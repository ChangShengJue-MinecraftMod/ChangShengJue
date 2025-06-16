package com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class ShaolinStickMethod implements ExternalKungFuCapability {
    private static final int EXTERNAL_COOLDOWN_TIME = 8 * 20; // 冷却时间，单位为tick（1秒=20tick）
    private int externalKungFuCooldown; // 当前冷却时间
    private String externalKungFuID = "ShaolinStickMethod";

    public ShaolinStickMethod() {
        this.externalKungFuCooldown = 0; // 初始化冷却时间为0
    }

    @Override
    public String getExternalKungFuID() {
        return externalKungFuID;
    }

    @Override
    public void applyAttackEffect(LivingEntity livingEntity,Entity target, int cooldown) {
        this.onShaolinStickMethod(livingEntity.level(),livingEntity,cooldown);
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

    @Override
    public void updateExternalKungFuCooldown() {
        if (externalKungFuCooldown > 0) {
            externalKungFuCooldown--;
        }
    }

    private void onShaolinStickMethod(Level pLevel, LivingEntity pEntity,int cooldown) {
        if (externalKungFuCooldown > 0) {
            // 如果还在冷却中，直接返回
            return;
        }
        float radius = 5.0f;//攻击半径
        float distance = 5.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3F, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        //radius * 2 表示的是立方体的边长,radius表示的从立方体中心到边界的距离
        for (Entity entity : entities) {//遍历包围盒中的实体
                //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
            if (pEntity.isPickable() && pEntity.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                if (!(entity instanceof Villager) && !(entity instanceof AbstractWuXia)) {
                    float damage = this.calculateDamage(pEntity);
                    float probability = pEntity.getRandom().nextFloat();
                    float defaultProbability = 0.15F;
                    if (probability < (defaultProbability * 1.2F)) {
                        ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 14, 1, false, false), pEntity);
                    }
                    if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), pEntity), damage)) {//造成伤害
                        EnchantmentHelper.doPostDamageEffects(pEntity, entity);//应用附魔
                    }
                }
            }
        }
        externalKungFuCooldown = EXTERNAL_COOLDOWN_TIME - cooldown; // 设置冷却时间
    }

    private float calculateDamage(LivingEntity livingEntity) {
        double attackDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (int)(attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage); // 返回计算后的伤害值
    }

}
