package com.shengchanshe.chang_sheng_jue.entity.custom.peacock.female;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.AbstractPeacock;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.male.MalePeacock;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class FemalePeacock extends AbstractPeacock {
    public float flap;
    public float flapSpeed;
    public float oFlapSpeed;
    public float oFlap;
    public float flapping = 1.0F;
    private float nextFlap = 1.0F;
    public int eggTime = this.random.nextInt(6000) + 6000;
    public FemalePeacock(EntityType<? extends FemalePeacock> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof MalePeacock)) {
            return false;
        }else {
            return true;
        }
    }
    protected float getStandingEyeHeight(Pose p_28251_, EntityDimensions p_28252_) {
        return this.isBaby() ? p_28252_.height * 0.85F : p_28252_.height * 0.92F;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D, MalePeacock.class));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return ChangShengJueEntity.FEMALE_PEACOCK.get().create(level);
    }

    public void aiStep() {
        super.aiStep();
        this.oFlap = this.flap;
        this.oFlapSpeed = this.flapSpeed;
        this.flapSpeed = (float)((double)this.flapSpeed + (double)(this.onGround() ? -1 : 4) * 0.3D);
        this.flapSpeed = Mth.clamp(this.flapSpeed, 0.0F, 1.0F);
        if (!this.onGround() && this.flapping < 1.0F) {
            this.flapping = 1.0F;
        }

        this.flapping = (float)((double)this.flapping * 0.9D);
        Vec3 vec3 = this.getDeltaMovement();
        if (!this.onGround() && vec3.y < 0.0D) {
            this.setDeltaMovement(vec3.multiply(1.0D, 0.6D, 1.0D));
        }

        this.flap += this.flapping * 2.0F;
        if (!this.level().isClientSide && this.isAlive() && !this.isBaby() && --this.eggTime <= 0) {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(ChangShengJueItems.PEACOCK_EGGS.get());
            this.eggTime = this.random.nextInt(6000) + 6000;
        }

    }

    protected boolean isFlapping() {
        return this.flyDist > this.nextFlap;
    }

    protected void onFlap() {
        this.nextFlap = this.flyDist + this.flapSpeed / 2.0F;
    }

    public boolean causeFallDamage(float p_148875_, float p_148876_, DamageSource p_148877_) {
        return false;
    }

//    protected SoundEvent getAmbientSound() {
//        return SoundEvents.CHICKEN_AMBIENT;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource p_28262_) {
//        return SoundEvents.CHICKEN_HURT;
//    }
//
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.CHICKEN_DEATH;
//    }

//    protected void playStepSound(BlockPos p_28254_, BlockState p_28255_) {
//        this.playSound(SoundEvents.CHICKEN_STEP, 0.15F, 1.0F);
//    }

    public void readAdditionalSaveData(CompoundTag p_28243_) {
        super.readAdditionalSaveData(p_28243_);
        if (p_28243_.contains("EggLayTime")) {
            this.eggTime = p_28243_.getInt("EggLayTime");
        }

    }

    public void addAdditionalSaveData(CompoundTag p_28257_) {
        super.addAdditionalSaveData(p_28257_);
        p_28257_.putInt("EggLayTime", this.eggTime);
    }

    public void positionRider(Entity p_28269_,MoveFunction p_19958_) {
        super.positionRider(p_28269_);
        float f = Mth.sin(this.yBodyRot * ((float)Math.PI / 180F));
        float f1 = Mth.cos(this.yBodyRot * ((float)Math.PI / 180F));
        float f2 = 0.1F;
        float f3 = 0.0F;
        p_28269_.setPos(this.getX() + (double)(0.1F * f), this.getY(0.5D) + p_28269_.getMyRidingOffset() + 0.0D, this.getZ() - (double)(0.1F * f1));
        if (p_28269_ instanceof LivingEntity) {
            ((LivingEntity)p_28269_).yBodyRot = this.yBodyRot;
        }
    }

}
