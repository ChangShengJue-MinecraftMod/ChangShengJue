package com.shengchanshe.chang_sheng_jue.network;

import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class ClientPacketBridge {
    private static BiConsumer<UUID, CompoundTag> questDataSync = (playerId, data) -> { };
    private static Consumer<List<Quest>> questScreenRefresh = quests -> { };
    private static Runnable playerQuestScreenRefresh = () -> { };
    private static Consumer<CompoundTag> kungFuSync = data -> { };
    private static BiConsumer<UUID, String> kungFuParticle = (playerId, kungFuId) -> { };
    private static BiConsumer<UUID, String> kungFuLevelUpParticle = (playerId, kungFuId) -> { };
    private static BiConsumer<UUID, String> immortalMiracleParticle = (playerId, kungFuId) -> { };
    private static FloatTriConsumer wuGangCutGuiParticle = (x, y, z) -> { };
    private static BiConsumer<UUID, String> treadParticle = (playerId, kungFuId) -> { };
    private static XpParticleConsumer xpParticle = (playerId, particleType, tick) -> { };

    private ClientPacketBridge() {
    }

    public static void install(
            BiConsumer<UUID, CompoundTag> questDataSync,
            Consumer<List<Quest>> questScreenRefresh,
            Runnable playerQuestScreenRefresh,
            Consumer<CompoundTag> kungFuSync,
            BiConsumer<UUID, String> kungFuParticle,
            BiConsumer<UUID, String> kungFuLevelUpParticle,
            BiConsumer<UUID, String> immortalMiracleParticle,
            FloatTriConsumer wuGangCutGuiParticle,
            BiConsumer<UUID, String> treadParticle,
            XpParticleConsumer xpParticle
    ) {
        ClientPacketBridge.questDataSync = Objects.requireNonNull(questDataSync);
        ClientPacketBridge.questScreenRefresh = Objects.requireNonNull(questScreenRefresh);
        ClientPacketBridge.playerQuestScreenRefresh = Objects.requireNonNull(playerQuestScreenRefresh);
        ClientPacketBridge.kungFuSync = Objects.requireNonNull(kungFuSync);
        ClientPacketBridge.kungFuParticle = Objects.requireNonNull(kungFuParticle);
        ClientPacketBridge.kungFuLevelUpParticle = Objects.requireNonNull(kungFuLevelUpParticle);
        ClientPacketBridge.immortalMiracleParticle = Objects.requireNonNull(immortalMiracleParticle);
        ClientPacketBridge.wuGangCutGuiParticle = Objects.requireNonNull(wuGangCutGuiParticle);
        ClientPacketBridge.treadParticle = Objects.requireNonNull(treadParticle);
        ClientPacketBridge.xpParticle = Objects.requireNonNull(xpParticle);
    }

    public static void syncQuestData(UUID playerId, CompoundTag data) {
        questDataSync.accept(playerId, data);
    }

    public static void refreshQuestScreen(List<Quest> quests) {
        questScreenRefresh.accept(quests);
    }

    public static void refreshPlayerQuestScreen() {
        playerQuestScreenRefresh.run();
    }

    public static void syncKungFuCapability(CompoundTag data) {
        kungFuSync.accept(data);
    }

    public static void triggerKungFuParticle(UUID playerId, String kungFuId) {
        kungFuParticle.accept(playerId, kungFuId);
    }

    public static void triggerKungFuLevelUpParticle(UUID playerId, String kungFuId) {
        kungFuLevelUpParticle.accept(playerId, kungFuId);
    }

    public static void immortalMiracleParticle(UUID playerId, String kungFuId) {
        immortalMiracleParticle.accept(playerId, kungFuId);
    }

    public static void wuGangCutGuiParticle(float x, float y, float z) {
        wuGangCutGuiParticle.accept(x, y, z);
    }

    public static void treadTheSnowWithoutTraceParticle(UUID playerId, String kungFuId) {
        treadParticle.accept(playerId, kungFuId);
    }

    public static void xpParticle(UUID playerId, SimpleParticleType particleType, int tick) {
        xpParticle.accept(playerId, particleType, tick);
    }

    @FunctionalInterface
    public interface FloatTriConsumer {
        void accept(float x, float y, float z);
    }

    @FunctionalInterface
    public interface XpParticleConsumer {
        void accept(UUID playerId, SimpleParticleType particleType, int tick);
    }
}
