package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
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

public class SunflowerPointCaveman extends Item {
    public SunflowerPointCaveman() {
        super(new Properties());
    }
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (!pLevel.isClientSide){
//            pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//                pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//                    if (immortalMiracle.isImmortalMiracleOff() && !sunflowerPointCaveman.isSunflowerPointCavemanOff()){
//                        immortalMiracle.setImmortalMiracleOff(false);
//                        sunflowerPointCaveman.setSunflowerPointCavemanOff(true);
//                        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
//                                immortalMiracle.getImmortalMiracleLevel(),
//                                immortalMiracle.isImmortalMiracleComprehend(),
//                                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
//                                immortalMiracle.isImmortalMiracleOff(),
//                                immortalMiracle.getImmortalMiracleToppedTick(),
//                                immortalMiracle.getImmortalMiracleDachengTick(),
//                                immortalMiracle.isImmortalMiracleParticle(),
//                                immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
//                                immortalMiracle.isSkillZActive(),
//                                immortalMiracle.isSkillXActive(),
//                                immortalMiracle.isSkillCActive()), (ServerPlayer) pPlayer);
//                    }
//                });
//                if (!sunflowerPointCaveman.isSunflowerPointCavemanComprehend()){
//                    sunflowerPointCaveman.setSunflowerPointCavemanComprehend(true);
//                    sunflowerPointCaveman.setSunflowerPointCavemanOff(true);
//                }
//                ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
//                        sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
//                        sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
//                        sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
//                        sunflowerPointCaveman.isSunflowerPointCavemanOff(),
//                        sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
//                        sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
//                        sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
//                        sunflowerPointCaveman.isSkillZActive(),
//                        sunflowerPointCaveman.isSkillXActive(),
//                        sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) pPlayer);
//            });
//        }
//        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
//    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.sunflower_point_caveman.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
