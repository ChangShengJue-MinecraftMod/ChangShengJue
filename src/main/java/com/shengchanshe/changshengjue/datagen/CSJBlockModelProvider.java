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
    }

    private BlockModelBuilder parentBlock(RegistryObject<Block> block,String parent){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + parent))
                .texture("1","block/"+block.getId().getPath())
                .texture("particle","block/"+block.getId().getPath());
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
