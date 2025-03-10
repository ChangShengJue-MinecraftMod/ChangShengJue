package com.shengchanshe.changshengjue.entity.villagers.warrior;

import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu.*;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.*;

public class Warrior extends AbstractGolem implements NeutralMob, RangedAttackMob {
//    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private KungFuCapability kungFuCapability; // 武夫的武功能力
    // 基础生命值设为100
    private static final float BASE_HEALTH = 100.0F;
    // 基础攻击力范围7.5至21.5
    private static final float ATTACK_DAMAGE_MIN = 7.5F;

    private static final UniformInt PERSISTENT_ANGER_TIME;
    private int remainingPersistentAngerTime;
    @Nullable
    private UUID persistentAngerTarget;

    public Warrior(EntityType<? extends Warrior> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
        // 使用 KungFuManager 随机分配武功能力
        this.kungFuCapability = new KungFuManager().getRandomKungFuCapability();
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,BASE_HEALTH)
                .add(Attributes.ATTACK_DAMAGE,ATTACK_DAMAGE_MIN)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new Warrior.WarriorThrowingKnivesAttackGoal(this, 1.0, 40, 10.0F));
        this.goalSelector.addGoal(2, new Warrior.WarriorAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new DefendVillageTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public boolean doHurtTarget(Entity pEntity) {
        if (this.kungFuCapability != null && !(this.kungFuCapability instanceof RelentlessThrowingKnives)) {
            if (this.random.nextInt(100) <= 30) {
                this.kungFuCapability.applyAttackEffect(this, pEntity);
            }else {
                this.level().broadcastEntityEvent(this, (byte)4);
                float attackDamage = this.getAttackDamage();
                float v = (int)attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage;
                boolean hurt = pEntity.hurt(this.damageSources().mobAttack(this), v);
                if (hurt) {
                    double var10000;
                    if (pEntity instanceof LivingEntity) {
                        LivingEntity pEntity1 = (LivingEntity)pEntity;
                        var10000 = pEntity1.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                    } else {
                        var10000 = 0.0;
                    }

                    double $$5 = var10000;
                    double $$6 = Math.max(0.0, 1.0 - $$5);
                    pEntity.setDeltaMovement(pEntity.getDeltaMovement().add(0.0, 0.4000000059604645 * $$6, 0.0));
                    this.doEnchantDamageEffects(this, pEntity);
                }
            }
        }else {
            this.level().broadcastEntityEvent(this, (byte)4);
            float attackDamage = this.getAttackDamage();
            float $$2 = (int)attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage;
            boolean hurt = pEntity.hurt(this.damageSources().mobAttack(this), $$2);
            if (hurt) {
                double var10000;
                if (pEntity instanceof LivingEntity) {
                    LivingEntity pEntity1 = (LivingEntity)pEntity;
                    var10000 = pEntity1.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE);
                } else {
                    var10000 = 0.0;
                }

                double var100001 = var10000;
                double max = Math.max(0.0, 1.0 - var100001);
                pEntity.setDeltaMovement(pEntity.getDeltaMovement().add(0.0, 0.4000000059604645 * max, 0.0));
                this.doEnchantDamageEffects(this, pEntity);
            }
        }
        return super.doHurtTarget(pEntity);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.random.nextInt(100) <= 30) {
            if (this.kungFuCapability instanceof GoldenBellJar) {
                this.kungFuCapability.applyAttackEffect(this, pSource.getEntity());
            }else if (this.kungFuCapability instanceof ImmortalMiracle){
                if (this.isDeadOrDying()) {
                    this.setHealth(this.getMaxHealth());
                    this.playSound( ChangShengJueSound.IMMORTAL_MIRACLE_SOUND.get(), this.getSoundVolume(), this.getVoicePitch());
                }
            }else if (this.kungFuCapability instanceof QianKunDaNuoYi){
                ((QianKunDaNuoYi) this.kungFuCapability).applyHurtEffect(this, pSource,pAmount);
            }
        }

        return super.hurt(pSource, pAmount);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.kungFuCapability != null){
            pCompound.putString("KungFuType",this.kungFuCapability.getID());
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("KungFuType")) {
            String kungFuType = pCompound.getString("KungFuType");
            this.kungFuCapability = KungFuManager.createKungFuCapabilityFromNBT(kungFuType);
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        if (this.kungFuCapability instanceof DuguNineSwords) {
            // 如果是独孤九剑，分配铁剑
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.HAN_JIAN.get()));
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.DUGU_NINE_SWORDS.get()));
        } else if (this.kungFuCapability instanceof GaoMarksmanship) {
            // 如果是高射术，分配弓
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.RED_TASSELLED_SPEAR.get()));
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.GAO_MARKSMANSHIP.get()));
        }else if (this.kungFuCapability instanceof GoldenBlackKnifeMethod) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.LARGE_KNIFE.get()));
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()));
        }else if (this.kungFuCapability instanceof ShaolinStickMethod) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.PAN_HUA_GUN.get()));
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.SHAOLIN_STICK_METHOD.get()));
        }else if (this.kungFuCapability instanceof XuannuSwordsmanship) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.SOFT_SWORD.get()));
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()));
        }else if (this.kungFuCapability instanceof RelentlessThrowingKnives) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.THROWING_KNIVES.get()));
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()));
        }else if (this.kungFuCapability instanceof GeShanDaNiu) {
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get()));
        }else if (this.kungFuCapability instanceof GoldenBellJar) {
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.GOLDEN_BELL_JAR.get()));
        }else if (this.kungFuCapability instanceof ImmortalMiracle) {
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.IMMORTAL_MIRACLE.get()));
        }else if (this.kungFuCapability instanceof QianKunDaNuoYi) {
            this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()));
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpawnGroupData $$5 = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        RandomSource $$6 = pLevel.getRandom();
        this.populateDefaultEquipmentSlots($$6, pDifficulty);
        this.populateDefaultEquipmentEnchantments($$6, pDifficulty);
        return $$5;
    }

//    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
//        if(event.isMoving()){
//            event.setAndContinue(DefaultAnimations.RUN);
//        }else {
//            event.setAndContinue(DefaultAnimations.REST);
//        }
//        return PlayState.CONTINUE;
//    }

//    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
//        controllerRegistrar.add(new AnimationController<>(this,"controller",0,this::predicate));
//    }
//
//    @Override
//    public AnimatableInstanceCache getAnimatableInstanceCache() {
//        return this.cache;
//    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pTime) {
        this.remainingPersistentAngerTime = pTime;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pTarget) {
        this.persistentAngerTarget = pTarget;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    static {
        PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
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

    private static class WarriorThrowingKnivesAttackGoal extends RangedAttackGoal {
        private final Warrior warrior;

        public WarriorThrowingKnivesAttackGoal(RangedAttackMob pRangedAttackMob, double pSpeedModifier, int pAttackInterval, float pAttackRadius) {
            super(pRangedAttackMob, pSpeedModifier, pAttackInterval, pAttackRadius);
            this.warrior = (Warrior)pRangedAttackMob;
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

    private static class WarriorAttackGoal extends MeleeAttackGoal {
        private final Warrior warrior;

        public WarriorAttackGoal(Warrior pWarrior, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
            super(pWarrior, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
            this.warrior = pWarrior;
        }

        public boolean canUse() {
            return super.canUse() && this.warrior.okTarget(this.warrior.getTarget());
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.warrior.okTarget(this.warrior.getTarget());
        }
    }

    public boolean okTarget(@Nullable LivingEntity livingEntity) {
        return livingEntity != null;
    }

    static class DefendVillageTargetGoal extends TargetGoal {
        private final Warrior warrior;
        @Nullable
        private LivingEntity potentialTarget;
        private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0);

        public DefendVillageTargetGoal(Warrior warrior) {
            super(warrior, false, true);
            this.warrior = warrior;
            this.setFlags(EnumSet.of(Flag.TARGET));
        }

        public boolean canUse() {
            AABB $$0 = this.warrior.getBoundingBox().inflate(10.0, 8.0, 10.0);
            List<? extends LivingEntity> $$1 = this.warrior.level().getNearbyEntities(Villager.class, this.attackTargeting, this.warrior, $$0);
            List<Player> $$2 = this.warrior.level().getNearbyPlayers(this.attackTargeting, this.warrior, $$0);
            Iterator var4 = $$1.iterator();

            while(var4.hasNext()) {
                LivingEntity $$3 = (LivingEntity)var4.next();
                Villager $$4 = (Villager)$$3;
                Iterator var7 = $$2.iterator();

                while(var7.hasNext()) {
                    Player $$5 = (Player)var7.next();
                    int $$6 = $$4.getPlayerReputation($$5);
                    if ($$6 <= -100) {
                        this.potentialTarget = $$5;
                    }
                }
            }

            if (this.potentialTarget == null) {
                return false;
            } else if (!(this.potentialTarget instanceof Player) || !this.potentialTarget.isSpectator() && !((Player)this.potentialTarget).isCreative()) {
                return true;
            } else {
                return false;
            }
        }

        public void start() {
            this.warrior.setTarget(this.potentialTarget);
            super.start();
        }
    }
}