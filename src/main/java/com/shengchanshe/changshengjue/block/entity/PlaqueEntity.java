package com.shengchanshe.changshengjue.block.entity;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PlaqueEntity extends SignBlockEntity{
    public PlaqueEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.PLAQUE_ENTITY.get(),pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ChangShengJueBlocksEntities.PLAQUE_ENTITY.get();
    }
}
