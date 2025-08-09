// ForgeBlockRecipe.java
package com.shengchanshe.chang_sheng_jue.recipe;

import com.google.gson.JsonArray;
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

public class ForgeBlockRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;

    public ForgeBlockRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> ingredients) {
        this.id = id;
        this.result = result;
        this.ingredients = ingredients;
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

    @Override
    public @NotNull ResourceLocation getId() {
        return id;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return CSJRecipeTypes.FORGE_BLOCK_TYPE.get();
    }
    
    public static class Type implements RecipeType<ForgeBlockRecipe> {
        Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "forge_block";
    }

    public static class Serializer implements RecipeSerializer<ForgeBlockRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "forge_block";

        @Override
        public @NotNull ForgeBlockRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
            // 从JSON解析配方结果和材料
            ItemStack result = net.minecraft.world.item.crafting.ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.create();

            // 解析配方所需材料
            for (int i = 0; i < ingredients.size(); i++) {
                inputs.add(Ingredient.fromJson(ingredients.get(i)));
            }
            
            return new ForgeBlockRecipe(recipeId, result, inputs);
        }

        @Override
        public ForgeBlockRecipe fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
            int size = buffer.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.withSize(size, Ingredient.EMPTY);

            for (int i = 0; i < size; i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            ItemStack result = buffer.readItem();
            return new ForgeBlockRecipe(recipeId, result, inputs);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, ForgeBlockRecipe recipe) {
            buffer.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }
            buffer.writeItem(recipe.result);
        }
    }
}