package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

import java.util.Objects;

/**
 * 纯 Java 的配置迁移判定，不读取文件或 Forge 状态。
 */
public final class KungFuConfigMigration {
    public static final int CURRENT_SCHEMA_VERSION = 1;

    public static final Values LEGACY_DEFAULTS = new Values(2, 100, 160, 2, 100, 100, 100);
    public static final Values UNIQUE_DEFAULTS = new Values(2, 100, 160, 2, 100, 100, 1000);

    private KungFuConfigMigration() {
    }

    public static Plan decide(int schemaVersion, Values legacyValues, Values uniqueValues) {
        Objects.requireNonNull(legacyValues, "legacyValues");
        Objects.requireNonNull(uniqueValues, "uniqueValues");

        if (schemaVersion >= CURRENT_SCHEMA_VERSION) {
            return new Plan(Action.NO_CHANGE, schemaVersion, uniqueValues);
        }

        // Forge 可能在 Loading 事件前补齐新键；只有旧别名存在自定义值时才足以证明是旧配置。
        if (uniqueValues.equals(UNIQUE_DEFAULTS) && !legacyValues.equals(LEGACY_DEFAULTS)) {
            return new Plan(Action.COPY_LEGACY_VALUES, CURRENT_SCHEMA_VERSION, legacyValues);
        }

        return new Plan(Action.KEEP_UNIQUE_VALUES, CURRENT_SCHEMA_VERSION, uniqueValues);
    }

    static Plan decide(
            KungFuConfigOriginProbe.Origin origin,
            int schemaVersion,
            Values legacyValues,
            Values uniqueValues
    ) {
        Objects.requireNonNull(origin, "origin");
        Objects.requireNonNull(legacyValues, "legacyValues");
        Objects.requireNonNull(uniqueValues, "uniqueValues");

        if (origin == KungFuConfigOriginProbe.Origin.UNREADABLE) {
            return new Plan(Action.NO_CHANGE, schemaVersion, uniqueValues);
        }
        if (schemaVersion >= CURRENT_SCHEMA_VERSION) {
            return new Plan(Action.NO_CHANGE, schemaVersion, uniqueValues);
        }
        if (origin == KungFuConfigOriginProbe.Origin.LEGACY_PRE_SCHEMA) {
            return new Plan(Action.COPY_LEGACY_VALUES, CURRENT_SCHEMA_VERSION, legacyValues);
        }
        return new Plan(Action.KEEP_UNIQUE_VALUES, CURRENT_SCHEMA_VERSION, uniqueValues);
    }

    public enum Action {
        NO_CHANGE,
        COPY_LEGACY_VALUES,
        KEEP_UNIQUE_VALUES
    }

    public record Plan(Action action, int targetSchemaVersion, Values values) {
    }

    public record Values(
            int goldenBellMaxLevel,
            int goldenBellMaxExp,
            int goldenBellMaxCooldown,
            int treadMaxLevel,
            int treadMaxExp,
            int treadMaxCooldown,
            int zaBingMaxExp
    ) {
        public Values {
            if (goldenBellMaxLevel < 0 || goldenBellMaxExp < 0 || goldenBellMaxCooldown < 0
                    || treadMaxLevel < 0 || treadMaxExp < 0 || treadMaxCooldown < 0 || zaBingMaxExp < 0) {
                throw new IllegalArgumentException("Configuration values must be non-negative");
            }
        }
    }
}
