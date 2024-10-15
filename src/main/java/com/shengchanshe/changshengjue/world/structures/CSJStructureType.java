package com.shengchanshe.changshengjue.world.structures;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.world.structures.structure.SiHeYuanStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CSJStructureType<S extends Structure>  {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, ChangShengJue.MOD_ID);

    public static final RegistryObject<StructureType<SiHeYuanStructure>> SI_HE_YUAN = registerType("si_he_yuan", () -> () -> SiHeYuanStructure.CODEC);

    // 也许你会好奇为什么这里的要求一个supplier提供StructureType，但是给出的是两个() -> () -> MyStructure.CODEC，并且是一个Codec
    // 其实你点开StructureType，会发现这就是一个interface，只有一个方法，就是要求一个没有参数，返回值是codec的函数，
    // 所以() -> MyStructure.CODEC 这个lammbda就是对应StructureType接口的一个实现。
    private static <P extends Structure> RegistryObject<StructureType<P>> registerType(String name, Supplier<StructureType<P>> factory) {
        return STRUCTURE_TYPES.register(name, factory);
    }

    public static void register(IEventBus eventBus){
        STRUCTURE_TYPES.register(eventBus);
    }
}
