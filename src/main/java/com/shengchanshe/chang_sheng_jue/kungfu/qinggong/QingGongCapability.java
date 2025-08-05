package com.shengchanshe.chang_sheng_jue.kungfu.qinggong;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public interface QingGongCapability {
    RandomSource random = RandomSource.create();
    String getQingGongID();
    void applyAttackEffect(LivingEntity livingEntity, Entity target,int cooldown);
    // 其他武功相关的方法...
    void saveNBTData(CompoundTag compound);
    void loadNBTData(CompoundTag compound);
    boolean isExternalKungFuCooldownOver(); // 冷却
    void updateExternalKungFuCooldown();
}