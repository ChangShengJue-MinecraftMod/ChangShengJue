package com.shengchanshe.changshengjue.entity;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.*;
import com.shengchanshe.changshengjue.entity.custom.deer.HindEntity;
import com.shengchanshe.changshengjue.entity.custom.deer.StagEntity;
import com.shengchanshe.changshengjue.entity.custom.peacock.FemalePeacockEntity;
import com.shengchanshe.changshengjue.entity.custom.peacock.MalePeacockEntity;
import com.shengchanshe.changshengjue.entity.custom.peacock.PeacockEgg;
import com.shengchanshe.changshengjue.entity.villagers.ChangShengJueVillagerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ChangShengJue.MOD_ID);

    public static final RegistryObject<EntityType<ButterflyEntity>> BUTTERFLY_ENTITY =
            ENTITY_TYPES.register("butterfly_entity",
                    () -> EntityType.Builder.of(ButterflyEntity::new, MobCategory.CREATURE)
                            .sized(0.8f,0.2f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"butterfly_entity").toString()));

    public static final RegistryObject<EntityType<MonkeyEntity>> MONKEY_ENTITY =
            ENTITY_TYPES.register("monkey_entity",
                    () -> EntityType.Builder.of(MonkeyEntity::new, MobCategory.CREATURE)
                            .sized(1.0f,1.5f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"monkey_entity").toString()));

    public static final RegistryObject<EntityType<DragonflyEntity>> DRAGONFLY_ENTITY =
            ENTITY_TYPES.register("dragonfly_entity",
                    () -> EntityType.Builder.of(DragonflyEntity::new, MobCategory.CREATURE)
                            .sized(0.8f,0.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"dragonfly_entity").toString()));

    public static final RegistryObject<EntityType<CicadaEntity>> CICADA_ENTITY =
            ENTITY_TYPES.register("cicada_entity",
                    () -> EntityType.Builder.of(CicadaEntity::new, MobCategory.CREATURE)
                            .sized(0.6f,0.5f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"cicada_entity").toString()));

    public static final RegistryObject<EntityType<CraneEntity>> CRANE_ENTITY =
            ENTITY_TYPES.register("crane_entity",
                    () -> EntityType.Builder.of(CraneEntity::new, MobCategory.CREATURE)
                            .sized(1.0f,1.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"crane_entity").toString()));

    public static final RegistryObject<EntityType<MalePeacockEntity>> MALE_PEACOCK_ENTITY =
            ENTITY_TYPES.register("male_peacock_entity",
                    () -> EntityType.Builder.of(MalePeacockEntity::new, MobCategory.CREATURE)
                            .sized(0.8f,1.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"male_peacock_entity").toString()));

    public static final RegistryObject<EntityType<FemalePeacockEntity>> FEMALE_PEACOCK_ENTITY =
            ENTITY_TYPES.register("female_peacock_entity",
                    () -> EntityType.Builder.of(FemalePeacockEntity::new, MobCategory.CREATURE)
                            .sized(0.8f,1.4f)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"female_peacock_entity").toString()));

    public static final RegistryObject<EntityType<StagEntity>> STAG_ENTITY =
            ENTITY_TYPES.register("stag_entity",
                    () -> EntityType.Builder.of(StagEntity::new, MobCategory.CREATURE)
                            .sized(0.9F, 1.5F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"stag_entity").toString()));

    public static final RegistryObject<EntityType<HindEntity>> HIND_ENTITY =
            ENTITY_TYPES.register("hind_entity",
                    () -> EntityType.Builder.of(HindEntity::new, MobCategory.CREATURE)
                            .sized(0.9F, 1.4F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"hind_entity").toString()));

    public static final RegistryObject<EntityType<TigerEntity>> TIGER_ENTITY =
            ENTITY_TYPES.register("tiger_entity",
                    () -> EntityType.Builder.of(TigerEntity::new, MobCategory.CREATURE)
                            .sized(1.0F, 1.4F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"tiger_entity").toString()));

    public static final RegistryObject<EntityType<CrocEntity>> CROC_ENTITY =
            ENTITY_TYPES.register("croc_entity",
                    () -> EntityType.Builder.of(CrocEntity::new, MobCategory.CREATURE)
                            .sized(1.15F, 0.75F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"croc_entity").toString()));

    public static final RegistryObject<EntityType<ChangShengJueVillagerEntity>> CHANG_SHENG_JUE_VILLAGER =
            ENTITY_TYPES.register("chang_sheng_jue_villager",
                    () -> EntityType.Builder.of(ChangShengJueVillagerEntity::new, MobCategory.MISC)
                            .sized(0.6F, 1.95F)
                            .build(new ResourceLocation(ChangShengJue.MOD_ID,"chang_sheng_jue_villager").toString()));

    public static final RegistryObject<EntityType<PeacockEgg>> PEACOCK_EGG = ENTITY_TYPES.register("peacock_egg",
            () -> EntityType.Builder.<PeacockEgg>of(PeacockEgg::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .setTrackingRange(4).updateInterval(10).build("peacock_egg"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
