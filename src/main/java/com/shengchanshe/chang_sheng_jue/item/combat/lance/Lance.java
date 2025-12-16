package com.shengchanshe.chang_sheng_jue.item.combat.lance;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.beat_dog_stick.BeatDogStickAttackEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.DuguNineSwords;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.GaoMarksmanship;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Lance extends SwordItem implements GeoItem, Vanishable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public boolean isThrowing = false;
    public Lance(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player pPlayer, Entity entity) {
        if (!pPlayer.level().isClientSide) {
            pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.comprehendKungFu((ServerPlayer) pPlayer, GaoMarksmanship.KUNG_FU_ID.toString(), pPlayer);
                boolean attack = cap.attack((ServerPlayer) pPlayer, GaoMarksmanship.KUNG_FU_ID.toString(), pPlayer, entity);
                if (!attack) {
                    if (entity instanceof LivingEntity livingEntity) {
                        if (entity != pPlayer) {
                            if (pPlayer.level().random.nextFloat() < cap.getEffectProbability(GaoMarksmanship.KUNG_FU_ID.toString())) {
                                livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(),
                                        30, 1, false, true), pPlayer);
                            }
                        }
                    }
                }
            });
            if (pPlayer.getMainHandItem().is(ChangShengJueItems.BA_WANG_QIANG.get())){
                BeatDogStickAttackEntity beatDogStickAttack = new BeatDogStickAttackEntity(ChangShengJueEntity.BA_WANG_QIANG_ATTACK.get(), pPlayer.level());
                beatDogStickAttack.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                beatDogStickAttack.setYRot(pPlayer.getYRot());
                pPlayer.level().addFreshEntity(beatDogStickAttack);
            }
        }
        return super.onLeftClickEntity(stack, pPlayer, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (itemstack.getItem() instanceof Lance && !(pPlayer.getOffhandItem().getItem() instanceof ShieldItem)) {
            if (!pPlayer.level().isClientSide){
                pPlayer.startUsingItem(pUsedHand); // 开始记录按住时间
            }
        }
        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        if (!pLevel.isClientSide) {
            if (pLivingEntity instanceof Player player) {
                this.isThrowing = player.isShiftKeyDown() && player.isUsingItem();
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    if (cap.getCooldownTick(GaoMarksmanship.KUNG_FU_ID.toString()) <= 0
                            && cap.getKungFuLevel(GaoMarksmanship.KUNG_FU_ID.toString()) >= 1) {
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
                if (cap.getCooldownTick(GaoMarksmanship.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(GaoMarksmanship.KUNG_FU_ID.toString()) >= 1 && !player.isShiftKeyDown()
                        && (player.getFoodData().getFoodLevel() > 8)) {
                    // 检查是否按住至少 0.3 秒（6 tick）
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, GaoMarksmanship.KUNG_FU_ID.toString())) {
                        cap.castKungFu(GaoMarksmanship.KUNG_FU_ID.toString(), player);
                        triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) world),
                                "Attack", "attack");
                    }
                }
            });
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return isThrowing ? UseAnim.SPEAR : UseAnim.NONE;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        if (ModList.get().isLoaded("epicfight")) {
            return Integer.MAX_VALUE;
        }
        return 72000; // 最大持续时间（实际由逻辑控制）
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
                        player.playSound(ChangShengJueSound.GAO_MARKSMANSHIP_SOUND.get(), 1.0F, 1.0F);
                    }
                }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
