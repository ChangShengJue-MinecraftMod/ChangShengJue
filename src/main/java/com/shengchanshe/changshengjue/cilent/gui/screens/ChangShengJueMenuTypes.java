package com.shengchanshe.changshengjue.cilent.gui.screens;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.gui.screens.plaque.PlaqueMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.blacksmith.BlacksmithMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.innkeeper.InnkeeperMenu;
import com.shengchanshe.changshengjue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ChangShengJue.MOD_ID);

    public static final RegistryObject<MenuType<PlaqueMenu>> PLAQUE_MENU =
            registerMenuType("plaque_menu", PlaqueMenu::new);

    public static final RegistryObject<MenuType<InnkeeperMenu>> INNKEEPER_MENU = MENUS.register(
            "innkeeper_menu", () -> new MenuType<>(InnkeeperMenu::new, FeatureFlags.VANILLA_SET));

    public static final RegistryObject<MenuType<BlacksmithMenu>> BLACKSMITH_MENU = MENUS.register(
            "blacksmith_menu", () -> new MenuType<>(BlacksmithMenu::new, FeatureFlags.VANILLA_SET));

    public static final RegistryObject<MenuType<KilnWorkerMenu>> KILNWORKER_MENU = MENUS.register(
            "kilnworker_menu", () -> new MenuType<>(KilnWorkerMenu::new, FeatureFlags.VANILLA_SET));

    public static final RegistryObject<MenuType<GangleaderTradingMenu>> GANGLEADER_MENU = MENUS.register(
            "gangleader_menu", () -> new MenuType<>(GangleaderTradingMenu::new, FeatureFlags.VANILLA_SET));

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
