package com.shengchanshe.changshengjue.world.feature.tree;

import com.shengchanshe.changshengjue.world.feature.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GuiHuaTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return ModConfiguredFeatures.GUIHUA_TREE;
    }
//    @Nullable
//    @Override
//    protected ConfiguredFeature<?, ?> getConfiguredFeature(Random p_60014_, boolean p_60015_) {
//        return ModConfiguredFeatures.GUIHUA_TREE;
//    }
}
