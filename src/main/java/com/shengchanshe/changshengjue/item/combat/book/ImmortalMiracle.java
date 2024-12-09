package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
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

public class ImmortalMiracle extends Item {
    public ImmortalMiracle() {
        super(new Properties());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    if (sunflowerPointCaveman.isSunflowerPointCavemanOff() && !immortalMiracle.isImmortalMiracleOff()){
                        sunflowerPointCaveman.setSunflowerPointCavemanOff(false);
                        immortalMiracle.setImmortalMiracleOff(true);
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
                pPlayer.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                    if (goldenBellJar.isGoldenBellJarOff() && !immortalMiracle.isImmortalMiracleOff()){
                        goldenBellJar.setGoldenBellJarOff(false);
                        immortalMiracle.setImmortalMiracleOff(true);
                        ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                goldenBellJar.getGoldenBellJarLevel(),
                                goldenBellJar.isGoldenBellJarComprehend(),
                                goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                goldenBellJar.isGoldenBellJarOff(),
                                goldenBellJar.getGoldenBellJarToppedTick(),
                                goldenBellJar.getGoldenBellJarDachengTick(),
                                goldenBellJar.isGoldenBellJarParticle()), (ServerPlayer) pPlayer);
                    }
                });
                pPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                    if (geShanDaNiu.isGeShanDaNiuOff() && !immortalMiracle.isImmortalMiracleOff()){
                        geShanDaNiu.setGeShanDaNiuOff(false);
                        immortalMiracle.setImmortalMiracleOff(true);
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
                if (!immortalMiracle.isImmortalMiracleComprehend()){
                    immortalMiracle.setImmortalMiracleComprehend(true);
                    immortalMiracle.setImmortalMiracleOff(true);
                }
                ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                        immortalMiracle.getImmortalMiracleLevel(),
                        immortalMiracle.isImmortalMiracleComprehend(),
                        immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                        immortalMiracle.isImmortalMiracleOff(),
                        immortalMiracle.getImmortalMiracleToppedTick(),
                        immortalMiracle.getImmortalMiracleDachengTick(),
                        immortalMiracle.isImmortalMiracleParticle(),
                        immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) pPlayer);
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.immortal_miracle.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
