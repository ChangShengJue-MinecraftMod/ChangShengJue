package com.shengchanshe.chang_sheng_jue.quest;

import com.google.gson.*;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITag;
import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class QuestLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final int MAX_ITEM_COUNT = Byte.MAX_VALUE;
    private static final int MAX_ITEM_ENTRIES = 128;
    private static final int MAX_EFFECT_ENTRIES = 64;
    private static final int MAX_QUEST_ID_ENTRIES = 128;
    private static final int MAX_BINOMIAL_TRIALS = 4096;
    private static final String AUTOMATIC_PATH = "quests/automatic";
    private static final List<String> REGULAR_PATHS = List.of(
            "quests/gather", "quests/kill", "quests/raid", "quests/treat");
    private static final Object CACHE_LOCK = new Object();
    private static volatile QuestDefinitionCache definitionCache = QuestDefinitionCache.empty();
    private static boolean cacheUnavailableReported;
    private static final QuestDefinitionReloadListener RELOAD_LISTENER = new QuestDefinitionReloadListener();

    @SubscribeEvent
    public static void addReloadListener(AddReloadListenerEvent event) {
        event.addListener(RELOAD_LISTENER);
    }

    @SubscribeEvent
    public static void clearCacheOnServerStop(ServerStoppedEvent event) {
        synchronized (CACHE_LOCK) {
            definitionCache = QuestDefinitionCache.empty();
            cacheUnavailableReported = false;
        }
    }

    public static Quest loadSpecificQuest(UUID questId, Set<UUID> completedNonRepeatable,UUID npcId) {
        if (questId == null || npcId == null) {
            return null;
        }
        Set<UUID> completed = completedNonRepeatable == null ? Set.of() : completedNonRepeatable;
        QuestDefinition definition = findAutomaticDefinition(ensureDefinitionCache(), questId, npcId);
        return definition != null
                && (definition.repeatable() || !completed.contains(questId))
                ? parseQuest(definition.json(), npcId) : null;
    }

    public static Quest loadSpecificQuest(UUID questId, UUID npcId) {
        if (questId == null || npcId == null) {
            return null;
        }
        QuestDefinition definition = findAutomaticDefinition(ensureDefinitionCache(), questId, npcId);
        return definition == null ? null : parseQuest(definition.json(), npcId);
    }

    public static List<Quest> loadAllAvailableQuests(UUID npcId, Set<UUID> completedNonRepeatable) {
        if (npcId == null) {
            return Collections.emptyList();
        }
        Set<UUID> completed = completedNonRepeatable == null ? Set.of() : completedNonRepeatable;
        List<Quest> quests = new ArrayList<>();
        for (QuestDefinition definition : ensureDefinitionCache().regularDefinitions()) {
            UUID questId = definition.explicitId() != null
                    ? definition.explicitId() : generateDeterministicId(npcId, definition.json());
            if (definition.repeatable() || !completed.contains(questId)) {
                Quest quest = parseQuest(definition.json(), npcId);
                if (quest != null) {
                    quests.add(quest);
                }
            }
        }
        return quests;
    }

    private static QuestDefinitionCache ensureDefinitionCache() {
        QuestDefinitionCache current = definitionCache;
        if (current.initialized()) {
            return current;
        }
        synchronized (CACHE_LOCK) {
            current = definitionCache;
            if (current.initialized()) {
                return current;
            }
            MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
            if (server == null) {
                if (!cacheUnavailableReported) {
                    ChangShengJue.LOGGER.error("任务定义缓存尚未初始化，且当前没有可用的服务端资源管理器");
                    cacheUnavailableReported = true;
                }
                return current;
            }
            ChangShengJue.LOGGER.warn("任务定义缓存未经过资源重载监听器初始化，执行一次同步回退加载");
            current = buildDefinitionCache(server.getResourceManager());
            definitionCache = current;
            cacheUnavailableReported = false;
            return current;
        }
    }

    private static QuestDefinition findAutomaticDefinition(QuestDefinitionCache cache, UUID questId, UUID npcId) {
        QuestDefinition indexed = cache.automaticById().get(questId);
        if (indexed != null) {
            return indexed;
        }
        for (QuestDefinition definition : cache.automaticWithoutId()) {
            if (generateDeterministicId(npcId, definition.json()).equals(questId)) {
                return definition;
            }
        }
        return null;
    }

    private static QuestDefinitionCache buildDefinitionCache(ResourceManager resourceManager) {
        List<QuestDefinition> automatic = loadDefinitions(resourceManager, List.of(AUTOMATIC_PATH));
        List<QuestDefinition> regular = loadDefinitions(resourceManager, REGULAR_PATHS);
        Map<UUID, QuestDefinition> automaticById = new HashMap<>();
        List<QuestDefinition> automaticWithoutId = new ArrayList<>();
        for (QuestDefinition definition : automatic) {
            if (definition.explicitId() == null) {
                automaticWithoutId.add(definition);
                continue;
            }
            QuestDefinition previous = automaticById.putIfAbsent(definition.explicitId(), definition);
            if (previous != null) {
                ChangShengJue.LOGGER.error("自动任务 UUID 重复: {} ({} 与 {})",
                        definition.explicitId(), previous.source(), definition.source());
            }
        }
        ChangShengJue.LOGGER.info("已缓存 {} 个自动任务定义和 {} 个普通任务定义",
                automatic.size(), regular.size());
        return new QuestDefinitionCache(true, List.copyOf(regular), Map.copyOf(automaticById),
                List.copyOf(automaticWithoutId));
    }

    private static List<QuestDefinition> loadDefinitions(ResourceManager resourceManager, List<String> paths) {
        Map<ResourceLocation, Resource> resources = new HashMap<>();
        for (String path : paths) {
            resources.putAll(resourceManager.listResources(path,
                    location -> location.getNamespace().equals(ChangShengJue.MOD_ID)
                            && location.getPath().endsWith(".json")));
        }
        List<Map.Entry<ResourceLocation, Resource>> orderedResources = new ArrayList<>(resources.entrySet());
        orderedResources.sort(Map.Entry.comparingByKey());
        List<QuestDefinition> definitions = new ArrayList<>(orderedResources.size());
        for (Map.Entry<ResourceLocation, Resource> entry : orderedResources) {
            try (InputStream stream = entry.getValue().open();
                 InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                JsonObject json = GSON.fromJson(reader, JsonObject.class);
                if (json == null) {
                    ChangShengJue.LOGGER.error("任务定义为空: {}", entry.getKey());
                    continue;
                }
                UUID explicitId = null;
                if (json.has("questId")) {
                    explicitId = UUID.fromString(json.get("questId").getAsString());
                }
                boolean repeatable = json.has("repeatable") && json.get("repeatable").getAsBoolean();
                definitions.add(new QuestDefinition(entry.getKey(), json.deepCopy(), explicitId, repeatable));
            } catch (Exception exception) {
                ChangShengJue.LOGGER.error("加载任务定义失败: {}", entry.getKey(), exception);
            }
        }
        return List.copyOf(definitions);
    }

    private record QuestDefinition(ResourceLocation source, JsonObject json, UUID explicitId, boolean repeatable) {
    }

    private record QuestDefinitionCache(boolean initialized, List<QuestDefinition> regularDefinitions,
                                        Map<UUID, QuestDefinition> automaticById,
                                        List<QuestDefinition> automaticWithoutId) {
        private static QuestDefinitionCache empty() {
            return new QuestDefinitionCache(false, List.of(), Map.of(), List.of());
        }
    }

    private static final class QuestDefinitionReloadListener
            extends SimplePreparableReloadListener<QuestDefinitionCache> {
        @Override
        protected QuestDefinitionCache prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
            return buildDefinitionCache(resourceManager);
        }

        @Override
        protected void apply(QuestDefinitionCache prepared, ResourceManager resourceManager, ProfilerFiller profiler) {
            synchronized (CACHE_LOCK) {
                definitionCache = prepared;
                cacheUnavailableReported = false;
            }
        }
    }


    private static Quest parseQuest(JsonObject json,UUID npcId) {
        try {
            // 读取或生成固定ID
            UUID questId = json.has("questId")
                    ? UUID.fromString(json.get("questId").getAsString()) // 从配置读取
                    : generateDeterministicId(npcId, json); // 根据内容生成

            String title = json.has("questName") ? json.get("questName").getAsString() : "";
            String description = json.has("questDescription") ? json.get("questDescription").getAsString() : "";
//            String title = Component.translatable(titleKey).getString();
//            String description = Component.translatable(descriptionKey).getString();

            // 获取任务类型，默认为 GATHER
            String typeStr = json.has("questType") ? json.get("questType").getAsString() : "GATHER";
            Quest.QuestType type;
            try {
                type = Quest.QuestType.valueOf(typeStr.toUpperCase(Locale.ROOT));
            } catch (IllegalArgumentException exception) {
                ChangShengJue.LOGGER.warn("未知的任务类型 {}，按 GATHER 读取", typeStr);
                type = Quest.QuestType.GATHER;
            }

            boolean repeatable = json.has("repeatable") &&  json.get("repeatable").getAsBoolean();

            String questRequirementsDescription = json.has("questRequirementsDescription") ? json.get("questRequirementsDescription").getAsString() : "";
//            String questRequirementsDescription = json.has("questRequirementsDescription") ?
//                    Component.translatable(json.get("questRequirementsDescription").getAsString()).getString() : "";

            List<QuestEffectEntry> effects = new ArrayList<>();
            if (json.has("effects")) {
                JsonArray effectsJson = json.getAsJsonArray("effects");
                for (JsonElement element : effectsJson) {
                    if (effects.size() >= MAX_EFFECT_ENTRIES) {
                        break;
                    }
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

            int questDay = json.has("questDay") ? json.get("questDay").getAsInt()
                    : json.has("qusetDay") ? json.get("qusetDay").getAsInt() : 0;

            String targetEntity = json.has("targetEntity") ? json.get("targetEntity").getAsString() : "";
            boolean isEntityTag = targetEntity.startsWith("#");

            int requiredKills = getRequiredKills(json);

            boolean questGenerateTarget = json.has("questGenerateTarget") && json.get("questGenerateTarget").getAsBoolean();

            int questTargetCount = json.has("questTargetCount") ? json.get("questTargetCount").getAsInt() : 0;

            int questTime = json.has("questTime") ? json.get("questTime").getAsInt() : 0;

            boolean isAcceptQuestEffects = json.has("isAcceptQuestEffects") && json.get("isAcceptQuestEffects").getAsBoolean();

            List<UUID> limitQuestIds = new ArrayList<>();
            if (json.has("limitQuestIds")) {
                JsonArray idArray = json.getAsJsonArray("limitQuestIds");
                for (JsonElement element : idArray) {
                    if (limitQuestIds.size() >= MAX_QUEST_ID_ENTRIES) {
                        break;
                    }
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
                    if (conflictQuestIds.size() >= MAX_QUEST_ID_ENTRIES) {
                        break;
                    }
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

            int weight = json.has("weight") ? json.get("weight").getAsInt() : 1;
            String secondTargetEntity = json.has("secondTargetEntity") ? json.get("secondTargetEntity").getAsString() : "";
            boolean isSecondEntityTag = secondTargetEntity.startsWith("#");

            int secondRequiredKills = getSecondRequiredKills(json);

            return new Quest(questId,npcId, title, description, needRefresh, requirements, rewards,
                    type, targetEntity, isEntityTag, requiredKills,secondTargetEntity, secondRequiredKills, isSecondEntityTag, repeatable, questRequirementsDescription, questGenerateTarget, questDay,
                    questTargetCount, questTime, effects, isAcceptQuestEffects, limitQuestIds,isNeedCompletePreQuest,conflictQuestIds,
                    isConflictQuest,needCompletionCount, weight);
        } catch (Exception e) {
            ChangShengJue.LOGGER.error("解析任务JSON失败", e);
            return null;
        }
    }

    private static int getSecondRequiredKills(JsonObject json) {
        if (json.has("minSecondKills") && json.has("maxSecondKills")) {
            int minKills = json.get("minSecondKills").getAsInt();
            int maxKills = json.get("maxSecondKills").getAsInt();
            return Math.toIntExact(Math.round(Math.random() * (maxKills - minKills) + minKills));
        } else {
            return json.has("secondRequiredKills") ? json.get("secondRequiredKills").getAsInt() : 0;
        }
    }

    private static int getRequiredKills(JsonObject json) {
        if (json.has("minKills") && json.has("maxKills")) {
            int minKills = json.get("minKills").getAsInt();
            int maxKills = json.get("maxKills").getAsInt();
            return Math.toIntExact(Math.round(Math.random() * (maxKills - minKills) + minKills));
        } else {
            return json.has("requiredKills") ? json.get("requiredKills").getAsInt() : 0;
        }
    }

    private static UUID generateDeterministicId(UUID npcId, JsonObject json) {
        String uniqueKey = String.format("%s|%s|%s",
                npcId,
                json.has("questName") ? json.get("questName").getAsString() : "",
                json.has("questType") ? json.get("questType").getAsString()
                        : json.has("type") ? json.get("type").getAsString() : "GATHER"
        );
        return UUID.nameUUIDFromBytes(uniqueKey.getBytes(StandardCharsets.UTF_8));
    }

    public static List<ItemStack> parseItemList(JsonElement element) {
        List<ItemStack> items = new ArrayList<>();
        RandomSource random = RandomSource.create();

        for (JsonElement itemJson : element.getAsJsonArray()) {
            if (items.size() >= MAX_ITEM_ENTRIES) {
                break;
            }
            if (!itemJson.isJsonObject()) {
                ChangShengJue.LOGGER.warn("忽略非对象格式的任务物品条目");
                continue;
            }
            JsonObject itemObj = itemJson.getAsJsonObject();
            if (!itemObj.has("item") || !itemObj.has("count")) {
                ChangShengJue.LOGGER.warn("忽略缺少 item 或 count 的任务物品条目");
                continue;
            }
            String itemId = itemObj.get("item").getAsString();
            int count = Math.max(0, Math.min(parseCount(itemObj.get("count"), random), MAX_ITEM_COUNT));
            if (count == 0) {
                continue;
            }

            // 检查是否是标签（以#开头）
            if (itemId.startsWith("#")) {
                String tagId = itemId.substring(1); // 去掉#
                ResourceLocation tagLocation = ResourceLocation.tryParse(tagId);
                if (tagLocation == null) {
                    ChangShengJue.LOGGER.warn("忽略无效的任务物品标签: {}", itemId);
                    continue;
                }
                TagKey<Item> tagKey = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), tagLocation);

                // 检查标签系统是否已加载
                if (ForgeRegistries.ITEMS.tags() == null) {
                    ChangShengJue.LOGGER.warn("标签系统未初始化，无法解析标签: {}", tagId);
                    continue;
                }

                // 获取所有带有该标签的物品
                ITag<Item> tag = ForgeRegistries.ITEMS.tags().getTag(tagKey);
                if (!tag.isEmpty()) {
                    // 随机选择标签中的一个物品
                    List<Item> tagItems = tag.stream().toList();
                    Item randomItem = tagItems.get(random.nextInt(tagItems.size()));
                    items.add(new ItemStack(randomItem, count));
                } else {
                    ChangShengJue.LOGGER.warn("标签不存在或为空: {}", tagId);
                }
            } else {
                // 普通物品处理
                ResourceLocation itemLocation = ResourceLocation.tryParse(itemId);
                if (itemLocation == null) {
                    ChangShengJue.LOGGER.warn("忽略无效的任务物品标识: {}", itemId);
                    continue;
                }
                Item item = ForgeRegistries.ITEMS.getValue(itemLocation);
                if (item != null) {
                    items.add(new ItemStack(item, count));
                } else {
                    ChangShengJue.LOGGER.warn("未知物品: {}", itemId);
                }
            }
        }

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
                    int n = Math.max(0, Math.min(countObj.get("n").getAsInt(), MAX_BINOMIAL_TRIALS));
                    float p = Math.max(0.0F, Math.min(countObj.get("p").getAsFloat(), 1.0F));
                    int binomialCount = 0;
                    for (int i = 0; i < n; i++) {
                        if (random.nextFloat() < p) binomialCount++;
                    }
                    return binomialCount;

                // 可以添加更多分布类型
                default:
                    ChangShengJue.LOGGER.warn("未知的任务 count 类型: {}", type);
                    return 1;
            }
        }
    }

}
