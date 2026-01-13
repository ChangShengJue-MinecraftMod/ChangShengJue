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
import net.minecraft.world.level.block.Block;
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

        //建筑方块
        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.HANG_TU_BLOCK.get(),6).requires(Blocks.DIRT,9).unlockedBy("has_dirt",has(Blocks.DIRT)).save(consumer);
        stairBuilder(ChangShengJueBlocks.HANG_TU_STAIRS.get(), Ingredient.of(ChangShengJueBlocks.HANG_TU_BLOCK.get())).unlockedBy("has_hang_tu_block", has(ChangShengJueBlocks.HANG_TU_BLOCK.get())).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.HANG_TU_SLAB.get(), Ingredient.of(ChangShengJueBlocks.HANG_TU_BLOCK.get())).unlockedBy("has_hang_tu_block", has(ChangShengJueBlocks.HANG_TU_BLOCK.get())).save(consumer);
        wall(consumer,RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.HANG_TU_WALL.get(),ChangShengJueBlocks.HANG_TU_BLOCK.get());

        stairBuilder(ChangShengJueBlocks.TU_PEI_STAIRS.get(), Ingredient.of(Blocks.DIRT)).unlockedBy("has_dirt", has(Blocks.DIRT)).save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.TU_PEI_SLAB.get(),
                Ingredient.of(Blocks.DIRT)).unlockedBy("has_dirt", has(Blocks.DIRT)).save(consumer);
        wall(consumer,RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.TU_PEI_WALL.get(),Blocks.DIRT);
        // 汉白玉
        stairBuilder(ChangShengJueBlocks.WHITE_JADE_STAIRS.get(),
                Ingredient.of(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .unlockedBy("has_white_jade", has(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .save(consumer);
        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.WHITE_JADE_SLAB.get(),
                Ingredient.of(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .unlockedBy("has_white_jade", has(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .save(consumer);
        wall(consumer,RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.WHITE_JADE_WALL.get(),ChangShengJueBlocks.WHITE_JADE_BLOCK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WHITE_JADE_BALUSTRADE.get(),5)
                .define('#', Ingredient.of(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_white_jade", has(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WHITE_JADE_GUARDRAIL.get(),5)
                .define('#', Ingredient.of(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_white_jade", has(ChangShengJueBlocks.WHITE_JADE_BLOCK.get()))
                .save(consumer);

        //石灰浆
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.LIME_SLURRY_BARRELS.get())
                .requires(ChangShengJueItems.QUICKLIME.get())
                .requires(Items.WATER_BUCKET)
                .unlockedBy("has_water_bucket",has(Items.WATER_BUCKET))
                .save(consumer);

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
        //青转
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BLUE_STONE_BRICKS.get())
                .define('#', ChangShengJueItems.CYAN_BRICKS.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_bricks", has(ChangShengJueItems.CYAN_BRICKS.get()))
                .save(consumer,"cyan_stone_bricks_shaped");

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),9)
                .requires(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),9)
                .unlockedBy("has_bricks",has(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get()))
                .save(consumer,"cyan_stone_bricks_shapeless");

        ShapelessRecipeBuilder.shapeless(MISC, ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),9)
                .requires(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),9)
                .unlockedBy("has_bricks",has(ChangShengJueBlocks.BLUE_STONE_BRICKS.get()))
                .save(consumer);

        stairBuilder(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(),
                Ingredient.of(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),
                        ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get()))
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLUE_STONE_BRICKS.get()))
                .save(consumer);

        slabBuilder(RecipeCategory.BUILDING_BLOCKS,ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(),
                Ingredient.of(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),
                        ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get()))
                .unlockedBy("has_dirt", has(ChangShengJueBlocks.BLUE_STONE_BRICKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(),6)
                .define('#', Ingredient.of(ChangShengJueBlocks.BLUE_STONE_BRICKS.get(),ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get()))
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLUE_STONE_BRICKS.get()))
                .save(consumer);

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
        //磨刀石
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.STONE_SHARPENING_STONE.get(),1)
                .define('#', Ingredient.of(Tags.Items.COBBLESTONE))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_sand", has(Tags.Items.COBBLESTONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DIAMOND_SHARPENING_STONE.get(),1)
                .define('#', Ingredient.of(Tags.Items.GEMS_DIAMOND))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_sand", has(Tags.Items.GEMS_DIAMOND)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.NETHERITE_SHARPENING_STONE.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_NETHERITE))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_sand", has(Tags.Items.INGOTS_NETHERITE)).save(consumer);

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
                .save(consumer);
        // 陶轮
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.POTTERY_WHEEL.get(), 1)
                .define('#', Ingredient.of(Items.COBBLESTONE))
                .pattern(" # ")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_planks",has(ItemTags.PLANKS))
                .save(consumer);
        //工具台
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.TOOL_TABLE.get(), 1)
                .define('#', Ingredient.of(ItemTags.PLANKS))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("###")
                .pattern("###")
                .pattern("X X")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);
        //牲畜食槽
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueBlocks.PIG_TROUGH.get(), 1)
                .define('#', Ingredient.of(Items.COBBLESTONE))
                .pattern("   ")
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);
        //丝绸
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueItems.SILK.get(), 1)
                .define('#', Ingredient.of(ChangShengJueItems.NATURAL_SILK.get()))
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(consumer);


        /**
         * 家具
         */
        //蒲团
        ShapedRecipeBuilder.shaped(MISC, ChangShengJueBlocks.ZAFU.get(), 1)
                .define('#', Ingredient.of(Items.HAY_BLOCK))
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_hay_block", has(Items.HAY_BLOCK)).save(consumer);

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
        //木工台
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.WOOD_WORKING_BENCH.get(),1)
                .define('X', Ingredient.of(ItemTags.PLANKS))
                .define('$', Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("$X$")
                .pattern("X X")
                .pattern("XXX")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        //窑炉
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueBlocks.BRICK_KILN.get(),1)
                .define('X', Ingredient.of(ItemTags.DIRT))
                .pattern("XXX")
                .pattern("X X")
                .pattern("XXX")
                .unlockedBy("has_dirt", has(ItemTags.DIRT)).save(consumer);

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

        //酒坛
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ChangShengJueBlocks.EMPTY_FEN_JIU.get(), 1)
                .requires(Ingredient.of(Items.CLAY_BALL), 4)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL)).save(consumer);

        //烧炼配方
        //矿石
        oreSmelting(consumer, AG_SMELTABLES, RecipeCategory.MISC, ChangShengJueItems.AG_INGOT.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer, AG_SMELTABLES, RecipeCategory.MISC, ChangShengJueItems.AG_INGOT.get(), 0.25f, SMOKING_TICK, "sapphire");

        oreSmelting(consumer,List.of(ChangShengJueItems.KAOLIN_BALL.get()), RecipeCategory.MISC, ChangShengJueItems.WHITE_BRICKS_ITEM.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer,List.of(ChangShengJueItems.KAOLIN_BALL.get()), RecipeCategory.MISC, ChangShengJueItems.WHITE_BRICKS_ITEM.get(), 0.25f, SMOKING_TICK, "sapphire");

        oreSmelting(consumer,List.of(ChangShengJueBlocks.LIMESTONE.get()), RecipeCategory.MISC, ChangShengJueItems.QUICKLIME.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer,List.of(ChangShengJueBlocks.LIMESTONE.get()), RecipeCategory.MISC, ChangShengJueItems.QUICKLIME.get(), 0.25f, SMOKING_TICK, "sapphire");

        oreSmelting(consumer,List.of(ChangShengJueItems.SYDEROLIFE_BALL.get()), RecipeCategory.MISC, ChangShengJueItems.BLACK_BRICKS.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer,List.of(ChangShengJueItems.SYDEROLIFE_BALL.get()), RecipeCategory.MISC, ChangShengJueItems.BLACK_BRICKS.get(), 0.25f, SMOKING_TICK, "sapphire");
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
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.BILUOCHUN_TEAS.get())
                .requires(ChangShengJueItems.BILUOCHUN_TEA.get(),3).requires(ChangShengJueItems.CI_BEI.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.CI_BEI.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.LONG_JING_TEAS.get())
                .requires(ChangShengJueItems.LONG_JING_TEA.get(),3).requires(ChangShengJueItems.CI_BEI.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.CI_BEI.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.FEN_JIU.get())
                .requires(ChangShengJueItems.SORGHUM.get(),4)
                .requires(ChangShengJueItems.HORDEUM.get()).requires(ChangShengJueItems.EMPTY_FEN_JIU.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.EMPTY_FEN_JIU.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.WHEAT_NUGGETS_TRIBUTE_WINE.get())
                .requires(ChangShengJueItems.SORGHUM.get(),4)
                .requires(Tags.Items.CROPS_WHEAT).requires(ChangShengJueItems.EMPTY_FEN_JIU.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.EMPTY_FEN_JIU.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.SHI_LI_XIANG.get())
                .requires(ChangShengJueItems.SORGHUM.get(),4)
                .requires(ChangShengJueItems.STICKYRICE_1.get()).requires(ChangShengJueItems.EMPTY_FEN_JIU.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.EMPTY_FEN_JIU.get()))
                .save(consumer);

        foodCooking(Ingredient.of(ChangShengJueItems.CORN.get()),ChangShengJueItems.BAKED_CORN.get(),1,consumer,"baked_corn");

        foodCooking(Ingredient.of(ChangShengJueItems.PEACOCK.get()),ChangShengJueItems.COOKED_PEACOCK.get(),1,consumer,"cooked_peacock");

        foodCooking(Ingredient.of(ChangShengJueItems.CROC.get()),ChangShengJueItems.COOKED_CROC.get(),1,consumer,"cooked_croc");

        buildWoodworkingBenchRecipes(consumer);

        buildBrickKilnRecipes(consumer);
    }

    /**
     * 木工台配方生成
     */
    private void buildWoodworkingBenchRecipes(Consumer<FinishedRecipe> consumer) {
    }
    /**
     * 砖窑配方生成
     */
    private void buildBrickKilnRecipes(Consumer<FinishedRecipe> consumer) {
        //        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get())
//                .requires(ChangShengJueItems.KAOLIN_BALL.get(), 4)
//                .requires(Items.GRAY_DYE)
//                .unlockedBy("has_kaolin_ball", has(ChangShengJueItems.KAOLIN_BALL.get()))
//                .group("wa_zuo:gray")
//                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID,
//                        "brick_kiln/" + ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.getId().getPath()));
        cylinderTile(consumer, ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_CYLINDER_TILE_BLOCK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_CYLINDER_TILE_BLOCK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_CYLINDER_TILE_BLOCK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_BLOCK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_CYLINDER_TILE_BLOCK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_CYLINDER_TILE_BLOCK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_CYLINDER_TILE_BLOCK.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.get(),2,4,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_CYLINDER_TILE_SLAB.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.get(),2,4,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_CYLINDER_TILE_SLAB.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.get(),2,4,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_CYLINDER_TILE_SLAB.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.get(),2,4,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SLAB.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.get(),2,4,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_CYLINDER_TILE_SLAB.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.get(),2,4,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_CYLINDER_TILE_SLAB.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.get(),2,4,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SLAB.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.get(),2,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_SHORT_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.get(),2,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_SHORT_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.get(),2,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_SHORT_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.get(),2,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_SHORT_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.get(),2,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_SHORT_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.get(),2,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_SHORT_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.get(),2,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_SHORT_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_CYLINDER_TILE.get(),2,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_CYLINDER_TILE.get(),2,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_CYLINDER_TILE.get(),2,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.get(),2,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_CYLINDER_TILE.get(),2,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_CYLINDER_TILE.get(),2,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_CYLINDER_TILE.get(),2,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_RIDGE_TILE.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_RIDGE_TILE.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_RIDGE_TILE.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_RIDGE_TILE.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_RIDGE_TILE.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_RIDGE_TILE.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_RIDGE_TILE.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_RIDGE_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_DOUBLE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_DOUBLE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_DOUBLE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_DOUBLE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_DOUBLE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_DOUBLE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_DOUBLE_RIDGE_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.HANGING_BEAST_GRE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.HANGING_BEAST_RED_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.HANGING_BEAST_BLACK_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.HANGING_BEAST_GOLDEN_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.HANGING_BEAST_CYAN_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.HANGING_BEAST_BLUE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.HANGING_BEAST_PURPLE_RIDGE_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.ANIMALS_GRE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.ANIMALS_RED_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.ANIMALS_BLACK_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.ANIMALS_GOLDEN_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.ANIMALS_CYAN_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.ANIMALS_BLUE_RIDGE_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.ANIMALS_PURPLE_RIDGE_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_DOUBLE_HANGING_BEAST_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_ROOF_RIDGE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_ROOF_RIDGE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_ROOF_RIDGE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_ROOF_RIDGE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_ROOF_RIDGE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_ROOF_RIDGE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_ROOF_RIDGE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_ROOF_RIDGE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_ROOF_RIDGE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_ROOF_RIDGE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_ROOF_RIDGE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_ROOF_RIDGE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_ROOF_RIDGE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_CHARACTER_PLAQUE_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_CHARACTER_PLAQUE_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_CHARACTER_PLAQUE_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_CHARACTER_PLAQUE_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_CHARACTER_PLAQUE_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_CHARACTER_PLAQUE_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.get(),1,8,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_CHARACTER_PLAQUE_PAVILION.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.get(),1,8,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_RIDGE_FINIAL_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.get(),1,8,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_RIDGE_FINIAL_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.get(),1,8,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_RIDGE_FINIAL_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.get(),1,8,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_RIDGE_FINIAL_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.get(),1,8,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_RIDGE_FINIAL_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.get(),1,8,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_RIDGE_FINIAL_PAVILION.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.get(),1,8,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_RIDGE_FINIAL_PAVILION.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.get(),2,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_SMALL_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_SMALL_DEMON_MASK.get(),2,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_SMALL_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.get(),2,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_SMALL_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.get(),2,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_SMALL_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.get(),2,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_SMALL_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.get(),2,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_SMALL_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.get(),2,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_SMALL_DEMON_MASK.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_DEMON_MASK.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_DEMON_MASK.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_DEMON_MASK.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_DEMON_MASK.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_DEMON_MASK.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_DEMON_MASK.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_DEMON_MASK.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_DEMON_MASK.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_DEMON_MASK.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_EAVES_TILE.get(),2,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_EAVES_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_EAVES_TILE.get(),2,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_EAVES_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_EAVES_TILE.get(),2,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_EAVES_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_EAVES_TILE.get(),2,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_EAVES_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_EAVES_TILE.get(),2,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_EAVES_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_EAVES_TILE.get(),2,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_EAVES_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_EAVES_TILE.get(),2,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_EAVES_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_EAVES_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_EAVES_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_EAVES_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_EAVES_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_EAVES_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_EAVES_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_EAVES_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.get(),2,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_EAVES_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_EAVES_TILE_SIDE.get(),2,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_EAVES_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.get(),2,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_EAVES_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.get(),2,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_EAVES_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.get(),2,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_EAVES_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.get(),2,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_EAVES_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.get(),2,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_EAVES_TILE_SIDE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.get(),2,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_CYLINDER_TILE_SIDE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_HIPPED_ROOF.get(),1,6,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_HIPPED_ROOF.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_HIPPED_ROOF.get(),1,6,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_HIPPED_ROOF.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_HIPPED_ROOF.get(),1,6,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_HIPPED_ROOF.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.get(),1,6,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_HIPPED_ROOF.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_HIPPED_ROOF.get(),1,6,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_HIPPED_ROOF.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_HIPPED_ROOF.get(),1,6,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_HIPPED_ROOF.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_HIPPED_ROOF.get(),1,6,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_HIPPED_ROOF.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_DOUBLE_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_DOUBLE_CYLINDER_TILE_SIDE.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_FRONT.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_DOUBLE_GABLE_RIDGE_CYLINDER_TILE_BEHIND.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_UPTURNED_EAVES.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_UPTURNED_EAVES.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_UPTURNED_EAVES.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_UPTURNED_EAVES.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_UPTURNED_EAVES.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_UPTURNED_EAVES.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_UPTURNED_EAVES.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_FRONT.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_DWARF_RIDGE_TILES_BEHIND.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_FRONT.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.get(), Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_HIGH_RIDGE_TILES_BEHIND.getId().getPath());

        cylinderTile(consumer, ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.GRAY_DYE,
                "gray", ChangShengJueBlocks.GRE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.RED_DYE,
                "red", ChangShengJueBlocks.RED_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.BLACK_DYE,
                "black", ChangShengJueBlocks.BLACK_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.YELLOW_DYE,
                "gold", ChangShengJueBlocks.GOLDEN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.CYAN_DYE,
                "cyan", ChangShengJueBlocks.CYAN_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.BLUE_DYE,
                "blue", ChangShengJueBlocks.BLUE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());
        cylinderTile(consumer, ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.get(),1,2,Items.PURPLE_DYE,
                "purple", ChangShengJueBlocks.PURPLE_OCTAGONAL_GABLE_RIDGE_CYLINDER_TILE.getId().getPath());

        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_TILE.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_TILE.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_GENTLE_TILE.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_GENTLE_TILE.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_CORNICES.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_CORNICES.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_GENTLE_CORNICES.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_TILE_BLOCK_2.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_TILE_BLOCK_3.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:gold")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.GOLDEN_TILE_BLOCK_4.getId().getPath()));

        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_TILE.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_TILE.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_GENTLE_TILE.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_GENTLE_TILE.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_CORNICES.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_CORNICES.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_GENTLE_CORNICES.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_GENTLE_CORNICES.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.TILE_BLOCK_2.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.TILE_BLOCK_2.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.TILE_BLOCK_3.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.TILE_BLOCK_3.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.TILE_BLOCK_4.get(),3)
                .requires(ChangShengJueItems.GOLD_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueItems.GOLD_BRICKS.get()))
                .group("wa_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.TILE_BLOCK_4.getId().getPath()));
        //石作
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.STONE_TABLE.get())
                .requires(Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE))
                .group("shi_zuo:stone_table")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/shi_zuo/" + ChangShengJueBlocks.STONE_TABLE.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.STONE_BENCH.get())
                .requires(Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE))
                .group("shi_zuo:stone_bench")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/shi_zuo/" + ChangShengJueBlocks.STONE_BENCH.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.STONE_BALUSTRADE.get())
                .requires(Items.STONE)
                .unlockedBy("has_stone", has(Items.STONE))
                .group("shi_zuo:stone_balustrade")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/shi_zuo/" + ChangShengJueBlocks.STONE_BALUSTRADE.getId().getPath()));

        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.get())
                .requires(Items.STONE)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_stone", has(Items.STONE))
                .group("shi_zuo:stone_lion_block")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/shi_zuo/" + ChangShengJueBlocks.YELLOW_STONE_LION_BLOCK.getId().getPath()));

        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.GRE_STONE_LION_BLOCK.get())
                .requires(Items.STONE)
                .requires(Items.GRAY_DYE)
                .unlockedBy("has_stone", has(Items.STONE))
                .group("shi_zuo:stone_lion_block")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/shi_zuo/" + ChangShengJueBlocks.GRE_STONE_LION_BLOCK.getId().getPath()));
        //细砖
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.WHITE_FINE_BRICKS.get())
                .requires(ChangShengJueItems.WHITE_BRICKS_ITEM.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.WHITE_BRICKS_ITEM.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.WHITE_FINE_BRICKS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get())
                .requires(ChangShengJueItems.BLACK_BRICKS.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.BLACK_BRICKS.get()))
                .group("shi_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get())
                .requires(ChangShengJueItems.CYAN_BRICKS.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.CYAN_BRICKS.get()))
                .group("shi_zuo:cyan")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.getId().getPath()));
        //石砖
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.WHITE_BRICKS.get())
                .requires(ChangShengJueItems.WHITE_BRICKS_ITEM.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.WHITE_BRICKS_ITEM.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.WHITE_BRICKS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_STONE_BRICKS.get())
                .requires(ChangShengJueItems.BLACK_BRICKS.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.BLACK_BRICKS.get()))
                .group("shi_zuo:black")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_STONE_BRICKS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_STONE_BRICKS.get())
                .requires(ChangShengJueItems.CYAN_BRICKS.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.CYAN_BRICKS.get()))
                .group("shi_zuo:cyan")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLUE_STONE_BRICKS.getId().getPath()));
        //地砖
//        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.WHITE_BRICKS.get())
//                .requires(ChangShengJueItems.WHITE_BRICKS_ITEM.get(),4)
//                .unlockedBy("has_bricks", has(ChangShengJueItems.WHITE_BRICKS_ITEM.get()))
//                .group("wa_zuo:bricks")
//                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.WHITE_BRICKS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.get())
                .requires(ChangShengJueItems.BLACK_BRICKS.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.BLACK_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_FLOOR_TILES_BLOCK.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.get())
                .requires(ChangShengJueItems.CYAN_BRICKS.get(),4)
                .unlockedBy("has_bricks", has(ChangShengJueItems.CYAN_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLUE_FLOOR_TILES_BLOCK.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.get(),2)
                .requires(ChangShengJueItems.WHITE_BRICKS_ITEM.get(),6)
                .requires(ChangShengJueItems.NATURAL_ASPHALT.get(),2)
                .unlockedBy("has_bricks", has(ChangShengJueItems.CYAN_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BITUMEN_FLOOR_TILES_BLOCK.getId().getPath()));
        //楼梯
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.WHITE_BRICKS_STAIRS.get(),4)
                .requires(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.WHITE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.WHITE_BRICKS_STAIRS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.get(),4)
                .requires(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_STONE_BRICKS_STAIRS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.get(),4)
                .requires(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),6)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLUE_STONE_BRICKS_STAIRS.getId().getPath()));
        //台阶
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.WHITE_BRICKS_SLAB.get(),6)
                .requires(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),3)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.WHITE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.WHITE_BRICKS_SLAB.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.get(),6)
                .requires(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),3)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_STONE_BRICKS_SLAB.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.get(),6)
                .requires(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),3)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLUE_STONE_BRICKS_SLAB.getId().getPath()));
        //竖墙
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.get(),6)
                .requires(ChangShengJueBlocks.WHITE_FINE_BRICKS.get(),3)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.WHITE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.WHITE_BRICKS_VERTICAL_WALLS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.get(),6)
                .requires(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get(),3)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLACK_STONE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLACK_STONE_VERTICAL_WALLS.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.get(),6)
                .requires(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get(),3)
                .unlockedBy("has_bricks", has(ChangShengJueBlocks.BLUE_STONE_FINE_BRICKS.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueBlocks.BLUE_STONE_VERTICAL_WALLS.getId().getPath()));
        //白砖
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.WHITE_BRICKS_ITEM.get())
                .requires(ChangShengJueItems.KAOLIN_BALL.get())
                .unlockedBy("has_ball", has(ChangShengJueItems.KAOLIN_BALL.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueItems.WHITE_BRICKS_ITEM.getId().getPath()));
        //金砖
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.GOLD_BRICKS.get(),2)
                .requires(ChangShengJueItems.KAOLIN_BALL.get())
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_ball", has(ChangShengJueItems.KAOLIN_BALL.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueItems.GOLD_BRICKS.getId().getPath()));
        //黑砖
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.BLACK_BRICKS.get())
                .requires(ChangShengJueItems.SYDEROLIFE_BALL.get())
                .unlockedBy("has_ball", has(ChangShengJueItems.SYDEROLIFE_BALL.get()))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueItems.BLACK_BRICKS.getId().getPath()));
        //青砖
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.CYAN_BRICKS.get())
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_ball", has(Items.CLAY_BALL))
                .group("shi_zuo:bricks")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + ChangShengJueItems.CYAN_BRICKS.getId().getPath()));

        //杂类
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.get())
                .requires(ChangShengJueItems.KAOLIN_BALL.get(), 2)
                .requires(Tags.Items.GEMS_LAPIS, 1)
                .unlockedBy("has_lapis_lazuli", has(Tags.Items.GEMS_LAPIS))
                .group("za_lei:blue_and_white_porcelain_flower_pots")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/za_lei/" + ChangShengJueBlocks.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS.getId().getPath()));
        //瓷器
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.CI_WAN.get())
                .requires(Items.CLAY_BALL,3)
                .unlockedBy("has_ball", has(Items.CLAY_BALL))
                .group("za_lei:porcelain")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/za_lei/" + ChangShengJueItems.CI_WAN.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.CI_BEI.get())
                .requires(Items.CLAY_BALL)
                .unlockedBy("has_ball", has(Items.CLAY_BALL))
                .group("za_lei:porcelain")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/za_lei/" + ChangShengJueItems.CI_BEI.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.CI_PAN.get())
                .requires(Items.CLAY_BALL,2)
                .unlockedBy("has_ball", has(Items.CLAY_BALL))
                .group("za_lei:porcelain")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/za_lei/" + ChangShengJueItems.CI_PAN.getId().getPath()));
        BrickKilnRecipeBuilder.brickKiln(ChangShengJueItems.EMPTY_FEN_JIU.get())
                .requires(Items.CLAY_BALL,4)
                .unlockedBy("has_ball", has(Items.CLAY_BALL))
                .group("za_lei:porcelain")
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/za_lei/" + ChangShengJueItems.EMPTY_FEN_JIU.getId().getPath()));
    }

    /**
     * 窑炉配方辅助方法
     * @param consumer 配方消费者
     * @param block 结果方块
     * @param dye 染料
     * @param color 颜色分类（用于group和文件名）
     */
    private void cylinderTile(Consumer<FinishedRecipe> consumer, Block block, ItemLike dye, String color, String blockId) {
        BrickKilnRecipeBuilder.brickKiln(block)
                .requires(ChangShengJueItems.KAOLIN_BALL.get(), 4)
                .requires(dye)
                .unlockedBy("has_kaolin_ball", has(ChangShengJueItems.KAOLIN_BALL.get()))
                .group("wa_zuo:" + color)
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + blockId));
    }

    /**
     * 窑炉配方辅助方法
     * @param consumer 配方消费者
     * @param block 结果方块
     * @param blockCount 结果方块数量
     * @param count 材料数量
     * @param dye 染料
     * @param color 颜色分类（用于group和文件名）
     */
    private void cylinderTile(Consumer<FinishedRecipe> consumer, Block block, int blockCount, int count, ItemLike dye, String color, String blockId) {
        BrickKilnRecipeBuilder.brickKiln(block, blockCount)
                .requires(ChangShengJueItems.KAOLIN_BALL.get(), count)
                .requires(dye)
                .unlockedBy("has_kaolin_ball", has(ChangShengJueItems.KAOLIN_BALL.get()))
                .group("wa_zuo:" + color)
                .save(consumer, new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln/wa_zuo/" + blockId));
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
