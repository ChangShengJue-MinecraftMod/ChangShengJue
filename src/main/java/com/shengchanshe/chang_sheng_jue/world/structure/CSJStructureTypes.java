package com.shengchanshe.chang_sheng_jue.world.structure;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class CSJStructureTypes {
    private CSJStructureTypes() {
    }

    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, ChangShengJue.MOD_ID);

    public static final RegistryObject<StructureType<FortressSlopeJigsawStructure>> FORTRESS_SLOPE_JIGSAW =
            STRUCTURE_TYPES.register("flat_checked_jigsaw", () -> () -> FortressSlopeJigsawStructure.CODEC);

    public static void register(IEventBus eventBus) {
        STRUCTURE_TYPES.register(eventBus);
    }
}
