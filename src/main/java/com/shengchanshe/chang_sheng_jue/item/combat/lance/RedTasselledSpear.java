package com.shengchanshe.chang_sheng_jue.item.combat.lance;

import com.shengchanshe.chang_sheng_jue.entity.combat.lance.ThrownRedTasselledSpear;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;

import java.util.function.Consumer;

public class RedTasselledSpear extends Lance {

    public RedTasselledSpear() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties());
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player){
            if (player.isShiftKeyDown() && isThrowing) {
                int useDuration = this.getUseDuration(pStack) - pTimeLeft;
                if (useDuration >= 10) {
                    int riptide = EnchantmentHelper.getRiptide(pStack);
                    if (riptide <= 0 || player.isInWaterOrRain()) {
                        if (!pLevel.isClientSide) {
                            pStack.hurtAndBreak(1, player, (p_43388_) -> {
                                p_43388_.broadcastBreakEvent(pEntityLiving.getUsedItemHand());
                            });
                            if (riptide == 0) {
                                ThrownRedTasselledSpear redTasselledSpear = new ThrownRedTasselledSpear(pLevel, player, pStack);
                                redTasselledSpear.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F + (float)riptide * 0.5F, 1.0F);
                                if (player.getAbilities().instabuild) {
                                    redTasselledSpear.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                                }

                                pLevel.addFreshEntity(redTasselledSpear);
                                pLevel.playSound((Player)null, redTasselledSpear, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
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

                            pLevel.playSound(null, player, $$18, SoundSource.PLAYERS, 1.0F, 1.0F);
                        }
                    }
                }
            } else {
                super.releaseUsing(pStack, pLevel, pEntityLiving, pTimeLeft);
            }
        }
    }

    public int getEnchantmentValue() {
        return 1;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private RedTasselledSpearRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new RedTasselledSpearRender();
                }
                return renderer;
            }
        });
    }

}
