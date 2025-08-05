package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

// 新增文件：任务提交数据包
public record AbandonPlayerQuestPacket(UUID questId,int page) {
    public static void encode(AbandonPlayerQuestPacket packet, FriendlyByteBuf buf) {
        buf.writeUUID(packet.questId());
        buf.writeInt(packet.page());
    }

    public static AbandonPlayerQuestPacket decode(FriendlyByteBuf buf) {
        return new AbandonPlayerQuestPacket(buf.readUUID(), buf.readInt());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            // 直接从玩家能力获取任务
            if (player != null) {
                player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                        .ifPresent(cap -> {
                            Optional<Quest> quest = cap.getQuests(player.getUUID()).stream()
                                    .filter(q -> q != null && questId.equals(q.getQuestId()))
                                    .findFirst();

                            if (quest.isPresent() && player.containerMenu instanceof PlayerQuestMenu) {
                                // 使用新的任务处理器
                                PlayerQuestHandler.handleAbandonPlayerQuest(player, quest.get());
                            }
                        });
            }

        });
        ctx.get().setPacketHandled(true);
    }
}
