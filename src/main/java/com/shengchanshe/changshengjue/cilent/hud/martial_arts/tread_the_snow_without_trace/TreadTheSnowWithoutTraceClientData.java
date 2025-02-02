package com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace;

public class TreadTheSnowWithoutTraceClientData {
    // 玩家的技能等级和是否学习了技能
    private static int treadTheSnowWithoutTraceLevel;
    private static boolean treadTheSnowWithoutTraceComprehend;
    private static int treadTheSnowWithoutTraceUseCooldownPercent;
    private static int jumpCount;

    private static float treadTheSnowWithoutTraceToppedTick;//技能领悟特效计时
    private static float treadTheSnowWithoutTraceDachengTick;//技能大成特效计时
    private static boolean treadTheSnowWithoutTraceParticle;//技能特效显示

    //获取技能等级
    public static int getTreadTheSnowWithoutTraceLevel() {
        return treadTheSnowWithoutTraceLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setTreadTheSnowWithoutTraceLevel(int treadTheSnowWithoutTraceLevel) {
        TreadTheSnowWithoutTraceClientData.treadTheSnowWithoutTraceLevel = treadTheSnowWithoutTraceLevel;
    }

    public static boolean isTreadTheSnowWithoutTraceComprehend() {
        return treadTheSnowWithoutTraceComprehend;
    }

    public static void setTreadTheSnowWithoutTraceComprehend(boolean treadTheSnowWithoutTraceComprehend) {
        TreadTheSnowWithoutTraceClientData.treadTheSnowWithoutTraceComprehend = treadTheSnowWithoutTraceComprehend;
    }

    public static int getTreadTheSnowWithoutTraceUseCooldownPercent() {
        return treadTheSnowWithoutTraceUseCooldownPercent;
    }

    public static void setTreadTheSnowWithoutTraceUseCooldownPercent(int treadTheSnowWithoutTraceComprehend) {
        TreadTheSnowWithoutTraceClientData.treadTheSnowWithoutTraceUseCooldownPercent = treadTheSnowWithoutTraceComprehend;
    }

    public static int getjumpCount() {
        return jumpCount;
    }

    public static void setjumpCount() {
        TreadTheSnowWithoutTraceClientData.jumpCount++;
    }
    public static void setjumpCount(int jumpCount) {
        TreadTheSnowWithoutTraceClientData.jumpCount = jumpCount;
    }

    public static float getTreadTheSnowWithoutTraceToppedTick() {
        return treadTheSnowWithoutTraceToppedTick;
    }

    public static void setTreadTheSnowWithoutTraceToppedTick(float treadTheSnowWithoutTraceToppedTick) {
        TreadTheSnowWithoutTraceClientData.treadTheSnowWithoutTraceToppedTick = treadTheSnowWithoutTraceToppedTick;
    }

    public static float getTreadTheSnowWithoutTraceDachengTick() {
        return treadTheSnowWithoutTraceDachengTick;
    }

    public static void setTreadTheSnowWithoutTraceDachengTick(float treadTheSnowWithoutTraceDachengTick) {
        TreadTheSnowWithoutTraceClientData.treadTheSnowWithoutTraceDachengTick = treadTheSnowWithoutTraceDachengTick;
    }

    public static boolean isTreadTheSnowWithoutTraceParticle() {
        return treadTheSnowWithoutTraceParticle;
    }

    public static void setTreadTheSnowWithoutTraceParticle(boolean treadTheSnowWithoutTraceParticle) {
        TreadTheSnowWithoutTraceClientData.treadTheSnowWithoutTraceParticle = treadTheSnowWithoutTraceParticle;
    }
}
