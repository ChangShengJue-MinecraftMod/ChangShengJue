package com.shengchanshe.changshengjue.entity.custom.wuxia.innkeeper.male;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.innkeeper.InnkeeperMenu;
import com.shengchanshe.changshengjue.entity.custom.goal.ReturnToSpawnGoal;
import com.shengchanshe.changshengjue.entity.custom.goal.WuXiaAttackGoal;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXia;
import com.shengchanshe.changshengjue.entity.custom.wuxia.AbstractWuXiaMerchant;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.clubbed.Clubbed;
import com.shengchanshe.changshengjue.item.combat.lance.Lance;
import com.shengchanshe.changshengjue.item.combat.sword.SoftSword;
import com.shengchanshe.changshengjue.world.village.WuXiaMerahantTrades;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
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
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.OptionalInt;

public class MaleInnkeeper extends AbstractWuXiaMerchant implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public MaleInnkeeper(EntityType<? extends AbstractWuXia> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,30.0D)
                .add(Attributes.ATTACK_DAMAGE,15D)
                .add(Attributes.MOVEMENT_SPEED,0.5D).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WuXiaAttackGoal(this, 1.0F, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9, 32.0F));
        this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(4, new GolemRandomStrollInVillageGoal(this, 0.6));
        this.goalSelector.addGoal(5, new ReturnToSpawnGoal(this, 0.6, 16, 100));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, 5, false, false, (livingEntity) -> livingEntity instanceof Enemy && !(livingEntity instanceof Creeper)));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, false));
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        return super.doHurtTarget(pEntity);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return super.hurt(pSource, pAmount);
    }

    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    public void openTradingScreen(Player pPlayer, Component pDisplayName, int pLevel) {
        OptionalInt present = pPlayer.openMenu(new SimpleMenuProvider((i, inventory, player) -> new InnkeeperMenu(i, inventory, this), pDisplayName));
        if (present.isPresent()) {
            MerchantOffers merchantOffers = this.getOffers();
            if (!merchantOffers.isEmpty()) {
                pPlayer.sendMerchantOffers(present.getAsInt(), merchantOffers, pLevel, this.getVillagerXp(), this.showProgressBar(), this.canRestock());
            }
        }
    }

    protected void updateTrades() {
        // 获取交易列表1和2
        VillagerTrades.ItemListing[] tradesList1 = WuXiaMerahantTrades.INNKEEPER_TRADES.get(1);
        VillagerTrades.ItemListing[] tradesList2 = WuXiaMerahantTrades.INNKEEPER_TRADES.get(2);
        // 获取交易列表3和4
        VillagerTrades.ItemListing[] tradesList3 = WuXiaMerahantTrades.INNKEEPER_TRADES.get(3);
        VillagerTrades.ItemListing[] tradesList4 = WuXiaMerahantTrades.INNKEEPER_TRADES.get(4);
        VillagerTrades.ItemListing[] tradesList5 = WuXiaMerahantTrades.INNKEEPER_TRADES.get(5);
        if (tradesList1 != null && tradesList2 != null && tradesList3 != null && tradesList4 != null) {
            MerchantOffers merchantOffers = this.getOffers();
            // 添加交易列表1中的5个交易
            this.addOffersFromItemListings(merchantOffers, tradesList1, 5);
            // 随机添加交易列表2中的一个交易
            int randomIndex2 = this.random.nextInt(tradesList2.length);
            VillagerTrades.ItemListing trade2 = tradesList2[randomIndex2];
            MerchantOffer offer2 = trade2.getOffer(this, this.random);
            if (offer2 != null) {
                merchantOffers.add(offer2);
            }
            // 添加交易列表3中的2个交易
            this.addOffersFromItemListings(merchantOffers, tradesList3, 2);
            // 添加交易列表4中的2个交易
            this.addOffersFromItemListings(merchantOffers, tradesList4, 2);
            // 添加交易列表5中的5个交易
            this.addOffersFromItemListings(merchantOffers, tradesList5, 5);
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
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 1.73F;
    }

    //    protected SoundEvent getAmbientSound() {
//        return this.isTrading() ? SoundEvents.WANDERING_TRADER_TRADE : SoundEvents.WANDERING_TRADER_AMBIENT;
//    }
//
//    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
//        return SoundEvents.WANDERING_TRADER_HURT;
//    }
//
//    protected SoundEvent getDeathSound() {
//        return SoundEvents.WANDERING_TRADER_DEATH;
//    }
//
//    protected SoundEvent getDrinkingSound(ItemStack pStack) {
//        return pStack.is(Items.MILK_BUCKET) ? SoundEvents.WANDERING_TRADER_DRINK_MILK : SoundEvents.WANDERING_TRADER_DRINK_POTION;
//    }
//
//    protected SoundEvent getTradeUpdatedSound(boolean pGetYesSound) {
//        return pGetYesSound ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
//    }
//
//    public SoundEvent getNotifyTradeSound() {
//        return SoundEvents.WANDERING_TRADER_YES;
//    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event){
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.getController().setAnimation(DefaultAnimations.WALK);
        } else {
            event.getController().setAnimation(DefaultAnimations.IDLE);
        }
        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationState animationEvent) {
        if (this.isAttacking() && animationEvent.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            animationEvent.getController().forceAnimationReset();
            ItemStack mainHandItem = this.getMainHandItem();
            if (mainHandItem.getItem() instanceof Lance || mainHandItem.getItem() instanceof SoftSword) {
                animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_sword3_and_spear", Animation.LoopType.PLAY_ONCE));
            }else if (mainHandItem.getItem() instanceof Clubbed){
                animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_knife2_and_sword2", Animation.LoopType.PLAY_ONCE));
            }else {
                int i = this.random.nextInt(2);
                switch (i) {
                    case 0 -> {
                        animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_knife1_and_sword1", Animation.LoopType.PLAY_ONCE));
                    }
                    case 1 -> {
                        animationEvent.setAnimation(RawAnimation.begin().then("attack.right_hand_knife2_and_sword2", Animation.LoopType.PLAY_ONCE));
                    }
                }
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // 注册动画控制器的方法，参数是一个控制器注册器对象
        // 添加一个名为"controller"的动画控制器，使用predicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"controller",5,this::predicate));
        // 添加一个名为"attackController"的动画控制器，使用attackPredicate方法作为动画状态判断逻辑
        controllers.add(new AnimationController<>(this,"attackController",0,this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
