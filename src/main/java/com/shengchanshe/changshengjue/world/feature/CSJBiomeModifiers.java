package com.shengchanshe.changshengjue.world.feature;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class CSJBiomeModifiers {
    //矿石生成
    public static final ResourceKey<BiomeModifier> ADD_AG_ORE = registerKey("add_ag_ore");
    public static final ResourceKey<BiomeModifier> ADD_AG_ORE_MIDDLE = registerKey("add_ag_ore_middle");
    public static final ResourceKey<BiomeModifier> ADD_DEEPSLATE_AG_ORE = registerKey("add_deepslate_ag_ore");

    public static final ResourceKey<BiomeModifier> ADD_KAOLIN_ORE = registerKey("add_kaolin_ore");

    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE_UPPER  = registerKey("add_limestone_upper");
    public static final ResourceKey<BiomeModifier> ADD_LIMESTONE_LOWER = registerKey("add_limestone_lower");

    public static final ResourceKey<BiomeModifier> ADD_SYDEROLIFE_ORE_UPPER  = registerKey("add_syderolife_ore_upper");
    public static final ResourceKey<BiomeModifier> ADD_SYDEROLIFE_ORE_LOWER = registerKey("add_syderolife_ore_lower");
    //树生成
    public static final ResourceKey<BiomeModifier> ADD_TREE_MANGO = registerKey("add_tree_mango");
    public static final ResourceKey<BiomeModifier> ADD_TREE_BANANA = registerKey("add_tree_banana");
    public static final ResourceKey<BiomeModifier> ADD_TREE_LICHEE = registerKey("add_tree_lichee");
    public static final ResourceKey<BiomeModifier> ADD_TREE_DURIAN = registerKey("add_tree_durian");
    public static final ResourceKey<BiomeModifier> ADD_TREE_GUIHUA = registerKey("add_tree_guihua");
    public static final ResourceKey<BiomeModifier> ADD_TREE_MEIHUA = registerKey("add_tree_meihua");
    public static final ResourceKey<BiomeModifier> ADD_TREE_MULBERRY = registerKey("add_tree_mulberry");
    public static final ResourceKey<BiomeModifier> ADD_TREE_HUANGHUALI = registerKey("add_tree_huanghuali");
    public static final ResourceKey<BiomeModifier> ADD_TREE_JICHIMU = registerKey("add_tree_jichimu");
    public static final ResourceKey<BiomeModifier> ADD_TREE_ZITAN = registerKey("add_tree_zitian");

    //花花草草
    public static final ResourceKey<BiomeModifier> ADD_MUGWORT = registerKey("add_mugwort");
    public static final ResourceKey<BiomeModifier> ADD_CUCKOO = registerKey("add_cuckoo");
    public static final ResourceKey<BiomeModifier> ADD_PORTULACA_OLERACEA = registerKey("add_portulaca_oleracea");
    public static final ResourceKey<BiomeModifier> ADD_JASMINE = registerKey("add_jasmine");
    public static final ResourceKey<BiomeModifier> ADD_KOCHIA_SCOPARIA = registerKey("add_kochia_scoparia");
    public static final ResourceKey<BiomeModifier> ADD_SHUI_XIAN = registerKey("add_shui_xian");
    public static final ResourceKey<BiomeModifier> ADD_TAN_HUA = registerKey("add_tan_hua");
    public static final ResourceKey<BiomeModifier> ADD_CAPSULE = registerKey("add_capsule");
//    public static final ResourceKey<BiomeModifier> ADD_STIPA_GRANDIS = registerKey("add_stipa_grandis");
    //野生大麦
    public static final ResourceKey<BiomeModifier> ADD_WILDLIFE_HORDEUM = registerKey("add_wildlife_hordeum");
    //哈密瓜
    public static final ResourceKey<BiomeModifier> ADD_CANTALOUPE_BLOCK = registerKey("add_cantaloupe_block");
    //生物
    public static final ResourceKey<BiomeModifier> ADD_BUTTERFLY = registerKey("add_butterfly");
    public static final ResourceKey<BiomeModifier> ADD_MONKEY = registerKey("add_monkey");
    public static final ResourceKey<BiomeModifier> ADD_DRAGONFLY = registerKey("add_dragonfly");
    public static final ResourceKey<BiomeModifier> ADD_CICADA = registerKey("add_cicada");
    public static final ResourceKey<BiomeModifier> ADD_CRANE = registerKey("add_crane");
    public static final ResourceKey<BiomeModifier> ADD_MALE_PEACOCK = registerKey("add_male_peacock");
    public static final ResourceKey<BiomeModifier> ADD_FEMALE_PEACOCK = registerKey("add_female_peacock");
    public static final ResourceKey<BiomeModifier> ADD_STAG = registerKey("add_stag");
    public static final ResourceKey<BiomeModifier> ADD_HIND = registerKey("add_hind");
    public static final ResourceKey<BiomeModifier> ADD_TIGER = registerKey("add_tiger");
    public static final ResourceKey<BiomeModifier> ADD_CROC = registerKey("add_croc");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        // 用于获取放置特性和生物群系的注册表引用
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
        //矿石
        context.register(ADD_AG_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(//创建生物群系修改器,向指定生物群系添加放置特征
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),//在主世界的所有生物群系中修改
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_AG_UPPER)),//获取放置特性
                GenerationStep.Decoration.UNDERGROUND_ORES));//在生成矿石时处理这些特性
        context.register(ADD_AG_ORE_MIDDLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_AG_MIDDLE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_DEEPSLATE_AG_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_AG_SMALL)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_KAOLIN_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.KAOLIN_UPPER)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LIMESTONE_UPPER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_LIMESTONE_UPPER)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_LIMESTONE_LOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_LIMESTONE_LOWER)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_SYDEROLIFE_ORE_UPPER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_SYDEROLIFE_ORE_UPPER)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_SYDEROLIFE_ORE_LOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ORE_SYDEROLIFE_ORE_LOWER)),
                GenerationStep.Decoration.UNDERGROUND_ORES));


        //树木
        context.register(ADD_TREE_MANGO,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.MANGO_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TREE_BANANA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.BANANA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_LICHEE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.LICHEE_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_DURIAN,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.DURIAN_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_GUIHUA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.GUIHUA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_MEIHUA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.MEIHUA_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_MULBERRY,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.MULBERRY_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_HUANGHUALI,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.HUANGHUALI_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_JICHIMU,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.JICHIMU_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_ZITAN,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.ZITAN_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));


        //花花草草
        context.register(ADD_MUGWORT,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.MUGWORT_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_CUCKOO,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.CUCKOO_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_PORTULACA_OLERACEA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.PORTULACA_OLERACEA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_JASMINE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.JASMINE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_KOCHIA_SCOPARIA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.KOCHIA_SCOPARIA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_SHUI_XIAN,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.SHUI_XIAN_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TAN_HUA,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_SAVANNA),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.TAN_HUA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_CAPSULE,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.CAPSULE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //野生大麦
        context.register(ADD_WILDLIFE_HORDEUM,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.WILDLIFE_HORDEUM_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //哈密瓜
        context.register(ADD_CANTALOUPE_BLOCK,new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                        HolderSet.direct(placedFeatures.getOrThrow(CSJPlacedFeatures.CANTALOUPE_BLOCK_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        //生物
//        context.register(ADD_BUTTERFLY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.BUTTERFLY.get(),
//                        100, 1, 2))));
        context.register(ADD_MONKEY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.MONKEY.get(),
                        40, 3, 6))));
        context.register(ADD_DRAGONFLY,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.MONKEY.get(),
                        200, 1, 1))));
        context.register(ADD_CICADA,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.CICADA.get(),
                        200, 1, 1))));
//        context.register(ADD_CRANE,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.CRANE.get(),
//                        100, 3, 6))));
        context.register(ADD_MALE_PEACOCK,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.MALE_PEACOCK.get(),
                        100, 1, 2))));
        context.register(ADD_FEMALE_PEACOCK,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.FEMALE_PEACOCK.get(),
                        100, 1, 2))));

//        context.register(ADD_STAG,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.STAG.get(),
//                        40, 3, 6))));
//        context.register(ADD_HIND,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_FOREST),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.HIND.get(),
//                        40, 3, 6))));
//
//        context.register(ADD_TIGER,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(BiomeTags.IS_JUNGLE),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.TIGER.get(),
//                        40, 3, 6))));
//        context.register(ADD_CROC,new ForgeBiomeModifiers.AddSpawnsBiomeModifier(biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
//                List.of(new MobSpawnSettings.SpawnerData(ChangShengJueEntity.CROC.get(),
//                        40, 3, 6))));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(ChangShengJue.MOD_ID, name));
    }
}
