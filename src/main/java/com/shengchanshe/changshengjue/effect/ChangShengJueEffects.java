package com.shengchanshe.changshengjue.effect;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ChangShengJueEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, ChangShengJue.MOD_ID);

    public static final Supplier<MobEffect> BLEED_EFFECT = register("bleed_effect", ()->new BleedEffect());

    public static final Supplier<MobEffect> DIZZY_EFFECT = register("dizzy_effect", ()->new DizzyEffect());

    public static final Supplier<MobEffect> AIRBORNE_EFFECT = register("airborne_effect", ()->new AirBorneEffect());

    public static RegistryObject<MobEffect> register(String name, Supplier<MobEffect> effect){
        return MOD_EFFECTS.register(name, effect);
    }
    public static void register(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }
}
