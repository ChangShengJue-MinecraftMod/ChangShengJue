package com.shengchanshe.chang_sheng_jue.event.kungfu;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.GoldenBellJar;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class GoldenBellJarEvent {

    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        if (player.level().isClientSide) return;
        player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
            cap.getKungFu(GoldenBellJar.KUNG_FU_ID.toString())
                .filter(kungFu -> kungFu instanceof GoldenBellJar)
                .map(kungFu -> (GoldenBellJar) kungFu)
                .filter(GoldenBellJar::isReady)
                .map(active -> {
                    active.onLevelUp(player);
                    if (player instanceof ServerPlayer) {
                        cap.syncToClient((ServerPlayer) player);
                    }
                    return true;
                });
        });
    }

}
