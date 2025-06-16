package com.shengchanshe.changshengjue.effect.martial_arts;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;

import java.util.Objects;

public class TurtleBreathEffect extends MobEffect {
    private int turtleBreath;

    public TurtleBreathEffect() {
        // 第二个参数是颜色
        super(MobEffectCategory.BENEFICIAL, ChatFormatting.AQUA.getColor());
    }

    @Override
    public void addAttributeModifiers(LivingEntity livingEntity, AttributeMap pAttributeMap, int pAmplifier) {
        super.addAttributeModifiers(livingEntity, pAttributeMap, pAmplifier);
        var selector = TargetingConditions.forCombat().ignoreLineOfSight().selector(e -> (((Mob) e).getTarget() == livingEntity));
        livingEntity.level().getNearbyEntities(Mob.class, selector, livingEntity, livingEntity.getBoundingBox().inflate(20D))
                .forEach(entityTargetingCaster -> {
                    entityTargetingCaster.setTarget(null);
                    entityTargetingCaster.setLastHurtMob(null);
                    entityTargetingCaster.setLastHurtByMob(null);
                    entityTargetingCaster.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
                    entityTargetingCaster.targetSelector.getAvailableGoals().forEach(WrappedGoal::stop);
                });
        this.turtleBreath = livingEntity.getLastHurtMobTimestamp();
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (Objects.requireNonNull(pLivingEntity.getEffect(this)).getDuration() % 40 == 0){
            pLivingEntity.playSound(ChangShengJueSound.TURTLE_BREATH_WORK_SOUND.get(), 1.0F, 1.0F);
        }
        var selector = TargetingConditions.forCombat().ignoreLineOfSight().selector(e -> (((Mob) e).getTarget() == pLivingEntity));
        pLivingEntity.level().getNearbyEntities(Mob.class, selector, pLivingEntity, pLivingEntity.getBoundingBox().inflate(20D))
                .forEach(entityTargetingCaster -> {
                    entityTargetingCaster.setTarget(null);
                    entityTargetingCaster.setLastHurtMob(null);
                    entityTargetingCaster.setLastHurtByMob(null);
                    entityTargetingCaster.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
                    entityTargetingCaster.targetSelector.getAvailableGoals().forEach(WrappedGoal::stop);
                });

        if (!pLivingEntity.level().isClientSide && turtleBreath != pLivingEntity.getLastHurtMobTimestamp()){
            pLivingEntity.removeEffect(this);
        }
    }

}