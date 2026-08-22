package com.shengchanshe.chang_sheng_jue.gametest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.CastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.loom.ChangShengJueLoomBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheelEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.tool_table.ToolTableEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class LegacyDeviceNbtBoundsGameTests {
    private LegacyDeviceNbtBoundsGameTests() {
    }

    @GameTest(template = "empty")
    public static void legacyDeviceProgressIsClampedOnLoad(GameTestHelper helper) {
        assertProgressBounds(helper, new ChangShengJueLoomBlockEntity(BlockPos.ZERO,
                ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get().defaultBlockState()),
                "LoomBlockProgress", 100, "loom");
        assertProgressBounds(helper, new CastingMoldsBlockEntity(BlockPos.ZERO,
                ChangShengJueBlocks.CASTING_MOLDS.get().defaultBlockState()),
                "CastingMoldsProgress", 300, "casting molds");
        assertProgressBounds(helper, new BullionsCastingMoldsBlockEntity(BlockPos.ZERO,
                ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get().defaultBlockState()),
                "LngotMoldsProgress", 300, "bullion casting molds");
        assertProgressBounds(helper, new PotteryWheelEntity(BlockPos.ZERO,
                ChangShengJueBlocks.POTTERY_WHEEL.get().defaultBlockState()),
                "PotteryProgress", 200, "pottery wheel");
        assertProgressBounds(helper, new ToolTableEntity(BlockPos.ZERO,
                ChangShengJueBlocks.TOOL_TABLE.get().defaultBlockState()),
                "ToolTableProgress", 200, "tool table");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void castingMoldsParticleQueueIsClampedOnLoad(GameTestHelper helper) {
        CastingMoldsBlockEntity entity = new CastingMoldsBlockEntity(BlockPos.ZERO,
                ChangShengJueBlocks.CASTING_MOLDS.get().defaultBlockState());
        CompoundTag negative = new CompoundTag();
        negative.putInt("ParticleSpawnTimer", Integer.MIN_VALUE);
        negative.putInt("ParticlesToSpawn", -1);
        entity.load(negative);
        CompoundTag negativeSaved = entity.saveWithFullMetadata();
        helper.assertTrue(negativeSaved.getInt("ParticleSpawnTimer") == 0
                        && negativeSaved.getInt("ParticlesToSpawn") == 0,
                "negative particle queue state was not clamped to zero");

        CompoundTag oversized = new CompoundTag();
        oversized.putInt("ParticleSpawnTimer", Integer.MAX_VALUE);
        oversized.putInt("ParticlesToSpawn", Integer.MAX_VALUE);
        entity.load(oversized);
        CompoundTag oversizedSaved = entity.saveWithFullMetadata();
        helper.assertTrue(oversizedSaved.getInt("ParticleSpawnTimer") == 3
                        && oversizedSaved.getInt("ParticlesToSpawn") == 5,
                "oversized particle queue state exceeded its runtime bounds");
        helper.succeed();
    }

    private static void assertProgressBounds(GameTestHelper helper, BlockEntity entity,
                                             String key, int maximum, String device) {
        CompoundTag negative = new CompoundTag();
        negative.putInt(key, Integer.MIN_VALUE);
        entity.load(negative);
        helper.assertTrue(entity.saveWithFullMetadata().getInt(key) == 0,
                device + " accepted negative progress");

        CompoundTag oversized = new CompoundTag();
        oversized.putInt(key, Integer.MAX_VALUE);
        entity.load(oversized);
        helper.assertTrue(entity.saveWithFullMetadata().getInt(key) == maximum,
                device + " accepted progress above its maximum");

        CompoundTag boundary = new CompoundTag();
        boundary.putInt(key, maximum);
        entity.load(boundary);
        helper.assertTrue(entity.saveWithFullMetadata().getInt(key) == maximum,
                device + " changed a valid maximum progress value");
    }
}
