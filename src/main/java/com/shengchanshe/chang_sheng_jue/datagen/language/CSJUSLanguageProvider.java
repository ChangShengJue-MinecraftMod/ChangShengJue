package com.shengchanshe.chang_sheng_jue.datagen.language;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.damage.CSJDamageTypes;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.items.StructureIntelligence;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class CSJUSLanguageProvider extends LanguageProvider {
    public CSJUSLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        //创造栏
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_building_block", "Changshengjue Building Block");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_natural_blocks", "Changshengjue Natural Blocks");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_functional", "Changshengjue Functional");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_ingredients", "Changshengjue Ingredients");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_food_and_drink", "Changshengjue Foods");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_combat", "Changshengjue Combat");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_tool", "Changshengjue Tool");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_spawn_eggs", "Changshengjue Spawn Eggs");
        //物品
        this.add(ChangShengJueItems.PINEAPPLE_SEEDS.get(),"Pineapple Seeds");
        this.add(ChangShengJueItems.PINEAPPLE.get(),"Pineapple");
        this.add(ChangShengJueItems.TOMATO_SEEDS.get(),"Tomato Seeds");
        this.add(ChangShengJueItems.TOMATO.get(),"Tomato");
        this.add(ChangShengJueItems.SOYBEAN.get(),"Soybean");
        this.add(ChangShengJueItems.GU_SEEDS.get(),"Grain Seeds");
        this.add(ChangShengJueItems.GU_SUI.get(),"Grain Ear");
        this.add(ChangShengJueItems.SORGHUM_SEEDS.get(),"Sorghum Seeds");
        this.add(ChangShengJueItems.SORGHUM.get(),"Sorghum");
        this.add(ChangShengJueItems.LOTUS_ROOT.get(),"Lotus Root");
        this.add(ChangShengJueItems.LOTUS_SEEDS.get(),"Lotus Seeds");
        this.add(ChangShengJueItems.LOTUS.get(),"Lotus");
        this.add(ChangShengJueItems.REDBEAN.get(),"Redbean");
        this.add(ChangShengJueItems.COTTON_SEEDS.get(),"Cotton Seeds");
        this.add(ChangShengJueItems.COTTON.get(),"Cotton");
        this.add(ChangShengJueItems.STICKYRICE_SEEDS.get(),"Sticky Rice Seeds");
        this.add(ChangShengJueItems.STICKYRICE.get(),"Glutinous Rice");
        this.add(ChangShengJueItems.STICKYRICE_1.get(),"Sticky Rice");
        this.add(ChangShengJueItems.CORN_SEEDS.get(),"Corn Seeds");
        this.add(ChangShengJueItems.CORN.get(),"Corn");
        this.add(ChangShengJueItems.JALAPENOS_SEEDS.get(),"pepper Seeds");
        this.add(ChangShengJueItems.JALAPENOS.get(),"pepper");
        this.add(ChangShengJueItems.PEANUT_SEEDS.get(),"Peanut Seeds");
        this.add(ChangShengJueItems.PEANUT.get(),"Peanut");
        this.add(ChangShengJueItems.BRINJAL_SEEDS.get(),"Brinjal Seeds");
        this.add(ChangShengJueItems.BRINJAL.get(),"Brinjal");
        this.add(ChangShengJueItems.CANTALOUPE.get(),"Cantaloupe");
        this.add(ChangShengJueItems.CANTALOUPE_SEEDS.get(),"Cantaloupe Seeds");
        this.add(ChangShengJueItems.GRAPE_SEEDS.get(),"Grape Seeds");
        this.add(ChangShengJueItems.GRAPE.get(),"Grape");
        this.add(ChangShengJueItems.RICE_SEEDS.get(),"Rice Seeds");
        this.add(ChangShengJueItems.RICE.get(),"Rice");
        this.add(ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get(),"Biluochun Seeds");
        this.add(ChangShengJueItems.BILUOCHUN_TEA.get(),"Biluochun Tea");
        this.add(ChangShengJueItems.LONG_JING_TEA_SEEDS.get(),"Longjing Seeds");
        this.add(ChangShengJueItems.LONG_JING_TEA.get(),"Longjing Tea");
        this.add(ChangShengJueItems.HORDEUM_SEEDS.get(),"Hordeum Seeds");
        this.add(ChangShengJueItems.HORDEUM.get(),"Hordeum");
        this.add(ChangShengJueItems.MULBERRY_JUICE.get(),"Mulberry Juice");
        this.add(ChangShengJueItems.APPLE_JUICE.get(),"Apple Juice");
        this.add(ChangShengJueItems.HOT_PEAR_SOUP.get(),"Hot Pear Soup");
        this.add(ChangShengJueItems.GRAPE_JUICE.get(),"Grape Juice");
        this.add(ChangShengJueItems.CROC.get(),"Crocodile");
        this.add(ChangShengJueItems.COOKED_CROC.get(),"Cooked Crocodile");
        this.add(ChangShengJueItems.PEACOCK.get(),"Peacock");
        this.add(ChangShengJueItems.COOKED_PEACOCK.get(),"Cooked Peacock");
        this.add(ChangShengJueItems.CI_PAN.get(),"Porcelain Plate");
        this.add(ChangShengJueItems.CI_WAN.get(),"Porcelain Bowl");
        this.add(ChangShengJueItems.CI_BEI.get(),"Porcelain Cup");
        this.add(ChangShengJueItems.CAPSULE_JIAO_ZI.get(),"Capsule JiaoZi");
        this.add(ChangShengJueItems.ZHENG_CAI.get(),"Steamed Dishes");
        this.add(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(),"Portulaca Oleracea Cake");
        this.add(ChangShengJueItems.QING_TUAN.get(),"QingTuan");
        this.add(ChangShengJueItems.BAKED_CORN.get(),"Baked Corn");
        this.add(ChangShengJueItems.TOMATO_EGG.get(),"Tomato Egg");
        this.add(ChangShengJueItems.GU_LAO_ROU.get(),"GuLao Meat");
        this.add(ChangShengJueItems.MEAT_FOAM_BRINJAL.get(),"Meat Foam Brinjal");
        this.add(ChangShengJueItems.SORGHUM_CAKE.get(),"Sorghum Cake");
        this.add(ChangShengJueItems.STINKY_TOFU.get(),"Stinky Tofu");
        this.add(ChangShengJueItems.ZHU_DU_JI.get(),"Pork Tripe and Chicken");
        this.add(ChangShengJueItems.XIAO_MI_FAN.get(),"Rice ball with millet");
        this.add(ChangShengJueItems.MI_FAN.get(),"rice ball");
        this.add(ChangShengJueItems.GUI_HUA_TANG_OU.get(),"Lotus Root Soup");
        this.add(ChangShengJueItems.BA_BAO_ZHOU.get(),"BaBaozhou");
        this.add(ChangShengJueItems.BILUOCHUN_TEAS.get(),"Biluochun Tea");
        this.add(ChangShengJueItems.LONG_JING_TEAS.get(),"Longjing Tea");
        this.add(ChangShengJueItems.SHI_LI_XIANG.get(),"ShiLiXiang");
        this.add(ChangShengJueItems.FEN_JIU.get(),"FenJiu");
        this.add(ChangShengJueItems.EMPTY_FEN_JIU.get(),"Empty Bottle");
        this.add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(),"Mai Kuai Tribute Liquor");
        this.add(ChangShengJueItems.MANGO.get(),"Mango");
        this.add(ChangShengJueItems.MEI_HUA.get(),"Plum blossom");
        this.add(ChangShengJueItems.GUI_HUA.get(),"Osmanthus fragrans");
        this.add(ChangShengJueItems.BANANA.get(),"Banana");
        this.add(ChangShengJueItems.PEAR.get(),"Pear");
        this.add(ChangShengJueItems.LICHEE.get(),"Lychee");
        this.add(ChangShengJueItems.DURIAN.get(),"Durian");
        this.add(ChangShengJueItems.DURIAN_MEAT.get(),"Durian flesh");
        this.add(ChangShengJueItems.MULBERRY.get(),"Mulberry");
        this.add(ChangShengJueItems.NATURAL_SILK.get(),"Natural Silk");
        this.add(ChangShengJueItems.SILKWORM.get(),"Silkworm");
        this.add(ChangShengJueItems.SILK.get(),"Silk");
        this.add(ChangShengJueItems.CAPSULE.get(),"mustard");
        this.add(ChangShengJueItems.QUICKLIME.get(),"Quicklime");
        this.add(ChangShengJueItems.LIME_SLURRY_BARRELS.get(),"Lime slurry bucket");
        this.add(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get(),"Warm lime mortar bucket");
        this.add(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get(),"Cool lime slurry bucket");

        this.add(ChangShengJueItems.CRANE_FEATHERS.get(), "Crane Feathers");
        this.add(ChangShengJueItems.PEACOCK_FEATHERS.get(), "Peacock Feathers");
        this.add(ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get(), "White Peacock Feathers");
        this.add(ChangShengJueItems.PEACOCK_EGGS.get(), "Peacock Eggs");
        this.add(ChangShengJueItems.ANTLER.get(), "Deer Antler");
        this.add(ChangShengJueItems.DEER_BLOOD.get(), "Deer Blood");
        this.add(ChangShengJueItems.VENISON.get(), "Raw Venison");
        this.add(ChangShengJueItems.COOKED_VENISON.get(), "Cooked Venison");
        this.add(ChangShengJueItems.TIGER_SKIN.get(), "Tiger Skin");
        this.add(ChangShengJueItems.CROC_SKIN.get(), "Crocodile Skin");
        this.add(ChangShengJueItems.RAW_AG.get(), "Crude Silver");
        this.add(ChangShengJueItems.AG_INGOT.get(), "Silver Ingot");

        this.add(ChangShengJueItems.THATCH.get(), "Thatch");

        this.add(ChangShengJueItems.PAINT_BRUSH.get(), "Paint Brush");
        this.add(ChangShengJueItems.BLACK_BRICKS.get(), "Black Bricks");
        this.add(ChangShengJueItems.WHITE_BRICKS_ITEM.get(), "White Bricks");
        this.add(ChangShengJueItems.GOLD_BRICKS.get(), "Gold Bricks");

        this.add(ChangShengJueItems.TONG_QIAN.get(), "Copper Coins");
        this.add(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), "String of Copper Coins");
        this.add(ChangShengJueItems.SILVER_BULLIONS.get(), "Silver Bullions");
        this.add(ChangShengJueItems.GOLD_BULLIONS.get(), "Gold Bullions");

        this.add(ChangShengJueItems.CRUCIBLE.get(), "Crucible");
        this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get(), "Crucible (Crushed Copper Pieces)");
        this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get(), "Crucible (Crushed Silver Pieces)");
        this.add(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get(), "Crucible (Crushed Gold Pieces)");
        this.add(ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get(), "Crucible (Liquid Copper)");
        this.add(ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), "Crucible (Liquid Silver)");
        this.add(ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), "Crucible (Liquid Gold)");

        this.add(ChangShengJueItems.GANG_TOKEN.get(),"Gang Token");


        this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.PIT_YARD_TYPE, "%s" + "information");
        this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SANDSTONE_CASTLE_TYPE, "%s" + "information");
        this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SI_HE_YUAN_TYPE, "%s" + "information");
        this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.SU_PAI_VILLAGE_TYPE, "%s" + "information");
        this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.HUI_PAI_VILLAGE_TYPE, "%s" + "information");
        this.add("item." + ChangShengJue.MOD_ID + "." + ChangShengJueItems.STRUCTURE_INTELLIGENCE.get() + "." + StructureIntelligence.FORTRESSES_TYPE, "%s" + "information");

        //刷怪蛋
        this.add(ChangShengJueItems.BUTTERFLY_EGG.get(), "Butterfly Spawn Egg");
        this.add(ChangShengJueItems.MONKEY_EGG.get(), "Monkey Spawn Egg");
        this.add(ChangShengJueItems.DRAGONFLY_EGG.get(), "Dragonfly Spawn Egg");
        this.add(ChangShengJueItems.CICADA_EGG.get(), "Cicada Spawn Egg");
        this.add(ChangShengJueItems.CRANE_EGG.get(), "Crane Spawn Egg");
        this.add(ChangShengJueItems.PEACOCK_EGG.get(), "Male Peacock Spawn Egg");
        this.add(ChangShengJueItems.PEACOCK_EGG_1.get(), "Female Peacock Spawn Egg");
        this.add(ChangShengJueItems.STAG_EGG.get(), "Stag Spawn Egg");
        this.add(ChangShengJueItems.HIND_EGG.get(), "Hind Spawn Egg");
        this.add(ChangShengJueItems.TIGER_EGG.get(), "Tiger Spawn Egg");
        this.add(ChangShengJueItems.CROC_EGG.get(), "Crocodile Spawn Egg");
        this.add(ChangShengJueItems.CHANG_SHENG_JUE_VILLAGER_EGG.get(), "Villager Spawn Egg");
        this.add(ChangShengJueItems.WARRIOR_EGG.get(), "Warrior Spawn Egg");
        this.add(ChangShengJueItems.KILN_WORKER_EGG.get(), "Kiln Worker Spawn Egg");
        this.add(ChangShengJueItems.MALE_INNKEEPER_EGG.get(), "Male Innkeeper Spawn Egg");
        this.add(ChangShengJueItems.FEMALE_INNKEEPER_EGG.get(), "Female Innkeeper Spawn Egg");
        this.add(ChangShengJueItems.CHALLENGER_EGG.get(), "Challenger Spawn Egg");
        this.add(ChangShengJueItems.BLACKSMITH_EGG.get(), "Blacksmith Spawn Egg");
        this.add(ChangShengJueItems.LANCE_GANG_LEADER_EGG.get(), "Spear Leader Spawn Egg");
        this.add(ChangShengJueItems.KNIFE_GANG_LEADER_EGG.get(), "Knife Leader Spawn Egg");
        this.add(ChangShengJueItems.SWORD_GANG_LEADER_EGG.get(), "Sword Leader Spawn Egg");
        this.add(ChangShengJueItems.CLUBBED_GANG_LEADER_EGG.get(), "Club Leader Spawn Egg");
        this.add(ChangShengJueItems.GANG_LEADER_EGG.get(), "Fist Leader Spawn Egg");
        this.add(ChangShengJueItems.BANDIT_EGG.get(), "Bandit Spawn Egg");
        this.add(ChangShengJueItems.VILLAIN_EGG.get(), "Villain Spawn Egg");
        this.add(ChangShengJueItems.ASSASSIN_EGG.get(), "Assassin Spawn Egg");
        this.add(ChangShengJueItems.CLUBBED_MING_XIA_EGG.get(), "Club Master Spawn Egg");
        this.add(ChangShengJueItems.SWORD_MING_XIA_EGG.get(), "Sword Immortal Spawn Egg");
        this.add(ChangShengJueItems.KNIFE_MING_XIA_EGG.get(), "Knife Sage Spawn Egg");
        this.add(ChangShengJueItems.FIST_MING_XIA_EGG.get(), "Northern Fist Spawn Egg");
        this.add(ChangShengJueItems.PIGLIN_WU_XIA_EGG.get(), "Kung Fu Piglin Spawn Egg");
        this.add(ChangShengJueItems.WITCH_WU_XIA_EGG.get(), "Kung Fu Witch Spawn Egg");
        this.add(ChangShengJueItems.EVOKER_WU_XIA_EGG.get(), "Kung Fu Evoker Spawn Egg");
        this.add(ChangShengJueItems.VINDICATOR_WU_XIA_EGG.get(), "Kung Fu Vindicator Spawn Egg");
        this.add(ChangShengJueItems.PILLAGER_WU_XIA_EGG.get(), "Kung Fu Pillager Spawn Egg");
        //工具武器和盔甲物品
        this.add(ChangShengJueItems.KAISHAN_PICKAXE.get(),"Kaishan Pickaxe");
        this.add(ChangShengJueItems.XUANHUA_AXE.get(),"Xuanhua Axe");
        this.add(ChangShengJueItems.BRONZE_SWORD.get(),"Bronze Sword");
        this.add(ChangShengJueItems.HAN_JIAN.get(),"Han Jian");
        this.add(ChangShengJueItems.HENG_DAO.get(),"Heng Dao");
        this.add(ChangShengJueItems.LARGE_KNIFE.get(),"Large Saber");
        this.add(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),"Red Tasselled Spear");
        this.add(ChangShengJueItems.SOFT_SWORD.get(),"Soft Sword");
        this.add(ChangShengJueItems.PAN_HUA_GUN.get(),"Panhua Gun");
        this.add(ChangShengJueItems.KITCHEN_KNIFE.get(),"Kitchen Knife");
        this.add(ChangShengJueItems.THROWING_KNIVES.get(),"Throwing Knives");
        this.add(ChangShengJueItems.FLYING_DAGGER_POUCH.get(),"Feidao Pouch");
        this.add(ChangShengJueItems.BEAT_DOG_STICK.get(),"Dagou Bang");
        this.add(ChangShengJueItems.YI_TIAN_JIAN.get(),"Yitian Sword");
        this.add(ChangShengJueItems.TU_LONG_DAO.get(),"Tulong Dao");
        this.add(ChangShengJueItems.BA_WANG_QIANG.get(),"Bawang Spear");
        this.add(ChangShengJueItems.GOLD_THREAD_GLOVE.get(),"Gold Thread Glove");
        this.add(ChangShengJueItems.COTTON_HELMET.get(),"Cotton Helmet");
        this.add(ChangShengJueItems.WHITE_COTTON_HELMET.get(),"White Feather Cotton Helmet");
        this.add(ChangShengJueItems.COTTON_CHESTPLATE.get(),"Cotton Armor");
        this.add(ChangShengJueItems.COTTON_LEGGINGS.get(),"Cotton Leg Guards");
        this.add(ChangShengJueItems.COTTON_BOOTS.get(),"Cotton Boots");
        this.add(ChangShengJueItems.FEMALE_TAOIST_HELMET.get(),"Taoist Crown");
        this.add(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get(),"Taoist Robe");
        this.add(ChangShengJueItems.MALE_TAOIST_HELMET.get(),"Square Scarf");
        this.add(ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get(),"Taoist Robe");
        this.add(ChangShengJueItems.TAOIST_BOOTS.get(),"Silk Shoes");
        this.add(ChangShengJueItems.TAOIST_LEGGINGS.get(),"Silk Trousers");
        this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get(),"Black Gauze Cap");
        this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get(),"Kylin Embroidered Robe");
        this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get(),"Phoenix Coronet");
        this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get(),"Imperial Robe");
        this.add(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get(),"Gold Thread Shoes");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get(),"Kuiqiang Doumou");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get(),"Shanwen Armor");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get(),"Mountain Pattern");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get(),"Cloud Toe Black Leather Boots");
        this.add(ChangShengJueItems.FLY_FISH_IRON_HAT.get(), "Iron Hat");
        this.add(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get(), "Cloud Veil Crown");
        this.add(ChangShengJueItems.FLY_FISH_CHESTPLATE.get(), "Flying Fish Robe");
        this.add(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get(), "Long Boots");
        this.add(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get(),"Green Gem Forehead Pendant");
        this.add(ChangShengJueItems.WALKER_GOLD_RING_BAND.get(), "Gold Ring Band");
        this.add(ChangShengJueItems.WALKER_CHESTPLATE.get(), "Walker's Outfit");
        this.add(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT.get(), "Tiger Skin Skirt");
        this.add(ChangShengJueItems.WALKER_SHORT_BOOTS.get(), "Short Boots");
        this.add(ChangShengJueItems.PHOENIX_FEATHER_CAP.get(),"Phoenix Feather Cap");
        this.add(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get(),"Olden Chain Mail Shirt");
        this.add(ChangShengJueItems.TIGER_SKIN_GARMENT.get(),"Tiger Skin Lower Garment");
        this.add(ChangShengJueItems.CLOUD_WALKING_BOOTS.get(),"Cloud Walking Boots");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get(), "Phoenix Winged Helmet");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get(), "Bright Light Armor");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get(), "Lazuli Knee Pads");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get(), "Animal Skin Boots");
        this.add(ChangShengJueItems.CONFUCIAN_HELMET.get(), "Confucian Cap");
        this.add(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get(), "Scholar's Robe");
        this.add(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get(), "Silk Trousers");
        this.add(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get(), "Light Silk Shoes");

        this.add(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get(), "Gold Silk Soft Armor");
        this.add(ChangShengJueItems.LEATHER_INNER_ARMOR.get(), "Leather Inner Armor");

        this.add(ChangShengJueItems.ARMOR_PARCEL.get(), "Armor Parcel");

        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "cotton_armor", "棉甲包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mountain_pattern", "山文甲包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mingguang_armor", "大将军明光铠包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "qi_tian_da_sheng", "大圣甲胄包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_taoist", "道服包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_taoist", "道袍包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_wedding_dress", "麒麟补服包裹");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_wedding_dress", "袆衣包裹");

        //武功秘籍物品
        this.add(ChangShengJueItems.IMMORTAL_MIRACLE.get(),"Immortal Divine Skill");
        this.add(ChangShengJueItems.HERCULES.get(),"Hercules' Mighty Skill");
        this.add(ChangShengJueItems.DUGU_NINE_SWORDS.get(),"Dugu Nine Swords");
        this.add(ChangShengJueItems.GAO_MARKSMANSHIP.get(),"Gao Family Spearplay");
        this.add(ChangShengJueItems.GE_SHAN_DA_NIU.get(),"Ge Shan Da Niu");
        this.add(ChangShengJueItems.TURTLE_BREATH_WORK.get(),"Turtle Breathing Skill");
        this.add(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get(),"Jinwu Saberplay");
        this.add(ChangShengJueItems.GOLDEN_BELL_JAR.get(),"Golden Bell Cover");
        this.add(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get(),"Sunflower Acupoint-Shooting Hand");
        this.add(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get(),"Wheat Block Encyclopedia");
        this.add(ChangShengJueItems.PAODING.get(),"Pao Ding's Ox-Butchering Skill");
        this.add(ChangShengJueItems.SHAOLIN_STICK_METHOD.get(),"Shaolin Staffplay");
        this.add(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get(),"Tread Snow Without Trace");
        this.add(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get(),"Relentless Flying Daggers");
        this.add(ChangShengJueItems.WU_GANG_CUT_GUI.get(),"Wu Gang Chopping Cassia");
        this.add(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get(),"Xuannü Swordplay");
        this.add(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get(),"Yugong Moves Mountains");
        this.add(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(),"Zhang Sect Mind Doctrine");
        this.add(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get(),"The Muscle-Tendon Changing Classic");
        this.add(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get(),"Qiankun Great Shift");

        //武功描述
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".tooltip","The pinnacle of swordsmanship in the world encompasses the profound and all-encompassing secrets of the art.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".hold_shift.tooltip",
                "Effect before reaching mastery: When unleashing external skills, deal damage equal to (main hand weapon damage + 1) multiplied by 1.8\\nAfter mastering the skill, the effect is as follows: the damage multiplier is increased to 2.2 times, and the probability of triggering bleeding when using a sword is multiplied by 1.25\\nAfter successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".tooltip","Make clever use of external forces, and conquer the strong with the weak.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".hold_shift.tooltip",
                "Effect before reaching mastery: External skill release causes (main hand weapon damage + 1) * 2.2 times the damage\\nAfter mastering the skill, the effect is as follows: the damage multiplier is increased to 2.5 times, and the probability of triggering bleeding when using a soft sword is multiplied by 3.0\\nAfter successfully performing it\" + \" %s \" + \"times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".tooltip","First a cold glint arrives, then the spear strikes like a dragon.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".hold_shift.tooltip",
                "Effect before mastery: External skill deals (main hand weapon damage + 1) × 1.8 damage\nEffect after mastery: Damage multiplier increases to 2.1x; chance of knocking up with spears ×2.5\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".tooltip","The relentless flying daggers know no mercy, yet the wielder bears compassion.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".hold_shift.tooltip",
                "Effect before mastery: Flying dagger damage increases to 1.25x; throws 3 daggers at once\nEffect after mastery: Damage increases to 1.5x; throws 7 daggers at once\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".tooltip","All martial arts under heaven originate from Shaolin; one staff settles the universe.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".hold_shift.tooltip",
                "Effect before mastery: External skill deals (main hand weapon damage + 1) × 1.7 damage\nEffect after mastery: Damage multiplier increases to 2.0x; chance of stunning with staves ×2.5\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".tooltip","No matter how you twist and turn, one strike of my blade shall break through!");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".hold_shift.tooltip",
                "Effect before mastery: External skill deals (main hand weapon damage + 1) × 1.9 damage\nEffect after mastery: Damage multiplier increases to 2.0x; chance of heavy strikes with sabers ×2.0\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".tooltip","Coming and going without a trace—free and unrestrained.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".hold_shift.tooltip",
                "Effect before mastery: Allows double jumps\nEffect after mastery: Allows triple jumps\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".tooltip","Why cling to killing skills? Better to satisfy the heart's desire.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".hold_shift.tooltip",
                "Effect before mastery: Using Xuanhua Axe to chop trees destroys the entire tree\nEffect after mastery: Faster destruction of entire trees\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".tooltip","Persist unceasingly until the mountains are leveled.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".hold_shift.tooltip",
                "Effect before mastery: Mining area of Kaishan Pickaxe expands to 2x2\nEffect after mastery: Mining area expands to 3x3\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".tooltip","Practice relentlessly to grasp the rhythm; then your hands move as if guided by intuition.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".hold_shift.tooltip",
                "Effect before mastery: 50% chance of extra meat drops when killing animals with a kitchen knife\nEffect after mastery: 75% chance of extra meat drops\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".tooltip","Channel qi to command strength—divine power knows no bounds.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".hold_shift.tooltip",
                "Effect before mastery: Reduces sprint hunger consumption to 60%\nEffect after mastery: Right-click with Gold-Thread Gloves to open ender chest\nMartial arts reach mastery after moving more than %s meters");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".tooltip","Fingers like gales, momentum like lightning.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".hold_shift.tooltip",
                "Effect before mastery: Stuns targets with max health below 25 for 1.5 seconds\nEffect after mastery: Stuns targets with max health below 200 for 2 seconds\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".tooltip","Invulnerable to swords and spears—like an unyielding golden bell.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".hold_shift.tooltip",
                "Effect before mastery: Increases armor by 4; gains Level 3 Damage Absorption when hit\nEffect after mastery: Increases armor by 8; Damage Absorption rises to Level 5\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".tooltip","Jianghu isn't just about fighting and killing—it's about human relationships and worldly wisdom!");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".hold_shift.tooltip",
                "Effect before mastery: One trade with villagers instantly raises their level to Apprentice\nEffect after mastery: 10% extra chance to trade without consuming items\nMartial arts reach mastery after %s trades with villagers");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".tooltip","Immortal and indestructible—could it be but a fantasy?");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".hold_shift.tooltip",
                "Effect before mastery: Blocks one fatal blow when near death\nEffect after mastery: Reduces cooldown by 15 seconds\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".tooltip","With such divine skill, why bully a mere ox?");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".hold_shift.tooltip",
                "Effect before mastery: Ignores block obstacles to deal 22 damage with external skills\nEffect after mastery: Increases attack range by 2 blocks\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".tooltip","Knowledge comes from diligence—ten thousand scrolls by the firefly-lit window.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".hold_shift.tooltip",
                "Effect before mastery: 25% chance to gain 5 XP per trade\nEffect after mastery: 35% chance to gain 10 XP per trade\nMartial arts reach mastery at Level 30 XP");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".tooltip","Though turtles have nostrils, they breathe through their ears.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".hold_shift.tooltip",
                "Effect before mastery: Extends underwater breath time; animals won't active attack after activation\nEffect after mastery: Enhances breath-holding effect\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".tooltip","A martial arts treasure sought by all in the wulin.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".hold_shift.tooltip",
                "Effect before mastery: Reduces hunger cost of skill activation by 1\nEffect after mastery: Reduces both hunger and saturation cost by 1\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".tooltip","Awaken potential, manipulate and shift—its changes are unfathomable, beyond imagination.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".hold_shift.tooltip",
                "Effect before mastery: 35% chance to reflect 1.5x damage back to attacker after 1.0 second\nEffect after mastery: +2% trigger chance per extra health point\nEach use increases cooldown by 2 seconds temporarily\n After successfully performing it" + " %s " + "times, your martial arts have reached mastery level");

        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu", "Learn " + "%s" + ", you can use " + "%s" + " to charge by holding down the right mouse button for " + "%s" + " seconds before unleashing your martial arts!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu_glove", "Learn " + "%s" + ", you can use " + "%s" + " to charge by holding down the right mouse button for " + "%s" + " seconds before unleashing your martial arts!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.internal_kungfu", "Learn " + "%s!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", "%s" + "had seen," + "%s!");

        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu", "%s has been studied. Use %s to attack targets and gain insight through actual combat!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu_glove", "%s has been studied. You still need to use bare hands or %s to attack Practice Stake for drilling and mastery!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.internal_kungfu", "%s has been studied. You still need to use %s to attack Practice Stake for drilling and mastery!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.light_kungfu", "%s has been studied. You still need %s to gain insight!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.mental_kungfu", "%s has been studied. You still need %s to gain insight!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.dacheng.kungfu", "%s has achieved divine mastery!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".swords.type", "Sword");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".softsword.type", "Soft Sword");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".clubbed.type", "Staff");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".glove.type", "Glove");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".knife.type", "Knife");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".lance.type", "Spear");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".throwingknives.type", "Throwing Knives");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type", "Bare hands or gloves");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".run_and_jump.type", "Running or jumping");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type", "Interacting with creatures");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.true.comprehend", "And it has been mastered! Hold the right mouse button with %s to charge for %s seconds to unleash the martial art");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.fales.comprehend", "You still need to attack targets with %s to gain insight through actual combat!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend", "And it has been mastered!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.fales.comprehend", "You still need to attack Practice Stake with %s to gain insight through practice!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".light_kungfu.fales.comprehend", "You still need %s to gain insight!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.fales.comprehend", "You still need %s to gain insight!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".state_change.kungfu", "%s : %s");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.open", "Activated. You still need to attack Practice Stake with bare hands or %s to gain insight through practice!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.open", "Activated. You still need to attack Practice Stake with bare hands to gain insight through practice!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.comprehend.open", "Activated. Hold the right mouse button with %s to charge for %s seconds to unleash the martial art");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.comprehend.open", "Activated. Once mastered, you can use %s to unleash the martial art!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off", "Deactivated");

        this.add("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty", "§cNo weapons left");

        this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.count","Dagger Pouch Capacity %s / %s");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".flying_dagger_pouch.right_click.tooltip","Pick up and right-click throwing knives in the inventory to store them in the dagger pouch");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".throwing_knives.right_click.tooltip","Pick up and right-click the dagger pouch in the inventory to store throwing knives in it");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".durability","Durability %s / %s");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.contents","Contents of the dagger pouch");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DURIAN.get()+".tooltip","Please use an axe to split it open");
        this.add("tooltip."+ChangShengJue.MOD_ID+".hold_shift.tooltip","Press §eShift§r to view more information");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data","Lined");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining","This armor cannot be lined");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining1","Please use a chestplate for lining");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.unload","Unloaded from equipment");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".damage_reduction","External damage reduction: +%s%%");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".trauma","Chance of sustaining external injuries: -%s%%");

        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "pit_yard.tooltip", "Underground Cave Dwelling");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "sandstone_castle.tooltip","Sandstone Fort");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "si_he_yuan.tooltip","Siheyuan");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "su_pai_village.tooltip","Su-style Village");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "hui_pai_village.tooltip","Hui-style Village");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "fortresses_type.tooltip","Ancient City");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "null.structure.tooltip","Unknown Structure");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".structural_location","At [x=%d | z=%d] there stands a %s, go check it out");

        //声音
        this.add("sounds."+ChangShengJue.MOD_ID + ".ge_shan_da_niu_sound","Martial Art: Ge Shan Da Niu");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dugu_nine_swords_sound","Martial Art: Dugu Nine Swords");
        this.add("sounds."+ChangShengJue.MOD_ID + ".immortal_miracle_sound","Martial Art: Immortal Miracle");
        this.add("sounds."+ChangShengJue.MOD_ID + ".gao_marksmanship_sound","Martial Art: Gao Family Spearplay");
        this.add("sounds."+ChangShengJue.MOD_ID + ".turtle_breath_work_sound","Martial Art: Turtle Breathing Work");
        this.add("sounds."+ChangShengJue.MOD_ID + ".golden_black_knife_method_sound","Martial Art: Jinwu Saber Technique");
        this.add("sounds."+ChangShengJue.MOD_ID + ".sunflower_point_caveman_sound","Martial Art: Sunflower Acupoint-Shooting Hand");
        this.add("sounds."+ChangShengJue.MOD_ID + ".shaolin_stick_method_sound","Martial Art: Shaolin Staffplay");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tread_the_snow_without_trace_sound","Martial Art: Tread Snow Without Trace");
        this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_sound","Throwing Knives: Flying Out");
        this.add("sounds."+ChangShengJue.MOD_ID + ".three_throwing_knives_sound","Throwing Knives: Flying Out");
        this.add("sounds."+ChangShengJue.MOD_ID + ".seven_throwing_knives_sound","Throwing Knives: Flying Out");
        this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit","Throwing Knives: Hit");
        this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit_ground","Throwing Knives: Hit Ground");
        this.add("sounds."+ChangShengJue.MOD_ID + ".wu_gang_cut_gui_sound","Martial Art: Wu Gang Chopping Cassia");
        this.add("sounds."+ChangShengJue.MOD_ID + ".xuannu_swordsmanship_sound","Martial Art: Xuannü Swordplay");
        this.add("sounds."+ChangShengJue.MOD_ID + ".golden_belljar_sound","Martial Art: Golden Bell Jar");
        this.add("sounds."+ChangShengJue.MOD_ID + ".qian_kun_da_nuo_yi_sound","Martial Art: Qiankun Great Shift");
        this.add("sounds."+ChangShengJue.MOD_ID + ".comprehend_sound","Martial Art: Breakthrough");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dacheng_sound","Martial Art: Mastery");

        this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_sound", "Cicada: Chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_hurt", "Cicada: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".crane_sound", "Crane: Crying");
        this.add("sounds."+ChangShengJue.MOD_ID + ".crane_hurt", "Crane: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".crane_death", "Crane: Death");
        this.add("sounds."+ChangShengJue.MOD_ID + ".croc_sound", "Crocodile: Roaring");
        this.add("sounds."+ChangShengJue.MOD_ID + ".croc_hurt", "Crocodile: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".croc_death", "Crocodile: Death");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_hurt", "Dragonfly: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_death", "Dragonfly: Death");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_sound" , "Monkey: Howling");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_baby_sound" , "Monkey: Howling");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_angry_sound" , "Monkey: Angry");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_hurt" , "Monkey: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_death" , "Monkey: Death");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_1" , "Monkey: Bowing (New Year Greeting)");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_2" , "Monkey: Somersaulting");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_3" , "Monkey: Saluting");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_4" , "Monkey: Filthy Howling");

        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound" , "Tiger: Roaring");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound_1" , "Tiger: Roaring");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_hurt" , "Tiger: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_death" , "Tiger: Death");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound" , "Deer: Bleating");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_1" , "Deer: Bleating");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_2" , "Deer: Bleating");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_3" , "Deer: Bleating");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_4" , "Deer: Bleating");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_5" , "Deer: Bleating");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_hurt" , "Deer: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_death" , "Deer: Death");
        this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_sound" , "Peacock: Calling");
        this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_hurt" , "Peacock: Hurt");
        this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_death" , "Peacock: Death");

        this.add("sounds."+ChangShengJue.MOD_ID + ".wind_chime_sound", "Wind Chime: Ting a ling");

        this.add("sounds."+ChangShengJue.MOD_ID + ".gong_sound", "Gong: Dong~");

        this.add("sounds."+ChangShengJue.MOD_ID + ".tailoring_case_sound", "Tailoring Table: Cutting");

        this.add("sounds."+ChangShengJue.MOD_ID + ".forge_block_sound", "Forge Hammer: Clanging");

        this.add("sounds."+ChangShengJue.MOD_ID + ".stakes_hit_sound", "Practice Stake: Being Struck");

        //方块
        this.add(ChangShengJueItems.STAKES.get(),"Practice Stake");
        this.add(ChangShengJueBlocks.GONG.get(),"Gong");
        this.add(ChangShengJueBlocks.CANTALOUPE_BLOCK.get(),"Cantaloupe");
        this.add(ChangShengJueBlocks.WILDLIFE_HORDEUM.get(),"Wild Barley");

        this.add(ChangShengJueBlocks.MANGO_LOG.get(),"Mango Log");
        this.add(ChangShengJueBlocks.MANGO_WOOD.get(),"Mango Wood");
        this.add(ChangShengJueBlocks.STRIPPED_MANGO_LOG.get(),"Stripped Mango Log");
        this.add(ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get(),"Stripped Mango Wood");
        this.add(ChangShengJueBlocks.MANGO_PLANKS.get(),"Mango Planks");
        this.add(ChangShengJueBlocks.MANGO_LEAVES.get(),"Mango Leaves");
        this.add(ChangShengJueBlocks.MANGO_SAPLING.get(),"Mango Sapling");

        this.add(ChangShengJueBlocks.BANANA_LOG.get(),"Banana Log");
        this.add(ChangShengJueBlocks.BANANA_LEAVES.get(),"Banana Leaves");
        this.add(ChangShengJueBlocks.BANANA_SAPLING.get(),"Banana Sapling");
        this.add(ChangShengJueBlocks.BANANA_FRUIT.get(),"Banana");

        this.add(ChangShengJueBlocks.PEAR_LOG.get(),"Pear Log");
        this.add(ChangShengJueBlocks.PEAR_WOOD.get(),"Pear Wood");
        this.add(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get(),"Stripped Pear Log");
        this.add(ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get(),"Stripped Pear Wood");
        this.add(ChangShengJueBlocks.PEAR_PLANKS.get(),"Pear Planks");
        this.add(ChangShengJueBlocks.PEAR_LEAVES.get(),"Pear Leaves");
        this.add(ChangShengJueBlocks.PEAR_SAPLING.get(),"Pear Sapling");

        this.add(ChangShengJueBlocks.LICHEE_LOG.get(),"Lychee Log");
        this.add(ChangShengJueBlocks.LICHEE_WOOD.get(),"Lychee Wood");
        this.add(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get(),"Stripped Lychee Log");
        this.add(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get(),"Stripped Lychee Wood");
        this.add(ChangShengJueBlocks.LICHEE_PLANKS.get(),"Lychee Planks");
        this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(),"Lychee Leaves");
        this.add(ChangShengJueBlocks.LICHEE_SAPLING.get(),"Lychee Sapling");

        this.add(ChangShengJueBlocks.DURIAN_LOG.get(),"Durian Log");
        this.add(ChangShengJueBlocks.DURIAN_WOOD.get(),"Durian Wood");
        this.add(ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get(),"Stripped Durian Log");
        this.add(ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get(),"Stripped Durian Wood");
        this.add(ChangShengJueBlocks.DURIAN_PLANKS.get(),"Durian Planks");
        this.add(ChangShengJueBlocks.DURIAN_LEAVES.get(),"Durian Leaves");
        this.add(ChangShengJueBlocks.DURIAN_SAPLING.get(),"Durian Sapling");

        this.add(ChangShengJueBlocks.OSMANTHUS_LOG.get(),"Osmanthus Log");
        this.add(ChangShengJueBlocks.OSMANTHUS_WOOD.get(),"Osmanthus Wood");
        this.add(ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get(),"Stripped Osmanthus Log");
        this.add(ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get(),"Stripped Osmanthus Wood");
        this.add(ChangShengJueBlocks.OSMANTHUS_PLANKS.get(),"Osmanthus Planks");
        this.add(ChangShengJueBlocks.OSMANTHUS_LEAVES.get(),"Osmanthus Leaves");
        this.add(ChangShengJueBlocks.OSMANTHUS_SAPLING.get(),"Osmanthus Sapling");
        this.add(ChangShengJueBlocks.OSMANTHUS_DEFOLIATION.get(),"Osmanthus Defoliation");

        this.add(ChangShengJueBlocks.PLUM_LOG.get(),"Plum Log");
        this.add(ChangShengJueBlocks.PLUM_WOOD.get(),"Plum Wood");
        this.add(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get(),"Stripped Plum Log");
        this.add(ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get(),"Stripped Plum Wood");
        this.add(ChangShengJueBlocks.PLUM_PLANKS.get(),"Plum Planks");
        this.add(ChangShengJueBlocks.PLUM_LEAVES.get(),"Plum Leaves");
        this.add(ChangShengJueBlocks.PLUM_SAPLING.get(),"Plum Sapling");
        this.add(ChangShengJueBlocks.PLUM_DEFOLIATION.get(),"Plum Defoliation");

        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get(),"Huanghuali Log");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get(),"Huanghuali Wood");
        this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get(),"Stripped Huanghuali Log");
        this.add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get(),"Stripped Huanghuali Wood");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LEAVES.get(),"Huanghuali Leaves");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(),"Huanghuali Sapling");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(),"Huanghuali Planks");

        this.add(ChangShengJueBlocks.WENGE_LOG.get(),"Wenge Log");
        this.add(ChangShengJueBlocks.WENGE_WOOD.get(),"Wenge Wood");
        this.add(ChangShengJueBlocks.STRIPPED_WENGE_LOG.get(),"Stripped Wenge Log");
        this.add(ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get(),"Stripped Wenge Wood");
        this.add(ChangShengJueBlocks.WENGE_LEAVES.get(),"Wenge Leaves");
        this.add(ChangShengJueBlocks.WENGE_SAPLING.get(),"Wenge Sapling");
        this.add(ChangShengJueBlocks.WENGE_PLANKS.get(),"Wenge Planks");

        this.add(ChangShengJueBlocks.ZI_TAN_LOG.get(),"Zitan Log");
        this.add(ChangShengJueBlocks.ZI_TAN_WOOD.get(),"Zitan Wood");
        this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get(),"Stripped Zitan Log");
        this.add(ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get(),"Stripped Zitan Wood");
        this.add(ChangShengJueBlocks.ZI_TAN_LEAVES.get(),"Zitan Leaves");
        this.add(ChangShengJueBlocks.ZI_TAN_SAPLING.get(),"Zitan Sapling");
        this.add(ChangShengJueBlocks.ZI_TAN_PLANKS.get(),"Zitan Planks");

        this.add(ChangShengJueBlocks.POPLAR_LOG.get(),"Poplar Log");
        this.add(ChangShengJueBlocks.POPLAR_WOOD.get(),"Poplar Wood");
        this.add(ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get(),"Stripped Poplar Log");
        this.add(ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get(),"Stripped Poplar Wood");
        this.add(ChangShengJueBlocks.POPLAR_PLANKS.get(),"Poplar Planks");
        this.add(ChangShengJueBlocks.POPLAR_LEAVES.get(),"Poplar Leaves");
        this.add(ChangShengJueBlocks.POPLAR_SAPLING.get(),"Poplar Sapling");
        this.add(ChangShengJueBlocks.POPLAR_DEFOLIATION.get(),"Poplar Defoliation");

        this.add(ChangShengJueBlocks.MULBERRY_LOG.get(),"Mulberry Log");
        this.add(ChangShengJueBlocks.MULBERRY_WOOD.get(),"Mulberry Wood");
        this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get(),"Stripped Mulberry Log");
        this.add(ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get(),"Stripped Mulberry Wood");
        this.add(ChangShengJueBlocks.MULBERRY_PLANKS.get(),"Mulberry Planks");
        this.add(ChangShengJueBlocks.MULBERRY_LEAVES.get(),"Mulberry Leaves");
        this.add(ChangShengJueBlocks.MULBERRY_SAPLING.get(),"Mulberry Sapling");

        this.add(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get(),"Blue and White Porcelain Flower Pots");

        this.add(ChangShengJueBlocks.MUGWORT_BLOCK.get(),"Mugwort");
        this.add(ChangShengJueBlocks.POTTED_MUGWORT_BLOCK.get(),"Mugwort");

        this.add(ChangShengJueBlocks.CAPSULE_BLOCK.get(),"Shepherd's Purse");

        this.add(ChangShengJueBlocks.CUCKOO_BLOCK.get(),"Azalea");
        this.add(ChangShengJueBlocks.POTTED_CUCKOO_BLOCK.get(),"Azalea");

        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get(),"Portulaca Oleracea");
        this.add(ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK.get(),"Portulaca Oleracea");

        this.add(ChangShengJueBlocks.JASMINE_BLOCK.get(),"Jasmine");
        this.add(ChangShengJueBlocks.POTTED_JASMINE_BLOCK.get(),"Jasmine");

        this.add(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get(),"Kochia Scoparia");
        this.add(ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK.get(),"Kochia Scoparia");

        this.add(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get(),"Narcissus");
        this.add(ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK.get(),"Narcissus");

        this.add(ChangShengJueBlocks.TAN_HUA_BLOCK.get(),"Epiphyllum");
        this.add(ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK.get(),"Epiphyllum");

        this.add(ChangShengJueBlocks.STIPA_GRANDIS.get(),"Stipa Grandis");
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(),"Stipa Grandis");
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(),"Tall Variant Stipa Grandis");

        this.add(ChangShengJueBlocks.SOLIDAGO.get(),"Solidago");
        this.add(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),"Solidago");

        this.add(ChangShengJueBlocks.GEUM_TRIFLORUM.get(),"Geum Triflorum");
        this.add(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),"Geum Triflorum");

        this.add(ChangShengJueBlocks.PURPLE_DANDELION.get(),"Purple Dandelion");
        this.add(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),"Purple Dandelion");

        this.add(ChangShengJueBlocks.RED_KNOTWEED.get(),"Red Knotweed");
        this.add(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(),"Variant Red Knotweed");

        this.add(ChangShengJueBlocks.RAPE_FLOWERS.get(),"Rape Flowers");

        this.add(ChangShengJueBlocks.ZHU_TAI.get(),"Candlestick");
        this.add(ChangShengJueBlocks.HANG_TU_BLOCK.get(),"Rammed Earth");
        this.add(ChangShengJueBlocks.HANG_TU_STAIRS.get(),"Rammed Earth Stairs");
        this.add(ChangShengJueBlocks.HANG_TU_SLAB.get(),"Rammed Earth Slab");
        this.add(ChangShengJueBlocks.HANG_TU_WALL.get(),"Rammed Earth Wall");
        this.add(ChangShengJueBlocks.TU_PEI_BLOCK.get(),"Adobe");
        this.add(ChangShengJueBlocks.TU_PEI_STAIRS.get(),"Adobe Stairs");
        this.add(ChangShengJueBlocks.TU_PEI_SLAB.get(),"Adobe Slab");
        this.add(ChangShengJueBlocks.TU_PEI_WALL.get(),"Adobe Wall");

        this.add(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get(), "White Walls");
        this.add(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get(), "Cool White Walls");
        this.add(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get(), "Warm White Walls");

        this.add(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),"White Fine Bricks");
        this.add(ChangShengJueBlocks.WHITE_BRICKS.get(),"White Bricks");
        this.add(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),"Black Stone Fine Bricks");
        this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),"Black Stone Bricks");
        this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),"Blue Stone Bricks");
        this.add(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),"Blue Stone Fine Bricks");

        this.add(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get(),"White Bricks Stairs");
        this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get(),"Black Stone Bricks Stairs");
        this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(),"Blue Stone Bricks Stairs");

        this.add(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get(),"White Bricks Slab");
        this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get(),"Black Stone Slab");
        this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(),"Blue Stone Slab");

        this.add(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get(),"White Bricks Vertical Walls");
        this.add(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get(),"Black Stone Vertical Walls");
        this.add(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(),"Blue Stone Vertical Walls");

        //效果
        this.add(ChangShengJueItems.TRAUMA_EFFECT.get(), "External Injury");
        this.add(ChangShengJueItems.INTERNAL_INJURY_EFFECT.get(), "Internal Injury");

        this.add(ChangShengJueBlocks.MANGROVE_OVERLORD_FIST.get(),"Mangrove Overlord Fist");
        this.add(ChangShengJueBlocks.BIRCH_OVERLORD_FIST.get(),"Birch Overlord Fist");
        this.add(ChangShengJueBlocks.JUNGLE_OVERLORD_FIST.get(), "Jungle Overlord Fist");
        this.add(ChangShengJueBlocks.CRIMSON_OVERLORD_FIST.get(), "Crimson Overlord Fist");
        this.add(ChangShengJueBlocks.WARPED_OVERLORD_FIST.get(), "Warped Overlord Fist");
        this.add(ChangShengJueBlocks.ACACIA_OVERLORD_FIST.get(), "Acacia Overlord Fist");
        this.add(ChangShengJueBlocks.DARK_OAK_OVERLORD_FIST.get(), "Dark Oak Overlord Fist");
        this.add(ChangShengJueBlocks.OAK_OVERLORD_FIST.get(), "Oak Overlord Fist");
        this.add(ChangShengJueBlocks.CHERRY_OVERLORD_FIST.get(), "Cherry Overlord Fist");
        this.add(ChangShengJueBlocks.SPRUCE_OVERLORD_FIST.get(), "Spruce Overlord Fist");
        this.add(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get(), "Short Mangrove Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get(), "Short Birch Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get(), "Short Jungle Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get(), "Short Crimson Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get(), "Short Warped Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get(), "Short Acacia Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get(), "Short Dark Oak Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get(), "Short Oak Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get(), "Short Cherry Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get(), "Short Spruce Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get(), "Short Mangrove Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get(), "Short Birch Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get(), "Short Jungle Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get(), "Short Crimson Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get(), "Short Warped Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get(), "Short Acacia Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get(), "Short Dark Oak Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get(), "Short Oak Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get(), "Short Cherry Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get(), "Short Spruce Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get(), "Long Mangrove Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get(), "Long Birch Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get(), "Long Jungle Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get(), "Long Crimson Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get(), "Long Warped Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get(), "Long Acacia Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get(), "Long Dark Oak Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get(), "Long Oak Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get(), "Long Cherry Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get(), "Long Spruce Meander-patterned Que Ti");
        this.add(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get(), "Long Mangrove Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get(), "Long Birch Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get(), "Long Jungle Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get(), "Long Crimson Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get(), "Long Warped Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get(), "Long Acacia Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get(), "Long Dark Oak Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get(), "Long Oak Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get(), "Long Cherry Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get(), "Long Spruce Flower-tooth Que Ti");
        this.add(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), "Mangrove Dougong");
        this.add(ChangShengJueBlocks.BIRCH_DOUGONG.get(), "Birch Dougong");
        this.add(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), "Jungle Dougong");
        this.add(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), "Crimson Dougong");
        this.add(ChangShengJueBlocks.WARPED_DOUGONG.get(), "Warped Dougong");
        this.add(ChangShengJueBlocks.ACACIA_DOUGONG.get(), "Acacia Dougong");
        this.add(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), "Dark Oak Dougong");
        this.add(ChangShengJueBlocks.OAK_DOUGONG.get(), "Oak Dougong");
        this.add(ChangShengJueBlocks.CHERRY_DOUGONG.get(), "Cherry Dougong");
        this.add(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), "Spruce Dougong");
        this.add(ChangShengJueBlocks.GREEN_DOUGONG.get(),"Green Dou with Blue Gong");
        this.add(ChangShengJueBlocks.BLUE_DOUGONG.get(),"Blue Dou with Green Gong");



        this.add(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get(),"Stone Lamp Base");
        this.add(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(),"Unlit Stone Lamp");
        this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(),"Stone Lamp");
        this.add(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(),"Yellow Stone Lion");
        this.add(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(),"Gray Stone Lion");
        this.add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),"Birch Stairs");
        this.add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),"Spruce Stairs");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),"Gray Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE.get(),"Red Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),"Black Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),"Golden Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),"Blue Glazed Tile");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),"Gray Cylinder Tile Slab");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),"Red Glazed Tile Slab");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),"Black Cylinder Tile Slab");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),"Golden Glazed Tile Slab");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),"Blue Glazed Tile Slab");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(),"Gray Side Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(),"Red Side Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(),"Black Side Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(),"Golden Side Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(),"Blue Side Glazed Tile");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),"Gray Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),"Red Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),"Black Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),"Golden Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),"Blue Side Octagonal Upturned Eaves");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Gray Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Red Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Black Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Golden Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Blue Side Octagonal Low Ridge Tiles (Front)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Gray Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Red Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Black Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Golden Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Blue Side Octagonal Low Ridge Tiles (Behind)");


        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Gray Side Octagonal High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Red Side Octagonal High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Black Side Octagonal High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Golden Side Octagonal High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Blue Side Octagonal High Ridge Tiles (Front)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Gray Side Octagonal High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Red Side Octagonal High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Black Side Octagonal High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Golden Side Octagonal High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Blue Side Octagonal High Ridge Tiles (Behind)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Gray Side Octagonal Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Red Side Octagonal Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Black Side Octagonal Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Golden Side Octagonal Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Blue Side Octagonal Double Ridge Tiles (Front)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Gray Side Octagonal Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Red Side Octagonal Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Black Side Octagonal Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Golden Side Octagonal Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Blue Side Octagonal Double Ridge Tiles (Behind)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Gray Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Red Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Black Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Golden Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Blue Side Ridge Tile Roof");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),"Gray Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),"Red Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),"Black Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),"Golden Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),"Blue Glazed Tile");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(),"Gray Eaves Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(),"Red Eaves Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(),"Black Eaves Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(),"Golden Eaves Tile");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(),"Blue Eaves Tile");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(),"Blue Double Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(),"Gray Double Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(),"Red Double Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(),"Black Double Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(),"Golden Double Glazed Tile");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(),"Blue Small Chiwen");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(),"Gray Small Chiwen");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(),"Red Small Chiwen");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(),"Black Small Chiwen");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(),"Golden Small Chiwen");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get(),"Blue High Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get(),"Gray High Ridge Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get(),"Red High Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get(),"Black High Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get(),"Golden High Ridge Tile");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get(),"Blue High Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get(),"Gray High Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get(),"Red High Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get(),"Black High Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get(),"Golden High Glazed Tile");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get(),"Blue Double Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get(),"Gray Double Ridge Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get(),"Red Double Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get(),"Black Double Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get(),"Golden Double Ridge Tile");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get(),"Blue Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get(),"Gray Upturned Eaves Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get(),"Red Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get(),"Black Upturned Eaves Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get(),"Golden Upturned Eaves Glazed Tile");

        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get(),"Blue Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get(),"Gray Ridge Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get(),"Red Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get(),"Black Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get(),"Golden Ridge Tile");

        this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),"Blue Double Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),"Gray Double Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),"Red Double Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),"Black Double Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),"Golden Double Ridge Beast Ridge Tile");

        this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get(),"Blue Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get(),"Gray Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get(),"Red Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get(),"Black Ridge Beast Ridge Tile");
        this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get(),"Golden Ridge Beast Ridge Tile");

        this.add(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(),"Blue Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(),"Gray Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(),"Red Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(),"Black Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(),"Golden Hanging Beast Ridge Tile");

        this.add(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(),"Blue Roof Ridge");
        this.add(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(),"Gray Roof Ridge");
        this.add(ChangShengJueBlocks.RED_ROOF_RIDGE.get(),"Red Roof Ridge");
        this.add(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(),"Black Roof Ridge");
        this.add(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(),"Golden Roof Ridge");

        this.add(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), "Blue Chiwen");
        this.add(ChangShengJueBlocks.GRE_DEMON_MASK.get(), "Gray Chiwen");
        this.add(ChangShengJueBlocks.RED_DEMON_MASK.get(), "Red Chiwen");
        this.add(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), "Black Chiwen");
        this.add(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), "Golden Chiwen");

        this.add(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), "Blue Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), "Gray Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), "Red Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), "Black Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), "Golden Pavilion Ridge Finial");

        this.add(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), "Blue Character Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), "Gray Character Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), "Red Character Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), "Black Character Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), "Golden Character Plaque Ridge Finial");

        this.add(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), "Blue Hipped Roof");
        this.add(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), "Gray Hipped Roof");
        this.add(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), "Red Hipped Roof");
        this.add(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), "Black Hipped Roof");
        this.add(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), "Golden Hipped Roof");

        this.add(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), "Blue Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), "Gray Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), "Red Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), "Black Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), "Golden Aligned Eaves Tile");

        this.add(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Blue Double Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Gray Double Ridge Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Red Double Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Black Double Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Golden Double Ridge Tile");

        this.add(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Blue Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Gray Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Red Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Black Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Golden Double Hanging Beast Ridge Tile");

        this.add(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), "Blue Short Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), "Gray Short Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), "Red Short Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), "Black Short Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), "Golden Short Glazed Tile");

        this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), "Blue Side Double Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), "Gray Side Double Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), "Red Side Double Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), "Black Side Double Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), "Golden Side Double Glazed Tile");

        this.add(ChangShengJueBlocks.BLUE_HIGH_CYLINDER_TILE_SIDE.get(), "Blue Side High Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_HIGH_CYLINDER_TILE_SIDE.get(), "Gray Side High Cylinder Tile");
        this.add(ChangShengJueBlocks.RED_HIGH_CYLINDER_TILE_SIDE.get(), "Red Side High Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_HIGH_CYLINDER_TILE_SIDE.get(), "Black Side High Cylinder Tile");
        this.add(ChangShengJueBlocks.GOLDEN_HIGH_CYLINDER_TILE_SIDE.get(), "Golden Side High Glazed Tile");

        this.add(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), "Blue Side Eaves Tile");
        this.add(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), "Gray Side Eaves Tile");
        this.add(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), "Red Side Eaves Tile");
        this.add(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), "Black Side Eaves Tile");
        this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), "Golden Side Eaves Tile");

        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_1.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), "Golden Tile");

        this.add(ChangShengJueBlocks.TILE_BLOCK.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_1.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_2.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_3.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_4.get(), "Tile");

        this.add(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get(), "Bitumen Floor Tiles");
        this.add(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get(), "Blue Stone Floor Tiles");
        this.add(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get(), "Black Stone Floor Tiles");

        this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get(), "Birch Windows");
        this.add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get(), "Birch Windows");
        this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get(), "Acacia Windows");
        this.add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get(), "Acacia Windows");
        this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get(), "Dark Oak Windows");
        this.add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get(), "Dark Oak Windows");
        this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get(), "Oak Windows");
        this.add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get(), "Oak Windows");
        this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get(), "Spruce Windows");
        this.add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get(), "Spruce Windows");

        this.add(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get(), "High Birch Windows");
        this.add(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get(), "High Acacia Windows");
        this.add(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get(), "High Dark Oak Windows");
        this.add(ChangShengJueBlocks.HIGH_OAK_WINDOWS.get(), "High Oak Windows");
        this.add(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get(), "High Spruce Windows");

        this.add(ChangShengJueBlocks.DOOR_BIRCH.get(), "Birch Door");
        this.add(ChangShengJueBlocks.DOOR_ACACIA.get(), "Acacia Door");
        this.add(ChangShengJueBlocks.DOOR_DARK_OAK.get(), "Dark Oak Door");
        this.add(ChangShengJueBlocks.DOOR_OAK.get(), "Oak Door");
        this.add(ChangShengJueBlocks.DOOR_SPRUCE.get(), "Spruce Door");

        this.add(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(), "Acacia Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(), "Dark Oak Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(), "Oak Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(), "Spruce Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get(), "Birch Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get(), "Jungle Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get(), "Mangrove Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get(), "Cherry Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get(), "Crimson Meiren Kao");
        this.add(ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get(), "Warped Meiren Kao");


        this.add(ChangShengJueBlocks.BIRCH_BENCH.get(), "Birch Bench");
        this.add(ChangShengJueBlocks.CRIMSON_BENCH.get(), "Crimson Bench");
        this.add(ChangShengJueBlocks.WARPED_BENCH.get(), "Warped Bench");
        this.add(ChangShengJueBlocks.MANGROVE_BENCH.get(), "Mangrove Bench");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get(), "Huanghuali Bench");
        this.add(ChangShengJueBlocks.JI_CHI_MU_BENCH.get(), "Jichimu Bench");
        this.add(ChangShengJueBlocks.ACACIA_BENCH.get(), "Acacia Bench");
        this.add(ChangShengJueBlocks.DARK_OAK_BENCH.get(), "Dark Oak Bench");
        this.add(ChangShengJueBlocks.OAK_BENCH.get(), "Oak Bench");
        this.add(ChangShengJueBlocks.CHERRY_BENCH.get(), "Cherry Bench");
        this.add(ChangShengJueBlocks.SPRUCE_BENCH.get(), "Spruce Bench");
        this.add(ChangShengJueBlocks.ZI_TAN_BENCH.get(), "Zitan Bench");

        this.add(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get(), "Birch Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get(), "Crimson Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get(), "Warped Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get(), "Mangrove Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get(), "Huanghuali Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get(), "Jichimu Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get(), "Acacia Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get(), "Dark Oak Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get(), "Oak Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get(), "Cherry Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get(), "Spruce Drinking Table's Chairs");
        this.add(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get(), "Zitan Drinking Table's Chairs");

        this.add(ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), "Birch Writing Desk");
        this.add(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), "Crimson Writing Desk");
        this.add(ChangShengJueBlocks.WARPED_BOOK_DESK.get(), "Warped Writing Desk");
        this.add(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), "Mangrove Writing Desk");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), "Huanghuali Writing Desk");
        this.add(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), "Jichimu Writing Desk");
        this.add(ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), "Acacia Writing Desk");
        this.add(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), "Dark Oak Writing Desk");
        this.add(ChangShengJueBlocks.OAK_BOOK_DESK.get(), "Oak Writing Desk");
        this.add(ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), "Cherry Writing Desk");
        this.add(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), "Spruce Writing Desk");
        this.add(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), "Zitan Writing Desk");

        this.add(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(), "Huanghuali Teapoy");
        this.add(ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get(), "Jichimu Teapoy");
        this.add(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(), "Zitan Teapoy");

        this.add(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), "Huanghuali Taishi Chair");
        this.add(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get(), "Jichimu Taishi Chair");
        this.add(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), "Zitan Taishi Chair");

        this.add(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), "Huanghuali Five-screen Throne");
        this.add(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get(), "Jichimu Five-screen Throne");
        this.add(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), "Zitan Five-screen Throne");

        this.add(ChangShengJueBlocks.BIRCH_LOW_DESK.get(), "Birch Low Desk");
        this.add(ChangShengJueBlocks.CRIMSON_LOW_DESK.get(), "Crimson Low Desk");
        this.add(ChangShengJueBlocks.WARPED_LOW_DESK.get(), "Warped Low Desk");
        this.add(ChangShengJueBlocks.MANGROVE_LOW_DESK.get(), "Mangrove Low Desk");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get(), "Huanghuali Low Desk");
        this.add(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get(), "Jichimu Low Desk");
        this.add(ChangShengJueBlocks.ACACIA_LOW_DESK.get(), "Acacia Low Desk");
        this.add(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get(), "Dark Oak Low Desk");
        this.add(ChangShengJueBlocks.OAK_LOW_DESK.get(), "Oak Low Desk");
        this.add(ChangShengJueBlocks.CHERRY_LOW_DESK.get(), "Cherry Low Desk");
        this.add(ChangShengJueBlocks.SPRUCE_LOW_DESK.get(), "Spruce Low Desk");
        this.add(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get(), "Zitan Low Desk");

        this.add(ChangShengJueBlocks.ZAFU.get(), "cushion");

        this.add(ChangShengJueBlocks.WHITE_JADE_BLOCK.get(),  "White Jade Block");
        this.add(ChangShengJueBlocks.WHITE_JADE_STAIRS.get(), "White Jade Stairs");
        this.add(ChangShengJueBlocks.WHITE_JADE_SLAB.get(), "White Jade Slab");
        this.add(ChangShengJueBlocks.WHITE_JADE_WALL.get(), "White Jade Wall");
        this.add(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(),"White Jade Balustrade");
        this.add(ChangShengJueBlocks.OAK_BALUSTRADE.get(),"Oak Balustrade");
        this.add(ChangShengJueBlocks.SPRUCE_BALUSTRADE.get(), "Spruce Balustrade");
        this.add(ChangShengJueBlocks.BIRCH_BALUSTRADE.get(), "Birch Balustrade");
        this.add(ChangShengJueBlocks.JUNGLE_BALUSTRADE.get(), "Jungle Balustrade");
        this.add(ChangShengJueBlocks.ACACIA_BALUSTRADE.get(), "Acacia Balustrade");
        this.add(ChangShengJueBlocks.MANGROVE_BALUSTRADE.get(), "Mangrove Balustrade");
        this.add(ChangShengJueBlocks.CHERRY_BALUSTRADE.get(), "Cherry Balustrade");
        this.add(ChangShengJueBlocks.DARK_OAK_BALUSTRADE.get(), "Dark Oak Balustrade");
        this.add(ChangShengJueBlocks.CRIMSON_BALUSTRADE.get(), "Crimson Balustrade");
        this.add(ChangShengJueBlocks.WARPED_BALUSTRADE.get(), "Warped Balustrade");
        this.add(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),"White Jade Guardrail");

        // 食物容器类方块
        this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(), "Jiaozi Plate");
        this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(), "Jiaozi Bowl");
        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(), "Portulaca Oleracea Cake Plate");
        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(), "Portulaca Oleracea Cake Bowl");
        this.add(ChangShengJueBlocks.QING_TUAN_PAN.get(), "Qingtuan Plate");
        this.add(ChangShengJueBlocks.QING_TUAN_WAN.get(), "Qingtuan Bowl");
        this.add(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(), "Sorghum Cake Plate");
        this.add(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(), "Sorghum Cake Bowl");
        this.add(ChangShengJueBlocks.MI_FAN_PAN.get(), "Rice Plate");
        this.add(ChangShengJueBlocks.MI_FAN_WAN.get(), "Rice Bowl");
        this.add(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(), "Millet Rice Plate");
        this.add(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(), "Millet Rice Bowl");


        this.add(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(), "Empty Shi Li Xiang Cup");
        this.add(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(), "Empty Wheat Nuggets Tribute Wine Cup");

        this.add(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), "Birch Wine Table");
        this.add(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(), "Crimson Wine Table");
        this.add(ChangShengJueBlocks.WARPED_WINE_TABLE.get(), "Warped Wine Table");
        this.add(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(), "Mangrove Wine Table");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(), "Huanghuali Wine Table");
        this.add(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(), "Jichimu Wine Table");
        this.add(ChangShengJueBlocks.ACACIA_WINE_TABLE.get(), "Acacia Wine Table");
        this.add(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(), "Dark Oak Wine Table");
        this.add(ChangShengJueBlocks.OAK_WINE_TABLE.get(), "Oak Wine Table");
        this.add(ChangShengJueBlocks.CHERRY_WINE_TABLE.get(), "Cherry Wine Table");
        this.add(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(), "Spruce Wine Table");
        this.add(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(), "Zitan Wine Table");

        this.add(ChangShengJueBlocks.AG_ORE.get(), "Silver Ore");
        this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), "Deepslate Silver Ore");
        this.add(ChangShengJueBlocks.KAOLIN_ORE.get(), "Kaolin Ore");
        this.add(ChangShengJueBlocks.LIMESTONE.get(), "Limestone");
        this.add(ChangShengJueBlocks.SYDEROLIFE_ORE.get(), "Clay Ore");

        this.add(ChangShengJueBlocks.CASTING_MOLDS.get(), "Copper Coin Mold");
        this.add(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(), "Ingot Casting Mold");

        this.add(ChangShengJueBlocks.PAINTING_SCROLL.get(), "Painting Scroll (1x1)");
        this.add(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), "Painting Scroll (1x2)");
        this.add(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), "Painting Scroll (2x1)");
        this.add(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), "Painting Scroll (2x2)");

        this.add(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), "Chang Sheng Jue Loom");
        this.add(ChangShengJueBlocks.POTTERY_WHEEL.get(), "Pottery Wheel");
        this.add(ChangShengJueBlocks.TOOL_TABLE.get(), "Tool Table");
        this.add(ChangShengJueBlocks.WEAPON_RACK.get(), "Weapon Rack");
        this.add(ChangShengJueBlocks.DESK.get(), "Desk");
        this.add(ChangShengJueBlocks.PIG_TROUGH.get(), "Livestock Trough");

        this.add(ChangShengJueBlocks.PLAQUE.get(), "Plaque");
        this.add(ChangShengJueBlocks.SHING_MUN_LEFT.get(), "Small City Gate (Left)");
        this.add(ChangShengJueBlocks.SHING_MUN_RIGHT.get(), "Small City Gate (Right)");

        this.add(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get(), "Big City Gate (Left)");
        this.add(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get(), "Big City Gate (Right)");
        this.add(ChangShengJueBlocks.WIND_CHIME.get(), "Wind Chime");
        this.add(ChangShengJueBlocks.TAILORING_CASE.get(), "Tailoring Table");
        this.add(ChangShengJueBlocks.FORGE_BLOCK.get(), "Forge Furnace");

        //实体生物
        this.add(ChangShengJueEntity.BUTTERFLY.get(), "Butterfly");
        this.add(ChangShengJueEntity.MONKEY.get(), "Monkey");
        this.add(ChangShengJueEntity.DRAGONFLY.get(), "Dragonfly");
        this.add(ChangShengJueEntity.CICADA.get(), "Cicada");
        this.add(ChangShengJueEntity.CRANE.get(), "Crane");
        this.add(ChangShengJueEntity.MALE_PEACOCK.get(), "Male Peacock");
        this.add(ChangShengJueEntity.FEMALE_PEACOCK.get(), "Female Peacock");
        this.add(ChangShengJueEntity.STAG.get(), "Stag");
        this.add(ChangShengJueEntity.HIND.get(), "Hind");
        this.add(ChangShengJueEntity.TIGER.get(), "Tiger");
        this.add(ChangShengJueEntity.CROC.get(), "Crocodile");
        this.add(ChangShengJueEntity.WARRIOR.get(), "Warrior");
        this.add(ChangShengJueEntity.KILN_WORKER.get(), "Kiln Worker");
        this.add(ChangShengJueEntity.MALE_INNKEEPER.get(), "Male Innkeeper");
        this.add(ChangShengJueEntity.FEMALE_INNKEEPER.get(), "Female Innkeeper");
        this.add(ChangShengJueEntity.CHALLENGER.get(), "Challenger");
        this.add(ChangShengJueEntity.BLACKSMITH.get(), "Blacksmith");
        this.add(ChangShengJueEntity.LANCE_GANG_LEADER.get(), "Lance Gang Leader");
        this.add(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), "Knife Gang Leader");
        this.add(ChangShengJueEntity.SWORD_GANG_LEADER.get(), "Sword Gang Leader");
        this.add(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), "Clubbed Gang Leader");
        this.add(ChangShengJueEntity.GANG_LEADER.get(), "Gang Leader");
        this.add(ChangShengJueEntity.BANDIT.get(), "Bandit");
        this.add(ChangShengJueEntity.VILLAIN.get(), "Villain");
        this.add(ChangShengJueEntity.ASSASSIN.get(), "Gang Assassin");
        this.add(ChangShengJueEntity.CLUBBED_MING_XIA.get(), "Staff King Master Dong");
        this.add(ChangShengJueEntity.SWORD_MING_XIA.get(), "Sword Immortal Master Zhang");
        this.add(ChangShengJueEntity.KNIFE_MING_XIA.get(), "Blade Sage Master Xu");
        this.add(ChangShengJueEntity.FIST_MING_XIA.get(), "Northern Fist Master Xiao");
        this.add(ChangShengJueEntity.PIGLIN_WU_XIA.get(), "Kung Fu Piglin");
        this.add(ChangShengJueEntity.WITCH_WU_XIA.get(), "Kung Fu Witch");
        this.add(ChangShengJueEntity.EVOKER_WU_XIA.get(), "Kung Fu Evoker");
        this.add(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), "Kung Fu Vindicator");
        this.add(ChangShengJueEntity.PILLAGER_WU_XIA.get(), "Kung Fu Pillager");

        this.add(ChangShengJueEntity.STAKES.get(), "Training Stake");
        this.add(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), "Ge Shan Da Niu");
        this.add(ChangShengJueEntity.PEACOCK_EGG.get(), "Peacock Egg");
        this.add(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), "Throwing Knife");
        this.add(ChangShengJueEntity.BA_WANG_QIANG.get(), "Ba Wang Spear");
        this.add(ChangShengJueEntity.RED_TASSELLED_SPEAR.get(), "Red Tasselled Spear");
        // 村民职业
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_farmer", "Farmer");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_potter", "Potter");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_hunter", "Hunter");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_chief", "Village Chief");
        this.add("entity.minecraft.villager.chang_sheng_jue.chang_sheng_jue_seamstress", "Seamstress");

        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_farmer", "Farmer");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_potter", "Potter");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_hunter", "Hunter");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_chief", "Village Chief");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.chang_sheng_jue.chang_sheng_jue_seamstress", "Seamstress");

        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager", "Villager");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.none", "Villager");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.villager", "Villager");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.armorer", "Armorer");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.butcher", "Butcher");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cartographer", "Cartographer");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.cleric", "Cleric");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.farmer", "Farmer");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fisherman", "Fisherman");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.fletcher", "Fletcher");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.leatherworker", "Leatherworker");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.librarian", "Librarian");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.mason", "Mason");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.nitwit", "Nitwit");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.shepherd", "Shepherd");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.toolsmith", "Toolsmith");
        this.add("entity.chang_sheng_jue.chang_sheng_jue_villager.weaponsmith", "Weaponsmith");

        //buff
        this.add(ChangShengJueEffects.BLEED_EFFECT.get(), "Bleeding");
        this.add(ChangShengJueEffects.DIZZY_EFFECT.get(), "Dizziness");
        this.add(ChangShengJueEffects.AIRBORNE_EFFECT.get(), "Airborne");
        this.add(ChangShengJueEffects.FIXATION_EFFECT.get(), "Fixation");
//        this.add(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), "Golden Bell Jar");
        this.add(ChangShengJueEffects.TURTLE_BREATH_EFFECT.get(), "Turtle Breath");
        this.add(ChangShengJueEffects.TRAUMA_EFFECT.get(), "Trauma");
        this.add(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), "Internal Injury");
        this.add(ChangShengJueEffects.BILUOCHUN_TEAS.get(), "Biluochun");
        this.add(ChangShengJueEffects.LONG_JING_TEAS.get(), "Longjing");
        this.add(ChangShengJueEffects.FEN_JIU.get(), "Fenjiu");
        this.add(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get(), "Wheat Nuggets Tribute Wine");
        this.add(ChangShengJueEffects.SHI_LI_XIANG.get(), "Shi Li Xiang");
        this.add(ChangShengJueEffects.DRUNKEN.get(), "Drunkenness");
        this.add(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), "Continuous Villager Reputation Boost");
        this.add(ChangShengJueEffects.INSTANT_CHARM_EFFECT.get(), "Instant Villager Reputation Boost");
        this.add(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get(), "Instant Villager Reputation Reduction");

        //群系
        this.add("biome."+ ChangShengJue.MOD_ID +".chang_shen_jue_prairie", "Muran Prairie");

        //按键

        //存储
        this.add("container.hercules", "Hercules' Mighty Skill");

        /*信息*/
//死亡信息
        this.add("death.attack." + CSJDamageTypes.BLEED.location().getPath(), "%1$s bled to death.");
        this.add("death.attack." + CSJDamageTypes.MARTIAL_ARTS.location().getPath(), "%1$s had their internal organs shattered by %2$s using martial arts.");
        this.add("death.attack." + CSJDamageTypes.TRAUMA.location().getPath(), "%1$s succumbed to severe trauma.");
        //配置文件信息
        this.add("config."+ ChangShengJue.MOD_ID +".reload", "Configuration reloaded");
        this.add("config."+ ChangShengJue.MOD_ID +".enable_quests", "Whether to enable auto-accept type quests.");
        this.add("config."+ ChangShengJue.MOD_ID +".spirit_recovery_amount", "Naturally restored lingqi value.");
        this.add("config."+ ChangShengJue.MOD_ID +".spirit_recovery_interval", "Lingqi natural recovery interval (game ticks).");
        this.add("config."+ ChangShengJue.MOD_ID +".spirit_root_ju_qi_efficiency", "Number of spirit roots affects qi gathering efficiency after the huashen stage");
        this.add("config."+ ChangShengJue.MOD_ID +".tun_na_particle", "Whether to display tuna particles");
        this.add("config."+ ChangShengJue.MOD_ID +".breakthrough_particle", "Whether to display breakthrough particles");

        this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_level", "dugu nine swords max level");
        this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_exp", "dugu nine swords max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_cooldown", "dugu nine swords max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_level", "gao marksmanship max level");
        this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_exp", "gao marksmanship max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_cooldown", "gao marksmanship max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_level", "ge shan da niu max level");
        this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_exp", "ge shan da niu max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_cooldown", "ge shan da niu max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_level", "golden black knife method max level");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_exp", "golden black knife method max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_cooldown", "golden black knife method max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_level", "shaolin stick method max level");
        this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_exp", "shaolin stick method max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_cooldown", "shaolin stick method max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_level", "sunflower point caveman max level");
        this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_exp", "sunflower point caveman max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_cooldown", "sunflower point caveman max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_level", "turtle breath work max level");
        this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_exp", "turtle breath work max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_cooldown", "turtle breath work max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_level", "xuannu swordsmanship max level");
        this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_exp", "xuannu swordsmanship max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_cooldown", "xuannu swordsmanship max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_level", "relentless throwing knives max level");
        this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_exp", "relentless throwing knives max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_cooldown", "relentless throwing knives max cooldown");
        this.add("config."+ ChangShengJue.MOD_ID +".flying_dagger_pouch_max_slots", "flying dagger pouch max slots");

        this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_level", "golden bell jar max level");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_exp", "golden bell jar max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_cooldown", "golden bell jar max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".hercules_max_exp", "hercules max exp");

        this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_level", "immortal miracle max level");
        this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_exp", "immortal miracle max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_cooldown", "immortal miracle max cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_level", "qian kun da nuo yi max level");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_exp", "qian kun da nuo yi max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_cooldown", "qian kun da nuo yi max cooldown");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_probability", "qian kun da nuo yi bounce damage probability");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_extra_probability", "qian kun da nuo yi bounce damage extra probability");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_multiplier", "qian kun da nuo yi bounce damage multiplier");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_tick", "qian kun da nuo yi bounce damage tick");
        this.add("config."+ ChangShengJue.MOD_ID +".qian_kun_da_nuo_yi_max_cooldown_extra_tick", "qian kun da nuo yi max cooldown extra tick");

        this.add("config."+ ChangShengJue.MOD_ID +".the_classics_of_tendon_changing_max_exp", "the classics of tendon changing max exp");

        this.add("config."+ ChangShengJue.MOD_ID +".paoding_max_exp", "paoding max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".paoding_additional_drops_count", "paoding additional drops count");

        this.add("config."+ ChangShengJue.MOD_ID +".wu_gang_cut_gui_max_exp", "wu gang cut gui max exp");

        this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_max_exp", "yugong moves mountains max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_excavation_range", "yugong moves mountains excavation range");

        this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_max_exp", "zhang men xin xue max exp");
        this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_extra_probability", "zhang men xin xue extra probability");

        this.add("block.changshengjue.fen_jiu.no_wine","There's no wine left!");
        this.add("tooltip.changshengjue.natural_silk", "Obtained by mining mulberry leaves");

        //进度
        // 一级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".begin", "Chang Sheng Jue");
        this.add("advancement." + ChangShengJue.MOD_ID + ".begin.desc", "The vast world is full of wonders");

        // 二级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan", "Man is iron, food is steel");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan.desc", "Man relies on food, just as iron relies on steel; skip one meal, and hunger will strike.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions", "Silver's Radiance Gleams");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions.desc", "Though silver may turn black over time, its inner brilliance still shines.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword", "The Knight's Journey");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword.desc", "A true knight fears no authority, dares to strive for justice, takes it upon themselves to protect the weak and uphold righteousness, and dedicates themselves selflessly without counting personal gains or losses.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage", "A New Life!");
        this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage.desc", "From the great rivers to the north and south, the land is as beautiful as a painting!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask", "A Guild?");
        this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask.desc", "Watch as this young master dominates the world and shakes the realm!");

        // 三级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee", "The Concubine's Smile");
        this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee.desc", "A steed kicks up red dust, the concubine smiles; none knows it's lychees coming."); // 杜牧《过华清宫》诗句英译

        this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg", "Homestyle Stir-Fry");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg.desc", "A home-cooked stir-fry anyone can make, yet each tastes uniquely different.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hastea", "Gentle Breezes Arise");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hastea.desc", "Since Shennong tasted a hundred herbs, tea has been used to detoxify—its history stretches back through the ages.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".haswine", "Sing to Wine, How Long Is Life?");
        this.add("advancement." + ChangShengJue.MOD_ID + ".haswine.desc", "Like morning dew, the days gone by are bitterly many."); // 曹操《短歌行》诗句英译

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions", "Golden Radiance");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions.desc", "Gold shines wherever it's placed!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong", "A Trusty Weapon");
        this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong.desc", "With a trusty sword, roam the world freely.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor", "Rustic Knight");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor.desc", "Though the armor is simple, the heart is as firm as stone.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa", "First Steps in Training");
        this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa.desc", "If you slack at the first setback, how can you achieve greatness?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware", "Craft Porcelain");
        this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware.desc", "china, china, china!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask", "Who Defines Good and Evil?");
        this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask.desc", "Read more to avoid deception. Study history to discern right from wrong.");

// 四级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu", "Auspiciousness and Fortune");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu.desc", "Strengthens the spleen, nourishes the stomach, reduces stagnation, aids weight loss, boosts qi, and calms the spirit.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou", "Sweetness");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou.desc", "May your life always be sweet, or unfold into sweetness ahead.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hassword", "Legendary Divine Weapon");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hassword.desc", "Supreme in martial arts, the dragon-slaying blade commands all under heaven—none dare disobey!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor", "Scion of a Martial Family");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor.desc", "Though the armor is strong, do not let it gather dust.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa", "Mastery Through Integration");
        this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa.desc", "Achievements exist, yet remember: there are always others greater, heavens beyond heavens.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask", "Respond to Every Request");
        this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask.desc", "Learn to refuse—you can't unclog all toilets.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken", "Gang Leader");
        this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken.desc", "I carry not Causeway Bay, but the world! All living beings under heaven!");

// 五级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian", "Unfinished Journey");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian.desc", "Where is the Great Sage Equal to Heaven? Where lies the path to immortality? What of the future?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone", "Grand Master");
        this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone.desc", "Humans have passions; swords do not, nor do martial arts. Atop the Forbidden City, who can rival me?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask", "Recluse Hero");
        this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask.desc", "Though one with passions and desires, how can the heart rest while the world is unjust?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader", "Top Seat");
        this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader.desc", "This wooden seat is far more comfortable than that blade-edged one—no more sore buttocks.");
        //按钮
        this.add ("quest."+ ChangShengJue.MOD_ID +".gre_button", "Gray");
        this.add ("quest."+ ChangShengJue.MOD_ID +".red_button", "Red");
        this.add ("quest."+ ChangShengJue.MOD_ID +".black_button", "Black");
        this.add ("quest."+ ChangShengJue.MOD_ID +".blue_button", "Cyan");
        this.add ("quest."+ ChangShengJue.MOD_ID +".golden_button", "Golden");

        //任务
        this.add("quest." + ChangShengJue.MOD_ID + ".button", "Quest");
        this.add("quest." + ChangShengJue.MOD_ID + ".requirements", "Quest Requirements:");
        this.add("quest." + ChangShengJue.MOD_ID + ".rewards", "Quest Rewards:");
        this.add("quest." + ChangShengJue.MOD_ID + ".submit.button", "Submit Quest");
        this.add("quest." + ChangShengJue.MOD_ID + ".accept.button", "Accept Quest");
        this.add("quest." + ChangShengJue.MOD_ID + ".abandon.button", "Abandon Quest");
        this.add("quest." + ChangShengJue.MOD_ID + ".flushed.button", "Flush Quest");
        this.add("quest." + ChangShengJue.MOD_ID + ".requirements.prompt", "Insufficient Quest Requirements!");
        this.add("quest." + ChangShengJue.MOD_ID + ".finish", "§a%s Quest Completed!");
        this.add("quest." + ChangShengJue.MOD_ID + ".trigger", "§aTrigger %s Quest");
        this.add("quest." + ChangShengJue.MOD_ID + ".fail", "§a%s Quest Failed!");

        this.add("quest."+ ChangShengJue.MOD_ID +".food.questName", "Gather Food");
        this.add("quest."+ ChangShengJue.MOD_ID +".food.questDescription", "Gang Leader: Our brothers are running out of food supplies—we can't let everyone go hungry! Go find a way to get more.");
        this.add("quest."+ ChangShengJue.MOD_ID +".money.questName", "Gather Money");
        this.add("quest."+ ChangShengJue.MOD_ID +".money.questDescription", "Gang Leader: Everything costs money these days—even a hero can be stumped by a single coin. Brother, can you collect some gang funds?");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questName", "Challenge the Gang Turf");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questDescription", "Gang Leader: Dammit! This is the second gang to invade our turf while I'm ill—they think we have no capable men? Go teach them a lesson!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questRequirementsDescription", "Kill any enemy gang leader");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questName", "Chivalrous Journey");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questDescription", "Gang Leader: Those Pillager Patrols keep picking fights with us—they're asking for death! Take them down!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questRequirementsDescription", "Kill Pillagers");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questName", "Kill the Chicken to Warn the Monkey");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questDescription", "Gang Leader: Those unruly folks have refused our gang dues three times—they're getting too bold! Go show them what happens when they defy us!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questRequirementsDescription", "Kill any Villager");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questName", "Toumingzhuang (Admission Token)");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questDescription", "Gang Leader: Brother, if you want to join our gang, you must first present a 'Toumingzhuang'—proof of your loyalty (by killing someone)!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questRequirementsDescription", "Kill any humanoid creature");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questName", "Duel of Skill");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questDescription", "Gang Leader: Some brothers heard you're a skilled warrior—they want to test their strength against yours. What do you say?");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questRequirementsDescription", "Defeat or kill the challenger");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questName", "The Best Under Heaven");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_1.questDescription", "Gang Leader: Though Great Hero Dong the Scepter King is now the strongest under heaven, your skills are enough to rival his!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_2.questDescription", "Gang Leader: Though Great Hero Xu the Saber Sage is now the strongest under heaven, your skills are enough to rival his!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_3.questDescription", "Gang Leader: Though Great Hero Xiao the Northern Fist Master is now the strongest under heaven, your skills are enough to rival his!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_4.questDescription", "Gang Leader: Though Great Hero Zhang the Sword Immortal is now the strongest under heaven, your skills are enough to rival his!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questRequirementsDescription", "Kill one of the Four Great Chivalrous Heroes");

        this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questName", "Protect the Village");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questDescription", "Gang Leader: The village under our gang's protection is under attack—hurry and defend our grain storehouse!");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questRequirementsDescription", "Win the village raid battle");

        this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questName", "Heroic Healer Saving the People");
        this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questDescription", "Gang Leader: A nearby village was attacked by zombies—many villagers turned into Zombie Villagers. I heard you know some healing skills—can you help?");
        this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questRequirementsDescription", "Cure one Zombie Villager");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questName", "Vegetarian Feast");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questDescription", "Gang Leader: With compassion in your heart, you shall not break the precept of killing.");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questRequirementsDescription", "Do not kill any creature within 2 in-game days");

        this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questName", "Uphold Justice with Chivalry");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questDescription", "A nearby village is swarmed by zombies—will you risk your life to help the villagers?");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questRequirementsDescription", "Stay in the village and help villagers fend off zombies");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questName", "Pastoral Chivalric Hero");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questDescription", "Because of you, no one dares to bully the villagers here—and you live in peace alongside them.");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questRequirementsDescription", "Encounter villagers by chance");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questName", "Act on Grievances Boldly");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questDescription", "If you don't settle grievances clearly, you're not worthy of being a true man under heaven.");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questRequirementsDescription", "Defeat enemies that attack you");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questName", "Eliminate Harm for the People");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questDescription", "This fierce tiger preys on villagers—be careful, great hero!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questRequirementsDescription", "Kill 1 Tiger");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questName", "Suppress the Wicked, Protect the Innocent");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questDescription", "Village Chief: There's a villain looting and plundering our village—can you help us, great hero?!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questRequirementsDescription", "Kill 1 Villain");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questName", "Wuxia Warrior");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questDescription", "When you see injustice on the road, draw your sword to help—that's what makes a chivalrous hero.");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questRequirementsDescription", "Kill 1 Zombie in the village at night");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questName", "Kill for Loot");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questDescription", "You flaunted your treasures so openly—don't blame me for being ruthless! Hehe...");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questRequirementsDescription", "Kill 1 Wandering Trader");

        this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questName", "Large-Scale Transaction");
        this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questDescription", "Village Chief: We had a poor harvest this year—we'll struggle through winter. Can you help us gather food to get through the hard times?");

        this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questName", "Large-Scale Transaction");
        this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questDescription", "Village Chief: We had a great harvest this time! But so much grain will spoil if stored too long—can you help us find a solution, great hero?");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questName", "Ren Woxing (Unrestrained Wanderer)");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questDescription", "The sea is vast and the sky is wide—where can't a man reside freely?");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questRequirementsDescription",  "Less than 1 death within 7 in-game days");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questName", "Suppress the Strong, Aid the Weak");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questDescription", "Villagers not only face zombie attacks—they're also threatened by bandit gangs!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questRequirementsDescription", "Kill 3 Bandits");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questName", "Jianghu Bounty (Wulin Manhunt Order)");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questDescription", "You helped the village fight against gangs—now all major forces have labeled you a 'public enemy of Wulin' and sent assassins after you!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questRequirementsDescription", "Kill the assassins sent to attack you");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombies.questName", "Pride Between Heaven and Earth");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombies.questDescription", "I have a hundred strengths—why use them on the weak? If heaven and earth are unjust, I shall right it myself! Even facing a hundred foes, though daunting, counter with wisdom and courage.");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombies.questRequirementsDescription", "Kill 100 Zombies");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questName", "If Heaven Had Affections, It Would Grow Old");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questDescription", "The right path under heaven is full of vicissitudes.");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questRequirementsDescription", "Complete the 'Jianghu Bounty' quest twice");

        //裁衣案"container.tailoring_case.json"
        this.add("container."+ ChangShengJue.MOD_ID +".tailoring_case", "tailoring case");
        this.add("gui."+ ChangShengJue.MOD_ID + ".tailoring_case.craft", "tailoring");
        //锻台“forgeblock”
        this.add("container."+ ChangShengJue.MOD_ID +".forge_block", "forge block");
        this.add("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft", "forge");

        this.add(ChangShengJue.MOD_ID +".function", "function item");
        this.add(ChangShengJue.MOD_ID +".function.desc", "Many strange people came from that rift in space—they not only dance fire into phoenixes and fly through the sky, but also brought many strange things. They're from the East, right?");
        this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots", "blue and white porcelain flower pots");
        this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots.page1.title", "blue and white porcelain flower pots");
        this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots.page1.text", "equivalent to vanilla flower pots");
        this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry", "brush and lime slurry");
        this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry.page1.title", "brush and lime slurry");
        this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry.page1.text", "Place any lime slurry bucket in the offhand, hold the brush in the main hand, and you can paint the entire block of red bricks into the corresponding color system white wall. The lime slurry bucket will become an empty bucket after using it 12 times.");
        this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds", "bullions casting molds");
        this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds.page1.text", "Place the mold right-click on the ground, hold the crucible (gold/silver liquid) right-click to pour in");
        this.add(ChangShengJue.MOD_ID +".function.casting_molds", "casting molds");
        this.add(ChangShengJue.MOD_ID +".function.casting_molds.page1.text", "Used to cast copper coins, place the mold right-click on the ground, hold the crucible (copper liquid) right-click to pour in");
        this.add(ChangShengJue.MOD_ID +".function.crucible", "crucible");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page1.title", "crucible");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page1.text", "It is an important tool for making copper coins and bullions$(br)Can be combined with 8 copper/silver/gold to become crucible (crushed copper/silver/gold)$(br)【crucible (crushed copper/silver/gold)】 can be obtained by burning in the furnace");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page3.text", "crucible (crushed copper/silver/gold) can be obtained by burning in the furnace");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page5.text", "crucible (copper/silver/gold liquid) can be placed in the mold to make: copper coins/bullions");
        this.add(ChangShengJue.MOD_ID +".function.ladder", "ladder");
        this.add(ChangShengJue.MOD_ID +".function.ladder.page1.title", "ladder");
        this.add(ChangShengJue.MOD_ID +".function.ladder.page1.text", "The ladder is a tool that can be used to climb up and down. It can be used to climb up and down ladders. It can also be used to climb up and down stairs.");
        this.add(ChangShengJue.MOD_ID +".function.painting_scroll", "painting scroll");
        this.add(ChangShengJue.MOD_ID +".function.painting_scroll.page1.title", "painting scroll");
        this.add(ChangShengJue.MOD_ID +".function.painting_scroll.page1.text", "There are four types of painting scrolls: 1x1, 2x1, 1x2, and 2x2. They are equivalent to vanilla paintings and have many patterns.");
        this.add(ChangShengJue.MOD_ID +".function.plaque", "plaque");
        this.add(ChangShengJue.MOD_ID +".function.plaque.page1.title", "plaque");
        this.add(ChangShengJue.MOD_ID +".function.plaque.page1.text", "Right-click the plaque to write content. Place it on the side of the block, equivalent to the signboard (can connect left and right to adjust the length of the plaque)");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp", "stone lamp");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page1.title", "stone lamp");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page1.text", "The stone lamp has two states: lit and unlit$(br)Use a flint and steel to ignite it, used as a light source, with an illumination brightness equal to that of a candlestick");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.title", "stone lamp base");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.text", "The base of the stone lamp, except for decoration, has no other functions");
        this.add(ChangShengJue.MOD_ID +".function.zhu_tai", "candlestick");
        this.add(ChangShengJue.MOD_ID +".function.zhu_tai.page1.text", "Equivalent to vanilla torches, illuminating a radius of 12 blocks.");this.add(ChangShengJue.MOD_ID +".village", "Village");
        this.add(ChangShengJue.MOD_ID +".village.desc", "Various Chinese-style villages are scattered across the Minecraft world, bringing many new and interesting items...");
        this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom", "Loom");
        this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom.page1.text", "Instructions: Right-click the Loom with $(item)Silk$() in your main hand to craft $(item)Silk Cloth$()$(br)Output Ratio: 2 Silk → 1 Silk Cloth");
        this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough", "Animal Trough");
        this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page1.text", "Growth Acceleration:$(li)Place $(item)Wheat$()$(br)Effect: Increases nearby animal growth speed by 20%");
        this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page2.text", "Animal Trough Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel", "Pottery Wheel");
        this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel.page1.text", "Interaction:$(li)1 Clay → Craft $(item)Ceramic Cup$()$(li)2 Clay → Craft $(item)Ceramic Bowl$()$(li)3 Clay → Craft $(item)Ceramic Plate$()");
        this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel.page2.text", "Pottery Wheel Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".village.tool.tool_table", "Tool Table");
        this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page1.text", "Maintenance: Right-click the Tool Table with $(item)Bow$() in your main hand to quickly repair tool durability");
        this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page2.text", "Tool Table Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief", "Village Chief");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page1.title", "Village Chief");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page1.text", "Right-clicking the Village Chief has a 50% chance to trigger the village quest [Suppress Evil], completing it will give certain rewards.");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.title", "Village Chief Trading List - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.text", "$(br)$(li)1x Silver Ingot → 6x Copper Coins$(br)$(li)1x Gold Ingot → 6x Silver Ingots$(br)$(li)7x Copper Coins → 1x Silver Ingot$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.title", "Village Chief Trading List - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.text", "$(br)$(li)1x Diamond → 4x Copper Coins$(br)$(li)4x Copper Coins → 2x Oil Lamp$(br)$(li)7x Silver Ingots → 1x Gold Ingot$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.title", "Village Chief Trading List - Experienced");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.text", "$(br)$(li)1x Compass → 4x Copper Coins$(br)$(li)4x Copper Coins → 1x Emerald$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.title", "Village Chief Trading List - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.text", "Expert:$(br)$(li)2x Book and Quill → 4x Copper Coins$(br2)Master:$(br)$(li)1x Silver Ingot → 1x Calligraphy$(br)$(li)2x Gold Ingots → 1x Emerald$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.anchor", "Village Chief-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.anchor", "Village Chief-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.anchor", "Village Chief-Experienced");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.anchor", "Village Chief-Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer", "Farmer");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page1.title", "Farmer");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.anchor", "Farmer-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.title", "Farmer Trading List - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.text", "$(br)$(li)20x Corn → 4x Copper Coins$(br)$(li)20x Rice → 4x Copper Coins$(br)$(li)22x Tomato → 4x Copper Coins$(br)$(li)22x Peanut → 4x Copper Coins$(br)$(li)4x Copper Coins → 4x Cooked Rice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.anchor", "Farmer-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.title", "Farmer Trading List - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.text", "$(br)$(li)22x Grape → 4x Copper Coins$(br)$(li)4x Copper Coins → 4x Steamed Vegetables$(br)$(li)4x Copper Coins → 4x Green Rice Balls");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.anchor", "Farmer-Experienced");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.title", "Farmer Trading List - Experienced");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.text", "$(br)$(li)4x Lotus Root with Osmanthus → 4x Copper Coins$(br)$(li)4x Copper Coins → 4x Pig Stomach Chicken");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.anchor", "Farmer-Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.title", "Farmer Trading List - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.text", "Expert:$(br)$(li) 4x Copper Coins → 1x Mystery Stew (Night Vision, Blindness, Saturation, Weakness, Jump Boost, Poison - 1-2 effects)$(br2)Master:$(br)$(li)4x Copper Coins → 4x Scrambled Eggs with Tomatoes$(br)$(li)8x Copper Coins → 8x Eggplant with Meat Sauce$(br)$(li)8x Copper Coins → 8x Eight Treasure Porridge");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter", "Hunter");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page1.title", "Hunter");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.anchor", "Hunter - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.title", "Hunter Trading List - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.text", "$(br)$(li)14x Raw Chicken → 4x Copper Coin$(br)$(li)4x Rabbit → 4x Copper Coin$(br)$(li)7x Pork Chop → 4x Copper Coin$(br)$(li)4x Copper Coin → 1x Peacock Egg$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.anchor", "Hunter - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.title", "Hunter Trading List - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.text", "$(br)$(li)7x Mutton → 4x Copper Coin$(br)$(li)4x Copper Coin → 5x Cooked Venison$(br)$(li)4x Copper Coin → 1x Deer Blood$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.anchor", "Hunter - Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.title", "Hunter Trading List - Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.text", "$(br)$(li)7x Venison → 4x Copper Coin$(br)$(li)10x Beef → 4x Copper Coin$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.anchor", "Hunter - Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.title", "Hunter Trading List - Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.text", "Expert:$(br)$(li)7x Deer Antler → 14x Copper Coin$(br2)Master:$(br)$(li)5x Tiger Hide → 15x Copper Coin");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter", "Potter");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page1.title", "Potter");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.anchor", "Potter - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.title", "Potter Trading List - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.text", "$(br)$(li)8x Copper Coin → 32x Sandstone Brick$(br)$(li)8x Copper Coin → 32x Sandstone Brick Slab$(br)$(li)8x Copper Coin → 32x Sandstone Stairs$(br)$(li)8x Copper Coin → 32x Sandstone Wall$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.anchor", "Potter - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.title", "Potter Trading List - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.text", "$(br)$(li)8x Copper Coin → 32x Sandstone Tile$(br)$(li)8x Copper Coin → 32x Dark Sandstone Tile$(br)$(li)8x Copper Coin → 32x Asphalt Tile$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.anchor", "Potter - Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.title", "Potter Trading List - Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.text", "$(br)$(li)4x Copper Coin → 8x Porcelain Bowl$(br)$(li)4x Copper Coin → 8x Porcelain Cup$(br)$(li)4x Copper Coin → 4x Wine Jar$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.anchor", "Potter - Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.title", "Potter Trading List - Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.text", "Expert:$(br)$(li)4x Copper Coin → 1x Blue and White Porcelain Planter$(br2)Master:$(br)$(li)4x Copper Coin → 1x Stone Lion (Yellow)$(br)$(li)4x Copper Coin → 1x Stone Lion (Gray)$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress", "Seamstress");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page1.title", "Seamstress");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.anchor", "Seamstress - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.title", "Seamstress Trading List - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.text", "$(br)$(li)6x Silk Thread → 4x Copper Coin$(br)$(li)22x Cotton → 4x Copper Coin$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.anchor", "Seamstress - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.title", "Seamstress Trading List - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.text", "$(br)$(li)5x Deer Hide → 10x Copper Coin$(br)$(li)4x Copper Coin → 4x Silk$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.anchor", "Seamstress - Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.title", "Seamstress Trading List - Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.text", "$(br)$(li)28x Copper Coin → 1x Male Taoist Robe Bundle$(br)$(li)28x Copper Coin → 1x Female Taoist Robe Bundle$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.anchor", "Seamstress - Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.title", "Seamstress Trading List - Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.text", "Expert:$(br)$(li)6x Silver Ingot → 1x Wedding Dress Bundle$(br)$(li)6x Silver Ingot → 1x Bridal Dress Bundle$(br)$(li)6x Silver Ingot → 1x Traveler's Outfit Bundle$(br)$(li)6x Silver Ingot → 1x Scholar's Outfit Bundle$(br2)Master:$(br)$(li)8x Silver Ingot → 1x Golden Cotton Armor Bundle$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle", "Sandstone Castle");
        this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle.page1.title", "Sandstone Castle");
        this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle.page1.text", "Often spawns in desert biomes. A fortress-style village built with sandstone, well-stocked and resistant to attacks, like a pearl in the desert. Common crops include: cotton, tomatoes, grapes, cantaloupe.");
        this.add(ChangShengJue.MOD_ID +".village.villages.courtyard", "Courtyard");
        this.add(ChangShengJue.MOD_ID +".village.villages.courtyard.page1.title", "Courtyard Village");
        this.add(ChangShengJue.MOD_ID +".village.villages.courtyard.page1.text", "Often spawns in grassland biomes. A courtyard surrounded by buildings on all four sides, hence the name Courtyard. Common crops include: sorghum, corn, wheat, soybeans, millet.");
        this.add(ChangShengJue.MOD_ID +".village.villages.huizhou", "Huizhou Style");
        this.add(ChangShengJue.MOD_ID +".village.villages.huizhou.page1.title", "Huizhou Style Village");
        this.add(ChangShengJue.MOD_ID +".village.villages.huizhou.page1.text", "Often spawns in forest biomes. Huizhou residences are famous for their white walls, dark tiles, and horsehead walls. Look at those exquisite carved doors and windows! Common crops include: lotus root, peanuts, eggplant, pears.");
        this.add(ChangShengJue.MOD_ID +".village.villages.suzhou", "Suzhou Style");
        this.add(ChangShengJue.MOD_ID +".village.villages.suzhou.page1.title", "Suzhou Style Village");
        this.add(ChangShengJue.MOD_ID +".village.villages.suzhou.page1.text", "Often spawns in jungle biomes. The simple and elegant style of white walls and black tiles with high-pitched roofs is an artistic masterpiece of Suzhou architecture. Common crops include: lychee, bananas, durian, rice.");
        this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling", "Cave Dwelling");
        this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling.page1.title", "Cave Dwelling Village");
        this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling.page1.text", "Often spawns in plateau biomes. A special building created by digging into the earth, warm in winter and cool in summer. Common crops include: sugarcane, pepper, mango, pineapple.");

        this.add(ChangShengJue.MOD_ID +".xiake", "Xiake (Rogue/Wandering Knight)");
        this.add(ChangShengJue.MOD_ID +".xiake.desc", "For some time now, things have changed. More and more people claiming to uphold justice have appeared, many of whom prefer to call themselves 'Xiake'.");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment", "Equipment");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page1.title", "Equipment");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page1.text", "In addition to providing armor value and toughness like vanilla equipment, Wuxia equipment can also reduce external damage dealt to you. Equipment can be crafted by yourself or exchanged for currency in the blacksmith shop of the new town. Most armor supports color customization for appearance, feel free to try. $(br)When you first craft or use a chestplate from Changsheng Jue, it will randomly generate external damage reduction and reduced trauma effects.");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.title", "Inner Armor");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.text", "Inner Armor can be worn under Changsheng Jue chestplates to increase their armor value or toughness. $(br)There are two ways to equip inner armor: 1. Wear the inner armor first, then wear the chestplate you want to line it with. 2. Or hold the inner armor in your off-hand and the chestplate in your main hand, then press SHIFT+right-click. $(br)Inner Armor can also be worn independently as regular chestplates. $(br)");
        this.add(ChangShengJue.MOD_ID +".xiake.forge_block", "Forge");
        this.add(ChangShengJue.MOD_ID +".xiake.forge_block.page1.title", "Forge");
        this.add(ChangShengJue.MOD_ID +".xiake.forge_block.page1.text", "Forge crafting recipe");
        this.add(ChangShengJue.MOD_ID +".xiake.forge_block.page2.text", "Used to craft weapons, armor, etc. You can view selected items in the forge, and crafting will automatically deduct the required materials from your inventory.");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury", "Internal Injury");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page1.title", "Internal Injury");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page1.text", "Each level of Internal Injury effect: Increases damage taken by 5%, reduces equipped armor effectiveness by 5%, 5% chance per second to be stunned for 15 seconds; If a target already has this effect, attacking them unarmed again will stack the effect by 1 level and extend duration by 2 seconds; Maximum of 5 levels, with effects doubling per level.");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page2.text", "When using unarmed martial arts, unarmed attacks on targets cause 1 level of Internal Injury, while using unarmed martial arts skills cause 2 levels. $(br)Wearing Gold Silk Gloves in main hand also counts as unarmed attack.");

        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual", "Martial Arts Manual");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page1.title", "Martial Arts Manual");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page1.text", "You can obtain Martial Arts Manuals by completing faction quests or village quests; there's a chance to drop them from NPCs who know martial arts.");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page2.text", "Martial Arts Manuals are divided into External (mainly active skills), Internal (mainly passive skills), Lightness (mainly movement effects), and Mind Cultivation (providing special bonuses). Specific effects can be seen in the manual description. Manuals clearly explain how to learn and perform the skills - right-click to view instructions.");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page3.text", "After learning sword martial arts, there's a 15% chance for sword attacks to cause bleeding (1 damage per 0.5 seconds for 1 second). After learning blade martial arts, there's a 15% chance for blade attacks to trigger critical hits (15% extra damage). After learning staff martial arts, there's a 15% chance for staff attacks to stun (0.5 seconds). After learning spear martial arts, there's a 15% chance for spear attacks to knock up (0.7 seconds).");

        this.add(ChangShengJue.MOD_ID +".xiake.trauma", "Trauma");
        this.add(ChangShengJue.MOD_ID +".xiake.trauma.page1.title", "Trauma");
        this.add(ChangShengJue.MOD_ID +".xiake.trauma.page1.text", "Each level of Trauma effect: Reduces damage dealt by 5%, reduces speed by 5%, loses 1% health per second for 7 seconds; If a target already has this effect, attacking them with corresponding weapons again extends duration by 1 second (if this attack causes higher level trauma, it overwrites previous effect); Maximum of 5 levels, with effects doubling per level.");
        this.add(ChangShengJue.MOD_ID +".xiake.trauma.page2.text", "When using weapon-based martial arts, there's a 25% chance for weapon attacks to cause 1-2 levels of Trauma, while using weapon martial arts skills guarantees 1-5 levels of Trauma.");

        this.add(ChangShengJue.MOD_ID +".xiake.stakes", "Training Stakes");
        this.add(ChangShengJue.MOD_ID +".xiake.stakes.page1.title", "Training Stakes");
        this.add(ChangShengJue.MOD_ID +".xiake.stakes.page1.text", "Training Stakes crafting recipe");
        this.add(ChangShengJue.MOD_ID +".xiake.stakes.page2.text", "Internal, Lightness, and External (unarmed) martial arts can be learned by practicing on training stakes, with a 15% chance per strike to comprehend.");

        this.add(ChangShengJue.MOD_ID +".xiake.tailoring_case", "Tailoring Table");
        this.add(ChangShengJue.MOD_ID +".xiake.tailoring_case.page1.title", "Tailoring Table");
        this.add(ChangShengJue.MOD_ID +".xiake.tailoring_case.page1.text", "Tailoring Table crafting recipe");
        this.add(ChangShengJue.MOD_ID +".xiake.tailoring_case.page2.text", "Used to craft clothing (armor), etc. You can view selected items in the table, and crafting will automatically deduct the required materials from your inventory.");

        this.add(ChangShengJue.MOD_ID +".xiake.quest", "Quests");
        this.add(ChangShengJue.MOD_ID +".xiake.quest.page1.title", "Quests");
        this.add(ChangShengJue.MOD_ID +".xiake.quest.page1.text", "Right-click faction leaders to accept faction quests. Completing them rewards faction tokens, martial arts manuals, currency, and more. During gameplay, you may also automatically trigger other quests (most are auto-accepted and auto-completed when conditions are met), with rewards including martial arts manuals and currency.");

        this.add(ChangShengJue.MOD_ID +".xiake.tea", "Tea");
        this.add(ChangShengJue.MOD_ID +".xiake.tea.page1.title", "Tea");
        this.add(ChangShengJue.MOD_ID +".xiake.tea.page1.text", "Drinking tea allows you to recover health or hunger faster. For detailed effects, check the tea's description.");

        this.add(ChangShengJue.MOD_ID +".xiake.weapon", "Weapons");
        this.add(ChangShengJue.MOD_ID +".xiake.weapon.page1.title", "Weapons");
        this.add(ChangShengJue.MOD_ID +".xiake.weapon.page1.text", "Some external martial arts require weapons as a medium, so having the appropriate weapon is important. You can craft weapons yourself or exchange them for faction tokens in your faction, and completing faction quests unlocks the ability to exchange legendary weapons.");

        this.add(ChangShengJue.MOD_ID +".xiake.wine", "Wine");
        this.add(ChangShengJue.MOD_ID +".xiake.wine.page1.title", "Wine");
        this.add(ChangShengJue.MOD_ID +".xiake.wine.page1.text", "Drinking wine speeds up martial arts cooldowns, reduces hunger consumption for skills, and increases martial arts damage. For detailed effects, check the wine's description. Don't overdo it - drinking too much will make you drunk~");


        this.add(ChangShengJue.MOD_ID +".wufanglu", "WU FANG HUI LU(Everything Record)");
        this.add(ChangShengJue.MOD_ID +".wufanglu.desc", "“天若有情天亦老，人间正道是沧桑。”$(br)The way of longevity, how can it be unknown? Understand the heavens, understand everything.");
        this.add(ChangShengJue.MOD_ID +".wufanglu.desc2", "chang sheng jue everything");
    }
}
