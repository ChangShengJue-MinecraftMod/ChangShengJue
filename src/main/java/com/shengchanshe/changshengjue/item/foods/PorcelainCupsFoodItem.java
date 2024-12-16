package com.shengchanshe.changshengjue.item.foods;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.util.EffectUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class PorcelainCupsFoodItem extends Item {
    public PorcelainCupsFoodItem(Properties pProperties) {
        super(pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            if (pStack.getItem().asItem() == ChangShengJueItems.LONG_JING_TEAS.get()){
                EffectUtils.handleEffectConflict(pEntityLiving,ChangShengJueEffects.LONG_JING_TEAS.get(), ChangShengJueEffects.BILUOCHUN_TEAS.get());
            }else if (pStack.getItem().asItem() == ChangShengJueItems.BILUOCHUN_TEAS.get()){
                EffectUtils.handleEffectConflict(pEntityLiving,ChangShengJueEffects.BILUOCHUN_TEAS.get(), ChangShengJueEffects.LONG_JING_TEAS.get());
            }
        }
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? itemstack : new ItemStack(ChangShengJueItems.CI_BEI.get());
    }
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
