package com.shengchanshe.chang_sheng_jue.world.village;

import com.google.common.collect.ImmutableMap;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.items.Parcel;
import com.shengchanshe.chang_sheng_jue.item.items.StructureIntelligence;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class WuXiaMerahantTrades {
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> INNKEEPER_TRADES;
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> BLACKSMITH_TRADES;
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> KILN_WORKER_TRADES;

    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> CLUBBED_AND_LANCE_GANG_LEADER_TRADES;
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> KNIFE_AND_SWORD_GANG_LEADER_TRADES;
    public static final Int2ObjectMap<VillagerTrades.ItemListing[]> OTHER_GANG_LEADER_TRADES;

    static {
        INNKEEPER_TRADES = toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueItems.BILUOCHUN_TEAS.get(), 1, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.LONG_JING_TEAS.get(), 1, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.FEN_JIU.get(), 1, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get(), 1, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.SHI_LI_XIANG.get(), 1, 1, 16, 1),
                }, 2, new VillagerTrades.ItemListing[]{
                        new ItemsForEmeralds(ChangShengJueItems.CI_WAN.get(), 1, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.CI_WAN.get(), 1, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.EMPTY_FEN_JIU.get(), 1, 1, 16, 1),
                }, 3, new VillagerTrades.ItemListing[]{
                        new ItemsForEmeralds(ChangShengJueItems.GU_LAO_ROU.get(), 2, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.MEAT_FOAM_BRINJAL.get(), 2, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.ZHU_DU_JI.get(), 2, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.GUI_HUA_TANG_OU.get(), 2, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.BA_BAO_ZHOU.get(), 2, 1, 16, 1),
                }, 4, new VillagerTrades.ItemListing[]{
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.ZHENG_CAI.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 4, 1, ChangShengJueItems.QING_TUAN.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.TOMATO_EGG.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.CAPSULE_JIAO_ZI.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 3, 1, ChangShengJueItems.STINKY_TOFU.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.XIAO_MI_FAN.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.MI_FAN.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.MULBERRY_JUICE.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.APPLE_JUICE.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.HOT_PEAR_SOUP.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.GRAPE_JUICE.get(), 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(), 1, 1, 16, 1),
                        new ItemsForEmeralds(ChangShengJueItems.SORGHUM_CAKE.get(), 1, 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 1, 1, ChangShengJueItems.MULBERRY.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 2, 1, ChangShengJueItems.BAKED_CORN.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 1, 1, ChangShengJueItems.GRAPE.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 1, 1, ChangShengJueItems.BANANA.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 1, 1, ChangShengJueItems.PEAR.get(), 1, 16, 1),
                },5, new VillagerTrades.ItemListing[]{
                        new StructureIntelTrade(StructureIntelligence.PIT_YARD_TYPE, 2, 1, 16, 1),
                        new StructureIntelTrade(StructureIntelligence.SANDSTONE_CASTLE_TYPE, 2, 1, 16, 1),
                        new StructureIntelTrade(StructureIntelligence.SI_HE_YUAN_TYPE, 2, 1, 16, 1),
                        new StructureIntelTrade(StructureIntelligence.SU_PAI_VILLAGE_TYPE, 2, 1, 16, 1),
                        new StructureIntelTrade(StructureIntelligence.WAN_PAI_VILLAGE_TYPE, 2, 1, 16, 1),
                }
        ));

        BLACKSMITH_TRADES = toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueItems.BRONZE_SWORD.get(), 1, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.HAN_JIAN.get(), 2, 1, 16, 1),
                        new BullionsToItems(ChangShengJueItems.SILVER_BULLIONS.get(), 2, ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 2,
                                ChangShengJueItems.SOFT_SWORD.get(), 1, 16, 1),
                        new BullionsToItems(ChangShengJueItems.SILVER_BULLIONS.get(), 1, ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 4,
                                ChangShengJueItems.HENG_DAO.get(), 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.LARGE_KNIFE.get(), 2, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.RED_TASSELLED_SPEAR.get(), 2, 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.PAN_HUA_GUN.get(), 2, 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 0, 4, ChangShengJueItems.KITCHEN_KNIFE.get(), 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 0, 2, ChangShengJueItems.THROWING_KNIVES.get(), 1, 16, 1),
                        new BullionsForItems(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get(), 2, 1, 16, 1),
                        new CoinsToItems(ChangShengJueItems.TONG_QIAN.get(), 0, 5, ChangShengJueItems.LEATHER_INNER_ARMOR.get(), 1, 16, 1),
                }, 2, new VillagerTrades.ItemListing[]{
                        new BullionsToItems(ChangShengJueItems.SILVER_BULLIONS.get(), 9, ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 1,
                                Parcel.createCottonParcel().getItem(), 1, 16, 1),
                        new BullionsToItems(ChangShengJueItems.SILVER_BULLIONS.get(), 9, ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 3,
                                Parcel.createMountainParcel().getItem(), 1, 16, 1),
                        new BullionsToItems(ChangShengJueItems.SILVER_BULLIONS.get(), 9, ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), 3,
                                Parcel.createMingguangParcel().getItem(), 1, 16, 1),
                }
        ));

        KILN_WORKER_TRADES = toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_8.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_ROOF_RIDGE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_DEMON_MASK.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_HIPPED_ROOF.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(), 4, 64, 16, 1),
                }, 2, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_8.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_ROOF_RIDGE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_DEMON_MASK.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_HIPPED_ROOF.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(), 4, 64, 16, 1),
                }, 3, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_8.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_DEMON_MASK.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(), 4, 64, 16, 1),
                }, 4, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_8.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_DEMON_MASK.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(), 4, 64, 16, 1),
                }, 5, new VillagerTrades.ItemListing[]{
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_8.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(), 2, 64, 16, 1),

                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(), 2, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(), 4, 64, 16, 1),
                        new BullionsForItems(ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(), 4, 64, 16, 1),
                }
        ));
        CLUBBED_AND_LANCE_GANG_LEADER_TRADES = toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                        new GangTokenForItems(ChangShengJueItems.RED_TASSELLED_SPEAR.get(), 2, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.PAN_HUA_GUN.get(), 3, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.SHAOLIN_STICK_METHOD.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.GAO_MARKSMANSHIP.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.GOLDEN_BELL_JAR.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get(), 20, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.HERCULES.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.IMMORTAL_MIRACLE.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get(), 10, 16, 1),
                }, 2, new VillagerTrades.ItemListing[]{
                        new GangTokenForItems(ChangShengJueItems.BA_WANG_QIANG.get().getDefaultInstance(), 35, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.BEAT_DOG_STICK.get().getDefaultInstance(), 35, 16, 1),
                }
        ));
        KNIFE_AND_SWORD_GANG_LEADER_TRADES = toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                        new GangTokenForItems(ChangShengJueItems.HAN_JIAN.get(), 3, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.LARGE_KNIFE.get(), 3, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.HENG_DAO.get(), 2, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.BRONZE_SWORD.get(), 1, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.SOFT_SWORD.get(), 3, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.DUGU_NINE_SWORDS.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(), 10, 16, 1),
                }, 2, new VillagerTrades.ItemListing[]{
                        new GangTokenForItems(ChangShengJueItems.YI_TIAN_JIAN.get().getDefaultInstance(), 35, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.TU_LONG_DAO.get().getDefaultInstance(), 35, 16, 1),
                }
        ));
        OTHER_GANG_LEADER_TRADES = toIntMap(ImmutableMap.of(1, new VillagerTrades.ItemListing[]{
                        new GangTokenForItems(ChangShengJueItems.KITCHEN_KNIFE.get(), 2, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.THROWING_KNIVES.get(), 1, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get(), 5, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.WU_GANG_CUT_GUI.get(), 5, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.PAODING.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get(), 15, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.TURTLE_BREATH_WORK.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.GE_SHAN_DA_NIU.get(), 10, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get(), 10, 16, 1)
                }, 2, new VillagerTrades.ItemListing[]{
                        new GangTokenForItems(ChangShengJueItems.KAISHAN_PICKAXE.get().getDefaultInstance(), 3, 16, 1),
                        new GangTokenForItems(ChangShengJueItems.XUANHUA_AXE.get().getDefaultInstance(), 3, 16, 1),
                }
        ));
    }


    private static Int2ObjectMap<VillagerTrades.ItemListing[]> toIntMap(ImmutableMap<Integer, VillagerTrades.ItemListing[]> pMap) {
        return new Int2ObjectOpenHashMap(pMap);
    }

    static class ItemsForEmeralds implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int emeraldCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public ItemsForEmeralds(Block pBlock, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
            this(new ItemStack(pBlock), pEmeraldCost, pNumberOfItems, pMaxUses, pVillagerXp);
        }

        public ItemsForEmeralds(Item pItem, int pEmeraldCost, int pNumberOfItems, int pVillagerXp) {
            this((ItemStack) (new ItemStack(pItem)), pEmeraldCost, pNumberOfItems, 12, pVillagerXp);
        }

        public ItemsForEmeralds(Item pItem, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
            this(new ItemStack(pItem), pEmeraldCost, pNumberOfItems, pMaxUses, pVillagerXp);
        }

        public ItemsForEmeralds(ItemStack pItemStack, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
            this(pItemStack, pEmeraldCost, pNumberOfItems, pMaxUses, pVillagerXp, 0.05F);
        }

        public ItemsForEmeralds(ItemStack pItemStack, int pEmeraldCost, int pNumberOfItems, int pMaxUses, int pVillagerXp, float pPriceMultiplier) {
            this.itemStack = pItemStack;
            this.emeraldCost = pEmeraldCost;
            this.numberOfItems = pNumberOfItems;
            this.maxUses = pMaxUses;
            this.villagerXp = pVillagerXp;
            this.priceMultiplier = pPriceMultiplier;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), this.emeraldCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }

    static class CoinsToItems implements VillagerTrades.ItemListing {
        private final ItemStack fromItem;
        private final int fromCount;
        private final int coinsCost;
        private final ItemStack toItem;
        private final int toCount;
        private final int maxUses;
        private final int Xp;

        public CoinsToItems(ItemLike forItem, int fromCount, int coinsCost, Item toItem, int toCount, int maxUses, int Xp) {
            this.fromItem = new ItemStack(forItem);
            this.fromCount = fromCount;
            this.coinsCost = coinsCost;
            this.toItem = new ItemStack(toItem);
            this.toCount = toCount;
            this.maxUses = maxUses;
            this.Xp = Xp;
        }

        @Nullable
        @Override
        public MerchantOffer getOffer(Entity trader, RandomSource rand) {
            return new MerchantOffer(new ItemStack(ChangShengJueItems.YI_GUAN_TONG_QIAN.get(), this.coinsCost),
                    new ItemStack(this.fromItem.getItem(), this.fromCount),
                    new ItemStack(this.toItem.getItem(), this.toCount),
                    this.maxUses, this.Xp, 0.05F);
        }
    }

    static class StructureIntelTrade implements VillagerTrades.ItemListing {
        private final int structureType;
        private final int bullionsCost;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public StructureIntelTrade(int structureType, int bullionsCost, int maxUses, int villagerXp) {
            this(structureType, bullionsCost, maxUses, villagerXp, 0.05F);
        }

        public StructureIntelTrade(int structureType, int bullionsCost, int maxUses, int villagerXp, float priceMultiplier) {
            this.structureType = structureType;
            this.bullionsCost = bullionsCost;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
            this.priceMultiplier = priceMultiplier;
        }

        @Override
        public MerchantOffer getOffer(Entity trader, RandomSource random) {
            // 1. 创建新的情报物品（不能复用ItemStack！）
            ItemStack intel = new ItemStack(ChangShengJueItems.STRUCTURE_INTELLIGENCE.get());

            // 2. 设置DamageValue区分类型
            intel.setDamageValue(this.structureType);

            // 3. 添加结构类型标识
            intel.getOrCreateTag().putInt("StructureType", this.structureType);

            // 4. 创建交易报价
            return new MerchantOffer(
                    new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), this.bullionsCost),
                    intel,
                    this.maxUses,
                    this.villagerXp,
                    this.priceMultiplier
            );
        }
    }

    static class BullionsForItems implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int bullionsCost;
        private final int numberOfItems;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public BullionsForItems(Block pBlock, int pBullionsCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
            this(new ItemStack(pBlock), pBullionsCost, pNumberOfItems, pMaxUses, pVillagerXp);
        }

        public BullionsForItems(Item pItem, int pBullionsCost, int pNumberOfItems, int pVillagerXp) {
            this(new ItemStack(pItem), pBullionsCost, pNumberOfItems, 12, pVillagerXp);
        }

        public BullionsForItems(Item pItem, int pBullionsCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
            this(new ItemStack(pItem), pBullionsCost, pNumberOfItems, pMaxUses, pVillagerXp);
        }

        public BullionsForItems(ItemStack pItemStack, int pBullionsCost, int pNumberOfItems, int pMaxUses, int pVillagerXp) {
            this(pItemStack, pBullionsCost, pNumberOfItems, pMaxUses, pVillagerXp, 0.05F);
        }

        public BullionsForItems(ItemStack pItemStack, int pBullionsCost, int pNumberOfItems, int pMaxUses, int pVillagerXp, float pPriceMultiplier) {
            this.itemStack = pItemStack;
            this.bullionsCost = pBullionsCost;
            this.numberOfItems = pNumberOfItems;
            this.maxUses = pMaxUses;
            this.villagerXp = pVillagerXp;
            this.priceMultiplier = pPriceMultiplier;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            return new MerchantOffer(new ItemStack(ChangShengJueItems.SILVER_BULLIONS.get(), this.bullionsCost), new ItemStack(this.itemStack.getItem(), this.numberOfItems), this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }

    static class GangTokenForItems implements VillagerTrades.ItemListing {
        private final ItemStack itemStack;
        private final int gangTokenCost;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;

        public GangTokenForItems(Block pBlock, int pGangTokenCost, int pMaxUses, int pVillagerXp) {
            this(new ItemStack(pBlock), pGangTokenCost, pMaxUses, pVillagerXp);
        }

        public GangTokenForItems(Item pItem, int pGangTokenCost, int pVillagerXp) {
            this(new ItemStack(pItem), pGangTokenCost, 12, pVillagerXp);
        }

        public GangTokenForItems(Item pItem, int pGangTokenCost, int pMaxUses, int pVillagerXp) {
            this(new ItemStack(pItem), pGangTokenCost, pMaxUses, pVillagerXp);
        }

        public GangTokenForItems(ItemStack pItemStack, int pGangTokenCost, int pMaxUses, int pVillagerXp) {
            this(pItemStack, pGangTokenCost, pMaxUses, pVillagerXp, 0.05F);
        }

        public GangTokenForItems(ItemStack pItemStack, int pGangTokenCost, int pMaxUses, int pVillagerXp, float pPriceMultiplier) {
            this.itemStack = pItemStack;
            this.gangTokenCost = pGangTokenCost;
            this.maxUses = pMaxUses;
            this.villagerXp = pVillagerXp;
            this.priceMultiplier = pPriceMultiplier;
        }

        public MerchantOffer getOffer(Entity pTrader, RandomSource pRandom) {
            return new MerchantOffer(new ItemStack(ChangShengJueItems.GANG_TOKEN.get(), this.gangTokenCost), this.itemStack, this.maxUses, this.villagerXp, this.priceMultiplier);
        }
    }

    static class BullionsToItems implements VillagerTrades.ItemListing {
        private final ItemStack bullions;
        private final int bullionsCost;
        private final ItemStack fromItem;
        private final int fromCount;
        private final ItemStack toItem;
        private final int toCount;
        private final int maxUses;
        private final int Xp;

        public BullionsToItems(ItemLike bullions, int bullionsCost, ItemLike forItem, int fromCount, Item toItem, int toCount, int maxUses, int Xp) {
            this.bullions = new ItemStack(bullions);
            this.fromItem = new ItemStack(forItem);
            this.fromCount = fromCount;
            this.bullionsCost = bullionsCost;
            this.toItem = new ItemStack(toItem);
            this.toCount = toCount;
            this.maxUses = maxUses;
            this.Xp = Xp;
        }

        @Nullable
        @Override
        public MerchantOffer getOffer(Entity trader, RandomSource rand) {
            return new MerchantOffer(new ItemStack(this.bullions.getItem(), this.bullionsCost),
                    new ItemStack(this.fromItem.getItem(), this.fromCount),
                    new ItemStack(this.toItem.getItem(), this.toCount),
                    this.maxUses, this.Xp, 0.05F);
        }
    }
}
