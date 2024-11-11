package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class CSJItemModelProvider extends ItemModelProvider {

    public CSJItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ChangShengJueItems.TONG_QIAN);
        simpleItem(ChangShengJueItems.YI_GUAN_TONG_QIAN);
        simpleItem(ChangShengJueItems.SILK);
        simpleItem(ChangShengJueItems.MULBERRY);
        simpleItem(ChangShengJueItems.RICE);
        simpleItem(ChangShengJueItems.BILUOCHUN_TEA);
        simpleItem(ChangShengJueItems.BILUOCHUN_TEA_SEEDS);
        simpleItem(ChangShengJueItems.LONG_JING_TEA);
        simpleItem(ChangShengJueItems.LONG_JING_TEA_SEEDS);

        simpleItem(ChangShengJueItems.HORDEUM);
        simpleItem(ChangShengJueItems.HORDEUM_SEEDS);

        handheldItem(ChangShengJueItems.BRONZE_SWORD);
        handheldItem(ChangShengJueItems.HAN_JIAN);
        handheldItem(ChangShengJueItems.KITCHEN_KNIFE);
        bullionsItem(ChangShengJueItems.SILVER_BULLIONS);
        bullionsItem(ChangShengJueItems.GOLD_BULLIONS);

        saplingItem(ChangShengJueBlocks.MULBERRY_SAPLING);
    }
    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/"+item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/"+item.getId().getPath()));
    }

    private ItemModelBuilder bullionsItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID + ":item/bullions")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/"+item.getId().getPath()));
    }
}
