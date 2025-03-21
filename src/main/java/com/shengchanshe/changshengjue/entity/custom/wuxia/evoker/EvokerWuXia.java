package com.shengchanshe.changshengjue.entity.custom.wuxia.evoker;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public class EvokerWuXia extends Evoker {
    private InternalKungFuCapability internalKungFuCapability;

    public EvokerWuXia(EntityType<? extends Evoker> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide) return;
        // 更新所有武功的冷却时间
        if (this.internalKungFuCapability != null && !(this.internalKungFuCapability.isInternalKungFuCooldownOver())) {
            this.internalKungFuCapability.updateInternalKungFuCooldown();
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
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.internalKungFuCapability = new InterfaceKungFuManager().getRandomInterfaceKungFuCapability();
        if (this.internalKungFuCapability != null) {
            if (this.internalKungFuCapability instanceof GoldenBellJar) {
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.GOLDEN_BELL_JAR.get()));
            } else if (this.internalKungFuCapability instanceof ImmortalMiracle) {
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.IMMORTAL_MIRACLE.get()));
            } else if (this.internalKungFuCapability instanceof QianKunDaNuoYi) {
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()));
            } else if (this.internalKungFuCapability instanceof TurtleBreathWork) {
                this.internalKungFuCapability.applyAttackEffect(this);
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.TURTLE_BREATH_WORK.get()));
            } else if (this.internalKungFuCapability instanceof TheClassicsOfTendonChanging) {
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()));
            }
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        RandomSource $$6 = pLevel.getRandom();
        this.populateDefaultEquipmentSlots($$6, pDifficulty);
        this.populateDefaultEquipmentEnchantments($$6, pDifficulty);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
    }

}
