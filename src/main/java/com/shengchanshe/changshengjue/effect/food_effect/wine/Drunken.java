package com.shengchanshe.changshengjue.effect.food_effect.wine;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class Drunken extends MobEffect {
    public Drunken() {
        super(MobEffectCategory.BENEFICIAL, 0xbcdcaf);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, -1, 0, false, false), entity);
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, -1, 0, false, false), entity);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity pLivingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.removeAttributeModifiers(pLivingEntity, pAttributeMap, pAmplifier);
        if (pLivingEntity.hasEffect(MobEffects.CONFUSION) || pLivingEntity.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
            pLivingEntity.removeEffect(MobEffects.CONFUSION);
            pLivingEntity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // 每 tick 检查冲突
    }
}
