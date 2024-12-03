package com.shengchanshe.changshengjue.item;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.BlueCottonArmor;
import com.shengchanshe.changshengjue.item.combat.armor.cotton.RedCottonArmor;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.taoistrobes.MaleTaoistRobes;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.ChineseWeddingDress;
import com.shengchanshe.changshengjue.item.combat.armor.wedding.RedDress;
import com.shengchanshe.changshengjue.item.combat.book.*;
import com.shengchanshe.changshengjue.item.combat.clubbed.BeatDogStick;
import com.shengchanshe.changshengjue.item.combat.clubbed.PanHuaGun;
import com.shengchanshe.changshengjue.item.combat.feidao.FeiDao;
import com.shengchanshe.changshengjue.item.combat.knife.HengDao;
import com.shengchanshe.changshengjue.item.combat.knife.KitchenKnife;
import com.shengchanshe.changshengjue.item.combat.knife.LargeKnife;
import com.shengchanshe.changshengjue.item.combat.knife.TuLongDao;
import com.shengchanshe.changshengjue.item.combat.lance.BaWangQiang;
import com.shengchanshe.changshengjue.item.combat.lance.RedTasselledSpear;
import com.shengchanshe.changshengjue.item.combat.stakes.Stakes;
import com.shengchanshe.changshengjue.item.combat.sword.BronzeSword;
import com.shengchanshe.changshengjue.item.combat.sword.HanJian;
import com.shengchanshe.changshengjue.item.combat.sword.SoftSword;
import com.shengchanshe.changshengjue.item.combat.sword.YiTianJian;
import com.shengchanshe.changshengjue.item.combat.tiers.ChangShengJueArmorMaterials;
import com.shengchanshe.changshengjue.item.foods.*;
import com.shengchanshe.changshengjue.item.items.Crucible;
import com.shengchanshe.changshengjue.item.items.LimeSlurryBarrels;
import com.shengchanshe.changshengjue.item.items.PaintBrush;
import com.shengchanshe.changshengjue.item.items.PeacockEggItem;
import net.minecraft.core.Direction;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ChangShengJue.MOD_ID);


    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.PINEAPPLE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.TOMATO_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> GU_SEEDS = ITEMS.register("gu_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.GU_ZI_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> SORGHUM_SEEDS = ITEMS.register("sorghum_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.SORGHUM_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> LOTUS_SEEDS = ITEMS.register("lotus_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.LOTUS_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> COTTON_SEEDS = ITEMS.register("cotton_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.COTTON_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> STICKYRICE_SEEDS = ITEMS.register("stickyrice_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.STICKYRICE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_SEEDS = ITEMS.register("corn_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.CORN_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> JALAPENOS_SEEDS = ITEMS.register("jalapenos_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.JALAPENOS_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEANUT_SEEDS = ITEMS.register("peanut_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.PEANUT_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> BRINJAL_SEEDS = ITEMS.register("brinjal_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.BRINJAL_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANTALOUPE_SEEDS = ITEMS.register("cantaloupe_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.CANTALOUPE_STEM.get(), new Item.Properties()));
    public static final RegistryObject<Item> GRAPE_SEEDS = ITEMS.register("grape_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.GRAPE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.RICE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BILUOCHUN_TEA_SEEDS = ITEMS.register("biluochun_tea_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.BILUOCHUN_TEA.get(), new Item.Properties()));
    public static final RegistryObject<Item> LONG_JING_TEA_SEEDS = ITEMS.register("long_jing_tea_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.LONG_JING_TEA.get(), new Item.Properties()));
    public static final RegistryObject<Item> HORDEUM_SEEDS = ITEMS.register("hordeum_seeds",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.HORDEUM.get(), new Item.Properties()));

    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PINEAPPLE)));
    public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.SOYBEAN_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.TOMATO)));
    public static final RegistryObject<Item> SORGHUM = ITEMS.register("sorghum",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GU_SUI = ITEMS.register("gu_sui",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LOTUS = ITEMS.register("lotus",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LOTUS_ROOT = ITEMS.register("lotus_root",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REDBEAN = ITEMS.register("redbean",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.REDBEAN_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> COTTON = ITEMS.register("cotton",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STICKYRICE = ITEMS.register("stickyrice",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STICKYRICE_1 = ITEMS.register("stickyrice_1",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.CORN)));
    public static final RegistryObject<Item> JALAPENOS = ITEMS.register("jalapenos",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.MANGO)));
    public static final RegistryObject<Item> GUI_HUA = ITEMS.register("gui_hua",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.GUI_HUA)));
    public static final RegistryObject<Item> MEI_HUA = ITEMS.register("mei_hua",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAPSULE = ITEMS.register("capsule",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.CAPSULE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANTALOUPE = ITEMS.register("cantaloupe",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.CANTALOUPE)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.BANANA)));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PEAR)));
    public static final RegistryObject<Item> LICHEE = ITEMS.register("lichee",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.LICHEE)));
    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.GRAPE)));
    public static final RegistryObject<Item> DURIAN = ITEMS.register("durian",
            ()-> new DurianItem(new Item.Properties()));
    public static final RegistryObject<Item> OPEN_DURIAN = ITEMS.register("durian_open",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.OPEN_DURIAN)));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BILUOCHUN_TEA = ITEMS.register("biluochun_tea",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LONG_JING_TEA = ITEMS.register("long_jing_tea",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HORDEUM = ITEMS.register("hordeum",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PEANUT)));
    public static final RegistryObject<Item> BRINJAL = ITEMS.register("brinjal",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.BRINJAL)));

    public static final RegistryObject<Item> CAPSULE_JIAO_ZI = ITEMS.register("capsule_jiao_zi",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.CAPSULE_JIAO_ZI)));
    public static final RegistryObject<Item> ZHENG_CAI = ITEMS.register("zheng_cai",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.ZHENG_CAI)));
    public static final RegistryObject<Item> PORTULACA_OLERACEA_CAKE = ITEMS.register("portulaca_oleracea_cake",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PORTULACA_OLERACEA_CAKE)));
    public static final RegistryObject<Item> QING_TUAN = ITEMS.register("qing_tuan",
            ()-> new PorcelainBowlsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.QING_TUAN)));
    public static final RegistryObject<Item> BAKED_CORN = ITEMS.register("baked_corn",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.BAKED_CORN)));
    public static final RegistryObject<Item> TOMATO_EGG = ITEMS.register("tomato_egg",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.TOMATO_EGG)));
    public static final RegistryObject<Item> GU_LAO_ROU = ITEMS.register("gu_lao_rou",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.GU_LAO_ROU)));
    public static final RegistryObject<Item> MEAT_FOAM_BRINJAL = ITEMS.register("meat_foam_brinjal",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.MEAT_FOAM_BRINJAL)));
    public static final RegistryObject<Item> SORGHUM_CAKE = ITEMS.register("sorghum_cake",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.SORGHUM_CAKE)));
    public static final RegistryObject<Item> STINKY_TOFU = ITEMS.register("stinky_tofu",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.STINKY_TOFU)));
    public static final RegistryObject<Item> ZHU_DU_JI = ITEMS.register("zhu_du_ji",
            ()-> new PorcelainBowlsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.ZHU_DU_JI)));
    public static final RegistryObject<Item> XIAO_MI_FAN = ITEMS.register("xiao_mi_fan",
            ()-> new PorcelainBowlsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.XIAO_MI_FAN)));
    public static final RegistryObject<Item> MI_FAN = ITEMS.register("mi_fan",
            ()-> new PorcelainBowlsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.MI_FAN)));
    public static final RegistryObject<Item> GUI_HUA_TANG_OU = ITEMS.register("gui_hua_tang_ou",
            ()-> new PorcelainPlatesFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.GUI_HUA_TANG_OU)));
    public static final RegistryObject<Item> BA_BAO_ZHOU = ITEMS.register("ba_bao_zhou",
            ()-> new PorcelainBowlsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.BA_BAO_ZHOU)));

    public static final RegistryObject<Item> MULBERRY_JUICE = ITEMS.register("mulberry_juice",
            ()-> new PorcelainCupsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.MULBERRY_JUICE)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            ()-> new PorcelainCupsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.APPLE_JUICE)));
    public static final RegistryObject<Item> HOT_PEAR_SOUP = ITEMS.register("hot_pear_soup",
            ()-> new PorcelainCupsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.HOT_PEAR_SOUP)));
    public static final RegistryObject<Item> GRAPE_JUICE = ITEMS.register("grape_juice",
            ()-> new PorcelainCupsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.GRAPE_JUICE)));

    public static final RegistryObject<Item> BILUOCHUN_TEAS = ITEMS.register("biluochun_teas",
            ()-> new PorcelainCupsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.BILUOCHUN_TEA)));
    public static final RegistryObject<Item> LONG_JING_TEAS = ITEMS.register("long_jing_teas",
            ()-> new PorcelainCupsFoodItem(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.LONG_JING_TEA)));
    public static final RegistryObject<Item> FEN_JIU = ITEMS.register("fen_jiu",
            ()-> new Item(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.FEN_JIU)));
    public static final RegistryObject<Item> WHEAT_NUGGETS_TRIBUTE_WINE = ITEMS.register("wheat_nuggets_tribute_wine",
            ()-> new Item(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.WHEAT_NUGGETS_TRIBUTE_WINE)));
    public static final RegistryObject<Item> SHI_LI_XIANG = ITEMS.register("shi_li_xiang",
            ()-> new Item(new Item.Properties().stacksTo(1).food(ChangShengJueFoods.SHI_LI_XIANG)));

    //刷怪蛋
    public static final RegistryObject<Item> BUTTERFLY_EGG = ITEMS.register("butterfly_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.BUTTERFLY_ENTITY,0xADFF2F,0x000000,
                    new Item.Properties()));
    public static final RegistryObject<Item> MONKEY_EGG = ITEMS.register("monkey_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.MONKEY_ENTITY,0x785925,0x272625,
                    new Item.Properties()));
    public static final RegistryObject<Item> DRAGONFLY_EGG = ITEMS.register("dragonfly_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.DRAGONFLY_ENTITY,0x228B22,0x008000,
                    new Item.Properties()));
    public static final RegistryObject<Item> CICADA_EGG = ITEMS.register("cicada_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CICADA_ENTITY,0x000000,0xADFF2F,
                    new Item.Properties()));
    public static final RegistryObject<Item> CRANE_EGG = ITEMS.register("crane_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CRANE_ENTITY,0xC0C0C0,0xFFFFFF,
                    new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_EGG = ITEMS.register("peacock_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.MALE_PEACOCK_ENTITY,0x0000FF,0xD3D3D3,
                    new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_EGG_1 = ITEMS.register("peacock_egg_1",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY,0x0000FF,0xD3D3D3,
                    new Item.Properties()));
    public static final RegistryObject<Item> STAG_EGG = ITEMS.register("stag_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.STAG_ENTITY,0x8B4513,0x228B22,
                    new Item.Properties()));
    public static final RegistryObject<Item> HIND_EGG = ITEMS.register("hind_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.HIND_ENTITY,0x8B4513,0x228B22,
                    new Item.Properties()));
    public static final RegistryObject<Item> TIGER_EGG = ITEMS.register("tiger_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.TIGER_ENTITY,0xFF8C00,0x000000,
                    new Item.Properties()));
    public static final RegistryObject<Item> CROC_EGG = ITEMS.register("croc_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CROC_ENTITY,0x808000,0x006400,
                    new Item.Properties()));

    public static final RegistryObject<Item> CHANG_SHENG_JUE_VILLAGER_EGG = ITEMS.register("chang_sheng_jue_villager_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER,5651507,12422002,
                    new Item.Properties()));

    public static final RegistryObject<Item> ZHU_TAI = ITEMS.register("zhu_tai",
            ()-> new StandingAndWallBlockItem(ChangShengJueBlocks.ZHU_TAI_BLOCK.get(),ChangShengJueBlocks.WALL_ZHU_TAI_BLOCK.get(), (new Item.Properties()), Direction.DOWN));

    public static final RegistryObject<Item> CRANE_FEATHERS = ITEMS.register("crane_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_FEATHERS = ITEMS.register("peacock_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHITE_PEACOCK_FEATHERS = ITEMS.register("white_peacock_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_EGGS = ITEMS.register("peacock_eggs",
            ()-> new PeacockEggItem((new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> DEERSKIN = ITEMS.register("deerskin",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANTLER = ITEMS.register("antler",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEER_BLOOD = ITEMS.register("deer_blood",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VENISON = ITEMS.register("venison",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.VENISON)));
    public static final RegistryObject<Item> COOKED_VENISON = ITEMS.register("cooked_venison",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.COOKED_VENISON)));
    public static final RegistryObject<Item> TIGER_SKIN = ITEMS.register("tiger_skin",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CROC_SKIN = ITEMS.register("croc_skin",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CI_PAN = ITEMS.register("ci_pan",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CI_WAN = ITEMS.register("ci_wan",
            ()-> new BowlFoodItem(new Item.Properties()));
    public static final RegistryObject<Item> CI_BEI = ITEMS.register("ci_bei",
            ()-> new BowlFoodItem(new Item.Properties()));

    public static final RegistryObject<Item> TONG_QIAN = ITEMS.register("tong_qian",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YI_GUAN_TONG_QIAN = ITEMS.register("yi_guan_tong_qian",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_BULLIONS = ITEMS.register("silver_bullions",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_BULLIONS = ITEMS.register("gold_bullions",
            ()-> new Item(new Item.Properties()));

    //石灰
    public static final RegistryObject<Item> QUICKLIME = ITEMS.register("quicklime",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIME_SLURRY_BARRELS = ITEMS.register("lime_slurry_barrels", ()-> new LimeSlurryBarrels());
    public static final RegistryObject<Item> WARM_LIME_SLURRY_BARRELS = ITEMS.register("warm_lime_slurry_barrels", ()-> new LimeSlurryBarrels());
    public static final RegistryObject<Item> COOL_LIME_SLURRY_BARRELS = ITEMS.register("cool_lime_slurry_barrels", ()-> new LimeSlurryBarrels());

    //刷子
    public static final RegistryObject<Item> PAINT_BRUSH = ITEMS.register("paint_brush", ()-> new PaintBrush());

    //蚕丝
    public static final RegistryObject<Item> NATURAL_SILK = ITEMS.register("natural_silk",
            ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SILK = ITEMS.register("silk",
            ()-> new Item(new Item.Properties()));

    //桑葚
    public static final RegistryObject<Item> MULBERRY = ITEMS.register("mulberry",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.MULBERRY)));

    //茅草
    public static final RegistryObject<Item> THATCH = ITEMS.register("thatch",
            ()-> new Item(new Item.Properties()));

    //矿石
    public static final RegistryObject<Item> RAW_AG = ITEMS.register("raw_ag",
            ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> AG_INGOT = ITEMS.register("ag_ingot",
            ()-> new Item((new Item.Properties())));
    //砖
    public static final RegistryObject<Item> BLACK_BRICKS = ITEMS.register("black_bricks",
            ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> WHITE_BRICKS_ITEM = ITEMS.register("white_bricks_item",
            ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> GOLD_BRICKS = ITEMS.register("gold_bricks",
            ()-> new Item((new Item.Properties())));

    //战斗
    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword",
            ()-> new BronzeSword());
    public static final RegistryObject<Item> HAN_JIAN = ITEMS.register("han_jian",
            ()-> new HanJian());
    public static final RegistryObject<Item> HENG_DAO = ITEMS.register("heng_dao",
            ()-> new HengDao());
    public static final RegistryObject<Item> LARGE_KNIFE = ITEMS.register("large_knife",
            ()-> new LargeKnife());
    public static final RegistryObject<Item> RED_TASSELLED_SPEAR = ITEMS.register("red_tasselled_spear",
            ()-> new RedTasselledSpear());
    public static final RegistryObject<Item> SOFT_SWORD = ITEMS.register("soft_sword",
            ()-> new SoftSword());
    public static final RegistryObject<Item> PAN_HUA_GUN = ITEMS.register("pan_hua_gun",
            ()-> new PanHuaGun());
    public static final RegistryObject<Item> KITCHEN_KNIFE = ITEMS.register("kitchen_knife",
            ()-> new KitchenKnife());
    public static final RegistryObject<Item> FEI_DAO = ITEMS.register("fei_dao",
            ()-> new FeiDao());
    //蓝边棉甲
    public static final RegistryObject<Item> BLUE_COTTON_ARMOR_HELMET = ITEMS.register("blue_cotton_armor_helmet",
            ()-> new BlueCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> BLUE_COTTON_ARMOR_CHESTPLATE = ITEMS.register("blue_cotton_armor_chestplate",
            ()-> new BlueCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> BLUE_COTTON_ARMOR_LEGGINGS = ITEMS.register("blue_cotton_armor_leggings",
            ()-> new BlueCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COTTON_ARMOR_BOOTS = ITEMS.register("cotton_armor_boots",
            ()-> new BlueCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.BOOTS,new Item.Properties()));
    //红边棉甲
    public static final RegistryObject<Item> RED_COTTON_ARMOR_HELMET = ITEMS.register("red_cotton_armor_helmet",
            ()-> new RedCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> RED_COTTON_ARMOR_CHESTPLATE = ITEMS.register("red_cotton_armor_chestplate",
            ()-> new RedCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> RED_COTTON_ARMOR_LEGGINGS = ITEMS.register("red_cotton_armor_leggings",
            ()-> new RedCottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    //道袍
    public static final RegistryObject<Item> FEMALE_TAOIST_ROBES_HELMET = ITEMS.register("female_taoist_robes_helmet",
            ()-> new FemaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> FEMALE_TAOIST_ROBES_CHESTPLATE = ITEMS.register("female_taoist_robes_chestplate",
            ()-> new FemaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> FEMALE_TAOIST_ROBES_LEGGINGS = ITEMS.register("female_taoist_robes_leggings",
            ()-> new FemaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> FEMALE_TAOIST_ROBES_BOOTS = ITEMS.register("female_taoist_robes_boots",
            ()-> new FemaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> MALE_TAOIST_ROBES_HELMET = ITEMS.register("male_taoist_robes_helmet",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> MALE_TAOIST_ROBES_CHESTPLATE = ITEMS.register("male_taoist_robes_chestplate",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> MALE_TAOIST_ROBES_LEGGINGS = ITEMS.register("male_taoist_robes_leggings",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> MALE_TAOIST_ROBES_BOOTS = ITEMS.register("male_taoist_robes_boots",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.BOOTS,new Item.Properties()));
    //婚服
    public static final RegistryObject<Item> CHINESE_WEDDING_DRESS_HELMET = ITEMS.register("chinese_wedding_dress_helmet",
            ()-> new ChineseWeddingDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> CHINESE_WEDDING_DRESS_CHESTPLATE = ITEMS.register("chinese_wedding_dress_chestplate",
            ()-> new ChineseWeddingDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> CHINESE_WEDDING_DRESS_LEGGINGS = ITEMS.register("chinese_wedding_dress_leggings",
            ()-> new ChineseWeddingDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> CHINESE_WEDDING_DRESS_BOOTS = ITEMS.register("chinese_wedding_dress_boots",
            ()-> new ChineseWeddingDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> RED_DRESS_HELMET = ITEMS.register("red_dress_helmet",
            ()-> new RedDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> RED_DRESS_CHESTPLATE = ITEMS.register("red_dress_chestplate",
            ()-> new RedDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> RED_DRESS_LEGGINGS = ITEMS.register("red_dress_leggings",
            ()-> new RedDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> RED_DRESS_BOOTS = ITEMS.register("red_dress_boots",
            ()-> new RedDress(ChangShengJueArmorMaterials.SILK_1,ArmorItem.Type.BOOTS,new Item.Properties()));
    //打狗棒
    public static final RegistryObject<Item> BEAT_DOG_STICK = ITEMS.register("beat_dog_stick",
            ()-> new BeatDogStick());
    //倚天剑
    public static final RegistryObject<Item> YI_TINA_JIAN = ITEMS.register("yi_tina_jian",
            ()-> new YiTianJian());
    //屠龙刀
    public static final RegistryObject<Item> TU_LONG_DAO = ITEMS.register("tu_long_dao",
            ()-> new TuLongDao());
    //霸王枪
    public static final RegistryObject<Item> BA_WANG_QIANG = ITEMS.register("ba_wang_qiang",
            ()-> new BaWangQiang());

    //武功秘籍
    //不死神功
    public static final RegistryObject<Item> IMMORTAL_MIRACLE = ITEMS.register("immortal_miracle",
            ()-> new ImmortalMiracle());
    //大力神功
    public static final RegistryObject<Item> HERCULES = ITEMS.register("hercules",
            ()-> new Hercules());
    //独孤九剑
    public static final RegistryObject<Item> DUGU_NINE_SWORDS = ITEMS.register("dugu_nine_swords",
            ()-> new DuguNineSwordsBook());
    //独孤九剑
    public static final RegistryObject<Item> GAO_MARKSMANSHIP = ITEMS.register("gao_marksmanship",
            ()-> new GaoMarksmanship());
    //隔山打牛
    public static final RegistryObject<Item> GE_SHAN_DA_NIU = ITEMS.register("ge_shan_da_niu",
            ()-> new GeShanDaNiu());
    //龟息功
    public static final RegistryObject<Item> TURTLE_BREATH_WORK = ITEMS.register("turtle_breath_work",
            ()-> new TurtleBreathWork());
    //金乌刀法
    public static final RegistryObject<Item> GOLDEN_BLACK_KNIFE_METHOD = ITEMS.register("golden_black_knife_method",
            ()-> new GoldenBlackKnifeMethod());
    //金钟罩
    public static final RegistryObject<Item> GOLDEN_BELL_JAR = ITEMS.register("golden_bell_jar",
            ()-> new GoldenBellJar());
    //葵花点穴手
    public static final RegistryObject<Item> SUNFLOWER_POINT_CAVEMAN = ITEMS.register("sunflower_point_caveman",
            ()-> new SunflowerPointCaveman());
    //麦块百科
    public static final RegistryObject<Item> WHEAT_NUGGET_ENCYCLOPEDIA = ITEMS.register("wheat_nugget_encyclopedia",
            ()-> new WheatNuggetEncyclopedia());
    //庖丁解牛
    public static final RegistryObject<Item> PAODING = ITEMS.register("paoding",
            ()-> new Paoding());
    //庖丁解牛
    public static final RegistryObject<Item> SHAOLIN_STICK_METHOD = ITEMS.register("shaolin_stick_method",
            ()-> new ShaolinStickMethod());
    //踏雪无痕
    public static final RegistryObject<Item> TREAD_THE_SNOW_WITHOUT_TRACE = ITEMS.register("tread_the_snow_without_trace",
            ()-> new TreadTheSnowWithoutTrace());
    //无情飞刀
    public static final RegistryObject<Item> RELENTLESS_THROWING_KNIVES = ITEMS.register("relentless_throwing_knives",
            ()-> new RelentlessThrowingKnives());
    //吴刚伐桂
    public static final RegistryObject<Item> WU_GANG_CUT_GUI = ITEMS.register("wu_gang_cut_gui",
            ()-> new WuGangCutGui());
    //玄女剑法
    public static final RegistryObject<Item> XUANNU_SWORDSMANSHIP = ITEMS.register("xuannu_swordsmanship",
            ()-> new XuannuSwordsmanship());
    //愚公移山
    public static final RegistryObject<Item> YUGONG_MOVES_MOUNTAINS = ITEMS.register("yugong_moves_mountains",
            ()-> new YugongMovesMountains());
    //张门心学
    public static final RegistryObject<Item> ZHANG_MEN_XIN_XUE = ITEMS.register("zhang_men_xin_xue",
            ()-> new ZhangMenXinxue());

    //练功木桩
    public static final RegistryObject<Item> STAKES = ITEMS.register("stakes", ()-> new Stakes());

    //浇铸
    public static final RegistryObject<Item> CRUCIBLE = ITEMS.register("crucible", ()-> new Crucible());
    public static final RegistryObject<Item> CRUCIBLE_CRUSHED_COPPER = ITEMS.register("crucible_crushed_copper", ()-> new Crucible());
    public static final RegistryObject<Item> CRUCIBLE_CRUSHED_SILVER = ITEMS.register("crucible_crushed_silver", ()-> new Crucible());
    public static final RegistryObject<Item> CRUCIBLE_CRUSHED_GOLD = ITEMS.register("crucible_crushed_gold", ()-> new Crucible());
    public static final RegistryObject<Item> CRUCIBLE_LIQUID_COPPER = ITEMS.register("crucible_liquid_copper", ()-> new Crucible());
    public static final RegistryObject<Item> CRUCIBLE_LIQUID_SILVER = ITEMS.register("crucible_liquid_silver", ()-> new Crucible());
    public static final RegistryObject<Item> CRUCIBLE_LIQUID_GOLD = ITEMS.register("crucible_liquid_gold", ()-> new Crucible());

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
