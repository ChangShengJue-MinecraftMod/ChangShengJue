package com.shengchanshe.changshengjue.block.custom.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

public class BevelCylinderTile extends CylinderTile {
    public static final BooleanProperty HAS_SAME_BLOCK_DIAGONAL = BooleanProperty.create("has_same_block_diagonal");

    public BevelCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HAS_SAME_BLOCK_DIAGONAL, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HAS_SAME_BLOCK_DIAGONAL,FACING);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state;
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        // 检查斜对角位置的方块
        BlockPos diagonalPos1 = pPos.offset(1, 0, 1); // 右前斜对角
        BlockPos diagonalPos2 = pPos.offset(-1, 0, 1); // 左前斜对角
        BlockPos diagonalPos3 = pPos.offset(1, 0, -1); // 右后斜对角
        BlockPos diagonalPos4 = pPos.offset(-1, 0, -1); // 左后斜对角

        boolean hasSameBlockDiagonal1 = pLevel.getBlockState(diagonalPos1).is(this);
        boolean hasSameBlockDiagonal2 = pLevel.getBlockState(diagonalPos2).is(this);
        boolean hasSameBlockDiagonal3 = pLevel.getBlockState(diagonalPos3).is(this);
        boolean hasSameBlockDiagonal4 = pLevel.getBlockState(diagonalPos4).is(this);

        // 计算斜对角位置相同方块的数量
        int sameBlockCount = (hasSameBlockDiagonal1 ? 1 : 0) + (hasSameBlockDiagonal2 ? 1 : 0) +
                (hasSameBlockDiagonal3 ? 1 : 0) + (hasSameBlockDiagonal4 ? 1 : 0);

        // 如果只有一个斜对角位置有相同方块，则更新状态
        boolean hasSingleSameBlockDiagonal = sameBlockCount == 1;

        // 根据斜对角是否有相同方块来更新状态
        BlockState newState = pState.setValue(HAS_SAME_BLOCK_DIAGONAL, hasSingleSameBlockDiagonal);
        pLevel.setBlock(pPos, newState, 3);
    }

}