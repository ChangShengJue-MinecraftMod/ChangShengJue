package com.shengchanshe.changshengjue.cilent.hud.martial_arts.wheat_nugget_encyclopedia;

public class WheatNuggetEncyclopediaClientData {
    // 玩家的技能等级和是否学习了技能
    private static int wheatNuggetEncyclopediaToppedTick;//技能领悟特效计时
    private static int wheatNuggetEncyclopediaDachengTick;//技能大成特效计时
    private static boolean wheatNuggetEncyclopediaParticle;//技能特效显示

    public static int getWheatNuggetEncyclopediaToppedTick() {
        return wheatNuggetEncyclopediaToppedTick;
    }

    public static void setWheatNuggetEncyclopediaToppedTick(int WheatNuggetEncyclopediaToppedTick) {
        WheatNuggetEncyclopediaClientData.wheatNuggetEncyclopediaToppedTick = WheatNuggetEncyclopediaToppedTick;
    }

    public static int getWheatNuggetEncyclopediaDachengTick() {
        return wheatNuggetEncyclopediaDachengTick;
    }

    public static void setWheatNuggetEncyclopediaDachengTick(int WheatNuggetEncyclopediaDachengTick) {
        WheatNuggetEncyclopediaClientData.wheatNuggetEncyclopediaDachengTick = WheatNuggetEncyclopediaDachengTick;
    }

    public static boolean isWheatNuggetEncyclopediaParticle() {
        return wheatNuggetEncyclopediaParticle;
    }

    public static void setWheatNuggetEncyclopediaParticle(boolean WheatNuggetEncyclopediaParticle) {
        WheatNuggetEncyclopediaClientData.wheatNuggetEncyclopediaParticle = WheatNuggetEncyclopediaParticle;
    }
}
