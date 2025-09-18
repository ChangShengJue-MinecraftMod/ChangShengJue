package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.quest.Quest;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class PlayerQuestHandler {
    public static void handleSubmitPlayerQuest(ServerPlayer player, Quest quest, AbstractContainerMenu menu) {
        QuestManager.getInstance().submitPlayerQuest(player, quest,menu);
    }

    public static void handleAbandonPlayerQuest(ServerPlayer player, Quest quest) {
        QuestManager.getInstance().abandonPlayerQuest(player, quest);
    }
}