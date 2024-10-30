package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class CSJBlockStateProvider extends BlockStateProvider {

    public CSJBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ChangShengJue.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ChangShengJueBlocks.AG_ORE.get());
        simpleBlock(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get());
        blockWithItem(ChangShengJueBlocks.AG_ORE);
        blockWithItem(ChangShengJueBlocks.DEEPSLATE_AG_ORE);

        simpleBlock(ChangShengJueBlocks.KAOLIN_ORE.get());
        blockWithItem(ChangShengJueBlocks.KAOLIN_ORE);

        simpleBlock(ChangShengJueBlocks.POPLAR_LEAVES.get());
        blockWithItem(ChangShengJueBlocks.POPLAR_LEAVES);

//        simpleBlock(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),new ModelFile.UncheckedModelFile(modLoc("block/blue_and_white_porcelain_flower_pots")));
//        simpleBlockItem(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),new ModelFile.UncheckedModelFile(modLoc("block/blue_and_white_porcelain_flower_pots")));
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
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),models().singleTexture("potted_kochia_scoparia_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.SOLIDAGO.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),models().singleTexture("potted_shui_xian_block",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.GEUM_TRIFLORUM.get())).renderType("cutout"));
        simpleBlockWithItem(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),models().singleTexture("potted_purple_dandelion",new ResourceLocation("flower_pot_cross"),"plant",
                blockTexture(ChangShengJueBlocks.PURPLE_DANDELION.get())).renderType("cutout"));

        horizontalBlock(ChangShengJueBlocks.TOOL_TABLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/tool_table")));
        horizontalBlock(ChangShengJueBlocks.DESK.get(), new ModelFile.UncheckedModelFile(modLoc("block/desk")));
    }

    public void blockWithItem(RegistryObject<Block> block){
        simpleBlockItem(block.get(),cubeAll(block.get()));
    }
}
