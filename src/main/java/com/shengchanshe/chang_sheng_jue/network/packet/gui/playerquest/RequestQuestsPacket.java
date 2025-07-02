package com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest;

import com.shengchanshe.chang_sheng_jue.quest.QuestManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class RequestQuestsPacket {
    public RequestQuestsPacket() {} // 无参构造

    public RequestQuestsPacket(FriendlyByteBuf buf) {} // 空解码

    public void encode(FriendlyByteBuf buf) {} // 空编码

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ServerPlayer player = ctx.get().getSender();
        if (player != null) {
            // 服务端响应数据
            QuestManager.getInstance().syncQuestsToPlayer(player);
        }
    }
}
