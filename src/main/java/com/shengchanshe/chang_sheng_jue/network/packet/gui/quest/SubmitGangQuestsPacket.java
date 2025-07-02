package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

// 新增文件：任务提交数据包
public record SubmitGangQuestsPacket() {
    public static void encode(SubmitGangQuestsPacket packet, FriendlyByteBuf buf) {
    }

    public static SubmitGangQuestsPacket decode(FriendlyByteBuf buf) {
        return new SubmitGangQuestsPacket();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof GangQuestsMenu menu) {
                if (menu.getTrader() instanceof AbstractGangLeader abstractGangLeader) {
                    GangQuestHandler.handleQuestSubmit(player, abstractGangLeader);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
