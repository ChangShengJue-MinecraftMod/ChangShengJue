package com.shengchanshe.changshengjue.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.player.Player;

import java.util.Optional;

public class VillageUtils {
    public static boolean isPlayerInVillage(Player player) {
        if (player.level() instanceof ServerLevel serverLevel) {
            // 获取玩家所在区块的村庄管理器
            PoiManager poiManager = serverLevel.getPoiManager();

            // 检查玩家周围是否有村庄
            Optional<BlockPos> nearestVillageCenter = poiManager.findClosest(
                    holder -> holder.is(PoiTypeTags.VILLAGE),
                    player.blockPosition(),
                    64, // 搜索半径
                    PoiManager.Occupancy.ANY
            );
            // 检查有效床铺数量
            long beds = poiManager.getCountInRange(holder -> holder.is(PoiTypes.HOME),
                    player.blockPosition(),
                    128, // 村庄半径
                    PoiManager.Occupancy.HAS_SPACE
            );

            return nearestVillageCenter.isPresent() && beds > 2;
        }
        return false;
    }
}
