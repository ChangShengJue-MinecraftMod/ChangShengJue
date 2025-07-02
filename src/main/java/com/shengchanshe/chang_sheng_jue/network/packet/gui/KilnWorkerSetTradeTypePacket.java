package com.shengchanshe.chang_sheng_jue.network.packet.gui;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerScreen;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorker;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class KilnWorkerSetTradeTypePacket {
    private final KilnWorkerScreen.TradeType tradeType;

    public KilnWorkerSetTradeTypePacket(KilnWorkerScreen.TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public static void encode(KilnWorkerSetTradeTypePacket packet, FriendlyByteBuf buffer) {
        buffer.writeEnum(packet.tradeType);
    }

    public static KilnWorkerSetTradeTypePacket decode(FriendlyByteBuf buffer) {
        return new KilnWorkerSetTradeTypePacket(buffer.readEnum(KilnWorkerScreen.TradeType.class));
    }

    public static void handle(KilnWorkerSetTradeTypePacket packet, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null && player.containerMenu instanceof KilnWorkerMenu menu) {
                if (menu.getTrader() instanceof KilnWorker worker) {
                    // 保存当前补货状态
                    long lastRestockTime = worker.getLastRestockGameTime();
                    int restocksToday = worker.getNumberOfRestocksToday();
                    long lastRestockCheckDayTime = worker.getLastRestockCheckDayTime();

                    // 更新交易类型
                    worker.setCurrentTradeType(packet.tradeType);

                    // 恢复补货状态
                    worker.setLastRestockGameTime(lastRestockTime);
                    worker.setNumberOfRestocksToday(restocksToday);
                    worker.setLastRestockCheckDayTime(lastRestockCheckDayTime);

                    // 发送更新
                    player.sendMerchantOffers(
                            menu.containerId,
                            worker.getOffers(),
                            1,
                            worker.getVillagerXp(),
                            worker.showProgressBar(),
                            worker.canRestock()
                    );
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
