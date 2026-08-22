package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueEntity;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueTextLayout;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.Plaque;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.MenuBlockEntityResolver;
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
    private final boolean backingEntityValid;

    public PlaqueMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, MenuBlockEntityResolver.resolve(
                inv.player.level(), extraData.readBlockPos(), PlaqueEntity.class,
                ChangShengJueBlocks.PLAQUE.get(), PlaqueEntity::new));
    }

    public PlaqueMenu(int pContainerId, Inventory inv, BlockEntity entity) {
        this(pContainerId, inv, MenuBlockEntityResolver.resolve(
                inv.player.level(), entity, PlaqueEntity.class,
                ChangShengJueBlocks.PLAQUE.get(), PlaqueEntity::new));
    }

    private PlaqueMenu(int pContainerId, Inventory inv,
                       MenuBlockEntityResolver.Resolution<PlaqueEntity> resolution) {
        super(ChangShengJueMenuTypes.PLAQUE_MENU.get(), pContainerId);
        checkContainerSize(inv, 2);
        blockEntity = resolution.entity();
        this.level = inv.player.level();
        this.backingEntityValid = resolution.valid();

    }
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        BlockPos pos = this.blockEntity.getBlockPos();
        return hasValidBackingEntity()
                && this.blockEntity.getLevel() == this.level
                && this.level.hasChunkAt(pos)
                && this.level.getBlockEntity(pos) == this.blockEntity
                && this.level.getBlockState(pos).getBlock() instanceof Plaque
                && pPlayer.distanceToSqr(
                        pos.getX() + 0.5D,
                        pos.getY() + 0.5D,
                        pos.getZ() + 0.5D) <= 64.0D;
    }

    public BlockPos getBlockPos() {
        return blockEntity.getBlockPos();
    }

    public int getTextCapacity() {
        return hasValidBackingEntity() ? PlaqueTextLayout.getCapacity(this.level, this.getBlockPos()) : 0;
    }

    public String getPlaqueText() {
        return hasValidBackingEntity() ? PlaqueTextLayout.read(this.level, this.getBlockPos()) : "";
    }

    public boolean hasValidBackingEntity() {
        return this.backingEntityValid
                && MenuBlockEntityResolver.isWorldBackingValid(
                this.level, this.blockEntity, ChangShengJueBlocks.PLAQUE.get());
    }
}
