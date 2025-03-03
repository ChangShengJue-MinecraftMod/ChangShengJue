package com.shengchanshe.changshengjue.world.biome;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class CSJOverworldRegion extends Region {
    public CSJOverworldRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        this.addModifiedVanillaOverworldBiomes(mapper,modifiedVanillaOverworldBuilder -> {
//            modifiedVanillaOverworldBuilder.replaceBiome(Biomes.PLAINS,CSJBiomes.CHANG_SHEN_JUE_PRAIRIE);

            VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

            new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.NEUTRAL, ParameterUtils.Temperature.NEUTRAL))//温度
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.NEUTRAL))//湿度
                    .continentalness(ParameterUtils.Continentalness.FAR_INLAND)//是否沿海
                    .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.FULL_RANGE)//地形起伏
                    .depth(ParameterUtils.Depth.SURFACE)//生成深度
                    .weirdness(ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.LOW_SLICE_NORMAL_DESCENDING)//地形形状和特征
                    .build().forEach(point -> builder.add(point, CSJBiomes.CHANG_SHENG_JUE_PRAIRIE));

            builder.build().forEach(mapper::accept);
//        });
        super.addBiomes(registry, mapper);
    }
}
