package com.shengchanshe.chang_sheng_jue.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 木工台配方生成器
 */
public class WoodworkingBenchRecipeBuilder implements RecipeBuilder {
    private final ItemStack result;
    private final List<IngredientEntry> ingredients = new ArrayList<>();
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private String group = "";

    private WoodworkingBenchRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static WoodworkingBenchRecipeBuilder woodworking(ItemLike result) {
        return woodworking(result, 1);
    }

    public static WoodworkingBenchRecipeBuilder woodworking(ItemLike result, int count) {
        return new WoodworkingBenchRecipeBuilder(new ItemStack(result, count));
    }

    /**
     * 添加普通物品材料
     */
    public WoodworkingBenchRecipeBuilder requires(ItemLike item) {
        return requires(item, 1);
    }

    /**
     * 添加带数量的普通物品材料
     */
    public WoodworkingBenchRecipeBuilder requires(ItemLike item, int count) {
        this.ingredients.add(new IngredientEntry(Ingredient.of(item), count, null));
        return this;
    }

    /**
     * 添加标签材料
     */
    public WoodworkingBenchRecipeBuilder requires(TagKey<Item> tag) {
        return requires(tag, 1);
    }

    /**
     * 添加带数量的标签材料
     */
    public WoodworkingBenchRecipeBuilder requires(TagKey<Item> tag, int count) {
        this.ingredients.add(new IngredientEntry(Ingredient.of(tag), count, tag.location().toString()));
        return this;
    }

    /**
     * 添加Ingredient材料
     */
    public WoodworkingBenchRecipeBuilder requires(Ingredient ingredient) {
        return requires(ingredient, 1);
    }

    /**
     * 添加带数量的Ingredient材料
     */
    public WoodworkingBenchRecipeBuilder requires(Ingredient ingredient, int count) {
        this.ingredients.add(new IngredientEntry(ingredient, count, null));
        return this;
    }

    @Override
    public @NotNull RecipeBuilder unlockedBy(@NotNull String name, @NotNull CriterionTriggerInstance criterion) {
        this.advancement.addCriterion(name, criterion);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String group) {
        this.group = group == null ? "" : group;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return result.getItem();
    }

    @Override
    public void save(@NotNull Consumer<FinishedRecipe> consumer, @NotNull ResourceLocation id) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(RequirementsStrategy.OR);

        consumer.accept(new Result(id, this.group, this.result, this.ingredients, this.advancement,
                new ResourceLocation(id.getNamespace(), "recipes/" + id.getPath())));
    }

    private static class IngredientEntry {
        final Ingredient ingredient;
        final int count;
        final String tagId;

        IngredientEntry(Ingredient ingredient, int count, @Nullable String tagId) {
            this.ingredient = ingredient;
            this.count = count;
            this.tagId = tagId;
        }
    }

    private static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final ItemStack result;
        private final List<IngredientEntry> ingredients;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, String group, ItemStack result, List<IngredientEntry> ingredients,
                      Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.group = group;
            this.result = result;
            this.ingredients = ingredients;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }

        @Override
        public void serializeRecipeData(@NotNull JsonObject json) {
            json.addProperty("type", ChangShengJue.MOD_ID + ":wood_working_bench");

            if (!group.isEmpty()) {
                json.addProperty("group", group);
            }

            JsonArray ingredientsArray = new JsonArray();
            for (IngredientEntry entry : ingredients) {
                JsonObject ingredientObj = entry.ingredient.toJson().getAsJsonObject();
                
                if (entry.count > 1) {
                    ingredientObj.addProperty("count", entry.count);
                }
                
                // 如果有tagId，确保保存tag信息
                if (entry.tagId != null) {
                    ingredientObj.addProperty("tag", entry.tagId);
                }
                
                ingredientsArray.add(ingredientObj);
            }
            json.add("ingredients", ingredientsArray);

            JsonObject resultObj = new JsonObject();
            resultObj.addProperty("item", BuiltInRegistries.ITEM.getKey(result.getItem()).toString());
            if (result.getCount() > 1) {
                resultObj.addProperty("count", result.getCount());
            }
            json.add("result", resultObj);
        }

        @Override
        public @NotNull ResourceLocation getId() {
            return id;
        }

        @Override
        public @NotNull RecipeSerializer<?> getType() {
            return RecipeSerializer.SHAPELESS_RECIPE;
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return advancement.serializeToJson();
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return advancementId;
        }
    }
}
