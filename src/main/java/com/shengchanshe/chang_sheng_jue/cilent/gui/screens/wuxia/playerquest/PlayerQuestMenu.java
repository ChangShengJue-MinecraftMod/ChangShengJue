package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerQuestMenu extends AbstractContainerMenu {
    private final List<Quest> quests;
    private int currentPage;
    private Player player;

    // 客户端构造函数（通过FriendlyByteBuf）
    public PlayerQuestMenu(int containerId, Inventory playerInv, FriendlyByteBuf data) {
        this(containerId, playerInv,
                QuestManager.getInstance().decodeQuests(data), // 从网络包解码
                data.readInt());
    }

    public PlayerQuestMenu(int containerId, Inventory playerInv, List<Quest> quests, int page) {
        super(ChangShengJueMenuTypes.PLAYER_QUEST_MENU.get(), containerId);
        this.quests = quests;
        this.currentPage = page;

        // 绑定玩家背包槽位（关键！）
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
            return Optional.empty(); // 防止越界
        }
        return Optional.of(quests.get(page));
    }


    public void removedCurrentQuest(UUID questId) {
        this.getCurrentQuest(currentPage).ifPresent(quest -> {
            if (quest.getQuestId().equals(questId)) {
                quests.remove(quest);
            }
        });
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
        if (hasNextPage()) currentPage++;
    }

    public void prevPage() {
        if (hasPrevPage()) currentPage--;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
