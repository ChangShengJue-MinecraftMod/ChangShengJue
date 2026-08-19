package com.shengchanshe.chang_sheng_jue.quest;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

import java.util.List;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class QuestRequirementTransactionGameTests {
    private QuestRequirementTransactionGameTests() {
    }

    @GameTest(template = "empty")
    public static void duplicateRequirementsConsumeTheirStrictTotal(GameTestHelper helper) {
        SimpleContainer inventory = new SimpleContainer(new ItemStack(Items.IRON_INGOT, 5));
        List<ItemStack> requirements = List.of(
                new ItemStack(Items.IRON_INGOT, 3),
                new ItemStack(Items.IRON_INGOT, 2));

        helper.assertTrue(Quest.consumeRequirements(inventory, requirements),
                "duplicate requirements with sufficient aggregate inventory must complete");
        helper.assertTrue(inventory.getItem(0).isEmpty(),
                "successful transaction must consume the full aggregate requirement");
        helper.succeed();
    }

    @GameTest(template = "empty")
    public static void duplicateRequirementsFailWithoutSideEffects(GameTestHelper helper) {
        SimpleContainer inventory = new SimpleContainer(new ItemStack(Items.IRON_INGOT, 4));
        List<ItemStack> requirements = List.of(
                new ItemStack(Items.IRON_INGOT, 3),
                new ItemStack(Items.IRON_INGOT, 2));

        helper.assertTrue(!Quest.consumeRequirements(inventory, requirements),
                "insufficient aggregate inventory must reject duplicate requirements");
        helper.assertTrue(inventory.getItem(0).is(Items.IRON_INGOT)
                        && inventory.getItem(0).getCount() == 4,
                "failed transaction must not mutate inventory");
        helper.succeed();
    }
}
