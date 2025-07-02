package com.shengchanshe.chang_sheng_jue.spirit;

import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.cultivation.SpiritDensityLevelPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ChunkPos;

public class SpiritManager {
    // 获取灵气值
    public static float getSpiritValue(ServerLevel level, BlockPos pos) {
        return SpiritWorldData.get(level).getSpiritValue(level, new ChunkPos(pos));
    }

    // 修改灵气值（返回实际修改量）
    public static void modifySpirit(ServerLevel level, BlockPos pos, float delta) {
        ChunkPos chunkPos = new ChunkPos(pos);
        SpiritWorldData data = SpiritWorldData.get(level);
        float current = data.getSpiritValue(level, chunkPos);
        float newValue = Math.max(0, current + delta);
        data.setSpiritValue(chunkPos, newValue);
    }

    // 更新玩家灵气显示
    public static void updateSpiritDisplay(ServerPlayer player, ChunkPos newChunk) {
        SpiritWorldData data = SpiritWorldData.get(player.serverLevel());
        float spiritValue = data.getSpiritValue(player.serverLevel(), newChunk);
        SpiritDensityLevel level = SpiritDensityLevel.getForValue(spiritValue);
        ChangShengJueMessages.sendToPlayer(new SpiritDensityLevelPacket(level.getTier(), spiritValue), player);
    }

    // 自然恢复所有区块
    public static void recoverAll(ServerLevel level) {
        SpiritWorldData data = SpiritWorldData.get(level);
        data.chunkData.replaceAll((pos, value) ->
                Math.min(value + ChangShengJueConfig.SPIRIT_RECOVERY_AMOUNT.get(), SpiritDensityLevel.RICH.getMax())
        );

        data.setDirty();
    }
}

