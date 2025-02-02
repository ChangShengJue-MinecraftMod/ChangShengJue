package com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords;

public class DuguNineSwordsClientData {
    // 玩家的技能等级和是否学习了技能
    private static int duguNineSwordsLevel;
    private static boolean duguNineSwordsComprehend;
    private static float duguNineSwordsToppedTick;//技能领悟特效计时
    private static float duguNineSwordsDachengTick;//技能大成特效计时
    private static boolean duguNineSwordsParticle;//技能特效显示
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
    public static float getDuguNineSwordsToppedTick() {
        return duguNineSwordsToppedTick;
    }

    public static void setDuguNineSwordsToppedTick(float duguNineSwordsToppedTick) {
        DuguNineSwordsClientData.duguNineSwordsToppedTick = duguNineSwordsToppedTick;
    }

    public static float getDuguNineSwordsDachengTick() {
        return duguNineSwordsDachengTick;
    }

    public static void setDuguNineSwordsDachengTick(float duguNineSwordsDachengTick) {
        DuguNineSwordsClientData.duguNineSwordsDachengTick = duguNineSwordsDachengTick;
    }

    public static boolean isDuguNineSwordsParticle() {
        return duguNineSwordsParticle;
    }

    public static void setDuguNineSwordsParticle(boolean duguNineSwordsParticle) {
        DuguNineSwordsClientData.duguNineSwordsParticle = duguNineSwordsParticle;
    }
}
