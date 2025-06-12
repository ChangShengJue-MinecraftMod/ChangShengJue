package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.datagen.language.CSJUSLanguageProvider;
import com.shengchanshe.changshengjue.datagen.language.CSJCNLanguageProvider;
import com.shengchanshe.changshengjue.datagen.loot.CSJGlobalLootModifiersProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
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
        generator.addProvider(event.includeClient(), new CSJBlockModelProvider(packOutput,existingFileHelper));
        generator.addProvider(event.includeClient(), new CSJItemModelProvider(packOutput,existingFileHelper));
        generator.addProvider(event.includeServer(), CSJLootTableProvider.create(packOutput));
        generator.addProvider(event.includeServer(), new CSJGlobalLootModifiersProvider(packOutput));

        event.getGenerator().addProvider(
                event.includeClient(),
               new CSJUSLanguageProvider(packOutput, ChangShengJue.MOD_ID, "en_us"));
        event.getGenerator().addProvider(
                event.includeClient(),
                new CSJCNLanguageProvider(packOutput, ChangShengJue.MOD_ID, "zh_cn"));


        generator.addProvider(event.includeServer(),new CSJPoiTypeTagsProvider(packOutput,lookupProvider,existingFileHelper));

        CSJBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new CSJBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new CSJItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new CSJEntityTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new CSJStructureTagProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new AdvancementProvider(packOutput, lookupProvider,
                List.of(
                        new CSJAdvanceProvider()
                ))
        );
//            generator.addProvider(new CSJLootTableProvider(generator));
//            BlockSta blockTags = new TutBlockTags(generator, event.getExistingFileHelper());
//            generator.addProvider(blockTags);
//            generator.addProvider(new TutItemTags(generator, blockTags, event.getExistingFileHelper()));
//            generator.addProvider(new TutLanguageProvider(generator, "en_us"));
    }
}
