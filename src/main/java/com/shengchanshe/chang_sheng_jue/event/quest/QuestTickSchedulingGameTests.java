package com.shengchanshe.chang_sheng_jue.event.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QuestTickSchedulingGameTests {
    private QuestTickSchedulingGameTests() {
    }

    @GameTest(template = "empty")
    public static void questStateRefreshUsesOneSecondCadence(GameTestHelper helper) {
        helper.assertTrue(QuestEvent.shouldRefreshQuestState(0), "tick zero must refresh quest state");
        helper.assertTrue(!QuestEvent.shouldRefreshQuestState(1), "tick one must not refresh quest state");
        helper.assertTrue(!QuestEvent.shouldRefreshQuestState(19), "tick nineteen must not refresh quest state");
        helper.assertTrue(QuestEvent.shouldRefreshQuestState(20), "tick twenty must refresh quest state");
        helper.assertTrue(QuestEvent.shouldRefreshQuestState(40), "refresh cadence must remain stable");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void siegeInitializationUsesPublishedNightWindow(GameTestHelper helper) {
        helper.assertTrue(!QuestEvent.isSiegeInitializationWindow(0.4999F),
                "time before the published window must not initialize a siege");
        helper.assertTrue(QuestEvent.isSiegeInitializationWindow(0.5F),
                "the lower bound must initialize a siege");
        helper.assertTrue(QuestEvent.isSiegeInitializationWindow(0.5029F),
                "time inside the published window must initialize a siege");
        helper.assertTrue(!QuestEvent.isSiegeInitializationWindow(0.503F),
                "the exclusive upper bound must not initialize a siege");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void siegeInitializesOnlyOncePerNight(GameTestHelper helper) {
        long currentDay = 12L;
        helper.assertTrue(QuestEvent.shouldInitializeSiege(0.5F, currentDay, null),
                "first entry into the night window must initialize the persistent siege");
        helper.assertTrue(!QuestEvent.shouldInitializeSiege(0.501F, currentDay, currentDay),
                "later refreshes in the same window must not reset an initialized siege");
        helper.assertTrue(!QuestEvent.shouldInitializeSiege(0.6F, currentDay + 1L, currentDay),
                "a new day outside the night window must not initialize early");
        helper.assertTrue(QuestEvent.shouldInitializeSiege(0.502F, currentDay + 1L, currentDay),
                "the next night window must initialize the persistent siege once again");
        helper.succeed();
    }
}
