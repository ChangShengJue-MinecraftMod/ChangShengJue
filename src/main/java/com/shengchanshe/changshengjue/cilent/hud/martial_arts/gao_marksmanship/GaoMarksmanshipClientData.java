package com.shengchanshe.changshengjue.cilent.hud.martial_arts.gao_marksmanship;

public class GaoMarksmanshipClientData {
    // 玩家的技能等级和是否学习了技能
    private static int gaoMarksmanshipLevel;
    private static boolean gaoMarksmanshipComprehend;

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
}
