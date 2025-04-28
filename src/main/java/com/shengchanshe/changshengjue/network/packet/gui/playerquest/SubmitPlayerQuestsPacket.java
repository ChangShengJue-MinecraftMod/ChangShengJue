package com.shengchanshe.changshengjue.network.packet.gui.playerquest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

// 新增文件：任务提交数据包
public record SubmitPlayerQuestsPacket(int page) {
    public static void encode(SubmitPlayerQuestsPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.page());
    }

    public static SubmitPlayerQuestsPacket decode(FriendlyByteBuf buf) {
        return new SubmitPlayerQuestsPacket(buf.readInt());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof PlayerQuestMenu menu) {
                menu.getCurrentQuest(this.page).ifPresent(quest -> {
                    PlayerQuestHandler.handleSubmitPlayerQuest(player, quest, menu);
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
