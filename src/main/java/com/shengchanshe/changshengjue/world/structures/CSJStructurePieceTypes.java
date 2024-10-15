package com.shengchanshe.changshengjue.world.structures;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.world.structures.piece.CSJStructurePieces;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;

public class CSJStructurePieceTypes {
    // 注册器
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = DeferredRegister.create(Registries.STRUCTURE_PIECE, ChangShengJue.MOD_ID);
    // 注册的对象
    public static final RegistryObject<StructurePieceType> SI_HE_YUAN_PIECE  = registerPieceType("si_he_yuan_piece", CSJStructurePieces.CSJStructurePiece::new);
    // 辅助注册的方法
    private static RegistryObject<StructurePieceType> registerPieceType(String name, StructurePieceType.StructureTemplateType structurePieceType) {
        // 第一个参数是name，第二个参数是构造方法
        // 第二个参数补充一点是StructureTemplateType是一个接口，只有一个方法，其实就是要求传入一个该接口的实例，这个接口实现方法应该传入
        // 两个StructureTemplateManager和CompoundTag参数返回一个StructurePiece
        // 所以这里可以直接是使用new构造方法。
        // 而register要求返回一个supplier，所以就这样写了。
        return STRUCTURE_PIECE_TYPES.register(name.toLowerCase(Locale.ROOT), () -> structurePieceType);
    }
    // 别忘记添加到总线
    public static void register(IEventBus eventBus){
        STRUCTURE_PIECE_TYPES.register(eventBus);
    }
}
