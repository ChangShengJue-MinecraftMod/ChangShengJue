package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ArhatBedEntity extends BlockEntity {
    public ArhatBedEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.ARHAT_BED_ENTITY.get(), pPos, pBlockState);
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
