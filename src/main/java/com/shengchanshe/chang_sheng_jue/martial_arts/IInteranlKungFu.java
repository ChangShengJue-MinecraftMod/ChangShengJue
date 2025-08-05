package com.shengchanshe.chang_sheng_jue.martial_arts;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public interface IInteranlKungFu extends IKungFu {
    void onEntityTick(LivingEntity player);
    void onEntityHurt(LivingEntity livingEntity, DamageSource source, float amount);
    void onInteranKungFu(Level pLevel, LivingEntity pEntity);
}
