package com.shengchanshe.changshengjue.world.feature.tree.custom;

import com.mojang.serialization.Codec;
import com.shengchanshe.changshengjue.world.feature.CSJFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;

import java.util.List;
import java.util.Random;

public class PoplarDecorator extends TreeDecorator {
    public static final Codec<PoplarDecorator> CODEC = Codec.unit(() -> PoplarDecorator.INSTANCE);
    public static final PoplarDecorator INSTANCE = new PoplarDecorator();

    @Override
    protected TreeDecoratorType<?> type() {
        return null
                ;
//                CSJFoliagePlacers.POPLAR_DECORATOR.get();
    }

    @Override
    public void place(Context pContext) {
        List<BlockPos> logPositions = pContext.logs();

        // 遍历所有的树干位置
        for (BlockPos logPos : logPositions) {
            // 计算树干下方的位置
            BlockPos belowPos = logPos.below();
            // 检查下方位置是否为空
                // 设置落叶块状态，这里使用橡树落叶作为示例
                BlockState leavesState = Blocks.OAK_LEAVES.defaultBlockState();
                // 使用BiConsumer来设置世界中的块状态
                pContext.setBlock(belowPos, leavesState);
        }
    }
}
