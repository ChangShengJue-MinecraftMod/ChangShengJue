package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
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

import java.util.List;

public class TurtleBreathWork extends Item {
    public TurtleBreathWork() {
        super(new Properties());
    }

    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                    if (turtleBreathWork.isTurtleBreathWorkComprehend() && turtleBreathWork.getTurtleBreathWorkLevel() == 0) {
                        if (turtleBreathWork.isSkillZActive() || turtleBreathWork.isSkillXActive() || turtleBreathWork.isSkillCActive()){
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                turtleBreathWork.addTurtleBreathWorkLevel();
                                turtleBreathWork.setTurtleBreathWorkParticle(true);
                            }
                            ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                    turtleBreathWork.getTurtleBreathWorkLevel(),
                                    turtleBreathWork.isTurtleBreathWorkComprehend(),
                                    turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                    turtleBreathWork.isTurtleBreathWorkOff(),
                                    turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                    turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                    turtleBreathWork.isTurtleBreathWorkParticle(),
                                    turtleBreathWork.isSkillZActive(),
                                    turtleBreathWork.isSkillXActive(),
                                    turtleBreathWork.isSkillCActive()), (ServerPlayer) player);
                            if (player instanceof ServerPlayer serverPlayer) {
                                CSJAdvanceInit.learnwaigong.trigger(serverPlayer);
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
//            pPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
//                pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//                    if (sunflowerPointCaveman.isSunflowerPointCavemanOff() && !turtleBreathWork.isTurtleBreathWorkOff()){
//                        sunflowerPointCaveman.setSunflowerPointCavemanOff(false);
//                        turtleBreathWork.setTurtleBreathWorkOff(true);
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
//                pPlayer.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
//                    if (immortalMiracle.isImmortalMiracleOff() && !turtleBreathWork.isTurtleBreathWorkOff()){
//                        immortalMiracle.setImmortalMiracleOff(false);
//                        turtleBreathWork.setTurtleBreathWorkOff(true);
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
//                if (!turtleBreathWork.isTurtleBreathWorkComprehend()){
//                    turtleBreathWork.setTurtleBreathWorkComprehend(true);
//                    turtleBreathWork.setTurtleBreathWorkOff(true);
//                }
//                ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
//                        turtleBreathWork.getTurtleBreathWorkLevel(),
//                        turtleBreathWork.isTurtleBreathWorkComprehend(),
//                        turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
//                        turtleBreathWork.isTurtleBreathWorkOff(),
//                        turtleBreathWork.getTurtleBreathWorkToppedTick(),
//                        turtleBreathWork.getTurtleBreathWorkDachengTick(),
//                        turtleBreathWork.isTurtleBreathWorkParticle(),
//                        turtleBreathWork.isSkillZActive(),
//                        turtleBreathWork.isSkillXActive(),
//                        turtleBreathWork.isSkillCActive()), (ServerPlayer) pPlayer);
//            });
//        }
//        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
//    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.turtle_breath_work.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
