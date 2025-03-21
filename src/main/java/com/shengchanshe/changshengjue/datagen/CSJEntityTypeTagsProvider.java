package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.tags.CSJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
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
//        this.tag(CSJTags.EntityTypes.WU_XIA_CREATURE)
//                .add(EntityType.VILLAGER,
//                        ChangShengJueEntity.CHANG_SHENG_JUE_VILLAGER.get(),
//                        ChangShengJueEntity.WARRIOR.get(),
//                        ChangShengJueEntity.FEMALE_INNKEEPER.get(),
//                        ChangShengJueEntity.MALE_INNKEEPER.get());
    }
}
