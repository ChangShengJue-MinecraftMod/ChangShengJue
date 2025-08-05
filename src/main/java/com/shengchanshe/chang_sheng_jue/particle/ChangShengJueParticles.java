package com.shengchanshe.chang_sheng_jue.particle;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, ChangShengJue.MOD_ID);

    public static final RegistryObject<SimpleParticleType> POPLAR_DEFOLIATION_PARTICLE =
            PARTICLE_TYPES.register("poplar_defoliation_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> GUI_HUA_DEFOLIATION_PARTICLE =
            PARTICLE_TYPES.register("gui_hua_defoliation_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> MEI_HUA_DEFOLIATION_PARTICLE =
            PARTICLE_TYPES.register("mei_hua_defoliation_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> COMPREHEND_PARTICLE =
            PARTICLE_TYPES.register("comprehend_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> COMPREHEND_PARTICLE_2 =
            PARTICLE_TYPES.register("comprehend_particle_2", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> DACHENG_PARTICLE =
            PARTICLE_TYPES.register("dacheng_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> IMMORTAL_MIRACLE_PARTICLE =
            PARTICLE_TYPES.register("immortal_miracle_particle", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> SUNFLOWER_POINT_CAVEMAN_PARTICLE =
            PARTICLE_TYPES.register("sunflower_point_caveman_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SUNFLOWER_POINT_CAVEMAN_PARTICLE_1 =
            PARTICLE_TYPES.register("sunflower_point_caveman_particle_1", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> SUNFLOWER_POINT_CAVEMAN_PARTICLE_2 =
            PARTICLE_TYPES.register("sunflower_point_caveman_particle_2", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> WU_GANG_CUT_GUI_PARTICLE =
            PARTICLE_TYPES.register("wu_gang_cut_gui_particle", () -> new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> WU_GANG_CUT_GUI_PARTICLE_1 =
            PARTICLE_TYPES.register("wu_gang_cut_gui_particle_1", () -> new SimpleParticleType(false));

//    public static final RegistryObject<SimpleParticleType> GOLDEN_BELL_JAR_PARTICLE =
//            PARTICLE_TYPES.register("golden_bell_jar_particle", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> TREAD_THE_SNOW_WITHOUT_TRACE_PARTICLE =
            PARTICLE_TYPES.register("tread_the_snow_without_trace_particle", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> GE_SHAN_DA_NIU_PARTICLE =
            PARTICLE_TYPES.register("ge_shan_da_niu_particle", () -> new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> THROWING_KNIVES_PARTICLE =
            PARTICLE_TYPES.register("throwing_knives_particle", () -> new SimpleParticleType(false));

    //锻造炉
    public static final RegistryObject<SimpleParticleType> FORGE_BLOCK_PARTCLE =
            PARTICLE_TYPES.register("forge_block_partcle", () -> new SimpleParticleType(false));

    //木桩
    public static final RegistryObject<SimpleParticleType> STAKES_PARTICLE =
            PARTICLE_TYPES.register("stakes_particle", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
