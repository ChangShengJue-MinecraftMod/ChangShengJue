package com.shengchanshe.chang_sheng_jue.world.processor;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class CSJProcessorTypes {
    private CSJProcessorTypes() {
    }

    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSORS =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, ChangShengJue.MOD_ID);

    public static final RegistryObject<StructureProcessorType<BlueStoneBrickFoundationProcessor>> BLUE_STONE_BRICK_FOUNDATION =
            STRUCTURE_PROCESSORS.register("blue_stone_brick_foundation", () -> () -> BlueStoneBrickFoundationProcessor.CODEC);

    public static void register(IEventBus eventBus) {
        STRUCTURE_PROCESSORS.register(eventBus);
    }
}
