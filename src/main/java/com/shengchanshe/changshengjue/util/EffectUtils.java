package com.shengchanshe.changshengjue.util;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;

public class EffectUtils {
    public static void handleEffectConflict(LivingEntity entity, MobEffect newEffect, MobEffect... conflictingEffects) {
        for (MobEffect effect : conflictingEffects) {
            if (entity.hasEffect(effect)) {
                entity.removeEffect(effect);
            }
        }
    }

}