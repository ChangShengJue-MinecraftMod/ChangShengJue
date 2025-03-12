package com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu;

import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class QianKunDaNuoYi implements InternalKungFuCapability {
    private static final int COOLDOWN_TIME = 100; // 冷却时间，单位为tick（1秒=20tick）
    private int internalKungFuCooldown; // 当前冷却时间

    private String internalKungFuID = "QianKunDaNuoYi";

    public QianKunDaNuoYi() {
        this.internalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getInternalKungFuID() {
        return internalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {

    }

    public void applyHurtEffect(LivingEntity pEntity, DamageSource pSource, float pAmount) {
        if (internalKungFuCooldown > 0) {
            // 如果还在冷却中，直接返回
            return;
        }
        if (pSource.getEntity() != null) {
            float health = pEntity.getHealth();
            float v = 0.35F + health * 0.02F;
            if (pEntity.getRandom().nextFloat() < v) {
                if (pSource.getEntity() instanceof LivingEntity livingEntity) {
                    livingEntity.hurt(pSource, pAmount * 1.35F);
                }
            }
        }
        internalKungFuCooldown = COOLDOWN_TIME; // 设置冷却时间
    }

    @Override
    public void saveNBTData(CompoundTag compound) {
        compound.putString("InternalKungFuID", internalKungFuID);
        compound.putInt("InternalKungFuCooldown", internalKungFuCooldown);
    }

    @Override
    public void loadNBTData(CompoundTag compound) {
        internalKungFuID = compound.getString("InternalKungFuID");
        internalKungFuCooldown = compound.getInt("InternalKungFuCooldown");
    }
    @Override
    public boolean isInternalKungFuCooldownOver() {
        return internalKungFuCooldown <= 0;
    }

    @Override
    public void updateInternalKungFuCooldown() {
        if (internalKungFuCooldown > 0) {
            internalKungFuCooldown--;
        }
    }

//    @Override
//    public String getID() {
//        return "QianKunDaNuoYi";
//    }

}
