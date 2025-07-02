package com.shengchanshe.chang_sheng_jue.block.custom;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.entity.ChangShengJueLoomBlockEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.util.ChangShengJueVoxelShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ChangShengJueLoomBlock extends BaseEntityBlock{
    private VoxelShape AABB = Shapes.empty();
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public ChangShengJueLoomBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        return switch (value){
            case SOUTH -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_SOUTH;
            case WEST -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_WEST;
            case EAST -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_EAST;
            default -> this.AABB = ChangShengJueVoxelShape.CHANG_SHENG_JUE_LOOM_NORTH;
        };
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        ItemStack mainHandItem = pPlayer.getMainHandItem();
        ItemStack offhandItem = pPlayer.getOffhandItem();
        if (mainHandItem.getItem() == ChangShengJueItems.NATURAL_SILK.get() || offhandItem.getItem() == ChangShengJueItems.NATURAL_SILK.get()){
            if (blockEntity instanceof ChangShengJueLoomBlockEntity entity){
                if (!pLevel.isClientSide && entity.addItem(pPlayer.getAbilities().instabuild ? pPlayer.getMainHandItem().copy() : pPlayer.getMainHandItem())){
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof ChangShengJueLoomBlockEntity) {
                ((ChangShengJueLoomBlockEntity) blockentity).drops();
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
        return createTickerHelper(pBlockEntityType, ChangShengJueBlocksEntities.CHANG_SHENG_JUE_LOOM_BLOCK_ENTITY.get(),((pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick()));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ChangShengJueLoomBlockEntity(pPos,pState);
    }
}
