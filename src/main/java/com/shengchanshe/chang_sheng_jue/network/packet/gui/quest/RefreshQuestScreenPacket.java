package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsScreen;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public record RefreshQuestScreenPacket(List<Quest> availableQuests) {
    public static void encode(RefreshQuestScreenPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.availableQuests().size());
        for (Quest quest : packet.availableQuests()) {
            buf.writeNbt(quest.toNbt());
        }
    }

    public static RefreshQuestScreenPacket decode(FriendlyByteBuf buf) {
        List<Quest> quests = new ArrayList<>();
        int count = buf.readInt();
        for (int i = 0; i < count; i++) {
            Quest quest = new Quest(Objects.requireNonNull(buf.readNbt()));
            quests.add(quest);
        }
        return new RefreshQuestScreenPacket(quests);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            // 客户端收到后更新任务数据
            if (Minecraft.getInstance().screen instanceof GangQuestsScreen screen) {
                List<Quest> newQuests = new ArrayList<>();
                for (Quest questData : this.availableQuests) {
                    Quest newData = new Quest(questData.toNbt());
//                    newQuests.add(newData);
//                    for (Quest quest : newQuests) {
                    newData.updateFrom(questData);
                    if (newData.getAcceptedBy() == null) {
                        newQuests.add(newData);
                    }
//                    }
                    // 刷新UI
                    /*screen.updateQuestData(this.availableQuests());*/
                }
                screen.forceRefresh(newQuests);
                ctx.get().setPacketHandled(true);
            }
        });
    }
}