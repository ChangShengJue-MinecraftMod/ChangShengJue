package com.shengchanshe.changshengjue.cilent.hud.martial_arts.yugong_moves_mountains;

public class YugongMovesMountainsClientData {
    // 玩家的技能等级和是否学习了技能
    private static int yugongMovesMountainsLevel;
    private static boolean yugongMovesMountainsComprehend;
    private static float yugongMovesMountainsToppedTick;//技能领悟特效计时
    private static float yugongMovesMountainsDachengTick;//技能大成特效计时
    private static boolean yugongMovesMountainsParticle;//技能特效显示
    //获取技能等级
    public static int getYugongMovesMountainsLevel() {
        return yugongMovesMountainsLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setYugongMovesMountainsLevel(int yugongMovesMountainsLevel) {
        YugongMovesMountainsClientData.yugongMovesMountainsLevel = yugongMovesMountainsLevel;
    }

    public static boolean isYugongMovesMountainsComprehend() {
        return yugongMovesMountainsComprehend;
    }

    public static void setYugongMovesMountainsComprehend(boolean yugongMovesMountainsComprehend) {
        YugongMovesMountainsClientData.yugongMovesMountainsComprehend = yugongMovesMountainsComprehend;
    }
    public static float getYugongMovesMountainsToppedTick() {
        return yugongMovesMountainsToppedTick;
    }

    public static void setYugongMovesMountainsToppedTick(float yugongMovesMountainsToppedTick) {
        YugongMovesMountainsClientData.yugongMovesMountainsToppedTick = yugongMovesMountainsToppedTick;
    }

    public static float getYugongMovesMountainsDachengTick() {
        return yugongMovesMountainsDachengTick;
    }

    public static void setYugongMovesMountainsDachengTick(float yugongMovesMountainsDachengTick) {
        YugongMovesMountainsClientData.yugongMovesMountainsDachengTick = yugongMovesMountainsDachengTick;
    }

    public static boolean isYugongMovesMountainsParticle() {
        return yugongMovesMountainsParticle;
    }

    public static void setYugongMovesMountainsParticle(boolean yugongMovesMountainsParticle) {
        YugongMovesMountainsClientData.yugongMovesMountainsParticle = yugongMovesMountainsParticle;
    }
}
