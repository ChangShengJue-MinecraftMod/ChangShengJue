package com.shengchanshe.changshengjue.block.custom_cropper;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GrapeBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, -4.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -4.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -11.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -11.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -16.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -16.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -16.0D, 0.0D, 16.0D, 1.0D, 16.0D),
            Block.box(0.0D, -16.0D, 0.0D, 16.0D, 1.0D, 16.0D)};
    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return SHAPE_BY_AGE[blockState.getValue(this.getAgeProperty())];
    }
    public GrapeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter p_60579_, BlockPos p_60580_) {
        return SHAPE_BY_AGE[blockState.getValue(this.getAgeProperty())];
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_52302_, BlockGetter p_52303_, BlockPos p_52304_) {
        return p_52302_.is(ChangShengJueBlocks.GRAPE_SHELF_BLOCK.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return (reader.getBlockState(pos.below(1)).is(ChangShengJueBlocks.GRAPE_SHELF_BLOCK.get()));
    }

    @Override
    public int getMaxAge() {
        return 7;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ChangShengJueItems.GRAPE_SEEDS.get();
    }
}
