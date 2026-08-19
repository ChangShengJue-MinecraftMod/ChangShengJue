package com.shengchanshe.chang_sheng_jue.cilent.setup;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public final class ClientRenderTypeRegistrar {
    private ClientRenderTypeRegistrar() {
    }

    public static void register() {
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TOMATO_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GU_ZI_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SORGHUM_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LOTUS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.REDBEAN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.COTTON_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CORN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEANUT_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BRINJAL_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAPE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RICE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BILUOCHUN_TEA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JING_TEA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HORDEUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CANTALOUPE_STEM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ATTACHED_CANTALOUPE_STEM.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OSMANTHUS_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OSMANTHUS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLUM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLUM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLUM_DEFOLIATION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),  RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA_FRUIT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEAR_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POPLAR_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POPLAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_LEAVES_FRUITS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LICHEE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LICHEE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DURIAN_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DURIAN_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MUGWORT_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CUCKOO_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JASMINE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TAN_HUA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CAPSULE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STIPA_GRANDIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_KNOTWEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RAPE_FLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SOLIDAGO.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GEUM_TRIFLORUM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DANDELION.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHU_TAI.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_BIRCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_ACACIA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_DARK_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_OAK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DOOR_SPRUCE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_EAVES_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DEMON_MASK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PLAQUE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_CORNICES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_GENTLE_TILE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_CORNICES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_2.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_3.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TILE_BLOCK_4.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.POTTERY_WHEEL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WIND_CHIME.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_ARHAT_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_CANOPY_BED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_CANOPY_BED.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STONE_BENCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STONE_TABLE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_TEAPOY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STONE_SHARPENING_STONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DIAMOND_SHARPENING_STONE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.NETHERITE_SHARPENING_STONE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WHITE_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ORANGE_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MAGENTA_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LIGHT_BLUE_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.YELLOW_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LIME_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PINK_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAY_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LIGHT_GRAY_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CYAN_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PURPLE_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BROWN_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GREEN_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.RED_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLACK_LANTERN.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STONE_BALUSTRADE.get(), RenderType.cutout());

// 食物方块透明渲染设置
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CI_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CI_WAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CI_BEI.get(), RenderType.cutout());

// 玉米相关
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CORN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BAKED_CORN.get(), RenderType.cutout());

// 水果类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PEAR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PINEAPPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGO.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LICHEE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BANANA.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DURIAN.get(), RenderType.cutout());

// 饺子相关
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(), RenderType.cutout());

// 马齿苋饼
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(), RenderType.cutout());

// 青团
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.QING_TUAN_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.QING_TUAN_WAN.get(), RenderType.cutout());

// 高粱饼
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(), RenderType.cutout());

// 米饭
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MI_FAN_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MI_FAN_WAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(), RenderType.cutout());

// 蒸菜类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHENG_CAI.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.TOMATO_EGG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GU_LAO_ROU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MEAT_FOAM_BRINJAL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.STINKY_TOFU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GUI_HUA_TANG_OU.get(), RenderType.cutout());

// 汤类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.HOT_PEAR_SOUP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ZHU_DU_JI.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BA_BAO_ZHOU.get(), RenderType.cutout());

// 饮料类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MULBERRY_JUICE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.APPLE_JUICE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GRAPE_JUICE.get(), RenderType.cutout());

// 茶类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BILUOCHUN_TEAS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JING_TEAS.get(), RenderType.cutout());

// 酒杯类
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.EMPTY_FEN_JIU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.FEN_JIU.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHI_LI_XIANG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get(), RenderType.cutout());
        //雀替和斗拱
        // 雀替类方块透明渲染设置
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get(), RenderType.cutout());

// 斗拱类方块透明渲染设置
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BIRCH_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.WARPED_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.ACACIA_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.OAK_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.CHERRY_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.GREEN_DOUGONG.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ChangShengJueBlocks.BLUE_DOUGONG.get(), RenderType.cutout());
    }
}

