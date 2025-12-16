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

public class CSJENLanguageProvider extends LanguageProvider {
    public CSJENLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        //创造栏
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_building_block", "ChangShengJue Building Block");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_natural_blocks", "ChangShengJue Natural Blocks");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_functional", "ChangShengJue Functional Blocks");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_ingredients", "ChangShengJue Ingredients");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_food_and_drink", "ChangShengJue Foods & Drinks");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_combat", "ChangShengJue Combat");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_tool", "ChangShengJue Tool & Utilities");
        this.add("itemGroup." + ChangShengJue.MOD_ID + "_spawn_eggs", "ChangShengJue Spawn Eggs");
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
        this.add(ChangShengJueItems.STICKYRICE.get(),"Sticky Rice");
        this.add(ChangShengJueItems.STICKYRICE_1.get(),"Sticky Rice");
        this.add(ChangShengJueItems.CORN_SEEDS.get(),"Corn Seeds");
        this.add(ChangShengJueItems.CORN.get(),"Corn");
        this.add(ChangShengJueItems.JALAPENOS_SEEDS.get(),"Jalapenos Seeds");
        this.add(ChangShengJueItems.JALAPENOS.get(),"Jalapenos");
        this.add(ChangShengJueItems.PEANUT_SEEDS.get(),"Peanut Seeds");
        this.add(ChangShengJueItems.PEANUT.get(),"Peanut");
        this.add(ChangShengJueItems.BRINJAL_SEEDS.get(),"Brinjal Seeds");
        this.add(ChangShengJueItems.BRINJAL.get(),"Brinjal");
        this.add(ChangShengJueItems.CANTALOUPE.get(),"Cantaloupe");
        this.add(ChangShengJueItems.CANTALOUPE_SEEDS.get(),"Cantaloupe Seeds");
        this.add(ChangShengJueItems.GRAPE_SEEDS.get(),"Grape Seeds");
        this.add(ChangShengJueItems.GRAPE.get(),"Grape");
        this.add(ChangShengJueItems.RICE_SEEDS.get(),"Paddy Seeds");
        this.add(ChangShengJueItems.RICE.get(),"Paddy");
        this.add(ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get(),"Biluochun Seeds");
        this.add(ChangShengJueItems.BILUOCHUN_TEA.get(),"Biluochun");
        this.add(ChangShengJueItems.LONG_JING_TEA_SEEDS.get(),"Longjing Seeds");
        this.add(ChangShengJueItems.LONG_JING_TEA.get(),"Longjing");
        this.add(ChangShengJueItems.HORDEUM_SEEDS.get(),"Hordeum Seeds");
        this.add(ChangShengJueItems.HORDEUM.get(),"Hordeum");
        this.add(ChangShengJueItems.MULBERRY_JUICE.get(),"Mulberry Juice");
        this.add(ChangShengJueItems.APPLE_JUICE.get(),"Apple Juice");
        this.add(ChangShengJueItems.HOT_PEAR_SOUP.get(),"Hot Pear Soup");
        this.add(ChangShengJueItems.GRAPE_JUICE.get(),"Grape Juice");
        this.add(ChangShengJueItems.CROC.get(),"Raw Crocodile");
        this.add(ChangShengJueItems.COOKED_CROC.get(),"Cooked Crocodile");
        this.add(ChangShengJueItems.PEACOCK.get(),"Raw Peacock");
        this.add(ChangShengJueItems.COOKED_PEACOCK.get(),"Cooked Peacock");
        this.add(ChangShengJueItems.CI_PAN.get(),"Porcelain Plate");
        this.add(ChangShengJueItems.CI_WAN.get(),"Porcelain Bowl");
        this.add(ChangShengJueItems.CI_BEI.get(),"Porcelain Cup");
        this.add(ChangShengJueItems.CAPSULE_JIAO_ZI.get(),"Mustard green dumplings");
        this.add(ChangShengJueItems.ZHENG_CAI.get(),"Steamed Dishes");
        this.add(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(),"Purslane Pancake");
        this.add(ChangShengJueItems.QING_TUAN.get(),"Qingtuan");
        this.add(ChangShengJueItems.BAKED_CORN.get(),"Baked Corn");
        this.add(ChangShengJueItems.TOMATO_EGG.get(),"Tomato and Egg Stir-fry");
        this.add(ChangShengJueItems.GU_LAO_ROU.get(),"Sweet and Sour Pork");
        this.add(ChangShengJueItems.MEAT_FOAM_BRINJAL.get(),"Minced Meat Eggplant");
        this.add(ChangShengJueItems.SORGHUM_CAKE.get(),"Sorghum Pancake");
        this.add(ChangShengJueItems.STINKY_TOFU.get(),"Stinky Tofu");
        this.add(ChangShengJueItems.ZHU_DU_JI.get(),"Pork Belly Chicken Soup");
        this.add(ChangShengJueItems.XIAO_MI_FAN.get(),"Rice ball with millet");
        this.add(ChangShengJueItems.MI_FAN.get(),"Rice Ball");
        this.add(ChangShengJueItems.GUI_HUA_TANG_OU.get(),"Osmanthus Sugar Lotus Root");
        this.add(ChangShengJueItems.BA_BAO_ZHOU.get(),"Eight-Treasure Porridge");
        this.add(ChangShengJueItems.BILUOCHUN_TEAS.get(),"Biluochun Tea");
        this.add(ChangShengJueItems.LONG_JING_TEAS.get(),"Longjing Tea");
        this.add(ChangShengJueItems.SHI_LI_XIANG.get(),"Shilixiang");
        this.add(ChangShengJueItems.FEN_JIU.get(),"Fenjiu");
        this.add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(),"Wheat Nuggets Tribute Wine");
        this.add(ChangShengJueItems.MANGO.get(),"Mango");
        this.add(ChangShengJueItems.MEI_HUA.get(),"Plum blossom");
        this.add(ChangShengJueItems.GUI_HUA.get(),"Osmanthus fragrans");
        this.add(ChangShengJueItems.BANANA.get(),"Banana");
        this.add(ChangShengJueItems.PEAR.get(),"Pear");
        this.add(ChangShengJueItems.LICHEE.get(),"Lychee");
        this.add(ChangShengJueItems.DURIAN.get(),"Durian");
        this.add(ChangShengJueItems.DURIAN_MEAT.get(),"Durian flesh");
        this.add(ChangShengJueItems.MULBERRY.get(),"Mulberry");
        this.add(ChangShengJueItems.NATURAL_SILK.get(),"Mulberry Silk");
        this.add(ChangShengJueItems.SILKWORM.get(),"Silkworm");
        this.add(ChangShengJueItems.SILK.get(),"Silk");
        this.add(ChangShengJueItems.CAPSULE.get(),"Mustard greens");
        this.add(ChangShengJueItems.QUICKLIME.get(),"Quicklime");
        this.add(ChangShengJueItems.LIME_SLURRY_BARRELS.get(),"Lime slurry bucket");
        this.add(ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get(),"Bucket of warm lime wash");
        this.add(ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get(),"Bucket of cool lime wash");

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
        this.add(ChangShengJueItems.CYAN_BRICKS.get(), "Cyan Bricks");
        this.add(ChangShengJueItems.WHITE_BRICKS_ITEM.get(), "White Bricks");
        this.add(ChangShengJueItems.GOLD_BRICKS.get(), "Golden Brick");

        this.add(ChangShengJueItems.SYDEROLIFE_BALL.get(), "Syderolife Ball");
        this.add(ChangShengJueItems.KAOLIN_BALL.get(), "Kaolin Ball");
        this.add(ChangShengJueItems.NATURAL_ASPHALT.get(), "Natural Asphalt");

        this.add(ChangShengJueItems.TONG_QIAN.get(), "Ancient Coin");
        this.add(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), "A String of Ancient Coin");
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
        this.add(ChangShengJueItems.EXTERNAL_KUNG_FU_XP.get(), "External KunFu Xp+5");
        this.add(ChangShengJueItems.INTERNAL_KUNG_FU_XP.get(), "Internal KungFu Xp+5");

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
        this.add(ChangShengJueItems.PEACOCK_EGG.get(), "Peacock Spawn Egg");
        this.add(ChangShengJueItems.PEACOCK_EGG_1.get(), "Peahen Spawn Egg");
        this.add(ChangShengJueItems.STAG_EGG.get(), "Stag Spawn Egg");
        this.add(ChangShengJueItems.HIND_EGG.get(), "Hind Spawn Egg");
        this.add(ChangShengJueItems.TIGER_EGG.get(), "Tiger Spawn Egg");
        this.add(ChangShengJueItems.CROC_EGG.get(), "Crocodile Spawn Egg");
        this.add(ChangShengJueItems.CHANG_SHENG_JUE_VILLAGER_EGG.get(), "Villager Spawn Egg");
        this.add(ChangShengJueItems.WARRIOR_EGG.get(), "Warrior Spawn Egg");
        this.add(ChangShengJueItems.KILN_WORKER_EGG.get(), "Kiln Worker Spawn Egg");
        this.add(ChangShengJueItems.MALE_INNKEEPER_EGG.get(), "Tavern Keeper Spawn Egg");
        this.add(ChangShengJueItems.FEMALE_INNKEEPER_EGG.get(), "Female Tavern Keeper Spawn Egg");
        this.add(ChangShengJueItems.CHALLENGER_EGG.get(), "Challenger Spawn Egg");
        this.add(ChangShengJueItems.BLACKSMITH_EGG.get(), "Blacksmith Spawn Egg");
        this.add(ChangShengJueItems.LANCE_GANG_LEADER_EGG.get(), "Lance Leader Spawn Egg");
        this.add(ChangShengJueItems.KNIFE_GANG_LEADER_EGG.get(), "Knife Leader Spawn Egg");
        this.add(ChangShengJueItems.SWORD_GANG_LEADER_EGG.get(), "Sword Leader Spawn Egg");
        this.add(ChangShengJueItems.CLUBBED_GANG_LEADER_EGG.get(), "Clubbed Leader Spawn Egg");
        this.add(ChangShengJueItems.GANG_LEADER_EGG.get(), "Fist Leader Spawn Egg");
        this.add(ChangShengJueItems.BANDIT_EGG.get(), "Bandit Spawn Egg");
        this.add(ChangShengJueItems.VILLAIN_EGG.get(), "Villain Spawn Egg");
        this.add(ChangShengJueItems.ASSASSIN_EGG.get(), "Assassin Spawn Egg");
        this.add(ChangShengJueItems.CLUBBED_MING_XIA_EGG.get(), "Stick king Spawn Egg");
        this.add(ChangShengJueItems.SWORD_MING_XIA_EGG.get(), "Sword Immortal Spawn Egg");
        this.add(ChangShengJueItems.KNIFE_MING_XIA_EGG.get(), "Blade Sage Spawn Egg");
        this.add(ChangShengJueItems.FIST_MING_XIA_EGG.get(), "Northern Fist Spawn Egg");
        this.add(ChangShengJueItems.PIGLIN_WU_XIA_EGG.get(), "Kungfu Piglin Spawn Egg");
        this.add(ChangShengJueItems.WITCH_WU_XIA_EGG.get(), "Kungfu Witch Spawn Egg");
        this.add(ChangShengJueItems.EVOKER_WU_XIA_EGG.get(), "Kungfu Evoker Spawn Egg");
        this.add(ChangShengJueItems.VINDICATOR_WU_XIA_EGG.get(), "Kungfu Vindicator Spawn Egg");
        this.add(ChangShengJueItems.PILLAGER_WU_XIA_EGG.get(), "Kungfu Pillager Spawn Egg");
        //工具武器和盔甲物品
        this.add(ChangShengJueItems.KAISHAN_PICKAXE.get(),"Kaishan Pickaxe");
        this.add(ChangShengJueItems.XUANHUA_AXE.get(),"Xuanhua Axe");
        this.add(ChangShengJueItems.BRONZE_SWORD.get(),"Bronze Sword");
        this.add(ChangShengJueItems.LONG_YUAN_SWORD.get(),"Long Yuan Sword");
        this.add(ChangShengJueItems.HAN_JIAN.get(),"Han Sword");
        this.add(ChangShengJueItems.HENG_DAO.get(),"Hengdao");
        this.add(ChangShengJueItems.LARGE_KNIFE.get(),"Large Knife");
        this.add(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),"Red-Tasseled Spear");
        this.add(ChangShengJueItems.SOFT_SWORD.get(),"Soft Sword");
        this.add(ChangShengJueItems.PAN_HUA_GUN.get(),"Panhua Gun");
        this.add(ChangShengJueItems.KITCHEN_KNIFE.get(),"Kitchen Knife");
        this.add(ChangShengJueItems.THROWING_KNIVES.get(),"Throwing Knives");
        this.add(ChangShengJueItems.FLYING_DAGGER_POUCH.get(),"Throwing Knives Pouch");
        this.add(ChangShengJueItems.BEAT_DOG_STICK.get(),"Beat Dog Stick");
        this.add(ChangShengJueItems.YI_TIAN_JIAN.get(),"Yi Tian Sword");
        this.add(ChangShengJueItems.TU_LONG_DAO.get(),"The Dragon Slaying Blade");
        this.add(ChangShengJueItems.BA_WANG_QIANG.get(),"Ba Wang Spear");
        this.add(ChangShengJueItems.GOLD_THREAD_GLOVE.get(),"Gold Thread Glove");
        this.add(ChangShengJueItems.COTTON_HELMET.get(),"Cotton Helmet");
        this.add(ChangShengJueItems.WHITE_COTTON_HELMET.get(),"White Feather Cotton Helmet");
        this.add(ChangShengJueItems.COTTON_CHESTPLATE.get(),"Cotton Chestplate");
        this.add(ChangShengJueItems.COTTON_LEGGINGS.get(),"Cotton Leggings");
        this.add(ChangShengJueItems.COTTON_BOOTS.get(),"Cotton Boots");
        this.add(ChangShengJueItems.FEMALE_TAOIST_HELMET.get(),"Taoist Crown");
        this.add(ChangShengJueItems.FEMALE_TAOIST_CHESTPLATE.get(),"Taoist Robe");
        this.add(ChangShengJueItems.MALE_TAOIST_HELMET.get(),"Square Scarf");
        this.add(ChangShengJueItems.MALE_TAOIST_CHESTPLATE.get(),"Taoist Robe");
        this.add(ChangShengJueItems.TAOIST_BOOTS.get(),"Silk Shoes");
        this.add(ChangShengJueItems.TAOIST_LEGGINGS.get(),"Silk Leggings");
        this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP.get(),"Silky Gauze Cap");
        this.add(ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU.get(),"Kylin Embroidered Robe");
        this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET.get(),"Phoenix Coronet");
        this.add(ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING.get(),"Imperial Robe");
        this.add(ChangShengJueItems.CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES.get(),"Golden silk shoes");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_HELMET_GUN_HOOD.get(),"Mountain Pattern Helmet");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_ARMOR.get(),"Mountain Pattern Chestplate");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR.get(),"Deerskin Tibial Armor");
        this.add(ChangShengJueItems.MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS.get(),"Cloud head black leather boots");
        this.add(ChangShengJueItems.FLY_FISH_IRON_HAT.get(), "Iron Hat");
        this.add(ChangShengJueItems.FLY_FISH_CLOUD_VEIL_CROWN.get(), "Cloud gauze crown");
        this.add(ChangShengJueItems.FLY_FISH_CHESTPLATE.get(), "Flying fish wear");
        this.add(ChangShengJueItems.FLY_FISH_LONG_BOOTS.get(), "Long Boots");
        this.add(ChangShengJueItems.WALKER_GOLD_RING_BAND.get(), "Gold Hoop");
        this.add(ChangShengJueItems.WALKER_GREEN_TREASURE_PENDANT.get(),"Green Gem Forehead Pendant");
        this.add(ChangShengJueItems.WALKER_CHESTPLATE.get(), "Xingzhe Zhuang");
        this.add(ChangShengJueItems.WALKER_TIGER_SKIN_SKIRT.get(), "Tiger skin skirt");
        this.add(ChangShengJueItems.WALKER_SHORT_BOOTS.get(), "Short Boots");
        this.add(ChangShengJueItems.PHOENIX_FEATHER_CAP.get(),"Feng Chi Zi Jin Guan");
        this.add(ChangShengJueItems.OLDEN_CHAIN_MAIL_SHIRT.get(),"Suo Zi Huang Jin Jia");
        this.add(ChangShengJueItems.TIGER_SKIN_GARMENT.get(),"Tiger Skin Lower Garment");
        this.add(ChangShengJueItems.CLOUD_WALKING_BOOTS.get(),"Ou Si Bu Yun Lv");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET.get(), "Phoenix Winged Helmet");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE.get(), "Bright Light Armor");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS.get(), "Lapis Knee Pads");
        this.add(ChangShengJueItems.THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS.get(), "Animal Skin Boots");
        this.add(ChangShengJueItems.CONFUCIAN_HELMET.get(), "Confucian Cap");
        this.add(ChangShengJueItems.CONFUCIAN_INK_CHESTPLATE.get(), "Scholar's Robe");
        this.add(ChangShengJueItems.CONFUCIAN_INK_LEGGINGS.get(), "Silk Trousers");
        this.add(ChangShengJueItems.CONFUCIAN_INK_BOOTS.get(), "Light Silk Shoes");

        this.add(ChangShengJueItems.CONSTABLE_UNIFORM_HELMET.get(), "Constable Uniform Helmet");
        this.add(ChangShengJueItems.CONSTABLE_UNIFORM_CHESTPLATE.get(), "Constable Uniform Chestplate");
        this.add(ChangShengJueItems.CONSTABLE_UNIFORM_LEGGINGS.get(), "Constable Uniform Leggings");
        this.add(ChangShengJueItems.CONSTABLE_UNIFORM_BOOTS.get(), "Constable Uniform Boots");

        this.add(ChangShengJueItems.HATS_WITH_VEIL_HELMET.get(), "Bamboo Hat with Veil");
        this.add(ChangShengJueItems.HATS_WITH_VEIL_CHESTPLATE.get(), "Plain and elegant long skirt");

        this.add(ChangShengJueItems.HATS_BLACK_ROBE_HELMET.get(), "Bamboo Hat");
        this.add(ChangShengJueItems.HATS_BLACK_ROBE_CHESTPLATE.get(), "Xuanyi");
        this.add(ChangShengJueItems.HATS_BLACK_ROBE_LEGGINGS.get(), "Xuanyi Leggings");

        this.add(ChangShengJueItems.DUAN_DA_CHESTPLATE.get(), "Duan Da Chestplate");
        this.add(ChangShengJueItems.BUDDHIST_ROBE_CHESTPLATE.get(), "Rosary monk's robe");
        this.add(ChangShengJueItems.NIGHT_SUIT_HELMET.get(), "Masked Headscarf");
        this.add(ChangShengJueItems.NIGHT_SUIT_CHESTPLATE.get(), "Night-running suit");
        this.add(ChangShengJueItems.LONG_GOWN_CHESTPLATE.get(), "Narrow Sleeved Long Shirt");
        this.add(ChangShengJueItems.NIGHT_SUIT_LEGGINGS.get(), "Silk Leggings");

        this.add(ChangShengJueItems.FOREHEAD_BAND_HELMET1.get(), "额带");
        this.add(ChangShengJueItems.FOREHEAD_BAND_HELMET2.get(), "额带");
        this.add(ChangShengJueItems.HAIR_CROWN_HELMET1.get(), "束发冠");
        this.add(ChangShengJueItems.HAIR_CROWN_HELMET2.get(), "束发冠");

        this.add(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get(), "Gold Silk Soft Armor");
        this.add(ChangShengJueItems.LEATHER_INNER_ARMOR.get(), "Leather Inner Armor");

        this.add(ChangShengJueItems.ARMOR_PARCEL.get(), "Armor Parcel");

        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "cotton_armor", "Cotton armor Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mountain_pattern", "Mountain pattern Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "mingguang_armor", "General Mingguang armor Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "qi_tian_da_sheng", "Da Sheng Jia Zhou Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_taoist", "Taoist Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_taoist", "Taoist robe Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "male_wedding_dress", "Kirin supplementary clothing Parcel");
        this.add("item."+ ChangShengJue.MOD_ID +".armor_parcel." + "female_wedding_dress", "Huiyi Parcel");

        //武功秘籍物品
        this.add(ChangShengJueItems.IMMORTAL_MIRACLE.get(),"Immortal Miracle");
        this.add(ChangShengJueItems.HERCULES.get(),"Hercules' Might Method");
        this.add(ChangShengJueItems.DUGU_NINE_SWORDS.get(),"Dugu Nine Swords");
        this.add(ChangShengJueItems.GAO_MARKSMANSHIP.get(),"Gaojia Marksmanship");
        this.add(ChangShengJueItems.GE_SHAN_DA_NIU.get(),"Striking from a Distance");
        this.add(ChangShengJueItems.TURTLE_BREATH_WORK.get(),"Turtle Breathing Technique");
        this.add(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get(),"Golden Black Knife Method");
        this.add(ChangShengJueItems.GOLDEN_BELL_JAR.get(),"Golden Bell Jar");
        this.add(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get(),"Kui Hua Dian Xue Shou");
        this.add(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get(),"Wheat Nugget Encyclopedia");
        this.add(ChangShengJueItems.PAODING.get(),"Paoding Jie Niu");
        this.add(ChangShengJueItems.SHAOLIN_STICK_METHOD.get(),"Shaolin Stick Method");
        this.add(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get(),"Tread The Snow Without Trace");
        this.add(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get(),"Relentless Throwing Knives");
        this.add(ChangShengJueItems.WU_GANG_CUT_GUI.get(),"Wu Gang cuts the laurel");
        this.add(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get(),"Xuannu Swordsmanship");
        this.add(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get(),"Yugong Moves Mountains");
        this.add(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(),"Zhangmen Xinxue");
        this.add(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get(),"Easy tendon meridian");
        this.add(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get(),"Qiankundanuoyi");

        //武功描述
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".tooltip","The ultimate pinnacle of sword arts, encompassing the secrets of all things.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DUGU_NINE_SWORDS.get()+".hold_shift.tooltip",
                "Before Mastery: External technique deals (Main Hand Weapon Damage + 1) * 1.8 damage." +
                        "\\nAfter Mastery: Damage multiplier increased to 2.2x. When using a sword, Bleed chance is increased by 25%." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".tooltip","Using skill to borrow strength, using softness to overcome hardness.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.XUANNU_SWORDSMANSHIP.get()+".hold_shift.tooltip",
                "Before Mastery: External technique deals (Main Hand Weapon Damage + 1) * 2.2 damage." +
                        "\\nAfter Mastery: Damage multiplier increased to 2.5x. When using a soft sword, Bleed chance is tripled (x3.0)." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".tooltip","A flash of cold steel arrives first, followed by the spear striking like a dragon.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GAO_MARKSMANSHIP.get()+".hold_shift.tooltip",
                "Before Mastery: External technique deals (Main Hand Weapon Damage + 1) * 1.8 damage." +
                        "\\nAfter Mastery: Damage multiplier increased to 2.1x. When using a spear, Knockback chance is increased by 150% (x2.5)." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".tooltip","The throwing knives are ruthless, but the person wielding them holds sentiment.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get()+".hold_shift.tooltip",
                "Before Mastery: Throwing knife damage increased to 1.25x and can throw 3 knives at once." +
                        "\\nAfter Mastery: Throwing knife damage increased to 1.5x and can throw 7 knives at once." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".tooltip","All martial arts originate from Shaolin; a stick staff can settle the world.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SHAOLIN_STICK_METHOD.get()+".hold_shift.tooltip",
                "Before Mastery: External technique deals (Main Hand Weapon Damage + 1) * 1.7 damage." +
                        "\\nAfter Mastery: Damage multiplier increased to 2.0x. When using a stick, Stun chance is increased by 150% (x2.5)." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".tooltip","No matter how you change, I will break through with a single slash!");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get()+".hold_shift.tooltip",
                "Before Mastery: External technique deals (Main Hand Weapon Damage + 1) * 1.9 damage." +
                        "\\nAfter Mastery: Damage multiplier increased to 2.0x. When using a knife, Critical Hit chance is doubled (x2.0)." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".tooltip","Come and go without a shadow, free and unconstrained.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get()+".hold_shift.tooltip",
                "Before Mastery: Allows a double jump.\\nAfter Mastery: Allows a triple jump.\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".tooltip","Why focus on killing techniques? Better to please the heart.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WU_GANG_CUT_GUI.get()+".hold_shift.tooltip",
                "Before Mastery: Using a Xuanhua Axe to chop a tree destroys the entire tree." +
                        "\\nAfter Mastery: Chopping down entire trees is significantly faster." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".tooltip","Endless and unceasing, until the mountains are flat.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get()+".hold_shift.tooltip",
                "Before Mastery: Using a Mountain-Pickaxe increases mining area to 2x2." +
                        "\\nAfter Mastery: Mining area increased to 3x3." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".tooltip","With repeated practice, one masters the principle; thus, it becomes effortless and natural.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.PAODING.get()+".hold_shift.tooltip",
                "Before Mastery: 50%% chance to drop extra meat when killing animals with a Cleaver in the main hand." +
                        "\\nAfter Mastery: 75%% chance to drop extra meat." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".tooltip","Channeling strength with inner energy, possessing boundless power.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.HERCULES.get()+".hold_shift.tooltip",
                "Before Mastery: Reduces hunger consumption from sprinting to 60%%." +
                        "\\nAfter Mastery: Right-clicking with Golden Thread Gloves in the main hand opens an Ender Chest." +
                        "\\nMastery: Achieved after moving a total of %s meters.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".tooltip","Fingers like a swift wind, momentum like lightning.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()+".hold_shift.tooltip",
                "Before Mastery: Immobilizes targets with less than 25 max health for 1.5 seconds." +
                        "\\nAfter Mastery: Immobilizes targets with less than 200 max health for 2 seconds." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".tooltip","Impervious to swords and spears, like a solid golden bell.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GOLDEN_BELL_JAR.get()+".hold_shift.tooltip",
                "Before Mastery: Increases armor by 4. Upon taking damage, grants Absorption III." +
                        "\\nAfter Mastery: Increases armor by 8. Absorption effect is upgraded to V upon taking damage." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".tooltip","The world of Jianghu isn't about killing; it's about human relationships and worldly wisdom!");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.ZHANG_MEN_XIN_XUE.get()+".hold_shift.tooltip",
                "Before Mastery: A single trade with a Villager promotes them to Apprentice level." +
                        "\\nAfter Mastery: Additionally, 10%% chance not to consume the traded item." +
                        "\\nMastery: Achieved after trading with villagers %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".tooltip","Deathless and undying, how can it be but an illusion?");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.IMMORTAL_MIRACLE.get()+".hold_shift.tooltip",
                "Before Mastery: Negates fatal damage once when near death." +
                        "\\nAfter Mastery: Cooldown reduced by 15 seconds." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".tooltip","Divine skill unparalleled under heaven, why bully the ox?");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.GE_SHAN_DA_NIU.get()+".hold_shift.tooltip",
                "Before Mastery: External technique ignores blocks, dealing 22 damage." +
                        "\\nAfter Mastery: Attack range increased by 2 blocks." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".tooltip","Learning comes from diligence; reading ten thousand books by the light of the firefly.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get()+".hold_shift.tooltip",
                "Before Mastery: 25%% chance per trade to gain 5 experience." +
                        "\\nAfter Mastery: 35% chance per trade to gain 10 experience." +
                        "\\nMastery: Achieved upon reaching experience level 30.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".tooltip","Although the turtle has a nose, it breathes through its ears.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.TURTLE_BREATH_WORK.get()+".hold_shift.tooltip",
                "Before Mastery: After activation, allows holding breath underwater longer for a duration, and prevents animals from attacking proactively." +
                        "\\nAfter Mastery: Breath-holding effect is improved." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".tooltip","A martial arts manual dreamt of by all in the martial world.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get()+".hold_shift.tooltip",
                "Before Mastery: Reduces hunger cost of unleashing techniques by 1." +
                        "\\nAfter Mastery: Reduces both hunger and saturation cost of unleashing techniques by 1." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".tooltip","Stimulates potential, pulls and shifts energy. Its variations are unpredictable and unimaginable.");
        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get()+".hold_shift.tooltip",
                "Before Mastery: 35%% chance to reflect damage taken back to the attacker at 1.5x after 1.0 second." +
                        "\\nAfter Mastery: For each additional health point, increases trigger chance by 2%%." +
                        "\\nCooldown increases by 2 seconds for a short time after each use." +
                        "\\nMastery: Achieved after successfully unleashing %s times.");

        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu", "Comprehended %s! Hold right-click with %s for %s seconds to charge and unleash the technique!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.external_kunfu_glove", "Comprehended %s! Hold right-click with %s for %s seconds to charge and unleash the technique!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.comprehend.internal_kungfu", "Comprehended %s!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.studied.kungfu", "Has already studied %s. %s!");

        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu", "%s studied! Now attack targets with %s to gain practical comprehension!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.external_kunfu_glove", "%s studied! Now attack on practice stakes with bare hands or %s to gain comprehension!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.internal_kungfu", "%s studied! Now attack on practice stakes with %s to gain comprehension!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.light_kungfu", "%s studied! Now %s to gain comprehension!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.learning.mental_kungfu", "%s studied! Now %s to gain comprehension!");
        this.add("message.kungfu." + ChangShengJue.MOD_ID + ".succeed.dacheng.kungfu", "Mastered the divine art of %s!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".swords.type", "sword");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".softsword.type", "soft sword");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".clubbed.type", "clubbed");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".glove.type", "glove");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".knife.type", "knife");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".lance.type", "spear");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".throwingknives.type", "throwing knives");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".hand_and_glove.type", "bare hands or gloves");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".run_and_jump.type", "running or jumping");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.type", "interacting with creatures");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.true.comprehend", "and mastered! Hold right with %s for %s seconds to charge and unleash the technique!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu.fales.comprehend", "Still need to attack targets with %s to gain practical comprehension!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.true.comprehend", "and mastered!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu.fales.comprehend", "Still need to attack on practice stakes with %s to gain comprehension!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".light_kungfu.fales.comprehend", "Still need %s to gain comprehension!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".mental_kungfu.fales.comprehend", "Still need %s to gain comprehension!");

        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".state_change.kungfu", "%s : %s");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.open", "Activated! Attack on Practice stakes with bare hands or %s to gain comprehension!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.open", "Activated! Attack on Practice stakes with bare hands to gain comprehension!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.comprehend.open", "Activated! Hold right-click with %s for %s seconds to charge and unleash the technique!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".internal_kungfu_glove.comprehend.open", "Activated! After mastery, use %s to unleash the technique!");
        this.add("message.kungfu."+ ChangShengJue.MOD_ID +".external_kunfu_glove.off", "Deactivated");

        this.add("message." + ChangShengJue.MOD_ID + ".dagger_pouch.empty", "§cNo weapons left");

        this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.count","Throwing Knives Pouch Capacity %s / %s");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".flying_dagger_pouch.right_click.tooltip","Pick up and right-click a throwing knives Pouch in inventory to store throwing daggers");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".throwing_knives.right_click.tooltip","Pick up and right-click throwing knives in inventory to store them in the pouch");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".durability","Durability %s / %s");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".dagger_pouch.contents","Contents of Throwing Knives Pouch");


        this.add("tooltip."+ChangShengJue.MOD_ID+"." + ChangShengJueItems.DURIAN.get()+".tooltip","Please use an axe to split it open");
        this.add("tooltip."+ChangShengJue.MOD_ID+".hold_shift.tooltip","Press §eShift§r to view more information");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data","Lined");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining","This armor cannot be lined");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.lining1","Please use a chestplate for lining");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".inner_armor_data.no.unload","Unloaded from equipment");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".dyeing","Can be dyed");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".damage_reduction","External damage reduction: +%s%%");
        this.add("tooltip."+ ChangShengJue.MOD_ID + ".trauma","Chance of sustaining external injuries: -%s%%");

        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "pit_yard.tooltip", "Underground Cave Dwelling");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "sandstone_castle.tooltip","Sandstone Fort");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "si_he_yuan.tooltip","Courtyard House (Siheyuan)");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "su_pai_village.tooltip","Su-style Village");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "hui_pai_village.tooltip","Hui-style Village");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "fortresses_type.tooltip","Ancient City");
        this.add("tooltip." + ChangShengJue.MOD_ID + "." + "null.structure.tooltip","Unknown Structure");
        this.add("tooltip." + ChangShengJue.MOD_ID + ".structural_location","At [x=%d | z=%d] there stands a %s, go check it out");

        //声音
        this.add("sounds."+ChangShengJue.MOD_ID + ".ge_shan_da_niu_sound","Kungfu Ge Shan Da Niu");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dugu_nine_swords_sound","Kungfu Dugu Nine Swords");
        this.add("sounds."+ChangShengJue.MOD_ID + ".immortal_miracle_sound","Kungfu Immortal Miracle");
        this.add("sounds."+ChangShengJue.MOD_ID + ".gao_marksmanship_sound","Kungfu Gaojia Marksmanship");
        this.add("sounds."+ChangShengJue.MOD_ID + ".turtle_breath_work_sound","Kungfu Turtle Breath Work");
        this.add("sounds."+ChangShengJue.MOD_ID + ".golden_black_knife_method_sound","Kungfu Golden Black Knife Method");
        this.add("sounds."+ChangShengJue.MOD_ID + ".sunflower_point_caveman_sound","Kungfu Kui Hua Dian Xue Shou");
        this.add("sounds."+ChangShengJue.MOD_ID + ".shaolin_stick_method_sound","Kungfu Shaolin Stick Method");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tread_the_snow_without_trace_sound","Kungfu Tread Snow Without Trace");
        this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_sound","Throwing Knives Flying Out");
        this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit","Throwing Knives Hit");
        this.add("sounds."+ChangShengJue.MOD_ID + ".throwing_knives_hit_ground","Throwing Knives: Hit Ground");
        this.add("sounds."+ChangShengJue.MOD_ID + ".wu_gang_cut_gui_sound","Kungfu Wu Gang cuts the laurel");
        this.add("sounds."+ChangShengJue.MOD_ID + ".xuannu_swordsmanship_sound","Kungfu Xuannu Swordsmanship");
        this.add("sounds."+ChangShengJue.MOD_ID + ".golden_belljar_sound","Kungfu Golden Bell Jar");
        this.add("sounds."+ChangShengJue.MOD_ID + ".qian_kun_da_nuo_yi_sound","Kungfu Qiankundanuoyi");
        this.add("sounds."+ChangShengJue.MOD_ID + ".comprehend_sound","Kungfu Breakthrough");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dacheng_sound","Kungfu Mastery");

        this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_sound", "Cicada chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".cicada_hurt", "Cicada hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".crane_sound", "Crane chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".crane_hurt", "Crane hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".crane_death", "Crane dies");
        this.add("sounds."+ChangShengJue.MOD_ID + ".croc_sound", "Croc roaring");
        this.add("sounds."+ChangShengJue.MOD_ID + ".croc_hurt", "Croco hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".croc_death", "Croc dies");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_hurt", "Dragonfly hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".dragonfly_death", "Dragonfly dies");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_sound" , "Monkey howling");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_baby_sound" , "Monkey howling");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_angry_sound" , "Monkey angry");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_hurt" , "Monkey hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_death" , "Monkey dies");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_1" , "Monkey bless");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_2" , "Monkey somersaulting");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_3" , "Monkey saluting");
        this.add("sounds."+ChangShengJue.MOD_ID + ".monkey_play_4" , "Monkey *(^%&*^#$?");

        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound" , "Tiger roaring");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_sound_1" , "Tiger roaring");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_hurt" , "Tiger hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".tiger_death" , "Tiger dies");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound" , "Deer chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_1" , "Deer chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_2" , "Deer chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_3" , "Deer chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_4" , "Deer chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_sound_5" , "Deer chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_hurt" , "Deer hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".deer_death" , "Deer dies");
        this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_sound" , "Peacock chirping");
        this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_hurt" , "Peacock hurts");
        this.add("sounds."+ChangShengJue.MOD_ID + ".peacock_death" , "Peacock dies");

        this.add("sounds."+ChangShengJue.MOD_ID + ".wind_chime_sound", "Wind Chime jingle bell");

        this.add("sounds."+ChangShengJue.MOD_ID + ".gong_sound", "Gong clang~");

        this.add("sounds."+ChangShengJue.MOD_ID + ".tailoring_case_sound", "Tailoring Table cutting");

        this.add("sounds."+ChangShengJue.MOD_ID + ".forge_block_sound", "Forge Hammer clanging");

        this.add("sounds."+ChangShengJue.MOD_ID + ".stakes_hit_sound", "Practice stake being struck");

        //方块
        this.add(ChangShengJueItems.STAKES.get(),"Practice stake");
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
        this.add(ChangShengJueBlocks.BANANA_FRUIT.get(),"Banana Bunch");

        this.add(ChangShengJueBlocks.PEAR_LOG.get(),"Pear Log");
        this.add(ChangShengJueBlocks.PEAR_WOOD.get(),"Pear Wood");
        this.add(ChangShengJueBlocks.STRIPPED_PEAR_LOG.get(),"Stripped Pear Log");
        this.add(ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get(),"Stripped Pear Wood");
        this.add(ChangShengJueBlocks.PEAR_PLANKS.get(),"Pear Planks");
        this.add(ChangShengJueBlocks.PEAR_LEAVES.get(),"Pear Leaves");
        this.add(ChangShengJueBlocks.PEAR_SAPLING.get(),"Pear Sapling");

        this.add(ChangShengJueBlocks.LICHEE_LOG.get(),"Lichee Log");
        this.add(ChangShengJueBlocks.LICHEE_WOOD.get(),"Lichee Wood");
        this.add(ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get(),"Stripped Lichee Log");
        this.add(ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get(),"Stripped Lichee Wood");
        this.add(ChangShengJueBlocks.LICHEE_PLANKS.get(),"Lichee Planks");
        this.add(ChangShengJueBlocks.LICHEE_LEAVES.get(),"Lichee Leaves");
        this.add(ChangShengJueBlocks.LICHEE_SAPLING.get(),"Lichee Sapling");

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

        this.add(ChangShengJueBlocks.PLUM_LOG.get(),"Plum Blossom Log");
        this.add(ChangShengJueBlocks.PLUM_WOOD.get(),"Plum Blossom Wood");
        this.add(ChangShengJueBlocks.STRIPPED_PLUM_LOG.get(),"Stripped Plum Blossom Log");
        this.add(ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get(),"Stripped Plum Blossom Wood");
        this.add(ChangShengJueBlocks.PLUM_PLANKS.get(),"Plum Blossom Planks");
        this.add(ChangShengJueBlocks.PLUM_LEAVES.get(),"Plum Blossom Leaves");
        this.add(ChangShengJueBlocks.PLUM_SAPLING.get(),"Plum Blossom Sapling");
        this.add(ChangShengJueBlocks.PLUM_DEFOLIATION.get(),"Plum Blossom Defoliation");

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
        this.add(ChangShengJueBlocks.POTTED_MUGWORT_BLOCK.get(),"Potted Mugwort");

        this.add(ChangShengJueBlocks.CAPSULE_BLOCK.get(),"Mustard greens");

        this.add(ChangShengJueBlocks.CUCKOO_BLOCK.get(),"Azalea");
        this.add(ChangShengJueBlocks.POTTED_CUCKOO_BLOCK.get(),"Potted Azalea");

        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get(),"Portulaca Oleracea");
        this.add(ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK.get(),"Potted Portulaca Oleracea");

        this.add(ChangShengJueBlocks.JASMINE_BLOCK.get(),"Jasmine");
        this.add(ChangShengJueBlocks.POTTED_JASMINE_BLOCK.get(),"Potted Jasmine");

        this.add(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get(),"Kochia Scoparia");
        this.add(ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK.get(),"Potted Kochia Scoparia");

        this.add(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get(),"Narcissus");
        this.add(ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK.get(),"Potted Narcissus");

        this.add(ChangShengJueBlocks.TAN_HUA_BLOCK.get(),"Epiphyllum");
        this.add(ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK.get(),"Potted Epiphyllum");

        this.add(ChangShengJueBlocks.STIPA_GRANDIS.get(),"Stipa Grandis");
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS.get(),"Stipa Grandis");
        this.add(ChangShengJueBlocks.TALL_STIPA_GRANDIS_VARIANT.get(),"Tall Variant Stipa Grandis");

        this.add(ChangShengJueBlocks.SOLIDAGO.get(),"Solidago");
        this.add(ChangShengJueBlocks.POTTED_SOLIDAGO.get(),"Potted Solidago");

        this.add(ChangShengJueBlocks.GEUM_TRIFLORUM.get(),"Geum Aleppicum");
        this.add(ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM.get(),"Potted Geum Aleppicum");

        this.add(ChangShengJueBlocks.PURPLE_DANDELION.get(),"Purple Dandelion");
        this.add(ChangShengJueBlocks.POTTED_PURPLE_DANDELION.get(),"Potted Purple Dandelion");

        this.add(ChangShengJueBlocks.RED_KNOTWEED.get(),"Prince's-feather");
        this.add(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get(),"Variant Prince's-feather");

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
        this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),"Cyan Stone Bricks");
        this.add(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),"Cyan Stone Fine Bricks");

        this.add(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get(),"White Bricks Stairs");
        this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get(),"Black Stone Bricks Stairs");
        this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(),"Cyan Stone Bricks Stairs");

        this.add(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get(),"White Bricks Slab");
        this.add(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get(),"Black Stone Slab");
        this.add(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(),"Cyan Stone Slab");

        this.add(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get(),"White Bricks Vertical Walls");
        this.add(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get(),"Black Stone Vertical Walls");
        this.add(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(),"Cyan Stone Vertical Walls");

        //效果
        this.add(ChangShengJueItems.TRAUMA_EFFECT.get(), "External Injury");
        this.add(ChangShengJueItems.INTERNAL_INJURY_EFFECT.get(), "Internal Injury");

        this.add(ChangShengJueBlocks.MANGROVE_OVERLORD_FIST.get(),"Mangrove Bawangquan");
        this.add(ChangShengJueBlocks.BIRCH_OVERLORD_FIST.get(),"Birch Bawangquan");
        this.add(ChangShengJueBlocks.JUNGLE_OVERLORD_FIST.get(), "Jungle Bawangquan");
        this.add(ChangShengJueBlocks.CRIMSON_OVERLORD_FIST.get(), "Crimson Bawangquan");
        this.add(ChangShengJueBlocks.WARPED_OVERLORD_FIST.get(), "Warped Bawangquan");
        this.add(ChangShengJueBlocks.ACACIA_OVERLORD_FIST.get(), "Acacia Bawangquan");
        this.add(ChangShengJueBlocks.DARK_OAK_OVERLORD_FIST.get(), "Dark Oak Bawangquan");
        this.add(ChangShengJueBlocks.OAK_OVERLORD_FIST.get(), "Oak Bawangquan");
        this.add(ChangShengJueBlocks.CHERRY_OVERLORD_FIST.get(), "Cherry Bawangquan");
        this.add(ChangShengJueBlocks.SPRUCE_OVERLORD_FIST.get(), "Spruce Bawangquan");
        this.add(ChangShengJueBlocks.SHORT_MANGROVE_BACK_BRACKET.get(), "Mangrove Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_BIRCH_BACK_BRACKET.get(), "Birch Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_JUNGLE_BACK_BRACKET.get(), "Jungle Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_CRIMSON_BACK_BRACKET.get(), "Crimson Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_WARPED_BACK_BRACKET.get(), "Warped Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_ACACIA_BACK_BRACKET.get(), "Acacia Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_DARK_OAK_BACK_BRACKET.get(), "Dark Oak Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_OAK_BACK_BRACKET.get(), "Oak Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_CHERRY_BACK_BRACKET.get(), "Cherry Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_SPRUCE_BACK_BRACKET.get(), "Spruce Hui Wen Queti");
        this.add(ChangShengJueBlocks.SHORT_MANGROVE_FLOWER_BRACKET.get(), "Mangrove Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_BIRCH_FLOWER_BRACKET.get(), "Birch Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_JUNGLE_FLOWER_BRACKET.get(), "Jungle Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_CRIMSON_FLOWER_BRACKET.get(), "Crimson Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_WARPED_FLOWER_BRACKET.get(), "Warped Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_ACACIA_FLOWER_BRACKET.get(), "Acacia Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_DARK_OAK_FLOWER_BRACKET.get(), "Dark Oak Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_OAK_FLOWER_BRACKET.get(), "Oak Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_CHERRY_FLOWER_BRACKET.get(), "Cherry Huayazi Queti");
        this.add(ChangShengJueBlocks.SHORT_SPRUCE_FLOWER_BRACKET.get(), "Spruce Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_MANGROVE_BACK_BRACKET.get(), "Mangrove Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_BIRCH_BACK_BRACKET.get(), "Birch Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_JUNGLE_BACK_BRACKET.get(), "Jungle Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_CRIMSON_BACK_BRACKET.get(), "Crimson Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_WARPED_BACK_BRACKET.get(), "Warped Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_ACACIA_BACK_BRACKET.get(), "Acacia Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_DARK_OAK_BACK_BRACKET.get(), "Dark Oak Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_OAK_BACK_BRACKET.get(), "Oak Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_CHERRY_BACK_BRACKET.get(), "Cherry Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_SPRUCE_BACK_BRACKET.get(), "Spruce Hui Wen Queti");
        this.add(ChangShengJueBlocks.LONG_MANGROVE_FLOWER_BRACKET.get(), "Mangrove Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_BIRCH_FLOWER_BRACKET.get(), "Birch Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_JUNGLE_FLOWER_BRACKET.get(), "Jungle Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_CRIMSON_FLOWER_BRACKET.get(), "Crimson Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_WARPED_FLOWER_BRACKET.get(), "Warped Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_ACACIA_FLOWER_BRACKET.get(), "Acacia Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_DARK_OAK_FLOWER_BRACKET.get(), "Dark Oak Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_OAK_FLOWER_BRACKET.get(), "Oak Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_CHERRY_FLOWER_BRACKET.get(), "Cherry Huayazi Queti");
        this.add(ChangShengJueBlocks.LONG_SPRUCE_FLOWER_BRACKET.get(), "Spruce Huayazi Queti");
        this.add(ChangShengJueBlocks.MANGROVE_DOUGONG.get(), "Mangrove Bracket System");
        this.add(ChangShengJueBlocks.BIRCH_DOUGONG.get(), "Birch Bracket System");
        this.add(ChangShengJueBlocks.JUNGLE_DOUGONG.get(), "Jungle Bracket System");
        this.add(ChangShengJueBlocks.CRIMSON_DOUGONG.get(), "Crimson Bracket System");
        this.add(ChangShengJueBlocks.WARPED_DOUGONG.get(), "Warped Bracket System");
        this.add(ChangShengJueBlocks.ACACIA_DOUGONG.get(), "Acacia Bracket System");
        this.add(ChangShengJueBlocks.DARK_OAK_DOUGONG.get(), "Dark Oak Bracket System");
        this.add(ChangShengJueBlocks.OAK_DOUGONG.get(), "Oak Bracket System");
        this.add(ChangShengJueBlocks.CHERRY_DOUGONG.get(), "Cherry Bracket System");
        this.add(ChangShengJueBlocks.SPRUCE_DOUGONG.get(), "Spruce Bracket System");
        this.add(ChangShengJueBlocks.GREEN_DOUGONG.get(),"Green with Cyan Bracket System");
        this.add(ChangShengJueBlocks.BLUE_DOUGONG.get(),"Cyan with Green Bracket System");

        this.add(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get(),"Stone Lamp Base");
        this.add(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(),"Unlit Stone Lamp");
        this.add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get(),"Stone Lamp");
        this.add(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get(),"Yellow Stone Lion");
        this.add(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get(),"Gray Stone Lion");
        this.add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),"Birch Ladder");
        this.add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),"Spruce Ladder");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(),"Gray Glazed Tile Block");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(),"Red Glazed Tile Block");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(),"Black Glazed Tile Block");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(),"Golden Glazed Tile Block");
        this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get(),"Cyan Glazed Tile Block");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(),"Blue Glazed Tile Block");
        this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get(),"Purple Glazed Tile Block");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),"Gray Glazed Tile Slab");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),"Red Glazed Tile Slab");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),"Black Glazed Tile Slab");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),"Golden Glazed Tile Slab");
        this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get(),"Cyan Glazed Tile Slab");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),"Blue Glazed Tile Slab");
        this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get(),"Purple Glazed Tile Slab");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(),"Gray Glazed Tile Side");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(),"Red Glazed Tile Side");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(),"Black Glazed Tile Side");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(),"Golden Glazed Tile Side");
        this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get(),"Cyan Glazed Tile Side");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(),"Blue Glazed Tile Side");
        this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get(),"Purple Glazed Tile Side");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),"Gray Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),"Red Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),"Black Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),"Golden Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get(),"Cyan Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),"Blue Side Octagonal Upturned Eaves");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get(),"Purple Side Octagonal Upturned Eaves");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Gray Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Red Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Black Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Golden Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Cyan Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Blue Side Octagonal Low Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),"Purple Side Octagonal Low Ridge Tiles (Front)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Gray Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Red Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Black Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Golden Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Cyan Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Blue Side Octagonal Low Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),"Purple Side Octagonal Low Ridge Tiles (Behind)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Gray Side High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Red Side High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Black Side High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Golden Side High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Cyan Side High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Blue Side High Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(),"Purple Side High Ridge Tiles (Front)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Gray Side High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Red Side High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Black Side High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Golden Side High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Cyan Side High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Blue Side High Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(),"Purple Side High Ridge Tiles (Behind)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Gray Side Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Red Side Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Black Side Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Golden Side Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Cyan Side Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Blue Side Double Ridge Tiles (Front)");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(),"Purple Side Double Ridge Tiles (Front)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Gray Side Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Red Side Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Black Side Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Golden Side Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Cyan Side Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Blue Side Double Ridge Tiles (Behind)");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(),"Purple Side Double Ridge Tiles (Behind)");

        this.add(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Gray Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Red Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Black Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Golden Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Cyan Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Blue Side Ridge Tile Roof");
        this.add(ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),"Purple Side Ridge Tile Roof");

        this.add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),"Gray Glazed Tile");
        this.add(ChangShengJueBlocks.RED_CYLINDER_TILE.get(),"Red Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),"Black Glazed Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),"Golden Glazed Tile");
        this.add(ChangShengJueBlocks.CYAN_CYLINDER_TILE.get(),"Cyan Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),"Blue Glazed Tile");
        this.add(ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get(),"Purple Glazed Tile");

        this.add(ChangShengJueBlocks.GRE_EAVES_TILE.get(),"Gray Eaves Tile");
        this.add(ChangShengJueBlocks.RED_EAVES_TILE.get(),"Red Eaves Tile");
        this.add(ChangShengJueBlocks.BLACK_EAVES_TILE.get(),"Black Eaves Tile");
        this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE.get(),"Golden Eaves Tile");
        this.add(ChangShengJueBlocks.CYAN_EAVES_TILE.get(),"Cyan Eaves Tile");
        this.add(ChangShengJueBlocks.BLUE_EAVES_TILE.get(),"Blue Eaves Tile");
        this.add(ChangShengJueBlocks.PURPLE_EAVES_TILE.get(),"Purple Eaves Tile");

        this.add(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get(),"Double Cyan Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(),"Double Gray Glazed Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get(),"Double Red Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(),"Double Black Glazed Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get(),"Double Golden Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get(),"Double Blue Glazed Tile");
        this.add(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get(),"Double Purple Glazed Tile");

        this.add(ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get(),"Cyan Small Chiwen");
        this.add(ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(),"Gray Small Chiwen");
        this.add(ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get(),"Red Small Chiwen");
        this.add(ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(),"Black Small Chiwen");
        this.add(ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get(),"Golden Small Chiwen");
        this.add(ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get(),"Blue Small Chiwen");
        this.add(ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get(),"Purple Small Chiwen");

        this.add(ChangShengJueBlocks.CYAN_RIDGE_TILE.get(),"Cyan Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_RIDGE_TILE.get(),"Gray Ridge Tile");
        this.add(ChangShengJueBlocks.RED_RIDGE_TILE.get(),"Red Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_RIDGE_TILE.get(),"Black Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get(),"Golden Ridge Tile");
        this.add(ChangShengJueBlocks.BLUE_RIDGE_TILE.get(),"Blue Ridge Tile");
        this.add(ChangShengJueBlocks.PURPLE_RIDGE_TILE.get(),"Purple Ridge Tile");

        this.add(ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get(),"Double Cyan Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get(),"Double Gray Ridge Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get(),"Double Red Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get(),"Double Black Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get(),"Double Golden Ridge Tile");
        this.add(ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get(),"Double Blue Ridge Tile");
        this.add(ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get(),"Purple Blue Ridge Tile");

        this.add(ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get(),"Cyan Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get(),"Gray Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get(),"Red Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get(),"Black Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get(),"Golden Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get(),"Blue Upturned Eaves Glazed Tile");
        this.add(ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get(),"Purple Upturned Eaves Glazed Tile");

        this.add(ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get(),"Cyan Double-Ridge Ornamental Tile");
        this.add(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),"Gray Double-Ridge Ornamental Tile");
        this.add(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),"Red Double-Ridge Ornamental Tile");
        this.add(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),"Black Double-Ridge Ornamental Tile");
        this.add(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),"Golden Double-Ridge Ornamental Tile");
        this.add(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),"Blue Double-Ridge Ornamental Tile");
        this.add(ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get(),"Purple Double-Ridge Ornamental Tile");

        this.add(ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get(),"Cyan Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(),"Gray Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(),"Red Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(),"Black Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(),"Golden Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(),"Blue Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get(),"Purple Hanging Beast Ridge Tile");

        this.add(ChangShengJueBlocks.CYAN_ROOF_RIDGE.get(),"Cyan Roof Ridge");
        this.add(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(),"Gray Roof Ridge");
        this.add(ChangShengJueBlocks.RED_ROOF_RIDGE.get(),"Red Roof Ridge");
        this.add(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(),"Black Roof Ridge");
        this.add(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(),"Golden Roof Ridge");
        this.add(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(),"Blue Roof Ridge");
        this.add(ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get(),"Purple Roof Ridge");

        this.add(ChangShengJueBlocks.CYAN_DEMON_MASK.get(), "Cyan Chiwen");
        this.add(ChangShengJueBlocks.GRE_DEMON_MASK.get(), "Gray Chiwen");
        this.add(ChangShengJueBlocks.RED_DEMON_MASK.get(), "Red Chiwen");
        this.add(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), "Black Chiwen");
        this.add(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), "Golden Chiwen");
        this.add(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), "Blue Chiwen");
        this.add(ChangShengJueBlocks.PURPLE_DEMON_MASK.get(), "Purple Chiwen");

        this.add(ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get(), "Cyan Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), "Gray Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), "Red Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), "Black Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), "Golden Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), "Blue Pavilion Ridge Finial");
        this.add(ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get(), "Purple Pavilion Ridge Finial");

        this.add(ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get(), "Cyan Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), "Gray Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), "Red Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), "Black Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), "Golden Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), "Blue Plaque Ridge Finial");
        this.add(ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get(), "Purple Plaque Ridge Finial");

        this.add(ChangShengJueBlocks.CYAN_HIPPED_ROOF.get(), "Cyan Pyramidal Roof");
        this.add(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), "Gray Pyramidal Roof");
        this.add(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), "Red Pyramidal Roof");
        this.add(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), "Black Pyramidal Roof");
        this.add(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), "Golden Pyramidal Roof");
        this.add(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), "Blue Pyramidal Roof");
        this.add(ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get(), "Purple Pyramidal Roof");

        this.add(ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.get(), "Cyan Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), "Gray Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), "Red Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), "Black Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), "Golden Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), "Blue Aligned Eaves Tile");
        this.add(ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Purple Aligned Eaves Tile");

        this.add(ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Double Cyan Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Double Gray Ridge Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Double Red Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Double Black Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Double Golden Ridge Tile");
        this.add(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Double Blue Ridge Tile");
        this.add(ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), "Purple Blue Ridge Tile");

        this.add(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Blue Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Gray Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Red Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Black Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Golden Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Cyan Double Hanging Beast Ridge Tile");
        this.add(ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(),"Purple Double Hanging Beast Ridge Tile");

        this.add(ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.get(), "Cyan Short Glazed Tile");
        this.add(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), "Gray Short Glazed Tile");
        this.add(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), "Red Short Glazed Tile");
        this.add(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), "Black Short Glazed Tile");
        this.add(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), "Golden Short Glazed Tile");
        this.add(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), "Blue Short Glazed Tile");
        this.add(ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.get(), "Purple Short Glazed Tile");

        this.add(ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get(), "Cyan Double Glazed Tile Side");
        this.add(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), "Gray Double Glazed Tile Side");
        this.add(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), "Red Double Glazed Tile Side");
        this.add(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), "Black Double Glazed Tile Side");
        this.add(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), "Golden Double Glazed Tile Side");
        this.add(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), "Blue Double Glazed Tile Side");
        this.add(ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get(), "Purple Double Glazed Tile Side");

        this.add(ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get(), "Cyan Side Eaves Tile");
        this.add(ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(), "Gray Side Eaves Tile");
        this.add(ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(), "Red Side Eaves Tile");
        this.add(ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(), "Black Side Eaves Tile");
        this.add(ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(), "Golden Side Eaves Tile");
        this.add(ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(), "Blue Side Eaves Tile");
        this.add(ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get(), "Purple Side Eaves Tile");

        this.add(ChangShengJueBlocks.GOLDEN_TILE.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_CORNICES.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(), "Golden Tile");
        this.add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(), "Golden Tile");

        this.add(ChangShengJueBlocks.BLACK_TILE.get(), "Tile");
        this.add(ChangShengJueBlocks.BLACK_GENTLE_TILE.get(), "Tile");
        this.add(ChangShengJueBlocks.BLACK_CORNICES.get(), "Tile");
        this.add(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_2.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_3.get(), "Tile");
        this.add(ChangShengJueBlocks.TILE_BLOCK_4.get(), "Tile");

        this.add(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get(), "Bitumen Floor Tiles");
        this.add(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get(), "Cyan Stone Floor Tiles");
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
        this.add(ChangShengJueBlocks.JUNGLE_BENCH.get(), "Jungle Bench");
        this.add(ChangShengJueBlocks.CRIMSON_BENCH.get(), "Crimson Bench");
        this.add(ChangShengJueBlocks.WARPED_BENCH.get(), "Warped Bench");
        this.add(ChangShengJueBlocks.MANGROVE_BENCH.get(), "Mangrove Bench");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get(), "Huanghuali Bench");
        this.add(ChangShengJueBlocks.JI_CHI_MU_BENCH.get(), "Wenge Bench");
        this.add(ChangShengJueBlocks.ACACIA_BENCH.get(), "Acacia Bench");
        this.add(ChangShengJueBlocks.DARK_OAK_BENCH.get(), "Dark Oak Bench");
        this.add(ChangShengJueBlocks.OAK_BENCH.get(), "Oak Bench");
        this.add(ChangShengJueBlocks.CHERRY_BENCH.get(), "Cherry Bench");
        this.add(ChangShengJueBlocks.SPRUCE_BENCH.get(), "Spruce Bench");
        this.add(ChangShengJueBlocks.ZI_TAN_BENCH.get(), "Zitan Bench");

        this.add(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get(), "Birch Wine table and chairs");
        this.add(ChangShengJueBlocks.JUNGLE_DRINKING_TABLE_AND_CHAIRS.get(), "Jungle Wine table and chairs");
        this.add(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get(), "Crimson Wine table and chairs");
        this.add(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get(), "Warped Wine table and chairs");
        this.add(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get(), "Mangrove Wine table and chairs");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get(), "Huanghuali Wine table and chairs");
        this.add(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get(), "Wenge Wine table and chairs");
        this.add(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get(), "Acacia Wine table and chairs");
        this.add(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get(), "Dark Oak Wine table and chairs");
        this.add(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get(), "Oak Wine table and chairs");
        this.add(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get(), "Cherry Wine table and chairs");
        this.add(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get(), "Spruce Wine table and chairs");
        this.add(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get(), "Zitan Wine table and chairs");

        this.add(ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), "Birch Writing Desk");
        this.add(ChangShengJueBlocks.JUNGLE_BOOK_DESK.get(), "Jungle Writing Desk");
        this.add(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), "Crimson Writing Desk");
        this.add(ChangShengJueBlocks.WARPED_BOOK_DESK.get(), "Warped Writing Desk");
        this.add(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), "Mangrove Writing Desk");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), "Huanghuali Writing Desk");
        this.add(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), "Wenge Writing Desk");
        this.add(ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), "Acacia Writing Desk");
        this.add(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), "Dark Oak Writing Desk");
        this.add(ChangShengJueBlocks.OAK_BOOK_DESK.get(), "Oak Writing Desk");
        this.add(ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), "Cherry Writing Desk");
        this.add(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), "Spruce Writing Desk");
        this.add(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), "Zitan Writing Desk");

        this.add(ChangShengJueBlocks.BIRCH_TEAPOY.get(), "Birch Teapoy");
        this.add(ChangShengJueBlocks.JUNGLE_TEAPOY.get(),"Jungle Teapoy");
        this.add(ChangShengJueBlocks.CRIMSON_TEAPOY.get(),"Crimson Teapoy");
        this.add(ChangShengJueBlocks.WARPED_TEAPOY.get(),"Warped Teapoy");
        this.add(ChangShengJueBlocks.MANGROVE_TEAPOY.get(),"Mangrove Teapoy");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(),"Huanghuali Teapoy");
        this.add(ChangShengJueBlocks.WENGE_TEAPOY.get(),"Wenge Teapoy");
        this.add(ChangShengJueBlocks.ACACIA_TEAPOY.get(),"Acacia Teapoy");
        this.add(ChangShengJueBlocks.DARK_OAK_TEAPOY.get(),"Dark Oak Teapoy");
        this.add(ChangShengJueBlocks.OAK_TEAPOY.get(),"Oak Teapoy");
        this.add(ChangShengJueBlocks.CHERRY_TEAPOY.get(),"Cherry Teapoy");
        this.add(ChangShengJueBlocks.SPRUCE_TEAPOY.get(),"Spruce Teapoy");
        this.add(ChangShengJueBlocks.ZI_TAN_TEAPOY.get(),"Zitan Teapoy");

        this.add(ChangShengJueBlocks.BIRCH_TAISHI_CHAIR.get(), "Birch Taishi Chair");
        this.add(ChangShengJueBlocks.JUNGLE_TAISHI_CHAIR.get(),"Jungle Taishi Chair");
        this.add(ChangShengJueBlocks.CRIMSON_TAISHI_CHAIR.get(),"Crimson Taishi Chair");
        this.add(ChangShengJueBlocks.WARPED_TAISHI_CHAIR.get(),"Warped Taishi Chair");
        this.add(ChangShengJueBlocks.MANGROVE_TAISHI_CHAIR.get(),"Mangrove Taishi Chair");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(),"Huanghuali Taishi Chair");
        this.add(ChangShengJueBlocks.WENGE_TAISHI_CHAIR.get(),"Wenge Taishi Chair");
        this.add(ChangShengJueBlocks.ACACIA_TAISHI_CHAIR.get(),"Acacia Taishi Chair");
        this.add(ChangShengJueBlocks.DARK_OAK_TAISHI_CHAIR.get(),"Dark Oak Taishi Chair");
        this.add(ChangShengJueBlocks.OAK_TAISHI_CHAIR.get(),"Oak Taishi Chair");
        this.add(ChangShengJueBlocks.CHERRY_TAISHI_CHAIR.get(),"Cherry Taishi Chair");
        this.add(ChangShengJueBlocks.SPRUCE_TAISHI_CHAIR.get(),"Spruce Taishi Chair");
        this.add(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(),"Zitan Taishi Chair");

        this.add(ChangShengJueBlocks.BIRCH_FIVE_SCREEN_THRONE.get(), "Birch Five-screen Throne");
        this.add(ChangShengJueBlocks.JUNGLE_FIVE_SCREEN_THRONE.get(),"Jungle Five-screen Throne");
        this.add(ChangShengJueBlocks.CRIMSON_FIVE_SCREEN_THRONE.get(),"Crimson Five-screen Throne");
        this.add(ChangShengJueBlocks.WARPED_FIVE_SCREEN_THRONE.get(),"Warped Five-screen Throne");
        this.add(ChangShengJueBlocks.MANGROVE_FIVE_SCREEN_THRONE.get(),"Mangrove Five-screen Throne");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(),"Huanghuali Five-screen Throne");
        this.add(ChangShengJueBlocks.WENGE_FIVE_SCREEN_THRONE.get(),"Wenge Five-screen Throne");
        this.add(ChangShengJueBlocks.ACACIA_FIVE_SCREEN_THRONE.get(),"Acacia Five-screen Throne");
        this.add(ChangShengJueBlocks.DARK_OAK_FIVE_SCREEN_THRONE.get(),"Dark Oak Five-screen Throne");
        this.add(ChangShengJueBlocks.OAK_FIVE_SCREEN_THRONE.get(),"Oak Five-screen Throne");
        this.add(ChangShengJueBlocks.CHERRY_FIVE_SCREEN_THRONE.get(),"Cherry Five-screen Throne");
        this.add(ChangShengJueBlocks.SPRUCE_FIVE_SCREEN_THRONE.get(),"Spruce Five-screen Throne");
        this.add(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(),"Zitan Five-screen Throne");

        this.add(ChangShengJueBlocks.BIRCH_LOW_DESK.get(), "Birch Low Desk");
        this.add(ChangShengJueBlocks.JUNGLE_LOW_DESK.get(), "Jungle Low Desk");
        this.add(ChangShengJueBlocks.CRIMSON_LOW_DESK.get(), "Crimson Low Desk");
        this.add(ChangShengJueBlocks.WARPED_LOW_DESK.get(), "Warped Low Desk");
        this.add(ChangShengJueBlocks.MANGROVE_LOW_DESK.get(), "Mangrove Low Desk");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get(), "Huanghuali Low Desk");
        this.add(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get(), "Wenge Low Desk");
        this.add(ChangShengJueBlocks.ACACIA_LOW_DESK.get(), "Acacia Low Desk");
        this.add(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get(), "Dark Oak Low Desk");
        this.add(ChangShengJueBlocks.OAK_LOW_DESK.get(), "Oak Low Desk");
        this.add(ChangShengJueBlocks.CHERRY_LOW_DESK.get(), "Cherry Low Desk");
        this.add(ChangShengJueBlocks.SPRUCE_LOW_DESK.get(), "Spruce Low Desk");
        this.add(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get(), "Zitan Low Desk");

        this.add(ChangShengJueBlocks.BIRCH_SQUARE_STOOL.get(), "Birch Square Stool");
        this.add(ChangShengJueBlocks.JUNGLE_SQUARE_STOOL.get(),"Jungle Square Stool");
        this.add(ChangShengJueBlocks.CRIMSON_SQUARE_STOOL.get(),"Crimson Square Stool");
        this.add(ChangShengJueBlocks.WARPED_SQUARE_STOOL.get(),"Warped Square Stool");
        this.add(ChangShengJueBlocks.MANGROVE_SQUARE_STOOL.get(),"Mangrove Square Stool");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_SQUARE_STOOL.get(),"Huanghuali Square Stool");
        this.add(ChangShengJueBlocks.WENGE_SQUARE_STOOL.get(),"Wenge Square Stool");
        this.add(ChangShengJueBlocks.ACACIA_SQUARE_STOOL.get(),"Acacia Square Stool");
        this.add(ChangShengJueBlocks.DARK_OAK_SQUARE_STOOL.get(),"Dark Oak Square Stool");
        this.add(ChangShengJueBlocks.OAK_SQUARE_STOOL.get(),"Oak Square Stool");
        this.add(ChangShengJueBlocks.CHERRY_SQUARE_STOOL.get(),"Cherry Square Stool");
        this.add(ChangShengJueBlocks.SPRUCE_SQUARE_STOOL.get(),"Spruce Square Stool");
        this.add(ChangShengJueBlocks.ZI_TAN_SQUARE_STOOL.get(),"Zitan Square Stool");

        this.add(ChangShengJueBlocks.BIRCH_FRETWORK_OPENWORK_PANEL.get(), "Birch Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.JUNGLE_FRETWORK_OPENWORK_PANEL.get(), "Jungle Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.CRIMSON_FRETWORK_OPENWORK_PANEL.get(), "Crimson Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.WARPED_FRETWORK_OPENWORK_PANEL.get(), "Warped Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.MANGROVE_FRETWORK_OPENWORK_PANEL.get(), "Mangrove Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_FRETWORK_OPENWORK_PANEL.get(), "Huanghuali Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.WENGE_FRETWORK_OPENWORK_PANEL.get(), "Wenge Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.ACACIA_FRETWORK_OPENWORK_PANEL.get(), "Acacia Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.DARK_OAK_FRETWORK_OPENWORK_PANEL.get(), "Dark Oak Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.OAK_FRETWORK_OPENWORK_PANEL.get(), "Oak Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.CHERRY_FRETWORK_OPENWORK_PANEL.get(), "Cherry Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.SPRUCE_FRETWORK_OPENWORK_PANEL.get(), "Spruce Fretwork Openwork Panel");
        this.add(ChangShengJueBlocks.ZI_TAN_FRETWORK_OPENWORK_PANEL.get(), "Zitan Fretwork Openwork Panel");

        this.add(ChangShengJueBlocks.BIRCH_BOOK_GRID.get(), "Birch Book Grid");
        this.add(ChangShengJueBlocks.JUNGLE_BOOK_GRID.get(), "Jungle Book Grid");
        this.add(ChangShengJueBlocks.CRIMSON_BOOK_GRID.get(), "Crimson Book Grid");
        this.add(ChangShengJueBlocks.WARPED_BOOK_GRID.get(), "Warped Book Grid");
        this.add(ChangShengJueBlocks.MANGROVE_BOOK_GRID.get(), "Mangrove Book Grid");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_GRID.get(), "Huanghuali Book Grid");
        this.add(ChangShengJueBlocks.WENGE_BOOK_GRID.get(), "Wenge Book Grid");
        this.add(ChangShengJueBlocks.ACACIA_BOOK_GRID.get(), "Acacia Book Grid");
        this.add(ChangShengJueBlocks.DARK_OAK_BOOK_GRID.get(), "Dark Oak Book Grid");
        this.add(ChangShengJueBlocks.OAK_BOOK_GRID.get(), "Oak Book Grid");
        this.add(ChangShengJueBlocks.CHERRY_BOOK_GRID.get(), "Cherry Book Grid");
        this.add(ChangShengJueBlocks.SPRUCE_BOOK_GRID.get(), "Spruce Book Grid");
        this.add(ChangShengJueBlocks.ZI_TAN_BOOK_GRID.get(), "Zitan Book Grid");

        this.add(ChangShengJueBlocks.BIRCH_CABINET.get(), "Birch Cabinet");
        this.add(ChangShengJueBlocks.JUNGLE_CABINET.get(), "Jungle Cabinet");
        this.add(ChangShengJueBlocks.CRIMSON_CABINET.get(), "Crimson Cabinet");
        this.add(ChangShengJueBlocks.WARPED_CABINET.get(), "Warped Cabinet");
        this.add(ChangShengJueBlocks.MANGROVE_CABINET.get(), "Mangrove Cabinet");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_CABINET.get(), "Huanghuali Cabinet");
        this.add(ChangShengJueBlocks.WENGE_CABINET.get(), "Wenge Cabinet");
        this.add(ChangShengJueBlocks.ACACIA_CABINET.get(), "Acacia Cabinet");
        this.add(ChangShengJueBlocks.DARK_OAK_CABINET.get(), "Dark Oak Cabinet");
        this.add(ChangShengJueBlocks.OAK_CABINET.get(), "Oak Cabinet");
        this.add(ChangShengJueBlocks.CHERRY_CABINET.get(), "Cherry Cabinet");
        this.add(ChangShengJueBlocks.SPRUCE_CABINET.get(), "Spruce Cabinet");
        this.add(ChangShengJueBlocks.ZI_TAN_CABINET.get(), "Zitan Cabinet");

        this.add(ChangShengJueBlocks.BIRCH_LARGE_CABINET.get(), "Birch LargeCabinet");
        this.add(ChangShengJueBlocks.JUNGLE_LARGE_CABINET.get(), "Jungle LargeCabinet");
        this.add(ChangShengJueBlocks.CRIMSON_LARGE_CABINET.get(), "Crimson LargeCabinet");
        this.add(ChangShengJueBlocks.WARPED_LARGE_CABINET.get(), "Warped LargeCabinet");
        this.add(ChangShengJueBlocks.MANGROVE_LARGE_CABINET.get(), "Mangrove LargeCabinet");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LARGE_CABINET.get(), "Huanghuali LargeCabinet");
        this.add(ChangShengJueBlocks.WENGE_LARGE_CABINET.get(), "Wenge LargeCabinet");
        this.add(ChangShengJueBlocks.ACACIA_LARGE_CABINET.get(), "Acacia LargeCabinet");
        this.add(ChangShengJueBlocks.DARK_OAK_LARGE_CABINET.get(), "Dark Oak LargeCabinet");
        this.add(ChangShengJueBlocks.OAK_LARGE_CABINET.get(), "Oak LargeCabinet");
        this.add(ChangShengJueBlocks.CHERRY_LARGE_CABINET.get(), "Cherry LargeCabinet");
        this.add(ChangShengJueBlocks.SPRUCE_LARGE_CABINET.get(), "Spruce LargeCabinet");
        this.add(ChangShengJueBlocks.ZI_TAN_LARGE_CABINET.get(), "Zitan LargeCabinet");

        this.add(ChangShengJueBlocks.BIRCH_DRYING_RAIL.get(), "Birch Drying Rail");
        this.add(ChangShengJueBlocks.JUNGLE_DRYING_RAIL.get(), "Jungle Drying Rail");
        this.add(ChangShengJueBlocks.CRIMSON_DRYING_RAIL.get(), "Crimson Drying Rail");
        this.add(ChangShengJueBlocks.WARPED_DRYING_RAIL.get(), "Warped Drying Rail");
        this.add(ChangShengJueBlocks.MANGROVE_DRYING_RAIL.get(), "Mangrove Drying Rail");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_DRYING_RAIL.get(), "Huanghuali Drying Rail");
        this.add(ChangShengJueBlocks.WENGE_DRYING_RAIL.get(), "Wenge Drying Rail");
        this.add(ChangShengJueBlocks.ACACIA_DRYING_RAIL.get(), "Acacia Drying Rail");
        this.add(ChangShengJueBlocks.DARK_OAK_DRYING_RAIL.get(), "Dark Oak Drying Rail");
        this.add(ChangShengJueBlocks.OAK_DRYING_RAIL.get(), "Oak Drying Rail");
        this.add(ChangShengJueBlocks.CHERRY_DRYING_RAIL.get(), "Cherry Drying Rail");
        this.add(ChangShengJueBlocks.SPRUCE_DRYING_RAIL.get(), "Spruce Drying Rail");
        this.add(ChangShengJueBlocks.ZI_TAN_DRYING_RAIL.get(), "Zitan Drying Rail");

        this.add(ChangShengJueBlocks.BIRCH_CLOTHES_RACK.get(), "Birch Clothes Rack");
        this.add(ChangShengJueBlocks.JUNGLE_CLOTHES_RACK.get(), "Jungle Clothes Rack");
        this.add(ChangShengJueBlocks.CRIMSON_CLOTHES_RACK.get(), "Crimson Clothes Rack");
        this.add(ChangShengJueBlocks.WARPED_CLOTHES_RACK.get(), "Warped Clothes Rack");
        this.add(ChangShengJueBlocks.MANGROVE_CLOTHES_RACK.get(), "Mangrove Clothes Rack");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_CLOTHES_RACK.get(), "Huanghuali Clothes Rack");
        this.add(ChangShengJueBlocks.WENGE_CLOTHES_RACK.get(), "Wenge Clothes Rack");
        this.add(ChangShengJueBlocks.ACACIA_CLOTHES_RACK.get(), "Acacia Clothes Rack");
        this.add(ChangShengJueBlocks.DARK_OAK_CLOTHES_RACK.get(), "Dark Oak Clothes Rack");
        this.add(ChangShengJueBlocks.OAK_CLOTHES_RACK.get(), "Oak Clothes Rack");
        this.add(ChangShengJueBlocks.CHERRY_CLOTHES_RACK.get(), "Cherry Clothes Rack");
        this.add(ChangShengJueBlocks.SPRUCE_CLOTHES_RACK.get(), "Spruce Clothes Rack");
        this.add(ChangShengJueBlocks.ZI_TAN_CLOTHES_RACK.get(), "Zitan Clothes Rack");

        this.add(ChangShengJueBlocks.BIRCH_CHEST_OF_DRAWERS.get(), "Birch Chest Of Drawers");
        this.add(ChangShengJueBlocks.JUNGLE_CHEST_OF_DRAWERS.get(), "Jungle Chest Of Drawers");
        this.add(ChangShengJueBlocks.CRIMSON_CHEST_OF_DRAWERS.get(), "Crimson Chest Of Drawers");
        this.add(ChangShengJueBlocks.WARPED_CHEST_OF_DRAWERS.get(), "Warped Chest Of Drawers");
        this.add(ChangShengJueBlocks.MANGROVE_CHEST_OF_DRAWERS.get(), "Mangrove Chest Of Drawers");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_CHEST_OF_DRAWERS.get(), "Huanghuali Chest Of Drawers");
        this.add(ChangShengJueBlocks.WENGE_CHEST_OF_DRAWERS.get(), "Wenge Chest Of Drawers");
        this.add(ChangShengJueBlocks.ACACIA_CHEST_OF_DRAWERS.get(), "Acacia Chest Of Drawers");
        this.add(ChangShengJueBlocks.DARK_OAK_CHEST_OF_DRAWERS.get(), "Dark Oak Chest Of Drawers");
        this.add(ChangShengJueBlocks.OAK_CHEST_OF_DRAWERS.get(), "Oak Chest Of Drawers");
        this.add(ChangShengJueBlocks.CHERRY_CHEST_OF_DRAWERS.get(), "Cherry Chest Of Drawers");
        this.add(ChangShengJueBlocks.SPRUCE_CHEST_OF_DRAWERS.get(), "Spruce Chest Of Drawers");
        this.add(ChangShengJueBlocks.ZI_TAN_CHEST_OF_DRAWERS.get(), "Zitan Chest Of Drawers");

        this.add(ChangShengJueBlocks.BIRCH_LIANGGE.get(), "Birch Liangge");
        this.add(ChangShengJueBlocks.JUNGLE_LIANGGE.get(), "Jungle Liangge");
        this.add(ChangShengJueBlocks.CRIMSON_LIANGGE.get(), "Crimson Liangge");
        this.add(ChangShengJueBlocks.WARPED_LIANGGE.get(), "Warped Liangge");
        this.add(ChangShengJueBlocks.MANGROVE_LIANGGE.get(), "Mangrove Liangge");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LIANGGE.get(), "Huanghuali Liangge");
        this.add(ChangShengJueBlocks.WENGE_LIANGGE.get(), "Wenge Liangge");
        this.add(ChangShengJueBlocks.ACACIA_LIANGGE.get(), "Acacia Liangge");
        this.add(ChangShengJueBlocks.DARK_OAK_LIANGGE.get(), "Dark Oak Liangge");
        this.add(ChangShengJueBlocks.OAK_LIANGGE.get(), "Oak Liangge");
        this.add(ChangShengJueBlocks.CHERRY_LIANGGE.get(), "Cherry Liangge");
        this.add(ChangShengJueBlocks.SPRUCE_LIANGGE.get(), "Spruce Liangge");
        this.add(ChangShengJueBlocks.ZI_TAN_LIANGGE.get(), "Zitan Liangge");

        this.add(ChangShengJueBlocks.STONE_BENCH.get(), "Stone Bench");
        this.add(ChangShengJueBlocks.STONE_TABLE.get(), "Stone Table");
        this.add(ChangShengJueBlocks.STONE_BALUSTRADE.get(),"Stone Balustrade");

        this.add(ChangShengJueBlocks.ZAFU.get(), "Futon");

        this.add(ChangShengJueBlocks.BIRCH_FOLDING_SCREEN.get(), "Birch Folding Screen");
        this.add(ChangShengJueBlocks.JUNGLE_FOLDING_SCREEN.get(),"Jungle Folding Screen");
        this.add(ChangShengJueBlocks.CRIMSON_FOLDING_SCREEN.get(),"Crimson Folding Screen");
        this.add(ChangShengJueBlocks.WARPED_FOLDING_SCREEN.get(),"Warped Folding Screen");
        this.add(ChangShengJueBlocks.MANGROVE_FOLDING_SCREEN.get(),"Mangrove Folding Screen");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_FOLDING_SCREEN.get(),"Huanghuali Folding Screen");
        this.add(ChangShengJueBlocks.WENGE_FOLDING_SCREEN.get(),"Wenge Folding Screen");
        this.add(ChangShengJueBlocks.ACACIA_FOLDING_SCREEN.get(),"Acacia Folding Screen");
        this.add(ChangShengJueBlocks.DARK_OAK_FOLDING_SCREEN.get(),"Dark Oak Folding Screen");
        this.add(ChangShengJueBlocks.OAK_FOLDING_SCREEN.get(),"Oak Folding Screen");
        this.add(ChangShengJueBlocks.CHERRY_FOLDING_SCREEN.get(),"Cherry Folding Screen");
        this.add(ChangShengJueBlocks.SPRUCE_FOLDING_SCREEN.get(),"Spruce Folding Screen");
        this.add(ChangShengJueBlocks.ZI_TAN_FOLDING_SCREEN.get(),"Zitan Folding Screen");

        this.add(ChangShengJueBlocks.BIRCH_ARHAT_BED.get(),"Birch Vine Arhat bed");
        this.add(ChangShengJueBlocks.JUNGLE_ARHAT_BED.get(),"Jungle Vine Arhat bed");
        this.add(ChangShengJueBlocks.CRIMSON_ARHAT_BED.get(),"Crimson Vine Arhat bed");
        this.add(ChangShengJueBlocks.WARPED_ARHAT_BED.get(),"Warped Vine Arhat bed");
        this.add(ChangShengJueBlocks.MANGROVE_ARHAT_BED.get(),"Mangrove Vine Arhat bed");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_ARHAT_BED.get(),"Huanghuali Vine Arhat bed");
        this.add(ChangShengJueBlocks.WENGE_ARHAT_BED.get(),"Wenge Vine Arhat bed");
        this.add(ChangShengJueBlocks.ACACIA_ARHAT_BED.get(),"Acacia Vine Arhat bed");
        this.add(ChangShengJueBlocks.DARK_OAK_ARHAT_BED.get(),"Dark Oak Vine Arhat bed");
        this.add(ChangShengJueBlocks.OAK_ARHAT_BED.get(),"Oak Vine Arhat bed");
        this.add(ChangShengJueBlocks.CHERRY_ARHAT_BED.get(),"Cherry Vine Arhat bed");
        this.add(ChangShengJueBlocks.SPRUCE_ARHAT_BED.get(),"Spruce Vine Arhat bed");
        this.add(ChangShengJueBlocks.ZI_TAN_ARHAT_BED.get(),"Zitan Vine Arhat bed");

        this.add(ChangShengJueBlocks.BIRCH_CANOPY_BED.get(),"Birch Canopy Bed");
        this.add(ChangShengJueBlocks.JUNGLE_CANOPY_BED.get(),"Jungle Canopy Bed");
        this.add(ChangShengJueBlocks.CRIMSON_CANOPY_BED.get(),"Crimson Canopy Bed");
        this.add(ChangShengJueBlocks.WARPED_CANOPY_BED.get(),"Warped Canopy Bed");
        this.add(ChangShengJueBlocks.MANGROVE_CANOPY_BED.get(),"Mangrove Canopy Bed");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_CANOPY_BED.get(),"Huanghuali Canopy Bed");
        this.add(ChangShengJueBlocks.WENGE_CANOPY_BED.get(),"Wenge Canopy Bed");
        this.add(ChangShengJueBlocks.ACACIA_CANOPY_BED.get(),"Acacia Canopy Bed");
        this.add(ChangShengJueBlocks.DARK_OAK_CANOPY_BED.get(),"Dark Oak Canopy Bed");
        this.add(ChangShengJueBlocks.OAK_CANOPY_BED.get(),"Oak Canopy Bed");
        this.add(ChangShengJueBlocks.CHERRY_CANOPY_BED.get(),"Cherry Canopy Bed");
        this.add(ChangShengJueBlocks.SPRUCE_CANOPY_BED.get(),"Spruce Canopy Bed");
        this.add(ChangShengJueBlocks.ZI_TAN_CANOPY_BED.get(),"Zitan Canopy Bed");

        this.add(ChangShengJueBlocks.LANTERN.get(), "Lanterns");
        this.add(ChangShengJueBlocks.WHITE_LANTERN.get(), "White Lanterns");
        this.add(ChangShengJueBlocks.ORANGE_LANTERN.get(), "Orange Lanterns");
        this.add(ChangShengJueBlocks.MAGENTA_LANTERN.get(), "Magenta Lanterns");
        this.add(ChangShengJueBlocks.LIGHT_BLUE_LANTERN.get(), "Light Blue Lanterns");
        this.add(ChangShengJueBlocks.YELLOW_LANTERN.get(), "Yellow Lanterns");
        this.add(ChangShengJueBlocks.LIME_LANTERN.get(), "Lime Lanterns");
        this.add(ChangShengJueBlocks.PINK_LANTERN.get(), "Pink Lanterns");
        this.add(ChangShengJueBlocks.GRAY_LANTERN.get(), "Gray Lanterns");
        this.add(ChangShengJueBlocks.LIGHT_GRAY_LANTERN.get(), "Light Gray Lanterns");
        this.add(ChangShengJueBlocks.CYAN_LANTERN.get(), "Cyan Lanterns");
        this.add(ChangShengJueBlocks.PURPLE_LANTERN.get(), "Purple Lanterns");
        this.add(ChangShengJueBlocks.BLUE_LANTERN.get(), "Blue Lanterns");
        this.add(ChangShengJueBlocks.BROWN_LANTERN.get(), "Brown Lanterns");
        this.add(ChangShengJueBlocks.GREEN_LANTERN.get(), "Green Lanterns");
        this.add(ChangShengJueBlocks.RED_LANTERN.get(), "Red Lanterns");
        this.add(ChangShengJueBlocks.BLACK_LANTERN.get(), "Black Lanterns");

        this.add(ChangShengJueBlocks.BIRCH_LIGHT_STAND.get(),"Birch Light Stand");
        this.add(ChangShengJueBlocks.JUNGLE_LIGHT_STAND.get(),"Jungle Light Stand");
        this.add(ChangShengJueBlocks.CRIMSON_LIGHT_STAND.get(),"Crimson Light Stand");
        this.add(ChangShengJueBlocks.WARPED_LIGHT_STAND.get(),"Warped Light Stand");
        this.add(ChangShengJueBlocks.MANGROVE_LIGHT_STAND.get(),"Mangrove Light Stand");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_LIGHT_STAND.get(),"Huanghuali Light Stand");
        this.add(ChangShengJueBlocks.WENGE_LIGHT_STAND.get(),"Wenge Light Stand");
        this.add(ChangShengJueBlocks.ACACIA_LIGHT_STAND.get(),"Acacia Light Stand");
        this.add(ChangShengJueBlocks.DARK_OAK_LIGHT_STAND.get(),"Dark Oak Light Stand");
        this.add(ChangShengJueBlocks.OAK_LIGHT_STAND.get(),"Oak Light Stand");
        this.add(ChangShengJueBlocks.CHERRY_LIGHT_STAND.get(),"Cherry Light Stand");
        this.add(ChangShengJueBlocks.SPRUCE_LIGHT_STAND.get(),"Spruce Light Stand");
        this.add(ChangShengJueBlocks.ZI_TAN_LIGHT_STAND.get(),"Zitan Light Stand");

        this.add(ChangShengJueBlocks.BIRCH_HEIGHT_LIGHT_STAND.get(),"Birch Height Light Stand");
        this.add(ChangShengJueBlocks.JUNGLE_HEIGHT_LIGHT_STAND.get(),"Jungle Height Light Stand");
        this.add(ChangShengJueBlocks.CRIMSON_HEIGHT_LIGHT_STAND.get(),"Crimson Height Light Stand");
        this.add(ChangShengJueBlocks.WARPED_HEIGHT_LIGHT_STAND.get(),"Warped Height Light Stand");
        this.add(ChangShengJueBlocks.MANGROVE_HEIGHT_LIGHT_STAND.get(),"Mangrove Height Light Stand");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_HEIGHT_LIGHT_STAND.get(),"Huanghuali Height Light Stand");
        this.add(ChangShengJueBlocks.WENGE_HEIGHT_LIGHT_STAND.get(),"Wenge Height Light Stand");
        this.add(ChangShengJueBlocks.ACACIA_HEIGHT_LIGHT_STAND.get(),"Acacia Height Light Stand");
        this.add(ChangShengJueBlocks.DARK_OAK_HEIGHT_LIGHT_STAND.get(),"Dark Oak Height Light Stand");
        this.add(ChangShengJueBlocks.OAK_HEIGHT_LIGHT_STAND.get(),"Oak Height Light Stand");
        this.add(ChangShengJueBlocks.CHERRY_HEIGHT_LIGHT_STAND.get(),"Cherry Height Light Stand");
        this.add(ChangShengJueBlocks.SPRUCE_HEIGHT_LIGHT_STAND.get(),"Spruce Height Light Stand");
        this.add(ChangShengJueBlocks.ZI_TAN_HEIGHT_LIGHT_STAND.get(),"Zitan Height Light Stand");

        this.add(ChangShengJueBlocks.BAMBOO_MAT.get(), "Bamboo Mat");

        this.add(ChangShengJueBlocks.WHITE_JADE_BLOCK.get(),  "White Jade");
        this.add(ChangShengJueBlocks.WHITE_JADE_STAIRS.get(), "White Jade Stairs");
        this.add(ChangShengJueBlocks.WHITE_JADE_SLAB.get(), "White Jade Slab");
        this.add(ChangShengJueBlocks.WHITE_JADE_WALL.get(), "White Jade Wall");
        this.add(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(),"White Jade Balustrade");
        this.add(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),"White Jade Guardrail");
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
        // 食物容器类方块
        this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_PAN.get(), "Jiao Zi Plate");
        this.add(ChangShengJueBlocks.CAPSULE_JIAO_ZI_WAN.get(), "Jiao Zi Bowl");
        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_PAN.get(), "Purslane Pancake Plate");
        this.add(ChangShengJueBlocks.PORTULACA_OLERACEA_CAKE_WAN.get(), "Purslane Pancake Bowl");
        this.add(ChangShengJueBlocks.QING_TUAN_PAN.get(), "Qingtuan Plate");
        this.add(ChangShengJueBlocks.QING_TUAN_WAN.get(), "Qingtuan Bowl");
        this.add(ChangShengJueBlocks.SORGHUM_CAKE_PAN.get(), "Sorghum Pancake Plate");
        this.add(ChangShengJueBlocks.SORGHUM_CAKE_WAN.get(), "Sorghum Pancake Bowl");
        this.add(ChangShengJueBlocks.MI_FAN_PAN.get(), "Rice Plate");
        this.add(ChangShengJueBlocks.MI_FAN_WAN.get(), "Rice Bowl");
        this.add(ChangShengJueBlocks.XIAO_MI_FAN_PAN.get(), "Millet Rice Plate");
        this.add(ChangShengJueBlocks.XIAO_MI_FAN_WAN.get(), "Millet Rice Bowl");

        this.add(ChangShengJueItems.EMPTY_FEN_JIU.get(),"Empty Wine Jar");
        this.add(ChangShengJueBlocks.EMPTY_SHI_LI_XIANG.get(), "Empty Shi Li Xiang Jar");
        this.add(ChangShengJueBlocks.EMPTY_WHEAT_NUGGETS_TRIBUTE_WINE.get(), "Empty Wheat Nuggets Tribute Wine Jar");

        this.add(ChangShengJueBlocks.BIRCH_WINE_TABLE.get(), "Birch Wine Table");
        this.add(ChangShengJueBlocks.JUNGLE_WINE_TABLE.get(), "Jungle Wine Table");
        this.add(ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(), "Crimson Wine Table");
        this.add(ChangShengJueBlocks.WARPED_WINE_TABLE.get(), "Warped Wine Table");
        this.add(ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(), "Mangrove Wine Table");
        this.add(ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(), "Huanghuali Wine Table");
        this.add(ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(), "Wenge Wine Table");
        this.add(ChangShengJueBlocks.ACACIA_WINE_TABLE.get(), "Acacia Wine Table");
        this.add(ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(), "Dark Oak Wine Table");
        this.add(ChangShengJueBlocks.OAK_WINE_TABLE.get(), "Oak Wine Table");
        this.add(ChangShengJueBlocks.CHERRY_WINE_TABLE.get(), "Cherry Wine Table");
        this.add(ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(), "Spruce Wine Table");
        this.add(ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(), "Zitan Wine Table");

        this.add(ChangShengJueBlocks.STONE_SHARPENING_STONE.get(), "Stone Sharpening Stone");
        this.add(ChangShengJueBlocks.DIAMOND_SHARPENING_STONE.get(), "Diamond Sharpening Stone");
        this.add(ChangShengJueBlocks.NETHERITE_SHARPENING_STONE.get(), "Netherite Sharpening Stone");

        this.add(ChangShengJueBlocks.AG_ORE.get(), "Silver Ore");
        this.add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), "Deepslate Silver Ore");
        this.add(ChangShengJueBlocks.KAOLIN_ORE.get(), "Kaolin Ore");
        this.add(ChangShengJueBlocks.LIMESTONE.get(), "Limestone");
        this.add(ChangShengJueBlocks.SYDEROLIFE_ORE.get(), "Syderolife Ore");
        this.add(ChangShengJueBlocks.NATURAL_ASPHALT_ORE.get(), "Natural Asphalt Ore");

        this.add(ChangShengJueBlocks.CASTING_MOLDS.get(), "Copper Coin Mold");
        this.add(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(), "Bullions Casting Mold");

        this.add(ChangShengJueBlocks.PAINTING_SCROLL.get(), "Painting Scroll (1x1)");
        this.add(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(), "Painting Scroll (1x2)");
        this.add(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(), "Painting Scroll (2x1)");
        this.add(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(), "Painting Scroll (2x2)");

        this.add(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), "Chang Sheng Jue Loom");
        this.add(ChangShengJueBlocks.POTTERY_WHEEL.get(), "Pottery Wheel");
        this.add(ChangShengJueBlocks.TOOL_TABLE.get(), "Tool Table");
        this.add(ChangShengJueBlocks.WEAPON_RACK.get(), "Weapon Rack");
        this.add(ChangShengJueBlocks.DESK.get(), "Desk");
        this.add(ChangShengJueBlocks.PIG_TROUGH.get(), "Livestock Feeding Trough");

        this.add(ChangShengJueBlocks.PLAQUE.get(), "Plaque");
        this.add(ChangShengJueBlocks.SHING_MUN_LEFT.get(), "Small City Gate (Left)");
        this.add(ChangShengJueBlocks.SHING_MUN_RIGHT.get(), "Small City Gate (Right)");

        this.add(ChangShengJueBlocks.BIG_SHING_MUN_LEFT.get(), "Big City Gate (Left)");
        this.add(ChangShengJueBlocks.BIG_SHING_MUN_RIGHT.get(), "Big City Gate (Right)");
        this.add(ChangShengJueBlocks.WIND_CHIME.get(), "Wind Chime");
        this.add(ChangShengJueBlocks.TAILORING_CASE.get(), "Tailoring Table");
        this.add(ChangShengJueBlocks.FORGE_BLOCK.get(), "Forge Furnace");
        this.add(ChangShengJueBlocks.WOOD_WORKING_BENCH.get(), "Wood Working Bench");
        this.add(ChangShengJueBlocks.BRICK_KILN.get(), "Brick Kiln");
        //实体生物
        this.add(ChangShengJueEntity.BUTTERFLY.get(), "Butterfly");
        this.add(ChangShengJueEntity.MONKEY.get(), "Monkey");
        this.add(ChangShengJueEntity.DRAGONFLY.get(), "Dragonfly");
        this.add(ChangShengJueEntity.CICADA.get(), "Cicada");
        this.add(ChangShengJueEntity.CRANE.get(), "Crane");
        this.add(ChangShengJueEntity.MALE_PEACOCK.get(), "Peacock");
        this.add(ChangShengJueEntity.FEMALE_PEACOCK.get(), "Peahen");
        this.add(ChangShengJueEntity.STAG.get(), "Stag");
        this.add(ChangShengJueEntity.HIND.get(), "Hind");
        this.add(ChangShengJueEntity.TIGER.get(), "Tiger");
        this.add(ChangShengJueEntity.CROC.get(), "Crocodile");
        this.add(ChangShengJueEntity.WARRIOR.get(), "Warrior");
        this.add(ChangShengJueEntity.KILN_WORKER.get(), "Kiln Worker");
        this.add(ChangShengJueEntity.MALE_INNKEEPER.get(), "Tavern Keeper");
        this.add(ChangShengJueEntity.FEMALE_INNKEEPER.get(), "Female Tavern Keeper");
        this.add(ChangShengJueEntity.CHALLENGER.get(), "Challenger");
        this.add(ChangShengJueEntity.BLACKSMITH.get(), "Blacksmith");
        this.add(ChangShengJueEntity.LANCE_GANG_LEADER.get(), "Gang Leader");
        this.add(ChangShengJueEntity.KNIFE_GANG_LEADER.get(), "Gang Leader");
        this.add(ChangShengJueEntity.SWORD_GANG_LEADER.get(), "Gang Leader");
        this.add(ChangShengJueEntity.CLUBBED_GANG_LEADER.get(), "Gang Leader");
        this.add(ChangShengJueEntity.GANG_LEADER.get(), "Gang Leader");
        this.add(ChangShengJueEntity.BANDIT.get(), "Bandit");
        this.add(ChangShengJueEntity.VILLAIN.get(), "Villain");
        this.add(ChangShengJueEntity.ASSASSIN.get(), "Gang Assassin");
        this.add(ChangShengJueEntity.CLUBBED_MING_XIA.get(), "Stick King Dong Daxia");
        this.add(ChangShengJueEntity.SWORD_MING_XIA.get(), "Sword Immortal Zhang Daxia");
        this.add(ChangShengJueEntity.KNIFE_MING_XIA.get(), "Blade Sage Xu Daxia");
        this.add(ChangShengJueEntity.FIST_MING_XIA.get(), "Northern Fist Xiao Daxia");
        this.add(ChangShengJueEntity.PIGLIN_WU_XIA.get(), "Kungfu Piglin");
        this.add(ChangShengJueEntity.WITCH_WU_XIA.get(), "Kungfu Witch");
        this.add(ChangShengJueEntity.EVOKER_WU_XIA.get(), "Kungfu Evoker");
        this.add(ChangShengJueEntity.VINDICATOR_WU_XIA.get(), "Kungfu Vindicator");
        this.add(ChangShengJueEntity.PILLAGER_WU_XIA.get(), "Kungfu Pillager");

        this.add(ChangShengJueEntity.STAKES.get(), "Practice stake");
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
        this.add(ChangShengJueEffects.DIZZY_EFFECT.get(), "Dizzy");
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
        this.add(ChangShengJueEffects.DRUNKEN.get(), "Drunken");
        this.add(ChangShengJueEffects.VILLAGER_CHARM_EFFECT.get(), "Continuous Villager Reputation Boost");
        this.add(ChangShengJueEffects.INSTANT_CHARM_EFFECT.get(), "Instant Villager Reputation Boost");
        this.add(ChangShengJueEffects.INSTANT_DISFAVOR_EFFECT.get(), "Instant Villager Reputation Reduction");

        //群系
        this.add("biome."+ ChangShengJue.MOD_ID +".chang_sheng_jue_prairie", "Muran Prairie");

        //存储
        this.add("container.hercules", "Hercules' Might Method");
        this.add("container."+ ChangShengJue.MOD_ID +".cabinet", "Cabinet");
        /*信息*/
        //死亡信息
        this.add("death.attack." + CSJDamageTypes.BLEED.location().getPath(), "%1$s bled to death.");
        this.add("death.attack." + CSJDamageTypes.MARTIAL_ARTS.location().getPath(), "%1$s had their internal organs shattered by %2$s using martial arts.");
        this.add("death.attack." + CSJDamageTypes.TRAUMA.location().getPath(), "%1$s succumbed to severe trauma.");
        //配置文件信息
        this.add("config."+ ChangShengJue.MOD_ID +".reload", "Configuration reloaded");
        this.add("config."+ ChangShengJue.MOD_ID +".enable_quests", "Whether to enable auto-accept type quests.");

        this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_level", "Dugu Nine Swords Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_exp", "Successful Casts Required for Dugu Nine Swords Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".dugu_nine_swords_max_cooldown", "Dugu Nine Swords Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_level", "Gao Marksmanship Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_exp", "Successful Casts Required for Gao Marksmanship Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".gao_marksmanship_max_cooldown", "Gao Marksmanship Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_level", "Ge Shan Da Niu Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_exp", "Successful Casts Required for Ge Shan Da Niu Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".ge_shan_da_niu_max_cooldown", "Ge Shan Da Niu Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_level", "Golden Black Knife Method Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_exp", "Successful Casts Required for Golden Black Knife Method Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_black_knife_method_max_cooldown", "Golden Black Knife Method Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_level", "Shaolin Stick Method Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_exp", "Successful Casts Required for Shaolin Stick Method Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".shaolin_stick_method_max_cooldown", "Shaolin Stick Method Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_level", "Kui Hua Dian Xue Shou Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_exp", "Successful Casts Required for Kui Hua Dian Xue Shou Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".sunflower_point_caveman_max_cooldown", "Kui Hua Dian Xue Shou Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_level", "Turtle Breathing Technique Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_exp", "Successful Casts Required for Turtle Breathing Technique Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".turtle_breath_work_max_cooldown", "Turtle Breathing Technique Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_level", "Xuannu Swordsmanship Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_exp", "Successful Casts Required for Xuannu Swordsmanship Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".xuannu_swordsmanship_max_cooldown", "Xuannu Swordsmanship Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_level", "Relentless Throwing Knives Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_exp", "Successful Casts Required for Relentless Throwing Knives Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".relentless_throwing_knives_max_cooldown", "Relentless Throwing Knives Maximum Cooldown Time");
        this.add("config."+ ChangShengJue.MOD_ID +".flying_dagger_pouch_max_slots", "Maximum Number of Throwing Knives the Throwing Knives Pouch Can Hold");

        this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_level", "Golden Bell Jar Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_exp", "Successful Casts Required for Golden Bell Jar Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".golden_bell_jar_max_cooldown", "Golden Bell Jar Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".hercules_max_exp", "Distance Traveled Required for Hercules Technique Breakthrough");

        this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_level", "Immortal Miracle Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_exp", "Successful Casts Required for Immortal Miracle Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".immortal_miracle_max_cooldown", "Immortal Miracle Maximum Cooldown Time");

        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_level", "Qian Kun Da Nuo Yi Maximum Level Cap");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_exp", "Successful Casts Required for Qian Kun Da Nuo Yi Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_max_cooldown", "Qian Kun Da Nuo Yi Maximum Cooldown Time");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_probability", "Qian Kun Da Nuo Yi Damage Reflection Probability per Trigger");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_extra_probability", "Extra Damage Reflection Probability per Health Point after Qian Kun Da Nuo Yi Mastery");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_multiplier", "Qian Kun Da Nuo Yi Reflected Damage Multiplier");
        this.add("config."+ ChangShengJue.MOD_ID +".qi_kun_da_nuo_yi_bounce_damage_tick", "Time Required for Each Damage Reflection by Qian Kun Da Nuo Yi");
        this.add("config."+ ChangShengJue.MOD_ID +".qian_kun_da_nuo_yi_max_cooldown_extra_tick", "Time Added to Cooldown Recovery per Cast for Qian Kun Da Nuo Yi to Return to Default Cooldown");

        this.add("config."+ ChangShengJue.MOD_ID +".the_classics_of_tendon_changing_max_exp", "Successful Casts Required for Easy tendon meridian Breakthrough");

        this.add("config."+ ChangShengJue.MOD_ID +".paoding_max_exp", "Successful Casts Required for Paoding Jie Niu Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".paoding_additional_drops_count", "Additional Meat Drops when Killing Mobs with Paoding Jie Niu");

        this.add("config."+ ChangShengJue.MOD_ID +".wu_gang_cut_gui_max_exp", "Successful Casts Required for Wu Gang cuts the laurel Breakthrough");

        this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_max_exp", "Successful Casts Required for Yugong Moves the Mountains Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".yugong_moves_mountains_excavation_range", "Excavation Range of Yugong Moves the Mountains");

        this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_max_exp", "Successful Trades Required for Zhang Men Xin Xue Breakthrough");
        this.add("config."+ ChangShengJue.MOD_ID +".zhang_men_xin_xue_extra_probability", "Probability of Trading Without Consuming Items after Zhang Men Xin Xue Mastery");

        this.add("block."+ ChangShengJue.MOD_ID +".fen_jiu.no_wine","There's no wine left!");
        this.add("tooltip."+ ChangShengJue.MOD_ID +".natural_silk", "Obtained by mining mulberry leaves");

        this.add("message.sharpening_stone.sharpened", "§aWeapons polished! This increase:");
        this.add("message.sharpening_stone.total_damage", "§a,current attack power:");
        this.add("message.sharpening_stone.max_damage", "§cThe weapon has been polished to the maximum limit");
        //进度
        // 一级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".begin", "Chang Sheng Jue");
        this.add("advancement." + ChangShengJue.MOD_ID + ".begin.desc", "The vast world is full of wonders");
        // 二级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan", "Food is the Staff of Life");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasmifan.desc", "Man relies on food, iron relies on steel; miss one meal and hunger you'll feel.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions", "Gleaming Silver");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hassilverbullions.desc", "Though silver may tarnish with time, its inner luster remains bright.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword", "The Wanderer's Path");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbronzesword.desc", "A true wanderer fears no power, fights for justice, protects the weak, upholds righteousness, and selflessly serves without regard for personal gain.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage", "A New Life!");
        this.add("advancement." + ChangShengJue.MOD_ID + ".findchinesevillage.desc", "From north to south, the land is as beautiful as a painting!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask", "A Guild?");
        this.add("advancement." + ChangShengJue.MOD_ID + ".accessguildtask.desc", "Watch as I shake the heavens and stir the world!");
        // 三级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee", "The Consort's Smile");
        this.add("advancement." + ChangShengJue.MOD_ID + ".haslichee.desc", "A steed raises red dust, the consort smiles; none know that lychees have arrived.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg", "Home-style Stir-fry");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hastomatoegg.desc", "A common dish anyone can make, yet each cook brings their own unique flavor.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hastea", "A Refreshing Breeze Rises");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hastea.desc", "Since Shennong tasted a hundred herbs and drank tea to detoxify, the history of tea has flowed long and deep.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".haswine", "Sing Facing Wine, How Long Does Life Last?");
        this.add("advancement." + ChangShengJue.MOD_ID + ".haswine.desc", "Like morning dew, gone are many bitter days.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions", "Glistening Gold");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasgoldbullions.desc", "True gold shines, no matter where it's placed!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong", "A Trusty Weapon");
        this.add("advancement." + ChangShengJue.MOD_ID + ".usewaigong.desc", "With a reliable sword in hand, roam the world with ease and grace.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor", "The Humble Wanderer");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasarmor.desc", "Though the armor is simple, let the heart be as steadfast as stone.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa", "First Steps in Training");
        this.add("advancement." + ChangShengJue.MOD_ID + ".learngongfa.desc", "If one slacks off at the first setback, how can they achieve greatness later?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware", "Crafting Chinaware");
        this.add("advancement." + ChangShengJue.MOD_ID + ".makechinaware.desc", "china, china, china!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask", "Who Decides Good and Evil?");
        this.add("advancement." + ChangShengJue.MOD_ID + ".finishtask.desc", "Read more to avoid being deceived. Study history to better distinguish right from wrong.");
        // 四级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu", "Auspicious and Propitious");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasbabaozhu.desc", "Strengthens the spleen, nourishes the stomach, aids digestion, promotes weight loss, boosts energy, and calms the spirit.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou", "Sweet as Honey");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasguihuatangou.desc", "May your life continue sweetly, or may a sweet new chapter unfold.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hassword", "Peerless Divine Weapon");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hassword.desc", "Supreme in the martial world, the treasured blade slays the dragon; none dare disobey when it commands the realm!");

        this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor", "Scion of a Military Line");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasadvancedarrmor.desc", "Though the armor is sturdy, let it not lie buried in dust.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa", "Thoroughly Mastered");
        this.add("advancement." + ChangShengJue.MOD_ID + ".mastergongfa.desc", "Though achievements exist, remember: there is always someone better, and skies beyond the sky.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask", "Always Ready to Help");
        this.add("advancement." + ChangShengJue.MOD_ID + ".donefivetask.desc", "Learn to say no; you can't unclog every toilet.");

        this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken", "The Gang Leader");
        this.add("advancement." + ChangShengJue.MOD_ID + ".agroupgangtoken.desc", "What I carry is not just a street—it's the world! The common people of all under heaven!");

        // 五级进度
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian", "Unfinished Journey");
        this.add("advancement." + ChangShengJue.MOD_ID + ".hasqitian.desc", "Where is the Great Sage, Equal of Heaven? Where lies the path to longevity? Where is the future?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone", "A Grandmaster of the Era");
        this.add("advancement." + ChangShengJue.MOD_ID + ".gongfadone.desc", "Humans have passions and desires; swords do not, martial arts do not. At the pinnacle of the Forbidden City, who dares challenge me?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask", "The Recluse Hero");
        this.add("advancement." + ChangShengJue.MOD_ID + ".donefinaltask.desc", "Since I am a man with passions and desires, how can my heart be content with an unjust world?");

        this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader", "The Top Seat");
        this.add("advancement." + ChangShengJue.MOD_ID + ".beatleader.desc", "This wooden seat is certainly more comfortable than one made of blades—at least it doesn't stab you in the rear.");

        //按钮
        this.add("button."+ ChangShengJue.MOD_ID +".gre_button.tips", "gre");
        this.add("button."+ ChangShengJue.MOD_ID +".red_button.tips", "red");
        this.add("button."+ ChangShengJue.MOD_ID +".black_button.tips", "black");
        this.add("button."+ ChangShengJue.MOD_ID +".blue_button.tips", "blue");
        this.add("button."+ ChangShengJue.MOD_ID +".golden_button.tips", "golden");
        this.add("button."+ ChangShengJue.MOD_ID +".wood_button.tips", "wood");
        this.add("gui."+ ChangShengJue.MOD_ID +".trade.gre", "gre");
        this.add("gui."+ ChangShengJue.MOD_ID +".trade.red", "red");
        this.add("gui."+ ChangShengJue.MOD_ID +".trade.black", "black");
        this.add("gui."+ ChangShengJue.MOD_ID +".trade.blue", "blue");
        this.add("gui."+ ChangShengJue.MOD_ID +".trade.golden", "golden");
        this.add("gui."+ ChangShengJue.MOD_ID +".trade.wood", "wood");

        //任务
        this.add("quest."+ ChangShengJue.MOD_ID +".button", "Quest");
        this.add("quest."+ ChangShengJue.MOD_ID +".requirements", "Requirements:");
        this.add("quest."+ ChangShengJue.MOD_ID +".rewards", "rewards:");
        this.add("quest."+ ChangShengJue.MOD_ID +".submit.button", "Submit Quest");
        this.add("quest."+ ChangShengJue.MOD_ID +".no_submit.button", "No quest available to submit");
        this.add("quest."+ ChangShengJue.MOD_ID +".accept.button", "Accept Quest");
        this.add("quest."+ ChangShengJue.MOD_ID +".abandon.button", "Abandon Quest");
        this.add("quest."+ ChangShengJue.MOD_ID +".no_abandon.button", "Cannot abandon a quest that doesn't exist");
        this.add("quest."+ ChangShengJue.MOD_ID +".requirements.prompt", "Quest requirements not met!");
        this.add("quest."+ ChangShengJue.MOD_ID +".finish", "§a%s quest completed!");
        this.add("quest."+ ChangShengJue.MOD_ID +".trigger", "§a%s quest triggered");
        this.add("quest."+ ChangShengJue.MOD_ID +".fail", "§a%s quest failed!");
        this.add("quest."+ ChangShengJue.MOD_ID +".requires.kill.target", "Requires kills: %s times");
        this.add("quest."+ ChangShengJue.MOD_ID +".current.kill.target", "Current progress: %s/%s");
        this.add("quest." + ChangShengJue.MOD_ID + ".no_quest", "No active quests at the moment!");
        this.add("quest." + ChangShengJue.MOD_ID + ".no_action_quest", "No quests available to accept!");

        this.add("quest."+ ChangShengJue.MOD_ID +".food.questName", "Gather Food");
        this.add("quest."+ ChangShengJue.MOD_ID +".food.questDescription", "Gang Leader: The brothers are running low on provisions again. We can't go on with empty stomachs. Brother, can you find a way to get some food?");

        this.add("quest."+ ChangShengJue.MOD_ID +".money.questName", "Collect Funds");
        this.add("quest."+ ChangShengJue.MOD_ID +".money.questDescription", "Gang Leader: These days everything costs money. Even a hero can be brought down by lack of coin. Brother, can you raise some funds for the gang?");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questName", "Challenge the Dojo");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questDescription", "Gang Leader: Damn it! This is the second time this year someone's come to challenge our dojo while I'm ill. They think our gang has no capable members? Go teach them a lesson!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.gang_leader.questRequirementsDescription", "Defeat any gang leader.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questName", "The Wanderer's Path");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questDescription", "Gang Leader: The ill-omened patrols keep clashing with us, they're asking for trouble! Take them out!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.pillager.questRequirementsDescription", "Kill pillagers.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questName", "Kill the Chicken to Scare the Monkey");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questDescription", "Gang Leader: These troublesome villagers have some nerve! They've rejected our collectors several times. Go give them a warning they won't forget!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villager.questRequirementsDescription", "Kill any villager.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questName", "The Oath of Allegiance");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questDescription", "Gang Leader: Brother, if you wish to join our gang, you must first prove your loyalty with an oath of allegiance!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.arbitrarily.questRequirementsDescription", "Kill any humanoid creature.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questName", "Duel Challenge");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questDescription", "Gang Leader: Some brothers have heard of your martial prowess and wish to test their skills against you. What do you say?");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.challenger.questRequirementsDescription", "Defeat or kill the challenger.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questName", "The World's Best");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_1.questDescription", "Gang Leader: Although the current world's best is the Staff King, Dong Daxia, with your skills you could challenge him for the title!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_2.questDescription", "Gang Leader: Although the current world's best is the Blade Sage, Xu Daxia, with your skills you could challenge him for the title!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_3.questDescription", "Gang Leader: Although the current world's best is the Northern Fist, Xiao Daxia, with your skills you could challenge him for the title!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia_4.questDescription", "Gang Leader: Although the current world's best is the Sword Immortal, Zhang Daxia, with your skills you could challenge him for the title!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.ming_xia.questRequirementsDescription", "Kill one of the Four Great Daxia.");

        this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questName", "Protect the Village");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questDescription", "Gang Leader: A village under our gang's protection is under attack! Hurry and defend our granary!");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.village.questRequirementsDescription", "Achieve victory in the raid.");

        this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questName", "The Healing Hero");
        this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questDescription", "Gang Leader: A nearby village was attacked by zombies, and many villagers have turned into zombie villagers. I heard you have some medical skills, brother. Would you go check it out?");
        this.add("quest."+ ChangShengJue.MOD_ID +".treat.village.questRequirementsDescription", "Cure one zombie villager.");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questName", "Vegetarian Meal");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questDescription", "Gang Leader: With a compassionate heart, refrain from taking life.");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.vegetarian_food.questRequirementsDescription", "Do not kill any creatures for 2 in-game days.");

        this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questName", "Uphold Justice and Chivalry");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questDescription", "A nearby village is being invaded by a horde of zombies. Would you be willing to risk yourself to help?");
        this.add("quest."+ ChangShengJue.MOD_ID +".raid.xing_xia_zhang_yi.questRequirementsDescription", "Remain in the village and assist the villagers in resisting the zombies.");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questName", "The Rural Hero");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questDescription", "Because of you, no one dares to bully the villagers here, and you have also settled down to a peaceful life.");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.village.questRequirementsDescription", "Encounter a villager by chance.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questName", "Swift Vengeance");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questDescription", "If grievances are not clearly repaid, one lives in vain as a true man.");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.mob.questRequirementsDescription", "Kill enemies who attack you.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questName", "Eliminate the Scourge for the People");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questDescription", "This great beast always preys on the villagers. Be careful, hero!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.tiger.questRequirementsDescription", "Kill 1 tiger.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questName", "Suppress Tyrants and Pacify the People");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questDescription", "Village Chief: A villain in the village is plundering everywhere. Great hero, can you help us?!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.villain.questRequirementsDescription", "Kill 1 villain.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questName", "Martial Hero");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questDescription", "Seeing injustice on the road, drawing the sword to help – only this merits the title of a true hero.");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.zombie.questRequirementsDescription", "Kill 1 zombie inside the village at night.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questName", "Kill and Plunder");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questDescription", "Since you flaunt your treasures, don't blame me for being ruthless! Hehehe...");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.wandering_trader.questRequirementsDescription", "Kill 1 Wandering Trader.");

        this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questName", "Large Transaction");
        this.add("quest."+ ChangShengJue.MOD_ID +".gather.food.questDescription", "Village Chief: The recent harvest is poor, and winter will be hard. Great hero, can you help us gather some food to get through this difficult time?");
        this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questName", "Large Transaction");
        this.add("quest."+ ChangShengJue.MOD_ID +".gather.money.questDescription", "Village Chief: This is truly a bumper harvest! But so much grain will spoil if stored too long. Great hero, can you help us find a solution?");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questName", "Roam Freely");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questDescription", "The world is vast; where can it not accommodate a person?");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.death.questRequirementsDescription", "Die less than 1 time in 7 days.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questName", "Crush the Strong and Aid the Weak");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questDescription", "Villagers face not only zombie attacks but also threats from gangs!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.bandit.questRequirementsDescription", "Kill 3 bandits.");

        this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questName", "Jianghu Bounty");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questDescription", "You helped the village resist the gangs. Now major factions have made you a public enemy of the martial world and placed a bounty on you!");
        this.add("quest."+ ChangShengJue.MOD_ID +".kill.assassin.questRequirementsDescription", "Kill those who assault you.");

        this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questName", "Proud Spirit Between Heaven and Earth");
        this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questDescription", "I possess great strength; why use it against the weak? If the world is unjust, I shall rectify it! Even against a hundred, what is there to fear? Face them with wisdom and courage.");
        this.add("quest."+ ChangShengJue.MOD_ID +".ao_qi_tian_di_jian.questRequirementsDescription", "Kill villains and assassins.");

        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questName", "If Heaven Had Feelings, It Too Would Age");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questDescription", "The true path in the human world is fraught with hardship.");
        this.add("quest."+ ChangShengJue.MOD_ID +".automatic.tian_ruo_you_qing.questRequirementsDescription", "Complete the 'Jianghu Bounty' quest twice.");

        //裁衣案"container.tailoring_case.json"
        this.add("container."+ ChangShengJue.MOD_ID +".tailoring_case", "tailoring case");
        this.add("gui."+ ChangShengJue.MOD_ID + ".tailoring_case.craft", "tailoring");
        //锻台“forgeblock”
        this.add("container."+ ChangShengJue.MOD_ID +".forge_block", "forge block");
        this.add("gui."+ ChangShengJue.MOD_ID + ".forge_block.craft", "forge");

        this.add("container."+ ChangShengJue.MOD_ID +".wood_working_bench", "Woodworking Bench");
        this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.craft", "Make");
        this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.all", "All");
        this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.da_mu_zuo", "Major");
        this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.xiao_mu_zuo", "Minor");
        this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.chen_she", "Decor");
        this.add("gui."+ ChangShengJue.MOD_ID + ".wood_working_bench.category.furniture", "Furniture");
        this.add("container."+ ChangShengJue.MOD_ID +".brick_kiln", "Brick Kiln");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.craft", "Fired");

        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.all", "All");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.wa_zuo", "Tile");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.shi_zuo", "Stone");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.za_lei", "Misc");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color", "Color");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.gray", "Gray");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.red", "Red");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.black", "Black");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.gold", "Gold");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.cyan", "Cyan");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.purple", "Purple");
        this.add("gui."+ ChangShengJue.MOD_ID + ".brick_kiln.category.color.blue", "Blue");

        this.add("jei."+ ChangShengJue.MOD_ID +".woodworking_bench.usage", "Craft the item in the woodworking table");
        this.add("jei."+ ChangShengJue.MOD_ID +".tailoring_case.usage", "Craft the item in the tailoring case");
        this.add("jei."+ ChangShengJue.MOD_ID +".forge_block.usage", "Craft the item in the Forge Block");
        this.add("jei."+ ChangShengJue.MOD_ID +".brick_kiln.usage", "Craft the item in the Brick Kiln");

        this.add(ChangShengJue.MOD_ID +".function", "Functional Items");
        this.add(ChangShengJue.MOD_ID +".function.desc", "Many strange people have come from that spatial rift. They can not only dance with fire to create phoenixes and fly through the skies, but they have also brought many peculiar objects. Rumor has it they come from the East?");
        this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots", "Blue and White Porcelain Flower Pot");
        this.add(ChangShengJue.MOD_ID +".function.blue_and_white_porcelain_flower_pots.page1.text", "Functions identically to the vanilla flower pot.");
        this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry", "Brush and Lime Slurry");
        this.add(ChangShengJue.MOD_ID +".function.brush_and_lime_slurry.page1.text", "Hold any Lime Slurry Bucket in the off-hand and the Brush in the main hand to paint entire Red Brick blocks into white walls of the corresponding color scheme. The Lime Slurry Bucket becomes empty after 12 uses.");
        this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds", "Bullion Casting Mold");
        this.add(ChangShengJue.MOD_ID +".function.bullions_casting_molds.page1.text", "Right-click to place the mold on the ground. Hold a [Crucible (Gold/Silver Liquid)] and right-click to pour it in.");
        this.add(ChangShengJue.MOD_ID +".function.casting_molds", "Coin Casting Mold");
        this.add(ChangShengJue.MOD_ID +".function.casting_molds.page1.text", "Used for casting copper coins. Right-click to place the mold on the ground. Hold a [Crucible (Copper Liquid)] and right-click to pour it in.");
        this.add(ChangShengJue.MOD_ID +".function.crucible", "Crucible");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page1.text", "An essential tool for making copper coins and bullions.$(br)Can be combined with 8 Copper/Silver/Gold to create a Crucible (Copper/Silver/Gold Fragments).$(br)[Crucible (Copper/Silver/Gold Fragments)] can be smelted in a furnace to obtain [Crucible (Copper/Silver/Gold Liquid)].");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page3.text", "Crucible (Copper/Silver/Gold Fragments) can be smelted in a furnace to obtain Crucible (Copper/Silver/Gold Liquid).");
        this.add(ChangShengJue.MOD_ID +".function.crucible.page5.text", "Crucible (Copper/Silver/Gold Liquid) can be poured into molds to create: Copper Coins / Gold or Silver Bullions.");
        this.add(ChangShengJue.MOD_ID +".function.ladder", "Ladder");
        this.add(ChangShengJue.MOD_ID +".function.ladder.page1.text", "The ladder is three blocks high and can be extended upward by placing more sections. (If the player is at the edge of a block, placing the ladder forward one block will cause the player to crouch/climb onto it).");
        this.add(ChangShengJue.MOD_ID +".function.painting_scroll", "Painting Scroll");
        this.add(ChangShengJue.MOD_ID +".function.painting_scroll.page1.text", "Comes in four sizes (1x1, 2x1, 1x2, 2x2). Functions like vanilla paintings, with various patterns available.");
        this.add(ChangShengJue.MOD_ID +".function.plaque", "Plaque");
        this.add(ChangShengJue.MOD_ID +".function.plaque.page1.text", "Right-click the plaque to write text on it. Places on the side of a block, functioning like a sign (can be connected left/right to adjust plaque length).");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp", "Stone Lamp");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page1.text", "The Stone Lamp has two states: Lit and Unlit.$(br)Use a Flint and Steel to light it. Serves as a light source with brightness equal to a Candlestick.");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.title", "Stone Lamp Base");
        this.add(ChangShengJue.MOD_ID +".function.stone_lamp.page2.text", "The base for the Stone Lamp. Purely decorative.");
        this.add(ChangShengJue.MOD_ID +".function.zhu_tai", "Candlestick");
        this.add(ChangShengJue.MOD_ID +".function.zhu_tai.page1.text", "Functions like a torch, illuminating a 12-block radius.");

        this.add(ChangShengJue.MOD_ID +".village", "Villages");
        this.add(ChangShengJue.MOD_ID +".village.desc", "Chinese-style villages of all sizes are scattered across the Minecraft continent, bringing many novelties with them...");
        this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom", "Loom");
        this.add(ChangShengJue.MOD_ID +".village.tool.chang_sheng_jue_loom.page1.text", "Usage: Hold $(item)Mulberry Silk$() in the main hand and right-click the loom to weave it into $(item)Silk$().$(br)Yield: 2 Mulberry Silk → 1 Silk");
        this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough", "Livestock Feeding Trough");
        this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page1.text", "Growth Acceleration: $(li)Can place $(item)Wheat$()$(br)Effect: Increases growth speed of nearby animals by 20%.");
        this.add(ChangShengJue.MOD_ID +".village.tool.pig_trough.page2.text", "Livestock Feeding Trough Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel", "Potter's Wheel");
        this.add(ChangShengJue.MOD_ID +".village.tool.pottery_wheel.page1.text", "Interaction: $(li)1 Clay → Craft $(item)Porcelain Cup$()$(li)2 Clay → Craft $(item)Porcelain Bowl$()$(li)3 Clay → Craft $(item)Porcelain Plate$()");
        this.add(ChangShengJue.MOD_ID +".village.tool.tool_table", "Tool Table");
        this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page1.text", "Maintenance: Hold a $(item)Bow$() in the main hand and right-click the Tool Table to quickly repair its durability.");
        this.add(ChangShengJue.MOD_ID +".village.tool.tool_table.page2.text", "Tool Table Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief", "Village Chief");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page1.text", "Right-clicking the Chief has a 50%% chance to trigger the village quest [Suppress Tyrants and Pacify the People]. Completion yields certain rewards.");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.title", "Trades - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.text", "$(br)$(li)1x Silver Bullion → 6x A String of Ancient Coin$(br)$(li)1x Gold Bullion → 6x Silver Bullion$(br)$(li)7x A String of Ancient Coin → 1x Silver Bullion$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.title", "Trades - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.text", "$(br)$(li)1x Diamond → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 2x Candlestick$(br)$(li)7x Silver Bullion → 1x Gold Bullion$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.title", "Trades - Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.text", "$(br)$(li)1x Compass → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 1x Emerald$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.title", "Trades - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.text", "Expert:$(br)$(li)2x Book and Quill → 4x A String of Ancient Coin$(br2)Master:$(br)$(li)1x Silver Bullion → 1x Painting Scroll$(br)$(li)2x Gold Bullion → 1x Emerald$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page2.anchor", "Chief-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page3.anchor", "Chief-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page4.anchor", "Chief-Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.chief.page5.anchor", "Chief-Expert");

        this.add(ChangShengJue.MOD_ID +".village.villager.farmer", "Farmer");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.anchor", "Farmer-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.title", "Trades - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page2.text", "$(br)$(li)20x Corn → 4x A String of Ancient Coin$(br)$(li)20x Sticky Rice → 4x A String of Ancient Coin$(br)$(li)22x Tomato → 4x A String of Ancient Coin$(br)$(li)22x Peanut → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 4x Rice Ball");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.anchor", "Farmer-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.title", "Trades - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page3.text", "$(br)$(li)22x Grape → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 4x Steamed Dishes$(br)$(li)4x A String of Ancient Coin → 4x Qingtuan");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.anchor", "Farmer-Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.title", "Trades - Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page4.text", "$(br)$(li)4x Osmanthus Sugar Lotus Root → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 4x Pork Belly Chicken Soup");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.anchor", "Farmer-Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.title", "Trades - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.farmer.page5.text", "Expert:$(br)$(li) 4x A String of Ancient Coin → 1x Suspicious Stem (1-2 effects from: Night Vision, Blindness, Saturation, Weakness, Jump Boost, Poison)$(br2)Master:$(br)$(li)4x A String of Ancient Coin → 4x Tomato and Egg Stir-fry $(br)$(li)8x A String of Ancient Coin → 8x Minced Meat Eggplant $(br)$(li)8x A String of Ancient Coin → 8x Eight-Treasure Porridge");

        this.add(ChangShengJue.MOD_ID +".village.villager.hunter", "Hunter");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.anchor", "Hunter-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.title", "Trades - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page2.text", "$(br)$(li)14x Raw Chicken → 4x A String of Ancient Coin$(br)$(li)4x Raw Rabbit → 4x A String of Ancient Coin$(br)$(li)7x Raw Porkchop → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 1x Peacock Eggs$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.anchor", "Hunter-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.title", "Trades - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page3.text", "$(br)$(li)7x Raw Mutton → 4x A String of Ancient Coin$(br)$(li)4x A String of Ancient Coin → 5x Cooked Venison$(br)$(li)4x A String of Ancient Coin → 1x Deer Blood$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.anchor", "Hunter-Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.title", "Trades - Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page4.text", "$(br)$(li)7x Raw Venison → 4x A String of Ancient Coin$(br)$(li)10x Raw Beef → 4x A String of Ancient Coin$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.anchor", "Hunter-Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.title", "Trades - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.hunter.page5.text", "Expert:$(br)$(li)7x Deer Antler → 14x A String of Ancient Coin$(br2)Master:$(br)$(li)5x Tiger Skin → 15x A String of Ancient Coin");

        this.add(ChangShengJue.MOD_ID +".village.villager.potter", "Potter");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.anchor", "Potter-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.title", "Trades - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page2.text", "$(br)$(li)8x A String of Ancient Coin → 32x Cyan Stone Bricks$(br)$(li)8x A String of Ancient Coin → 32x Cyan Stone Fine Bricks$(br)$(li)8x A String of Ancient Coin → 32x Cyan Stone Bricks Stairs$(br)$(li)8x A String of Ancient Coin → 32x Cyan Stone Slab$(br)$(li)8x A String of Ancient Coin → 32x Cyan Stone Vertical Walls$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.anchor", "Potter-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.title", "Trades - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page3.text", "$(br)$(li)8x A String of Ancient Coin → 32x Cyan Stone Floor Tiles$(br)$(li)8x A String of Ancient Coin → 32x Black Stone Floor Tiles$(br)$(li)8x A String of Ancient Coin → 32x Bitumen Floor Tiles$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.anchor", "Potter-Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.title", "Trades - Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page4.text", "$(br)$(li)4x A String of Ancient Coin → 8x Porcelain Bowl$(br)$(li)4x A String of Ancient Coin → 8x Porcelain Cup$(br)$(li)4x A String of Ancient Coin → 4x Wine Jar$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.anchor", "Potter-Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.title", "Trades - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.potter.page5.text", "Expert:$(br)$(li)4x A String of Ancient Coin → 1x Blue and White Porcelain Flower Pot$(br2)Master:$(br)$(li)4x A String of Ancient Coin → 1x Yellow Stone Lion$(br)$(li)4x A String of Ancient Coin → 1x Gray Stone Lion$(br2)");

        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress", "Seamstress");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.anchor", "Seamstress-Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.title", "Trades - Novice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page2.text", "$(br)$(li)6x Silk Thread → 4x A String of Ancient Coin$(br)$(li)22x Cotton → 4x A String of Ancient Coin$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.anchor", "Seamstress-Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.title", "Trades - Apprentice");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page3.text", "$(br)$(li)4x A String of Ancient Coin → 4x Silk$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.anchor", "Seamstress-Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.title", "Trades - Journeyman");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page4.text", "$(br)$(li)28x A String of Ancient Coin → 1x Taoist Parcel$(br)$(li)28x A String of Ancient Coin → 1x Taoist robe Parcel$(br2)");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.anchor", "Seamstress-Expert");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.title", "Trades - Expert & Master");
        this.add(ChangShengJue.MOD_ID +".village.villager.seamstress.page5.text", "Expert:$(br)$(li)6x Silver Bullion → 1x Kirin supplementary clothing Parcel$(br)$(li)6x Silver Bullion → 1x Huiyi Parcel$(br)$(li)6x Silver Bullion → 1x Wanderer's Garb Bundle$(br)$(li)6x Silver Bullion → 1x Scholar's Robe Bundle$(br2)Master:$(br)$(li)8x Silver Bullion → 1x Golden Cotton armor Parcel$(br2)");

        this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle", "Sandstone Castle");
        this.add(ChangShengJue.MOD_ID +".village.villages.sandstone_castle.page1.text", "Often generates in desert biomes. A fortress-style village built from sandstone, well-stocked and resistant to raids, like a pearl in the desert. Common crops: Cotton, Tomato, Grapes, Cantaloupe.");
        this.add(ChangShengJue.MOD_ID +".village.villages.courtyard", "Courtyard House (Siheyuan)");
        this.add(ChangShengJue.MOD_ID +".village.villages.courtyard.page1.text", "Often generates in plains biomes. A courtyard surrounded by buildings on all four sides, hence the name 'Siheyuan'. Common crops: Sorghum, Corn, Wheat, Soybean, Grain.");
        this.add(ChangShengJue.MOD_ID +".village.villages.huizhou", "Huizhou-style Village");
        this.add(ChangShengJue.MOD_ID +".village.villages.huizhou.page1.text", "Often generates in forest biomes. Huizhou民居 (Mínjū) are famous for their white walls, black tiles, and horse-head gables. Look at the exquisite carved doors and windows! Common crops: Lotus Root, Peanut, Brinjal, Pear.");
        this.add(ChangShengJue.MOD_ID +".village.villages.suzhou", "Suzhou-style Village");
        this.add(ChangShengJue.MOD_ID +".village.villages.suzhou.page1.text", "Often generates in jungle biomes. The simple yet elegant style with white walls and black tiles, combined with upward-curving roof ridges, is an artistic model of Suzhou architecture. Common crops: Lychee, Banana, Durian, Rice.");
        this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling", "Cave Dwelling (Yaodong)");
        this.add(ChangShengJue.MOD_ID +".village.villages.cave_dwelling.page1.text", "Often generates in plateau/mesa biomes. Constructed by excavating into the earth, providing warmth in winter and coolness in summer—a unique architectural form. Common crops: Sugar Cane, Jalapenos, Mango, Pineapple.");

        this.add(ChangShengJue.MOD_ID +".xiake", "Xia (Chivalrous Hero)");
        this.add(ChangShengJue.MOD_ID +".xiake.desc", "Somehow, the situation here has changed. More people claiming to uphold justice have appeared, often calling themselves 'Xia' or 'Xiake' (Chivalrous Heroes).");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment", "Armor");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page1.text", "Wuxia equipment not only provides Armor Toughness and/or Armor points like vanilla gear but can also reduce external (Wai Gong) damage taken. Equipment can be crafted or purchased from blacksmiths in new towns using currency. Most armor supports color customization for appearance—try it!$(br)The first time you craft or use a ChangShengJue chestpiece, it will generate random attributes for mitigating external damage and reducing the chance of receiving Trauma (Wai Shang).");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.title", "Inner Armor (Nei Jia)");
        this.add(ChangShengJue.MOD_ID +".xiake.equipment.page2.text", "Inner Armor can be worn underneath a ChangShengJue chestpiece, increasing its Armor points or toughness.$(br)Two ways to equip it: 1. Wear the Inner Armor first, then put on the desired chestpiece. 2. Hold the Inner Armor in the off-hand, the chestpiece in the main hand, and press SHIFT + Right-Click.$(br)Inner Armor can also be worn alone like a regular chestpiece.$(br)");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury", "Internal Injury (Nei Shang)");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page1.text", "Effects per stack: +5%% damage taken, -5%% effectiveness of worn armor, 5%% chance per second to be stunned. Duration: 15 seconds. Empty-hand attacks on a target already affected add 1 stack and extend duration by 2 seconds. Max 5 stacks; effects double per level.");
        this.add(ChangShengJue.MOD_ID +".xiake.internal_injury.page2.text", "When an empty-hand external skill (Wai Gong) is active: Empty-hand attacks inflict Level 1 Internal Injury; using an empty-hand Wai Gong attack inflicts Level 2.$(br)Holding Golden Thread Gloves in the main hand counts as an empty-hand attack.");

        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual", "Martial Arts Manual");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page1.text", "Can be obtained as rewards for completing Gang or Village quests, or rarely dropped by martial NPCs.");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page2.text", "Manuals are categorized: External Skills (Wai Gong, mainly active), Internal Skills (Nei Gong, mainly passive), Lightness Skills (Qing Gong, affecting movement), and Heart Methods (Xin Fa, providing special bonuses). Descriptions explain effects. Right-click to learn how to comprehend and execute the skill.");
        this.add(ChangShengJue.MOD_ID +".xiake.martial_arts_manual.page3.text", "After learning Sword Wai Gong: Sword attacks have 15%% chance to cause Bleeding (1 HP/0.5s for 1s). Blade Wai Gong: 15%% chance for Critical Hit (+15%% damage). Staff Wai Gong: 15%% chance to Stun (0.5s). Spear Wai Gong: 15%% chance to Launch target (0.7s).");

        this.add(ChangShengJue.MOD_ID +".xiake.trauma", "External Injury (Wai Shang)");
        this.add(ChangShengJue.MOD_ID +".xiake.trauma.page1.text", "Effects per stack: -5%% damage dealt, -5%% speed, 1%% HP drain per second. Duration: 7 seconds. Weapon attacks on an affected target extend duration by 1 second (a stronger level overwrites previous). Max 5 stacks; effects double per level.");
        this.add(ChangShengJue.MOD_ID +".xiake.trauma.page2.text", "When a weapon-based Wai Gong is active: Weapon attacks have 25%% chance to inflict Level 1-2 Trauma; using the (weapon) Wai Gong attack guarantees Level 1-5 Trauma.");

        this.add(ChangShengJue.MOD_ID +".xiake.stakes", "Practice stake");
        this.add(ChangShengJue.MOD_ID +".xiake.stakes.page1.text", "Practice stake Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".xiake.stakes.page2.text", "Internal Skills (Nei Gong), Lightness Skills (Qing Gong), and empty-hand External Skills (Wai Gong) can be practiced/comprehended by hitting the stake. 15%% comprehension chance per hit.");

        this.add(ChangShengJue.MOD_ID +".function.tailoring_case", "Tailoring Bench");
        this.add(ChangShengJue.MOD_ID +".function.tailoring_case.page1.text", "Tailoring Bench Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".function.tailoring_case.page2.text", "Used for crafting clothing (armor). View selected items within the bench interface. Crafting automatically consumes required materials from your inventory.");

        this.add(ChangShengJue.MOD_ID +".function.wood_working_bench", "Wood Working Bench");
        this.add(ChangShengJue.MOD_ID +".function.wood_working_bench.page1.text", "Wood Working Bench Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".function.wood_working_bench.page2.text", "It is used to quickly craft various furniture and wooden building components, which can be made in batches (click the icon next to the number to increase or decrease the number of productions, the maximum number is 64), and the corresponding materials will be automatically deducted from the backpack.");

        this.add(ChangShengJue.MOD_ID +".function.forge_block", "Forge furnace");
        this.add(ChangShengJue.MOD_ID +".function.forge_block.page1.text", "Forge furnace Crafting Recipe");
        this.add(ChangShengJue.MOD_ID +".function.forge_block.page2.text", "Used for crafting weapons, armor, etc. View selected items within the forge interface. Crafting automatically consumes required materials from your inventory.");

        this.add(ChangShengJue.MOD_ID +".function.sharpening_stone", "Sharpening Stone");
        this.add(ChangShengJue.MOD_ID +".function.sharpening_stone.page1.text", "You can strengthen your weapons with whetstones, with cobblestone whetstones increasing weapon damage by up to 6 points, diamond whetstones up to 8 points, and netherite whetstones increasing up to 10 points. Note! The durability consumption of the weapon after grinding will also be increased accordingly.");

        this.add(ChangShengJue.MOD_ID +".xiake.quest", "Quests");
        this.add(ChangShengJue.MOD_ID +".xiake.quest.page1.text", "Right-click a Gang Leader to accept gang quests from the quest interface. Completing them rewards Gang Tokens, Martial Arts Manuals, currency, etc. Other quests may trigger automatically during gameplay (most are auto-accepted and completed upon meeting conditions), rewarding martial arts secrets, currency, etc.");

        this.add(ChangShengJue.MOD_ID +".xiake.tea", "Tea");
        this.add(ChangShengJue.MOD_ID +".xiake.tea.page1.text", "Drinking tea helps you recover Health or Saturation faster. Check the tea's description for specific effects.");

        this.add(ChangShengJue.MOD_ID +".xiake.weapon", "Weapons");
        this.add(ChangShengJue.MOD_ID +".xiake.weapon.page1.text", "Some External Skills require specific weapons to perform. You can craft weapons or exchange Gang Tokens for them at gang bases. Completing gang quests unlocks access to peerless weapons.");

        this.add(ChangShengJue.MOD_ID +".xiake.wine", "Wine");
        this.add(ChangShengJue.MOD_ID +".xiake.wine.page1.text", "Drinking wine can reduce skill cooldowns, decrease hunger cost for skills, increase skill damage, etc. Check the wine's description for details. Don't overindulge—you might get drunk!");

        this.add(ChangShengJue.MOD_ID +".thanks", "Thanks");
        this.add(ChangShengJue.MOD_ID +".thanks.long_yuan_sword", "Special thanks to Peng_Fan for your help during the mod test!");
        this.add(ChangShengJue.MOD_ID +".thanks.desc", "This is not only our creation, but also the time we spend with you. Thank you from the bottom of my heart. $(br2) Acknowledgment List: $(br)ID: Peng_Fan");
        this.add(ChangShengJue.MOD_ID +".thanks.long_yuan_sword.name", "Long Yuan Sword");

        this.add(ChangShengJue.MOD_ID +".wufanglu", "Compendium of the Five Realms");
        this.add(ChangShengJue.MOD_ID +".wufanglu.desc", "\"If Heaven had feelings, Heaven too would grow old; The rightful path on earth is full of strife and change.\"$(br)How can one seek longevity without knowledge? Understand heaven and earth, comprehend all things.");
        this.add(ChangShengJue.MOD_ID +".wufanglu.desc2", "ChangShengJue Encyclopedia");
    }
}
