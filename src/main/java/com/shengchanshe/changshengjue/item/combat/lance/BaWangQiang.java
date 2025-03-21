package com.shengchanshe.changshengjue.item.combat.lance;

import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.lance.ThrownBaWangQiang;
import com.shengchanshe.changshengjue.item.render.combat.lance.BaWangQiangRender;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
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

public class BaWangQiang extends Lance implements GeoItem , Vanishable{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public BaWangQiang() {
        super(Tiers.IRON, 3, -2.4F, new Properties());
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }
    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
                int useDuration = this.getUseDuration(pStack) - pTimeLeft;
                if (useDuration >= 10) {
                    int riptide = EnchantmentHelper.getRiptide(pStack);
                    if (riptide <= 0 || player.isInWaterOrRain()) {
                        if (!pLevel.isClientSide) {
                            pStack.hurtAndBreak(1, player, (p_43388_) -> {
                                p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
                            });
                            if (riptide == 0) {
                                ThrownBaWangQiang baWangQiang = new ThrownBaWangQiang(pLevel, player, pStack);
                                baWangQiang.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)riptide * 0.5F, 1.0F);
                                if (player.getAbilities().instabuild) {
                                    baWangQiang.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                                }

                                pLevel.addFreshEntity(baWangQiang);
                                pLevel.playSound((Player)null, baWangQiang, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                                if (!player.getAbilities().instabuild) {
                                    player.getInventory().removeItem(pStack);
                                }
                            }
                        }

                        player.awardStat(Stats.ITEM_USED.get(this));
                        if (riptide > 0) {
                            float yRot = player.getYRot();
                            float xRot = player.getXRot();
                            float $$10 = -Mth.sin(yRot * 0.017453292F) * Mth.cos(xRot * 0.017453292F);
                            float $$11 = -Mth.sin(xRot * 0.017453292F);
                            float $$12 = Mth.cos(yRot * 0.017453292F) * Mth.cos(xRot * 0.017453292F);
                            float $$13 = Mth.sqrt($$10 * $$10 + $$11 * $$11 + $$12 * $$12);
                            float $$14 = 3.0F * ((1.0F + (float)riptide) / 4.0F);
                            $$10 *= $$14 / $$13;
                            $$11 *= $$14 / $$13;
                            $$12 *= $$14 / $$13;
                            player.push((double)$$10, (double)$$11, (double)$$12);
                            player.startAutoSpinAttack(20);
                            if (player.onGround()) {
                                float $$15 = 1.1999999F;
                                player.move(MoverType.SELF, new Vec3(0.0, 1.1999999284744263, 0.0));
                            }

                            SoundEvent $$18;
                            if (riptide >= 3) {
                                $$18 = SoundEvents.TRIDENT_RIPTIDE_3;
                            } else if (riptide == 2) {
                                $$18 = SoundEvents.TRIDENT_RIPTIDE_2;
                            } else {
                                $$18 = SoundEvents.TRIDENT_RIPTIDE_1;
                            }

                            pLevel.playSound((Player)null, player, $$18, SoundSource.PLAYERS, 1.0F, 1.0F);
                        }
                    }
            }
        }
    }
    public int getEnchantmentValue() {
        return 1;
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() instanceof Lance) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
                        if (gaoMarksmanship.getGaoMarksmanshipLevel() >= 1 && !pPlayer.isShiftKeyDown()) {
                            triggerAnim(pPlayer, GeoItem.getOrAssignId(pPlayer.getItemInHand(pUsedHand), (ServerLevel) pLevel), "Attack", "attack");
                        }
                    });
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pLivingEntity.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() instanceof Lance) {
                triggerAnim(pLivingEntity, GeoItem.getOrAssignId(pLivingEntity.getItemInHand(pLivingEntity.getUsedItemHand()), (ServerLevel) pLevel), "Attack", "attack");
            }
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private BaWangQiangRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new BaWangQiangRender();
                }
                return renderer;
            }
        });
    }
    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.MENDING, 1);
        stack.enchant(Enchantments.SWEEPING_EDGE, 3);
        return stack;
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, "idle",0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
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
