package com.shengchanshe.changshengjue.block.custom_cropper;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LotusBlock extends CropBlock implements SimpleWaterloggedBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 20.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 23.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 25.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D)};

    public LotusBlock(Properties p_53928_) {
        super(p_53928_);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ChangShengJueItems.LOTUS_SEEDS.get();
    }

    @Override
    public VoxelShape getShape(BlockState p_52297_, BlockGetter p_52298_, BlockPos p_52299_, CollisionContext p_52300_) {
        return SHAPE_BY_AGE[p_52297_.getValue(this.getAgeProperty())];
    }

    @Override
    public int getMaxAge() {
        return 7;
    }


    @Override
    public boolean canPlaceLiquid(BlockGetter p_54766_, BlockPos p_54767_, BlockState p_54768_, Fluid p_54769_) {
        return false;
    }

    @Override
    public boolean placeLiquid(LevelAccessor p_54770_, BlockPos p_54771_, BlockState p_54772_, FluidState p_54773_) {
        return false;
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter world, BlockPos pos) {
        return super.getLightEmission(state, world, pos);
    }

    public FluidState getFluidState(BlockState p_54319_) {
        return Fluids.WATER.getSource(true);
    }
    @Override
    protected boolean mayPlaceOn(BlockState p_52302_, BlockGetter worldIn, BlockPos pos) {
        BlockState underState = worldIn.getBlockState(pos);
        BlockState aboveFluidState = worldIn.getBlockState(pos.above());
        BlockState aboveFluidState1 = worldIn.getBlockState(pos.above().above());
        return (p_52302_.is(Blocks.DIRT)) && aboveFluidState.is(Blocks.WATER) && aboveFluidState1.isAir();
    }
}

