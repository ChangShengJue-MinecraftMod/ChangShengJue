package com.shengchanshe.chang_sheng_jue.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class TailoringCaseRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> ingredients;
    private final String group;
    private final int ingredientCount;

    public TailoringCaseRecipe(ResourceLocation id, ItemStack result, NonNullList<Ingredient> ingredients, String group) {
        this.id = Objects.requireNonNull(id, "Recipe ID cannot be null");
        this.result = Objects.requireNonNull(result, "Result cannot be null");
        this.ingredients = Objects.requireNonNull(ingredients, "Ingredients cannot be null");
        this.group = group != null ? group : "";
        this.ingredientCount = ingredients.size();
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        // 检查容器大小是否满足配方需求
        if (container.getContainerSize() < ingredientCount) {
            return false;
        }

        // 验证每个槽位的材料是否符合配方要求
        for (int i = 0; i < ingredientCount; i++) {
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
        return width * height >= ingredientCount;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess registryAccess) {
        return result.copy();
    }

    public NonNullList<Ingredient> getIngredients() {
        // 创建防御性副本
        NonNullList<Ingredient> copy = NonNullList.create();
        copy.addAll(ingredients);
        return copy;
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

    public static TailoringCaseRecipe create(ResourceLocation id, ItemStack result,
                                             NonNullList<Ingredient> ingredients, String group) {
        return new TailoringCaseRecipe(id, result, ingredients, group);
    }

    public static class Type implements RecipeType<TailoringCaseRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "tailoring_case";

        private Type() {}
    }

    public static class Serializer implements RecipeSerializer<TailoringCaseRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(ChangShengJue.MOD_ID, "tailoring_case");

        private static final int MAX_GROUP_LENGTH = 64;
        private static final int MAX_INGREDIENTS = 9;

        private static final String JSON_KEY_RESULT = "result";
        private static final String JSON_KEY_INGREDIENTS = "ingredients";
        private static final String JSON_KEY_GROUP = "group";
        private static final String JSON_KEY_COUNT = "count";
        private static final String JSON_KEY_TAG = "tag";

        private Serializer() {}

        @Override
        public @NotNull TailoringCaseRecipe fromJson(@NotNull ResourceLocation recipeId, @NotNull JsonObject json) {
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

            return new TailoringCaseRecipe(recipeId, result, ingredients, group);
        }

        @Override
        public TailoringCaseRecipe fromNetwork(@NotNull ResourceLocation recipeId, @NotNull FriendlyByteBuf buffer) {
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
            return new TailoringCaseRecipe(recipeId, result, ingredients, group);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, TailoringCaseRecipe recipe) {
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

                int count = 1;
                if (jsonObj.has(JSON_KEY_COUNT)) {
                    count = GsonHelper.getAsInt(jsonObj, JSON_KEY_COUNT);
                    if (count <= 0) {
                        throw new JsonSyntaxException("Ingredient count must be positive: " + count);
                    }
                }

                // 创建一个不包含count的JSON对象给Ingredient.fromJson使用
                JsonObject ingredientJson = new JsonObject();
                String tagId = null;
                if (jsonObj.has(JSON_KEY_TAG)) {
                    tagId = GsonHelper.getAsString(jsonObj, JSON_KEY_TAG);
                    ingredientJson.addProperty(JSON_KEY_TAG, tagId);
                } else if (jsonObj.has("item")) {
                    ingredientJson.add("item", jsonObj.get("item"));
                } else {
                    return Ingredient.EMPTY;
                }

                // 使用Minecraft原生的fromJson方法，它会正确处理tag
                Ingredient baseIngredient = Ingredient.fromJson(ingredientJson);

                if (count > 1 || tagId != null) {
                    return new CountedIngredient(baseIngredient, count, tagId);
                } else {
                    return baseIngredient;
                }

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
                // 读取原始Ingredient（保留tag信息）
                Ingredient baseIngredient = Ingredient.fromNetwork(buffer);
                int count = buffer.readVarInt();
                // 读取Tag ID（如果有）
                String tagId = buffer.readBoolean() ? buffer.readUtf() : null;

                if (baseIngredient.isEmpty()) {
                    return Ingredient.EMPTY;
                }

                if (count > 1 || tagId != null) {
                    return new CountedIngredient(baseIngredient, count, tagId);
                } else if (count == 1) {
                    return baseIngredient;
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
                // 获取数量和Tag ID
                int count = 1;
                String tagId = null;
                Ingredient baseIngredient = ingredient;

                if (ingredient instanceof CountedIngredient counted) {
                    count = counted.requiredCount;
                    tagId = counted.tagId;
                    baseIngredient = counted.original;
                } else {
                    ItemStack[] items = ingredient.getItems();
                    if (items.length > 0 && !items[0].isEmpty()) {
                        count = items[0].getCount();
                    }
                }

                // 写入原始Ingredient（保留tag信息）
                baseIngredient.toNetwork(buffer);
                buffer.writeVarInt(count);
                // 写入Tag ID
                buffer.writeBoolean(tagId != null);
                if (tagId != null) {
                    buffer.writeUtf(tagId);
                }
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to write ingredient to network", e);
                Ingredient.EMPTY.toNetwork(buffer);
                buffer.writeVarInt(0);
                buffer.writeBoolean(false);
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
    }

    // 公开的CountedIngredient类，用于访问tagId
    public static class CountedIngredient extends Ingredient {
        public final Ingredient original;
        public final int requiredCount;
        public final String tagId; // 存储Tag ID用于直接查询注册表

        public CountedIngredient(Ingredient original, int count, @Nullable String tagId) {
            super(Stream.of());
            this.original = Objects.requireNonNull(original);
            this.requiredCount = Math.max(1, count);
            this.tagId = tagId;
        }

        @Override
        public boolean test(@Nullable ItemStack stack) {
            if (stack == null || stack.isEmpty()) return false;
            // 如果有Tag ID，直接使用Tag检查
            if (tagId != null) {
                TagKey<Item> tag = TagKey.create(Registries.ITEM, new ResourceLocation(tagId));
                return stack.is(tag) && stack.getCount() >= requiredCount;
            }
            return original.test(stack) && stack.getCount() >= requiredCount;
        }

        @Override
        public ItemStack[] getItems() {
            // 如果有Tag ID，使用Forge注册表直接获取所有物品
            if (tagId != null) {
                TagKey<Item> tag = TagKey.create(Registries.ITEM, new ResourceLocation(tagId));
                List<ItemStack> items = new ArrayList<>();

                // 使用ForgeRegistries获取Tag中的所有物品
                ForgeRegistries.ITEMS.tags().getTag(tag).forEach(item -> {
                    ItemStack stack = new ItemStack(item);
                    stack.setCount(requiredCount);
                    items.add(stack);
                });

                // 如果Forge注册表返回空，回退到原始Ingredient
                if (items.isEmpty()) {
                    return getItemsFromOriginal();
                }
                return items.toArray(new ItemStack[0]);
            }

            return getItemsFromOriginal();
        }

        private ItemStack[] getItemsFromOriginal() {
            ItemStack[] originalItems = original.getItems();
            ItemStack[] result = new ItemStack[originalItems.length];
            for (int i = 0; i < originalItems.length; i++) {
                result[i] = originalItems[i].copy();
                result[i].setCount(requiredCount);
            }
            return result;
        }

        @Override
        public boolean isEmpty() {
            if (tagId != null) {
                TagKey<Item> tag = TagKey.create(Registries.ITEM, new ResourceLocation(tagId));
                return ForgeRegistries.ITEMS.tags().getTag(tag).isEmpty();
            }
            return original.isEmpty();
        }

        @Override
        public boolean isSimple() {
            return original.isSimple();
        }
    }

    // 自定义异常类
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