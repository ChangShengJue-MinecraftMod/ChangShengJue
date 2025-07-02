package com.shengchanshe.chang_sheng_jue.entity.villagers;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.SpawnUtil;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.sensing.GolemSensor;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;

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

    public void spawnGolemIfNeeded(ServerLevel pServerLevel, long pGameTime, int pMinVillagerAmount) {
        if (this.wantsToSpawnGolem(pGameTime)) {
            AABB aabb = this.getBoundingBox().inflate(10.0, 10.0, 10.0);
            List<Villager> list = pServerLevel.getEntitiesOfClass(Villager.class, aabb);
            List list1 = list.stream().filter((p_186293_) -> p_186293_.wantsToSpawnGolem(pGameTime)).limit(5L).toList();
            if (list1.size() >= pMinVillagerAmount && SpawnUtil.trySpawnMob(ChangShengJueEntity.WARRIOR.get(), MobSpawnType.MOB_SUMMONED, pServerLevel, this.blockPosition(), 10, 8, 6, SpawnUtil.Strategy.LEGACY_IRON_GOLEM).isPresent()) {
                list.forEach(GolemSensor::golemDetected);
            }
        }

    }

}
