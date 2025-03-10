package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class RelentlessThrowingKnives implements KungFuCapability {
    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {
//        Level pLevel = livingEntity.level();
//        int numKnives = 7; // 投掷物的数量
//        float angleStep = 10.0F; // 每个投掷物之间的角度差
//        for (int i = 0; i < numKnives; i++) {
//            ThrowingKnivesEntity feiDaoEntity = new ThrowingKnivesEntity(pLevel, livingEntity, ChangShengJueItems.THROWING_KNIVES.get().getDefaultInstance());
//
//            // 计算这个投掷物的发射角度
//            float angle = livingEntity.getYRot() + (i - (float) numKnives / 2) * angleStep;
//
//            feiDaoEntity.shootFromRotation(livingEntity, livingEntity.getXRot(), angle, 0.0F, 2.5F, 1.0F);
//            pLevel.addFreshEntity(feiDaoEntity);
//        }
//        pLevel.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ChangShengJueSound.SEVEN_THROWING_KNIVES_SOUND.get(), SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
    }

    @Override
    public String getID() {
        return "RelentlessThrowingKnives";
    }
    @Override
    public void saveNBTData(CompoundTag compound) {

    }

    @Override
    public void loadNBTData(CompoundTag compound) {

    }

    private float calculateDamage(LivingEntity livingEntity) {
        double baseDamage = livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE);
        // 计算最终伤害值
        return (float) ((baseDamage + 2) * 1.8F);// 返回计算后的伤害值
    }

}
