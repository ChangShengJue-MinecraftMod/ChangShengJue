package com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
import net.minecraft.server.level.ServerPlayer;

import java.util.Map;
import java.util.WeakHashMap;

public final class TreadTheSnowWithoutTraceIntentGuard {
    private static final int PACKET_INTERVAL_TICKS = 4;
    private static final int INTENT_WINDOW_TICKS = 8;
    private static final int ACCEPT_INTERVAL_TICKS = 10;
    private static final double MIN_HORIZONTAL_MOVEMENT_SQR = 0.0004D;
    private static final Map<ServerPlayer, IntentState> STATES = new WeakHashMap<>();

    private TreadTheSnowWithoutTraceIntentGuard() {
    }

    public static void submitIntent(ServerPlayer player) {
        if (!isEligible(player)) {
            return;
        }
        long now = player.level().getGameTime();
        IntentState state = STATES.computeIfAbsent(player, ignored -> new IntentState(player));
        if (state.lastPacketTick != Long.MIN_VALUE
                && now >= state.lastPacketTick
                && now - state.lastPacketTick < PACKET_INTERVAL_TICKS) {
            return;
        }
        state.lastPacketTick = now;
        state.pendingSinceTick = now;
    }

    public static void tickPlayer(ServerPlayer player) {
        IntentState state = STATES.get(player);
        if (state == null) {
            return;
        }
        if (!isEligible(player)) {
            STATES.remove(player);
            return;
        }

        long now = player.level().getGameTime();
        double deltaX = player.getX() - state.lastX;
        double deltaZ = player.getZ() - state.lastZ;
        state.lastX = player.getX();
        state.lastZ = player.getZ();

        if (state.pendingSinceTick == Long.MIN_VALUE) {
            return;
        }
        if (now < state.pendingSinceTick || now - state.pendingSinceTick > INTENT_WINDOW_TICKS) {
            state.pendingSinceTick = Long.MIN_VALUE;
            return;
        }
        if (state.lastAcceptedTick != Long.MIN_VALUE
                && now >= state.lastAcceptedTick
                && now - state.lastAcceptedTick < ACCEPT_INTERVAL_TICKS) {
            return;
        }

        boolean airborneMovement = !player.onGround()
                && !player.isFallFlying()
                && !player.isInWaterOrBubble()
                && player.getDeltaMovement().y > -0.4D;
        boolean sprintMovement = player.isSprinting()
                && deltaX * deltaX + deltaZ * deltaZ >= MIN_HORIZONTAL_MOVEMENT_SQR;
        if (!airborneMovement && !sprintMovement) {
            return;
        }

        state.pendingSinceTick = Long.MIN_VALUE;
        state.lastAcceptedTick = now;
        executeIntent(player);
    }

    public static void forget(ServerPlayer player) {
        STATES.remove(player);
    }

    public static void clearAll() {
        STATES.clear();
    }

    private static boolean isEligible(ServerPlayer player) {
        return player != null
                && player.isAlive()
                && !player.hasDisconnected()
                && !player.isSpectator()
                && !player.getAbilities().instabuild
                && !player.isPassenger()
                && !player.isSleeping();
    }

    private static void executeIntent(ServerPlayer player) {
        player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
            String kungFuId = TreadTheSnowWithoutTrace.KUNG_FU_ID.toString();
            cap.getKungFu(kungFuId)
                    .filter(TreadTheSnowWithoutTrace.class::isInstance)
                    .map(TreadTheSnowWithoutTrace.class::cast)
                    .ifPresent(active -> {
                        boolean changed = false;
                        if (!active.isComprehend()) {
                            int previousLevel = active.getLevel();
                            active.comprehendKungFu(player);
                            changed = active.isComprehend() || active.getLevel() != previousLevel;
                        }
                        if (active.isReady()) {
                            active.onLightKungfu(player);
                            changed = true;
                        }
                        if (changed) {
                            cap.syncToClient(player);
                        }
                    });
        });
    }

    private static final class IntentState {
        private long lastPacketTick = Long.MIN_VALUE;
        private long pendingSinceTick = Long.MIN_VALUE;
        private long lastAcceptedTick = Long.MIN_VALUE;
        private double lastX;
        private double lastZ;

        private IntentState(ServerPlayer player) {
            this.lastX = player.getX();
            this.lastZ = player.getZ();
        }
    }
}
