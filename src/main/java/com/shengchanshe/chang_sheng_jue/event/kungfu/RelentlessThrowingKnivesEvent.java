package com.shengchanshe.chang_sheng_jue.event.kungfu;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.FlyingDaggerPouch;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class RelentlessThrowingKnivesEvent {
    // 自动拾取飞刀
    public static void onItemPickup(EntityItemPickupEvent event) {
        ItemStack pickedUp = event.getItem().getItem();
        Player player = event.getEntity();

        if(pickedUp.getItem() == ChangShengJueItems.THROWING_KNIVES.get()) {
            // 检查所有可能存放的位置
            for(InteractionHand hand : InteractionHand.values()) {
                if(tryStoreToPouch(player, player.getItemInHand(hand), pickedUp)) {
                    event.setCanceled(true);
                    return;
                }
            }

            for(int i = 0; i < player.getInventory().getContainerSize(); i++) {
                if(tryStoreToPouch(player, player.getInventory().getItem(i), pickedUp)) {
                    event.setCanceled(true);
                    return;
                }
            }
        }
    }

    private static boolean tryStoreToPouch(Player player, ItemStack pouch, ItemStack dagger) {
        if(pouch.getItem() instanceof FlyingDaggerPouch) {
            if(FlyingDaggerPouch.tryAddDagger(pouch, dagger)) {
                dagger.shrink(1);
                player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, 1.0F);
                return true;
            }
        }
        return false;
    }
}
