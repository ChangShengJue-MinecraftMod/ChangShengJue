package com.shengchanshe.chang_sheng_jue.item.combat.book;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.QianKunDaNuoYi;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class QianKunDaNuoYiBook extends Item {
    public QianKunDaNuoYiBook() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            pPlayer.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> cap.learnKungFu((ServerPlayer) pPlayer, QianKunDaNuoYi.KUNG_FU_ID.toString()));
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

//    public static void comprehend(Entity entity, Level level){
//        if (!level.isClientSide) {
//            if (entity instanceof Player player){
//                player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
//                    if (qianKunDaNuoYi.isQianKunDaNuoYiComprehend() && qianKunDaNuoYi.getQianKunDaNuoYiLevel() == 0) {
//                        float probability = player.getRandom().nextFloat();
//                        float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
//                        if (probability < defaultProbability) {
//                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
//                                    ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                            qianKunDaNuoYi.addQianKunDaNuoYiLevel();
//                            qianKunDaNuoYi.setQianKunDaNuoYiParticle(true);
//                        }
//                        CSJAdvanceEvent.summonChallenger(level, player);
//                        ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
//                                qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
//                                qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
//                                qianKunDaNuoYi.isQianKunDaNuoYiOff(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
//                                qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
//                                qianKunDaNuoYi.isSkillActive(),
//                                qianKunDaNuoYi.getRecordTime(),
//                                qianKunDaNuoYi.getRecordDamage(),
//                                qianKunDaNuoYi.getRecordDamageSource()), (ServerPlayer) player);
//                        if (player instanceof ServerPlayer serverPlayer) {
//                            CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
//                        }
//                    }
//                });
//            }
//        }
//    }

//    public static void onQianKunDaNuoYi(Level pLevel, LivingEntity pEntity, DamageSource source, float amount) {
//        if (pEntity instanceof Player player) {
//            player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
//                if (qianKunDaNuoYi.isQianKunDaNuoYiComprehend() && qianKunDaNuoYi.getQianKunDaNuoYiLevel() > 0) {
//                    if (qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent() <= 0) {
//                        if (player.getFoodData().getFoodLevel() > 8) {
//                            if (qianKunDaNuoYi.getQianKunDaNuoYiLevel() >= 1) {
//                                if (!player.getAbilities().instabuild) {
//                                    float healthMax = player.getMaxHealth();
//                                    float baseChance = 0.35F;
//                                    float healthBonus = (healthMax - 20.0F) * 0.02F;
//                                    float totalChance = baseChance + Math.max(0, healthBonus);
//                                    float finalChance = qianKunDaNuoYi.getQianKunDaNuoYiLevel() < 2 ? baseChance : totalChance;
//
//                                    if (player.getRandom().nextFloat() < finalChance) {
//                                        if (source.getEntity() instanceof LivingEntity livingEntity) {
//                                            qianKunDaNuoYi.setRecordDamage(amount * 1.5F);
//                                            qianKunDaNuoYi.setRecordTime(20);
//                                            qianKunDaNuoYi.setRecordDamageSource(livingEntity.getUUID());
//                                            player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
//                                                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
//                                                if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() >= 1) {
//                                                    player.getFoodData().eat(-foodLevel + 1, -1);//消耗饱食度
//                                                    if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 100) {
//                                                        theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
//                                                    }
//                                                } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() > 1) {
//                                                    player.getFoodData().eat(-foodLevel + 2, -1);//消耗饱食度
//                                                    if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 100) {
//                                                        theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
//                                                    }
//                                                } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() < 1) {
//                                                    player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
//                                                }
//                                            });
//                                        }
//                                        qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownPercent(player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ?
//                                                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax() - 30 : qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax());
//
//                                        if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())) {
//                                            player.setHealth(player.getHealth() + 1);
//                                        }
//                                        if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())) {
//                                            player.getFoodData().eat(1, 0);
//                                        }
//                                    }
//
//                                    if (qianKunDaNuoYi.getQianKunDaNuoYiUseCount() < 100){
//                                        qianKunDaNuoYi.addQianKunDaNuoYiUseCount(1);
//                                        if (qianKunDaNuoYi.getQianKunDaNuoYiUseCount() >= 100){
//                                            qianKunDaNuoYi.setQianKunDaNuoYiParticle(true);
//                                            pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
//                                                    ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
//                        qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
//                        qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
//                        qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
//                        qianKunDaNuoYi.isQianKunDaNuoYiOff(),
//                        qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
//                        qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
//                        qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
//                        qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
//                        qianKunDaNuoYi.isSkillActive(),
//                        qianKunDaNuoYi.getRecordTime(),
//                        qianKunDaNuoYi.getRecordDamage(),
//                        qianKunDaNuoYi.getRecordDamageSource()), (ServerPlayer) player);
//            });
//        }
//    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip." + ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip", Component.translatable(KungFuConfig.QIAN_KUN_DA_NUO_YI_MAX_EXP.get().toString())).withStyle(ChatFormatting.YELLOW);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.YELLOW));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
