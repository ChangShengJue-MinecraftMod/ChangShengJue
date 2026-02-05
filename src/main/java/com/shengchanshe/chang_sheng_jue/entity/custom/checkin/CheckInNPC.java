package com.shengchanshe.chang_sheng_jue.entity.custom.checkin;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.checkin.CheckInDataManager;
import com.shengchanshe.chang_sheng_jue.checkin.PlayerCheckInData;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.checkin.CheckInMenu;
import com.shengchanshe.chang_sheng_jue.network.packet.checkin.SyncCheckInDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * 签到NPC实体 - 云游道人
 */
public class CheckInNPC extends PathfinderMob implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Nullable
    private Player tradingPlayer;

    public CheckInNPC(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 16.0D)
                .build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.2D));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }


    /**
     * 玩家右键交互
     */
    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        if (this.isAlive()) {
            if (pHand == InteractionHand.MAIN_HAND) {
                pPlayer.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (!this.level().isClientSide && pPlayer instanceof ServerPlayer serverPlayer) {
                this.setTradingPlayer(pPlayer);

                ServerLevel serverLevel = (ServerLevel) this.level();
                CheckInDataManager manager = CheckInDataManager.get(serverLevel);
                PlayerCheckInData data = manager.getPlayerData(pPlayer.getUUID());

                if (!data.hasCheckedInToday()) {
                    int dayIndex = data.getCurrentRewardIndex();
                    int poolSize = com.shengchanshe.chang_sheng_jue.checkin.CheckInRewardConfig.getRewardListSize(dayIndex);
                    data.getTodayRandomRewardIndex(poolSize, true);
                }

                SyncCheckInDataPacket.sendToClient(serverPlayer, data);

                NetworkHooks.openScreen(
                    serverPlayer,
                    new SimpleMenuProvider(
                        CheckInMenu::new,
                        Component.translatable("gui." + ChangShengJue.MOD_ID + ".checkin")
                    ),
                    buf -> {}
                );
            }

            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        return InteractionResult.PASS;
    }

    /**
     * 设置正在交易的玩家
     */
    public void setTradingPlayer(@Nullable Player player) {
        this.tradingPlayer = player;
    }

    /**
     * 获取正在交易的玩家
     */
    @Nullable
    public Player getTradingPlayer() {
        return this.tradingPlayer;
    }

    /**
     * 检查是否正在交易
     */
    public boolean isTrading() {
        return this.tradingPlayer != null;
    }

    /**
     * 每tick更新
     */
    @Override
    public void tick() {
        super.tick();

        // 检查交易玩家是否有效
        if (!this.level().isClientSide && this.tradingPlayer != null) {
            // 如果玩家已经关闭界面或距离太远，清除交易状态
            if (this.tradingPlayer.containerMenu == this.tradingPlayer.inventoryMenu ||
                this.distanceToSqr(this.tradingPlayer) > 64.0D) {
                this.setTradingPlayer(null);
            }
        }
    }

    /**
     * 重写此方法以在交易时停止移动
     */
    @Override
    protected void customServerAiStep() {
        if (this.isTrading()) {
            // 停止移动
            this.getNavigation().stop();
            // 看向交易玩家
            if (this.tradingPlayer != null) {
                this.getLookControl().setLookAt(this.tradingPlayer, 30.0F, 30.0F);
            }
        }
        super.customServerAiStep();
    }

    @Override
    protected float getStandingEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 1.73F;
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    protected int decreaseAirSupply(int pAir) {
        return pAir;
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return false;
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.getController().setAnimation(DefaultAnimations.WALK);
        } else {
            event.getController().setAnimation(DefaultAnimations.IDLE);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
