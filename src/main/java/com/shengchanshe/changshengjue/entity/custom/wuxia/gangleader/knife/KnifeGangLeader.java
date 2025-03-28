package com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.knife;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.changshengjue.entity.custom.goal.WuXiaAttackGoal;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXiaMerchant;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.GangleaderVariant;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuManager;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.GeShanDaNiu;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.GoldenBlackKnifeMethod;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.SunflowerPointCaveman;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InterfaceKungFuManager;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.InternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.*;
import com.shengchanshe.changshengjue.world.village.WuXiaMerahantTrades;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

public class KnifeGangLeader extends AbstractWuXiaMerchant implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private List<ExternalKungFuCapability> externalKungFuCapabilities;
    private InternalKungFuCapability internalKungFuCapability;
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(KnifeGangLeader.class, EntityDataSerializers.INT);

    public KnifeGangLeader(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,150.0D)
                .add(Attributes.ATTACK_DAMAGE,18D)
                .add(Attributes.MOVEMENT_SPEED,0.5D)
                .add(Attributes.KNOCKBACK_RESISTANCE,1.0).build();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT,0);
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
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    public void openTradingScreen(Player pPlayer, Component pDisplayName, int pLevel) {
        OptionalInt present = pPlayer.openMenu(new SimpleMenuProvider((i, inventory, player) -> new GangleaderTradingMenu(i, inventory, this), pDisplayName));
        if (present.isPresent()) {
            MerchantOffers merchantOffers = this.getOffers();
            if (!merchantOffers.isEmpty()) {
                pPlayer.sendMerchantOffers(present.getAsInt(), merchantOffers, pLevel, this.getVillagerXp(), this.showProgressBar(), this.canRestock());
            }
        }
    }

    protected void updateTrades() {
        // 获取交易列表1和2
        VillagerTrades.ItemListing[] tradesList1 = WuXiaMerahantTrades.CLUBBED_AND_LANCE_GANG_LEADER_TRADES.get(1);
        VillagerTrades.ItemListing[] tradesList2 = WuXiaMerahantTrades.CLUBBED_AND_LANCE_GANG_LEADER_TRADES.get(2);
        if (tradesList1 != null && tradesList2 != null) {
            MerchantOffers merchantOffers = this.getOffers();
            // 添加交易列表1中的5个交易
            this.addOffersFromItemListings(merchantOffers, tradesList1, 8);
            // 随机添加交易列表2中的一个交易
            this.addOffersFromItemListings(merchantOffers, tradesList2, 2);
//            int randomIndex2 = this.random.nextInt(tradesList2.length);
//            VillagerTrades.ItemListing trade2 = tradesList2[randomIndex2];
//            MerchantOffer offer2 = trade2.getOffer(this, this.random);
//            if (offer2 != null) {
//                merchantOffers.add(offer2);
//            }
        }
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemInHand = pPlayer.getItemInHand(pHand);
        if (!itemInHand.is(ChangShengJueItems.MALE_INNKEEPER_EGG.get()) && this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (pHand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return InteractionResult.sidedSuccess(this.level().isClientSide);
            } else {
                if (!this.level().isClientSide) {
                    this.startTrading(pPlayer);
                }

                return InteractionResult.sidedSuccess(this.level().isClientSide);
            }
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
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
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        // 检查武功是否在冷却中，以及是否有75%的概率使用武功
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
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.externalKungFuCapabilities = new ExternalKungFuManager().getRandomExternalKungFuCapabilities(this);
        this.internalKungFuCapability = new InterfaceKungFuManager().getRandomInterfaceKungFuCapability();
        if (this.externalKungFuCapabilities != null && this.internalKungFuCapability != null) {
            for (ExternalKungFuCapability externalKungFuCapability : this.externalKungFuCapabilities) {
                if (externalKungFuCapability != null) {
                    if (externalKungFuCapability instanceof GoldenBlackKnifeMethod) {
                        ItemStack randomSword = KNIFE.get(random.nextInt(KNIFE.size()));
                        this.setItemSlot(EquipmentSlot.MAINHAND, randomSword);
                        this.setItemSlot(EquipmentSlot.CHEST,
                                Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()),
                                        INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
                    }else if (externalKungFuCapability instanceof GeShanDaNiu) {
                        this.setItemSlot(EquipmentSlot.CHEST,
                                Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.GE_SHAN_DA_NIU.get()),
                                        INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
                    }else if (externalKungFuCapability instanceof SunflowerPointCaveman) {
                        this.setItemSlot(EquipmentSlot.CHEST,
                                Objects.requireNonNull(this.getInternalKungFuItem(new ItemStack(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()),
                                        INTERNAL_KUNGFU.get(0),INTERNAL_KUNGFU.get(1),INTERNAL_KUNGFU.get(2),INTERNAL_KUNGFU.get(3),INTERNAL_KUNGFU.get(4))));
                    }
                }
            }
        }
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

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (this.externalKungFuCapabilities != null){
            int index = 0;
            for (ExternalKungFuCapability externalKungFuCapability : this.externalKungFuCapabilities) {
                pCompound.putString("ExternalKungFuFuID" + index,externalKungFuCapability.getQingGongID());
                externalKungFuCapability.saveNBTData(pCompound);
                index++;
            }
        }
        if (this.internalKungFuCapability != null){
            pCompound.putString("InternalKungFuFuType",this.internalKungFuCapability.getInternalKungFuID());
            this.internalKungFuCapability.saveNBTData(pCompound);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.externalKungFuCapabilities = new ArrayList<>();
        int index = 0;
        while (pCompound.contains("ExternalKungFuFuID" + index)) {
            String externalKungFuId = pCompound.getString("ExternalKungFuFuID" + index);
            List<ExternalKungFuCapability> externalKungFuCapabilities = ExternalKungFuManager.createExternalKungFuCapabilitiesFromTag(externalKungFuId);
            for (ExternalKungFuCapability externalKungFuCapability : externalKungFuCapabilities) {
                externalKungFuCapability.loadNBTData(pCompound);
                this.externalKungFuCapabilities.add(externalKungFuCapability);
            }
            index++;
        }

        if (pCompound.contains("InternalKungFuFuType")) {
            String kungFuType = pCompound.getString("InternalKungFuFuType");
            this.internalKungFuCapability = InterfaceKungFuManager.createInterfaceKungFuCapabilityFromTag(kungFuType);
            if (this.internalKungFuCapability != null) {
                this.internalKungFuCapability.loadNBTData(pCompound);
            }
        }
        this.entityData.set(DATA_ID_TYPE_VARIANT, pCompound.getInt("Variant"));
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    protected int decreaseAirSupply(int pAir) {
        return pAir;
    }

    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> animationEvent) {
        if (this.isAttacking() && this.swinging){
            int i = this.random.nextInt(2);
            switch (i) {
                case 0 -> {
                    animationEvent.getController().forceAnimationReset();
                    animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife1_and_sword1"));
                    this.setAttacking(false);
                    this.swinging = false;
                }
                case 1 -> {
                    animationEvent.getController().forceAnimationReset();
                    animationEvent.setAndContinue(RawAnimation.begin().thenPlay("attack.right_hand_knife2_and_sword2"));
                    this.setAttacking(false);
                    this.swinging = false;
                }
            }

        }
        return PlayState.CONTINUE;
    }


    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.getController().setAnimation(DefaultAnimations.WALK);
        } else {
            event.getController().setAnimation(DefaultAnimations.IDLE);
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

    /**
     * 变异
     * */
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        GangleaderVariant variant = Util.getRandom(GangleaderVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public GangleaderVariant getVariant() {
        return GangleaderVariant.getById(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(GangleaderVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

}
