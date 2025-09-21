package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia;

import com.shengchanshe.chang_sheng_jue.entity.custom.goal.WuXiaAttackGoalMonster;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.assassin.Assassin;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.bandit.Bandit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.chang_sheng_jue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu.InternalKungFuCapability;
import com.shengchanshe.chang_sheng_jue.kungfu.internalkungfu.kungfu.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

public class AbstractWuXiaMonster extends Monster {
    protected static final List<ItemStack> SWORDS;
    protected static final List<ItemStack> KNIFE;
    protected static final List<ItemStack> INTERNAL_KUNGFU;
    protected ExternalKungFuCapability externalKungFuCapability;
    protected InternalKungFuCapability internalKungFuCapability;

    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(AbstractWuXiaMonster.class, EntityDataSerializers.BOOLEAN);

    public AbstractWuXiaMonster(EntityType<? extends AbstractWuXiaMonster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(1.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WuXiaAttackGoalMonster(this, 1.0F, true));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractWuXia.class, 15, true, false, (entity) -> !(entity instanceof Assassin)));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) return;
        // 更新所有武功的冷却时间
        if (this.externalKungFuCapability != null && !(this.externalKungFuCapability.isExternalKungFuCooldownOver())) {
            this.externalKungFuCapability.updateExternalKungFuCooldown();
        }
        if (this.internalKungFuCapability != null && !(this.internalKungFuCapability.isInternalKungFuCooldownOver())) {
            this.internalKungFuCapability.updateInternalKungFuCooldown();
        }
    }

    protected float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING, false);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        // 检查武功是否在冷却中，以及是否有75%的概率使用武功
        if (this.externalKungFuCapability != null && this.externalKungFuCapability.isExternalKungFuCooldownOver() && this.random.nextInt(100) < 75) {
            if (this.internalKungFuCapability instanceof TheClassicsOfTendonChanging){
                this.externalKungFuCapability.applyAttackEffect(this, pEntity,2);
            }else {
                this.externalKungFuCapability.applyAttackEffect(this, pEntity,0);
            }
            this.getMainHandItem().getItem().onUseTick(this.level(),this, this.getMainHandItem(), 0);
            return true;
        } else {
            this.level().broadcastEntityEvent(this, (byte)4);
            float attackDamage = this.getAttackDamage();
            float v = (int)attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage;
            boolean hurt = pEntity.hurt(this.damageSources().mobAttack(this), v);
            if (hurt) {
                float f1 = (float)this.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
                if (f1 > 0.0F && pEntity instanceof LivingEntity) {
                    ((LivingEntity)pEntity).knockback(f1 * 0.5F, Mth.sin(this.getYRot() * 0.017453292F), -Mth.cos(this.getYRot() * 0.017453292F));
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
                }

                this.doEnchantDamageEffects(this, pEntity);
                this.setLastHurtMob(pEntity);
            }

            this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.0F, 1.0F);
            return hurt;
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.internalKungFuCapability != null && this.internalKungFuCapability.isInternalKungFuCooldownOver()) {
            if (this.internalKungFuCapability instanceof GoldenBellJar) {
                this.internalKungFuCapability.applyAttackEffect(this);
            }else if (this.internalKungFuCapability instanceof ImmortalMiracle){
                if (pAmount > this.getHealth()) {
                    pAmount = 0;
                    ((ImmortalMiracle) this.internalKungFuCapability).applyHurtEffect(pSource,this);
                }
            }else if (this.internalKungFuCapability instanceof QianKunDaNuoYi){
                ((QianKunDaNuoYi) this.internalKungFuCapability).applyHurtEffect(this, pSource,pAmount);
            }
        }

        return super.hurt(pSource, pAmount);
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
    }

    @Override
    public void aiStep() {
        super.aiStep();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
        // 使用 KungFuManager 随机分配武功能力
//        this.externalKungFuCapability = new ExternalKungFuManager().getRandomExternalKungFuCapability(this);
//        this.internalKungFuCapability = new InterfaceKungFuManager().getRandomInterfaceKungFuCapability();
//        if (this.externalKungFuCapability != null && this.internalKungFuCapability != null) {
//            if (this.externalKungFuCapability instanceof DuguNineSwords) {
//                ItemStack randomSword = SWORDS.get(random.nextInt(SWORDS.size()));
//                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.DUGU_NINE_SWORDS.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }else if (this.externalKungFuCapability instanceof GaoMarksmanship) {
//                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.RED_TASSELLED_SPEAR.get()));
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.GAO_MARKSMANSHIP.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }else if (this.externalKungFuCapability instanceof GoldenBlackKnifeMethod){
//                ItemStack randomSword = KNIFE.get(random.nextInt(KNIFE.size()));
//                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }else if (this.externalKungFuCapability instanceof ShaolinStickMethod) {
//                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.PAN_HUA_GUN.get()));
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.SHAOLIN_STICK_METHOD.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }else if (this.externalKungFuCapability instanceof XuannuSwordsmanship) {
//                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ChangShengJueItems.SOFT_SWORD.get()));
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }else if (this.externalKungFuCapability instanceof GeShanDaNiu) {
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }else if (this.externalKungFuCapability instanceof SunflowerPointCaveman) {
//                this.setItemSlot(EquipmentSlot.CHEST,
//                        Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()),
//                                INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
//            }
//        }
    }

    private ItemStack getInternalKungFuItem(ItemStack item, ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5) {
        if (this.internalKungFuCapability instanceof GoldenBellJar) {
            return this.getRandomItem(item, item1);
        } else if (this.internalKungFuCapability instanceof ImmortalMiracle) {
            return this.getRandomItem(item, item2);
        } else if (this.internalKungFuCapability instanceof QianKunDaNuoYi) {
            return this.getRandomItem(item, item3);
        } else if (this.internalKungFuCapability instanceof TurtleBreathWork) {
            this.internalKungFuCapability.applyAttackEffect(this);
            return this.getRandomItem(item, item4);
        } else if (this.internalKungFuCapability instanceof TheClassicsOfTendonChanging) {
            return this.getRandomItem(item, item5);
        } else {
            return item;
        }
    }

    protected ItemStack getRandomItem(ItemStack item1, ItemStack item2) {
        return random.nextBoolean() ? item1 : item2;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpawnGroupData $$5 = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        RandomSource $$6 = pLevel.getRandom();
        this.populateDefaultEquipmentSlots($$6, pDifficulty);
        this.populateDefaultEquipmentEnchantments($$6, pDifficulty);
        if (this instanceof Bandit) {
            if ($$6.nextInt(100) >= 50) {
                Horse horse = EntityType.HORSE.create(this.level());
                if (horse != null) {
                    horse.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    horse.finalizeSpawn(pLevel, pDifficulty, pReason, null, null);
                    horse.setTamed(true);
//                    AttributeInstance movementSpeedAttribute = horse.getAttribute(Attributes.MOVEMENT_SPEED);
//                    if (movementSpeedAttribute != null) {
//                        // 创建一个新的属性修饰符，提升速度
//                        AttributeModifier speedModifier = new AttributeModifier("Speed Boost", 0.15, AttributeModifier.Operation.ADDITION);
//                        movementSpeedAttribute.addPermanentModifier(speedModifier);
//                    }
                    this.level().addFreshEntity(horse); // 将马添加到世界中
                    this.startRiding(horse);
                }
            }
        }
        return $$5;
    }

    static {
        SWORDS = Arrays.asList(
                new ItemStack(ChangShengJueItems.HAN_JIAN.get()),
                new ItemStack(Items.DIAMOND_SWORD),
                new ItemStack(Items.IRON_SWORD),
                new ItemStack(Items.GOLDEN_SWORD),
                new ItemStack(Items.STONE_SWORD),
                new ItemStack(Items.WOODEN_SWORD)
        );
        INTERNAL_KUNGFU = Arrays.asList(
                new ItemStack(ChangShengJueItems.GOLDEN_BELL_JAR.get()),
                new ItemStack(ChangShengJueItems.IMMORTAL_MIRACLE.get()),
                new ItemStack(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()),
                new ItemStack(ChangShengJueItems.TURTLE_BREATH_WORK.get()),
                new ItemStack(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get())
        );
        KNIFE = Arrays.asList(
                new ItemStack(ChangShengJueItems.HENG_DAO.get()),
                new ItemStack(ChangShengJueItems.LARGE_KNIFE.get())
        );
    }
}
