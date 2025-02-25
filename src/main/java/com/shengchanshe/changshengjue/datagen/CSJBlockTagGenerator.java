package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.tags.CSJTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CSJBlockTagGenerator extends BlockTagsProvider {
    public CSJBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ChangShengJue.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //mod标签
        this.tag(CSJTags.Blocks.DOORS)
                .add(ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get())
                .add(ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get())
                .add(ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get())
                .add(ChangShengJueBlocks.DOOR_OAK_BLOCK.get())
                .add(ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get());

        this.tag(CSJTags.Blocks.JI_CHI_MU_LOG)
                .add(ChangShengJueBlocks.JI_CHI_MU_LOG.get())
                .add(ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get());
        this.tag(CSJTags.Blocks.HUANG_HUA_LI_LOG)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get())
                .add(ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get());
        this.tag(CSJTags.Blocks.ZI_TAN_LOG)
                .add(ChangShengJueBlocks.ZI_TAN_LOG.get())
                .add(ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get());
        this.tag(CSJTags.Blocks.POPLAR_LOG)
                .add(ChangShengJueBlocks.POPLAR_LOG.get());
        this.tag(CSJTags.Blocks.MULBERRY_LOG)
                .add(ChangShengJueBlocks.MULBERRY_LOG.get())
                .add(ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get());
        this.tag(CSJTags.Blocks.LOG)
                .add(ChangShengJueBlocks.MANGO_LOG.get())
                .add(ChangShengJueBlocks.GUI_HUA_LOG.get())
                .add(ChangShengJueBlocks.MEI_HUA_LOG.get())
                .add(ChangShengJueBlocks.BANANA_LOG.get())
                .add(ChangShengJueBlocks.PEAR_LOG.get())
                .add(ChangShengJueBlocks.LICHEE_LOG.get())
                .add(ChangShengJueBlocks.DURIAN_LOG.get());

        this.tag(CSJTags.Blocks.MEI_REN_KAO)
                .add(ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get())
                .add(ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get())
                .add(ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get())
                .add(ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get());

        this.tag(CSJTags.Blocks.TILE)
                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE.get())

                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get())
                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_4.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_4.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_4.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_4.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_4.get())

                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_5.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_5.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_5.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_5.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_5.get())

                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_6.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_6.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_6.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_6.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_6.get())

                .add(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK_7.get())
                .add(ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK_7.get())
                .add(ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK_7.get())
                .add(ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK_7.get())
                .add(ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK_7.get())

                .add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK.get())
                .add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get())
                .add(ChangShengJueBlocks.TILE_BLOCK.get())
                .add(ChangShengJueBlocks.TILE_BLOCK_1.get())
                .add(ChangShengJueBlocks.TILE_BLOCK_2.get())
                .add(ChangShengJueBlocks.TILE_BLOCK_3.get())
                .add(ChangShengJueBlocks.TILE_BLOCK_4.get());

        this.tag(CSJTags.Blocks.WINDOWS)
                .add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get())
                .add(ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_1.get())
                .add(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get())
                .add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get())
                .add(ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_1.get())
                .add(ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get())
                .add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get())
                .add(ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_1.get())
                .add(ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get())
                .add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get())
                .add(ChangShengJueBlocks.WINDOWS_OAK_BLOCK_1.get())
                .add(ChangShengJueBlocks.HIGH_OAK_WINDOWS.get())
                .add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get())
                .add(ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_1.get())
                .add(ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get());

        this.tag(CSJTags.Blocks.PAINTING)
                .add(ChangShengJueBlocks.PAINTING_SCROLL.get())
                .add(ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get())
                .add(ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get())
                .add(ChangShengJueBlocks.BIG_PAINTING_SCROLL.get());

        this.tag(CSJTags.Blocks.BENCH)
                .add(ChangShengJueBlocks.BIRCH_BENCH.get())
                .add(ChangShengJueBlocks.CRIMSON_BENCH.get())
                .add(ChangShengJueBlocks.WARPED_BENCH.get())
                .add(ChangShengJueBlocks.MANGROVE_BENCH.get())
                .add(ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_BENCH.get())
                .add(ChangShengJueBlocks.ACACIA_BENCH.get())
                .add(ChangShengJueBlocks.DARK_OAK_BENCH.get())
                .add(ChangShengJueBlocks.OAK_BENCH.get())
                .add(ChangShengJueBlocks.CHERRY_BENCH.get())
                .add(ChangShengJueBlocks.SPRUCE_BENCH.get())
                .add(ChangShengJueBlocks.ZI_TAN_BENCH.get());

        this.tag(CSJTags.Blocks.DRINKING_TABLE_AND_CHAIRS)
                .add(ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get())
                .add(ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get());

        this.tag(CSJTags.Blocks.BOOK_DESK)
                .add(ChangShengJueBlocks.BIRCH_BOOK_DESK.get())
                .add(ChangShengJueBlocks.CRIMSON_BOOK_DESK.get())
                .add(ChangShengJueBlocks.WARPED_BOOK_DESK.get())
                .add(ChangShengJueBlocks.MANGROVE_BOOK_DESK.get())
                .add(ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get())
                .add(ChangShengJueBlocks.ACACIA_BOOK_DESK.get())
                .add(ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get())
                .add(ChangShengJueBlocks.OAK_BOOK_DESK.get())
                .add(ChangShengJueBlocks.CHERRY_BOOK_DESK.get())
                .add(ChangShengJueBlocks.SPRUCE_BOOK_DESK.get())
                .add(ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get());

        this.tag(CSJTags.Blocks.TEAPOY)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get())
                .add(ChangShengJueBlocks.ZI_TAN_TEAPOY.get());

        this.tag(CSJTags.Blocks.TAISHI_CHAIR)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get())
                .add(ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get());

        this.tag(CSJTags.Blocks.FIVE_SCREEN_THRONE)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get())
                .add(ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get());

        this.tag(CSJTags.Blocks.LOW_DESK)
                .add(ChangShengJueBlocks.BIRCH_LOW_DESK.get())
                .add(ChangShengJueBlocks.CRIMSON_LOW_DESK.get())
                .add(ChangShengJueBlocks.WARPED_LOW_DESK.get())
                .add(ChangShengJueBlocks.MANGROVE_LOW_DESK.get())
                .add(ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get())
                .add(ChangShengJueBlocks.ACACIA_LOW_DESK.get())
                .add(ChangShengJueBlocks.DARK_OAK_LOW_DESK.get())
                .add(ChangShengJueBlocks.OAK_LOW_DESK.get())
                .add(ChangShengJueBlocks.CHERRY_LOW_DESK.get())
                .add(ChangShengJueBlocks.SPRUCE_LOW_DESK.get())
                .add(ChangShengJueBlocks.ZI_TAN_LOW_DESK.get());

        //砖
        this.tag(CSJTags.Blocks.BRICKS)
                .add(ChangShengJueBlocks.WHITE_FINE_BRICKS.get())
                .add(ChangShengJueBlocks.WHITE_BRICKS.get())
                .add(ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get())
                .add(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())
                .add(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get())
                .add(ChangShengJueBlocks.BLUE_STONE_BRICKS.get())
                .add(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get())
                .add(Blocks.STONE_BRICKS)
                .add(Blocks.CRACKED_STONE_BRICKS)
                .add(Blocks.CHISELED_STONE_BRICKS)
                .add(Blocks.PRISMARINE_BRICKS)
                .add(Blocks.POLISHED_BLACKSTONE_BRICKS)
                .add(Blocks.END_STONE_BRICKS)
                .add(Blocks.MOSSY_STONE_BRICKS)
                .add(Blocks.DEEPSLATE_BRICKS)
                .add(Blocks.CRACKED_DEEPSLATE_BRICKS)
                .add(Blocks.BRICKS)
                .add(Blocks.NETHER_BRICKS)
                .add(Blocks.CRACKED_NETHER_BRICKS)
                .add(Blocks.CHISELED_NETHER_BRICKS)
                .add(Blocks.RED_NETHER_BRICKS)
                .add(Blocks.MOSSY_STONE_BRICKS)
                .add(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        //原版工具
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get())
                .add(ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get())
                .add(ChangShengJueBlocks.CANTALOUPE_STEM.get())
                .add(ChangShengJueBlocks.ATTACHED_CANTALOUPE_STEM.get())
                .add(ChangShengJueBlocks.CANTALOUPE_BLOCK.get())
                .add(ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get())
                .add(ChangShengJueBlocks.POTTERY_WHEEL.get())
                .add(ChangShengJueBlocks.TOOL_TABLE.get())
                .add(ChangShengJueBlocks.DESK.get())
                .add(ChangShengJueBlocks.SHING_MUN_LEFT.get())
                .add(ChangShengJueBlocks.SHING_MUN_RIGHT.get())
                .addTag(CSJTags.Blocks.WINDOWS)
                .addTag(CSJTags.Blocks.MEI_REN_KAO)
                .addTag(CSJTags.Blocks.BENCH)
                .addTag(CSJTags.Blocks.DRINKING_TABLE_AND_CHAIRS)
                .addTag(CSJTags.Blocks.BOOK_DESK)
                .addTag(CSJTags.Blocks.TEAPOY)
                .addTag(CSJTags.Blocks.TAISHI_CHAIR)
                .addTag(CSJTags.Blocks.FIVE_SCREEN_THRONE)
                .addTag(CSJTags.Blocks.LOW_DESK);
        this.tag(BlockTags.MINEABLE_WITH_HOE);
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(CSJTags.Blocks.TILE)
                .add(ChangShengJueBlocks.WHITE_WALLS_BLOCK.get())
                .add(ChangShengJueBlocks.COOL_WHITE_WALLS_BLOCK.get())
                .add(ChangShengJueBlocks.WARM_WHITE_WALLS_BLOCK.get())
                .add(ChangShengJueBlocks.WHITE_FINE_BRICKS.get())
                .add(ChangShengJueBlocks.WHITE_BRICKS.get())
                .add(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get())
                .add(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())
                .add(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get())
                .add(ChangShengJueBlocks.BLUE_STONE_BRICKS.get())
                .add(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get())
                .add(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get())
                .add(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get())
                .add(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get())
                .add(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get())
                .add(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get())
                .add(ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get())
                .add(ChangShengJueBlocks.STONE_LAMPS_BLOCK.get())
                .add(ChangShengJueBlocks.STONE_LAMPS_LIANG_BLOCK.get())
                .add(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get())
                .add(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get())
                .add(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get())
                .add(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get())
                .add(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get())
                .add(ChangShengJueBlocks.AG_ORE.get())
                .add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get())
                .add(ChangShengJueBlocks.KAOLIN_ORE.get())
                .add(ChangShengJueBlocks.LIMESTONE.get())
                .add(ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get())
                .add(ChangShengJueBlocks.CASTING_MOLDS.get())
                .add(ChangShengJueBlocks.SYDEROLIFE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ChangShengJueBlocks.HANG_TU_BLOCK.get())
                .add(ChangShengJueBlocks.TU_PEI_BLOCK.get())
                .add(ChangShengJueBlocks.HANG_TU_STAIRS.get())
                .add(ChangShengJueBlocks.TU_PEI_STAIRS.get())
                .add(ChangShengJueBlocks.HANG_TU_SLAB.get())
                .add(ChangShengJueBlocks.TU_PEI_SLAB.get());

        //树
        this.tag(BlockTags.LOGS).addTag(CSJTags.Blocks.LOG);
        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTags(CSJTags.Blocks.LOG)
                .addTag(CSJTags.Blocks.HUANG_HUA_LI_LOG)
                .addTags(CSJTags.Blocks.JI_CHI_MU_LOG)
                .addTags(CSJTags.Blocks.ZI_TAN_LOG)
                .addTags(CSJTags.Blocks.POPLAR_LOG)
                .addTags(CSJTags.Blocks.MULBERRY_LOG);

        this.tag(BlockTags.PLANKS)
                .add(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())
                .add(ChangShengJueBlocks.JI_CHI_MU_PLANKS.get())
                .add(ChangShengJueBlocks.ZI_TAN_PLANKS.get());

        //花
        this.tag(BlockTags.FLOWERS)
                .add(ChangShengJueBlocks.MUGWORT_BLOCK.get())
                .add(ChangShengJueBlocks.CUCKOO_BLOCK.get())
                .add(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get())
                .add(ChangShengJueBlocks.JASMINE_BLOCK.get())
                .add(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get())
                .add(ChangShengJueBlocks.SHUI_XIAN_BLOCK.get())
                .add(ChangShengJueBlocks.TAN_HUA_BLOCK.get())
                .add(ChangShengJueBlocks.CAPSULE_BLOCK.get())
                .add(ChangShengJueBlocks.SOLIDAGO.get())
                .add(ChangShengJueBlocks.GEUM_TRIFLORUM.get())
                .add(ChangShengJueBlocks.PURPLE_DANDELION.get())
                .add(ChangShengJueBlocks.RED_KNOTWEED.get())
                .add(ChangShengJueBlocks.PURPLE_RED_KNOTWEED.get())
                .add(ChangShengJueBlocks.RAPE_FLOWERS.get());

        //Forge矿石标签
        this.tag(Tags.Blocks.ORES).add(ChangShengJueBlocks.AG_ORE.get()).add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get())
                .add(ChangShengJueBlocks.KAOLIN_ORE.get()).add(ChangShengJueBlocks.LIMESTONE.get()).add(ChangShengJueBlocks.SYDEROLIFE_ORE.get());
        //工具等级
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ChangShengJueBlocks.AG_ORE.get()).add(ChangShengJueBlocks.DEEPSLATE_AG_ORE.get());

        this.tag(BlockTags.WALLS)
                .add(ChangShengJueBlocks.HANG_TU_WALL.get())
                .add(ChangShengJueBlocks.TU_PEI_WALL.get())
                .add(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get())
                .add(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get())
                .add(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get());
        //门
        this.tag(BlockTags.WOODEN_DOORS).addTag(CSJTags.Blocks.DOORS);
        //树叶
        this.tag(BlockTags.LEAVES)
                .add(ChangShengJueBlocks.MULBERRY_LEAVES.get())
                .add(ChangShengJueBlocks.POPLAR_LEAVES.get())
                .add(ChangShengJueBlocks.LICHEE_LEAVES.get())
                .add(ChangShengJueBlocks.MANGO_LEAVES.get())
                .add(ChangShengJueBlocks.DURIAN_LEAVES.get())
                .add(ChangShengJueBlocks.BANANA_LEAVES.get())
                .add(ChangShengJueBlocks.BANANA_FRUIT.get())
                .add(ChangShengJueBlocks.PEAR_LEAVES.get())
                .add(ChangShengJueBlocks.MEI_HUA_LEAVES.get())
                .add(ChangShengJueBlocks.GUI_HUA_LEAVES.get());
    }
}
