package com.shengchanshe.chang_sheng_jue.block.custom;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.entity.WeaponRackEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
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

    private static final VoxelShape NORTH_SHAPE = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 15.0D, 13.0D);
    private static final VoxelShape EAST_SHAPE = Block.box(3.0D, 0.0D, 0.0D, 13.0D, 15.0D, 16.0D);
    private static final VoxelShape SOUTH_SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 13.0D);
    private static final VoxelShape WEST_SHAPE = Block.box(3.0D, 0.0D, 0.0D, 13.0D, 15.0D, 16.0D);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction facing = pState.getValue(FACING);


        // 根据朝向选择形状组
        switch (facing) {
            case NORTH:
                return NORTH_SHAPE;
            case EAST:
                return EAST_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return NORTH_SHAPE;
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

    private boolean checkWeapon(ItemStack item) {
        return item.getItem().equals(Items.WOODEN_SWORD)
                || item.getItem().equals(Items.STONE_SWORD)
                || item.getItem().equals(Items.IRON_SWORD)
                || item.getItem().equals(Items.DIAMOND_SWORD)
                || item.getItem().equals(Items.GOLDEN_SWORD)
                || item.getItem().equals(Items.NETHERITE_SWORD)
                || item.getItem().equals(Items.TRIDENT);
    }

    private boolean checkModWeapon(ItemStack item) {
        return item.getItem().equals(ChangShengJueItems.BEAT_DOG_STICK.get())
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

    private boolean checkfather(ItemStack item) {
        if(item.getItem() instanceof SwordItem){
            return true;
        }
        return false;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof WeaponRackEntity entity) {
            ItemStack item = pPlayer.getMainHandItem();
            if (checkWeapon(item) || checkModWeapon(item) ||checkfather(item)) {
                if (!pLevel.isClientSide ) {
                    if(pPlayer.getAbilities().instabuild){
                        ItemStack itemcopy = item.copy();
                        entity.addItem(itemcopy);
                        return InteractionResult.SUCCESS;
                    } else {
                        entity.addItem(item);
                    }
                }
            } else {
                entity.drops(pPlayer);
                return InteractionResult.SUCCESS;
            }

        }
        return InteractionResult.SUCCESS;
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
