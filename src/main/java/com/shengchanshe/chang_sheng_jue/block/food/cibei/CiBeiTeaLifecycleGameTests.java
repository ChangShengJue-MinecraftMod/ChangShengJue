package com.shengchanshe.chang_sheng_jue.block.food.cibei;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.gametest.PrefixGameTestTemplate;

@GameTestHolder(ChangShengJue.MOD_ID)
@PrefixGameTestTemplate(false)
public final class CiBeiTeaLifecycleGameTests {
    private CiBeiTeaLifecycleGameTests() {
    }

    @GameTest(template = "empty")
    public static void teaReductionMarkerPersistsUntilDrunkennessEnds(GameTestHelper helper) {
        String teaMarker = ChangShengJue.MOD_ID + ":cibei_tea_reduced_drunkenness";
        String porcelainMarker = ChangShengJue.MOD_ID + ":porcelain_cup_reduced_drunkenness";
        CompoundTag persistentData = new CompoundTag();
        CiBeiTea.clearReducedDrunkenness(persistentData);

        CiBeiTea.markReducedDrunkenness(persistentData);
        persistentData.putBoolean(porcelainMarker, true);
        CompoundTag reloadedData = persistentData.copy();
        helper.assertTrue(CiBeiTea.hasReducedDrunkenness(reloadedData),
                "tea marker must survive player NBT round trip");
        helper.assertTrue(reloadedData.getBoolean(teaMarker),
                "tea marker must use its stable namespaced key");

        CiBeiTea.updateReducedDrunkenness(reloadedData, true);
        helper.assertTrue(CiBeiTea.hasReducedDrunkenness(reloadedData),
                "active drunkenness must retain the tea marker");

        CiBeiTea.updateReducedDrunkenness(reloadedData, false);
        helper.assertTrue(!CiBeiTea.hasReducedDrunkenness(reloadedData),
                "effect end must release the tea marker");
        helper.assertTrue(reloadedData.getBoolean(porcelainMarker),
                "tea cleanup must not remove the porcelain-cup marker");

        CiBeiTea.clearReducedDrunkenness(persistentData);
        persistentData.remove(porcelainMarker);
        reloadedData.remove(porcelainMarker);
        helper.succeed();
    }
}
