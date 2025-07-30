package com.shengchanshe.chang_sheng_jue.item.combat.glove;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.combat.book.HerculesBook;
import com.shengchanshe.chang_sheng_jue.martial_arts.IExternalKunfu;
import com.shengchanshe.chang_sheng_jue.martial_arts.IInteranlKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.GeShanDaNiu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.SunflowerPointCaveman;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.TurtleBreathWork;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Hercules;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class GoldThreadGlove extends SwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public GoldThreadGlove() {
        super(Tiers.IRON, 2, -2.4F, new Properties());
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pPlayer.level().isClientSide){
            pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (pPlayer.getAbilities().instabuild) {
                        if (cap.getCooldownTick((ServerPlayer) pPlayer, GeShanDaNiu.KUNG_FU_ID.toString()) <= 0
                                && cap.isStart(GeShanDaNiu.KUNG_FU_ID.toString())) {
                            // 检查是否按住至少 0.3 秒（6 tick）
                            pPlayer.startUsingItem(pUsedHand); // 开始记录按住时间
                        } else if (cap.getCooldownTick((ServerPlayer) pPlayer, SunflowerPointCaveman.KUNG_FU_ID.toString()) <= 0
                                && cap.isStart(SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        } else if (cap.getCooldownTick((ServerPlayer) pPlayer, TurtleBreathWork.KUNG_FU_ID.toString()) <= 0
                                && cap.isStart(TurtleBreathWork.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        }else if (cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) > 1
                                && cap.isStart(Hercules.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        }
                } else {
                    if ((pPlayer.getFoodData().getFoodLevel() > 8 && pPlayer.getFoodData().getSaturationLevel() > 0)) {
                        if (cap.getCooldownTick((ServerPlayer) pPlayer, GeShanDaNiu.KUNG_FU_ID.toString()) <= 0
                                && cap.isStart(GeShanDaNiu.KUNG_FU_ID.toString())) {
                            // 检查是否按住至少 0.3 秒（6 tick）
                            pPlayer.startUsingItem(pUsedHand); // 开始记录按住时间
                        } else if (cap.getCooldownTick((ServerPlayer) pPlayer, SunflowerPointCaveman.KUNG_FU_ID.toString()) <= 0
                                && cap.isStart(SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        } else if (cap.getCooldownTick((ServerPlayer) pPlayer, TurtleBreathWork.KUNG_FU_ID.toString()) <= 0
                                && cap.isStart(TurtleBreathWork.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        }else if (cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) > 1
                                && cap.isStart(Hercules.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        }
                    }else {
                        if (cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) > 1
                                && cap.isStart(Hercules.KUNG_FU_ID.toString())) {
                            pPlayer.startUsingItem(pUsedHand);
                        }
                    }
                }
            });
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseDuration) {
        if (user instanceof Player player && !world.isClientSide) {
            int usedTicks = this.getUseDuration(stack) - remainingUseDuration;
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getCooldownTick((ServerPlayer) player, GeShanDaNiu.KUNG_FU_ID.toString()) <= 0
                        && cap.isStart(GeShanDaNiu.KUNG_FU_ID.toString())) {
                    // 检查是否按住至少 0.3 秒（6 tick）
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, GeShanDaNiu.KUNG_FU_ID.toString())) {
                        cap.castKungFu(GeShanDaNiu.KUNG_FU_ID.toString(), player);
                    }
                } else if (cap.getCooldownTick((ServerPlayer) player, SunflowerPointCaveman.KUNG_FU_ID.toString()) <= 0
                        && cap.isStart(SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, SunflowerPointCaveman.KUNG_FU_ID.toString())) {
                        cap.castKungFu(SunflowerPointCaveman.KUNG_FU_ID.toString(), player);
                    }
                } else if (cap.getCooldownTick((ServerPlayer) player, TurtleBreathWork.KUNG_FU_ID.toString()) <= 0
                        && cap.isStart(TurtleBreathWork.KUNG_FU_ID.toString())) {
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, TurtleBreathWork.KUNG_FU_ID.toString())) {
                        cap.castKungFu(TurtleBreathWork.KUNG_FU_ID.toString(), player);
                    }
                } else if (cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) > 1 && cap.isStart(Hercules.KUNG_FU_ID.toString())) {
                    cap.getKungFu(Hercules.KUNG_FU_ID.toString())
                            .filter(kungFu -> kungFu instanceof IInteranlKungFu)
                            .map(kungFu -> (IInteranlKungFu) kungFu)
                            .filter(IInteranlKungFu::isReady)
                            .map(active -> {
                                active.onInteranKungFu(player.level(), player);
                                return true;
                            });
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
        return UseAnim.NONE; // 使用动画（可改为 SPEAR、CROSSBOW 等）
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (pLivingEntity instanceof Player player && !pLevel.isClientSide) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if ((cap.getCooldownTick((ServerPlayer) player, GeShanDaNiu.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(GeShanDaNiu.KUNG_FU_ID.toString()) >= 1)
                        || (cap.getCooldownTick((ServerPlayer) player, SunflowerPointCaveman.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(SunflowerPointCaveman.KUNG_FU_ID.toString()) >= 1)
                        || (cap.getCooldownTick((ServerPlayer) player, TurtleBreathWork.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(TurtleBreathWork.KUNG_FU_ID.toString()) >= 1)) {
                    triggerAnim(player, GeoItem.getOrAssignId(pStack, (ServerLevel) pLevel),
                            "Charge", "charge");
                }
            });
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }


    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GoldThreadGloveRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new GoldThreadGloveRender();
                }
                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "Charge", 0, state -> PlayState.STOP)
                .triggerableAnim("charge", DefaultAnimations.ITEM_ON_USE).setAnimationSpeed(2.0));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
