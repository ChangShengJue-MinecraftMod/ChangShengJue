package com.shengchanshe.chang_sheng_jue.block.custom.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class OctagonalUpturnedEaves extends CylinderTile{
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final VoxelShape CYLINDER_TILE_RIGHT_N = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape CYLINDER_TILE_RIGHT_E = Block.box(0, 0, 8, 16, 16, 16);
    public static final VoxelShape CYLINDER_TILE_RIGHT_S = Block.box(0, 0, 0, 8, 16, 16);
    public static final VoxelShape CYLINDER_TILE_RIGHT_W = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape CYLINDER_TILE_LEFT_N = Block.box(0, 0, 0, 8, 16, 16);
    public static final VoxelShape CYLINDER_TILE_LEFT_E = Block.box(0, 0, 0, 16, 16, 8);
    public static final VoxelShape CYLINDER_TILE_LEFT_S = Block.box(8, 0, 0, 16, 16, 16);
    public static final VoxelShape CYLINDER_TILE_LEFT_W = Block.box(0, 0, 8, 16, 16, 16);

    public OctagonalUpturnedEaves(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        Direction value = state.getValue(FACING);
        Boolean value1 = state.getValue(LEFT);
        return switch (value){
            case NORTH -> value1 ? CYLINDER_TILE_LEFT_N : CYLINDER_TILE_RIGHT_N;
            case EAST -> value1 ? CYLINDER_TILE_LEFT_E : CYLINDER_TILE_RIGHT_E;
            case SOUTH -> value1 ? CYLINDER_TILE_LEFT_S : CYLINDER_TILE_RIGHT_S;
            default -> value1 ? CYLINDER_TILE_LEFT_W : CYLINDER_TILE_RIGHT_W;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Direction clickedFace = pContext.getClickedFace();
        BlockPos blockpos = pContext.getClickedPos();
        Vec3 clickLocation = pContext.getClickLocation();
        BlockState blockstate = this.defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite());
        boolean isLeft = false;
        if (clickedFace.getAxis() == Direction.Axis.X) {
            isLeft = clickLocation.z - (double)blockpos.getZ() > 0.5;
        } else if (clickedFace.getAxis() == Direction.Axis.Z) {
            isLeft = clickLocation.x - (double)blockpos.getX() < 0.5;
        }else if (clickedFace.getAxis() == Direction.Axis.Y){
            isLeft = clickLocation.x - (double)blockpos.getX() > 0.5;
        }
        return blockstate.setValue(LEFT, isLeft);
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
        builder.add(FACING,LEFT);
    }
}
