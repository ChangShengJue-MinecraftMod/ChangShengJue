package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;

import java.util.Objects;

public class GangQuestsMenu extends AbstractContainerMenu {
    private final Quest quest;
    private final Merchant trader;
    private Player player;

    public GangQuestsMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, new ClientSideMerchant(inventory.player),
                // 从网络包读取NPC UUID和任务数据
                new Quest(Objects.requireNonNull(extraData.readNbt())));
    }

    public GangQuestsMenu(int containerId, Inventory inv, Merchant merchant, Quest quest) {
        super(ChangShengJueMenuTypes.GANG_QUESTS_MENU.get(), containerId);
        this.quest = quest;
        this.trader = merchant;
        this.player = inv.player;

        // 绑定玩家背包槽位（关键！）
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 100000));
            }
        }
        // 绑定快捷栏
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inv, col, 8 + col * 18, 100000));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void slotsChanged(Container container) {
        super.slotsChanged(container);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY; // 禁止物品移动
    }

    public Quest getGangQuests() {
        return quest;
    }

    public Merchant getTrader() {
        return trader;
    }

    public Player getPlayer() {
        return player;
    }
}