package com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader;

import com.shengchanshe.changshengjue.quest.Quest;
import net.minecraft.client.Minecraft;

import java.util.*;
import java.util.stream.Collectors;

public class ClientQuestDataCache {
    private static List<Quest> clientQuests = new ArrayList<>();
    private static Set<UUID> completedQuests = new HashSet<>();
    private static Map<UUID, Integer> completionCounts = new HashMap<>();

    public static void update(List<Quest> quests, Set<UUID> completed, Map<UUID, Integer> counts) {
        if (Minecraft.getInstance().isLocalServer()) {
            return; // 主机客户端跳过缓存，直接使用服务端数据
        }
        clientQuests = quests;
        completedQuests = completed;
        completionCounts = counts;
    }

    // 客户端专用获取方法
    public static List<Quest> getClientQuests(UUID playerId) {
        return clientQuests.stream()
                .filter(q -> q.getAcceptedBy().equals(playerId))
                .collect(Collectors.toList());
    }

    // 在ClientQuestDataCache中
    public static void clearCache() {
        clientQuests.clear();
        completedQuests.clear();
        completionCounts.clear();
    }

    /** 检查任务是否完成 */
    public static boolean isQuestCompleted(UUID questId) {
        return completedQuests.contains(questId);
    }
}
