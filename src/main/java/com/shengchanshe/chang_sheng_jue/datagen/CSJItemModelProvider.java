package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class CSJItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public CSJItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ChangShengJueItems.TONG_QIAN);
        simpleItem(ChangShengJueItems.YI_GUAN_TONG_QIAN);
        simpleItem(ChangShengJueItems.NATURAL_SILK);
        simpleItem(ChangShengJueItems.SILKWORM);
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
        //情报
        simpleItem(ChangShengJueItems.STRUCTURE_INTELLIGENCE);

        //令牌
        simpleItem(ChangShengJueItems.GANG_TOKEN);

        //食物
        simpleItem(ChangShengJueItems.PEACOCK);
        simpleItem(ChangShengJueItems.COOKED_PEACOCK);
        simpleItem(ChangShengJueItems.CROC);
        simpleItem(ChangShengJueItems.COOKED_CROC);
        //武功经验
        simpleItem(ChangShengJueItems.EXTERNAL_KUNG_FU_XP);
        simpleItem(ChangShengJueItems.INTERNAL_KUNG_FU_XP);
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
        simpleArmorItem(ChangShengJueItems.COTTON_HELMET);
        simpleArmorItem(ChangShengJueItems.WHITE_COTTON_HELMET);
        simpleArmorItem(ChangShengJueItems.COTTON_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.COTTON_LEGGINGS);
        simpleArmorItem(ChangShengJueItems.COTTON_BOOTS);
        //道袍
        simpleItem(ChangShengJueItems.FEMALE_TAOIST_HELMET);
        simpleArmorItem(ChangShengJueItems.MALE_TAOIST_HELMET);
        simpleArmorItem(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.MALE_TAOIST_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.TAOIST_BOOTS);
        //丝绸裤裤
        simpleArmorItem(ChangShengJueItems.TAOIST_LEGGINGS);
        //婚服
        simpleArmorItem(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP);
        simpleItem(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET);
        simpleArmorItem(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU);
        simpleArmorItem(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING);
        simpleArmorItem(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES);
        //山文甲
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD);
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR);
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR);
        simpleItem(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS);
        //飞鱼服
        simpleItem(ChangShengJueItems.FLY_FISH_IRON_HAT);
        simpleArmorItem(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN);
        simpleArmorItem(ChangShengJueItems.FLY_FISH_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.FLY_FISH_LONG_BOOTS);
        //行者套
        simpleItem(ChangShengJueItems.WALKER_GOLD_RING_BAND);
        simpleItem(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT);
        simpleItem(ChangShengJueItems.WALKER_CHESTPLATE);
        simpleItem(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT);
        simpleItem(ChangShengJueItems.WALKER_SHORT_BOOTS);
        //齐天大圣套
        simpleItem(ChangShengJueItems.PHOENIX_FEATHER_CAP);
        simpleItem(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT);
        simpleItem(ChangShengJueItems.TIGER_SKIN_GARMENT);
        simpleItem(ChangShengJueItems.CLOUD_WALKING_BOOTS);
        //大将军明光铠
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET);
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE);
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS);
        simpleItem(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS);
        //儒装
        simpleArmorItem(ChangShengJueItems.CONFUCIAN_HELMET);
        simpleArmorItem(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS);
        simpleArmorItem(ChangShengJueItems.CONFUCIAN_INK_BOOTS);

        //斗笠
        simpleArmorItem(ChangShengJueItems.HATS_WITH_VEIL_HELMET);
        simpleArmorItem(ChangShengJueItems.HATS_WITH_VEIL_CHESTPLATE);

        simpleArmorItem(ChangShengJueItems.HATS_BLACK_ROBE_HELMET);
        simpleArmorItem(ChangShengJueItems.HATS_BLACK_ROBE_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.HATS_BLACK_ROBE_LEGGINGS);

        simpleArmorItem(ChangShengJueItems.DUAN_DA_CHESTPLATE);

        simpleArmorItem(ChangShengJueItems.BUDDHIST_ROBE_CHESTPLATE);

        simpleArmorItem(ChangShengJueItems.NIGHT_SUIT_HELMET);
        simpleArmorItem(ChangShengJueItems.NIGHT_SUIT_CHESTPLATE);

        simpleArmorItem(ChangShengJueItems.LONG_GOWN_CHESTPLATE);
        simpleArmorItem(ChangShengJueItems.NIGHT_SUIT_LEGGINGS);

        simpleItem(ChangShengJueItems.FOREHEAD_BAND_HELMET1);
        simpleItem(ChangShengJueItems.FOREHEAD_BAND_HELMET2);
        simpleItem(ChangShengJueItems.HAIR_CROWN_HELMET1);
        simpleItem(ChangShengJueItems.HAIR_CROWN_HELMET2);

        trimmedArmorItem(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR);
        trimmedArmorItem(ChangShengJueItems.LEATHER_INNER_ARMOR);
        //武器
        handheldItem(ChangShengJueItems.THROWING_KNIVES);
        handheldItem(ChangShengJueItems.FLYING_DAGGER_POUCH);
        //工具
        handheldItem(ChangShengJueItems.KAISHAN_PICKAXE);
        handheldItem(ChangShengJueItems.XUANHUA_AXE);

        bullionsItem(ChangShengJueItems.SILVER_BULLIONS);
        bullionsItem(ChangShengJueItems.GOLD_BULLIONS);

        saplingItem(ChangShengJueBlocks.MULBERRY_SAPLING);

        saplingItem(ChangShengJueBlocks.POPLAR_SAPLING);

        saplingItem(ChangShengJueBlocks.OSMANTHUS_SAPLING);

        saplingItem(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING);

        saplingItem(ChangShengJueBlocks.WENGE_SAPLING);

        saplingItem(ChangShengJueBlocks.PEAR_SAPLING);

        saplingItem(ChangShengJueBlocks.LICHEE_SAPLING);

        saplingItem(ChangShengJueBlocks.DURIAN_SAPLING);

        saplingItem(ChangShengJueBlocks.MANGO_SAPLING);

        saplingItem(ChangShengJueBlocks.PLUM_SAPLING);

        saplingItem(ChangShengJueBlocks.MULBERRY_SAPLING);

        saplingItem(ChangShengJueBlocks.ZI_TAN_SAPLING);

        parentItem(ChangShengJueBlocks.BIRCH_BENCH);
        parentItem(ChangShengJueBlocks.JUNGLE_BENCH);
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
        parentItem(ChangShengJueBlocks.JUNGLE_WINE_TABLE);
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
        parentItem(ChangShengJueBlocks.JUNGLE_DRINKING_TABLE_AND_CHAIRS);
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
        parentItem(ChangShengJueBlocks.JUNGLE_BOOK_DESK);
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

        parentItem(ChangShengJueBlocks.BIRCH_TEAPOY);
        parentItem(ChangShengJueBlocks.JUNGLE_TEAPOY);
        parentItem(ChangShengJueBlocks.CRIMSON_TEAPOY);
        parentItem(ChangShengJueBlocks.WARPED_TEAPOY);
        parentItem(ChangShengJueBlocks.MANGROVE_TEAPOY);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY);
        parentItem(ChangShengJueBlocks.WENGE_TEAPOY);
        parentItem(ChangShengJueBlocks.ACACIA_TEAPOY);
        parentItem(ChangShengJueBlocks.DARK_OAK_TEAPOY);
        parentItem(ChangShengJueBlocks.OAK_TEAPOY);
        parentItem(ChangShengJueBlocks.CHERRY_TEAPOY);
        parentItem(ChangShengJueBlocks.SPRUCE_TEAPOY);
        parentItem(ChangShengJueBlocks.ZI_TAN_TEAPOY);

        parentItem(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.WARPED_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.WENGE_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.OAK_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR);
        parentItem(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR);

        parentItem(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE);
        parentItem(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE);

        parentItem(ChangShengJueBlocks.BIRCH_LOW_DESK);
        parentItem(ChangShengJueBlocks.JUNGLE_LOW_DESK);
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
        //灯笼
        parentItem(ChangShengJueBlocks.LANTERN);
        parentItem(ChangShengJueBlocks.WHITE_LANTERN);
        parentItem(ChangShengJueBlocks.ORANGE_LANTERN);
        parentItem(ChangShengJueBlocks.MAGENTA_LANTERN);
        parentItem(ChangShengJueBlocks.LIGHT_BLUE_LANTERN);
        parentItem(ChangShengJueBlocks.YELLOW_LANTERN);
        parentItem(ChangShengJueBlocks.LIME_LANTERN);
        parentItem(ChangShengJueBlocks.PINK_LANTERN);
        parentItem(ChangShengJueBlocks.GRAY_LANTERN);
        parentItem(ChangShengJueBlocks.LIGHT_GRAY_LANTERN);
        parentItem(ChangShengJueBlocks.CYAN_LANTERN);
        parentItem(ChangShengJueBlocks.PURPLE_LANTERN);
        parentItem(ChangShengJueBlocks.BLUE_LANTERN);
        parentItem(ChangShengJueBlocks.BROWN_LANTERN);
        parentItem(ChangShengJueBlocks.GREEN_LANTERN);
        parentItem(ChangShengJueBlocks.RED_LANTERN);
        parentItem(ChangShengJueBlocks.BLACK_LANTERN);

//        parentItem(ChangShengJueBlocks.BIRCH_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.JUNGLE_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.CRIMSON_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.WARPED_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.MANGROVE_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.WENGE_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.ACACIA_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.OAK_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.CHERRY_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.SPRUCE_LIGHT_STAND);
//        parentItem(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND);
        //方凳
        parentItem(ChangShengJueBlocks.BIRCH_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.WARPED_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.WENGE_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.ACACIA_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.OAK_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.CHERRY_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL);
        parentItem(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL);
        //置物格
        parentItem(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL);
        parentItem(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL);
        //书格
        parentItem(ChangShengJueBlocks.BIRCH_BOOK_GRID);
        parentItem(ChangShengJueBlocks.JUNGLE_BOOK_GRID);
        parentItem(ChangShengJueBlocks.CRIMSON_BOOK_GRID);
        parentItem(ChangShengJueBlocks.WARPED_BOOK_GRID);
        parentItem(ChangShengJueBlocks.MANGROVE_BOOK_GRID);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID);
        parentItem(ChangShengJueBlocks.WENGE_BOOK_GRID);
        parentItem(ChangShengJueBlocks.ACACIA_BOOK_GRID);
        parentItem(ChangShengJueBlocks.DARK_OAK_BOOK_GRID);
        parentItem(ChangShengJueBlocks.OAK_BOOK_GRID);
        parentItem(ChangShengJueBlocks.CHERRY_BOOK_GRID);
        parentItem(ChangShengJueBlocks.SPRUCE_BOOK_GRID);
        parentItem(ChangShengJueBlocks.ZI_TAN_BOOK_GRID);
        //亮格
        parentItem(ChangShengJueBlocks.BIRCH_LIANGGE);
        parentItem(ChangShengJueBlocks.JUNGLE_LIANGGE);
        parentItem(ChangShengJueBlocks.CRIMSON_LIANGGE);
        parentItem(ChangShengJueBlocks.WARPED_LIANGGE);
        parentItem(ChangShengJueBlocks.MANGROVE_LIANGGE);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE);
        parentItem(ChangShengJueBlocks.WENGE_LIANGGE);
        parentItem(ChangShengJueBlocks.ACACIA_LIANGGE);
        parentItem(ChangShengJueBlocks.DARK_OAK_LIANGGE);
        parentItem(ChangShengJueBlocks.OAK_LIANGGE);
        parentItem(ChangShengJueBlocks.CHERRY_LIANGGE);
        parentItem(ChangShengJueBlocks.SPRUCE_LIANGGE);
        parentItem(ChangShengJueBlocks.ZI_TAN_LIANGGE);
        //柜子
        parentItem(ChangShengJueBlocks.BIRCH_CABINET);
        parentItem(ChangShengJueBlocks.JUNGLE_CABINET);
        parentItem(ChangShengJueBlocks.CRIMSON_CABINET);
        parentItem(ChangShengJueBlocks.WARPED_CABINET);
        parentItem(ChangShengJueBlocks.MANGROVE_CABINET);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_CABINET);
        parentItem(ChangShengJueBlocks.WENGE_CABINET);
        parentItem(ChangShengJueBlocks.ACACIA_CABINET);
        parentItem(ChangShengJueBlocks.DARK_OAK_CABINET);
        parentItem(ChangShengJueBlocks.OAK_CABINET);
        parentItem(ChangShengJueBlocks.CHERRY_CABINET);
        parentItem(ChangShengJueBlocks.SPRUCE_CABINET);
        parentItem(ChangShengJueBlocks.ZI_TAN_CABINET);
        //立柜
        parentItem(ChangShengJueBlocks.BIRCH_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.JUNGLE_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.CRIMSON_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.WARPED_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.MANGROVE_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.WENGE_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.ACACIA_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.OAK_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.CHERRY_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.SPRUCE_LARGE_CABINET);
        parentItem(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET);
        //晾衣架
        parentItem(ChangShengJueBlocks.BIRCH_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.JUNGLE_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.CRIMSON_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.WARPED_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.MANGROVE_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.WENGE_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.ACACIA_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.OAK_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.CHERRY_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.SPRUCE_DRYING_RAIL);
        parentItem(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL);

        parentItem(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS);
        parentItem(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS);
        //石凳
        parentItem(ChangShengJueBlocks.STONE_BENCH);
        //石桌
        parentItem(ChangShengJueBlocks.STONE_TABLE);
        //磨刀石
        parentItem(ChangShengJueBlocks.STONE_SHARPENING_STONE);
        parentItem(ChangShengJueBlocks.DIAMOND_SHARPENING_STONE);
        parentItem(ChangShengJueBlocks.NETHERITE_SHARPENING_STONE);
        //衣架
        parentItem(ChangShengJueBlocks.BIRCH_CLOTHES_RACK,ChangShengJueBlocks.BIRCH_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK,ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK,ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WARPED_CLOTHES_RACK,ChangShengJueBlocks.WARPED_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK,ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK,ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WENGE_CLOTHES_RACK,ChangShengJueBlocks.WENGE_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ACACIA_CLOTHES_RACK,ChangShengJueBlocks.ACACIA_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK,ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.OAK_CLOTHES_RACK,ChangShengJueBlocks.OAK_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CHERRY_CLOTHES_RACK,ChangShengJueBlocks.CHERRY_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK,ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK,ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.getId().getPath() + "_inventory");
        //折屏
        parentItem(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN,ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN,ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN,ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WARPED_FOLDING_SCREEN,ChangShengJueBlocks.WARPED_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN,ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN,ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WENGE_FOLDING_SCREEN,ChangShengJueBlocks.WENGE_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN,ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN,ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.OAK_FOLDING_SCREEN,ChangShengJueBlocks.OAK_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN,ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN,ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN,ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.getId().getPath() + "_inventory");
        //罗汉床
        parentItem(ChangShengJueBlocks.BIRCH_ARHAT_BED,ChangShengJueBlocks.BIRCH_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.JUNGLE_ARHAT_BED,ChangShengJueBlocks.JUNGLE_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CRIMSON_ARHAT_BED,ChangShengJueBlocks.CRIMSON_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WARPED_ARHAT_BED,ChangShengJueBlocks.WARPED_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.MANGROVE_ARHAT_BED,ChangShengJueBlocks.MANGROVE_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED,ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WENGE_ARHAT_BED,ChangShengJueBlocks.WENGE_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ACACIA_ARHAT_BED,ChangShengJueBlocks.ACACIA_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.DARK_OAK_ARHAT_BED,ChangShengJueBlocks.DARK_OAK_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.OAK_ARHAT_BED,ChangShengJueBlocks.OAK_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CHERRY_ARHAT_BED,ChangShengJueBlocks.CHERRY_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.SPRUCE_ARHAT_BED,ChangShengJueBlocks.SPRUCE_ARHAT_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ZI_TAN_ARHAT_BED,ChangShengJueBlocks.ZI_TAN_ARHAT_BED.getId().getPath() + "_inventory");
        //架子床
        parentItem(ChangShengJueBlocks.BIRCH_CANOPY_BED,ChangShengJueBlocks.BIRCH_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.JUNGLE_CANOPY_BED,ChangShengJueBlocks.JUNGLE_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CRIMSON_CANOPY_BED,ChangShengJueBlocks.CRIMSON_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WARPED_CANOPY_BED,ChangShengJueBlocks.WARPED_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.MANGROVE_CANOPY_BED,ChangShengJueBlocks.MANGROVE_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED,ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WENGE_CANOPY_BED,ChangShengJueBlocks.WENGE_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ACACIA_CANOPY_BED,ChangShengJueBlocks.ACACIA_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.DARK_OAK_CANOPY_BED,ChangShengJueBlocks.DARK_OAK_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.OAK_CANOPY_BED,ChangShengJueBlocks.OAK_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CHERRY_CANOPY_BED,ChangShengJueBlocks.CHERRY_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.SPRUCE_CANOPY_BED,ChangShengJueBlocks.SPRUCE_CANOPY_BED.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ZI_TAN_CANOPY_BED,ChangShengJueBlocks.ZI_TAN_CANOPY_BED.getId().getPath() + "_inventory");
        //高灯架
        parentItem(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND,ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.getId().getPath() + "_inventory");
        //窗户
        simpleBlockItem(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS,ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS,ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS,ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_OAK_WINDOWS,ChangShengJueBlocks.HIGH_OAK_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS,ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.getId().getPath());

        //城门
        simpleBlockItem(ChangShengJueBlocks.SHING_MUN_RIGHT,ChangShengJueBlocks.SHING_MUN_RIGHT.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.BIG_SHING_MUN_LEFT,ChangShengJueBlocks.SHING_MUN_LEFT.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT,ChangShengJueBlocks.SHING_MUN_RIGHT.getId().getPath());

        parentItem(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE);

        parentItem(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB);
        parentItem(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB);

        parentItem(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE);

        parentItem(ChangShengJueBlocks.GRE_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.RED_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.BLACK_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.CYAN_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.BLUE_ROOF_RIDGE);
        parentItem(ChangShengJueBlocks.PURPLE_ROOF_RIDGE);

        parentItem(ChangShengJueBlocks.GRE_DEMON_MASK);
        parentItem(ChangShengJueBlocks.RED_DEMON_MASK);
        parentItem(ChangShengJueBlocks.BLACK_DEMON_MASK);
        parentItem(ChangShengJueBlocks.GOLDEN_DEMON_MASK);
        parentItem(ChangShengJueBlocks.CYAN_DEMON_MASK);
        parentItem(ChangShengJueBlocks.BLUE_DEMON_MASK);
        parentItem(ChangShengJueBlocks.PURPLE_DEMON_MASK);

        parentItem(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");
        parentItem(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE,ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath() + "_top");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");


        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_HIPPED_ROOF,ChangShengJueBlocks.GRE_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.RED_HIPPED_ROOF,ChangShengJueBlocks.RED_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLACK_HIPPED_ROOF,ChangShengJueBlocks.BLACK_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF,ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CYAN_HIPPED_ROOF,ChangShengJueBlocks.CYAN_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLUE_HIPPED_ROOF,ChangShengJueBlocks.BLUE_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.PURPLE_HIPPED_ROOF,ChangShengJueBlocks.PURPLE_HIPPED_ROOF.getId().getPath() + "_inventory");

        parentItem(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);

        parentItem(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);

        parentItem(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE);
        //双层琉璃瓦
        parentItem(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE);
        //小鸱吻
        parentItem(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK);
        parentItem(ChangShengJueBlocks.RED_SMALL_DEMON_MASK);
        parentItem(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK);
        parentItem(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK);
        parentItem(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK);
        parentItem(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK);
        parentItem(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK);
        //侧筒瓦
        parentItem(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE);
        //侧瓦当
        parentItem(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.RED_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE);
        //八角垂脊
        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        //双层脊瓦
        parentItem(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE);

        //栏杆
        parentItem(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE,
                ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.OAK_BALUSTRADE,
                ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.SPRUCE_BALUSTRADE,
                ChangShengJueBlocks.SPRUCE_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BIRCH_BALUSTRADE,
                ChangShengJueBlocks.BIRCH_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.JUNGLE_BALUSTRADE,
                ChangShengJueBlocks.JUNGLE_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.ACACIA_BALUSTRADE,
                ChangShengJueBlocks.ACACIA_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.MANGROVE_BALUSTRADE,
                ChangShengJueBlocks.MANGROVE_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CHERRY_BALUSTRADE,
                ChangShengJueBlocks.CHERRY_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.DARK_OAK_BALUSTRADE,
                ChangShengJueBlocks.DARK_OAK_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CRIMSON_BALUSTRADE,
                ChangShengJueBlocks.CRIMSON_BALUSTRADE.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.WARPED_BALUSTRADE,
                ChangShengJueBlocks.WARPED_BALUSTRADE.getId().getPath() + "_inventory");


        parentItem(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL);
        //瓦片
        parentItem(ChangShengJueBlocks.GRE_CYLINDER_TILE,
                ChangShengJueBlocks.GRE_CYLINDER_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.RED_CYLINDER_TILE,
                ChangShengJueBlocks.RED_CYLINDER_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE,
                ChangShengJueBlocks.BLACK_CYLINDER_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE,
                ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.CYAN_CYLINDER_TILE,
                ChangShengJueBlocks.CYAN_CYLINDER_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE,
                ChangShengJueBlocks.BLUE_CYLINDER_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.PURPLE_CYLINDER_TILE,
                ChangShengJueBlocks.PURPLE_CYLINDER_TILE.getId().getPath() + "_height1");

        parentItem(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE,
                ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.getId().getPath() + "_height1");

        //脊瓦
        parentItem(ChangShengJueBlocks.GRE_RIDGE_TILE,
                ChangShengJueBlocks.GRE_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.RED_RIDGE_TILE,
                ChangShengJueBlocks.RED_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLACK_RIDGE_TILE,
                ChangShengJueBlocks.BLACK_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.GOLDEN_RIDGE_TILE,
                ChangShengJueBlocks.GOLDEN_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.CYAN_RIDGE_TILE,
                ChangShengJueBlocks.CYAN_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLUE_RIDGE_TILE,
                ChangShengJueBlocks.BLUE_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.PURPLE_RIDGE_TILE,
                ChangShengJueBlocks.PURPLE_RIDGE_TILE.getId().getPath() + "_height1");
        //蹲兽脊瓦
        parentItem(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE,
                ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.getId().getPath() + "_height1");
        //脊刹
        parentItem(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION,
                ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.getId().getPath() + "_inventory");

        parentItem(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION,
                ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.getId().getPath() + "_inventory");
        //瓦当
        parentItem(ChangShengJueBlocks.GRE_EAVES_TILE);
        parentItem(ChangShengJueBlocks.RED_EAVES_TILE);
        parentItem(ChangShengJueBlocks.BLACK_EAVES_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_EAVES_TILE);
        parentItem(ChangShengJueBlocks.CYAN_EAVES_TILE);
        parentItem(ChangShengJueBlocks.BLUE_EAVES_TILE);
        parentItem(ChangShengJueBlocks.PURPLE_EAVES_TILE);
        //包裹
        simpleItem(ChangShengJueItems.ARMOR_PARCEL,"parcel");
        //片瓦(飞檐)
        parentItem(ChangShengJueBlocks.GOLDEN_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_GENTLE_TILE,ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.GOLDEN_CORNICES);
        parentItem(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES);
        parentItem(ChangShengJueBlocks.BLACK_TILE);
        parentItem(ChangShengJueBlocks.BLACK_CORNICES);
        parentItem(ChangShengJueBlocks.BLACK_GENTLE_TILE,ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath() + "_height1");
        parentItem(ChangShengJueBlocks.BLACK_GENTLE_CORNICES);
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

    //自定义方块物品资源路径json
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> block, String path) {
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/"+path));
    }
    //自定义物品资源路径json
    private ItemModelBuilder simpleItem(RegistryObject<Item> item,String path) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ChangShengJue.MOD_ID,"item/" + path));
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


    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ChangShengJue.MOD_ID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}
