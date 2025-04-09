package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
                    //人是铁饭是钢
                    CSJAdvanceInit.hasmifan.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.SILVER_BULLIONS.get()) {
                    //银华熠熠
                    CSJAdvanceInit.hassilverbullions.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.GOLD_BULLIONS.get()) {
                    CSJAdvanceInit.hasgoldbullions.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.BA_BAO_ZHOU.get()){
                    CSJAdvanceInit.hasbabaozhou.trigger(serverPlayer);
                }else if(item == ChangShengJueItems.GUI_HUA_TANG_OU.get()){
                    CSJAdvanceInit.hasguihuatangou.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.BRONZE_SWORD.get()) {
                    CSJAdvanceInit.hasbronzesword.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.LICHEE.get()) {
                    CSJAdvanceInit.haslichee.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.BILUOCHUN_TEAS.get()
                        || item == ChangShengJueItems.LONG_JING_TEAS.get()) {
                    CSJAdvanceInit.hastea.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.SHI_LI_XIANG.get()
                        || item == ChangShengJueItems.FEN_JIU.get()
                        || item == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()) {
                    CSJAdvanceInit.haswine.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.TOMATO_EGG.get()) {
                    CSJAdvanceInit.hastomatoegg.trigger(serverPlayer);
                }else if (item == ChangShengJueItems.TU_LONG_DAO.get()
                        || item == ChangShengJueItems.YI_TINA_JIAN.get()
                        || item == ChangShengJueItems.BA_WANG_QIANG.get()
                        || item == ChangShengJueItems.BEAT_DOG_STICK.get()) {
                    CSJAdvanceInit.hassword.trigger(serverPlayer);
                }
            }
        }
    }
}
