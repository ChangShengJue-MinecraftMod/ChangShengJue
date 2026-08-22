package com.shengchanshe.chang_sheng_jue.gametest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.recipe.BrickKilnRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.ForgeBlockRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.TailoringCaseRecipe;
import com.shengchanshe.chang_sheng_jue.recipe.WoodworkingBenchRecipe;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;
import net.minecraftforge.registries.ForgeRegistries;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class RecipeTypeRegistrationGameTests {
    private RecipeTypeRegistrationGameTests() {
    }

    @GameTest(template = "empty")
    public static void customRecipeTypesUsePublishedSingletons(GameTestHelper helper) {
        assertRegistered(helper, ForgeBlockRecipe.Type.ID, ForgeBlockRecipe.Type.INSTANCE);
        assertRegistered(helper, TailoringCaseRecipe.Type.ID, TailoringCaseRecipe.Type.INSTANCE);
        assertRegistered(helper, WoodworkingBenchRecipe.Type.ID, WoodworkingBenchRecipe.Type.INSTANCE);
        assertRegistered(helper, BrickKilnRecipe.Type.ID, BrickKilnRecipe.Type.INSTANCE);
        helper.succeed();
    }

    private static void assertRegistered(GameTestHelper helper, String path, RecipeType<?> expectedType) {
        ResourceLocation id = new ResourceLocation(ChangShengJue.MOD_ID, path);
        helper.assertTrue(ForgeRegistries.RECIPE_TYPES.getValue(id) == expectedType,
                "recipe type was missing or did not preserve singleton identity: " + id);
        helper.assertTrue(ForgeRegistries.RECIPE_SERIALIZERS.containsKey(id),
                "recipe serializer was missing after recipe type registration: " + id);
    }
}
