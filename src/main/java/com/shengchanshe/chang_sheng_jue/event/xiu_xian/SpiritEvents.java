package com.shengchanshe.chang_sheng_jue.event.xiu_xian;

import com.shengchanshe.chang_sheng_jue.ChangShengJueConfig;
import com.shengchanshe.chang_sheng_jue.spirit.SpiritManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.event.TickEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpiritEvents {
    // 每10秒恢复一次灵气
    private static int timer = 0;

    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (++timer >= ChangShengJueConfig.SPIRIT_RECOVERY_INTERVAL.get()) {
                timer = 0;
                event.getServer().getAllLevels().forEach(SpiritManager::recoverAll);
            }
        }
    }

    private static final Map<UUID, ChunkPos> lastChunkMap = new HashMap<>();

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player) || (event.player.isCreative()) || (event.player.isSpectator())) return;

        ChunkPos currentChunk = new ChunkPos(player.blockPosition());
        ChunkPos lastChunk = lastChunkMap.get(player.getUUID());

        // 检测区块变化
        if (!currentChunk.equals(lastChunk)) {
            // 更新灵气显示
            SpiritManager.updateSpiritDisplay(player, currentChunk);
            lastChunkMap.put(player.getUUID(), currentChunk);
        }
    }

//    public static void onChunkLoad(ChunkEvent.Load event) {
//        if (event.getLevel() instanceof ServerLevel level) {
//            ChunkPos pos = event.getChunk().getPos();
//            SpiritWorldData.get(level).getSpiritValue(pos); // 触发初始化
//        }
//    }

}
