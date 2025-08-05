package com.shengchanshe.chang_sheng_jue.util;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.List;
import java.util.function.Function;

public class TradeHelper {
    /**
     * 为指定等级添加两个不重复的交易
     */
    public static void addTradesForLevel(Int2ObjectMap<List<VillagerTrades.ItemListing>> trades,
                                         int level, ItemStack[] items,
                                         Function<ItemStack, MerchantOffer> offerCreator) {
        final int[] firstIndex = new int[1];

        trades.get(level).add((trader, rand) -> {
            firstIndex[0] = rand.nextInt(items.length);
            ItemStack firstStack = items[firstIndex[0]].copy();
            return offerCreator.apply(firstStack);
        });

        trades.get(level).add((trader, rand) -> {
            int secondIndex;
            do {
                secondIndex = rand.nextInt(items.length);
            } while (secondIndex == firstIndex[0]);

            ItemStack secondStack = items[secondIndex].copy();
            return offerCreator.apply(secondStack);
        });
    }
}
