package com.shengchanshe.changshengjue.entity.custom;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animation.*;

import java.util.UUID;

public class MonkeyEntity extends Animal implements GeoEntity,NeutralMob{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    protected int xpReward;
    @Nullable
    private UUID persistentAngerTarget;
    @Nullable
    private Entity vehicle;
    public boolean attackTick;
    private int anInt = 0;
    private static final EntityDataAccessor<Boolean> MONKEY_ATTACK =
            SynchedEntityData.defineId(MonkeyEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(MonkeyEntity.class, EntityDataSerializers.INT);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    public MonkeyEntity(EntityType<? extends MonkeyEntity> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
        this.entityData.define(MONKEY_ATTACK,false);
    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,10D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D)
                .add(Attributes.ATTACK_SPEED, 2.0D)
                .add(Attributes.MOVEMENT_SPEED,0.6D).build();
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.6D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 0.8D, Ingredient.of(ChangShengJueItems.BANANA.get()), false));
        this.goalSelector.addGoal(2,new MonkeyAttackGoal(this,0.8D, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.targetSelector.addGoal(6, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) ->{
            if (entity instanceof Player){
                Player player = (Player) entity;
                ItemStack mainHandItem = player.getMainHandItem();
                ItemStack offhandItem = player.getOffhandItem();
                if (mainHandItem.is(ChangShengJueItems.BANANA.get()) && anInt >= 600 ||  offhandItem.is(ChangShengJueItems.BANANA.get()) && anInt >= 600) {
                    return true;
                }else {
                    return false;
                }
            }
            return false;
        }));
        this.targetSelector.addGoal(2, new ResetUniversalAngerTargetGoal<>(this, true));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_27587_) {
        super.addAdditionalSaveData(p_27587_);
        this.addPersistentAngerSaveData(p_27587_);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_27576_) {
        super.readAdditionalSaveData(p_27576_);
        this.addPersistentAngerSaveData(p_27576_);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (!this.level().isClientSide) {
            this.updatePersistentAnger((ServerLevel)this.level(), false);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (attackTick){
            anInt++;
            if (anInt >= 600){
                this.startPersistentAngerTimer();
            }
        }else {
            this.goalSelector.addGoal(2,new MonkeyAttackGoal(this,0.8D, false));
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() == (ChangShengJueItems.BANANA.get())){
            this.setTarget(null);
            itemStack.shrink(1);
            this.setRemainingPersistentAngerTime(0);
            this.stopRiding();
            anInt = 0;
        }
        return super.mobInteract(player, hand);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()) {
            if (this.shouldFollow(Minecraft.getInstance().player)){
                event.getController().setAnimation(RawAnimation.begin().then("jump",Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }
            event.getController().setAnimation(RawAnimation.begin().then("walk",Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        if (this.shouldFollow(Minecraft.getInstance().player)){
            event.getController().setAnimation(RawAnimation.begin().then("jump",Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(RawAnimation.begin().then("idle",Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    public boolean shouldFollow(LivingEntity entity) {
        if (entity.getMainHandItem().is(ChangShengJueItems.BANANA.get()) || entity.getOffhandItem().is(ChangShengJueItems.BANANA.get())){
            if (anInt >= 600){
                this.doPlayerRide(Minecraft.getInstance().player);
            }
            attackTick = true;
        }else {
            attackTick = false;
        }
        return entity.getMainHandItem().is(ChangShengJueItems.BANANA.get()) || entity.getOffhandItem().is(ChangShengJueItems.BANANA.get());
    }

    @Override
    public boolean doHurtTarget(Entity p_21372_) {
        return super.doHurtTarget(p_21372_);
    }
    @Override
    public int getExperienceReward() {
        int i = this.random.nextInt(2) + 1;
        this.xpReward = i;
        return this.xpReward;
    }

    class MonkeyAttackGoal extends MeleeAttackGoal {
        MonkeyAttackGoal(PathfinderMob p_27960_, double p_27961_, boolean p_27962_) {
            super(p_27960_, p_27961_, p_27962_);
        }

        public boolean canUse() {
            return super.canUse() && MonkeyEntity.this.isAngry();
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && MonkeyEntity.this.isAngry();
        }
    }

//    public boolean canBeControlledByRider() {
//        Entity entity = this.getControllingPassenger();
//        if (!(entity instanceof Player)) {
//            return false;
//        } else {
//            Player playerentity = (Player)entity;
//            return true;
//        }
//    }

    protected void doPlayerRide(Player player) {
//        if (!this.level.isClientSide) {
            this.setYRot(player.getYRot());
            this.setXRot(player.getXRot());
            MonkeyEntity.this.startRiding(player);
//        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ChangShengJueEntity.MONKEY_ENTITY.get().create(level);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.getItem() == ChangShengJueItems.BANANA.get();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController(this,"attackController",0,this::attackPredicate));
    }

    private PlayState attackPredicate(AnimationState animationEvent) {
        if (this.swinging && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            animationEvent.getController().forceAnimationReset();
            animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack"));
            this.swinging =false;
        }
        return PlayState.CONTINUE;
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        Integer i = this.entityData.get(DATA_REMAINING_ANGER_TIME);
        return i;
    }

    @Override
    public void setRemainingPersistentAngerTime(int p_21673_) {
        this.entityData.set(DATA_REMAINING_ANGER_TIME, p_21673_);
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID p_21672_) {
        this.persistentAngerTarget = p_21672_;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return isBaby() ? ChangShengJueSound.MONKEY_BABY_SOUND.get() : attackTick ? ChangShengJueSound.MONKEY_ANGRY_SOUND.get() : ChangShengJueSound.MONKEY_SOUND.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.MONKEY_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.MONKEY_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }
}
