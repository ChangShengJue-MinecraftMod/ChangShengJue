package com.shengchanshe.chang_sheng_jue.entity.placement;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;

public class BanditEntitySpawns {
    // 可配置参数
    private static final int SPAWN_RADIUS = 48;

    public static void registerSpawnRules(SpawnPlacementRegisterEvent event) {
        event.register(ChangShengJueEntity.VILLAIN.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (type, level, spawnType, pos, random) -> {
                    // 仅在村庄附近黑暗处生成
                    if (!(level instanceof ServerLevel serverLevel)) return false;
                    return isNearVillage(serverLevel, pos) && Monster.checkMonsterSpawnRules(type, level, spawnType, pos, random);},
                SpawnPlacementRegisterEvent.Operation.AND);
    }

    private static boolean isNearVillage(ServerLevel level, BlockPos pos) {
        return level.getPoiManager().getCountInRange(
                poiType -> poiType.is(PoiTypes.HOME),
                pos,
                SPAWN_RADIUS,
                PoiManager.Occupancy.ANY
        ) > 0;
    }
}