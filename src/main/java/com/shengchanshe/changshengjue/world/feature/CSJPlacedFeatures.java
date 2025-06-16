package com.shengchanshe.changshengjue.world.feature;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class CSJPlacedFeatures {
    //矿石
    public static final ResourceKey<PlacedFeature> ORE_AG_UPPER = registerKey("ore_ag_upper");
    public static final ResourceKey<PlacedFeature> ORE_AG_MIDDLE = registerKey("ore_ag_middle");
    public static final ResourceKey<PlacedFeature> ORE_AG_SMALL =registerKey("ore_ag_small");

    public static final ResourceKey<PlacedFeature> KAOLIN_UPPER = registerKey("kaolin_upper");

    public static final ResourceKey<PlacedFeature> ORE_LIMESTONE_UPPER = registerKey("ore_limestone_upper");
    public static final ResourceKey<PlacedFeature> ORE_LIMESTONE_LOWER = registerKey("ore_limestone_lower");

    public static final ResourceKey<PlacedFeature> ORE_SYDEROLIFE_ORE_UPPER = registerKey("ore_syderolife_ore_upper");
    public static final ResourceKey<PlacedFeature> ORE_SYDEROLIFE_ORE_LOWER = registerKey("ore_syderolife_ore_lower");

    //树木
    public static final ResourceKey<PlacedFeature> MANGO_TREE_PLACED_KEY =registerKey("mango_tree_placed_key");
    public static final ResourceKey<PlacedFeature> BANANA_TREE_PLACED_KEY =registerKey("banana_tree_placed_key");
    public static final ResourceKey<PlacedFeature> LICHEE_TREE_PLACED_KEY =registerKey("lichee_tree_placed_key");
    public static final ResourceKey<PlacedFeature> DURIAN_TREE_PLACED_KEY =registerKey("durian_tree_placed_key");
    public static final ResourceKey<PlacedFeature> GUIHUA_TREE_PLACED_KEY =registerKey("guihua_tree_placed_key");
    public static final ResourceKey<PlacedFeature> MEIHUA_TREE_PLACED_KEY =registerKey("meihua_tree_placed_key");
    public static final ResourceKey<PlacedFeature> POPLAR_TREE_PLACED_KEY =registerKey("poplar_tree_placed_key");
    public static final ResourceKey<PlacedFeature> MULBERRY_TREE_PLACED_KEY =registerKey("mulberry_tree_placed_key");
    public static final ResourceKey<PlacedFeature> HUANGHUALI_TREE_PLACED_KEY =registerKey("huanghuali_tree_placed_key");
    public static final ResourceKey<PlacedFeature> JICHIMU_TREE_PLACED_KEY =registerKey("jichimu_tree_placed_key");
    public static final ResourceKey<PlacedFeature> ZITAN_TREE_PLACED_KEY =registerKey("zitan_tree_placed_key");
    //花花草草
    public static final ResourceKey<PlacedFeature> MUGWORT_PLACED_KEY =registerKey("mugwort_placed_key");
    public static final ResourceKey<PlacedFeature> CUCKOO_PLACED_KEY =registerKey("cuckoo_placed_key");
    public static final ResourceKey<PlacedFeature> PORTULACA_OLERACEA_PLACED_KEY =registerKey("portulaca_oleracea_placed_key");
    public static final ResourceKey<PlacedFeature> JASMINE_PLACED_KEY =registerKey("jasmine_placed_key");
    public static final ResourceKey<PlacedFeature> KOCHIA_SCOPARIA_PLACED_KEY =registerKey("kochia_scoparia_placed_key");
    public static final ResourceKey<PlacedFeature> SHUI_XIAN_PLACED_KEY = registerKey("shui_xian_placed_key");
    public static final ResourceKey<PlacedFeature> TAN_HUA_PLACED_KEY = registerKey("tan_hua_placed_key");
    public static final ResourceKey<PlacedFeature> CAPSULE_PLACED_KEY = registerKey("capsule_placed_key");
    public static final ResourceKey<PlacedFeature> STIPA_GRANDIS_PLACED_KEY = registerKey("stipa_grandis_placed_key");
    public static final ResourceKey<PlacedFeature> TALL_STIPA_GRANDIS_PLACED_KEY = registerKey("tall_stipa_grandis_placed_key");
    public static final ResourceKey<PlacedFeature> RAPE_FLOWERS_PLACED_KEY = registerKey("rape_flowers_placed_key");

    //野生大麦
    public static final ResourceKey<PlacedFeature> WILDLIFE_HORDEUM_PLACED_KEY =registerKey("wildlife_hordeum_placed_key");
    //哈密瓜
    public static final ResourceKey<PlacedFeature> CANTALOUPE_BLOCK_PLACED_KEY = registerKey("cantaloupe_block_placed_key");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        // 获取配置特性的注册表引用，用于后续获取指定的配置特性。
        HolderGetter<ConfiguredFeature<?,?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);
        //注册一个放置特性,使用ModConfiguredFeatures类中的配置特性和不同的放置规则
        register(context,ORE_AG_UPPER,configuredFeature.getOrThrow(CSJConfiguredFeatures.AG_ORE),
                CSJOrePlacement.commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
        register(context,ORE_AG_MIDDLE,configuredFeature.getOrThrow(CSJConfiguredFeatures.AG_ORE_SMALL),
                CSJOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        register(context,ORE_AG_SMALL,configuredFeature.getOrThrow(CSJConfiguredFeatures.AG_ORE_SMALL),
                CSJOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));

        register(context,KAOLIN_UPPER,configuredFeature.getOrThrow(CSJConfiguredFeatures.KAOLIN_ORE),
                CSJOrePlacement.commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(100), VerticalAnchor.absolute(200))));

        register(context, ORE_LIMESTONE_UPPER, configuredFeature.getOrThrow(CSJConfiguredFeatures.LIMESTONE),
                CSJOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        register(context, ORE_LIMESTONE_LOWER, configuredFeature.getOrThrow(CSJConfiguredFeatures.LIMESTONE),
                CSJOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

        register(context, ORE_SYDEROLIFE_ORE_UPPER, configuredFeature.getOrThrow(CSJConfiguredFeatures.SYDEROLIFE_ORE),
                CSJOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(128))));
        register(context, ORE_SYDEROLIFE_ORE_LOWER, configuredFeature.getOrThrow(CSJConfiguredFeatures.SYDEROLIFE_ORE),
                CSJOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));

        //树木
        register(context,MANGO_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.MANGO_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.MANGO_SAPLING.get()));

        register(context,BANANA_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.BANANA_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.BANANA_SAPLING.get()));

        register(context,LICHEE_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.LICHEE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.LICHEE_SAPLING.get()));

        register(context,DURIAN_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.DURIAN_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.DURIAN_SAPLING.get()));

        register(context,GUIHUA_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.GUIHUA_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.GUI_HUA_SAPLING.get()));

        register(context,MEIHUA_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.MEIHUA_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.MEI_HUA_SAPLING.get()));

        register(context,POPLAR_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.POPLAR_TREE),
                //                                                            10%的概率尝试1+1次  90%的概率尝试1次
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1F,1),
                        ChangShengJueBlocks.POPLAR_SAPLING.get()));

        register(context,MULBERRY_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.MULBERRY_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1F,1),
                        ChangShengJueBlocks.MULBERRY_SAPLING.get()));

        register(context,HUANGHUALI_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.HUANGHUALI_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1F,1),
                        ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get()));

        register(context,JICHIMU_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.JICHIMU_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1F,1),
                        ChangShengJueBlocks.JI_CHI_MU_SAPLING.get()));

        register(context,ZITAN_TREE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.ZITAN_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1,0.1F,1),
                        ChangShengJueBlocks.ZI_TAN_SAPLING.get()));
        //花花草草
        register(context,MUGWORT_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.MUGWORT),
                List.of(RarityFilter.onAverageOnceEvery(16),//生成几率,值越小生成的越多
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,CUCKOO_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.CUCKOO),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,PORTULACA_OLERACEA_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.PORTULACA_OLERACEA),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,JASMINE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.JASMINE),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,KOCHIA_SCOPARIA_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.KOCHIA_SCOPARIA),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,SHUI_XIAN_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.SHUI_XIAN),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,TAN_HUA_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.TAN_HUA),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,CAPSULE_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.CAPSULE),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,STIPA_GRANDIS_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.STIPA_GRANDIS),
                List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 10),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context,TALL_STIPA_GRANDIS_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.TALL_STIPA_GRANDIS),
                List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 10),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context,RAPE_FLOWERS_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.RAPE_FLOWERS),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        //野生大麦
        register(context,WILDLIFE_HORDEUM_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.WILDLIFE_HORDEUM),
                List.of(RarityFilter.onAverageOnceEvery(8),//生成几率,值越小生成的越多
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));
        //哈密瓜
        register(context,CANTALOUPE_BLOCK_PLACED_KEY,configuredFeature.getOrThrow(CSJConfiguredFeatures.CANTALOUPE_BLOCK),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ChangShengJue.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        //注册放置特性
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

