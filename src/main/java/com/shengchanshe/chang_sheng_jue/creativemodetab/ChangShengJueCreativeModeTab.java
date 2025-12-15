package com.shengchanshe.chang_sheng_jue.creativemodetab;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.items.Parcel;
import com.shengchanshe.chang_sheng_jue.item.items.StructureIntelligence;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChangShengJue.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_NATURAL_BLOCKS = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_natural_blocks",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_natural_blocks")).icon(() ->
            new ItemStack(ChangShengJueBlocks.TAN_HUA_BLOCK.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueBlocks.CANTALOUPE_BLOCK.get());
                output.accept(ChangShengJueBlocks.MANGO_LEAVES.get());
                output.accept(ChangShengJueBlocks.MANGO_SAPLING.get());
                output.accept(ChangShengJueBlocks.BANANA_LEAVES.get());
                output.accept(ChangShengJueBlocks.BANANA_SAPLING.get());
                output.accept(ChangShengJueBlocks.PEAR_LEAVES.get());
                output.accept(ChangShengJueBlocks.PEAR_SAPLING.get());
                output.accept(ChangShengJueBlocks.LICHEE_LEAVES.get());
                output.accept(ChangShengJueBlocks.LICHEE_SAPLING.get());
                output.accept(ChangShengJueBlocks.DURIAN_LEAVES.get());
                output.accept(ChangShengJueBlocks.DURIAN_SAPLING.get());
                output.accept(ChangShengJueBlocks.OSMANTHUS_LEAVES.get());
                output.accept(ChangShengJueBlocks.OSMANTHUS_SAPLING.get());
                output.accept(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get());
                output.accept(ChangShengJueBlocks.PLUM_LEAVES.get());
                output.accept(ChangShengJueBlocks.PLUM_SAPLING.get());
                output.accept(ChangShengJueBlocks.PLUM_DEFOLIATION.get());
                output.accept(ChangShengJueBlocks.POPLAR_LEAVES.get());
                output.accept(ChangShengJueBlocks.POPLAR_SAPLING.get());
                output.accept(ChangShengJueBlocks.POPLAR_DEFOLIATION.get());
                output.accept(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get());
                output.accept(ChangShengJueBlocks.MULBERRY_LEAVES.get());
                output.accept(ChangShengJueBlocks.MULBERRY_SAPLING.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get());
                output.accept(ChangShengJueBlocks.WENGE_LEAVES.get());
                output.accept(ChangShengJueBlocks.WENGE_SAPLING.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_LEAVES.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_SAPLING.get());

                output.accept(ChangShengJueBlocks.MUGWORT_BLOCK.get());
                output.accept(ChangShengJueBlocks.CUCKOO_BLOCK.get());
                output.accept(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get());
                output.accept(ChangShengJueBlocks.JASMINE_BLOCK.get());
                output.accept(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get());
                output.accept(ChangShengJueBlocks.TAN_HUA_BLOCK.get());
                output.accept(ChangShengJueBlocks.STIPA_GRANDIS.get());
                output.accept(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get());
                output.accept(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get());
                output.accept(ChangShengJueBlocks.RED_KNOTWEED.get());
                output.accept(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get());
                output.accept(ChangShengJueBlocks.WILDLIFE_HORDEUM.get());
                output.accept(ChangShengJueBlocks.RAPE_FLOWERS.get());
                output.accept(ChangShengJueBlocks.SOLIDAGO.get());
                output.accept(ChangShengJueBlocks.GEUM_TRIFLORUM.get());
                output.accept(ChangShengJueBlocks.PURPLE_DANDELION.get());
                output.accept(ChangShengJueItems.CAPSULE.get());

                output.accept(ChangShengJueItems.PINEAPPLE_SEEDS.get());
                output.accept(ChangShengJueItems.TOMATO_SEEDS.get());
                output.accept(ChangShengJueItems.GU_SEEDS.get());
                output.accept(ChangShengJueItems.SORGHUM_SEEDS.get());
                output.accept(ChangShengJueItems.LOTUS_SEEDS.get());
                output.accept(ChangShengJueItems.COTTON_SEEDS.get());
                output.accept(ChangShengJueItems.STICKYRICE_SEEDS.get());
                output.accept(ChangShengJueItems.CORN_SEEDS.get());
                output.accept(ChangShengJueItems.JALAPENOS_SEEDS.get());
                output.accept(ChangShengJueItems.PEANUT_SEEDS.get());
                output.accept(ChangShengJueItems.BRINJAL_SEEDS.get());
                output.accept(ChangShengJueItems.CANTALOUPE_SEEDS.get());
                output.accept(ChangShengJueItems.GRAPE_SEEDS.get());
                output.accept(ChangShengJueItems.SOYBEAN.get());
                output.accept(ChangShengJueItems.REDBEAN.get());
                output.accept(ChangShengJueItems.RICE_SEEDS.get());
                output.accept(ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get());
                output.accept(ChangShengJueItems.LONG_JING_TEA_SEEDS.get());
                output.accept(ChangShengJueItems.HORDEUM_SEEDS.get());

                output.accept(ChangShengJueBlocks.AG_ORE.get());
                output.accept(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get());
                output.accept(ChangShengJueBlocks.KAOLIN_ORE.get());
                output.accept(ChangShengJueBlocks.LIMESTONE.get());
                output.accept(ChangShengJueBlocks.SYDEROLIFE_ORE.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_BUILDING_BLOCK = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_building_block",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_building_block")).icon(() ->
                    new ItemStack(ChangShengJueBlocks.MANGO_LOG.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueBlocks.MANGO_LOG.get());
                output.accept(ChangShengJueBlocks.MANGO_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get());
                output.accept(ChangShengJueBlocks.MANGO_PLANKS.get());

                output.accept(ChangShengJueBlocks.BANANA_LOG.get());
                output.accept(ChangShengJueBlocks.PEAR_LOG.get());
                output.accept(ChangShengJueBlocks.PEAR_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get());
                output.accept(ChangShengJueBlocks.PEAR_PLANKS.get());

                output.accept(ChangShengJueBlocks.LICHEE_LOG.get());
                output.accept(ChangShengJueBlocks.LICHEE_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get());
                output.accept(ChangShengJueBlocks.LICHEE_PLANKS.get());

                output.accept(ChangShengJueBlocks.DURIAN_LOG.get());
                output.accept(ChangShengJueBlocks.DURIAN_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get());
                output.accept(ChangShengJueBlocks.DURIAN_PLANKS.get());

                output.accept(ChangShengJueBlocks.OSMANTHUS_LOG.get());
                output.accept(ChangShengJueBlocks.OSMANTHUS_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get());
                output.accept(ChangShengJueBlocks.OSMANTHUS_PLANKS.get());

                output.accept(ChangShengJueBlocks.PLUM_LOG.get());
                output.accept(ChangShengJueBlocks.PLUM_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get());
                output.accept(ChangShengJueBlocks.PLUM_PLANKS.get());

                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get());

                output.accept(ChangShengJueBlocks.WENGE_LOG.get());
                output.accept(ChangShengJueBlocks.WENGE_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get());
                output.accept(ChangShengJueBlocks.WENGE_PLANKS.get());

                output.accept(ChangShengJueBlocks.ZI_TAN_LOG.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_PLANKS.get());

                output.accept(ChangShengJueBlocks.POPLAR_LOG.get());
                output.accept(ChangShengJueBlocks.POPLAR_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get());
                output.accept(ChangShengJueBlocks.POPLAR_PLANKS.get());

                output.accept(ChangShengJueBlocks.MULBERRY_LOG.get());
                output.accept(ChangShengJueBlocks.MULBERRY_WOOD.get());
                output.accept(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get());
                output.accept(ChangShengJueBlocks.MULBERRY_PLANKS.get());

                output.accept(ChangShengJueBlocks.HANG_TU_BLOCK.get());
                output.accept(ChangShengJueBlocks.TU_PEI_BLOCK.get());

                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get());
                output.accept(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get());

                output.accept(ChangShengJueBlocks.GRE_EAVES_TILE.get());
                output.accept(ChangShengJueBlocks.RED_EAVES_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_EAVES_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_EAVES_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_EAVES_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_EAVES_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_EAVES_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get());

                output.accept(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.GRE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.RED_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get());
                output.accept(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_ROOF_RIDGE.get());
                output.accept(ChangShengJueBlocks.RED_ROOF_RIDGE.get());
                output.accept(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get());
                output.accept(ChangShengJueBlocks.CYAN_ROOF_RIDGE.get());
                output.accept(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get());
                output.accept(ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get());

                output.accept(ChangShengJueBlocks.GRE_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.RED_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.BLACK_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.CYAN_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.BLUE_DEMON_MASK.get());
                output.accept(ChangShengJueBlocks.PURPLE_DEMON_MASK.get());

                output.accept(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get());
                output.accept(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get());
                output.accept(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get());
                output.accept(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get());
                output.accept(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get());
                output.accept(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get());
                output.accept(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get());

                output.accept(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get());
                output.accept(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get());
                output.accept(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get());
                output.accept(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get());
                output.accept(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get());
                output.accept(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get());

                output.accept(ChangShengJueBlocks.GRE_HIPPED_ROOF.get());
                output.accept(ChangShengJueBlocks.RED_HIPPED_ROOF.get());
                output.accept(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get());
                output.accept(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get());
                output.accept(ChangShengJueBlocks.CYAN_HIPPED_ROOF.get());
                output.accept(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get());
                output.accept(ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get());

                output.accept(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get());
                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get());
                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get());
                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get());

                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get());

                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get());

                output.accept(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());
                output.accept(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get());

                output.accept(ChangShengJueBlocks.GOLDEN_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CORNICES.get());
                output.accept(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get());
                output.accept(ChangShengJueBlocks.BLACK_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_GENTLE_TILE.get());
                output.accept(ChangShengJueBlocks.BLACK_CORNICES.get());
                output.accept(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_4.get());
                output.accept(ChangShengJueBlocks.HANG_TU_WALL.get());
                output.accept(ChangShengJueBlocks.TU_PEI_WALL.get());
                output.accept(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get());
                output.accept(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get());
                output.accept(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get());
                output.accept(ChangShengJueBlocks.WHITE_FINE_BRICKS.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get());
                output.accept(ChangShengJueBlocks.HANG_TU_STAIRS.get());
                output.accept(ChangShengJueBlocks.TU_PEI_STAIRS.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get());
                output.accept(ChangShengJueBlocks.HANG_TU_SLAB.get());
                output.accept(ChangShengJueBlocks.TU_PEI_SLAB.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get());
                output.accept(ChangShengJueBlocks.DOOR_BIRCH.get());
                output.accept(ChangShengJueBlocks.DOOR_ACACIA.get());
                output.accept(ChangShengJueBlocks.DOOR_DARK_OAK.get());
                output.accept(ChangShengJueBlocks.DOOR_OAK.get());
                output.accept(ChangShengJueBlocks.DOOR_SPRUCE.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get());
                output.accept(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get());
                output.accept(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get());
                output.accept(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get());
                output.accept(ChangShengJueBlocks.HIGH_OAK_WINDOWS.get());
                output.accept(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get());
                output.accept(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get());
                output.accept(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get());
                output.accept(ChangShengJueBlocks.SHING_MUN_LEFT.get());
                output.accept(ChangShengJueBlocks.SHING_MUN_RIGHT.get());
                output.accept(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get());
                output.accept(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get());

                output.accept(ChangShengJueBlocks.BIRCH_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.JUNGLE_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.WARPED_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.ACACIA_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.OAK_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.CHERRY_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get());

                output.accept(ChangShengJueBlocks.BIRCH_BENCH.get());
                output.accept(ChangShengJueBlocks.JUNGLE_BENCH.get());
                output.accept(ChangShengJueBlocks.CRIMSON_BENCH.get());
                output.accept(ChangShengJueBlocks.WARPED_BENCH.get());
                output.accept(ChangShengJueBlocks.MANGROVE_BENCH.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_BENCH.get());
                output.accept(ChangShengJueBlocks.ACACIA_BENCH.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_BENCH.get());
                output.accept(ChangShengJueBlocks.OAK_BENCH.get());
                output.accept(ChangShengJueBlocks.CHERRY_BENCH.get());
                output.accept(ChangShengJueBlocks.SPRUCE_BENCH.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_BENCH.get());

                output.accept(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.JUNGLE_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get());

                output.accept(ChangShengJueBlocks.BIRCH_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.JUNGLE_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.WARPED_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.ACACIA_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.OAK_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.CHERRY_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get());

                output.accept(ChangShengJueBlocks.BIRCH_TEAPOY.get());
                output.accept(ChangShengJueBlocks.JUNGLE_TEAPOY.get());
                output.accept(ChangShengJueBlocks.CRIMSON_TEAPOY.get());
                output.accept(ChangShengJueBlocks.WARPED_TEAPOY.get());
                output.accept(ChangShengJueBlocks.MANGROVE_TEAPOY.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get());
                output.accept(ChangShengJueBlocks.WENGE_TEAPOY.get());
                output.accept(ChangShengJueBlocks.ACACIA_TEAPOY.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_TEAPOY.get());
                output.accept(ChangShengJueBlocks.OAK_TEAPOY.get());
                output.accept(ChangShengJueBlocks.CHERRY_TEAPOY.get());
                output.accept(ChangShengJueBlocks.SPRUCE_TEAPOY.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_TEAPOY.get());

                output.accept(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.WARPED_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.WENGE_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.OAK_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get());

                output.accept(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get());

                output.accept(ChangShengJueBlocks.BIRCH_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.JUNGLE_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.CRIMSON_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.WARPED_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.MANGROVE_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.ACACIA_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.OAK_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.CHERRY_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.SPRUCE_LOW_DESK.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get());

                output.accept(ChangShengJueBlocks.LANTERN.get());
                output.accept(ChangShengJueBlocks.WHITE_LANTERN.get());
                output.accept(ChangShengJueBlocks.ORANGE_LANTERN.get());
                output.accept(ChangShengJueBlocks.MAGENTA_LANTERN.get());
                output.accept(ChangShengJueBlocks.LIGHT_BLUE_LANTERN.get());
                output.accept(ChangShengJueBlocks.YELLOW_LANTERN.get());
                output.accept(ChangShengJueBlocks.LIME_LANTERN.get());
                output.accept(ChangShengJueBlocks.PINK_LANTERN.get());
                output.accept(ChangShengJueBlocks.GRAY_LANTERN.get());
                output.accept(ChangShengJueBlocks.LIGHT_GRAY_LANTERN.get());
                output.accept(ChangShengJueBlocks.CYAN_LANTERN.get());
                output.accept(ChangShengJueBlocks.PURPLE_LANTERN.get());
                output.accept(ChangShengJueBlocks.BLUE_LANTERN.get());
                output.accept(ChangShengJueBlocks.BROWN_LANTERN.get());
                output.accept(ChangShengJueBlocks.GREEN_LANTERN.get());
                output.accept(ChangShengJueBlocks.RED_LANTERN.get());
                output.accept(ChangShengJueBlocks.BLACK_LANTERN.get());

                output.accept(ChangShengJueBlocks.BIRCH_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.JUNGLE_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.CRIMSON_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.WARPED_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.MANGROVE_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.WENGE_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.ACACIA_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.OAK_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.CHERRY_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.SPRUCE_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND.get());

                output.accept(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.get());

                output.accept(ChangShengJueBlocks.BIRCH_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.WARPED_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.WENGE_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.ACACIA_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.OAK_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.CHERRY_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL.get());

                output.accept(ChangShengJueBlocks.ZAFU.get());

                output.accept(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.WARPED_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.WENGE_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.get());

                output.accept(ChangShengJueBlocks.BIRCH_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.JUNGLE_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.CRIMSON_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.WARPED_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.MANGROVE_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.WENGE_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.ACACIA_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.OAK_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.CHERRY_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.SPRUCE_ARHAT_BED.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get());

                output.accept(ChangShengJueBlocks.BIRCH_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.JUNGLE_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.CRIMSON_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.WARPED_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.MANGROVE_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.WENGE_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.ACACIA_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.OAK_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.CHERRY_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.SPRUCE_CANOPY_BED.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_CANOPY_BED.get());

                output.accept(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL.get());

                output.accept(ChangShengJueBlocks.BIRCH_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.JUNGLE_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.CRIMSON_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.WARPED_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.MANGROVE_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.WENGE_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.ACACIA_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.OAK_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.CHERRY_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.SPRUCE_BOOK_GRID.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get());

                output.accept(ChangShengJueBlocks.BIRCH_LIANGGE.get());
                output.accept(ChangShengJueBlocks.JUNGLE_LIANGGE.get());
                output.accept(ChangShengJueBlocks.CRIMSON_LIANGGE.get());
                output.accept(ChangShengJueBlocks.WARPED_LIANGGE.get());
                output.accept(ChangShengJueBlocks.MANGROVE_LIANGGE.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE.get());
                output.accept(ChangShengJueBlocks.WENGE_LIANGGE.get());
                output.accept(ChangShengJueBlocks.ACACIA_LIANGGE.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_LIANGGE.get());
                output.accept(ChangShengJueBlocks.OAK_LIANGGE.get());
                output.accept(ChangShengJueBlocks.CHERRY_LIANGGE.get());
                output.accept(ChangShengJueBlocks.SPRUCE_LIANGGE.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_LIANGGE.get());

                output.accept(ChangShengJueBlocks.BIRCH_CABINET.get());
                output.accept(ChangShengJueBlocks.JUNGLE_CABINET.get());
                output.accept(ChangShengJueBlocks.CRIMSON_CABINET.get());
                output.accept(ChangShengJueBlocks.WARPED_CABINET.get());
                output.accept(ChangShengJueBlocks.MANGROVE_CABINET.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get());
                output.accept(ChangShengJueBlocks.WENGE_CABINET.get());
                output.accept(ChangShengJueBlocks.ACACIA_CABINET.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_CABINET.get());
                output.accept(ChangShengJueBlocks.OAK_CABINET.get());
                output.accept(ChangShengJueBlocks.CHERRY_CABINET.get());
                output.accept(ChangShengJueBlocks.SPRUCE_CABINET.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_CABINET.get());

                output.accept(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS.get());

                output.accept(ChangShengJueBlocks.BIRCH_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.WARPED_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.WENGE_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.ACACIA_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.OAK_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.CHERRY_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get());

                output.accept(ChangShengJueBlocks.WHITE_JADE_BLOCK.get());
                output.accept(ChangShengJueBlocks.WHITE_JADE_STAIRS.get());
                output.accept(ChangShengJueBlocks.WHITE_JADE_SLAB.get());
                output.accept(ChangShengJueBlocks.WHITE_JADE_WALL.get());
                output.accept(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get());

                output.accept(ChangShengJueBlocks.OAK_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.SPRUCE_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.BIRCH_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.JUNGLE_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.ACACIA_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.MANGROVE_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.CHERRY_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.CRIMSON_BALUSTRADE.get());
                output.accept(ChangShengJueBlocks.WARPED_BALUSTRADE.get());

                output.accept(ChangShengJueBlocks.OAK_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.SPRUCE_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.BIRCH_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.JUNGLE_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.ACACIA_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.MANGROVE_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.CHERRY_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.CRIMSON_OVERLORD_FIST.get());
                output.accept(ChangShengJueBlocks.WARPED_OVERLORD_FIST.get());

                output.accept(ChangShengJueBlocks.BIRCH_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.JUNGLE_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.CRIMSON_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.WARPED_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.MANGROVE_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.WENGE_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.ACACIA_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.OAK_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.CHERRY_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.SPRUCE_DRYING_RAIL.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL.get());

                output.accept(ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.WARPED_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.WENGE_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.OAK_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get());

                output.accept(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get());
                output.accept(ChangShengJueBlocks.MANGROVE_DOUGONG.get());
                output.accept(ChangShengJueBlocks.BIRCH_DOUGONG.get());
                output.accept(ChangShengJueBlocks.JUNGLE_DOUGONG.get());
                output.accept(ChangShengJueBlocks.CRIMSON_DOUGONG.get());
                output.accept(ChangShengJueBlocks.WARPED_DOUGONG.get());
                output.accept(ChangShengJueBlocks.ACACIA_DOUGONG.get());
                output.accept(ChangShengJueBlocks.DARK_OAK_DOUGONG.get());
                output.accept(ChangShengJueBlocks.OAK_DOUGONG.get());
                output.accept(ChangShengJueBlocks.CHERRY_DOUGONG.get());
                output.accept(ChangShengJueBlocks.SPRUCE_DOUGONG.get());
                output.accept(ChangShengJueBlocks.GREEN_DOUGONG.get());
                output.accept(ChangShengJueBlocks.BLUE_DOUGONG.get());

                output.accept(ChangShengJueBlocks.STONE_BENCH.get());
                output.accept(ChangShengJueBlocks.STONE_TABLE.get());
                output.accept(ChangShengJueBlocks.STONE_BALUSTRADE.get());

                output.accept(ChangShengJueBlocks.WIND_CHIME.get());
                output.accept(ChangShengJueItems.BAMBOO_MAT.get());

            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_FUNCTIONAL = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_functional",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_functional")).icon(() ->
                    new ItemStack(ChangShengJueBlocks.TOOL_TABLE.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get());
                output.accept(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get());
                output.accept(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get());
                output.accept(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get());
                output.accept(ChangShengJueItems.ZHU_TAI.get());
                output.accept(ChangShengJueBlocks.PAINTING_SCROLL.get());
                output.accept(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get());
                output.accept(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get());
                output.accept(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get());
                output.accept(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get());
                output.accept(ChangShengJueBlocks.POTTERY_WHEEL.get());
                output.accept(ChangShengJueBlocks.TOOL_TABLE.get());
                output.accept(ChangShengJueBlocks.WEAPON_RACK.get());
                output.accept(ChangShengJueBlocks.DESK.get());
                output.accept(ChangShengJueBlocks.PIG_TROUGH.get());
                output.accept(ChangShengJueBlocks.PLAQUE.get());
                output.accept(ChangShengJueBlocks.CASTING_MOLDS.get());
                output.accept(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get());
                output.accept(ChangShengJueBlocks.TAILORING_CASE.get());
                output.accept(ChangShengJueBlocks.FORGE_BLOCK.get());
                output.accept(ChangShengJueItems.WOOD_WORKING_BENCH.get());
                output.accept(ChangShengJueBlocks.BRICK_KILN.get());
                output.accept(ChangShengJueItems.PAINT_BRUSH.get());
                output.accept(ChangShengJueItems.CRUCIBLE.get());
                output.accept(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get());
                output.accept(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get());
                output.accept(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get());
                output.accept(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get());
                output.accept(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get());
                output.accept(ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get());
                output.accept(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get());
                output.accept(ChangShengJueItems.STAKES.get());
                output.accept(ChangShengJueItems.GONG.get());
                output.accept(ChangShengJueBlocks.STONE_SHARPENING_STONE.get());
                output.accept(ChangShengJueBlocks.DIAMOND_SHARPENING_STONE.get());
                output.accept(ChangShengJueBlocks.NETHERITE_SHARPENING_STONE.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_FOOD_AND_DRINK = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_food_and_drink",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_food_and_drink")).icon(() ->
                    new ItemStack(ChangShengJueItems.PINEAPPLE.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.VENISON.get());
                output.accept(ChangShengJueItems.COOKED_VENISON.get());
                output.accept(ChangShengJueItems.PEACOCK.get());
                output.accept(ChangShengJueItems.COOKED_PEACOCK.get());
                output.accept(ChangShengJueItems.CROC.get());
                output.accept(ChangShengJueItems.COOKED_CROC.get());

                output.accept(ChangShengJueItems.PINEAPPLE.get());
                output.accept(ChangShengJueItems.TOMATO.get());
                output.accept(ChangShengJueItems.CORN.get());
                output.accept(ChangShengJueItems.MANGO.get());
                output.accept(ChangShengJueItems.GUI_HUA.get());
                output.accept(ChangShengJueItems.MEI_HUA.get());
                output.accept(ChangShengJueItems.CANTALOUPE.get());
                output.accept(ChangShengJueItems.BANANA.get());
                output.accept(ChangShengJueItems.PEAR.get());
                output.accept(ChangShengJueItems.LICHEE.get());
                output.accept(ChangShengJueItems.GRAPE.get());
                output.accept(ChangShengJueItems.DURIAN_MEAT.get());
                output.accept(ChangShengJueItems.PEANUT.get());
                output.accept(ChangShengJueItems.BRINJAL.get());
                output.accept(ChangShengJueItems.MULBERRY.get());
                output.accept(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get());
                output.accept(ChangShengJueItems.BAKED_CORN.get());
                output.accept(ChangShengJueItems.SORGHUM_CAKE.get());
                output.accept(ChangShengJueItems.CAPSULE_JIAO_ZI.get());
                output.accept(ChangShengJueItems.QING_TUAN.get());
                output.accept(ChangShengJueItems.XIAO_MI_FAN.get());
                output.accept(ChangShengJueItems.MI_FAN.get());
                output.accept(ChangShengJueItems.ZHENG_CAI.get());
                output.accept(ChangShengJueItems.TOMATO_EGG.get());
                output.accept(ChangShengJueItems.GU_LAO_ROU.get());
                output.accept(ChangShengJueItems.MEAT_FOAM_BRINJAL.get());
                output.accept(ChangShengJueItems.STINKY_TOFU.get());
                output.accept(ChangShengJueItems.GUI_HUA_TANG_OU.get());

                output.accept(ChangShengJueItems.HOT_PEAR_SOUP.get());
                output.accept(ChangShengJueItems.ZHU_DU_JI.get());
                output.accept(ChangShengJueItems.BA_BAO_ZHOU.get());
                output.accept(ChangShengJueItems.MULBERRY_JUICE.get());
                output.accept(ChangShengJueItems.APPLE_JUICE.get());
                output.accept(ChangShengJueItems.GRAPE_JUICE.get());

                output.accept(ChangShengJueItems.BILUOCHUN_TEAS.get());
                output.accept(ChangShengJueItems.LONG_JING_TEAS.get());
                output.accept(ChangShengJueItems.FEN_JIU.get());
                output.accept(ChangShengJueItems.EMPTY_FEN_JIU.get());
                output.accept(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get());
                output.accept(ChangShengJueItems.SHI_LI_XIANG.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_INGREDIENTS = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_ingredients",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_ingredients")).icon(() ->
                    new ItemStack(ChangShengJueItems.GU_SUI.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.SOYBEAN.get());
                output.accept(ChangShengJueItems.REDBEAN.get());
                output.accept(ChangShengJueItems.SORGHUM.get());
                output.accept(ChangShengJueItems.GU_SUI.get());
                output.accept(ChangShengJueItems.LOTUS.get());
                output.accept(ChangShengJueItems.LOTUS_ROOT.get());
                output.accept(ChangShengJueItems.COTTON.get());
                output.accept(ChangShengJueItems.STICKYRICE.get());
                output.accept(ChangShengJueItems.STICKYRICE_1.get());
                output.accept(ChangShengJueItems.RICE.get());
                output.accept(ChangShengJueItems.JALAPENOS.get());
                output.accept(ChangShengJueItems.CRANE_FEATHERS.get());
                output.accept(ChangShengJueItems.PEACOCK_FEATHERS.get());
                output.accept(ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get());
                output.accept(ChangShengJueItems.PEACOCK_EGGS.get());
                output.accept(ChangShengJueItems.ANTLER.get());
                output.accept(ChangShengJueItems.DEER_BLOOD.get());
                output.accept(ChangShengJueItems.TIGER_SKIN.get());
                output.accept(ChangShengJueItems.CROC_SKIN.get());
                output.accept(ChangShengJueItems.SYDEROLIFE_BALL.get());
                output.accept(ChangShengJueItems.KAOLIN_BALL.get());
                output.accept(ChangShengJueItems.NATURAL_ASPHALT.get());
                output.accept(ChangShengJueItems.TONG_QIAN.get());
                output.accept(ChangShengJueItems.YI_GUAN_TONG_QIAN.get());
                output.accept(ChangShengJueItems.SILVER_BULLIONS.get());
                output.accept(ChangShengJueItems.GOLD_BULLIONS.get());
                output.accept(ChangShengJueItems.DURIAN.get());
                output.accept(ChangShengJueItems.RAW_AG.get());
                output.accept(ChangShengJueItems.AG_INGOT.get());
                output.accept(ChangShengJueItems.BLACK_BRICKS.get());
                output.accept(ChangShengJueItems.WHITE_BRICKS_ITEM.get());
                output.accept(ChangShengJueItems.GOLD_BRICKS.get());
                output.accept(ChangShengJueItems.CYAN_BRICKS.get());
                output.accept(ChangShengJueItems.SILK.get());
                output.accept(ChangShengJueItems.NATURAL_SILK.get());
                output.accept(ChangShengJueItems.SILKWORM.get());
                output.accept(ChangShengJueItems.BILUOCHUN_TEA.get());
                output.accept(ChangShengJueItems.LONG_JING_TEA.get());
                output.accept(ChangShengJueItems.HORDEUM.get());
                output.accept(ChangShengJueItems.THATCH.get());
                output.accept(ChangShengJueItems.CI_PAN.get());
                output.accept(ChangShengJueItems.CI_WAN.get());
                output.accept(ChangShengJueItems.CI_BEI.get());

                output.accept(ChangShengJueItems.QUICKLIME.get());
                output.accept(ChangShengJueItems.LIME_SLURRY_BARRELS.get());
                output.accept(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get());
                output.accept(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get());
                output.accept(ChangShengJueItems.EXTERNAL_KUNG_FU_XP.get());
                output.accept(ChangShengJueItems.INTERNAL_KUNG_FU_XP.get());

                output.accept(ChangShengJueItems.DUGU_NINE_SWORDS.get());
                output.accept(ChangShengJueItems.GAO_MARKSMANSHIP.get());
                output.accept(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get());
                output.accept(ChangShengJueItems.SHAOLIN_STICK_METHOD.get());
                output.accept(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get());
                output.accept(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get());
                output.accept(ChangShengJueItems.GE_SHAN_DA_NIU.get());
                output.accept(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get());
                output.accept(ChangShengJueItems.TURTLE_BREATH_WORK.get());

                output.accept(ChangShengJueItems.IMMORTAL_MIRACLE.get());
                output.accept(ChangShengJueItems.HERCULES.get());
                output.accept(ChangShengJueItems.GOLDEN_BELL_JAR.get());
                output.accept(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get());
                output.accept(ChangShengJueItems.PAODING.get());
                output.accept(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get());
                output.accept(ChangShengJueItems.WU_GANG_CUT_GUI.get());
                output.accept(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get());
                output.accept(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get());
                output.accept(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get());
                output.accept(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_COMBAT = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("cahng_sheng_jue_combat",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_combat")).icon(() ->
                    ChangShengJueItems.TU_LONG_DAO.get().getDefaultInstance()).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.LONG_YUAN_SWORD.get().getDefaultInstance());
                output.accept(ChangShengJueItems.BEAT_DOG_STICK.get().getDefaultInstance());
                output.accept(ChangShengJueItems.YI_TIAN_JIAN.get().getDefaultInstance());
                output.accept(ChangShengJueItems.TU_LONG_DAO.get().getDefaultInstance());
                output.accept(ChangShengJueItems.BA_WANG_QIANG.get().getDefaultInstance());
                output.accept(ChangShengJueItems.GOLD_THREAD_GLOVE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.BRONZE_SWORD.get());
                output.accept(ChangShengJueItems.HAN_JIAN.get());
                output.accept(ChangShengJueItems.HENG_DAO.get());
                output.accept(ChangShengJueItems.LARGE_KNIFE.get());
                output.accept(ChangShengJueItems.RED_TASSELLED_SPEAR.get());
                output.accept(ChangShengJueItems.SOFT_SWORD.get());
                output.accept(ChangShengJueItems.PAN_HUA_GUN.get());
                output.accept(ChangShengJueItems.KITCHEN_KNIFE.get());
                output.accept(ChangShengJueItems.THROWING_KNIVES.get());
                output.accept(ChangShengJueItems.FLYING_DAGGER_POUCH.get());
                output.accept(ChangShengJueItems.COTTON_HELMET.get());
                output.accept(ChangShengJueItems.WHITE_COTTON_HELMET.get());
                output.accept(ChangShengJueItems.COTTON_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.COTTON_LEGGINGS.get());
                output.accept(ChangShengJueItems.COTTON_BOOTS.get());
                output.accept(ChangShengJueItems.FEMALE_TAOIST_HELMET.get());
                output.accept(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.MALE_TAOIST_HELMET.get());
                output.accept(ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.TAOIST_BOOTS.get());
                output.accept(ChangShengJueItems.TAOIST_LEGGINGS.get());
                output.accept(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get());
                output.accept(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get().getDefaultInstance());
                output.accept(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get());
                output.accept(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get().getDefaultInstance());
                output.accept(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get());

                output.accept(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get());
                output.accept(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get().getDefaultInstance());
                output.accept(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get());
                output.accept(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get());

                output.accept(ChangShengJueItems.FLY_FISH_IRON_HAT.get());
                output.accept(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get());
                output.accept(ChangShengJueItems.FLY_FISH_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get());

                output.accept(ChangShengJueItems.WALKER_GOLD_RING_BAND.get());
                output.accept(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get());
                output.accept(ChangShengJueItems.WALKER_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT.get());
                output.accept(ChangShengJueItems.WALKER_SHORT_BOOTS.get());

                output.accept(ChangShengJueItems.PHOENIX_FEATHER_CAP.get());
                output.accept(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get().getDefaultInstance());
                output.accept(ChangShengJueItems.TIGER_SKIN_GARMENT.get());
                output.accept(ChangShengJueItems.CLOUD_WALKING_BOOTS.get());

                output.accept(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get());
                output.accept(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get());
                output.accept(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get());

                output.accept(ChangShengJueItems.CONFUCIAN_HELMET.get());
                output.accept(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get());
                output.accept(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get());

                output.accept(ChangShengJueItems.HATS_WITH_VEIL_HELMET.get());
                output.accept(ChangShengJueItems.HATS_WITH_VEIL_CHESTPLATE.get().getDefaultInstance());

                output.accept(ChangShengJueItems.HATS_BLACK_ROBE_HELMET.get());
                output.accept(ChangShengJueItems.HATS_BLACK_ROBE_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.HATS_BLACK_ROBE_LEGGINGS.get());

                output.accept(ChangShengJueItems.DUAN_DA_CHESTPLATE.get().getDefaultInstance());

                output.accept(ChangShengJueItems.BUDDHIST_ROBE_CHESTPLATE.get().getDefaultInstance());

                output.accept(ChangShengJueItems.NIGHT_SUIT_HELMET.get());
                output.accept(ChangShengJueItems.NIGHT_SUIT_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.NIGHT_SUIT_LEGGINGS.get());

                output.accept(ChangShengJueItems.LONG_GOWN_CHESTPLATE.get().getDefaultInstance());

                output.accept(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get());
                output.accept(ChangShengJueItems.LEATHER_INNER_ARMOR.get());

                output.accept(ChangShengJueItems.FOREHEAD_BAND_HELMET1.get());
                output.accept(ChangShengJueItems.FOREHEAD_BAND_HELMET2.get());
                output.accept(ChangShengJueItems.HAIR_CROWN_HELMET1.get());
                output.accept(ChangShengJueItems.HAIR_CROWN_HELMET2.get());

                output.accept(ChangShengJueItems.CONSTABLE_UNIFORM_HELMET.get());
                output.accept(ChangShengJueItems.CONSTABLE_UNIFORM_CHESTPLATE.get().getDefaultInstance());
                output.accept(ChangShengJueItems.CONSTABLE_UNIFORM_LEGGINGS.get());
                output.accept(ChangShengJueItems.CONSTABLE_UNIFORM_BOOTS.get());

            }).build());
    //工具
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_TOOL = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_tool",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_tool")).icon(() ->
                    new ItemStack(ChangShengJueItems.XUANHUA_AXE.get())).displayItems((parameters,output)-> {
                output.accept(ChangShengJueItems.XUANHUA_AXE.get());
                output.accept(ChangShengJueItems.KAISHAN_PICKAXE.get());
                output.accept(ChangShengJueItems.GANG_TOKEN.get());
                output.acceptAll(Parcel.createParcel());

                output.accept(createStructureIntelligence(StructureIntelligence.SANDSTONE_CASTLE_TYPE));
                output.accept(createStructureIntelligence(StructureIntelligence.SI_HE_YUAN_TYPE));
                output.accept(createStructureIntelligence(StructureIntelligence.PIT_YARD_TYPE));
                output.accept(createStructureIntelligence(StructureIntelligence.SU_PAI_VILLAGE_TYPE));
                output.accept(createStructureIntelligence(StructureIntelligence.HUI_PAI_VILLAGE_TYPE));
                output.accept(createStructureIntelligence(StructureIntelligence.FORTRESSES_TYPE));
            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_SPAWN_EGGS = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_spawn_eggs",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_spawn_eggs")).icon(() ->
                    new ItemStack(ChangShengJueItems.MONKEY_EGG.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.BUTTERFLY_EGG.get());
                output.accept(ChangShengJueItems.MONKEY_EGG.get());
                output.accept(ChangShengJueItems.DRAGONFLY_EGG.get());
                output.accept(ChangShengJueItems.CICADA_EGG.get());
                output.accept(ChangShengJueItems.CRANE_EGG.get());
                output.accept(ChangShengJueItems.PEACOCK_EGG.get());
                output.accept(ChangShengJueItems.PEACOCK_EGG_1.get());
                output.accept(ChangShengJueItems.STAG_EGG.get());
                output.accept(ChangShengJueItems.HIND_EGG.get());
                output.accept(ChangShengJueItems.TIGER_EGG.get());
                output.accept(ChangShengJueItems.CROC_EGG.get());
                output.accept(ChangShengJueItems.CHANG_SHENG_JUE_VILLAGER_EGG.get());
                output.accept(ChangShengJueItems.WARRIOR_EGG.get());
                output.accept(ChangShengJueItems.KILN_WORKER_EGG.get());
                output.accept(ChangShengJueItems.MALE_INNKEEPER_EGG.get());
                output.accept(ChangShengJueItems.FEMALE_INNKEEPER_EGG.get());
                output.accept(ChangShengJueItems.CHALLENGER_EGG.get());
                output.accept(ChangShengJueItems.BLACKSMITH_EGG.get());
                output.accept(ChangShengJueItems.LANCE_GANG_LEADER_EGG.get());
                output.accept(ChangShengJueItems.KNIFE_GANG_LEADER_EGG.get());
                output.accept(ChangShengJueItems.SWORD_GANG_LEADER_EGG.get());
                output.accept(ChangShengJueItems.CLUBBED_GANG_LEADER_EGG.get());
                output.accept(ChangShengJueItems.GANG_LEADER_EGG.get());
                output.accept(ChangShengJueItems.BANDIT_EGG.get());
                output.accept(ChangShengJueItems.VILLAIN_EGG.get());
                output.accept(ChangShengJueItems.ASSASSIN_EGG.get());
                output.accept(ChangShengJueItems.CLUBBED_MING_XIA_EGG.get());
                output.accept(ChangShengJueItems.SWORD_MING_XIA_EGG.get());
                output.accept(ChangShengJueItems.KNIFE_MING_XIA_EGG.get());
                output.accept(ChangShengJueItems.FIST_MING_XIA_EGG.get());
                output.accept(ChangShengJueItems.PIGLIN_WU_XIA_EGG.get());
                output.accept(ChangShengJueItems.WITCH_WU_XIA_EGG.get());
                output.accept(ChangShengJueItems.EVOKER_WU_XIA_EGG.get());
                output.accept(ChangShengJueItems.VINDICATOR_WU_XIA_EGG.get());
                output.accept(ChangShengJueItems.PILLAGER_WU_XIA_EGG.get());
            }).build());


    private static ItemStack createStructureIntelligence(int damageValue) {
        ItemStack stack = new ItemStack(ChangShengJueItems.STRUCTURE_INTELLIGENCE.get());
        stack.setDamageValue(damageValue);
        return stack;
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }
}
