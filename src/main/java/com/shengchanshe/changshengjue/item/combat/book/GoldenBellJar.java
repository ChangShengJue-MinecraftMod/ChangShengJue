package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.hercules.HerculesPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class GoldenBellJar extends Item {
    public GoldenBellJar() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                if (!goldenBellJar.isGoldenBellJarComprehend()) {
                    goldenBellJar.setGoldenBellJarComprehend(true);
                    goldenBellJar.setSkillActive(true);
                    if (pPlayer instanceof ServerPlayer serverPlayer) {
                        CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                    }
                }else {
                    goldenBellJar.setSkillActive(!goldenBellJar.isSkillActive());
                    pPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                        if (geShanDaNiu.isSkillActive()){
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
                    pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                        if (immortalMiracle.isSkillActive()) {
                            immortalMiracle.setSkillActive(false);
                            ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                    immortalMiracle.getImmortalMiracleLevel(),
                                    immortalMiracle.isImmortalMiracleComprehend(),
                                    immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                    immortalMiracle.isImmortalMiracleOff(),
                                    immortalMiracle.getImmortalMiracleToppedTick(),
                                    immortalMiracle.getImmortalMiracleDachengTick(),
                                    immortalMiracle.isImmortalMiracleParticle(),
                                    immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
                                    immortalMiracle.isSkillActive()), (ServerPlayer) pPlayer);
                        }
                    });
                    pPlayer.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
                        if (qianKunDaNuoYi.isSkillActive()) {
                            qianKunDaNuoYi.setSkillActive(false);
                            ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
                                    qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
                                    qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
                                    qianKunDaNuoYi.isQianKunDaNuoYiOff(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
                                    qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
                                    qianKunDaNuoYi.isSkillActive()), (ServerPlayer) pPlayer);
                        }
                    });
                    pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                        if (sunflowerPointCaveman.isSkillActive()) {
                            sunflowerPointCaveman.setSkillActive(false);
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                    sunflowerPointCaveman.isSkillActive()), (ServerPlayer) pPlayer);
                        }
                    });
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
                }
                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                        goldenBellJar.getGoldenBellJarLevel(),
                        goldenBellJar.isGoldenBellJarComprehend(),
                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                        goldenBellJar.isGoldenBellJarOff(),
                        goldenBellJar.getGoldenBellJarToppedTick(),
                        goldenBellJar.getGoldenBellJarDachengTick(),
                        goldenBellJar.isGoldenBellJarParticle(),
                        goldenBellJar.isSkillActive()), (ServerPlayer) pPlayer);
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    public static void comprehend(Entity entity, Level level) {
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                    if (goldenBellJar.isSkillActive()) {
                        if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.getGoldenBellJarLevel() == 0) {
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                goldenBellJar.addGoldenBellJarLevel();
                                goldenBellJar.setGoldenBellJarParticle(true);
                                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                        goldenBellJar.getGoldenBellJarLevel(),
                                        goldenBellJar.isGoldenBellJarComprehend(),
                                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                        goldenBellJar.isGoldenBellJarOff(),
                                        goldenBellJar.getGoldenBellJarToppedTick(),
                                        goldenBellJar.getGoldenBellJarDachengTick(),
                                        goldenBellJar.isGoldenBellJarParticle(),
                                        goldenBellJar.isSkillActive()), (ServerPlayer) player);
                                if (player instanceof ServerPlayer serverPlayer) {
                                    CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                                }
                            }
                        }
                    }
                });
            }
        }
    }
    public static void onGoldenBellJar(Level pLevel, LivingEntity pEntity) {
        if (pEntity instanceof Player player) {
            player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                if (goldenBellJar.isSkillActive()) {
                    if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.getGoldenBellJarLevel() > 0) {
                        if (goldenBellJar.getGoldenBellJarUseCooldownPercent() <= 0) {
                            if (player.getFoodData().getFoodLevel() > 8) {
                                if (!player.getAbilities().instabuild) {
                                    player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
                                        int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                                        if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() >= 1) {
                                            player.getFoodData().eat(-foodLevel + 1, -1);//消耗饱食度
                                            if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 1000) {
                                                theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                                            }
                                        } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() > 1) {
                                            player.getFoodData().eat(-foodLevel + 2, -1);//消耗饱食度
                                            if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 1000) {
                                                theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                                            }
                                        } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() < 1) {
                                            player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
                                        }
                                    });
                                }
                                if (player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())) {
                                    goldenBellJar.setGoldenBellJarUseCooldownPercent(!player.getAbilities().instabuild ? 145 : 0);
                                } else {
                                    goldenBellJar.setGoldenBellJarUseCooldownPercent(!player.getAbilities().instabuild ? 160 : 0);
                                }
                                player.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, goldenBellJar.getGoldenBellJarLevel() < 2 ? 0 : 1, false, false), player);
                                if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())) {
                                    player.getFoodData().eat(1, 0);
                                }
                                if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())) {
                                    player.setHealth(player.getHealth() + 1);
                                }
                                if (goldenBellJar.getGoldenBellJarUseCount() <= 100) {
                                    goldenBellJar.addGoldenBellJarUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                    if (goldenBellJar.getGoldenBellJarUseCount() >= 100) {
                                        goldenBellJar.setGoldenBellJarParticle(true);
                                        pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                    }
                                }
                                player.getMainHandItem().hurtAndBreak(1, player, (player1) -> {//消耗耐久
                                    player1.broadcastBreakEvent(player.getUsedItemHand());
                                });
                            }
                        }
                    }
                    ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                            goldenBellJar.getGoldenBellJarLevel(),
                            goldenBellJar.isGoldenBellJarComprehend(),
                            goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                            goldenBellJar.isGoldenBellJarOff(),
                            goldenBellJar.getGoldenBellJarToppedTick(),
                            goldenBellJar.getGoldenBellJarDachengTick(),
                            goldenBellJar.isGoldenBellJarParticle(),
                            goldenBellJar.isSkillActive()), (ServerPlayer) player);
                }
            });
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.GOLD);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.GOLD));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
