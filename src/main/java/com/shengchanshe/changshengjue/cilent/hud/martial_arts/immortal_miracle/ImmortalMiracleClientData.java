package com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle;

public class ImmortalMiracleClientData {
    // 玩家的技能等级和是否学习了技能
    private static int immortalMiracleLevel;
    private static boolean immortalMiracleComprehend;
    private static int immortalMiracleUseCooldownPercent;
    private static boolean immortalMiracleOff;
    private static int immortalMiracleToppedTick;//技能领悟特效计时
    private static int immortalMiracleDachengTick;//技能大成特效计时
    private static boolean immortalMiracleParticle;//技能特效显示
    private static int immortalMiracleUseCooldownPercentMax;//技能总冷却时间

    //获取技能等级
    public static int getImmortalMiracleLevel() {
        return immortalMiracleLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setImmortalMiracleLevel(int immortalMiracleLevel) {
        ImmortalMiracleClientData.immortalMiracleLevel = immortalMiracleLevel;
    }

    public static int getImmortalMiracleUseCooldownPercent() {
        return immortalMiracleUseCooldownPercent;
    }

    public static void setImmortalMiracleUseCooldownPercent(int immortalMiracleComprehend) {
        ImmortalMiracleClientData.immortalMiracleUseCooldownPercent = immortalMiracleComprehend;
    }

    public static boolean isImmortalMiracleComprehend() {
        return immortalMiracleComprehend;
    }

    public static void setImmortalMiracleComprehend(boolean immortalMiracleComprehend) {
        ImmortalMiracleClientData.immortalMiracleComprehend = immortalMiracleComprehend;
    }

    public static boolean isImmortalMiracleOff() {
        return immortalMiracleOff;
    }

    public static void setImmortalMiracleOff(boolean immortalMiracleOff) {
        ImmortalMiracleClientData.immortalMiracleOff = immortalMiracleOff;
    }

    public static int getImmortalMiracleToppedTick() {
        return immortalMiracleToppedTick;
    }

    public static void setImmortalMiracleToppedTick(int immortalMiracleToppedTick) {
        ImmortalMiracleClientData.immortalMiracleToppedTick = immortalMiracleToppedTick;
    }

    public static int getImmortalMiracleDachengTick() {
        return immortalMiracleDachengTick;
    }

    public static void setImmortalMiracleDachengTick(int immortalMiracleDachengTick) {
        ImmortalMiracleClientData.immortalMiracleDachengTick = immortalMiracleDachengTick;
    }

    public static boolean isImmortalMiracleParticle() {
        return immortalMiracleParticle;
    }

    public static void setImmortalMiracleParticle(boolean immortalMiracleParticle) {
        ImmortalMiracleClientData.immortalMiracleParticle = immortalMiracleParticle;
    }

    public static int getImmortalMiracleUseCooldownPercentMax() {
        return immortalMiracleUseCooldownPercentMax;
    }

    public static void setImmortalMiracleUseCooldownPercentMax(int immortalMiracleUseCooldownPercentMax) {
        ImmortalMiracleClientData.immortalMiracleUseCooldownPercentMax = immortalMiracleUseCooldownPercentMax;
    }
}
