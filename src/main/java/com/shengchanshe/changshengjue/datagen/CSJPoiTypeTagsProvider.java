package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class CSJPoiTypeTagsProvider extends PoiTypeTagsProvider {

    public CSJPoiTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(ChangShengJue.MOD_ID, "chang_sheng_jue_farmer_pot"))
                .addOptional(new ResourceLocation(ChangShengJue.MOD_ID, "chang_sheng_jue_potter_pot"))
                .addOptional(new ResourceLocation(ChangShengJue.MOD_ID, "chang_sheng_jue_hunter_pot"))
                .addOptional(new ResourceLocation(ChangShengJue.MOD_ID, "chang_sheng_jue_chief_pot"))
                .addOptional(new ResourceLocation(ChangShengJue.MOD_ID, "chang_sheng_jue_seamstress_pot"));
    }
}
