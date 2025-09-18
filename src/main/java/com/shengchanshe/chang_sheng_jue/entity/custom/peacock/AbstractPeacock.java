package com.shengchanshe.chang_sheng_jue.entity.custom.peacock;

import com.shengchanshe.chang_sheng_jue.entity.custom.tiger.Tiger;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public abstract class AbstractPeacock extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final Ingredient FOOD_ITEMS = Ingredient.of(ChangShengJueItems.CORN.get(), ChangShengJueItems.SORGHUM.get(), ChangShengJueItems.SOYBEAN.get());
    public AbstractPeacock(EntityType<? extends AbstractPeacock> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.7D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Tiger.class, 8.0F, 0.7D, 0.8D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.6D, AbstractPeacock.class));
        this.goalSelector.addGoal(4, new TemptGoal(this, 0.7D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 0.6D));
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

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.isFood(itemstack)) {
            int i = this.getAge();
            if (!this.level().isClientSide && i == 0 && this.canFallInLove()) {
                this.usePlayerItem(pPlayer, pHand, itemstack);
                this.setInLove(pPlayer);
                return InteractionResult.SUCCESS;
            }

            if (this.isBaby()) {
                this.usePlayerItem(pPlayer, pHand, itemstack);
                this.ageUp(getSpeedUpSecondsWhenFeeding(-i), true);
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }

            if (this.level().isClientSide) {
                return InteractionResult.CONSUME;
            }
        }

        return super.mobInteract(pPlayer, pHand);
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