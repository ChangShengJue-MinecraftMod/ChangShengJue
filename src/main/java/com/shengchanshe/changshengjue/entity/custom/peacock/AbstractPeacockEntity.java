package com.shengchanshe.changshengjue.entity.custom.peacock;

import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public abstract class AbstractPeacockEntity extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.RED_MUSHROOM, Items.BROWN_MUSHROOM);
    public AbstractPeacockEntity(EntityType<? extends AbstractPeacockEntity> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.6D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D, AbstractPeacockEntity.class));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(Items.RED_MUSHROOM, Items.BROWN_MUSHROOM), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.6D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

    @Override
    public int getExperienceReward() {
        return 0;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()) {
            event.setAndContinue(RawAnimation.begin().thenPlay("walk"));
        }else {
            event.setAnimation(RawAnimation.begin().thenPlay("idle"));
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
    protected SoundEvent getAmbientSound() {
        return ChangShengJueSound.PEACOCK_SOUND.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.PEACOCK_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.PEACOCK_DEATH.get();
    }
}