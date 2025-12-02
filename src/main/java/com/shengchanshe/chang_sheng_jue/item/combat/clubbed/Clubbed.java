package com.shengchanshe.chang_sheng_jue.item.combat.clubbed;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.beat_dog_stick.BeatDogStickAttackEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.ShaolinStickMethod;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Clubbed extends SwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public Clubbed(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player pPlayer, Entity entity) {
        if (!pPlayer.level().isClientSide) {
            pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.comprehendKungFu((ServerPlayer) pPlayer, ShaolinStickMethod.KUNG_FU_ID.toString(), pPlayer);
                cap.attack((ServerPlayer) pPlayer,ShaolinStickMethod.KUNG_FU_ID.toString(),pPlayer,entity);
            });
            if (pPlayer.getMainHandItem().is(ChangShengJueItems.BEAT_DOG_STICK.get())){
                BeatDogStickAttackEntity beatDogStickEntity = new BeatDogStickAttackEntity(ChangShengJueEntity.BEAT_DOG_STICK_ATTACK.get(), pPlayer.level());
                beatDogStickEntity.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                beatDogStickEntity.setYRot(pPlayer.getYRot());
                pPlayer.level().addFreshEntity(beatDogStickEntity);
            }
        }
        return super.onLeftClickEntity(stack, pPlayer, entity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.getFoodData().getFoodLevel() > 8 || pPlayer.getAbilities().instabuild) {
            ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
            if (itemstack.getItem() instanceof Clubbed && !(pPlayer.getOffhandItem().getItem() instanceof ShieldItem)) {
                if (!pPlayer.level().isClientSide){
                    pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        if (cap.getCooldownTick(ShaolinStickMethod.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(ShaolinStickMethod.KUNG_FU_ID.toString()) >= 1) {
                            pPlayer.startUsingItem(pUsedHand);
                        }
                    });
                }
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (!pLevel.isClientSide) {
            if (pLivingEntity instanceof Player player) {
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    if (cap.getCooldownTick(ShaolinStickMethod.KUNG_FU_ID.toString()) <= 0
                            && cap.getKungFuLevel(ShaolinStickMethod.KUNG_FU_ID.toString()) >= 1) {
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
                if (cap.getCooldownTick(ShaolinStickMethod.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(ShaolinStickMethod.KUNG_FU_ID.toString()) >= 1) {
                    // 检查是否按住至少 0.3 秒（6 tick）
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, ShaolinStickMethod.KUNG_FU_ID.toString())) {
                        cap.castKungFu(ShaolinStickMethod.KUNG_FU_ID.toString(), player);
                        triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) world),
                                "Attack", "attack");
                    }
                }
            });
        }
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (ModList.get().isLoaded("epicfight")) {
            return Integer.MAX_VALUE;
        }
        return 72000; // 最大持续时间（实际由逻辑控制）
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.NONE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, "idle",0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
        controllerRegistrar.add(new AnimationController<>(this, "Charge", 0, state -> PlayState.STOP)
                .triggerableAnim("charge", DefaultAnimations.ITEM_ON_USE).setAnimationSpeed(2.0));
        controllerRegistrar.add(new AnimationController<>(this, "Attack", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("attack", DefaultAnimations.ATTACK_SWING).setSoundKeyframeHandler((state) -> {
                    Player player = ClientUtils.getClientPlayer();
                    if (player != null) {
                        player.playSound(ChangShengJueSound.SHAOLIN_STICK_METHOD_SOUND.get(), 1.0F, 1.0F);
                    }
                }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

}
