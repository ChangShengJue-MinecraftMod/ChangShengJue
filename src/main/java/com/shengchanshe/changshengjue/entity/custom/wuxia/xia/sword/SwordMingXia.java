package com.shengchanshe.changshengjue.entity.custom.wuxia.xia.sword;

import com.shengchanshe.changshengjue.entity.custom.wuxia.xia.AbstractMingXia;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.changshengjue.kungfu.qinggong.QingGongManager;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SwordMingXia extends AbstractMingXia implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SwordMingXia(EntityType<? extends AbstractMingXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        this.externalKungFuCapabilities = new ExternalKungFuManager().getRandomExternalKungFuCapabilities(this);
        this.internalKungFuCapability = new InterfaceKungFuManager().getRandomInternalKungFuCapabilities();
        this.qingGongCapability = new QingGongManager().getRandomExternalKungFuCapability(this);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.YI_TIAN_JIAN.get()));
    }

    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> animationEvent) {
        if (this.isAttacking() && this.swinging && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            int i = this.random.nextInt(6);
            switch (i) {
                case 0 -> {
                    animationEvent.getController().forceAnimationReset();//重置动画
                    animationEvent.getController().setAnimation(RawAnimation.begin().thenPlay("attack.right_hand_knife1_and_sword1"));
                    this.swinging = false;
                    this.setAttacking(false);
                }
                case 1 -> {
                    animationEvent.getController().forceAnimationReset();
                    animationEvent.getController().setAnimation(RawAnimation.begin().thenPlay("attack.right_hand2_knife1_and_sword1"));
                    this.swinging = false;
                    this.setAttacking(false);
                }
                case 2 -> {
                    animationEvent.getController().forceAnimationReset();
                    animationEvent.getController().setAnimation(RawAnimation.begin().thenPlay("attack.right_hand_knife2_and_sword2"));
                    this.swinging = false;
                    this.setAttacking(false);
                }
                case 3 -> {
                    animationEvent.getController().forceAnimationReset();
                    animationEvent.getController().setAnimation(RawAnimation.begin().thenPlay("attack.right_hand2_knife2_and_sword2"));
                    this.swinging = false;
                    this.setAttacking(false);
                }
                case 4 -> {
                    animationEvent.getController().forceAnimationReset();
                    animationEvent.getController().setAnimation(RawAnimation.begin().thenPlay("attack.right_hand_sword3_and_spear"));
                    this.swinging = false;
                    this.setAttacking(false);
                }
            }
        }
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.getController().setAnimation(DefaultAnimations.WALK);
        } else {
            event.getController().setAnimation(DefaultAnimations.IDLE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller",5,this::predicate));
        controllers.add(new AnimationController<>(this,"attackController",0,this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
