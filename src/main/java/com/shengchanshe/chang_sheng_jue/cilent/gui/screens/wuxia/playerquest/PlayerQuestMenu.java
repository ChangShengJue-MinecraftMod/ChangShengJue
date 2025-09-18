package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest;

import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class PlayerQuestMenu extends AbstractContainerMenu {
    private List<Quest> quests;
    private int currentPage;
    private Player player;

    public PlayerQuestMenu(int containerId, Inventory playerInv, Player player) {
        super(ChangShengJueMenuTypes.PLAYER_QUEST_MENU.get(), containerId);
        this.player = player;
        refreshQuests();
        this.currentPage = 0;

        // 绑定玩家背包槽位
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 100000));
            }
        }
        // 绑定快捷栏
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 100000));
        }
    }

    public void refreshQuests() {
        if (player.level().isClientSide) {
            // 客户端从本地缓存获取
            this.quests = ClientQuestDataCache.get().getPlayerQuests(player.getUUID());
        } else {
            // 服务端直接从能力系统获取
            this.quests = player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                    .map(cap -> cap.getQuests(player.getUUID()))
                    .orElse(Collections.emptyList());
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true; // 始终可打开
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    // 获取当前页任务
    public Optional<Quest> getCurrentQuest(int page) {
        if (quests.isEmpty() || page < 0 || page >= quests.size()) {
            return Optional.empty();
        }

        Quest quest = quests.get(page);
        if (quest.getAcceptedBy() == null) {
            return Optional.empty();
        }

        return Optional.of(quest);
    }


    // 是否有上一页
    public boolean hasPrevPage() {
        return currentPage > 0;
    }

    // 是否有下一页
    public boolean hasNextPage() {
        return currentPage + 1 < quests.size();
    }

    // 翻页方法
    public void nextPage() {
        if (hasNextPage()) {
            currentPage++;
        } else {
            currentPage = 0;
        }
    }

    public void prevPage() {
        if (hasPrevPage()) {
            currentPage--;
        } else {
            currentPage = quests.size() - 1;
        }
    }

    // 在放弃任务后调用此方法来调整页码
    public void adjustPageAfterQuestRemoval() {
        refreshQuests(); // 刷新任务列表

        if (quests.isEmpty()) {
            currentPage = 0;
            return;
        }

        // 如果当前页码超出了新列表的范围，调整到最后一页
        if (currentPage >= quests.size()) {
            currentPage = quests.size() - 1;
        }

        // 如果当前页的任务已被移除或被别人接受，找到最近的有效页面
        if (currentPage >= 0 && currentPage < quests.size()) {
            Quest currentQuest = quests.get(currentPage);
            if (currentQuest.getAcceptedBy() == null) {
                // 当前页任务无效，需要找到最近的有效页面
                findNearestValidPage();
            }
        }
    }

    // 找到最近的有效任务页面
    private void findNearestValidPage() {
        if (quests.isEmpty()) {
            currentPage = 0;
            return;
        }

        // 向前查找
        for (int i = currentPage; i >= 0; i--) {
            if (i < quests.size() && quests.get(i).getAcceptedBy() != null) {
                currentPage = i;
                return;
            }
        }

        // 向后查找
        for (int i = currentPage; i < quests.size(); i++) {
            if (quests.get(i).getAcceptedBy() != null) {
                currentPage = i;
                return;
            }
        }

        // 如果没有找到有效任务，重置到第一页
        currentPage = 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalPages() {
        return Math.max(1, quests.size());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
