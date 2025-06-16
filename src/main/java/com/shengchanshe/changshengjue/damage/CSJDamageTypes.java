package com.shengchanshe.changshengjue.damage;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class CSJDamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID, name));
    }
    public static final ResourceKey<DamageType> BLEED = register("bleed");

    public static final ResourceKey<DamageType> MARTIAL_ARTS = register("martial_arts");

    public static final ResourceKey<DamageType> TRAUMA = register("trauma");

    public static void bootstrap(BootstapContext<DamageType> pContext) {
        pContext.register(BLEED, new DamageType(BLEED.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.0f));
        pContext.register(MARTIAL_ARTS, new DamageType(MARTIAL_ARTS.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.05f));
        pContext.register(TRAUMA, new DamageType(TRAUMA.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0.0f));
    }
}
