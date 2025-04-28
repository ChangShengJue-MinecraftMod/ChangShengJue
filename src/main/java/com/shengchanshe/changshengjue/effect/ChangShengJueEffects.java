package com.shengchanshe.changshengjue.effect;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.effect.food_effect.teas.*;
import com.shengchanshe.changshengjue.effect.food_effect.wine.Drunken;
import com.shengchanshe.changshengjue.effect.food_effect.wine.FenJiu;
import com.shengchanshe.changshengjue.effect.food_effect.wine.ShiLiXiang;
import com.shengchanshe.changshengjue.effect.food_effect.wine.WheatNuggetsTributeWine;
import com.shengchanshe.changshengjue.effect.martial_arts.*;
import com.shengchanshe.changshengjue.effect.village.InstantCharmEffect;
import com.shengchanshe.changshengjue.effect.village.InstantDisfavorEffect;
import com.shengchanshe.changshengjue.effect.village.VillagerCharmEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ChangShengJueEffects {
    public static final DeferredRegister<MobEffect> MOD_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, ChangShengJue.MOD_ID);

    public static final Supplier<MobEffect> BLEED_EFFECT = register("bleed_effect", BleedEffect::new);

    public static final Supplier<MobEffect> DIZZY_EFFECT = register("dizzy_effect", DizzyEffect::new);

    public static final Supplier<MobEffect> AIRBORNE_EFFECT = register("airborne_effect", AirBorneEffect::new);

    public static final Supplier<MobEffect> FIXATION_EFFECT = register("fixation_effect", DizzyEffect::new);

    public static final Supplier<MobEffect> GOLDEN_BELL_JAR_EFFECT = register("golden_bell_jar_effect", GoldenBellJarEffect::new);

    public static final Supplier<MobEffect> TURTLE_BREATH_EFFECT = register("turtle_breath_effect", TurtleBreathEffect::new);

    public static final Supplier<MobEffect> BILUOCHUN_TEAS = register("biluochun_teas", BiluochunTeas::new);
    public static final Supplier<MobEffect> LONG_JING_TEAS = register("long_jing_teas", LongJingTeas::new);
    public static final Supplier<MobEffect> FEN_JIU = register("fen_jiu", FenJiu::new);
    public static final Supplier<MobEffect> WHEAT_NUGGETS_TRIBUTE_WINE = register("wheat_nuggets_tribute_wine", WheatNuggetsTributeWine::new);
    public static final Supplier<MobEffect> SHI_LI_XIANG = register("shi_li_xiang", ShiLiXiang::new);
    public static final Supplier<MobEffect> DRUNKEN = register("drunken", Drunken::new);

    public static final Supplier<MobEffect> VILLAGER_CHARM_EFFECT = register("villager_charm_effect", VillagerCharmEffect::new);
    public static final Supplier<MobEffect> INSTANT_CHARM_EFFECT = register("instant_charm_effect", InstantCharmEffect::new);
    public static final Supplier<MobEffect> INSTANT_DISFAVOR_EFFECT = register("instant_disfavor_effect", InstantDisfavorEffect::new);

    public static RegistryObject<MobEffect> register(String name, Supplier<MobEffect> effect){
        return MOD_EFFECTS.register(name, effect);
    }
    public static void register(IEventBus eventBus){
        MOD_EFFECTS.register(eventBus);
    }
}
