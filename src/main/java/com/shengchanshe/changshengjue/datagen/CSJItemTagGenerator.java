package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CSJItemTagGenerator extends ItemTagsProvider {
    public CSJItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.SWORDS)
                .add(ChangShengJueItems.BRONZE_SWORD.get())
                .add(ChangShengJueItems.HAN_JIAN.get())
                .add(ChangShengJueItems.HENG_DAO.get())
                .add(ChangShengJueItems.LARGE_KNIFE.get())
                .add(ChangShengJueItems.RED_TASSELLED_SPEAR.get())
                .add(ChangShengJueItems.SOFT_SWORD.get())
                .add(ChangShengJueItems.PAN_HUA_GUN.get())
                .add(ChangShengJueItems.KITCHEN_KNIFE.get());

        this.tag(ItemTags.FLOWERS)
                .add(Item.byBlock(ChangShengJueBlocks.MUGWORT_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.CUCKOO_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.JASMINE_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.TAN_HUA_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.CAPSULE_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.SOLIDAGO.get()))
                .add(Item.byBlock(ChangShengJueBlocks.GEUM_TRIFLORUM.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PURPLE_DANDELION.get()))
                .add(Item.byBlock(ChangShengJueBlocks.RED_KNOTWEED.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get()))
                .add(Item.byBlock(ChangShengJueBlocks.RAPE_FLOWERS.get()));
    }
}
