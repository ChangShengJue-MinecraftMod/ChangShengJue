package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record RefreshPlayerQuestScreenPacket() {
    // 实现encode/decode方法
    public static void encode(RefreshPlayerQuestScreenPacket packet, FriendlyByteBuf buf) {
    }

    public static RefreshPlayerQuestScreenPacket decode(FriendlyByteBuf buf) {
        return new RefreshPlayerQuestScreenPacket();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (Minecraft.getInstance().screen instanceof PlayerQuestScreen screen) {
                screen.getMenu().getCurrentQuest(screen.getMenu().getCurrentPage()).ifPresent(quest -> {
                    screen.refreshUI();
                });
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
