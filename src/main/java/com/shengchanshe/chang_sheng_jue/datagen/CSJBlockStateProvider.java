package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.RoofPart;
import com.shengchanshe.chang_sheng_jue.block.cropper.HordeumBlock;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed.ArhatBed;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed.ArhatBedSection;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed.CanopyBed;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.folding_screen.FoldingScreen;
import com.shengchanshe.chang_sheng_jue.block.custom.lantern.HeightLightStand;
import com.shengchanshe.chang_sheng_jue.block.custom.lantern.Lantern;
import com.shengchanshe.chang_sheng_jue.block.custom.racks.ClothesRack;
import com.shengchanshe.chang_sheng_jue.block.custom.tile.*;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.*;
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
        blockWithItem(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK);
        blockWithItem(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK);
        blockWithItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK);
        blockWithItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK);
        blockWithItem(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK);
        blockWithItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK);
        blockWithItem(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK);

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
        horizontalBlock(ChangShengJueBlocks.JUNGLE_DRINKING_TABLE_AND_CHAIRS.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_drinking_table_and_chairs")));
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
        //方凳
        horizontalBlock(ChangShengJueBlocks.BIRCH_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_square_stool")));
        horizontalBlock(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_square_stool")));
        horizontalBlock(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_square_stool")));
        horizontalBlock(ChangShengJueBlocks.WARPED_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_square_stool")));
        horizontalBlock(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_square_stool")));
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_square_stool")));
        horizontalBlock(ChangShengJueBlocks.WENGE_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_square_stool")));
        horizontalBlock(ChangShengJueBlocks.ACACIA_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_square_stool")));
        horizontalBlock(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_square_stool")));
        horizontalBlock(ChangShengJueBlocks.OAK_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_square_stool")));
        horizontalBlock(ChangShengJueBlocks.CHERRY_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_square_stool")));
        horizontalBlock(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_square_stool")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_square_stool")));
        //石凳
        horizontalBlock(ChangShengJueBlocks.STONE_BENCH.get(), new ModelFile.UncheckedModelFile(modLoc("block/stone_bench")));
        horizontalBlock(ChangShengJueBlocks.STONE_TABLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/stone_table")));
        //置物格
        simpleBlock(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_fretwork_openwork_panel")));
        simpleBlock(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_fretwork_openwork_panel")));
        //书格
        simpleBlock(ChangShengJueBlocks.BIRCH_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_book_grid")));
        simpleBlock(ChangShengJueBlocks.JUNGLE_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_book_grid")));
        simpleBlock(ChangShengJueBlocks.CRIMSON_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_book_grid")));
        simpleBlock(ChangShengJueBlocks.WARPED_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_book_grid")));
        simpleBlock(ChangShengJueBlocks.MANGROVE_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_book_grid")));
        simpleBlock(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_book_grid")));
        simpleBlock(ChangShengJueBlocks.WENGE_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_book_grid")));
        simpleBlock(ChangShengJueBlocks.ACACIA_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_book_grid")));
        simpleBlock(ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_book_grid")));
        simpleBlock(ChangShengJueBlocks.OAK_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_book_grid")));
        simpleBlock(ChangShengJueBlocks.CHERRY_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_book_grid")));
        simpleBlock(ChangShengJueBlocks.SPRUCE_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_book_grid")));
        simpleBlock(ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_book_grid")));
        //亮格
        simpleBlock(ChangShengJueBlocks.BIRCH_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_liangge")));
        simpleBlock(ChangShengJueBlocks.JUNGLE_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_liangge")));
        simpleBlock(ChangShengJueBlocks.CRIMSON_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_liangge")));
        simpleBlock(ChangShengJueBlocks.WARPED_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_liangge")));
        simpleBlock(ChangShengJueBlocks.MANGROVE_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_liangge")));
        simpleBlock(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_liangge")));
        simpleBlock(ChangShengJueBlocks.WENGE_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_liangge")));
        simpleBlock(ChangShengJueBlocks.ACACIA_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_liangge")));
        simpleBlock(ChangShengJueBlocks.DARK_OAK_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_liangge")));
        simpleBlock(ChangShengJueBlocks.OAK_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_liangge")));
        simpleBlock(ChangShengJueBlocks.CHERRY_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_liangge")));
        simpleBlock(ChangShengJueBlocks.SPRUCE_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_liangge")));
        simpleBlock(ChangShengJueBlocks.ZI_TAN_LIANGGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_liangge")));
        //柜子
        simpleBlock(ChangShengJueBlocks.BIRCH_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_cabinet")));
        simpleBlock(ChangShengJueBlocks.JUNGLE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_cabinet")));
        simpleBlock(ChangShengJueBlocks.CRIMSON_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_cabinet")));
        simpleBlock(ChangShengJueBlocks.WARPED_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_cabinet")));
        simpleBlock(ChangShengJueBlocks.MANGROVE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_cabinet")));
        simpleBlock(ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_cabinet")));
        simpleBlock(ChangShengJueBlocks.WENGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_cabinet")));
        simpleBlock(ChangShengJueBlocks.ACACIA_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_cabinet")));
        simpleBlock(ChangShengJueBlocks.DARK_OAK_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_cabinet")));
        simpleBlock(ChangShengJueBlocks.OAK_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_cabinet")));
        simpleBlock(ChangShengJueBlocks.CHERRY_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_cabinet")));
        simpleBlock(ChangShengJueBlocks.SPRUCE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_cabinet")));
        simpleBlock(ChangShengJueBlocks.ZI_TAN_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_cabinet")));
        //立柜
        simpleBlock(ChangShengJueBlocks.BIRCH_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.WARPED_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.WENGE_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.ACACIA_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.OAK_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.CHERRY_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_large_cabinet")));
        simpleBlock(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_large_cabinet")));
        //晾衣架
        horizontalBlock(ChangShengJueBlocks.BIRCH_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.JUNGLE_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.CRIMSON_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.WARPED_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.MANGROVE_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.WENGE_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.ACACIA_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.OAK_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.CHERRY_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.SPRUCE_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_drying_rail")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_drying_rail")));

        simpleBlock(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_chest_of_drawers")));
        simpleBlock(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_chest_of_drawers")));
        //茶几
        horizontalBlock(ChangShengJueBlocks.BIRCH_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_teapoy")));
        horizontalBlock(ChangShengJueBlocks.JUNGLE_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_teapoy")));
        horizontalBlock(ChangShengJueBlocks.CRIMSON_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_teapoy")));
        horizontalBlock(ChangShengJueBlocks.WARPED_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_teapoy")));
        horizontalBlock(ChangShengJueBlocks.MANGROVE_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_teapoy")));
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_teapoy")));
        horizontalBlock(ChangShengJueBlocks.WENGE_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_teapoy")));
        horizontalBlock(ChangShengJueBlocks.ACACIA_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_teapoy")));
        horizontalBlock(ChangShengJueBlocks.DARK_OAK_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_teapoy")));
        horizontalBlock(ChangShengJueBlocks.OAK_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_teapoy")));
        horizontalBlock(ChangShengJueBlocks.CHERRY_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_teapoy")));
        horizontalBlock(ChangShengJueBlocks.SPRUCE_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_teapoy")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_teapoy")));
        //太师椅
        horizontalBlock(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.WARPED_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.WENGE_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.OAK_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_taishi_chair")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_taishi_chair")));
        //五围屏宝座
        horizontalBlock(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_five_screen_throne")));
        horizontalBlock(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_five_screen_throne")));
        //蒲团
        horizontalBlock(ChangShengJueBlocks.ZAFU.get(), new ModelFile.UncheckedModelFile(modLoc("block/zafu")));
        //短琉璃瓦
        horizontalBlock(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_short_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE .get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_short_cylinder_tile")));
        //屋脊
        horizontalBlock(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.RED_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.CYAN_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_roof_ridge")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_roof_ridge")));
        //鸱吻
        horizontalBlock(ChangShengJueBlocks.GRE_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.RED_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.CYAN_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_demon_mask")));
        //垂兽脊瓦
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_gre_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_red_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_black_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_golden_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_cyan_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_blue_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/hanging_beast_purple_ridge_tile")));
        //侧筒瓦
        horizontalBlock(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_double_cylinder_tile_side")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_double_cylinder_tile_side")));
        //八角垂脊
        horizontalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_octagonal_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_octagonal_gable_ridge_cylinder_tile")));
        //双层垂脊
        horizontalBlock(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_double_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_double_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_double_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_double_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_double_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_double_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_double_gable_ridge_cylinder_tile")));
        //双层垂兽
        horizontalBlock(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_double_hanging_beast_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_double_hanging_beast_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_double_hanging_beast_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_double_hanging_beast_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_double_hanging_beast_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_double_hanging_beast_gable_ridge_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_double_hanging_beast_gable_ridge_cylinder_tile")));
        //栏杆
        horizontalBlock(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/white_jade_guardrail")));
//        wallBlock(((WallBlock) ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get()), new ResourceLocation(ChangShengJue.MOD_ID,"block/white_jade_balustrade"));

        createHangingBlock(ChangShengJueBlocks.LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.WHITE_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/white_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/white_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/white_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.ORANGE_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/orange_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/orange_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/orange_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.MAGENTA_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/magenta_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/magenta_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/magenta_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.LIGHT_BLUE_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/light_blue_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/light_blue_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/light_blue_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.YELLOW_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/yellow_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/yellow_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/yellow_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.LIME_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/lime_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/lime_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/lime_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.PINK_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/pink_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/pink_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/pink_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.GRAY_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/gray_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/gray_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/gray_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.LIGHT_GRAY_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/light_gray_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/light_gray_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/light_gray_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.CYAN_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/cyan_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/cyan_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/cyan_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.PURPLE_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/purple_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/purple_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/purple_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.BLUE_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/blue_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/blue_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/blue_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.BROWN_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/brown_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/brown_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/brown_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.GREEN_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/green_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/green_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/green_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.RED_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/red_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/red_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/red_lantern_lay")));
        createHangingBlock(ChangShengJueBlocks.BLACK_LANTERN.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/black_lantern")),
                new ModelFile.UncheckedModelFile(modLoc("block/black_lantern_hanging")),
                new ModelFile.UncheckedModelFile(modLoc("block/black_lantern_lay")));

        simpleBlockWithItem(ChangShengJueBlocks.BIRCH_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/birch_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.JUNGLE_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/jungle_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.CRIMSON_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/crimson_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.WARPED_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/warped_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.MANGROVE_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/mangrove_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/huang_hua_li_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.WENGE_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/wenge_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.ACACIA_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/acacia_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/dark_oak_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.OAK_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/oak_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.CHERRY_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/cherry_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.SPRUCE_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/spruce_light_stand")));
        simpleBlockWithItem(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND.get(), new ModelFile.UncheckedModelFile(modLoc("block/zi_tan_light_stand")));

        createHighHorizontalBlock(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.WARPED_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.WENGE_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);
        createHighHorizontalBlock(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.get(), FoldingScreen.FACING, FoldingScreen.PART, FoldingScreen.RIGHT);

        createTileBaffleBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        createTileBaffleBlock(ChangShengJueBlocks.RED_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        createTileBaffleBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        createTileBaffleBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        createTileBaffleBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        createTileBaffleBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        createTileBaffleBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get(), HalfCylinderTile.FACING, HalfCylinderTile.BAFFLE, HalfCylinderTile.LAYERS);
        //侧琉璃瓦
        createTileSideBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        //蹲兽脊瓦
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        //瓦当
        horizontalBlock(ChangShengJueBlocks.GRE_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_eaves_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_eaves_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_eaves_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_eaves_tile")));
        horizontalBlock(ChangShengJueBlocks.CYAN_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_eaves_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_eaves_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_EAVES_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_eaves_tile")));
        //侧瓦当
        horizontalBlock(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_eaves_tile_side")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_eaves_tile_side")));
        //双层琉璃瓦
        createDoubleTileBaffleBlock(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        createDoubleTileBaffleBlock(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        createDoubleTileBaffleBlock(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        createDoubleTileBaffleBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        createDoubleTileBaffleBlock(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        createDoubleTileBaffleBlock(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        createDoubleTileBaffleBlock(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get(),BaffleCylinderTile.FACING,BaffleCylinderTile.BAFFLE);
        //小鸱吻
        horizontalBlock(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_small_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_small_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_small_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_small_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_small_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_small_demon_mask")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_small_demon_mask")));
        //双层脊瓦
        horizontalBlock(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_double_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_double_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_double_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_double_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_double_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_double_ridge_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_double_ridge_tile")));
        //飞檐
        horizontalBlock(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/gre_eaves_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/red_eaves_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_eaves_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_eaves_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/cyan_eaves_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/blue_eaves_cylinder_tile")));
        horizontalBlock(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get(), new ModelFile.UncheckedModelFile(modLoc("block/purple_eaves_cylinder_tile")));
        //脊瓦
        createTileSideBlock(ChangShengJueBlocks.GRE_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.RED_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.BLACK_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.CYAN_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.BLUE_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        createTileSideBlock(ChangShengJueBlocks.PURPLE_RIDGE_TILE.get(), HalfAnimalsCylinderTile.FACING, HalfAnimalsCylinderTile.LAYERS);
        //脊刹
        createDoubleBlock(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);

        createDoubleBlock(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        createDoubleBlock(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get(),Pavilion.FACING,Pavilion.HALF);
        //攒尖
        createHighHorizontalBlock(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        createHighHorizontalBlock(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        createHighHorizontalBlock(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        createHighHorizontalBlock(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        createHighHorizontalBlock(ChangShengJueBlocks.CYAN_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        createHighHorizontalBlock(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        createHighHorizontalBlock(ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get(), HippedRoof.FACING, HippedRoof.PART);
        //侧向飞檐
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get(),OctagonalUpturnedEaves.FACING,OctagonalUpturnedEaves.LEFT);
        //八角矮垂脊(前)
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        //八角矮垂脊(后)
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),OctagonalDwarfRidgeTiles.FACING,OctagonalDwarfRidgeTiles.LEFT);
        //八角高垂脊(前)
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        //八角高垂脊(后)
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        //八角双层垂脊(前)
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        //八角双层垂脊(后)
        createOctagonalBlock(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        createOctagonalBlock(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),OctagonalDoubleGableRidgeCylinderTile.FACING,OctagonalDoubleGableRidgeCylinderTile.LEFT);
        //台阶
        slabBlock((SlabBlock) ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get()));
        slabBlock((SlabBlock) ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get(),blockTexture(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get()), blockTexture(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get()));
        //片瓦(飞檐)
        horizontalBlock(ChangShengJueBlocks.GOLDEN_CORNICES.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_cornices")));
        horizontalBlock(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get(), new ModelFile.UncheckedModelFile(modLoc("block/golden_gentle_cornices")));
        horizontalBlock(ChangShengJueBlocks.BLACK_CORNICES.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_cornices")));
        horizontalBlock(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get(), new ModelFile.UncheckedModelFile(modLoc("block/black_gentle_cornices")));
        //罗汉床
        createLongHorizontalBlock(ChangShengJueBlocks.BIRCH_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.JUNGLE_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.CRIMSON_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.WARPED_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.MANGROVE_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.WENGE_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.ACACIA_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.OAK_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.CHERRY_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.SPRUCE_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        createLongHorizontalBlock(ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get(), ArhatBed.FACING, ArhatBed.BED_SECTION);
        //高灯架
        createHeightLightStandBlock(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        createHeightLightStandBlock(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.get(), HeightLightStand.FACING, HeightLightStand.PART);
        //衣架
        createClothesRackBlock(ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.WARPED_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.WENGE_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.OAK_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        createClothesRackBlock(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get(), ClothesRack.FACING, ClothesRack.HALF);
        //架子床
        createCanopyBedBlock(ChangShengJueBlocks.BIRCH_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.JUNGLE_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.CRIMSON_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.WARPED_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.MANGROVE_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.WENGE_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.ACACIA_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.DARK_OAK_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.OAK_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.CHERRY_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.SPRUCE_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
        createCanopyBedBlock(ChangShengJueBlocks.ZI_TAN_CANOPY_BED.get(), CanopyBed.FACING, CanopyBed.SECTION);
    }

    private void createClothesRackBlock(Block block, DirectionProperty facing, EnumProperty<DoubleBlockHalf> part){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    model = switch (state.getValue(part)) {
                        case UPPER ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_top"));
                        case LOWER ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_bottom"));
                    };
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void createHeightLightStandBlock(Block block,DirectionProperty facing, EnumProperty<HeightLightStand.HeightLightStandSection> part){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    model = switch (state.getValue(part)) {
                        case BOTTOM ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_bottom"));
                        case MIDDLE1 ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_middle1"));
                        case MIDDLE2 ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_middle2"));
                        case TOP ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_top"));
                        case TOP_LEFT ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_top_left"));
                    };
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createLongHorizontalBlock(Block block, DirectionProperty facing, EnumProperty<ArhatBedSection> part){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    model = switch (state.getValue(part)) {
                        case HEAD ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head"));
                        case BODY ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_body"));
                        case FOOT ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot"));
                    };
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }


    private void createCanopyBedBlock(Block block, DirectionProperty facing, EnumProperty<CanopyBed.CanopyBedSection> part){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    model = switch (state.getValue(part)) {
                        case HEAD_FRONT_TOP -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head_front_top"));
                        case HEAD_REAR_TOP -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head_rear_top"));
                        case HEAD_FRONT_MIDDLE -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head_front_middle"));
                        case HEAD_REAR_MIDDLE -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head_rear_middle"));
                        case HEAD_FRONT_BOTTOM -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head_front_bottom"));
                        case HEAD_REAR_BOTTOM -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_head_rear_bottom"));
                        case BODY_FRONT_TOP -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_body_front_top"));
                        case BODY_REAR_TOP -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_body_rear_top"));
                        case BODY_REAR_MIDDLE -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_body_rear_middle"));
                        case BODY_FRONT_BOTTOM -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_body_front_bottom"));
                        case BODY_REAR_BOTTOM -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_body_rear_bottom"));
                        case FOOT_FRONT_TOP -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot_front_top"));
                        case FOOT_REAR_TOP -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot_rear_top"));
                        case FOOT_FRONT_MIDDLE -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot_front_middle"));
                        case FOOT_REAR_MIDDLE -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot_rear_middle"));
                        case FOOT_FRONT_BOTTOM -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot_front_bottom"));
                        case FOOT_REAR_BOTTOM -> new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_foot_rear_bottom"));
                    };
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createDoubleBlock(Block block,DirectionProperty facing, EnumProperty<DoubleBlockHalf> half){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    if (state.getValue(half) == DoubleBlockHalf.UPPER) {
                        model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_top"));
                    }else {
                        model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_bottom"));
                    }
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createDoubleTileBaffleBlock(Block block, DirectionProperty facing, BooleanProperty baffle){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                        if (state.getValue(baffle)) {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_baffle"));
                        }else {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath()));
                        }
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createTileSideBlock(Block block,DirectionProperty facing,IntegerProperty value){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    if (state.getValue(value) == 2){
                        model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_height2"));
                    }else if (state.getValue(value) == 3){
                        model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_height3"));
                    }else {
                        model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_height1"));
                    }
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createTileBaffleBlock(Block block,DirectionProperty facing, BooleanProperty baffle, IntegerProperty value){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    if (state.getValue(value) == 2){
                        if (state.getValue(baffle)) {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_baffle_height2"));
                        }else {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_height2"));
                        }
                    }else if (state.getValue(value) == 3){
                        if (state.getValue(baffle)) {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_baffle_height3"));
                        }else {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_height3"));
                        }
                    }else {
                        if (state.getValue(baffle)) {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_baffle_height1"));
                        }else {
                            model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_height1"));
                        }
                    }
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createHighHorizontalBlock(Block block,DirectionProperty facing, EnumProperty<RoofPart> part){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    model = switch (state.getValue(part)) {
                        case BOTTOM ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_bottom"));
                        case MIDDLE ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_middle"));
                        case TOP ->
                                new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_top"));
                    };
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createHighHorizontalBlock(Block block,DirectionProperty facing,EnumProperty<RoofPart> part, BooleanProperty rightProperty){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    if (state.getValue(rightProperty)){
                        model = switch (state.getValue(part)) {
                            case BOTTOM ->
                                    new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_right_bottom"));
                            case MIDDLE ->
                                    new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_right_middle"));
                            case TOP ->
                                    new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_right_top"));
                        };
                    }else {
                        model = switch (state.getValue(part)) {
                            case BOTTOM ->
                                    new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_left_bottom"));
                            case MIDDLE ->
                                    new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_left_middle"));
                            case TOP ->
                                    new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_left_top"));
                        };
                    }
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private int getRotationY(Direction facing) {
        return switch (facing) {
            case EAST -> 90;
            case SOUTH -> 180;
            case WEST -> 270;
            default -> 0; // NORTH
        };
    }

    private void createOctagonalBlock(Block block,DirectionProperty facing, BooleanProperty rightProperty){
        getVariantBuilder(block)
                .forAllStates(state -> {
                    ModelFile model;
                    if (state.getValue(rightProperty)){
                        model = new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_right"));
                    } else {
                        model =  new ModelFile.UncheckedModelFile(modLoc("block/" + this.key(block).getPath() + "_left"));
                    }
                    return ConfiguredModel.builder().modelFile(model).rotationY(getRotationY(state.getValue(facing))).build();
                });
    }

    private void createHangingBlock(Block block, ModelFile defaultState, ModelFile hangingState, ModelFile layState) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean hanging = state.getValue(Lantern.HANGING);
            boolean lay = state.getValue(Lantern.LAY);

            if (hanging && lay) {
                return ConfiguredModel.builder().modelFile(hangingState).build();
            } else if (hanging) {
                return ConfiguredModel.builder().modelFile(hangingState).build();
            } else if (lay) {
                return ConfiguredModel.builder().modelFile(layState).build();
            } else {
                return ConfiguredModel.builder().modelFile(defaultState).build();
            }
        });
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
