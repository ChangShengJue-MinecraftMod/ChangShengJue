package com.shengchanshe.chang_sheng_jue.martial_arts;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public interface IInteranlKungFu extends IKungFu {
    void onEntityTick(LivingEntity player);
    void onEntityHurt(LivingDamageEvent event);
    void onInteranKungFu(Level pLevel, LivingEntity pEntity);
    void onAttackHurt(LivingAttackEvent event);
}
