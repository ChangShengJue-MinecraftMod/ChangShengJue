package com.shengchanshe.changshengjue.world.gen;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;

import java.util.Arrays;
import java.util.List;

public class ModEntityGeneration {
//    public static void onEntitySpawn(final BiomeLoadingEvent event) {
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.BUTTERFLY_ENTITY.get(), 100, 1, 2, Biomes.FLOWER_FOREST);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.DRAGONFLY_ENTITY.get(), 200, 1, 1, Biomes.RIVER);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.MONKEY_ENTITY.get(), 40, 3, 6, Biomes.FOREST);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.CICADA_ENTITY.get(), 200, 1, 1, Biomes.FOREST);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.CRANE_ENTITY.get(), 100, 3, 6, Biomes.PLAINS,Biomes.SWAMP);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(), 100, 1, 2, Biomes.PLAINS);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(), 100, 1, 2, Biomes.PLAINS);
//
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.STAG_ENTITY.get(), 100, 1, 2, Biomes.PLAINS,Biomes.FOREST);
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.HIND_ENTITY.get(), 100, 2, 4, Biomes.PLAINS,Biomes.FOREST);
//
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.TIGER_ENTITY.get(), 100, 1, 2, Biomes.JUNGLE,Biomes.FOREST);
//
//        addEntityToSpecificBiomes(event, ChangShengJueEntity.CROC_ENTITY.get(), 100, 1, 1, Biomes.RIVER,Biomes.SWAMP);
//    }
//    //那种地形不生成entity
//    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
//        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location).map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));
//        if(!isBiomeSelected) {
//            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
//        }
//    }
//    //那种地形生成entity
//    @SafeVarargs
//    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
//        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location).map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));
//        if(isBiomeSelected) {
//            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
//        }
//    }
//
//    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
//        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
//            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
//        }
//    }
//
//    //地狱
//    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
//        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
//            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
//            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
//        }
//    }
//    //末地
//    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
//        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
//            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
//            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
//        }
//    }
//
//    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type, int weight, int minCount, int maxCount) {
//        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
//        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
//    }
}