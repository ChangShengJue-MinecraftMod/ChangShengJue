package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.cropper.HordeumBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;


public class CSJBlockStateProvider extends BlockStateProvider {

    public CSJBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChangShengJue.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ChangShengJueBlocks.AG_ORE);
        blockWithItem(ChangShengJueBlocks.DEEPSLATE_AG_ORE);

        blockWithItem(ChangShengJueBlocks.KAOLIN_ORE);

        blockWithItem(ChangShengJueBlocks.LIMESTONE);

        blockWithItem(ChangShengJueBlocks.SYDEROLIFE_ORE);

        //瓦
        blockWithItem(ChangShengJueBlocks.GRE_CYLINDER_TILE);
        blockWithItem(ChangShengJueBlocks.RED_CYLINDER_TILE);
        blockWithItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE);
        blockWithItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE);
        blockWithItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE);

        //白杨树
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.POPLAR_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.POPLAR_WOOD.get(),
                blockTexture(ChangShengJueBlocks.POPLAR_LOG.get()), blockTexture(ChangShengJueBlocks.POPLAR_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_poplar_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get()));
        blockItem(ChangShengJueBlocks.POPLAR_LOG);
        blockItem(ChangShengJueBlocks.POPLAR_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_POPLAR_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_POPLAR_WOOD);
        blockWithItem(ChangShengJueBlocks.POPLAR_PLANKS);
        leavesBlock(ChangShengJueBlocks.POPLAR_LEAVES);
        saplingBlock(ChangShengJueBlocks.POPLAR_SAPLING);
        //紫檀
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.ZI_TAN_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.ZI_TAN_WOOD.get(),
                blockTexture(ChangShengJueBlocks.ZI_TAN_LOG.get()), blockTexture(ChangShengJueBlocks.ZI_TAN_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_zi_tan_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get()));
        blockItem(ChangShengJueBlocks.ZI_TAN_LOG);
        blockItem(ChangShengJueBlocks.ZI_TAN_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD);
        blockWithItem(ChangShengJueBlocks.ZI_TAN_PLANKS);
        leavesBlock(ChangShengJueBlocks.ZI_TAN_LEAVES);
        saplingBlock(ChangShengJueBlocks.ZI_TAN_SAPLING);
        //桂花
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.OSMANTHUS_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.OSMANTHUS_WOOD.get(),
                blockTexture(ChangShengJueBlocks.OSMANTHUS_LOG.get()), blockTexture(ChangShengJueBlocks.OSMANTHUS_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_osmanthus_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get()));
        blockItem(ChangShengJueBlocks.OSMANTHUS_LOG);
        blockItem(ChangShengJueBlocks.OSMANTHUS_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD);
        blockWithItem(ChangShengJueBlocks.OSMANTHUS_PLANKS);
        leavesBlock(ChangShengJueBlocks.OSMANTHUS_LEAVES);
        saplingBlock(ChangShengJueBlocks.OSMANTHUS_SAPLING);
        //黄花梨
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.HUANG_HUA_LI_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get(),
                blockTexture(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get()), blockTexture(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_huang_hua_li_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get()));
        blockItem(ChangShengJueBlocks.HUANG_HUA_LI_LOG);
        blockItem(ChangShengJueBlocks.HUANG_HUA_LI_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD);
        blockWithItem(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS);
        leavesBlock(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES);
        saplingBlock(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING);
        //鸡翅木
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.WENGE_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.WENGE_WOOD.get(),
                blockTexture(ChangShengJueBlocks.WENGE_LOG.get()), blockTexture(ChangShengJueBlocks.WENGE_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_WENGE_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_wenge_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get()));
        blockItem(ChangShengJueBlocks.WENGE_LOG);
        blockItem(ChangShengJueBlocks.WENGE_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_WENGE_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_WENGE_WOOD);
        blockWithItem(ChangShengJueBlocks.WENGE_PLANKS);
        leavesBlock(ChangShengJueBlocks.WENGE_LEAVES);
        saplingBlock(ChangShengJueBlocks.WENGE_SAPLING);
        //梨树
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.PEAR_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.PEAR_WOOD.get(),
                blockTexture(ChangShengJueBlocks.PEAR_LOG.get()), blockTexture(ChangShengJueBlocks.PEAR_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_PEAR_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_pear_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get()));
        blockItem(ChangShengJueBlocks.PEAR_LOG);
        blockItem(ChangShengJueBlocks.PEAR_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_PEAR_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_PEAR_WOOD);
        blockWithItem(ChangShengJueBlocks.PEAR_PLANKS);
        leavesBlock(ChangShengJueBlocks.PEAR_LEAVES);
        saplingBlock(ChangShengJueBlocks.PEAR_SAPLING);
        //荔枝
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.LICHEE_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.LICHEE_WOOD.get(),
                blockTexture(ChangShengJueBlocks.LICHEE_LOG.get()), blockTexture(ChangShengJueBlocks.LICHEE_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_lichee_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get()));
        blockItem(ChangShengJueBlocks.LICHEE_LOG);
        blockItem(ChangShengJueBlocks.LICHEE_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_LICHEE_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD);
        blockWithItem(ChangShengJueBlocks.LICHEE_PLANKS);
        leavesBlock(ChangShengJueBlocks.LICHEE_LEAVES);
        saplingBlock(ChangShengJueBlocks.LICHEE_SAPLING);
        //榴莲
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.DURIAN_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.DURIAN_WOOD.get(),
                blockTexture(ChangShengJueBlocks.DURIAN_LOG.get()), blockTexture(ChangShengJueBlocks.DURIAN_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_durian_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get()));
        blockItem(ChangShengJueBlocks.DURIAN_LOG);
        blockItem(ChangShengJueBlocks.DURIAN_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_DURIAN_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_DURIAN_WOOD);
        blockWithItem(ChangShengJueBlocks.DURIAN_PLANKS);
        leavesBlock(ChangShengJueBlocks.DURIAN_LEAVES);
        saplingBlock(ChangShengJueBlocks.DURIAN_SAPLING);

        //芒果树叶
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.MANGO_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.MANGO_WOOD.get(),
                blockTexture(ChangShengJueBlocks.MANGO_LOG.get()), blockTexture(ChangShengJueBlocks.MANGO_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_MANGO_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_mango_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get()));
        blockItem(ChangShengJueBlocks.MANGO_LOG);
        blockItem(ChangShengJueBlocks.MANGO_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_MANGO_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_MANGO_WOOD);
        blockWithItem(ChangShengJueBlocks.MANGO_PLANKS);
        leavesBlock(ChangShengJueBlocks.MANGO_LEAVES);
        saplingBlock(ChangShengJueBlocks.MANGO_SAPLING);
        //梅花
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.PLUM_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.PLUM_WOOD.get(),
                blockTexture(ChangShengJueBlocks.PLUM_LOG.get()), blockTexture(ChangShengJueBlocks.PLUM_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_PLUM_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_plum_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get()));
        blockItem(ChangShengJueBlocks.PLUM_LOG);
        blockItem(ChangShengJueBlocks.PLUM_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_PLUM_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_PLUM_WOOD);
        blockWithItem(ChangShengJueBlocks.PLUM_PLANKS);
        leavesBlock(ChangShengJueBlocks.PLUM_LEAVES);
        saplingBlock(ChangShengJueBlocks.PLUM_SAPLING);
        //桑树
        logBlock((RotatedPillarBlock) ChangShengJueBlocks.MULBERRY_LOG.get());
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.MULBERRY_WOOD.get(),
                blockTexture(ChangShengJueBlocks.MULBERRY_LOG.get()), blockTexture(ChangShengJueBlocks.MULBERRY_LOG.get()));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get()), new ResourceLocation(ChangShengJue.MOD_ID, "block/stripped_mulberry_log_top"));
        axisBlock((RotatedPillarBlock) ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get(),
                blockTexture(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get()), blockTexture(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get()));
        blockItem(ChangShengJueBlocks.MULBERRY_LOG);
        blockItem(ChangShengJueBlocks.MULBERRY_WOOD);
        blockItem(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG);
        blockItem(ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD);
        blockWithItem(ChangShengJueBlocks.MULBERRY_PLANKS);
        saplingBlock(ChangShengJueBlocks.MULBERRY_SAPLING);

//        simpleBlock(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),new ModelFile.UncheckedModelFile(modLoc("block/blue_and_white_porcelain_flower_pots")));
//        simpleBlockItem(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),new ModelFile.UncheckedModelFile(modLoc("block/blue_and_white_porcelain_flower_pots")));

        makeCrop((CropBlock) ChangShengJueBlocks.HORDEUM.get(), "hordeum_stage", "hordeum_stage");
        //花盆和盆栽花
        simpleBlockWithItem(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/blue_and_white_porcelain_flower_pots")));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_MUGWORT_BLOCK.get(),models().singleTexture("potted_mugwort_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.MUGWORT_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_CUCKOO_BLOCK.get(),models().singleTexture("potted_cuckoo_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.CUCKOO_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK.get(),models().singleTexture("potted_portulaca_oleracea_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_JASMINE_BLOCK.get(),models().singleTexture("potted_jasmine_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.JASMINE_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK.get(),models().singleTexture("potted_kochia_scoparia_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK.get(),models().singleTexture("potted_shui_xian_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK.get(),models().singleTexture("potted_tan_hua_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.TAN_HUA_BLOCK.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),models().singleTexture("potted_solidago",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.SOLIDAGO.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),models().singleTexture("potted_geum_triflorum",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.GEUM_TRIFLORUM.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),models().singleTexture("potted_purple_dandelion",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.PURPLE_DANDELION.get())).renderType("cutout"));

        horizontalBlock(ChangShengJueBlocks.TOOL_TABLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/tool_table")));
        horizontalBlock(ChangShengJueBlocks.DESK.get(), new ModelFile.UncheckedModelFile(modLoc("block/desk")));
        //酒桌椅
        horizontalBlock(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/ji_chi_mu_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_drinking_table_and_chairs")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_drinking_table_and_chairs")));
        //茶几
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_teapoy")));
        horizontalBlock(ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/ji_chi_mu_teapoy")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_teapoy")));
        //太师椅
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/ji_chi_mu_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_taishi_chair")));
        //五围屏宝座
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/ji_chi_mu_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_five_screen_throne")));
        //蒲团
        horizontalBlock(ChangShengJueBlocks.ZAFU.get(), new ModelFile.UncheckedModelFile(modLoc("block/zafu")));

        //屋脊
        horizontalBlock(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.RED_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_roof_ridge")));
        //鸱吻
        horizontalBlock(ChangShengJueBlocks.GRE_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.RED_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_demon_mask")));
        //脊兽脊瓦
        horizontalBlock(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/animals_gre_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/animals_red_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/animals_black_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/animals_golden_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/animals_blue_ridge_tile")));
        //垂兽脊瓦
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_gre_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_red_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_black_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_golden_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_blue_ridge_tile")));
        //侧筒瓦
        horizontalBlock(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_double_cylinder_tile_side")));
        //侧高筒瓦
        horizontalBlock(ChangShengJueBlocks.GRE_HIGH_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_high_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.RED_HIGH_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_high_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLACK_HIGH_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_high_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_HIGH_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_high_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLUE_HIGH_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_high_cylinder_tile_side")));
        //侧瓦当
        horizontalBlock(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_eaves_tile_side")));
        //八角垂脊
        horizontalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/red_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/black_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_octagonal_gable_ridge_cylinder_tile")));
        //台阶
        slabBlock((SlabBlock) ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.GRE_CYLINDER_TILE.get()), blockTexture(ChangShengJueBlocks.GRE_CYLINDER_TILE.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.RED_CYLINDER_TILE.get()), blockTexture(ChangShengJueBlocks.RED_CYLINDER_TILE.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get()), blockTexture(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get()), blockTexture(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get()), blockTexture(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get()));
        //栏杆
        horizontalBlock(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/white_jade_guardrail")));
//        wallBlock(((WallBlock) ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get()), new ResourceLocation(ChangShengJue.MOD_ID,"block/white_jade_balustrade"));

    }


    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] cropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((HordeumBlock) block).getAgeProperty()),
                new ResourceLocation(ChangShengJue.MOD_ID, "block/" + textureName + state.getValue(((HordeumBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(ChangShengJue.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(),models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                new ResourceLocation("block/leaves"), "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void blockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(),cubeAll(block.get()));
    }
}
