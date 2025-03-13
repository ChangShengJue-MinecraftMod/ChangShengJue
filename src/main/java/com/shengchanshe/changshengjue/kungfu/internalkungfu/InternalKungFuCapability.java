package com.shengchanshe.changshengjue.kungfu.internalkungfu;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public interface InternalKungFuCapability {
    RandomSource random = RandomSource.create();
    String getInternalKungFuID();
    void applyAttackEffect(LivingEntity livingEntity, Entity target);
    // 其他武功相关的方法...
    void saveNBTData(CompoundTag compound);
    void loadNBTData(CompoundTag compound);
    boolean isInternalKungFuCooldownOver(); // 冷却
    void updateInternalKungFuCooldown();
}