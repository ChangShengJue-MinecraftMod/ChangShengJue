package com.shengchanshe.chang_sheng_jue.effect.food_effect.wine;

import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Drunken extends InstantenousMobEffect {
    public Drunken() {
        super(MobEffectCategory.BENEFICIAL, 0xbcdcaf);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "ED1ED20F-766A-286D-BE69-C61A93AFC5A8",-0.15000000596046448, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        MobEffectInstance drunkenEffect = pLivingEntity.getEffect(this);
        if (drunkenEffect == null) return;
//        i++;
//        pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION,
//                drunkenEffect.getDuration(), i, false, true, true), pLivingEntity);

        MobEffectInstance effect = pLivingEntity.getEffect(MobEffects.CONFUSION);
        if (effect == null) {
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION,1600), pLivingEntity);
        }else {
            int newDuration = Math.max(0, Objects.requireNonNull(effect).getDuration() - 600); // 减少 30 秒
            pLivingEntity.removeEffect(MobEffects.CONFUSION);
            // 将新的状态效果添加到实体上，这将替换旧的效果
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, newDuration), pLivingEntity);
        }
    }
}
