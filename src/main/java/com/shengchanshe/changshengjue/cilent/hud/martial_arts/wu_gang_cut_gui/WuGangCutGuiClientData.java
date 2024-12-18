package com.shengchanshe.changshengjue.cilent.hud.martial_arts.wu_gang_cut_gui;

import net.minecraft.core.BlockPos;

public class WuGangCutGuiClientData {
    private static BlockPos dropPos;
    private static float particleTick;

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
}
