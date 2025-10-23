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

public class WoodworkingBenchRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;
    private final String group;
    private final int ingredientCount;

    public WoodworkingBenchRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> ingredients, String group) {
        this.id = Objects.requireNonNull(id, "Recipe ID cannot be null");
        this.result = Objects.requireNonNull(result, "Result cannot be null");
        this.ingredients = Objects.requireNonNull(ingredients, "Ingredients cannot be null");
        this.group = group != null ? group : "";
        this.ingredientCount = ingredients.size();
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        if (container.getContainerSize() < ingredientCount) {
            return false;
        }

        for (int i = 0; i < ingredientCount; i++) {
            Ingredient ingredient = ingredients.get(i);
            ItemStack itemInSlot = container.getItem(i);

            if (!ingredient.test(itemInSlot)) {
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
        return width * height >= ingredientCount;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return result.copy();
    }

    public NonNullList<Ingredient> getIngredients() {
        // 创建防御性副本而不是使用 copyOf
        NonNullList<Ingredient> copy = NonNullList.create();
        copy.addAll(ingredients);
        return copy;
    }

    public String getGroup() {
        return group;
    }

    public int getIngredientCount() {
        return ingredientCount;
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

    public static WoodworkingBenchRecipe create(ResourceLocation id, ItemStack result,
                                                NonNullList<Ingredient> ingredients, String group) {
        return new WoodworkingBenchRecipe(id, result, ingredients, group);
    }

    public static class Type implements RecipeType<WoodworkingBenchRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "wood_working_bench";

        private Type() {}
    }

    public static class Serializer implements RecipeSerializer<WoodworkingBenchRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(ChangShengJue.MOD_ID, "wood_working_bench");

        private static final int MAX_GROUP_LENGTH = 64;
        private static final int MAX_INGREDIENTS = 9;

        private static final String JSON_KEY_RESULT = "result";
        private static final String JSON_KEY_INGREDIENTS = "ingredients";
        private static final String JSON_KEY_GROUP = "group";
        private static final String JSON_KEY_COUNT = "count";
        private static final String JSON_KEY_TAG = "tag";

        private Serializer() {}

        @Override
        public @NotNull WoodworkingBenchRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
            validateResourceLocation(recipeId);

            JsonObject resultJson = GsonHelper.getAsJsonObject(json, JSON_KEY_RESULT);
            JsonArray ingredientsJson = GsonHelper.getAsJsonArray(json, JSON_KEY_INGREDIENTS);
            String group = GsonHelper.getAsString(json, JSON_KEY_GROUP, "");

            if (ingredientsJson.size() > MAX_INGREDIENTS) {
                throw new JsonSyntaxException("Too many ingredients: " + ingredientsJson.size() +
                        ", maximum is " + MAX_INGREDIENTS);
            }

            ItemStack result = parseItemStack(resultJson);
            NonNullList<Ingredient> ingredients = parseIngredients(ingredientsJson);

            return new WoodworkingBenchRecipe(recipeId, result, ingredients, group);
        }

        @Override
        public WoodworkingBenchRecipe fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
            String group = buffer.readUtf(MAX_GROUP_LENGTH);
            int size = buffer.readVarInt();

            if (size < 0 || size > MAX_INGREDIENTS) {
                throw new RecipeDecodeException("Invalid ingredient count from network: " + size);
            }

            NonNullList<Ingredient> ingredients = NonNullList.withSize(size, Ingredient.EMPTY);
            for (int i = 0; i < size; i++) {
                ingredients.set(i, readIngredient(buffer));
            }

            ItemStack result = readItemStack(buffer);
            return new WoodworkingBenchRecipe(recipeId, result, ingredients, group);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, WoodworkingBenchRecipe recipe) {
            buffer.writeUtf(recipe.group, MAX_GROUP_LENGTH);
            buffer.writeVarInt(recipe.ingredientCount);

            for (Ingredient ingredient : recipe.ingredients) {
                writeIngredient(buffer, ingredient);
            }

            writeItemStack(buffer, recipe.result);
        }

        private static NonNullList<Ingredient> parseIngredients(JsonArray ingredientsJson) {
            NonNullList<Ingredient> ingredients = NonNullList.create();

            for (JsonElement element : ingredientsJson) {
                Ingredient ingredient = parseIngredient(element);
                if (ingredient != Ingredient.EMPTY) {
                    ingredients.add(ingredient);
                }
            }

            if (ingredients.isEmpty()) {
                throw new JsonSyntaxException("Recipe must have at least one ingredient");
            }

            return ingredients;
        }

        private static Ingredient parseIngredient(JsonElement json) {
            try {
                JsonObject jsonObj = GsonHelper.convertToJsonObject(json, "ingredient");

                if (jsonObj.has(JSON_KEY_COUNT)) {
                    int count = GsonHelper.getAsInt(jsonObj, JSON_KEY_COUNT);
                    if (count <= 0) {
                        throw new JsonSyntaxException("Ingredient count must be positive: " + count);
                    }

                    if (jsonObj.has(JSON_KEY_TAG)) {
                        Ingredient baseIngredient = Ingredient.fromJson(json);
                        return new CountedIngredient(baseIngredient, count);
                    } else {
                        Ingredient ingredient = Ingredient.fromJson(json);
                        return createCountedIngredient(ingredient, count);
                    }
                }

                return Ingredient.fromJson(json);

            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to parse ingredient from JSON: {}", json, e);
                return Ingredient.EMPTY;
            }
        }

        private static ItemStack parseItemStack(JsonObject json) {
            try {
                ItemStack stack = net.minecraft.world.item.crafting.ShapedRecipe.itemStackFromJson(json);
                if (stack.isEmpty()) {
                    throw new JsonSyntaxException("Recipe result cannot be empty");
                }
                return stack;
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to parse item stack from JSON: {}", json, e);
                throw new JsonSyntaxException("Invalid recipe result", e);
            }
        }

        private static Ingredient readIngredient(FriendlyByteBuf buffer) {
            try {
                ItemStack stack = buffer.readItem();
                int count = buffer.readVarInt();

                if (!stack.isEmpty() && count > 0) {
                    stack.setCount(count);
                    return Ingredient.of(stack);
                }
                return Ingredient.EMPTY;
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to read ingredient from network", e);
                return Ingredient.EMPTY;
            }
        }

        private static ItemStack readItemStack(FriendlyByteBuf buffer) {
            try {
                ItemStack stack = buffer.readItem();
                if (stack.isEmpty()) {
                    throw new RecipeDecodeException("Received empty item stack from network");
                }
                return stack;
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to read item stack from network", e);
                throw new RecipeDecodeException("Failed to read item stack", e);
            }
        }

        private static void writeIngredient(FriendlyByteBuf buffer, Ingredient ingredient) {
            try {
                ItemStack[] items = ingredient.getItems();
                if (items.length > 0 && !items[0].isEmpty()) {
                    ItemStack stack = items[0].copy();
                    buffer.writeItem(stack);
                    buffer.writeVarInt(stack.getCount());
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

        private static void writeItemStack(FriendlyByteBuf buffer, ItemStack stack) {
            try {
                if (stack.isEmpty()) {
                    throw new RecipeEncodeException("Cannot write empty item stack to network");
                }
                buffer.writeItem(stack);
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to write item stack to network", e);
                throw new RecipeEncodeException("Failed to write item stack", e);
            }
        }

        private static void validateResourceLocation(ResourceLocation id) {
            Objects.requireNonNull(id, "Recipe ID cannot be null");
            if (!isValidResourceLocation(id)) {
                throw new JsonSyntaxException("Invalid recipe ID format: " + id);
            }
        }

        private static boolean isValidResourceLocation(ResourceLocation id) {
            return id.getNamespace().matches("[a-z0-9_.-]+") &&
                    id.getPath().matches("[a-z0-9_./-]+");
        }

        private static Ingredient createCountedIngredient(Ingredient ingredient, int count) {
            ItemStack[] stacks = ingredient.getItems();
            if (stacks.length == 0) return ingredient;

            ItemStack[] countedStacks = new ItemStack[stacks.length];
            for (int i = 0; i < stacks.length; i++) {
                countedStacks[i] = stacks[i].copy();
                countedStacks[i].setCount(count);
            }

            return Ingredient.of(countedStacks);
        }
    }

    private static class CountedIngredient extends Ingredient {
        private final Ingredient original;
        private final int requiredCount;
        private ItemStack[] cachedItems;

        public CountedIngredient(Ingredient original, int count) {
            super(Stream.of());
            this.original = Objects.requireNonNull(original);
            this.requiredCount = Math.max(1, count);
        }

        @Override
        public boolean test(@Nullable ItemStack stack) {
            if (stack == null || stack.isEmpty()) return false;
            return original.test(stack) && stack.getCount() >= requiredCount;
        }

        @Override
        public ItemStack[] getItems() {
            if (cachedItems == null) {
                ItemStack[] originalItems = original.getItems();
                cachedItems = new ItemStack[originalItems.length];

                for (int i = 0; i < originalItems.length; i++) {
                    cachedItems[i] = originalItems[i].copy();
                    cachedItems[i].setCount(requiredCount);
                }
            }
            return cachedItems;
        }

        @Override
        public boolean isEmpty() {
            return original.isEmpty();
        }

        @Override
        public boolean isSimple() {
            return original.isSimple();
        }
    }

    public static class RecipeDecodeException extends RuntimeException {
        public RecipeDecodeException(String message) {
            super(message);
        }

        public RecipeDecodeException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class RecipeEncodeException extends RuntimeException {
        public RecipeEncodeException(String message) {
            super(message);
        }

        public RecipeEncodeException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}