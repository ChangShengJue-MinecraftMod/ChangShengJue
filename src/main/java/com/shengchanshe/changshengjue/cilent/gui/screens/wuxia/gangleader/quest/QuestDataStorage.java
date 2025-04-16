package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.nbt.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QuestDataStorage {
    private static final String FILE_NAME = "quest_data.dat";
    // 新增常量（文件名）
    private static final String COMPLETED_QUESTS_FILE = "completed_quests.dat";

    // 保存方法（适配List<Quest>）
    public static void save(Map<UUID, List<Quest>> quests, Path path) {
        CompoundTag root = new CompoundTag();
        ListTag playerQuestList = new ListTag();

        quests.forEach((uuid, questsList) -> {
            CompoundTag playerEntry = new CompoundTag();
            playerEntry.putUUID("player", uuid);

            // 存储该玩家的所有任务
            ListTag questsTag = new ListTag();
            questsList.forEach(quest -> questsTag.add(quest.toNbt()));
            playerEntry.put("quests", questsTag);

            playerQuestList.add(playerEntry);
        });

        root.put("players", playerQuestList);

        try {
            NbtIo.writeCompressed(root, path.resolve(FILE_NAME).toFile());
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("任务数据保存失败", e);
        }
    }

    // 加载方法（返回Map<UUID, List<Quest>>）
    public static Map<UUID, List<Quest>> load(Path path) {
        Map<UUID, List<Quest>> result = new ConcurrentHashMap<>();
        File file = path.resolve(FILE_NAME).toFile();

        if (!file.exists()) return result;

        try {
            CompoundTag root = NbtIo.readCompressed(file);
            ListTag playerQuestList = root.getList("players", Tag.TAG_COMPOUND);

            for (Tag playerTag : playerQuestList) {
                CompoundTag playerEntry = (CompoundTag) playerTag;
                UUID playerId = playerEntry.getUUID("player");

                // 加载该玩家的任务列表
                List<Quest> quests = new ArrayList<>();
                ListTag questsTag = playerEntry.getList("quests", Tag.TAG_COMPOUND);

                for (Tag questTag : questsTag) {
                    quests.add(new Quest((CompoundTag) questTag));
                }

                result.put(playerId, quests);
            }
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("任务数据加载失败", e);
        }

        return result;
    }

    // 新增方法：保存已完成不可重复任务记录
    public static void saveCompletedQuests(Set<UUID> completedQuestIds, Path path) {
        CompoundTag tag = new CompoundTag();
        ListTag list = new ListTag();
        completedQuestIds.forEach(uuid -> list.add(NbtUtils.createUUID(uuid)));
        tag.put("completed", list);

        try {
            NbtIo.writeCompressed(tag, path.resolve(COMPLETED_QUESTS_FILE).toFile());
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("保存已完成任务记录失败", e);
        }
    }

    // 新增方法：加载已完成不可重复任务记录
    public static Set<UUID> loadCompletedQuests(Path path) {
        Set<UUID> completed = new HashSet<>();
        File file = path.resolve(COMPLETED_QUESTS_FILE).toFile();

        if (file.exists()) {
            try {
                CompoundTag tag = NbtIo.readCompressed(file);
                ListTag list = tag.getList("completed", Tag.TAG_INT_ARRAY);
                list.forEach(t -> completed.add(NbtUtils.loadUUID(t)));
            } catch (IOException e) {
                ChangShengJue.LOGGER.error("加载已完成任务记录失败", e);
            }
        }
        return completed;
    }

    public static void initWorldData(Path path) {
        try {
            Files.createDirectories(path);

            // 初始化主任务文件
            File questFile = path.resolve(FILE_NAME).toFile();
            if (!questFile.exists()) {
                CompoundTag root = new CompoundTag();
                root.put("players", new ListTag()); // 修改为与save()一致的结构
                NbtIo.writeCompressed(root, questFile);
            }

            // 初始化已完成任务记录文件
            File completedFile = path.resolve(COMPLETED_QUESTS_FILE).toFile();
            if (!completedFile.exists()) {
                CompoundTag tag = new CompoundTag();
                tag.put("completed", new ListTag());
                NbtIo.writeCompressed(tag, completedFile);
            }
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("初始化任务文件失败", e);
        }
    }

}