package com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi;

public class QianKunDaNuoYiClientData {
    // 玩家的技能等级和是否学习了技能
    private static int qianKunDaNuoYiLevel;
    private static boolean qianKunDaNuoYiComprehend;
    private static float qianKunDaNuoYiUseCooldownPercent;
    private static boolean qianKunDaNuoYiOff;
    private static float qianKunDaNuoYiToppedTick;//技能领悟特效计时
    private static float qianKunDaNuoYiDachengTick;//技能大成特效计时
    private static boolean qianKunDaNuoYiParticle;//技能特效显示
    private static float qianKunDaNuoYiUseCooldownMax;//技能特效显示
    // 技能状态
    private static boolean skillZActive;
    private static boolean skillXActive;
    private static boolean skillCActive;
    //获取技能等级
    public static int getQianKunDaNuoYiLevel() {
        return qianKunDaNuoYiLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setQianKunDaNuoYiLevel(int qianKunDaNuoYiLevel) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiLevel = qianKunDaNuoYiLevel;
    }

    public static float getQianKunDaNuoYiUseCooldownPercent() {
        return qianKunDaNuoYiUseCooldownPercent;
    }

    public static void setQianKunDaNuoYiUseCooldownPercent(float qianKunDaNuoYiComprehend) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiUseCooldownPercent = qianKunDaNuoYiComprehend;
    }

    public static boolean isQianKunDaNuoYiComprehend() {
        return qianKunDaNuoYiComprehend;
    }

    public static void setQianKunDaNuoYiComprehend(boolean qianKunDaNuoYiComprehend) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiComprehend = qianKunDaNuoYiComprehend;
    }

    public static boolean isQianKunDaNuoYiOff() {
        return qianKunDaNuoYiOff;
    }

    public static void setQianKunDaNuoYiOff(boolean qianKunDaNuoYiOff) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiOff = qianKunDaNuoYiOff;
    }

    public static float getQianKunDaNuoYiToppedTick() {
        return qianKunDaNuoYiToppedTick;
    }

    public static void setQianKunDaNuoYiToppedTick(float qianKunDaNuoYiToppedTick) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiToppedTick = qianKunDaNuoYiToppedTick;
    }

    public static float getQianKunDaNuoYiDachengTick() {
        return qianKunDaNuoYiDachengTick;
    }

    public static void setQianKunDaNuoYiDachengTick(float qianKunDaNuoYiDachengTick) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiDachengTick = qianKunDaNuoYiDachengTick;
    }

    public static boolean isQianKunDaNuoYiParticle() {
        return qianKunDaNuoYiParticle;
    }

    public static void setQianKunDaNuoYiParticle(boolean qianKunDaNuoYiParticle) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiParticle = qianKunDaNuoYiParticle;
    }
    public static boolean isSkillZActive() {
        return skillZActive;
    }

    public static void setSkillZActive(boolean skillZActive) {
        QianKunDaNuoYiClientData.skillZActive = skillZActive;
    }

    public static boolean isSkillXActive() {
        return skillXActive;
    }

    public static void setSkillXActive(boolean skillXActive) {
        QianKunDaNuoYiClientData.skillXActive = skillXActive;
    }

    public static boolean isSkillCActive() {
        return skillCActive;
    }

    public static void setSkillCActive(boolean skillCActive) {
        QianKunDaNuoYiClientData.skillCActive = skillCActive;
    }

    public static float isQianKunDaNuoYiUseCooldownMax() {
        return qianKunDaNuoYiUseCooldownMax;
    }

    public static void setQianKunDaNuoYiUseCooldownMax(float qianKunDaNuoYiUseCooldownMax) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiUseCooldownMax = qianKunDaNuoYiUseCooldownMax;
    }
}
