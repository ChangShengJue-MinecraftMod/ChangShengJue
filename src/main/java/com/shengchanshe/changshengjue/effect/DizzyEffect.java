package com.shengchanshe.changshengjue.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;

public class DizzyEffect extends MobEffect {
    protected DizzyEffect() {
        super(MobEffectCategory.HARMFUL, 00000000);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "ED1ED20F-766A-286D-BE69-C61A93AFC5A8",-1.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "E322D6CB-4C6F-9E12-FB4F-74D1DF6B86BA",-1.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(ForgeMod.ENTITY_GRAVITY.get(), "6E0B7E9C-1DEF-E820-92C9-C15E84F30FB8",10000.0, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if (this == ChangShengJueEffects.DIZZY_EFFECT.get()) {
            if (!pLivingEntity.level().isClientSide && !pLivingEntity.isDeadOrDying()){
                ((ServerLevel)pLivingEntity.level()).sendParticles(ParticleTypes.DAMAGE_INDICATOR, pLivingEntity.getX(), pLivingEntity.getEyeY()+0.5, pLivingEntity.getZ(), 1, 0.1D, 0.0D, 0.1D, 0.2D);
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
