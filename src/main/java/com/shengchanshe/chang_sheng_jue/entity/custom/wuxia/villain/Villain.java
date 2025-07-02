package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.villain;

import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXiaMonster;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.kungfu.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Villain extends AbstractWuXiaMonster implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected ExternalKungFuCapability externalKungFuCapability;
    public Villain(EntityType<? extends AbstractWuXiaMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.externalKungFuCapability = new GoldenBlackKnifeMethod();
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,100.0D)
                .add(Attributes.ATTACK_DAMAGE,15D)
                .add(Attributes.MOVEMENT_SPEED,0.3499999940395355).build();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        // 使用 KungFuManager 随机分配武功能力
        if (this.externalKungFuCapability != null) {
            if (this.externalKungFuCapability instanceof GoldenBlackKnifeMethod){
                ItemStack randomSword = KNIFE.get(random.nextInt(KNIFE.size()));
                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get())));
            }
        }
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.setAnimation(DefaultAnimations.WALK);
        } else {
            event.setAnimation(DefaultAnimations.IDLE);
        }
        return PlayState.CONTINUE;
    }

    private <E extends GeoAnimatable> PlayState  attackPredicate(AnimationState<E> animationEvent) {
        if (this.isAttacking() && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            animationEvent.getController().forceAnimationReset();
            int i = this.random.nextInt(2);
            switch (i) {
                case 0 -> animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_knife1_and_sword1", Animation.LoopType.PLAY_ONCE));
                case 1 -> animationEvent.setAndContinue(RawAnimation.begin().then("attack.right_hand_knife2_and_sword2", Animation.LoopType.PLAY_ONCE));
            }
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
        return cache;
    }
}
