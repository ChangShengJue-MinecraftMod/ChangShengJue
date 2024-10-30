package com.shengchanshe.changshengjue.block.entity;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.decoration.BlueAndWhitePorcelainFlowerPots;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlueAndWhitePorcelainFlowerPotsEntity extends BlockEntity {
    ItemStack middlePlant = ItemStack.EMPTY;

    public BlueAndWhitePorcelainFlowerPotsEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangShengJueBlocksEntities.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS_ENTITY.get(), pPos, pBlockState);
    }

    public ItemStack getPlant(BlueAndWhitePorcelainFlowerPots.Slot slot) {
        return switch (slot) {
            case PLANT -> this.middlePlant;
        };
    }

    public void setPlant(BlueAndWhitePorcelainFlowerPots.Slot slot, ItemStack itemStack) {
        switch (slot) {
            case PLANT -> this.middlePlant = itemStack;
        }
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("Plant", 10)) {
            this.setPlant(BlueAndWhitePorcelainFlowerPots.Slot.PLANT, ItemStack.of(pTag.getCompound("Plant")));
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = super.getUpdateTag();
        compoundtag.put("Plant", this.middlePlant.save(new CompoundTag()));
        return compoundtag;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (!this.getPlant(BlueAndWhitePorcelainFlowerPots.Slot.PLANT).isEmpty()) {
            pTag.put("Plant", this.getPlant(BlueAndWhitePorcelainFlowerPots.Slot.PLANT).save(new CompoundTag()));
        }
    }

}
