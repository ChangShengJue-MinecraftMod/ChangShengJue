package com.shengchanshe.changshengjue.network.packet.gui.playerquest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.changshengjue.network.packet.gui.quest.GangQuestHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

// 新增文件：任务提交数据包
public record AbandonPlayerQuestPacket(int page) {
    public static void encode(AbandonPlayerQuestPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.page());
    }

    public static AbandonPlayerQuestPacket decode(FriendlyByteBuf buf) {
        return new AbandonPlayerQuestPacket(buf.readInt());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof PlayerQuestMenu menu) {
                menu.getCurrentQuest(this.page).ifPresent(quest -> {
                    PlayerQuestHandler.handleAbandonPlayerQuest(player, quest);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
