package com.shengchanshe.changshengjue;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.creativemodetab.ChangShengJueCreativeModeTab;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.screen.ChangShengJueMenuTypes;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.ClientSetup;
import com.shengchanshe.changshengjue.world.biome.CSJTerrablender;
import com.shengchanshe.changshengjue.world.biome.surface.CSJSurFaceRules;
import com.shengchanshe.changshengjue.world.feature.CSJFoliagePlacers;
import com.shengchanshe.changshengjue.world.feature.CSJTrunkPlacerTypes;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.GeckoLib;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ChangShengJue.MOD_ID)
public class ChangShengJue {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "chang_sheng_jue";


    public ChangShengJue() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::setup);

        ChangShengJueItems.register(eventBus);
        ChangShengJueBlocks.register(eventBus);
        ChangShengJueBlocksEntities.register(eventBus);
        ChangShengJueEntity.register(eventBus);
        ChangShengJueSound.register(eventBus);
        ChangShengJueVillagers.register(eventBus);
        ChangShengJueCreativeModeTab.register(eventBus);
        ChangShengJueParticles.register(eventBus);
        ChangShengJueMenuTypes.register(eventBus);
        ChangShengJueEffects.register(eventBus);
        CSJTerrablender.registerBiomes();
        CSJFoliagePlacers.register(eventBus);
        CSJTrunkPlacerTypes.register(eventBus);

        ChangShengJueMessages.register();

        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(()->{
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.MUGWORT_BLOCK.getId(), ChangShengJueBlocks.POTTED_MUGWORT_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.CUCKOO_BLOCK.getId(), ChangShengJueBlocks.POTTED_CUCKOO_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.getId(), ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.JASMINE_BLOCK.getId(), ChangShengJueBlocks.POTTED_JASMINE_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.getId(), ChangShengJueBlocks.POTTED_KOCHIA_SCOPARIA_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.SHUI_XIAN_BLOCK.getId(), ChangShengJueBlocks.POTTED_SHUI_XIAN_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.TAN_HUA_BLOCK.getId(), ChangShengJueBlocks.POTTED_TAN_HUA_BLOCK);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.SOLIDAGO.getId(), ChangShengJueBlocks.POTTED_SOLIDAGO);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.GEUM_TRIFLORUM.getId(), ChangShengJueBlocks.POTTED_GEUM_TRIFLORUM);
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.PURPLE_DANDELION.getId(), ChangShengJueBlocks.POTTED_PURPLE_DANDELION);

            SpawnPlacements.register(ChangShengJueEntity.BUTTERFLY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.MONKEY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.DRAGONFLY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.CICADA.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.CRANE.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.MALE_PEACOCK.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.FEMALE_PEACOCK.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.STAG.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.HIND.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.TIGER.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.CROC.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,MOD_ID, CSJSurFaceRules.makeRules());

            ItemProperties.register(ChangShengJueItems.BA_WANG_QIANG.get(),new ResourceLocation("throwing"),(stack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);
            ItemProperties.register(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),new ResourceLocation("throwing"),(stack, clientLevel, livingEntity, i) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F);

        });
    }

    public void clientSetup(final FMLClientSetupEvent event){
        ClientSetup.clientSetup(event);
    }
}
