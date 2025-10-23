package com.shengchanshe.chang_sheng_jue.datagen;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;

import java.util.List;
import java.util.function.Consumer;

public class CustomRecipeBuilder {
    private final String recipeType;
    private final ResourceLocation id;
    private final String group;
    private final List<Ingredient> ingredients;
    private final ItemStack result;
    private final ICondition[] conditions;

    private CustomRecipeBuilder(String recipeType, ResourceLocation id, String group,
                                List<Ingredient> ingredients, ItemStack result,
                                ICondition... conditions) {
        this.recipeType = recipeType;
        this.id = id;
        this.group = group;
        this.ingredients = ingredients;
        this.result = result;
        this.conditions = conditions;
    }

    public static CustomRecipeBuilder customRecipe(String recipeType, ResourceLocation id,
                                                   String group, List<Ingredient> ingredients,
                                                   ItemStack result) {
        return new CustomRecipeBuilder(recipeType, id, group, ingredients, result);
    }

    public void save(Consumer<FinishedRecipe> consumer) {
        consumer.accept(new Result(recipeType, id, group, ingredients, result, conditions));
    }

    private static class Result implements FinishedRecipe {
        private final String recipeType;
        private final ResourceLocation id;
        private final String group;
        private final List<Ingredient> ingredients;
        private final ItemStack result;
        private final ICondition[] conditions;

        public Result(String recipeType, ResourceLocation id, String group,
                      List<Ingredient> ingredients, ItemStack result,
                      ICondition... conditions) {
            this.recipeType = recipeType;
            this.id = id;
            this.group = group;
            this.ingredients = ingredients;
            this.result = result;
            this.conditions = conditions;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            // 设置自定义配方类型
            json.addProperty("type", recipeType);

            // 添加组（可选）
            if (group != null && !group.isEmpty()) {
                json.addProperty("group", group);
            }

            // 构建材料数组
            JsonArray ingredientsJson = new JsonArray();
            for (Ingredient ingredient : ingredients) {
                ingredientsJson.add(ingredient.toJson());
            }
            json.add("ingredients", ingredientsJson);

            // 构建结果
            JsonObject resultJson = new JsonObject();
            resultJson.addProperty("item", result.getItem().toString());
            if (result.getCount() > 1) {
                resultJson.addProperty("count", result.getCount());
            }
            json.add("result", resultJson);

            // 添加条件（如果有）
            if (conditions != null && conditions.length > 0) {
                JsonArray conditionsJson = new JsonArray();
                for (ICondition condition : conditions) {
                    conditionsJson.add(CraftingHelper.serialize(condition));
                }
                json.add("conditions", conditionsJson);
            }
        }

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            // 返回虚拟序列化器，实际由JSON类型标识
            return RecipeSerializer.SHAPED_RECIPE;
        }

        @Override
        public JsonObject serializeAdvancement() {
            return null; // 无关联进度
        }

        @Override
        public ResourceLocation getAdvancementId() {
            return null; // 无关联进度
        }
    }
}