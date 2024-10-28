package com.shengchanshe.changshengjue.world.feature.tree.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shengchanshe.changshengjue.world.feature.CSJTrunkPlacerTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PoplarTrunkPlacer extends TrunkPlacer {
    public static final Codec<PoplarTrunkPlacer> CODEC = RecordCodecBuilder.create(pineTrunkPlacerInstance ->
            trunkPlacerParts(pineTrunkPlacerInstance).apply(pineTrunkPlacerInstance, PoplarTrunkPlacer::new));

    public PoplarTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return CSJTrunkPlacerTypes.POPLAR_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        setDirtAt(pLevel,pBlockSetter,pRandom,pPos.below(),pConfig);
        int height = pFreeTreeHeight + pRandom.nextInt(heightRandA, heightRandA + 3) + pRandom.nextInt(heightRandB - 1, heightRandB + 1);

        for (int i = 0; i < height; i++){
            placeLog(pLevel,pBlockSetter,pRandom,pPos.above(i),pConfig);
            if(i % 2 == 0 && i > 6 && pRandom.nextBoolean()) {
                int i1 = pRandom.nextInt(2) + 1;
                if(pRandom.nextFloat() > 0.25f) {
                    for (int x = 0; x < i1; x++) {
                        pBlockSetter.accept(pPos.above(i).relative(Direction.NORTH, x), ((BlockState)
                                Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                    }
                }
                if(pRandom.nextFloat() > 0.25f) {
                    for (int x = 0; x < i1; x++) {
                        pBlockSetter.accept(pPos.above(i).relative(Direction.SOUTH, x), ((BlockState)
                                Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                    }
                }
                if(pRandom.nextFloat() > 0.25f) {
                    for (int x = 0; x < i1; x++) {
                        pBlockSetter.accept(pPos.above(i).relative(Direction.EAST, x), ((BlockState)
                                Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                    }
                }
                if(pRandom.nextFloat() > 0.25f) {
                    for (int x = 0; x < i1; x++) {
                        pBlockSetter.accept(pPos.above(i).relative(Direction.WEST, x), ((BlockState)
                                Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X))));
                    }
                }
            }
        }
        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height) , 0 , false));
    }
}
