package com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.paoding;

public class PaodingClientData {
    // 玩家的技能等级和是否学习了技能
    private static int paodingLevel;
    private static boolean paodingComprehend;
    private static float paodingToppedTick;//技能领悟特效计时
    private static float paodingDachengTick;//技能大成特效计时
    private static boolean paodingParticle;//技能特效显示
    //获取技能等级
    public static int getPaodingLevel() {
        return paodingLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setPaodingLevel(int paodingLevel) {
        PaodingClientData.paodingLevel = paodingLevel;
    }

    public static boolean isPaodingComprehend() {
        return paodingComprehend;
    }

    public static void setPaodingComprehend(boolean paodingComprehend) {
        PaodingClientData.paodingComprehend = paodingComprehend;
    }
    public static float getPaodingToppedTick() {
        return paodingToppedTick;
    }

    public static void setPaodingToppedTick(float paodingToppedTick) {
        PaodingClientData.paodingToppedTick = paodingToppedTick;
    }

    public static float getPaodingDachengTick() {
        return paodingDachengTick;
    }

    public static void setPaodingDachengTick(float paodingDachengTick) {
        PaodingClientData.paodingDachengTick = paodingDachengTick;
    }

    public static boolean isPaodingParticle() {
        return paodingParticle;
    }

    public static void setPaodingParticle(boolean paodingParticle) {
        PaodingClientData.paodingParticle = paodingParticle;
    }
}
