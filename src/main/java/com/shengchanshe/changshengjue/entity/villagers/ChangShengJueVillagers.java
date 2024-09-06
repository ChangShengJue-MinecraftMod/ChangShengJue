package com.shengchanshe.changshengjue.entity.villagers;

import com.google.common.collect.ImmutableSet;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ChangShengJueVillagers {

    public static final DeferredRegister<PoiType> POT_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, ChangShengJue.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,ChangShengJue.MOD_ID);

    public static final RegistryObject<PoiType> CHANG_SHENG_JUE_FARMER_POT = POT_TYPES.register("chang_sheng_jue_farmer_pot",
            ()-> new PoiType(ImmutableSet.copyOf(ChangShengJueBlocks.BANANA_LOG.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_FARMER = VILLAGER_PROFESSION.register("chang_sheng_jue_farmer",
            ()-> new VillagerProfession("chang_sheng_jue_farmer",
                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_FARMER_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_FARMER_POT.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));

    public static void register(IEventBus eventBus){
        POT_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}
