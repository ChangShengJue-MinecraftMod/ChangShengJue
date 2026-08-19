package com.shengchanshe.chang_sheng_jue.cilent.setup;

import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.ChangShengJueMenuTypes;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.brick_kiln.BrickKilnScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.forgeblock.ForgeBlockScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.plaque.PlaqueScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.tailoringcase.TailoringCaseScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.workbench.WoodworkingBenchScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.blacksmith.BlacksmithScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangQuestsScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.gangleader.GangleaderTradingScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.innkeeper.InnkeeperScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.PlayerQuestScreen;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.worker.KilnWorkerScreen;
import net.minecraft.client.gui.screens.MenuScreens;

public final class ClientMenuRegistrar {
    private ClientMenuRegistrar() {
    }

    public static void register() {
        MenuScreens.register(ChangShengJueMenuTypes.PLAQUE_MENU.get(), PlaqueScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.INNKEEPER_MENU.get(), InnkeeperScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.BLACKSMITH_MENU.get(), BlacksmithScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.KILNWORKER_MENU.get(), KilnWorkerScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.GANGLEADER_MENU.get(), GangleaderTradingScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.GANG_QUESTS_MENU.get(), GangQuestsScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.PLAYER_QUEST_MENU.get(), PlayerQuestScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.TAILORING_CASE_MENU.get(), TailoringCaseScreen::new);
        //ForgeBlockScreen
        MenuScreens.register(ChangShengJueMenuTypes.FORGE_BLOCK_MENU.get(), ForgeBlockScreen::new);

        MenuScreens.register(ChangShengJueMenuTypes.WOOD_WORKING_BENCH_MENU.get(), WoodworkingBenchScreen::new);
        MenuScreens.register(ChangShengJueMenuTypes.BRICK_KILN_MENU.get(), BrickKilnScreen::new);
    }
}

