package com.shengchanshe.changshengjue.effect.martial_arts;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.UUID;

public class InternalInjuryEffect extends MobEffect {
    private static final RandomSource RANDOM = RandomSource.create();

    public InternalInjuryEffect() {
        super(MobEffectCategory.HARMFUL, 0x660000);
        this.addAttributeModifier(Attributes.ARMOR, "BF3778BD-821A-4404-B8F8-0D83832B2555",-0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "B5A5E5D5-1C1A-4D2D-9F9F-3F3F3F3F3F3F",-0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        // 每秒5%概率眩晕（每级+5%概率）
        if (RANDOM.nextFloat() < (0.05f * (pAmplifier + 1))) {
            if (pLivingEntity.hasEffect(ChangShengJueEffects.DIZZY_EFFECT.get())){
                pLivingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 30, 0, true, true, true));
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        // 检查是否拥有内伤效果
        if (entity.hasEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get())) {
            MobEffectInstance effect = entity.getEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get());
            int level = 0;
            if (effect != null) {
                level = effect.getAmplifier() + 1;
            }

            // 增加伤害（5% × 等级）
            event.setAmount(event.getAmount() * (1 + 0.05f * level));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // 每秒触发一次（20 ticks = 1秒）
        return duration % 20 == 0;
    }
}
