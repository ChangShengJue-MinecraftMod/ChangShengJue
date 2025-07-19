package com.shengchanshe.chang_sheng_jue.world;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;

public class CSJStructures {
    public final static ResourceKey<Structure> PIT_YARD = createKey(ChangShengJue.MOD_ID + ":pit_yard");
    public final static ResourceKey<Structure> SANDSTONE_CASTLE = createKey(ChangShengJue.MOD_ID + ":sandstone_castle");
    public final static ResourceKey<Structure> SI_HE_YUAN = createKey(ChangShengJue.MOD_ID + ":si_he_yuan");
    public final static ResourceKey<Structure> SU_PAI_VILLAGE = createKey(ChangShengJue.MOD_ID + ":su_pai_village");
    public final static ResourceKey<Structure> HUI_PAI_VILLAGE = createKey(ChangShengJue.MOD_ID + ":hui_pai_village");
    public final static ResourceKey<Structure> FORTRESSES = createKey(ChangShengJue.MOD_ID + ":fortresses");


    private static ResourceKey<Structure> createKey(String pName) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(pName));
    }
}
