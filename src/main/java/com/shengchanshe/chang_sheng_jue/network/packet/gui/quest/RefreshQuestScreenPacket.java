package com.shengchanshe.chang_sheng_jue.network.packet.gui.quest;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsScreen;
import com.shengchanshe.chang_sheng_jue.quest.Quest;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record RefreshQuestScreenPacket(CompoundTag questData) {
    // 实现encode/decode方法
    public static void encode(RefreshQuestScreenPacket packet, FriendlyByteBuf buf) {
        buf.writeNbt(packet.questData);
    }

    public static RefreshQuestScreenPacket decode(FriendlyByteBuf buf) {
        return new RefreshQuestScreenPacket(buf.readNbt());
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            if (Minecraft.getInstance().screen instanceof GangQuestsScreen screen) {
                // 获取当前任务实例
                Quest currentQuest = screen.getMenu().getGangQuests();
                // 从网络包反序列化新数据
                Quest newData = new Quest(this.questData);
                // 更新当前任务（而不是替换整个实例）
                currentQuest.updateFrom(newData);
                // 刷新UI
                screen.refreshUI();
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
