package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class OverLordFist extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private static final VoxelShape NORTH = Stream.of(
            Block.box(3, 0, 12, 13, 1, 16),
            Block.box(3, 1, 9, 13, 2, 16),
            Block.box(3, 2, 7, 13, 3, 16),
            Block.box(3, 3, 4, 13, 6, 16),
            Block.box(3, 6, 3, 13, 9, 16),
            Block.box(3, 9, 4, 13, 10, 16),
            Block.box(3, 10, 2, 13, 16, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SOUTH = Stream.of(
            Block.box(3, 0, 0, 13, 1, 4),
            Block.box(3, 1, 0, 13, 2, 7),
            Block.box(3, 2, 0, 13, 3, 9),
            Block.box(3, 3, 0, 13, 6, 12),
            Block.box(3, 6, 0, 13, 9, 13),
            Block.box(3, 9, 0, 13, 10, 12),
            Block.box(3, 10, 0, 13, 16, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape EAST = Stream.of(
            Block.box(0, 0, 3, 4, 1, 13),
            Block.box(0, 1, 3, 7, 2, 13),
            Block.box(0, 2, 3, 9, 3, 13),
            Block.box(0, 3, 3, 12, 6, 13),
            Block.box(0, 6, 3, 13, 9, 13),
            Block.box(0, 9, 3, 12, 10, 13),
            Block.box(0, 10, 3, 14, 16, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape WEST = Stream.of(
            Block.box(12, 0, 3, 16, 1, 13),
            Block.box(9, 1, 3, 16, 2, 13),
            Block.box(7, 2, 3, 16, 3, 13),
            Block.box(4, 3, 3, 16, 6, 13),
            Block.box(3, 6, 3, 16, 9, 13),
            Block.box(4, 9, 3, 16, 10, 13),
            Block.box(2, 10, 3, 16, 16, 13)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    public OverLordFist(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return NORTH;
            case SOUTH:
                return SOUTH;
            case EAST:
                return EAST;
            case WEST:
                return WEST;
            default:
                return NORTH;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
