package com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu;

import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

public class TheClassicsOfTendonChanging implements InternalKungFuCapability {
    private int internalKungFuCooldown; // 当前冷却时间
    private String internalKungFuID = "TheClassicsOfTendonChanging";

    public TheClassicsOfTendonChanging() {
        this.internalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getInternalKungFuID() {
        return internalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity) {
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
