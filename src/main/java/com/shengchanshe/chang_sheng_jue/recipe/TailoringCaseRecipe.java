package com.shengchanshe.chang_sheng_jue.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
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
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.stream.Stream;

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
        return Serializer.INSTANCE;
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<TailoringCaseRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "tailoring_case";
    }

    public static class Serializer implements RecipeSerializer<TailoringCaseRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(ChangShengJue.MOD_ID, "tailoring_case");

        @Override
        public @NotNull TailoringCaseRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
            // 验证recipeId格式
            validateResourceLocation(recipeId);

            ItemStack result = safelyParseItemStack(GsonHelper.getAsJsonObject(json, "result"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            String group = GsonHelper.getAsString(json, "group", "");

            NonNullList<Ingredient> inputs = NonNullList.create();
            for (JsonElement element : ingredients) {
                inputs.add(safelyParseIngredient(element));
            }

            return new TailoringCaseRecipe(recipeId, result, inputs, group);
        }

        @Override
        public TailoringCaseRecipe fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
            try {
                String group = buffer.readUtf(64);
                int size = buffer.readVarInt();
                NonNullList<Ingredient> inputs = NonNullList.withSize(size, Ingredient.EMPTY);

                for (int i = 0; i < size; i++) {
                    inputs.set(i, safelyReadIngredient(buffer));
                }

                ItemStack result = safelyReadItemStack(buffer);
                return new TailoringCaseRecipe(recipeId, result, inputs, group);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to deserialize recipe {} from network", recipeId, e);
                throw new TailoringCaseRecipe.RecipeDecodeException("Failed to decode recipe: " + recipeId, e);
            }
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, TailoringCaseRecipe recipe) {
            try {
                buffer.writeUtf(recipe.group, 64);
                buffer.writeVarInt(recipe.ingredients.size());

                for (Ingredient ingredient : recipe.ingredients) {
                    safelyWriteIngredient(buffer, ingredient);
                }

                safelyWriteItemStack(buffer, recipe.result);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to serialize recipe {}", recipe.id, e);
                throw new RecipeEncodeException("Failed to encode recipe: " + recipe.id, e);
            }
        }

        private static void validateResourceLocation(ResourceLocation id) {
            Objects.requireNonNull(id, "Recipe ID cannot be null");
            if (!id.getNamespace().matches("[a-z0-9_.-]+") ||
                    !id.getPath().matches("[a-z0-9_./-]+")) {
                throw new JsonSyntaxException("Invalid recipe ID format: " + id);
            }
        }

        private static ItemStack safelyParseItemStack(JsonObject json) {
            try {
                return net.minecraft.world.item.crafting.ShapedRecipe.itemStackFromJson(json);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to parse item stack from JSON", e);
                return ItemStack.EMPTY;
            }
        }

        private static Ingredient safelyParseIngredient(JsonElement json) {
            try {
                JsonObject jsonObj = GsonHelper.convertToJsonObject(json, "ingredient");
                
                // 新增：处理tag字段时先解析为Ingredient
                if (jsonObj.has("tag")) {
                    Ingredient ingredient = Ingredient.fromJson(json);
                    
                    // 如果同时有count字段，创建带有数量限制的新Ingredient
                    if (jsonObj.has("count")) {
                        int count = GsonHelper.getAsInt(jsonObj, "count");
                        return new CountedIngredient(ingredient, count);
                    }
                    return ingredient;
                }
                
                // 原始处理逻辑
                Ingredient ingredient = Ingredient.fromJson(json);
                
                // 仅当有count字段时修改数量
                if (jsonObj.has("count")) {
                    int count = GsonHelper.getAsInt(jsonObj, "count");
                    ItemStack[] stacks = ingredient.getItems();
                    for (ItemStack stack : stacks) {
                        stack.setCount(count);
                    }
                    return Ingredient.of(stacks);
                }
                
                return ingredient;
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to parse ingredient from JSON", e);
                return Ingredient.EMPTY;
            }
        }

        private static Ingredient safelyReadIngredient(FriendlyByteBuf buffer) {
            try {
                ItemStack stack = buffer.readItem();
                int count = buffer.readVarInt();
                if (!stack.isEmpty()) {
                    stack.setCount(count);
                }
                return Ingredient.of(stack);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to read ingredient from network", e);
                return Ingredient.EMPTY;
            }
        }

        private static ItemStack safelyReadItemStack(FriendlyByteBuf buffer) {
            try {
                return buffer.readItem();
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to read item stack from network", e);
                return ItemStack.EMPTY;
            }
        }

        private static void safelyWriteIngredient(FriendlyByteBuf buffer, Ingredient ingredient) {
            try {
                ItemStack[] items = ingredient.getItems();
                if (items.length > 0) {
                    buffer.writeItem(items[0]);
                    buffer.writeVarInt(items[0].getCount());
                } else {
                    buffer.writeItem(ItemStack.EMPTY);
                    buffer.writeVarInt(0);
                }
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to write ingredient to network", e);
                buffer.writeItem(ItemStack.EMPTY);
                buffer.writeVarInt(0);
            }
        }

        private static void safelyWriteItemStack(FriendlyByteBuf buffer, ItemStack stack) {
            try {
                buffer.writeItem(stack);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to write item stack to network", e);
                buffer.writeItem(ItemStack.EMPTY);
            }
        }
    }

    // 新增内部类用于支持带数量限制的Ingredient
    private static class CountedIngredient extends Ingredient {
        private final Ingredient original;
        private final int requiredCount;
        
        public CountedIngredient(Ingredient original, int count) {
            super(Stream.of());
            this.original = original;
            this.requiredCount = count;
        }
        
        @Override
        public boolean test(@Nullable ItemStack stack) {
            if (stack == null || stack.isEmpty()) return false;
            return original.test(stack) && stack.getCount() >= requiredCount;
        }
        
        @Override
        public ItemStack[] getItems() {
            ItemStack[] items = original.getItems();
            if (items.length > 0 && items[0].getCount() != requiredCount) {
                ItemStack[] countedItems = new ItemStack[items.length];
                for (int i = 0; i < items.length; i++) {
                    countedItems[i] = items[i].copy();
                    countedItems[i].setCount(requiredCount);
                }
                return countedItems;
            }
            return items;
        }
    }

    // 自定义异常类
    public static class RecipeDecodeException extends RuntimeException {
        public RecipeDecodeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class RecipeEncodeException extends RuntimeException {
        public RecipeEncodeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}