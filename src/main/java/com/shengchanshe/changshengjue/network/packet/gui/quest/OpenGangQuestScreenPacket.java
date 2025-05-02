package com.shengchanshe.changshengjue.network.packet.gui.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.other.GangLeader;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public record OpenGangQuestScreenPacket() {
    public static void encode(OpenGangQuestScreenPacket packet, FriendlyByteBuf buf) {
    }

    public static OpenGangQuestScreenPacket decode(FriendlyByteBuf buf) {
        return new OpenGangQuestScreenPacket();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player.containerMenu instanceof GangleaderTradingMenu menu) {
                if (menu.getTrader() instanceof AbstractGangLeader abstractGangLeader) {
                    NetworkHooks.openScreen(
                                player,
                                new SimpleMenuProvider(
                                        (windowId, inv, p) -> new GangQuestsMenu(windowId, inv,abstractGangLeader,abstractGangLeader.getQuest()),
                                        Component.translatable("quest."+ ChangShengJue.MOD_ID +".button")
                                ),
                            buf -> {
                                buf.writeNbt(abstractGangLeader.getQuest().toNbt()); // 传入任务NBT数据,在Menu客户端方法中使用
                            }
                        );
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
