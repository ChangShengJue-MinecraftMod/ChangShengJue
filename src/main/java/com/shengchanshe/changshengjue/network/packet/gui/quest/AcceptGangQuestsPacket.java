package com.shengchanshe.changshengjue.network.packet.gui.quest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

// 新增文件：任务提交数据包
public record AcceptGangQuestsPacket() {
    public static void encode(AcceptGangQuestsPacket packet, FriendlyByteBuf buf) {
    }

    public static AcceptGangQuestsPacket decode(FriendlyByteBuf buf) {
        return new AcceptGangQuestsPacket();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof GangQuestsMenu menu) {
                if (menu.getTrader() instanceof AbstractGangLeader abstractGangLeader) {
                    GangQuestHandler.handleQuestAccept(player, abstractGangLeader);
                    CSJAdvanceInit.ACCESS_GUILD_TASK.trigger(player);
                    //触发成就“帮会？”
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
