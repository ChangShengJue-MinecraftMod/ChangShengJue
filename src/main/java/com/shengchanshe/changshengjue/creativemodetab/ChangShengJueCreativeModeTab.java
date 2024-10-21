package com.shengchanshe.changshengjue.creativemodetab;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ChangShengJue.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_NATURAL_BLOCKS_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_natural_blocks_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_natural_blocks_tab")).icon(() ->
            new ItemStack(ChangShengJueBlocks.TAN_HUA_BLOCK.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueBlocks.CANTALOUPE_BLOCK.get());
                output.accept(ChangShengJueBlocks.MANGO_LEAVES.get());
                output.accept(ChangShengJueBlocks.MANGO_SAPLING.get());
                output.accept(ChangShengJueBlocks.BANANA_LEAVES.get());
                output.accept(ChangShengJueBlocks.BANANA_SAPLING.get());
                output.accept(ChangShengJueBlocks.PEAR_LEAVES.get());
                output.accept(ChangShengJueBlocks.PEAR_SAPLING.get());
                output.accept(ChangShengJueBlocks.LICHEE_LEAVES.get());
                output.accept(ChangShengJueBlocks.LICHEE_SAPLING.get());
                output.accept(ChangShengJueBlocks.DURIAN_LEAVES.get());
                output.accept(ChangShengJueBlocks.DURIAN_SAPLING.get());
                output.accept(ChangShengJueBlocks.GUI_HUA_LEAVES.get());
                output.accept(ChangShengJueBlocks.GUI_HUA_SAPLING.get());
                output.accept(ChangShengJueBlocks.MEI_HUA_LEAVES.get());
                output.accept(ChangShengJueBlocks.MEI_HUA_SAPLING.get());
                output.accept(ChangShengJueBlocks.MUGWORT_BLOCK.get());
                output.accept(ChangShengJueBlocks.CUCKOO_BLOCK.get());
                output.accept(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get());
                output.accept(ChangShengJueBlocks.JASMINE_BLOCK.get());
                output.accept(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get());
                output.accept(ChangShengJueBlocks.TAN_HUA_BLOCK.get());
//                output.accept(ChangShengJueBlocks.GRAPE_SHELF_BLOCK.get());
//                output.accept(ChangShengJueBlocks.PILLAR_BLOCK.get());
                output.accept(ChangShengJueItems.CAPSULE.get());
                output.accept(ChangShengJueItems.RAW_AG.get());
                output.accept(ChangShengJueItems.AG_INGOT.get());
                output.accept(ChangShengJueItems.PINEAPPLE_SEEDS.get());
                output.accept(ChangShengJueItems.TOMATO_SEEDS.get());
                output.accept(ChangShengJueItems.GU_SEEDS.get());
                output.accept(ChangShengJueItems.SORGHUM_SEEDS.get());
                output.accept(ChangShengJueItems.LOTUS_SEEDS.get());
                output.accept(ChangShengJueItems.COTTON_SEEDS.get());
                output.accept(ChangShengJueItems.STICKYRICE_SEEDS.get());
                output.accept(ChangShengJueItems.CORN_SEEDS.get());
                output.accept(ChangShengJueItems.JALAPENOS_SEEDS.get());
                output.accept(ChangShengJueItems.PEANUT_SEEDS.get());
                output.accept(ChangShengJueItems.BRINJAL_SEEDS.get());
                output.accept(ChangShengJueItems.CANTALOUPE_SEEDS.get());
                output.accept(ChangShengJueItems.GRAPE_SEEDS.get());
                output.accept(ChangShengJueItems.SOYBEAN.get());
                output.accept(ChangShengJueItems.REDBEAN.get());

                output.accept(ChangShengJueBlocks.AG_ORE.get());
                output.accept(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get());
                output.accept(ChangShengJueBlocks.KAOLIN_ORE.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_BUILDING_BLOCK_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_building_block_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_building_block_tab")).icon(() ->
                    new ItemStack(ChangShengJueBlocks.MANGO_LOG.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueBlocks.MANGO_LOG.get());
                output.accept(ChangShengJueBlocks.BANANA_LOG.get());
                output.accept(ChangShengJueBlocks.PEAR_LOG.get());
                output.accept(ChangShengJueBlocks.LICHEE_LOG.get());
                output.accept(ChangShengJueBlocks.DURIAN_LOG.get());
                output.accept(ChangShengJueBlocks.GUI_HUA_LOG.get());
                output.accept(ChangShengJueBlocks.MEI_HUA_LOG.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get());
                output.accept(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get());
                output.accept(ChangShengJueBlocks.JI_CHI_MU_WOOD.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_LOG.get());
                output.accept(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get());
                output.accept(ChangShengJueBlocks.ZI_TAN_WOOD.get());
                output.accept(ChangShengJueBlocks.HANG_TU_BLOCK.get());
                output.accept(ChangShengJueBlocks.TU_PEI_BLOCK.get());
                output.accept(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get());
                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_1.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_3.get());
                output.accept(ChangShengJueBlocks.TILE_BLOCK_4.get());
                output.accept(ChangShengJueBlocks.HANG_TU_WALL.get());
                output.accept(ChangShengJueBlocks.TU_PEI_WALL.get());
                output.accept(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get());
                output.accept(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get());
                output.accept(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get());
                output.accept(ChangShengJueBlocks.WHITE_FINE_BRICKS.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_BRICKS.get());
                output.accept(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get());
                output.accept(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get());
                output.accept(ChangShengJueBlocks.HANG_TU_STAIRS.get());
                output.accept(ChangShengJueBlocks.TU_PEI_STAIRS.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get());
                output.accept(ChangShengJueBlocks.HANG_TU_SLAB.get());
                output.accept(ChangShengJueBlocks.TU_PEI_SLAB.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get());
                output.accept(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get());
                output.accept(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get());
                output.accept(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get());
                output.accept(ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get());
                output.accept(ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.DOOR_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get());
                output.accept(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_2.get());
                output.accept(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_2.get());

            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_FUNCTIONAL_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_functional_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_functional_tab")).icon(() ->
                    new ItemStack(ChangShengJueBlocks.TOOL_TABLE.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get());
                output.accept(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get());
                output.accept(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get());
                output.accept(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get());
                output.accept(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get());
                output.accept(ChangShengJueItems.ZHU_TAI.get());
                output.accept(ChangShengJueItems.PAINTING_SCROLL.get());
                output.accept(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get());
                output.accept(ChangShengJueBlocks.POTTERY_WHEEL.get());
                output.accept(ChangShengJueBlocks.TOOL_TABLE.get());
                output.accept(ChangShengJueBlocks.DESK.get());
                output.accept(ChangShengJueBlocks.PIG_TROUGH.get());
            }).build());
    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_FOOD_AND_DRINK_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_food_and_drink_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_food_and_drink_tab")).icon(() ->
                    new ItemStack(ChangShengJueItems.PINEAPPLE.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.PINEAPPLE.get());
                output.accept(ChangShengJueItems.TOMATO.get());
                output.accept(ChangShengJueItems.STICKYRICE_1.get());
                output.accept(ChangShengJueItems.CORN.get());
                output.accept(ChangShengJueItems.MANGO.get());
                output.accept(ChangShengJueItems.GUI_HUA.get());
                output.accept(ChangShengJueItems.MEI_HUA.get());
                output.accept(ChangShengJueItems.CANTALOUPE.get());
                output.accept(ChangShengJueItems.BANANA.get());
                output.accept(ChangShengJueItems.PEAR.get());
                output.accept(ChangShengJueItems.LICHEE.get());
                output.accept(ChangShengJueItems.GRAPE.get());
                output.accept(ChangShengJueItems.OPEN_DURIAN.get());
                output.accept(ChangShengJueItems.PEANUT.get());
                output.accept(ChangShengJueItems.BRINJAL.get());
                output.accept(ChangShengJueItems.CAPSULE_JIAO_ZI.get());
                output.accept(ChangShengJueItems.ZHENG_CAI.get());
                output.accept(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get());
                output.accept(ChangShengJueItems.QING_TUAN.get());
                output.accept(ChangShengJueItems.BAKED_CORN.get());
                output.accept(ChangShengJueItems.TOMATO_EGG.get());
                output.accept(ChangShengJueItems.GU_LAO_ROU.get());
                output.accept(ChangShengJueItems.MEAT_FOAM_BRINJAL.get());
                output.accept(ChangShengJueItems.SORGHUM_CAKE.get());
                output.accept(ChangShengJueItems.STINKY_TOFU.get());
                output.accept(ChangShengJueItems.ZHU_DU_JI.get());
                output.accept(ChangShengJueItems.XIAO_MI_FAN.get());
                output.accept(ChangShengJueItems.MI_FAN.get());
                output.accept(ChangShengJueItems.GUI_HUA_TANG_OU.get());
                output.accept(ChangShengJueItems.BA_BAO_ZHOU.get());
                output.accept(ChangShengJueItems.VENISON.get());
                output.accept(ChangShengJueItems.COOKED_VENISON.get());
                output.accept(ChangShengJueItems.CI_PAN.get());
                output.accept(ChangShengJueItems.CI_WAN.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_INGREDIENTS_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_ingredients_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_ingredients_tab")).icon(() ->
                    new ItemStack(ChangShengJueItems.GU_SUI.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.SOYBEAN.get());
                output.accept(ChangShengJueItems.REDBEAN.get());
                output.accept(ChangShengJueItems.SORGHUM.get());
                output.accept(ChangShengJueItems.GU_SUI.get());
                output.accept(ChangShengJueItems.LOTUS.get());
                output.accept(ChangShengJueItems.LOTUS_ROOT.get());
                output.accept(ChangShengJueItems.COTTON.get());
                output.accept(ChangShengJueItems.STICKYRICE.get());
                output.accept(ChangShengJueItems.JALAPENOS.get());
                output.accept(ChangShengJueItems.CRANE_FEATHERS.get());
                output.accept(ChangShengJueItems.PEACOCK_FEATHERS.get());
                output.accept(ChangShengJueItems.PEACOCK_EGGS.get());
                output.accept(ChangShengJueItems.DEERSKIN.get());
                output.accept(ChangShengJueItems.ANTLER.get());
                output.accept(ChangShengJueItems.DEER_BLOOD.get());
                output.accept(ChangShengJueItems.TIGER_SKIN.get());
                output.accept(ChangShengJueItems.CROC_SKIN.get());
                output.accept(ChangShengJueItems.TONG_QIAN.get());
                output.accept(ChangShengJueItems.YI_GUAN_TONG_QIAN.get());
                output.accept(ChangShengJueItems.SILVER_BULLIONS.get());
                output.accept(ChangShengJueItems.GOLD_BULLIONS.get());
                output.accept(ChangShengJueItems.DURIAN.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> CHANG_SHENG_JUE_SPAWN_EGGS_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register("chang_sheng_jue_spawn_eggs_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.chang_sheng_jue_spawn_eggs_tab")).icon(() ->
                    new ItemStack(ChangShengJueItems.GU_SUI.get())).displayItems((parameters,output)->{
                output.accept(ChangShengJueItems.BUTTERFLY_EGG.get());
                output.accept(ChangShengJueItems.MONKEY_EGG.get());
                output.accept(ChangShengJueItems.DRAGONFLY_EGG.get());
                output.accept(ChangShengJueItems.CICADA_EGG.get());
                output.accept(ChangShengJueItems.CRANE_EGG.get());
                output.accept(ChangShengJueItems.PEACOCK_EGG.get());
                output.accept(ChangShengJueItems.PEACOCK_EGG_1.get());
                output.accept(ChangShengJueItems.STAG_EGG.get());
                output.accept(ChangShengJueItems.HIND_EGG.get());
                output.accept(ChangShengJueItems.TIGER_EGG.get());
                output.accept(ChangShengJueItems.CROC_EGG.get());
                output.accept(ChangShengJueItems.CHANG_SHENG_JUE_VILLAGER_EGG.get());
            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }
}
