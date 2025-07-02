package com.shengchanshe.chang_sheng_jue.world.feature.tree;

import com.shengchanshe.chang_sheng_jue.world.feature.CSJConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class JiChiMuTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return CSJConfiguredFeatures.JICHIMU_TREE;
    }
//    @Nullable
//    @Override
//    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random p_60014_, boolean p_60015_) {
//        return ModConfiguredFeatures.GUIHUA_TREE;
//    }
}
