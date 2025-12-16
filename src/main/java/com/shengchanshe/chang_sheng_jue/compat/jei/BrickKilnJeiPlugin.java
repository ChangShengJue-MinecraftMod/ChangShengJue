package com.shengchanshe.chang_sheng_jue.compat.jei;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.recipe.BrickKilnRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@JeiPlugin
public class BrickKilnJeiPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(ChangShengJue.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (Minecraft.getInstance().level == null) {
            return;
        }

        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        var recipes = recipeManager.getAllRecipesFor(BrickKilnRecipe.Type.INSTANCE);

        if (recipes.isEmpty()) {
            return;
        }

        int registeredCount = 0;
        for (var recipe : recipes) {
            try {
                ItemStack output = recipe.getResultItem(Objects.requireNonNull(Minecraft.getInstance().level.registryAccess()));

                if (output.isEmpty()) {
                    ChangShengJue.LOGGER.warn("Recipe {} has empty output, skipping", recipe.getId());
                    continue;
                }

                registration.addIngredientInfo(output, VanillaTypes.ITEM_STACK, Component.translatable("jei."+ ChangShengJue.MOD_ID +".brick_kiln.usage"));

                registeredCount++;
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to register JEI info for recipe: {}", recipe.getId(), e);
            }
        }

        ChangShengJue.LOGGER.info("Registered JEI usage info for {} brick kiln recipes", registeredCount);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        ResourceLocation benchId = new ResourceLocation(ChangShengJue.MOD_ID, "brick_kiln");

        var benchBlock = ForgeRegistries.BLOCKS.getValue(benchId);
        if (benchBlock == null) {
            return;
        }

        ItemStack stack = new ItemStack(benchBlock);
        if (stack.isEmpty()) {
            return;
        }

        var brickKiln = mezz.jei.api.recipe.RecipeType.create(ChangShengJue.MOD_ID, "brick_kiln", BrickKilnRecipe.class);

        registration.addRecipeCatalyst(stack, brickKiln);
    }
}