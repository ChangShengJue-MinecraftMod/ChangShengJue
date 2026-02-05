package com.shengchanshe.chang_sheng_jue.checkin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 签到数据管理器,保存所有玩家的签到数据
 */
public class CheckInDataManager extends SavedData {
    private static final String DATA_NAME = "chang_sheng_jue_checkin_data";
    private final Map<UUID, PlayerCheckInData> playerDataMap = new HashMap<>();

    public CheckInDataManager() {
    }

    /**
     * 获取服务端的签到数据管理器
     */
    public static CheckInDataManager get(ServerLevel level) {
        return level.getServer()
                .overworld()
                .getDataStorage()
                .computeIfAbsent(CheckInDataManager::load, CheckInDataManager::new, DATA_NAME);
    }

    /**
     * 从NBT加载数据
     */
    public static CheckInDataManager load(CompoundTag tag) {
        CheckInDataManager manager = new CheckInDataManager();
        ListTag list = tag.getList("PlayerData", Tag.TAG_COMPOUND);

        for (int i = 0; i < list.size(); i++) {
            CompoundTag playerTag = list.getCompound(i);
            UUID playerId = playerTag.getUUID("PlayerId");
            PlayerCheckInData data = new PlayerCheckInData(playerId);
            data.deserializeNBT(playerTag);
            manager.playerDataMap.put(playerId, data);
        }

        return manager;
    }

    /**
     * 获取玩家签到数据
     */
    public PlayerCheckInData getPlayerData(UUID playerId) {
        return playerDataMap.computeIfAbsent(playerId, PlayerCheckInData::new);
    }

    /**
     * 保存数据到NBT
     */
    @Override
    public CompoundTag save(CompoundTag tag) {
        ListTag list = new ListTag();

        for (PlayerCheckInData data : playerDataMap.values()) {
            list.add(data.serializeNBT());
        }

        tag.put("PlayerData", list);
        return tag;
    }

    /**
     * 标记数据已修改
     */
    public void markDirty() {
        this.setDirty();
    }
}
