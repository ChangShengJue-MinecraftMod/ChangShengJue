package com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method;

public class ShaolinStickMethodClientData {
    // 玩家的技能等级和是否学习了技能
    private static int shaolinStickMethodLevel;
    private static boolean shaolinStickMethodComprehend;

    //获取技能等级
    public static int getShaolinStickMethodLevel() {
        return shaolinStickMethodLevel;
    }
    //设置技能等级,等级由服务端发包
    public static void setShaolinStickMethodLevel(int shaolinStickMethodLevel) {
        ShaolinStickMethodClientData.shaolinStickMethodLevel = shaolinStickMethodLevel;
    }

    public static boolean isShaolinStickMethodComprehend() {
        return shaolinStickMethodComprehend;
    }

    public static void setShaolinStickMethodComprehend(boolean shaolinStickMethodComprehend) {
        ShaolinStickMethodClientData.shaolinStickMethodComprehend = shaolinStickMethodComprehend;
    }
}
