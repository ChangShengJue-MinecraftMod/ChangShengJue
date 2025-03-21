package com.shengchanshe.changshengjue.entity.custom.wuxia.piglin;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.GoldenBlackKnifeMethod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;

public class PiglinWuXia extends Piglin {
    protected static final List<ItemStack> KNIFE;
    private final ExternalKungFuCapability externalKungFuCapability;
    public PiglinWuXia(EntityType<? extends AbstractPiglin> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.externalKungFuCapability = new GoldenBlackKnifeMethod();
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,50.0D)
                .add(Attributes.ATTACK_DAMAGE,16D)
                .add(Attributes.MOVEMENT_SPEED, 0.3499999940395355).build();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.externalKungFuCapability != null && !(this.externalKungFuCapability.isExternalKungFuCooldownOver())) {
            this.externalKungFuCapability.updateExternalKungFuCooldown();
        }
    }

    protected float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (this.externalKungFuCapability != null && this.externalKungFuCapability.isExternalKungFuCooldownOver() && this.random.nextInt(100) < 75) {
            this.externalKungFuCapability.applyAttackEffect(this, pEntity,0);
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

    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        if (this.externalKungFuCapability != null) {
            if (this.externalKungFuCapability instanceof GoldenBlackKnifeMethod){
                ItemStack randomSword = KNIFE.get(random.nextInt(KNIFE.size()));
                this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
                this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()));
            }
        }
    }

    static {
        KNIFE = Arrays.asList(
                new ItemStack(ChangShengJueItems.HENG_DAO.get()),
                new ItemStack(ChangShengJueItems.LARGE_KNIFE.get())
        );
    }
}
