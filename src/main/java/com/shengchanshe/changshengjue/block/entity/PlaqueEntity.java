package com.shengchanshe.changshengjue.block.entity;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.custom.Plaque;
import com.shengchanshe.changshengjue.cilent.gui.screens.plaque.PlaqueMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nullable;

public class PlaqueEntity extends BlockEntity implements MenuProvider {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private String text = ""; // 存储的文字内容

    public PlaqueEntity(BlockPos pos, BlockState state) {
        super(ChangShengJueBlocksEntities.PLAQUE_ENTITY.get(), pos, state);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.setChanged(); // 标记数据变更
    }
    @Override
    public void setChanged() {
        super.setChanged();
        if (this.level != null){
            this.level.sendBlockUpdated(this.getBlockPos(),this.getBlockState(),this.getBlockState(), Block.UPDATE_CLIENTS);
        }
    }
    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.text = tag.getString("Text");
    }
    @Override
    public Component getDisplayName() {
        return Component.translatable("牌匾");
    }

    private CompoundTag writeItems(CompoundTag compoundTag){
        super.saveAdditional(compoundTag);
        compoundTag.putString("Text", this.text);
        return compoundTag;
    }
    @Override
    public CompoundTag getUpdateTag() {
        return this.writeItems(new CompoundTag());
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        this.writeItems(pTag);
    }

    public Direction getFacing() {
        if (this.level != null) {
            this.getBlockPos();
            BlockState state = this.level.getBlockState(this.getBlockPos()); // 获取方块的 BlockState
            if (state.hasProperty(Plaque.FACING)) { // 检查方块是否有 FACING 属性
                return state.getValue(Plaque.FACING); // 返回 FACING 的值
            }
        }
        return Direction.NORTH; // 默认朝向（例如 NORTH）
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new PlaqueMenu(pContainerId, pPlayerInventory, this);
    }
}