package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.GoldenBlackKnifeMethodPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class GoldenBlackKnifeMethodEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                    if (goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()){
                        if (goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel() == 1){
                            goldenBlackKnifeMethod.setGoldenBlackKnifeMethodToppedTick();
                            ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(
                                    goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
                                    goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
                                    goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
                                    goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
                                    goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), (ServerPlayer) player);
                        }else if (goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel() == 2){
                            goldenBlackKnifeMethod.setGoldenBlackKnifeMethodDachengTick();
                            ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(
                                    goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
                                    goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
                                    goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
                                    goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
                                    goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (GoldenBlackKnifeMethodClientData.isGoldenBlackKnifeMethodParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, GoldenBlackKnifeMethodClientData.getGoldenBlackKnifeMethodToppedTick());
                }
                if (GoldenBlackKnifeMethodClientData.isGoldenBlackKnifeMethodParticle()) {
                    DachengParticle.DachengParticle(player, level, GoldenBlackKnifeMethodClientData.getGoldenBlackKnifeMethodDachengTick());
                }
            }
        }
    }
}
