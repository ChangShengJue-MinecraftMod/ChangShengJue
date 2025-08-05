package com.shengchanshe.chang_sheng_jue.item.combat.knife;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.tu_long_dao.TuLongDaoAttackEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.sword.Sword;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.GoldenBlackKnifeMethod;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Knife extends SwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public Knife(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                cap.comprehendKungFu((ServerPlayer) player, GoldenBlackKnifeMethod.KUNG_FU_ID.toString(), player);
                cap.attack((ServerPlayer) player,GoldenBlackKnifeMethod.KUNG_FU_ID.toString(),player,entity);
            });
            if (player.getMainHandItem().is(ChangShengJueItems.TU_LONG_DAO.get())) {
                TuLongDaoAttackEntity tuLongDaoEntity = new TuLongDaoAttackEntity(ChangShengJueEntity.TU_LONG_DAO_ATTACK.get(), player.level());
                tuLongDaoEntity.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                tuLongDaoEntity.setYRot(player.getYRot());
                player.level().addFreshEntity(tuLongDaoEntity);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    public static void onKnifeAttack(LivingDamageEvent event) {
        Level level = event.getEntity().level();
        if (!level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof LivingEntity directEntity) {
                if (directEntity.getMainHandItem().getItem() instanceof Knife) {
                    directEntity.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        float probability = directEntity.getRandom().nextFloat();
                        float defaultProbability = cap.getEffectProbability(GoldenBlackKnifeMethod.KUNG_FU_ID.toString());
                        if (probability < defaultProbability) {
                            float amount = event.getAmount();
                            event.setAmount((amount * 1.8f));
                        }
                    });
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.getFoodData().getFoodLevel() > 8 || pPlayer.getAbilities().instabuild) {
            if (!pPlayer.level().isClientSide){
                if (!(pPlayer.getOffhandItem().getItem() instanceof ShieldItem)) {
                    pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        if (cap.getCooldownTick(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()) >= 1) {
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
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getCooldownTick(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()) <= 0
                        && cap.getKungFuLevel(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()) >= 1) {
                    triggerAnim(player, GeoItem.getOrAssignId(pStack, (ServerLevel) pLevel),
                            "Charge", "charge");
                }
            });
        }
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseDuration) {
        if (user instanceof Player player && !world.isClientSide) {
            int usedTicks = this.getUseDuration(stack) - remainingUseDuration;
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getCooldownTick(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()) <= 0 && cap.getKungFuLevel(GoldenBlackKnifeMethod.KUNG_FU_ID.toString()) >= 1) {
                    // 检查是否按住至少 0.3 秒（6 tick）
                    if (usedTicks >= cap.getSwingTick((ServerPlayer) player, GoldenBlackKnifeMethod.KUNG_FU_ID.toString())) {
                        cap.castKungFu(GoldenBlackKnifeMethod.KUNG_FU_ID.toString(), player);
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
        return UseAnim.NONE; // 使用动画（可改为 SPEAR、CROSSBOW 等）
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
