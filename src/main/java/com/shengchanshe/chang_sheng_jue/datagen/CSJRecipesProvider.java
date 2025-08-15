package com.shengchanshe.chang_sheng_jue.datagen;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.tags.CSJTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;
import static net.minecraft.data.recipes.RecipeCategory.FOOD;
import static net.minecraft.data.recipes.RecipeCategory.MISC;

//合成表
public class CSJRecipesProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> AG_SMELTABLES = List.of(ChangShengJueBlocks.AG_ORE.get(),
            ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), ChangShengJueItems.RAW_AG.get());
    private static final int SMELTING_TICK = 200;
    private static final int SMOKING_TICK = 100;
    private static final int CAMPFIRE_COOKING_TICK = 600;

    public CSJRecipesProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //无序合成
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.YI_GUAN_TONG_QIAN.get()).requires(ChangShengJueItems.TONG_QIAN.get(),7)
                .unlockedBy("has_tong_qian",has(ChangShengJueItems.TONG_QIAN.get()))
                .save(consumer);
        //原木
        planksFromLog(consumer, ChangShengJueBlocks.POPLAR_PLANKS.get(), CSJTags.Items.POPLAR_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.OSMANTHUS_PLANKS.get(), CSJTags.Items.OSMANTHUS_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(), CSJTags.Items.HUANG_HUA_LI_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.WENGE_PLANKS.get(), CSJTags.Items.WENGE_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.PEAR_PLANKS.get(), CSJTags.Items.PEAR_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.LICHEE_PLANKS.get(), CSJTags.Items.LICHEE_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.DURIAN_PLANKS.get(), CSJTags.Items.DURIAN_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.MANGO_PLANKS.get(), CSJTags.Items.MANGO_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.PLUM_PLANKS.get(), CSJTags.Items.PLUM_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.MULBERRY_PLANKS.get(), CSJTags.Items.MULBERRY_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.ZI_TAN_PLANKS.get(), CSJTags.Items.ZI_TAN_LOG, 4);

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.BLUE_DOUGONG.get())
                .requires(ChangShengJueBlocks.GREEN_DOUGONG.get())
                .requires(Tags.Items.DYES_BLUE)
                .unlockedBy("has_green_dougong", has(ChangShengJueBlocks.GREEN_DOUGONG.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.GREEN_DOUGONG.get())
                .requires(ChangShengJueBlocks.BLUE_DOUGONG.get())
                .requires(Tags.Items.DYES_GREEN)
                .unlockedBy("has_blue_dougong", has(ChangShengJueBlocks.BLUE_DOUGONG.get()))
                .save(consumer);
        //建筑方块
        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.HANG_TU_BLOCK.get(),6).requires(Blocks.DIRT,9).unlockedBy("has_dirt",has(Blocks.DIRT)).save(consumer);
        stairBuilder(ChangShengJueBlocks.HANG_TU_STAIRS.get(), Ingredient.of(ChangShengJueBlocks.HANG_TU_BLOCK.get())).unlockedBy("has_hang_tu_block", has(ChangShengJueBlocks.HANG_TU_BLOCK.get())).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.HANG_TU_SLAB.get(), Ingredient.of(ChangShengJueBlocks.HANG_TU_BLOCK.get())).unlockedBy("has_hang_tu_block", has(ChangShengJueBlocks.HANG_TU_BLOCK.get())).save(consumer);
        wall(consumer,RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.HANG_TU_WALL.get(),ChangShengJueBlocks.HANG_TU_BLOCK.get());

        stairBuilder(ChangShengJueBlocks.TU_PEI_STAIRS.get(), Ingredient.of(Blocks.DIRT)).unlockedBy("has_dirt", has(Blocks.DIRT)).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.TU_PEI_SLAB.get(),
                Ingredient.of(Blocks.DIRT)).unlockedBy("has_dirt", has(Blocks.DIRT)).save(consumer);
        wall(consumer,RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.TU_PEI_WALL.get(),Blocks.DIRT);
        //石灰浆
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.LIME_SLURRY_BARRELS.get()).requires(ChangShengJueItems.QUICKLIME.get()).requires(Items.WATER_BUCKET)
                .unlockedBy("has_water_bucket",has(Items.WATER_BUCKET)).save(consumer);

        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.COOL_LIME_SLURRY_BARRELS.get()).requires(ChangShengJueItems.LIME_SLURRY_BARRELS.get()).requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_lime_slurry_barrels",has(ChangShengJueItems.LIME_SLURRY_BARRELS.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.WARM_LIME_SLURRY_BARRELS.get()).requires(ChangShengJueItems.LIME_SLURRY_BARRELS.get()).requires(Items.YELLOW_DYE)
                .unlockedBy("has_lime_slurry_barrels",has(ChangShengJueItems.LIME_SLURRY_BARRELS.get())).save(consumer);
        //黑砖
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BLACK_STONE_BRICKS.get()).define('#', ChangShengJueItems.BLACK_BRICKS.get())
                .pattern("##").pattern("##").unlockedBy("has_bricks", has(ChangShengJueItems.BLACK_BRICKS.get())).save(consumer,"black_stone_bricks_shaped");

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),9)
                .requires(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),9).unlockedBy("has_bricks",has(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get())).save(consumer,"black_stone_bricks_shapeless");

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),9)
                .requires(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),9).unlockedBy("has_bricks",has(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())).save(consumer);

        stairBuilder(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get(), Ingredient.of(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get()))
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())).save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get(),
                Ingredient.of(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get())).unlockedBy("has_dirt", has(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get(),6)
                .define('#', Ingredient.of(ChangShengJueBlocks.BLACK_STONE_BRICKS.get(),ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get()))
                .pattern("#").pattern("#").pattern("#").unlockedBy("has_bricks", has(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())).save(consumer);
        //白砖
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WHITE_BRICKS.get()).define('#', ChangShengJueItems.WHITE_BRICKS_ITEM.get())
                .pattern("##").pattern("##").unlockedBy("has_bricks", has(ChangShengJueItems.WHITE_BRICKS_ITEM.get())).save(consumer,"white_stone_bricks_shaped");

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.WHITE_BRICKS.get(),9)
                .requires(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),9).unlockedBy("has_bricks",has(ChangShengJueBlocks.WHITE_FINE_BRICKS.get())).save(consumer,"white_bricks_shapeless");

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),9)
                .requires(ChangShengJueBlocks.WHITE_BRICKS.get(),9).unlockedBy("has_bricks",has(ChangShengJueBlocks.WHITE_BRICKS.get())).save(consumer);

        stairBuilder(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get(), Ingredient.of(ChangShengJueBlocks.WHITE_BRICKS.get(),ChangShengJueBlocks.WHITE_FINE_BRICKS.get()))
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.WHITE_BRICKS.get())).save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.WHITE_BRICKS_SLAB.get(),
                Ingredient.of(ChangShengJueBlocks.WHITE_BRICKS.get(),ChangShengJueBlocks.WHITE_FINE_BRICKS.get())).unlockedBy("has_dirt", has(ChangShengJueBlocks.WHITE_BRICKS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get(),6)
                .define('#', Ingredient.of(ChangShengJueBlocks.WHITE_BRICKS.get(),ChangShengJueBlocks.WHITE_FINE_BRICKS.get()))
                .pattern("#").pattern("#").pattern("#").unlockedBy("has_bricks", has(ChangShengJueBlocks.WHITE_BRICKS.get())).save(consumer);
        //金砖
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.GOLD_BRICKS.get()).requires(ChangShengJueItems.WHITE_BRICKS_ITEM.get()).requires(Items.YELLOW_DYE)
                .unlockedBy("has_white_bricks_item",has(ChangShengJueItems.WHITE_BRICKS_ITEM.get())).save(consumer);

        //坩埚
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get()).requires(ChangShengJueItems.CRUCIBLE.get()).requires(Ingredient.of(Tags.Items.INGOTS_COPPER),8)
                .unlockedBy("has_crucible",has(ChangShengJueItems.CRUCIBLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get()).requires(ChangShengJueItems.CRUCIBLE.get()).requires(ChangShengJueItems.AG_INGOT.get(),8)
                .unlockedBy("has_crucible",has(ChangShengJueItems.CRUCIBLE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get()).requires(ChangShengJueItems.CRUCIBLE.get()).requires(Ingredient.of(Tags.Items.INGOTS_GOLD),8)
                .unlockedBy("has_crucible",has(ChangShengJueItems.CRUCIBLE.get())).save(consumer);
        ShapedRecipeBuilder.shaped(MISC, ChangShengJueItems.CRUCIBLE.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("# #")
                .pattern("# #")
                .pattern(" # ")
                .unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);

        //哈密瓜
        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.CANTALOUPE_BLOCK.get(),1)
                .requires(ChangShengJueItems.CANTALOUPE.get(),9).unlockedBy("has_cantaloupe",has(ChangShengJueItems.CANTALOUPE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueItems.CANTALOUPE_SEEDS.get(),1)
                .requires(ChangShengJueItems.CANTALOUPE.get(),1).unlockedBy("has_cantaloupe",has(ChangShengJueItems.CANTALOUPE.get())).save(consumer);

        //模具
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CASTING_MOLDS.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Tags.Items.SAND))
                .pattern("#X#")
                .pattern("XXX")
                .pattern("#X#")
                .unlockedBy("has_sand", has(Tags.Items.SAND)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BULLIONS_CASTING_MOLDS.get(),1)
                .define('#', Ingredient.of(Tags.Items.GEMS_DIAMOND))
                .define('X', Ingredient.of(Tags.Items.SAND))
                .pattern("#X#")
                .pattern("XXX")
                .pattern("#X#")
                .unlockedBy("has_sand", has(Tags.Items.SAND)).save(consumer);

        //刷子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueItems.PAINT_BRUSH.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.WHITE_WOOL))
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        //烛台
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueItems.ZHU_TAI.get(),1)
                .define('#', Ingredient.of(Tags.Items.STRING))
                .define('X', Ingredient.of(Items.HONEYCOMB))
                .define('&',  Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("#")
                .pattern("X")
                .pattern("&")
                .unlockedBy("has_string", has(Items.STRING)).save(consumer);
        //美人靠
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_OAK_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.OAK_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_ACACIA_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.ACACIA_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_DARK_OAK_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_SPRUCE_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_BIRCH_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_JUNGLE_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.JUNGLE_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_MANGROVE_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.MANGROVE_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.MANGROVE_PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_CHERRY_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.CHERRY_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.CHERRY_PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_CRIMSON_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.CRIMSON_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.CRIMSON_PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MEI_REN_KAO_WARPED_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.WARPED_PLANKS))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.WARPED_PLANKS)).save(consumer);


        //扶梯
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BAI_HUA_FU_TI_BLOCK.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("X#X")
                .pattern("X#X")
                .pattern("X#X")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.YUN_SHAN_FU_TI_BLOCK.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("X#X")
                .pattern("X#X")
                .pattern("X#X")
                .unlockedBy("has_sand", has(Items.STICK)).save(consumer);
        //门
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_OAK.get(),2)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_BIRCH.get(),2)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_DARK_OAK.get(),2)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_SPRUCE.get(),2)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_ACACIA.get(),2)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        //窗户
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HIGH_OAK_WINDOWS.get(),3)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HIGH_BIRCH_WINDOWS.get(),3)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HIGH_DARK_OAK_WINDOWS.get(),3)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HIGH_SPRUCE_WINDOWS.get(),3)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HIGH_ACACIA_WINDOWS.get(),3)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        //窗户板
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_OAK_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.OAK_PLANKS))
                .pattern("X#X")
                .pattern("X X")
                .unlockedBy("has_sand", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("X#X")
                .pattern("X X")
                .unlockedBy("has_sand", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("X#X")
                .pattern("X X")
                .unlockedBy("has_sand", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("X#X")
                .pattern("X X")
                .unlockedBy("has_sand", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK.get(),3)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.ACACIA_PLANKS))
                .pattern("X#X")
                .pattern("X X")
                .unlockedBy("has_sand", has(ItemTags.PLANKS)).save(consumer);
        //石灯
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.STONE_LAMPS_BASE_BLOCK.get(),1)
                .define('#', Ingredient.of(Items.STONE))
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_planks", has(Items.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.STONE_LAMPS_BLOCK.get(),1)
                .define('#', Ingredient.of(Items.STONE))
                .define('X', Ingredient.of(ChangShengJueItems.ZHU_TAI.get()))
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_zhu_tai", has(Items.STONE)).save(consumer);
        //功能方块
        // 织布机
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.CHANG_SHENG_JUE_LOOM.get(), 1)
                .define('#', Ingredient.of(ItemTags.PLANKS))
                .define('X', Ingredient.of(ItemTags.WOODEN_SLABS))
                .pattern("X X")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "loom_recipe"));
        // 陶轮
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.POTTERY_WHEEL.get(), 1)
                .define('#', Ingredient.of(Items.COBBLESTONE))
                .pattern(" # ")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_planks",has(ItemTags.PLANKS))
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "pottery_wheel_recipe"));
        //工具台
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.TOOL_TABLE.get(), 1)
                .define('#', Ingredient.of(ItemTags.PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "tool_table_recipe"));
        //牲畜食槽
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.PIG_TROUGH.get(), 1)
                .define('#', Ingredient.of(Items.COBBLESTONE))
                .pattern("   ")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "pig_trough_recipe"));
        //武器架
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.WEAPON_RACK.get(), 1)
                .define('X', Ingredient.of(Items.STICK))
                .pattern("   ")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "weapon_rack_recipe"));
        //丝绸
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueItems.SILK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueItems.NATURAL_SILK.get()))
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "silk_recipe"));


        /**
         * 家具
         */
        //城门
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.SHING_MUN_LEFT.get(),1)
                .define('#', Ingredient.of(ItemTags.LOGS))
                .define('X', Ingredient.of(Items.GOLD_BLOCK))
                .pattern("###")
                .pattern("##X")
                .pattern("###")
                .unlockedBy("has_planks", has(ItemTags.LOGS)).save(consumer);
        //白桦木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BIRCH_BENCH.get(),1)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.BIRCH_PLANKS)).save(consumer);
        //绯红木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CRIMSON_BENCH.get(),1)
            .define('#', Ingredient.of(Items.CRIMSON_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.CRIMSON_PLANKS)).save(consumer);
        //诡异木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WARPED_BENCH.get(),1)
            .define('#', Ingredient.of(Items.WARPED_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.WARPED_PLANKS)).save(consumer);
        //红木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MANGROVE_BENCH.get(),1)
            .define('#', Ingredient.of(Items.MANGROVE_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.MANGROVE_PLANKS)).save(consumer);
        //金合欢长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ACACIA_BENCH.get(),1)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.ACACIA_PLANKS)).save(consumer);
        //深色橡木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DARK_OAK_BENCH.get(),1)
            .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.DARK_OAK_PLANKS)).save(consumer);
        //橡木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.OAK_BENCH.get(),1)
            .define('#', Ingredient.of(Items.OAK_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.OAK_PLANKS)).save(consumer);
        //樱花木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CHERRY_BENCH.get(),1)
            .define('#', Ingredient.of(Items.CHERRY_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.CHERRY_PLANKS)).save(consumer);
        //云杉木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.SPRUCE_BENCH.get(),1)
            .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
            .define('X', Ingredient.of(Items.STICK))
            .pattern("###")
            .pattern("X X")
            .unlockedBy("has_planks", has(Items.SPRUCE_PLANKS)).save(consumer);
        //黄花梨长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HUANG_HUA_LI_BENCH.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //鸡翅木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.JI_CHI_MU_BENCH.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //紫檀木长凳
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ZI_TAN_BENCH.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);

        //白桦木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BIRCH_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.BIRCH_PLANKS)).save(consumer);
        //绯红木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CRIMSON_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.CRIMSON_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.CRIMSON_PLANKS)).save(consumer);
        //诡异木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WARPED_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.WARPED_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.WARPED_PLANKS)).save(consumer);
        //红木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MANGROVE_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.MANGROVE_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.MANGROVE_PLANKS)).save(consumer);
        //金合欢木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ACACIA_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.ACACIA_PLANKS)).save(consumer);
        //深色橡木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DARK_OAK_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.DARK_OAK_PLANKS)).save(consumer);
        //橡木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.OAK_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.OAK_PLANKS)).save(consumer);
        //樱花木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CHERRY_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.CHERRY_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.CHERRY_PLANKS)).save(consumer);
        //云杉木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.SPRUCE_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(Items.SPRUCE_PLANKS)).save(consumer);
        //黄花梨酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HUANG_HUA_LI_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //鸡翅木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.JI_CHI_MU_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //紫檀木酒桌
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ZI_TAN_WINE_TABLE.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("X##")
                .pattern("X##")
                .pattern(" XX")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);

        //黄花梨茶几
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HUANG_HUA_LI_TEAPOY.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" ##")
                .pattern("X##")
                .pattern("XX ")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //鸡翅木茶几
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.JI_CHI_MU_TEAPOY.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" ##")
                .pattern("X##")
                .pattern("XX ")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //紫檀木茶几
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ZI_TAN_TEAPOY.get(),1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" ##")
                .pattern("X##")
                .pattern("XX ")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);
        //白桦酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BIRCH_DRINKING_TABLE_AND_CHAIRS.get(),1)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.BIRCH_PLANKS)).save(consumer);
        //深色橡木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DARK_OAK_DRINKING_TABLE_AND_CHAIRS.get(),1)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.DARK_OAK_PLANKS)).save(consumer);
        //红树酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MANGROVE_DRINKING_TABLE_AND_CHAIRS.get(),1)
                .define('#', Ingredient.of(Items.MANGROVE_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.MANGROVE_PLANKS)).save(consumer);
        //樱花木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CHERRY_DRINKING_TABLE_AND_CHAIRS.get(),1)
                .define('#', Ingredient.of(Items.CHERRY_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.CHERRY_PLANKS)).save(consumer);
        //云杉木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.SPRUCE_DRINKING_TABLE_AND_CHAIRS.get(),1)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.SPRUCE_PLANKS)).save(consumer);
        //橡木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.OAK_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.OAK_PLANKS)).save(consumer);
        //绯红木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CRIMSON_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(Items.CRIMSON_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.CRIMSON_PLANKS)).save(consumer);
        //诡异木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WARPED_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(Items.WARPED_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.WARPED_PLANKS)).save(consumer);

        //金合欢酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ACACIA_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(Items.ACACIA_PLANKS)).save(consumer);
        //紫檀木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ZI_TAN_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);
        //鸡翅木酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.JI_CHI_MU_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //黄花梨酒桌椅子
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HUANG_HUA_LI_DRINKING_TABLE_AND_CHAIRS.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" # ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //黄花梨太师椅
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HUANG_HUA_LI_TAISHI_CHAIR.get(), 1)
                .define('L', Ingredient.of(ChangShengJueItems.AG_INGOT.get()))
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" L ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //鸡翅木太师椅
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.JI_CHI_MU_TAISHI_CHAIR.get(), 1)
                .define('L', Ingredient.of(ChangShengJueItems.AG_INGOT.get()))
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('X',Ingredient.of(Items.STICK))
                .pattern(" L ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //紫檀木太师椅
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ZI_TAN_TAISHI_CHAIR.get(), 1)
                .define('L', Ingredient.of(ChangShengJueItems.AG_INGOT.get()))
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern(" L ")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);
        // 橡木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.OAK_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.OAK_PLANKS)).save(consumer);

        // 深色橡木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DARK_OAK_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.DARK_OAK_PLANKS)).save(consumer);

        // 白桦木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BIRCH_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.BIRCH_PLANKS)).save(consumer);

        // 绯红木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CRIMSON_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.CRIMSON_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.CRIMSON_PLANKS)).save(consumer);

        // 诡异木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WARPED_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.WARPED_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.WARPED_PLANKS)).save(consumer);

        // 红树木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.MANGROVE_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.MANGROVE_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.MANGROVE_PLANKS)).save(consumer);

        // 金合欢木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ACACIA_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.ACACIA_PLANKS)).save(consumer);

        // 樱花木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.CHERRY_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.CHERRY_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.CHERRY_PLANKS)).save(consumer);

        // 云杉木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.SPRUCE_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(Items.SPRUCE_PLANKS)).save(consumer);
        //鸡翅木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.JI_CHI_MU_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //紫檀木桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.ZI_TAN_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);
        //黄花梨桌席
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.HUANG_HUA_LI_LOW_DESK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //蒲团
        ShapedRecipeBuilder.shaped(MISC, ChangShengJueBlocks.ZAFU.get(), 1)
                .define('#', Ingredient.of(Items.HAY_BLOCK))
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_hay_block", has(Items.HAY_BLOCK)).save(consumer);
        //橡木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.OAK_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.OAK_PLANKS)).save(consumer);
        // 深色橡木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.DARK_OAK_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.DARK_OAK_PLANKS)).save(consumer);
        // 白桦木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.BIRCH_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.BIRCH_PLANKS)).save(consumer);
        // 绯红木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.CRIMSON_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.CRIMSON_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.CRIMSON_PLANKS)).save(consumer);
        // 诡异木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.WARPED_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.WARPED_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.WARPED_PLANKS)).save(consumer);
        // 红树木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.MANGROVE_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.MANGROVE_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.MANGROVE_PLANKS)).save(consumer);
        // 金合欢木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.ACACIA_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.ACACIA_PLANKS)).save(consumer);
        // 樱花树书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.CHERRY_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.CHERRY_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.CHERRY_PLANKS)).save(consumer);
        // 云杉木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.SPRUCE_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(Items.SPRUCE_PLANKS)).save(consumer);
        //鸡翅木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.JI_CHI_MU_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //黄花梨书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.HUANG_HUA_LI_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);
        //紫檀木书桌
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.ZI_TAN_BOOK_DESK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("XXX")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);
        //鸡翅木宝座
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.JI_CHI_MU_FIVE_SCREEN_THRONE.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.WENGE_PLANKS.get()))
                .define('Y', Ingredient.of(Items.HAY_BLOCK))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("#Y#")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.WENGE_PLANKS.get())).save(consumer);
        //紫檀木宝座
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.ZI_TAN_FIVE_SCREEN_THRONE.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.ZI_TAN_PLANKS.get()))
                .define('Y', Ingredient.of(Items.HAY_BLOCK))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("#Y#")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.ZI_TAN_PLANKS.get())).save(consumer);
        //黄花梨宝座
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.HUANG_HUA_LI_FIVE_SCREEN_THRONE.get(), 1)
                .define('#', Ingredient.of(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get()))
                .define('Y', Ingredient.of(Items.HAY_BLOCK))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("#Y#")
                .pattern("X X")
                .unlockedBy("has_planks", has(ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get())).save(consumer);

        //皮革帽子
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.LEATHER_HELMET,1)
                .define('#', Ingredient.of(Tags.Items.LEATHER))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_leather", has(Tags.Items.LEATHER)).save(consumer);

        //皮革胸甲
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.LEATHER_CHESTPLATE,1)
                .define('#', Ingredient.of(Tags.Items.LEATHER))
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_leather", has(Tags.Items.LEATHER)).save(consumer);

        //皮革护腿
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.LEATHER_LEGGINGS,1)
                .define('#', Ingredient.of(Tags.Items.LEATHER))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_leather", has(Tags.Items.LEATHER)).save(consumer);
        //皮革靴子
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.LEATHER_BOOTS,1)
                .define('#', Ingredient.of(Tags.Items.LEATHER))
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_leather", has(Tags.Items.LEATHER)).save(consumer);

        //练功木桩
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueItems.STAKES.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(ItemTags.PLANKS))
                .define('$', Ingredient.of(Tags.Items.COBBLESTONE))
                .pattern("#")
                .pattern("X")
                .pattern("$")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);

        //锻造炉
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.FORGE_BLOCK.get(),1)
                .define('#', Ingredient.of(Tags.Items.COBBLESTONE))
                .define('X', Ingredient.of(ItemTags.PLANKS))
                .define('$', Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("$$ ")
                .pattern("##X")
                .pattern("##X")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);

        //裁衣案
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.TAILORING_CASE.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .define('X', Ingredient.of(ItemTags.PLANKS))
                .define('$', Ingredient.of(Tags.Items.SHEARS))
                .pattern("##$")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);

        //画轴
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.PAINTING_SCROLL.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.PAPER))
                .pattern("#")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_planks", has(Items.PAPER)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.HIGH_PAINTING_SCROLL.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.PAPER))
                .pattern("#X#")
                .pattern("#X#")
                .unlockedBy("has_planks", has(Items.PAPER)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.WIDTH_PAINTING_SCROLL.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.PAPER))
                .pattern("##")
                .pattern("XX")
                .pattern("##")
                .unlockedBy("has_planks", has(Items.PAPER)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.BIG_PAINTING_SCROLL.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.PAPER))
                .pattern("###")
                .pattern("XXX")
                .pattern("###")
                .unlockedBy("has_planks", has(Items.PAPER)).save(consumer);

        //牌匾
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.PLAQUE.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(Items.PAPER))
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .unlockedBy("has_planks", has(Items.PAPER)).save(consumer);

        //酒坛
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ChangShengJueBlocks.EMPTY_FEN_JIU.get(), 1)
                .requires(Ingredient.of(Items.CLAY_BALL), 4)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL)).save(consumer);



        //烧炼配方
        //矿石
        oreSmelting(consumer, AG_SMELTABLES, RecipeCategory.MISC, ChangShengJueItems.AG_INGOT.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer, AG_SMELTABLES, RecipeCategory.MISC, ChangShengJueItems.AG_INGOT.get(), 0.25f, SMOKING_TICK, "sapphire");

        oreSmelting(consumer,List.of(ChangShengJueBlocks.KAOLIN_ORE.get()), RecipeCategory.MISC, ChangShengJueItems.WHITE_BRICKS_ITEM.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer,List.of(ChangShengJueBlocks.KAOLIN_ORE.get()), RecipeCategory.MISC, ChangShengJueItems.WHITE_BRICKS_ITEM.get(), 0.25f, SMOKING_TICK, "sapphire");

        oreSmelting(consumer,List.of(ChangShengJueBlocks.LIMESTONE.get()), RecipeCategory.MISC, ChangShengJueItems.QUICKLIME.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer,List.of(ChangShengJueBlocks.LIMESTONE.get()), RecipeCategory.MISC, ChangShengJueItems.QUICKLIME.get(), 0.25f, SMOKING_TICK, "sapphire");

        oreSmelting(consumer,List.of(ChangShengJueBlocks.SYDEROLIFE_ORE.get()), RecipeCategory.MISC, ChangShengJueItems.BLACK_BRICKS.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer,List.of(ChangShengJueBlocks.SYDEROLIFE_ORE.get()), RecipeCategory.MISC, ChangShengJueItems.BLACK_BRICKS.get(), 0.25f, SMOKING_TICK, "sapphire");
        //坩埚
        oreSmelting(consumer,List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get(), 0.25f, 300, "sapphire");
        oreBlasting(consumer, List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_COPPER.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_COPPER.get(), 0.25f, 150, "sapphire");
        oreSmelting(consumer,List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), 0.25f, 300, "sapphire");
        oreBlasting(consumer, List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), 0.25f, 150, "sapphire");
        oreSmelting(consumer,List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), 0.25f, 300, "sapphire");
        oreBlasting(consumer, List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), 0.25f, 150, "sapphire");

        // 食物
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.CAPSULE_JIAO_ZI.get())
                .requires(ChangShengJueItems.CAPSULE.get())
                .requires(Tags.Items.CROPS_WHEAT)
                .requires(Items.PORKCHOP)
                .unlockedBy("has_plates",has(ChangShengJueItems.CAPSULE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.ZHENG_CAI.get())
                .requires(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get())
                .requires(Tags.Items.CROPS_WHEAT)
                .requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get())
                .requires(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get())
                .requires(Tags.Items.CROPS_WHEAT)
                .unlockedBy("has_portulaca_oleracea_block",has(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.QING_TUAN.get())
                .requires(ChangShengJueItems.STICKYRICE_1.get())
                .requires(ChangShengJueBlocks.MUGWORT_BLOCK.get())
                .requires(ChangShengJueItems.REDBEAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.STICKYRICE_1.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.TOMATO_EGG.get())
                .requires(ChangShengJueItems.TOMATO.get())
                .requires(Tags.Items.EGGS)
                .requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.GU_LAO_ROU.get())
                .requires(ChangShengJueItems.PINEAPPLE.get())
                .requires(Items.PORKCHOP)
                .requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.MEAT_FOAM_BRINJAL.get())
                .requires(ChangShengJueItems.BRINJAL.get(),2)
                .requires(Items.PORKCHOP)
                .requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.SORGHUM_CAKE.get())
                .requires(ChangShengJueItems.SORGHUM.get(),3)
                .unlockedBy("has_sorghum",has(ChangShengJueItems.SORGHUM.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.STINKY_TOFU.get())
                .requires(ChangShengJueItems.SOYBEAN.get(),3)
                .requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.ZHU_DU_JI.get())
                .requires(ChangShengJueItems.JALAPENOS.get())
                .requires(Items.PORKCHOP)
                .requires(Items.CHICKEN)
                .requires(ChangShengJueItems.CI_WAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.XIAO_MI_FAN.get())
                .requires(ChangShengJueItems.GU_SUI.get(),3)
                .unlockedBy("has_bowls",has(ChangShengJueItems.GU_SUI.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.MI_FAN.get())
                .requires(ChangShengJueItems.RICE.get(),3)
                .unlockedBy("has_bowls",has(ChangShengJueItems.RICE.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.GUI_HUA_TANG_OU.get())
                .requires(ChangShengJueItems.GUI_HUA.get())
                .requires(ChangShengJueItems.LOTUS_ROOT.get())
                .requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.BA_BAO_ZHOU.get())
                .requires(ChangShengJueItems.PEANUT.get()).requires(ChangShengJueItems.LOTUS_SEEDS.get()).requires(ChangShengJueItems.REDBEAN.get())
                .requires(ChangShengJueItems.RICE.get()).requires(ChangShengJueItems.GU_SUI.get()).requires(ChangShengJueItems.GRAPE.get())
                .requires(ChangShengJueItems.SOYBEAN.get()).requires(ChangShengJueItems.CORN.get()).requires(ChangShengJueItems.CI_WAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.MULBERRY_JUICE.get())
                .requires(ChangShengJueItems.MULBERRY.get(),3)
                .requires(ChangShengJueItems.CI_BEI.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.CI_BEI.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.APPLE_JUICE.get())
                .requires(Items.APPLE,2).requires(ChangShengJueItems.CI_BEI.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.CI_BEI.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.HOT_PEAR_SOUP.get())
                .requires(ChangShengJueItems.PEAR.get(),2).requires(ChangShengJueItems.CI_WAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.GRAPE_JUICE.get())
                .requires(ChangShengJueItems.GRAPE.get(),3).requires(ChangShengJueItems.CI_BEI.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.CI_BEI.get()))
                .save(consumer);


        foodCooking(Ingredient.of(ChangShengJueItems.CORN.get()),ChangShengJueItems.BAKED_CORN.get(),1,consumer,"baked_corn");

        foodCooking(Ingredient.of(ChangShengJueItems.PEACOCK.get()),ChangShengJueItems.COOKED_PEACOCK.get(),1,consumer,"cooked_peacock");

        foodCooking(Ingredient.of(ChangShengJueItems.CROC.get()),ChangShengJueItems.COOKED_CROC.get(),1,consumer,"cooked_croc");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    public static void foodCooking(Ingredient ingredient, ItemLike itemLike, float f, Consumer<FinishedRecipe> consumer, String name){
        String string = new ResourceLocation(ChangShengJue.MOD_ID, name).toString();

        SimpleCookingRecipeBuilder.smelting(ingredient,FOOD,itemLike,f,SMELTING_TICK)
                .unlockedBy(name, hasItems(ingredient.getItems()[0].getItem()))
                .save(consumer);

        SimpleCookingRecipeBuilder.generic(ingredient,FOOD, itemLike,f,SMOKING_TICK,RecipeSerializer.SMOKING_RECIPE)
                .unlockedBy(name, hasItems(ingredient.getItems()[0].getItem()))
                .save(consumer,string + "_from_smoking");

        SimpleCookingRecipeBuilder.campfireCooking(ingredient,FOOD, itemLike,f,CAMPFIRE_COOKING_TICK)
                .unlockedBy(name, hasItems(ingredient.getItems()[0].getItem()))
                .save(consumer,string + "_from_campfire_cooking");
    }
}
