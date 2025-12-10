package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.tags.CSJTags;
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
        this.tag(CSJTags.Items.DOORS)
                .add(ChangShengJueBlocks.DOOR_BIRCH.get().asItem(),
                ChangShengJueBlocks.DOOR_ACACIA.get().asItem(),
                ChangShengJueBlocks.DOOR_DARK_OAK.get().asItem(),
                ChangShengJueBlocks.DOOR_OAK.get().asItem(),
                ChangShengJueBlocks.DOOR_SPRUCE.get().asItem());

        this.tag(CSJTags.Items.WENGE_LOG)
                .add(ChangShengJueBlocks.WENGE_LOG.get().asItem(),
                        ChangShengJueBlocks.WENGE_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_WENGE_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get().asItem());
        this.tag(CSJTags.Items.HUANG_HUA_LI_LOG)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get().asItem(),
                        ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get().asItem());
        this.tag(CSJTags.Items.PEAR_LOG)
                .add(ChangShengJueBlocks.PEAR_LOG.get().asItem(),
                        ChangShengJueBlocks.PEAR_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_PEAR_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_PEAR_WOOD.get().asItem());
        this.tag(CSJTags.Items.LICHEE_LOG)
                .add(ChangShengJueBlocks.LICHEE_LOG.get().asItem(),
                        ChangShengJueBlocks.LICHEE_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get().asItem());
        this.tag(CSJTags.Items.DURIAN_LOG)
                .add(ChangShengJueBlocks.DURIAN_LOG.get().asItem(),
                        ChangShengJueBlocks.DURIAN_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get().asItem());
        this.tag(CSJTags.Items.MANGO_LOG)
                .add(ChangShengJueBlocks.MANGO_LOG.get().asItem(),
                        ChangShengJueBlocks.MANGO_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_MANGO_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get().asItem());
        this.tag(CSJTags.Items.PLUM_LOG)
                .add(ChangShengJueBlocks.PLUM_LOG.get().asItem(),
                        ChangShengJueBlocks.PLUM_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_PLUM_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get().asItem());
        this.tag(CSJTags.Items.ZI_TAN_LOG)
                .add(ChangShengJueBlocks.ZI_TAN_LOG.get().asItem(),
                        ChangShengJueBlocks.ZI_TAN_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get().asItem());

        this.tag(CSJTags.Items.POPLAR_LOG)
                .add(ChangShengJueBlocks.POPLAR_LOG.get().asItem(),
                        ChangShengJueBlocks.POPLAR_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get().asItem());

        this.tag(CSJTags.Items.OSMANTHUS_LOG)
                .add(ChangShengJueBlocks.OSMANTHUS_LOG.get().asItem(),
                        ChangShengJueBlocks.OSMANTHUS_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get().asItem());

        this.tag(CSJTags.Items.MULBERRY_LOG)
                .add(ChangShengJueBlocks.MULBERRY_LOG.get().asItem(),
                        ChangShengJueBlocks.MULBERRY_WOOD.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get().asItem(),
                        ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get().asItem());


        this.tag(CSJTags.Items.LOG)
                .add(ChangShengJueBlocks.BANANA_LOG.get().asItem());

        this.tag(CSJTags.Items.MJ_BOOK)
                .addTag(CSJTags.Items.INTERNAL_KUNG_FU_MJ)
                .addTag(CSJTags.Items.EXTERNAL_KUNG_FU_MJ)
                .add(ChangShengJueItems.ZHANG_MEN_XIN_XUE.get(),ChangShengJueItems.WHEAT_NUGGET_ENCYCLOPEDIA.get());
        this.tag(CSJTags.Items.INTERNAL_KUNG_FU_MJ)
                .add(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                .add(ChangShengJueItems.HERCULES.get())
                .add(ChangShengJueItems.TURTLE_BREATH_WORK.get())
                .add(ChangShengJueItems.GOLDEN_BELL_JAR.get())
                .add(ChangShengJueItems.PAODING.get())
                .add(ChangShengJueItems.WU_GANG_CUT_GUI.get())
                .add(ChangShengJueItems.YUGONG_MOVES_MOUNTAINS.get())
                .add(ChangShengJueItems.THE_CLASSICS_OF_TENDON_CHANGING.get())
                .add(ChangShengJueItems.QIAN_KUN_DA_NUO_YI.get());
        this.tag(CSJTags.Items.EXTERNAL_KUNG_FU_MJ)
                .add(ChangShengJueItems.DUGU_NINE_SWORDS.get())
                .add(ChangShengJueItems.GAO_MARKSMANSHIP.get())
                .add(ChangShengJueItems.GE_SHAN_DA_NIU.get())
                .add(ChangShengJueItems.GOLDEN_BLACK_KNIFE_METHOD.get())
                .add(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get())
                .add(ChangShengJueItems.SHAOLIN_STICK_METHOD.get())
                .add(ChangShengJueItems.TREAD_THE_SNOW_WITHOUT_TRACE.get())
                .add(ChangShengJueItems.RELENTLESS_THROWING_KNIVES.get())
                .add(ChangShengJueItems.XUANNU_SWORDSMANSHIP.get());

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

        this.tag(ItemTags.SAPLINGS)
                .add(Item.byBlock(ChangShengJueBlocks.MANGO_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.OSMANTHUS_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PLUM_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.BANANA_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PEAR_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.LICHEE_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.DURIAN_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.ZI_TAN_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.POPLAR_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.MULBERRY_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.HUANG_HUA_LI_SAPLING.get()))
                .add(Item.byBlock(ChangShengJueBlocks.WENGE_SAPLING.get()));

        this.tag(CSJTags.Items.DRINKS)
                .addTag(CSJTags.Items.TEA)
                .addTag(CSJTags.Items.WINE);

        this.tag(CSJTags.Items.PAINTING)
                .add(Item.byBlock(ChangShengJueBlocks.PAINTING_SCROLL.get()))
                .add(Item.byBlock(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get()))
                .add(Item.byBlock(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get()))
                .add(Item.byBlock(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get()));

        this.tag(CSJTags.Items.WINE)
                .add(ChangShengJueItems.SHI_LI_XIANG.get())
                .add(ChangShengJueItems.FEN_JIU.get())
                .add(ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get());
        this.tag(CSJTags.Items.TEA)
                .add(ChangShengJueItems.BILUOCHUN_TEAS.get())
                .add(ChangShengJueItems.LONG_JING_TEAS.get());

        this.tag(CSJTags.Items.FOODS)
                .addTag(CSJTags.Items.UNPROCESSED_FOODS)
                .add(ChangShengJueItems.COOKED_VENISON.get(), ChangShengJueItems.COOKED_PEACOCK.get(),
                        ChangShengJueItems.COOKED_CROC.get(), ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get(),
                        ChangShengJueItems.BAKED_CORN.get(),ChangShengJueItems.SORGHUM_CAKE.get(), ChangShengJueItems.CAPSULE_JIAO_ZI.get(), ChangShengJueItems.QING_TUAN.get(),
                        ChangShengJueItems.XIAO_MI_FAN.get(),ChangShengJueItems.MI_FAN.get(), ChangShengJueItems.ZHENG_CAI.get(), ChangShengJueItems.TOMATO_EGG.get(),
                        ChangShengJueItems.GU_LAO_ROU.get(),ChangShengJueItems.MEAT_FOAM_BRINJAL.get(), ChangShengJueItems.STINKY_TOFU.get(), ChangShengJueItems.GUI_HUA_TANG_OU.get(),
                        ChangShengJueItems.HOT_PEAR_SOUP.get(),ChangShengJueItems.ZHU_DU_JI.get(), ChangShengJueItems.BA_BAO_ZHOU.get()
                );

        this.tag(CSJTags.Items.UNPROCESSED_FOODS)
                .add(ChangShengJueItems.VENISON.get(),ChangShengJueItems.PEACOCK.get(),ChangShengJueItems.CROC.get(),ChangShengJueItems.PINEAPPLE.get(),ChangShengJueItems.TOMATO.get(),
                        ChangShengJueItems.CORN.get(),ChangShengJueItems.MANGO.get(),ChangShengJueItems.CANTALOUPE.get(),ChangShengJueItems.BANANA.get(),ChangShengJueItems.PEAR.get(),
                        ChangShengJueItems.LICHEE.get(),ChangShengJueItems.GRAPE.get(),ChangShengJueItems.DURIAN_MEAT.get(),ChangShengJueItems.PEANUT.get(),ChangShengJueItems.BRINJAL.get(),
                        ChangShengJueItems.MULBERRY.get());

        this.tag(CSJTags.Items.FRUIT)
                .add(ChangShengJueItems.PINEAPPLE.get(),
                        ChangShengJueItems.MANGO.get(),
                        ChangShengJueItems.CANTALOUPE.get(),
                        ChangShengJueItems.BANANA.get(),
                        ChangShengJueItems.PEAR.get(),
                        ChangShengJueItems.LICHEE.get(),
                        ChangShengJueItems.GRAPE.get(),
                        ChangShengJueItems.DURIAN.get(),
                        ChangShengJueItems.MULBERRY.get());

        this.tag(CSJTags.Items.ARTIFACT)
                .add(ChangShengJueItems.BEAT_DOG_STICK.get())
                .add(ChangShengJueItems.YI_TIAN_JIAN.get())
                .add(ChangShengJueItems.TU_LONG_DAO.get())
                .add(ChangShengJueItems.BA_WANG_QIANG.get());

        this.tag(CSJTags.Items.WEAPONS)
                .add(ChangShengJueItems.BRONZE_SWORD.get(),
                        ChangShengJueItems.HAN_JIAN.get(),
                        ChangShengJueItems.HENG_DAO.get(),
                        ChangShengJueItems.LARGE_KNIFE.get(),
                        ChangShengJueItems.RED_TASSELLED_SPEAR.get(),
                        ChangShengJueItems.SOFT_SWORD.get(),
                        ChangShengJueItems.PAN_HUA_GUN.get(),
                        ChangShengJueItems.KITCHEN_KNIFE.get(),
                        ChangShengJueItems.GOLD_THREAD_GLOVE.get());

        this.tag(CSJTags.Items.FEATHER)
                .add(ChangShengJueItems.PEACOCK_FEATHERS.get(),
                    ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get());

        this.tag(CSJTags.Items.CRUCIBLE)
                .add(ChangShengJueItems.CRUCIBLE.get(),
                        ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get(),
                        ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get(),
                        ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get());

        this.tag(ItemTags.SWORDS)
                .add(ChangShengJueItems.BRONZE_SWORD.get(),
                        ChangShengJueItems.LONG_YUAN_SWORD.get(),
                        ChangShengJueItems.HAN_JIAN.get(),
                        ChangShengJueItems.HENG_DAO.get(),
                        ChangShengJueItems.LARGE_KNIFE.get(),
                        ChangShengJueItems.RED_TASSELLED_SPEAR.get(),
                        ChangShengJueItems.SOFT_SWORD.get(),
                        ChangShengJueItems.PAN_HUA_GUN.get(),
                        ChangShengJueItems.KITCHEN_KNIFE.get(),
                        ChangShengJueItems.BEAT_DOG_STICK.get(),
                        ChangShengJueItems.YI_TIAN_JIAN.get(),
                        ChangShengJueItems.TU_LONG_DAO.get(),
                        ChangShengJueItems.BA_WANG_QIANG.get(),
                        ChangShengJueItems.GOLD_THREAD_GLOVE.get());

        this.tag(ItemTags.AXES)
                .add(ChangShengJueItems.XUANHUA_AXE.get());

        this.tag(ItemTags.PICKAXES)
                .add(ChangShengJueItems.KAISHAN_PICKAXE.get());

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
                .addTag(CSJTags.Items.LOG)
                .addTag(CSJTags.Items.HUANG_HUA_LI_LOG)
                .addTag(CSJTags.Items.WENGE_LOG)
                .addTag(CSJTags.Items.ZI_TAN_LOG)
                .addTag(CSJTags.Items.POPLAR_LOG)
                .addTag(CSJTags.Items.OSMANTHUS_LOG)
                .addTag(CSJTags.Items.PEAR_LOG)
                .addTag(CSJTags.Items.LICHEE_LOG)
                .addTag(CSJTags.Items.DURIAN_LOG)
                .addTag(CSJTags.Items.MANGO_LOG)
                .addTag(CSJTags.Items.PLUM_LOG)
                .addTag(CSJTags.Items.MULBERRY_LOG);

        this.tag(ItemTags.PLANKS)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get().asItem(),
                        ChangShengJueBlocks.WENGE_PLANKS.get().asItem(),
                        ChangShengJueBlocks.ZI_TAN_PLANKS.get().asItem(),
                        ChangShengJueBlocks.POPLAR_PLANKS.get().asItem(),
                        ChangShengJueBlocks.OSMANTHUS_PLANKS.get().asItem(),
                        ChangShengJueBlocks.PEAR_PLANKS.get().asItem(),
                        ChangShengJueBlocks.LICHEE_PLANKS.get().asItem(),
                        ChangShengJueBlocks.DURIAN_PLANKS.get().asItem(),
                        ChangShengJueBlocks.MANGO_PLANKS.get().asItem(),
                        ChangShengJueBlocks.PLUM_PLANKS.get().asItem(),
                        ChangShengJueBlocks.MULBERRY_PLANKS.get().asItem());

        this.tag(Tags.Items.CROPS_WHEAT)
                .add(ChangShengJueItems.HORDEUM.get());

        this.tag(Tags.Items.LEATHER)
                .add(ChangShengJueItems.TIGER_SKIN.get())
                .add(ChangShengJueItems.CROC_SKIN.get());

        //Forge矿石物品标签
        this.tag(Tags.Items.INGOTS).add(ChangShengJueItems.AG_INGOT.get());
        this.tag(CSJTags.ForgeItems.INGOTS_SILVER).add(ChangShengJueItems.AG_INGOT.get().asItem());

        //slabs台阶标签
        this.tag(ItemTags.SLABS)
                .add(Item.byBlock(ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.HANG_TU_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.TU_PEI_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.WHITE_JADE_SLAB.get()))
                .add(Item.byBlock(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get()));

        //盔甲
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ChangShengJueItems.GOLD_SILK_SOFT_ARMOR.get().asItem(),
                        ChangShengJueItems.LEATHER_INNER_ARMOR.get().asItem());
    }
}
