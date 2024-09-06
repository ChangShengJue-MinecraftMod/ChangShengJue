package com.shengchanshe.changshengjue.entity.custom.peacock;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
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
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class MalePeacockEntity extends AbstractPeacockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int anInt = 0;
    private boolean aBoolean;
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(MalePeacockEntity.class, EntityDataSerializers.INT);

    public MalePeacockEntity(EntityType<? extends MalePeacockEntity> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
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
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        MalePeacockEntity malePeacockEntity = ChangShengJueEntity.MALE_PEACOCK_ENTITY.get().create(level);
        PeacockVariant variant = Util.getRandom(PeacockVariant.values(),this.random);
        malePeacockEntity.setVariant(variant);
        return malePeacockEntity;
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof FemalePeacockEntity)) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (anInt < 600){
            anInt++;
        }else if (anInt >= 600){
            aBoolean = new Random().nextBoolean();
            anInt = 0;
        }
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()) {
            event.setAnimation(RawAnimation.begin().then("walk", Animation.LoopType.LOOP));
        }else if (aBoolean && !event.isMoving()){
            event.setAnimation(RawAnimation.begin().then("Open screen", Animation.LoopType.PLAY_ONCE).then("dance",Animation.LoopType.LOOP));
        }else {
            event.setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    /**
     * 变异
     * */
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        PeacockVariant variant = Util.getRandom(PeacockVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
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


//    @Override
//    public void tick() {
//        super.tick();
//        this.spawnFluidParticle(this.level, this.getX() - (double)0.1F, this.getX() + (double)0.1F, this.getZ() - (double)0.1F, this.getZ() + (double)0.1F, this.getY(0.0D), ParticleTypes.FALLING_NECTAR);
//    }
//    private void spawnFluidParticle(Level p_27780_, double p_27781_, double p_27782_, double p_27783_, double p_27784_, double p_27785_, ParticleOptions p_27786_) {
//        p_27780_.addParticle(p_27786_, Mth.lerp(p_27780_.random.nextDouble(), p_27781_, p_27782_), p_27785_, Mth.lerp(p_27780_.random.nextDouble(), p_27783_, p_27784_), 0.0D, 0.0D, 0.0D);
//    }

}
