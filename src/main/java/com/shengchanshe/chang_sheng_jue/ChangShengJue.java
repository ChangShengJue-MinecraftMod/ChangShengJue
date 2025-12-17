package com.shengchanshe.chang_sheng_jue;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.creativemodetab.ChangShengJueCreativeModeTab;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.villagers.ChangShengJueVillagers;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.loot_modifier.ChangShengJueLootModifier;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.recipe.CSJRecipeTypes;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import com.shengchanshe.chang_sheng_jue.util.ClientSetup;
import com.shengchanshe.chang_sheng_jue.world.biome.CSJTerrablender;
import com.shengchanshe.chang_sheng_jue.world.biome.surface.CSJSurFaceRules;
import com.shengchanshe.chang_sheng_jue.world.feature.CSJFoliagePlacers;
import com.shengchanshe.chang_sheng_jue.world.feature.CSJTrunkPlacerTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
        if (net.minecraftforge.fml.ModList.get().isLoaded("terrablender")) {
            CSJTerrablender.registerBiomes();
        }
        CSJFoliagePlacers.register(eventBus);
        CSJTrunkPlacerTypes.register(eventBus);
        ChangShengJueLootModifier.register(eventBus);
        CSJRecipeTypes.register(eventBus); // 确保配方类型已注册

        new CSJAdvanceInit();

        ChangShengJueMessages.register();

        GeckoLib.initialize();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ChangShengJueConfig.SPEC, MOD_ID + "/" + MOD_ID + ".toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KungFuConfig.SPEC, MOD_ID + "/" + "kung_fu.toml");

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
            if (net.minecraftforge.fml.ModList.get().isLoaded("terrablender")) {
                SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, CSJSurFaceRules.makeRules());
            }
            Raid.RaiderType.create(ChangShengJue.MOD_ID + "pillager_wu_xia", ChangShengJueEntity.PILLAGER_WU_XIA.get(), new int[]{0, 0, 1, 0, 1, 1, 2, 1});
            Raid.RaiderType.create(ChangShengJue.MOD_ID + "vindicator_wu_xia", ChangShengJueEntity.VINDICATOR_WU_XIA.get(), new int[]{1, 0, 0, 1, 1, 2, 1, 2});
            Raid.RaiderType.create(ChangShengJue.MOD_ID + "evoker_wu_xia", ChangShengJueEntity.EVOKER_WU_XIA.get(), new int[]{0, 0, 0, 0, 1, 1, 1, 2});
            Raid.RaiderType.create(ChangShengJue.MOD_ID + "witch_wu_xia", ChangShengJueEntity.WITCH_WU_XIA.get(), new int[]{0, 0, 0, 0, 1, 1, 1, 2});
        });
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        ClientSetup.clientSetup(event);
    }

}
