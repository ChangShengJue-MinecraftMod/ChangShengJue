package com.shengchanshe.changshengjue.cilent.hud.martial_arts.wu_gang_cut_gui;

import net.minecraft.core.BlockPos;

public class WuGangCutGuiClientData {
    private static BlockPos dropPos;
    private static float particleTick;
    private static float wuGangCutGuiToppedTick;//技能领悟特效计时
    private static float wuGangCutGuiDachengTick;//技能大成特效计时
    private static boolean wuGangCutGuiParticle;//技能特效显示

    public static BlockPos getDropPos() {
        return dropPos;
    }

    public static void setDropPos(BlockPos dropPos) {
        WuGangCutGuiClientData.dropPos = dropPos;
    }

    public static float getParticleTick() {
        return particleTick;
    }

    public static void setParticleTick(float particleTick) {
        WuGangCutGuiClientData.particleTick = particleTick - 1;
    }
    public static float getWuGangCutGuiToppedTick() {
        return wuGangCutGuiToppedTick;
    }

    public static void setWuGangCutGuiToppedTick(float wuGangCutGuiToppedTick) {
        WuGangCutGuiClientData.wuGangCutGuiToppedTick = wuGangCutGuiToppedTick;
    }

    public static float getWuGangCutGuiDachengTick() {
        return wuGangCutGuiDachengTick;
    }

    public static void setWuGangCutGuiDachengTick(float wuGangCutGuiDachengTick) {
        WuGangCutGuiClientData.wuGangCutGuiDachengTick = wuGangCutGuiDachengTick;
    }

    public static boolean isWuGangCutGuiParticle() {
        return wuGangCutGuiParticle;
    }

    public static void setWuGangCutGuiParticle(boolean wuGangCutGuiParticle) {
        WuGangCutGuiClientData.wuGangCutGuiParticle = wuGangCutGuiParticle;
    }
}
