package com.shengchanshe.chang_sheng_jue.event.xiu_xian;

import com.shengchanshe.chang_sheng_jue.capability.cultivation.entity.CultivationCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.cultivation.CultivationPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class XiuXianEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        if (player.level().isClientSide) return;

        if (event.phase == TickEvent.Phase.END) {
            player.getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).ifPresent(cap -> {
                cap.absorbSpiritPower(player);
                cap.convertTruePower(player);
            });
        }
    }

    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof Player player) {
            player.getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).ifPresent(cap -> {
                cap.setJiQiEfficiency(cap.calculateJiQiEfficiency(player));
                cap.setTunNaEfficiency(cap.calculateTunNaEfficiency());
                ChangShengJueMessages.sendToPlayer(new CultivationPacket(
                        cap.getCultivationStage().getName(cap.getTruePower(), cap.getCultivationStage()),
                                cap.getCultivationStage().ordinal(),
                                cap.getSpiritPower(),
                                cap.getMaxSpiritPower(),
                                cap.getTruePower(),
                                cap.getMaxTruePower(),
                                cap.getTunNaTick()),
                        (ServerPlayer) player);
            });
        }
    }

    public static void onPlayerCloned(PlayerEvent.Clone event){
        Player oldPlayer = event.getOriginal();
        oldPlayer.reviveCaps();
        oldPlayer.getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).ifPresent(oldStore->
                event.getEntity().getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).ifPresent(newStore-> newStore.copy(oldStore)));
        event.getOriginal().invalidateCaps();
    }

}
