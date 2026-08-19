package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

public final class KungFuConfigOriginProbeTest {
    private KungFuConfigOriginProbeTest() {
    }

    static void runAll() throws IOException {
        Path directory = Files.createTempDirectory("csj-kung-fu-origin-probe-");
        try {
            Path configPath = directory.resolve("kung_fu.toml");
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.FRESH_ABSENT,
                    KungFuConfigOriginProbe.inspect(configPath),
                    "absent file");

            Files.writeString(configPath, legacyConfig(false), StandardCharsets.UTF_8);
            byte[] originalLegacyFile = Files.readAllBytes(configPath);
            var legacyDefaults = KungFuConfigOriginProbe.inspect(configPath);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.LEGACY_PRE_SCHEMA,
                    legacyDefaults,
                    "all-default legacy file");
            assertValues(KungFuConfigMigration.LEGACY_DEFAULTS, legacyDefaults, "all-default legacy file");
            if (!Arrays.equals(originalLegacyFile, Files.readAllBytes(configPath))) {
                throw new AssertionError("origin probe must not modify the source file");
            }

            Files.writeString(configPath, legacyConfig(true), StandardCharsets.UTF_8);
            var legacyCustom = KungFuConfigOriginProbe.inspect(configPath);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.LEGACY_PRE_SCHEMA,
                    legacyCustom,
                    "custom legacy file");
            assertValues(
                    new KungFuConfigMigration.Values(3, 250, 90, 4, 300, 60, 999),
                    legacyCustom,
                    "custom legacy file");

            Files.writeString(configPath, "goldenBellJarMaxExp = 700\n", StandardCharsets.UTF_8);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.MODERN,
                    KungFuConfigOriginProbe.inspect(configPath),
                    "new independent key");

            Files.writeString(configPath, "configSchemaVersion = 1\n", StandardCharsets.UTF_8);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.MODERN,
                    KungFuConfigOriginProbe.inspect(configPath),
                    "schema key");

            Files.writeString(configPath, "broken = [\n", StandardCharsets.UTF_8);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.UNREADABLE,
                    KungFuConfigOriginProbe.inspect(configPath),
                    "malformed TOML");

            Files.writeString(
                    configPath,
                    "relentlessThrowingKnivesMaxLevel = \"invalid\"\n",
                    StandardCharsets.UTF_8);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.UNREADABLE,
                    KungFuConfigOriginProbe.inspect(configPath),
                    "invalid legacy value type");

            Files.delete(configPath);
            KungFuConfigOriginProbe.captureBeforeConfigRegistration(configPath);
            Files.writeString(configPath, "configSchemaVersion = 1\n", StandardCharsets.UTF_8);
            KungFuConfigOriginProbe.captureBeforeConfigRegistration(configPath);
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.FRESH_ABSENT,
                    KungFuConfigOriginProbe.consumeForLoading(),
                    "first captured snapshot wins");
            assertOrigin(
                    KungFuConfigOriginProbe.Origin.UNREADABLE,
                    KungFuConfigOriginProbe.consumeForLoading(),
                    "snapshot is consumed only once");
        } finally {
            try (var paths = Files.walk(directory)) {
                paths.sorted(Comparator.reverseOrder()).forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException exception) {
                        throw new IllegalStateException("Unable to clean probe test directory", exception);
                    }
                });
            }
        }
    }

    private static String legacyConfig(boolean custom) {
        if (custom) {
            return """
                    relentlessThrowingKnivesMaxLevel = 3
                    relentlessThrowingKnivesMaxExp = 250
                    relentlessThrowingKnivesMaxCooldown = 90
                    duguNineSwordsMaxLevel = 4
                    duguNineSwordsMaxExp = 300
                    duguNineSwordsMaxCooldown = 60
                    zhangMenXinXueMaxExp = 999
                    """;
        }
        return """
                relentlessThrowingKnivesMaxLevel = 2
                relentlessThrowingKnivesMaxExp = 100
                relentlessThrowingKnivesMaxCooldown = 160
                duguNineSwordsMaxLevel = 2
                duguNineSwordsMaxExp = 100
                duguNineSwordsMaxCooldown = 100
                zhangMenXinXueMaxExp = 100
                """;
    }

    private static void assertOrigin(
            KungFuConfigOriginProbe.Origin expected,
            KungFuConfigOriginProbe.Snapshot actual,
            String scenario
    ) {
        if (actual.origin() != expected) {
            throw new AssertionError(scenario + ": expected " + expected + " but got " + actual.origin());
        }
    }

    private static void assertValues(
            KungFuConfigMigration.Values expected,
            KungFuConfigOriginProbe.Snapshot actual,
            String scenario
    ) {
        if (!actual.legacyValues().equals(expected)) {
            throw new AssertionError(scenario + ": legacy values do not match");
        }
    }
}
