package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.util.CSJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
        this.tag(CSJTags.Items.DOORS)
                .add(Item.byBlock(ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.DOOR_OAK_BLOCK.get()))
                .add(Item.byBlock(ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get()));

        this.tag(CSJTags.Items.JI_CHI_MU_LOG)
                .add(Item.byBlock(ChangShengJueBlocks.JI_CHI_MU_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.JI_CHI_MU_PLANKS.get()))
                .add(Item.byBlock(ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get()));
        this.tag(CSJTags.Items.HUANG_HUA_LI_LOG)
                .add(Item.byBlock(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .add(Item.byBlock(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get()));
        this.tag(CSJTags.Items.ZI_TAN_LOG)
                .add(Item.byBlock(ChangShengJueBlocks.ZI_TAN_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .add(Item.byBlock(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get()));
        this.tag(CSJTags.Items.POPLAR_LOG)
                .add(Item.byBlock(ChangShengJueBlocks.POPLAR_LOG.get()));
        this.tag(CSJTags.Items.LOG)
                .add(Item.byBlock(ChangShengJueBlocks.MANGO_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.GUI_HUA_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.MEI_HUA_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.BANANA_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PEAR_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.LICHEE_LOG.get()))
                .add(Item.byBlock(ChangShengJueBlocks.DURIAN_LOG.get()));

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

        this.tag(ItemTags.LOGS).addTag(CSJTags.Items.LOG);
        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTags(CSJTags.Items.LOG)
                .addTag(CSJTags.Items.HUANG_HUA_LI_LOG)
                .addTags(CSJTags.Items.JI_CHI_MU_LOG)
                .addTags(CSJTags.Items.ZI_TAN_LOG)
                .addTags(CSJTags.Items.POPLAR_LOG);

        this.tag(ItemTags.PLANKS)
                .add(Item.byBlock(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .add(Item.byBlock(ChangShengJueBlocks.JI_CHI_MU_PLANKS.get()))
                .add(Item.byBlock(ChangShengJueBlocks.ZI_TAN_PLANKS.get()));


    }
}
