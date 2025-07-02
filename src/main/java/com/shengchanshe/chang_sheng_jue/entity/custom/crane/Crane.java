package com.shengchanshe.chang_sheng_jue.entity.custom.crane;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class Crane extends Animal implements GeoEntity, FlyingAnimal {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.COD,Items.SALMON,Items.TROPICAL_FISH);

    public Crane(EntityType<? extends Crane> aSuper1, Level aSuper) {
        super(aSuper1, aSuper);
        this.moveControl = new CraneFlyingMoveControl(this, 10, true);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,12D)
                .add(Attributes.MOVEMENT_SPEED,0.2D)
                .add(Attributes.FLYING_SPEED,1.5D).build();
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, pLevel);
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(true);
        flyingPathNavigation.setCanPassDoors(true);
        return flyingPathNavigation;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return FOOD_ITEMS.test(pStack);
    }

    @Override
    public int getExperienceReward() {
        return 0;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return ChangShengJueEntity.CRANE.get().create(level);
    }

    @Override
    public boolean onGround() {
        return super.onGround();
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if(event.isMoving()){
            if (!this.onGround()){
                event.setAndContinue(DefaultAnimations.FLY);
            }else {
                event.setAndContinue(DefaultAnimations.RUN);
            }
        }else {
            if (!this.onGround()){
                event.setAndContinue(DefaultAnimations.FLY);
            }else {
                event.setAndContinue(DefaultAnimations.REST);
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this,"controller",0,this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }
    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ChangShengJueSound.CRANE_SOUND.get();
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.CRANE_HURT.get();
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.CRANE_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

//    public static class CraneFlyingPathNavigation extends FlyingPathNavigation {
//        private int ticksAtCurrentTarget;
//
//        public CraneFlyingPathNavigation(Crane crane, Level level) {
//            super(crane, level);
//            this.ticksAtCurrentTarget = 0;
//        }
//
//        @Override
//        public void tick() {
//            if (this.isDone()) {
//                this.setTarget(this.getRandomTarget());
//                this.ticksAtCurrentTarget = 0;
//            } else {
//                this.ticksAtCurrentTarget++;
//                if (this.ticksAtCurrentTarget > this.level.random.nextInt(500) + 300) {
//                    this.setTarget(this.getRandomTarget());
//                    this.ticksAtCurrentTarget = 0;
//                }
//            }
//            super.tick();
//        }
//
//        private BlockPos getRandomTarget() {
//            Vec3 randomOffset = new Vec3(
//                    (this.level.random.nextDouble() - 0.5) * 15,
//                    (this.level.random.nextDouble() - 0.5) * 15,
//                    (this.level.random.nextDouble() - 0.5) * 15
//            );
//            return new BlockPos(
//                    (int) Math.round(this.mob.getX() + randomOffset.x),
//                    (int) Math.round(this.mob.getY() + randomOffset.y),
//                    (int) Math.round(this.mob.getZ() + randomOffset.z)
//            );
//        }
//
//        private void setTarget(BlockPos target) {
//            this.moveTo(target.getX(), target.getY(), target.getZ(), 1.0);
//        }
//    }

    public static class CraneFlyingMoveControl extends FlyingMoveControl {
        public CraneFlyingMoveControl(Mob mob, int maxPitchChange, boolean noGravity) {
            super(mob, maxPitchChange, noGravity);
        }

        @Override
        public void tick() {
            // 检查当前操作是否为移动到指定位置
            if (this.operation == MoveControl.Operation.MOVE_TO) {
                // 计算目标位置与当前位置的向量差
                Vec3 vec3d = new Vec3(this.wantedX - this.mob.getX(), this.wantedY - this.mob.getY(), this.wantedZ - this.mob.getZ());
                // 计算向量差的长度，即距离
                double d0 = vec3d.length();
                // 如果距离小于0.3，则停止移动
                if (d0 < 0.3) {
                    this.operation = MoveControl.Operation.WAIT;
                    this.mob.setSpeed((float) (0));
                } else {
                    // 获取生物的飞行速度属性值
                    double speed = this.mob.getAttributeValue(Attributes.FLYING_SPEED);
                    // 设置生物的移动速度
                    if (this.mob.onGround()){
                        this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
                    }else {
                        this.mob.setSpeed((float) (this.speedModifier * speed));
                    }

                    // 计算垂直方向上的速度分量
                    double ySpeed = vec3d.y / d0 * speed;
                    // 限制垂直方向上的最大速度
                    double maxYSpeed = 0.1;
                    ySpeed = Mth.clamp(ySpeed, -maxYSpeed, maxYSpeed);

                    // 设置生物的垂直方向上的移动速度
                    this.mob.setDeltaMovement(this.mob.getDeltaMovement().multiply(1, 0, 1).add(0, ySpeed, 0));

                    // 设置生物的旋转角度，使其面向目标位置
                    this.mob.setYRot(-((float)Mth.atan2(vec3d.x, vec3d.z)) * (180F / (float)Math.PI));
                    this.mob.setXRot(-((float)Mth.atan2(vec3d.y, vec3d.horizontalDistance())) * (180F / (float)Math.PI));
                }
            }
        }
    }
}
