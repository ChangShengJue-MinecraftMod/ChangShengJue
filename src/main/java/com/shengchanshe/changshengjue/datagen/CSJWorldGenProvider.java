package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.world.biome.CSJBiomes;
import com.shengchanshe.changshengjue.world.feature.CSJBiomeModifiers;
import com.shengchanshe.changshengjue.world.feature.CSJConfiguredFeatures;
import com.shengchanshe.changshengjue.world.feature.CSJPlacedFeatures;
import com.shengchanshe.changshengjue.world.structures.CSJStructureSets;
import com.shengchanshe.changshengjue.world.structures.CSJStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CSJWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, CSJConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, CSJPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, CSJBiomeModifiers::bootstrap)
            .add(Registries.STRUCTURE_SET, CSJStructureSets::bootstrap)
            .add(Registries.STRUCTURE, CSJStructures::bootstrap)
            .add(Registries.BIOME, CSJBiomes::boostrap);

    public CSJWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ChangShengJue.MOD_ID));
    }
}