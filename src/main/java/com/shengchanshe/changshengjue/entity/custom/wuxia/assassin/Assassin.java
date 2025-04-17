package com.shengchanshe.changshengjue.entity.custom.wuxia.assassin;

import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.changshengjue.entity.custom.goal.WuXiaAttackGoal;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.sword.SoftSword;
import com.shengchanshe.changshengjue.item.combat.throwingknives.ThrowingKnives;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.*;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.*;
import com.shengchanshe.changshengjue.kungfu.qinggong.QingGongCapability;
import com.shengchanshe.changshengjue.kungfu.qinggong.QingGongManager;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
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

import java.util.Objects;

public class Assassin extends AbstractWuXia implements GeoEntity , RangedAttackMob{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private ExternalKungFuCapability externalKungFuCapability;
    private InternalKungFuCapability internalKungFuCapability;
    private QingGongCapability qingGongCapability;
    public Assassin(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.qingGongCapability = new QingGongManager().getRandomExternalKungFuCapability(this);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,150.0D)
                .add(Attributes.ATTACK_DAMAGE,17D)
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
        this.goalSelector.addGoal(1, new Assassin.AssassinThrowingKnivesAttackGoal(this, 1.0, 40, 10.0F));
        this.goalSelector.addGoal(1, new WuXiaAttackGoal(this, 1.0F, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
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

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pDistanceFactor) {
        ThrowingKnivesEntity $$2 = new ThrowingKnivesEntity(this.level(), this, new ItemStack(ChangShengJueItems.THROWING_KNIVES.get()));
        double $$3 = pTarget.getX() - this.getX();
        double $$4 = pTarget.getY(0.3333333333333333) - $$2.getY();
        double $$5 = pTarget.getZ() - this.getZ();
        double $$6 = Math.sqrt($$3 * $$3 + $$5 * $$5);
        $$2.shoot($$3, $$4 + $$6 * 0.20000000298023224, $$5, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.DROWNED_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity($$2);
    }

    private static class AssassinThrowingKnivesAttackGoal extends RangedAttackGoal {
        private final Assassin warrior;

        public AssassinThrowingKnivesAttackGoal(RangedAttackMob pRangedAttackMob, double pSpeedModifier, int pAttackInterval, float pAttackRadius) {
            super(pRangedAttackMob, pSpeedModifier, pAttackInterval, pAttackRadius);
            this.warrior = (Assassin)pRangedAttackMob;
        }

        public boolean canUse() {
            return super.canUse() && this.warrior.getMainHandItem().is(ChangShengJueItems.THROWING_KNIVES.get());
        }

        public void start() {
            super.start();
            this.warrior.setAggressive(true);
            this.warrior.startUsingItem(InteractionHand.MAIN_HAND);
        }

        public void stop() {
            super.stop();
            this.warrior.stopUsingItem();
            this.warrior.setAggressive(false);
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.externalKungFuCapability != null){
            pCompound.putString("ExternalKungFuType",this.externalKungFuCapability.getExternalKungFuID());
            this.externalKungFuCapability.saveNBTData(pCompound); // 保存武功的具体数据，包括冷却时间
        }
        if (this.internalKungFuCapability != null){
            pCompound.putString("InternalKungFuType",this.internalKungFuCapability.getInternalKungFuID());
            this.internalKungFuCapability.saveNBTData(pCompound); // 保存武功的具体数据，包括冷却时间
        }
        if (this.qingGongCapability != null){
            pCompound.putString("QingGongType",this.qingGongCapability.getQingGongID());
            this.qingGongCapability.saveNBTData(pCompound); // 保存武功的具体数据，包括冷却时间
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("ExternalKungFuType")) {
            String kungFuType = pCompound.getString("ExternalKungFuType");
            this.externalKungFuCapability = ExternalKungFuManager.createExternalKungFuCapabilityFromTag(kungFuType);
            if (this.externalKungFuCapability != null) {
                this.externalKungFuCapability.loadNBTData(pCompound); // 读取武功的具体数据，包括冷却时间
            }
        }
        if (pCompound.contains("InternalKungFuType")) {
            String kungFuType = pCompound.getString("InternalKungFuType");
            this.internalKungFuCapability = InterfaceKungFuManager.createInterfaceKungFuCapabilityFromTag(kungFuType);
            if (this.internalKungFuCapability != null) {
                this.internalKungFuCapability.loadNBTData(pCompound); // 读取武功的具体数据，包括冷却时间
            }
        }
        if (pCompound.contains("QingGongType")) {
            String kungFuType = pCompound.getString("QingGongType");
            this.qingGongCapability = QingGongManager.createQingGongCapabilityFromTag(kungFuType);
            if (this.qingGongCapability != null) {
                this.qingGongCapability.loadNBTData(pCompound); // 读取武功的具体数据，包括冷却时间
            }
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        // 使用 KungFuManager 随机分配武功能力
        this.externalKungFuCapability = new ExternalKungFuManager().getRandomExternalKungFuCapability(this);
        this.internalKungFuCapability = new InterfaceKungFuManager().getRandomInterfaceKungFuCapability();
        if (this.externalKungFuCapability != null && this.internalKungFuCapability != null) {
            if (this.externalKungFuCapability instanceof DuguNineSwords) {
                ItemStack randomSword = SWORDS.get(random.nextInt(SWORDS.size()));
                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
                this.setItemSlot(EquipmentSlot.CHEST,
                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.DUGU_NINE_SWORDS.get()),
                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4),new ItemStack(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()))));
            }else if (this.externalKungFuCapability instanceof XuannuSwordsmanship) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.SOFT_SWORD.get()));
                this.setItemSlot(EquipmentSlot.CHEST,
                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()),
                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4),new ItemStack(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()))));
            }else if (this.externalKungFuCapability instanceof RelentlessThrowingKnives){
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.THROWING_KNIVES.get()));
                this.setItemSlot(EquipmentSlot.CHEST,
                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()),
                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4),new ItemStack(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()))));
            }else if (this.externalKungFuCapability instanceof GeShanDaNiu) {
                this.setItemSlot(EquipmentSlot.CHEST,
                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get()),
                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4),new ItemStack(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()))));
            }else if (this.externalKungFuCapability instanceof SunflowerPointCaveman) {
                this.setItemSlot(EquipmentSlot.CHEST,
                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()),
                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4),new ItemStack(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()))));
            }
        }
    }

    private ItemStack getInternalKungFuItem(ItemStack item, ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5,ItemStack item6) {
        if (this.internalKungFuCapability instanceof GoldenBellJar) {
            return this.getRandomItem(item, item1, item6);
        } else if (this.internalKungFuCapability instanceof ImmortalMiracle) {
            return this.getRandomItem(item, item2, item6);
        } else if (this.internalKungFuCapability instanceof QianKunDaNuoYi) {
            return this.getRandomItem(item, item3, item6);
        } else if (this.internalKungFuCapability instanceof TurtleBreathWork) {
            this.internalKungFuCapability.applyAttackEffect(this);
            return this.getRandomItem(item, item4, item6);
        } else if (this.internalKungFuCapability instanceof TheClassicsOfTendonChanging) {
            return this.getRandomItem(item, item5, item6);
        } else {
            return item;
        }
    }

    protected ItemStack getRandomItem(ItemStack item1, ItemStack item2,ItemStack item3) {
        int randomIndex = random.nextInt(3); // 生成0, 1或2中的一个随机数
        return switch (randomIndex) {
            case 0 -> item1;
            case 1 -> item2;
            case 2 -> item3;
            default -> null; // 防止意外情况
        };
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
             if (mainHandItem.getItem() instanceof SoftSword) {
                animationEvent.getController().forceAnimationReset();
                animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_sword3_and_spear"));
                this.setAttacking(false);
                 this.swinging = false;
            }else if (mainHandItem.getItem() instanceof ThrowingKnives){
                animationEvent.getController().forceAnimationReset();
                animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife2_and_sword2"));
                this.setAttacking(false);
                 this.swinging = false;
            }else {
                 animationEvent.getController().forceAnimationReset();
                 animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife1_and_sword1"));
                 this.setAttacking(false);
                 this.swinging = false;
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
