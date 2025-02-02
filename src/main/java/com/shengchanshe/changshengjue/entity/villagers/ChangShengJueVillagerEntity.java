package com.shengchanshe.changshengjue.entity.villagers;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class ChangShengJueVillagerEntity extends Villager {
    public ChangShengJueVillagerEntity(EntityType<? extends ChangShengJueVillagerEntity> p_35381_, Level p_35382_) {
        super(p_35381_, p_35382_);
    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.FOLLOW_RANGE,48D)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }
    @Nullable
    public ChangShengJueVillagerEntity getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        ChangShengJueVillagerEntity villager = new ChangShengJueVillagerEntity(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), pLevel);
        villager.finalizeSpawn(pLevel, pLevel.getCurrentDifficultyAt(villager.blockPosition()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
        return villager;
    }

}
