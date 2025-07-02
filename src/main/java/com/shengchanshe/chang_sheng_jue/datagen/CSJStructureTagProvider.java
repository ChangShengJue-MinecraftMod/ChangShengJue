package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.tags.CSJTags;
import com.shengchanshe.chang_sheng_jue.world.CSJStructures;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CSJStructureTagProvider extends StructureTagsProvider {
    public CSJStructureTagProvider(PackOutput p_256522_, CompletableFuture<HolderLookup.Provider> p_256661_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_256522_, p_256661_, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(CSJTags.StructureTypes.SANDSTONE_CASTLE).add(CSJStructures.SANDSTONE_CASTLE);
        this.tag(CSJTags.StructureTypes.PIT_YARD).add(CSJStructures.PIT_YARD);
        this.tag(CSJTags.StructureTypes.SI_HE_YUAN).add(CSJStructures.SI_HE_YUAN);
        this.tag(CSJTags.StructureTypes.SU_PAI_VILLAGE).add(CSJStructures.SU_PAI_VILLAGE);
        this.tag(CSJTags.StructureTypes.WAN_PAI_VILLAGE).add(CSJStructures.WAN_PAI_VILLAGE);
        this.tag(CSJTags.StructureTypes.FORTRESSES).add(CSJStructures.FORTRESSES);
    }
}
