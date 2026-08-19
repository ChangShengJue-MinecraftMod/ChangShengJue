package com.shengchanshe.chang_sheng_jue.item.foods;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class PorcelainCupsFoodItemLifecycleGameTests {
    private PorcelainCupsFoodItemLifecycleGameTests() {
    }

    @GameTest(template = "empty")
    public static void cupReductionMarkerPersistsUntilDrunkennessEnds(GameTestHelper helper) {
        String teaMarker = ChangShengJue.MOD_ID + ":cibei_tea_reduced_drunkenness";
        String porcelainMarker = ChangShengJue.MOD_ID + ":porcelain_cup_reduced_drunkenness";
        CompoundTag persistentData = new CompoundTag();
        PorcelainCupsFoodItem.clearReducedDrunkenness(persistentData);

        PorcelainCupsFoodItem.markReducedDrunkenness(persistentData);
        persistentData.putBoolean(teaMarker, true);
        CompoundTag reloadedData = persistentData.copy();
        helper.assertTrue(PorcelainCupsFoodItem.hasReducedDrunkenness(reloadedData),
                "porcelain-cup marker must survive player NBT round trip");
        helper.assertTrue(reloadedData.getBoolean(porcelainMarker),
                "porcelain-cup marker must use its stable namespaced key");

        PorcelainCupsFoodItem.updateReducedDrunkenness(reloadedData, true);
        helper.assertTrue(PorcelainCupsFoodItem.hasReducedDrunkenness(reloadedData),
                "active drunkenness must retain the porcelain-cup marker");

        PorcelainCupsFoodItem.updateReducedDrunkenness(reloadedData, false);
        helper.assertTrue(!PorcelainCupsFoodItem.hasReducedDrunkenness(reloadedData),
                "effect end must release the porcelain-cup marker");
        helper.assertTrue(reloadedData.getBoolean(teaMarker),
                "porcelain-cup cleanup must not remove the tea marker");

        PorcelainCupsFoodItem.clearReducedDrunkenness(persistentData);
        persistentData.remove(teaMarker);
        reloadedData.remove(teaMarker);
        helper.succeed();
    }
}
