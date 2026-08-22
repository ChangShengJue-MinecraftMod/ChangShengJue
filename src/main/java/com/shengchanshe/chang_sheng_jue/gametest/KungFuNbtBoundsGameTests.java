package com.shengchanshe.chang_sheng_jue.gametest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.KungFuCapability;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFuUpgradable;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.TurtleBreathWork;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.GoldenBellJar;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.WanXiangBaoShu;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.List;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class KungFuNbtBoundsGameTests {
    private KungFuNbtBoundsGameTests() {
    }

    @GameTest(template = "empty")
    public static void allKungFuCategoriesSanitizeMalformedNumericState(GameTestHelper helper) {
        List<IKungFu> kungFuTypes = List.of(
                new TurtleBreathWork(),
                new GoldenBellJar(),
                new TreadTheSnowWithoutTrace(),
                new WanXiangBaoShu()
        );
        for (IKungFu kungFu : kungFuTypes) {
            CompoundTag malformed = kungFu.serializeNBT();
            malformed.putInt("KungFuLevel", Integer.MIN_VALUE);
            malformed.putInt("KungFuExp", Integer.MAX_VALUE);
            malformed.putInt("KungFuCooldown", Integer.MAX_VALUE);
            malformed.putInt("KungFuComprehendTick", Integer.MIN_VALUE);
            malformed.putInt("KungFuLevelUpTick", Integer.MAX_VALUE);
            malformed.putInt("KungFuHunger", Integer.MIN_VALUE);
            malformed.putFloat("KungFuDamage", Float.NaN);
            malformed.putFloat("KungFuSaturation", Float.NEGATIVE_INFINITY);
            malformed.putFloat("KungFuEffectProbability", Float.POSITIVE_INFINITY);
            malformed.putFloat("KungFuCooldownFactor", Float.NaN);
            if (malformed.contains("KungFuSwingTick")) {
                malformed.putInt("KungFuSwingTick", Integer.MIN_VALUE);
            }

            kungFu.deserializeNBT(malformed);
            CompoundTag sanitized = kungFu.serializeNBT();
            IKungFuUpgradable upgradable = (IKungFuUpgradable) kungFu;
            helper.assertTrue(sanitized.getInt("KungFuLevel") == 0,
                    kungFu.getId() + " retained a negative level");
            helper.assertTrue(sanitized.getInt("KungFuExp") == upgradable.getMaxExp(),
                    kungFu.getId() + " did not clamp experience to its configured maximum");
            helper.assertTrue(sanitized.getInt("KungFuCooldown") == Math.max(0, kungFu.getMaxCoolDown()),
                    kungFu.getId() + " did not clamp cooldown to its configured maximum");
            helper.assertTrue(sanitized.getInt("KungFuComprehendTick") == 0
                            && sanitized.getInt("KungFuLevelUpTick") == 29,
                    kungFu.getId() + " retained invalid animation tick counters");
            helper.assertTrue(sanitized.getInt("KungFuHunger") == 0,
                    kungFu.getId() + " retained a negative hunger cost");
            assertFiniteNonNegative(helper, sanitized, "KungFuDamage", kungFu.getId());
            assertFiniteNonNegative(helper, sanitized, "KungFuSaturation", kungFu.getId());
            assertFiniteNonNegative(helper, sanitized, "KungFuCooldownFactor", kungFu.getId());
            float probability = sanitized.getFloat("KungFuEffectProbability");
            helper.assertTrue(Float.isFinite(probability) && probability >= 0.0F && probability <= 1.0F,
                    kungFu.getId() + " retained an invalid effect probability");
            if (sanitized.contains("KungFuSwingTick")) {
                helper.assertTrue(sanitized.getInt("KungFuSwingTick") == 0,
                        kungFu.getId() + " retained a negative swing tick");
            }
        }
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void kungFuCapabilityRejectsCanonicalTypeMismatch(GameTestHelper helper) {
        TurtleBreathWork kungFu = new TurtleBreathWork();
        CompoundTag wrongType = kungFu.serializeNBT();
        wrongType.putString("KungFuType", "INTERNAL_KUNGFU");
        ListTag entries = new ListTag();
        entries.add(wrongType);
        CompoundTag saved = new CompoundTag();
        saved.put("LearnedKungFu", entries);

        KungFuCapability capability = new KungFuCapability();
        capability.deserializeNBT(saved);
        helper.assertTrue(capability.getKungFu(kungFu.getId()).isEmpty(),
                "kung fu capability accepted a saved entry with a forged type");
        helper.succeed();
    }

    private static void assertFiniteNonNegative(GameTestHelper helper, CompoundTag tag,
                                                String key, String kungFuId) {
        float value = tag.getFloat(key);
        helper.assertTrue(Float.isFinite(value) && value >= 0.0F,
                kungFuId + " retained invalid " + key);
    }
}
