package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesClientData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class RelentlessThrowingKnivesEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                    if (relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent() > 0) {
                        relentlessThrowingKnives.setRelentlessThrowingKnivesUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(
                                relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                                relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                                relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                                relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                                relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                                relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) player);
                    }
                    if (relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()){
                        if (relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() == 1){
                            relentlessThrowingKnives.setRelentlessThrowingKnivesToppedTick();
                            ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                                    relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                                    relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) player);
                        }else if (relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() == 2){
                            relentlessThrowingKnives.setRelentlessThrowingKnivesDachengTick();
                            ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                                    relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                                    relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                                    relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (RelentlessThrowingKnivesClientData.isRelentlessThrowingKnivesParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, RelentlessThrowingKnivesClientData.getRelentlessThrowingKnivesToppedTick());
                }
                if (RelentlessThrowingKnivesClientData.isRelentlessThrowingKnivesParticle()) {
                    DachengParticle.DachengParticle(player, level, RelentlessThrowingKnivesClientData.getRelentlessThrowingKnivesDachengTick());
                }
            }
        }
    }

}
