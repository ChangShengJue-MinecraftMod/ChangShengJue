package com.shengchanshe.changshengjue.item.combat.knife;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class knife extends SwordItem {
    public knife(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onKnifeAttack(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof LivingEntity directEntity){
                if (directEntity != null && directEntity.getMainHandItem().getItem() == this){
                    float probability = directEntity.getRandom().nextFloat();
                    if (probability < 0.15F){
                        float amount = event.getAmount();
                        event.setAmount((float) (amount * 1.15));
                    }
                }
            }
        }
    }
}
