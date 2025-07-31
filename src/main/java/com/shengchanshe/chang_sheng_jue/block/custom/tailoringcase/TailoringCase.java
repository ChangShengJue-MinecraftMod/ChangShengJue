package com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class TailoringCase extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(
            Direction.NORTH, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Direction.SOUTH, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Direction.EAST, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D),
            Direction.WEST, Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)));


    public TailoringCase(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AABBS.get(pState.getValue(FACING));
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if(pState.getBlock() != pNewState.getBlock()){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof TailoringCaseEntity){
                ((TailoringCaseEntity) blockEntity).drop();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof TailoringCaseEntity){
                NetworkHooks.openScreen((ServerPlayer) pPlayer, (TailoringCaseEntity) blockEntity, pPos);
            } else {
                throw new IllegalStateException("容器提供者消失!");
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if(pLevel.isClientSide){
            return null;
        }
        return createTickerHelper(pBlockEntityType, ChangShengJueBlocksEntities.TAILORING_CASE_ENTITY.get(),
                (pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick(pLevel1, pPos, pState1));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new TailoringCaseEntity(pPos,pState);
    }

}
