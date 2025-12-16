package com.shengchanshe.chang_sheng_jue.block.custom.weaponrack;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TridentItem;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

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

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        if (blockEntity instanceof WeaponRackEntity entity) {
            ItemStack item = pPlayer.getMainHandItem();
            if (item.getItem() instanceof TieredItem || item.getItem() instanceof TridentItem) {
                if (!pLevel.isClientSide) {
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

}
