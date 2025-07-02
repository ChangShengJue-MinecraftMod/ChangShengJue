package com.shengchanshe.chang_sheng_jue.kungfu.qinggong.kungfu;

import com.shengchanshe.chang_sheng_jue.kungfu.qinggong.QingGongCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class TreadTheSnowWithoutTrace implements QingGongCapability {
    private String qingGongID = "TreadTheSnowWithoutTrace";
    private static final int QING_GONG_COOLDOWN_TIME = 5 * 20; // 冷却时间，单位为tick（1秒=20tick）
    private int qingGongCooldown; // 当前冷却时间

    public TreadTheSnowWithoutTrace() {
        this.qingGongCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getQingGongID() {
        return qingGongID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity,Entity target, int cooldown) {
    }

    @Override
    public void saveNBTData(CompoundTag compound) {
        compound.putString("ExternalKungFuID", qingGongID);
        compound.putInt("ExternalKungFuCooldown", qingGongCooldown);
    }

    @Override
    public void loadNBTData(CompoundTag compound) {
        qingGongID = compound.getString("ExternalKungFuID");
        qingGongCooldown = compound.getInt("ExternalKungFuCooldown");
    }

    @Override
    public boolean isExternalKungFuCooldownOver() {
        return qingGongCooldown <= 0;
    }

    private float calculateDamage(LivingEntity livingEntity) {
        double attackDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (int)(attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage); // 返回计算后的伤害值
    }

    @Override
    public void updateExternalKungFuCooldown() {
        if (qingGongCooldown > 0) {
            qingGongCooldown--;
        }
    }
}
