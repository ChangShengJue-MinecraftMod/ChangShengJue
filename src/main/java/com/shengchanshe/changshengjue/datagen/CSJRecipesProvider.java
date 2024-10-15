package com.shengchanshe.changshengjue.datagen;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocks;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;
import static net.minecraft.data.recipes.RecipeCategory.FOOD;
import static net.minecraft.data.recipes.RecipeCategory.MISC;

//合成表
public class CSJRecipesProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ChangShengJueBlocks.AG_ORE.get(),
            ChangShengJueBlocks.DEEPSLATE_AG_ORE.get(), ChangShengJueItems.RAW_AG.get());
    private static final int SMELTING_TICK = 200;
    private static final int SMOKING_TICK = 100;
    private static final int CAMPFIRE_COOKING_TICK = 600;

    public CSJRecipesProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        //有序合成
//        ShapedRecipeBuilder.shaped(MISC,ChangShengJueItems.TONG_QIAN.get())
//                .pattern("mxm")
//                .pattern("x#x")
//                .pattern("#x#")
//                .define('x', Tags.Items.GEMS_DIAMOND)
//                .group("chang_sheng_jue_sundry_tab")
//                .unlockedBy(getHasName(ChangShengJueItems.TONG_QIAN.get()),has(Tags.Items.INGOTS_COPPER))
//                .save(consumer);
        //无序合成
        ShapelessRecipeBuilder.shapeless(MISC,ChangShengJueItems.TONG_QIAN.get()).requires(Tags.Items.INGOTS_COPPER)
                .unlockedBy("tong_qian",has(Tags.Items.INGOTS_COPPER))
                .save(consumer);

        //烧炼配方
        //矿石
        oreSmelting(consumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ChangShengJueItems.AG_INGOT.get(), 0.25f, SMELTING_TICK, "sapphire");
        oreBlasting(consumer, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ChangShengJueItems.AG_INGOT.get(), 0.25f, SMOKING_TICK, "sapphire");

        // 食物
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
