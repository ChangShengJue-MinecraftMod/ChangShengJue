package com.shengchanshe.chang_sheng_jue.block.custom.eescalator;

import com.shengchanshe.chang_sheng_jue.block.RoofPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class Eescalator extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<RoofPart> PART = EnumProperty.create("part", RoofPart.class);
    public static final VoxelShape EESCALATOR_BOTTOM_N;
    public static final VoxelShape EESCALATOR_BOTTOM_E;
    public static final VoxelShape EESCALATOR_BOTTOM_S;
    public static final VoxelShape EESCALATOR_BOTTOM_W;

    public static final VoxelShape EESCALATOR_MIDDLE_N;
    public static final VoxelShape EESCALATOR_MIDDLE_E;
    public static final VoxelShape EESCALATOR_MIDDLE_S;
    public static final VoxelShape EESCALATOR_MIDDLE_W;

    public static final VoxelShape EESCALATOR_TOP_N;
    public static final VoxelShape EESCALATOR_TOP_E;
    public static final VoxelShape EESCALATOR_TOP_S;
    public static final VoxelShape EESCALATOR_TOP_W;
    public Eescalator(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, RoofPart.BOTTOM));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        Direction facing = blockState.getValue(FACING);
        RoofPart roofPart = blockState.getValue(PART);
//        if (facing == Direction.NORTH) {
//            if (roofPart == RoofPart.BOTTOM){
//                return EESCALATOR_BOTTOM_N;
////            }else if (roofPart == RoofPart.MIDDLE){
////                return EESCALATOR_MIDDLE_N;
////            }else if (roofPart == RoofPart.TOP){
////                return EESCALATOR_TOP_N;
//            }
//        } else if (facing == Direction.SOUTH && roofPart == RoofPart.BOTTOM) {
//            return EESCALATOR_BOTTOM_S;
//        } else if (facing == Direction.EAST && roofPart == RoofPart.BOTTOM) {
//            return EESCALATOR_BOTTOM_E;
//        } else if (facing == Direction.WEST && roofPart == RoofPart.BOTTOM) {
//            return EESCALATOR_BOTTOM_W;
//        }
        return switch (facing){
            case NORTH -> roofPart == RoofPart.BOTTOM ? EESCALATOR_BOTTOM_N : roofPart == RoofPart.MIDDLE ? EESCALATOR_MIDDLE_N : EESCALATOR_TOP_N;
            case SOUTH -> roofPart == RoofPart.BOTTOM ? EESCALATOR_BOTTOM_S : roofPart == RoofPart.MIDDLE ? EESCALATOR_MIDDLE_S : EESCALATOR_TOP_S;
            case EAST -> roofPart == RoofPart.BOTTOM ? EESCALATOR_BOTTOM_E : roofPart == RoofPart.MIDDLE ? EESCALATOR_MIDDLE_E : EESCALATOR_TOP_E;
            default -> roofPart == RoofPart.BOTTOM ? EESCALATOR_BOTTOM_W : roofPart == RoofPart.MIDDLE ? EESCALATOR_MIDDLE_W : EESCALATOR_TOP_W;
        };
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        // 检查上方两个位置是否可放置
        if (pos.getY() < level.getMaxBuildHeight() - 2 &&
                level.getBlockState(pos.above()).canBeReplaced(context) &&
                level.getBlockState(pos.above(2)).canBeReplaced(context)) {

            return this.defaultBlockState()
                    .setValue(FACING, context.getHorizontalDirection().getOpposite())
                    .setValue(PART, RoofPart.BOTTOM);
        }
        return null; // 空间不足时取消放置
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        // 自动生成中部和顶部
        level.setBlock(pos.above(), state.setValue(PART, RoofPart.MIDDLE), Block.UPDATE_ALL);
        level.setBlock(pos.above(2), state.setValue(PART, RoofPart.TOP), Block.UPDATE_ALL);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        RoofPart part = state.getValue(PART);

        // 只在垂直方向检查（性能优化）
        if (direction.getAxis() != Direction.Axis.Y) {
            return state;
        }

        // 检查三部分结构完整性
        switch (part) {
            case BOTTOM -> {
                if (!level.getBlockState(pos.above()).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            case MIDDLE -> {
                if (!level.getBlockState(pos.below()).is(this) ||
                        !level.getBlockState(pos.above()).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
            case TOP -> {
                if (!level.getBlockState(pos.below()).is(this)) {
                    return Blocks.AIR.defaultBlockState();
                }
            }
        }

        return state;
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            super.playerWillDestroy(level, pos, state, player);
        }
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
        builder.add(PART,FACING);
    }

    static {
        EESCALATOR_BOTTOM_N = Stream.of(
                Block.box(1, 12.038709999999998, 2.42994, 15, 16.33871, 4.92994),
                Block.box(1, 0.53871, -2.1200600000000005, 15, 4.838710000000001, 0.3799399999999995),
                Block.box(1, 4.03871, -0.8200599999999998, 15, 8.33871, 1.6799400000000002),
                Block.box(1, 8.038709999999998, 0.7799399999999999, 15, 12.338709999999999, 3.27994)
        ).reduce(Shapes::or).get();
        EESCALATOR_BOTTOM_E = Stream.of(
                Block.box(11.07006, 12.038709999999998, 1, 13.57006, 16.33871, 15),
                Block.box(15.62006, 0.53871, 1, 18.120060000000002, 4.838710000000001, 15),
                Block.box(14.32006, 4.03871, 1, 16.820059999999998, 8.33871, 15),
                Block.box(12.72006, 8.038709999999998, 1, 15.22006, 12.338709999999999, 15)
        ).reduce(Shapes::or).get();
        EESCALATOR_BOTTOM_S = Stream.of(
                Block.box(1, 12.038709999999998, 11.07006, 15, 16.33871, 13.57006),
                Block.box(1, 0.53871, 15.62006, 15, 4.838710000000001, 18.120060000000002),
                Block.box(1, 4.03871, 14.32006, 15, 8.33871, 16.820059999999998),
                Block.box(1, 8.038709999999998, 12.72006, 15, 12.338709999999999, 15.22006)
        ).reduce(Shapes::or).get();
        EESCALATOR_BOTTOM_W = Stream.of(
                Block.box(2.42994, 12.038709999999998, 1, 4.92994, 16.33871, 15),
                Block.box(-2.1200600000000023, 0.53871, 1, 0.3799399999999995, 4.838710000000001, 15),
                Block.box(-0.820059999999998, 4.03871, 1, 1.6799400000000002, 8.33871, 15),
                Block.box(0.7799399999999999, 8.038709999999998, 1, 3.27994, 12.338709999999999, 15)
        ).reduce(Shapes::or).get();

        EESCALATOR_MIDDLE_N = Stream.of(
                Block.box(1, 12.038709999999998, 7.42994, 15, 16.33871, 9.92994),
                Block.box(1, 0.53871, 2.8799399999999995, 15, 4.838710000000001, 5.3799399999999995),
                Block.box(1, 4.03871, 4.17994, 15, 8.33871, 6.67994),
                Block.box(1, 8.038709999999998, 5.77994, 15, 12.338709999999999, 8.27994)
        ).reduce(Shapes::or).get();
        EESCALATOR_MIDDLE_E = Stream.of(
                Block.box(6.07006, 12.038709999999998, 1, 8.57006, 16.33871, 15),
                Block.box(10.62006, 0.53871, 1, 13.12006, 4.838710000000001, 15),
                Block.box(9.32006, 4.03871, 1, 11.82006, 8.33871, 15),
                Block.box(7.72006, 8.038709999999998, 1, 10.22006, 12.338709999999999, 15)
        ).reduce(Shapes::or).get();
        EESCALATOR_MIDDLE_S = Stream.of(
                Block.box(1, 12.038709999999998, 6.07006, 15, 16.33871, 8.57006),
                Block.box(1, 0.53871, 10.62006, 15, 4.838710000000001, 13.12006),
                Block.box(1, 4.03871, 9.32006, 15, 8.33871, 11.82006),
                Block.box(1, 8.038709999999998, 7.72006, 15, 12.338709999999999, 10.22006)
        ).reduce(Shapes::or).get();
        EESCALATOR_MIDDLE_W = Stream.of(
                Block.box(7.42994, 12.038709999999998, 1, 9.92994, 16.33871, 15),
                Block.box(2.8799399999999995, 0.53871, 1, 5.3799399999999995, 4.838710000000001, 15),
                Block.box(4.17994, 4.03871, 1, 6.67994, 8.33871, 15),
                Block.box(5.77994, 8.038709999999998, 1, 8.27994, 12.338709999999999, 15)
        ).reduce(Shapes::or).get();

        EESCALATOR_TOP_N = Stream.of(
                Block.box(1, 12.038709999999998, 12.42994, 15, 16.33871, 14.92994),
                Block.box(1, 0.53871, 7.8799399999999995, 15, 4.838710000000001, 10.37994),
                Block.box(1, 4.03871, 9.17994, 15, 8.33871, 11.67994),
                Block.box(1, 8.038709999999998, 10.77994, 15, 12.338709999999999, 13.27994)
        ).reduce(Shapes::or).get();
        EESCALATOR_TOP_E = Stream.of(
                Block.box(1.0700599999999998, 12.038709999999998, 1, 3.57006, 16.33871, 15),
                Block.box(5.6200600000000005, 0.53871, 1, 8.12006, 4.838710000000001, 15),
                Block.box(4.32006, 4.03871, 1, 6.82006, 8.33871, 15),
                Block.box(2.72006, 8.038709999999998, 1, 5.22006, 12.338709999999999, 15)
        ).reduce(Shapes::or).get();
        EESCALATOR_TOP_S = Stream.of(
                Block.box(1, 12.038709999999998, 1.0700599999999998, 15, 16.33871, 3.57006),
                Block.box(1, 0.53871, 5.6200600000000005, 15, 4.838710000000001, 8.12006),
                Block.box(1, 4.03871, 4.32006, 15, 8.33871, 6.82006),
                Block.box(1, 8.038709999999998, 2.72006, 15, 12.338709999999999, 5.22006)
        ).reduce(Shapes::or).get();
        EESCALATOR_TOP_W = Stream.of(
                Block.box(12.42994, 12.038709999999998, 1, 14.92994, 16.33871, 15),
                Block.box(7.8799399999999995, 0.53871, 1, 10.37994, 4.838710000000001, 15),
                Block.box(9.17994, 4.03871, 1, 11.67994, 8.33871, 15),
                Block.box(10.77994, 8.038709999999998, 1, 13.27994, 12.338709999999999, 15)
        ).reduce(Shapes::or).get();
    }
}
