package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.tags.CSJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CSJEntityTypeTagsProvider extends EntityTypeTagsProvider {

    public CSJEntityTypeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(CSJTags.EntityTypes.HUMANOIDS)
                .addTag(CSJTags.EntityTypes.GANG_LEADER)
                .addTag(CSJTags.EntityTypes.VILLAGERS)
                .addTag(CSJTags.EntityTypes.PILLAGER)
                .addTag(EntityTypeTags.SKELETONS)
                .addTag(CSJTags.EntityTypes.MING_XIA)
                .add(
                        ChangShengJueEntity.WARRIOR.get(),
                        ChangShengJueEntity.KILN_WORKER.get(),
                        ChangShengJueEntity.FEMALE_INNKEEPER.get(),
                        ChangShengJueEntity.MALE_INNKEEPER.get(),
                        ChangShengJueEntity.CHALLENGER.get(),
                        ChangShengJueEntity.BLACKSMITH.get(),
                        ChangShengJueEntity.BANDIT.get(),
                        ChangShengJueEntity.VILLAIN.get(),
                        ChangShengJueEntity.ASSASSIN.get(),
                        ChangShengJueEntity.PIGLIN_WU_XIA.get(),
                        ChangShengJueEntity.WITCH_WU_XIA.get(),
                        ChangShengJueEntity.EVOKER_WU_XIA.get(),
                        ChangShengJueEntity.VINDICATOR_WU_XIA.get(),
                        EntityType.PIGLIN,
                        EntityType.EVOKER,
                        EntityType.WITCH,
                        EntityType.VINDICATOR,
                        EntityType.PIGLIN_BRUTE,
                        EntityType.ZOMBIE,
                        EntityType.DROWNED,
                        EntityType.ENDERMAN,
                        EntityType.HUSK,
                        EntityType.WANDERING_TRADER,
                        EntityType.ZOMBIE_VILLAGER,
                        EntityType.ZOMBIFIED_PIGLIN
                );

        this.tag(CSJTags.EntityTypes.GANG_LEADER)
                .add(ChangShengJueEntity.LANCE_GANG_LEADER.get(),
                        ChangShengJueEntity.KNIFE_GANG_LEADER.get(),
                        ChangShengJueEntity.SWORD_GANG_LEADER.get(),
                        ChangShengJueEntity.CLUBBED_GANG_LEADER.get(),
                        ChangShengJueEntity.GANG_LEADER.get());

        this.tag(CSJTags.EntityTypes.PILLAGER)
                .add(ChangShengJueEntity.PILLAGER_WU_XIA.get(),
                        EntityType.PILLAGER);

        this.tag(CSJTags.EntityTypes.VILLAGERS)
                .add(ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(),
                        EntityType.VILLAGER);

        this.tag(CSJTags.EntityTypes.MING_XIA)
                .add(ChangShengJueEntity.CLUBBED_MING_XIA.get(),
                        ChangShengJueEntity.SWORD_MING_XIA.get(),
                        ChangShengJueEntity.KNIFE_MING_XIA.get(),
                        ChangShengJueEntity.FIST_MING_XIA.get());

    }
}
