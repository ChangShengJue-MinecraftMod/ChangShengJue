package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class CSJBlockModelProvider extends BlockModelProvider {

    public CSJBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //茶几
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.JI_CHI_MU_TEAPOY,"teapoy");
        parentBlock(ChangShengJueBlocks.ZI_TAN_TEAPOY,"teapoy");
        //太师椅
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR,"taishi_chair");
        parentBlock(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR,"taishi_chair");
        //五围屏宝座
        parentBlock(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE,"five_screen_throne");
        parentBlock(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE,"five_screen_throne");
        //席桌
        parentSplicingBlock(ChangShengJueBlocks.BIRCH_LOW_DESK,"low_desk");//参数为方块和自定义模型
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
        parentBlock(ChangShengJueBlocks.BLUE_ROOF_RIDGE,"roof_ridge","blue_roof_ridge_demon_mask");
        //鸱吻
        parentBlock(ChangShengJueBlocks.GRE_DEMON_MASK,"demon_mask","gre_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.RED_DEMON_MASK,"demon_mask","red_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.BLACK_DEMON_MASK,"demon_mask","black_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.GOLDEN_DEMON_MASK,"demon_mask","golden_roof_ridge_demon_mask");
        parentBlock(ChangShengJueBlocks.BLUE_DEMON_MASK,"demon_mask","blue_roof_ridge_demon_mask");
        //脊兽瓦
        parentBlock(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE,"cylindertile/animals_cylinder_tile_block","animals_gre_roof_ridge");
        parentBlock(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE,"cylindertile/animals_cylinder_tile_block","animals_red_roof_ridge");
        parentBlock(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE,"cylindertile/animals_cylinder_tile_block","animals_black_roof_ridge");
        parentBlock(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE,"cylindertile/animals_cylinder_tile_block","animals_golden_roof_ridge");
        parentBlock(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE,"cylindertile/animals_cylinder_tile_block","animals_blue_roof_ridge");
        //垂兽脊瓦
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_gre_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_red_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_black_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_golden_roof_ridge");
        parentBlock(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE,"cylindertile/hanging_beast_cylinder_tile_block","animals_blue_roof_ridge");
        //脊刹
        parentBottomBlock(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_bottom");

        parentTopBlock(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION,"ridge_finial_pavilion_top");

        parentBottomBlock(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");
        parentBottomBlock(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_bottom");

        parentTopBlock(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");
        parentTopBlock(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION,"character_plaque_pavilion_top");

        parentBottomBlock(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","cylinder_tile_gre_block");
        parentBottomBlock(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","cylinder_tile_red_block");
        parentBottomBlock(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","cylinder_tile_black_block");
        parentBottomBlock(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","cylinder_tile_golden_block");
        parentBottomBlock(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_bottom","cylinder_tile_blue_block");

        parentTopBlock(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","cylinder_tile_gre_block");
        parentTopBlock(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","cylinder_tile_red_block");
        parentTopBlock(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","cylinder_tile_black_block");
        parentTopBlock(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","cylinder_tile_golden_block");
        parentTopBlock(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE,"gable_ridge_cylinder_tile_top","cylinder_tile_blue_block");

        parentBlock(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","cylinder_tile_gre_block");
        parentBlock(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","cylinder_tile_red_block");
        parentBlock(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","cylinder_tile_black_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","cylinder_tile_golden_block");
        parentBlock(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_bottom_left",
                "gable_ridge_cylinder_tile_bottom_left","cylinder_tile_blue_block");

        parentBlock(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","gre_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","red_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","black_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","golden_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE,"double_gable_ridge_cylinder_tile","blue_double_gable_ridge_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","gre_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","red_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","black_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","golden_double_gable_ridge_cylinder_tile");
        parentBlock(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE,"double_hanging_beast_gable_ridge_cylinder_tile","blue_double_gable_ridge_cylinder_tile");

        parentBlock(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE,"short_cylinder_tile","cylinder_tile_gre_block");
        parentBlock(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE,"short_cylinder_tile","cylinder_tile_red_block");
        parentBlock(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE,"short_cylinder_tile","cylinder_tile_black_block");
        parentBlock(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE,"short_cylinder_tile","cylinder_tile_golden_block");
        parentBlock(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE,"short_cylinder_tile","cylinder_tile_blue_block");

    }

    //自定义方块模型
    private BlockModelBuilder parentBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
    }
    //自定义两格方块模型
    private BlockModelBuilder parentBottomBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath() + "_bottom",
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

    //自定义方块模型贴图
    private BlockModelBuilder parentBlock(RegistryObject<Block> block, String parent, String textures){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
    }
    private BlockModelBuilder parentTopBlock(RegistryObject<Block> block, String parent, String textures){
        return withExistingParent(block.getId().getPath() + "_top",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
    }
    private BlockModelBuilder parentBottomBlock(RegistryObject<Block> block, String parent, String textures){
        return withExistingParent(block.getId().getPath() + "_bottom",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
    }
    private BlockModelBuilder parentBlock(String jsonName,String parent,String textures){
        return withExistingParent(jsonName, new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/" + textures)
                .texture("particle","block/"+ textures);
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
