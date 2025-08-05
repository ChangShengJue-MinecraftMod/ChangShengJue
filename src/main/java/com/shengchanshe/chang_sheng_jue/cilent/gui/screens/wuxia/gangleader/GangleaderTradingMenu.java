package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MerchantContainer;
import net.minecraft.world.inventory.MerchantResultSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffers;

import java.util.UUID;

public class GangleaderTradingMenu extends AbstractContainerMenu {
    protected static final int PAYMENT1_SLOT = 0;
//    protected static final int PAYMENT2_SLOT = 1;
    protected static final int RESULT_SLOT = 2;
    private static final int INV_SLOT_START = 3;
    private static final int INV_SLOT_END = 30;
    private static final int USE_ROW_SLOT_START = 30;
    private static final int USE_ROW_SLOT_END = 38;
    private static final int SELL_SLOT1_X = 148;
//    private static final int SELL_SLOT2_X = 161;
    private static final int BUY_SLOT_X = 206;
    private static final int ROW_Y = 81;
    private final Merchant trader;
    private final MerchantContainer tradeContainer;
    private int merchantLevel;
    private boolean showProgressBar;
    private boolean canRestock;
    private Player player;

    public GangleaderTradingMenu(int id, Inventory inventory) {
        this(id, inventory, new ClientSideMerchant(inventory.player));
    }

    public GangleaderTradingMenu(int id, Inventory inventory, Merchant merchant) {
        super(ChangShengJueMenuTypes.GANGLEADER_MENU.get(), id);
        this.trader = merchant;
        this.tradeContainer = new MerchantContainer(merchant);
        this.player = inventory.player;
        this.addSlot(new Slot(this.tradeContainer, PAYMENT1_SLOT, SELL_SLOT1_X, ROW_Y));
//        this.addSlot(new Slot(this.tradeContainer, PAYMENT2_SLOT, SELL_SLOT2_X, ROW_Y));
        this.addSlot(new MerchantResultSlot(inventory.player, merchant, this.tradeContainer, RESULT_SLOT, BUY_SLOT_X, ROW_Y));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 109 + j * 18, 128 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 109 + k * 18, 186));
        }

    }

    public void setShowProgressBar(boolean showProgressBar) {
        this.showProgressBar = showProgressBar;
    }

    @Override
    public void slotsChanged(Container container) {
        this.tradeContainer.updateSellItem();
        super.slotsChanged(container);
    }

    public void setSelectionHint(int selectionHint) {
        this.tradeContainer.setSelectionHint(selectionHint);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.trader.getTradingPlayer() == player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTraderXp() {
        return this.trader.getVillagerXp();
    }

    public int getFutureTraderXp() {
        return this.tradeContainer.getFutureXp();
    }

    public void setXp(int xp) {
        this.trader.overrideXp(xp);
    }

    public int getTraderLevel() {
        return this.merchantLevel;
    }

    public UUID getNpcUUID() {
        if (this.trader instanceof AbstractVillager) {
            return ((AbstractVillager)this.trader).getUUID();
        }else {
            return UUID.randomUUID();
        }
    }

    public Merchant getTrader() {
        return trader;
    }

    public void setMerchantLevel(int level) {
        this.merchantLevel = level;
    }

    public void setCanRestock(boolean canRestock) {
        this.canRestock = canRestock;
    }

    public boolean canRestock() {
        return this.canRestock;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack itemStack, Slot slot) {
        return false;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == RESULT_SLOT) {
                if (!this.moveItemStackTo(itemstack1, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
                this.playTradeSound();
            } else if (index != PAYMENT1_SLOT) {
                if (index >= INV_SLOT_START && index < INV_SLOT_END) {
                    if (!this.moveItemStackTo(itemstack1, USE_ROW_SLOT_START, USE_ROW_SLOT_END, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= USE_ROW_SLOT_START && index < USE_ROW_SLOT_END && !this.moveItemStackTo(itemstack1, INV_SLOT_START, INV_SLOT_END, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, INV_SLOT_START, USE_ROW_SLOT_END, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    private void playTradeSound() {
        if (!this.trader.isClientSide()) {
            Entity entity = (Entity)this.trader;
            entity.level().playLocalSound(entity.getX(), entity.getY(), entity.getZ(), this.trader.getNotifyTradeSound(), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
        }
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.trader.setTradingPlayer(null);
        if (!this.trader.isClientSide()) {
            if (!player.isAlive() || player instanceof ServerPlayer && ((ServerPlayer)player).hasDisconnected()) {
                ItemStack itemstack = this.tradeContainer.removeItemNoUpdate(PAYMENT1_SLOT);
                if (!itemstack.isEmpty()) {
                    player.drop(itemstack, false);
                }
            } else if (player instanceof ServerPlayer) {
                player.getInventory().placeItemBackInInventory(this.tradeContainer.removeItemNoUpdate(PAYMENT1_SLOT));
            }

        }
    }

    public void tryMoveItems(int index) {
        if (this.getOffers().size() > index) {
            ItemStack itemstack = this.tradeContainer.getItem(PAYMENT1_SLOT);
            if (!itemstack.isEmpty()) {
                if (!this.moveItemStackTo(itemstack, INV_SLOT_START, USE_ROW_SLOT_END, true)) {
                    return;
                }

                this.tradeContainer.setItem(PAYMENT1_SLOT, itemstack);
            }


            if (this.tradeContainer.getItem(PAYMENT1_SLOT).isEmpty()) {
                ItemStack itemstack2 = this.getOffers().get(index).getCostA();
                this.moveFromInventoryToPaymentSlot(PAYMENT1_SLOT, itemstack2);
            }

        }
    }

    private void moveFromInventoryToPaymentSlot(int index, ItemStack itemStack) {
        if (!itemStack.isEmpty()) {
            for(int i = INV_SLOT_START; i < USE_ROW_SLOT_END; ++i) {
                ItemStack itemstack = this.slots.get(i).getItem();
                if (!itemstack.isEmpty() && ItemStack.isSameItemSameTags(itemStack, itemstack)) {
                    ItemStack itemstack1 = this.tradeContainer.getItem(index);
                    int j = itemstack1.isEmpty() ? 0 : itemstack1.getCount();
                    int k = Math.min(itemStack.getMaxStackSize() - j, itemstack.getCount());
                    ItemStack itemstack2 = itemstack.copy();
                    int l = j + k;
                    itemstack.shrink(k);
                    itemstack2.setCount(l);
                    this.tradeContainer.setItem(index, itemstack2);
                    if (l >= itemStack.getMaxStackSize()) {
                        break;
                    }
                }
            }
        }

    }

    public void setOffers(MerchantOffers offers) {
        this.trader.overrideOffers(offers);
    }

    public MerchantOffers getOffers() {
        return this.trader.getOffers();
    }

    public boolean showProgressBar() {
        return this.showProgressBar;
    }
}
