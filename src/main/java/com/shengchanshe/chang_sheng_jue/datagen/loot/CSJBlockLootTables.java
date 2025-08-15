package com.shengchanshe.chang_sheng_jue.datagen.loot;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.RoofPart;
import com.shengchanshe.chang_sheng_jue.block.cropper.*;
import com.shengchanshe.chang_sheng_jue.block.custom.DoorsBlock;
import com.shengchanshe.chang_sheng_jue.block.custom.bracket.ChineseBracketLong;
import com.shengchanshe.chang_sheng_jue.block.custom.tile.HippedRoof;
import com.shengchanshe.chang_sheng_jue.block.tree_logs.FruitLeaves;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.Tags;
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
        //芒果
        this.dropSelf(ChangShengJueBlocks.MANGO_LOG.get());
        this.dropSelf(ChangShengJueBlocks.MANGO_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.MANGO_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.MANGO_SAPLING.get());
//        this.createLeavesFruitsDrops(ChangShengJueBlocks.MANGO_LEAVES.get(),ChangShengJueItems.MANGO.get(),ChangShengJueBlocks.MANGO_SAPLING.get());
        this.add(ChangShengJueBlocks.MANGO_LEAVES.get(),
                (block) -> this.createLeavesDrops(block,ChangShengJueBlocks.MANGO_SAPLING.get(),ChangShengJueItems.MANGO.get(),NORMAL_LEAVES_SAPLING_CHANCES));

        //香蕉
        this.dropSelf(ChangShengJueBlocks.BANANA_LOG.get());
        this.dropSelf(ChangShengJueBlocks.BANANA_SAPLING.get());
        this.add(ChangShengJueBlocks.BANANA_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.BANANA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ChangShengJueBlocks.BANANA_FRUIT.get(), (createSilkTouchDispatchTable(ChangShengJueBlocks.BANANA_FRUIT.get(),
                LootItem.lootTableItem(ChangShengJueItems.BANANA.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F))))));
        //梨
//        this.createLeavesFruitsDrops(ChangShengJueBlocks.PEAR_LEAVES.get(),ChangShengJueItems.PEAR.get(),ChangShengJueBlocks.PEAR_SAPLING.get());
        this.dropSelf(ChangShengJueBlocks.PEAR_LOG.get());
        this.dropSelf(ChangShengJueBlocks.PEAR_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.PEAR_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.PEAR_SAPLING.get());
        this.add(ChangShengJueBlocks.PEAR_LEAVES.get(), (block) -> this.createLeavesDrops(block,ChangShengJueBlocks.PEAR_SAPLING.get(),ChangShengJueItems.PEAR.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        //荔枝
        this.dropSelf(ChangShengJueBlocks.LICHEE_LOG.get());
        this.dropSelf(ChangShengJueBlocks.LICHEE_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.LICHEE_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.LICHEE_SAPLING.get());
//        this.createLeavesFruitsDrops(ChangShengJueBlocks.LICHEE_LEAVES.get(),ChangShengJueItems.LICHEE.get(),ChangShengJueBlocks.LICHEE_SAPLING.get());
        this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(),
                (block) -> this.createLeavesDrops(block,ChangShengJueBlocks.LICHEE_SAPLING.get(),ChangShengJueItems.LICHEE.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        //榴莲
        this.dropSelf(ChangShengJueBlocks.DURIAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.DURIAN_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.DURIAN_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.DURIAN_SAPLING.get());
//        this.createLeavesFruitsDrops(ChangShengJueBlocks.DURIAN_LEAVES.get(),ChangShengJueItems.DURIAN.get(),ChangShengJueBlocks.DURIAN_SAPLING.get());
        this.add(ChangShengJueBlocks.DURIAN_LEAVES.get(),
                (block) -> this.createLeavesDrops(block,ChangShengJueBlocks.DURIAN_SAPLING.get(),ChangShengJueItems.DURIAN.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ChangShengJueBlocks.DURIAN.get(), block ->
                createSilkTouchDispatchTable(
                        block,
                        LootItem.lootTableItem(ChangShengJueItems.DURIAN_MEAT.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 7.0F)))
                )
        );
        //桂花树
        this.dropSelf(ChangShengJueBlocks.OSMANTHUS_LOG.get());
        this.dropSelf(ChangShengJueBlocks.OSMANTHUS_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.OSMANTHUS_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.OSMANTHUS_SAPLING.get());
        this.add(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.OSMANTHUS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ChangShengJueBlocks.OSMANTHUS_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.OSMANTHUS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES).
                withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionCondition(block, LootItem.lootTableItem(ChangShengJueItems.GUI_HUA.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.2F, 0.3F, 0.4F, 0.7F, 0.8F)))));
        // 梅花
        this.dropSelf(ChangShengJueBlocks.PLUM_LOG.get());
        this.dropSelf(ChangShengJueBlocks.PLUM_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.PLUM_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.PLUM_SAPLING.get());
        this.add(ChangShengJueBlocks.PLUM_DEFOLIATION.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.PLUM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ChangShengJueBlocks.PLUM_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.PLUM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES).
                withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(this.applyExplosionCondition(block, LootItem.lootTableItem(ChangShengJueItems.MEI_HUA.get()))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.2F, 0.3F, 0.4F, 0.7F, 0.8F)))));
        //黄花梨
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get());
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),
                (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        //鸡翅木
        this.dropSelf(ChangShengJueBlocks.WENGE_LOG.get());
        this.dropSelf(ChangShengJueBlocks.WENGE_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.WENGE_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.WENGE_SAPLING.get());
        this.add(ChangShengJueBlocks.WENGE_LEAVES.get(),
                (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.WENGE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        //紫檀
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_SAPLING.get());
        this.add(ChangShengJueBlocks.ZI_TAN_LEAVES.get(),
                (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.ZI_TAN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        //白杨树
        this.dropSelf(ChangShengJueBlocks.POPLAR_LOG.get());
        this.dropSelf(ChangShengJueBlocks.POPLAR_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.POPLAR_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.POPLAR_SAPLING.get());
        this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.POPLAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(), (block) -> this.createLeavesDrops(block, ChangShengJueBlocks.POPLAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        //桑树
        this.dropSelf(ChangShengJueBlocks.MULBERRY_LOG.get());
        this.dropSelf(ChangShengJueBlocks.MULBERRY_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get());
        this.dropSelf(ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get());
        this.dropSelf(ChangShengJueBlocks.MULBERRY_PLANKS.get());
        this.dropSelf(ChangShengJueBlocks.MULBERRY_SAPLING.get());
        this.createMulberryLeavesDrops(ChangShengJueBlocks.MULBERRY_LEAVES.get(),ChangShengJueItems.MULBERRY.get(),ChangShengJueBlocks.MULBERRY_SAPLING.get(),ChangShengJueItems.NATURAL_SILK.get(),ChangShengJueItems.SILKWORM.get());
        //矿石
        this.add(ChangShengJueBlocks.AG_ORE.get(),
                (block -> createOreDrop(ChangShengJueBlocks.AG_ORE.get(), ChangShengJueItems.RAW_AG.get())));
        this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(),
                (block -> createOreDrop(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), ChangShengJueItems.RAW_AG.get())));

        this.dropSelf(ChangShengJueBlocks.KAOLIN_ORE.get());

        this.dropSelf(ChangShengJueBlocks.LIMESTONE.get());

        this.dropSelf(ChangShengJueBlocks.SYDEROLIFE_ORE.get());

        //农作物
        LootItemCondition.Builder pineapple = cropDrop(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), ChangShengJueItems.PINEAPPLE.get(), ChangShengJueItems.PINEAPPLE_SEEDS.get(),0, pineapple));
        LootItemCondition.Builder soybean = cropDrop(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), ChangShengJueItems.SOYBEAN.get(), ChangShengJueItems.SOYBEAN.get(), soybean,2));
        LootItemCondition.Builder tomato = cropDrop(ChangShengJueBlocks.TOMATO_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.TOMATO_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.TOMATO_BLOCK.get(), ChangShengJueItems.TOMATO.get(), ChangShengJueItems.TOMATO_SEEDS.get(), tomato,3));
        LootItemCondition.Builder GuZi = cropDrop(ChangShengJueBlocks.GU_ZI_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.GU_ZI_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.GU_ZI_BLOCK.get(), ChangShengJueItems.GU_SUI.get(), ChangShengJueItems.GU_SEEDS.get(), GuZi,2));
        LootItemCondition.Builder sorghum = cropDrop(ChangShengJueBlocks.SORGHUM_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.SORGHUM_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.SORGHUM_BLOCK.get(), ChangShengJueItems.SORGHUM.get(), ChangShengJueItems.SORGHUM_SEEDS.get(), sorghum,1));
        LootItemCondition.Builder redbean = cropDrop(ChangShengJueBlocks.REDBEAN_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.REDBEAN_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.REDBEAN_BLOCK.get(), ChangShengJueItems.REDBEAN.get(), ChangShengJueItems.SORGHUM_SEEDS.get(), redbean,3));
        LootItemCondition.Builder cotton = cropDrop(ChangShengJueBlocks.COTTON_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.COTTON_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.COTTON_BLOCK.get(), ChangShengJueItems.COTTON.get(), ChangShengJueItems.COTTON_SEEDS.get(), cotton,2));
        LootItemCondition.Builder stickyrice = cropDrop(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), ChangShengJueItems.STICKYRICE.get(), ChangShengJueItems.STICKYRICE_SEEDS.get(), stickyrice,3));
        LootItemCondition.Builder corn = cropDrop(ChangShengJueBlocks.CORN_BLOCK.get(), 7);
//                LootItemBlockStatePropertyCondition
//                .hasBlockStateProperties(ChangShengJueBlocks.CORN_BLOCK.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 6))
//                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.CORN_BLOCK.get())
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7)));
        this.add(ChangShengJueBlocks.CORN_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.CORN_BLOCK.get(), ChangShengJueItems.CORN.get(), ChangShengJueItems.CORN_SEEDS.get(), corn,1));
        LootItemCondition.Builder jalapenos = cropDrop(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), ChangShengJueItems.JALAPENOS.get(), ChangShengJueItems.JALAPENOS_SEEDS.get(), jalapenos,3));
        LootItemCondition.Builder peanut = cropDrop(ChangShengJueBlocks.PEANUT_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.PEANUT_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.PEANUT_BLOCK.get(), ChangShengJueItems.PEANUT.get(), ChangShengJueItems.PEANUT_SEEDS.get(), peanut,3));
        LootItemCondition.Builder brinjal = cropDrop(ChangShengJueBlocks.BRINJAL_BLOCK.get(), 7);
        this.add(ChangShengJueBlocks.BRINJAL_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.BRINJAL_BLOCK.get(), ChangShengJueItems.BRINJAL.get(), ChangShengJueItems.BRINJAL_SEEDS.get(), brinjal,3));
        LootItemCondition.Builder grape =  LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.GRAPE_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 6))
                .or(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ChangShengJueBlocks.GRAPE_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7)));
        this.add(ChangShengJueBlocks.GRAPE_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.GRAPE_BLOCK.get(), ChangShengJueItems.GRAPE.get(), ChangShengJueItems.GRAPE_SEEDS.get(),6, grape));


        LootItemCondition.Builder lotus0 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 0))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 1)));
        LootItemCondition.Builder lotus1 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 2))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 3)));
        LootItemCondition.Builder lotus2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 4))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 5)));
        LootItemCondition.Builder lotus3 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 6));
        LootItemCondition.Builder lotus4 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.LOTUS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE, 7));
        this.add(ChangShengJueBlocks.LOTUS_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.LOTUS_BLOCK.get(), ChangShengJueItems.LOTUS_ROOT.get(), ChangShengJueItems.LOTUS_SEEDS.get(),lotus0,lotus1, lotus2,lotus3,lotus4));

        LootItemCondition.Builder rice = cropDrop(ChangShengJueBlocks.RICE.get(), 7);
        this.add(ChangShengJueBlocks.RICE.get(), this.createCropDrops(ChangShengJueBlocks.RICE.get(),ChangShengJueItems.RICE.get(),ChangShengJueItems.RICE_SEEDS.get(),rice,2));

        LootItemCondition.Builder biluochunTea = cropDrop(ChangShengJueBlocks.BILUOCHUN_TEA.get(), 7);
        this.add(ChangShengJueBlocks.BILUOCHUN_TEA.get(),
                this.createCropDrops(ChangShengJueBlocks.BILUOCHUN_TEA.get(),ChangShengJueItems.BILUOCHUN_TEA.get(),ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get(),biluochunTea,1,4,0,1));

        LootItemCondition.Builder longJingTea =cropDrop(ChangShengJueBlocks.LONG_JING_TEA.get(), 7);
        this.add(ChangShengJueBlocks.LONG_JING_TEA.get(),
                this.createCropDrops(ChangShengJueBlocks.LONG_JING_TEA.get(),ChangShengJueItems.LONG_JING_TEA.get(),ChangShengJueItems.LONG_JING_TEA_SEEDS.get(),longJingTea,1,4,0,1));

        LootItemCondition.Builder hordeum = cropDrop(ChangShengJueBlocks.HORDEUM.get(), 7);
        this.add(ChangShengJueBlocks.HORDEUM.get(), this.createCropDrops(ChangShengJueBlocks.HORDEUM.get(), ChangShengJueItems.HORDEUM.get(), ChangShengJueItems.HORDEUM_SEEDS.get(), hordeum,3));

        LootItemCondition.Builder wildlifeHordeum = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.WILDLIFE_HORDEUM.get());
        this.add(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(), this.createCropDrops(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(), ChangShengJueItems.HORDEUM.get(), ChangShengJueItems.HORDEUM_SEEDS.get(), wildlifeHordeum,2));

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
        this.add(ChangShengJueBlocks.CAPSULE_BLOCK.get(), this.createCropDrops(ChangShengJueBlocks.CAPSULE_BLOCK.get(), ChangShengJueItems.CAPSULE.get(), ChangShengJueItems.CAPSULE.get(), capsule));

        this.add(ChangShengJueBlocks.STIPA_GRANDIS.get(), (block) -> this.createGrassDrops(block));
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, ChangShengJueItems.THATCH.get()));
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
        this.dropSelf(ChangShengJueBlocks.ZHU_TAI.get());
        this.dropSelf(ChangShengJueBlocks.HANG_TU_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.TU_PEI_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get());
        this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(), (block) -> this.createSingleItemTableWithSilkTouch(block, ChangShengJueBlocks.STONE_LAMPS_BLOCK.get()));
        this.dropSelf(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get());

        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get());
        this.dropSelf(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get());
        //脊兽脊瓦
        this.dropSelf(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get());
        //垂兽脊瓦
        this.dropSelf(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get());
        this.dropSelf(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get());
        //屋脊
        this.dropSelf(ChangShengJueBlocks.GRE_ROOF_RIDGE.get());
        this.dropSelf(ChangShengJueBlocks.RED_ROOF_RIDGE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get());
        //鸱吻
        this.dropSelf(ChangShengJueBlocks.GRE_DEMON_MASK.get());
        this.dropSelf(ChangShengJueBlocks.RED_DEMON_MASK.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_DEMON_MASK.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_DEMON_MASK.get());
        //脊刹
        this.dropSelf(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get());
        //垂脊筒瓦
        this.dropSelf(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());

        this.dropSelf(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_HIGH_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.RED_HIGH_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_HIGH_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_HIGH_CYLINDER_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_HIGH_CYLINDER_TILE_SIDE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get());

        this.dropSelf(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
        this.dropSelf(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());

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
        this.add(ChangShengJueBlocks.DOOR_BIRCH.get(), block -> this.createSinglePropConditionTable(block, DoorsBlock.PART, RoofPart.MIDDLE));
        this.add(ChangShengJueBlocks.DOOR_ACACIA.get(),  block -> this.createSinglePropConditionTable(block, DoorsBlock.PART, RoofPart.MIDDLE));
        this.add(ChangShengJueBlocks.DOOR_DARK_OAK.get(),  block -> this.createSinglePropConditionTable(block, DoorsBlock.PART, RoofPart.MIDDLE));
        this.add(ChangShengJueBlocks.DOOR_OAK.get(),  block -> this.createSinglePropConditionTable(block, DoorsBlock.PART, RoofPart.MIDDLE));
        this.add(ChangShengJueBlocks.DOOR_SPRUCE.get(),  block -> this.createSinglePropConditionTable(block, DoorsBlock.PART, RoofPart.MIDDLE));
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get());
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
        this.add(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get(), this::createDoorTable);
        this.add(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get(), this::createDoorTable);
        this.add(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get(), this::createDoorTable);
        this.add(ChangShengJueBlocks.HIGH_OAK_WINDOWS.get(), this::createDoorTable);
        this.add(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get(), this::createDoorTable);
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
        this.dropSelf(ChangShengJueBlocks.MANGROVE_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.BIRCH_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.JUNGLE_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.OAK_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_OVERLORD_FIST.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get());
        this.dropSelf(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get());
        this.add(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.BIRCH_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.WARPED_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.ACACIA_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.OAK_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.CHERRY_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.GREEN_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));
        this.add(ChangShengJueBlocks.BLUE_DOUGONG.get(), block ->
                this.createBooleanConditionTable(block, ChineseBracketLong.MAIN_PART, true));


        this.dropSelf(ChangShengJueBlocks.WHITE_JADE_BLOCK.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_JADE_STAIRS.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_JADE_SLAB.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_JADE_WALL.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.OAK_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.BIRCH_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.JUNGLE_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.MANGROVE_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_BALUSTRADE.get());
        this.dropSelf(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get());

        //织布机
        this.dropSelf(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get());
        //陶轮
        this.dropSelf(ChangShengJueBlocks.POTTERY_WHEEL.get());
        //工具台
        this.dropSelf(ChangShengJueBlocks.TOOL_TABLE.get());
        //武器架
        this.dropSelf(ChangShengJueBlocks.WEAPON_RACK.get());
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
        //风铃
        this.dropSelf(ChangShengJueBlocks.WIND_CHIME.get());

        //城门
        this.dropSelf(ChangShengJueBlocks.SHING_MUN_LEFT.get());
        this.dropSelf(ChangShengJueBlocks.SHING_MUN_RIGHT.get());
        this.dropSelf(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get());
        this.dropSelf(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get());
        //牌匾
        this.dropSelf(ChangShengJueBlocks.PLAQUE.get());

        this.dropSelf(ChangShengJueBlocks.GONG.get());

        //模具
        this.dropSelf(ChangShengJueBlocks.CASTING_MOLDS.get());
        this.dropSelf(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get());

        //家具
        //长凳
        this.dropSelf(ChangShengJueBlocks.BIRCH_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.MANGROVE_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.OAK_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_BENCH.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_BENCH.get());
        //酒桌
        this.dropSelf(ChangShengJueBlocks.BIRCH_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.OAK_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get());
        //酒桌椅
        this.dropSelf(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get());
        //书桌
        this.dropSelf(ChangShengJueBlocks.BIRCH_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.OAK_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get());
        //茶几
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_TEAPOY.get());
        //太师椅
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get());
        //五围屏宝座
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get());
        //席桌
        this.dropSelf(ChangShengJueBlocks.BIRCH_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.CRIMSON_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.WARPED_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.MANGROVE_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.ACACIA_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.OAK_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.CHERRY_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.SPRUCE_LOW_DESK.get());
        this.dropSelf(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get());
        //蒲团
        this.dropSelf(ChangShengJueBlocks.ZAFU.get());

        //食物
        this.dropSelf(ChangShengJueBlocks.CI_PAN.get());
        this.dropSelf(ChangShengJueBlocks.CI_WAN.get());
        this.dropSelf(ChangShengJueBlocks.CI_BEI.get());
        this.dropSelf(ChangShengJueBlocks.CORN.get());
        this.dropSelf(ChangShengJueBlocks.BAKED_CORN.get());
        this.dropSelf(ChangShengJueBlocks.PEAR.get());
        this.dropSelf(ChangShengJueBlocks.PINEAPPLE.get());
        this.dropSelf(ChangShengJueBlocks.MANGO.get());
        this.dropSelf(ChangShengJueBlocks.LICHEE.get());
        this.dropSelf(ChangShengJueBlocks.BANANA.get());
        this.dropSelf(ChangShengJueBlocks.GRAPE.get());
        this.dropSelf(ChangShengJueBlocks.MULBERRY.get());
        /*容器食用*/
        //盘
        this.dropSelf(ChangShengJueBlocks.ZHENG_CAI.get());
        this.dropSelf(ChangShengJueBlocks.TOMATO_EGG.get());
        this.dropSelf(ChangShengJueBlocks.GU_LAO_ROU.get());
        this.dropSelf(ChangShengJueBlocks.MEAT_FOAM_BRINJAL.get());
        this.dropSelf(ChangShengJueBlocks.STINKY_TOFU.get());
        this.dropSelf(ChangShengJueBlocks.GUI_HUA_TANG_OU.get());
        //碗
        this.dropSelf(ChangShengJueBlocks.HOT_PEAR_SOUP.get());
        this.dropSelf(ChangShengJueBlocks.ZHU_DU_JI.get());
        this.dropSelf(ChangShengJueBlocks.BA_BAO_ZHOU.get());
        //杯
        this.dropSelf(ChangShengJueBlocks.BILUOCHUN_TEAS.get());
        this.dropSelf(ChangShengJueBlocks.LONG_JING_TEAS.get());
        this.dropSelf(ChangShengJueBlocks.GRAPE_JUICE.get());
        this.dropSelf(ChangShengJueBlocks.APPLE_JUICE.get());
        this.dropSelf(ChangShengJueBlocks.MULBERRY_JUICE.get());
        this.dropSelf(ChangShengJueBlocks.FEN_JIU.get());
        this.dropSelf(ChangShengJueBlocks.SHI_LI_XIANG.get());
        this.dropSelf(ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get());
        //裁衣案
        this.dropSelf(ChangShengJueBlocks.TAILORING_CASE.get());
        this.dropSelf(ChangShengJueBlocks.FORGE_BLOCK.get());
        this.add(ChangShengJueBlocks.EMPTY_FEN_JIU.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.EMPTY_FEN_JIU.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );




        this.add(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.EMPTY_FEN_JIU.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.EMPTY_FEN_JIU.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );

        /*直接食用*/
        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_PAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_WAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.CAPSULE_JIAO_ZI.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_PAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.CAPSULE_JIAO_ZI.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_WAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.QING_TUAN_PAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.QING_TUAN.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_PAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.QING_TUAN_WAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.QING_TUAN.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_WAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.SORGHUM_CAKE.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_PAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.SORGHUM_CAKE.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_WAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.MI_FAN_PAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.MI_FAN.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_PAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.MI_FAN_WAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.MI_FAN.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_WAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        //xiao_mi_fan_pan
        this.add(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.XIAO_MI_FAN.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_PAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );
        this.add(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueItems.XIAO_MI_FAN.get())))
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(ChangShengJueBlocks.CI_WAN.get())))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))
        );

        //台阶/瓦
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get()));
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get()));
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get()));
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get()));
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get()));

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get()));
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get()));
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get()));
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get()));
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get()));

        this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get()));
        this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get()));
        this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get()));
        this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get()));
        this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get()));


        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get()));
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get()));
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get()));
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get()));
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get()));

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get()));
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get()));
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get()));
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get()));
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(),
                block -> createSlabItemTable(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get()));

        //攒尖
        this.add(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), HippedRoof.PART ,RoofPart.BOTTOM));
        this.add(ChangShengJueBlocks.RED_HIPPED_ROOF.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), HippedRoof.PART ,RoofPart.BOTTOM));
        this.add(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), HippedRoof.PART ,RoofPart.BOTTOM));
        this.add(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), HippedRoof.PART ,RoofPart.BOTTOM));
        this.add(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), HippedRoof.PART ,RoofPart.BOTTOM));

        this.add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(), HippedRoof.PART ,RoofPart.BOTTOM));
        this.add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),
                block -> this.createSinglePropConditionTable(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(), HippedRoof.PART ,RoofPart.BOTTOM));
    }


    public void createLeavesFruitsDrops(Block leavesBlock, Item fruitsItem,Block sapling){
        var leaves = LootItem.lootTableItem(leavesBlock)
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).or(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))));
        var fruits = LootItem.lootTableItem(fruitsItem)
                .when(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(leavesBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(FruitLeaves.STATE, FruitLeaves.State.FRUITS)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1));
        var saplings = LootItem.lootTableItem(sapling)
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                        0.2F, 0.3F, 0.4F, 0.7F, 0.8F));
        var drops = AlternativesEntry.alternatives(leaves, fruits, saplings);
        this.add(leavesBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(drops)
                .when(ExplosionCondition.survivesExplosion())));
    }
    //树苗掉落
    public LootTable.Builder createLeavesDrops(Block pOakLeavesBlock, Block pSaplingBlock, Item fruitsItem, float... pChances) {
        return this.createLeavesDrops(pOakLeavesBlock, pSaplingBlock, pChances)
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)
                        .add(((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(pOakLeavesBlock, LootItem.lootTableItem(fruitsItem)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }
    public void createMulberryLeavesDrops(Block leavesBlock, Item fruitsItem, Block sapling, Item stateItem, Item stateItem1) {
        LootPoolEntryContainer.Builder<?> leaves = LootItem.lootTableItem(leavesBlock)
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))))
                        .or(MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))));

        // 蚕丝掉落
        LootPoolEntryContainer.Builder<?> state = LootItem.lootTableItem(stateItem)
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leavesBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(FruitLeaves.STATE, FruitLeaves.State.FRUITS)))
                .when(LootItemRandomChanceCondition.randomChance(0.25F))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE));
        // 蚕掉落
        LootPoolEntryContainer.Builder<?> state1 = LootItem.lootTableItem(stateItem1)
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leavesBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(FruitLeaves.STATE, FruitLeaves.State.FRUITS)))
                .when(LootItemRandomChanceCondition.randomChance(0.05F))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE));

        // 树苗掉落
        LootPoolEntryContainer.Builder<?> saplings = LootItem.lootTableItem(sapling)
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leavesBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(FruitLeaves.STATE, FruitLeaves.State.LEAVES)))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                        Enchantments.BLOCK_FORTUNE, 0.2F, 0.3F, 0.4F, 0.7F, 0.8F));

        // 果实掉落
        LootPoolEntryContainer.Builder<?> fruits = LootItem.lootTableItem(fruitsItem)
                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(leavesBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(FruitLeaves.STATE, FruitLeaves.State.LEAVES)))
                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                        Enchantments.BLOCK_FORTUNE, 0.05F, 0.06F, 0.07F, 0.08F, 0.09F));

        LootPoolEntryContainer.Builder<?> drops = AlternativesEntry.alternatives(leaves, state, fruits, saplings, state1);

        this.add(leavesBlock,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(drops)
                                .when(ExplosionCondition.survivesExplosion())));
    }

    protected LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem,LootItemCondition.Builder pDropGrownCropCondition0,
                                                LootItemCondition.Builder pDropGrownCropCondition1,LootItemCondition.Builder pDropGrownCropCondition2,
                                                LootItemCondition.Builder pDropGrownCropCondition3,LootItemCondition.Builder pDropGrownCropCondition4) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition0).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 1)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 2)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition2).apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 3)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition3).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 4)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition4).apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 7)))))

                .withPool(LootPool.lootPool().when(pDropGrownCropCondition4).add(LootItem.lootTableItem(pSeedsItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 4))))));
    }


    protected LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem,LootItemCondition.Builder pDropGrownCropCondition,int fruitsMin,int fruitsMax,int seedsMin,int seedsMax) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem)
                        .when(pDropGrownCropCondition)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(fruitsMin, fruitsMax))).otherwise(LootItem.lootTableItem(pSeedsItem))))
                .withPool(LootPool.lootPool()
                        .when(pDropGrownCropCondition)
                        .add(LootItem.lootTableItem(pSeedsItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(seedsMin, seedsMax))))));
    }

    protected LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem,int pExtraRounds1, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pGrownCropItem)
                                .when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pSeedsItem)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, pExtraRounds1)))));

    }

    protected LootTable.Builder createCropDrops(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition,int pExtraRounds) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(pGrownCropItem)
                                .when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem))))
                .withPool(LootPool.lootPool()
                        .when(pDropGrownCropCondition)
                        .add(LootItem.lootTableItem(pSeedsItem)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, pExtraRounds)))));

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



    protected LootTable.Builder createBooleanConditionTable(Block block, BooleanProperty property, boolean value) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(block))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(property, value))));
    }
}
