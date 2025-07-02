package com.shengchanshe.chang_sheng_jue.cilent.hud.cultivation.spirit;

public class CultivationClientData {
    private static String stageName;//境界名称
    private static int stageOrdinal;//境界序号
    private static float spiritPower;//当前灵力
    private static float spiritPowerMax;//当前灵力上限
    private static float truePower;//当前真元
    private static float truePowerMax;//当前真元上限
    private static float tunNaTick;// 吐纳时间

    private static byte densityTier;// 当前位置的天地灵气浓郁等级
    private static float currentValue;// 当前位置的天地灵气值

    public static String getStageName() {
        return stageName;
    }

    public static void setStageName(String stageName) {
        CultivationClientData.stageName = stageName;
    }

    public static int getStageOrdinal() {
        return stageOrdinal;
    }

    public static void setStageOrdinal(int stageOrdinal) {
        CultivationClientData.stageOrdinal = stageOrdinal;
    }

    public static float getSpiritPower() {
        return spiritPower;
    }

    public static void setSpiritPower(float spiritPower) {
        CultivationClientData.spiritPower = spiritPower;
    }

    public static float getSpiritPowerMax() {
        return spiritPowerMax;
    }

    public static void setSpiritPowerMax(float spiritPowerMax) {
        CultivationClientData.spiritPowerMax = spiritPowerMax;
    }

    public static float getTruePower() {
        return truePower;
    }

    public static void setTruePower(float truePower) {
        CultivationClientData.truePower = truePower;
    }

    public static float getTruePowerMax() {
        return truePowerMax;
    }

    public static void setTruePowerMax(float truePowerMax) {
        CultivationClientData.truePowerMax = truePowerMax;
    }

    public static float getTunNaTick() {
        return tunNaTick;
    }

    public static void setTunNaTick(float tunNaTick) {
        CultivationClientData.tunNaTick = tunNaTick;
    }

    //天地灵气
    public static byte getDensityTier() {
        return densityTier;
    }

    public static void setDensityTier(byte densityTier) {
        CultivationClientData.densityTier = densityTier;
    }

    public static float getCurrentValue() {
        return currentValue;
    }

    public static void setCurrentValue(float currentValue) {
        CultivationClientData.currentValue = currentValue;
    }
}
