package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.DuguNineSwordsPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class DuguNineSwordsEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSwords -> {
                    if (duguNineSwords.isDuguNineSwordsParticle()){
                        if (duguNineSwords.getDuguNineSwordsLevel() == 1){
                            duguNineSwords.setDuguNineSwordsToppedTick();
                            ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(
                                    duguNineSwords.getDuguNineSwordsLevel(),
                                    duguNineSwords.isDuguNineSwordsComprehend(),
                                    duguNineSwords.getDuguNineSwordsToppedTick(),
                                    duguNineSwords.getDuguNineSwordsDachengTick(),
                                    duguNineSwords.isDuguNineSwordsParticle()), (ServerPlayer) player);
                        }else if (duguNineSwords.getDuguNineSwordsLevel() == 2){
                            duguNineSwords.setDuguNineSwordsDachengTick();
                            ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(
                                    duguNineSwords.getDuguNineSwordsLevel(),
                                    duguNineSwords.isDuguNineSwordsComprehend(),
                                    duguNineSwords.getDuguNineSwordsToppedTick(),
                                    duguNineSwords.getDuguNineSwordsDachengTick(),
                                    duguNineSwords.isDuguNineSwordsParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (DuguNineSwordsClientData.isDuguNineSwordsParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, DuguNineSwordsClientData.getDuguNineSwordsToppedTick());
                }
                if (DuguNineSwordsClientData.isDuguNineSwordsParticle()) {
                    DachengParticle.DachengParticle(player, level, DuguNineSwordsClientData.getDuguNineSwordsDachengTick());
                }
            }
        }
    }
}
