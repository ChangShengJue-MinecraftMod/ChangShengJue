package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.checkin;

import com.shengchanshe.chang_sheng_jue.checkin.CheckInDataManager;
import com.shengchanshe.chang_sheng_jue.checkin.CheckInRewardConfig;
import com.shengchanshe.chang_sheng_jue.checkin.PlayerCheckInData;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.network.packet.checkin.ClientCheckInDataCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * 签到菜单容器
 */
public class CheckInMenu extends AbstractContainerMenu {
    private final Player player;
    private PlayerCheckInData checkInData;

    public CheckInMenu(int containerId, Inventory playerInv, Player player) {
        super(ChangShengJueMenuTypes.CHECKIN_MENU.get(), containerId);
        this.player = player;

        // 初始化签到数据
        if (player.level() instanceof ServerLevel serverLevel) {
            // 服务端
            CheckInDataManager manager = CheckInDataManager.get(serverLevel);
            this.checkInData = manager.getPlayerData(player.getUUID());
        } else {
            // 客户端
            this.checkInData = ClientCheckInDataCache.getPlayerData();
            if (this.checkInData == null) {
                this.checkInData = new PlayerCheckInData(player.getUUID());
            }
        }

        // 添加玩家背包槽位(隐藏在屏幕外)
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInv, col + row * 9 + 9, 8 + col * 18, 100000));
            }
        }
        // 添加快捷栏
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(playerInv, col, 8 + col * 18, 100000));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    /**
     * 获取签到数据
     */
    public PlayerCheckInData getCheckInData() {
        return checkInData;
    }

    /**
     * 获取今日奖励(基础数量,不含倍数)
     */
    public ItemStack getTodayBaseReward() {
        if (checkInData == null) {
            return ItemStack.EMPTY;
        }
        int dayIndex = checkInData.getCurrentRewardIndex();
        int poolSize = CheckInRewardConfig.getRewardListSize(dayIndex);
        boolean isServerSide = player.level() instanceof ServerLevel;
        int randomIndex = checkInData.getTodayRandomRewardIndex(poolSize, isServerSide);
        return CheckInRewardConfig.getTodayRandomReward(dayIndex, randomIndex);
    }

    /**
     * 获取今日奖励(含倍数)
     */
    public ItemStack getTodayReward() {
        if (checkInData == null) {
            return ItemStack.EMPTY;
        }
        int dayIndex = checkInData.getCurrentRewardIndex();
        int poolSize = CheckInRewardConfig.getRewardListSize(dayIndex);
        boolean isServerSide = player.level() instanceof ServerLevel;
        int randomIndex = checkInData.getTodayRandomRewardIndex(poolSize, isServerSide);
        ItemStack baseReward = CheckInRewardConfig.getTodayRandomReward(dayIndex, randomIndex);
        double multiplier = checkInData.getRewardMultiplier();
        int newCount = (int) Math.ceil(baseReward.getCount() * multiplier);
        baseReward.setCount(newCount);
        return baseReward;
    }

    /**
     * 获取明日奖励(基础数量,不含倍数)
     */
    public ItemStack getTomorrowBaseReward() {
        if (checkInData == null) {
            return ItemStack.EMPTY;
        }
        return CheckInRewardConfig.getNextReward(checkInData.getCurrentRewardIndex());
    }

    /**
     * 是否已签到
     */
    public boolean hasCheckedInToday() {
        return checkInData != null && checkInData.hasCheckedInToday();
    }

    /**
     * 获取累计签到天数
     */
    public int getTotalDays() {
        return checkInData != null ? checkInData.getTotalDays() : 0;
    }

    /**
     * 获取连续签到天数
     */
    public int getConsecutiveDays() {
        return checkInData != null ? checkInData.getConsecutiveDays() : 0;
    }

    /**
     * 获取明日奖励倍数
     */
    public double getTomorrowMultiplier() {
        return checkInData != null ? checkInData.getTomorrowRewardMultiplier() : 1.0;
    }

    /**
     * 获取指定天数的奖励(基础数量,不含倍数)
     * @param dayIndex 0-6 代表第1-7天
     */
    public ItemStack getRewardForDay(int dayIndex) {
        if (dayIndex < 0 || dayIndex >= 7) {
            return ItemStack.EMPTY;
        }
        return CheckInRewardConfig.getReward(dayIndex).getItemStack();
    }

    /**
     * 刷新数据
     */
    public void refreshData() {
        if (player.level() instanceof ServerLevel serverLevel) {
            CheckInDataManager manager = CheckInDataManager.get(serverLevel);
            this.checkInData = manager.getPlayerData(player.getUUID());
        } else {
            this.checkInData = ClientCheckInDataCache.getPlayerData();
        }
    }
}
