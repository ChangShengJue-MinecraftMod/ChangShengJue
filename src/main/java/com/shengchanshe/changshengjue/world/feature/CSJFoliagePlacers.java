package com.shengchanshe.changshengjue.world.feature;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.world.feature.tree.custom.PoplarDecorator;
import com.shengchanshe.changshengjue.world.feature.tree.custom.PoplarFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CSJFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, ChangShengJue.MOD_ID);
//    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR =
//            DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, ChangShengJue.MOD_ID);

    public static final RegistryObject<FoliagePlacerType<PoplarFoliagePlacer>> POPLAR_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("poplar_foliage_placer", () -> new FoliagePlacerType<>(PoplarFoliagePlacer.CODEC));

//    public static final RegistryObject<TreeDecoratorType<PoplarDecorator>> POPLAR_DECORATOR =
//            TREE_DECORATOR.register("poplar_decorator", () -> new TreeDecoratorType<>(PoplarDecorator.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
//        TREE_DECORATOR.register(eventBus);
    }
}

