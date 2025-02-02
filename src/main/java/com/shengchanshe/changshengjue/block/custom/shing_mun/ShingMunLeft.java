package com.shengchanshe.changshengjue.block.custom.shing_mun;

import com.shengchanshe.changshengjue.block.custom.shing_mun.entity.ShingMunLeftEntity;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class ShingMunLeft extends BaseEntityBlock{
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty REST = BooleanProperty.create("rest");

    public static final BooleanProperty ONE = BooleanProperty.create("one");
    public static final BooleanProperty TWO = BooleanProperty.create("two");
    public static final BooleanProperty THREE = BooleanProperty.create("three");
    public static final BooleanProperty FOUR = BooleanProperty.create("four");
    public static final BooleanProperty FIVE = BooleanProperty.create("five");
    public static final BooleanProperty SIX = BooleanProperty.create("six");
    public static final BooleanProperty SEVEN = BooleanProperty.create("seven");
    public static final BooleanProperty EIGHT = BooleanProperty.create("eight");

    public ShingMunLeft(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN,false)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(RIGHT, false)
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

    public Direction rightOf(Direction facing) {
        switch (facing) {
            case NORTH:
                return Direction.WEST;
            case EAST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.EAST;
            case WEST:
                return Direction.SOUTH;
            default:
                return facing; // 如果不是水平方向，就返回原方向
        }
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction facing = pState.getValue(FACING); // 获取方块当前朝向
        Direction rightDirection = rightOf(facing); // 获取朝向的右侧方向

        // 检查 2x4x2 的所有位置是否为可替换方块
        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 4; y++) {
                BlockPos targetPos = pPos.relative(rightDirection, x).above(y); // 获取目标位置
                BlockState targetState = pLevel.getBlockState(targetPos);

                // 检查目标位置是否是可替换方块
                if (!targetState.canBeReplaced()) {
                    return false; // 如果某个位置不可替换，返回 false
                }
            }
        }
        return true; // 如果所有位置都是可替换方块，返回 true
    }

//    @Override
//    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
//        if (!pLevel.isClientSide && pPlacer instanceof Player player) {
//            // 获取当前方块朝向
//            Direction facing = pState.getValue(FACING); // 方块的朝向
//            Direction rightDirection = rightOf(facing); // 当前方块的右侧方向
//
//            // 获取玩家点击的位置信息
//            HitResult hitResult = player.pick(5.0D, 0.0F, false); // 检测玩家的点击位置
//            if (!(hitResult instanceof BlockHitResult blockHitResult)) {
//                return; // 如果不是 BlockHitResult，则退出
//            }
//
//            // 计算点击位置相对当前方块的位置
//            Vec3 hitLocation = blockHitResult.getLocation(); // 点击的世界坐标
//            double hitX = hitLocation.x - pPos.getX(); // 相对 X 坐标
//            double hitZ = hitLocation.z - pPos.getZ(); // 相对 Z 坐标
//
//            // 判断玩家点击的是左侧还是右侧
//            boolean isRightClick = false;
//            switch (facing) {
//                case NORTH -> isRightClick = hitX > 0.5; // 朝北时，X > 0.5 表示右侧
//                case SOUTH -> isRightClick = hitX < 0.5; // 朝南时，X < 0.5 表示右侧
//                case WEST -> isRightClick = hitZ < 0.5; // 朝西时，Z < 0.5 表示右侧
//                case EAST -> isRightClick = hitZ > 0.5; // 朝东时，Z > 0.5 表示右侧
//            }
//
//            // 调试输出点击位置和方向
//            System.out.println("Player clicked at relative position: X=" + hitX + ", Z=" + hitZ);
//            System.out.println("Facing: " + facing + ", Is Right Click: " + isRightClick);
//
//            // 遍历 2x4x2 区域，根据点击位置调整生成顺序00000
//            for (int x = 0; x < 2; x++) { // 宽度为 2
//                for (int y = 0; y < 4; y++) { // 高度为 4
//                    // 根据 isRightClick 决定生成方块的位置
//                    int offsetX = isRightClick ? x : 1 - x; // 如果是右侧点击，按正常顺序；左侧点击，反转顺序
//                    BlockPos targetPos = pPos.relative(rightDirection, offsetX).above(y); // 计算目标位置
//
//                    // 动态设置 ONE 到 EIGHT 属性
//                    boolean isOne = (offsetX == 0 && y == 0);
//                    boolean isTwo = (offsetX == 1 && y == 0);
//                    boolean isThree = (offsetX == 0 && y == 1);
//                    boolean isFour = (offsetX == 1 && y == 1);
//                    boolean isFive = (offsetX == 0 && y == 2);
//                    boolean isSix = (offsetX == 1 && y == 2);
//                    boolean isSeven = (offsetX == 0 && y == 3);
//                    boolean isEight = (offsetX == 1 && y == 3);
//
//                    // 构造新状态
//                    BlockState newState = pState
//                            .setValue(HALF, y < 2 ? DoubleBlockHalf.LOWER : DoubleBlockHalf.UPPER) // 前两层为 LOWER，后两层为 UPPER
//                            .setValue(RIGHT, offsetX == 1) // 第二列的方块标记为 RIGHT
//                            .setValue(ONE, isOne)
//                            .setValue(TWO, isTwo)
//                            .setValue(THREE, isThree)
//                            .setValue(FOUR, isFour)
//                            .setValue(FIVE, isFive)
//                            .setValue(SIX, isSix)
//                            .setValue(SEVEN, isSeven)
//                            .setValue(EIGHT, isEight);
//
//                    // 打印调试信息
//                    System.out.println("Placing block at: " + targetPos + ", State: " + newState);
//
//                    // 放置目标方块
//                    pLevel.setBlockAndUpdate(targetPos, newState);
//                }
//            }
//
//            // 初始化根方块的 BlockEntity
//            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
//            if (blockEntity instanceof ShingMunLeftEntity entity) {
//                entity.setOpen(pState.getValue(OPEN)); // 初始化 open 值
//            }
//        }
//    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        if (!pLevel.isClientSide) {
            Direction facing = pState.getValue(FACING); // 获取当前方块的朝向
            Direction rightDirection = rightOf(facing); // 计算右侧方向

            // 遍历 2x4x2 区域
            for (int x = 0; x < 2; x++) { // 宽度为 2
                for (int y = 0; y < 4; y++) { // 高度为 4
                    BlockPos targetPos = pPos.relative(rightDirection, x).above(y); // 计算目标位置

                    // 构造新状态
                    BlockState newState = pState
                            .setValue(HALF, y < 2 ? DoubleBlockHalf.LOWER : DoubleBlockHalf.UPPER) // 前两层为 LOWER，后两层为 UPPER
                            .setValue(RIGHT, x == 1)
                            .setValue(ONE, y == 0 && x == 0)
                            .setValue(TWO,y == 0 && x == 1)
                            .setValue(THREE, y == 1 && x == 0)
                            .setValue(FOUR,y == 1 && x == 1)
                            .setValue(FIVE, y == 2 && x == 0)
                            .setValue(SIX,y == 2 && x == 1)
                            .setValue(SEVEN, y == 3 && x == 0)
                            .setValue(EIGHT,y == 3 && x == 1); // 第二列的方块标记为 RIGHT

                    // 直接替换目标位置的方块（包括可替换的方块）
                    pLevel.setBlockAndUpdate(targetPos, newState);
                }
            }

            // 同步 BlockEntity 的初始状态
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ShingMunLeftEntity entity) {
                entity.setOpen(pState.getValue(OPEN)); // 初始化 open 值
            }
        }
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
        Direction rightDirection = rightOf(facing); // 右侧方向

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
        Direction rightDirection = rightOf(facing); // 右侧方向

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
        Direction rightDirection = rightOf(facing);

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

//    @Override
//    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pNeighborBlock, BlockPos pNeighborPos, boolean pMovedByPiston) {
//        super.neighborChanged(pState, pLevel, pPos, pNeighborBlock, pNeighborPos, pMovedByPiston);
//    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction playerFacing = context.getHorizontalDirection().getOpposite(); // 获取玩家的背面方向（通常是方块正面）
        return this.defaultBlockState()
                .setValue(FACING, playerFacing) // 设置朝向
                .setValue(HALF, DoubleBlockHalf.LOWER) // 默认设置为 LOWER
                .setValue(RIGHT, false) // 默认设置为 LEFT 列
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
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ShingMunLeftEntity entity) {
            boolean isOpen = state.getValue(OPEN);
            entity.setOpen(isOpen); // 将 BlockState 中的 open 状态同步到 BlockEntity
            entity.setRight(state.getValue(RIGHT)); // 将 BlockState 中的 right 状态同步到 BlockEntity
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
            if (blockEntity instanceof ShingMunLeftEntity entity) {
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
            if (neighborState.getBlock() instanceof ShingMunLeft && neighborState.getValue(OPEN) != newOpen) {
                level.setBlock(neighborPos, neighborState.setValue(OPEN, newOpen), 3);

                // 同步更新邻近方块的 BlockEntity
                BlockEntity neighborEntity = level.getBlockEntity(neighborPos);
                if (neighborEntity instanceof ShingMunLeftEntity neighborShingMunEntity) {
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
        Boolean right = pState.getValue(RIGHT);

//      根据是否打开选择碰撞箱的形状
//      OPEN = false 时，保持原始碰撞箱
        return switch (facing) {
            case WEST -> !open ? Block.box(0, 0, 0, 5, 16, 16) : !right ?  Block.box(0, 0, 0, 16, 16, 5) : Block.box(16, 0, -16, 32, 16, -11);
            case EAST -> !open ? Block.box(11, 0, 0, 16, 16, 16) : !right ? Block.box(0, 0, 11, 16, 16, 16) : Block.box(16, 0, 27, 32, 16, 32);
            case SOUTH -> !open ? Block.box(0, 0, 11, 16, 16, 16) : !right ? Block.box(0, 0, 0, 5, 16, 16) : Block.box(-16, 0, -16, -11, 16, 0);
            default -> !open ? Block.box(0, 0, 0, 16, 16, 5) : !right ? Block.box(11, 0, 0, 16, 16, 16) : Block.box(27, 0, 16, 32, 16, 32);
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING,HALF,RIGHT,OPEN,REST,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ShingMunLeftEntity(pPos,pState);
    }
}
