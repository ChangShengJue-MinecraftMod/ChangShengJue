package com.shengchanshe.changshengjue.loot_modifier;

import com.mojang.serialization.Codec;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueLootModifier {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> GLM_REGISTER =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ChangShengJue.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> DRAGON_PARCEL_MODIFIER =
            GLM_REGISTER.register("dragon_parcel", () -> DragonParcelModifier.CODEC);

    public static void register(IEventBus eventBus){
        GLM_REGISTER.register(eventBus);
    }
}
