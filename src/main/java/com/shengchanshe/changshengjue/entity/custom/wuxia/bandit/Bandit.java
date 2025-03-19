package com.shengchanshe.changshengjue.entity.custom.wuxia.bandit;

import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXiaMonster;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.clubbed.Clubbed;
import com.shengchanshe.changshengjue.item.combat.lance.Lance;
import com.shengchanshe.changshengjue.item.combat.sword.SoftSword;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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

import javax.annotation.Nullable;

public class Bandit extends AbstractWuXiaMonster implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected ExternalKungFuCapability externalKungFuCapability;
    public Bandit(EntityType<? extends AbstractWuXiaMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,120.0D)
                .add(Attributes.ATTACK_DAMAGE,16D)
                .add(Attributes.MOVEMENT_SPEED,0.3499999940395355).build();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        // 使用 KungFuManager 随机分配武功能力
        this.externalKungFuCapability = new ExternalKungFuManager().getRandomExternalKungFuCapability(this);
        if (this.externalKungFuCapability != null) {
            if (this.externalKungFuCapability instanceof DuguNineSwords) {
                ItemStack randomSword = SWORDS.get(random.nextInt(SWORDS.size()));
                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.DUGU_NINE_SWORDS.get())));
            }else if (this.externalKungFuCapability instanceof GaoMarksmanship) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.RED_TASSELLED_SPEAR.get()));
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.GAO_MARKSMANSHIP.get())));
            }else if (this.externalKungFuCapability instanceof GoldenBlackKnifeMethod){
                ItemStack randomSword = KNIFE.get(random.nextInt(KNIFE.size()));
                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get())));
            }else if (this.externalKungFuCapability instanceof ShaolinStickMethod) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.PAN_HUA_GUN.get()));
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.SHAOLIN_STICK_METHOD.get())));
            }else if (this.externalKungFuCapability instanceof XuannuSwordsmanship) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.SOFT_SWORD.get()));
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get())));
            }else if (this.externalKungFuCapability instanceof GeShanDaNiu) {
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get())));
            }else if (this.externalKungFuCapability instanceof SunflowerPointCaveman) {
                this.setItemSlot(EquipmentSlot.CHEST,(new ItemStack(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get())));
            }
        }
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.setAnimation(DefaultAnimations.WALK);
        } else if (this.isPassenger()){
            event.setAnimation(DefaultAnimations.SIT);
        } else {
            event.setAnimation(DefaultAnimations.IDLE);
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
        controllers.add(new AnimationController<>(this,"controller",5,this::predicate));
        controllers.add(new AnimationController<>(this,"attackController",0,this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
