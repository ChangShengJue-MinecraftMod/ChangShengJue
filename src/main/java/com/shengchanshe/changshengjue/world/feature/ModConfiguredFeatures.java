package com.shengchanshe.changshengjue.world.feature;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.Optional;


public class ModConfiguredFeatures {
//多种叶子的树
//    public static final ConfiguredFeature<TreeConfiguration,?> MANGO_TREE = FeatureUtils.register("mango", new ConfiguredFeature<>(
//            Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//            BlockStateProvider.simple(ChangShengJueBlocks.MANGO_LOG.get()),
//            new StraightTrunkPlacer(3, 2, 1),
//            new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ChangShengJueBlocks.MANGO_LEAVES.get().defaultBlockState(), 3).
//                    add(ChangShengJueBlocks.MANGO_LEAVES_1.get().defaultBlockState(), 1)),
//            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//            new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
//
//    public static final ConfiguredFeature<TreeConfiguration,?> BANANA_TREE = FeatureUtils.register("banana_tree",
//            Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(
//                    BlockStateProvider.simple(ChangShengJueBlocks.BANANA_LOG.get()),
//                    new StraightTrunkPlacer(5, 2, 1),
//                    BlockStateProvider.simple(ChangShengJueBlocks.BANANA_LEAVES.get()),
//                    new SpruceFoliagePlacer(UniformInt.of(0, 1), UniformInt.of(0, 1), UniformInt.of(1, 2)),
//                    new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build()));
//
//    public static final ConfiguredFeature<TreeConfiguration,?> PEAR_TREE = FeatureUtils.register("pear_tree", new ConfiguredFeature<>(
//            Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//            BlockStateProvider.simple(ChangShengJueBlocks.PEAR_LOG.get()),
//            new StraightTrunkPlacer(3, 2, 1),
//            BlockStateProvider.simple(ChangShengJueBlocks.PEAR_LEAVES.get()),
//            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//            new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
//
//    public static final ConfiguredFeature<TreeConfiguration,?> LICHEE_TREE = FeatureUtils.register("lichee_tree", new ConfiguredFeature<>(
//            Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//            BlockStateProvider.simple(ChangShengJueBlocks.LICHEE_LOG.get()),
//            new StraightTrunkPlacer(3, 2, 1),
//            BlockStateProvider.simple(ChangShengJueBlocks.LICHEE_LEAVES.get()),
//            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//            new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
//
//    public static final ConfiguredFeature<TreeConfiguration,?> DURIAN_TREE = FeatureUtils.register("durian_tree", new ConfiguredFeature<>(
//            Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//            BlockStateProvider.simple(ChangShengJueBlocks.DURIAN_LOG.get()),
//            new StraightTrunkPlacer(3, 2, 1),
//            BlockStateProvider.simple(ChangShengJueBlocks.DURIAN_LEAVES.get()),
//            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//            new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
//
//    public static final ConfiguredFeature<TreeConfiguration,?> GUIHUA_TREE = FeatureUtils.register("guihua_tree", new ConfiguredFeature<>(
//            Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//            BlockStateProvider.simple(ChangShengJueBlocks.GUI_HUA_LOG.get()),
//            new StraightTrunkPlacer(3, 2, 1),
//            BlockStateProvider.simple(ChangShengJueBlocks.GUI_HUA_LEAVES.get()),
//            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//            new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
//    public static final ConfiguredFeature<TreeConfiguration,?> MEIHUA_TREE = FeatureUtils.register("meihua_tree", new ConfiguredFeature<>(
//            Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//            BlockStateProvider.simple(ChangShengJueBlocks.MEI_HUA_LOG.get()),
//            new StraightTrunkPlacer(3, 2, 1),
//            BlockStateProvider.simple(ChangShengJueBlocks.MEI_HUA_LEAVES.get()),
//            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//            new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build()));
//
//    public static final PlacedFeature MANGO_CHECKED = PlacementUtils.register("mango_checked", MANGO_TREE.filteredByBlockSurvival(ChangShengJueBlocks.MANGO_SAPLING.get()));
//    public static final PlacedFeature BANANA_CHECKED = PlacementUtils.register("banana_checked", BANANA_TREE.filteredByBlockSurvival(ChangShengJueBlocks.BANANA_SAPLING.get()));
//    public static final PlacedFeature PEAR_CHECKED = PlacementUtils.register("pear_checked", PEAR_TREE.filteredByBlockSurvival(ChangShengJueBlocks.PEAR_SAPLING.get()));
//    public static final PlacedFeature LICHEE_CHECKED = PlacementUtils.register("pear_checked", LICHEE_TREE.filteredByBlockSurvival(ChangShengJueBlocks.LICHEE_SAPLING.get()));
//    public static final PlacedFeature DURIAN_CHECKED = PlacementUtils.register("pear_checked", DURIAN_TREE.filteredByBlockSurvival(ChangShengJueBlocks.DURIAN_SAPLING.get()));
//
//    public static final PlacedFeature GUIHUA_CHECKED = PlacementUtils.register("guihua_checked", GUIHUA_TREE.filteredByBlockSurvival(ChangShengJueBlocks.GUI_HUA_SAPLING.get()));
//    public static final PlacedFeature MEIHUA_CHECKED = PlacementUtils.register("meihua_checked", MEIHUA_TREE.filteredByBlockSurvival(ChangShengJueBlocks.MEI_HUA_SAPLING.get()));
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> MANGO_FOREST_VEGETATION =
//            FeatureUtils.register("mango_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(MANGO_CHECKED, 0.0000001F)), MANGO_CHECKED)));
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> BANANA_FOREST_VEGETATION =
//            FeatureUtils.register("banana_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(BANANA_CHECKED, 0.05F)), BANANA_CHECKED)));
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> PEAR_FOREST_VEGETATION =
//            FeatureUtils.register("pear_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(PEAR_CHECKED, 0.05F)), PEAR_CHECKED)));
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> LICHEE_FOREST_VEGETATION =
//            FeatureUtils.register("lichee_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(LICHEE_CHECKED, 0.05F)), LICHEE_CHECKED)));
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> DURIAN_FOREST_VEGETATION =
//            FeatureUtils.register("durian_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(DURIAN_CHECKED, 0.05F)), DURIAN_CHECKED)));
//
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> GUIHUA_FOREST_VEGETATION =
//            FeatureUtils.register("guihua_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(GUIHUA_CHECKED, 0.05F)), GUIHUA_CHECKED)));
//
//    public static final ConfiguredFeature<RandomFeatureConfiguration, ?> MEIHUA_FOREST_VEGETATION =
//            FeatureUtils.register("meihua_forest_vegetation", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(
//                    List.of(new WeightedPlacedFeature(MEIHUA_CHECKED, 0.0000001F)), MEIHUA_CHECKED)));
//
//
//    //花花草草
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> MUGWORT_FOREST_VEGETATION =
//            FeatureUtils.register("mugwort_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.MUGWORT_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> CUCKOO_FOREST_VEGETATION =
//            FeatureUtils.register("cuckoo_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.CUCKOO_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PORTULACA_OLERACEA_FOREST_VEGETATION =
//            FeatureUtils.register("portulaca_oleracea_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> JASMINE_FOREST_VEGETATION =
//            FeatureUtils.register("jasmine_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.JASMINE_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> KOCHIA_SCOPARIA_FOREST_VEGETATION =
//            FeatureUtils.register("kochia_scoparia_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> SHUI_XIAN_FOREST_VEGETATION =
//            FeatureUtils.register("shui_xian_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> TAN_HUA_FOREST_VEGETATION =
//            FeatureUtils.register("tan_hua_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 2, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.TAN_HUA_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> CAPSULE_FOREST_VEGETATION =
//            FeatureUtils.register("capsule_forest_vegetation", Feature.FLOWER.configured(new RandomPatchConfiguration(32, 3, 2, () ->
//                    Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.CAPSULE_BLOCK.get().defaultBlockState()))).onlyWhenEmpty())));
//
//    //哈密瓜
//    public static final ConfiguredFeature<RandomPatchConfiguration, ?> CANTALOUPE_BLOCK_VEGETATION = FeatureUtils.register("cantaloupe_block_vegetation",
//            Feature.RANDOM_PATCH.configured(new RandomPatchConfiguration(64, 7, 3,
//                    () -> Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(
//                            BlockStateProvider.simple(ChangShengJueBlocks.CANTALOUPE_BLOCK.get().defaultBlockState()))).filtered(BlockPredicate.allOf(BlockPredicate.replaceable(),
//                            BlockPredicate.matchesBlock(Blocks.SAND, new BlockPos(0, -1, 0)))))));

    //矿石
    public static final ResourceKey<ConfiguredFeature<?, ?>> AG_ORE = registerKey("ag_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AG_ORE_SMALL = registerKey("ag_ore_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KAOLIN_ORE = registerKey("kaolin_ore");
    //树
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGO_TREE = registerKey("mango_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_TREE = registerKey("banana_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PEAR_TREE = registerKey("pear_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LICHEE_TREE = registerKey("lichee_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DURIAN_TREE = registerKey("durian_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GUIHUA_TREE = registerKey("guihua_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEIHUA_TREE = registerKey("meihua_tree");
    //花花草草
    public static final ResourceKey<ConfiguredFeature<?, ?>> MUGWORT = registerKey("mugwort");
    public static final ResourceKey<ConfiguredFeature<?,?>> CUCKOO = registerKey("cuckoo");
    public static final ResourceKey<ConfiguredFeature<?,?>> PORTULACA_OLERACEA = registerKey("portulaca_oleracea");
    public static final ResourceKey<ConfiguredFeature<?,?>> JASMINE = registerKey("jasmine");
    public static final ResourceKey<ConfiguredFeature<?,?>> KOCHIA_SCOPARIA = registerKey("kochia_scoparia");
    public static final ResourceKey<ConfiguredFeature<?,?>> SHUI_XIAN = registerKey("shui_xian");
    public static final ResourceKey<ConfiguredFeature<?,?>> TAN_HUA = registerKey("tan_hua");
    public static final ResourceKey<ConfiguredFeature<?,?>> CAPSULE = registerKey("capsule");
    //哈密瓜
    public static final ResourceKey<ConfiguredFeature<?,?>> CANTALOUPE_BLOCK = registerKey("cantaloupe_block");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?,?>> context){
        HolderGetter<Block> holdergetter = context.lookup(Registries.BLOCK);
        //定义矿石可替换的方块,TagMatchTest匹配特定标签的方块,BlockMatchTest匹配具体方块

        //定义在主世界中生成的矿石配置
        List<OreConfiguration.TargetBlockState> overworldSapphireOres = overworldSapphireOres(ChangShengJueBlocks.AG_ORE.get().defaultBlockState(),ChangShengJueBlocks.DEEPSLATE_AG_ORE.get().defaultBlockState());//在深板岩方块上生成矿石
        register(context,AG_ORE,Feature.ORE,new OreConfiguration(overworldSapphireOres,9));
        register(context,AG_ORE_SMALL,Feature.ORE,new OreConfiguration(overworldSapphireOres,4));

        register(context,KAOLIN_ORE,Feature.ORE,new OreConfiguration(overworldSapphireOres(ChangShengJueBlocks.KAOLIN_ORE.get().defaultBlockState(),null),9));

        register(context,MANGO_TREE,Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.MANGO_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),

                BlockStateProvider.simple(ChangShengJueBlocks.MANGO_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
//
//                Optional.of(new MangroveRootPlacer(UniformInt.of(1, 3), BlockStateProvider.simple(Blocks.MANGROVE_ROOTS),
//                        Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)),
//                        new MangroveRootPlacement(holdergetter.getOrThrow(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH), HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS),
//                                BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 8, 15, 0.2F))),

                new TwoLayersFeatureSize(1,0,2)).ignoreVines().build());
        //树木
        register(context,BANANA_TREE,Feature.TREE,(new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.BANANA_LOG.get()),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.simple(ChangShengJueBlocks.BANANA_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(0, 1), UniformInt.of(0, 1), UniformInt.of(3, 4)),
                new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());

        register(context,PEAR_TREE,Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.PEAR_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ChangShengJueBlocks.PEAR_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context,LICHEE_TREE,Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.LICHEE_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ChangShengJueBlocks.LICHEE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context,DURIAN_TREE,Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.DURIAN_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ChangShengJueBlocks.DURIAN_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context,GUIHUA_TREE,Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.GUI_HUA_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ChangShengJueBlocks.GUI_HUA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

        register(context,MEIHUA_TREE,Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ChangShengJueBlocks.MEI_HUA_LOG.get()),
                new StraightTrunkPlacer(3, 2, 1),
                BlockStateProvider.simple(ChangShengJueBlocks.MEI_HUA_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
        //花花草草
        register(context,MUGWORT,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,//生成次数,xz轴的扩散范围,y轴的扩散范围
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.MUGWORT_BLOCK.get())))));
        register(context,CUCKOO,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.CUCKOO_BLOCK.get())))));
        register(context,PORTULACA_OLERACEA,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get())))));
        register(context,JASMINE,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.JALAPENOS_BLOCK.get())))));
        register(context,KOCHIA_SCOPARIA,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get())))));
        register(context,SHUI_XIAN,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get())))));
        register(context,TAN_HUA,Feature.FLOWER,
                new RandomPatchConfiguration(16,3,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.TAN_HUA_BLOCK.get())))));
        register(context,CAPSULE,Feature.FLOWER,
                new RandomPatchConfiguration(16,4,2,PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.CAPSULE_BLOCK.get())))));
        //哈密瓜
        register(context,CANTALOUPE_BLOCK,Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(32, 6, 2,PlacementUtils.filtered(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ChangShengJueBlocks.CANTALOUPE_BLOCK.get())),
                        BlockPredicate.allOf(
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.matchesBlocks(BlockPos.ZERO.below(), Blocks.SAND)))));
    }

    public static List<OreConfiguration.TargetBlockState> overworldSapphireOres(BlockState state,BlockState state1){
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplacables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        return List.of(OreConfiguration.target(stoneReplaceable, state),//在石头方块上生成矿石
                OreConfiguration.target(deepslateReplaceables, state));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(ChangShengJue.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

//    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_AG_ORES = List.of(
//            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ChangShengJueBlocks.AG_ORE.get().defaultBlockState()),
//            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ChangShengJueBlocks.DEEPSLATE_AG_ORE.get().defaultBlockState()));

}
