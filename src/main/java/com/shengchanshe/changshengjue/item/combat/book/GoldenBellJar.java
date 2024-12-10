package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.SunflowerPointCavemanPacket;
import net.minecraft.ChatFormatting;
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

import java.util.List;

public class GoldenBellJar extends Item {
    public GoldenBellJar() {
        super(new Properties());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    if (sunflowerPointCaveman.isSunflowerPointCavemanOff() && !goldenBellJar.isGoldenBellJarOff()){
                        sunflowerPointCaveman.setSunflowerPointCavemanOff(false);
                        goldenBellJar.setGoldenBellJarOff(true);
                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) pPlayer);
                    }
                });
                pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                    if (immortalMiracle.isImmortalMiracleOff() && !goldenBellJar.isGoldenBellJarOff()){
                        immortalMiracle.setImmortalMiracleOff(false);
                        goldenBellJar.setGoldenBellJarOff(true);
                        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                immortalMiracle.getImmortalMiracleLevel(),
                                immortalMiracle.isImmortalMiracleComprehend(),
                                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                immortalMiracle.isImmortalMiracleOff(),
                                immortalMiracle.getImmortalMiracleToppedTick(),
                                immortalMiracle.getImmortalMiracleDachengTick(),
                                immortalMiracle.isImmortalMiracleParticle(),
                                immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) pPlayer);
                    }
                });
                pPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                    if (geShanDaNiu.isGeShanDaNiuOff() && !goldenBellJar.isGoldenBellJarOff()){
                        geShanDaNiu.setGeShanDaNiuOff(false);
                        goldenBellJar.setGoldenBellJarOff(true);
                        ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                geShanDaNiu.getGeShanDaNiuLevel(),
                                geShanDaNiu.isGeShanDaNiuComprehend(),
                                geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                geShanDaNiu.isGeShanDaNiuOff(),
                                geShanDaNiu.getGeShanDaNiuToppedTick(),
                                geShanDaNiu.getGeShanDaNiuDachengTick(),
                                geShanDaNiu.isGeShanDaNiuParticle(),
                                geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax()), (ServerPlayer) pPlayer);
                    }
                });
                pPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                    if (turtleBreathWork.isTurtleBreathWorkOff() && !goldenBellJar.isGoldenBellJarOff()){
                        turtleBreathWork.setTurtleBreathWorkOff(false);
                        goldenBellJar.setGoldenBellJarOff(true);
                        ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                turtleBreathWork.getTurtleBreathWorkLevel(),
                                turtleBreathWork.isTurtleBreathWorkComprehend(),
                                turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                turtleBreathWork.isTurtleBreathWorkOff(),
                                turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                turtleBreathWork.isTurtleBreathWorkParticle()), (ServerPlayer) pPlayer);
                    }
                });
                if (!goldenBellJar.isGoldenBellJarComprehend()){
                    goldenBellJar.setGoldenBellJarComprehend(true);
                    goldenBellJar.setGoldenBellJarOff(true);
                }
                ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                        goldenBellJar.getGoldenBellJarLevel(),
                        goldenBellJar.isGoldenBellJarComprehend(),
                        goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                        goldenBellJar.isGoldenBellJarOff(),
                        goldenBellJar.getGoldenBellJarToppedTick(),
                        goldenBellJar.getGoldenBellJarDachengTick(),
                        goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) pPlayer);
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.golden_bell_jar.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
