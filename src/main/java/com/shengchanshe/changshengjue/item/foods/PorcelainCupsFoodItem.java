package com.shengchanshe.changshengjue.item.foods;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public class PorcelainCupsFoodItem extends BlockItem {

    public PorcelainCupsFoodItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            if (pStack.getItem().asItem() == ChangShengJueItems.LONG_JING_TEAS.get() || pStack.getItem().asItem() == ChangShengJueItems.BILUOCHUN_TEAS.get()){
                if (pEntityLiving.hasEffect(ChangShengJueEffects.DRUNKEN.get())) {
                    // 获取当前的 DRUNKEN 效果
                    MobEffectInstance effect = pEntityLiving.getEffect(ChangShengJueEffects.DRUNKEN.get());

                    // 计算新的持续时间
                    int newDuration = Math.max(0, Objects.requireNonNull(effect).getDuration() - 600); // 减少 30 秒
                    pEntityLiving.removeEffect(ChangShengJueEffects.DRUNKEN.get());
                    // 将新的状态效果添加到实体上，这将替换旧的效果
                    pEntityLiving.addEffect(new MobEffectInstance(ChangShengJueEffects.DRUNKEN.get(), newDuration), pEntityLiving);

                    MobEffect mobEffect = ChangShengJueEffects.DRUNKEN.get();
                    mobEffect.applyInstantenousEffect( null, null, pEntityLiving, 1, 0.0);
                }
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
