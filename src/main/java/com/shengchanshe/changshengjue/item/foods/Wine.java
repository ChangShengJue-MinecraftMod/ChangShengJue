package com.shengchanshe.changshengjue.item.foods;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class Wine extends Item {
    public Wine(Properties pProperties) {
        super(pProperties);
    }
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            if (pStack.getItem().asItem() == ChangShengJueItems.FEN_JIU.get()){
                if (!pEntityLiving.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.FEN_JIU.get(), 360), pEntityLiving);
                    pEntityLiving.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                    pEntityLiving.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                }else if (pEntityLiving.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
                    pEntityLiving.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                    pEntityLiving.addEffect(new MobEffectInstance( ChangShengJueEffects.DRUNKEN.get(),360),pEntityLiving);
                }
            }else if (pStack.getItem().asItem() == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()){
                if (!pEntityLiving.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), 360), pEntityLiving);
                    pEntityLiving.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                    pEntityLiving.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                }else if (pEntityLiving.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
                    pEntityLiving.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                    pEntityLiving.addEffect(new MobEffectInstance( ChangShengJueEffects.DRUNKEN.get(),360),pEntityLiving);
                }
            }else if (pStack.getItem().asItem() == ChangShengJueItems.SHI_LI_XIANG.get()){
                if (!pEntityLiving.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.SHI_LI_XIANG.get(), 360), pEntityLiving);
                    pEntityLiving.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                    pEntityLiving.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                }else if (pEntityLiving.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                    pEntityLiving.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                    pEntityLiving.addEffect(new MobEffectInstance( ChangShengJueEffects.DRUNKEN.get(),360),pEntityLiving);
                }
            }
        }
        return super.finishUsingItem(pStack,pLevel,pEntityLiving);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
