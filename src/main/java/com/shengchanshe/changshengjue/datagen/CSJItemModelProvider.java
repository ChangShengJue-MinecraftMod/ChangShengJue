package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
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

        handheldItem(ChangShengJueItems.BRONZE_SWORD);
        handheldItem(ChangShengJueItems.HAN_JIAN);
        handheldItem(ChangShengJueItems.KITCHEN_KNIFE);
        bullionsItem(ChangShengJueItems.SILVER_BULLIONS);
        bullionsItem(ChangShengJueItems.GOLD_BULLIONS);
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
