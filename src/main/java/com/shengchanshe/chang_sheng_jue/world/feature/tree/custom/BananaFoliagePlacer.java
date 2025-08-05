package com.shengchanshe.chang_sheng_jue.world.feature.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.world.feature.CSJFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class BananaFoliagePlacer extends FoliagePlacer {
    public static final Codec<BananaFoliagePlacer> CODEC = RecordCodecBuilder.create(pineFoliagePlacerInstance
            -> foliagePlacerParts(pineFoliagePlacerInstance).and(Codec.intRange(0, 16).fieldOf("poplar_height")
            .forGetter(fp -> fp.height)).apply(pineFoliagePlacerInstance, BananaFoliagePlacer::new));

    private final int height;

    public BananaFoliagePlacer(IntProvider pRadius, IntProvider pOffset , int height) {
         super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return CSJFoliagePlacers.BANANA_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -1, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -2, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -3, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -4, pAttachment.doubleTrunk());

        // 确定最后一层树叶的位置
        BlockPos basePos = pAttachment.pos().below(5);
        // 生成果实
        placeFruit(pLevel, pBlockSetter, pRandom, basePos);
    }

    protected void placeFruit(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, BlockPos pos) {
        // 选择果实的类型
        BlockState fruitState = ChangShengJueBlocks.BANANA_FRUIT.get().defaultBlockState(); // 确保这个方块状态是存在的，如果没有苹果方块，选择其他方块

        // 放置果实
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        for (int dx = -1; dx <= 1; dx++) {
            for (int dz = -1; dz <= 1; dz++) {
                mutablePos.set(pos.getX() + dx, pos.getY(), pos.getZ() + dz);

                // 检查该位置是否为树叶
                if (pLevel.isStateAtPosition(mutablePos.above(), state -> state.getBlock() instanceof LeavesBlock)) {
                    if (pRandom.nextFloat() < 0.3) { // 使用随机数决定是否替换树叶为果实
                        pBlockSetter.set(mutablePos, fruitState); // 替换为果实
                    }
                }
            }
        }
    }
    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pLocalX == pRange && pLocalZ == pRange && pRange > 0;
    }
}
