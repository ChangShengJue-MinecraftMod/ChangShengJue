package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.dugu_nine_swords.DuguNineSwordsEntity;
import com.shengchanshe.changshengjue.entity.combat.ge_shan_da_niu.GeShanDaNiuEntity;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
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

public class GeShanDaNiu implements KungFuCapability {

    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {
        Level pLevel = livingEntity.level();
        float radius = 4.0F * 1.5F;
        float distance = 2.0F;
        Vec3 forward = livingEntity.getForward();
        Vec3 hitLocation = livingEntity.position().add(0, livingEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));
        //radius * 2 表示的是立方体的边长,radius表示的从立方体中心到边界的距离
        var entities = pLevel.getEntities(livingEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));
        for (Entity entity : entities) {//遍历包围盒中的实体
            //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
            if (livingEntity.isPickable() && livingEntity.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                if (!(entity instanceof Villager) && !(entity instanceof Warrior)) {
                    if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), livingEntity), this.calculateDamage(livingEntity))) {//造成伤害
                        EnchantmentHelper.doPostDamageEffects(livingEntity, entity);//应用附魔
                    }
                }
            }
        }
        GeShanDaNiuEntity geShanDaNiuEntity = new GeShanDaNiuEntity(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), pLevel);
        geShanDaNiuEntity.moveTo(hitLocation);
        geShanDaNiuEntity.setYRot(livingEntity.getYRot());
        geShanDaNiuEntity.setXRot(livingEntity.getXRot());
        pLevel.addFreshEntity(geShanDaNiuEntity);
    }

    @Override
    public void saveNBTData(CompoundTag compound) {
    }

    @Override
    public void loadNBTData(CompoundTag compound) {

    }

    @Override
    public String getID() {
        return "GeShanDaNiu";
    }

    private float calculateDamage(LivingEntity livingEntity) {
        double baseDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (float) ((baseDamage + 14)); // 返回计算后的伤害值
    }

    public boolean isLivingSkeletonAndGolemAndSlime(LivingEntity pLivingEntity) {
        return pLivingEntity instanceof AbstractSkeleton || pLivingEntity instanceof AbstractGolem || pLivingEntity instanceof Slime || pLivingEntity instanceof SkeletonHorse;
    }
}
