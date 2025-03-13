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
        simpleItem(ChangShengJueItems.EMPTY_FEN_JIU);

        //食物
        simpleItem(ChangShengJueItems.PEACOCK);
        simpleItem(ChangShengJueItems.COOKED_PEACOCK);
        simpleItem(ChangShengJueItems.CROC);
        simpleItem(ChangShengJueItems.COOKED_CROC);

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
        simpleItem(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING);
        simpleItem(ChangShengJueItems.QIAN_KUN_DA_NUO_YI);

        //护甲
        //棉甲
        simpleArmorItem(ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET);
        simpleArmorItem(ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET);
        simpleArmorItem(ChangShengJueItems.COTTON_ARMOR_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.COTTON_ARMOR_LEGGINGS);
        simpleArmorItem(ChangShengJueItems.COTTON_ARMOR_BOOTS);
        //道袍
        simpleItem(ChangShengJueItems.FEMALE_TAOIST_ROBES_HELMET);
        simpleArmorItem(ChangShengJueItems.MALE_TAOIST_ROBES_HELMET);
        simpleArmorItem(ChangShengJueItems.FEMALE_TAOIST_ROBES_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.MALE_TAOIST_ROBES_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.TAOIST_ROBES_BOOTS);
        //丝绸裤裤
        simpleArmorItem(ChangShengJueItems.SILK_LEGGINGS);
        //婚服
        simpleArmorItem(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_HELMET);
        simpleItem(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_HELMET);
        simpleArmorItem(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.CHINESE_WEDDING_DRESS_BOOTS);
        //山文甲
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_HELMET);
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_CHESTPLATE);
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_LEGGINGS);
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR_BOOTS);
        //飞鱼服
        simpleItem(ChangShengJueItems.FLYING_FISH_ROBE_HELMET_0);
        simpleArmorItem(ChangShengJueItems.FLYING_FISH_ROBE_HELMET_1);
        simpleArmorItem(ChangShengJueItems.FLYING_FISH_ROBE_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.FLYING_FISH_ROBE_BOOTS);
        //行者套
        simpleItem(ChangShengJueItems.WALKER_SET_HELMET_0);
        simpleItem(ChangShengJueItems.WALKER_SET_HELMET_1);
        simpleItem(ChangShengJueItems.WALKER_SET_CHESTPLATE);
        simpleItem(ChangShengJueItems.WALKER_SET_LEGGINGS);
        simpleItem(ChangShengJueItems.WALKER_SET_BOOTS);
        //齐天大圣套
        simpleItem(ChangShengJueItems.QI_TIAN_DA_SHENG_HELMET);
        simpleItem(ChangShengJueItems.QI_TIAN_DA_SHENG_CHESTPLATE);
        simpleItem(ChangShengJueItems.QI_TIAN_DA_SHENG_LEGGINGS);
        simpleItem(ChangShengJueItems.QI_TIAN_DA_SHENG_BOOTS);
        //大将军明光铠
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_HELMET);
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_CHESTPLATE);
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_LEGGINGS);
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MINGGUANG_ARMOR_BOOTS);
        //儒装
        simpleItem(ChangShengJueItems.CONFUCIAN_COSTUMES_HELMET);
        simpleItem(ChangShengJueItems.CONFUCIAN_COSTUMES_CHESTPLATE);
        simpleItem(ChangShengJueItems.CONFUCIAN_COSTUMES_LEGGINGS);
        simpleItem(ChangShengJueItems.CONFUCIAN_COSTUMES_BOOTS);
        //武器
        handheldItem(ChangShengJueItems.BRONZE_SWORD);
        handheldItem(ChangShengJueItems.HAN_JIAN);
        handheldItem(ChangShengJueItems.KITCHEN_KNIFE);
        handheldItem(ChangShengJueItems.YI_TINA_JIAN);
        handheldItem(ChangShengJueItems.TU_LONG_DAO);
        handheldItem(ChangShengJueItems.THROWING_KNIVES);
        handheldItem(ChangShengJueItems.THREE_THROWING_KNIVES);
        handheldItem(ChangShengJueItems.SEVEN_THROWING_KNIVES);
        //工具
        handheldItem(ChangShengJueItems.KAISHAN_PICKAXE);
        handheldItem(ChangShengJueItems.XUANHUA_AXE);

        bullionsItem(ChangShengJueItems.SILVER_BULLIONS);
        bullionsItem(ChangShengJueItems.GOLD_BULLIONS);

        saplingItem(ChangShengJueBlocks.MULBERRY_SAPLING);

        parentItem(ChangShengJueBlocks.BIRCH_BENCH);
        parentItem(ChangShengJueBlocks.CRIMSON_BENCH);
        parentItem(ChangShengJueBlocks.WARPED_BENCH);
        parentItem(ChangShengJueBlocks.MANGROVE_BENCH);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_BENCH);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_BENCH);
        parentItem(ChangShengJueBlocks.ACACIA_BENCH);
        parentItem(ChangShengJueBlocks.DARK_OAK_BENCH);
        parentItem(ChangShengJueBlocks.OAK_BENCH);
        parentItem(ChangShengJueBlocks.CHERRY_BENCH);
        parentItem(ChangShengJueBlocks.SPRUCE_BENCH);
        parentItem(ChangShengJueBlocks.ZI_TAN_BENCH);
        //家具
        parentItem(ChangShengJueBlocks.BIRCH_WINE_TABLE);
        parentItem(ChangShengJueBlocks.CRIMSON_WINE_TABLE);
        parentItem(ChangShengJueBlocks.WARPED_WINE_TABLE);
        parentItem(ChangShengJueBlocks.MANGROVE_WINE_TABLE);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE);
        parentItem(ChangShengJueBlocks.ACACIA_WINE_TABLE);
        parentItem(ChangShengJueBlocks.DARK_OAK_WINE_TABLE);
        parentItem(ChangShengJueBlocks.OAK_WINE_TABLE);
        parentItem(ChangShengJueBlocks.CHERRY_WINE_TABLE);
        parentItem(ChangShengJueBlocks.SPRUCE_WINE_TABLE);
        parentItem(ChangShengJueBlocks.ZI_TAN_WINE_TABLE);

        parentItem(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS);
        parentItem(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS);

        parentItem(ChangShengJueBlocks.BIRCH_BOOK_DESK);
        parentItem(ChangShengJueBlocks.CRIMSON_BOOK_DESK);
        parentItem(ChangShengJueBlocks.WARPED_BOOK_DESK);
        parentItem(ChangShengJueBlocks.MANGROVE_BOOK_DESK);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK);
        parentItem(ChangShengJueBlocks.ACACIA_BOOK_DESK);
        parentItem(ChangShengJueBlocks.DARK_OAK_BOOK_DESK);
        parentItem(ChangShengJueBlocks.OAK_BOOK_DESK);
        parentItem(ChangShengJueBlocks.CHERRY_BOOK_DESK);
        parentItem(ChangShengJueBlocks.SPRUCE_BOOK_DESK);
        parentItem(ChangShengJueBlocks.ZI_TAN_BOOK_DESK);

        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_TEAPOY);
        parentItem(ChangShengJueBlocks.ZI_TAN_TEAPOY);

        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR);

        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE);

        parentItem(ChangShengJueBlocks.BIRCH_LOW_DESK);
        parentItem(ChangShengJueBlocks.CRIMSON_LOW_DESK);
        parentItem(ChangShengJueBlocks.WARPED_LOW_DESK);
        parentItem(ChangShengJueBlocks.MANGROVE_LOW_DESK);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK);
        parentItem(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK);
        parentItem(ChangShengJueBlocks.ACACIA_LOW_DESK);
        parentItem(ChangShengJueBlocks.DARK_OAK_LOW_DESK);
        parentItem(ChangShengJueBlocks.OAK_LOW_DESK);
        parentItem(ChangShengJueBlocks.CHERRY_LOW_DESK);
        parentItem(ChangShengJueBlocks.SPRUCE_LOW_DESK);
        parentItem(ChangShengJueBlocks.ZI_TAN_LOW_DESK);

        parentItem(ChangShengJueBlocks.ZAFU);

        //窗户
        simpleItem(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS,ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.getId().getPath());
        simpleItem(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS,ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.getId().getPath());
        simpleItem(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS,ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.getId().getPath());
        simpleItem(ChangShengJueBlocks.HIGH_OAK_WINDOWS,ChangShengJueBlocks.HIGH_OAK_WINDOWS.getId().getPath());
        simpleItem(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS,ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.getId().getPath());

        //城门
        simpleItem(ChangShengJueBlocks.SHING_MUN_RIGHT,ChangShengJueBlocks.SHING_MUN_RIGHT.getId().getPath());
        simpleItem(ChangShengJueBlocks.BIG_SHING_MUN_LEFT,ChangShengJueBlocks.SHING_MUN_LEFT.getId().getPath());
        simpleItem(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT,ChangShengJueBlocks.SHING_MUN_RIGHT.getId().getPath());

        parentItem(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7);
        parentItem(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7);
        parentItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7);
        parentItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7);
        parentItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7);

        parentItem(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8);
        parentItem(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8);
        parentItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8);
        parentItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8);
        parentItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8);

        parentItem(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB);

        parentItem(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE);

        parentItem(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1);
        parentItem(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1);
        parentItem(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1);
        parentItem(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1);
        parentItem(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1);

        parentItem(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE);

        parentItem(ChangShengJueBlocks.GRE_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.RED_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.BLACK_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.BLUE_ROOF_RIDGE);

        parentItem(ChangShengJueBlocks.GRE_DEMON_MASK);
        parentItem(ChangShengJueBlocks.RED_DEMON_MASK);
        parentItem(ChangShengJueBlocks.BLACK_DEMON_MASK);
        parentItem(ChangShengJueBlocks.GOLDEN_DEMON_MASK);
        parentItem(ChangShengJueBlocks.BLUE_DEMON_MASK);

        parentItem(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION);
        parentItem(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION);
        parentItem(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION);
        parentItem(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION);
        parentItem(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION);

        parentItem(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION);
        parentItem(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION);
        parentItem(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION);
        parentItem(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION);
        parentItem(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION);

        parentItem(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
    }

    private ItemModelBuilder parentItem(RegistryObject<Block> block){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/"+block.getId().getPath()));
    }
    //多模型方块物品选择
    private ItemModelBuilder parentItem(RegistryObject<Block> block,String path){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + path));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"block/" + block.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/"+item.getId().getPath()));
    }

    //自定义物品路径json
    private ItemModelBuilder simpleItem(RegistryObject<Block> item,String path) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/"+path));
    }

    private ItemModelBuilder simpleArmorItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(ChangShengJue.MOD_ID,"item/"+item.getId().getPath()))
                .texture("layer1", new ResourceLocation(ChangShengJue.MOD_ID,"item/"+item.getId().getPath()+"_overlay"));
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
