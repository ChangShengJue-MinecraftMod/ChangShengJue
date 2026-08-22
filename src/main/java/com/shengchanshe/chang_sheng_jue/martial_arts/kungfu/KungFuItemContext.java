package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public final class KungFuItemContext {
    private KungFuItemContext() {
    }

    public static ItemStack getCastingItem(LivingEntity entity) {
        return entity.isUsingItem() ? entity.getUseItem() : entity.getMainHandItem();
    }

    public static void hurtCastingItem(LivingEntity entity, int amount) {
        boolean isUsingItem = entity.isUsingItem();
        InteractionHand hand = isUsingItem ? entity.getUsedItemHand() : InteractionHand.MAIN_HAND;
        ItemStack itemStack = isUsingItem ? entity.getUseItem() : entity.getMainHandItem();
        itemStack.hurtAndBreak(amount, entity, livingEntity -> livingEntity.broadcastBreakEvent(hand));
    }
}
