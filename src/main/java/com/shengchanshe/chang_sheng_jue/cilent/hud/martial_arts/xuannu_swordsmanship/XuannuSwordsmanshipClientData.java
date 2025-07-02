package com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.xuannu_swordsmanship;

public class XuannuSwordsmanshipClientData {
    // 玩家的技能等级和是否学习了技能
    private static int xuannuSwordsmanshipLevel;
    private static boolean xuannuSwordsmanshipComprehend;
    private static float xuannuSwordsmanshipToppedTick;//技能领悟特效计时
    private static float xuannuSwordsmanshipDachengTick;//技能大成特效计时
    private static boolean xuannuSwordsmanshipParticle;//技能特效显示
    //获取技能等级
    public static int getXuannuSwordsmanshipLevel() {
        return xuannuSwordsmanshipLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setXuannuSwordsmanshipLevel(int xuannuSwordsmanshipLevel) {
        XuannuSwordsmanshipClientData.xuannuSwordsmanshipLevel = xuannuSwordsmanshipLevel;
    }

    public static boolean isXuannuSwordsmanshipComprehend() {
        return xuannuSwordsmanshipComprehend;
    }

    public static void setXuannuSwordsmanshipComprehend(boolean xuannuSwordsmanshipComprehend) {
        XuannuSwordsmanshipClientData.xuannuSwordsmanshipComprehend = xuannuSwordsmanshipComprehend;
    }
    public static float getXuannuSwordsmanshipToppedTick() {
        return xuannuSwordsmanshipToppedTick;
    }

    public static void setXuannuSwordsmanshipToppedTick(float xuannuSwordsmanshipToppedTick) {
        XuannuSwordsmanshipClientData.xuannuSwordsmanshipToppedTick = xuannuSwordsmanshipToppedTick;
    }

    public static float getXuannuSwordsmanshipDachengTick() {
        return xuannuSwordsmanshipDachengTick;
    }

    public static void setXuannuSwordsmanshipDachengTick(float xuannuSwordsmanshipDachengTick) {
        XuannuSwordsmanshipClientData.xuannuSwordsmanshipDachengTick = xuannuSwordsmanshipDachengTick;
    }

    public static boolean isXuannuSwordsmanshipParticle() {
        return xuannuSwordsmanshipParticle;
    }

    public static void setXuannuSwordsmanshipParticle(boolean xuannuSwordsmanshipParticle) {
        XuannuSwordsmanshipClientData.xuannuSwordsmanshipParticle = xuannuSwordsmanshipParticle;
    }
}
