package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Slime;

public class GoldenBellJar implements KungFuCapability {

    @Override
    public void applyAttackEffect(LivingEntity livingEntity, Entity target) {
        livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, 1, false, false), livingEntity);
    }

    @Override
    public void saveNBTData(CompoundTag compound) {
    }

    @Override
    public void loadNBTData(CompoundTag compound) {

    }

    @Override
    public String getID() {
        return "GoldenBellJar";
    }

}
