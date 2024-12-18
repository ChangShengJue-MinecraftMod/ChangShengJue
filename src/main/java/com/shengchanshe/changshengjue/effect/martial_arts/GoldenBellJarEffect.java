package com.shengchanshe.changshengjue.effect.martial_arts;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.effect.EffectEntityPacket;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;

public class GoldenBellJarEffect extends MobEffect {
    public GoldenBellJarEffect() {
        // 第二个参数是颜色
        super(MobEffectCategory.BENEFICIAL, 0XFFD700);
        this.addAttributeModifier(Attributes.ARMOR, "935B9346-FE1F-46E0-BFE7-D6919277D611",4.0, AttributeModifier.Operation.ADDITION);
    }
//
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        super.applyEffectTick(pLivingEntity, pAmplifier);
        if (this == ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get() && pLivingEntity.level().isClientSide) {
//            if (pLivingEntity.getEffect(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get()).getDuration() % 5 == 0){
//                pLivingEntity.level().addParticle(ChangShengJueParticles.GOLDEN_BELL_JAR_PARTICLE.get(), pLivingEntity.getRandomX(1.0D), pLivingEntity.getRandomY(), pLivingEntity.getRandomZ(1.0D),
//                        0, 0, 0);
            // 粒子的初始位置
            double x = pLivingEntity.getX() + (Math.random() - 0.5);
            double y = pLivingEntity.getY() + 0.7 + (Math.random() - 0.5);
            double z = pLivingEntity.getZ() + (Math.random() - 0.5);

            pLivingEntity.level().addParticle(ChangShengJueParticles.GOLDEN_BELL_JAR_PARTICLE.get(), x, y, z, 0, 0, 0);
//            }
        }
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap map, int i) {
        if (!entity.level().isClientSide) {
            MobEffectInstance instance = entity.getEffect(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get());
            if (instance != null) {
                ChangShengJueMessages.sendMSGToAll(new EffectEntityPacket(entity.getId(), entity.getId(), 1, instance.getDuration()));
            }
        }
        super.addAttributeModifiers(entity, map, i);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
