package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class CSJBlockModelProvider extends BlockModelProvider {

    public CSJBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //茶几
        parentBlock(ChangShengJueBlocks.BIRCH_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.JUNGLE_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.CRIMSON_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.WARPED_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.MANGROVE_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.WENGE_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.ACACIA_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.DARK_OAK_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.OAK_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.CHERRY_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.SPRUCE_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.ZI_TAN_TEAPOY,"teapoy");
        //太师椅
        parentBlock(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.WARPED_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.WENGE_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.OAK_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR,"taishi_chair");
        //五围屏宝座
        parentBlock(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE,"five_screen_throne");

        //席桌
        parentSplicingBlock(ChangShengJueBlocks.BIRCH_LOW_DESK,"low_desk");//参数为方块和自定义模型
        parentSplicingBlock(ChangShengJueBlocks.JUNGLE_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.CRIMSON_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.WARPED_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.MANGROVE_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.ACACIA_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.DARK_OAK_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.OAK_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.CHERRY_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.SPRUCE_LOW_DESK,"low_desk");
        parentSplicingBlock(ChangShengJueBlocks.ZI_TAN_LOW_DESK,"low_desk");

        parentSplicingSideBlock(ChangShengJueBlocks.BIRCH_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.JUNGLE_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.CRIMSON_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.WARPED_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.MANGROVE_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.ACACIA_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.DARK_OAK_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.OAK_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.CHERRY_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.SPRUCE_LOW_DESK,"low_desk");
        parentSplicingSideBlock(ChangShengJueBlocks.ZI_TAN_LOW_DESK,"low_desk");

        parentSplicingMiddleBlock(ChangShengJueBlocks.BIRCH_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.JUNGLE_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.CRIMSON_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.WARPED_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.MANGROVE_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.ACACIA_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.DARK_OAK_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.OAK_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.CHERRY_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.SPRUCE_LOW_DESK,"low_desk");
        parentSplicingMiddleBlock(ChangShengJueBlocks.ZI_TAN_LOW_DESK,"low_desk");
        //蒲团
        parentBlock(ChangShengJueBlocks.ZAFU,"zafu_model");
        //酒桌
        parentSplicingBlock(ChangShengJueBlocks.BIRCH_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.JUNGLE_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.CRIMSON_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.WARPED_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.MANGROVE_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.ACACIA_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.DARK_OAK_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.OAK_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.CHERRY_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.SPRUCE_WINE_TABLE,"wine_table");
        parentSplicingBlock(ChangShengJueBlocks.ZI_TAN_WINE_TABLE,"wine_table");

        parentSplicingSideBlock(ChangShengJueBlocks.BIRCH_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.JUNGLE_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.CRIMSON_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.WARPED_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.MANGROVE_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.ACACIA_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.DARK_OAK_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.OAK_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.CHERRY_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.SPRUCE_WINE_TABLE,"wine_table");
        parentSplicingSideBlock(ChangShengJueBlocks.ZI_TAN_WINE_TABLE,"wine_table");

        parentSplicingSideOneBlock(ChangShengJueBlocks.BIRCH_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.JUNGLE_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.CRIMSON_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.WARPED_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.MANGROVE_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.ACACIA_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.DARK_OAK_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.OAK_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.CHERRY_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.SPRUCE_WINE_TABLE,"wine_table");
        parentSplicingSideOneBlock(ChangShengJueBlocks.ZI_TAN_WINE_TABLE,"wine_table");

        parentSplicingSideTwoBlock(ChangShengJueBlocks.BIRCH_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.JUNGLE_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.CRIMSON_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.WARPED_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.MANGROVE_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.ACACIA_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.DARK_OAK_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.OAK_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.CHERRY_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.SPRUCE_WINE_TABLE,"wine_table");
        parentSplicingSideTwoBlock(ChangShengJueBlocks.ZI_TAN_WINE_TABLE,"wine_table");

        parentSplicingSideThreeBlock(ChangShengJueBlocks.BIRCH_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.JUNGLE_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.CRIMSON_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.WARPED_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.MANGROVE_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.ACACIA_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.DARK_OAK_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.OAK_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.CHERRY_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.SPRUCE_WINE_TABLE,"wine_table");
        parentSplicingSideThreeBlock(ChangShengJueBlocks.ZI_TAN_WINE_TABLE,"wine_table");

        parentSplicingMiddleBlock(ChangShengJueBlocks.BIRCH_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.JUNGLE_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.CRIMSON_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.WARPED_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.MANGROVE_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.ACACIA_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.DARK_OAK_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.OAK_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.CHERRY_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.SPRUCE_WINE_TABLE,"wine_table");
        parentSplicingMiddleBlock(ChangShengJueBlocks.ZI_TAN_WINE_TABLE,"wine_table");

        //屋脊
        parentBlock(ChangShengJueBlocks.GRE_ROOF_RIDGE,"roof_ridge","gre_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.RED_ROOF_RIDGE,"roof_ridge","red_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.BLACK_ROOF_RIDGE,"roof_ridge","black_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE,"roof_ridge","golden_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.CYAN_ROOF_RIDGE,"roof_ridge","cyan_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.BLUE_ROOF_RIDGE,"roof_ridge","blue_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.PURPLE_ROOF_RIDGE,"roof_ridge","purple_roof_ridge_demon_mask");
        //鸱吻
        parentBlock(ChangShengJueBlocks.GRE_DEMON_MASK,"demon_mask","gre_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.RED_DEMON_MASK,"demon_mask","red_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.BLACK_DEMON_MASK,"demon_mask","black_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.GOLDEN_DEMON_MASK,"demon_mask","golden_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.CYAN_DEMON_MASK,"demon_mask","cyan_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.BLUE_DEMON_MASK,"demon_mask","blue_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.PURPLE_DEMON_MASK,"demon_mask","purple_roof_ridge_demon_mask");
        //垂兽脊瓦
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_gre_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_red_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_black_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_golden_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_cyan_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_blue_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_purple_roof_ridge");
        //脊刹
        parentBottomBlock(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");

        parentTopBlock(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");

        parentInventoryBlock(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion");

        parentBottomBlock(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");

        parentTopBlock(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");

        parentInventoryBlock(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");
        parentInventoryBlock(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion");

        //攒尖
        parentBottomBlock(ChangShengJueBlocks.GRE_HIPPED_ROOF,"hipped_roof_bottom");
        parentBottomBlock(ChangShengJueBlocks.RED_HIPPED_ROOF,"hipped_roof_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLACK_HIPPED_ROOF,"hipped_roof_bottom");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF,"hipped_roof_bottom");
        parentBottomBlock(ChangShengJueBlocks.CYAN_HIPPED_ROOF,"hipped_roof_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLUE_HIPPED_ROOF,"hipped_roof_bottom");
        parentBottomBlock(ChangShengJueBlocks.PURPLE_HIPPED_ROOF,"hipped_roof_bottom");

        parentMiddleBlock(ChangShengJueBlocks.GRE_HIPPED_ROOF,"hipped_roof_middle");
        parentMiddleBlock(ChangShengJueBlocks.RED_HIPPED_ROOF,"hipped_roof_middle");
        parentMiddleBlock(ChangShengJueBlocks.BLACK_HIPPED_ROOF,"hipped_roof_middle");
        parentMiddleBlock(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF,"hipped_roof_middle");
        parentMiddleBlock(ChangShengJueBlocks.CYAN_HIPPED_ROOF,"hipped_roof_middle");
        parentMiddleBlock(ChangShengJueBlocks.BLUE_HIPPED_ROOF,"hipped_roof_middle");
        parentMiddleBlock(ChangShengJueBlocks.PURPLE_HIPPED_ROOF,"hipped_roof_middle");

        parentTopBlock(ChangShengJueBlocks.GRE_HIPPED_ROOF,"hipped_roof_top");
        parentTopBlock(ChangShengJueBlocks.RED_HIPPED_ROOF,"hipped_roof_top");
        parentTopBlock(ChangShengJueBlocks.BLACK_HIPPED_ROOF,"hipped_roof_top");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF,"hipped_roof_top");
        parentTopBlock(ChangShengJueBlocks.CYAN_HIPPED_ROOF,"hipped_roof_top");
        parentTopBlock(ChangShengJueBlocks.BLUE_HIPPED_ROOF,"hipped_roof_top");
        parentTopBlock(ChangShengJueBlocks.PURPLE_HIPPED_ROOF,"hipped_roof_top");

        parentInventoryBlock(ChangShengJueBlocks.GRE_HIPPED_ROOF,"hipped_roof_inventory");
        parentInventoryBlock(ChangShengJueBlocks.RED_HIPPED_ROOF,"hipped_roof_inventory");
        parentInventoryBlock(ChangShengJueBlocks.BLACK_HIPPED_ROOF,"hipped_roof_inventory");
        parentInventoryBlock(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF,"hipped_roof_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CYAN_HIPPED_ROOF,"hipped_roof_inventory");
        parentInventoryBlock(ChangShengJueBlocks.BLUE_HIPPED_ROOF,"hipped_roof_inventory");
        parentInventoryBlock(ChangShengJueBlocks.PURPLE_HIPPED_ROOF,"hipped_roof_inventory");

        parentBottomBlock(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","gre_cylinder_tile","");
        parentBottomBlock(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","red_cylinder_tile","");
        parentBottomBlock(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","black_cylinder_tile","");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","golden_cylinder_tile","");
        parentBottomBlock(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","cyan_cylinder_tile","");
        parentBottomBlock(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","blue_cylinder_tile","");
        parentBottomBlock(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","purple_cylinder_tile","");

        parentTopBlock(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","gre_cylinder_tile","");
        parentTopBlock(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","red_cylinder_tile","");
        parentTopBlock(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","black_cylinder_tile","");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","golden_cylinder_tile","");
        parentTopBlock(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","cyan_cylinder_tile","");
        parentTopBlock(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","blue_cylinder_tile","");
        parentTopBlock(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","purple_cylinder_tile","");

        parentBlock(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","purple_cylinder_tile");

        //八角飞檐
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_left",
                "octagonal_upturned_eaves_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right",
                "octagonal_upturned_eaves_right","purple_cylinder_tile");

        //八角垂脊(矮)
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_front_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_front_right","blue_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_dwarf_ridge_tiles_behind_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_dwarf_ridge_tiles_behind_right","purple_cylinder_tile");

        //八角高垂脊(前)
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_front_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_front_right","purple_cylinder_tile");
        //八角高垂脊(后)
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_left",
                "octagonal_high_ridge_tiles_behind_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right",
                "octagonal_high_ridge_tiles_behind_right","purple_cylinder_tile");

        //八角双层垂脊(前)
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_front_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_front_right","purple_cylinder_tile");

        //八角双层垂脊(后)
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_left",
                "octagonal_double_gable_ridge_cylinder_tile_behind_left","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right",
                "octagonal_double_gable_ridge_cylinder_tile_behind_right","purple_cylinder_tile");

        //八角垂脊
        parentBlock(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE ,"octagonal_gable_ridge_cylinder_tile","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE ,"octagonal_gable_ridge_cylinder_tile","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE ,"octagonal_gable_ridge_cylinder_tile","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE ,"octagonal_gable_ridge_cylinder_tile","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE,"octagonal_gable_ridge_cylinder_tile","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE,"octagonal_gable_ridge_cylinder_tile","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE,"octagonal_gable_ridge_cylinder_tile","purple_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","gre_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","red_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","black_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","golden_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","cyan_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","blue_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","purple_double_gable_ridge_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","gre_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","red_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","black_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","golden_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","golden_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","blue_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","purple_double_gable_ridge_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE,"short_cylinder_tile","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE,"short_cylinder_tile","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE,"short_cylinder_tile","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE,"short_cylinder_tile","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE,"short_cylinder_tile","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE,"short_cylinder_tile","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE,"short_cylinder_tile","purple_cylinder_tile");
        //侧双层筒瓦
        parentBlock(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE,"double_cylinder_tile_side","purple_cylinder_tile");
        //片瓦(飞檐)
        parentBlock(ChangShengJueBlocks.GOLDEN_CORNICES,"cornices_tile","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES,"gentle_cornices_tile","golden_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_CORNICES,"cornices_tile","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_CORNICES,"gentle_cornices_tile","black_tile_block");
        //片瓦
        parentBlock(ChangShengJueBlocks.GOLDEN_TILE.getId().getPath(), "tile","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_TILE.getId().getPath() + "_outer", "tile_outer","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_TILE.getId().getPath() + "_inner", "tile_inner","golden_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_TILE.getId().getPath(), "tile","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_TILE.getId().getPath() + "_outer", "tile_outer","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_TILE.getId().getPath() + "_inner", "tile_inner","black_tile_block");
        //平缓片瓦
        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_height1","gentle_tile_height1","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_outer_height1","gentle_tile_outer_height1","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_inner_height1","gentle_tile_inner_height1","golden_tile_block");

        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_height2","gentle_tile_height2","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_outer_height2","gentle_tile_outer_height2","golden_tile_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_inner_height2","gentle_tile_inner_height2","golden_tile_block");

        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_height1","gentle_tile_height1","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_outer_height1","gentle_tile_outer_height1","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_inner_height1","gentle_tile_inner_height1","black_tile_block");

        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_height2","gentle_tile_height2","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_outer_height2","gentle_tile_outer_height2","black_tile_block");
        parentBlock(ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_inner_height2","gentle_tile_inner_height2","black_tile_block");
        //灯笼
        parentBlock(ChangShengJueBlocks.LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.WHITE_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.WHITE_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.WHITE_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.ORANGE_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.ORANGE_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.ORANGE_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.MAGENTA_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.MAGENTA_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.MAGENTA_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.LIGHT_BLUE_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.LIGHT_BLUE_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.LIGHT_BLUE_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.YELLOW_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.YELLOW_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.YELLOW_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.LIME_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.LIME_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.LIME_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.PINK_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.PINK_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.PINK_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.GRAY_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.GRAY_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.GRAY_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.LIGHT_GRAY_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.LIGHT_GRAY_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.LIGHT_GRAY_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.CYAN_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.CYAN_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.CYAN_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.PURPLE_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.PURPLE_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.PURPLE_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.BLUE_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.BLUE_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.BLUE_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.BROWN_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.BROWN_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.BROWN_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.GREEN_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.GREEN_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.GREEN_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.RED_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.RED_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.RED_LANTERN,"lanterns_hanging");
        parentBlock(ChangShengJueBlocks.BLACK_LANTERN,"lanterns");
        parentLayBlock(ChangShengJueBlocks.BLACK_LANTERN,"lanterns_lay");
        parentHangingBlock(ChangShengJueBlocks.BLACK_LANTERN,"lanterns_hanging");

        parentBlock(ChangShengJueBlocks.BIRCH_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.JUNGLE_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.CRIMSON_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.WARPED_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.MANGROVE_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.WENGE_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.ACACIA_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.OAK_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.CHERRY_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.SPRUCE_LIGHT_STAND,"light_stand");
        parentBlock(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND,"light_stand");

        parentBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","birch_light_stand");
        parentBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","jungle_light_stand");
        parentBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","crimson_light_stand");
        parentBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","warped_light_stand");
        parentBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","mangrove_light_stand");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","huang_hua_li_light_stand");
        parentBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","wenge_light_stand");
        parentBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","acacia_light_stand");
        parentBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","dark_oak_light_stand");
        parentBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","oak_light_stand");
        parentBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","cherry_light_stand");
        parentBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","spruce_light_stand");
        parentBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.getId().getPath() + "_bottom","height_light_stand_bottom","zi_tan_light_stand");

        parentBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","birch_light_stand");
        parentBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","jungle_light_stand");
        parentBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","crimson_light_stand");
        parentBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","warped_light_stand");
        parentBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","mangrove_light_stand");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","huang_hua_li_light_stand");
        parentBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","wenge_light_stand");
        parentBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","acacia_light_stand");
        parentBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","dark_oak_light_stand");
        parentBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","oak_light_stand");
        parentBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","cherry_light_stand");
        parentBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","spruce_light_stand");
        parentBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle1","height_light_stand_middle1","zi_tan_light_stand");

        parentBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","birch_light_stand");
        parentBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","jungle_light_stand");
        parentBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","crimson_light_stand");
        parentBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","warped_light_stand");
        parentBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","mangrove_light_stand");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","huang_hua_li_light_stand");
        parentBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","wenge_light_stand");
        parentBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","acacia_light_stand");
        parentBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","dark_oak_light_stand");
        parentBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","oak_light_stand");
        parentBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","cherry_light_stand");
        parentBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","spruce_light_stand");
        parentBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.getId().getPath() + "_middle2","height_light_stand_middle2","zi_tan_light_stand");

        parentBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","birch_light_stand");
        parentBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","jungle_light_stand");
        parentBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","crimson_light_stand");
        parentBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","warped_light_stand");
        parentBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","mangrove_light_stand");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","huang_hua_li_light_stand");
        parentBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","wenge_light_stand");
        parentBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","acacia_light_stand");
        parentBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","dark_oak_light_stand");
        parentBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","oak_light_stand");
        parentBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","cherry_light_stand");
        parentBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","spruce_light_stand");
        parentBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.getId().getPath() + "_top","height_light_stand_top","zi_tan_light_stand");

        parentBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","birch_light_stand");
        parentBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","jungle_light_stand");
        parentBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","crimson_light_stand");
        parentBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","warped_light_stand");
        parentBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","mangrove_light_stand");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","huang_hua_li_light_stand");
        parentBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","wenge_light_stand");
        parentBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","acacia_light_stand");
        parentBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","dark_oak_light_stand");
        parentBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","oak_light_stand");
        parentBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","cherry_light_stand");
        parentBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","spruce_light_stand");
        parentBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.getId().getPath() + "_top_left","height_light_stand_top_left","zi_tan_light_stand");

        parentInventoryBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","birch_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","jungle_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","crimson_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","warped_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","mangrove_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","huang_hua_li_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","wenge_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","acacia_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","dark_oak_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","oak_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","cherry_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","spruce_light_stand");
        parentInventoryBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND,"height_light_stand_inventory","zi_tan_light_stand");

        parentBlock(ChangShengJueBlocks.BIRCH_SQUARE_STOOL,"square_stool","birch_square_stool");
        parentBlock(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL,"square_stool","jungle_square_stool");
        parentBlock(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL,"square_stool","crimson_square_stool");
        parentBlock(ChangShengJueBlocks.WARPED_SQUARE_STOOL,"square_stool","warped_square_stool");
        parentBlock(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL,"square_stool","mangrove_square_stool");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL,"square_stool","huang_hua_li_square_stool");
        parentBlock(ChangShengJueBlocks.WENGE_SQUARE_STOOL,"square_stool","wenge_square_stool");
        parentBlock(ChangShengJueBlocks.ACACIA_SQUARE_STOOL,"square_stool","acacia_square_stool");
        parentBlock(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL,"square_stool","dark_oak_square_stool");
        parentBlock(ChangShengJueBlocks.OAK_SQUARE_STOOL,"square_stool","oak_square_stool");
        parentBlock(ChangShengJueBlocks.CHERRY_SQUARE_STOOL,"square_stool","cherry_square_stool");
        parentBlock(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL,"square_stool","spruce_square_stool");
        parentBlock(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL,"square_stool","zi_tan_square_stool");

        parentBlock(ChangShengJueBlocks.STONE_BENCH,"stone_benchs","stone_bench");
        parentBlock(ChangShengJueBlocks.STONE_TABLE,"stone_tables","stone_bench");
        //置物格
        parentBlock(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","birch_storage_compartment");
        parentBlock(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","jungle_storage_compartment");
        parentBlock(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","crimson_storage_compartment");
        parentBlock(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","warped_storage_compartment");
        parentBlock(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","mangrove_storage_compartment");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","huang_hua_li_storage_compartment");
        parentBlock(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","wenge_storage_compartment");
        parentBlock(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","acacia_storage_compartment");
        parentBlock(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","dark_oak_storage_compartment");
        parentBlock(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","oak_storage_compartment");
        parentBlock(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","cherry_storage_compartment");
        parentBlock(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","spruce_storage_compartment");
        parentBlock(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL,"fretwork_openwork_panel","zi_tan_storage_compartment");
        //书格
        parentBlock(ChangShengJueBlocks.BIRCH_BOOK_GRID,"book_grid","birch_storage_compartment");
        parentBlock(ChangShengJueBlocks.JUNGLE_BOOK_GRID,"book_grid","jungle_storage_compartment");
        parentBlock(ChangShengJueBlocks.CRIMSON_BOOK_GRID,"book_grid","crimson_storage_compartment");
        parentBlock(ChangShengJueBlocks.WARPED_BOOK_GRID,"book_grid","warped_storage_compartment");
        parentBlock(ChangShengJueBlocks.MANGROVE_BOOK_GRID,"book_grid","mangrove_storage_compartment");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID,"book_grid","huang_hua_li_storage_compartment");
        parentBlock(ChangShengJueBlocks.WENGE_BOOK_GRID,"book_grid","wenge_storage_compartment");
        parentBlock(ChangShengJueBlocks.ACACIA_BOOK_GRID,"book_grid","acacia_storage_compartment");
        parentBlock(ChangShengJueBlocks.DARK_OAK_BOOK_GRID,"book_grid","dark_oak_storage_compartment");
        parentBlock(ChangShengJueBlocks.OAK_BOOK_GRID,"book_grid","oak_storage_compartment");
        parentBlock(ChangShengJueBlocks.CHERRY_BOOK_GRID,"book_grid","cherry_storage_compartment");
        parentBlock(ChangShengJueBlocks.SPRUCE_BOOK_GRID,"book_grid","spruce_storage_compartment");
        parentBlock(ChangShengJueBlocks.ZI_TAN_BOOK_GRID,"book_grid","zi_tan_storage_compartment");
        //亮格
        parentBlock(ChangShengJueBlocks.BIRCH_LIANGGE,"liangge","birch_storage_compartment");
        parentBlock(ChangShengJueBlocks.JUNGLE_LIANGGE,"liangge","jungle_storage_compartment");
        parentBlock(ChangShengJueBlocks.CRIMSON_LIANGGE,"liangge","crimson_storage_compartment");
        parentBlock(ChangShengJueBlocks.WARPED_LIANGGE,"liangge","warped_storage_compartment");
        parentBlock(ChangShengJueBlocks.MANGROVE_LIANGGE,"liangge","mangrove_storage_compartment");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE,"liangge","huang_hua_li_storage_compartment");
        parentBlock(ChangShengJueBlocks.WENGE_LIANGGE,"liangge","wenge_storage_compartment");
        parentBlock(ChangShengJueBlocks.ACACIA_LIANGGE,"liangge","acacia_storage_compartment");
        parentBlock(ChangShengJueBlocks.DARK_OAK_LIANGGE,"liangge","dark_oak_storage_compartment");
        parentBlock(ChangShengJueBlocks.OAK_LIANGGE,"liangge","oak_storage_compartment");
        parentBlock(ChangShengJueBlocks.CHERRY_LIANGGE,"liangge","cherry_storage_compartment");
        parentBlock(ChangShengJueBlocks.SPRUCE_LIANGGE,"liangge","spruce_storage_compartment");
        parentBlock(ChangShengJueBlocks.ZI_TAN_LIANGGE,"liangge","zi_tan_storage_compartment");
        //柜子
        parentBlock(ChangShengJueBlocks.BIRCH_CABINET,"cabinet","birch_cabinet");
        parentBlock(ChangShengJueBlocks.JUNGLE_CABINET,"cabinet","jungle_cabinet");
        parentBlock(ChangShengJueBlocks.CRIMSON_CABINET,"cabinet","crimson_cabinet");
        parentBlock(ChangShengJueBlocks.WARPED_CABINET,"cabinet","warped_cabinet");
        parentBlock(ChangShengJueBlocks.MANGROVE_CABINET,"cabinet","mangrove_cabinet");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_CABINET,"cabinet","huang_hua_li_cabinet");
        parentBlock(ChangShengJueBlocks.WENGE_CABINET,"cabinet","wenge_cabinet");
        parentBlock(ChangShengJueBlocks.ACACIA_CABINET,"cabinet","acacia_cabinet");
        parentBlock(ChangShengJueBlocks.DARK_OAK_CABINET,"cabinet","dark_oak_cabinet");
        parentBlock(ChangShengJueBlocks.OAK_CABINET,"cabinet","oak_cabinet");
        parentBlock(ChangShengJueBlocks.CHERRY_CABINET,"cabinet","cherry_cabinet");
        parentBlock(ChangShengJueBlocks.SPRUCE_CABINET,"cabinet","spruce_cabinet");
        parentBlock(ChangShengJueBlocks.ZI_TAN_CABINET,"cabinet","zi_tan_cabinet");
        //立柜
        parentBlock(ChangShengJueBlocks.BIRCH_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.JUNGLE_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.CRIMSON_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.WARPED_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.MANGROVE_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.WENGE_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.ACACIA_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.OAK_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.CHERRY_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.SPRUCE_LARGE_CABINET,"large_cabinet");
        parentBlock(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET,"large_cabinet");
        //晾衣架
        parentBlock(ChangShengJueBlocks.BIRCH_DRYING_RAIL,"drying_rail", "birch_clothes_rack");
        parentBlock(ChangShengJueBlocks.JUNGLE_DRYING_RAIL,"drying_rail","jungle_clothes_rack");
        parentBlock(ChangShengJueBlocks.CRIMSON_DRYING_RAIL,"drying_rail","crimson_clothes_rack");
        parentBlock(ChangShengJueBlocks.WARPED_DRYING_RAIL,"drying_rail","warped_clothes_rack");
        parentBlock(ChangShengJueBlocks.MANGROVE_DRYING_RAIL,"drying_rail","mangrove_clothes_rack");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL,"drying_rail","huang_hua_li_clothes_rack");
        parentBlock(ChangShengJueBlocks.WENGE_DRYING_RAIL,"drying_rail","wenge_clothes_rack");
        parentBlock(ChangShengJueBlocks.ACACIA_DRYING_RAIL,"drying_rail","acacia_clothes_rack");
        parentBlock(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL,"drying_rail","dark_oak_clothes_rack");
        parentBlock(ChangShengJueBlocks.OAK_DRYING_RAIL,"drying_rail","oak_clothes_rack");
        parentBlock(ChangShengJueBlocks.CHERRY_DRYING_RAIL,"drying_rail","cherry_clothes_rack");
        parentBlock(ChangShengJueBlocks.SPRUCE_DRYING_RAIL,"drying_rail","spruce_clothes_rack");
        parentBlock(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL,"drying_rail","zi_tan_clothes_rack");

        parentBlock(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS,"chest_of_drawers","birch_cabinet");
        parentBlock(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS,"chest_of_drawers","jungle_cabinet");
        parentBlock(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS,"chest_of_drawers","crimson_cabinet");
        parentBlock(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS,"chest_of_drawers","warped_cabinet");
        parentBlock(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS,"chest_of_drawers","mangrove_cabinet");
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS,"chest_of_drawers","huang_hua_li_cabinet");
        parentBlock(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS,"chest_of_drawers","wenge_cabinet");
        parentBlock(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS,"chest_of_drawers","acacia_cabinet");
        parentBlock(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS,"chest_of_drawers","dark_oak_cabinet");
        parentBlock(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS,"chest_of_drawers","oak_cabinet");
        parentBlock(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS,"chest_of_drawers","cherry_cabinet");
        parentBlock(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS,"chest_of_drawers","spruce_cabinet");
        parentBlock(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS,"chest_of_drawers","zi_tan_cabinet");
        //折屏
        parentBottomBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_left_bottom","birch_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_left_bottom","jungle_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_left_bottom","crimson_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_left_bottom","warped_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_left_bottom","mangrove_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_left_bottom","huang_hua_li_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_left_bottom","wenge_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_left_bottom","acacia_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_left_bottom","dark_oak_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_left_bottom","oak_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_left_bottom","cherry_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_left_bottom","spruce_folding_screen","_left");
        parentBottomBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_left_bottom","zi_tan_folding_screen","_left");

        parentMiddleBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_left_middle","birch_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_left_middle","jungle_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_left_middle","crimson_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_left_middle","warped_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_left_middle","mangrove_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_left_middle","huang_hua_li_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_left_middle","wenge_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_left_middle","acacia_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_left_middle","dark_oak_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_left_middle","oak_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_left_middle","cherry_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_left_middle","spruce_folding_screen","_left");
        parentMiddleBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_left_middle","zi_tan_folding_screen","_left");

        parentTopBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_left_top","birch_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_left_top","jungle_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_left_top","crimson_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_left_top","warped_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_left_top","mangrove_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_left_top","huang_hua_li_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_left_top","wenge_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_left_top","acacia_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_left_top","dark_oak_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_left_top","oak_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_left_top","cherry_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_left_top","spruce_folding_screen","_left");
        parentTopBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_left_top","zi_tan_folding_screen","_left");

        parentBottomBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_right_bottom","birch_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_right_bottom","jungle_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_right_bottom","crimson_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_right_bottom","warped_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_right_bottom","mangrove_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_right_bottom","huang_hua_li_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_right_bottom","wenge_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_right_bottom","acacia_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_right_bottom","dark_oak_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_right_bottom","oak_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_right_bottom","cherry_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_right_bottom","spruce_folding_screen","_right");
        parentBottomBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_right_bottom","zi_tan_folding_screen","_right");

        parentMiddleBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_right_middle","birch_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_right_middle","jungle_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_right_middle","crimson_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_right_middle","warped_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_right_middle","mangrove_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_right_middle","huang_hua_li_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_right_middle","wenge_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_right_middle","acacia_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_right_middle","dark_oak_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_right_middle","oak_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_right_middle","cherry_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_right_middle","spruce_folding_screen","_right");
        parentMiddleBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_right_middle","zi_tan_folding_screen","_right");

        parentTopBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_right_top","birch_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_right_top","jungle_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_right_top","crimson_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_right_top","warped_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_right_top","mangrove_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_right_top","huang_hua_li_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_right_top","wenge_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_right_top","acacia_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_right_top","dark_oak_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_right_top","oak_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_right_top","cherry_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_right_top","spruce_folding_screen","_right");
        parentTopBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_right_top","zi_tan_folding_screen","_right");

        parentInventoryBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,"folding_screen_left_inventory","birch_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,"folding_screen_left_inventory","jungle_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,"folding_screen_left_inventory","crimson_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,"folding_screen_left_inventory","warped_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,"folding_screen_left_inventory","mangrove_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,"folding_screen_left_inventory","huang_hua_li_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,"folding_screen_left_inventory","wenge_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,"folding_screen_left_inventory","acacia_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,"folding_screen_left_inventory","dark_oak_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN,"folding_screen_left_inventory","oak_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,"folding_screen_left_inventory","cherry_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,"folding_screen_left_inventory","spruce_folding_screen");
        parentInventoryBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,"folding_screen_left_inventory","zi_tan_folding_screen");

        //琉璃瓦
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","gre_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","red_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","black_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","golden_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","cyan_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","blue_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height1",1,"_baffle","purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,"cylindertile/cylinder_tile_height1",1,"","purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height2",2,"_baffle","purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,"cylindertile/cylinder_tile_height2",2,"","purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,"cylindertile/cylinder_tile_baffle_height3",3,"_baffle","purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,"cylindertile/cylinder_tile_height3",3,"","purple_cylinder_tile");

        //侧向琉璃瓦
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"gre_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"red_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"black_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"golden_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"cyan_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"blue_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height1",1,"purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height2",2,"purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE,"cylindertile/cylinder_tile_side_height3",3,"purple_cylinder_tile");
        //脊兽瓦
        parentTileBlock(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_gre_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_gre_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_gre_roof_ridge");

        parentTileBlock(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_red_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_red_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_red_roof_ridge");

        parentTileBlock(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_black_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_black_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_black_roof_ridge");

        parentTileBlock(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_golden_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_golden_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_golden_roof_ridge");

        parentTileBlock(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_cyan_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_cyan_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_cyan_roof_ridge");

        parentTileBlock(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_blue_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_blue_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_blue_roof_ridge");

        parentTileBlock(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height1",1,"animals_purple_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height2",2,"animals_purple_roof_ridge");
        parentTileBlock(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE,"cylindertile/animals_ridge_tile_height3",3,"animals_purple_roof_ridge");

        //瓦当
        parentBlock(ChangShengJueBlocks.GRE_EAVES_TILE,"cylindertile/eaves_tile","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_EAVES_TILE,"cylindertile/eaves_tile","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_EAVES_TILE,"cylindertile/eaves_tile","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_EAVES_TILE,"cylindertile/eaves_tile","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_EAVES_TILE,"cylindertile/eaves_tile","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_EAVES_TILE,"cylindertile/eaves_tile","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_EAVES_TILE,"cylindertile/eaves_tile","purple_cylinder_tile");
        //侧瓦当
        parentBlock(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE,"eaves_tile_side","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_EAVES_TILE_SIDE,"eaves_tile_side","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE,"eaves_tile_side","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE,"eaves_tile_side","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE,"eaves_tile_side","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE,"eaves_tile_side","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE,"eaves_tile_side","purple_cylinder_tile");
        //双层琉璃瓦
        parentTileBlock(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile","","purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE,"cylindertile/double_cylinder_tile_baffle","_baffle","purple_cylinder_tile");
        //小鸱吻
        parentBlock(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK,"cylindertile/small_demon_mask","purple_cylinder_tile");
        //双层脊瓦
        parentBlock(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE,"cylindertile/double_ridge_tile","purple_cylinder_tile");
        //飞檐
        parentBlock(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","gre_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","red_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","black_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","golden_cylinder_tile");
        parentBlock(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","cyan_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","blue_cylinder_tile");
        parentBlock(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE,"cylindertile/eaves_cylinder_tile","purple_cylinder_tile");
        //脊瓦
        parentTileBlock(ChangShengJueBlocks.GRE_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"gre_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GRE_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"gre_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.RED_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"red_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.RED_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"red_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.BLACK_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"black_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLACK_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"black_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.GOLDEN_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"golden_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.GOLDEN_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"golden_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.CYAN_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"cyan_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.CYAN_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"cyan_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.BLUE_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"blue_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.BLUE_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"blue_cylinder_tile");

        parentTileBlock(ChangShengJueBlocks.PURPLE_RIDGE_TILE,"cylindertile/ridge_tile_height1",1,"purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_RIDGE_TILE,"cylindertile/ridge_tile_height2",2,"purple_cylinder_tile");
        parentTileBlock(ChangShengJueBlocks.PURPLE_RIDGE_TILE,"cylindertile/ridge_tile_height3",3,"purple_cylinder_tile");

        parentHeadBlock(ChangShengJueBlocks.BIRCH_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.BIRCH_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.BIRCH_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.JUNGLE_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.JUNGLE_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.JUNGLE_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.CRIMSON_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.CRIMSON_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.CRIMSON_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.WARPED_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.WARPED_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.WARPED_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.MANGROVE_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.MANGROVE_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.MANGROVE_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.WENGE_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.WENGE_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.WENGE_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.ACACIA_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.ACACIA_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.ACACIA_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.DARK_OAK_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.DARK_OAK_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.DARK_OAK_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.OAK_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.OAK_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.OAK_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.CHERRY_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.CHERRY_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.CHERRY_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.SPRUCE_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.SPRUCE_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.SPRUCE_ARHAT_BED,"arhat_bed_foot");

        parentHeadBlock(ChangShengJueBlocks.ZI_TAN_ARHAT_BED,"arhat_bed_head");
        parentBodyBlock(ChangShengJueBlocks.ZI_TAN_ARHAT_BED,"arhat_bed_body");
        parentFootBlock(ChangShengJueBlocks.ZI_TAN_ARHAT_BED,"arhat_bed_foot");

        parentInventoryBlock(ChangShengJueBlocks.BIRCH_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.JUNGLE_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CRIMSON_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.WARPED_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.MANGROVE_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.WENGE_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.ACACIA_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.DARK_OAK_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.OAK_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CHERRY_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.SPRUCE_ARHAT_BED,"arhat_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.ZI_TAN_ARHAT_BED,"arhat_bed_inventory");

        //衣架
        parentTopBlock(ChangShengJueBlocks.BIRCH_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.WARPED_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.WENGE_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.ACACIA_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.OAK_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.CHERRY_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK,"clothes_rack_top");
        parentTopBlock(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK,"clothes_rack_top");

        parentBottomBlock(ChangShengJueBlocks.BIRCH_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.WARPED_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.WENGE_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.ACACIA_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.OAK_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.CHERRY_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK,"clothes_rack_bottom");
        parentBottomBlock(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK,"clothes_rack_bottom");

        parentInventoryBlock(ChangShengJueBlocks.BIRCH_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.WARPED_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.WENGE_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.ACACIA_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.OAK_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CHERRY_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK,"clothes_rack_inventory");
        parentInventoryBlock(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK,"clothes_rack_inventory");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_head_front_top", "canopy_bed_head_front_top");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_head_rear_top", "canopy_bed_head_rear_top");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_head_front_middle", "canopy_bed_head_front_middle");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_head_rear_middle", "canopy_bed_head_rear_middle");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_head_front_bottom", "canopy_bed_head_front_bottom");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_head_rear_bottom", "canopy_bed_head_rear_bottom");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_body_front_top", "canopy_bed_body_front_top");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_body_rear_top", "canopy_bed_body_rear_top");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_body_rear_middle", "canopy_bed_body_rear_middle");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_body_front_bottom", "canopy_bed_body_front_bottom");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_body_rear_bottom", "canopy_bed_body_rear_bottom");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_foot_front_top", "canopy_bed_foot_front_top");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_foot_rear_top", "canopy_bed_foot_rear_top");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_foot_front_middle", "canopy_bed_foot_front_middle");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_foot_rear_middle", "canopy_bed_foot_rear_middle");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_foot_front_bottom", "canopy_bed_foot_front_bottom");

        parentBlocks(ChangShengJueBlocks.BIRCH_CANOPY_BED, ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");
        parentBlocks(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_foot_rear_bottom", "canopy_bed_foot_rear_bottom");

        parentInventoryBlock(ChangShengJueBlocks.BIRCH_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.JUNGLE_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CRIMSON_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.WARPED_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.MANGROVE_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.WENGE_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.ACACIA_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.OAK_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.CHERRY_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.SPRUCE_CANOPY_BED,"canopy_bed_inventory");
        parentInventoryBlock(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,"canopy_bed_inventory");
    }

    //自定义方块模型
    private BlockModelBuilder parentBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    private BlockModelBuilder parentLayBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_lay",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    private BlockModelBuilder parentHangingBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_hanging",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    //自定义多格方块模型
    private BlockModelBuilder parentBottomBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_bottom",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    private BlockModelBuilder parentMiddleBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_middle",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    private BlockModelBuilder parentTopBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_top",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    //多层琉璃瓦
    private BlockModelBuilder parentTileBlock(RegistryObject<Block> block,String parent, int i, String baffle, String textures){
        return withExistingParent(block.getId().getPath() + baffle + "_height" + i,
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/" + textures);
    }
    private BlockModelBuilder parentTileBlock(RegistryObject<Block> block,String parent, int i, String textures){
        return withExistingParent(block.getId().getPath() + "_height" + i,
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/" + textures);
    }

    private BlockModelBuilder parentTileBlock(RegistryObject<Block> block,String parent, String baffle, String textures){
        return withExistingParent(block.getId().getPath() + baffle,
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/" + textures);
    }

    //自定义多格方块手持模型
    private BlockModelBuilder parentInventoryBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_inventory",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    //自定义长方块模型
    private BlockModelBuilder parentHeadBlock(RegistryObject<Block> block, String parent){
        return withExistingParent(block.getId().getPath() + "_head",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + block.getId().getPath())
                .texture("particle","block/"+ block.getId().getPath());
    }
    private BlockModelBuilder parentBodyBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_body",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + block.getId().getPath())
                .texture("particle","block/" + block.getId().getPath());
    }
    private BlockModelBuilder parentFootBlock(RegistryObject<Block> block, String parent){
        return withExistingParent(block.getId().getPath() + "_foot",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + block.getId().getPath())
                .texture("particle","block/"+ block.getId().getPath());
    }

    //自定义方块模型贴图
    private BlockModelBuilder parentBlock(RegistryObject<Block> block, String parent, String textures){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
    }
    private BlockModelBuilder parentMiddleBlock(RegistryObject<Block> block,String parent, String textures, String around){
        return withExistingParent(block.getId().getPath() + around + "_middle",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/" + textures);
    }
    private BlockModelBuilder parentTopBlock(RegistryObject<Block> block, String parent, String textures, String around){
        return withExistingParent(block.getId().getPath() + around + "_top",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
    }
    private BlockModelBuilder parentBottomBlock(RegistryObject<Block> block, String parent, String textures, String around){
        return withExistingParent(block.getId().getPath() + around + "_bottom",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
    }
    private BlockModelBuilder parentInventoryBlock(RegistryObject<Block> block, String parent, String textures){
        return withExistingParent(block.getId().getPath() + "_inventory",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+ textures)
                .texture("particle","block/"+ textures);
    }

    private BlockModelBuilder parentBlock(String jsonName,String parent,String textures){
        return withExistingParent(jsonName, new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/" + textures);
    }

    private BlockModelBuilder parentBlocks(RegistryObject<Block> block, String jsonName, String parent){
        return withExistingParent(jsonName, new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + block.getId().getPath())
                .texture("particle","block/" + block.getId().getPath());
    }

    //拼接方块模型
    private BlockModelBuilder parentSplicingBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }

    private BlockModelBuilder parentSplicingSideBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_side",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent + "_side"))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }

    private BlockModelBuilder parentSplicingSideOneBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_side1",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent + "_side1"))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    private BlockModelBuilder parentSplicingSideTwoBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_side2",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent + "_side2"))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    private BlockModelBuilder parentSplicingSideThreeBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_side3",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent + "_side3"))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }

    private BlockModelBuilder parentSplicingMiddleBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_middle",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent + "_middle"))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }

}
