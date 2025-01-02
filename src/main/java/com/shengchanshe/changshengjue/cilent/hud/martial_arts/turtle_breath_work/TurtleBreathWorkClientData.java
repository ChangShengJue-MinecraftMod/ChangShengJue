package com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;

public class TurtleBreathWorkClientData {
    // 玩家的技能等级和是否学习了技能
    private static int turtleBreathWorkLevel;
    private static boolean turtleBreathWorkComprehend;
    private static float turtleBreathWorkUseCooldownPercent;
    private static boolean turtleBreathWorkOff;
    private static float turtleBreathWorkToppedTick;//技能领悟特效计时
    private static float turtleBreathWorkDachengTick;//技能大成特效计时
    private static boolean turtleBreathWorkParticle;//技能特效显示
    // 技能状态
    private static boolean skillZActive;
    private static boolean skillXActive;
    private static boolean skillCActive;
    //获取技能等级
    public static int getTurtleBreathWorkLevel() {
        return turtleBreathWorkLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setTurtleBreathWorkLevel(int turtleBreathWorkLevel) {
        TurtleBreathWorkClientData.turtleBreathWorkLevel = turtleBreathWorkLevel;
    }

    public static float getTurtleBreathWorkUseCooldownPercent() {
        return turtleBreathWorkUseCooldownPercent;
    }

    public static void setTurtleBreathWorkUseCooldownPercent(float turtleBreathWorkComprehend) {
        TurtleBreathWorkClientData.turtleBreathWorkUseCooldownPercent = turtleBreathWorkComprehend;
    }

    public static boolean isTurtleBreathWorkComprehend() {
        return turtleBreathWorkComprehend;
    }

    public static void setTurtleBreathWorkComprehend(boolean turtleBreathWorkComprehend) {
        TurtleBreathWorkClientData.turtleBreathWorkComprehend = turtleBreathWorkComprehend;
    }

    public static boolean isTurtleBreathWorkOff() {
        return turtleBreathWorkOff;
    }

    public static void setTurtleBreathWorkOff(boolean turtleBreathWorkOff) {
        TurtleBreathWorkClientData.turtleBreathWorkOff = turtleBreathWorkOff;
    }

    public static float getTurtleBreathWorkToppedTick() {
        return turtleBreathWorkToppedTick;
    }

    public static void setTurtleBreathWorkToppedTick(float turtleBreathWorkToppedTick) {
        TurtleBreathWorkClientData.turtleBreathWorkToppedTick = turtleBreathWorkToppedTick;
    }

    public static float getTurtleBreathWorkDachengTick() {
        return turtleBreathWorkDachengTick;
    }

    public static void setTurtleBreathWorkDachengTick(float turtleBreathWorkDachengTick) {
        TurtleBreathWorkClientData.turtleBreathWorkDachengTick = turtleBreathWorkDachengTick;
    }

    public static boolean isTurtleBreathWorkParticle() {
        return turtleBreathWorkParticle;
    }

    public static void setTurtleBreathWorkParticle(boolean turtleBreathWorkParticle) {
        TurtleBreathWorkClientData.turtleBreathWorkParticle = turtleBreathWorkParticle;
    }
    public static boolean isSkillZActive() {
        return skillZActive;
    }

    public static void setSkillZActive(boolean skillZActive) {
        TurtleBreathWorkClientData.skillZActive = skillZActive;
    }

    public static boolean isSkillXActive() {
        return skillXActive;
    }

    public static void setSkillXActive(boolean skillXActive) {
        TurtleBreathWorkClientData.skillXActive = skillXActive;
    }

    public static boolean isSkillCActive() {
        return skillCActive;
    }

    public static void setSkillCActive(boolean skillCActive) {
        TurtleBreathWorkClientData.skillCActive = skillCActive;
    }
}
