package com.shengchanshe.changshengjue.block.custom.shing_mun.right;

import com.shengchanshe.changshengjue.block.custom.shing_mun.right.entity.ShingMunRightEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class ShingMunRight extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty REST = BooleanProperty.create("rest");

    public static final BooleanProperty ONE = BooleanProperty.create("one");
    public static final BooleanProperty TWO = BooleanProperty.create("two");
    public static final BooleanProperty THREE = BooleanProperty.create("three");
    public static final BooleanProperty FOUR = BooleanProperty.create("four");
    public static final BooleanProperty FIVE = BooleanProperty.create("five");
    public static final BooleanProperty SIX = BooleanProperty.create("six");
    public static final BooleanProperty SEVEN = BooleanProperty.create("seven");
    public static final BooleanProperty EIGHT = BooleanProperty.create("eight");

    public ShingMunRight(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN,false)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(LEFT, false)
                .setValue(REST,false)
                .setValue(ONE, false)
                .setValue(TWO,false)
                .setValue(THREE, false)
                .setValue(FOUR,false)
                .setValue(FIVE, false)
                .setValue(SIX,false)
                .setValue(SEVEN, false)
                .setValue(EIGHT,false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction playerFacing = context.getHorizontalDirection().getOpposite(); // 获取玩家的背面方向（通常是方块正面）
        return this.defaultBlockState()
                .setValue(FACING, playerFacing) // 设置朝向
                .setValue(HALF, DoubleBlockHalf.LOWER) // 默认设置为 LOWER
                .setValue(LEFT, false) // 默认设置为 Right 列
                .setValue(OPEN, false)
                .setValue(ONE, false)
                .setValue(TWO,false)
                .setValue(THREE, false)
                .setValue(FOUR,false)
                .setValue(FIVE, false)
                .setValue(SIX,false)
                .setValue(SEVEN, false)
                .setValue(EIGHT,false); // 默认关闭
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction facing = pState.getValue(FACING); // 获取方块当前朝向
        // 获取当前面向方向的顺时针方向
        Direction rightDirection = facing.getClockWise();
        //获取朝向的后侧方向
        Direction backDirection = facing.getOpposite();

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 4; y++) {
                for (int z = 0; z < 2; z++) {
                    BlockPos targetPos = pPos.relative(rightDirection, x).relative(backDirection, z).above(y);
                    BlockState targetState = pLevel.getBlockState(targetPos);

                    if (!targetState.canBeReplaced()) {
                        return false;
                    }
                }
            }
        }

        for (int x = -1; x < 3; x++) {
            for (int y = -1; y < 5; y++) {
                for (int z = -1; z < 3; z++) {
                    BlockPos targetPos = pPos.relative(rightDirection, x).relative(backDirection, z).above(y);
                    BlockState targetState = pLevel.getBlockState(targetPos);

                    if (targetState.getBlock() instanceof ShingMunRight) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        // 检查当前是否在客户端，如果不是客户端则执行以下代码
        if (!pLevel.isClientSide) {
            // 获取当前方块状态的方向属性
            Direction facing = pState.getValue(FACING);
            // 获取当前方向的顺时针方向
            Direction rightDirection = facing.getClockWise();

            // 遍历x轴，范围是0到1
            for (int x = 0; x < 2; x++) {
                // 遍历y轴，范围是0到3
                for (int y = 0; y < 4; y++) {
                    // 计算目标位置，根据当前方块位置、顺时针方向和y轴偏移
                    BlockPos targetPos = pPos.relative(rightDirection, x).above(y);
                    // 设置新的方块状态，根据y轴和x轴的值来确定不同的属性
                    BlockState newState = pState
                            .setValue(HALF, y < 2 ? DoubleBlockHalf.LOWER : DoubleBlockHalf.UPPER) // 设置上下半块
                            .setValue(LEFT, x == 1) // 设置是否为左半部分
                            .setValue(ONE, y == 0 && x == 0) // 设置第一个方块
                            .setValue(TWO,y == 0 && x == 1) // 设置第二个方块
                            .setValue(THREE, y == 1 && x == 0) // 设置第三个方块
                            .setValue(FOUR,y == 1 && x == 1) // 设置第四个方块
                            .setValue(FIVE, y == 2 && x == 0) // 设置第五个方块
                            .setValue(SIX,y == 2 && x == 1) // 设置第六个方块
                            .setValue(SEVEN, y == 3 && x == 0) // 设置第七个方块
                            .setValue(EIGHT,y == 3 && x == 1); // 设置第八个方块

                    // 更新目标位置的方块状态
                    pLevel.setBlockAndUpdate(targetPos, newState);
                }
            }
            // 获取当前方块位置的方块实体
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            // 如果方块实体是ShingMunRightEntity的实例，则设置其开放状态
            if (blockEntity instanceof ShingMunRightEntity entity) {
                entity.setOpen(pState.getValue(OPEN));
            }
        }
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ShingMunRightEntity entity) {
            boolean isOpen = state.getValue(OPEN);
            entity.setOpen(isOpen); // 将 BlockState 中的 open 状态同步到 BlockEntity
            entity.setLeft(state.getValue(LEFT)); // 将 BlockState 中的 left 状态同步到 BlockEntity
            entity.setRest(state.getValue(REST)); // 将 BlockState 中的 rest 状态同步到 BlockEntity
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            // 切换当前方块的 open 状态
            boolean newOpen = !state.getValue(OPEN);
            level.setBlock(pos, state.setValue(OPEN, newOpen), 3);

            // 同步到 BlockEntity
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof ShingMunRightEntity entity) {
                entity.setOpen(newOpen);
            }
            // 同步切换周围相同类型的方块的 open 状态
            syncNeighborBlocks(level, pos, newOpen,true, new HashSet<>());
        }
        return InteractionResult.SUCCESS;
    }

    /**
     * 同步切换周围相同类型方块的 open 状态。
     */
    private void syncNeighborBlocks(Level level, BlockPos pos, boolean newOpen, boolean newRest, Set<BlockPos> visited) {
        // 避免重复访问
        if (visited.contains(pos)) {
            return;
        }
        visited.add(pos);

        for (Direction direction : Direction.values()) {
            BlockPos neighborPos = pos.relative(direction);
            BlockState neighborState = level.getBlockState(neighborPos);

            // 检查邻近方块是否是相同类型的方块
            if (neighborState.getBlock() instanceof ShingMunRight && neighborState.getValue(OPEN) != newOpen) {
                level.setBlock(neighborPos, neighborState.setValue(OPEN, newOpen), 3);

                // 同步更新邻近方块的 BlockEntity
                BlockEntity neighborEntity = level.getBlockEntity(neighborPos);
                if (neighborEntity instanceof ShingMunRightEntity neighborShingMunEntity) {
                    neighborShingMunEntity.setOpen(newOpen);
                    neighborShingMunEntity.setRest(newRest);
                }

                // 递归调用以同步更远的方块
                syncNeighborBlocks(level, neighborPos, newOpen, true,visited);
            }
        }
    }
    
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING); // 获取朝向
        boolean open = pState.getValue(OPEN); // 获取是否打开
        Boolean left = pState.getValue(LEFT);

//      根据是否打开选择碰撞箱的形状
//      OPEN = false 时，保持原始碰撞箱
        return switch (facing) {
            case WEST -> !open ? Block.box(0, 0, 0, 5, 16, 16)
                    : !left ? Block.box(0, 0, 11, 16, 16, 16)
                    : Block.box(16, 0, 27, 32, 16, 32);

            case EAST -> !open ? Block.box(11, 0, 0, 16, 16, 16)
                    : !left ? Block.box(0, 0, 0, 16, 16, 5)
                    : Block.box(-16, 0, -16, 0, 16, -11);

            case SOUTH -> !open ? Block.box(0, 0, 11, 16, 16, 16)
                    : !left ? Block.box(11, 0, 0, 16, 16, 16)
                    : Block.box(27, 0, -16, 32, 16, 0);

            default -> !open ? Block.box(0, 0, 0, 16, 16, 5)
                    : !left ? Block.box(0, 0, 0, 5, 16, 16)
                    : Block.box(-16, 0, 16, -11, 16, 32);
        };
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);

        // 如果新状态的方块不是同一类型，则意味着方块被移除，开始检查结构完整性
        if (pState.getBlock() != pNewState.getBlock()) {
            // 找到整个结构的根位置（底层左侧方块）
            BlockPos rootPos = findRootPosition(pLevel, pPos, pState);

            // 检查整个结构是否完整
            if (!isStructureIntact(pLevel, rootPos, pState)) {
                // 如果不完整，移除整个结构
                destroyEntireStructure(pLevel, rootPos, pState);
            }
        }
    }

    /**
     * 找到整个结构的根位置（假设结构是规则的 2x4x2，从左下角开始）
     */
    private BlockPos findRootPosition(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction facing = pState.getValue(FACING); // 当前结构的方向
        Direction rightDirection = facing.getCounterClockWise(); // 右侧方向

        // 从当前位置向下查找最低点
        BlockPos currentPos = pPos;
        while (pLevel.getBlockState(currentPos.below()).getBlock() == this) {
            currentPos = currentPos.below();
        }

        // 从最低点向左查找最左侧点
        while (pLevel.getBlockState(currentPos.relative(rightDirection.getOpposite())).getBlock() == this) {
            currentPos = currentPos.relative(rightDirection.getOpposite());
        }

        return currentPos;
    }

    /**
     * 检查整个结构是否完整
     */
    private boolean isStructureIntact(Level pLevel, BlockPos rootPos, BlockState pState) {
        Direction facing = pState.getValue(FACING); // 当前结构的方向
        Direction rightDirection = facing.getCounterClockWise(); // 右侧方向

        // 遍历 2x4x2 的所有方块
        for (int x = 0; x < 2; x++) { // 宽度
            for (int y = 0; y < 4; y++) { // 高度
                BlockPos targetPos = rootPos.relative(rightDirection, x).above(y);
                BlockState targetState = pLevel.getBlockState(targetPos);

                // 如果目标方块不是当前方块的一部分，则结构不完整
                if (targetState.getBlock() != this) {
                    return false;
                }
            }
        }

        return true; // 结构完整
    }

    /**
     * 销毁整个 2x4x2 的结构
     */
    private void destroyEntireStructure(Level pLevel, BlockPos rootPos, BlockState pState) {
        Direction facing = pState.getValue(FACING);
        Direction rightDirection = facing.getCounterClockWise();

        // 遍历 2x4x2 的所有方块并移除
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 4; y++) {
                BlockPos targetPos = rootPos.relative(rightDirection, x).above(y);
                BlockState targetState = pLevel.getBlockState(targetPos);

                // 如果目标方块是当前方块的一部分，则移除
                if (targetState.getBlock() == this) {
                    pLevel.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 35);
                    pLevel.levelEvent(2001, targetPos, Block.getId(targetState)); // 发出破坏事件
                }
            }
        }
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        if (pState.getValue(OPEN)) {
            return true;
        }
        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,HALF, LEFT,OPEN,REST,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ShingMunRightEntity(blockPos,blockState);
    }
}
