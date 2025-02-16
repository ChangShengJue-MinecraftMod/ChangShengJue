package com.shengchanshe.changshengjue.entity.combat.throwingknives;

import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
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
            Random random = new Random();

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
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();
        final float[] f = {7.0F};
        if (entity instanceof LivingEntity livingentity) {
            f[0] += EnchantmentHelper.getDamageBonus(this.throwingKnivesItem, livingentity.getMobType());
        }

        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, entity1 == null ? this : entity1);
        if (entity1 != null && !entity1.level().isClientSide && entity1 instanceof Player player){
            entity1.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                if (relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() > 0){
                    if (relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent() <= 0){
                        if (player.getFoodData().getFoodLevel() > 8){
                            if (!player.getAbilities().instabuild){
                                player.getFoodData().eat(-3, -2);// 消耗饱食度
                            }
                            f[0] = relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() <= 1 ? f[0] * 1.25F: f[0] * 1.5F;
                            relentlessThrowingKnives.setRelentlessThrowingKnivesUseCooldownPercent(!player.getAbilities().instabuild ? 160 : 0);
                            if (relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend() && relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() == 1){
                                if (relentlessThrowingKnives.getRelentlessThrowingKnivesUseCount() < 100){
                                    relentlessThrowingKnives.addRelentlessThrowingKnivesUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                    if (relentlessThrowingKnives.getRelentlessThrowingKnivesUseCount() >= 100){
                                        this.getOwner().level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                        relentlessThrowingKnives.setRelentlessThrowingKnivesParticle(true);
                                    }
                                }
                            }
                            ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                                    relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                                    relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) entity1);
                        }
                    }
                }
            });
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
