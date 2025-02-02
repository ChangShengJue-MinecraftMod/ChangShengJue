package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.wheat_nugget_encyclopedia.WheatNuggetEncyclopediaClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.WheatNuggetEncyclopediaPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class WheatNuggetEncyclopediaEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(WheatNuggetEncyclopediaCapabilityProvider.WHEAT_NUGGET_ENCYCLOPEDIA_CAPABILITY).ifPresent(wheatNuggetEncyclopedia -> {
                    if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() != 0 && player.level().getGameTime() % 20 == 0){
                        if (player.experienceLevel >= 30 && wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaUseCount() <= 100){
                            wheatNuggetEncyclopedia.addWheatNuggetEncyclopediaUseCount(100);
                            wheatNuggetEncyclopedia.setWheatNuggetEncyclopediaParticle(true);
                        }
                        float wheatNuggetEncyclopediaLevel = wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() <= 1 ? 0.05F : 0.1F;
                        if (player.getRandom().nextFloat() < wheatNuggetEncyclopediaLevel){
                            player.giveExperiencePoints(1);
                        }
                    }

                    if (wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaParticle()){
                        if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() == 1){
                            wheatNuggetEncyclopedia.setWheatNuggetEncyclopediaToppedTick();
                            ChangShengJueMessages.sendToPlayer(new WheatNuggetEncyclopediaPacket(
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaToppedTick(),
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaDachengTick(),
                                    wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaParticle()), (ServerPlayer) player);
                        }else if (wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaLevel() == 2){
                            wheatNuggetEncyclopedia.setWheatNuggetEncyclopediaDachengTick();
                            ChangShengJueMessages.sendToPlayer(new WheatNuggetEncyclopediaPacket(
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaToppedTick(),
                                    wheatNuggetEncyclopedia.getWheatNuggetEncyclopediaDachengTick(),
                                    wheatNuggetEncyclopedia.isWheatNuggetEncyclopediaParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide) {
                if (WheatNuggetEncyclopediaClientData.isWheatNuggetEncyclopediaParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, WheatNuggetEncyclopediaClientData.getWheatNuggetEncyclopediaToppedTick());
                }
                if (WheatNuggetEncyclopediaClientData.isWheatNuggetEncyclopediaParticle()) {
                    DachengParticle.DachengParticle(player, level, WheatNuggetEncyclopediaClientData.getWheatNuggetEncyclopediaDachengTick());
                }
            }
        }
    }
}
