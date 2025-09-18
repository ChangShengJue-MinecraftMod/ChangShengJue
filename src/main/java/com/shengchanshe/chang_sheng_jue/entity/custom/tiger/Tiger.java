package com.shengchanshe.chang_sheng_jue.entity.custom.tiger;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.ForgeEventFactory;
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
import java.util.Random;

public class Tiger extends TamableAnimal implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);//动画工厂
    protected int xpReward;
    private float hungryTime = 0;
    private double fedTime = 0;
    private static final Ingredient FOOD_ITEMS = Ingredient.of(Items.BEEF, Items.PORKCHOP, Items.CHICKEN, Items.RABBIT, Items.MUTTON, ChangShengJueItems.VENISON.get());
    public Tiger(EntityType<? extends Tiger> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
    }
    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,36D)
                .add(Attributes.ATTACK_DAMAGE, 8.0D)
                .add(Attributes.MOVEMENT_SPEED,0.5D)
                .build();
    }

    protected void registerGoals(){
        this.goalSelector.addGoal(3, new FloatGoal(this));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this,1.0D, true));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 0.8D));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new TemptGoal(this, 0.7D, FOOD_ITEMS, false));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Animal.class, 15, true, false,
                (entity) -> {
                    if (entity instanceof Tiger) {
                        if (entity.isBaby()) {
                            return false;
                        }
                        if (this.isBaby()) {
                            return false;
                        }
                    }
                    if (entity instanceof Tiger) {
                        return !this.isTame() &&
                                this.getFedTime() == 0;
                    }
                    return !this.isTame() &&
                            this.getFedTime() == 0;
                }));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 15, true, false,
                (entity) -> !this.isTame() && entity instanceof Enemy && !(entity instanceof Creeper)));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false,
                (entity) -> !isTame() && getHungryTime()==0));
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
        } else if (this.isFood(itemstack)) {
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


    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        boolean isMoving = !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F);//生物是否在行走,可以直接用event.isMoving()方法代替,这里也是为了测试,
        if (this.onGround() && isMoving) {
            if (this.isSprinting()){//跑动状态?但并没有用
                event.setAndContinue(DefaultAnimations.RUN);
            }else {
                event.setAndContinue(DefaultAnimations.WALK);//播放行走动画
            }
        }else if (this.isInWater() || !this.onGround()){//在水中或者不在地面时播放的动画
            event.setAndContinue(DefaultAnimations.WALK);
        }else {
            event.setAndContinue(DefaultAnimations.IDLE);//其他条件都不满足是为静止,播放静止动画
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean doHurtTarget(Entity p_21372_) {
        boolean result = super.doHurtTarget(p_21372_);
        return result;
    }

    public double getFedTime() {
        return fedTime;
    }

    public void setFedTime(double fedTime) {
        this.fedTime = fedTime;
    }


    @Override
    public int getExperienceReward() {
        int i = this.random.nextInt(8) + 1;
        this.xpReward = i;
        return this.xpReward;
    }


    public float getHungryTime() {
        return hungryTime;
    }

    public void setHungryTime(float hungryTime) {
        this.hungryTime = hungryTime;
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
        return ChangShengJueEntity.TIGER.get().create(level);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return FOOD_ITEMS.test(itemStack);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //依次执行
        controllerRegistrar.add(new AnimationController(this,"controller",0,this::predicate));
        controllerRegistrar.add(new AnimationController(this,"attackController",0,this::attackPredicate));
    }

    private PlayState attackPredicate(AnimationState animationEvent) {
        //攻击动画,肢体摆动并且没有播放其他动画时播放攻击动画
        if (this.swinging && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            animationEvent.getController().forceAnimationReset();//重置动画
            animationEvent.getController().setAnimation(DefaultAnimations.ATTACK_BITE);//播放攻击动画,经测试getController().setAnimation跟上面的setAndContinue没什么区别
            this.swinging =false;
        }
        return PlayState.CONTINUE;//继续播放或停止播放
    }

    //动画实例
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        int i = new Random().nextInt(2);
        switch (i){
            case 1:
                return ChangShengJueSound.TIGER_SOUND_1.get();
            default:
                return ChangShengJueSound.TIGER_SOUND.get();
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_21239_) {
        return ChangShengJueSound.TIGER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ChangShengJueSound.TIGER_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }
}
