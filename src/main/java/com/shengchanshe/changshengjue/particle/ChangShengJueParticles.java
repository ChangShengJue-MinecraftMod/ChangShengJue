package com.shengchanshe.changshengjue.particle;

import com.shengchanshe.changshengjue.ChangShengJue;
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

    public static final RegistryObject<SimpleParticleType> COMPREHEND_PARTICLE =
            PARTICLE_TYPES.register("comprehend_particle", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> COMPREHEND_PARTICLE_2 =
            PARTICLE_TYPES.register("comprehend_particle_2", () -> new SimpleParticleType(true));

    public static final RegistryObject<SimpleParticleType> DACHENG_PARTICLE =
            PARTICLE_TYPES.register("dacheng_particle", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
