package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.network.ClientPacketBridge;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import io.netty.handler.codec.DecoderException;
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
        if (count < 0 || count > buf.readableBytes()) {
            throw new DecoderException("Invalid available quest count: " + count);
        }
        for (int i = 0; i < count; i++) {
            Quest quest = new Quest(Objects.requireNonNull(buf.readNbt()));
            quests.add(quest);
        }
        return new RefreshQuestScreenPacket(quests);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> ClientPacketBridge.refreshQuestScreen(this.availableQuests));
        ctx.get().setPacketHandled(true);
    }
}
