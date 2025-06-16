package com.shengchanshe.changshengjue.entity.custom.monkey;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.custom.tiger.Tiger;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.animation.*;

import java.util.UUID;

public class Monkey extends TamableAnimal implements GeoEntity,NeutralMob{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    //随机动画计数
    private int performing = 0;
    protected int xpReward;
    @Nullable
    private UUID persistentAngerTarget;
    public boolean attackTick;
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(Monkey.class, EntityDataSerializers.INT);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    public Monkey(EntityType<? extends Monkey> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.setTame(false);
        this.entityData.define(DATA_REMAINING_ANGER_TIME, 0);
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
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Tiger.class, 8.0F, 0.7D, 0.8D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.7D, Ingredient.of(ChangShengJueItems.BANANA.get()), false));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this,0.7D, false));
        this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 0.7, 10.0F, 2.0F, false));
//        this.goalSelector.addGoal(6, new FollowParentGoal(this, 0.7D));
        this.goalSelector.addGoal(6, new BreedGoal(this, 0.6D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, true));
        //        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, (entity) ->{
//            if (entity instanceof Player){
//                Player player = (Player) entity;
//                ItemStack mainHandItem = player.getMainHandItem();
//                ItemStack offhandItem = player.getOffhandItem();
//                if (mainHandItem.is(ChangShengJueItems.BANANA.get())|| offhandItem.is(ChangShengJueItems.BANANA.get())) {
//                    aggroTime++;
//                    if (aggroTime >= 60){
//                        this.startPersistentAngerTimer();
//                        return true;
//                    }
//                }else {
//                    return false;
//                }
//            }
//            return false;
//        }));
    }
//
//    @Override
//    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
//        return this.isBaby() ? 0.93F : 1.28F;
//    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        this.addPersistentAngerSaveData(pCompound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.addPersistentAngerSaveData(pCompound);
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
    }

    @Override
// 重写父类的方法，用于处理玩家与该实体的交互
    public InteractionResult interactAt(Player pPlayer, Vec3 pVec, InteractionHand pHand) {
    // 检查玩家手中的物品是否为空且该实体不是幼崽
        if (pPlayer.getItemInHand(pHand).isEmpty() && !this.isBaby()) {
        // 生成一个0到99之间的随机数
            int rand = random.nextInt(100);
        // 检查交互的手是否是主手
            if (pHand == InteractionHand.MAIN_HAND) {
            // 检查该实体是否已被驯服
                if (this.isTame()) {
                // 根据随机数设置不同的表演行为
                    if (rand < 30) {
                        this.performing = 1; // 设置表演行为为1
                    } else if (rand < 60) {
                        this.performing = 2; // 设置表演行为为2
                    } else if (rand < 90) {
                        this.performing = 3; // 设置表演行为为3
                    } else {
                        this.performing = 4; // 设置表演行为为4
                    }
                }
            }
        }
    // 调用父类的交互方法并返回结果
        return super.interactAt(pPlayer, pVec, pHand);
    }

    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || itemstack.is(ChangShengJueItems.BANANA.get()) && !this.isTame() && !this.isAngry();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (this.isTame()) {
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
                    this.setTarget(null);
                    return InteractionResult.SUCCESS;
                }else {
                    return interactionresult;
                }
            }
        } else if (itemstack.is(ChangShengJueItems.BANANA.get()) && !this.isAngry()) {
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                this.tame(pPlayer);
                this.navigation.stop();
                this.setTarget(null);
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
    public boolean canMate(Animal pOtherAnimal) {
        if (pOtherAnimal == this) {
            return false;
        } else if (!this.isTame()) {
            return false;
        } else if (!(pOtherAnimal instanceof Monkey)) {
            return false;
        } else {
            Monkey monkey = (Monkey) pOtherAnimal;
            if (!monkey.isTame()) {
                return false;
            } else if (monkey.isInSittingPose()) {
                return false;
            } else {
                return this.isInLove() && monkey.isInLove();
            }
        }
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (event.isMoving()) {
//            if (this.shouldFollow(Minecraft.getInstance().player)){
//                event.getController().setAnimation(RawAnimation.begin().then("jump",Animation.LoopType.LOOP));
//                return PlayState.CONTINUE;
//            }
            event.setAnimation(RawAnimation.begin().then("walk",Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        event.setAnimation(RawAnimation.begin().thenPlay("idle"));
//        if (this.shouldFollow(Minecraft.getInstance().player)){
//            event.getController().setAnimation(RawAnimation.begin().then("jump",Animation.LoopType.LOOP));
//            return PlayState.CONTINUE;
//        }
        return PlayState.CONTINUE;
    }

//    public boolean shouldFollow(LivingEntity entity) {
//        if (entity instanceof Player){
//            Player player = (Player) entity;
//            if (entity.getMainHandItem().is(ChangShengJueItems.BANANA.get()) || entity.getOffhandItem().is(ChangShengJueItems.BANANA.get())){
//                if (this.getRemainingPersistentAngerTime() != 0){
//                    this.doPlayerRide(player);
//                }
//                attackTick = true;
//            }else {
//                attackTick = false;
//            }
//        }
//        return entity.getMainHandItem().is(ChangShengJueItems.BANANA.get()) || entity.getOffhandItem().is(ChangShengJueItems.BANANA.get());
//    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isTame()) {
            Entity attacker = source.getEntity();
            if (attacker != null && attacker.getUUID().equals(this.getOwnerUUID())) {
                this.setTame(false);
                this.setOwnerUUID(null);
                this.setOrderedToSit(false);

                this.setRemainingPersistentAngerTime(0);
                this.setPersistentAngerTarget(null);

                this.reassessTameGoals();
            }
        }
        return super.hurt(source, amount);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
        if (DATA_FLAGS_ID.equals(data)) {
            this.reassessTameGoals(); 
        }
        super.onSyncedDataUpdated(data);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return super.doHurtTarget(pEntity);
    }

    @Override
    public int getExperienceReward() {
        int i = this.random.nextInt(2) + 1;
        this.xpReward = i;
        return this.xpReward;
    }

//    class MonkeyAttackGoal extends MeleeAttackGoal {
//        MonkeyAttackGoal(PathfinderMob p_27960_, double p_27961_, boolean p_27962_) {
//            super(p_27960_, p_27961_, p_27962_);
//        }
//
//        public boolean canUse() {
//            return super.canUse() && Monkey.this.isAngry();
//        }
//
//        public boolean canContinueToUse() {
//            return super.canContinueToUse() && Monkey.this.isAngry();
//        }
//    }

//    public boolean canBeControlledByRider() {
//        Entity entity = this.getControllingPassenger();
//        if (!(entity instanceof Player)) {
//            return false;
//        } else {
//            Player playerentity = (Player)entity;
//            return true;
//        }
//    }

//    protected void doPlayerRide(Player player) {
//        Entity entity = this; /* 获取你想检查的实体 */;
//
//        // 计算玩家和实体之间的距离
//        double distance = player.position().distanceTo(entity.position());
//
//        // 检查距离是否在两格范围内
//        if (distance <= 2.0D && !this.isTame()) {
//            // 实体在玩家两格范围内
//            // 在这里执行你的逻辑
//            this.startRiding(player);
//        }
//    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ChangShengJueEntity.MONKEY.get().create(level);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.getItem() == ChangShengJueItems.BANANA.get();
    }

    // 定义一个私有方法performingPredicate，用于根据performing的值设置动画状态
    private <E extends GeoAnimatable> PlayState performingPredicate(AnimationState<E> event){
        if (this.performing == 1) {
            event.setAnimation(RawAnimation.begin().thenPlay("play1"));
        } else if (this.performing == 2) {
            event.setAnimation(RawAnimation.begin().thenPlay("play2"));
        } else if (this.performing == 3) {
            event.setAnimation(RawAnimation.begin().thenPlay("play3"));
        } else if (this.performing == 4) {
            event.setAnimation(RawAnimation.begin().thenPlay("play4"));
        }
        return PlayState.CONTINUE;
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // 注册动画控制器的方法，参数是一个控制器注册器对象
        // 添加一个名为"controller"的动画控制器，使用predicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"controller",0,this::predicate));
        // 添加一个名为"performing"的动画控制器，使用performingPredicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"performing",0, this::performingPredicate).setSoundKeyframeHandler((state) -> {
            Player player = ClientUtils.getClientPlayer();
            if (player != null) {
                if (this.performing == 1) {
                    player.playSound(ChangShengJueSound.MONKEY_PLAY_1.get(), 1.0F, 1.0F);
                } else if (this.performing == 2) {
                    player.playSound(ChangShengJueSound.MONKEY_PLAY_2.get(), 1.0F, 1.0F);
                } else if (this.performing == 3) {
                    player.playSound(ChangShengJueSound.MONKEY_PLAY_3.get(), 1.0F, 1.0F);
                } else if (this.performing == 4) {
                    player.playSound(ChangShengJueSound.MONKEY_PLAY_4.get(), 1.0F, 1.0F);
                }
            }}));
        // 添加一个名为"attackController"的动画控制器，使用attackPredicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"attackController",0,this::attackPredicate));
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
        return this.entityData.get(DATA_REMAINING_ANGER_TIME);
    }

    @Override
    public void setRemainingPersistentAngerTime(int i) {
        this.entityData.set(DATA_REMAINING_ANGER_TIME, i);
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID uuid) {
        this.persistentAngerTarget = uuid;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        if (performing != 0){
            return null;
        }
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
