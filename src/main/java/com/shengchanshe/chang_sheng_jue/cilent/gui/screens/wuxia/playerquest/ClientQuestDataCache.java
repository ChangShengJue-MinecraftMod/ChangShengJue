package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest;

import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientQuestDataCache {
    private static final ClientQuestDataCache INSTANCE = new ClientQuestDataCache();
    private final Map<UUID, List<Quest>> playerQuests = new ConcurrentHashMap<>();

    public static ClientQuestDataCache get() {
        return INSTANCE;
    }

    public void updateData(UUID playerId, CompoundTag nbt) {
        List<Quest> quests = new ArrayList<>();
        ListTag questsTag = nbt.getList("Quests", Tag.TAG_COMPOUND);
        for (Tag tag : questsTag) {
            quests.add(new Quest((CompoundTag) tag));
        }
        playerQuests.put(playerId, Collections.unmodifiableList(quests));
    }

    public List<Quest> getPlayerQuests(UUID playerId) {
        return playerQuests.getOrDefault(playerId, Collections.emptyList());
    }

    public void clear() {
        playerQuests.clear();
    }
}
