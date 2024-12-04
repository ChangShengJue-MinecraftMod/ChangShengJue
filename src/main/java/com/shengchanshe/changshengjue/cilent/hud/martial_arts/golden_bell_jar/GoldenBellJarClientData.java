package com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar;


public class GoldenBellJarClientData {
    // 玩家的技能等级和是否学习了技能
    private static int goldenBellJarLevel;
    private static boolean goldenBellJarComprehend;
    private static int goldenBellJarUseCooldownPercent;
    private static boolean goldenBellJarOff;

    //获取技能等级
    public static int getGoldenBellJarLevel() {
        return goldenBellJarLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setGoldenBellJarLevel(int goldenBellJarLevel) {
        GoldenBellJarClientData.goldenBellJarLevel = goldenBellJarLevel;
    }

    public static int getGoldenBellJarUseCooldownPercent() {
        return goldenBellJarUseCooldownPercent;
    }

    public static void setGoldenBellJarUseCooldownPercent(int goldenBellJarComprehend) {
        GoldenBellJarClientData.goldenBellJarUseCooldownPercent = goldenBellJarComprehend;
    }

    public static boolean isGoldenBellJarComprehend() {
        return goldenBellJarComprehend;
    }

    public static void setGoldenBellJarComprehend(boolean goldenBellJarComprehend) {
        GoldenBellJarClientData.goldenBellJarComprehend = goldenBellJarComprehend;
    }

    public static boolean isGoldenBellJarOff() {
        return goldenBellJarOff;
    }

    public static void setGoldenBellJarOff(boolean goldenBellJarOff) {
        GoldenBellJarClientData.goldenBellJarOff = goldenBellJarOff;
    }
}
