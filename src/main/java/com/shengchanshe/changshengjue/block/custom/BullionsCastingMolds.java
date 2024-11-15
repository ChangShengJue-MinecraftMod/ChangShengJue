package com.shengchanshe.changshengjue.block.custom;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.entity.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.changshengjue.block.entity.CastingMoldsBlockEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class BullionsCastingMolds extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public BullionsCastingMolds(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction value = pState.getValue(FACING);
        return switch (value){
            default -> Block.box(3, 0, 3, 13, 8, 13);
        };
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
        ItemStack mainHandItem = pPlayer.getMainHandItem();
        ItemStack offhandItem = pPlayer.getOffhandItem();
        if (handItem(mainHandItem,offhandItem)){
            if (blockEntity instanceof BullionsCastingMoldsBlockEntity entity){
                if (!pLevel.isClientSide && entity.addItem(pPlayer.getAbilities().instabuild ? pPlayer.getMainHandItem().copy() : pPlayer.getMainHandItem())){
                    return InteractionResult.SUCCESS;
                }
            }
            return InteractionResult.CONSUME;
        }else {
            if (blockEntity instanceof BullionsCastingMoldsBlockEntity) {
                ((BullionsCastingMoldsBlockEntity) blockEntity).drops();
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
    }
    public boolean handItem(ItemStack mainHandItem,ItemStack offhandItem){
        return mainHandItem.getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get() || offhandItem.getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get()
                || mainHandItem.getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get() || offhandItem.getItem() == ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get();
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof BullionsCastingMoldsBlockEntity) {
                ((BullionsCastingMoldsBlockEntity) blockentity).drops();
            }
            super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof BullionsCastingMoldsBlockEntity entity) {
            ItemStackHandler inventory = entity.getInventory();
            if (!inventory.getStackInSlot(0).isEmpty() && inventory.getStackInSlot(1).isEmpty()) {
                BlockPos blockpos = pPos.below();
                BlockState blockstate = pLevel.getBlockState(blockpos);
                if (!blockstate.isFaceSturdy(pLevel, blockpos, Direction.UP)) {
                    if (this.canBurn(pLevel.getBlockState(pPos.west()))) {
                        for(int j = 0; j < 2; ++j) {
                            double d3 = (double)pPos.getX() + pRandom.nextDouble() * (double)0.1F;
                            double d8 = (double)pPos.getY() + pRandom.nextDouble();
                            double d13 = (double)pPos.getZ() + pRandom.nextDouble();
                            pLevel.addParticle(ParticleTypes.SMOKE, d3, d8, d13, 0.0D, 0.0D, 0.0D);
                        }
                    }
                    if (this.canBurn(pLevel.getBlockState(pPos.east()))) {
                        for(int k = 0; k < 2; ++k) {
                            double d4 = (double)(pPos.getX() + 1) - pRandom.nextDouble() * (double)0.1F;
                            double d9 = (double)pPos.getY() + pRandom.nextDouble();
                            double d14 = (double)pPos.getZ() + pRandom.nextDouble();
                            pLevel.addParticle(ParticleTypes.SMOKE, d4, d9, d14, 0.0D, 0.0D, 0.0D);
                        }
                    }
                    if (this.canBurn(pLevel.getBlockState(pPos.north()))) {
                        for(int l = 0; l < 2; ++l) {
                            double d5 = (double)pPos.getX() + pRandom.nextDouble();
                            double d10 = (double)pPos.getY() + pRandom.nextDouble();
                            double d15 = (double)pPos.getZ() + pRandom.nextDouble() * (double)0.1F;
                            pLevel.addParticle(ParticleTypes.SMOKE, d5, d10, d15, 0.0D, 0.0D, 0.0D);
                        }
                    }
                    if (this.canBurn(pLevel.getBlockState(pPos.south()))) {
                        for(int i1 = 0; i1 < 2; ++i1) {
                            double d6 = (double)pPos.getX() + pRandom.nextDouble();
                            double d11 = (double)pPos.getY() + pRandom.nextDouble();
                            double d16 = (double)(pPos.getZ() + 1) - pRandom.nextDouble() * (double)0.1F;
                            pLevel.addParticle(ParticleTypes.SMOKE, d6, d11, d16, 0.0D, 0.0D, 0.0D);
                        }
                    }
                    if (this.canBurn(pLevel.getBlockState(pPos.above()))) {
                        for(int j1 = 0; j1 < 2; ++j1) {
                            double d7 = (double)pPos.getX() + pRandom.nextDouble();
                            double d12 = (double)(pPos.getY() + 1) - pRandom.nextDouble() * (double)0.1F;
                            double d17 = (double)pPos.getZ() + pRandom.nextDouble();
                            pLevel.addParticle(ParticleTypes.SMOKE, d7, d12, d17, 0.0D, 0.0D, 0.0D);
                        }
                    }
                } else {
                    for(int i = 0; i < 3; ++i) {
                        double d0 = (double)pPos.getX() + pRandom.nextDouble();
                        double d1 = (double)pPos.getY() + pRandom.nextDouble() * 0.5D + 0.5D;
                        double d2 = (double)pPos.getZ() + pRandom.nextDouble();
                        pLevel.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                    }
                }
                super.animateTick(pState, pLevel, pPos, pRandom);
            }
//            else if (!inventory.getStackInSlot(0).isEmpty() && !inventory.getStackInSlot(1).isEmpty()){
//                pLevel.playLocalSound((double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.FIRE_EXTINGUISH,
//                        SoundSource.BLOCKS, 1.0F + pRandom.nextFloat(), pRandom.nextFloat() * 0.7F + 0.3F, false);
//            }
        }
    }
    protected boolean canBurn(BlockState pState) {
        return true;
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide){
            return null;
        }
        return createTickerHelper(pBlockEntityType, ChangShengJueBlocksEntities.BULLIONS_CASTING_MOLDS_BLOCK_ENTITY.get(),((pLevel1, pPos, pState1, pBlockEntity) -> pBlockEntity.tick()));
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
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
        return new BullionsCastingMoldsBlockEntity(pPos,pState);
    }
}
