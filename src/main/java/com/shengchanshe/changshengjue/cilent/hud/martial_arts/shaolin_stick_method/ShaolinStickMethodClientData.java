package com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method;

public class ShaolinStickMethodClientData {
    // 玩家的技能等级和是否学习了技能
    private static int shaolinStickMethodLevel;
    private static boolean shaolinStickMethodComprehend;
    private static float shaolinStickMethodToppedTick;//技能领悟特效计时
    private static float shaolinStickMethodDachengTick;//技能大成特效计时
    private static boolean shaolinStickMethodParticle;//技能特效显示
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
    public static float getShaolinStickMethodToppedTick() {
        return shaolinStickMethodToppedTick;
    }

    public static void setShaolinStickMethodToppedTick(float shaolinStickMethodToppedTick) {
        ShaolinStickMethodClientData.shaolinStickMethodToppedTick = shaolinStickMethodToppedTick;
    }

    public static float getShaolinStickMethodDachengTick() {
        return shaolinStickMethodDachengTick;
    }

    public static void setShaolinStickMethodDachengTick(float shaolinStickMethodDachengTick) {
        ShaolinStickMethodClientData.shaolinStickMethodDachengTick = shaolinStickMethodDachengTick;
    }

    public static boolean isShaolinStickMethodParticle() {
        return shaolinStickMethodParticle;
    }

    public static void setShaolinStickMethodParticle(boolean shaolinStickMethodParticle) {
        ShaolinStickMethodClientData.shaolinStickMethodParticle = shaolinStickMethodParticle;
    }
}
