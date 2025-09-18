package com.shengchanshe.chang_sheng_jue.entity.custom.peacock.male;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.AbstractPeacock;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.PeacockDisplayGoal;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.PeacockVariant;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.female.FemalePeacock;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

import static net.minecraft.world.entity.MobSpawnType.CHUNK_GENERATION;

public class MalePeacock extends AbstractPeacock {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(MalePeacock.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DISPLAYING =
            SynchedEntityData.defineId(MalePeacock.class, EntityDataSerializers.BOOLEAN);

    public MalePeacock(EntityType<? extends MalePeacock> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D, FemalePeacock.class));
        this.goalSelector.addGoal(3, new PeacockDisplayGoal(this)); // 优先级设为3
    }

    // 新增方法
    public void setDisplaying(boolean displaying) {
        this.entityData.set(DISPLAYING, displaying);
    }

    public boolean isDisplaying() {
        return this.entityData.get(DISPLAYING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DISPLAYING, false);
        this.entityData.define(DATA_ID_TYPE_VARIANT,0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT,tag.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Displaying", this.isDisplaying());
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        MalePeacock malePeacockEntity = ChangShengJueEntity.MALE_PEACOCK.get().create(level);
        PeacockVariant variant = Util.getRandom(PeacockVariant.values(),this.random);
        malePeacockEntity.setVariant(variant);
        return malePeacockEntity;
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof FemalePeacock)) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void tick() {
        super.tick();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()) {
            event.setAnimation(RawAnimation.begin().then("walk",Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        event.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState displayingController(AnimationState<E> event){
        if (this.isDisplaying()){
            event.setAnimation(RawAnimation.begin()
                    .then("Open screen2", Animation.LoopType.PLAY_ONCE)
            );
            event.getController().forceAnimationReset();
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController(this,"displayingController",0,this::displayingController));
    }

    /**
     * 变异
     * */
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        if (pReason != CHUNK_GENERATION){
            PeacockVariant variant = Util.getRandom(PeacockVariant.values(), this.random);
            setVariant(variant);
        }
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

    public PeacockVariant getVariant() {
        return PeacockVariant.getById(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(PeacockVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

//    @Override
//    public void tick() {
//        super.tick();
//        this.spawnFluidParticle(this.level, this.getX() - (double)0.1F, this.getX() + (double)0.1F, this.getZ() - (double)0.1F, this.getZ() + (double)0.1F, this.getY(0.0D), ParticleTypes.FALLING_NECTAR);
//    }
//    private void spawnFluidParticle(Level p_27780_, double p_27781_, double p_27782_, double p_27783_, double p_27784_, double p_27785_, ParticleOptions p_27786_) {
//        p_27780_.addParticle(p_27786_, Mth.lerp(p_27780_.random.nextDouble(), p_27781_, p_27782_), p_27785_, Mth.lerp(p_27780_.random.nextDouble(), p_27783_, p_27784_), 0.0D, 0.0D, 0.0D);
//    }

}
