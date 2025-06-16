package com.shengchanshe.changshengjue.mixin;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.blacksmith.BlacksmithMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.innkeeper.InnkeeperMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundMerchantOffersPacket;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.trading.MerchantOffers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {
    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "handleMerchantOffers", at = @At(value = "TAIL"))
    public void handleWuXiaMerchantOffers(ClientboundMerchantOffersPacket packet, CallbackInfo ci) {
        AbstractContainerMenu menu = this.minecraft.player.containerMenu;
        if (packet.getContainerId() == menu.containerId && menu instanceof InnkeeperMenu innkeeperMenu) {
            innkeeperMenu.setOffers(new MerchantOffers(packet.getOffers().createTag()));
            innkeeperMenu.setXp(packet.getVillagerXp());
            innkeeperMenu.setMerchantLevel(packet.getVillagerLevel());
            innkeeperMenu.setShowProgressBar(packet.showProgress());
            innkeeperMenu.setCanRestock(packet.canRestock());
		} else if (packet.getContainerId() == menu.containerId && menu instanceof BlacksmithMenu blacksmithMenu) {
            blacksmithMenu.setOffers(new MerchantOffers(packet.getOffers().createTag()));
            blacksmithMenu.setXp(packet.getVillagerXp());
            blacksmithMenu.setMerchantLevel(packet.getVillagerLevel());
            blacksmithMenu.setShowProgressBar(packet.showProgress());
            blacksmithMenu.setCanRestock(packet.canRestock());
        }else if (packet.getContainerId() == menu.containerId && menu instanceof KilnWorkerMenu kilnWorkerMenu) {
            kilnWorkerMenu.setOffers(new MerchantOffers(packet.getOffers().createTag()));
            kilnWorkerMenu.setXp(packet.getVillagerXp());
            kilnWorkerMenu.setMerchantLevel(packet.getVillagerLevel());
            kilnWorkerMenu.setShowProgressBar(packet.showProgress());
            kilnWorkerMenu.setCanRestock(packet.canRestock());
        }else if (packet.getContainerId() == menu.containerId && menu instanceof GangleaderTradingMenu gangleaderTradingMenu) {
            gangleaderTradingMenu.setOffers(new MerchantOffers(packet.getOffers().createTag()));
            gangleaderTradingMenu.setXp(packet.getVillagerXp());
            gangleaderTradingMenu.setMerchantLevel(packet.getVillagerLevel());
            gangleaderTradingMenu.setShowProgressBar(packet.showProgress());
            gangleaderTradingMenu.setCanRestock(packet.canRestock());
        }
    }
}
