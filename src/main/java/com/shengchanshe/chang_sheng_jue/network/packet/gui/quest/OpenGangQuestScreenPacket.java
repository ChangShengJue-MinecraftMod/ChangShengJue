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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
                        Optional<Quest> existingQuest = quests.stream()
                                .filter(Objects::nonNull)
                                .filter(Quest::isNeedRefresh)
                                .filter(quest -> quest.getAcceptedBy() == null)
                                .findFirst();

                        if (existingQuest.isPresent()) {
                            abstractGangLeader.removeUnacceptedQuests(playerId);
                            abstractGangLeader.addQuestForPlayer(playerId, playerQuest.triggerGangQuest(player, abstractGangLeader,1.0f));

                            List<Quest> quests1 = abstractGangLeader.getPlayerQuests(playerId);
                            Optional<Quest> existingQuest1 = quests1.stream()
                                    .filter(Objects::nonNull)
                                    .findFirst();
                            if (existingQuest1.isPresent()) {
                                Quest quest = existingQuest1.get();
                                NetworkHooks.openScreen(
                                        player,
                                        new SimpleMenuProvider(
                                                (windowId, inv, p) -> new GangQuestsMenu(windowId, inv, abstractGangLeader, quest),
                                                Component.translatable("quest." + ChangShengJue.MOD_ID + ".button")
                                        ),
                                        buf -> {
                                            buf.writeNbt(quest.toNbt()); // 传入任务NBT数据,在Menu客户端方法中使用
                                        }
                                );
                            }
                        }else {
                            List<Quest> quests1 = playerQuest.getQuests(playerId);
                            Optional<Quest> existingQuest1 = quests1.stream()
                                    .filter(Objects::nonNull)
                                    .filter(quest -> quest.getQuestNpcId().equals(abstractGangLeader.getUUID()))
                                    .findFirst();

                            if (existingQuest1.isPresent()) {
                                Quest quest = existingQuest1.get();
                                NetworkHooks.openScreen(
                                        player,
                                        new SimpleMenuProvider(
                                                (windowId, inv, p) -> new GangQuestsMenu(windowId, inv, abstractGangLeader, quest),
                                                Component.translatable("quest." + ChangShengJue.MOD_ID + ".button")
                                        ),
                                        buf -> {
                                            buf.writeNbt(quest.toNbt());
                                        }
                                );
                            }else {
                                Optional<Quest> existingQuest3 = quests.stream()
                                        .filter(Objects::nonNull)
                                        .filter(quest -> quest.getAcceptedBy() != null)
                                        .filter(quest -> quest.getAcceptedBy().equals(playerId))
                                        .findFirst();
                                if (existingQuest3.isPresent()){
                                    Quest quest = existingQuest3.get();
                                    abstractGangLeader.removeQuest(playerId, quest.getQuestId());
                                }

                                abstractGangLeader.addQuestForPlayer(playerId, playerQuest.triggerGangQuest(player, abstractGangLeader,1.0f));

                                List<Quest> quests2 = abstractGangLeader.getPlayerQuests(playerId);
                                Optional<Quest> existingQuest2 = quests2.stream()
                                        .filter(Objects::nonNull)
                                        .findFirst();
                                if (existingQuest2.isPresent()) {
                                    Quest quest = existingQuest2.get();
                                    NetworkHooks.openScreen(
                                            player,
                                            new SimpleMenuProvider(
                                                    (windowId, inv, p) -> new GangQuestsMenu(windowId, inv, abstractGangLeader, quest),
                                                    Component.translatable("quest." + ChangShengJue.MOD_ID + ".button")
                                            ),
                                            buf -> {
                                                buf.writeNbt(quest.toNbt());
                                            }
                                    );
                                }
                            }
                        }
                        playerQuest.syncToClient(player);
                    });
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
