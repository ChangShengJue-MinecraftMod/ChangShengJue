package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.capability.quest.PlayerQuestCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import io.netty.handler.codec.DecoderException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.function.Supplier;

public record OpenPlayerQuestScreenPacket(int newPage,Component title) {
    private static final int MAX_TITLE_JSON_LENGTH = 512;

    public static void encode(OpenPlayerQuestScreenPacket packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.newPage);
        buf.writeUtf(Component.Serializer.toJson(packet.title), MAX_TITLE_JSON_LENGTH);
    }

    public static OpenPlayerQuestScreenPacket decode(FriendlyByteBuf buf) {
        int page = buf.readInt();
        Component title = Component.Serializer.fromJson(buf.readUtf(MAX_TITLE_JSON_LENGTH));
        if (title == null) {
            throw new DecoderException("Invalid player quest title component");
        }
        return new OpenPlayerQuestScreenPacket(page, title);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer serverPlayer = ctx.get().getSender();
            if (PlayerQuestPacketGuard.allowOpen(serverPlayer)) {
                serverPlayer.getCapability(PlayerQuestCapabilityProvider.PLAYER_QUEST_CAPABILITY)
                        .ifPresent(cap -> cap.syncToClient(serverPlayer));
                NetworkHooks.openScreen(
                        serverPlayer,
                        new SimpleMenuProvider(
                                PlayerQuestMenu::new, Component.translatable("menu.title.quests")));
            }
//            NetworkHooks.openScreen(serverPlayer,
//                    new SimpleMenuProvider(
//                            (id, inv, player) -> new PlayerQuestMenu(id, inv, QuestManager.getInstance().getPlayerQuests(player.getUUID()), 0),
//                            Component.literal("")
//                    ),
//                    buf -> {
//                        QuestManager.getInstance().encodeQuests(buf, QuestManager.getInstance().getPlayerQuests(serverPlayer.getUUID())); // 必须写入数据
//                        buf.writeInt(0); // 写入初始页码
//                    }
//            );
        });
        ctx.get().setPacketHandled(true);
    }
}
