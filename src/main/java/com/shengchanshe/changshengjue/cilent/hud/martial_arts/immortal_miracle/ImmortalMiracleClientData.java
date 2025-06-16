package com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;

public class ImmortalMiracleClientData {
    // 玩家的技能等级和是否学习了技能
    private static int immortalMiracleLevel;
    private static boolean immortalMiracleComprehend;
    private static float immortalMiracleUseCooldownPercent;
    private static boolean immortalMiracleOff;
    private static float immortalMiracleToppedTick;//技能领悟特效计时
    private static float immortalMiracleDachengTick;//技能大成特效计时
    private static boolean immortalMiracleParticle;//技能特效显示
    private static float immortalMiracleUseCooldownPercentMax;//技能总冷却时间
    // 技能状态
    private static boolean skillActive;
    //获取技能等级
    public static int getImmortalMiracleLevel() {
        return immortalMiracleLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setImmortalMiracleLevel(int immortalMiracleLevel) {
        ImmortalMiracleClientData.immortalMiracleLevel = immortalMiracleLevel;
    }

    public static float getImmortalMiracleUseCooldownPercent() {
        return immortalMiracleUseCooldownPercent;
    }

    public static void setImmortalMiracleUseCooldownPercent(float immortalMiracleComprehend) {
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

    public static float getImmortalMiracleToppedTick() {
        return immortalMiracleToppedTick;
    }

    public static void setImmortalMiracleToppedTick(float immortalMiracleToppedTick) {
        ImmortalMiracleClientData.immortalMiracleToppedTick = immortalMiracleToppedTick;
    }

    public static float getImmortalMiracleDachengTick() {
        return immortalMiracleDachengTick;
    }

    public static void setImmortalMiracleDachengTick(float immortalMiracleDachengTick) {
        ImmortalMiracleClientData.immortalMiracleDachengTick = immortalMiracleDachengTick;
    }

    public static boolean isImmortalMiracleParticle() {
        return immortalMiracleParticle;
    }

    public static void setImmortalMiracleParticle(boolean immortalMiracleParticle) {
        ImmortalMiracleClientData.immortalMiracleParticle = immortalMiracleParticle;
    }

    public static float getImmortalMiracleUseCooldownPercentMax() {
        return immortalMiracleUseCooldownPercentMax;
    }

    public static void setImmortalMiracleUseCooldownPercentMax(float immortalMiracleUseCooldownPercentMax) {
        ImmortalMiracleClientData.immortalMiracleUseCooldownPercentMax = immortalMiracleUseCooldownPercentMax;
    }

    public static boolean isSkillActive() {
        return skillActive;
    }

    public static void setSkillActive(boolean skillActive) {
        ImmortalMiracleClientData.skillActive = skillActive;
    }
}
