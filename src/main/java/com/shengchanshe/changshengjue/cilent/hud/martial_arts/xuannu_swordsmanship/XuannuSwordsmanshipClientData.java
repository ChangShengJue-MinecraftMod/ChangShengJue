package com.shengchanshe.changshengjue.cilent.hud.martial_arts.xuannu_swordsmanship;

public class XuannuSwordsmanshipClientData {
    // 玩家的技能等级和是否学习了技能
    private static int xuannuSwordsmanshipLevel;
    private static boolean xuannuSwordsmanshipComprehend;

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
}
