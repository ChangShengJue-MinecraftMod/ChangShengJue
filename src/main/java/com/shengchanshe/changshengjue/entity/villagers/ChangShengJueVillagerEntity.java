package com.shengchanshe.changshengjue.entity.villagers;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ChangShengJueVillagerEntity extends Villager implements GeoEntity {
    private byte foodLevel;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public ChangShengJueVillagerEntity(EntityType<? extends ChangShengJueVillagerEntity> p_35381_, Level p_35382_) {
        super(p_35381_, p_35382_);
    }

    public ChangShengJueVillagerEntity(EntityType<? extends ChangShengJueVillagerEntity> entityType, Level level, VillagerType type) {
        super(entityType, level);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        this.getNavigation().setCanFloat(true);
        this.setCanPickUpLoot(true);
        this.setVillagerData(this.getVillagerData().setType(type).setProfession(VillagerProfession.NONE));
    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,20D)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this,"controller",0,this::predicate));
    }


    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()) {
            event.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }else if (this.isSleeping()){
            if (!this.isBaby()){
                event.setAnimation(RawAnimation.begin().then("sleep", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }else {
                return PlayState.STOP;
            }
        }else {
            return PlayState.STOP;
        }
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
    private int countFoodPointsInInventory() {
        SimpleContainer simplecontainer = this.getInventory();
        return FOOD_POINTS.entrySet().stream().mapToInt((p_186300_) -> simplecontainer.countItem(p_186300_.getKey()) * p_186300_.getValue()).sum();
    }

    public void eatAndDigestFood() {
        this.eatUntilFull();
        this.digestFood(12);
    }

    private boolean hungry() {
        return this.foodLevel < 12;
    }
    private void digestFood(int p_35549_) {
        this.foodLevel = (byte)(this.foodLevel - p_35549_);
    }
    private void eatUntilFull() {
        if (this.hungry() && this.countFoodPointsInInventory() != 0) {
            for(int i = 0; i < this.getInventory().getContainerSize(); ++i) {
                ItemStack itemstack = this.getInventory().getItem(i);
                if (!itemstack.isEmpty()) {
                    Integer integer = FOOD_POINTS.get(itemstack.getItem());
                    if (integer != null) {
                        int j = itemstack.getCount();

                        for(int k = j; k > 0; --k) {
                            this.foodLevel = (byte)(this.foodLevel + integer);
                            this.getInventory().removeItem(i, 1);
                            if (!this.hungry()) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public ChangShengJueVillagerEntity getBreedOffspring(ServerLevel level, AgeableMob mob) {
        double d0 = this.random.nextDouble();
        VillagerType villagertype;
        if (d0 < 0.5D) {
            villagertype = VillagerType.byBiome(level.getBiome(this.blockPosition()));
        } else if (d0 < 0.75D) {
            villagertype = this.getVillagerData().getType();
        } else {
            villagertype = ((Villager)mob).getVillagerData().getType();
        }
        ChangShengJueVillagerEntity villager = new ChangShengJueVillagerEntity(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(), level, villagertype);
        villager.finalizeSpawn(level, level.getCurrentDifficultyAt(villager.blockPosition()), MobSpawnType.BREEDING, (SpawnGroupData)null, (CompoundTag)null);
        return villager;
    }
}
