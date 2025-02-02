package com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman;
public class SunflowerPointCavemanClientData {
    // 玩家的技能等级和是否学习了技能
    private static int sunflowerPointCavemanLevel;
    private static boolean sunflowerPointCavemanComprehend;
    private static float sunflowerPointCavemanUseCooldownPercent;
    private static boolean sunflowerPointCavemanOff;
    private static float sunflowerPointCavemanToppedTick;//技能领悟特效计时
    private static float sunflowerPointCavemanDachengTick;//技能大成特效计时
    private static boolean sunflowerPointCavemanParticle;//技能特效显示
    // 技能状态
    private static boolean skillZActive;
    private static boolean skillXActive;
    private static boolean skillCActive;
    //获取技能等级
    public static int getSunflowerPointCavemanLevel() {
        return sunflowerPointCavemanLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setSunflowerPointCavemanLevel(int sunflowerPointCavemanLevel) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanLevel = sunflowerPointCavemanLevel;
    }

    public static float getSunflowerPointCavemanUseCooldownPercent() {
        return sunflowerPointCavemanUseCooldownPercent;
    }

    public static void setSunflowerPointCavemanUseCooldownPercent(float sunflowerPointCavemanComprehend) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanUseCooldownPercent = sunflowerPointCavemanComprehend;
    }

    public static boolean isSunflowerPointCavemanComprehend() {
        return sunflowerPointCavemanComprehend;
    }

    public static void setSunflowerPointCavemanComprehend(boolean sunflowerPointCavemanComprehend) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanComprehend = sunflowerPointCavemanComprehend;
    }

    public static boolean isSunflowerPointCavemanOff() {
        return sunflowerPointCavemanOff;
    }

    public static void setSunflowerPointCavemanOff(boolean sunflowerPointCavemanOff) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanOff = sunflowerPointCavemanOff;
    }

    public static float getSunflowerPointCavemanToppedTick() {
        return sunflowerPointCavemanToppedTick;
    }

    public static void setSunflowerPointCavemanToppedTick(float sunflowerPointCavemanToppedTick) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanToppedTick = sunflowerPointCavemanToppedTick;
    }

    public static float getSunflowerPointCavemanDachengTick() {
        return sunflowerPointCavemanDachengTick;
    }

    public static void setSunflowerPointCavemanDachengTick(float sunflowerPointCavemanDachengTick) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanDachengTick = sunflowerPointCavemanDachengTick;
    }

    public static boolean isSunflowerPointCavemanParticle() {
        return sunflowerPointCavemanParticle;
    }

    public static void setSunflowerPointCavemanParticle(boolean sunflowerPointCavemanParticle) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanParticle = sunflowerPointCavemanParticle;
    }
    public static boolean isSkillZActive() {
        return skillZActive;
    }

    public static void setSkillZActive(boolean skillZActive) {
        SunflowerPointCavemanClientData.skillZActive = skillZActive;
    }

    public static boolean isSkillXActive() {
        return skillXActive;
    }

    public static void setSkillXActive(boolean skillXActive) {
        SunflowerPointCavemanClientData.skillXActive = skillXActive;
    }

    public static boolean isSkillCActive() {
        return skillCActive;
    }

    public static void setSkillCActive(boolean skillCActive) {
        SunflowerPointCavemanClientData.skillCActive = skillCActive;
    }

}
