package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.mojang.authlib.GameProfile;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class MentalKungFuNeighborhoodSnapshotPerformanceGameTests {
    private static final int[] PLAYER_COUNTS = {10, 30, 60};
    private static final int WARMUP_ITERATIONS = 20;
    private static final int MEASURE_ITERATIONS = 200;

    private MentalKungFuNeighborhoodSnapshotPerformanceGameTests() {
    }

    @GameTest(template = "empty", timeoutTicks = 200)
    public static void snapshotScalesAcrossSyntheticPlayerCounts(GameTestHelper helper) {
        helper.assertTrue(MentalKungFuNeighborhoodSnapshot.isRefreshTick(0)
                        && MentalKungFuNeighborhoodSnapshot.isRefreshTick(10)
                        && !MentalKungFuNeighborhoodSnapshot.isRefreshTick(1)
                        && !MentalKungFuNeighborhoodSnapshot.isRefreshTick(9),
                "snapshot refresh cadence is not a stable ten Tick cycle");
        ServerLevel level = helper.getLevel();
        for (int playerCount : PLAYER_COUNTS) {
            benchmarkLayout(helper, level, playerCount, true);
            benchmarkLayout(helper, level, playerCount, false);
        }
        helper.succeed();
    }

    private static void benchmarkLayout(
            GameTestHelper helper,
            ServerLevel level,
            int playerCount,
            boolean dense
    ) {
        List<ServerPlayer> syntheticPlayers = createPlayers(helper, playerCount, dense);
        level.players().addAll(syntheticPlayers);
        try {
            ServerPlayer target = syntheticPlayers.get(0);
            int expectedNeighbors = dense ? playerCount : 1;
            for (int i = 0; i < WARMUP_ITERATIONS; i++) {
                captureAndAssert(helper, level, target, expectedNeighbors);
                legacyNeighborhoodScanAndAssert(helper, level, expectedNeighbors);
            }

            long[] snapshotTimings = new long[MEASURE_ITERATIONS];
            long[] legacyTimings = new long[MEASURE_ITERATIONS];
            for (int i = 0; i < MEASURE_ITERATIONS; i++) {
                long started = System.nanoTime();
                captureAndAssert(helper, level, target, expectedNeighbors);
                snapshotTimings[i] = System.nanoTime() - started;

                started = System.nanoTime();
                legacyNeighborhoodScanAndAssert(helper, level, expectedNeighbors);
                legacyTimings[i] = System.nanoTime() - started;
            }
            Arrays.sort(snapshotTimings);
            Arrays.sort(legacyTimings);
            ChangShengJue.LOGGER.info(
                    "CSJ_PERF mental_snapshot players={} layout={} iterations={} "
                            + "snapshot_median_ns={} snapshot_p95_ns={} legacy_scan_median_ns={} legacy_scan_p95_ns={}",
                    playerCount,
                    dense ? "dense" : "sparse",
                    MEASURE_ITERATIONS,
                    percentile(snapshotTimings, 50),
                    percentile(snapshotTimings, 95),
                    percentile(legacyTimings, 50),
                    percentile(legacyTimings, 95)
            );
        } finally {
            level.players().removeAll(syntheticPlayers);
            MentalKungFuNeighborhoodSnapshot.clear(level);
            syntheticPlayers.forEach(ServerPlayer::invalidateCaps);
        }
    }

    // 复现改造前每名玩家四次邻域扫描的结构成本，不包含能力读取与属性更新。
    private static void legacyNeighborhoodScanAndAssert(
            GameTestHelper helper,
            ServerLevel level,
            int expectedNeighbors
    ) {
        int matches = 0;
        for (ServerPlayer target : level.players()) {
            AABB searchBox = new AABB(
                    target.getX() - 16.0D, target.getY() - 16.0D, target.getZ() - 16.0D,
                    target.getX() + 16.0D, target.getY() + 16.0D, target.getZ() + 16.0D
            );
            for (int pass = 0; pass < 4; pass++) {
                for (ServerPlayer candidate : level.players()) {
                    if (candidate.isAlive() && candidate.getBoundingBox().intersects(searchBox)) {
                        matches++;
                    }
                }
            }
        }
        int expectedMatches = level.players().size() * expectedNeighbors * 4;
        helper.assertTrue(matches == expectedMatches,
                "legacy scan returned " + matches + " matches, expected " + expectedMatches);
    }

    private static void captureAndAssert(
            GameTestHelper helper,
            ServerLevel level,
            ServerPlayer target,
            int expectedNeighbors
    ) {
        MentalKungFuNeighborhoodSnapshot.clear(level);
        int actualNeighbors = MentalKungFuNeighborhoodSnapshot.get(target).size();
        helper.assertTrue(actualNeighbors == expectedNeighbors,
                "snapshot returned " + actualNeighbors + " neighbors, expected " + expectedNeighbors);
    }

    private static List<ServerPlayer> createPlayers(GameTestHelper helper, int playerCount, boolean dense) {
        ServerLevel level = helper.getLevel();
        List<ServerPlayer> players = new ArrayList<>(playerCount);
        for (int index = 0; index < playerCount; index++) {
            UUID playerId = UUID.nameUUIDFromBytes(
                    ("csj-perf-" + dense + '-' + playerCount + '-' + index).getBytes(StandardCharsets.UTF_8));
            ServerPlayer player = new ServerPlayer(
                    level.getServer(),
                    level,
                    new GameProfile(playerId, "csj-perf-" + index)
            ) {
                @Override
                public boolean isSpectator() {
                    return false;
                }

                @Override
                public boolean isCreative() {
                    return true;
                }
            };
            double x = dense ? helper.absolutePos(net.minecraft.core.BlockPos.ZERO).getX() + (index % 10) * 0.5D
                    : helper.absolutePos(net.minecraft.core.BlockPos.ZERO).getX() + index * 40.0D;
            double z = dense ? helper.absolutePos(net.minecraft.core.BlockPos.ZERO).getZ() + (index / 10) * 0.5D
                    : helper.absolutePos(net.minecraft.core.BlockPos.ZERO).getZ();
            player.moveTo(x, helper.absolutePos(net.minecraft.core.BlockPos.ZERO).getY(), z, 0.0F, 0.0F);
            players.add(player);
        }
        return players;
    }

    private static long percentile(long[] sortedTimings, int percentile) {
        int index = Math.min(sortedTimings.length - 1,
                Math.max(0, (int) Math.ceil(sortedTimings.length * percentile / 100.0D) - 1));
        return sortedTimings[index];
    }
}
