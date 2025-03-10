package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

public class QianKunDaNuoYi implements KungFuCapability {

    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {

    }
    public void applyHurtEffect(LivingEntity pEntity, DamageSource pSource, float pAmount) {
        Level level = pEntity.level();
        if (pSource.getEntity() != null) {
            float health = pEntity.getHealth();
            float v = 0.35F + health * 0.02F;
            if (pEntity.getRandom().nextFloat() < v) {
                if (pSource.getEntity() instanceof LivingEntity livingEntity) {
                    livingEntity.hurt(pSource, pAmount * 1.35F);
                }
            }
        }
    }

    @Override
    public void saveNBTData(CompoundTag compound) {
    }

    @Override
    public void loadNBTData(CompoundTag compound) {

    }

    @Override
    public String getID() {
        return "QianKunDaNuoYi";
    }

}
