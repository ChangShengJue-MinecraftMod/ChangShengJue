package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class XuannuSwordsmanship implements KungFuCapability {
    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {
        this.onXuannuSwordsmanship(livingEntity.level(),livingEntity);
    }
    @Override
    public String getID() {
        return "XuannuSwordsmanship";
    }
    @Override
    public void saveNBTData(CompoundTag compound) {

    }

    @Override
    public void loadNBTData(CompoundTag compound) {

    }

    private void onXuannuSwordsmanship(Level pLevel, LivingEntity pEntity) {
        float radius = 4.0f;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        for (Entity entity : entities) {//遍历包围盒中的实体
            //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
            if (pEntity.isPickable() && pEntity.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                if (!(entity instanceof Villager) && !(entity instanceof Warrior)) {
                    float damage = this.calculateDamage(pEntity);
                    float probability = pEntity.getRandom().nextFloat();
                    float defaultProbability = 0.15F;
                    if (probability < (defaultProbability * 1.2F)) {
                        if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                            ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, false), pEntity);
                        }
                    }
                    if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), pEntity), damage)) {//造成伤害
                        EnchantmentHelper.doPostDamageEffects(pEntity, entity);// 应用附魔
                    }
                }
            }
        }
    }
    private float calculateDamage(LivingEntity livingEntity) {
        double baseDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (float) ((baseDamage + 2) * 2.0F);// 返回计算后的伤害值
    }
    public boolean isLivingSkeletonAndGolemAndSlime(LivingEntity pLivingEntity) {
        return pLivingEntity instanceof AbstractSkeleton || pLivingEntity instanceof AbstractGolem || pLivingEntity instanceof Slime || pLivingEntity instanceof SkeletonHorse;
    }
}
