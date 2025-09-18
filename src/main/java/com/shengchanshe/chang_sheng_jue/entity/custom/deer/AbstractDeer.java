package com.shengchanshe.chang_sheng_jue.entity.custom.deer;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.entity.custom.tiger.Tiger;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
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
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;

public abstract class AbstractDeer extends Animal implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private EatBlockGoal eatBlockGoal;
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.CARROT, Items.OAK_LEAVES,Items.AZALEA_LEAVES,Items.DARK_OAK_LEAVES,Items.FLOWERING_AZALEA_LEAVES,Items.BIRCH_LEAVES,
            Items.SPRUCE_LEAVES,Items.JUNGLE_LEAVES,Items.AZALEA_LEAVES,Items.WHEAT,
            ChangShengJueBlocks.MANGO_LEAVES.get(),ChangShengJueBlocks.OSMANTHUS_LEAVES.get(),ChangShengJueBlocks.PLUM_LEAVES.get(),ChangShengJueBlocks.BANANA_LEAVES.get(),
            ChangShengJueBlocks.PEAR_LEAVES.get(),ChangShengJueBlocks.LICHEE_LEAVES.get(),ChangShengJueBlocks.DURIAN_LEAVES.get(),ChangShengJueBlocks.POPLAR_LEAVES.get(),
            ChangShengJueBlocks.MULBERRY_LEAVES.get(), ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(), ChangShengJueBlocks.WENGE_LEAVES.get(), ChangShengJueBlocks.ZI_TAN_LEAVES.get(), ChangShengJueItems.THATCH.get());
    public Random random = new Random();
    private int eatAnimationTick;
    public AbstractDeer(EntityType<? extends AbstractDeer> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    public void aiStep() {
        if (this.level().isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }
    public void handleEntityEvent(byte p_29814_) {
        if (p_29814_ == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(p_29814_);
        }

    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,20)
                .add(Attributes.MOVEMENT_SPEED,0.6D).build();
    }

    protected void registerGoals(){
        this.eatBlockGoal = new EatBlockGoal(this);
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 0.7D));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Tiger.class, 8.0F, 0.7D, 0.8D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D, AbstractDeer.class));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.6D));
        this.goalSelector.addGoal(5, this.eatBlockGoal);
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
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()){
            event.getController().setAnimation(RawAnimation.begin().thenPlay("walk"));
        }else if (this.eatAnimationTick > 4 && this.eatAnimationTick <= 36){
            event.getController().setAnimation(RawAnimation.begin().thenPlay("eating_grass"));
        }else {
            event.getController().setAnimation(RawAnimation.begin().thenPlay("idle"));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
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
        int i = new Random().nextInt(6);
        switch (i){
            case 0:
                return ChangShengJueSound.DEER_SOUND.get();
            case 1:
                return ChangShengJueSound.DEER_SOUND_1.get();
            case 2:
                return ChangShengJueSound.DEER_SOUND_2.get();
            case 3:
                return ChangShengJueSound.DEER_SOUND_3.get();
            case 4:
                return ChangShengJueSound.DEER_SOUND_4.get();
            case 5:
                return ChangShengJueSound.DEER_SOUND_5.get();
            default:
                return null;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.DEER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.DEER_DEATH.get();
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