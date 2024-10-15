package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        generator.addProvider(event.includeServer(),new CSJRecipesProvider(packOutput));
        generator.addProvider(event.includeServer(), new CSJWorldGenProvider(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(), new CSJBlockStateProvider(packOutput,existingFileHelper));
        generator.addProvider(event.includeClient(), new CSJItemModelProvider(packOutput,existingFileHelper));

        generator.addProvider(event.includeServer(), CSJLootTableProvider.create(packOutput));

        generator.addProvider(event.includeServer(),new CSJPoiTypeTagsProvider(packOutput,lookupProvider,existingFileHelper));

//            generator.addProvider(new CSJLootTableProvider(generator));
//            BlockSta blockTags = new TutBlockTags(generator, event.getExistingFileHelper());
//            generator.addProvider(blockTags);
//            generator.addProvider(new TutItemTags(generator, blockTags, event.getExistingFileHelper()));
//            generator.addProvider(new TutLanguageProvider(generator, "en_us"));
    }
}
