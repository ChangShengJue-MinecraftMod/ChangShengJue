package com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu;

import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class SunflowerPointCaveman implements ExternalKungFuCapability {
    private String externalKungFuID = "SunflowerPointCaveman";
    private static final int EXTERNAL_COOLDOWN_TIME = 9 * 20; // 冷却时间，单位为tick（1秒=20tick）
    private int externalKungFuCooldown; // 当前冷却时间

    public SunflowerPointCaveman() {
        this.externalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getExternalKungFuID() {
        return externalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target,int cooldown) {
        if (externalKungFuCooldown > 0) {
            // 如果还在冷却中，直接返回
            return;
        }
        float health = 200;
        if (target instanceof LivingEntity livingEntity1){
            if (livingEntity.getHealth() < health) {
                livingEntity.level().playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                        ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                livingEntity1.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 1, false, false), livingEntity);
            }
        }

        // 使用武功后重置冷却时间
        externalKungFuCooldown = EXTERNAL_COOLDOWN_TIME - cooldown;
    }

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

    private float calculateDamage(LivingEntity livingEntity) {
        double attackDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (int)(attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage); // 返回计算后的伤害值
    }

    @Override
    public void updateExternalKungFuCooldown() {
        if (externalKungFuCooldown > 0) {
            externalKungFuCooldown--;
        }
    }
}
