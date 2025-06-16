package com.shengchanshe.changshengjue.mixin;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.blacksmith.BlacksmithMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.innkeeper.InnkeeperMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import net.minecraft.network.protocol.game.ServerboundSelectTradePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
    @Shadow
    public ServerPlayer player;

    @Inject(method = "handleSelectTrade", at = @At(value = "TAIL"))
    public void handleSelectWuXiaTrade(ServerboundSelectTradePacket packet, CallbackInfo ci) {
        int item = packet.getItem();
        AbstractContainerMenu menu = this.player.containerMenu;
        if (menu instanceof InnkeeperMenu innkeeperMenu) {
            if (!innkeeperMenu.stillValid(this.player)) {
                return;
            }
            innkeeperMenu.setSelectionHint(item);
            innkeeperMenu.tryMoveItems(item);
		}else if (menu instanceof BlacksmithMenu blacksmithMenu) {
            if (!blacksmithMenu.stillValid(this.player)) {
                return;
            }
            blacksmithMenu.setSelectionHint(item);
            blacksmithMenu.tryMoveItems(item);
        }else if (menu instanceof KilnWorkerMenu kilnWorkerMenu) {
            if (!kilnWorkerMenu.stillValid(this.player)) {
                return;
            }
            kilnWorkerMenu.setSelectionHint(item);
            kilnWorkerMenu.tryMoveItems(item);
        }else if (menu instanceof GangleaderTradingMenu gangleaderTradingMenu) {
            if (!gangleaderTradingMenu.stillValid(this.player)) {
                return;
            }
            gangleaderTradingMenu.setSelectionHint(item);
            gangleaderTradingMenu.tryMoveItems(item);
        }
	}
}
