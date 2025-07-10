package com.shengchanshe.chang_sheng_jue.cilent.gui.screens;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.PlaqueMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.blacksmith.BlacksmithMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.innkeeper.InnkeeperMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestMenu;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerMenu;
import net.minecraft.world.entity.npc.ClientSideMerchant;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.trading.Merchant;
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

//    public static final RegistryObject<MenuType<GangQuestsMenu>> GANG_QUESTS_MENU = MENUS.register("gang_quests_menu",
//            () -> new MenuType<>(GangQuestsMenu::new,FeatureFlags.VANILLA_SET));
////
    public static final RegistryObject<MenuType<GangQuestsMenu>> GANG_QUESTS_MENU = MENUS.register("gang_quests_menu",
        () -> IForgeMenuType.create(GangQuestsMenu::new));
    public static final RegistryObject<MenuType<PlayerQuestMenu>> PLAYER_QUEST_MENU = MENUS.register("player_quest_menu",
            () -> new MenuType<>((containerId, inv) ->
                    new PlayerQuestMenu(containerId, inv, inv.player), // 直接传入Player
                    FeatureFlagSet.of()
            ));

//            () -> new MenuType<>(GangQuestsMenu::new, FeatureFlags.VANILLA_SET));
//    public static final RegistryObject<MenuType<GangQuestsMenu>> GANG_QUESTS_MENU =
//        MENUS.register("gang_quests_menu", () -> new MenuType<>((windowId, inv, data) -> {
//                    // 从网络数据包读取NPC UUID和任务ID
//                    UUID npcId = data.readUUID();
//                    UUID taskId = data.readUUID();
//                    Quest task = QuestManager.getTask(npcId, taskId); // 根据NPC和任务ID获取任务
//                    return new GangQuestsMenu(windowId, inv, task);
//                })
//        );

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
