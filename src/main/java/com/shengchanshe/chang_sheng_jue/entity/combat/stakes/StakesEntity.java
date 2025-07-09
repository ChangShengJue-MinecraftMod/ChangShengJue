package com.shengchanshe.chang_sheng_jue.entity.combat.stakes;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.hind.Hind;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.book.*;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Rotations;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class StakesEntity extends LivingEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final Rotations DEFAULT_HEAD_POSE = new Rotations(0.0F, 0.0F, 0.0F);
    private static final Rotations DEFAULT_BODY_POSE = new Rotations(0.0F, 0.0F, 0.0F);
    private static final Rotations DEFAULT_LEFT_ARM_POSE = new Rotations(-10.0F, 0.0F, -10.0F);
    private static final Rotations DEFAULT_RIGHT_ARM_POSE = new Rotations(-15.0F, 0.0F, 10.0F);
    private static final Rotations DEFAULT_LEFT_LEG_POSE = new Rotations(-1.0F, 0.0F, -1.0F);
    private static final Rotations DEFAULT_RIGHT_LEG_POSE = new Rotations(1.0F, 0.0F, 1.0F);
    private static final EntityDimensions MARKER_DIMENSIONS = new EntityDimensions(0.0F, 0.0F, true);
    private static final EntityDimensions BABY_DIMENSIONS;
    public static final EntityDataAccessor<Byte> DATA_CLIENT_FLAGS;
    public static final EntityDataAccessor<Rotations> DATA_HEAD_POSE;
    public static final EntityDataAccessor<Rotations> DATA_BODY_POSE;
    public static final EntityDataAccessor<Rotations> DATA_LEFT_ARM_POSE;
    public static final EntityDataAccessor<Rotations> DATA_RIGHT_ARM_POSE;
    public static final EntityDataAccessor<Rotations> DATA_LEFT_LEG_POSE;
    public static final EntityDataAccessor<Rotations> DATA_RIGHT_LEG_POSE;
    private static final Predicate<Entity> RIDABLE_MINECARTS;
    private final NonNullList<ItemStack> handItems;
    private final NonNullList<ItemStack> armorItems;
    private boolean invisible;
    public long lastHit;
    private int disabledSlots;
    private Rotations headPose;
    private Rotations bodyPose;
    private Rotations leftArmPose;
    private Rotations rightArmPose;
    private Rotations leftLegPose;
    private Rotations rightLegPose;

    public StakesEntity(EntityType<? extends StakesEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.handItems = NonNullList.withSize(2, ItemStack.EMPTY);
        this.armorItems = NonNullList.withSize(4, ItemStack.EMPTY);
        this.headPose = DEFAULT_HEAD_POSE;
        this.bodyPose = DEFAULT_BODY_POSE;
        this.leftArmPose = DEFAULT_LEFT_ARM_POSE;
        this.rightArmPose = DEFAULT_RIGHT_ARM_POSE;
        this.leftLegPose = DEFAULT_LEFT_LEG_POSE;
        this.rightLegPose = DEFAULT_RIGHT_LEG_POSE;
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

    public void refreshDimensions() {
        double d0 = this.getX();
        double d1 = this.getY();
        double d2 = this.getZ();
        super.refreshDimensions();
        this.setPos(d0, d1, d2);
    }

    private boolean hasPhysics() {
        return !this.isMarker() && !this.isNoGravity();
    }

    public boolean isEffectiveAi() {
        return super.isEffectiveAi() && this.hasPhysics();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_CLIENT_FLAGS, (byte)0);
        this.entityData.define(DATA_HEAD_POSE, DEFAULT_HEAD_POSE);
        this.entityData.define(DATA_BODY_POSE, DEFAULT_BODY_POSE);
        this.entityData.define(DATA_LEFT_ARM_POSE, DEFAULT_LEFT_ARM_POSE);
        this.entityData.define(DATA_RIGHT_ARM_POSE, DEFAULT_RIGHT_ARM_POSE);
        this.entityData.define(DATA_LEFT_LEG_POSE, DEFAULT_LEFT_LEG_POSE);
        this.entityData.define(DATA_RIGHT_LEG_POSE, DEFAULT_RIGHT_LEG_POSE);
    }

    public Iterable<ItemStack> getHandSlots() {
        return this.handItems;
    }

    public Iterable<ItemStack> getArmorSlots() {
        return this.armorItems;
    }

    public ItemStack getItemBySlot(EquipmentSlot pSlot) {
        switch (pSlot.getType()) {
            case HAND -> {
                return this.handItems.get(pSlot.getIndex());
            }
            case ARMOR -> {
                return this.armorItems.get(pSlot.getIndex());
            }
            default -> {
                return ItemStack.EMPTY;
            }
        }
    }

    public void setItemSlot(EquipmentSlot pSlot, ItemStack pStack) {
        this.verifyEquippedItem(pStack);
        switch (pSlot.getType()) {
            case HAND -> this.onEquipItem(pSlot, this.handItems.set(pSlot.getIndex(), pStack), pStack);
            case ARMOR -> this.onEquipItem(pSlot, this.armorItems.set(pSlot.getIndex(), pStack), pStack);
        }

    }

    public boolean canTakeItem(ItemStack pItemstack) {
        EquipmentSlot equipmentslot = Mob.getEquipmentSlotForItem(pItemstack);
        return this.getItemBySlot(equipmentslot).isEmpty() && !this.isDisabled(equipmentslot);
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        ListTag listtag = new ListTag();

        CompoundTag compoundtag;
        for(Iterator var3 = this.armorItems.iterator(); var3.hasNext(); listtag.add(compoundtag)) {
            ItemStack itemstack = (ItemStack)var3.next();
            compoundtag = new CompoundTag();
            if (!itemstack.isEmpty()) {
                itemstack.save(compoundtag);
            }
        }

        pCompound.put("ArmorItems", listtag);
        ListTag listtag1 = new ListTag();

        CompoundTag compoundtag1;
        for(Iterator var8 = this.handItems.iterator(); var8.hasNext(); listtag1.add(compoundtag1)) {
            ItemStack itemstack1 = (ItemStack)var8.next();
            compoundtag1 = new CompoundTag();
            if (!itemstack1.isEmpty()) {
                itemstack1.save(compoundtag1);
            }
        }

        pCompound.put("HandItems", listtag1);
        pCompound.putBoolean("Invisible", this.isInvisible());
        pCompound.putBoolean("Small", this.isSmall());
        pCompound.putBoolean("ShowArms", this.isShowArms());
        pCompound.putInt("DisabledSlots", this.disabledSlots);
        pCompound.putBoolean("NoBasePlate", this.isNoBasePlate());
        if (this.isMarker()) {
            pCompound.putBoolean("Marker", this.isMarker());
        }

        pCompound.put("Pose", this.writePose());
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        ListTag listtag1;
        int j;
        if (pCompound.contains("ArmorItems", 9)) {
            listtag1 = pCompound.getList("ArmorItems", 10);

            for(j = 0; j < this.armorItems.size(); ++j) {
                this.armorItems.set(j, ItemStack.of(listtag1.getCompound(j)));
            }
        }

        if (pCompound.contains("HandItems", 9)) {
            listtag1 = pCompound.getList("HandItems", 10);

            for(j = 0; j < this.handItems.size(); ++j) {
                this.handItems.set(j, ItemStack.of(listtag1.getCompound(j)));
            }
        }

        this.setInvisible(pCompound.getBoolean("Invisible"));
        this.setSmall(pCompound.getBoolean("Small"));
        this.setShowArms(pCompound.getBoolean("ShowArms"));
        this.disabledSlots = pCompound.getInt("DisabledSlots");
        this.setNoBasePlate(pCompound.getBoolean("NoBasePlate"));
        this.setMarker(pCompound.getBoolean("Marker"));
        this.noPhysics = !this.hasPhysics();
        CompoundTag compoundtag = pCompound.getCompound("Pose");
        this.readPose(compoundtag);
    }

    private void readPose(CompoundTag pCompound) {
        ListTag listtag = pCompound.getList("Head", 5);
        this.setHeadPose(listtag.isEmpty() ? DEFAULT_HEAD_POSE : new Rotations(listtag));
        ListTag listtag1 = pCompound.getList("Body", 5);
        this.setBodyPose(listtag1.isEmpty() ? DEFAULT_BODY_POSE : new Rotations(listtag1));
        ListTag listtag2 = pCompound.getList("LeftArm", 5);
        this.setLeftArmPose(listtag2.isEmpty() ? DEFAULT_LEFT_ARM_POSE : new Rotations(listtag2));
        ListTag listtag3 = pCompound.getList("RightArm", 5);
        this.setRightArmPose(listtag3.isEmpty() ? DEFAULT_RIGHT_ARM_POSE : new Rotations(listtag3));
        ListTag listtag4 = pCompound.getList("LeftLeg", 5);
        this.setLeftLegPose(listtag4.isEmpty() ? DEFAULT_LEFT_LEG_POSE : new Rotations(listtag4));
        ListTag listtag5 = pCompound.getList("RightLeg", 5);
        this.setRightLegPose(listtag5.isEmpty() ? DEFAULT_RIGHT_LEG_POSE : new Rotations(listtag5));
    }

    private CompoundTag writePose() {
        CompoundTag compoundtag = new CompoundTag();
        if (!DEFAULT_HEAD_POSE.equals(this.headPose)) {
            compoundtag.put("Head", this.headPose.save());
        }

        if (!DEFAULT_BODY_POSE.equals(this.bodyPose)) {
            compoundtag.put("Body", this.bodyPose.save());
        }

        if (!DEFAULT_LEFT_ARM_POSE.equals(this.leftArmPose)) {
            compoundtag.put("LeftArm", this.leftArmPose.save());
        }

        if (!DEFAULT_RIGHT_ARM_POSE.equals(this.rightArmPose)) {
            compoundtag.put("RightArm", this.rightArmPose.save());
        }

        if (!DEFAULT_LEFT_LEG_POSE.equals(this.leftLegPose)) {
            compoundtag.put("LeftLeg", this.leftLegPose.save());
        }

        if (!DEFAULT_RIGHT_LEG_POSE.equals(this.rightLegPose)) {
            compoundtag.put("RightLeg", this.rightLegPose.save());
        }

        return compoundtag;
    }

    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity pEntity) {
    }

    protected void pushEntities() {
        List<Entity> list = this.level().getEntities(this, this.getBoundingBox(), RIDABLE_MINECARTS);

        for(int i = 0; i < list.size(); ++i) {
            Entity entity = (Entity)list.get(i);
            if (this.distanceToSqr(entity) <= 0.2) {
                entity.push(this);
            }
        }

    }


    private boolean isDisabled(EquipmentSlot pSlot) {
        return (this.disabledSlots & 1 << pSlot.getFilterFlag()) != 0 || pSlot.getType() == EquipmentSlot.Type.HAND && !this.isShowArms();
    }
    public boolean hurt(DamageSource pSource, float pAmount) {
        Level level = this.level();
        if (!level.isClientSide && !this.isRemoved()) {
            Entity entity = pSource.getEntity();
            if (entity instanceof Player && entity.isShiftKeyDown()){
                this.brokenByPlayer(pSource);
                this.showBreakingParticles();
                this.kill();
                return true; // 实体对所有伤害免疫
            }else {
                level.broadcastEntityEvent(this, (byte)32); // 触发受击事件

                GoldenBellJar.comprehend(entity,level);
                QianKunDaNuoYi.comprehend(entity,level);
                ImmortalMiracle.comprehend(entity,level);
                TheClassicsOfTendonChanging.comprehend(entity,level);
                WuGangCutGui.comprehend(entity,level);
                YugongMovesMountains.comprehend(entity,level);
                Paoding.comprehend(entity,level);
                TurtleBreathWork.comprehend(entity,level);
                TreadTheSnowWithoutTrace.comprehend(entity,level);

                Player player;
                if (entity instanceof Player) {
                    player = (Player) entity;
                    GeShanDaNiu.comprehend(player,player.level(),entity);
//            GoldenBellJar.comprehend(player,player.level());
                    Hercules.comprehend(player,player.level());

//            QianKunDaNuoYi.comprehend(player,player.level());
                    SunflowerPointCaveman.comprehend(player,player.level(),entity);
                    TurtleBreathWork.comprehend(player,player.level());
                }

                return false;
            }
        } else {
            return false;
        }
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        AnimationController<StakesEntity> hurtController = new AnimationController<>(
                this,
                "stakes_hurt_controller",
                0,
                this::hurtPredicate
        );
        hurtController.triggerableAnim(
                "stakes",
                RawAnimation.begin().then("stakes", Animation.LoopType.PLAY_ONCE)
        );
        controllerRegistrar.add(hurtController);
        controllerRegistrar.add(new AnimationController(this,"stakes",0,this::hurtPredicate));

    }

    private PlayState hurtPredicate(AnimationState event) {
        return PlayState.CONTINUE;
    }

    @Override
    public void handleEntityEvent(byte pId) {
        if (pId == 32) {
            if (this.level().isClientSide) {
                // 播放自定义声音
                this.level().playLocalSound(
                        this.getX(), this.getY(), this.getZ(),
                        ChangShengJueSound.STAKES_HIT_SOUND.get(),
                        this.getSoundSource(), 0.3F, 1.0F,
                        false
                );
                this.triggerAnim("stakes_hurt_controller", "stakes");
            }
        } else {
            super.handleEntityEvent(pId);
        }
    }





    public ResourceLocation getAnimationResource(Hind entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/entity/stakes/stakes.animation.json");
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

    private void causeDamage(DamageSource pDamageSource, float pAmount) {
        float f = this.getHealth();
        f -= pAmount;
        if (f <= 0.5F) {
            this.brokenByAnything(pDamageSource);
            this.kill();
        } else {
            this.setHealth(f);
            this.gameEvent(GameEvent.ENTITY_DAMAGE, pDamageSource.getEntity());
        }

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
        this.playBrokenSound();
        this.dropAllDeathLoot(pDamageSource);

        int j;
        ItemStack itemstack1;
        for(j = 0; j < this.handItems.size(); ++j) {
            itemstack1 = (ItemStack)this.handItems.get(j);
            if (!itemstack1.isEmpty()) {
                Block.popResource(this.level(), this.blockPosition().above(), itemstack1);
                this.handItems.set(j, ItemStack.EMPTY);
            }
        }

        for(j = 0; j < this.armorItems.size(); ++j) {
            itemstack1 = (ItemStack)this.armorItems.get(j);
            if (!itemstack1.isEmpty()) {
                Block.popResource(this.level(), this.blockPosition().above(), itemstack1);
                this.armorItems.set(j, ItemStack.EMPTY);
            }
        }

    }

    private void playBrokenSound() {
        this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.ARMOR_STAND_BREAK, this.getSoundSource(), 1.0F, 1.0F);
    }

    protected float tickHeadTurn(float pYRot, float pAnimStep) {
        this.yBodyRotO = this.yRotO;
        this.yBodyRot = this.getYRot();
        return 0.0F;
    }

    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return pSize.height * (this.isBaby() ? 0.5F : 0.9F);
    }

    public double getMyRidingOffset() {
        return this.isMarker() ? 0.0 : 0.10000000149011612;
    }

    public void travel(Vec3 pTravelVector) {
        if (this.hasPhysics()) {
            super.travel(pTravelVector);
        }

    }

    public void setYBodyRot(float pOffset) {
        this.yBodyRotO = this.yRotO = pOffset;
        this.yHeadRotO = this.yHeadRot = pOffset;
    }

    public void setYHeadRot(float pRotation) {
        this.yBodyRotO = this.yRotO = pRotation;
        this.yHeadRotO = this.yHeadRot = pRotation;
    }

    public void tick() {
        super.tick();
        Rotations rotations = (Rotations)this.entityData.get(DATA_HEAD_POSE);
        if (!this.headPose.equals(rotations)) {
            this.setHeadPose(rotations);
        }

        Rotations rotations1 = (Rotations)this.entityData.get(DATA_BODY_POSE);
        if (!this.bodyPose.equals(rotations1)) {
            this.setBodyPose(rotations1);
        }

        Rotations rotations2 = (Rotations)this.entityData.get(DATA_LEFT_ARM_POSE);
        if (!this.leftArmPose.equals(rotations2)) {
            this.setLeftArmPose(rotations2);
        }

        Rotations rotations3 = (Rotations)this.entityData.get(DATA_RIGHT_ARM_POSE);
        if (!this.rightArmPose.equals(rotations3)) {
            this.setRightArmPose(rotations3);
        }

        Rotations rotations4 = (Rotations)this.entityData.get(DATA_LEFT_LEG_POSE);
        if (!this.leftLegPose.equals(rotations4)) {
            this.setLeftLegPose(rotations4);
        }

        Rotations rotations5 = (Rotations)this.entityData.get(DATA_RIGHT_LEG_POSE);
        if (!this.rightLegPose.equals(rotations5)) {
            this.setRightLegPose(rotations5);
        }

    }

    protected void updateInvisibilityStatus() {
        this.setInvisible(this.invisible);
    }

    public void setInvisible(boolean pInvisible) {
        this.invisible = pInvisible;
        super.setInvisible(pInvisible);
    }

    public boolean isBaby() {
        return this.isSmall();
    }

    public void kill() {
        this.remove(RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }

    public boolean ignoreExplosion() {
        return this.isInvisible();
    }

    public PushReaction getPistonPushReaction() {
        return this.isMarker() ? PushReaction.IGNORE : super.getPistonPushReaction();
    }

    public boolean isIgnoringBlockTriggers() {
        return this.isMarker();
    }

    private void setSmall(boolean pSmall) {
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit((Byte)this.entityData.get(DATA_CLIENT_FLAGS), 1, pSmall));
    }

    public boolean isSmall() {
        return ((Byte)this.entityData.get(DATA_CLIENT_FLAGS) & 1) != 0;
    }

    public void setShowArms(boolean pShowArms) {
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit((Byte)this.entityData.get(DATA_CLIENT_FLAGS), 4, pShowArms));
    }

    public boolean isShowArms() {
        return ((Byte)this.entityData.get(DATA_CLIENT_FLAGS) & 4) != 0;
    }

    public void setNoBasePlate(boolean pNoBasePlate) {
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit((Byte)this.entityData.get(DATA_CLIENT_FLAGS), 8, pNoBasePlate));
    }

    public boolean isNoBasePlate() {
        return ((Byte)this.entityData.get(DATA_CLIENT_FLAGS) & 8) != 0;
    }

    private void setMarker(boolean pMarker) {
        this.entityData.set(DATA_CLIENT_FLAGS, this.setBit((Byte)this.entityData.get(DATA_CLIENT_FLAGS), 16, pMarker));
    }

    public boolean isMarker() {
        return ((Byte)this.entityData.get(DATA_CLIENT_FLAGS) & 16) != 0;
    }

    private byte setBit(byte pOldBit, int pOffset, boolean pValue) {
        if (pValue) {
            pOldBit = (byte)(pOldBit | pOffset);
        } else {
            pOldBit = (byte)(pOldBit & ~pOffset);
        }

        return pOldBit;
    }

    public void setHeadPose(Rotations pHeadPose) {
        this.headPose = pHeadPose;
        this.entityData.set(DATA_HEAD_POSE, pHeadPose);
    }

    public void setBodyPose(Rotations pBodyPose) {
        this.bodyPose = pBodyPose;
        this.entityData.set(DATA_BODY_POSE, pBodyPose);
    }

    public void setLeftArmPose(Rotations pLeftArmPose) {
        this.leftArmPose = pLeftArmPose;
        this.entityData.set(DATA_LEFT_ARM_POSE, pLeftArmPose);
    }

    public void setRightArmPose(Rotations pRightArmPose) {
        this.rightArmPose = pRightArmPose;
        this.entityData.set(DATA_RIGHT_ARM_POSE, pRightArmPose);
    }

    public void setLeftLegPose(Rotations pLeftLegPose) {
        this.leftLegPose = pLeftLegPose;
        this.entityData.set(DATA_LEFT_LEG_POSE, pLeftLegPose);
    }

    public void setRightLegPose(Rotations pRightLegPose) {
        this.rightLegPose = pRightLegPose;
        this.entityData.set(DATA_RIGHT_LEG_POSE, pRightLegPose);
    }

    public Rotations getHeadPose() {
        return this.headPose;
    }

    public Rotations getBodyPose() {
        return this.bodyPose;
    }

    public Rotations getLeftArmPose() {
        return this.leftArmPose;
    }

    public Rotations getRightArmPose() {
        return this.rightArmPose;
    }

    public Rotations getLeftLegPose() {
        return this.leftLegPose;
    }

    public Rotations getRightLegPose() {
        return this.rightLegPose;
    }

    public boolean isPickable() {
        return super.isPickable() && !this.isMarker();
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

    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if (DATA_CLIENT_FLAGS.equals(pKey)) {
            this.refreshDimensions();
            this.blocksBuilding = !this.isMarker();
        }

        super.onSyncedDataUpdated(pKey);
    }

    public boolean attackable() {
        return false;
    }

    public EntityDimensions getDimensions(Pose pPose) {
        return this.getDimensionsMarker(this.isMarker());
    }

    private EntityDimensions getDimensionsMarker(boolean pIsMarker) {
        if (pIsMarker) {
            return MARKER_DIMENSIONS;
        } else {
            return this.isBaby() ? BABY_DIMENSIONS : this.getType().getDimensions();
        }
    }

    public Vec3 getLightProbePosition(float pPartialTicks) {
        if (this.isMarker()) {
            AABB aabb = this.getDimensionsMarker(false).makeBoundingBox(this.position());
            BlockPos blockpos = this.blockPosition();
            int i = Integer.MIN_VALUE;
            Iterator var5 = BlockPos.betweenClosed(BlockPos.containing(aabb.minX, aabb.minY, aabb.minZ), BlockPos.containing(aabb.maxX, aabb.maxY, aabb.maxZ)).iterator();

            while(var5.hasNext()) {
                BlockPos blockpos1 = (BlockPos)var5.next();
                int j = Math.max(this.level().getBrightness(LightLayer.BLOCK, blockpos1), this.level().getBrightness(LightLayer.SKY, blockpos1));
                if (j == 15) {
                    return Vec3.atCenterOf(blockpos1);
                }

                if (j > i) {
                    i = j;
                    blockpos = blockpos1.immutable();
                }
            }

            return Vec3.atCenterOf(blockpos);
        } else {
            return super.getLightProbePosition(pPartialTicks);
        }
    }

    public ItemStack getPickResult() {
        return new ItemStack(ChangShengJueItems.STAKES.get());
    }

    public boolean canBeSeenByAnyone() {
        return !this.isInvisible() && !this.isMarker();
    }

    static {
        BABY_DIMENSIONS = ChangShengJueEntity.STAKES.get().getDimensions().scale(0.5F);
        DATA_CLIENT_FLAGS = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.BYTE);
        DATA_HEAD_POSE = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.ROTATIONS);
        DATA_BODY_POSE = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.ROTATIONS);
        DATA_LEFT_ARM_POSE = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.ROTATIONS);
        DATA_RIGHT_ARM_POSE = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.ROTATIONS);
        DATA_LEFT_LEG_POSE = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.ROTATIONS);
        DATA_RIGHT_LEG_POSE = SynchedEntityData.defineId(StakesEntity.class, EntityDataSerializers.ROTATIONS);
        RIDABLE_MINECARTS = (p_31582_) -> p_31582_ instanceof AbstractMinecart && ((AbstractMinecart)p_31582_).canBeRidden();
    }

//    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
//        AnimationController<StakesEntity> hurtController = new AnimationController<>(
//                this,
//                "stakes_hurt_controller",
//                0,
//                state -> PlayState.CONTINUE // 确保返回 CONTINUE 以持续更新动画
//        );
//        hurtController.triggerableAnim(
//                "stakes", // 与 JSON 文件中的动画名一致
//                RawAnimation.begin().then("stakes", Animation.LoopType.PLAY_ONCE)
//        );
//        controllerRegistrar.add(hurtController); // 注册控制器
//
//    }

    public ResourceLocation getAnimationResource(StakesEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID, "animations/entity/stakes/stakes.animation.json");
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }


}
