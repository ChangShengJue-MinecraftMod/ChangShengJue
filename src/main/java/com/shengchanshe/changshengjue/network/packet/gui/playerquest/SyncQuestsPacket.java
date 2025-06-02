package com.shengchanshe.changshengjue.network.packet.gui.playerquest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.ClientQuestDataCache;
import com.shengchanshe.changshengjue.quest.Quest;
import com.shengchanshe.changshengjue.quest.QuestManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.*;
import java.util.function.Supplier;

public class SyncQuestsPacket {
    private final List<Quest> quests;
    private final Set<UUID> completedQuests;
    private final Map<UUID, Integer> completionCounts;

    public SyncQuestsPacket(List<Quest> quests, Set<UUID> completedQuests, Map<UUID, Integer> completionCounts) {
        this.quests = quests;
        this.completedQuests = completedQuests;
        this.completionCounts = completionCounts;
    }

    public SyncQuestsPacket(FriendlyByteBuf buf) {
        this(
                QuestManager.getInstance().decodeQuests(buf), // 静态方法避免实例依赖
                buf.readCollection(HashSet::new, FriendlyByteBuf::readUUID),
                buf.readMap(FriendlyByteBuf::readUUID, FriendlyByteBuf::readInt)
        );
    }

    public void encode(FriendlyByteBuf buf) {
        QuestManager.getInstance().encodeQuests(buf, this.quests);
        buf.writeCollection(this.completedQuests, FriendlyByteBuf::writeUUID);
        buf.writeMap(this.completionCounts, FriendlyByteBuf::writeUUID, FriendlyByteBuf::writeInt);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // 客户端更新本地数据
            // 纯客户端才更新缓存
            if (ctx.get().getDirection().getReceptionSide().isClient()) {
                ClientQuestDataCache.update(
                    this.quests,
                    this.completedQuests,
                    this.completionCounts
                );
            }

        });
        ctx.get().setPacketHandled(true);
    }
}
