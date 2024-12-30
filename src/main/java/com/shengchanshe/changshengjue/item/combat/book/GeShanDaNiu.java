package com.shengchanshe.changshengjue.item.combat.book;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GeShanDaNiu extends Item {
    public GeShanDaNiu() {
        super(new Properties());
    }

//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (!pLevel.isClientSide){
//            pPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
//                pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//                    if (sunflowerPointCaveman.isSunflowerPointCavemanOff() && !geShanDaNiu.isGeShanDaNiuOff()){
//                        sunflowerPointCaveman.setSunflowerPointCavemanOff(false);
//                        geShanDaNiu.setGeShanDaNiuOff(true);
//                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
//                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
//                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
//                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
//                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
//                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
//                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
//                                sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) pPlayer);
//                    }
//                });
//                pPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                    if (goldenBellJar.isGoldenBellJarOff() && !geShanDaNiu.isGeShanDaNiuOff()){
//                        goldenBellJar.setGoldenBellJarOff(false);
//                        geShanDaNiu.setGeShanDaNiuOff(true);
//                        ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                                goldenBellJar.getGoldenBellJarLevel(),
//                                goldenBellJar.isGoldenBellJarComprehend(),
//                                goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                                goldenBellJar.isGoldenBellJarOff(),
//                                goldenBellJar.getGoldenBellJarToppedTick(),
//                                goldenBellJar.getGoldenBellJarDachengTick(),
//                                goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) pPlayer);
//                    }
//                });
//                pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//                    if (immortalMiracle.isImmortalMiracleOff() && !geShanDaNiu.isGeShanDaNiuOff()){
//                        immortalMiracle.setImmortalMiracleOff(false);
//                        geShanDaNiu.setGeShanDaNiuOff(true);
//                        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
//                                immortalMiracle.getImmortalMiracleLevel(),
//                                immortalMiracle.isImmortalMiracleComprehend(),
//                                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
//                                immortalMiracle.isImmortalMiracleOff(),
//                                immortalMiracle.getImmortalMiracleToppedTick(),
//                                immortalMiracle.getImmortalMiracleDachengTick(),
//                                immortalMiracle.isImmortalMiracleParticle(),
//                                immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) pPlayer);
//                    }
//                });
//                pPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
//                    if (turtleBreathWork.isTurtleBreathWorkOff() && !geShanDaNiu.isGeShanDaNiuOff()){
//                        turtleBreathWork.setTurtleBreathWorkOff(false);
//                        geShanDaNiu.setGeShanDaNiuOff(true);
//                        ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
//                                turtleBreathWork.getTurtleBreathWorkLevel(),
//                                turtleBreathWork.isTurtleBreathWorkComprehend(),
//                                turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
//                                turtleBreathWork.isTurtleBreathWorkOff(),
//                                turtleBreathWork.getTurtleBreathWorkToppedTick(),
//                                turtleBreathWork.getTurtleBreathWorkDachengTick(),
//                                turtleBreathWork.isTurtleBreathWorkParticle()), (ServerPlayer) pPlayer);
//                    }
//                });
//                if (!geShanDaNiu.isGeShanDaNiuComprehend()){
//                    geShanDaNiu.setGeShanDaNiuComprehend(true);
//                    geShanDaNiu.setGeShanDaNiuOff(true);
//                }
//                ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
//                        geShanDaNiu.getGeShanDaNiuLevel(),
//                        geShanDaNiu.isGeShanDaNiuComprehend(),
//                        geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
//                        geShanDaNiu.getGeShanDaNiuToppedTick(),
//                        geShanDaNiu.getGeShanDaNiuDachengTick(),
//                        geShanDaNiu.isGeShanDaNiuParticle(),
//                        geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
//                        geShanDaNiu.isSkillZActive(),
//                        geShanDaNiu.isSkillXActive(),
//                        geShanDaNiu.isSkillCActive()), (ServerPlayer) pPlayer);
//            });
//        }
//        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
//    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.ge_shan_da_niu.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
