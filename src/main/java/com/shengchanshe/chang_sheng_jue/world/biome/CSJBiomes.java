package com.shengchanshe.chang_sheng_jue.world.biome;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.world.feature.CSJPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class CSJBiomes {

    public static final ResourceKey<Biome> CHANG_SHENG_JUE_PRAIRIE = ResourceKey.create(Registries.BIOME,new ResourceLocation(ChangShengJue.MOD_ID,"chang_sheng_jue_prairie"));

    public static void boostrap(BootstapContext<Biome> context){
        context.register(CHANG_SHENG_JUE_PRAIRIE,changShengJuePrairie(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome changShengJuePrairie(BootstapContext<Biome> context){
        MobSpawnSettings.Builder builder = new MobSpawnSettings.Builder();
        //在自定义群系中生成生物
        builder.addSpawn(MobCategory.CREATURE,new MobSpawnSettings.SpawnerData(ChangShengJueEntity.BUTTERFLY.get(),2,3,5));
        builder.addSpawn(MobCategory.CREATURE,new MobSpawnSettings.SpawnerData(ChangShengJueEntity.STAG.get(),8,4,4));

        BiomeDefaultFeatures.plainsSpawns(builder);
//        BiomeDefaultFeatures.commonSpawns(builder);
        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalOverworldGeneration(biomeBuilder);
        addPlainGrass(biomeBuilder);
//        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);//生成花
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);//生成原版矿石
//        BiomeDefaultFeatures.addExtraGold(biomeBuilder);额外生成金矿

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CSJPlacedFeatures.POPLAR_TREE_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(2.0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(builder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(calculateSkyColor(2.0F))
                        .grassColorOverride(7124827)
                        .foliageColorOverride(7124827)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static void addPlainGrass(BiomeGenerationSettings.Builder pBuilder) {
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CSJPlacedFeatures.STIPA_GRANDIS_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CSJPlacedFeatures.TALL_STIPA_GRANDIS_PLACED_KEY);
        pBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CSJPlacedFeatures.RAPE_FLOWERS_PLACED_KEY);
    }

//    public static void addDefaultOres(BiomeGenerationSettings.Builder pBuilder, boolean pLargeOres) {
//        BiomeDefaultFeatures.addDefaultOres(pBuilder);
//        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CSJPlacedFeatures.ORE_AG_UPPER);
//        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CSJPlacedFeatures.ORE_AG_SMALL);
//        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CSJPlacedFeatures.ORE_AG_MIDDLE);
//        pBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, CSJPlacedFeatures.KAOLIN_UPPER);
//    }

    protected static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
}
