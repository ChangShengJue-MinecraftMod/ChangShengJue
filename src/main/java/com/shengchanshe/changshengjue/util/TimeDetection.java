package com.shengchanshe.changshengjue.util;

import net.minecraft.world.level.Level;

public class TimeDetection {
    public static boolean isFullNight(Level level) {
        long dayTime = level.getDayTime() % 24000;
        return dayTime >= 13000 && dayTime <= 23000;
    }
}
