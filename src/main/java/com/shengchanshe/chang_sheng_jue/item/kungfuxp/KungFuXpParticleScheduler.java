package com.shengchanshe.chang_sheng_jue.item.kungfuxp;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.XpParticlePacket;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class KungFuXpParticleScheduler {
    private static final int LAST_VISIBLE_TICK = 20;
    private static final Map<UUID, Map<SimpleParticleType, Integer>> ACTIVE_EFFECTS = new HashMap<>();

    private KungFuXpParticleScheduler() {
    }

    public static void start(ServerPlayer player, SimpleParticleType particleType) {
        ACTIVE_EFFECTS.computeIfAbsent(player.getUUID(), ignored -> new IdentityHashMap<>())
                .put(particleType, 1);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player)) {
            return;
        }

        Map<SimpleParticleType, Integer> effects = ACTIVE_EFFECTS.get(player.getUUID());
        if (effects == null) {
            return;
        }

        Iterator<Map.Entry<SimpleParticleType, Integer>> iterator = effects.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<SimpleParticleType, Integer> entry = iterator.next();
            int nextTick = entry.getValue() + 1;
            if (nextTick > LAST_VISIBLE_TICK) {
                iterator.remove();
                continue;
            }
            ChangShengJueMessages.sendToPlayer(
                    new XpParticlePacket(player.getUUID(), entry.getKey(), nextTick), player);
            entry.setValue(nextTick);
        }
        if (effects.isEmpty()) {
            ACTIVE_EFFECTS.remove(player.getUUID());
        }
    }

    @SubscribeEvent
    public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        ACTIVE_EFFECTS.remove(event.getEntity().getUUID());
    }

    @SubscribeEvent
    public static void onServerStopped(ServerStoppedEvent event) {
        ACTIVE_EFFECTS.clear();
    }
}
