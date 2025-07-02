package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodClientData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.ShaolinStickMethodPacket;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
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
