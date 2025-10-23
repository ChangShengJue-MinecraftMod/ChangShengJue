package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.AbstractGangLeader;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public record OpenGangQuestScreenPacket(UUID playerId) {
    public static void encode(OpenGangQuestScreenPacket packet, FriendlyByteBuf buf) {
        buf.writeUUID(packet.playerId());
    }

    public static OpenGangQuestScreenPacket decode(FriendlyByteBuf buf) {
        return new OpenGangQuestScreenPacket(buf.readUUID());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null && player.containerMenu instanceof GangleaderTradingMenu menu) {
                if (menu.getTrader() instanceof AbstractGangLeader abstractGangLeader) {
                    player.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY).ifPresent(playerQuest -> {
                        List<Quest> quests = abstractGangLeader.getPlayerQuests(playerId);
                        List<Quest> availableQuests = new ArrayList<>();

                        for (Quest quest : quests) {
                            if (quest != null){
                                if (quest.isNeedRefresh()) {
                                    abstractGangLeader.clearPlayerQuests(playerId);
                                    availableQuests.clear();
                                }
                                if (quest.isValid() && !quest.isNeedRefresh() && quest.getAcceptedBy() == null) {
                                    availableQuests.add(quest);
                                }
                            }

                        }

                        List<Quest> newQuests = playerQuest.triggerGangQuest(player, abstractGangLeader, 1.0f);

                        if (newQuests != null) {
                            for (Quest newQuest : newQuests) {
                                if (newQuest != null && newQuest.isValid()) {
                                    boolean alreadyExists = false;

                                    // 检查是否已存在相同任务
                                    for (int i = 0; i < availableQuests.size(); i++) {
                                        Quest existingQuest = availableQuests.get(i);
                                        if (existingQuest.getQuestId().equals(newQuest.getQuestId()) && existingQuest.getAcceptedBy() == null) {
                                            // 存在相同任务，更新现有任务
                                            availableQuests.set(i, newQuest); // 替换为新的任务对象
                                            abstractGangLeader.addQuestForPlayer(playerId, newQuest);
                                            alreadyExists = true;
                                            break;
                                        }
                                    }

                                    // 不存在相同任务，添加新任务
                                    if (!alreadyExists && newQuest.getAcceptedBy() == null) {
                                        abstractGangLeader.addQuestForPlayer(playerId, newQuest);
                                        availableQuests.add(newQuest);
                                    }
                                }
                            }
                        }

//                        if (!availableQuests.isEmpty()) {
                            NetworkHooks.openScreen(
                                    player,
                                    new SimpleMenuProvider(
                                            (windowId, inv, p) -> new GangQuestsMenu(windowId, inv, abstractGangLeader, availableQuests),
                                            Component.translatable("quest." + ChangShengJue.MOD_ID + ".button")
                                    ),
                                    buf -> {
                                        buf.writeInt(availableQuests.size());
                                        // 写入每个任务的NBT数据
                                        for (Quest quest : availableQuests) {
                                            buf.writeNbt(quest.toNbt());
                                        }
                                    }
                            );
//                        }
                        playerQuest.syncToClient(player);
                    });
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}