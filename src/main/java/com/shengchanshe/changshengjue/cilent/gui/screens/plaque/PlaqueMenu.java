package com.shengchanshe.changshengjue.cilent.gui.screens.plaque;

import com.shengchanshe.changshengjue.block.entity.PlaqueEntity;
import com.shengchanshe.changshengjue.cilent.gui.screens.ChangShengJueMenuTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;


public class PlaqueMenu extends AbstractContainerMenu {
    public final PlaqueEntity blockEntity;
    private final Level level;

    public PlaqueMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public PlaqueMenu(int pContainerId, Inventory inv, BlockEntity entity) {
        super(ChangShengJueMenuTypes.PLAQUE_MENU.get(), pContainerId);
        checkContainerSize(inv, 2);
        blockEntity = ((PlaqueEntity) entity);
        this.level = inv.player.level();

    }
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    public BlockPos getBlockPos() {
        return blockEntity.getBlockPos();
    }
}