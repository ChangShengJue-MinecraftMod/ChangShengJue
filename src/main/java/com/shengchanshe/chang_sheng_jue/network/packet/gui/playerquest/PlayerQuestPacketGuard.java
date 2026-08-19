package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import net.minecraft.server.level.ServerPlayer;

import java.util.Map;
import java.util.WeakHashMap;

public final class PlayerQuestPacketGuard {
    private static final int OPEN_INTERVAL_TICKS = 10;
    private static final Map<ServerPlayer, Long> LAST_OPEN_TICK = new WeakHashMap<>();

    private PlayerQuestPacketGuard() {
    }

    public static boolean allowOpen(ServerPlayer player) {
        if (player == null || !player.isAlive() || player.hasDisconnected()
                || player.containerMenu != player.inventoryMenu) {
            return false;
        }
        long now = player.level().getGameTime();
        Long last = LAST_OPEN_TICK.get(player);
        if (last != null && now >= last && now - last < OPEN_INTERVAL_TICKS) {
            return false;
        }
        LAST_OPEN_TICK.put(player, now);
        return true;
    }
}
