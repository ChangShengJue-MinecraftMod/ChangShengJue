package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class GableRidgeCylinderTile extends CylinderTile {
    public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_BOTTOM_N = Block.box(0, 0, 7, 16, 16, 16);
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_BOTTOM_E = Block.box(0, 0, 0, 9, 16, 16);
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_BOTTOM_S = Block.box(0, 0, 0, 16, 16, 9);
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_BOTTOM_W = Block.box(7, 0, 0, 16, 16, 16);
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_TOP_N;
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_TOP_E;
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_TOP_S;
    public static final VoxelShape GABLE_RIDGE_CYLINDER_TILE_TOP_W;
    public GableRidgeCylinderTile(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, Half.BOTTOM));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        Direction value = state.getValue(FACING);
        Half value1 = state.getValue(HALF);
        return switch (value){
            case NORTH -> value1 == Half.BOTTOM ? GABLE_RIDGE_CYLINDER_TILE_BOTTOM_N : GABLE_RIDGE_CYLINDER_TILE_TOP_N;
            case EAST -> value1 == Half.BOTTOM ? GABLE_RIDGE_CYLINDER_TILE_BOTTOM_E : GABLE_RIDGE_CYLINDER_TILE_TOP_E;
            case SOUTH -> value1 == Half.BOTTOM ? GABLE_RIDGE_CYLINDER_TILE_BOTTOM_S : GABLE_RIDGE_CYLINDER_TILE_TOP_S;
            default -> value1 == Half.BOTTOM ? GABLE_RIDGE_CYLINDER_TILE_BOTTOM_W : GABLE_RIDGE_CYLINDER_TILE_TOP_W;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction direction = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = this.defaultBlockState().setValue(FACING,pContext.getHorizontalDirection().getOpposite())
                .setValue(HALF,direction == Direction.DOWN || direction != Direction.UP && pContext.getClickLocation().y - (double)blockpos.getY() > 0.5 ? Half.TOP : Half.BOTTOM)
                .setValue(LEFT, direction == Direction.NORTH  && pContext.getClickLocation().x - (double)blockpos.getX() < 0.5 ||
                        direction == Direction.SOUTH && pContext.getClickLocation().x - (double)blockpos.getX() > 0.5 ? Boolean.TRUE :
                        direction == Direction.EAST  && pContext.getClickLocation().z - (double)blockpos.getZ() < 0.5 ||
                        direction == Direction.WEST && pContext.getClickLocation().z - (double)blockpos.getZ() > 0.5 ? Boolean.TRUE : Boolean.FALSE);
        return blockstate;
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return super.rotate(blockState,rotation);
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING,HALF,LEFT);
    }

    static {
        GABLE_RIDGE_CYLINDER_TILE_TOP_N = Stream.of(
                Block.box(0, -4, 8, 4, 4, 16),
                Block.box(4, 4, 7.5, 12, 12, 16.5),
                Block.box(12, -4, 8, 16, 4, 16),
                Block.box(9.94975, -2.29289, 9.1, 10.94975, 3.70711, 16.1),
                Block.box(1.05025, -3.29289, 9, 5.05025, 4.70711, 16),
                Block.box(6.05025, -1.29289, 9, 7.05025, 2.70711, 16),
                Block.box(10.94975, -3.29289, 9.1, 14.94975, 4.70711, 16.1),
                Block.box(8.94975, -1.29289, 9.1, 9.94975, 2.70711, 16.1),
                Block.box(5.05025, -2.29289, 9, 6.05025, 3.70711, 16)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        GABLE_RIDGE_CYLINDER_TILE_TOP_E = Stream.of(
                Block.box(0, -4, 0, 8, 4, 4),
                Block.box(-0.5, 4, 4, 8.5, 12, 12),
                Block.box(0, -4, 12, 8, 4, 16),
                Block.box(-0.10000000000000142, -2.29289, 9.94975, 6.9, 3.70711, 10.94975),
                Block.box(0, -3.29289, 1.0502500000000001, 7, 4.70711, 5.05025),
                Block.box(0, -1.29289, 6.05025, 7, 2.70711, 7.05025),
                Block.box(-0.10000000000000142, -3.29289, 10.94975, 6.9, 4.70711, 14.94975),
                Block.box(-0.10000000000000142, -1.29289, 8.94975, 6.9, 2.70711, 9.94975),
                Block.box(0, -2.29289, 5.05025, 7, 3.70711, 6.05025)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        GABLE_RIDGE_CYLINDER_TILE_TOP_S = Stream.of(
                Block.box(12, -4, 0, 16, 4, 8),
                Block.box(4, 4, -0.5, 12, 12, 8.5),
                Block.box(0, -4, 0, 4, 4, 8),
                Block.box(5.05025, -2.29289, -0.10000000000000142, 6.05025, 3.70711, 6.9),
                Block.box(10.94975, -3.29289, 0, 14.94975, 4.70711, 7),
                Block.box(8.94975, -1.29289, 0, 9.94975, 2.70711, 7),
                Block.box(1.0502500000000001, -3.29289, -0.10000000000000142, 5.05025, 4.70711, 6.9),
                Block.box(6.05025, -1.29289, -0.10000000000000142, 7.05025, 2.70711, 6.9),
                Block.box(9.94975, -2.29289, 0, 10.94975, 3.70711, 7)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

        GABLE_RIDGE_CYLINDER_TILE_TOP_W = Stream.of(
                Block.box(8, -4, 12, 16, 4, 16),
                Block.box(7.5, 4, 4, 16.5, 12, 12),
                Block.box(8, -4, 0, 16, 4, 4),
                Block.box(9.1, -2.29289, 5.05025, 16.1, 3.70711, 6.05025),
                Block.box(9, -3.29289, 10.94975, 16, 4.70711, 14.94975),
                Block.box(9, -1.29289, 8.94975, 16, 2.70711, 9.94975),
                Block.box(9.1, -3.29289, 1.0502500000000001, 16.1, 4.70711, 5.05025),
                Block.box(9.1, -1.29289, 6.05025, 16.1, 2.70711, 7.05025),
                Block.box(9, -2.29289, 9.94975, 16, 3.70711, 10.94975)
        ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    }
}
