package com.shengchanshe.chang_sheng_jue.datagen.loot;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.loot_modifier.DragonParcelModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class CSJGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public CSJGlobalLootModifiersProvider(PackOutput output) {
        super(output, ChangShengJue.MOD_ID);
    }

    @Override
    protected void start() {
        add("dragon_parcel", new DragonParcelModifier(
                new LootItemCondition[] {LootTableIdCondition.builder(new ResourceLocation("entities/ender_dragon")).build()}));
    }
}