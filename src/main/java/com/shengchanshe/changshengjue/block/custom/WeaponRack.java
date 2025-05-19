package com.shengchanshe.changshengjue.block.custom;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.entity.WeaponRackEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class WeaponRack extends BaseEntityBlock {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");



    public WeaponRack(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LEFT, false)
                .setValue(RIGHT, false));
    }

    // 连接状态更新逻辑
    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (level.isClientSide()) return state;

        Direction facing = state.getValue(FACING);
        if (!direction.getAxis().isHorizontal()) return state;

        // 只处理当前朝向的左右方向
        Direction leftDir = facing.getCounterClockWise();
        Direction rightDir = facing.getClockWise();

        boolean leftConnected = false;
        boolean rightConnected = false;

        if (direction == leftDir || direction == rightDir) {
            leftConnected = checkConnection(level, pos, leftDir, facing);
            rightConnected = checkConnection(level, pos, rightDir, facing);
        }

        return state.setValue(LEFT, leftConnected)
                .setValue(RIGHT, rightConnected);
    }

    private boolean checkConnection(BlockGetter level, BlockPos pos, Direction checkDir, Direction facing) {
        BlockState neighbor = level.getBlockState(pos.relative(checkDir));
        return neighbor.is(this) && neighbor.getValue(FACING) == facing;
    }

    // 在类顶部定义所有方向的形状常量（单位：像素/16）
    // 北方向基准形状
    private static final VoxelShape SHAPE_NORTH_SINGLE = Stream.of(
            Block.box(14, 2, 11, 16, 15, 13),
            Block.box(14, 13, 8, 16, 15, 11),
            Block.box(0, 2, 11, 2, 15, 13),
            Block.box(0, 13, 8, 2, 15, 11),
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(2, 14, 11, 14, 15, 13),
            Block.box(2, 7, 5.5, 14, 8, 7.5),
            Block.box(14, 11.999999999999998, 7.5, 16, 14.000000000000005, 8.5),
            Block.box(0, 1.9999999999999998, 4, 2, 5.000000000000007, 5),
            Block.box(14, 1.9999999999999998, 4, 16, 5.000000000000007, 5),
            Block.box(0, 4, 5, 2, 6.000000000000007, 6),
            Block.box(14, 4, 5, 16, 6.000000000000007, 6),
            Block.box(0, 6, 5, 2, 8.000000000000007, 6),
            Block.box(14, 6, 5, 16, 8.000000000000007, 6),
            Block.box(0, 11.999999999999998, 7.5, 2, 14.000000000000005, 8.5),
            Block.box(14, 1.9999999999999998, 3, 16, 3.000000000000007, 5),
            Block.box(0, 1.9999999999999998, 3, 2, 3.000000000000007, 5),
            Block.box(0, 11, 8, 2, 13.000000000000007, 9),
            Block.box(14, 11, 8, 16, 13.000000000000007, 9),
            Block.box(14, 7, 6, 16, 8.000000000000007, 7),
            Block.box(0, 7, 6, 2, 9.000000000000007, 7),
            Block.box(14, 7, 6, 16, 9.000000000000007, 7),
            Block.box(0, 7.999999999999999, 6, 2, 10.000000000000007, 7),
            Block.box(14, 7.999999999999999, 6, 16, 10.000000000000007, 7),
            Block.box(0, 9, 6, 2, 10.000000000000007, 8),
            Block.box(0, 3, 5, 2, 4.000000000000007, 6),
            Block.box(14, 3, 5, 16, 4.000000000000007, 6),
            Block.box(14, 9, 6, 16, 10.000000000000007, 8),
            Block.box(0, 8.999999999999998, 7, 2, 12.000000000000005, 8),
            Block.box(14, 8.999999999999998, 7, 16, 12.000000000000005, 8),
            Block.box(0, 11.999999999999998, 8, 2, 14.000000000000005, 9),
            Block.box(14, 11.999999999999998, 8, 16, 14.000000000000005, 9),
            Block.box(0, 9.999999999999998, 7, 2, 13.000000000000005, 8),
            Block.box(14, 9.999999999999998, 7, 16, 13.000000000000005, 8),
            Block.box(0, 7, 6, 2, 8.000000000000007, 7)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();// 独立状态
    private static final VoxelShape SHAPE_NORTH_LEFT = Stream.of(
            Block.box(14, 2, 11, 16, 15, 13),
            Block.box(14, 13, 8, 16, 15, 11),
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(0, 14, 11, 14, 15, 13),
            Block.box(0, 7, 5.5, 14, 8, 7.5),
            Block.box(14, 11.999999999999998, 7.5, 16, 14.000000000000005, 8.5),
            Block.box(14, 1.9999999999999998, 3, 16, 3.000000000000007, 5),
            Block.box(14, 11, 8, 16, 13.000000000000007, 9),
            Block.box(14, 1.9999999999999998, 4, 16, 5.000000000000007, 5),
            Block.box(14, 4, 5, 16, 6.000000000000007, 6),
            Block.box(14, 6, 5, 16, 8.000000000000007, 6),
            Block.box(14, 7, 6, 16, 8.000000000000007, 7),
            Block.box(14, 7, 6, 16, 9.000000000000007, 7),
            Block.box(14, 7.999999999999999, 6, 16, 10.000000000000007, 7),
            Block.box(14, 9, 6, 16, 10.000000000000007, 8),
            Block.box(14, 8.999999999999998, 7, 16, 12.000000000000005, 8),
            Block.box(14, 11.999999999999998, 8, 16, 14.000000000000005, 9),
            Block.box(14, 9.999999999999998, 7, 16, 13.000000000000005, 8),
            Block.box(14, 3, 5, 16, 4.000000000000007, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();// 左端
    private static final VoxelShape SHAPE_NORTH_RIGHT = Stream.of(
            Block.box(0, 2, 11, 2, 15, 13),
            Block.box(0, 13, 8, 2, 15, 11),
            Block.box(2, 7, 5.5, 16, 8, 7.5),
            Block.box(2, 14, 11, 16, 15, 13),
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(0, 11.999999999999998, 7.5, 2, 14.000000000000005, 8.5),
            Block.box(0, 1.9999999999999998, 3, 2, 3.000000000000007, 5),
            Block.box(0, 11, 8, 2, 13.000000000000007, 9),
            Block.box(0, 1.9999999999999998, 4, 2, 5.000000000000007, 5),
            Block.box(0, 4, 5, 2, 6.000000000000007, 6),
            Block.box(0, 6, 5, 2, 8.000000000000007, 6),
            Block.box(0, 7, 6, 2, 8.000000000000007, 7),
            Block.box(0, 7, 6, 2, 9.000000000000007, 7),
            Block.box(0, 7.999999999999999, 6, 2, 10.000000000000007, 7),
            Block.box(0, 9, 6, 2, 10.000000000000007, 8),
            Block.box(0, 8.999999999999998, 7, 2, 12.000000000000005, 8),
            Block.box(0, 11.999999999999998, 8, 2, 14.000000000000005, 9),
            Block.box(0, 9.999999999999998, 7, 2, 13.000000000000005, 8),
            Block.box(0, 3, 5, 2, 4.000000000000007, 6)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
            // 右端
    private static final VoxelShape SHAPE_NORTH_MIDDLE = Stream.of(
                    Block.box(0, 0, 3, 16, 2, 13),
                    Block.box(0, 14, 11, 16, 15, 13),
                    Block.box(0, 7, 5.5, 16, 8, 7.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();// 中间

    // 东方向形状（根据实际模型调整坐标）
    private static final VoxelShape SHAPE_EAST_SINGLE = Stream.of(
            Block.box(3, 2, 14, 5, 15, 16),
            Block.box(5, 13, 14, 8, 15, 16),
            Block.box(3, 2, 0, 5, 15, 2),
            Block.box(5, 13, 0, 8, 15, 2),
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(3, 14, 2, 5, 15, 14),
            Block.box(8.5, 7, 2, 10.5, 8, 14),
            Block.box(7.5, 11.999999999999998, 14, 8.5, 14.000000000000005, 16),
            Block.box(11, 1.9999999999999998, 0, 12, 5.000000000000007, 2),
            Block.box(11, 1.9999999999999998, 14, 12, 5.000000000000007, 16),
            Block.box(10, 4, 0, 11, 6.000000000000007, 2),
            Block.box(10, 4, 14, 11, 6.000000000000007, 16),
            Block.box(10, 6, 0, 11, 8.000000000000007, 2),
            Block.box(10, 6, 14, 11, 8.000000000000007, 16),
            Block.box(7.5, 11.999999999999998, 0, 8.5, 14.000000000000005, 2),
            Block.box(11, 1.9999999999999998, 14, 13, 3.000000000000007, 16),
            Block.box(11, 1.9999999999999998, 0, 13, 3.000000000000007, 2),
            Block.box(7, 11, 0, 8, 13.000000000000007, 2),
            Block.box(7, 11, 14, 8, 13.000000000000007, 16),
            Block.box(9, 7, 14, 10, 8.000000000000007, 16),
            Block.box(9, 7, 0, 10, 9.000000000000007, 2),
            Block.box(9, 7, 14, 10, 9.000000000000007, 16),
            Block.box(9, 7.999999999999999, 0, 10, 10.000000000000007, 2),
            Block.box(9, 7.999999999999999, 14, 10, 10.000000000000007, 16),
            Block.box(8, 9, 0, 10, 10.000000000000007, 2),
            Block.box(10, 3, 0, 11, 4.000000000000007, 2),
            Block.box(10, 3, 14, 11, 4.000000000000007, 16),
            Block.box(8, 9, 14, 10, 10.000000000000007, 16),
            Block.box(8, 8.999999999999998, 0, 9, 12.000000000000005, 2),
            Block.box(8, 8.999999999999998, 14, 9, 12.000000000000005, 16),
            Block.box(7, 11.999999999999998, 0, 8, 14.000000000000005, 2),
            Block.box(7, 11.999999999999998, 14, 8, 14.000000000000005, 16),
            Block.box(8, 9.999999999999998, 0, 9, 13.000000000000005, 2),
            Block.box(8, 9.999999999999998, 14, 9, 13.000000000000005, 16),
            Block.box(9, 7, 0, 10, 8.000000000000007, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_LEFT = Stream.of(
            Block.box(3, 2, 14, 5, 15, 16),
            Block.box(5, 13, 14, 8, 15, 16),
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(3, 14, 0, 5, 15, 14),
            Block.box(8.5, 7, 0, 10.5, 8, 14),
            Block.box(7.5, 11.999999999999998, 14, 8.5, 14.000000000000005, 16),
            Block.box(11, 1.9999999999999998, 14, 13, 3.000000000000007, 16),
            Block.box(7, 11, 14, 8, 13.000000000000007, 16),
            Block.box(11, 1.9999999999999998, 14, 12, 5.000000000000007, 16),
            Block.box(10, 4, 14, 11, 6.000000000000007, 16),
            Block.box(10, 6, 14, 11, 8.000000000000007, 16),
            Block.box(9, 7, 14, 10, 8.000000000000007, 16),
            Block.box(9, 7, 14, 10, 9.000000000000007, 16),
            Block.box(9, 7.999999999999999, 14, 10, 10.000000000000007, 16),
            Block.box(8, 9, 14, 10, 10.000000000000007, 16),
            Block.box(8, 8.999999999999998, 14, 9, 12.000000000000005, 16),
            Block.box(7, 11.999999999999998, 14, 8, 14.000000000000005, 16),
            Block.box(8, 9.999999999999998, 14, 9, 13.000000000000005, 16),
            Block.box(10, 3, 14, 11, 4.000000000000007, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_RIGHT = Stream.of(
            Block.box(3, 2, 0, 5, 15, 2),
            Block.box(5, 13, 0, 8, 15, 2),
            Block.box(8.5, 7, 2, 10.5, 8, 16),
            Block.box(3, 14, 2, 5, 15, 16),
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(7.5, 11.999999999999998, 0, 8.5, 14.000000000000005, 2),
            Block.box(11, 1.9999999999999998, 0, 13, 3.000000000000007, 2),
            Block.box(7, 11, 0, 8, 13.000000000000007, 2),
            Block.box(11, 1.9999999999999998, 0, 12, 5.000000000000007, 2),
            Block.box(10, 4, 0, 11, 6.000000000000007, 2),
            Block.box(10, 6, 0, 11, 8.000000000000007, 2),
            Block.box(9, 7, 0, 10, 8.000000000000007, 2),
            Block.box(9, 7, 0, 10, 9.000000000000007, 2),
            Block.box(9, 7.999999999999999, 0, 10, 10.000000000000007, 2),
            Block.box(8, 9, 0, 10, 10.000000000000007, 2),
            Block.box(8, 8.999999999999998, 0, 9, 12.000000000000005, 2),
            Block.box(7, 11.999999999999998, 0, 8, 14.000000000000005, 2),
            Block.box(8, 9.999999999999998, 0, 9, 13.000000000000005, 2),
            Block.box(10, 3, 0, 11, 4.000000000000007, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_EAST_MIDDLE = Stream.of(
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(3, 14, 0, 5, 15, 16),
            Block.box(8.5, 7, 0, 10.5, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    // 南方向形状
    private static final VoxelShape SHAPE_SOUTH_SINGLE = Stream.of(
            Block.box(0, 2, 3, 2, 15, 5),
            Block.box(0, 13, 5, 2, 15, 8),
            Block.box(14, 2, 3, 16, 15, 5),
            Block.box(14, 13, 5, 16, 15, 8),
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(2, 14, 3, 14, 15, 5),
            Block.box(2, 7, 8.5, 14, 8, 10.5),
            Block.box(0, 11.999999999999998, 7.5, 2, 14.000000000000005, 8.5),
            Block.box(14, 1.9999999999999998, 11, 16, 5.000000000000007, 12),
            Block.box(0, 1.9999999999999998, 11, 2, 5.000000000000007, 12),
            Block.box(14, 4, 10, 16, 6.000000000000007, 11),
            Block.box(0, 4, 10, 2, 6.000000000000007, 11),
            Block.box(14, 6, 10, 16, 8.000000000000007, 11),
            Block.box(0, 6, 10, 2, 8.000000000000007, 11),
            Block.box(14, 11.999999999999998, 7.5, 16, 14.000000000000005, 8.5),
            Block.box(0, 1.9999999999999998, 11, 2, 3.000000000000007, 13),
            Block.box(14, 1.9999999999999998, 11, 16, 3.000000000000007, 13),
            Block.box(14, 11, 7, 16, 13.000000000000007, 8),
            Block.box(0, 11, 7, 2, 13.000000000000007, 8),
            Block.box(0, 7, 9, 2, 8.000000000000007, 10),
            Block.box(14, 7, 9, 16, 9.000000000000007, 10),
            Block.box(0, 7, 9, 2, 9.000000000000007, 10),
            Block.box(14, 7.999999999999999, 9, 16, 10.000000000000007, 10),
            Block.box(0, 7.999999999999999, 9, 2, 10.000000000000007, 10),
            Block.box(14, 9, 8, 16, 10.000000000000007, 10),
            Block.box(14, 3, 10, 16, 4.000000000000007, 11),
            Block.box(0, 3, 10, 2, 4.000000000000007, 11),
            Block.box(0, 9, 8, 2, 10.000000000000007, 10),
            Block.box(14, 8.999999999999998, 8, 16, 12.000000000000005, 9),
            Block.box(0, 8.999999999999998, 8, 2, 12.000000000000005, 9),
            Block.box(14, 11.999999999999998, 7, 16, 14.000000000000005, 8),
            Block.box(0, 11.999999999999998, 7, 2, 14.000000000000005, 8),
            Block.box(14, 9.999999999999998, 8, 16, 13.000000000000005, 9),
            Block.box(0, 9.999999999999998, 8, 2, 13.000000000000005, 9),
            Block.box(14, 7, 9, 16, 8.000000000000007, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_LEFT = Stream.of(
            Block.box(0, 2, 3, 2, 15, 5),
            Block.box(0, 13, 5, 2, 15, 8),
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(2, 14, 3, 16, 15, 5),
            Block.box(2, 7, 8.5, 16, 8, 10.5),
            Block.box(0, 11.999999999999998, 7.5, 2, 14.000000000000005, 8.5),
            Block.box(0, 1.9999999999999998, 11, 2, 3.000000000000007, 13),
            Block.box(0, 11, 7, 2, 13.000000000000007, 8),
            Block.box(0, 1.9999999999999998, 11, 2, 5.000000000000007, 12),
            Block.box(0, 4, 10, 2, 6.000000000000007, 11),
            Block.box(0, 6, 10, 2, 8.000000000000007, 11),
            Block.box(0, 7, 9, 2, 8.000000000000007, 10),
            Block.box(0, 7, 9, 2, 9.000000000000007, 10),
            Block.box(0, 7.999999999999999, 9, 2, 10.000000000000007, 10),
            Block.box(0, 9, 8, 2, 10.000000000000007, 10),
            Block.box(0, 8.999999999999998, 8, 2, 12.000000000000005, 9),
            Block.box(0, 11.999999999999998, 7, 2, 14.000000000000005, 8),
            Block.box(0, 9.999999999999998, 8, 2, 13.000000000000005, 9),
            Block.box(0, 3, 10, 2, 4.000000000000007, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_RIGHT = Stream.of(
            Block.box(14, 2, 3, 16, 15, 5),
            Block.box(14, 13, 5, 16, 15, 8),
            Block.box(0, 7, 8.5, 14, 8, 10.5),
            Block.box(0, 14, 3, 14, 15, 5),
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(14, 11.999999999999998, 7.5, 16, 14.000000000000005, 8.5),
            Block.box(14, 1.9999999999999998, 11, 16, 3.000000000000007, 13),
            Block.box(14, 11, 7, 16, 13.000000000000007, 8),
            Block.box(14, 1.9999999999999998, 11, 16, 5.000000000000007, 12),
            Block.box(14, 4, 10, 16, 6.000000000000007, 11),
            Block.box(14, 6, 10, 16, 8.000000000000007, 11),
            Block.box(14, 7, 9, 16, 8.000000000000007, 10),
            Block.box(14, 7, 9, 16, 9.000000000000007, 10),
            Block.box(14, 7.999999999999999, 9, 16, 10.000000000000007, 10),
            Block.box(14, 9, 8, 16, 10.000000000000007, 10),
            Block.box(14, 8.999999999999998, 8, 16, 12.000000000000005, 9),
            Block.box(14, 11.999999999999998, 7, 16, 14.000000000000005, 8),
            Block.box(14, 9.999999999999998, 8, 16, 13.000000000000005, 9),
            Block.box(14, 3, 10, 16, 4.000000000000007, 11)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_SOUTH_MIDDLE = Stream.of(
            Block.box(0, 0, 3, 16, 2, 13),
            Block.box(0, 14, 3, 16, 15, 5),
            Block.box(0, 7, 8.5, 16, 8, 10.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    // 西方向形状
    private static final VoxelShape SHAPE_WEST_SINGLE = Stream.of(
            Block.box(11, 2, 0, 13, 15, 2),
            Block.box(8, 13, 0, 11, 15, 2),
            Block.box(11, 2, 14, 13, 15, 16),
            Block.box(8, 13, 14, 11, 15, 16),
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(11, 14, 2, 13, 15, 14),
            Block.box(5.5, 7, 2, 7.5, 8, 14),
            Block.box(7.5, 11.999999999999998, 0, 8.5, 14.000000000000005, 2),
            Block.box(4, 1.9999999999999998, 14, 5, 5.000000000000007, 16),
            Block.box(4, 1.9999999999999998, 0, 5, 5.000000000000007, 2),
            Block.box(5, 4, 14, 6, 6.000000000000007, 16),
            Block.box(5, 4, 0, 6, 6.000000000000007, 2),
            Block.box(5, 6, 14, 6, 8.000000000000007, 16),
            Block.box(5, 6, 0, 6, 8.000000000000007, 2),
            Block.box(7.5, 11.999999999999998, 14, 8.5, 14.000000000000005, 16),
            Block.box(3, 1.9999999999999998, 0, 5, 3.000000000000007, 2),
            Block.box(3, 1.9999999999999998, 14, 5, 3.000000000000007, 16),
            Block.box(8, 11, 14, 9, 13.000000000000007, 16),
            Block.box(8, 11, 0, 9, 13.000000000000007, 2),
            Block.box(6, 7, 0, 7, 8.000000000000007, 2),
            Block.box(6, 7, 14, 7, 9.000000000000007, 16),
            Block.box(6, 7, 0, 7, 9.000000000000007, 2),
            Block.box(6, 7.999999999999999, 14, 7, 10.000000000000007, 16),
            Block.box(6, 7.999999999999999, 0, 7, 10.000000000000007, 2),
            Block.box(6, 9, 14, 8, 10.000000000000007, 16),
            Block.box(5, 3, 14, 6, 4.000000000000007, 16),
            Block.box(5, 3, 0, 6, 4.000000000000007, 2),
            Block.box(6, 9, 0, 8, 10.000000000000007, 2),
            Block.box(7, 8.999999999999998, 14, 8, 12.000000000000005, 16),
            Block.box(7, 8.999999999999998, 0, 8, 12.000000000000005, 2),
            Block.box(8, 11.999999999999998, 14, 9, 14.000000000000005, 16),
            Block.box(8, 11.999999999999998, 0, 9, 14.000000000000005, 2),
            Block.box(7, 9.999999999999998, 14, 8, 13.000000000000005, 16),
            Block.box(7, 9.999999999999998, 0, 8, 13.000000000000005, 2),
            Block.box(6, 7, 14, 7, 8.000000000000007, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_LEFT = Stream.of(
            Block.box(11, 2, 0, 13, 15, 2),
            Block.box(8, 13, 0, 11, 15, 2),
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(11, 14, 2, 13, 15, 16),
            Block.box(5.5, 7, 2, 7.5, 8, 16),
            Block.box(7.5, 11.999999999999998, 0, 8.5, 14.000000000000005, 2),
            Block.box(3, 1.9999999999999998, 0, 5, 3.000000000000007, 2),
            Block.box(8, 11, 0, 9, 13.000000000000007, 2),
            Block.box(4, 1.9999999999999998, 0, 5, 5.000000000000007, 2),
            Block.box(5, 4, 0, 6, 6.000000000000007, 2),
            Block.box(5, 6, 0, 6, 8.000000000000007, 2),
            Block.box(6, 7, 0, 7, 8.000000000000007, 2),
            Block.box(6, 7, 0, 7, 9.000000000000007, 2),
            Block.box(6, 7.999999999999999, 0, 7, 10.000000000000007, 2),
            Block.box(6, 9, 0, 8, 10.000000000000007, 2),
            Block.box(7, 8.999999999999998, 0, 8, 12.000000000000005, 2),
            Block.box(8, 11.999999999999998, 0, 9, 14.000000000000005, 2),
            Block.box(7, 9.999999999999998, 0, 8, 13.000000000000005, 2),
            Block.box(5, 3, 0, 6, 4.000000000000007, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_RIGHT = Stream.of(
            Block.box(11, 2, 14, 13, 15, 16),
            Block.box(8, 13, 14, 11, 15, 16),
            Block.box(5.5, 7, 0, 7.5, 8, 14),
            Block.box(11, 14, 0, 13, 15, 14),
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(7.5, 11.999999999999998, 14, 8.5, 14.000000000000005, 16),
            Block.box(3, 1.9999999999999998, 14, 5, 3.000000000000007, 16),
            Block.box(8, 11, 14, 9, 13.000000000000007, 16),
            Block.box(4, 1.9999999999999998, 14, 5, 5.000000000000007, 16),
            Block.box(5, 4, 14, 6, 6.000000000000007, 16),
            Block.box(5, 6, 14, 6, 8.000000000000007, 16),
            Block.box(6, 7, 14, 7, 8.000000000000007, 16),
            Block.box(6, 7, 14, 7, 9.000000000000007, 16),
            Block.box(6, 7.999999999999999, 14, 7, 10.000000000000007, 16),
            Block.box(6, 9, 14, 8, 10.000000000000007, 16),
            Block.box(7, 8.999999999999998, 14, 8, 12.000000000000005, 16),
            Block.box(8, 11.999999999999998, 14, 9, 14.000000000000005, 16),
            Block.box(7, 9.999999999999998, 14, 8, 13.000000000000005, 16),
            Block.box(5, 3, 14, 6, 4.000000000000007, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    private static final VoxelShape SHAPE_WEST_MIDDLE = Stream.of(
            Block.box(3, 0, 0, 13, 2, 16),
            Block.box(11, 14, 0, 13, 15, 16),
            Block.box(5.5, 7, 0, 7.5, 8, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);
        boolean left = pState.getValue(LEFT);
        boolean right = pState.getValue(RIGHT);

        // 计算连接总数
        int connections = (left ? 1 : 0) + (right ? 1 : 0);

        // 根据朝向选择形状组
        switch (facing) {
            case NORTH:
                return getNorthShape(connections, left, right);
            case EAST:
                return getEastShape(connections, left, right);
            case SOUTH:
                return getSouthShape(connections, left, right);
            case WEST:
                return getWestShape(connections, left, right);
            default:
                return SHAPE_NORTH_SINGLE;
        }
    }

    // 北方向形状选择逻辑
    private VoxelShape getNorthShape(int connections, boolean left, boolean right) {
        if (connections == 0) {
            return SHAPE_NORTH_SINGLE;
        } else if (connections == 1) {
            return left ? SHAPE_NORTH_LEFT : SHAPE_NORTH_RIGHT;
        } else {
            return isMiddleBlock(Direction.NORTH, left, right) ?
                    SHAPE_NORTH_MIDDLE :
                    (left ? SHAPE_NORTH_LEFT : SHAPE_NORTH_RIGHT);
        }
    }



    // 东方向形状选择逻辑
    private VoxelShape getEastShape(int connections, boolean left, boolean right) {
        if (connections == 0) {
            return SHAPE_EAST_SINGLE;
        } else if (connections == 1) {
            return left ? SHAPE_EAST_LEFT : SHAPE_EAST_RIGHT;
        } else {
            return isMiddleBlock(Direction.EAST, left, right) ?
                    SHAPE_EAST_MIDDLE :
                    (left ? SHAPE_EAST_LEFT : SHAPE_EAST_RIGHT);
        }
    }

    // 南方向形状选择逻辑
    private VoxelShape getSouthShape(int connections, boolean left, boolean right) {
        if (connections == 0) {
            return SHAPE_SOUTH_SINGLE;
        } else if (connections == 1) {
            return left ? SHAPE_SOUTH_LEFT : SHAPE_SOUTH_RIGHT;
        } else {
            return isMiddleBlock(Direction.SOUTH, left, right) ?
                    SHAPE_SOUTH_MIDDLE :
                    (left ? SHAPE_SOUTH_LEFT : SHAPE_SOUTH_RIGHT);
        }
    }

    // 西方向形状选择逻辑
    private VoxelShape getWestShape(int connections, boolean left, boolean right) {
        if (connections == 0) {
            return SHAPE_WEST_SINGLE;
        } else if (connections == 1) {
            return left ? SHAPE_WEST_LEFT : SHAPE_WEST_RIGHT;
        } else {
            return isMiddleBlock(Direction.WEST, left, right) ?
                    SHAPE_WEST_MIDDLE :
                    (left ? SHAPE_WEST_LEFT : SHAPE_WEST_RIGHT);
        }
    }
    // 辅助方法：判断是否是中间方块
    private boolean isMiddleBlock(Direction facing, boolean left, boolean right) {
        // 当左右都有连接时才是中间方块
        return left && right;
    }
    // 其他必要方法保持原有功能
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LEFT, RIGHT);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        Direction facing = pContext.getHorizontalDirection().getOpposite();

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(LEFT, checkConnection(level, pos, facing.getCounterClockWise(), facing))
                .setValue(RIGHT, checkConnection(level, pos, facing.getClockWise(), facing));
    }

    // 保留原有实体方块相关方法
    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new WeaponRackEntity(blockPos, blockState);
    }

    private boolean checkWeapon(Item item) {
        return item.equals(Items.WOODEN_SWORD)
                || item.equals(Items.STONE_SWORD)
                || item.equals(Items.IRON_SWORD)
                || item.equals(Items.DIAMOND_SWORD)
                || item.equals(Items.GOLDEN_SWORD)
                || item.equals(Items.NETHERITE_SWORD)
                || item.equals(Items.TRIDENT);
    }

    private boolean checkModWeapon(ItemStack item) {
        return item.getItem().equals(ChangShengJueItems.BEAT_DOG_STICK.get())
                || item.getItem().equals(ChangShengJueItems.THREE_THROWING_KNIVES.get())
                || item.getItem().equals(ChangShengJueItems.YI_TIAN_JIAN.get())
                || item.getItem().equals(ChangShengJueItems.TU_LONG_DAO.get())
                || item.getItem().equals(ChangShengJueItems.BA_WANG_QIANG.get())
                || item.getItem().equals(ChangShengJueItems.BRONZE_SWORD.get())
                || item.getItem().equals(ChangShengJueItems.HAN_JIAN.get())
                || item.getItem().equals(ChangShengJueItems.HENG_DAO.get())
                || item.getItem().equals(ChangShengJueItems.LARGE_KNIFE.get())
                || item.getItem().equals(ChangShengJueItems.RED_TASSELLED_SPEAR.get())
                || item.getItem().equals(ChangShengJueItems.SOFT_SWORD.get())
                || item.getItem().equals(ChangShengJueItems.PAN_HUA_GUN.get())
                || item.getItem().equals(ChangShengJueItems.KITCHEN_KNIFE.get())
                ;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof WeaponRackEntity entity) {
            ItemStack item = pPlayer.getMainHandItem();
            if (checkWeapon(item.getItem())) {
                if (!pLevel.isClientSide && entity.addItem(pPlayer.getAbilities().instabuild ? item.copy() : item)) {
                    return InteractionResult.SUCCESS;
                }
            }
            if (checkModWeapon(item)) {
                if (!pLevel.isClientSide && entity.addItem(pPlayer.getAbilities().instabuild ? item.copy() : item)) {
                    return InteractionResult.SUCCESS;
                }
            }else {
                entity.drops(pPlayer);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }



    // 在类顶部添加属性定义
    public static final IntegerProperty CONNECTION =
            IntegerProperty.create("connection", 0, 2); // 0=only 1=double 2=treble
    public static final IntegerProperty MAIN =
            IntegerProperty.create("main", 0, 1);



    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof WeaponRackEntity) {
                ((WeaponRackEntity) blockentity).drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide){
            return null;
        }
        return createTickerHelper(pBlockEntityType, ChangShengJueBlocksEntities.TOOL_TABLE_ENTITY.get(),((pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1,pPos,pState1)));
    }








    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }


//    private int checkSideConnection(BlockState currentState, BlockGetter level, BlockPos pos) {
//        Direction currentFacing = currentState.getValue(FACING);
//
//        // 检查左右两侧（相对当前朝向的顺时针和逆时针方向）
//        List<Direction> checkDirections = Arrays.asList(
//                currentFacing.getCounterClockWise(),  // 左侧
//                currentFacing.getClockWise()          // 右侧
//        );
//
//        for (Direction dir : checkDirections) {
//            BlockState neighbor = level.getBlockState(pos.relative(dir));
//            if (neighbor.is(this) && neighbor.getValue(FACING) == currentFacing) {
//                return 0; // 发现相邻同类型方块
//            }
//        }
//        return 1; // 没有相邻同类型方块
//    }
//
//
//    private int calculateConnection(BlockState currentState, BlockGetter level, BlockPos pos) {
//        Direction currentFacing = currentState.getValue(FACING);
//        int connections = 0;
//
//        // 只检查左右两侧（相对当前朝向的顺时针和逆时针方向）
//        List<Direction> checkDirections = Arrays.asList(
//                currentFacing.getCounterClockWise(),  // 左侧
//                currentFacing.getClockWise()          // 右侧
//        );
//
//        for(Direction dir : checkDirections) {
//            BlockState neighbor = level.getBlockState(pos.relative(dir));
//            if(neighbor.is(this) && neighbor.getValue(FACING) == currentFacing) {
//                connections++;
//            }
//        }
//        return Math.min(connections, 2);
//    }

    private void updateNeighborState(BlockState state, LevelAccessor level, BlockPos pos, Direction direction) {
        // 新增主方块判断逻辑
        if (state.getValue(MAIN) == 1) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);

            // 仅处理同朝向的相邻方块
            if (neighborState.is(this) && neighborState.getValue(FACING) == state.getValue(FACING)) {
                level.setBlock(neighborPos, neighborState
                                .setValue(MAIN, 0)  // 设置邻居为附属方块
                                .setValue(CONNECTION, 1),
                        3); // Block.UPDATE_CLIENTS 标志
            }
        }
    }


}
