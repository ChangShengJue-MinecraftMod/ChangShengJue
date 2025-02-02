package com.shengchanshe.changshengjue.cilent.hud.martial_arts.relentless_throwing_knives;

public class RelentlessThrowingKnivesClientData {
    // 玩家的技能等级和是否学习了技能
    private static int relentlessThrowingKnivesLevel;
    private static boolean relentlessThrowingKnivesComprehend;
    private static int relentlessThrowingKnivesUseCooldownPercent;
    private static int relentlessThrowingKnivesToppedTick;//技能领悟特效计时
    private static int relentlessThrowingKnivesDachengTick;//技能大成特效计时
    private static boolean relentlessThrowingKnivesParticle;//技能特效显示

    //获取技能等级
    public static int getRelentlessThrowingKnivesLevel() {
        return relentlessThrowingKnivesLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setRelentlessThrowingKnivesLevel(int relentlessThrowingKnivesLevel) {
        RelentlessThrowingKnivesClientData.relentlessThrowingKnivesLevel = relentlessThrowingKnivesLevel;
    }

    public static int getRelentlessThrowingKnivesUseCooldownPercent() {
        return relentlessThrowingKnivesUseCooldownPercent;
    }

    public static void setRelentlessThrowingKnivesUseCooldownPercent(int relentlessThrowingKnivesComprehend) {
        RelentlessThrowingKnivesClientData.relentlessThrowingKnivesUseCooldownPercent = relentlessThrowingKnivesComprehend;
    }

    public static boolean isRelentlessThrowingKnivesComprehend() {
        return relentlessThrowingKnivesComprehend;
    }

    public static void setRelentlessThrowingKnivesComprehend(boolean relentlessThrowingKnivesComprehend) {
        RelentlessThrowingKnivesClientData.relentlessThrowingKnivesComprehend = relentlessThrowingKnivesComprehend;
    }

    public static int getRelentlessThrowingKnivesToppedTick() {
        return relentlessThrowingKnivesToppedTick;
    }

    public static void setRelentlessThrowingKnivesToppedTick(int relentlessThrowingKnivesToppedTick) {
        RelentlessThrowingKnivesClientData.relentlessThrowingKnivesToppedTick = relentlessThrowingKnivesToppedTick;
    }

    public static int getRelentlessThrowingKnivesDachengTick() {
        return relentlessThrowingKnivesDachengTick;
    }

    public static void setRelentlessThrowingKnivesDachengTick(int relentlessThrowingKnivesDachengTick) {
        RelentlessThrowingKnivesClientData.relentlessThrowingKnivesDachengTick = relentlessThrowingKnivesDachengTick;
    }

    public static boolean isRelentlessThrowingKnivesParticle() {
        return relentlessThrowingKnivesParticle;
    }

    public static void setRelentlessThrowingKnivesParticle(boolean relentlessThrowingKnivesParticle) {
        RelentlessThrowingKnivesClientData.relentlessThrowingKnivesParticle = relentlessThrowingKnivesParticle;
    }
}
