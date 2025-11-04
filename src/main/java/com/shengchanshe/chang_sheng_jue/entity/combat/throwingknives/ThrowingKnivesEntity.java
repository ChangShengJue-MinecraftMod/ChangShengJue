package com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.FlyingDaggerPouch;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.RelentlessThrowingKnives;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Random;

public class ThrowingKnivesEntity extends AbstractArrow {
    private static final EntityDataAccessor<Byte> ID_LOYALTY = SynchedEntityData.defineId(ThrowingKnivesEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrowingKnivesEntity.class, EntityDataSerializers.BOOLEAN);
    private ItemStack throwingKnivesItem = new ItemStack(ChangShengJueItems.THROWING_KNIVES.get());
    private boolean dealtDamage;
    public int clientSideReturnTridentTickCount;
    public ThrowingKnivesEntity(EntityType<? extends ThrowingKnivesEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public ThrowingKnivesEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), pShooter, pLevel);
        this.throwingKnivesItem = pStack.copy();
        this.entityData.set(ID_LOYALTY, (byte) EnchantmentHelper.getLoyalty(pStack));
        this.entityData.set(ID_FOIL, pStack.hasFoil());
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_LOYALTY, (byte)0);
        this.entityData.define(ID_FOIL, false);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        int i = this.entityData.get(ID_LOYALTY);
        if (i > 0 && (this.dealtDamage || this.isNoPhysics()) && entity != null) {
            if (!this.isAcceptibleReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == AbstractArrow.Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }

                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 vec3 = entity.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + vec3.y * 0.015D * (double)i, this.getZ());
                if (this.level().isClientSide) {
                    this.yOld = this.getY();
                }

                double d0 = 0.05D * (double)i;
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(vec3.normalize().scale(d0)));
                if (this.clientSideReturnTridentTickCount == 0) {
                    this.playSound(SoundEvents.TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.clientSideReturnTridentTickCount;
            }
        }
        if (this.level().isClientSide && !this.inGround){
            int numParticles = 1;  // 可以根据需要调整数量
            RandomSource random = this.level().random;

            for (int j = 0; j < numParticles; ++j) {
                // 使用球坐标系生成球形范围内的粒子位置
                double radius = 0.1;
                double theta = random.nextDouble() * 2 * Math.PI;  // 0 到 2π 之间的随机角度
                double phi = random.nextDouble() * Math.PI;  // 0 到 π 之间的随机角度

                // 球坐标转换为笛卡尔坐标
                double offsetX = radius * Math.sin(phi) * Math.cos(theta);
                double offsetY = radius * Math.sin(phi) * Math.sin(theta);
                double offsetZ = radius * Math.cos(phi);

                double particleX = this.getX() + offsetX;
                double particleY = this.getY() + offsetY;  // 生成在玩家的高度
                double particleZ = this.getZ() + offsetZ;

                // 生成粒子并设置速度
                this.level().addParticle(ChangShengJueParticles.THROWING_KNIVES_PARTICLE.get(), particleX, particleY, particleZ, 0, 0, 0);
            }
        }

        super.tick();
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    @Override
    public void playerTouch(Player pEntity) {
        if (!this.level().isClientSide &&
                (this.inGround || this.isNoPhysics()) &&
                this.shakeTime <= 0 &&
                pEntity.isAlive() &&
                (this.getOwner() == null || this.getOwner().getUUID().equals(pEntity.getUUID()))) {

            // 尝试将飞刀存回飞刀囊
            boolean stored = tryStoreToPouch(pEntity, this.throwingKnivesItem);

            if (!stored && !this.level().isClientSide && (this.inGround || this.isNoPhysics()) && this.shakeTime <= 0 && this.tryPickup(pEntity)) {
                pEntity.take(this, 1);
                this.discard();
            }
        }
    }

    private boolean tryStoreToPouch(Player player, ItemStack dagger) {
        // 先检查主手和副手（优先级高）
        for (InteractionHand hand : InteractionHand.values()) {
            ItemStack stackInHand = player.getItemInHand(hand);
            if (stackInHand.getItem() instanceof FlyingDaggerPouch) {
                if (FlyingDaggerPouch.tryAddDagger(stackInHand, dagger)) {
                    this.playSound(SoundEvents.ITEM_PICKUP, 0.2F, 1.0F);
                    this.discard();
                    return true;
                }
            }
        }

        // 检查背包其他槽位
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stackInSlot = inventory.getItem(i);
            // 跳过已检查的手持槽位
            if (stackInSlot == player.getItemInHand(InteractionHand.MAIN_HAND) ||
                    stackInSlot == player.getItemInHand(InteractionHand.OFF_HAND)) {
                continue;
            }

            if (stackInSlot.getItem() instanceof FlyingDaggerPouch) {
                if (FlyingDaggerPouch.tryAddDagger(stackInSlot, dagger)) {
                    // 更新背包中的物品
                    inventory.setItem(i, stackInSlot);
                    this.playSound(SoundEvents.ITEM_PICKUP, 0.2F, 1.0F);
                    this.discard();
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        final float[] f = {4.0F};
        if (entity instanceof LivingEntity livingEntity) {
            f[0] += EnchantmentHelper.getDamageBonus(this.throwingKnivesItem, livingEntity.getMobType());
            livingEntity.invulnerableTime = 1;
        }

        Entity entity1 = this.getOwner();

        DamageSource damagesource = this.damageSources().trident(this, entity1 == null ? this : entity1);
        if (entity1 != null && !entity1.level().isClientSide && entity1 instanceof Player player){
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getKungFuLevel(RelentlessThrowingKnives.KUNG_FU_ID.toString()) > 0
                        && cap.getCooldownTick(RelentlessThrowingKnives.KUNG_FU_ID.toString()) <= 0) {
                    if ((player.getFoodData().getFoodLevel() > 8)) {
                        f[0] = f[0] * cap.getDamageFactor((ServerPlayer) player, RelentlessThrowingKnives.KUNG_FU_ID.toString());
                        if (player.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
                            player.getFoodData().eat(-1,0);
                            f[0] = f[0] + 1;
                        }
                        cap.castKungFu(RelentlessThrowingKnives.KUNG_FU_ID.toString(), player);
                    }
                }
            });
        }else if (entity1 != null && !(entity1 instanceof Player) && entity1 instanceof LivingEntity livingEntity){
            f[0] = (float) (f[0] * 1.5F + livingEntity.getAttributeValue(Attributes.ATTACK_DAMAGE));
        }
        this.dealtDamage = true;
        SoundEvent soundevent = ChangShengJueSound.THROWING_KNIVES_HIT.get();

        if (entity.hurt(damagesource, f[0])) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingentity1) {
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingentity1, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity) entity1, livingentity1);
                }

                this.doPostHurtEffects(livingentity1);
            }
        }
        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        if (this.level() instanceof ServerLevel && this.level().isThundering() && this.isChanneling()) {
            BlockPos blockpos = entity.blockPosition();
            if (this.level().canSeeSky(blockpos)) {
                LightningBolt lightningbolt = EntityType.LIGHTNING_BOLT.create(this.level());
                if (lightningbolt != null) {
                    lightningbolt.moveTo(Vec3.atBottomCenterOf(blockpos));
                    lightningbolt.setCause(entity1 instanceof ServerPlayer ? (ServerPlayer)entity1 : null);
                    this.level().addFreshEntity(lightningbolt);
                    soundevent = SoundEvents.TRIDENT_THUNDER;
                    f1 = 5.0F;
                }
            }
        }

        this.playSound(soundevent, f1, 1.0F);
    }

    public boolean isChanneling() {
        return EnchantmentHelper.hasChanneling(this.throwingKnivesItem);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return ChangShengJueSound.THROWING_KNIVES_HIT_GROUND.get();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayer) || !entity.isSpectator();
        } else {
            return false;
        }
    }
    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("ThrowingKnives", 10)) {
            this.throwingKnivesItem = ItemStack.of(pCompound.getCompound("ThrowingKnives"));
        }

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
        this.entityData.set(ID_LOYALTY, (byte)EnchantmentHelper.getLoyalty(this.throwingKnivesItem));
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("ThrowingKnives", this.throwingKnivesItem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void tickDespawn() {
        int $$0 = this.entityData.get(ID_LOYALTY);
        if (this.pickup != Pickup.ALLOWED || $$0 <= 0) {
            super.tickDespawn();
        }

    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }
    @Override
    protected ItemStack getPickupItem() {
        return this.throwingKnivesItem.copy();
    }
}
