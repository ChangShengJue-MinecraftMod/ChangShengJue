package com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method;

public class GoldenBlackKnifeMethodClientData {
    // 玩家的技能等级和是否学习了技能
    private static int goldenBlackKnifeMethodLevel;
    private static boolean goldenBlackKnifeMethodComprehend;

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
}
