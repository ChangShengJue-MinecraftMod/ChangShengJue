package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.clubbed;

import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.AbstractMingXia;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.chang_sheng_jue.kungfu.qinggong.QingGongManager;
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
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ClubbedMingXia extends AbstractMingXia implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ClubbedMingXia(EntityType<? extends AbstractMingXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        this.externalKungFuCapabilities = new ExternalKungFuManager().getRandomExternalKungFuCapabilities(this);
        this.internalKungFuCapability = new InterfaceKungFuManager().getRandomInternalKungFuCapabilities();
        this.qingGongCapability = new QingGongManager().getRandomExternalKungFuCapability(this);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.BEAT_DOG_STICK.get()));
    }

    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> animationEvent) {
        if (this.isAttacking() && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            animationEvent.getController().forceAnimationReset();
            int i = this.random.nextInt(3);
            switch (i) {
                case 0 -> animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_knife1_and_sword1", Animation.LoopType.PLAY_ONCE));
                case 1 -> animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand2_knife1_and_sword1", Animation.LoopType.PLAY_ONCE));
                case 2 -> animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_sword3_and_spear", Animation.LoopType.PLAY_ONCE));
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
