package com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.kungfu;

import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.ExternalKungFuCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class RelentlessThrowingKnives implements ExternalKungFuCapability {
    private static final int EXTERNAL_COOLDOWN_TIME = 8 * 20; // 冷却时间，单位为tick（1秒=20tick）
    private int externalKungFuCooldown; // 当前冷却时间
    private String externalKungFuID = "RelentlessThrowingKnives";

    public RelentlessThrowingKnives() {
        this.externalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getExternalKungFuID() {
        return externalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity,Entity target, int cooldown) {
    }

//    @Override
//    public String getID() {
//        return "RelentlessThrowingKnives";
//    }

    @Override
    public void saveNBTData(CompoundTag compound) {
        compound.putString("ExternalKungFuID", externalKungFuID);
        compound.putInt("ExternalKungFuCooldown", externalKungFuCooldown);
    }

    @Override
    public void loadNBTData(CompoundTag compound) {
        externalKungFuID = compound.getString("ExternalKungFuID");
        externalKungFuCooldown = compound.getInt("ExternalKungFuCooldown");
    }

    @Override
    public boolean isExternalKungFuCooldownOver() {
        return externalKungFuCooldown <= 0;
    }

    @Override
    public void updateExternalKungFuCooldown() {
        if (externalKungFuCooldown > 0) {
            externalKungFuCooldown--;
        }
    }

    private float calculateDamage(LivingEntity livingEntity) {
        double attackDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (int)(attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage); // 返回计算后的伤害值
    }

}
