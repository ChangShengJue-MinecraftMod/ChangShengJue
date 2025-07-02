package com.shengchanshe.chang_sheng_jue.world.biome;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class CSJTerrablender {
    public static void registerBiomes(){
        Regions.register(new CSJOverworldRegion(new ResourceLocation(ChangShengJue.MOD_ID,"overworld"),5));
    }
}
