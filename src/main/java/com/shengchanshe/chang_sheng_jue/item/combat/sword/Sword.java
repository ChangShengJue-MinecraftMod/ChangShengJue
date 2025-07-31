package com.shengchanshe.chang_sheng_jue.item.combat.sword;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.yi_tian_jian.YiTianJianAttackEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.DuguNineSwords;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.XuannuSwordsmanship;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Sword extends SwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public Sword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            if (!player.getMainHandItem().is(ChangShengJueItems.SOFT_SWORD.get())){
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    cap.comprehendKungFu((ServerPlayer) player, DuguNineSwords.KUNG_FU_ID.toString(), player);
                    cap.attack((ServerPlayer) player,DuguNineSwords.KUNG_FU_ID.toString(),player,entity);
                });
            }
            if (player.getMainHandItem().is(ChangShengJueItems.YI_TIAN_JIAN.get())){
                YiTianJianAttackEntity yiTianJianAttackEntity = new YiTianJianAttackEntity(ChangShengJueEntity.YI_TIAN_JIAN_ATTACK.get(), player.level());
                yiTianJianAttackEntity.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                yiTianJianAttackEntity.setYRot(player.getYRot());
                player.level().addFreshEntity(yiTianJianAttackEntity);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if ((pPlayer.getFoodData().getFoodLevel() > 8 && pPlayer.getFoodData().getSaturationLevel() > 0) || pPlayer.getAbilities().instabuild) {
           ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
            if (itemstack.getItem() instanceof Sword && itemstack.getItem() != ChangShengJueItems.SOFT_SWORD.get()) {
                if (!pPlayer.level().isClientSide){
                    pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        if (cap.getCooldownTick(DuguNineSwords.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(DuguNineSwords.KUNG_FU_ID.toString()) >= 1) {
                            // 检查是否按住至少 0.3 秒（6 tick）
                            pPlayer.startUsingItem(pUsedHand); // 开始记录按住时间
                        }
                    });
                }
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            if (!player.getMainHandItem().is(ChangShengJueItems.SOFT_SWORD.get())){
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    if (cap.getCooldownTick(DuguNineSwords.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(DuguNineSwords.KUNG_FU_ID.toString()) >= 1) {
                        triggerAnim(player, GeoItem.getOrAssignId(pStack, (ServerLevel) pLevel),
                                "Charge", "charge");
                    }
                });
            }
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseDuration) {
        if (user instanceof Player player && !world.isClientSide) {
            int usedTicks = this.getUseDuration(stack) - remainingUseDuration;
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getCooldownTick(DuguNineSwords.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(DuguNineSwords.KUNG_FU_ID.toString()) >= 1) {
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, DuguNineSwords.KUNG_FU_ID.toString())) {
                        cap.castKungFu(DuguNineSwords.KUNG_FU_ID.toString(), player);
                    }
                }
            });
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 72000; // 最大持续时间（实际由逻辑控制）
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "Charge", 0, state -> PlayState.STOP)
                .triggerableAnim("charge", DefaultAnimations.ITEM_ON_USE).setAnimationSpeed(2.0));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
