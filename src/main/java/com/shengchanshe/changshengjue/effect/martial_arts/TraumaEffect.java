package com.shengchanshe.changshengjue.effect.martial_arts;

import com.shengchanshe.changshengjue.damage.CSJDamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class TraumaEffect extends MobEffect {

    public TraumaEffect() {
        super(MobEffectCategory.HARMFUL, 0xFF0000);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "3ED56735-8D0D-491A-90BF-929417C3B975",-0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ATTACK_DAMAGE, "470CCF33-5CBE-496D-B320-432546683562",-0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        // 每秒减少最大生命值的 (1% * (等级+1))
        float damagePercent = 0.01f * (pAmplifier + 1);
        pLivingEntity.hurt(pLivingEntity.level().damageSources().source(CSJDamageTypes.TRAUMA), pLivingEntity.getMaxHealth() * damagePercent);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // 每秒触发一次（20 ticks = 1秒）
        return duration % 20 == 0;
    }
}
