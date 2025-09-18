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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GangQuestsMenu extends AbstractContainerMenu {
    private final List<Quest> availableQuests;
    private int currentPage = 0;
    private final Merchant trader;
    private final Player player;

    public GangQuestsMenu(int id, Inventory inventory, FriendlyByteBuf extraData) {
        this(id, inventory, new ClientSideMerchant(inventory.player),
                readQuestsFromBuffer(extraData));
    }

    public GangQuestsMenu(int containerId, Inventory inv, Merchant merchant, List<Quest> availableQuests) {
        super(ChangShengJueMenuTypes.GANG_QUESTS_MENU.get(), containerId);
        this.player = inv.player;
        this.availableQuests = availableQuests != null ?
                sortQuestsByWeight(availableQuests) : new ArrayList<>();
        this.trader = merchant;

        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 100000));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inv, col, 8 + col * 18, 100000));
        }
    }

    private List<Quest> sortQuestsByWeight(List<Quest> quests) {
        List<Quest> sortedQuests = new ArrayList<>(quests);
        sortedQuests.sort((q1, q2) -> {
            // 首先按权重降序排序
            int weightCompare = Integer.compare(q2.getWeight(), q1.getWeight());
            if (weightCompare != 0) {
                return weightCompare;
            }
            // 权重相同的按任务ID排序（确保顺序稳定）
            return q1.getQuestId().compareTo(q2.getQuestId());
        });
        return sortedQuests;
    }

    private static List<Quest> readQuestsFromBuffer(FriendlyByteBuf extraData) {
        List<Quest> quests = new ArrayList<>();
        int questCount = extraData.readInt();
        for (int i = 0; i < questCount; i++) {
            Quest quest = new Quest(Objects.requireNonNull(extraData.readNbt()));
            quests.add(quest);
        }
        return quests;
    }

    public void nextPage() {
        if (currentPage < getTotalPages() - 1) {
            currentPage++;
        }else {
            currentPage = 0;
        }
    }

    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
        }else {
            currentPage = getTotalPages() - 1;
        }
    }

    public Quest getCurrentQuest() {
        if (availableQuests.isEmpty()) {
            return null;
        }
        if (currentPage >= 0 && currentPage < availableQuests.size()) {
            return availableQuests.get(currentPage);
        }
        return availableQuests.get(0);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return Math.max(1, availableQuests.size());
    }

    public List<Quest> getAllAvailableQuests() {
        return availableQuests;
    }

    public void updateAvailableQuests(List<Quest> newQuests){
        availableQuests.clear();
        List<Quest> sorted = sortQuestsByWeight(newQuests);
        availableQuests.addAll(sorted);

        if (availableQuests.isEmpty()) {
            currentPage = 0;
        } else if (currentPage >= availableQuests.size()) {
            currentPage = availableQuests.size() - 1;
        } else if (currentPage < 0) {
            currentPage = 0;
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
        return ItemStack.EMPTY;
    }

    public Merchant getTrader() {
        return trader;
    }

    public Player getPlayer() {
        return player;
    }
}