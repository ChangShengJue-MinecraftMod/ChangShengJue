package com.shengchanshe.changshengjue.cilent.hud.dugu_nine_swords;

public class DuguNineSwordsClientData {
    // 玩家的技能等级和是否学习了技能
    private static int duguNineSwordsLevel;
    private static boolean duguNineSwordsComprehend;

    //获取技能等级
    public static int getDuguNineSwordsLevel() {
        return duguNineSwordsLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setDuguNineSwordsLevel(int duguNineSwordsLevel) {
        DuguNineSwordsClientData.duguNineSwordsLevel = duguNineSwordsLevel;
    }

    public static boolean isDuguNineSwordsComprehend() {
        return duguNineSwordsComprehend;
    }

    public static void setDuguNineSwordsComprehend(boolean duguNineSwordsComprehend) {
        DuguNineSwordsClientData.duguNineSwordsComprehend = duguNineSwordsComprehend;
    }
}
