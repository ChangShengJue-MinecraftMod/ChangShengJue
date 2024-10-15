package com.shengchanshe.changshengjue.world.structures;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.world.structures.structure.SiHeYuanStructure;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraftforge.common.Tags;

import java.util.Map;

public class CSJStructures {
    // 以下的三个辅助的方法用于获得StructureSettings这个类
    // 和之前讲解StructureSettings的一致，就不赘述了。
    public static Structure.StructureSettings structure(HolderSet<Biome> pBiomes, Map<MobCategory, StructureSpawnOverride> pSpawnOverrides, GenerationStep.Decoration pStep, TerrainAdjustment pTerrainAdaptation) {
        return new Structure.StructureSettings(pBiomes, pSpawnOverrides, pStep, pTerrainAdaptation);
    }
    private static Structure.StructureSettings structure(HolderSet<Biome> pBiomes, GenerationStep.Decoration pStep, TerrainAdjustment pTerrainAdaptation) {
        return structure(pBiomes, Map.of(), pStep, pTerrainAdaptation);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> pBiomes, TerrainAdjustment pTerrainAdaptation) {
        return structure(pBiomes, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, pTerrainAdaptation);
    }
    // strucutre的key
    public static final ResourceKey<Structure> SI_HE_YUAN = registerKey("si_he_yuan");
    // 创建key的方法
    public static ResourceKey<Structure> registerKey(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(ChangShengJue.MOD_ID,name));
    }
    // bootstrap在数据生成时候调用
    public static void bootstrap(BootstapContext<Structure> context) {
        // 从上下文中获得所有的生物群系
        HolderGetter<Biome> biomeHolderGetter = context.lookup(Registries.BIOME);
        // 第一个参数是key
        // 第二个参数就是我们的strucutre的构造
        // 构造的要传入一个StructureSettings
        // setting的一个参数是生物群系，第二个参数设置的是结构和地面的
        context.register(
                CSJStructures.SI_HE_YUAN,
                new SiHeYuanStructure(structure(biomeHolderGetter.getOrThrow(Tags.Biomes.IS_PLAINS), TerrainAdjustment.BEARD_THIN))
        );

    }
}
