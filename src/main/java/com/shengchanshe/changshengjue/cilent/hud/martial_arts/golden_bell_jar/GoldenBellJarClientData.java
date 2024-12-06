package com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar;

public class GoldenBellJarClientData {
    // 玩家的技能等级和是否学习了技能
    private static int goldenBellJarLevel;
    private static boolean goldenBellJarComprehend;
    private static int goldenBellJarUseCooldownPercent;
    private static boolean goldenBellJarOff;
    private static boolean goldenBellJarTopped;
    private static boolean goldenBellJarDacheng;
    private static int goldenBellJarToppedTick;//技能领悟特效计时
    private static int goldenBellJarDachengTick;//技能大成特效计时
    private static boolean goldenBellJarParticle;//技能特效显示

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

    public static boolean isGoldenBellJarTopped() {
        return goldenBellJarTopped;
    }

    public static void setGoldenBellJarTopped(boolean goldenBellJarTopped) {
        GoldenBellJarClientData.goldenBellJarTopped = goldenBellJarTopped;
    }
    public static boolean isGoldenBellJarDacheng() {
        return goldenBellJarDacheng;
    }

    public static void setGoldenBellJarDacheng(boolean goldenBellJarDacheng) {
        GoldenBellJarClientData.goldenBellJarDacheng = goldenBellJarDacheng;
    }

    public static int getGoldenBellJarToppedTick() {
        return goldenBellJarToppedTick;
    }

    public static void setGoldenBellJarToppedTick(int goldenBellJarToppedTick) {
        GoldenBellJarClientData.goldenBellJarToppedTick = goldenBellJarToppedTick;
    }

    public static int getGoldenBellJarDachengTick() {
        return goldenBellJarDachengTick;
    }

    public static void setGoldenBellJarDachengTick(int goldenBellJarDachengTick) {
        GoldenBellJarClientData.goldenBellJarDachengTick = goldenBellJarDachengTick;
    }

    public static boolean isGoldenBellJarParticle() {
        return goldenBellJarParticle;
    }

    public static void setGoldenBellJarParticle(boolean goldenBellJarParticle) {
        GoldenBellJarClientData.goldenBellJarParticle = goldenBellJarParticle;
    }
}
