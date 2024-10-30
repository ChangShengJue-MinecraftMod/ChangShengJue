package com.shengchanshe.changshengjue.world.biome.surface;

import com.shengchanshe.changshengjue.world.biome.CSJBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class CSJSurFaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        // 定义草地表面规则，只有在地面且水平面以上时才应用草方块，否则应用泥土
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(isAtOrAboveWaterLevel,
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)
                ),
                DIRT
        );
        // 最终的表面规则序列
        return SurfaceRules.sequence(
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(CSJBiomes.CHANG_SHEN_JUE_PRAIRIE),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRASS_BLOCK)
                        ),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, AIR)
                ),
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
        );
    }
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}
