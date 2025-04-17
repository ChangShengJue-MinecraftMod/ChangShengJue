package com.shengchanshe.changshengjue.network.packet.gui.quest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.quest.QuestManager;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import net.minecraft.server.level.ServerPlayer;

// 服务端任务处理
public class GangQuestHandler {
    //提交任务
    public static void handleQuestSubmit(ServerPlayer player, AbstractGangLeader abstractGangLeader) {
        QuestManager.getInstance().submitQuest(player,abstractGangLeader);
    }

    //接受任务
    public static void handleQuestAccept(ServerPlayer player,AbstractGangLeader abstractGangLeader) {
        QuestManager.getInstance().acceptQuest(player, abstractGangLeader);
    }

    public static void handleAbandonQuest(ServerPlayer player, AbstractGangLeader abstractGangLeader) {
        QuestManager.getInstance().abandonQuest(player, abstractGangLeader);
    }

    public static void handleRefreshQuest(ServerPlayer player, AbstractGangLeader abstractGangLeader) {
        QuestManager.getInstance().refreshQuest(player, abstractGangLeader);
    }
}