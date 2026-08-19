package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

import com.electronwill.nightconfig.core.UnmodifiableConfig;
import com.electronwill.nightconfig.toml.TomlParser;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

/**
 * 在 Forge 注册配置前只读原文件，避免默认键补齐后丢失配置来源信息。
 */
public final class KungFuConfigOriginProbe {
    private static final String SCHEMA_KEY = "configSchemaVersion";
    private static final List<String> UNIQUE_KEYS = List.of(
            "goldenBellJarMaxLevel",
            "goldenBellJarMaxExp",
            "goldenBellJarMaxCooldown",
            "treadTheSnowWithoutTraceMaxLevel",
            "treadTheSnowWithoutTraceMaxExp",
            "treadTheSnowWithoutTraceMaxCooldown",
            "zaBingShouCeMaxExp"
    );

    private static Snapshot pendingSnapshot;

    private KungFuConfigOriginProbe() {
    }

    public static synchronized void captureBeforeConfigRegistration(Path configPath) {
        if (pendingSnapshot != null) {
            return;
        }
        ProbeResult result = inspectWithResult(Objects.requireNonNull(configPath, "configPath"));
        pendingSnapshot = result.snapshot();
        if (result.failureType() != null) {
            ChangShengJue.LOGGER.error(
                    "Unable to inspect the pre-registration kung fu config source ({}); migration is disabled",
                    result.failureType());
        }
    }

    static synchronized Snapshot consumeForLoading() {
        Snapshot snapshot = pendingSnapshot;
        pendingSnapshot = null;
        return snapshot != null ? snapshot : Snapshot.unreadable();
    }

    static Snapshot inspect(Path configPath) {
        return inspectWithResult(configPath).snapshot();
    }

    private static ProbeResult inspectWithResult(Path configPath) {
        if (Files.notExists(configPath)) {
            return new ProbeResult(Snapshot.freshAbsent(), null);
        }
        if (!Files.isRegularFile(configPath)) {
            return unreadable("NotRegularFile");
        }

        try (Reader reader = Files.newBufferedReader(configPath, StandardCharsets.UTF_8)) {
            UnmodifiableConfig rawConfig = new TomlParser().parse(reader);
            if (rawConfig.contains(SCHEMA_KEY) || UNIQUE_KEYS.stream().anyMatch(rawConfig::contains)) {
                return new ProbeResult(Snapshot.modern(), null);
            }

            var legacyValues = new KungFuConfigMigration.Values(
                    readLegacyInt(rawConfig, "relentlessThrowingKnivesMaxLevel", 2),
                    readLegacyInt(rawConfig, "relentlessThrowingKnivesMaxExp", 100),
                    readLegacyInt(rawConfig, "relentlessThrowingKnivesMaxCooldown", 160),
                    readLegacyInt(rawConfig, "duguNineSwordsMaxLevel", 2),
                    readLegacyInt(rawConfig, "duguNineSwordsMaxExp", 100),
                    readLegacyInt(rawConfig, "duguNineSwordsMaxCooldown", 100),
                    readLegacyInt(rawConfig, "zhangMenXinXueMaxExp", 100)
            );
            return new ProbeResult(Snapshot.legacyPreSchema(legacyValues), null);
        } catch (IOException | RuntimeException exception) {
            return unreadable(exception.getClass().getSimpleName());
        }
    }

    private static int readLegacyInt(UnmodifiableConfig config, String key, int fallback) {
        if (!config.contains(key)) {
            return fallback;
        }
        Object value = config.get(key);
        if (!(value instanceof Number number)) {
            throw new IllegalArgumentException("Invalid numeric config value");
        }
        return Math.max(0, number.intValue());
    }

    private static ProbeResult unreadable(String failureType) {
        return new ProbeResult(Snapshot.unreadable(), failureType);
    }

    enum Origin {
        FRESH_ABSENT,
        LEGACY_PRE_SCHEMA,
        MODERN,
        UNREADABLE
    }

    record Snapshot(Origin origin, KungFuConfigMigration.Values legacyValues) {
        Snapshot {
            Objects.requireNonNull(origin, "origin");
            Objects.requireNonNull(legacyValues, "legacyValues");
        }

        static Snapshot freshAbsent() {
            return new Snapshot(Origin.FRESH_ABSENT, KungFuConfigMigration.LEGACY_DEFAULTS);
        }

        static Snapshot legacyPreSchema(KungFuConfigMigration.Values values) {
            return new Snapshot(Origin.LEGACY_PRE_SCHEMA, values);
        }

        static Snapshot modern() {
            return new Snapshot(Origin.MODERN, KungFuConfigMigration.LEGACY_DEFAULTS);
        }

        static Snapshot unreadable() {
            return new Snapshot(Origin.UNREADABLE, KungFuConfigMigration.LEGACY_DEFAULTS);
        }
    }

    private record ProbeResult(Snapshot snapshot, String failureType) {
    }
}
