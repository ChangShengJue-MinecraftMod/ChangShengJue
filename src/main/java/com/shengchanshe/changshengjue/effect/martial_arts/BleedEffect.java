package com.shengchanshe.changshengjue.effect.martial_arts;

import com.shengchanshe.changshengjue.damage.CSJDamageTypes;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import java.util.Optional;

public class BleedEffect extends MobEffect {
    public BleedEffect() {
        // 第二个参数是颜色
        super(MobEffectCategory.HARMFUL, 00000000);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if (this == ChangShengJueEffects.BLEED_EFFECT.get()) {
            // 获取施加该效果的玩家（通过LastHurtByMob）
            LivingEntity attacker = pLivingEntity.getLastHurtByMob();

            // 创建带攻击者引用的伤害来源
            DamageSource damageSource = pLivingEntity.level().damageSources().source(
                    CSJDamageTypes.BLEED, attacker != null ? attacker : pLivingEntity);
            pLivingEntity.hurt(damageSource, 1.0F);
            if (!pLivingEntity.level().isClientSide && !pLivingEntity.isDeadOrDying()){
                ((ServerLevel)pLivingEntity.level()).sendParticles(ParticleTypes.DAMAGE_INDICATOR, pLivingEntity.getX(), pLivingEntity.getY(0.5D), pLivingEntity.getZ(), 1, 0.1D, 0.0D, 0.1D, 0.2D);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        if (this == ChangShengJueEffects.BLEED_EFFECT.get()) {
            int i = 10 >> pAmplifier;
            if (i > 0) {
                return pDuration % i == 0;
            } else {
                return true;
            }
        }
        return super.isDurationEffectTick(pDuration, pAmplifier);
    }
}
