package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

/**
 * 每个服务端维度复用固定十 Tick 的心法邻域只读快照。
 */
public final class MentalKungFuNeighborhoodSnapshot {
    private static final int SNAPSHOT_INTERVAL_TICKS = 10;
    private static final double DETECTION_RANGE = 16.0;
    private static final double CELL_SIZE = DETECTION_RANGE;
    private static final Map<ServerLevel, LevelSnapshot> LEVEL_SNAPSHOTS = new WeakHashMap<>();

    private MentalKungFuNeighborhoodSnapshot() {
    }

    public static boolean isRefreshTick(Player target) {
        return target.level() instanceof ServerLevel serverLevel
            && isRefreshTick(serverLevel.getGameTime());
    }

    static boolean isRefreshTick(long gameTime) {
        return Math.floorMod(gameTime, SNAPSHOT_INTERVAL_TICKS) == 0;
    }

    static List<Entry> get(Player target) {
        if (!(target.level() instanceof ServerLevel serverLevel)) {
            return List.of();
        }
        if (!serverLevel.getServer().isSameThread()) {
            throw new IllegalStateException("Mental kung fu snapshot must be accessed on the server thread");
        }

        long generation = Math.floorDiv(serverLevel.getGameTime(), SNAPSHOT_INTERVAL_TICKS);
        synchronized (LEVEL_SNAPSHOTS) {
            LevelSnapshot snapshot = LEVEL_SNAPSHOTS.get(serverLevel);
            if (snapshot == null || snapshot.generation != generation) {
                snapshot = capture(serverLevel, generation);
                LEVEL_SNAPSHOTS.put(serverLevel, snapshot);
            }
            return snapshot.nearbyByPlayer.getOrDefault(target.getUUID(), List.of());
        }
    }

    public static void clear(ServerLevel serverLevel) {
        synchronized (LEVEL_SNAPSHOTS) {
            LEVEL_SNAPSHOTS.remove(serverLevel);
        }
    }

    public static void clearAll() {
        synchronized (LEVEL_SNAPSHOTS) {
            LEVEL_SNAPSHOTS.clear();
        }
    }

    private static LevelSnapshot capture(ServerLevel serverLevel, long generation) {
        List<CapturedPlayer> players = new ArrayList<>(serverLevel.players().size());
        for (Player player : serverLevel.players()) {
            if (player.isAlive()) {
                players.add(new CapturedPlayer(
                    captureEntry(player),
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    player.getBoundingBox()
                ));
            }
        }

        Map<CellKey, List<CapturedPlayer>> spatialIndex = new HashMap<>();
        for (CapturedPlayer player : players) {
            addToSpatialIndex(spatialIndex, player);
        }

        Map<UUID, List<Entry>> nearbyByPlayer = new HashMap<>(players.size());
        for (CapturedPlayer target : players) {
            nearbyByPlayer.put(target.entry.playerId(), findNearby(spatialIndex, target));
        }
        return new LevelSnapshot(generation, Map.copyOf(nearbyByPlayer));
    }

    private static void addToSpatialIndex(Map<CellKey, List<CapturedPlayer>> spatialIndex, CapturedPlayer player) {
        int minCellX = cellCoordinate(player.bounds.minX);
        int minCellY = cellCoordinate(player.bounds.minY);
        int minCellZ = cellCoordinate(player.bounds.minZ);
        int maxCellX = cellCoordinate(player.bounds.maxX);
        int maxCellY = cellCoordinate(player.bounds.maxY);
        int maxCellZ = cellCoordinate(player.bounds.maxZ);
        for (int cellX = minCellX; cellX <= maxCellX; cellX++) {
            for (int cellY = minCellY; cellY <= maxCellY; cellY++) {
                for (int cellZ = minCellZ; cellZ <= maxCellZ; cellZ++) {
                    spatialIndex.computeIfAbsent(new CellKey(cellX, cellY, cellZ), ignored -> new ArrayList<>())
                        .add(player);
                }
            }
        }
    }

    private static List<Entry> findNearby(Map<CellKey, List<CapturedPlayer>> spatialIndex, CapturedPlayer target) {
        AABB searchBox = new AABB(
            target.x - DETECTION_RANGE, target.y - DETECTION_RANGE, target.z - DETECTION_RANGE,
            target.x + DETECTION_RANGE, target.y + DETECTION_RANGE, target.z + DETECTION_RANGE
        );
        int minCellX = cellCoordinate(searchBox.minX);
        int minCellY = cellCoordinate(searchBox.minY);
        int minCellZ = cellCoordinate(searchBox.minZ);
        int maxCellX = cellCoordinate(searchBox.maxX);
        int maxCellY = cellCoordinate(searchBox.maxY);
        int maxCellZ = cellCoordinate(searchBox.maxZ);
        Map<UUID, Entry> nearby = new LinkedHashMap<>();
        for (int cellX = minCellX; cellX <= maxCellX; cellX++) {
            for (int cellY = minCellY; cellY <= maxCellY; cellY++) {
                for (int cellZ = minCellZ; cellZ <= maxCellZ; cellZ++) {
                    List<CapturedPlayer> candidates = spatialIndex.get(new CellKey(cellX, cellY, cellZ));
                    if (candidates == null) {
                        continue;
                    }
                    for (CapturedPlayer candidate : candidates) {
                        if (candidate.bounds.intersects(searchBox)) {
                            nearby.putIfAbsent(candidate.entry.playerId(), candidate.entry);
                        }
                    }
                }
            }
        }
        return List.copyOf(nearby.values());
    }

    private static int cellCoordinate(double coordinate) {
        return (int) Math.floor(coordinate / CELL_SIZE);
    }

    private static Entry captureEntry(Player player) {
        Entry empty = new Entry(player.getUUID(), player.getId(), false, false, 0, false, 0, false);
        Entry[] holder = {empty};
        player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
            WanXiangBaoShu wanXiang = cap.getKungFu(WanXiangBaoShu.KUNG_FU_ID.toString())
                .filter(WanXiangBaoShu.class::isInstance)
                .map(WanXiangBaoShu.class::cast)
                .orElse(null);
            ZaBingShouCe zaBing = cap.getKungFu(ZaBingShouCe.KUNG_FU_ID.toString())
                .filter(ZaBingShouCe.class::isInstance)
                .map(ZaBingShouCe.class::cast)
                .orElse(null);
            QingPingJi qingPing = cap.getKungFu(QingPingJi.KUNG_FU_ID.toString())
                .filter(QingPingJi.class::isInstance)
                .map(QingPingJi.class::cast)
                .orElse(null);
            holder[0] = new Entry(
                player.getUUID(),
                player.getId(),
                wanXiang != null && wanXiang.isComprehend(),
                wanXiang != null && wanXiang.isStart(),
                wanXiang == null ? 0 : wanXiang.getLevel(),
                zaBing != null && zaBing.isComprehend(),
                zaBing == null ? 0 : zaBing.getLevel(),
                qingPing != null && qingPing.isComprehend() && qingPing.isStart() && qingPing.getLevel() > 0
            );
        });
        return holder[0];
    }

    record Entry(
        UUID playerId,
        int entityId,
        boolean wanXiangComprehended,
        boolean wanXiangStarted,
        int wanXiangLevel,
        boolean zaBingComprehended,
        int zaBingLevel,
        boolean qingPingActive
    ) {
    }

    private record CapturedPlayer(Entry entry, double x, double y, double z, AABB bounds) {
    }

    private record CellKey(int x, int y, int z) {
    }

    private record LevelSnapshot(long generation, Map<UUID, List<Entry>> nearbyByPlayer) {
    }
}
