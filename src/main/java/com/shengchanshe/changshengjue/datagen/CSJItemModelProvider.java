package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
        simpleItem(ChangShengJueItems.NATURAL_SILK);
        simpleItem(ChangShengJueItems.SILK);
        simpleItem(ChangShengJueItems.MULBERRY);
        simpleItem(ChangShengJueItems.RICE);
        simpleItem(ChangShengJueItems.BILUOCHUN_TEA);
        simpleItem(ChangShengJueItems.BILUOCHUN_TEA_SEEDS);
        simpleItem(ChangShengJueItems.LONG_JING_TEA);
        simpleItem(ChangShengJueItems.LONG_JING_TEA_SEEDS);

        simpleItem(ChangShengJueItems.MULBERRY_JUICE);
        simpleItem(ChangShengJueItems.APPLE_JUICE);
        simpleItem(ChangShengJueItems.HOT_PEAR_SOUP);
        simpleItem(ChangShengJueItems.GRAPE_JUICE);

        simpleItem(ChangShengJueItems.HORDEUM);
        simpleItem(ChangShengJueItems.HORDEUM_SEEDS);

        simpleItem(ChangShengJueItems.CI_BEI);
        simpleItem(ChangShengJueItems.WHITE_PEACOCK_FEATHERS);

        simpleItem(ChangShengJueItems.QUICKLIME);
        simpleItem(ChangShengJueItems.LIME_SLURRY_BARRELS);
        simpleItem(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS);
        simpleItem(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS);

        simpleItem(ChangShengJueItems.BLACK_BRICKS);
        simpleItem(ChangShengJueItems.WHITE_BRICKS_ITEM);
        simpleItem(ChangShengJueItems.GOLD_BRICKS);

        simpleItem(ChangShengJueItems.CRUCIBLE);
        simpleItem(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER);
        simpleItem(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER);
        simpleItem(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD);
        simpleItem(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER);
        simpleItem(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER);
        simpleItem(ChangShengJueItems.CRUCIBLE_LIQUID_GOLD);

        simpleItem(ChangShengJueItems.PAINT_BRUSH);

        simpleItem(ChangShengJueItems.THATCH);

        simpleItem(ChangShengJueItems.BILUOCHUN_TEAS);
        simpleItem(ChangShengJueItems.LONG_JING_TEAS);
        simpleItem(ChangShengJueItems.FEN_JIU);
        simpleItem(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE);
        simpleItem(ChangShengJueItems.SHI_LI_XIANG);
        //武功秘籍
        simpleItem(ChangShengJueItems.IMMORTAL_MIRACLE);
        simpleItem(ChangShengJueItems.HERCULES);
        simpleItem(ChangShengJueItems.DUGU_NINE_SWORDS);
        simpleItem(ChangShengJueItems.GAO_MARKSMANSHIP);
        simpleItem(ChangShengJueItems.GE_SHAN_DA_NIU);
        simpleItem(ChangShengJueItems.TURTLE_BREATH_WORK);
        simpleItem(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD);
        simpleItem(ChangShengJueItems.GOLDEN_BELL_JAR);
        simpleItem(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN);
        simpleItem(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA);
        simpleItem(ChangShengJueItems.PAODING);
        simpleItem(ChangShengJueItems.SHAOLIN_STICK_METHOD);
        simpleItem(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE);
        simpleItem(ChangShengJueItems.RELENTLESS_THROWING_KNIVES);
        simpleItem(ChangShengJueItems.WU_GANG_CUT_GUI);
        simpleItem(ChangShengJueItems.XUANNU_SWORDSMANSHIP);
        simpleItem(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS);
        simpleItem(ChangShengJueItems.ZHANG_MEN_XIN_XUE);

        //护甲
        //棉甲
        simpleItem(ChangShengJueItems.BLUE_COTTON_ARMOR_HELMET);
        simpleItem(ChangShengJueItems.BLUE_COTTON_ARMOR_CHESTPLATE);
        simpleItem(ChangShengJueItems.BLUE_COTTON_ARMOR_LEGGINGS);
        simpleItem(ChangShengJueItems.COTTON_ARMOR_BOOTS);
        simpleItem(ChangShengJueItems.RED_COTTON_ARMOR_HELMET);
        simpleItem(ChangShengJueItems.RED_COTTON_ARMOR_CHESTPLATE);
        simpleItem(ChangShengJueItems.RED_COTTON_ARMOR_LEGGINGS);
        //道袍
        simpleItem(ChangShengJueItems.FEMALE_TAOIST_ROBES_HELMET);
        simpleItem(ChangShengJueItems.FEMALE_TAOIST_ROBES_CHESTPLATE);
        simpleItem(ChangShengJueItems.FEMALE_TAOIST_ROBES_LEGGINGS);
        simpleItem(ChangShengJueItems.FEMALE_TAOIST_ROBES_BOOTS);
        simpleItem(ChangShengJueItems.MALE_TAOIST_ROBES_HELMET);
        simpleItem(ChangShengJueItems.MALE_TAOIST_ROBES_CHESTPLATE);
        simpleItem(ChangShengJueItems.MALE_TAOIST_ROBES_LEGGINGS);
        simpleItem(ChangShengJueItems.MALE_TAOIST_ROBES_BOOTS);
        //婚服
        simpleItem(ChangShengJueItems.CHINESE_WEDDING_DRESS_HELMET);
        simpleItem(ChangShengJueItems.CHINESE_WEDDING_DRESS_CHESTPLATE);
        simpleItem(ChangShengJueItems.CHINESE_WEDDING_DRESS_LEGGINGS);
        simpleItem(ChangShengJueItems.CHINESE_WEDDING_DRESS_BOOTS);
        simpleItem(ChangShengJueItems.RED_DRESS_HELMET);
        simpleItem(ChangShengJueItems.RED_DRESS_CHESTPLATE);
        simpleItem(ChangShengJueItems.RED_DRESS_LEGGINGS);
        simpleItem(ChangShengJueItems.RED_DRESS_BOOTS);
        //武器
        handheldItem(ChangShengJueItems.BRONZE_SWORD);
        handheldItem(ChangShengJueItems.HAN_JIAN);
        handheldItem(ChangShengJueItems.KITCHEN_KNIFE);
        handheldItem(ChangShengJueItems.YI_TINA_JIAN);
        handheldItem(ChangShengJueItems.TU_LONG_DAO);
        handheldItem(ChangShengJueItems.THROWING_KNIVES);
        handheldItem(ChangShengJueItems.THREE_THROWING_KNIVES);
        handheldItem(ChangShengJueItems.SEVEN_THROWING_KNIVES);

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
