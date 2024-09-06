//package com.shengchanshe.changshengjue.world.structures;
//
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import static com.shengchanshe.changshengjue.ChangShengJue.MOD_ID;
//
//public class Registration {
//    private static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, MOD_ID);
//
//    public static final RegistryObject<StructureFeature<JigsawConfiguration>> SI_HE_YUAN = STRUCTURES.register("si_he_yuan", SiHeYuanStructure::new);
//
//    public static void init() {
//        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();;
//        STRUCTURES.register(eventBus);
//    }
//}
