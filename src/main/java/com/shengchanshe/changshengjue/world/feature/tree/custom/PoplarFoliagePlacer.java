package com.shengchanshe.changshengjue.world.feature.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shengchanshe.changshengjue.world.feature.CSJFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PoplarFoliagePlacer extends FoliagePlacer {
    public static final Codec<PoplarFoliagePlacer> CODEC = RecordCodecBuilder.create(pineFoliagePlacerInstance
            -> foliagePlacerParts(pineFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("poplar_height")
            .forGetter(fp -> fp.height)).apply(pineFoliagePlacerInstance, PoplarFoliagePlacer::new));

    private final int height;

    public PoplarFoliagePlacer(IntProvider pRadius, IntProvider pOffset , int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return CSJFoliagePlacers.POPLAR_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        BlockPos blockpos = pAttachment.pos();
        int i = pRandom.nextInt(2);
        int j = 1;
        int k = 0;
        int maxRadius = pFoliageRadius + pAttachment.radiusOffset(); // 最大半径
        boolean increasing = true; // 控制递增/递减

        for (int l = pOffset; l >= -pFoliageHeight; --l) {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, l, pAttachment.doubleTrunk());

            // 更新逻辑
            if (increasing) {
                if (i >= j) {
                    i = k; // 重置i
                    k = 1; // 开始新的半径
                    j = Math.min(j + 1, maxRadius); // 增加j，直到最大半径
                } else {
                    ++i; // 递增
                }
            } else {
                // 递减部分
                if (i <= 1) {
                    increasing = true; // 达到最小半径后重新开始递增
                    i++;
                    j = 1; // 重置j
                } else {
                    --i; // 递减
                }
            }

            // 检查是否需要切换到递减
            if (i >= maxRadius) {
                increasing = false; // 达到最大半径后开始递减
            }
        }


//       BlockPos blockpos = pAttachment.pos();
//
//    for (int l = pOffset; l >= -pFoliageHeight; --l) {
//        // 每层的叶子半径
//        int foliageRadius = pRandom.nextInt(pFoliageRadius + 1); // 随机决定叶子半径
//
//        for (int dx = -foliageRadius; dx <= foliageRadius; ++dx) {
//            for (int dz = -foliageRadius; dz <= foliageRadius; ++dz) {
//                // 确定是否在当前(x, z)位置放置叶子
//                if (Math.abs(dx) == foliageRadius || Math.abs(dz) == foliageRadius) {
//                    // 对于最外圈的叶子，增加随机性，使某些方块缺失
//                    if (pRandom.nextFloat() < 0.7) { // 70%的概率生成叶子
//                        BlockPos leafPos = blockpos.offset(dx, l, dz);
//                        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, leafPos, 1, 0, pAttachment.doubleTrunk());
//                    }
//                } else {
//                    // 内层叶子全部生成
//                    BlockPos leafPos = blockpos.offset(dx, l, dz);
//                    this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, leafPos, 1, 0, pAttachment.doubleTrunk());
//                }
//            }
//        }
//    }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
