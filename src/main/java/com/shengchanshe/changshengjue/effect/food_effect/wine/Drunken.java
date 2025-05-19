package com.shengchanshe.changshengjue.effect.food_effect.wine;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

import java.util.Iterator;

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
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        super.removeAttributeModifiers(entity, attributes, amplifier);

        if (!entity.level().isClientSide) {
            Iterator<MobEffectInstance> iterator = entity.getActiveEffects().iterator();
            while (iterator.hasNext()) {
                MobEffectInstance effect = iterator.next();
                if (effect.getEffect() == MobEffects.CONFUSION ||
                        effect.getEffect() == MobEffects.MOVEMENT_SLOWDOWN) {
                    iterator.remove();
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
