package com.shengchanshe.chang_sheng_jue.item.foods;

import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Wine extends BlockItem {

    public Wine(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            if (pEntityLiving.hasEffect(ChangShengJueEffects.FEN_JIU.get()) || pEntityLiving.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) || pEntityLiving.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                if (pStack.getItem().asItem() == ChangShengJueItems.SHI_LI_XIANG.get() || pStack.getItem().asItem() == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get() || pStack.getItem().asItem() == ChangShengJueItems.FEN_JIU.get()){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.DRUNKEN.get(),1600),pEntityLiving);
                    MobEffect mobEffect = ChangShengJueEffects.DRUNKEN.get();
                    mobEffect.applyInstantenousEffect( null, null, pEntityLiving, 1, 0.0);
                }
            }
            if (pStack.getItem().asItem() == ChangShengJueItems.FEN_JIU.get()){
                if (!pEntityLiving.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.FEN_JIU.get(), 1200), pEntityLiving);
                    pEntityLiving.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                    pEntityLiving.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                }
            }else if (pStack.getItem().asItem() == ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get()){
                if (!pEntityLiving.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), 1200), pEntityLiving);
                    pEntityLiving.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                    pEntityLiving.removeEffect(ChangShengJueEffects.SHI_LI_XIANG.get());
                }
            }else if (pStack.getItem().asItem() == ChangShengJueItems.SHI_LI_XIANG.get()){
                if (!pEntityLiving.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.SHI_LI_XIANG.get(), 1200), pEntityLiving);
                    pEntityLiving.removeEffect(ChangShengJueEffects.FEN_JIU.get());
                    pEntityLiving.removeEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                }
            }
        }
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? itemstack : new ItemStack(ChangShengJueItems.EMPTY_FEN_JIU.get());
    }


    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
