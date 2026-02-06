package com.shengchanshe.chang_sheng_jue.item;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.bamboo_mat.BambooMatItem;
import com.shengchanshe.chang_sheng_jue.block.custom.gong.GongItem;
import com.shengchanshe.chang_sheng_jue.block.custom.workbench.WoodworkingBenchItem;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.ChangShengJueArmorMaterials;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.buddhist_robe.BuddhistRobe;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.confucian_costumes.ConfucianCostumes;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.constable_uniform.ConstableUniform;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.cotton.CottonArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.duanda.DuanDa;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.flying_fish_robe.FlyingFishRobe;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.black_robe.HatsBlackRobe;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.hats.with_veil.HatsWithVeil;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.forehead_band.ForeheadBand;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.forehead_band.ForeheadBand2;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.hair_crown.HairCrown;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.headdress.hair_crown.HairCrown2;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.inner_armor.GoldSilkSoftArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.inner_armor.LeatherInnerArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.long_gown.LongGown;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.mountain_pattern_armor.MountainPatternArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.night_suit.NightSuit;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.outer_robe.OuterRobe;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.qi_tian_da_sheng.QiTianDaSheng;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.side_fastening_leather.SideFasteningLeatherArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.taoistrobes.FemaleTaoistRobes;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.taoistrobes.MaleTaoistRobes;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.the_great_general_mingguang_armor.TheGreatGeneralMingguangArmor;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.walker_set.WalkerSet;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.wedding.FemaleChineseWeddingDress;
import com.shengchanshe.chang_sheng_jue.item.combat.armor.wedding.MaleChineseWeddingDress;
import com.shengchanshe.chang_sheng_jue.item.combat.book.*;
import com.shengchanshe.chang_sheng_jue.item.combat.clubbed.BeatDogStick;
import com.shengchanshe.chang_sheng_jue.item.combat.clubbed.PanHuaGun;
import com.shengchanshe.chang_sheng_jue.item.combat.glove.GoldThreadGlove;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.HengDao;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.KitchenKnife;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.LargeKnife;
import com.shengchanshe.chang_sheng_jue.item.combat.knife.TuLongDao;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.BaWangQiang;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.RedTasselledSpear;
import com.shengchanshe.chang_sheng_jue.item.combat.stakes.Stakes;
import com.shengchanshe.chang_sheng_jue.item.combat.sword.*;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.FlyingDaggerPouch;
import com.shengchanshe.chang_sheng_jue.item.combat.throwingknives.ThrowingKnives;
import com.shengchanshe.chang_sheng_jue.item.foods.*;
import com.shengchanshe.chang_sheng_jue.item.items.*;
import com.shengchanshe.chang_sheng_jue.item.kungfuxp.ExternalKungfuXp;
import com.shengchanshe.chang_sheng_jue.item.kungfuxp.InternalkungfuXp;
import com.shengchanshe.chang_sheng_jue.item.tool.KaishanPickaxe;
import com.shengchanshe.chang_sheng_jue.item.tool.XuanhuaAxe;
import net.minecraft.ChatFormatting;
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
            ()-> new BlockItem(ChangShengJueBlocks.PINEAPPLE.get(),
                    new Item.Properties().food(ChangShengJueFoods.PINEAPPLE)));
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
            ()-> new BlockItem(ChangShengJueBlocks.CORN.get(),
                    new Item.Properties().food(ChangShengJueFoods.CORN)));
    public static final RegistryObject<Item> JALAPENOS = ITEMS.register("jalapenos",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            ()-> new BlockItem(ChangShengJueBlocks.MANGO.get(),
                    new Item.Properties().food(ChangShengJueFoods.MANGO)));
    public static final RegistryObject<Item> GUI_HUA = ITEMS.register("gui_hua",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.GUI_HUA)));
    public static final RegistryObject<Item> MEI_HUA = ITEMS.register("mei_hua",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CAPSULE = ITEMS.register("capsule",
            ()-> new ItemNameBlockItem(ChangShengJueBlocks.CAPSULE_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> CANTALOUPE = ITEMS.register("cantaloupe",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.CANTALOUPE)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            ()-> new BlockItem(ChangShengJueBlocks.BANANA.get(),
                    new Item.Properties().food(ChangShengJueFoods.BANANA)));
    public static final RegistryObject<Item> PEAR = ITEMS.register("pear",
            ()-> new BlockItem(ChangShengJueBlocks.PEAR.get(),
                    new Item.Properties().food(ChangShengJueFoods.PEAR)));
    public static final RegistryObject<Item> LICHEE = ITEMS.register("lichee",
            ()-> new BlockItem(ChangShengJueBlocks.LICHEE.get(),
                    new Item.Properties().food(ChangShengJueFoods.LICHEE)));
    public static final RegistryObject<Item> GRAPE = ITEMS.register("grape",
            ()-> new BlockItem(ChangShengJueBlocks.GRAPE.get(),
                    new Item.Properties().food(ChangShengJueFoods.GRAPE)));
    public static final RegistryObject<Item> DURIAN = ITEMS.register("durian",
            ()-> new DurianBlockItem(ChangShengJueBlocks.DURIAN.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> DURIAN_MEAT = ITEMS.register("durian_meat",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.DURIAN_MEAT)));
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
            ()-> new Item(new Item.Properties().stacksTo(64).food(ChangShengJueFoods.CAPSULE_JIAO_ZI)));
    public static final RegistryObject<Item> PORTULACA_OLERACEA_CAKE = ITEMS.register("portulaca_oleracea_cake",
            ()-> new Item(new Item.Properties().stacksTo(64).food(ChangShengJueFoods.PORTULACA_OLERACEA_CAKE)));
    public static final RegistryObject<Item> QING_TUAN = ITEMS.register("qing_tuan",
            ()-> new Item(new Item.Properties().stacksTo(64).food(ChangShengJueFoods.QING_TUAN)));
    public static final RegistryObject<Item> XIAO_MI_FAN = ITEMS.register("xiao_mi_fan",
            ()-> new Item(new Item.Properties().stacksTo(64).food(ChangShengJueFoods.XIAO_MI_FAN)));
    public static final RegistryObject<Item> MI_FAN = ITEMS.register("mi_fan",
            ()-> new Item(new Item.Properties().stacksTo(64).food(ChangShengJueFoods.MI_FAN)));

    public static final RegistryObject<Item> ZHENG_CAI = ITEMS.register("zheng_cai",
            ()-> new PorcelainPlatesFoodItem(ChangShengJueBlocks.ZHENG_CAI.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.ZHENG_CAI)));
    public static final RegistryObject<Item> BAKED_CORN = ITEMS.register("baked_corn",
            ()-> new BlockItem(ChangShengJueBlocks.BAKED_CORN.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.BAKED_CORN)));
    public static final RegistryObject<Item> TOMATO_EGG = ITEMS.register("tomato_egg",
            ()-> new PorcelainPlatesFoodItem(ChangShengJueBlocks.TOMATO_EGG.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.TOMATO_EGG)));
    public static final RegistryObject<Item> GU_LAO_ROU = ITEMS.register("gu_lao_rou",
            ()-> new PorcelainPlatesFoodItem(ChangShengJueBlocks.GU_LAO_ROU.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.GU_LAO_ROU)));
    public static final RegistryObject<Item> MEAT_FOAM_BRINJAL = ITEMS.register("meat_foam_brinjal",
            ()-> new PorcelainPlatesFoodItem(ChangShengJueBlocks.MEAT_FOAM_BRINJAL.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.MEAT_FOAM_BRINJAL)));
    public static final RegistryObject<Item> STINKY_TOFU = ITEMS.register("stinky_tofu",
            ()-> new PorcelainPlatesFoodItem(ChangShengJueBlocks.STINKY_TOFU.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.STINKY_TOFU)));
    public static final RegistryObject<Item> GUI_HUA_TANG_OU = ITEMS.register("gui_hua_tang_ou",
            ()-> new PorcelainPlatesFoodItem(ChangShengJueBlocks.GUI_HUA_TANG_OU.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.GUI_HUA_TANG_OU)));
    public static final RegistryObject<Item> HOT_PEAR_SOUP = ITEMS.register("hot_pear_soup",
            ()-> new PorcelainBowlsFoodItem(ChangShengJueBlocks.HOT_PEAR_SOUP.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.HOT_PEAR_SOUP)));
    public static final RegistryObject<Item> ZHU_DU_JI = ITEMS.register("zhu_du_ji",
            ()-> new PorcelainBowlsFoodItem(ChangShengJueBlocks.ZHU_DU_JI.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.ZHU_DU_JI)));
    public static final RegistryObject<Item> BA_BAO_ZHOU = ITEMS.register("ba_bao_zhou",
            ()-> new PorcelainBowlsFoodItem(ChangShengJueBlocks.BA_BAO_ZHOU.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.BA_BAO_ZHOU)));
    public static final RegistryObject<Item> MULBERRY_JUICE = ITEMS.register("mulberry_juice",
            ()-> new PorcelainCupsFoodItem(ChangShengJueBlocks.MULBERRY_JUICE.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.MULBERRY_JUICE)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            ()-> new PorcelainCupsFoodItem(ChangShengJueBlocks.APPLE_JUICE.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.APPLE_JUICE)));
    public static final RegistryObject<Item> GRAPE_JUICE = ITEMS.register("grape_juice",
            ()-> new PorcelainCupsFoodItem(ChangShengJueBlocks.GRAPE_JUICE.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.GRAPE_JUICE)));
    public static final RegistryObject<Item> BILUOCHUN_TEAS = ITEMS.register("biluochun_teas",
            ()-> new PorcelainCupsFoodItem(ChangShengJueBlocks.BILUOCHUN_TEAS.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.BILUOCHUN_TEA)));
    public static final RegistryObject<Item> LONG_JING_TEAS = ITEMS.register("long_jing_teas",
            ()-> new PorcelainCupsFoodItem(ChangShengJueBlocks.LONG_JING_TEAS.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.LONG_JING_TEA)));

    public static final RegistryObject<Item> SORGHUM_CAKE = ITEMS.register("sorghum_cake",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.SORGHUM_CAKE)));
    public static final RegistryObject<Item> FEN_JIU = ITEMS.register("fen_jiu",
            ()-> new Wine(ChangShengJueBlocks.FEN_JIU.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.FEN_JIU)));
    public static final RegistryObject<Item> WHEAT_NUGGETS_TRIBUTE_WINE = ITEMS.register("wheat_nuggets_tribute_wine",
            ()-> new Wine(ChangShengJueBlocks.WHEAT_NUGGETS_TRIBUTE_WINE.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.WHEAT_NUGGETS_TRIBUTE_WINE)));
    public static final RegistryObject<Item> SHI_LI_XIANG = ITEMS.register("shi_li_xiang",
            ()-> new Wine(ChangShengJueBlocks.SHI_LI_XIANG.get(),
                    new Item.Properties().stacksTo(1).food(ChangShengJueFoods.SHI_LI_XIANG)));
    public static final RegistryObject<Item> EMPTY_FEN_JIU = ITEMS.register("empty_fen_jiu",
            ()-> new Wine(ChangShengJueBlocks.EMPTY_FEN_JIU.get(),
                    new Item.Properties().stacksTo(64)));

    //刷怪蛋
    public static final RegistryObject<Item> BUTTERFLY_EGG = ITEMS.register("butterfly_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.BUTTERFLY,0xADFF2F,0x000000,
                    new Item.Properties()));
    public static final RegistryObject<Item> MONKEY_EGG = ITEMS.register("monkey_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.MONKEY,0x785925,0x272625,
                    new Item.Properties()));
    public static final RegistryObject<Item> DRAGONFLY_EGG = ITEMS.register("dragonfly_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.DRAGONFLY,0x228B22,0x008000,
                    new Item.Properties()));
    public static final RegistryObject<Item> CICADA_EGG = ITEMS.register("cicada_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CICADA,0x000000,0xADFF2F,
                    new Item.Properties()));
    public static final RegistryObject<Item> CRANE_EGG = ITEMS.register("crane_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CRANE,0xC0C0C0,0xFFFFFF,
                    new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_EGG = ITEMS.register("peacock_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.MALE_PEACOCK,0x0000FF,0xD3D3D3,
                    new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_EGG_1 = ITEMS.register("peacock_egg_1",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.FEMALE_PEACOCK,0x0000FF,0xD3D3D3,
                    new Item.Properties()));
    public static final RegistryObject<Item> STAG_EGG = ITEMS.register("stag_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.STAG,0x8B4513,0x228B22,
                    new Item.Properties()));
    public static final RegistryObject<Item> HIND_EGG = ITEMS.register("hind_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.HIND,0x8B4513,0x228B22,
                    new Item.Properties()));
    public static final RegistryObject<Item> TIGER_EGG = ITEMS.register("tiger_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.TIGER,0xFF8C00,0x000000,
                    new Item.Properties()));
    public static final RegistryObject<Item> CROC_EGG = ITEMS.register("croc_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CROC,0x808000,0x006400,
                    new Item.Properties()));

    public static final RegistryObject<Item> CHANG_SHENG_JUE_VILLAGER_EGG = ITEMS.register("chang_sheng_jue_villager_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER,5651507,12422002,
                    new Item.Properties()));
    public static final RegistryObject<Item> WARRIOR_EGG = ITEMS.register("warrior_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.WARRIOR,0x6a746c,0xb2a565, new Item.Properties()));

    public static final RegistryObject<Item> KILN_WORKER_EGG = ITEMS.register("kiln_worker_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.KILN_WORKER,0x606357,0x456787, new Item.Properties()));
    //酒馆掌柜
    public static final RegistryObject<Item> MALE_INNKEEPER_EGG = ITEMS.register("male_innkeeper_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.MALE_INNKEEPER,0x636d48,0x4a4029, new Item.Properties()));
    public static final RegistryObject<Item> FEMALE_INNKEEPER_EGG = ITEMS.register("female_innkeeper_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.FEMALE_INNKEEPER,0xc37a4a,0xe3c77a, new Item.Properties()));
    public static final RegistryObject<Item> CHALLENGER_EGG = ITEMS.register("challenger_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CHALLENGER,0xb2a58f,0x312116, new Item.Properties()));
    public static final RegistryObject<Item> BLACKSMITH_EGG = ITEMS.register("blacksmith_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.BLACKSMITH,0x507281,0x875638, new Item.Properties()));
    public static final RegistryObject<Item> LANCE_GANG_LEADER_EGG = ITEMS.register("lance_gang_leader_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.LANCE_GANG_LEADER,0x233d43,0xc6c6c6, new Item.Properties()));
    public static final RegistryObject<Item> KNIFE_GANG_LEADER_EGG = ITEMS.register("knife_gang_leader_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.KNIFE_GANG_LEADER,0x53452c,0x18150d, new Item.Properties()));
    public static final RegistryObject<Item> SWORD_GANG_LEADER_EGG = ITEMS.register("sword_gang_leader_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.SWORD_GANG_LEADER,0x501d1d,0x1d0a0a, new Item.Properties()));
    public static final RegistryObject<Item> CLUBBED_GANG_LEADER_EGG = ITEMS.register("clubbed_gang_leader_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CLUBBED_GANG_LEADER,0x434463,0x0f0e1b, new Item.Properties()));
    public static final RegistryObject<Item> GANG_LEADER_EGG = ITEMS.register("gang_leader_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.GANG_LEADER,0x431463,0x0f1e1b, new Item.Properties()));
    public static final RegistryObject<Item> BANDIT_EGG = ITEMS.register("bandit_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.BANDIT,0x405647,0xc49f76, new Item.Properties()));
    public static final RegistryObject<Item> VILLAIN_EGG = ITEMS.register("villain_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.VILLAIN,0x405257,0x34423e, new Item.Properties()));
    public static final RegistryObject<Item> ASSASSIN_EGG = ITEMS.register("assassin_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.ASSASSIN,0x404040,0x404040, new Item.Properties()));

    public static final RegistryObject<Item> CLUBBED_MING_XIA_EGG = ITEMS.register("clubbed_ming_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.CLUBBED_MING_XIA, ChatFormatting.BLUE.getColor(),ChatFormatting.BLACK.getColor(), new Item.Properties()));
    public static final RegistryObject<Item> SWORD_MING_XIA_EGG = ITEMS.register("sword_ming_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.SWORD_MING_XIA, ChatFormatting.GOLD.getColor(),ChatFormatting.BLACK.getColor(), new Item.Properties()));
    public static final RegistryObject<Item> KNIFE_MING_XIA_EGG = ITEMS.register("knife_ming_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.KNIFE_MING_XIA, ChatFormatting.WHITE.getColor(),ChatFormatting.GREEN.getColor(), new Item.Properties()));
    public static final RegistryObject<Item> FIST_MING_XIA_EGG = ITEMS.register("fist_ming_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.FIST_MING_XIA, ChatFormatting.BLACK.getColor(),0X3AB3DA, new Item.Properties()));

    public static final RegistryObject<Item> PIGLIN_WU_XIA_EGG = ITEMS.register("piglin_wu_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.PIGLIN_WU_XIA,10051392, 16380836, new Item.Properties()));
    public static final RegistryObject<Item> WITCH_WU_XIA_EGG = ITEMS.register("witch_wu_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.WITCH_WU_XIA,3407872, 5349438, new Item.Properties()));
    public static final RegistryObject<Item> EVOKER_WU_XIA_EGG = ITEMS.register("evoker_wu_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.EVOKER_WU_XIA,9804699, 1973274,  new Item.Properties()));
    public static final RegistryObject<Item> VINDICATOR_WU_XIA_EGG = ITEMS.register("vindicator_wu_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.VINDICATOR_WU_XIA,9804699, 2580065,  new Item.Properties()));
    public static final RegistryObject<Item> PILLAGER_WU_XIA_EGG = ITEMS.register("pillager_wu_xia_egg",
            ()-> new ForgeSpawnEggItem(ChangShengJueEntity.PILLAGER_WU_XIA,5451574, 9804699,  new Item.Properties()));

    public static final RegistryObject<Item> ZHU_TAI = ITEMS.register("zhu_tai",
            ()-> new StandingAndWallBlockItem(ChangShengJueBlocks.ZHU_TAI.get(),ChangShengJueBlocks.WALL_ZHU_TAI.get(), new Item.Properties(), Direction.DOWN));

    public static final RegistryObject<Item> CRANE_FEATHERS = ITEMS.register("crane_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_FEATHERS = ITEMS.register("peacock_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WHITE_PEACOCK_FEATHERS = ITEMS.register("white_peacock_feathers",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEACOCK_EGGS = ITEMS.register("peacock_eggs",
            ()-> new PeacockEggItem((new Item.Properties()).stacksTo(16)));
    public static final RegistryObject<Item> ANTLER = ITEMS.register("antler",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEER_BLOOD = ITEMS.register("deer_blood",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> VENISON = ITEMS.register("venison",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.VENISON)));
    public static final RegistryObject<Item> COOKED_VENISON = ITEMS.register("cooked_venison",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.COOKED_VENISON)));

    public static final RegistryObject<Item> PEACOCK = ITEMS.register("peacock",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.PEACOCK)));
    public static final RegistryObject<Item> COOKED_PEACOCK = ITEMS.register("cooked_peacock",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.COOKED_PEACOCK)));
    public static final RegistryObject<Item> CROC = ITEMS.register("croc",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.CROC)));
    public static final RegistryObject<Item> COOKED_CROC = ITEMS.register("cooked_croc",
            ()-> new Item(new Item.Properties().food(ChangShengJueFoods.COOKED_CROC)));

    public static final RegistryObject<Item> TIGER_SKIN = ITEMS.register("tiger_skin",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CROC_SKIN = ITEMS.register("croc_skin",
            ()-> new Item(new Item.Properties()));

//    public static final RegistryObject<Item> CI_PAN = ITEMS.register("ci_pan",
//            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CI_PAN = ITEMS.register("ci_pan",
            ()-> new BlockItem(ChangShengJueBlocks.CI_PAN.get(), new BlockItem.Properties()));
    public static final RegistryObject<Item> CI_WAN = ITEMS.register("ci_wan",
            ()-> new BlockItem(ChangShengJueBlocks.CI_WAN.get(), new BlockItem.Properties()));
    public static final RegistryObject<Item> CI_BEI = ITEMS.register("ci_bei",
            ()-> new BlockItem(ChangShengJueBlocks.CI_BEI.get(), new BlockItem.Properties()));

    public static final RegistryObject<Item> TONG_QIAN = ITEMS.register("tong_qian",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YI_GUAN_TONG_QIAN = ITEMS.register("yi_guan_tong_qian",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_BULLIONS = ITEMS.register("silver_bullions",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GOLD_BULLIONS = ITEMS.register("gold_bullions",
            ()-> new Item(new Item.Properties()));

    //石灰
    public static final RegistryObject<Item> QUICKLIME = ITEMS.register("quicklime", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LIME_SLURRY_BARRELS = ITEMS.register("lime_slurry_barrels", LimeSlurryBarrels::new);
    public static final RegistryObject<Item> WARM_LIME_SLURRY_BARRELS = ITEMS.register("warm_lime_slurry_barrels", LimeSlurryBarrels::new);
    public static final RegistryObject<Item> COOL_LIME_SLURRY_BARRELS = ITEMS.register("cool_lime_slurry_barrels", LimeSlurryBarrels::new);

    //刷子
    public static final RegistryObject<Item> PAINT_BRUSH = ITEMS.register("paint_brush", PaintBrush::new);

    //蚕丝
    public static final RegistryObject<Item> NATURAL_SILK = ITEMS.register("natural_silk", ()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SILKWORM = ITEMS.register("silkworm", ()-> new Silkworm(new Item.Properties()));


    public static final RegistryObject<Item> SILK = ITEMS.register("silk", ()-> new Item(new Item.Properties()));

    //桑葚
    public static final RegistryObject<Item> MULBERRY = ITEMS.register("mulberry",
            ()-> new BlockItem(ChangShengJueBlocks.MULBERRY.get(),
                    new Item.Properties().food(ChangShengJueFoods.MULBERRY)));

    //茅草
    public static final RegistryObject<Item> THATCH = ITEMS.register("thatch",
            ()-> new Item(new Item.Properties()));

    //矿石
    public static final RegistryObject<Item> RAW_AG = ITEMS.register("raw_ag",
            ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> AG_INGOT = ITEMS.register("ag_ingot",
            ()-> new Item((new Item.Properties())));
    //砖
    public static final RegistryObject<Item> BLACK_BRICKS = ITEMS.register("black_bricks", ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> WHITE_BRICKS_ITEM = ITEMS.register("white_bricks_item", ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> GOLD_BRICKS = ITEMS.register("gold_bricks", ()-> new Item((new Item.Properties())));
    public static final RegistryObject<Item> CYAN_BRICKS = ITEMS.register("cyan_bricks", ()-> new Item((new Item.Properties())));
    //陶土球
    public static final RegistryObject<Item> SYDEROLIFE_BALL = ITEMS.register("syderolife_ball", ()-> new Item((new Item.Properties())));
    //高岭土球
    public static final RegistryObject<Item> KAOLIN_BALL = ITEMS.register("kaolin_ball", ()-> new Item((new Item.Properties())));
    //天然沥青
    public static final RegistryObject<Item> NATURAL_ASPHALT = ITEMS.register("natural_asphalt", ()-> new Item((new Item.Properties())));
    //工具
    public static final RegistryObject<Item> KAISHAN_PICKAXE = ITEMS.register("kaishan_pickaxe", KaishanPickaxe::new);
    public static final RegistryObject<Item> XUANHUA_AXE = ITEMS.register("xuanhua_axe", XuanhuaAxe::new);
    //战斗
    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword", BronzeSword::new);
    public static final RegistryObject<Item> HAN_JIAN = ITEMS.register("han_jian", HanJian::new);
    public static final RegistryObject<Item> HENG_DAO = ITEMS.register("heng_dao", HengDao::new);
    public static final RegistryObject<Item> LARGE_KNIFE = ITEMS.register("large_knife", LargeKnife::new);
    public static final RegistryObject<Item> RED_TASSELLED_SPEAR = ITEMS.register("red_tasselled_spear", RedTasselledSpear::new);
    public static final RegistryObject<Item> SOFT_SWORD = ITEMS.register("soft_sword", SoftSword::new);
    public static final RegistryObject<Item> PAN_HUA_GUN = ITEMS.register("pan_hua_gun", PanHuaGun::new);
    public static final RegistryObject<Item> KITCHEN_KNIFE = ITEMS.register("kitchen_knife", KitchenKnife::new);
    public static final RegistryObject<Item> THROWING_KNIVES = ITEMS.register("throwing_knives", ThrowingKnives::new);
    public static final RegistryObject<Item> FLYING_DAGGER_POUCH = ITEMS.register("flying_dagger_pouch", FlyingDaggerPouch::new);
    public static final RegistryObject<Item> LONG_YUAN_SWORD = ITEMS.register("long_yuan_sword", LongYuanSword::new);
    //金丝软甲
    public static final RegistryObject<Item> GOLD_SILK_SOFT_ARMOR = ITEMS.register("gold_silk_soft_armor",
            ()-> new GoldSilkSoftArmor(ChangShengJueArmorMaterials.GOLD_SILK,
                    ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    //皮革内甲
    public static final RegistryObject<Item> LEATHER_INNER_ARMOR = ITEMS.register("leather_inner_armor",
            ()-> new LeatherInnerArmor(ChangShengJueArmorMaterials.LEATHER,
                    ArmorItem.Type.CHESTPLATE,new Item.Properties().defaultDurability(96)));
    //棉甲
    public static final RegistryObject<Item> COTTON_HELMET = ITEMS.register("cotton_helmet",
            () -> new CottonArmor(ChangShengJueArmorMaterials.COTTON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WHITE_COTTON_HELMET = ITEMS.register("white_cotton_helmet",
            ()-> new CottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> COTTON_CHESTPLATE = ITEMS.register("cotton_chestplate",
            ()-> new CottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> COTTON_LEGGINGS = ITEMS.register("cotton_leggings",
            ()-> new CottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> COTTON_BOOTS = ITEMS.register("cotton_boots",
            ()-> new CottonArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.BOOTS,new Item.Properties()));
    //道袍
    public static final RegistryObject<Item> FEMALE_TAOIST_HELMET = ITEMS.register("female_taoist_helmet",
            ()-> new FemaleTaoistRobes(ChangShengJueArmorMaterials.TAOIST_1,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> FEMALE_TAOIST_CHESTPLATE = ITEMS.register("female_taoist_chestplate",
            ()-> new FemaleTaoistRobes(ChangShengJueArmorMaterials.TAOIST_1,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> MALE_TAOIST_HELMET = ITEMS.register("male_taoist_helmet",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.TAOIST,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> MALE_TAOIST_CHESTPLATE = ITEMS.register("male_taoist_chestplate",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.TAOIST,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> TAOIST_BOOTS = ITEMS.register("taoist_boots",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.TAOIST,ArmorItem.Type.BOOTS,new Item.Properties()));
    public static final RegistryObject<Item> TAOIST_LEGGINGS = ITEMS.register("taoist_leggings",
            ()-> new MaleTaoistRobes(ChangShengJueArmorMaterials.TAOIST,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    //婚服
    public static final RegistryObject<Item> MALE_CHINESE_WEDDING_DRESS_BLACK_GAUZE_CAP = ITEMS.register("male_chinese_wedding_dress_black_gauze_cap",
            ()-> new MaleChineseWeddingDress(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> MALE_CHINESE_WEDDING_DRESS_KYLIN_BUFU = ITEMS.register("male_chinese_wedding_dress_kylin_bufu",
            ()-> new MaleChineseWeddingDress(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));

    public static final RegistryObject<Item> FEMALE_CHINESE_WEDDING_DRESS_PHOENIX_CORONET = ITEMS.register("female_chinese_wedding_dress_phoenix_coronet",
            ()-> new FemaleChineseWeddingDress(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> FEMALE_CHINESE_WEDDING_DRESS_QUEEN_CLOTHING = ITEMS.register("female_chinese_wedding_dress_queen_clothing",
            ()-> new FemaleChineseWeddingDress(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));

    public static final RegistryObject<Item>  CHINESE_WEDDING_DRESS_GOLDEN_THREAD_SHOES = ITEMS.register("chinese_wedding_dress_golden_thread_shoes",
            ()-> new MaleChineseWeddingDress(ChangShengJueArmorMaterials.SILK,ArmorItem.Type.BOOTS,new Item.Properties()));

    //山文甲
    public static final RegistryObject<Item> MOUNTAIN_PATTERN_HELMET_GUN_HOOD = ITEMS.register("mountain_pattern_helmet_gun_hood",
            ()-> new MountainPatternArmor(ChangShengJueArmorMaterials.MOUNTAIN,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> MOUNTAIN_PATTERN_ARMOR = ITEMS.register("mountain_pattern_armor",
            ()-> new MountainPatternArmor(ChangShengJueArmorMaterials.MOUNTAIN,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> MOUNTAIN_PATTERN_DEERSKIN_TIBIAL_ARMOR = ITEMS.register("mountain_pattern_deerskin_tibial_armor",
            ()-> new MountainPatternArmor(ChangShengJueArmorMaterials.MOUNTAIN,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> MOUNTAIN_PATTERN_CLOUD_BLACK_BOOTS = ITEMS.register("mountain_pattern_cloud_black_boots",
            ()-> new MountainPatternArmor(ChangShengJueArmorMaterials.MOUNTAIN,ArmorItem.Type.BOOTS,new Item.Properties()));
    //甲种侧襟皮甲
    public static final RegistryObject<Item> SIDE_FASTENING_LEATHER_HELMET = ITEMS.register("side_fastening_leather_helmet",
            ()-> new SideFasteningLeatherArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> SIDE_FASTENING_LEATHER_CHESTPLATE = ITEMS.register("side_fastening_leather_chestplate",
            ()-> new SideFasteningLeatherArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> SIDE_FASTENING_LEATHER_LEGGINGS = ITEMS.register("side_fastening_leather_leggings",
            ()-> new SideFasteningLeatherArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> SIDE_FASTENING_LEATHER_BOOTS = ITEMS.register("side_fastening_leather_boots",
            ()-> new SideFasteningLeatherArmor(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.BOOTS,new Item.Properties()));
    // 蝉腹巾和大氅
    public static final RegistryObject<Item> OUTER_ROBE_HELMET = ITEMS.register("outer_robe_helmet",
            ()-> new OuterRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> OUTER_ROBE_CHESTPLATE = ITEMS.register("outer_robe_chestplate",
            ()-> new OuterRobe(ChangShengJueArmorMaterials.WALK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    //飞鱼服
    public static final RegistryObject<Item> FLY_FISH_IRON_HAT = ITEMS.register("fly_fish_iron_hat",
            ()-> new FlyingFishRobe(ChangShengJueArmorMaterials.FLY_HAT,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> FLY_FISH_CLOUD_VEIL_CROWN = ITEMS.register("fly_fish_cloud_veil_crown",
            ()-> new FlyingFishRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> FLY_FISH_CHESTPLATE = ITEMS.register("fly_fish_chestplate",
            ()-> new FlyingFishRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> FLY_FISH_LONG_BOOTS = ITEMS.register("fly_fish_long_boots",
            ()-> new FlyingFishRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.BOOTS,new Item.Properties()));
    //行者套
    public static final RegistryObject<Item> WALKER_GOLD_RING_BAND = ITEMS.register("walker_gold_ring_band",
            ()-> new WalkerSet(ChangShengJueArmorMaterials.WALK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> WALKER_GREEN_TREASURE_PENDANT = ITEMS.register("walker_green_treasure_pendant",
            ()-> new WalkerSet(ChangShengJueArmorMaterials.WALK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> WALKER_CHESTPLATE = ITEMS.register("walker_chestplate",
            ()-> new WalkerSet(ChangShengJueArmorMaterials.WALK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> WALKER_TIGER_SKIN_SKIRT = ITEMS.register("walker_tiger_skin_skirt",
            ()-> new WalkerSet(ChangShengJueArmorMaterials.WALK,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> WALKER_SHORT_BOOTS = ITEMS.register("walker_short_boots",
            ()-> new WalkerSet(ChangShengJueArmorMaterials.WALK,ArmorItem.Type.BOOTS,new Item.Properties()));
    //齐天大圣套
    public static final RegistryObject<Item> PHOENIX_FEATHER_CAP = ITEMS.register("phoenix_feather_cap",
            ()-> new QiTianDaSheng(ArmorMaterials.NETHERITE,ArmorItem.Type.HELMET,new Item.Properties().fireResistant(),50));
    public static final RegistryObject<Item> OLDEN_CHAIN_MAIL_SHIRT = ITEMS.register("olden_chain_mail_shirt",
            ()-> new QiTianDaSheng(ArmorMaterials.NETHERITE,ArmorItem.Type.CHESTPLATE,new Item.Properties().fireResistant(),50));
    public static final RegistryObject<Item> TIGER_SKIN_GARMENT = ITEMS.register("tiger_skin_garment",
            ()-> new QiTianDaSheng(ArmorMaterials.NETHERITE,ArmorItem.Type.LEGGINGS,new Item.Properties().fireResistant(),50));
    public static final RegistryObject<Item> CLOUD_WALKING_BOOTS = ITEMS.register("cloud_walking_boots",
            ()-> new QiTianDaSheng(ArmorMaterials.NETHERITE,ArmorItem.Type.BOOTS,new Item.Properties().fireResistant(),50));
    //大将军明光铠
    public static final RegistryObject<Item> THE_GREAT_GENERAL_MING_GUANG_PHOENIX_WINGS_HELMET = ITEMS.register("the_great_general_ming_guang_phoenix_wings_helmet",
            ()-> new TheGreatGeneralMingguangArmor(ChangShengJueArmorMaterials.BRIGHT,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> THE_GREAT_GENERAL_MING_GUANG_LIGHT_CHESTPLATE = ITEMS.register("the_great_general_ming_guang_light_chestplate",
            ()-> new TheGreatGeneralMingguangArmor(ChangShengJueArmorMaterials.BRIGHT,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> THE_GREAT_GENERAL_MING_GUANG_LAZULI_KNEE_PADS = ITEMS.register("the_great_general_ming_guang_lazuli_knee_pads",
            ()-> new TheGreatGeneralMingguangArmor(ChangShengJueArmorMaterials.BRIGHT,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> THE_GREAT_GENERAL_MING_GUANG_ANIMAL_SKIN_BOOTS = ITEMS.register("the_great_general_ming_guang_animal_skin_boots",
            ()-> new TheGreatGeneralMingguangArmor(ChangShengJueArmorMaterials.BRIGHT,ArmorItem.Type.BOOTS,new Item.Properties()));
    //儒装
    public static final RegistryObject<Item> CONFUCIAN_HELMET = ITEMS.register("confucian_helmet",
            ()-> new ConfucianCostumes(ChangShengJueArmorMaterials.INK,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> CONFUCIAN_INK_CHESTPLATE = ITEMS.register("confucian_ink_chestplate",
            ()-> new ConfucianCostumes(ChangShengJueArmorMaterials.INK,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> CONFUCIAN_INK_LEGGINGS = ITEMS.register("confucian_ink_leggings",
            ()-> new ConfucianCostumes(ChangShengJueArmorMaterials.INK,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> CONFUCIAN_INK_BOOTS = ITEMS.register("confucian_ink_boots",
            ()-> new ConfucianCostumes(ChangShengJueArmorMaterials.INK,ArmorItem.Type.BOOTS,new Item.Properties()));
    // 斗笠垂纱套
    public static final RegistryObject<Item> HATS_WITH_VEIL_HELMET = ITEMS.register("hats_with_veil_helmet",
            ()-> new HatsWithVeil(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> HATS_WITH_VEIL_CHESTPLATE = ITEMS.register("hats_with_veil_chestplate",
            ()-> new HatsWithVeil(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    //斗笠玄衣套
    public static final RegistryObject<Item> HATS_BLACK_ROBE_HELMET = ITEMS.register("hats_black_robe_helmet",
            ()-> new HatsBlackRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> HATS_BLACK_ROBE_CHESTPLATE = ITEMS.register("hats_black_robe_chestplate",
            ()-> new HatsBlackRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> HATS_BLACK_ROBE_LEGGINGS = ITEMS.register("hats_black_robe_leggings",
            ()-> new HatsBlackRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    //短打套
    public static final RegistryObject<Item> DUAN_DA_CHESTPLATE = ITEMS.register("duan_da_chestplate",
            ()-> new DuanDa(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    //捕快套
    public static final RegistryObject<Item> CONSTABLE_UNIFORM_HELMET = ITEMS.register("constable_uniform_helmet",
            ()-> new ConstableUniform(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> CONSTABLE_UNIFORM_CHESTPLATE = ITEMS.register("constable_uniform_chestplate",
            ()-> new ConstableUniform(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> CONSTABLE_UNIFORM_LEGGINGS = ITEMS.register("constable_uniform_leggings",
            ()-> new ConstableUniform(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> CONSTABLE_UNIFORM_BOOTS = ITEMS.register("constable_uniform_boots",
            ()-> new ConstableUniform(ChangShengJueArmorMaterials.COTTON,ArmorItem.Type.BOOTS,new Item.Properties()));
    //头饰
    public static final RegistryObject<Item> FOREHEAD_BAND_HELMET1 = ITEMS.register("forehead_band_helmet1",
            ()-> new ForeheadBand(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> FOREHEAD_BAND_HELMET2 = ITEMS.register("forehead_band_helmet2",
            ()-> new ForeheadBand2(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> HAIR_CROWN_HELMET1 = ITEMS.register("hair_crown_helmet1",
            ()-> new HairCrown(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> HAIR_CROWN_HELMET2 = ITEMS.register("hair_crown_helmet2",
            ()-> new HairCrown2(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    //僧袍
    public static final RegistryObject<Item> BUDDHIST_ROBE_CHESTPLATE = ITEMS.register("buddhist_robe_chestplate",
            ()-> new BuddhistRobe(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    //夜行衣
    public static final RegistryObject<Item> NIGHT_SUIT_HELMET = ITEMS.register("night_suit_helmet",
            ()-> new NightSuit(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> NIGHT_SUIT_CHESTPLATE = ITEMS.register("night_suit_chestplate",
            ()-> new NightSuit(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> NIGHT_SUIT_LEGGINGS = ITEMS.register("night_suit_leggings",
            ()-> new NightSuit(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.LEGGINGS,new Item.Properties()));
    //长衫
    public static final RegistryObject<Item> LONG_GOWN_CHESTPLATE = ITEMS.register("long_gown_chestplate",
            ()-> new LongGown(ChangShengJueArmorMaterials.FLY,ArmorItem.Type.CHESTPLATE,new Item.Properties()));

    //打狗棒
    public static final RegistryObject<Item> BEAT_DOG_STICK = ITEMS.register("beat_dog_stick", BeatDogStick::new);
    //倚天剑
    public static final RegistryObject<Item> YI_TIAN_JIAN = ITEMS.register("yi_tian_jian", YiTianJian::new);
    //屠龙刀
    public static final RegistryObject<Item> TU_LONG_DAO = ITEMS.register("tu_long_dao", TuLongDao::new);
    //霸王枪
    public static final RegistryObject<Item> BA_WANG_QIANG = ITEMS.register("ba_wang_qiang", BaWangQiang::new);
    //金丝手套
    public static final RegistryObject<Item> GOLD_THREAD_GLOVE = ITEMS.register("gold_thread_glove", GoldThreadGlove::new);

    //武功秘籍
    //不死神功
    public static final RegistryObject<Item> IMMORTAL_MIRACLE = ITEMS.register("immortal_miracle", ImmortalMiracleBook::new);
    //大力神功
    public static final RegistryObject<Item> HERCULES = ITEMS.register("hercules", HerculesBook::new);
    //独孤九剑
    public static final RegistryObject<Item> DUGU_NINE_SWORDS = ITEMS.register("dugu_nine_swords", DuguNineSwordsBook::new);
    //高家枪法
    public static final RegistryObject<Item> GAO_MARKSMANSHIP = ITEMS.register("gao_marksmanship", GaoMarksmanshipBook::new);
    //隔山打牛
    public static final RegistryObject<Item> GE_SHAN_DA_NIU = ITEMS.register("ge_shan_da_niu", GeShanDaNiuBook::new);
    //龟息功
    public static final RegistryObject<Item> TURTLE_BREATH_WORK = ITEMS.register("turtle_breath_work", TurtleBreathWorkBook::new);
    //金乌刀法
    public static final RegistryObject<Item> GOLDEN_BLACK_KNIFE_METHOD = ITEMS.register("golden_black_knife_method", GoldenBlackKnifeMethodBook::new);
    //金钟罩
    public static final RegistryObject<Item> GOLDEN_BELL_JAR = ITEMS.register("golden_bell_jar", GoldenBellJarBook::new);
    //葵花点穴手
    public static final RegistryObject<Item> SUNFLOWER_POINT_CAVEMAN = ITEMS.register("sunflower_point_caveman", SunflowerPointCavemanBook::new);
    //麦块百科
    public static final RegistryObject<Item> WHEAT_NUGGET_ENCYCLOPEDIA = ITEMS.register("wheat_nugget_encyclopedia", WheatNuggetEncyclopediaBook::new);
    //庖丁解牛
    public static final RegistryObject<Item> PAODING = ITEMS.register("paoding", PaodingBook::new);
    //少林棍法
    public static final RegistryObject<Item> SHAOLIN_STICK_METHOD = ITEMS.register("shaolin_stick_method", ShaolinStickMethodBook::new);
    //踏雪无痕
    public static final RegistryObject<Item> TREAD_THE_SNOW_WITHOUT_TRACE = ITEMS.register("tread_the_snow_without_trace", TreadTheSnowWithoutTraceBook::new);
    //无情飞刀
    public static final RegistryObject<Item> RELENTLESS_THROWING_KNIVES = ITEMS.register("relentless_throwing_knives", RelentlessThrowingKnivesBook::new);
    //吴刚伐桂
    public static final RegistryObject<Item> WU_GANG_CUT_GUI = ITEMS.register("wu_gang_cut_gui", WuGangCutGuiBook::new);
    //玄女剑法
    public static final RegistryObject<Item> XUANNU_SWORDSMANSHIP = ITEMS.register("xuannu_swordsmanship", XuannuSwordsmanshipBook::new);
    //愚公移山
    public static final RegistryObject<Item> YUGONG_MOVES_MOUNTAINS = ITEMS.register("yugong_moves_mountains", YugongMovesMountainsBook::new);
    //张门心学
    public static final RegistryObject<Item> ZHANG_MEN_XIN_XUE = ITEMS.register("zhang_men_xin_xue", ZhangMenXinxueBook::new);
    //易筋经
    public static final RegistryObject<Item> THE_CLASSICS_OF_TENDON_CHANGING = ITEMS.register("the_classics_of_tendon_changing", TheClassicsOfTendonChangingBook::new);
    //乾坤大挪移
    public static final RegistryObject<Item> QIAN_KUN_DA_NUO_YI = ITEMS.register("qian_kun_da_nuo_yi", QianKunDaNuoYiBook::new);

    //令牌
    public static final RegistryObject<Item> GANG_TOKEN = ITEMS.register("gang_token", ()-> new Item(new Item.Properties()));

    //练功木桩
    public static final RegistryObject<Item> STAKES = ITEMS.register("stakes", Stakes::new);

    //浇铸
    public static final RegistryObject<Item> CRUCIBLE = ITEMS.register("crucible", Crucible::new);
    public static final RegistryObject<Item> CRUCIBLE_CRUSHED_COPPER = ITEMS.register("crucible_crushed_copper", Crucible::new);
    public static final RegistryObject<Item> CRUCIBLE_CRUSHED_SILVER = ITEMS.register("crucible_crushed_silver", Crucible::new);
    public static final RegistryObject<Item> CRUCIBLE_CRUSHED_GOLD = ITEMS.register("crucible_crushed_gold", Crucible::new);
    public static final RegistryObject<Item> CRUCIBLE_LIQUID_COPPER = ITEMS.register("crucible_liquid_copper", Crucible::new);
    public static final RegistryObject<Item> CRUCIBLE_LIQUID_SILVER = ITEMS.register("crucible_liquid_silver", Crucible::new);
    public static final RegistryObject<Item> CRUCIBLE_LIQUID_GOLD = ITEMS.register("crucible_liquid_gold", Crucible::new);

    //包裹
    public static final RegistryObject<Item> ARMOR_PARCEL = ITEMS.register("armor_parcel", Parcel::new);

    public static final RegistryObject<Item> TRAUMA_EFFECT = ITEMS.register("trauma_effect",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INTERNAL_INJURY_EFFECT = ITEMS.register("internal_injury_effect",
            ()-> new Item(new Item.Properties()));

    //情报
    public static final RegistryObject<Item> STRUCTURE_INTELLIGENCE = ITEMS.register("structure_intelligence",
            () -> new StructureIntelligence(new Item.Properties().stacksTo(1)));

    //锣
    public static final RegistryObject<Item> GONG = ITEMS.register("gong",
            () -> new GongItem(ChangShengJueBlocks.GONG.get() , new Item.Properties()));
    //木工台
    public static final RegistryObject<Item> WOOD_WORKING_BENCH = ITEMS.register("wood_working_bench",
            () -> new WoodworkingBenchItem(ChangShengJueBlocks.WOOD_WORKING_BENCH.get() , new Item.Properties()));

    //经验书
    public static final RegistryObject<Item> EXTERNAL_KUNG_FU_XP = ITEMS.register("external_kung_fu_xp",
            () -> new ExternalKungfuXp((new Item.Properties())));
    public static final RegistryObject<Item> INTERNAL_KUNG_FU_XP = ITEMS.register("internal_kung_fu_xp",
            () -> new InternalkungfuXp((new Item.Properties())));
    //竹席
    public static final RegistryObject<Item> BAMBOO_MAT = ITEMS.register("bamboo_mat",
            () -> new BambooMatItem(ChangShengJueBlocks.BAMBOO_MAT.get() , new Item.Properties()));
    //手册
    public static final RegistryObject<Item> WU_FANG_LU = ITEMS.register("wu_fang_lu", ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
