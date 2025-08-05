package com.shengchanshe.chang_sheng_jue.block.tree_logs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class BananaFruit extends LeavesBlock {
    public BananaFruit(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Stream.of(
                Block.box(8, 3.979999999999997, 0, 8, 19.979999999999997, 16),
                Block.box(8, 3.979999999999997, 0, 8, 19.979999999999997, 16),
                Block.box(8, 3.979999999999997, 0, 8, 19.979999999999997, 16),
                Block.box(0, 3.979999999999997, 8, 16, 19.979999999999997, 8),
                Block.box(6, 0, 6, 10, 32, 10)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }
}
