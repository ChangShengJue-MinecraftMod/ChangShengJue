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
public record SubmitPlayerQuestsPacket(UUID questId, int page) {
    public static void encode(SubmitPlayerQuestsPacket packet, FriendlyByteBuf buf) {
        buf.writeUUID(packet.questId());
        buf.writeInt(packet.page());
    }

    public static SubmitPlayerQuestsPacket decode(FriendlyByteBuf buf) {
        return new SubmitPlayerQuestsPacket(buf.readUUID(), buf.readInt());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            // 直接从玩家能力获取任务
            player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                    .ifPresent(cap -> {
                        Optional<Quest> quest = cap.getQuests(player.getUUID()).stream()
                                .filter(q -> q != null && questId.equals(q.getQuestId()) && player.getUUID().equals(q.getAcceptedBy()))
                                .findFirst();

                        if (quest.isPresent() && player.containerMenu instanceof PlayerQuestMenu menu) {
                            // 使用新的任务处理器
                            PlayerQuestHandler.handleSubmitPlayerQuest(player, quest.get(), menu);
                        }
                    });
        });
        ctx.get().setPacketHandled(true);
    }
}