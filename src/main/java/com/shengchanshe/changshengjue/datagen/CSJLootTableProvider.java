package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.datagen.loot.CSJBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CSJLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
            new LootTableProvider.SubProviderEntry(CSJBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}
