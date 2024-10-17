package com.shengchanshe.changshengjue.item;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.creativemodetab.ChangShengJueCreativeModeTab;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.foods.ChangShengJueFoods;
import com.shengchanshe.changshengjue.item.foods.DurianItem;
import com.shengchanshe.changshengjue.item.items.PeacockEggItem;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
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


    public static final RegistryObject<Item> PEANUT = ITEMS.register("peanut",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PEANUT)));
    public static final RegistryObject<Item> BRINJAL = ITEMS.register("brinjal",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.BRINJAL)));

    public static final RegistryObject<Item> CAPSULE_JIAO_ZI = ITEMS.register("capsule_jiao_zi",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.CAPSULE_JIAO_ZI)));
    public static final RegistryObject<Item> ZHENG_CAI = ITEMS.register("zheng_cai",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.ZHENG_CAI)));
    public static final RegistryObject<Item> PORTULACA_OLERACEA_CAKE = ITEMS.register("portulaca_oleracea_cake",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PORTULACA_OLERACEA_CAKE)));
    public static final RegistryObject<Item> QING_TUAN = ITEMS.register("qing_tuan",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.QING_TUAN)));
    public static final RegistryObject<Item> BAKED_CORN = ITEMS.register("baked_corn",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.BAKED_CORN)));
    public static final RegistryObject<Item> TOMATO_EGG = ITEMS.register("tomato_egg",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.TOMATO_EGG)));
    public static final RegistryObject<Item> GU_LAO_ROU = ITEMS.register("gu_lao_rou",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.GU_LAO_ROU)));
    public static final RegistryObject<Item> MEAT_FOAM_BRINJAL = ITEMS.register("meat_foam_brinjal",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.MEAT_FOAM_BRINJAL)));
    public static final RegistryObject<Item> SORGHUM_CAKE = ITEMS.register("sorghum_cake",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.SORGHUM_CAKE)));
    public static final RegistryObject<Item> STINKY_TOFU = ITEMS.register("stinky_tofu",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.STINKY_TOFU)));
    public static final RegistryObject<Item> ZHU_DU_JI = ITEMS.register("zhu_du_ji",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.ZHU_DU_JI)));
    public static final RegistryObject<Item> XIAO_MI_FAN = ITEMS.register("xiao_mi_fan",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.XIAO_MI_FAN)));
    public static final RegistryObject<Item> MI_FAN = ITEMS.register("mi_fan",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.MI_FAN)));
    public static final RegistryObject<Item> GUI_HUA_TANG_OU = ITEMS.register("gui_hua_tang_ou",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.GUI_HUA_TANG_OU)));
    public static final RegistryObject<Item> BA_BAO_ZHOU = ITEMS.register("ba_bao_zhou",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.BA_BAO_ZHOU)));


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
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER,0x808000,0x006400,
                    new Item.Properties()));
    public static final RegistryObject<Item> CHANG_SHENG_JUE_HUNTER_EGG = ITEMS.register("chang_sheng_jue_hunter_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CHANG_SHENG_JUE_HUNTER,0x808000,0x006400,
                    new Item.Properties()));
    public static final RegistryObject<Item> CHANG_SHENG_JUE_VILLAGER_CHIEF_EGG = ITEMS.register("chang_sheng_jue_villager_chief_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER_CHIEF,0x808000,0x006400,
                    new Item.Properties()));


    public static final RegistryObject<Item> ZHU_TAI = ITEMS.register("zhu_tai",
            ()-> new StandingAndWallBlockItem(ChangShengJueBlocks.ZHU_TAI_BLOCK.get(),ChangShengJueBlocks.WALL_ZHU_TAI_BLOCK.get(), (new Item.Properties()), Direction.DOWN));

    public static final RegistryObject<Item> CRANE_FEATHERS = ITEMS.register("crane_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_FEATHERS = ITEMS.register("peacock_feathers",
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

    public static final RegistryObject<Item> TONG_QIAN = ITEMS.register("tong_qian",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YI_GUAN_TONG_QIAN = ITEMS.register("yi_guan_tong_qian",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_BULLIONS = ITEMS.register("silver_bullions",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_BULLIONS = ITEMS.register("gold_bullions",
            ()-> new Item(new Item.Properties()));

    //矿石
    public static final RegistryObject<Item> RAW_AG = ITEMS.register("raw_ag",
            ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> AG_INGOT = ITEMS.register("ag_ingot",
            ()-> new Item((new Item.Properties())));

    //画
    public static final RegistryObject<Item> PAINTING_SCROLL  = ITEMS.register("painting_scroll",()-> new HangingEntityItem(EntityType.PAINTING, new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
