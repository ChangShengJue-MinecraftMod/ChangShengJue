package com.shengchanshe.chang_sheng_jue.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.nbt.*;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QuestDataStorage {
    private static final String FILE_NAME = "quest_data.dat";
    private static final String COMPLETED_QUESTS_FILE = "completed_quests.dat";
    private static final String ACCEPT_QUEST_FILE = "accept_quest.dat";
    private static final String QUEST_COMPLETION_COUNTS_FILE = "quest_completion_counts.dat";

    public static void saveCompletionCounts(Map<UUID, Integer> counts, Path path) {
        try {
            Path file = path.resolve(QUEST_COMPLETION_COUNTS_FILE);
            CompoundTag tag = new CompoundTag();

            // 写入统计数据
            counts.forEach((questId, count) ->
                    tag.putInt(questId.toString(), count)
            );

            // 修正的写入方法
            try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file.toFile()))) {
                NbtIo.writeCompressed(tag, output);
            }

        } catch (Exception e) {
            ChangShengJue.LOGGER.error("保存任务完成次数失败", e);
        }
    }

    public static Map<UUID, Integer> loadCompletionCounts(Path path) {
        Path file = path.resolve(QUEST_COMPLETION_COUNTS_FILE);
        if (!Files.exists(file)) return new HashMap<>();

        try {
            CompoundTag tag = NbtIo.readCompressed(file.toFile());
            Map<UUID, Integer> counts = new HashMap<>();

            for (String key : tag.getAllKeys()) {
                counts.put(UUID.fromString(key), tag.getInt(key));
            }

            return counts;
        } catch (Exception e) {
            ChangShengJue.LOGGER.error("加载任务完成次数失败", e);
            return new HashMap<>();
        }
    }

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

    // 保存已完成不可重复任务记录
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

    // 加载已完成不可重复任务记录
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

    // 保存已完成任务记录
    public static void saveDoneQuests(Set<UUID> doneQuestsIds, Path path) {
        CompoundTag tag = new CompoundTag();
        ListTag list = new ListTag();
        doneQuestsIds.forEach(uuid -> list.add(NbtUtils.createUUID(uuid)));
        tag.put("acceptQuest", list);

        try {
            NbtIo.writeCompressed(tag, path.resolve(ACCEPT_QUEST_FILE).toFile());
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("保存已完成任务记录失败", e);
        }
    }

    // 加载已完成不可重复任务记录
    public static Set<UUID> loadDoneQuests(Path path) {
        Set<UUID> acceptQuest = new HashSet<>();
        File file = path.resolve(ACCEPT_QUEST_FILE).toFile();

        if (file.exists()) {
            try {
                CompoundTag tag = NbtIo.readCompressed(file);
                ListTag list = tag.getList("acceptQuest", Tag.TAG_INT_ARRAY);
                list.forEach(t -> acceptQuest.add(NbtUtils.loadUUID(t)));
            } catch (IOException e) {
                ChangShengJue.LOGGER.error("加载已完成任务记录失败", e);
            }
        }
        return acceptQuest;
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

            // 初始化已完成不可重复任务记录文件
            File completedFile = path.resolve(COMPLETED_QUESTS_FILE).toFile();
            if (!completedFile.exists()) {
                CompoundTag tag = new CompoundTag();
                tag.put("completed", new ListTag());
                NbtIo.writeCompressed(tag, completedFile);
            }

            // 初始化已完成任务记录文件
            File doneQuestsFile = path.resolve(ACCEPT_QUEST_FILE).toFile();
            if (!doneQuestsFile.exists()) {
                CompoundTag tag = new CompoundTag();
                tag.put("acceptQuest", new ListTag());
                NbtIo.writeCompressed(tag, doneQuestsFile);
            }
        } catch (IOException e) {
            ChangShengJue.LOGGER.error("初始化任务文件失败", e);
        }
    }

}