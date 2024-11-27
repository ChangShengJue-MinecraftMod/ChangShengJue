package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Clubbed extends SwordItem {
    public Clubbed(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onKnifeAttack(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            LivingEntity entity = event.getEntity();
            if (event.getSource().getDirectEntity() instanceof LivingEntity directEntity){
                if (directEntity != null && directEntity.getMainHandItem().getItem() == this){
                    float probability = directEntity.getRandom().nextFloat();
                    if (probability < 0.15F) {
                        (entity).addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 10, 1, false, false), directEntity);
                    }
                }
            }
        }
    }
}
