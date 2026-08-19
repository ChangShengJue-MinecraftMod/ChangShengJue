package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.Set;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QingPingJiSuppressionPersistenceGameTests {
    private QingPingJiSuppressionPersistenceGameTests() {
    }

    @GameTest(template = "empty")
    public static void suppressionMarkerSurvivesNbtRoundTrip(GameTestHelper helper) {
        CompoundTag persistentData = new CompoundTag();
        Set<String> expected = Set.of("chang_sheng_jue:test_internal_a", "chang_sheng_jue:test_internal_b");

        QingPingJi.writePersistedSuppressedInternal(persistentData, expected);
        Set<String> restored = QingPingJi.readPersistedSuppressedInternal(persistentData.copy());

        helper.assertTrue(restored.equals(expected),
                "suppression marker must survive an entity persisted-data round trip");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void suppressionMarkerIsOptionalAndClearable(GameTestHelper helper) {
        CompoundTag persistentData = new CompoundTag();
        helper.assertTrue(QingPingJi.readPersistedSuppressedInternal(persistentData).isEmpty(),
                "old saves without a marker must remain safe");

        QingPingJi.writePersistedSuppressedInternal(
                persistentData, Set.of("chang_sheng_jue:test_internal"));
        QingPingJi.writePersistedSuppressedInternal(persistentData, Set.of());

        helper.assertTrue(QingPingJi.readPersistedSuppressedInternal(persistentData).isEmpty(),
                "normal restoration must clear the suppression marker");
        helper.succeed();
    }
}
