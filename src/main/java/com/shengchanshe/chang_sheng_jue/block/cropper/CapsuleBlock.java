package com.shengchanshe.chang_sheng_jue.block.cropper;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CapsuleBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CapsuleBlock(Properties properties) {
        super(properties);
    }
    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_52302_, BlockGetter p_52303_, BlockPos p_52304_) {
        return p_52302_.is(Blocks.GRASS_BLOCK);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ChangShengJueItems.CAPSULE.get();
    }
}
