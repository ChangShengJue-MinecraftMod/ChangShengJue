package com.shengchanshe.chang_sheng_jue.recipe;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CSJRecipeTypes {

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, ChangShengJue.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ChangShengJue.MOD_ID);

    public static final RegistryObject<RecipeType<ForgeBlockRecipe>> FORGE_BLOCK_TYPE =
            TYPES.register(ForgeBlockRecipe.Type.ID, () -> ForgeBlockRecipe.Type.INSTANCE);

    public static final RegistryObject<RecipeType<TailoringCaseRecipe>> TAILORING_CASE_TYPE =
            TYPES.register(TailoringCaseRecipe.Type.ID, () -> TailoringCaseRecipe.Type.INSTANCE);

    public static final RegistryObject<RecipeType<WoodworkingBenchRecipe>> WOOD_WORKING_BENCH_TYPE =
            TYPES.register(WoodworkingBenchRecipe.Type.ID, () -> WoodworkingBenchRecipe.Type.INSTANCE);

    public static final RegistryObject<RecipeType<BrickKilnRecipe>> BRICK_KILN_TYPE =
            TYPES.register(BrickKilnRecipe.Type.ID, () -> BrickKilnRecipe.Type.INSTANCE);

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
        TYPES.register(eventBus);
        SERIALIZERS.register(eventBus);
    }
}
