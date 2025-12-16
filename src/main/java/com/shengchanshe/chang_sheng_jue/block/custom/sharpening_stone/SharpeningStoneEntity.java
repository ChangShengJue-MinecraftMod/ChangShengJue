package com.shengchanshe.chang_sheng_jue.block.custom.sharpening_stone;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class SharpeningStoneEntity extends BlockEntity {
    private int durability;
    private final int maxDurability;

    public SharpeningStoneEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        // 根据具体的磨刀石类型设置耐久
        if (state.getBlock() instanceof StoneSharpeningStone) {
            this.maxDurability = 20;  // 石磨刀石20耐久
        } else if (state.getBlock() instanceof DiamondSharpeningStone) {
            this.maxDurability = 30;  // 钻石磨刀石30耐久
        } else if (state.getBlock() instanceof NetheriteSharpeningStone) {
            this.maxDurability = 50;  // 下界合金磨刀石50耐久
        } else {
            this.maxDurability = 20;
        }

        this.durability = maxDurability;
    }

    public static SharpeningStoneEntity create(BlockPos pos, BlockState state) {
        return new SharpeningStoneEntity(
                ChangShengJueBlocksEntities.SHARPENING_STONE_BLOCK_ENTITY.get(),
                pos,
                state
        );
    }

    public int getDurability() {
        return durability;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    // 检查是否有足够耐久
    public boolean hasDurability() {
        return durability > 0;
    }

    public void reduceDurability(int amount) {
        int oldDurability = durability;
        durability = Math.max(0, durability - amount);
        setChanged();

        if (level != null && !level.isClientSide && oldDurability != durability) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }

        if (durability <= 0 && level != null) {
            level.destroyBlock(worldPosition, false);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Durability", durability);
        tag.putInt("MaxDurability", maxDurability);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        int loadedDurability = tag.getInt("Durability");
        this.durability = Math.max(0, Math.min(loadedDurability, maxDurability));
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}