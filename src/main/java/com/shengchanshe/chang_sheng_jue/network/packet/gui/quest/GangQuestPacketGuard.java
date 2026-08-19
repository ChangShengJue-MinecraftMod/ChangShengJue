package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.trading.Merchant;

import java.util.Map;
import java.util.WeakHashMap;

final class GangQuestPacketGuard {
    private static final int OPEN_INTERVAL_TICKS = 10;
    private static final int ACCEPT_INTERVAL_TICKS = 4;
    private static final double MAX_INTERACTION_DISTANCE_SQR = 64.0D;
    private static final Map<ServerPlayer, ActionTimes> ACTION_TIMES = new WeakHashMap<>();

    private GangQuestPacketGuard() {
    }

    static AbstractGangLeader validateOpen(ServerPlayer player) {
        if (!(player.containerMenu instanceof GangleaderTradingMenu menu)
                || !allow(player, true)
                || !isValidMenu(player, menu, menu.getTrader())) {
            return null;
        }
        return menu.getTrader() instanceof AbstractGangLeader gangLeader ? gangLeader : null;
    }

    static AbstractGangLeader validateAccept(ServerPlayer player) {
        if (!(player.containerMenu instanceof GangQuestsMenu menu)
                || !allow(player, false)
                || !isValidMenu(player, menu, menu.getTrader())) {
            return null;
        }
        return menu.getTrader() instanceof AbstractGangLeader gangLeader ? gangLeader : null;
    }

    private static boolean isValidMenu(ServerPlayer player, AbstractContainerMenu menu, Merchant merchant) {
        if (!player.isAlive() || player.hasDisconnected() || !menu.stillValid(player)) {
            return false;
        }
        if (!(merchant instanceof Entity entity) || !entity.isAlive()) {
            return false;
        }
        return entity.level() == player.level()
                && entity.distanceToSqr(player) <= MAX_INTERACTION_DISTANCE_SQR
                && merchant.getTradingPlayer() == player;
    }

    private static boolean allow(ServerPlayer player, boolean open) {
        long now = player.level().getGameTime();
        ActionTimes times = ACTION_TIMES.computeIfAbsent(player, ignored -> new ActionTimes());
        long last = open ? times.lastOpenTick : times.lastAcceptTick;
        int interval = open ? OPEN_INTERVAL_TICKS : ACCEPT_INTERVAL_TICKS;
        if (last != Long.MIN_VALUE && now >= last && now - last < interval) {
            return false;
        }
        if (open) {
            times.lastOpenTick = now;
        } else {
            times.lastAcceptTick = now;
        }
        return true;
    }

    private static final class ActionTimes {
        private long lastOpenTick = Long.MIN_VALUE;
        private long lastAcceptTick = Long.MIN_VALUE;
    }
}
