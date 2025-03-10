package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public interface KungFuCapability {
    void applyAttackEffect(LivingEntity livingEntity, Entity target);
    // 其他武功相关的方法...
    void saveNBTData(CompoundTag compound);
    void loadNBTData(CompoundTag compound);
    String getID();
}

