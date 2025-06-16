package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class SunflowerPointCavemanEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent() > 0) {
                        if (sunflowerPointCaveman.isSkillActive()) {
                            sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent();
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
                    if (sunflowerPointCaveman.isSunflowerPointCavemanParticle()){
                        if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 1){
                            sunflowerPointCaveman.setSunflowerPointCavemanToppedTick();
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                    sunflowerPointCaveman.isSkillActive()), (ServerPlayer) player);
                        }else if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 2){
                            sunflowerPointCaveman.setSunflowerPointCavemanDachengTick();
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
                });
            }
            if (player.level().isClientSide){
                if (SunflowerPointCavemanClientData.isSunflowerPointCavemanParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, SunflowerPointCavemanClientData.getSunflowerPointCavemanToppedTick());
                }
                if (SunflowerPointCavemanClientData.isSunflowerPointCavemanParticle()) {
                    DachengParticle.DachengParticle(player, level, SunflowerPointCavemanClientData.getSunflowerPointCavemanDachengTick());
                }
            }
        }
    }

    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event){
//        Level level = event.getEntity().level();
//        if (!level.isClientSide){
//            if (event.getSource().getDirectEntity() instanceof Player directEntity){
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
//                    if (!directEntity.isShiftKeyDown()){
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
//                        if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 0) {
//                            if (sunflowerPointCaveman.isSkillZActive() || sunflowerPointCaveman.isSkillXActive() || sunflowerPointCaveman.isSkillCActive()){
//                                float probability = directEntity.getRandom().nextFloat();
//                                float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                                if (probability < defaultProbability) {
//                                    level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                            ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                    sunflowerPointCaveman.addSunflowerPointCavemanLevel();
//                                    sunflowerPointCaveman.setSunflowerPointCavemanParticle(true);
//                                }
//                                ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
//                                        sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
//                                        sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
//                                        sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
//                                        sunflowerPointCaveman.isSunflowerPointCavemanOff(),
//                                        sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
//                                        sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
//                                        sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
//                                        sunflowerPointCaveman.isSkillZActive(),
//                                        sunflowerPointCaveman.isSkillXActive(),
//                                        sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) directEntity);
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

}
