package com.shengchanshe.chang_sheng_jue.effect.martial_arts;

import com.shengchanshe.chang_sheng_jue.damage.CSJDamageTypes;
import net.minecraft.world.damagesource.DamageSource;
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
        // 获取施加该效果的玩家（通过LastHurtByMob）
        LivingEntity attacker = pLivingEntity.getLastHurtByMob();

        // 创建带攻击者引用的伤害来源
        DamageSource damageSource = pLivingEntity.level().damageSources().source(
                CSJDamageTypes.TRAUMA,
                attacker != null ? attacker : pLivingEntity // 若无攻击者则归因于自身
        );
        pLivingEntity.hurt(damageSource, pLivingEntity.getMaxHealth() * damagePercent);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // 每秒触发一次（20 ticks = 1秒）
        return duration % 20 == 0;
    }
}
