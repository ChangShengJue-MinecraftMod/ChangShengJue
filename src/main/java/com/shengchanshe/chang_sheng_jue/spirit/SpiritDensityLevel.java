package com.shengchanshe.chang_sheng_jue.spirit;

public enum SpiritDensityLevel {
    DEPLETED(0,4999,-0.2f,1,"枯竭"),
    SCARCE(5000,74999,-0.1f,2,"稀少"),
    NORMAL(75000,125000,0f,3,"普通"),
    ABUNDANT(125001,150000,0.1f,4, "充沛"),
    RICH(150001,200000,0.2f,5,"浓郁"),
    VEIN(200001,250000,0.3f,6,"灵脉");

    private final int min;
    private final int max;
    private final float efficiency;
    private final String name;
    private final byte tier;

    SpiritDensityLevel(int min, int max, float efficiency, int tier, String name) {
        this.min = min;
        this.max = max;
        this.efficiency = efficiency;
        this.tier = (byte) tier; // 确保用byte传输
        this.name = name;
    }
    public static SpiritDensityLevel getForValue(float value) {
        for (SpiritDensityLevel level : values()) {
            if (value >= level.min && value <= level.max) return level;
        }
        return DEPLETED;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public String getName() {
        return name;
    }

    public byte getTier() {
        return tier;
    }
}