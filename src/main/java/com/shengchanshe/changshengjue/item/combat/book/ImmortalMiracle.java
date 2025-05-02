package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class ImmortalMiracle extends Item {
    public ImmortalMiracle() {
        super(new Properties());
    }

    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                    if (immortalMiracle.isImmortalMiracleComprehend() && immortalMiracle.isImmortalMiracleOff() && immortalMiracle.getImmortalMiracleLevel() == 0) {
                        if (immortalMiracle.isSkillXActive() || immortalMiracle.isSkillZActive() || immortalMiracle.isSkillCActive()) {
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                immortalMiracle.addImmortalMiracleLevel();
                                immortalMiracle.setImmortalMiracleParticle(true);
                                ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                        immortalMiracle.getImmortalMiracleLevel(),
                                        immortalMiracle.isImmortalMiracleComprehend(),
                                        immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                        immortalMiracle.isImmortalMiracleOff(),
                                        immortalMiracle.getImmortalMiracleToppedTick(),
                                        immortalMiracle.getImmortalMiracleDachengTick(),
                                        immortalMiracle.isImmortalMiracleParticle(),
                                        immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
                                        immortalMiracle.isSkillZActive(),
                                        immortalMiracle.isSkillXActive(),
                                        immortalMiracle.isSkillCActive()), (ServerPlayer) player);
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

//    @Override
//    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (!pLevel.isClientSide){
//            pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//                pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//                    if (sunflowerPointCaveman.isSunflowerPointCavemanOff() && !immortalMiracle.isImmortalMiracleOff()){
//                        sunflowerPointCaveman.setSunflowerPointCavemanOff(false);
//                        immortalMiracle.setImmortalMiracleOff(true);
//                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
//                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
//                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
//                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
//                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
//                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
//                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
//                                sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
//                                sunflowerPointCaveman.isSkillZActive(),
//                                sunflowerPointCaveman.isSkillXActive(),
//                                sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) pPlayer);
//                    }
//                });
//                pPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
//                    if (turtleBreathWork.isTurtleBreathWorkOff() && !immortalMiracle.isImmortalMiracleOff()){
//                        turtleBreathWork.setTurtleBreathWorkOff(false);
//                        immortalMiracle.setImmortalMiracleOff(true);
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
//                if (!immortalMiracle.isImmortalMiracleComprehend()){
//                    immortalMiracle.setImmortalMiracleComprehend(true);
//                    immortalMiracle.setImmortalMiracleOff(true);
//                }
//                ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
//                        immortalMiracle.getImmortalMiracleLevel(),
//                        immortalMiracle.isImmortalMiracleComprehend(),
//                        immortalMiracle.getImmortalMiracleUseCooldownPercent(),
//                        immortalMiracle.isImmortalMiracleOff(),
//                        immortalMiracle.getImmortalMiracleToppedTick(),
//                        immortalMiracle.getImmortalMiracleDachengTick(),
//                        immortalMiracle.isImmortalMiracleParticle(),
//                        immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
//                        immortalMiracle.isSkillZActive(),
//                        immortalMiracle.isSkillXActive(),
//                        immortalMiracle.isSkillCActive()), (ServerPlayer) pPlayer);
//            });
//        }
//        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
//    }

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
