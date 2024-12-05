package com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman;

public class SunflowerPointCavemanClientData {
    // 玩家的技能等级和是否学习了技能
    private static int sunflowerPointCavemanLevel;
    private static boolean sunflowerPointCavemanComprehend;
    private static int sunflowerPointCavemanUseCooldownPercent;
    private static boolean sunflowerPointCavemanOff;
    private static boolean sunflowerPointCavemanTopped;

    //获取技能等级
    public static int getSunflowerPointCavemanLevel() {
        return sunflowerPointCavemanLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setSunflowerPointCavemanLevel(int sunflowerPointCavemanLevel) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanLevel = sunflowerPointCavemanLevel;
    }

    public static int getSunflowerPointCavemanUseCooldownPercent() {
        return sunflowerPointCavemanUseCooldownPercent;
    }

    public static void setSunflowerPointCavemanUseCooldownPercent(int sunflowerPointCavemanComprehend) {
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
    public static boolean isSunflowerPointCavemanTopped() {
        return sunflowerPointCavemanTopped;
    }

    public static void setSunflowerPointCavemanTopped(boolean sunflowerPointCavemanTopped) {
        SunflowerPointCavemanClientData.sunflowerPointCavemanTopped = sunflowerPointCavemanTopped;
    }
}
