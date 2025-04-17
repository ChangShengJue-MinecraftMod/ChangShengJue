package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;
import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class QuestLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static Quest loadQuest(UUID npcId, Set<UUID> completedNonRepeatable) {
        Map<ResourceLocation, Resource> allResources = getResourceLocationResourceMap();
        List<ResourceLocation> candidates = new ArrayList<>();

        // 第一步：筛选候选文件
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

        // 第二步：随机选择有效候选
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

    private static @NotNull Map<ResourceLocation, Resource> getResourceLocationResourceMap() {
        ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        String namespace = ChangShengJue.MOD_ID;

        // 定义任务类型的路径
        String[] questPaths = {"quests/gather", "quests/kill", "quests/raid", "quests/treat"};
        // 收集所有任务文件
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

            String titleKey = json.get("questName").getAsString();
            String descriptionKey = json.get("questDescription").getAsString();
            String title = I18n.get(titleKey);
            String description = I18n.get(descriptionKey);

            // 获取任务类型，默认为 GATHER
            String typeStr = json.has("type") ? json.get("type").getAsString() : "GATHER";
            Quest.QuestType type = Quest.QuestType.valueOf(typeStr.toUpperCase());

            boolean repeatable = json.get("repeatable").getAsBoolean();

            String questRequirementsDescription = json.has("questRequirementsDescription") ?
                    I18n.get(json.get("questRequirementsDescription").getAsString()) : " ";

            boolean givesEffect = json.get("givesEffect").getAsBoolean();

            if (type == Quest.QuestType.GATHER) {
                // 收集物品任务
                List<ItemStack> requirements = json.has("questRequirements") ?
                        parseItemList(json.getAsJsonArray("questRequirements")) : Collections.emptyList();
                List<ItemStack> rewards = json.has("questRewards") ?
                        parseItemList(json.getAsJsonArray("questRewards")) : Collections.emptyList();

                return new Quest(questId,npcId, title, description, requirements, rewards,type,repeatable,questRequirementsDescription);
            } else if (type == Quest.QuestType.KILL) {
                String targetEntity = json.get("targetEntity").getAsString();
                boolean isEntityTag = targetEntity.startsWith("#");
                int requiredKills = json.get("requiredKills").getAsInt();

                List<ItemStack> requirements = json.has("questRequirements") ?
                        parseItemList(json.getAsJsonArray("questRequirements")) : Collections.emptyList();
                List<ItemStack> rewards = json.has("questRewards") ?
                        parseItemList(json.getAsJsonArray("questRewards")) : Collections.emptyList();

                boolean questGenerateTarget = json.get("questGenerateTarget").getAsBoolean();

                return new Quest(questId,npcId, title, description, requirements, rewards,
                        type, targetEntity, isEntityTag, requiredKills,repeatable,questRequirementsDescription,questGenerateTarget);
            }else if (type == Quest.QuestType.RAID || type == Quest.QuestType.TREAT){
                List<ItemStack> requirements = json.has("questRequirements") ?
                        parseItemList(json.getAsJsonArray("questRequirements")) : Collections.emptyList();
                List<ItemStack> rewards = json.has("questRewards") ?
                        parseItemList(json.getAsJsonArray("questRewards")) : Collections.emptyList();

                return new Quest(questId,npcId, title, description, requirements, rewards,type,repeatable,questRequirementsDescription,givesEffect);
            }

            throw new IllegalArgumentException("未知的任务类型: " + type);

        } catch (Exception e) {
            System.err.println("解析任务JSON失败: " + e.getMessage());
            return null;
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
                    return (int) Math.round(min + (max - min) * random.nextFloat());

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