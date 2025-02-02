package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class EescalatorBlock extends Block  {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public EescalatorBlock(Properties p_49795_) {
        super(p_49795_);
    }
    public static final VoxelShape EESCALATOR_N = Stream.of(Block.box(2.5, 1.25, 4.85, 13, 2.75, 6.35), Block.box(2.5, 5.25, 6.6, 13, 6.75, 8.1), Block.box(2.5, 9.25, 8.1, 13, 10.75, 9.6), Block.box(2.5, 13.25, 9.85, 13, 14.75, 11.35), Block.box(2.5, -2.75, 3.1, 13, -1.25, 4.6), Block.box(2.5, -14.75, -1.65, 13, -13.25, -0.15), Block.box(2.5, -10.75, -0.15, 13, -9.25, 1.35), Block.box(2.5, -6.75, 1.45, 13, -5.25, 2.95), Block.box(2.5, 29.25, 16.2, 13, 30.75, 17.7), Block.box(2.5, 17.25, 11.45, 13, 18.75, 12.95), Block.box(2.5, 21.25, 13.15, 13, 22.75, 14.65), Block.box(2.5, 25.25, 14.85, 13, 26.75, 16.35)).reduce(Shapes::or).get();
    public static final VoxelShape EESCALATOR_E = Stream.of(Block.box(9.674999999999999, 1.25, 2.5249999999999986, 11.174999999999999, 2.75, 13.024999999999999), Block.box(7.924999999999999, 5.25, 2.5249999999999986, 9.424999999999999, 6.75, 13.024999999999999), Block.box(6.424999999999999, 9.25, 2.5249999999999986, 7.924999999999999, 10.75, 13.024999999999999), Block.box(4.674999999999999, 13.25, 2.5249999999999986, 6.174999999999999, 14.75, 13.024999999999999), Block.box(11.424999999999999, -2.75, 2.5249999999999986, 12.924999999999999, -1.25, 13.024999999999999), Block.box(16.174999999999997, -14.75, 2.5249999999999986, 17.674999999999997, -13.25, 13.024999999999999), Block.box(14.674999999999999, -10.75, 2.5249999999999986, 16.174999999999997, -9.25, 13.024999999999999), Block.box(13.075, -6.75, 2.5249999999999986, 14.575, -5.25, 13.024999999999999), Block.box(-1.6750000000000007, 29.25, 2.5249999999999986, -0.1750000000000007, 30.75, 13.024999999999999), Block.box(3.0749999999999993, 17.25, 2.5249999999999986, 4.574999999999999, 18.75, 13.024999999999999), Block.box(1.3749999999999982, 21.25, 2.5249999999999986, 2.8749999999999982, 22.75, 13.024999999999999), Block.box(-0.32500000000000284, 25.25, 2.5249999999999986, 1.174999999999999, 26.75, 13.024999999999999)).reduce(Shapes::or).get();
    public static final VoxelShape EESCALATOR_S = Stream.of(Block.box(3, 1.25, 9.699999999999998, 13.5, 2.75, 11.199999999999998), Block.box(3, 5.25, 7.9499999999999975, 13.5, 6.75, 9.449999999999998), Block.box(3, 9.25, 6.4499999999999975, 13.5, 10.75, 7.9499999999999975), Block.box(3, 13.25, 4.6999999999999975, 13.5, 14.75, 6.1999999999999975), Block.box(3, -2.75, 11.449999999999998, 13.5, -1.25, 12.949999999999998), Block.box(3, -14.75, 16.199999999999996, 13.5, -13.25, 17.699999999999996), Block.box(3, -10.75, 14.699999999999998, 13.5, -9.25, 16.199999999999996), Block.box(3, -6.75, 13.099999999999998, 13.5, -5.25, 14.599999999999998), Block.box(3, 29.25, -1.6500000000000021, 13.5, 30.75, -0.15000000000000213), Block.box(3, 17.25, 3.099999999999998, 13.5, 18.75, 4.599999999999998), Block.box(3, 21.25, 1.3999999999999968, 13.5, 22.75, 2.899999999999997), Block.box(3, 25.25, -0.30000000000000426, 13.5, 26.75, 1.1999999999999975)).reduce(Shapes::or).get();
    public static final VoxelShape EESCALATOR_W = Stream.of(Block.box(4.825000000000001, 1.25, 3.0249999999999986, 6.325000000000001, 2.75, 13.524999999999999), Block.box(6.575000000000001, 5.25, 3.0249999999999986, 8.075000000000001, 6.75, 13.524999999999999), Block.box(8.075000000000001, 9.25, 3.0249999999999986, 9.575000000000001, 10.75, 13.524999999999999), Block.box(9.825000000000001, 13.25, 3.0249999999999986, 11.325000000000001, 14.75, 13.524999999999999), Block.box(3.075000000000001, -2.75, 3.0249999999999986, 4.575000000000001, -1.25, 13.524999999999999), Block.box(-1.6749999999999972, -14.75, 3.0249999999999986, -0.17499999999999716, -13.25, 13.524999999999999), Block.box(-0.17499999999999716, -10.75, 3.0249999999999986, 1.325000000000001, -9.25, 13.524999999999999), Block.box(1.4250000000000007, -6.75, 3.0249999999999986, 2.9250000000000007, -5.25, 13.524999999999999), Block.box(16.175, 29.25, 3.0249999999999986, 17.675, 30.75, 13.524999999999999), Block.box(11.425, 17.25, 3.0249999999999986, 12.925, 18.75, 13.524999999999999), Block.box(13.125000000000002, 21.25, 3.0249999999999986, 14.625000000000002, 22.75, 13.524999999999999), Block.box(14.825000000000001, 25.25, 3.0249999999999986, 16.325000000000003, 26.75, 13.524999999999999)).reduce(Shapes::or).get();

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        Direction value = blockState.getValue(FACING);
        return switch (value){
            case NORTH -> EESCALATOR_N;
            case SOUTH -> EESCALATOR_S;
            case EAST -> EESCALATOR_E;
            default -> EESCALATOR_W;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState().setValue(FACING,placeContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING,rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        Direction value = state.getValue(FACING);
        return switch (value){
            case NORTH -> EESCALATOR_N;
            case SOUTH -> EESCALATOR_S;
            case EAST -> EESCALATOR_E;
            default -> EESCALATOR_W;
        };
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return super.mirror(blockState, mirror);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
