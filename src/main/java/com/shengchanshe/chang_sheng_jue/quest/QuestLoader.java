package com.shengchanshe.chang_sheng_jue.quest;

import com.google.gson.*;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class QuestLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static Quest loadSpecificQuest(UUID questId, Set<UUID> completedNonRepeatable,UUID npcId) {
        Map<ResourceLocation, Resource> allResources = getAutomaticResourceLocationResourceMap();

        // 从所有资源中查找指定ID的任务
        for (ResourceLocation loc : allResources.keySet()) {
            try (InputStream stream = allResources.get(loc).open()) {
                JsonObject json = GSON.fromJson(new InputStreamReader(stream), JsonObject.class);

                UUID currentId = UUID.fromString(json.get("questId").getAsString());
                boolean repeatable = json.get("repeatable").getAsBoolean();

                if (repeatable || !completedNonRepeatable.contains(questId)) {
                    if (currentId.equals(questId)) {
                        return parseQuest(json, npcId);
                    }
                }
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("加载任务失败: {}", loc, e);
            }
        }
        return null;
    }
    public static Quest loadSpecificQuest(UUID questId, UUID npcId) {
        Map<ResourceLocation, Resource> allResources = getAutomaticResourceLocationResourceMap();

        // 从所有资源中查找指定ID的任务
        for (ResourceLocation loc : allResources.keySet()) {
            try (InputStream stream = allResources.get(loc).open()) {
                JsonObject json = GSON.fromJson(new InputStreamReader(stream), JsonObject.class);

                UUID currentId = UUID.fromString(json.get("questId").getAsString());

                if (currentId.equals(questId)) {
                    return parseQuest(json, npcId);
                }
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("加载任务失败: {}", loc, e);
            }
        }
        return null;
    }

    public static Quest loadQuest(UUID npcId, Set<UUID> completedNonRepeatable) {
        Map<ResourceLocation, Resource> allResources = getResourceLocationResourceMap();
        List<ResourceLocation> candidates = new ArrayList<>();

        // 筛选候选文件
        for (ResourceLocation loc : allResources.keySet()) {
            try (InputStream stream = allResources.get(loc).open()) {
                JsonObject json = GSON.fromJson(new InputStreamReader(stream), JsonObject.class);

                // 检查是否可重复 或 未完成
                boolean repeatable = json.get("repeatable").getAsBoolean();
                UUID questId = json.has("questId")
                        ? UUID.fromString(json.get("questId").getAsString())
                        : generateDeterministicId(npcId, json);

                if (repeatable || !completedNonRepeatable.contains(questId)) {
                    candidates.add(loc);
                }
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("预扫描任务文件失败: {}", loc, e);
            }
        }

        // 随机选择有效候选
        if (!candidates.isEmpty()) {
            ResourceLocation selected = candidates.get(new Random().nextInt(candidates.size()));
            try (InputStream stream = allResources.get(selected).open()) {
                return parseQuest(GSON.fromJson(new InputStreamReader(stream), JsonObject.class), npcId);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("加载任务失败: {}", selected, e);
            }
        }
        return null; // 无可用任务
    }

    private static @NotNull Map<ResourceLocation, Resource> getAutomaticResourceLocationResourceMap() {
        ResourceManager resourceManager = ServerLifecycleHooks.getCurrentServer().getResourceManager(); // 服务端
        String namespace = ChangShengJue.MOD_ID;

        // 定义任务类型的路径
        String[] questPaths = {"quests/automatic"};
        // 收集任务文件
        Map<ResourceLocation, Resource> allResources = new HashMap<>();

        for (String path : questPaths) {
            Map<ResourceLocation, Resource> resources = resourceManager.listResources(
                    path,
                    location -> location.getNamespace().equals(namespace) && location.getPath().endsWith(".json")
            );
            allResources.putAll(resources);
        }
        return allResources;
    }

    private static @NotNull Map<ResourceLocation, Resource> getResourceLocationResourceMap() {
        ResourceManager resourceManager = ServerLifecycleHooks.getCurrentServer().getResourceManager(); // 服务端
        String namespace = ChangShengJue.MOD_ID;

        // 定义任务类型的路径
        String[] questPaths = {"quests/gather", "quests/kill", "quests/raid", "quests/treat"};
        // 收集任务文件
        Map<ResourceLocation, Resource> allResources = new HashMap<>();

        for (String path : questPaths) {
            Map<ResourceLocation, Resource> resources = resourceManager.listResources(
                    path,
                    location -> location.getNamespace().equals(namespace) && location.getPath().endsWith(".json")
            );
            allResources.putAll(resources);
        }
        return allResources;
    }


    private static Quest parseQuest(JsonObject json,UUID npcId) {
        try {
            // 读取或生成固定ID
            UUID questId = json.has("questId")
                    ? UUID.fromString(json.get("questId").getAsString()) // 从配置读取
                    : generateDeterministicId(npcId, json); // 根据内容生成

            String titleKey = json.has("questName") ? json.get("questName").getAsString() : "";
            String descriptionKey = json.has("questDescription") ? json.get("questDescription").getAsString() : "";
            String title = Component.translatable(titleKey).getString();
            String description = Component.translatable(descriptionKey).getString();

            // 获取任务类型，默认为 GATHER
            String typeStr = json.has("questType") ? json.get("questType").getAsString() : "GATHER";
            Quest.QuestType type = Quest.QuestType.valueOf(typeStr.toUpperCase());

            boolean repeatable = json.has("repeatable") &&  json.get("repeatable").getAsBoolean();

            String questRequirementsDescription = json.has("questRequirementsDescription") ?
                    Component.translatable(json.get("questRequirementsDescription").getAsString()).getString() : "";

            List<QuestEffectEntry> effects = new ArrayList<>();
            if (json.has("effects")) {
                JsonArray effectsJson = json.getAsJsonArray("effects");
                for (JsonElement element : effectsJson) {
                    JsonObject effectJson = element.getAsJsonObject();
                    effects.add(new QuestEffectEntry(
                            effectJson.get("effectId").getAsString(),
                            effectJson.get("duration").getAsInt(),
                            effectJson.get("amplifier").getAsInt(),
                            effectJson.has("isAmbient") && effectJson.get("isAmbient").getAsBoolean(),
                            !effectJson.has("showParticles") || effectJson.get("showParticles").getAsBoolean(),
                            !effectJson.has("showIcon") || effectJson.get("showIcon").getAsBoolean()
                    ));
                }
            }

            List<ItemStack> requirements = json.has("questRequirements") ?
                    parseItemList(json.getAsJsonArray("questRequirements")) : Collections.emptyList();
            List<ItemStack> rewards = json.has("questRewards") ?
                    parseItemList(json.getAsJsonArray("questRewards")) : Collections.emptyList();
            int questDay = json.has("qusetDay") ? json.get("questDay").getAsInt() : 0;

            String targetEntity = json.has("targetEntity") ? json.get("targetEntity").getAsString() : "";
            boolean isEntityTag = targetEntity.startsWith("#");

            // 优先处理minKills和maxKills



            int requiredKills = getrequiredKills(json);

            boolean questGenerateTarget = json.has("questGenerateTarget") && json.get("questGenerateTarget").getAsBoolean();

            int questTargetCount = json.has("questTargetCount") ? json.get("questTargetCount").getAsInt() : 0;

            int questTime = json.has("questTime") ? json.get("questTime").getAsInt() : 0;

            boolean isAcceptQuestEffects = json.has("isAcceptQuestEffects") && json.get("isAcceptQuestEffects").getAsBoolean();

            List<UUID> limitQuestIds = new ArrayList<>();
            if (json.has("limitQuestIds")) {
                JsonArray idArray = json.getAsJsonArray("limitQuestIds");
                for (JsonElement element : idArray) {
                    try {
                        limitQuestIds.add(UUID.fromString(element.getAsString()));
                    } catch (IllegalArgumentException e) {
                        ChangShengJue.LOGGER.error("无效的任务ID格式: {}", element.getAsString());
                    }
                }
            }

            boolean isNeedCompletePreQuest = json.has("isNeedCompletePreQuest") && json.get("isNeedCompletePreQuest").getAsBoolean();

            List<UUID> conflictQuestIds = new ArrayList<>();
            if (json.has("conflictQuestIds")) {
                JsonArray idArray = json.getAsJsonArray("conflictQuestIds");
                for (JsonElement element : idArray) {
                    try {
                        conflictQuestIds.add(UUID.fromString(element.getAsString()));
                    } catch (IllegalArgumentException e) {
                        ChangShengJue.LOGGER.error("无效的任务ID格式: {}", element.getAsString());
                    }
                }
            }

            boolean isConflictQuest = json.has("isConflictQuest") && json.get("isConflictQuest").getAsBoolean();


            int needCompletionCount = json.has("needCompletionCount") ? json.get("needCompletionCount").getAsInt() : 0;

            boolean needRefresh = json.has("needRefresh") && json.get("needRefresh").getAsBoolean();

            Quest quest = new Quest(questId,npcId, title, description, needRefresh, requirements, rewards,
                    type, targetEntity, isEntityTag, requiredKills, repeatable, questRequirementsDescription, questGenerateTarget, questDay,
                    questTargetCount, questTime, effects, isAcceptQuestEffects, limitQuestIds,isNeedCompletePreQuest,conflictQuestIds,isConflictQuest,needCompletionCount);

            if (json.has("secondTargetEntity")) {
                quest.secondTargetEntity = json.get("secondTargetEntity").getAsString();
            }
            if (json.has("SecondKills")) {
                quest.secondRequiredKills = json.get("SecondKills").getAsInt();
            }
            return quest;

        } catch (Exception e) {
            ChangShengJue.LOGGER.error("解析任务JSON失败", e);
            return null;
        }
    }

    private static int getrequiredKills(JsonObject json) {
        int minKills = 0;
        int maxKills = 0;
        if (json.has("minKills") && json.has("maxKills")) {
            minKills = json.get("minKills").getAsInt();
            maxKills = json.get("maxKills").getAsInt();
            //输出min到max之间的随机数使用math
            return Math.toIntExact(Math.round(Math.random() * (maxKills - minKills) + minKills));
        } else {
            return json.has("requiredKills") ? json.get("requiredKills").getAsInt() : 0;
        }
    }

    // 根据任务内容生成确定性ID
    private static UUID generateDeterministicId(UUID npcId, JsonObject json) {
        String uniqueKey = String.format("%s|%s|%s",
                npcId,
                json.get("questName").getAsString(),
                json.get("type").getAsString()
        );
        return UUID.nameUUIDFromBytes(uniqueKey.getBytes(StandardCharsets.UTF_8));
    }

    public static List<ItemStack> parseItemList(JsonElement element) {
        List<ItemStack> items = new ArrayList<>();
        RandomSource random = RandomSource.create();

        element.getAsJsonArray().forEach(itemJson -> {
            JsonObject itemObj = itemJson.getAsJsonObject();
            String itemId = itemObj.get("item").getAsString();
            int count = parseCount(itemObj.get("count"), random);

            // 检查是否是标签（以#开头）
            if (itemId.startsWith("#")) {
                String tagId = itemId.substring(1); // 去掉#
                ResourceLocation tagLocation = new ResourceLocation(tagId);
                TagKey<Item> tagKey = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), tagLocation);

                // 检查标签系统是否已加载
                if (ForgeRegistries.ITEMS.tags() == null) {
                    System.err.println("标签系统未初始化，无法解析标签: " + tagId);
                    return;
                }

                // 获取所有带有该标签的物品
                ITag<Item> tag = ForgeRegistries.ITEMS.tags().getTag(tagKey);
                if (!tag.isEmpty()) {
                    // 随机选择标签中的一个物品
                    List<Item> tagItems = tag.stream().toList();
                    Item randomItem = tagItems.get(random.nextInt(tagItems.size()));
                    items.add(new ItemStack(randomItem, count));
                } else {
                    System.err.println("标签不存在或为空: " + tagId);
                }
            } else {
                // 普通物品处理
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemId));
                if (item != null) {
                    items.add(new ItemStack(item, count));
                } else {
                    System.err.println("未知物品: " + itemId);
                }
            }
        });

        return items;
    }

    private static int parseCount(JsonElement countElement, RandomSource random) {
        if (countElement.isJsonPrimitive()) {
            // 简单数字格式
            return countElement.getAsInt();
        } else {
            // 复杂格式
            JsonObject countObj = countElement.getAsJsonObject();
            String type = countObj.get("type").getAsString();

            switch (type) {
                case "minecraft:uniform":
                    float min = countObj.get("min").getAsFloat();
                    float max = countObj.get("max").getAsFloat();
                    return Math.round(min + (max - min) * random.nextFloat());

                case "minecraft:binomial":
                    int n = countObj.get("n").getAsInt();
                    float p = countObj.get("p").getAsFloat();
                    int binomialCount = 0;
                    for (int i = 0; i < n; i++) {
                        if (random.nextFloat() < p) binomialCount++;
                    }
                    return binomialCount;

                // 可以添加更多分布类型
                default:
                    System.err.println("未知的count类型: " + type);
                    return 1;
            }
        }
    }

}