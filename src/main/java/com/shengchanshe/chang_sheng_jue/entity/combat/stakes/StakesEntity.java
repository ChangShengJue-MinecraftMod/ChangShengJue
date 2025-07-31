package com.shengchanshe.chang_sheng_jue.entity.combat.stakes;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.book.TreadTheSnowWithoutTraceBook;
import com.shengchanshe.chang_sheng_jue.item.combat.glove.GoldThreadGlove;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.GeShanDaNiu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.SunflowerPointCaveman;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.TurtleBreathWork;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.*;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;

public class StakesEntity extends LivingEntity {
    public final AnimationState animationState = new AnimationState();

    public StakesEntity(EntityType<? extends StakesEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setMaxUpStep(0.0F);
    }

    public StakesEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ChangShengJueEntity.STAKES.get(), pLevel);
        this.setPos(pX, pY, pZ);
    }


    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1D)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1)
                .add(Attributes.FLYING_SPEED, 0.6).build();
    }


    private boolean hasPhysics() {
        return !this.isNoGravity();
    }

    public boolean isEffectiveAi() {
        return super.isEffectiveAi() && this.hasPhysics();
    }

    @Override
    public void tick() {
        super.tick();
    }

    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
    }


    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
    }

    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity pEntity) {
    }


    public boolean hurt(DamageSource pSource, float pAmount) {
        Level level = this.level();
        if (!level.isClientSide && !this.isRemoved()) {
            Entity entity = pSource.getEntity();
            if (entity instanceof Player && entity.isShiftKeyDown()){
                if (!pSource.isCreativePlayer()) {
                    this.brokenByPlayer(pSource);
                }
                this.showBreakingParticles();
                this.kill();
                return true;
            }else {
                level.broadcastEntityEvent(this, (byte)32); // 触发受击事件
//                ((ServerLevel)this.level()).sendParticles(ChangShengJueParticles.STAKES_PARTICLE.get(), this.getX(),
//                        this.getY(0.6666666666666666), this.getZ(), 10,
//                        this.getBbWidth() / 3.0F, this.getBbHeight() / 8.0F, this.getBbWidth() / 3.0F, 0.5);

                if (entity instanceof Player player) {
                    player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        if (player.getMainHandItem().isEmpty() || player.getMainHandItem().getItem() instanceof GoldThreadGlove){
                            if (cap.isStart(GeShanDaNiu.KUNG_FU_ID.toString())){
                                cap.comprehendKungFu((ServerPlayer) player, GeShanDaNiu.KUNG_FU_ID.toString(), player);
                            } else if (cap.isStart(SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                                cap.comprehendKungFu((ServerPlayer) player, SunflowerPointCaveman.KUNG_FU_ID.toString(), player);
                            } else if (cap.isStart(TurtleBreathWork.KUNG_FU_ID.toString())) {
                                cap.comprehendKungFu((ServerPlayer) player, TurtleBreathWork.KUNG_FU_ID.toString(), player);
                            }
                        }
                        if (player.getMainHandItem().isEmpty()){
                            cap.comprehendKungFu((ServerPlayer) player, GoldenBellJar.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, Hercules.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, ImmortalMiracle.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, QianKunDaNuoYi.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, TheClassicsOfTendonChanging.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, Paoding.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, WuGangCutGui.KUNG_FU_ID.toString(), player);
                            cap.comprehendKungFu((ServerPlayer) player, YugongMovesMountains.KUNG_FU_ID.toString(), player);
                        }
                    });
                }

                return false;
            }
        } else {
            this.level().playLocalSound(
                    this.getX(), this.getY(), this.getZ(),
                    ChangShengJueSound.STAKES_HIT_SOUND.get(),
                    this.getSoundSource(), 0.3F, 1.0F,
                    false
            );
            for (int i = 0; i < 10; ++i) {
                double speed = 0.05 + this.getRandom().nextDouble() * 0.1;
                double offsetY = (this.getRandom().nextDouble() + 0.5) * 0.7;

                double theta = this.getRandom().nextDouble() * 2 * Math.PI;
                double horizontalFactor = 0.7;
                double xDir = Math.cos(theta) * horizontalFactor;
                double zDir = Math.sin(theta) * horizontalFactor;

                double yDir = 0.3 + this.getRandom().nextDouble() * 0.3;

                this.level().addParticle(
                        ChangShengJueParticles.STAKES_PARTICLE.get(),
                        this.getX(),
                        this.getY() + offsetY, // 沿玩家身高随机生成
                        this.getZ(),
                        xDir * speed,
                        yDir * speed,
                        zDir * speed
                );
            }
            this.animationState.stop();
            this.animationState.animateWhen(true, this.tickCount);

            return false;
        }
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return NonNullList.withSize(2, ItemStack.EMPTY);
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot equipmentSlot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot equipmentSlot, ItemStack itemStack) {
        this.verifyEquippedItem(itemStack);
    }

    public boolean shouldRenderAtSqrDistance(double pDistance) {
        double d0 = this.getBoundingBox().getSize() * 4.0;
        if (Double.isNaN(d0) || d0 == 0.0) {
            d0 = 4.0;
        }

        d0 *= 64.0;
        return pDistance < d0 * d0;
    }

    private void showBreakingParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_PLANKS.defaultBlockState()), this.getX(), this.getY(0.6666666666666666), this.getZ(), 10, (double)(this.getBbWidth() / 4.0F), (double)(this.getBbHeight() / 4.0F), (double)(this.getBbWidth() / 4.0F), 0.05);
        }

    }

    protected float tickHeadTurn(float pYRot, float pAnimStep) {
        this.yBodyRotO = this.yRotO;
        this.yBodyRot = this.getYRot();
        return 0.0F;
    }

    private void brokenByPlayer(DamageSource pDamageSource) {
        ItemStack itemstack = new ItemStack(ChangShengJueItems.STAKES.get());
        if (this.hasCustomName()) {
            itemstack.setHoverName(this.getCustomName());
        }

        Block.popResource(this.level(), this.blockPosition(), itemstack);
        this.brokenByAnything(pDamageSource);
    }

    private void brokenByAnything(DamageSource pDamageSource) {
        this.dropAllDeathLoot(pDamageSource);
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * (this.isBaby() ? 0.5F : 0.9F);
    }

    public void setYBodyRot(float pOffset) {
        this.yBodyRotO = this.yRotO = pOffset;
        this.yHeadRotO = this.yHeadRot = pOffset;
    }

    public void setYHeadRot(float pRotation) {
        this.yBodyRotO = this.yRotO = pRotation;
        this.yHeadRotO = this.yHeadRot = pRotation;
    }


    public void kill() {
        this.remove(RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }

    public boolean ignoreExplosion() {
        return this.isInvisible();
    }

    public boolean skipAttackInteraction(Entity pEntity) {
        return pEntity instanceof Player && !this.level().mayInteract((Player)pEntity, this.blockPosition());
    }

    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

    public LivingEntity.Fallsounds getFallSounds() {
        return new LivingEntity.Fallsounds(SoundEvents.ARMOR_STAND_FALL, SoundEvents.ARMOR_STAND_FALL);
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.ARMOR_STAND_BREAK;
    }

    public void thunderHit(ServerLevel pLevel, LightningBolt pLightning) {
    }

    public boolean isAffectedByPotions() {
        return false;
    }


    public boolean attackable() {
        return false;
    }

}
