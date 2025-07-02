package com.shengchanshe.chang_sheng_jue.world.feature.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.shengchanshe.chang_sheng_jue.world.feature.CSJFoliagePlacers;
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

//    public static final Codec<PoplarFoliagePlacer> CODEC = RecordCodecBuilder.create((p_68735_) -> foliagePlacerParts(p_68735_).and(IntProvider.codec(0, 16)
//            .fieldOf("poplar_height").forGetter((p_161553_) -> p_161553_.height)).apply(p_68735_, PoplarFoliagePlacer::new));

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
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 0, 0, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -1, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 2, -2, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -3, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 2, -4, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 2, -5, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 2, -6, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -7, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 2, -8, pAttachment.doubleTrunk());
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos(), 1, -9, pAttachment.doubleTrunk());
        
//            BlockPos blockpos = pAttachment.pos();
//            int i = 0;
//            for(int l = pOffset; l >= -pFoliageHeight; --l) {
//                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, l, pAttachment.doubleTrunk());
//                if (i > pFoliageRadius / 2){
//                    --i;
//                }else {
//                    ++i;
//                }
//            }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
//        return pLocalX == pRange && pLocalZ == pRange && pRange > 0;
        return pLocalX == pRange && pLocalZ == pRange && (pRange > 0 && pLocalY != -3 && pLocalY != -5 && pLocalY != -7);
//        return false;
    }
}
