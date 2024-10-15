package com.shengchanshe.changshengjue.block.building;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ChangShengJueLoomBlock extends HorizontalDirectionalBlock {
    private VoxelShape AABB = Shapes.empty();

    public ChangShengJueLoomBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        return switch (value){
            case SOUTH -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_SOUTH;
            case WEST -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_WEST;
            case EAST -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_EAST;
            default -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_NORTH;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
