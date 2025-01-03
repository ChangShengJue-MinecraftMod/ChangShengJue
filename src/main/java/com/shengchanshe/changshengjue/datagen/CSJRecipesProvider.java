package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.tags.CSJTags;
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
        planksFromLog(consumer, ChangShengJueBlocks.HUANG_HUA_LI_PLANKS.get(), CSJTags.Items.HUANG_HUA_LI_LOG, 4);
        planksFromLog(consumer, ChangShengJueBlocks.JI_CHI_MU_PLANKS.get(), CSJTags.Items.JI_CHI_MU_LOG, 4);
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
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_OAK_BLOCK.get(),2)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_BIRCH_BLOCK.get(),2)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_DARK_OAK_BLOCK.get(),2)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_SPRUCE_BLOCK.get(),2)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.DOOR_ACACIA_BLOCK.get(),2)
                .define('#', Ingredient.of(Items.ACACIA_PLANKS))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        //窗户
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_OAK_BLOCK_2.get(),3)
                .define('#', Ingredient.of(Items.OAK_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_BIRCH_BLOCK_2.get(),3)
                .define('#', Ingredient.of(Items.BIRCH_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_DARK_OAK_BLOCK_2.get(),3)
                .define('#', Ingredient.of(Items.DARK_OAK_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_SPRUCE_BLOCK_2.get(),3)
                .define('#', Ingredient.of(Items.SPRUCE_PLANKS))
                .pattern("# #")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ChangShengJueBlocks.WINDOWS_ACACIA_BLOCK_2.get(),3)
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
        //工具
        //萱花斧
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueItems.XUANHUA_AXE.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_COPPER))
                .define('X', Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //开山镐
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ChangShengJueItems.KAISHAN_PICKAXE.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_COPPER))
                .define('X', Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //战斗用品
        //青铜剑
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.BRONZE_SWORD.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_COPPER))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("#")
                .pattern("#")
                .pattern("X")
                .unlockedBy("has_ingots_copper", has(Tags.Items.INGOTS_COPPER)).save(consumer);
        //汉剑
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.HAN_JIAN.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //软剑
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.SOFT_SWORD.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Tags.Items.STRING))
                .pattern("# ")
                .pattern("# ")
                .pattern("#X")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //横刀
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.HENG_DAO.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("#")
                .pattern("#")
                .pattern("X")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //大刀
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.LARGE_KNIFE.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("##")
                .pattern("# ")
                .pattern("X ")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //红缨枪
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.RED_TASSELLED_SPEAR.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Items.RED_WOOL))
                .define('$', Ingredient.of(Items.STICK))
                .pattern("#")
                .pattern("X")
                .pattern("$")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //飞刀
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT,ChangShengJueItems.THROWING_KNIVES.get()).requires(Ingredient.of(Tags.Items.INGOTS_IRON),1)
                .unlockedBy("has_iron",has(Tags.Items.INGOTS_IRON)).save(consumer);
        //三把飞刀
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT,ChangShengJueItems.THREE_THROWING_KNIVES.get()).requires(Ingredient.of(ChangShengJueItems.THROWING_KNIVES.get()),3)
                .unlockedBy("has_throwing_knives",has(ChangShengJueItems.THROWING_KNIVES.get())).save(consumer);
        //七把飞刀
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT,ChangShengJueItems.SEVEN_THROWING_KNIVES.get()).requires(Ingredient.of(ChangShengJueItems.THROWING_KNIVES.get()),7)
                .unlockedBy("has_throwing_knives",has(ChangShengJueItems.THROWING_KNIVES.get())).save(consumer);
        //盘花棍
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.PAN_HUA_GUN.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .define('X', Ingredient.of(ItemTags.LOGS_THAT_BURN))
                .pattern("#")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_ingots_gold", has(Tags.Items.INGOTS_GOLD)).save(consumer);
        //菜刀
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.KITCHEN_KNIFE.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Items.STICK))
                .pattern("#")
                .pattern("X")
                .unlockedBy("has_ingots_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        //棉甲
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.COTTON_ARMOR_FEATHER_HELMET.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.DEERSKIN.get()))
                .define('X', Ingredient.of(ChangShengJueItems.PEACOCK_FEATHERS.get()))
                .define('$', Ingredient.of(ChangShengJueItems.COTTON.get()))
                .pattern("#X#")
                .pattern("$ $")
                .unlockedBy("has_cotton", has(ChangShengJueItems.COTTON.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.COTTON_ARMOR_WHITE_FEATHER_HELMET.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.DEERSKIN.get()))
                .define('X', Ingredient.of(ChangShengJueItems.WHITE_PEACOCK_FEATHERS.get()))
                .define('$', Ingredient.of(ChangShengJueItems.COTTON.get()))
                .pattern("#X#")
                .pattern("$ $")
                .unlockedBy("has_cotton", has(ChangShengJueItems.COTTON.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.COTTON_ARMOR_CHESTPLATE.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.DEERSKIN.get()))
                .define('$', Ingredient.of(ChangShengJueItems.COTTON.get()))
                .pattern("# #")
                .pattern("$#$")
                .pattern("$$$")
                .unlockedBy("has_cotton", has(ChangShengJueItems.COTTON.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.COTTON_ARMOR_LEGGINGS.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.DEERSKIN.get()))
                .define('$', Ingredient.of(ChangShengJueItems.COTTON.get()))
                .pattern("###")
                .pattern("$ $")
                .pattern("$ $")
                .unlockedBy("has_cotton", has(ChangShengJueItems.COTTON.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.COTTON_ARMOR_BOOTS.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.DEERSKIN.get()))
                .define('$', Ingredient.of(ChangShengJueItems.COTTON.get()))
                .pattern("# #")
                .pattern("$ $")
                .unlockedBy("has_cotton", has(ChangShengJueItems.COTTON.get())).save(consumer);

        //道袍
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.MALE_TAOIST_ROBES_HELMET.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .pattern("###")
                .pattern("# #")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.MALE_TAOIST_ROBES_CHESTPLATE.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.FEMALE_TAOIST_ROBES_HELMET.get(),1)
                .define('#', Ingredient.of(Tags.Items.INGOTS_IRON))
                .define('X', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("#X#")
                .pattern("X X")
                .unlockedBy("has_iron", has(Tags.Items.INGOTS_IRON)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.FEMALE_TAOIST_ROBES_CHESTPLATE.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.TAOIST_ROBES_BOOTS.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);
        //丝绸裤裤
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.SILK_LEGGINGS.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);
        //婚服
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_HELMET.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .define('$', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("#$#")
                .pattern("# #")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.MALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .define('$', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("# #")
                .pattern("#$#")
                .pattern("###")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_HELMET.get(),1)
                .define('#', Ingredient.of(Tags.Items.GEMS_LAPIS))
                .define('X', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("XXX")
                .pattern("# #")
                .unlockedBy("has_gold", has(Tags.Items.INGOTS_GOLD)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.FEMALE_CHINESE_WEDDING_DRESS_CHESTPLATE.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .define('X', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("# #")
                .pattern("#X#")
                .pattern("#X#")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ChangShengJueItems.CHINESE_WEDDING_DRESS_BOOTS.get(),1)
                .define('#', Ingredient.of(ChangShengJueItems.SILK.get()))
                .define('X', Ingredient.of(Tags.Items.INGOTS_GOLD))
                .pattern("# #")
                .pattern("X X")
                .unlockedBy("has_silk", has(ChangShengJueItems.SILK.get())).save(consumer);

        //练功木桩
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ChangShengJueItems.STAKES.get(),1)
                .define('#', Ingredient.of(Items.STICK))
                .define('X', Ingredient.of(ItemTags.PLANKS))
                .define('$', Ingredient.of(Tags.Items.COBBLESTONE))
                .pattern("#")
                .pattern("X")
                .pattern("$")
                .unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer);

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
        oreSmelting(consumer,List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_SILVER.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_SILVER.get(), 0.25f, 300, "sapphire");
        oreSmelting(consumer,List.of(ChangShengJueItems.CRUCIBLE_CRUSHED_GOLD.get()), RecipeCategory.MISC, ChangShengJueItems.CRUCIBLE_LIQUID_GOLD.get(), 0.25f, 300, "sapphire");

        // 食物
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.CAPSULE_JIAO_ZI.get()).requires(ChangShengJueItems.CAPSULE.get()).requires(Tags.Items.CROPS_WHEAT).requires(Items.PORKCHOP).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.ZHENG_CAI.get()).requires(ChangShengJueBlocks.KOCHIA_SCOPARIA_BLOCK.get()).requires(Tags.Items.CROPS_WHEAT).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.PORTULACA_OLERACEA_CAKE.get()).requires(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get()).requires(Tags.Items.CROPS_WHEAT)
                .unlockedBy("has_portulaca_oleracea_block",has(ChangShengJueBlocks.PORTULACA_OLERACEA_BLOCK.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.QING_TUAN.get())
                .requires(ChangShengJueItems.STICKYRICE_1.get()).requires(ChangShengJueBlocks.MUGWORT_BLOCK.get())
                .requires(ChangShengJueItems.REDBEAN.get()).requires(ChangShengJueItems.CI_WAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.TOMATO_EGG.get()).requires(ChangShengJueItems.TOMATO.get()).requires(Tags.Items.EGGS).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.GU_LAO_ROU.get()).requires(ChangShengJueItems.PINEAPPLE.get()).requires(Items.PORKCHOP).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.MEAT_FOAM_BRINJAL.get()).requires(ChangShengJueItems.BRINJAL.get(),2)
                .requires(Items.PORKCHOP).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.SORGHUM_CAKE.get()).requires(ChangShengJueItems.SORGHUM.get(),3)
                .unlockedBy("has_sorghum",has(ChangShengJueItems.SORGHUM.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.STINKY_TOFU.get()).requires(ChangShengJueItems.SOYBEAN.get(),3).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.ZHU_DU_JI.get())
                .requires(ChangShengJueItems.JALAPENOS.get()).requires(Items.PORKCHOP)
                .requires(Items.CHICKEN).requires(ChangShengJueItems.CI_WAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.XIAO_MI_FAN.get())
                .requires(ChangShengJueItems.GU_SUI.get(),3)
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.MI_FAN.get())
                .requires(ChangShengJueItems.RICE.get(),3)
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.GUI_HUA_TANG_OU.get()).requires(ChangShengJueItems.GUI_HUA.get()).requires(ChangShengJueItems.LOTUS_ROOT.get()).requires(ChangShengJueItems.CI_PAN.get())
                .unlockedBy("has_plates",has(ChangShengJueItems.CI_PAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.BA_BAO_ZHOU.get())
                .requires(ChangShengJueItems.PEANUT.get()).requires(ChangShengJueItems.LOTUS_SEEDS.get()).requires(ChangShengJueItems.REDBEAN.get())
                .requires(ChangShengJueItems.RICE.get()).requires(ChangShengJueItems.GU_SUI.get()).requires(ChangShengJueItems.GRAPE.get())
                .requires(ChangShengJueItems.SOYBEAN.get()).requires(ChangShengJueItems.CORN.get()).requires(ChangShengJueItems.CI_WAN.get())
                .unlockedBy("has_bowls",has(ChangShengJueItems.CI_WAN.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.MULBERRY_JUICE.get())
                .requires(ChangShengJueItems.MULBERRY.get(),3).requires(ChangShengJueItems.CI_BEI.get())
                .unlockedBy("has_cups",has(ChangShengJueItems.CI_BEI.get()))
                .save(consumer);

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


    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    public static void foodCooking(Ingredient ingredient, ItemLike itemLike, float f, Consumer<FinishedRecipe> p_176532_, String name){
        String string = new ResourceLocation(ChangShengJue.MOD_ID, name).toString();
        SimpleCookingRecipeBuilder.smelting(ingredient,FOOD,itemLike,f,SMELTING_TICK)
                .unlockedBy(name, hasItems(ChangShengJueItems.CORN.get()))
                .save(p_176532_);
        SimpleCookingRecipeBuilder.generic(Ingredient.of(ChangShengJueItems.CORN.get()),FOOD,ChangShengJueItems.BAKED_CORN.get(),f,SMOKING_TICK,RecipeSerializer.SMOKING_RECIPE)
                .unlockedBy(name, hasItems(ChangShengJueItems.CORN.get()))
                .save(p_176532_,string + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ChangShengJueItems.CORN.get()),FOOD,ChangShengJueItems.BAKED_CORN.get(),f,CAMPFIRE_COOKING_TICK)
                .unlockedBy(name, hasItems(ChangShengJueItems.CORN.get()))
                .save(p_176532_,string + "_from_campfire_cooking");
    }

}
