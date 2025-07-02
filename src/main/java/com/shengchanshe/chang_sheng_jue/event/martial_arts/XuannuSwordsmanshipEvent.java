package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipClientData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.XuannuSwordsmanshipPacket;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class XuannuSwordsmanshipEvent {
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
                    if (xuannuSwordsmanship.isXuannuSwordsmanshipParticle()){
                        if (xuannuSwordsmanship.getXuannuSwordsmanshipLevel() == 1){
                            xuannuSwordsmanship.setXuannuSwordsmanshipToppedTick();
                            ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(
                                    xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),
                                    xuannuSwordsmanship.isXuannuSwordsmanshipComprehend(),
                                    xuannuSwordsmanship.getXuannuSwordsmanshipToppedTick(),
                                    xuannuSwordsmanship.getXuannuSwordsmanshipDachengTick(),
                                    xuannuSwordsmanship.isXuannuSwordsmanshipParticle()), (ServerPlayer) player);
                        }else if (xuannuSwordsmanship.getXuannuSwordsmanshipLevel() == 2){
                            xuannuSwordsmanship.setXuannuSwordsmanshipDachengTick();
                            ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(
                                    xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),
                                    xuannuSwordsmanship.isXuannuSwordsmanshipComprehend(),
                                    xuannuSwordsmanship.getXuannuSwordsmanshipToppedTick(),
                                    xuannuSwordsmanship.getXuannuSwordsmanshipDachengTick(),
                                    xuannuSwordsmanship.isXuannuSwordsmanshipParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (XuannuSwordsmanshipClientData.isXuannuSwordsmanshipParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, XuannuSwordsmanshipClientData.getXuannuSwordsmanshipToppedTick());
                }
                if (XuannuSwordsmanshipClientData.isXuannuSwordsmanshipParticle()) {
                    DachengParticle.DachengParticle(player, level, XuannuSwordsmanshipClientData.getXuannuSwordsmanshipDachengTick());
                }
            }
        }
    }
}
