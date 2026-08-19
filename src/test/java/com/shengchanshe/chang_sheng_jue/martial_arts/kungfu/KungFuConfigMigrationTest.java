package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

public final class KungFuConfigMigrationTest {
    private KungFuConfigMigrationTest() {
    }

    public static void main(String[] args) throws Exception {
        assertPlan(
                KungFuConfigMigration.Action.KEEP_UNIQUE_VALUES,
                KungFuConfigMigration.UNIQUE_DEFAULTS,
                KungFuConfigMigration.decide(
                        0,
                        KungFuConfigMigration.LEGACY_DEFAULTS,
                        KungFuConfigMigration.UNIQUE_DEFAULTS
                ),
                "fresh config"
        );

        var legacyCustomValues = new KungFuConfigMigration.Values(3, 250, 90, 4, 300, 60, 450);
        assertPlan(
                KungFuConfigMigration.Action.COPY_LEGACY_VALUES,
                legacyCustomValues,
                KungFuConfigMigration.decide(0, legacyCustomValues, KungFuConfigMigration.UNIQUE_DEFAULTS),
                "0.7.9 custom aliases"
        );

        var uniqueCustomValues = new KungFuConfigMigration.Values(5, 500, 80, 6, 600, 40, 1200);
        assertPlan(
                KungFuConfigMigration.Action.KEEP_UNIQUE_VALUES,
                uniqueCustomValues,
                KungFuConfigMigration.decide(0, legacyCustomValues, uniqueCustomValues),
                "explicit unique values"
        );

        assertPlan(
                KungFuConfigMigration.Action.NO_CHANGE,
                uniqueCustomValues,
                KungFuConfigMigration.decide(1, legacyCustomValues, uniqueCustomValues),
                "second load"
        );

        assertPlan(
                KungFuConfigMigration.Action.KEEP_UNIQUE_VALUES,
                KungFuConfigMigration.UNIQUE_DEFAULTS,
                KungFuConfigMigration.decide(
                        KungFuConfigOriginProbe.Origin.FRESH_ABSENT,
                        0,
                        KungFuConfigMigration.LEGACY_DEFAULTS,
                        KungFuConfigMigration.UNIQUE_DEFAULTS),
                "fresh absent source"
        );
        assertPlan(
                KungFuConfigMigration.Action.COPY_LEGACY_VALUES,
                KungFuConfigMigration.LEGACY_DEFAULTS,
                KungFuConfigMigration.decide(
                        KungFuConfigOriginProbe.Origin.LEGACY_PRE_SCHEMA,
                        0,
                        KungFuConfigMigration.LEGACY_DEFAULTS,
                        KungFuConfigMigration.UNIQUE_DEFAULTS),
                "all-default 0.7.9 source"
        );
        assertPlan(
                KungFuConfigMigration.Action.COPY_LEGACY_VALUES,
                legacyCustomValues,
                KungFuConfigMigration.decide(
                        KungFuConfigOriginProbe.Origin.LEGACY_PRE_SCHEMA,
                        0,
                        legacyCustomValues,
                        KungFuConfigMigration.UNIQUE_DEFAULTS),
                "custom 0.7.9 source"
        );
        assertPlan(
                KungFuConfigMigration.Action.KEEP_UNIQUE_VALUES,
                uniqueCustomValues,
                KungFuConfigMigration.decide(
                        KungFuConfigOriginProbe.Origin.MODERN,
                        0,
                        legacyCustomValues,
                        uniqueCustomValues),
                "modern source"
        );
        var unreadable = KungFuConfigMigration.decide(
                KungFuConfigOriginProbe.Origin.UNREADABLE,
                0,
                legacyCustomValues,
                uniqueCustomValues);
        assertPlan(
                KungFuConfigMigration.Action.NO_CHANGE,
                uniqueCustomValues,
                unreadable,
                "unreadable source"
        );
        if (unreadable.targetSchemaVersion() != 0) {
            throw new AssertionError("unreadable source: schema must not advance");
        }

        KungFuConfigOriginProbeTest.runAll();
    }

    private static void assertPlan(
            KungFuConfigMigration.Action expected,
            KungFuConfigMigration.Values expectedValues,
            KungFuConfigMigration.Plan actual,
            String scenario
    ) {
        if (actual.action() != expected) {
            throw new AssertionError(scenario + ": expected " + expected + " but got " + actual.action());
        }
        if (!actual.values().equals(expectedValues)) {
            throw new AssertionError(scenario + ": resulting values do not match");
        }
        if (expected != KungFuConfigMigration.Action.NO_CHANGE
                && actual.targetSchemaVersion() != KungFuConfigMigration.CURRENT_SCHEMA_VERSION) {
            throw new AssertionError(scenario + ": schema was not advanced");
        }
    }
}
