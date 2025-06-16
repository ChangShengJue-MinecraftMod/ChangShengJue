package com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi;

import java.util.UUID;

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
    private static int recordTime;
    private static float recordDamage;
    private static UUID recordDamageSource;
    // 技能状态
    private static boolean skillActive;
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

    public static boolean isSkillActive() {
        return skillActive;
    }
    public static void setSkillActive(boolean skillActive) {
        QianKunDaNuoYiClientData.skillActive = skillActive;
    }

    public static float isQianKunDaNuoYiUseCooldownMax() {
        return qianKunDaNuoYiUseCooldownMax;
    }

    public static void setQianKunDaNuoYiUseCooldownMax(float qianKunDaNuoYiUseCooldownMax) {
        QianKunDaNuoYiClientData.qianKunDaNuoYiUseCooldownMax = qianKunDaNuoYiUseCooldownMax;
    }

    public static int getRecordTime() {
        return recordTime;
    }

    public static void setRecordTime(int recordTime) {
        QianKunDaNuoYiClientData.recordTime = recordTime;
    }

    public static float getRecordDamage() {
        return recordDamage;
    }

    public static void setRecordDamage(float recordDamage) {
        QianKunDaNuoYiClientData.recordDamage = recordDamage;
    }

    public static UUID getRecordDamageSource() {
        return recordDamageSource;
    }

    public static void setRecordDamageSource(UUID recordDamageSource) {
        QianKunDaNuoYiClientData.recordDamageSource = recordDamageSource;
    }
}
