package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.server.level.ServerPlayer;

import java.util.UUID;

public class GangQuestHandler {
    public static void handleQuestAccept(ServerPlayer player, AbstractGangLeader abstractGangLeader, UUID questId) {
        QuestManager.getInstance().acceptQuest(player, abstractGangLeader, questId);
    }
}