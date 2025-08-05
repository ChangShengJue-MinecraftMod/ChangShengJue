package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.ClientQuestDataCache;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public class SyncQuestDataPacket {
    private final UUID playerId;
    private final CompoundTag questData;

    public SyncQuestDataPacket(UUID playerId, CompoundTag questData) {
        this.playerId = playerId;
        this.questData = questData;
    }

    public static void encode(SyncQuestDataPacket msg, FriendlyByteBuf buf) {
        buf.writeUUID(msg.playerId);
        buf.writeNbt(msg.questData);
    }

    public static SyncQuestDataPacket decode(FriendlyByteBuf buf) {
        return new SyncQuestDataPacket(buf.readUUID(), buf.readNbt());
    }

    public static void handle(SyncQuestDataPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ClientQuestDataCache.get().updateData(msg.playerId(), msg.questData());
        });
        ctx.get().setPacketHandled(true);
    }

    public UUID playerId() { return playerId; }
    public CompoundTag questData() { return questData; }
//    private final List<Quest> quests;
//    private final Set<UUID> completedQuests;
//    private final Map<UUID, Integer> completionCounts;
//
//    public SyncQuestsPacket(List<Quest> quests, Set<UUID> completedQuests, Map<UUID, Integer> completionCounts) {
//        this.quests = quests;
//        this.completedQuests = completedQuests;
//        this.completionCounts = completionCounts;
//    }
//
//    public SyncQuestsPacket(FriendlyByteBuf buf) {
//        this(
//            QuestManager.getInstance().decodeQuests(buf), // 静态方法避免实例依赖
//            buf.readCollection(HashSet::new, FriendlyByteBuf::readUUID),
//            buf.readMap(FriendlyByteBuf::readUUID, FriendlyByteBuf::readInt)
//        );
//    }
//
//    public void encode(FriendlyByteBuf buf) {
//        QuestManager.getInstance().encodeQuests(buf, this.quests);
//        buf.writeCollection(this.completedQuests, FriendlyByteBuf::writeUUID);
//        buf.writeMap(this.completionCounts, FriendlyByteBuf::writeUUID, FriendlyByteBuf::writeInt);
//    }
//
//    public void handle(Supplier<NetworkEvent.Context> ctx) {
//        ctx.get().enqueueWork(() -> {
//            // 客户端更新本地数据
//            // 纯客户端才更新缓存
//            if (ctx.get().getDirection().getReceptionSide().isClient()) {
//                ClientQuestDataCache.update(
//                    this.quests,
//                    this.completedQuests,
//                    this.completionCounts
//                );
//            }
//
//        });
//        ctx.get().setPacketHandled(true);
//    }
}
