package com.shengchanshe.changshengjue.world.feature.tree;

import com.shengchanshe.changshengjue.world.feature.CSJConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class MulberryTreeGrower extends AbstractTreeGrower {
//    @Nullable
//    @Override
//    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random p_60014_, boolean p_60015_) {
//        return ModConfiguredFeatures.PEAR_TREE;
//    }
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return CSJConfiguredFeatures.MULBERRY_TREE;
    }
}
