package com.shengchanshe.changshengjue.network.packet.gui.playerquest;

import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.changshengjue.quest.QuestManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public record OpenPlayerQuestScreenPacket(int newPage,Component title) {
    public static void encode(OpenPlayerQuestScreenPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.newPage);
        buf.writeComponent(packet.title);
    }

    public static OpenPlayerQuestScreenPacket decode(FriendlyByteBuf buf) {
        return new OpenPlayerQuestScreenPacket(buf.readInt(), buf.readComponent());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer serverPlayer = ctx.get().getSender();
            NetworkHooks.openScreen(serverPlayer,
                    new SimpleMenuProvider(
                            (id, inv, player) -> new PlayerQuestMenu(id, inv, QuestManager.getInstance().getPlayerQuests(player.getUUID()), 0),
                            Component.literal("")
                    ),
                    buf -> {
                        QuestManager.getInstance().encodeQuests(buf, QuestManager.getInstance().getPlayerQuests(serverPlayer.getUUID())); // 必须写入数据
                        buf.writeInt(0); // 写入初始页码
                    }
            );
        });
        ctx.get().setPacketHandled(true);
    }
}
