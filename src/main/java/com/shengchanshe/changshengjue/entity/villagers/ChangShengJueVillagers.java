package com.shengchanshe.changshengjue.entity.villagers;

import com.google.common.collect.ImmutableSet;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueVillagers {

    public static final DeferredRegister<PoiType> POT_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, ChangShengJue.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS,ChangShengJue.MOD_ID);


    public static final RegistryObject<PoiType> CHANG_SHENG_JUE_FARMER_POT = POT_TYPES.register("chang_sheng_jue_farmer_pot",
            ()-> new PoiType(ImmutableSet.copyOf(ChangShengJueBlocks.PIG_TROUGH.get().getStateDefinition().getPossibleStates()),1,1));
    public static final RegistryObject<PoiType> CHANG_SHENG_JUE_POTTER_POT = POT_TYPES.register("chang_sheng_jue_potter_pot",
            ()-> new PoiType(ImmutableSet.copyOf(ChangShengJueBlocks.POTTERY_WHEEL.get().getStateDefinition().getPossibleStates()),1,1));
    public static final RegistryObject<PoiType> CHANG_SHENG_JUE_HUNTER_POT = POT_TYPES.register("chang_sheng_jue_hunter_pot",
            ()-> new PoiType(ImmutableSet.copyOf(ChangShengJueBlocks.TOOL_TABLE.get().getStateDefinition().getPossibleStates()),1,1));
    public static final RegistryObject<PoiType> CHANG_SHENG_JUE_CHIEF_POT = POT_TYPES.register("chang_sheng_jue_chief_pot",
            ()-> new PoiType(ImmutableSet.copyOf(ChangShengJueBlocks.DESK.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<PoiType> CHANG_SHENG_JUE_SEAMSTRESS_POT = POT_TYPES.register("chang_sheng_jue_seamstress_pot",
            ()-> new PoiType(ImmutableSet.copyOf(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_FARMER = VILLAGER_PROFESSION.register("chang_sheng_jue_farmer",
            ()-> new VillagerProfession("chang_sheng_jue_farmer",
                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_FARMER_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_FARMER_POT.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_FARMER));

    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_POTTER = VILLAGER_PROFESSION.register("chang_sheng_jue_potter",
            ()-> new VillagerProfession("chang_sheng_jue_potter",
                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_POTTER_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_POTTER_POT.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));

//    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_POTTER_1 = VILLAGER_PROFESSION.register("chang_sheng_jue_potter_1",
//            ()-> new VillagerProfession("chang_sheng_jue_potter_1",
//                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_POTTER_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_POTTER_POT.get(),
//                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_HUNTER = VILLAGER_PROFESSION.register("chang_sheng_jue_hunter",
            ()-> new VillagerProfession("chang_sheng_jue_hunter",
                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_HUNTER_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_HUNTER_POT.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_TOOLSMITH));

    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_CHIEF = VILLAGER_PROFESSION.register("chang_sheng_jue_chief",
            ()-> new VillagerProfession("chang_sheng_jue_chief",
                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_CHIEF_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_CHIEF_POT.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static final RegistryObject<VillagerProfession> CHANG_SHENG_JUE_SEAMSTRESS = VILLAGER_PROFESSION.register("chang_sheng_jue_seamstress",
            ()-> new VillagerProfession("chang_sheng_jue_seamstress",
                    poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_SEAMSTRESS_POT.get(), poiTypeHolder -> poiTypeHolder.get() == CHANG_SHENG_JUE_SEAMSTRESS_POT.get(),
                    ImmutableSet.of(),ImmutableSet.of(), SoundEvents.VILLAGER_WORK_CARTOGRAPHER));

    public static void register(IEventBus eventBus){
        POT_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }
}
