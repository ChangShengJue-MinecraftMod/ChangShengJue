package com.shengchanshe.changshengjue.datagen.loot;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.block.cropper.CornBlock;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class CSJBlockLootTables extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    public CSJBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //树木
        this.dropSelf(ChangShengJueBlocks.MANGO_LOG.get());
        this.dropSelf(ChangShengJueBlocks.MANGO_SAPLING.get());
        this.add(ChangShengJueBlocks.MANGO_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.MANGO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ChangShengJueBlocks.BANANA_LOG.get());
        this.dropSelf(ChangShengJueBlocks.BANANA_SAPLING.get());
        this.add(ChangShengJueBlocks.BANANA_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.BANANA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ChangShengJueBlocks.PEAR_LOG.get());
        this.dropSelf(ChangShengJueBlocks.PEAR_SAPLING.get());
        this.add(ChangShengJueBlocks.PEAR_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ChangShengJueBlocks.LICHEE_LOG.get());
        this.dropSelf(ChangShengJueBlocks.LICHEE_SAPLING.get());
        this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.LICHEE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(ChangShengJueBlocks.DURIAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.DURIAN_SAPLING.get());
        this.add(ChangShengJueBlocks.DURIAN_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.DURIAN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ChangShengJueBlocks.GUI_HUA_LOG.get());
        this.dropSelf(ChangShengJueBlocks.GUI_HUA_SAPLING.get());
        this.add(ChangShengJueBlocks.GUI_HUA_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.GUI_HUA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES).
                withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionCondition(block, LootItem.lootTableItem(ChangShengJueItems.GUI_HUA.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.2F, 0.3F, 0.4F, 0.7F, 0.8F)))));

        this.dropSelf(ChangShengJueBlocks.MEI_HUA_LOG.get());
        this.dropSelf(ChangShengJueBlocks.MEI_HUA_SAPLING.get());
        this.add(ChangShengJueBlocks.MEI_HUA_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.MEI_HUA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES).
                withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionCondition(block, LootItem.lootTableItem(ChangShengJueItems.MEI_HUA.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.2F, 0.3F, 0.4F, 0.7F, 0.8F)))));

        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_PLANKS.get());

        this.dropSelf(ChangShengJueBlocks.POPLAR_LOG.get());
        this.dropSelf(ChangShengJueBlocks.POPLAR_SAPLING.get());
        this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.POPLAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.POPLAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ChangShengJueBlocks.AG_ORE.get(),
                (block -> createOreDrop(ChangShengJueBlocks.AG_ORE.get(), ChangShengJueItems.RAW_AG.get())));
        this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(),
                (block -> createOreDrop(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), ChangShengJueItems.RAW_AG.get())));

        this.dropSelf(ChangShengJueBlocks.KAOLIN_ORE.get());

        this.dropSelf(ChangShengJueBlocks.MANGO_LEAVES.get());
        //农作物
        LootItemCondition.Builder pineapple = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.PINEAPPLE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), createCropDrops(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), ChangShengJueItems.PINEAPPLE.get(), ChangShengJueItems.PINEAPPLE_SEEDS.get(), pineapple));
        LootItemCondition.Builder soybean = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.SOYBEAN_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), createCropDrops(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), ChangShengJueItems.SOYBEAN.get(), ChangShengJueItems.SOYBEAN.get(), soybean));
        LootItemCondition.Builder tomato = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.TOMATO_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.TOMATO_BLOCK.get(), createCropDrops(ChangShengJueBlocks.TOMATO_BLOCK.get(), ChangShengJueItems.TOMATO.get(), ChangShengJueItems.TOMATO_SEEDS.get(), tomato));
        LootItemCondition.Builder GuZi = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.GU_ZI_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.GU_ZI_BLOCK.get(), createCropDrops(ChangShengJueBlocks.GU_ZI_BLOCK.get(), ChangShengJueItems.GU_SUI.get(), ChangShengJueItems.GU_SEEDS.get(), GuZi));
        LootItemCondition.Builder sorghum = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.SORGHUM_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 6))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.SORGHUM_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7)));
        this.add(ChangShengJueBlocks.SORGHUM_BLOCK.get(), createCropDrops(ChangShengJueBlocks.SORGHUM_BLOCK.get(), ChangShengJueItems.SORGHUM.get(), ChangShengJueItems.SORGHUM_SEEDS.get(), sorghum));
        LootItemCondition.Builder redbean = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.REDBEAN_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.REDBEAN_BLOCK.get(), createCropDrops(ChangShengJueBlocks.REDBEAN_BLOCK.get(), ChangShengJueItems.REDBEAN.get(), ChangShengJueItems.SORGHUM_SEEDS.get(), redbean));
        LootItemCondition.Builder cotton = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.COTTON_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.COTTON_BLOCK.get(), createCropDrops(ChangShengJueBlocks.COTTON_BLOCK.get(), ChangShengJueItems.COTTON.get(), ChangShengJueItems.COTTON_SEEDS.get(), cotton));
        LootItemCondition.Builder stickyrice = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.STICKYRICE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), createCropDrops(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), ChangShengJueItems.STICKYRICE.get(), ChangShengJueItems.STICKYRICE_SEEDS.get(), stickyrice));
        LootItemCondition.Builder corn = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.CORN_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 6))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.CORN_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7)));
        this.add(ChangShengJueBlocks.CORN_BLOCK.get(), createCropDrops(ChangShengJueBlocks.CORN_BLOCK.get(), ChangShengJueItems.CORN.get(), ChangShengJueItems.CORN_SEEDS.get(), corn));
        LootItemCondition.Builder jalapenos = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.JALAPENOS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), createCropDrops(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), ChangShengJueItems.JALAPENOS.get(), ChangShengJueItems.JALAPENOS_SEEDS.get(), jalapenos));
        LootItemCondition.Builder peanut = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.PEANUT_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.PEANUT_BLOCK.get(), createCropDrops(ChangShengJueBlocks.PEANUT_BLOCK.get(), ChangShengJueItems.PEANUT.get(), ChangShengJueItems.PEANUT_SEEDS.get(), peanut));
        LootItemCondition.Builder brinjal = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.BRINJAL_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.BRINJAL_BLOCK.get(), createCropDrops(ChangShengJueBlocks.BRINJAL_BLOCK.get(), ChangShengJueItems.BRINJAL.get(), ChangShengJueItems.BRINJAL_SEEDS.get(), brinjal));
        LootItemCondition.Builder grape = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.GRAPE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.GRAPE_BLOCK.get(), createCropDrops(ChangShengJueBlocks.GRAPE_BLOCK.get(), ChangShengJueItems.GRAPE.get(), ChangShengJueItems.GRAPE_SEEDS.get(), grape));
        LootItemCondition.Builder lotus = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.LOTUS_BLOCK.get(), createCropDrops(ChangShengJueBlocks.LOTUS_BLOCK.get(), ChangShengJueItems.LOTUS.get(), ChangShengJueItems.LOTUS_SEEDS.get(), lotus));

        //哈密瓜和哈密瓜藤
        this.add(ChangShengJueBlocks.CANTALOUPE_BLOCK.get(), createSilkTouchDispatchTable(ChangShengJueBlocks.GRAPE_BLOCK.get(),
                LootItem.lootTableItem(ChangShengJueItems.CANTALOUPE.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).apply(LimitCount.limitCount(IntRange.upperBound(9)))));
//        this.add(ChangShengJueBlocks.CANTALOUPE_STEM.get(),createStemDrops(ChangShengJueBlocks.CANTALOUPE_STEM.get(),ChangShengJueItems.CANTALOUPE_SEEDS.get()));
        this.add(ChangShengJueBlocks.CANTALOUPE_STEM.get(), (p_249349_) -> this.createStemDrops(p_249349_, ChangShengJueItems.CANTALOUPE_SEEDS.get()));
        this.add(ChangShengJueBlocks.ATTACHED_CANTALOUPE_STEM.get(), (p_249349_) -> this.createAttachedStemDrops(p_249349_, ChangShengJueItems.CANTALOUPE_SEEDS.get()));

        //花花草草
        this.dropSelf(ChangShengJueBlocks.MUGWORT_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.CUCKOO_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.JASMINE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.TAN_HUA_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.CAPSULE_BLOCK.get());
        LootItemCondition.Builder capsule = cropDrop(ChangShengJueBlocks.CAPSULE_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.CAPSULE_BLOCK.get(), createCropDrops(ChangShengJueBlocks.CAPSULE_BLOCK.get(), ChangShengJueItems.CAPSULE.get(), ChangShengJueItems.CAPSULE.get(), capsule));

        this.add(ChangShengJueBlocks.STIPA_GRANDIS.get(), (block) -> this.createGrassDrops(block));
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(), (block) -> this.createDoublePlantWithSeedDrops(block, ChangShengJueBlocks.STIPA_GRANDIS.get()));
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(), (block) -> this.createDoublePlantWithSeedDrops(block, ChangShengJueBlocks.STIPA_GRANDIS.get()));

        this.add(ChangShengJueBlocks.RED_KNOTWEED.get(), (block) -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(), (block) -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        this.add(ChangShengJueBlocks.RAPE_FLOWERS.get(), (block) -> this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));

        this.dropSelf(ChangShengJueBlocks.SOLIDAGO.get());
        this.dropSelf(ChangShengJueBlocks.GEUM_TRIFLORUM.get());
        this.dropSelf(ChangShengJueBlocks.PURPLE_DANDELION.get());

        //花盆和盆栽花
        this.dropSelf(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get());
        this.add(ChangShengJueBlocks.POTTED_MUGWORT_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.MUGWORT_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_CUCKOO_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.CUCKOO_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_JASMINE_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.JASMINE_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK.get(),createPotFlowerItemTable(ChangShengJueBlocks.TAN_HUA_BLOCK.get()));
        this.add(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),createPotFlowerItemTable(ChangShengJueBlocks.SOLIDAGO.get()));
        this.add(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),createPotFlowerItemTable(ChangShengJueBlocks.GEUM_TRIFLORUM.get()));
        this.add(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),createPotFlowerItemTable(ChangShengJueBlocks.PURPLE_DANDELION.get()));

        //建筑
        this.dropSelf(ChangShengJueBlocks.ZHU_TAI_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.HANG_TU_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.TU_PEI_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get());
        this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(), (p_251015_) -> this.createSingleItemTableWithSilkTouch(p_251015_, ChangShengJueBlocks.STONE_LAMPS_BLOCK.get()));
        this.dropSelf(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get());
        this.dropSelf(ChangShengJueBlocks.TILE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.TILE_BLOCK_4.get());
        this.add(ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.DOOR_OAK_BLOCK.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get(), (door) -> this.createDoorTable(door));
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get());
        this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_2.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_2.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_2.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_2.get(), (door) -> this.createDoorTable(door));
        this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_2.get(), (door) -> this.createDoorTable(door));
        //方块
        this.dropSelf(ChangShengJueBlocks.HANG_TU_WALL.get());
        this.dropSelf(ChangShengJueBlocks.TU_PEI_WALL.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_FINE_BRICKS.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_BRICKS.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_STONE_BRICKS.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_STONE_BRICKS.get());
        this.dropSelf(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.HANG_TU_STAIRS.get());
        this.dropSelf(ChangShengJueBlocks.TU_PEI_STAIRS.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get());
        this.dropSelf(ChangShengJueBlocks.HANG_TU_SLAB.get());
        this.dropSelf(ChangShengJueBlocks.TU_PEI_SLAB.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get());

        this.dropSelf(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get());

        //织布机
        this.dropSelf(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get());
        //陶轮
        this.dropSelf(ChangShengJueBlocks.POTTERY_WHEEL.get());
        //工具台
        this.dropSelf(ChangShengJueBlocks.TOOL_TABLE.get());
        //案台
        this.dropSelf(ChangShengJueBlocks.DESK.get());
        //猪食槽
        this.dropSelf(ChangShengJueBlocks.PIG_TROUGH.get());
        //画轴(小)
        this.dropSelf(ChangShengJueBlocks.PAINTING_SCROLL.get());
        //画轴(竖)
        this.dropSelf(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get());
        //画轴(横)
        this.dropSelf(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get());
        //画轴(大)
        this.dropSelf(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get());
    }

    public LootItemCondition.Builder cropDrop(Block blocks, int age) {
        return LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(blocks)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, age));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ChangShengJueBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
