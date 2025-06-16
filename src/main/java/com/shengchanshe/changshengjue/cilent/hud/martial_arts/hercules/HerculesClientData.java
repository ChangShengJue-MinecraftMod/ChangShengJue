package com.shengchanshe.changshengjue.cilent.hud.martial_arts.hercules;

import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;

public class HerculesClientData {
    // 玩家的技能等级和是否学习了技能
    private static int herculesLevel;
    private static boolean herculesComprehend;
    private static float herculesToppedTick;//技能领悟特效计时
    private static float herculesDachengTick;//技能大成特效计时
    private static boolean herculesParticle;//技能特效显示
    // 技能状态
    private static boolean skillActive;
    //获取技能等级
    public static int getHerculesLevel() {
        return herculesLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setHerculesLevel(int herculesLevel) {
        HerculesClientData.herculesLevel = herculesLevel;
    }

    public static boolean isHerculesComprehend() {
        return herculesComprehend;
    }

    public static void setHerculesComprehend(boolean herculesComprehend) {
        HerculesClientData.herculesComprehend = herculesComprehend;
    }
    public static float getHerculesToppedTick() {
        return herculesToppedTick;
    }

    public static void setHerculesToppedTick(float herculesToppedTick) {
        HerculesClientData.herculesToppedTick = herculesToppedTick;
    }

    public static float getHerculesDachengTick() {
        return herculesDachengTick;
    }

    public static void setHerculesDachengTick(float herculesDachengTick) {
        HerculesClientData.herculesDachengTick = herculesDachengTick;
    }

    public static boolean isHerculesParticle() {
        return herculesParticle;
    }

    public static void setHerculesParticle(boolean herculesParticle) {
        HerculesClientData.herculesParticle = herculesParticle;
    }

    public static boolean isSkillActive() {
        return skillActive;
    }

    public static void setSkillActive(boolean skillActive) {
        HerculesClientData.skillActive = skillActive;
    }
}
