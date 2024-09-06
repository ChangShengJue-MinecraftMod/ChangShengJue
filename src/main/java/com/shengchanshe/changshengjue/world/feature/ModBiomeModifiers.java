package com.shengchanshe.changshengjue.world.feature;

import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSources;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.JsonCodecProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class ModBiomeModifiers {
    //矿石生成
    public static final ResourceKey<BiomeModifier> ADD_AG_ORE = registerKey("add_ag_ore");
    public static final ResourceKey<BiomeModifier> ADD_AG_ORE_MIDDLE = registerKey("add_ag_ore_middle");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_AG_ORE = registerKey("add_deepslate_ag_ore");

    //树生成
    public static final ResourceKey<BiomeModifier> ADD_TREE_MANGO = registerKey("add_tree_mango");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BANANA = registerKey("add_tree_banana");
    public static final ResourceKey<BiomeModifier> ADD_TREE_LICHEE = registerKey("add_tree_lichee");
    public static final ResourceKey<BiomeModifier> ADD_TREE_DURIAN = registerKey("add_tree_durian");
    public static final ResourceKey<BiomeModifier> ADD_TREE_GUIHUA = registerKey("add_tree_guihua");
    public static final ResourceKey<BiomeModifier> ADD_TREE_MEIHUA = registerKey("add_tree_meihua");

    //花花草草
    public static final ResourceKey<BiomeModifier> ADD_MUGWORT = registerKey("add_mugwort");
    public static final ResourceKey<BiomeModifier> ADD_CUCKOO = registerKey("add_cuckoo");
    public static final ResourceKey<BiomeModifier> ADD_PORTULACA_OLERACEA = registerKey("add_portulaca_oleracea");
    public static final ResourceKey<BiomeModifier> ADD_JASMINE = registerKey("add_jasmine");
    public static final ResourceKey<BiomeModifier> ADD_KOCHIA_SCOPARIA = registerKey("add_kochia_scoparia");
    public static final ResourceKey<BiomeModifier> ADD_SHUI_XIAN = registerKey("add_shui_xian");
    public static final ResourceKey<BiomeModifier> ADD_TAN_HUA = registerKey("add_tan_hua");
    public static final ResourceKey<BiomeModifier> ADD_CAPSULE = registerKey("add_capsule");
    //哈密瓜
    public static final ResourceKey<BiomeModifier> ADD_CANTALOUPE_BLOCK = registerKey("add_cantaloupe_block");
    //生物
    public static final ResourceKey<BiomeModifier> ADD_BUTTERFLY_ENTITY = registerKey("add_butterfly_entity");
    public static final ResourceKey<BiomeModifier> ADD_MONKEY_ENTITY = registerKey("add_monkey_entity");
    public static final ResourceKey<BiomeModifier> ADD_DRAGONFLY_ENTITY = registerKey("add_dragonfly_entity");
    public static final ResourceKey<BiomeModifier> ADD_CICADA_ENTITY = registerKey("add_cicada_entity");
    public static final ResourceKey<BiomeModifier> ADD_CRANE_ENTITY = registerKey("add_crane_entity");
    public static final ResourceKey<BiomeModifier> ADD_MALE_PEACOCK_ENTITY = registerKey("add_male_peacock_entity");
    public static final ResourceKey<BiomeModifier> ADD_FEMALE_PEACOCK_ENTITY = registerKey("add_female_peacock_entity");
    public static final ResourceKey<BiomeModifier> ADD_STAG_ENTITY = registerKey("add_stag_entity");
    public static final ResourceKey<BiomeModifier> ADD_HIND_ENTITY = registerKey("add_hind_entity");
    public static final ResourceKey<BiomeModifier> ADD_TIGER_ENTITY = registerKey("add_tiger_entity");
    public static final ResourceKey<BiomeModifier> ADD_CROC_ENTITY = registerKey("add_croc_entity");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // 用于获取放置特性和生物群系的注册表引用
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        //矿石
        context.register(ADD_AG_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(//创建生物群系修改器,向指定生物群系添加放置特征
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),//在主世界的所有生物群系中修改
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORE_AG_UPPER)),//获取放置特性
                GenerationStep.Decoration.UNDERGROUND_ORES));//在生成矿石时处理这些特性
        context.register(ADD_AG_ORE_MIDDLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORE_AG_MIDDLE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_DEEPSLATE_AG_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ORE_AG_SMALL)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TREE_MANGO,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MANGO_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TREE_BANANA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BANANA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_LICHEE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LICHEE_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_DURIAN,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.DURIAN_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_GUIHUA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.GUIHUA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_MEIHUA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MEIHUA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //花花草草
        context.register(ADD_MUGWORT,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MUGWORT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_CUCKOO,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CUCKOO_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_PORTULACA_OLERACEA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PORTULACA_OLERACEA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_JASMINE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.JASMINE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_KOCHIA_SCOPARIA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.KOCHIA_SCOPARIA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_SHUI_XIAN,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SHUI_XIAN_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TAN_HUA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TAN_HUA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_CAPSULE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CAPSULE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        //哈密瓜
        context.register(ADD_CANTALOUPE_BLOCK,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SANDY),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CANTALOUPE_BLOCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

//        context.register(ADD_BUTTERFLY_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.BUTTERFLY_ENTITY.get(),
//                        100, 1, 2))));
        context.register(ADD_MONKEY_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.MONKEY_ENTITY.get(),
                        40, 3, 6))));
        context.register(ADD_DRAGONFLY_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.MONKEY_ENTITY.get(),
                        200, 1, 1))));
        context.register(ADD_CICADA_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.CICADA_ENTITY.get(),
                        200, 1, 1))));
//        context.register(ADD_CRANE_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.CRANE_ENTITY.get(),
//                        100, 3, 6))));
        context.register(ADD_MALE_PEACOCK_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(),
                        100, 1, 2))));
        context.register(ADD_FEMALE_PEACOCK_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(),
                        100, 1, 2))));

//        context.register(ADD_STAG_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.STAG_ENTITY.get(),
//                        40, 3, 6))));
//        context.register(ADD_HIND_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.HIND_ENTITY.get(),
//                        40, 3, 6))));
//
//        context.register(ADD_TIGER_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_JUNGLE),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.TIGER_ENTITY.get(),
//                        40, 3, 6))));
//        context.register(ADD_CROC_ENTITY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.CROC_ENTITY.get(),
//                        40, 3, 6))));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ChangShengJue.MOD_ID, name));
    }
}
