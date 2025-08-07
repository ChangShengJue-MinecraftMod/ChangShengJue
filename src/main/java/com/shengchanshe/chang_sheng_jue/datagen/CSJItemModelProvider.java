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
        simpleBlockItem(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS,ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS,ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS,ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_OAK_WINDOWS,ChangShengJueBlocks.HIGH_OAK_WINDOWS.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS,ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.getId().getPath());

        //城门
        simpleBlockItem(ChangShengJueBlocks.SHING_MUN_RIGHT,ChangShengJueBlocks.SHING_MUN_RIGHT.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.BIG_SHING_MUN_LEFT,ChangShengJueBlocks.SHING_MUN_LEFT.getId().getPath());
        simpleBlockItem(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT,ChangShengJueBlocks.SHING_MUN_RIGHT.getId().getPath());

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

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES,ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath() + "_right");


        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT,ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND,ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT,ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND,ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath() + "_right");

        parentItem(ChangShengJueBlocks.GRE_HIPPED_ROOF,ChangShengJueBlocks.GRE_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.RED_HIPPED_ROOF,ChangShengJueBlocks.RED_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLACK_HIPPED_ROOF,ChangShengJueBlocks.BLACK_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF,ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.getId().getPath() + "_inventory");
        parentItem(ChangShengJueBlocks.BLUE_HIPPED_ROOF,ChangShengJueBlocks.BLUE_HIPPED_ROOF.getId().getPath() + "_inventory");

        parentItem(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE);

        parentItem(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE);

        parentItem(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE);

        //侧筒瓦
        parentItem(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE);
        //侧高筒瓦
        parentItem(ChangShengJueBlocks.GRE_HIGH_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.RED_HIGH_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLACK_HIGH_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.GOLDEN_HIGH_CYLINDER_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLUE_HIGH_CYLINDER_TILE_SIDE);
        //侧瓦当
        parentItem(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.RED_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE);
        parentItem(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE);
        //八角垂脊
        parentItem(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);
        parentItem(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE);

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

        //包裹
        simpleItem(ChangShengJueItems.ARMOR_PARCEL,"parcel");
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
