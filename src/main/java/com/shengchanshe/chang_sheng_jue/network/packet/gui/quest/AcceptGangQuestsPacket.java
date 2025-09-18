package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.UUID;
import java.util.function.Supplier;

public record AcceptGangQuestsPacket(UUID questId) {
    public static void encode(AcceptGangQuestsPacket packet, FriendlyByteBuf buf) {
        buf.writeUUID(packet.questId());
    }

    public static AcceptGangQuestsPacket decode(FriendlyByteBuf buf) {
        return new AcceptGangQuestsPacket(buf.readUUID());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof GangQuestsMenu menu) {
                if (menu.getTrader() instanceof AbstractGangLeader abstractGangLeader) {
                    GangQuestHandler.handleQuestAccept(player, abstractGangLeader, questId);
                    CSJAdvanceInit.ACCESS_GUILD_TASK.trigger(player);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
