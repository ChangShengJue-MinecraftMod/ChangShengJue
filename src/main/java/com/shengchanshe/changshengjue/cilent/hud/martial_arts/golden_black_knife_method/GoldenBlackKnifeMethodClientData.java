package com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method;


public class GoldenBlackKnifeMethodClientData {
    // 玩家的技能等级和是否学习了技能
    private static int goldenBlackKnifeMethodLevel;
    private static boolean goldenBlackKnifeMethodComprehend;
    private static float goldenBlackKnifeMethodToppedTick;//技能领悟特效计时
    private static float goldenBlackKnifeMethodDachengTick;//技能大成特效计时
    private static boolean goldenBlackKnifeMethodParticle;//技能特效显示
    //获取技能等级
    public static int getGoldenBlackKnifeMethodLevel() {
        return goldenBlackKnifeMethodLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setGoldenBlackKnifeMethodLevel(int goldenBlackKnifeMethodLevel) {
        GoldenBlackKnifeMethodClientData.goldenBlackKnifeMethodLevel = goldenBlackKnifeMethodLevel;
    }

    public static boolean isGoldenBlackKnifeMethodComprehend() {
        return goldenBlackKnifeMethodComprehend;
    }

    public static void setGoldenBlackKnifeMethodComprehend(boolean goldenBlackKnifeMethodComprehend) {
        GoldenBlackKnifeMethodClientData.goldenBlackKnifeMethodComprehend = goldenBlackKnifeMethodComprehend;
    }
    public static float getGoldenBlackKnifeMethodToppedTick() {
        return goldenBlackKnifeMethodToppedTick;
    }

    public static void setGoldenBlackKnifeMethodToppedTick(float goldenBlackKnifeMethodToppedTick) {
        GoldenBlackKnifeMethodClientData.goldenBlackKnifeMethodToppedTick = goldenBlackKnifeMethodToppedTick;
    }

    public static float getGoldenBlackKnifeMethodDachengTick() {
        return goldenBlackKnifeMethodDachengTick;
    }

    public static void setGoldenBlackKnifeMethodDachengTick(float goldenBlackKnifeMethodDachengTick) {
        GoldenBlackKnifeMethodClientData.goldenBlackKnifeMethodDachengTick = goldenBlackKnifeMethodDachengTick;
    }

    public static boolean isGoldenBlackKnifeMethodParticle() {
        return goldenBlackKnifeMethodParticle;
    }

    public static void setGoldenBlackKnifeMethodParticle(boolean goldenBlackKnifeMethodParticle) {
        GoldenBlackKnifeMethodClientData.goldenBlackKnifeMethodParticle = goldenBlackKnifeMethodParticle;
    }
}
