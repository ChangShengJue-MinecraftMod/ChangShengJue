package com.shengchanshe.changshengjue.network.packet.gui.quest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

// 新增文件：任务提交数据包
public record RefreshGangQuestPacket() {
    public static void encode(RefreshGangQuestPacket packet, FriendlyByteBuf buf) {
    }

    public static RefreshGangQuestPacket decode(FriendlyByteBuf buf) {
        return new RefreshGangQuestPacket();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof GangQuestsMenu menu) {
                if (menu.getTrader() instanceof AbstractGangLeader abstractGangLeader) {
                    GangQuestHandler.handleRefreshQuest(player, abstractGangLeader);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
