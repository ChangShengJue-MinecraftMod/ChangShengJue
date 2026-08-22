package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import net.minecraft.server.level.ServerPlayer;

import java.util.Map;
import java.util.WeakHashMap;

public final class PlayerQuestPacketGuard {
    private static final int OPEN_INTERVAL_TICKS = 10;
    private static final int ACTION_INTERVAL_TICKS = 2;
    private static final Map<ServerPlayer, Long> LAST_OPEN_TICK = new WeakHashMap<>();
    private static final Map<ServerPlayer, Long> LAST_ACTION_TICK = new WeakHashMap<>();

    private PlayerQuestPacketGuard() {
    }

    public static boolean allowOpen(ServerPlayer player) {
        if (!isActive(player)
                || player.containerMenu != player.inventoryMenu) {
            return false;
        }
        return acquire(player, LAST_OPEN_TICK, OPEN_INTERVAL_TICKS);
    }

    public static boolean allowAction(ServerPlayer player) {
        if (!isActive(player) || !(player.containerMenu instanceof PlayerQuestMenu)) {
            return false;
        }
        return acquire(player, LAST_ACTION_TICK, ACTION_INTERVAL_TICKS);
    }

    private static boolean isActive(ServerPlayer player) {
        return player != null && player.isAlive() && !player.hasDisconnected();
    }

    private static boolean acquire(ServerPlayer player, Map<ServerPlayer, Long> actionTimes, int interval) {
        long now = player.level().getGameTime();
        Long last = actionTimes.get(player);
        if (last != null && now >= last && now - last < interval) {
            return false;
        }
        actionTimes.put(player, now);
        return true;
    }
}
