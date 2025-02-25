package com.shengchanshe.changshengjue.block.custom.eescalator;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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

public class Eescalator extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public Eescalator(Properties p_49795_) {
        super(p_49795_);
    }
    public static final VoxelShape EESCALATOR_N = Stream.of(
            Block.box(1, 0, 3.1999999999999993, 15, 3.75, 6.199999999999999),
            Block.box(1, 4, 4.850000000000003, 15, 7.75, 7.850000000000003),
            Block.box(1, 8.1, 6.150000000000004, 15, 11.85, 9.150000000000004),
            Block.box(1, 12.2, 7.500000000000005, 15, 15.95, 10.500000000000005),
            Block.box(1, -4.2, 1.9499999999999993, 15, -0.25, 4.949999999999999),
            Block.box(1, -16, -1.8999999999999986, 15, -12.25, 1.1000000000000014),
            Block.box(1, -12.5, -0.8500000000000014, 15, -8.5, 2.1499999999999986),
            Block.box(1, -8.3, 0.5, 15, -4.15, 3.5),
            Block.box(1, 28.70000000000001, 12.750000000000007, 15, 32.45000000000001, 15.749999999999996),
            Block.box(1, 16.300000000000004, 8.600000000000005, 15, 20.050000000000004, 11.600000000000005),
            Block.box(1, 20.500000000000007, 10.300000000000004, 15, 24.250000000000007, 13.300000000000004),
            Block.box(1, 24.60000000000001, 11.700000000000005, 15, 28.35000000000001, 14.699999999999998)
    ).reduce(Shapes::or).get();

    public static final VoxelShape EESCALATOR_E = Stream.of(
            Block.box(9.8, 0, 1, 12.8, 3.75, 15),
            Block.box(8.149999999999997, 4, 1, 11.149999999999997, 7.75, 15),
            Block.box(6.849999999999996, 8.1, 1, 9.849999999999996, 11.85, 15),
            Block.box(5.499999999999995, 12.2, 1, 8.499999999999995, 15.95, 15),
            Block.box(11.05, -4.2, 1, 14.05, -0.25, 15),
            Block.box(14.899999999999999, -16, 1, 17.9, -12.25, 15),
            Block.box(13.850000000000001, -12.5, 1, 16.85, -8.5, 15),
            Block.box(12.5, -8.3, 1, 15.5, -4.15, 15),
            Block.box(0.25000000000000355, 28.70000000000001, 1, 3.249999999999993, 32.45000000000001, 15),
            Block.box(4.399999999999995, 16.300000000000004, 1, 7.399999999999995, 20.050000000000004, 15),
            Block.box(2.6999999999999957, 20.500000000000007, 1, 5.699999999999996, 24.250000000000007, 15),
            Block.box(1.3000000000000025, 24.60000000000001, 1, 4.299999999999995, 28.35000000000001, 15)
    ).reduce(Shapes::or).get();

    public static final VoxelShape EESCALATOR_S = Stream.of(
            Block.box(1, 0, 9.8, 15, 3.75, 12.8),
            Block.box(1, 4, 8.149999999999997, 15, 7.75, 11.149999999999997),
            Block.box(1, 8.1, 6.849999999999996, 15, 11.85, 9.849999999999996),
            Block.box(1, 12.2, 5.499999999999995, 15, 15.95, 8.499999999999995),
            Block.box(1, -4.2, 11.05, 15, -0.25, 14.05),
            Block.box(1, -16, 14.899999999999999, 15, -12.25, 17.9),
            Block.box(1, -12.5, 13.850000000000001, 15, -8.5, 16.85),
            Block.box(1, -8.3, 12.5, 15, -4.15, 15.5),
            Block.box(1, 28.70000000000001, 0.25000000000000355, 15, 32.45000000000001, 3.249999999999993),
            Block.box(1, 16.300000000000004, 4.399999999999995, 15, 20.050000000000004, 7.399999999999995),
            Block.box(1, 20.500000000000007, 2.6999999999999957, 15, 24.250000000000007, 5.699999999999996),
            Block.box(1, 24.60000000000001, 1.3000000000000025, 15, 28.35000000000001, 4.299999999999995)
    ).reduce(Shapes::or).get();

    public static final VoxelShape EESCALATOR_W = Stream.of(
            Block.box(3.1999999999999993, 0, 1, 6.199999999999999, 3.75, 15),
            Block.box(4.850000000000003, 4, 1, 7.850000000000003, 7.75, 15),
            Block.box(6.150000000000004, 8.1, 1, 9.150000000000004, 11.85, 15),
            Block.box(7.500000000000005, 12.2, 1, 10.500000000000005, 15.95, 15),
            Block.box(1.9499999999999993, -4.2, 1, 4.949999999999999, -0.25, 15),
            Block.box(-1.8999999999999986, -16, 1, 1.1000000000000014, -12.25, 15),
            Block.box(-0.8500000000000014, -12.5, 1, 2.1499999999999986, -8.5, 15),
            Block.box(0.5, -8.3, 1, 3.5, -4.15, 15),
            Block.box(12.750000000000007, 28.70000000000001, 1, 15.749999999999996, 32.45000000000001, 15),
            Block.box(8.600000000000005, 16.300000000000004, 1, 11.600000000000005, 20.050000000000004, 15),
            Block.box(10.300000000000004, 20.500000000000007, 1, 13.300000000000004, 24.250000000000007, 15),
            Block.box(11.700000000000005, 24.60000000000001, 1, 14.699999999999998, 28.35000000000001, 15)
    ).reduce(Shapes::or).get();

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

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        // 首先在原始位置移除方块
        pLevel.removeBlock(pPos, false);

        // 计算新的位置，即原位置向上位移一格
        BlockPos newPos = pPos.above();

        // 然后在新的位置放置方块
        pLevel.setBlock(newPos, pState, 3); // 参数3表示更新方块时的标志
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
