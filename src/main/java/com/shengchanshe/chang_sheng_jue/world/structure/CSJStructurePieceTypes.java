package com.shengchanshe.chang_sheng_jue.world.structure;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class CSJStructurePieceTypes {
    private CSJStructurePieceTypes() {
    }

    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECES =
            DeferredRegister.create(Registries.STRUCTURE_PIECE, ChangShengJue.MOD_ID);

    public static final RegistryObject<StructurePieceType> FORTRESS_INTERIOR_CLEAR =
            STRUCTURE_PIECES.register("fortress_interior_clear", () -> FortressInteriorClearPiece::new);

    public static void register(IEventBus eventBus) {
        STRUCTURE_PIECES.register(eventBus);
    }
}
