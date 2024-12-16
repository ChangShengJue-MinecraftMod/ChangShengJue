package com.shengchanshe.changshengjue.effect.martial_arts;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class GoldenBellJarEffect extends MobEffect {
    public GoldenBellJarEffect() {
        // 第二个参数是颜色
        super(MobEffectCategory.BENEFICIAL, 00000000);
        this.addAttributeModifier(Attributes.ARMOR, "935B9346-FE1F-46E0-BFE7-D6919277D611",4.0, AttributeModifier.Operation.ADDITION);
    }

//    @Override
//    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
//        super.applyEffectTick(pLivingEntity, pAmplifier);
//        if (this == ChangShengJueEffects.BLEED_EFFECT.get()) {
//            pLivingEntity.hurt(pLivingEntity.damageSources().generic(), 1.0F);
//            if (!pLivingEntity.level().isClientSide && !pLivingEntity.isDeadOrDying()){
//            }
//        }
//    }
}
