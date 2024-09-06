package com.shengchanshe.changshengjue.datagen.loot;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.block.custom_cropper.CornBlock;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class CSJBlockLootTables extends BlockLootSubProvider {
    public CSJBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ChangShengJueBlocks.BANANA_LOG.get());

        this.add(ChangShengJueBlocks.AG_ORE.get(),
                (block -> createOreDrop(ChangShengJueBlocks.AG_ORE.get(), ChangShengJueItems.RAW_AG.get())));
        this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(),
                (block -> createOreDrop(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), ChangShengJueItems.RAW_AG.get())));

        this.dropSelf(ChangShengJueBlocks.MANGO_LEAVES.get());
        //农作物
        LootItemCondition.Builder pineapple = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.PINEAPPLE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder soybean = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.SOYBEAN_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder tomato = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.TOMATO_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder GuZi = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.GU_ZI_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder sorghum = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.SORGHUM_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,6))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.SORGHUM_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7)));
        LootItemCondition.Builder redbean = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.REDBEAN_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder cotton = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.COTTON_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder stickyrice = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.STICKYRICE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder corn = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.CORN_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,6))
                .or(LootItemBlockStatePropertyCondition.hasBlockStateProperties(ChangShengJueBlocks.CORN_BLOCK.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7)));
        LootItemCondition.Builder jalapenos = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.JALAPENOS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder peanut = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.PEANUT_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder brinjal = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.BRINJAL_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));
        LootItemCondition.Builder grape = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ChangShengJueBlocks.GRAPE_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornBlock.AGE,7));


        this.add(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(),createCropDrops(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(),
                ChangShengJueItems.PINEAPPLE.get(),ChangShengJueItems.PINEAPPLE_SEEDS.get(), pineapple));
        this.add(ChangShengJueBlocks.SOYBEAN_BLOCK.get(),createCropDrops(ChangShengJueBlocks.SOYBEAN_BLOCK.get(),
                ChangShengJueItems.SOYBEAN.get(),ChangShengJueItems.SOYBEAN.get(), soybean));
        this.add(ChangShengJueBlocks.TOMATO_BLOCK.get(),createCropDrops(ChangShengJueBlocks.TOMATO_BLOCK.get(),
                ChangShengJueItems.TOMATO.get(),ChangShengJueItems.TOMATO_SEEDS.get(), tomato));
        this.add(ChangShengJueBlocks.GU_ZI_BLOCK.get(),createCropDrops(ChangShengJueBlocks.GU_ZI_BLOCK.get(),
                ChangShengJueItems.GU_SUI.get(),ChangShengJueItems.GU_SEEDS.get(), GuZi));
        this.add(ChangShengJueBlocks.SORGHUM_BLOCK.get(),createCropDrops(ChangShengJueBlocks.SORGHUM_BLOCK.get(),
                ChangShengJueItems.SORGHUM.get(),ChangShengJueItems.SORGHUM_SEEDS.get(), sorghum));
        this.add(ChangShengJueBlocks.REDBEAN_BLOCK.get(),createCropDrops(ChangShengJueBlocks.REDBEAN_BLOCK.get(),
                ChangShengJueItems.REDBEAN.get(),ChangShengJueItems.SORGHUM_SEEDS.get(), redbean));
        this.add(ChangShengJueBlocks.COTTON_BLOCK.get(),createCropDrops(ChangShengJueBlocks.COTTON_BLOCK.get(),
                ChangShengJueItems.COTTON.get(),ChangShengJueItems.COTTON_SEEDS.get(), cotton));
        this.add(ChangShengJueBlocks.STICKYRICE_BLOCK.get(),createCropDrops(ChangShengJueBlocks.STICKYRICE_BLOCK.get(),
                ChangShengJueItems.STICKYRICE.get(),ChangShengJueItems.STICKYRICE_SEEDS.get(), stickyrice));
        this.add(ChangShengJueBlocks.CORN_BLOCK.get(),createCropDrops(ChangShengJueBlocks.CORN_BLOCK.get(),
                ChangShengJueItems.CORN.get(),ChangShengJueItems.CORN_SEEDS.get(), corn));
        this.add(ChangShengJueBlocks.JALAPENOS_BLOCK.get(),createCropDrops(ChangShengJueBlocks.JALAPENOS_BLOCK.get(),
                ChangShengJueItems.JALAPENOS.get(),ChangShengJueItems.JALAPENOS_SEEDS.get(), jalapenos));
        this.add(ChangShengJueBlocks.PEANUT_BLOCK.get(),createCropDrops(ChangShengJueBlocks.PEANUT_BLOCK.get(),
                ChangShengJueItems.PEANUT.get(),ChangShengJueItems.PEANUT_SEEDS.get(), peanut));
        this.add(ChangShengJueBlocks.BRINJAL_BLOCK.get(),createCropDrops(ChangShengJueBlocks.BRINJAL_BLOCK.get(),
                ChangShengJueItems.BRINJAL.get(),ChangShengJueItems.BRINJAL_SEEDS.get(), brinjal));
        this.add(ChangShengJueBlocks.GRAPE_BLOCK.get(),createCropDrops(ChangShengJueBlocks.GRAPE_BLOCK.get(),
                ChangShengJueItems.GRAPE.get(),ChangShengJueItems.GRAPE_SEEDS.get(), grape));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ChangShengJueBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
