package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class  CSJBlockStateProvider extends BlockStateProvider {

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

        horizontalBlock(ChangShengJueBlocks.TOOL_TABLE.get(), new ModelFile.UncheckedModelFile(modLoc("block/tool_table")));
        horizontalBlock(ChangShengJueBlocks.DESK.get(), new ModelFile.UncheckedModelFile(modLoc("block/desk")));
    }

    public void blockWithItem(RegistryObject<Block> block){
        simpleBlockItem(block.get(),cubeAll(block.get()));
    }
}
