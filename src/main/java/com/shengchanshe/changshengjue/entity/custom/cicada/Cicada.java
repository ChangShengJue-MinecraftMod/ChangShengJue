package com.shengchanshe.changshengjue.entity.custom.cicada;

import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class Cicada extends Animal implements GeoEntity, FlyingAnimal {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private boolean isHovering = false;

    public Cicada(EntityType<? extends Cicada> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.moveControl = new FlyingMoveControl(this, 20, false);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,3.0D)
                .add(Attributes.MOVEMENT_SPEED,0.2D)
                .add(Attributes.FLYING_SPEED,0.6D).build();
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new CicadaWanderGoal(this, 0.6D));
    }

    @Override
    protected PathNavigation createNavigation(Level p_29417_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_29417_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    @Override
    public int getExperienceReward() {
        return 0;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ChangShengJueSound.CICADA_SOUND.get();
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.CICADA_HURT.get();
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.CICADA_HURT.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        Level world = this.level();
        BlockPos pos = this.blockPosition();
        boolean north = hasBlock(world, pos.north());
        boolean south = hasBlock(world, pos.south());
        boolean east = hasBlock(world, pos.east());
        boolean west = hasBlock(world, pos.west());

        if (isHovering) {
            event.setAnimation(RawAnimation.begin().then("idle01", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()){
            event.setAnimation(RawAnimation.begin().then("idle02", Animation.LoopType.LOOP));
        } else if(north || south || east || west){
            event.setAnimation(RawAnimation.begin().then("idle01", Animation.LoopType.LOOP));
        } else{
            event.setAnimation(RawAnimation.begin().then("idle02", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public boolean isFlying(){
        return !this.onGround();
    }

    @Override
    public boolean causeFallDamage(float p_147187_, float p_147188_, DamageSource p_147189_) {
        return false;
    }

    @Override
    protected void checkFallDamage(double p_29370_, boolean p_29371_, BlockState p_29372_, BlockPos p_29373_) {
    }

    @Override
    public void tick() {
        super.tick();

        // 检测侧面是否有树叶
        if (checkSideLeaves()) {
            isHovering = true;
            this.getNavigation().stop(); // 停止移动
            this.setDeltaMovement(0, 0, 0); // 清除移动速度
        } else {
            isHovering = false;
        }

        this.updateLook(this);
    }

    private boolean checkSideLeaves() {
        Level world = this.level();
        BlockPos pos = this.blockPosition();

        return hasBlock(world, pos.north()) ||
                hasBlock(world, pos.south()) ||
                hasBlock(world, pos.east()) ||
                hasBlock(world, pos.west());
    }

    public void updateLook(Mob mob) {
        Level world = mob.level();
        BlockPos pos = mob.blockPosition();

        Vec3 lookAt = null;
        double minDistance = Double.MAX_VALUE;

        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                BlockPos blockPos = pos.offset(x, 0, z);
                Block block = world.getBlockState(blockPos).getBlock();
                if (block instanceof LeavesBlock || block.equals(BlockTags.LOGS)) {
                    double distance = mob.distanceToSqr(blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5);
                    if (distance < minDistance) {
                        Vec3 center = new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
                        Vec3 blockCenter = new Vec3(blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5);
                        Vec3 offset = blockCenter.subtract(center);
                        lookAt = center.add(offset.normalize());
                        minDistance = distance;
                    }
                }
            }
        }

        if (lookAt != null) {
            mob.getLookControl().setLookAt(lookAt.x, lookAt.y, lookAt.z);
        }
    }

    private static boolean hasBlock(Level world, BlockPos pos) {
        Block block = world.getBlockState(pos).getBlock();
        return block instanceof LeavesBlock || block.equals(BlockTags.LOGS);
    }

    static class CicadaWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public CicadaWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @Nullable
        protected Vec3 getPosition() {
            Vec3 vec3 = null;
            if (this.mob.isInWater()) {
                vec3 = LandRandomPos.getPos(this.mob, 15, 15);
            }

            if (this.mob.getRandom().nextFloat() >= this.probability) {
                vec3 = this.getTreePos();
            }

            return vec3 == null ? super.getPosition() : vec3;
        }

        @Nullable
        private Vec3 getTreePos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

            for(BlockPos blockpos1 : BlockPos.betweenClosed(Mth.floor(this.mob.getX() - 3.0D), Mth.floor(this.mob.getY() - 6.0D), Mth.floor(this.mob.getZ() - 3.0D), Mth.floor(this.mob.getX() + 3.0D), Mth.floor(this.mob.getY() + 6.0D), Mth.floor(this.mob.getZ() + 3.0D))) {
                if (!blockpos.equals(blockpos1)) {
                    BlockState blockstate = this.mob.level().getBlockState(blockpos$mutableblockpos1.setWithOffset(blockpos1, Direction.DOWN));
                    boolean flag = blockstate.getBlock() instanceof LeavesBlock || blockstate.is(BlockTags.LOGS);
                    if (flag && this.mob.level().isEmptyBlock(blockpos1) && this.mob.level().isEmptyBlock(blockpos$mutableblockpos.setWithOffset(blockpos1, Direction.UP))) {
                        return Vec3.atBottomCenterOf(blockpos1);
                    }
                }
            }

            return null;
        }
    }
}