package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.gao_marksmanship.GaoMarksmanshipClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.GaoMarksmanshipPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class GaoMarksmanshipEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
                    if (gaoMarksmanship.isGaoMarksmanshipParticle()){
                        if (gaoMarksmanship.getGaoMarksmanshipLevel() == 1){
                            gaoMarksmanship.setGaoMarksmanshipToppedTick();
                            ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(
                                    gaoMarksmanship.getGaoMarksmanshipLevel(),
                                    gaoMarksmanship.isGaoMarksmanshipComprehend(),
                                    gaoMarksmanship.getGaoMarksmanshipToppedTick(),
                                    gaoMarksmanship.getGaoMarksmanshipDachengTick(),
                                    gaoMarksmanship.isGaoMarksmanshipParticle()), (ServerPlayer) player);
                        }else if (gaoMarksmanship.getGaoMarksmanshipLevel() == 2){
                            gaoMarksmanship.setGaoMarksmanshipDachengTick();
                            ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(
                                    gaoMarksmanship.getGaoMarksmanshipLevel(),
                                    gaoMarksmanship.isGaoMarksmanshipComprehend(),
                                    gaoMarksmanship.getGaoMarksmanshipToppedTick(),
                                    gaoMarksmanship.getGaoMarksmanshipDachengTick(),
                                    gaoMarksmanship.isGaoMarksmanshipParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (GaoMarksmanshipClientData.isGaoMarksmanshipParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, GaoMarksmanshipClientData.getGaoMarksmanshipToppedTick());
                }
                if (GaoMarksmanshipClientData.isGaoMarksmanshipParticle()) {
                    DachengParticle.DachengParticle(player, level, GaoMarksmanshipClientData.getGaoMarksmanshipDachengTick());
                }
            }
        }
    }
}
