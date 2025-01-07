package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingClientData;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.TheClassicsOfTendonChangingPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class TheClassicsOfTendonChangingEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
                    if (theClassicsOfTendonChanging.isTheClassicsOfTendonChangingParticle()){
                        if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() == 1){
                            theClassicsOfTendonChanging.setTheClassicsOfTendonChangingToppedTick();
                            ChangShengJueMessages.sendToPlayer(new TheClassicsOfTendonChangingPacket(
                                    theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel(),
                                    theClassicsOfTendonChanging.isTheClassicsOfTendonChangingComprehend(),
                                    theClassicsOfTendonChanging.getTheClassicsOfTendonChangingToppedTick(),
                                    theClassicsOfTendonChanging.getTheClassicsOfTendonChangingDachengTick(),
                                    theClassicsOfTendonChanging.isTheClassicsOfTendonChangingParticle()), (ServerPlayer) player);
                        }else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() == 2){
                            theClassicsOfTendonChanging.setTheClassicsOfTendonChangingDachengTick();
                            ChangShengJueMessages.sendToPlayer(new TheClassicsOfTendonChangingPacket(
                                    theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel(),
                                    theClassicsOfTendonChanging.isTheClassicsOfTendonChangingComprehend(),
                                    theClassicsOfTendonChanging.getTheClassicsOfTendonChangingToppedTick(),
                                    theClassicsOfTendonChanging.getTheClassicsOfTendonChangingDachengTick(),
                                    theClassicsOfTendonChanging.isTheClassicsOfTendonChangingParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (TheClassicsOfTendonChangingClientData.isTheClassicsOfTendonChangingParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, TheClassicsOfTendonChangingClientData.getTheClassicsOfTendonChangingToppedTick());
                }
                if (TheClassicsOfTendonChangingClientData.isTheClassicsOfTendonChangingParticle()) {
                    DachengParticle.DachengParticle(player, level, TheClassicsOfTendonChangingClientData.getTheClassicsOfTendonChangingDachengTick());
                }
            }
        }
    }

//    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event){
//        Level level = event.getEntity().level();
//        if (!level.isClientSide){
//            if (event.getSource().getDirectEntity() instanceof Player directEntity){
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
//                    if (!directEntity.isShiftKeyDown()){
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
//                        if (theClassicsOfTendonChanging.isTheClassicsOfTendonChangingComprehend() && theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() == 0) {
//                            float probability = directEntity.getRandom().nextFloat();
//                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                            if (probability < defaultProbability) {
//                                theClassicsOfTendonChanging.addTheClassicsOfTendonChangingLevel();
//                                theClassicsOfTendonChanging.setTheClassicsOfTendonChangingParticle(true);
//                                directEntity.level().playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                ChangShengJueMessages.sendToPlayer(new TheClassicsOfTendonChangingPacket( theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel(),
//                                        theClassicsOfTendonChanging.isTheClassicsOfTendonChangingComprehend(),
//                                        theClassicsOfTendonChanging.getTheClassicsOfTendonChangingToppedTick(),
//                                        theClassicsOfTendonChanging.getTheClassicsOfTendonChangingDachengTick(),
//                                        theClassicsOfTendonChanging.isTheClassicsOfTendonChangingParticle()), (ServerPlayer) directEntity);
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

}
