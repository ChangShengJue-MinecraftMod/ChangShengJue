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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
//    public static final PlacedFeature MANGO_PLACED = PlacementUtils.register("mango_placed",
//            ModConfiguredFeatures.MANGO_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    public static final PlacedFeature BANANA_PLACED = PlacementUtils.register("banana_placed",
//            ModConfiguredFeatures.BANANA_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    public static final PlacedFeature PEAR_PLACED = PlacementUtils.register("pear_placed",
//            ModConfiguredFeatures.PEAR_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    public static final PlacedFeature LICHEE_PLACED = PlacementUtils.register("lichee_placed",
//            ModConfiguredFeatures.LICHEE_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    public static final PlacedFeature DURIAN_PLACED = PlacementUtils.register("durian_placed",
//            ModConfiguredFeatures.DURIAN_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    public static final PlacedFeature GUIHUA_PLACED = PlacementUtils.register("guihua_placed",
//            ModConfiguredFeatures.GUIHUA_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    public static final PlacedFeature MEIHUA_PLACED = PlacementUtils.register("meihua_placed",
//            ModConfiguredFeatures.MEIHUA_FOREST_VEGETATION.placed(VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
//
//    //花花草草
//    public static final PlacedFeature MUGWORT_PLACED = PlacementUtils.register("mugwort_placed",
//            ModConfiguredFeatures.MUGWORT_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature CUCKOO_FOREST_PLACED = PlacementUtils.register("cuckoo_forest_placed",
//            ModConfiguredFeatures.CUCKOO_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature PORTULACA_OLERACEA_PLACED = PlacementUtils.register("portulaca_oleracea_placed",
//            ModConfiguredFeatures.PORTULACA_OLERACEA_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature JASMINE_PLACED = PlacementUtils.register("jasmine_placed",
//            ModConfiguredFeatures.JASMINE_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature KOCHIA_SCOPARIA_PLACED = PlacementUtils.register("kochia_scoparia_placed",
//            ModConfiguredFeatures.KOCHIA_SCOPARIA_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature SHUI_XIAN_PLACED = PlacementUtils.register("shui_xian_placed",
//            ModConfiguredFeatures.SHUI_XIAN_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature TAN_HUA_PLACED = PlacementUtils.register("tan_hua_placed",
//            ModConfiguredFeatures.TAN_HUA_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//    public static final PlacedFeature CAPSULE_PLACED = PlacementUtils.register("capsule_placed",
//            ModConfiguredFeatures.CAPSULE_FOREST_VEGETATION.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
//
//    public static final PlacedFeature CANTALOUPE_BLOCK_PLACED = PlacementUtils.register("cantaloupe_block_placed",
//            ModConfiguredFeatures.CANTALOUPE_BLOCK_VEGETATION.placed(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    //矿石
    public static final ResourceKey<PlacedFeature> ORE_AG_UPPER = registerKey("ore_ag_upper");
    public static final ResourceKey<PlacedFeature> ORE_AG_MIDDLE = registerKey("ore_ag_middle");
    public static final ResourceKey<PlacedFeature> ORE_AG_SMALL =registerKey("ore_ag_small");
    //树木
    public static final ResourceKey<PlacedFeature> MANGO_TREE_PLACED_KEY =registerKey("mango_tree_placed_key");
    public static final ResourceKey<PlacedFeature> BANANA_TREE_PLACED_KEY =registerKey("banana_tree_placed_key");
    public static final ResourceKey<PlacedFeature> LICHEE_TREE_PLACED_KEY =registerKey("lichee_tree_placed_key");
    public static final ResourceKey<PlacedFeature> DURIAN_TREE_PLACED_KEY =registerKey("durian_tree_placed_key");
    public static final ResourceKey<PlacedFeature> GUIHUA_TREE_PLACED_KEY =registerKey("guihua_tree_placed_key");
    public static final ResourceKey<PlacedFeature> MEIHUA_TREE_PLACED_KEY =registerKey("meihua_tree_placed_key");
    //花花草草
    public static final ResourceKey<PlacedFeature> MUGWORT_PLACED_KEY =registerKey("mugwort_placed_key");
    public static final ResourceKey<PlacedFeature> CUCKOO_PLACED_KEY =registerKey("cuckoo_placed_key");
    public static final ResourceKey<PlacedFeature> PORTULACA_OLERACEA_PLACED_KEY =registerKey("portulaca_oleracea_placed_key");
    public static final ResourceKey<PlacedFeature> JASMINE_PLACED_KEY =registerKey("jasmine_placed_key");
    public static final ResourceKey<PlacedFeature> KOCHIA_SCOPARIA_PLACED_KEY =registerKey("kochia_scoparia_placed_key");
    public static final ResourceKey<PlacedFeature> SHUI_XIAN_PLACED_KEY = registerKey("shui_xian_placed_key");
    public static final ResourceKey<PlacedFeature> TAN_HUA_PLACED_KEY = registerKey("tan_hua_placed_key");
    public static final ResourceKey<PlacedFeature> CAPSULE_PLACED_KEY = registerKey("capsule_placed_key");
    //哈密瓜
    public static final ResourceKey<PlacedFeature> CANTALOUPE_BLOCK_PLACED_KEY = registerKey("cantaloupe_block_placed_key");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        // 获取配置特性的注册表引用，用于后续获取指定的配置特性。
        HolderGetter<ConfiguredFeature<?,?>> configuredFeature = context.lookup(Registries.CONFIGURED_FEATURE);
        //注册一个放置特性,使用ModConfiguredFeatures类中的配置特性和不同的放置规则
        register(context,ORE_AG_UPPER,configuredFeature.getOrThrow(ModConfiguredFeatures.AG_ORE),
                ModOrePlacement.commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));
        register(context,ORE_AG_MIDDLE,configuredFeature.getOrThrow(ModConfiguredFeatures.AG_ORE_SMALL),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56))));
        register(context,ORE_AG_SMALL,configuredFeature.getOrThrow(ModConfiguredFeatures.AG_ORE_SMALL),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72))));

        //树木
        register(context,MANGO_TREE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.MANGO_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.MANGO_SAPLING.get()));

        register(context,BANANA_TREE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.BANANA_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.BANANA_SAPLING.get()));

        register(context,LICHEE_TREE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.LICHEE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.LICHEE_SAPLING.get()));

        register(context,DURIAN_TREE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.DURIAN_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.DURIAN_SAPLING.get()));

        register(context,GUIHUA_TREE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.GUIHUA_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.GUI_HUA_SAPLING.get()));

        register(context,MEIHUA_TREE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.MEIHUA_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.1F,1),
                        ChangShengJueBlocks.MEI_HUA_SAPLING.get()));
        //花花草草
        register(context,MUGWORT_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.MUGWORT),
                List.of(RarityFilter.onAverageOnceEvery(16),//生成几率,值越小生成的越多
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,CUCKOO_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.CUCKOO),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,PORTULACA_OLERACEA_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.PORTULACA_OLERACEA),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,JASMINE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.JASMINE),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,KOCHIA_SCOPARIA_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.KOCHIA_SCOPARIA),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,SHUI_XIAN_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.SHUI_XIAN),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,TAN_HUA_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.TAN_HUA),
                List.of(RarityFilter.onAverageOnceEvery(8),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));

        register(context,CAPSULE_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.CAPSULE),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP,BiomeFilter.biome()));
        //哈密瓜
        register(context,CANTALOUPE_BLOCK_PLACED_KEY,configuredFeature.getOrThrow(ModConfiguredFeatures.CANTALOUPE_BLOCK),
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

