package com.shengchanshe.chang_sheng_jue.network.packet.checkin;

import com.shengchanshe.chang_sheng_jue.checkin.CheckInDataManager;
import com.shengchanshe.chang_sheng_jue.checkin.CheckInRewardConfig;
import com.shengchanshe.chang_sheng_jue.checkin.PlayerCheckInData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * 签到请求数据包
 */
public record CheckInPacket() {

    public static void encode(CheckInPacket packet, FriendlyByteBuf buf) {
        // 无需额外数据
    }

    public static CheckInPacket decode(FriendlyByteBuf buf) {
        return new CheckInPacket();
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null && player.level() instanceof ServerLevel serverLevel) {
                CheckInDataManager manager = CheckInDataManager.get(serverLevel);
                PlayerCheckInData data = manager.getPlayerData(player.getUUID());

                if (!data.hasCheckedInToday()) {
                    int dayIndex = data.getCurrentRewardIndex();
                    int poolSize = CheckInRewardConfig.getRewardListSize(dayIndex);
                    int randomIndex = data.getTodayRandomRewardIndex(poolSize, true);

                    ItemStack baseReward = CheckInRewardConfig.getTodayRandomReward(dayIndex, randomIndex);
                    double multiplier = data.getRewardMultiplier();

                    ItemStack reward = baseReward.copy();
                    int newCount = (int) Math.ceil(reward.getCount() * multiplier);
                    reward.setCount(newCount);

                    if (data.checkIn(reward)) {
                        if (!player.addItem(reward)) {
                            player.drop(reward, false);
                        }

                        manager.markDirty();
                        SyncCheckInDataPacket.sendToClient(player, data);
                    }
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
