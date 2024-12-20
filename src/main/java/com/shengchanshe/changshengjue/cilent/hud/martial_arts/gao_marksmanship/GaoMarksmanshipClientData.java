package com.shengchanshe.changshengjue.cilent.hud.martial_arts.gao_marksmanship;

public class GaoMarksmanshipClientData {
    // 玩家的技能等级和是否学习了技能
    private static int gaoMarksmanshipLevel;
    private static boolean gaoMarksmanshipComprehend;
    private static float gaoMarksmanshipToppedTick;//技能领悟特效计时
    private static float gaoMarksmanshipDachengTick;//技能大成特效计时
    private static boolean gaoMarksmanshipParticle;//技能特效显示
    //获取技能等级
    public static int getGaoMarksmanshipLevel() {
        return gaoMarksmanshipLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setGaoMarksmanshipLevel(int gaoMarksmanshipLevel) {
        GaoMarksmanshipClientData.gaoMarksmanshipLevel = gaoMarksmanshipLevel;
    }

    public static boolean isGaoMarksmanshipComprehend() {
        return gaoMarksmanshipComprehend;
    }

    public static void setGaoMarksmanshipComprehend(boolean gaoMarksmanshipComprehend) {
        GaoMarksmanshipClientData.gaoMarksmanshipComprehend = gaoMarksmanshipComprehend;
    }
    public static float getGaoMarksmanshipToppedTick() {
        return gaoMarksmanshipToppedTick;
    }

    public static void setGaoMarksmanshipToppedTick(float gaoMarksmanshipToppedTick) {
        GaoMarksmanshipClientData.gaoMarksmanshipToppedTick = gaoMarksmanshipToppedTick;
    }

    public static float getGaoMarksmanshipDachengTick() {
        return gaoMarksmanshipDachengTick;
    }

    public static void setGaoMarksmanshipDachengTick(float gaoMarksmanshipDachengTick) {
        GaoMarksmanshipClientData.gaoMarksmanshipDachengTick = gaoMarksmanshipDachengTick;
    }

    public static boolean isGaoMarksmanshipParticle() {
        return gaoMarksmanshipParticle;
    }

    public static void setGaoMarksmanshipParticle(boolean gaoMarksmanshipParticle) {
        GaoMarksmanshipClientData.gaoMarksmanshipParticle = gaoMarksmanshipParticle;
    }
}
