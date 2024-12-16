package com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu;

public class GeShanDaNiuClientData {
    // 玩家的技能等级和是否学习了技能
    private static int geShanDaNiuLevel;
    private static boolean geShanDaNiuComprehend;
    private static float geShanDaNiuUseCooldownPercent;
    private static boolean geShanDaNiuOff;
    private static float geShanDaNiuToppedTick;//技能领悟特效计时
    private static float geShanDaNiuDachengTick;//技能大成特效计时
    private static boolean geShanDaNiuParticle;//技能特效显示
    private static float geShanDaNiuUseCooldownPercentMax;//技能总冷却时间

    //获取技能等级
    public static int getGeShanDaNiuLevel() {
        return geShanDaNiuLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setGeShanDaNiuLevel(int geShanDaNiuLevel) {
        GeShanDaNiuClientData.geShanDaNiuLevel = geShanDaNiuLevel;
    }

    public static float getGeShanDaNiuUseCooldownPercent() {
        return geShanDaNiuUseCooldownPercent;
    }

    public static void setGeShanDaNiuUseCooldownPercent(float geShanDaNiuComprehend) {
        GeShanDaNiuClientData.geShanDaNiuUseCooldownPercent = geShanDaNiuComprehend;
    }

    public static boolean isGeShanDaNiuComprehend() {
        return geShanDaNiuComprehend;
    }

    public static void setGeShanDaNiuComprehend(boolean geShanDaNiuComprehend) {
        GeShanDaNiuClientData.geShanDaNiuComprehend = geShanDaNiuComprehend;
    }

    public static boolean isGeShanDaNiuOff() {
        return geShanDaNiuOff;
    }

    public static void setGeShanDaNiuOff(boolean geShanDaNiuOff) {
        GeShanDaNiuClientData.geShanDaNiuOff = geShanDaNiuOff;
    }

    public static float getGeShanDaNiuToppedTick() {
        return geShanDaNiuToppedTick;
    }

    public static void setGeShanDaNiuToppedTick(float geShanDaNiuToppedTick) {
        GeShanDaNiuClientData.geShanDaNiuToppedTick = geShanDaNiuToppedTick;
    }

    public static float getGeShanDaNiuDachengTick() {
        return geShanDaNiuDachengTick;
    }

    public static void setGeShanDaNiuDachengTick(float geShanDaNiuDachengTick) {
        GeShanDaNiuClientData.geShanDaNiuDachengTick = geShanDaNiuDachengTick;
    }

    public static boolean isGeShanDaNiuParticle() {
        return geShanDaNiuParticle;
    }

    public static void setGeShanDaNiuParticle(boolean geShanDaNiuParticle) {
        GeShanDaNiuClientData.geShanDaNiuParticle = geShanDaNiuParticle;
    }

    public static float getGeShanDaNiuUseCooldownPercentMax() {
        return geShanDaNiuUseCooldownPercentMax;
    }

    public static void setGeShanDaNiuUseCooldownPercentMax(float geShanDaNiuUseCooldownPercentMax) {
        GeShanDaNiuClientData.geShanDaNiuUseCooldownPercentMax = geShanDaNiuUseCooldownPercentMax;
    }
}
