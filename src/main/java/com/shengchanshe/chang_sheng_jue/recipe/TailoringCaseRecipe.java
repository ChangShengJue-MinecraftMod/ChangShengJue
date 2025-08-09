package com.shengchanshe.chang_sheng_jue.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class TailoringCaseRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;
    private final String group;

    public TailoringCaseRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> ingredients, String group) {
        this.id = id;
        this.result = result;
        this.ingredients = ingredients;
        this.group = group;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        // 检查容器大小是否满足配方需求
        if (container.getContainerSize() < ingredients.size()) {
            return false;
        }
        
        // 验证每个槽位的材料是否符合配方要求
        for (int i = 0; i < ingredients.size(); i++) {
            if (!ingredients.get(i).test(container.getItem(i))) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public @NotNull ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return result;
    }

    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return CSJRecipeTypes.TAILORING_CASE_SERIALIZERS.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return CSJRecipeTypes.TAILORING_CASE_TYPE.get();
    }
    
    public static class Serializer implements RecipeSerializer<TailoringCaseRecipe> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public @NotNull TailoringCaseRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
            // 从JSON解析配方结果和材料
            ItemStack result = net.minecraft.world.item.crafting.ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            String group = GsonHelper.getAsString(json, "group", "");
            NonNullList<Ingredient> inputs = NonNullList.create();

            // 解析配方所需材料
            for (int i = 0; i < ingredients.size(); i++) {
                inputs.add(ingredientFromJson(ingredients.get(i)));
            }
            
            return new TailoringCaseRecipe(recipeId, result, inputs, group);
        }

        @Override
        public TailoringCaseRecipe fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
            int size = buffer.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(size, Ingredient.EMPTY);
            String group = buffer.readUtf();

            for (int i = 0; i < size; i++) {
                Ingredient ingredient = Ingredient.fromNetwork(buffer);
                int count = buffer.readVarInt();
                
                // 创建具有指定数量的新ItemStack
                ItemStack[] stacks = ingredient.getItems();
                if (stacks.length > 0) {
                    stacks[0] = stacks[0].copy();
                    stacks[0].setCount(count);
                    ingredient = Ingredient.of(stacks);
                }
                
                inputs.set(i, ingredient);
            }

            ItemStack result = buffer.readItem();
            return new TailoringCaseRecipe(recipeId, result, inputs, group);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, TailoringCaseRecipe recipe) {
            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                // 写入原料和其数量
                ing.toNetwork(buffer);
                buffer.writeVarInt(ing.getItems()[0].getCount());
            }
            buffer.writeItem(recipe.result);
            buffer.writeUtf(recipe.getGroup());
        }

        /**
         * 从JsonElement创建Ingredient，支持count字段
         * @param json JSON元素
         * @return Ingredient对象
         */
        private Ingredient ingredientFromJson(JsonElement json) {
            JsonObject jsonObject = GsonHelper.convertToJsonObject(json, "ingredient");
            if (jsonObject.has("count")) {
                // 如果有count字段，创建自定义Ingredient
                int count = GsonHelper.getAsInt(jsonObject, "count");
                
                // 直接使用Ingredient.fromJson处理，包括tag类型
                Ingredient ingredient = Ingredient.fromJson(json);
                ItemStack[] stacks = ingredient.getItems();
                for (ItemStack stack : stacks) {
                    stack.setCount(count);
                }
                return Ingredient.of(stacks);
            } else {
                // 没有count字段，使用默认解析
                return Ingredient.fromJson(json);
            }
        }
    }
}