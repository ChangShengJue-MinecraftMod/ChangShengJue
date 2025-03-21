package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID)
public class AdvanceEvent {

    @SubscribeEvent
    public static void onPlayerInventoryChanged(PlayerEvent.PlayerLoggedInEvent event) {
        checkForStick(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerInventoryChanged(PlayerEvent.ItemPickupEvent event) {
        checkForStick(event.getEntity());
    }

    @SubscribeEvent
    public static void onPlayerInventoryChanged(PlayerEvent.ItemCraftedEvent event) {
        checkForStick(event.getEntity());
    }

    private static void checkForStick(net.minecraft.world.entity.player.Player player) {
        for (ItemStack itemStack : player.getInventory().items) {
            Item item = itemStack.getItem();
            if (player instanceof ServerPlayer serverPlayer) {
                if (item == ChangShengJueItems.MI_FAN.get()) {
                    CSJAdvanceInit.hasmifan.trigger(serverPlayer);
                }
                if (item == ChangShengJueItems.LICHEE.get()) {
                    CSJAdvanceInit.haslichee.trigger(serverPlayer);
                }
                if (item == ChangShengJueItems.BILUOCHUN_TEAS.get() || item == ChangShengJueItems.LONG_JING_TEAS.get()) {
                    CSJAdvanceInit.hastea.trigger(serverPlayer);
                }
                if (item == ChangShengJueItems.SHI_LI_XIANG.get() || item == ChangShengJueItems.FEN_JIU.get() || item == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()) {
                    CSJAdvanceInit.haswine.trigger(serverPlayer);
                }
                if (item == ChangShengJueItems.BRONZE_SWORD.get()) {
                    CSJAdvanceInit.hasbrozesword.trigger(serverPlayer);
                }
                if (item == ChangShengJueItems.TOMATO_EGG.get()) {
                    CSJAdvanceInit.hastomatoegg.trigger(serverPlayer);
                }
                if (item == ChangShengJueItems.TU_LONG_DAO.get() || item == ChangShengJueItems.YI_TINA_JIAN.get() || item == ChangShengJueItems.BA_WANG_QIANG.get() || item == ChangShengJueItems.BEAT_DOG_STICK.get()) {
                    CSJAdvanceInit.hassword.trigger(serverPlayer);
                }
            }
        }
    }
}
