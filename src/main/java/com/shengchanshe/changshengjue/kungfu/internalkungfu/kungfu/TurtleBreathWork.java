package com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.Objects;

public class TurtleBreathWork implements InternalKungFuCapability {
    private static final int INTERNAL_KUNGFU_COOLDOWN_TIME = 45 * 20; // 冷却时间，单位为tick（1秒=20tick）
    private int internalKungFuCooldown; // 当前冷却时间
    private String internalKungFuID = "TurtleBreathWork";

    public TurtleBreathWork() {
        this.internalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getInternalKungFuID() {
        return internalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity) {
        Objects.requireNonNull(livingEntity.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(livingEntity.getMaxHealth() + 25.0F);
        livingEntity.setHealth(livingEntity.getMaxHealth() + 25.0F);
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

}
