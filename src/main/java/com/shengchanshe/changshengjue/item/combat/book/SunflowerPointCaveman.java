package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.effect.EffectEntityPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.hercules.HerculesPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class SunflowerPointCaveman extends Item {
    public SunflowerPointCaveman() {
        super(new Properties());
    }

    public static void comprehend(Player player, Level level, Entity entity){
        if (!level.isClientSide) {
            player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                if (sunflowerPointCaveman.isSkillActive()){
                    if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 0) {
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                        if (probability < defaultProbability) {
                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                    ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                            sunflowerPointCaveman.addSunflowerPointCavemanLevel();
                            sunflowerPointCaveman.setSunflowerPointCavemanParticle(true);
                        }
                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                sunflowerPointCaveman.isSkillActive()), (ServerPlayer) player);
                        if (player instanceof ServerPlayer serverPlayer) {
                            CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                        }
                    }else {
                        if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() > 0) {
                            LivingEntity livingEntity = (LivingEntity) entity;
                            float probability = player.getRandom().nextFloat();
                            if (probability < 0.25F) {
                                int duration = 300;
                                int level1 = 0;

                                if (livingEntity.hasEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get())) {
                                    MobEffectInstance oldEffect = livingEntity.getEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get());
                                    if (oldEffect != null) {
                                        int increment = livingEntity instanceof Zombie ? 2 : 1;
                                        level1 = Math.min(oldEffect.getAmplifier() + increment, 4);
                                    }
                                }

                                livingEntity.addEffect(new MobEffectInstance(
                                        ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), duration, level1,
                                        true,
                                        true,
                                        true
                                ), player);
                            }
                        }
                    }
                }
            });
        }
    }

    public static void onSunflowerPointCaveman(Level pLevel, LivingEntity pPlayer , LivingEntity pEntity) {
        if (pPlayer instanceof Player player) {
            player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                if (sunflowerPointCaveman.isSkillActive()) {
                    if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() > 0) {
                        if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent() <= 0) {
//                            if (player.getMainHandItem().isEmpty()) {
                                if (player.getFoodData().getFoodLevel() > 8) {
                                    if (!player.getAbilities().instabuild) {
                                        player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
                                            int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                                            if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() >= 1) {
                                                player.getFoodData().eat(-foodLevel + 1, -1);//消耗饱食度
                                                if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 100) {
                                                    theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                                                }
                                            } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() > 1) {
                                                player.getFoodData().eat(-foodLevel + 2, -1);//消耗饱食度
                                                if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 100) {
                                                    theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                                                }
                                            } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() < 1) {
                                                player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
                                            }
                                        });
                                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ?
                                                180 - 30 : 180);
                                    }
                                    float health;
                                    if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() < 2) {
                                        health = 25;
                                        if (pEntity.getHealth() < health) {
                                            pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                    ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                            pEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 25, 1, false, false), player);
                                            MobEffectInstance effectInstance = new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 25, 0, false, false);
                                            ChangShengJueMessages.sendMSGToAll(new EffectEntityPacket(pEntity.getId(), player.getId(), 0, effectInstance.getDuration()));
                                        }
                                    } else {
                                        health = 200;
                                        if (pEntity.getHealth() < health) {
                                            pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                    ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                            pEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 1, false, false), player);
                                            MobEffectInstance effectInstance = new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 0, false, false);
                                            ChangShengJueMessages.sendMSGToAll(new EffectEntityPacket(pEntity.getId(), player.getId(), 0, effectInstance.getDuration()));
                                        }
                                    }
                                    float probability = player.getRandom().nextFloat();
                                    if (probability < 0.25F) {
                                        int duration = 100;
                                        int level1 = 1;

                                        if (pEntity.hasEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get())) {
                                            MobEffectInstance oldEffect = pEntity.getEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get());
                                            if (oldEffect != null) {
                                                int increment = pEntity instanceof Zombie ? 3 : 2;
                                                level1 = Math.min((oldEffect.getAmplifier() + increment), 4);
                                            }
                                        }

                                        pEntity.addEffect(new MobEffectInstance(
                                                ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), duration, level1,
                                                true,
                                                true,
                                                true
                                        ), player);
                                    }
                                    if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())) {
                                        player.setHealth(player.getHealth() + 1);
                                    }
                                    if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())) {
                                        player.getFoodData().eat(1, 0);
                                    }
                                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCount() < 100) {
                                        sunflowerPointCaveman.addSunflowerPointCavemanUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                        if (sunflowerPointCaveman.getSunflowerPointCavemanUseCount() >= 100) {
                                            pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                    ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                            sunflowerPointCaveman.setSunflowerPointCavemanParticle(true);
                                        }
                                    }
                                    ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                            sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                            sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                            sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                            sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                            sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                            sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                            sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                            sunflowerPointCaveman.isSkillActive()), (ServerPlayer) player);
                                }
                            }
                        }
                    }
//                }
            });
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                if (!sunflowerPointCaveman.isSunflowerPointCavemanComprehend()) {
                    sunflowerPointCaveman.setSunflowerPointCavemanComprehend(true);
                    sunflowerPointCaveman.setSkillActive(true);
                    if (pPlayer instanceof ServerPlayer serverPlayer) {
                        CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                    }
                }else {
                    sunflowerPointCaveman.setSkillActive(!sunflowerPointCaveman.isSkillActive());
                }
                pPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                    if (geShanDaNiu.isSkillActive()) {
                        geShanDaNiu.setSkillActive(false);
                        ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                geShanDaNiu.getGeShanDaNiuLevel(),
                                geShanDaNiu.isGeShanDaNiuComprehend(),
                                geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                geShanDaNiu.getGeShanDaNiuToppedTick(),
                                geShanDaNiu.getGeShanDaNiuDachengTick(),
                                geShanDaNiu.isGeShanDaNiuParticle(),
                                geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                                geShanDaNiu.isSkillActive()), (ServerPlayer) pPlayer);
                    }
                });
//                pPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                    if (goldenBellJar.isSkillActive()) {
//                        goldenBellJar.setSkillActive(false);
//                        ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                                goldenBellJar.getGoldenBellJarLevel(),
//                                goldenBellJar.isGoldenBellJarComprehend(),
//                                goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                                goldenBellJar.isGoldenBellJarOff(),
//                                goldenBellJar.getGoldenBellJarToppedTick(),
//                                goldenBellJar.getGoldenBellJarDachengTick(),
//                                goldenBellJar.isGoldenBellJarParticle(),
//                                goldenBellJar.isSkillActive()), (ServerPlayer) pPlayer);
//                    }
//                });
                pPlayer.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
                    if (hercules.isSkillActive()) {
                        hercules.setSkillActive(false);
                        ChangShengJueMessages.sendToPlayer(new HerculesPacket(
                                hercules.getHerculesLevel(),
                                hercules.isHerculesComprehend(),
                                hercules.getHerculesToppedTick(),
                                hercules.getHerculesDachengTick(),
                                hercules.isHerculesParticle(), hercules.isSkillActive()), (ServerPlayer) pPlayer);
                    }
                });
//                pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//                    if (immortalMiracle.isSkillActive()) {
//                        immortalMiracle.setSkillActive(false);
//                        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
//                                immortalMiracle.getImmortalMiracleLevel(),
//                                immortalMiracle.isImmortalMiracleComprehend(),
//                                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
//                                immortalMiracle.isImmortalMiracleOff(),
//                                immortalMiracle.getImmortalMiracleToppedTick(),
//                                immortalMiracle.getImmortalMiracleDachengTick(),
//                                immortalMiracle.isImmortalMiracleParticle(),
//                                immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
//                                immortalMiracle.isSkillActive()), (ServerPlayer) pPlayer);
//                    }
//                });
//                pPlayer.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
//                    if (qianKunDaNuoYi.isSkillActive()) {
//                        qianKunDaNuoYi.setSkillActive(false);
//                        ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
//                                qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
//                                qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
//                                qianKunDaNuoYi.isQianKunDaNuoYiOff(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
//                                qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
//                                qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
//                                qianKunDaNuoYi.isSkillActive()), (ServerPlayer) pPlayer);
//                    }
//                });
                pPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                    if (turtleBreathWork.isSkillActive()){
                        turtleBreathWork.setSkillActive(false);
                        ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                turtleBreathWork.getTurtleBreathWorkLevel(),
                                turtleBreathWork.isTurtleBreathWorkComprehend(),
                                turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                turtleBreathWork.isTurtleBreathWorkOff(),
                                turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                turtleBreathWork.isTurtleBreathWorkParticle(),
                                turtleBreathWork.isSkillActive()), (ServerPlayer) pPlayer);
                    }
                });
                ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                        sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                        sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                        sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                        sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                        sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                        sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                        sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                        sunflowerPointCaveman.isSkillActive()), (ServerPlayer) pPlayer);
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.YELLOW);
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
