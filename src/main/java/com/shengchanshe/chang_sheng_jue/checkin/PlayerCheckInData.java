package com.shengchanshe.chang_sheng_jue.checkin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 玩家签到数据
 */
public class PlayerCheckInData implements INBTSerializable<CompoundTag> {
    private final UUID playerId;
    private long lastCheckInDate; // 最后签到日期 (以天为单位的时间戳)
    private int consecutiveDays; // 连续签到天数
    private int totalDays; // 累计签到天数
    private int currentRewardIndex; // 当前奖励索引(在奖励列表中轮换)
    private final List<ItemStack> receivedRewards; // 本轮7日已获得的奖励(最多7个)
    private int todayRandomRewardIndex; // 今日随机奖励索引
    private long todayRandomRewardDate; // 今日随机奖励对应的日期

    public PlayerCheckInData(UUID playerId) {
        this.playerId = playerId;
        this.lastCheckInDate = 0;
        this.consecutiveDays = 0;
        this.totalDays = 0;
        this.currentRewardIndex = 0;
        this.receivedRewards = new ArrayList<>();
        this.todayRandomRewardIndex = -1;
        this.todayRandomRewardDate = 0;
    }

    /**
     * 获取当前日期(以天为单位)
     */
    private static long getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() / (24 * 60 * 60 * 1000);
    }

    /**
     * 根据现实世界星期几获取签到索引
     */
    private static int getRewardIndexFromDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return switch (dayOfWeek) {
            case Calendar.MONDAY -> 0;
            case Calendar.TUESDAY -> 1;
            case Calendar.WEDNESDAY -> 2;
            case Calendar.THURSDAY -> 3;
            case Calendar.FRIDAY -> 4;
            case Calendar.SATURDAY -> 5;
            case Calendar.SUNDAY -> 6;
            default -> 0;
        };
    }

    /**
     * 检查今天是否已签到
     */
    public boolean hasCheckedInToday() {
        return lastCheckInDate == getCurrentDay();
    }

    /**
     * 执行签到
     * @param reward 实际获得的奖励物品
     * @return true表示签到成功,false表示今天已签到
     */
    public boolean checkIn(ItemStack reward) {
        long currentDay = getCurrentDay();

        if (hasCheckedInToday()) {
            return false;
        }

        int todayIndex = getRewardIndexFromDayOfWeek();

        if (lastCheckInDate == currentDay - 1) {
            consecutiveDays++;
        } else if (lastCheckInDate < currentDay - 1) {
            consecutiveDays = 1;
        }

        if (todayIndex == 0) {
            receivedRewards.clear();
        }

        lastCheckInDate = currentDay;
        totalDays++;

        currentRewardIndex = todayIndex;

        while (receivedRewards.size() <= currentRewardIndex) {
            receivedRewards.add(ItemStack.EMPTY);
        }
        receivedRewards.set(currentRewardIndex, reward.copy());

        return true;
    }

    /**
     * 获取签到奖励倍数
     */
    public double getRewardMultiplier() {
        double multiplier = 1.0;

        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {
            multiplier *= 1.5;
        }

        if (consecutiveDays >= 1) {
            multiplier *= 2.0;
        }

        return multiplier;
    }

    /**
     * 预测明日奖励倍数
     */
    public double getTomorrowRewardMultiplier() {
        double multiplier = 1.0;

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == Calendar.SUNDAY) {
            multiplier *= 1.5;
        }

        int tomorrowConsecutiveDays = hasCheckedInToday() ? consecutiveDays + 1 : 1;
        if (tomorrowConsecutiveDays >= 1) {
            multiplier *= 2.0;
        }

        return multiplier;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public long getLastCheckInDate() {
        return lastCheckInDate;
    }

    public int getConsecutiveDays() {
        return consecutiveDays;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getCurrentRewardIndex() {
        return getRewardIndexFromDayOfWeek();
    }

    /**
     * 获取今日随机奖励索引(仅服务端调用生成随机数,客户端直接返回同步的值)
     */
    public int getTodayRandomRewardIndex(int poolSize, boolean isServerSide) {
        if (isServerSide) {
            long currentDay = getCurrentDay();
            if (todayRandomRewardDate != currentDay) {
                Random random = new Random();
                todayRandomRewardIndex = random.nextInt(poolSize);
                todayRandomRewardDate = currentDay;
            } else if (todayRandomRewardIndex < 0 || todayRandomRewardIndex >= poolSize) {
                Random random = new Random();
                todayRandomRewardIndex = random.nextInt(poolSize);
            }
        }
        return todayRandomRewardIndex < 0 || todayRandomRewardIndex >= poolSize ? 0 : todayRandomRewardIndex;
    }

    /**
     * 获取指定天数已获得的奖励
     * @param dayIndex 0-6 代表第1-7天
     * @return 如果该天已签到则返回奖励,否则返回null
     */
    public ItemStack getReceivedReward(int dayIndex) {
        if (dayIndex < 0 || dayIndex >= receivedRewards.size()) {
            return ItemStack.EMPTY;
        }
        return receivedRewards.get(dayIndex).copy();
    }

    public boolean hasReceivedReward(int dayIndex) {
        if (dayIndex < 0 || dayIndex >= receivedRewards.size()) {
            return false;
        }
        int currentDayIndex = getRewardIndexFromDayOfWeek();
        if (currentDayIndex < currentRewardIndex && dayIndex > currentDayIndex) {
            return false;
        }
        return !receivedRewards.get(dayIndex).isEmpty();
    }

    public boolean hasMissedReward(int dayIndex) {
        int currentDayIndex = getRewardIndexFromDayOfWeek();
        if (currentDayIndex < currentRewardIndex && dayIndex > currentDayIndex) {
            return false;
        }
        return dayIndex < currentDayIndex && !hasReceivedReward(dayIndex);
    }

    /**
     * 获取已签到的天数(本轮7日中)
     */
    public int getReceivedRewardCount() {
        int count = 0;
        for (ItemStack stack : receivedRewards) {
            if (!stack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putUUID("PlayerId", playerId);
        tag.putLong("LastCheckInDate", lastCheckInDate);
        tag.putInt("ConsecutiveDays", consecutiveDays);
        tag.putInt("TotalDays", totalDays);
        tag.putInt("CurrentRewardIndex", currentRewardIndex);
        tag.putInt("TodayRandomRewardIndex", todayRandomRewardIndex);
        tag.putLong("TodayRandomRewardDate", todayRandomRewardDate);

        ListTag rewardsList = new ListTag();
        for (ItemStack reward : receivedRewards) {
            CompoundTag rewardTag = new CompoundTag();
            reward.save(rewardTag);
            rewardsList.add(rewardTag);
        }
        tag.put("ReceivedRewards", rewardsList);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        lastCheckInDate = tag.getLong("LastCheckInDate");
        consecutiveDays = tag.getInt("ConsecutiveDays");
        totalDays = tag.getInt("TotalDays");
        currentRewardIndex = tag.getInt("CurrentRewardIndex");
        todayRandomRewardIndex = tag.getInt("TodayRandomRewardIndex");
        todayRandomRewardDate = tag.getLong("TodayRandomRewardDate");

        receivedRewards.clear();
        if (tag.contains("ReceivedRewards", Tag.TAG_LIST)) {
            ListTag rewardsList = tag.getList("ReceivedRewards", Tag.TAG_COMPOUND);
            for (int i = 0; i < rewardsList.size(); i++) {
                CompoundTag rewardTag = rewardsList.getCompound(i);
                ItemStack reward = ItemStack.of(rewardTag);
                receivedRewards.add(reward);
            }
        }
    }
}
