package com.shengchanshe.changshengjue.entity.custom.wuxia.xia;

import com.shengchanshe.changshengjue.entity.custom.goal.WuXiaAttackGoal;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.GoldenBellJar;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.ImmortalMiracle;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.QianKunDaNuoYi;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.TheClassicsOfTendonChanging;
import com.shengchanshe.changshengjue.kungfu.qinggong.QingGongCapability;
import com.shengchanshe.changshengjue.kungfu.qinggong.QingGongManager;
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
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class AbstractMingXia extends AbstractWuXia {
    protected List<ExternalKungFuCapability> externalKungFuCapabilities;
    protected List<InternalKungFuCapability> internalKungFuCapability;
    protected QingGongCapability qingGongCapability;

    protected AbstractMingXia(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,200.0D)
                .add(Attributes.ATTACK_DAMAGE,20.0D)
                .add(Attributes.MOVEMENT_SPEED,0.5D)
                .add(Attributes.KNOCKBACK_RESISTANCE,1.0).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WuXiaAttackGoal(this, 1.0F, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 0.7F));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) return;
        // 更新所有武功的冷却时间
        if (this.externalKungFuCapabilities != null) {
            for (ExternalKungFuCapability externalKungFuCapability : this.externalKungFuCapabilities) {
                if (externalKungFuCapability != null && !externalKungFuCapability.isExternalKungFuCooldownOver()) {
                    externalKungFuCapability.updateExternalKungFuCooldown();
                }
            }
        }
        if (this.internalKungFuCapability != null) {
            for (InternalKungFuCapability internalKungFuCapability1 : this.internalKungFuCapability) {
                if (internalKungFuCapability1 != null && !internalKungFuCapability1.isInternalKungFuCooldownOver()) {
                    internalKungFuCapability1.updateInternalKungFuCooldown();
                }
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
//         检查武功是否在冷却中，以及是否有75%的概率使用武功
        if (this.externalKungFuCapabilities != null && this.random.nextInt(100) < 75) {
            for (ExternalKungFuCapability externalKungFuCapability : this.externalKungFuCapabilities) {
                if (externalKungFuCapability != null && externalKungFuCapability.isExternalKungFuCooldownOver()) {
                    if (this.internalKungFuCapability instanceof TheClassicsOfTendonChanging){
                        externalKungFuCapability.applyAttackEffect(this, pEntity,2);
                        this.getMainHandItem().getItem().onUseTick(this.level(),this, this.getMainHandItem(), 0);
                    } else {
                        this.getMainHandItem().getItem().onUseTick(this.level(),this, this.getMainHandItem(), 0);
                        externalKungFuCapability.applyAttackEffect(this, pEntity,0);
                    }
                }else {
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
                break;
            }
            return true;
        } else {
            this.level().broadcastEntityEvent(this, (byte)4);
            float attackDamage = this.getAttackDamage();
            float v = (int)attackDamage > 0 ? attackDamage / 2.0F + (float)this.random.nextInt((int)attackDamage) : attackDamage;
            boolean hurt = pEntity.hurt(this.damageSources().mobAttack(this), v);
            if (hurt) {
                float f1 = this.getAttackDamage();
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
        if (this.internalKungFuCapability != null) {
            for (InternalKungFuCapability internalKungFuCapability1 : this.internalKungFuCapability) {
                if (internalKungFuCapability1 instanceof GoldenBellJar) {
                    if (internalKungFuCapability1.isInternalKungFuCooldownOver()){
                        internalKungFuCapability1.applyAttackEffect(this);
                    }
                }else if (internalKungFuCapability1 instanceof ImmortalMiracle){
                    if (internalKungFuCapability1.isInternalKungFuCooldownOver()) {
                        if (pAmount > this.getHealth()) {
                            pAmount = 0;
                            ((ImmortalMiracle) internalKungFuCapability1).applyHurtEffect(pSource, this);
                        }
                    }
                }else if (internalKungFuCapability1 instanceof QianKunDaNuoYi){
                    if (internalKungFuCapability1.isInternalKungFuCooldownOver()) {
                        ((QianKunDaNuoYi) internalKungFuCapability1).applyHurtEffect(this, pSource, pAmount);
                    }
                }
            }
        }
        return super.hurt(pSource, pAmount);
    }

    protected float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.externalKungFuCapabilities != null){
            int index = 0;
            for (ExternalKungFuCapability externalKungFuCapability : this.externalKungFuCapabilities) {
                pCompound.putString("ExternalKungFuID" + index, externalKungFuCapability.getExternalKungFuID());
                externalKungFuCapability.saveNBTData(pCompound);
                index++;
            }
        }

        if (this.internalKungFuCapability != null){
            int index = 0;
            for (InternalKungFuCapability internalKungFuCapability : this.internalKungFuCapability) {
                pCompound.putString("InternalKungFuID" + index, internalKungFuCapability.getInternalKungFuID());
                internalKungFuCapability.saveNBTData(pCompound);
                index++;
            }
        }

        if (this.qingGongCapability != null){
            pCompound.putString("QingGongType",this.qingGongCapability.getQingGongID());
            this.qingGongCapability.saveNBTData(pCompound); // 保存武功的具体数据，包括冷却时间
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.externalKungFuCapabilities = new ArrayList<>();
        int index = 0;
        while (pCompound.contains("ExternalKungFuID" + index)) {
            String externalKungFuId = pCompound.getString("ExternalKungFuID" + index);
            List<ExternalKungFuCapability> externalKungFuCapabilities = ExternalKungFuManager.createExternalKungFuCapabilitiesFromTag(externalKungFuId);
            for (ExternalKungFuCapability externalKungFuCapability : externalKungFuCapabilities) {
                externalKungFuCapability.loadNBTData(pCompound);
                this.externalKungFuCapabilities.add(externalKungFuCapability);
            }
            index++;
        }

        this.internalKungFuCapability = new ArrayList<>();
        int index1 = 0;
        while (pCompound.contains("InternalKungFuID" + index1)) {
            String internalKungFuId = pCompound.getString("InternalKungFuID" + index1);
            List<InternalKungFuCapability> internalKungFuCapabilities =
                    InterfaceKungFuManager.createInterfaceKungFuCapabilitiesFromTag(internalKungFuId);
            for (InternalKungFuCapability internalKungFuCapability : internalKungFuCapabilities) {
                internalKungFuCapability.loadNBTData(pCompound);
                this.internalKungFuCapability.add(internalKungFuCapability);
            }
            index1++;
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
        super.populateDefaultEquipmentSlots(pRandom, pDifficulty);
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

    @Override
    public void die(DamageSource pCause) {
        if (!this.level().isClientSide) {
            // 检查是否有可掉落的武功
            boolean hasExternal = externalKungFuCapabilities != null && !externalKungFuCapabilities.isEmpty();
            boolean hasInternal = internalKungFuCapability != null && !internalKungFuCapability.isEmpty();
            boolean hasQingGong = qingGongCapability != null;

            if (hasExternal || hasInternal || hasQingGong) {
                // 随机选择武功类型
                List<Integer> availableTypes = new ArrayList<>();
                if (hasExternal) availableTypes.add(0);
                if (hasInternal) availableTypes.add(1);
                if (hasQingGong) availableTypes.add(2);

                if (!availableTypes.isEmpty()) {
                    int selectedType = availableTypes.get(this.random.nextInt(availableTypes.size()));
                    ItemStack skillBook = ItemStack.EMPTY;

                    switch (selectedType) {
                        case 0 -> { // 外功
                            ExternalKungFuCapability selected = externalKungFuCapabilities.get(
                                    this.random.nextInt(externalKungFuCapabilities.size()));
                            skillBook = ExternalKungFuManager.createExternalKungFuBookItems(selected.getExternalKungFuID());
                        }
                        case 1 -> { // 内功
                            InternalKungFuCapability selected = internalKungFuCapability.get(
                                    this.random.nextInt(internalKungFuCapability.size()));
                            skillBook = InterfaceKungFuManager.createInterfaceKungFuBookItems(selected.getInternalKungFuID());
                        }
                        case 2 -> { // 轻功
                            skillBook = QingGongManager.createQingGongBookItems(this.qingGongCapability.getQingGongID());
                        }
                    }

                    if (skillBook != null && !skillBook.isEmpty()) {
                        this.spawnAtLocation(skillBook);
                    }
                }
            }
        }
        super.die(pCause);
    }
}
