package com.shengchanshe.changshengjue.cilent.hud.martial_arts.the_classics_of_tendon_changing;

public class TheClassicsOfTendonChangingClientData {
    // 玩家的技能等级和是否学习了技能
    private static int theClassicsOfTendonChangingLevel;
    private static boolean theClassicsOfTendonChangingComprehend;
    private static float theClassicsOfTendonChangingUseCooldownPercent;
    private static boolean theClassicsOfTendonChangingOff;
    private static float theClassicsOfTendonChangingToppedTick;//技能领悟特效计时
    private static float theClassicsOfTendonChangingDachengTick;//技能大成特效计时
    private static boolean theClassicsOfTendonChangingParticle;//技能特效显示
    // 技能状态
    private static boolean skillZActive;
    private static boolean skillXActive;
    private static boolean skillCActive;
    //获取技能等级
    public static int getTheClassicsOfTendonChangingLevel() {
        return theClassicsOfTendonChangingLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setTheClassicsOfTendonChangingLevel(int theClassicsOfTendonChangingLevel) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingLevel = theClassicsOfTendonChangingLevel;
    }

    public static float getTheClassicsOfTendonChangingUseCooldownPercent() {
        return theClassicsOfTendonChangingUseCooldownPercent;
    }

    public static void setTheClassicsOfTendonChangingUseCooldownPercent(float theClassicsOfTendonChangingComprehend) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingUseCooldownPercent = theClassicsOfTendonChangingComprehend;
    }

    public static boolean isTheClassicsOfTendonChangingComprehend() {
        return theClassicsOfTendonChangingComprehend;
    }

    public static void setTheClassicsOfTendonChangingComprehend(boolean theClassicsOfTendonChangingComprehend) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingComprehend = theClassicsOfTendonChangingComprehend;
    }

    public static boolean isTheClassicsOfTendonChangingOff() {
        return theClassicsOfTendonChangingOff;
    }

    public static void setTheClassicsOfTendonChangingOff(boolean theClassicsOfTendonChangingOff) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingOff = theClassicsOfTendonChangingOff;
    }

    public static float getTheClassicsOfTendonChangingToppedTick() {
        return theClassicsOfTendonChangingToppedTick;
    }

    public static void setTheClassicsOfTendonChangingToppedTick(float theClassicsOfTendonChangingToppedTick) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingToppedTick = theClassicsOfTendonChangingToppedTick;
    }

    public static float getTheClassicsOfTendonChangingDachengTick() {
        return theClassicsOfTendonChangingDachengTick;
    }

    public static void setTheClassicsOfTendonChangingDachengTick(float theClassicsOfTendonChangingDachengTick) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingDachengTick = theClassicsOfTendonChangingDachengTick;
    }

    public static boolean isTheClassicsOfTendonChangingParticle() {
        return theClassicsOfTendonChangingParticle;
    }

    public static void setTheClassicsOfTendonChangingParticle(boolean theClassicsOfTendonChangingParticle) {
        TheClassicsOfTendonChangingClientData.theClassicsOfTendonChangingParticle = theClassicsOfTendonChangingParticle;
    }
    public static boolean isSkillZActive() {
        return skillZActive;
    }

    public static void setSkillZActive(boolean skillZActive) {
        TheClassicsOfTendonChangingClientData.skillZActive = skillZActive;
    }

    public static boolean isSkillXActive() {
        return skillXActive;
    }

    public static void setSkillXActive(boolean skillXActive) {
        TheClassicsOfTendonChangingClientData.skillXActive = skillXActive;
    }

    public static boolean isSkillCActive() {
        return skillCActive;
    }

    public static void setSkillCActive(boolean skillCActive) {
        TheClassicsOfTendonChangingClientData.skillCActive = skillCActive;
    }

}
