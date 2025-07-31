package com.shengchanshe.chang_sheng_jue.item.combat.sword;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.XuannuSwordsmanship;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class SoftSword extends Sword implements GeoItem {

    public SoftSword() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties().durability(1200));
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.comprehendKungFu((ServerPlayer) player, XuannuSwordsmanship.KUNG_FU_ID.toString(), player);
                cap.attack((ServerPlayer) player, XuannuSwordsmanship.KUNG_FU_ID.toString(),player,entity);
            });
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if ((pPlayer.getFoodData().getFoodLevel() > 8 && pPlayer.getFoodData().getSaturationLevel() > 0) || pPlayer.getAbilities().instabuild) {
            if (!pPlayer.level().isClientSide){
                pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    if (cap.getCooldownTick((ServerPlayer) pPlayer, XuannuSwordsmanship.KUNG_FU_ID.toString()) <= 0) {
                        pPlayer.startUsingItem(pUsedHand); // 开始记录按住时间
                    }
                });
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (!pLevel.isClientSide) {
            if (pLivingEntity instanceof Player player) {
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    if (cap.getCooldownTick((ServerPlayer) player, XuannuSwordsmanship.KUNG_FU_ID.toString()) <= 0
                            && cap.getKungFuLevel(XuannuSwordsmanship.KUNG_FU_ID.toString()) >= 1) {
                        triggerAnim(player, GeoItem.getOrAssignId(pStack, (ServerLevel) pLevel),
                                "Charge", "charge");
                    }
                });
            } else {
                triggerAnim(pLivingEntity, GeoItem.getOrAssignId(pLivingEntity.getItemInHand(pLivingEntity.getUsedItemHand()), (ServerLevel) pLevel), "Attack", "attack");
            }
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseDuration) {
        if (user instanceof Player player && !world.isClientSide) {
            int usedTicks = this.getUseDuration(stack) - remainingUseDuration;
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getCooldownTick((ServerPlayer) player, XuannuSwordsmanship.KUNG_FU_ID.toString()) <= 0) {
                    // 检查是否按住至少 0.3 秒（6 tick）
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, XuannuSwordsmanship.KUNG_FU_ID.toString()) && !player.isShiftKeyDown()) {
                        cap.castKungFu(XuannuSwordsmanship.KUNG_FU_ID.toString(), player);
                        triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) world),
                                "Attack", "attack");
                    }
                }
            });
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private SoftSwordRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new SoftSwordRender();
                }
                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController(this, "idle",0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
        controllerRegistrar.add(new AnimationController<>(this, "Charge", 0, state -> PlayState.STOP)
                .triggerableAnim("charge", DefaultAnimations.ITEM_ON_USE).setAnimationSpeed(2.0));
        controllerRegistrar.add(new AnimationController<>(this, "Attack", 0, state -> PlayState.STOP)
                .triggerableAnim("attack", DefaultAnimations.ATTACK_SWING).setSoundKeyframeHandler((state) -> {
                    Player player = ClientUtils.getClientPlayer();
                    if (player != null) {
                        player.playSound(ChangShengJueSound.XUANNU_SWORDSMANSHIP_SOUND.get(), 1.0F, 1.0F);
                    }
                }));
    }
    
}
