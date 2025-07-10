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
        if (quests.isEmpty() || page < 0 || page >= quests.size() || quests.get(page).getAcceptedBy() == null) {
            return Optional.empty();
        }
        return Optional.of(quests.get(page));
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
