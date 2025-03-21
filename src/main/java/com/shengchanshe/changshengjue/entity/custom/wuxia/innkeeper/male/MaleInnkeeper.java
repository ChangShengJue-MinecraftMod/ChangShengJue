package com.shengchanshe.changshengjue.entity.custom.wuxia.innkeeper.male;

import com.shengchanshe.changshengjue.entity.custom.goal.WuXiaAttackGoal;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.item.combat.clubbed.Clubbed;
import com.shengchanshe.changshengjue.item.combat.lance.Lance;
import com.shengchanshe.changshengjue.item.combat.sword.SoftSword;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class MaleInnkeeper extends AbstractWuXia implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public MaleInnkeeper(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,30.0D)
                .add(Attributes.ATTACK_DAMAGE,15D)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    protected int decreaseAirSupply(int pAir) {
        return pAir;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WuXiaAttackGoal(this, 1.0F, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return super.doHurtTarget(pEntity);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return super.hurt(pSource, pAmount);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.getController().setAnimation(DefaultAnimations.WALK);
        } else {
            event.getController().setAnimation(DefaultAnimations.IDLE);
        }
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState animationEvent) {
        if (this.isAttacking() && this.swinging){
            ItemStack mainHandItem = this.getMainHandItem();
             if (mainHandItem.getItem() instanceof Lance || mainHandItem.getItem() instanceof SoftSword) {
                animationEvent.getController().forceAnimationReset();
                animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_sword3_and_spear"));
                this.setAttacking(false);
                 this.swinging = false;
            }else if (mainHandItem.getItem() instanceof Clubbed){
                animationEvent.getController().forceAnimationReset();
                animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife2_and_sword2"));
                this.setAttacking(false);
                 this.swinging = false;
            }else {
                 int i = this.random.nextInt(2);
                 switch (i) {
                     case 0 -> {
                         animationEvent.getController().forceAnimationReset();
                         animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife1_and_sword1"));
                         this.setAttacking(false);
                         this.swinging = false;
                     }
                     case 1 -> {
                         animationEvent.getController().forceAnimationReset();
                         animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife2_and_sword2"));
                         this.setAttacking(false);
                         this.swinging = false;
                     }
                 }

            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // 注册动画控制器的方法，参数是一个控制器注册器对象
        // 添加一个名为"controller"的动画控制器，使用predicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"controller",5,this::predicate));
        // 添加一个名为"attackController"的动画控制器，使用attackPredicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"attackController",0,this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
