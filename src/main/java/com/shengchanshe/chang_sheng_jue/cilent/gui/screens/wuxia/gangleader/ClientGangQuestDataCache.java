package com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ClientGangQuestDataCache {
    private static final ClientGangQuestDataCache INSTANCE = new ClientGangQuestDataCache();
    private final Map<UUID, List<Quest>> playerQuests = new ConcurrentHashMap<>();

        public static ClientGangQuestDataCache get() {
        return INSTANCE;
    }

    public void updateData(UUID npcId, CompoundTag nbt) {
        List<Quest> quests = new ArrayList<>();
        ListTag questsTag = nbt.getList("Quests", Tag.TAG_COMPOUND);
        for (Tag tag : questsTag) {
            quests.add(new Quest((CompoundTag) tag));
        }
        playerQuests.put(npcId, Collections.unmodifiableList(quests));
    }

    public List<Quest> getPlayerQuests(UUID npcId) {
        return playerQuests.getOrDefault(npcId, Collections.emptyList());
    }

    public void clear() {
        playerQuests.clear();
    }
}
