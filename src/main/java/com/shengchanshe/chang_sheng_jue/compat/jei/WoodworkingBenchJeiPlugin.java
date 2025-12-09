package com.shengchanshe.chang_sheng_jue.compat.jei;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
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
public class WoodworkingBenchJeiPlugin implements IModPlugin {

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(ChangShengJue.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (Minecraft.getInstance().level == null) {
            ChangShengJue.LOGGER.warn("Minecraft level is null, skipping JEI recipe registration");
            return;
        }

        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        var recipes = recipeManager.getAllRecipesFor(WoodworkingBenchRecipe.Type.INSTANCE);

        if (recipes.isEmpty()) {
            ChangShengJue.LOGGER.info("No woodworking bench recipes found for JEI registration");
            return;
        }

        int registeredCount = 0;
        for (var recipe : recipes) {
            try {
                ItemStack output = recipe.getResultItem(
                        Objects.requireNonNull(Minecraft.getInstance().level.registryAccess())
                );

                if (output.isEmpty()) {
                    ChangShengJue.LOGGER.warn("Recipe {} has empty output, skipping", recipe.getId());
                    continue;
                }

                registration.addIngredientInfo(
                        output,
                        VanillaTypes.ITEM_STACK,
                        Component.translatable("jei."+ ChangShengJue.MOD_ID +".woodworking_bench.usage")
                );

                registeredCount++;
            } catch (Exception e) {
                ChangShengJue.LOGGER.error("Failed to register JEI info for recipe: {}", recipe.getId(), e);
            }
        }

        ChangShengJue.LOGGER.info("Registered JEI usage info for {} woodworking bench recipes", registeredCount);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        ResourceLocation benchId = new ResourceLocation(ChangShengJue.MOD_ID, "woodworking_bench");

        var benchBlock = ForgeRegistries.BLOCKS.getValue(benchId);
        if (benchBlock == null) {
            ChangShengJue.LOGGER.error("Woodworking bench block not found in registry: {}", benchId);
            return;
        }

        ItemStack woodworkingBench = new ItemStack(benchBlock);
        if (woodworkingBench.isEmpty()) {
            ChangShengJue.LOGGER.error("Failed to create ItemStack for woodworking bench");
            return;
        }

        var woodworkingType = mezz.jei.api.recipe.RecipeType.create(
                ChangShengJue.MOD_ID,
                "woodworking_bench",
                WoodworkingBenchRecipe.class
        );

        registration.addRecipeCatalyst(woodworkingBench, woodworkingType);

        ChangShengJue.LOGGER.info("Registered woodworking bench as JEI catalyst");
    }
}