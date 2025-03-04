package com.shengchanshe.changshengjue.block.custom;

import com.shengchanshe.changshengjue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Desk extends HorizontalDirectionalBlock {
    private VoxelShape AABB = Shapes.empty();
    //案台
    public static final VoxelShape CHANG_SHENG_JUE_DESK_NORTH;
    public static final VoxelShape CHANG_SHENG_JUE_DESK_EAST;
    public static final VoxelShape CHANG_SHENG_JUE_DESK_SOUTH;
    public static final VoxelShape CHANG_SHENG_JUE_DESK_WEST;

    public Desk(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        return switch (value){
            case SOUTH -> this.AABB = CHANG_SHENG_JUE_DESK_SOUTH;
            case WEST -> this.AABB = CHANG_SHENG_JUE_DESK_WEST;
            case EAST -> this.AABB = CHANG_SHENG_JUE_DESK_EAST;
            default -> this.AABB = CHANG_SHENG_JUE_DESK_NORTH;
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

    static {
        CHANG_SHENG_JUE_DESK_NORTH = Stream.of(
                Block.box(0, 13.75, 2, 16, 15.75, 14),
                Block.box(1, 11.75, 3, 15, 13.75, 13),
                Block.box(0, 15.75, 2, 1, 16.75, 14),
                Block.box(15, 15.75, 2, 16, 16.75, 14),
                Block.box(1.25, -0.25, 3, 3.25, 12, 13),
                Block.box(12.75, -0.25, 3, 14.75, 12, 13),
                Block.box(1, 15.9, 3, 9, 15.9, 13),
                Block.box(4, 15.949999999999998, 3, 12, 15.949999999999998, 13),
                Block.box(5.5, 15.8, 3, 13.5, 15.8, 13)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        CHANG_SHENG_JUE_DESK_EAST = Stream.of(
                Block.box(2, 13.75, 0, 14, 15.75, 16),
                Block.box(3, 11.75, 1, 13, 13.75, 15),
                Block.box(2, 15.75, 0, 14, 16.75, 1),
                Block.box(2, 15.75, 15, 14, 16.75, 16),
                Block.box(3, -0.25, 1.25, 13, 12, 3.25),
                Block.box(3, -0.25, 12.75, 13, 12, 14.75),
                Block.box(1.9280701703934433, 15.9, 1.6110448348312287, 11.928070170393445, 15.9, 9.611044834831237),
                Block.box(3, 15.949999999999998, 4, 13, 15.949999999999998, 12),
                Block.box(4.353553390593273, 15.8, 5.7677669529663635, 14.353553390593275, 15.8, 13.767766952966367)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        CHANG_SHENG_JUE_DESK_SOUTH = Stream.of(
                Block.box(0, 13.75, 2, 16, 15.75, 14),
                Block.box(1, 11.75, 3, 15, 13.75, 13),
                Block.box(15, 15.75, 2, 16, 16.75, 14),
                Block.box(0, 15.75, 2, 1, 16.75, 14),
                Block.box(12.75, -0.25, 3, 14.75, 12, 13),
                Block.box(1.25, -0.25, 3, 3.25, 12, 13),
                Block.box(6.388955165168763, 15.9, 1.9280701703934433, 14.38895516516877, 15.9, 11.928070170393445),
                Block.box(4, 15.949999999999998, 3, 12, 15.949999999999998, 13),
                Block.box(2.232233047033633, 15.8, 4.353553390593273, 10.232233047033636, 15.8, 14.353553390593275)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        CHANG_SHENG_JUE_DESK_WEST = Stream.of(
                Block.box(2, 13.75, 0, 14, 15.75, 16),
                Block.box(3, 11.75, 1, 13, 13.75, 15),
                Block.box(2, 15.75, 15, 14, 16.75, 16),
                Block.box(2, 15.75, 0, 14, 16.75, 1),
                Block.box(3, -0.25, 12.75, 13, 12, 14.75),
                Block.box(3, -0.25, 1.25, 13, 12, 3.25),
                Block.box(4.071929829606555, 15.9, 6.388955165168763, 14.071929829606557, 15.9, 14.38895516516877),
                Block.box(3, 15.949999999999998, 4, 13, 15.949999999999998, 12),
                Block.box(1.6464466094067252, 15.8, 2.232233047033633, 11.646446609406727, 15.8, 10.232233047033636)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }
}
