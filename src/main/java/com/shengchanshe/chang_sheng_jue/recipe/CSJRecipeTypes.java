package com.shengchanshe.chang_sheng_jue.recipe;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CSJRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, ChangShengJue.MOD_ID);

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ChangShengJue.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ForgeBlockRecipe>> FORGE_BLOCK_SERIALIZERS =
            SERIALIZERS.register("forge_block", () -> ForgeBlockRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeType<ForgeBlockRecipe>> FORGE_BLOCK_TYPE =
            RECIPE_TYPES.register("forge_block", () -> new RecipeType<ForgeBlockRecipe>() {
                @Override
                public String toString() {
                    return "chang_sheng_jue:forge_block";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
        System.out.println("已注册配方类型和序列化器");
    }
}