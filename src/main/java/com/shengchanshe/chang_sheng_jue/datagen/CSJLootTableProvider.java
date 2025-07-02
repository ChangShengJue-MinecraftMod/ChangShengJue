package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.datagen.loot.CSJBlockLootTables;
import com.shengchanshe.chang_sheng_jue.datagen.loot.CSJEntityLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CSJLootTableProvider {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
            new LootTableProvider.SubProviderEntry(CSJBlockLootTables::new, LootContextParamSets.BLOCK),
            new LootTableProvider.SubProviderEntry(CSJEntityLootTables::new, LootContextParamSets.ENTITY)
        ));
    }
}
