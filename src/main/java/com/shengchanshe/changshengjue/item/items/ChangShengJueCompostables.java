package com.shengchanshe.changshengjue.item.items;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangShengJueCompostables {
    @SubscribeEvent
    public static void onFMLLoadComplete(FMLLoadCompleteEvent event) {
        registerCompostable(ChangShengJueItems.PINEAPPLE_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.TOMATO_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.GU_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.SORGHUM_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.LOTUS_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.COTTON_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.STICKYRICE_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.CORN_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.JALAPENOS_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.PEANUT_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.BRINJAL_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.CANTALOUPE_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.GRAPE_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.RICE_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.BILUOCHUN_TEA_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.LONG_JING_TEA_SEEDS.get(), 0.3f);
        registerCompostable(ChangShengJueItems.HORDEUM_SEEDS.get(), 0.3f);
    }

    private static void registerCompostable(Item item, float chance) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);

    }
}
