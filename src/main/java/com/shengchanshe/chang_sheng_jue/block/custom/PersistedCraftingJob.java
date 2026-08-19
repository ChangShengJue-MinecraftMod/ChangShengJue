package com.shengchanshe.chang_sheng_jue.block.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

/** Frozen recipe/output/count state for a paid crafting operation. */
public final class PersistedCraftingJob {
    private static final String RECIPE = "recipe";
    private static final String OUTPUT = "output";
    private static final String TOTAL = "total";
    private static final String REMAINING = "remaining";
    private static final String PROGRESS = "progress";

    private final ResourceLocation recipeId;
    private final ItemStack output;
    private final int total;
    private int remaining;

    public PersistedCraftingJob(ResourceLocation recipeId, ItemStack output, int total, int remaining) {
        if (recipeId == null || output.isEmpty() || output.getCount() > output.getMaxStackSize()
                || total < 1 || total > 64 || remaining < 1 || remaining > total) {
            throw new IllegalArgumentException("Invalid persisted crafting job");
        }
        this.recipeId = recipeId;
        this.output = output.copy();
        this.total = total;
        this.remaining = remaining;
    }

    public ResourceLocation recipeId() {
        return recipeId;
    }

    public ItemStack output() {
        return output.copy();
    }

    public int total() {
        return total;
    }

    public int remaining() {
        return remaining;
    }

    public boolean finishOne() {
        remaining--;
        return remaining <= 0;
    }

    public CompoundTag save(int progress) {
        CompoundTag tag = new CompoundTag();
        tag.putString(RECIPE, recipeId.toString());
        tag.put(OUTPUT, output.save(new CompoundTag()));
        tag.putInt(TOTAL, total);
        tag.putInt(REMAINING, remaining);
        tag.putInt(PROGRESS, Math.max(0, progress));
        return tag;
    }

    @Nullable
    public static Loaded load(CompoundTag tag, int maxProgress) {
        ResourceLocation recipeId = ResourceLocation.tryParse(tag.getString(RECIPE));
        ItemStack output = ItemStack.of(tag.getCompound(OUTPUT));
        int total = tag.getInt(TOTAL);
        int remaining = tag.getInt(REMAINING);
        int progress = tag.getInt(PROGRESS);
        if (recipeId == null || output.isEmpty() || output.getCount() > output.getMaxStackSize()
                || total < 1 || total > 64 || remaining < 1 || remaining > total
                || maxProgress < 1 || progress < 1 || progress > maxProgress) {
            return null;
        }
        return new Loaded(new PersistedCraftingJob(recipeId, output, total, remaining), progress);
    }

    public record Loaded(PersistedCraftingJob job, int progress) {
    }
}
