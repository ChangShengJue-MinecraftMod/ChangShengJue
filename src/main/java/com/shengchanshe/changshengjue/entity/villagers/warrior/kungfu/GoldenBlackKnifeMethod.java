package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntity;
import com.shengchanshe.changshengjue.entity.villagers.warrior.Warrior;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GoldenBlackKnifeMethod implements KungFuCapability {
    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {
        this.onGoldenBlackKnifeMethod(livingEntity.level(),livingEntity);
    }
    @Override
    public String getID() {
        return "GoldenBlackKnifeMethod";
    }
    @Override
    public void saveNBTData(CompoundTag compound) {
    }

    @Override
    public void loadNBTData(CompoundTag compound) {
    }

    private void onGoldenBlackKnifeMethod(Level pLevel, LivingEntity pEntity) {
        float radius = 4.0f;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        GoldenBlackKnifeMethodEntity goldenBlackKnifeMethodEntity = new GoldenBlackKnifeMethodEntity(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD_ENTITY.get(), pLevel);
        goldenBlackKnifeMethodEntity.moveTo(hitLocation);
        goldenBlackKnifeMethodEntity.setYRot(pEntity.getYRot());
        pLevel.addFreshEntity(goldenBlackKnifeMethodEntity);
        for (Entity entity : entities) {//遍历包围盒中的实体
            //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
            if (pEntity.isPickable() && pEntity.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                if (!(entity instanceof Villager) && !(entity instanceof Warrior)) {
                    float damage = this.calculateDamage(pEntity);
                    if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), pEntity), damage)) {//造成伤害
                        EnchantmentHelper.doPostDamageEffects(pEntity, entity);//应用附魔
                    }
                }
            }
        }
        pLevel.playSound(null, pEntity.getX(), pEntity.getY(), pEntity.getZ(), ChangShengJueSound.GOLDEN_BLACK_KNIFE_METHOD_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
    }
    private float calculateDamage(LivingEntity livingEntity) {
        double baseDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (float) (baseDamage + 2) * 1.6F;// 返回计算后的伤害值
    }

}
