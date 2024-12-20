package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ShaolinStickMethodPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;

public class ShaolinStickMethodEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                    if (shaolinStickMethod.isShaolinStickMethodParticle()){
                        if (shaolinStickMethod.getShaolinStickMethodLevel() == 1){
                            shaolinStickMethod.setShaolinStickMethodToppedTick();
                            ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(
                                    shaolinStickMethod.getShaolinStickMethodLevel(),
                                    shaolinStickMethod.isShaolinStickMethodComprehend(),
                                    shaolinStickMethod.getShaolinStickMethodToppedTick(),
                                    shaolinStickMethod.getShaolinStickMethodDachengTick(),
                                    shaolinStickMethod.isShaolinStickMethodParticle()), (ServerPlayer) player);
                        }else if (shaolinStickMethod.getShaolinStickMethodLevel() == 2){
                            shaolinStickMethod.setShaolinStickMethodDachengTick();
                            ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(
                                    shaolinStickMethod.getShaolinStickMethodLevel(),
                                    shaolinStickMethod.isShaolinStickMethodComprehend(),
                                    shaolinStickMethod.getShaolinStickMethodToppedTick(),
                                    shaolinStickMethod.getShaolinStickMethodDachengTick(),
                                    shaolinStickMethod.isShaolinStickMethodParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (ShaolinStickMethodClientData.isShaolinStickMethodParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, ShaolinStickMethodClientData.getShaolinStickMethodToppedTick());
                }
                if (ShaolinStickMethodClientData.isShaolinStickMethodParticle()) {
                    DachengParticle.DachengParticle(player, level, ShaolinStickMethodClientData.getShaolinStickMethodDachengTick());
                }
            }
        }
    }
}
