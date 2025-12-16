package com.shengchanshe.chang_sheng_jue.recipe;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CSJRecipeTypes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ChangShengJue.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ForgeBlockRecipe>> FORGE_BLOCK_SERIALIZERS =
            SERIALIZERS.register("forge_block", () -> ForgeBlockRecipe.Serializer.INSTANCE);
    
    public static final RegistryObject<RecipeSerializer<TailoringCaseRecipe>> TAILORING_CASE_SERIALIZERS =
            SERIALIZERS.register("tailoring_case", () -> TailoringCaseRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<WoodworkingBenchRecipe>> WOOD_WORKING_BENCH_SERIALIZERS =
            SERIALIZERS.register("wood_working_bench", () -> WoodworkingBenchRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<BrickKilnRecipe>> BRICK_KILN_SERIALIZERS =
            SERIALIZERS.register("brick_kiln", () -> BrickKilnRecipe.Serializer.INSTANCE);

    // 注册配方类型和序列化器
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}