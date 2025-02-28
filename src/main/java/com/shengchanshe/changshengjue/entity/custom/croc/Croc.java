package com.shengchanshe.changshengjue.entity.custom.croc;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.custom.tiger.Tiger;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class Croc extends TamableAnimal implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    protected int xpReward;
    private float hungryTime = 0;
    private double fedTime = 0;
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.BEEF, Items.PORKCHOP, Items.CHICKEN, Items.RABBIT, Items.MUTTON, ChangShengJueItems.VENISON.get());
    public Croc(EntityType<? extends Croc> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,30D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.MOVEMENT_SPEED,0.6D)
                .add(Attributes.KNOCKBACK_RESISTANCE).build();
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(2,new MeleeAttackGoal(this,0.6D, true));
        this.goalSelector.addGoal(3, new CrocWanderGoal(this, 0.6D));
        this.goalSelector.addGoal(5, new TemptGoal(this, 0.7D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.6D));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this).setAlertOthers()));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false,
                (entity) -> !isTame() && getHungryTime()==0));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Animal.class, 15, true, false,
                (entity) -> !this.isTame() && this.getFedTime() == 0 && !(entity instanceof Croc)));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Mob.class, 15, true, false,
                (entity) -> !this.isTame() && entity instanceof Enemy && !(entity instanceof Creeper) && !(entity instanceof Tiger)));

    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || isFood(itemstack) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (this.isTame()) {
            if(this.isFood(itemstack)){
                setHungryTime(10*60*20);
                setFedTime(3.3*60*20);
            }
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                this.heal((float)itemstack.getFoodProperties(this).getNutrition());
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            } else {
                InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
                if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(pPlayer)) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    return InteractionResult.SUCCESS;
                } else {
                    return interactionresult;
                }
            }
        } else if (isFood(itemstack)) {
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                this.tame(pPlayer);
                setHungryTime(10*60*20);


                this.navigation.stop();
                this.setTarget((LivingEntity)null);
                this.setOrderedToSit(true);
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(pPlayer, pHand);
        }

    }

    @Override
    public void aiStep() {
        if (fedTime > 0 && !isTame()) {
            fedTime--; // 每次调用aiStep时减少饱食时间

        }
        if (getHungryTime() > 0){
            setHungryTime(getHungryTime() - 1);

        }
        if (getHungryTime() == 0){
            this.setTame(false);
            this.setOwnerUUID(null);
            this.reassessTameGoals();
        }
        super.aiStep();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putFloat("HungryTime", this.getHungryTime());
        pCompound.putDouble("FedTime", this.getFedTime());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("HungryTime", 99)) {
            this.setHungryTime(pCompound.getFloat("HungryTime"));
        }
        if (pCompound.contains("FedTime", 99)) {
            this.setFedTime(pCompound.getInt("FedTime"));
        }

    }

    public double getFedTime() {
        return fedTime;
    }

    public void setFedTime(double fedTime) {
        this.fedTime = fedTime;
    }
    public float getHungryTime() {
        return hungryTime;
    }

    public void setHungryTime(float hungryTime) {
        this.hungryTime = hungryTime;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (this.onGround() && event.isMoving()) {
            event.getController().setAnimation(DefaultAnimations.WALK);
//            event.getController().setAnimation(RawAnimation.begin().thenPlay("walk"));
        }else if (this.isInWater()){
//            event.getController().setAnimation(RawAnimation.begin().thenPlay("still_in_water"));
            event.getController().setAnimation(DefaultAnimations.SWIM);
        }else if (!this.getPassengers().isEmpty()){
            event.getController().setAnimation(RawAnimation.begin().thenPlay("rotate_attack"));
        }else {
            return PlayState.STOP;
        }
        return PlayState.CONTINUE;
    }


    @Override
    public void tick() {
        super.tick();
        if (!level().isClientSide && this.getTarget() != null){
            if (this.distanceTo(this.getTarget()) < 2.0F){
                if (!this.getTarget().isBlocking() && this.getTarget().isAlive() && this.getPassengers().isEmpty() && this.getTarget().getVehicle() != this){
                    doPlayerRide(this.getTarget());
                }
            }
        }
    }

    public void positionRider(Entity passenger,MoveFunction pCallback) {
        if (this.hasPassenger(passenger)) {
            float radius = 1.3F;
            float angle = (0.017F * this.yBodyRot);
            double extraX = radius * Mth.sin((float) (Math.PI + angle));
            double extraZ = radius * Mth.cos(angle);
            passenger.setPos(this.getX() + extraX, this.getY() + 0.1F, this.getZ() + extraZ);
            passenger.hurt(this.damageSources().mobAttack(this), 2);
            if (this.isAlive()) {
                this.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
                this.doHurtTarget(passenger);
            }
        }
    }
    protected void doPlayerRide(Entity entity) {
        if (!this.level().isClientSide) {
            this.setYRot(entity.getYRot());
            this.setXRot(entity.getXRot());
            entity.startRiding(this,true);
        }
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    //骑乘动作
    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean doHurtTarget(Entity p_21372_) {
        return super.doHurtTarget(p_21372_);
    }
    @Override
    public int getExperienceReward() {
        int i = this.random.nextInt(4) + 1;
        this.xpReward = i;
        return this.xpReward;
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
//
//    @Override
//    public InteractionResult mobInteract(Player p_30713_, InteractionHand p_30714_) {
//        if (!this.isBaby()) {
//            if (this.isVehicle()) {
//                return super.mobInteract(p_30713_, p_30714_);
//            }
//        }
//
//        if (this.isBaby()) {
//            return super.mobInteract(p_30713_, p_30714_);
//        } else {
//            this.doPlayerRide(p_30713_);
//            return InteractionResult.sidedSuccess(this.level.isClientSide);
//        }
//    }

//    protected void doPlayerRide(Player player) {
//        if (!this.level.isClientSide) {
//            this.setYRot(player.getYRot());
//            this.setXRot(player.getXRot());
//            TigerEntity.this.startRiding(player);
//        }
//    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ChangShengJueEntity.CROC_ENTITY.get().create(level);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController(this,"attackController",0,this::attackPredicate));
    }

    private PlayState attackPredicate(AnimationState animationEvent) {
        if (this.swinging && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            animationEvent.getController().forceAnimationReset();
            if (this.isInWater() || this.getPassengers().isEmpty()){
                animationEvent.getController().setAnimation(RawAnimation.begin().thenPlay("attack"));
            }
            this.swinging =false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    static class CrocWanderGoal extends WaterAvoidingRandomStrollGoal {
        public CrocWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @Nullable
        protected Vec3 getPosition() {
            Vec3 vec3 = null;

            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3 = this.getTreePos();
            }

            return vec3;
        }

        @Nullable
        private Vec3 getTreePos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

            for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 3.0D), Mth.floor(this.mob.getY() - 6.0D), Mth.floor(this.mob.getZ() - 3.0D), Mth.floor(this.mob.getX() + 3.0D), Mth.floor(this.mob.getY() + 6.0D), Mth.floor(this.mob.getZ() + 3.0D))) {
                if (!blockpos.equals(blockpos1)) {
                    BlockState blockstate = this.mob.level().getBlockState(blockpos$mutableblockpos1.setWithOffset(blockpos1, Direction.DOWN));
                    boolean flag = blockstate.is(Blocks.WATER);
                    if (flag && this.mob.level().isEmptyBlock(blockpos1) && this.mob.level().isEmptyBlock(blockpos$mutableblockpos.setWithOffset(blockpos1, Direction.UP))) {
                        return Vec3.atBottomCenterOf(blockpos1);
                    }
                }
            }
            return null;
        }
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ChangShengJueSound.CROC_SOUND.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.CROC_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.CROC_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }
}
