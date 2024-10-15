package com.shengchanshe.changshengjue;

import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.creativemodetab.ChangShengJueCreativeModeTab;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.ClientSetup;
//import com.shengchanshe.changshengjue.world.structures.Registration;
//import com.shengchanshe.changshengjue.world.structures.Structures;
import com.shengchanshe.changshengjue.world.structures.CSJStructurePieceTypes;
import com.shengchanshe.changshengjue.world.structures.CSJStructureType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
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

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ChangShengJue.MOD_ID)
public class ChangShengJue {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "chang_sheng_jue";

    public ChangShengJue() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::setup);
//        forgeBus.addListener(EventPriority.NORMAL, Structures::addDimensionalSpacing);
//        forgeBus.addListener(EventPriority.NORMAL, Structures::setupStructureSpawns);

        ChangShengJueItems.register(eventBus);
        ChangShengJueBlocks.register(eventBus);
        ChangShengJueBlocksEntities.register(eventBus);
        ChangShengJueEntity.register(eventBus);
        ChangShengJueSound.register(eventBus);
        ChangShengJueVillagers.register(eventBus);
        ChangShengJueCreativeModeTab.register(eventBus);
        CSJStructureType.register(eventBus);
        CSJStructurePieceTypes.register(eventBus);
//        Registration.init();

        GeckoLib.initialize();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(()->{
//            Structures.setupStructures();
//            Structures.registerConfiguredStructures();
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.MUGWORT_BLOCK.getId(), ChangShengJueBlocks.POTTED_MUGWORT_BLOCK);
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.CUCKOO_BLOCK.getId(), ChangShengJueBlocks.POTTED_CUCKOO_BLOCK);
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.getId(), ChangShengJueBlocks.POTTED_PORTULACA_OLERACEA_BLOCK);
//            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ChangShengJueBlocks.JASMINE_BLOCK.getId(), ChangShengJueBlocks.POTTED_JASMINE_BLOCK);
            SpawnPlacements.register(ChangShengJueEntity.BUTTERFLY_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.MONKEY_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.DRAGONFLY_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.CICADA_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.CRANE_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.MALE_PEACOCK_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.FEMALE_PEACOCK_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.STAG_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.HIND_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.TIGER_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
            SpawnPlacements.register(ChangShengJueEntity.CROC_ENTITY.get(),SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);

        });
    }

    public void clientSetup(final FMLClientSetupEvent event){
        ClientSetup.clientSetup(event);
    }

}
