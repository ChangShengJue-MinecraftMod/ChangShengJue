package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;
import java.util.HashSet;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CSJFuelProvider {
    @SubscribeEvent
    public static void onFuelRegister(FurnaceFuelBurnTimeEvent event) {
        HashSet<Block> fuelItems = new HashSet<>(Arrays.asList(
                ChangShengJueBlocks.MANGO_SAPLING.get(),
                ChangShengJueBlocks.GUI_HUA_SAPLING.get(),
                ChangShengJueBlocks.MEI_HUA_SAPLING.get(),
                ChangShengJueBlocks.BANANA_SAPLING.get(),
                ChangShengJueBlocks.PEAR_SAPLING.get(),
                ChangShengJueBlocks.LICHEE_SAPLING.get(),
                ChangShengJueBlocks.DURIAN_SAPLING.get(),
                ChangShengJueBlocks.ZI_TAN_SAPLING.get(),
                ChangShengJueBlocks.POPLAR_SAPLING.get(),
                ChangShengJueBlocks.MULBERRY_SAPLING.get(),
                ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get(),
                ChangShengJueBlocks.JI_CHI_MU_SAPLING.get()
        ));
        for (Block block : fuelItems){
            Item saplingItem = Item.byBlock(block);

            int saplingBurnTime = 200;

            event.setBurnTime(event.getItemStack().getItem() == saplingItem ? saplingBurnTime : event.getBurnTime());
        }
    }
}