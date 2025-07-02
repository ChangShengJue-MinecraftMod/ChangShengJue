package com.shengchanshe.chang_sheng_jue.capability.cultivation.entity;

public enum CultivationStage {
    MORTAL("凡人", 0.0f,0.0f,100.0f,1000.0f,
            0.21f,0.1f, 0){
        @Override
        public boolean canAdvance(float truePower){
            return super.canAdvance(truePower);
        }
    },
    QI_CONDENSATION("炼气期", 2000.0f,200000.0f, 200.0f,2000.0f,
            0.21f,0.1f, 120) {
        @Override
        public boolean canAdvance(float truePower){
            return super.canAdvance(truePower);
        }
    },
    FOUNDATION("筑基期", 30000.0f,3000000.0f,300.0f,
            3000.0f, 0.21f,0.1f, 120) {
        @Override
        public boolean canAdvance(float truePower){
            return super.canAdvance(truePower);
        }
    },
    CORE_FORMATION("结丹期", 500000.0f,50000000.0f,500.0f,
            5000.0f, 0.21f,0.1f, 220) {
        @Override
        public boolean canAdvance(float truePower){
            return super.canAdvance(truePower);
        }
    },
    NASCENT_SOUL("元婴期", 10000000.0f,1000000000.0f,1000.0f,
            10000.0f, 0.21f,0.1f, 280) {
        @Override
        public boolean canAdvance(float truePower){
            return super.canAdvance(truePower);
        }
    },
    DEITY_TRANSFORMATION("化神期", 2000000000.0f,200000000000.0f,2000.0f,
            20000.0f, 0.21f,0.1f, 300) {
        @Override
        public boolean canAdvance(float truePower){
            return super.canAdvance(truePower);
        }
    };

    private final String name;//境界名称
    private final float requiredTruePower;//所需进阶的真元
    private final float defaultSpiritPowerMax;//默认灵力上限
    private final float absorbSpiritPowerMax;//每次聚气上限
    private final float transformedSpiritPowerMax;//每次转化真元的灵力上限
    private final float defaultTunNaEfficiency;//默认吐纳效率
    private final float defaultSeclusionEfficiency;//默认闭关效率
    private final int breakthroughTick;// 突破时间

    CultivationStage(String name, float requiredZhenYuan, float defaultSpiritPowerMax, float absorbSpiritPowerMax,
                     float transformedSpiritPowerMax, float defaultTunNaEfficiency, float defaultSeclusionEfficiency, int breakthroughTick) {
        this.name = name;
        this.requiredTruePower = requiredZhenYuan;
        this.defaultSpiritPowerMax = defaultSpiritPowerMax;
        this.absorbSpiritPowerMax = absorbSpiritPowerMax;
        this.transformedSpiritPowerMax = transformedSpiritPowerMax;
        this.defaultTunNaEfficiency = defaultTunNaEfficiency;
        this.defaultSeclusionEfficiency = defaultSeclusionEfficiency;
        this.breakthroughTick = breakthroughTick;
    }

    public String getName(float truePower, CultivationStage stage) {
        CultivationStage[] stages = CultivationStage.values();
        int ordinal = stage.ordinal();
        if (ordinal >= stages.length - (stages.length - 1)) {
            if (truePower < stage.getRequiredTruePower() * 0.34) {
                return name + "初期";
            } else if (truePower >= stage.getRequiredTruePower() * 0.34
                    && truePower < stage.getRequiredTruePower() * 0.67) {
                return name + "中期";
            } else if (truePower >= stage.getRequiredTruePower() * 0.67
                    && truePower < stage.getRequiredTruePower() * 1) {
                return name + "后期";
            } else if (truePower >= stage.getRequiredTruePower() * 1) {
                return name + "圆满";
            }
        }
        return name;
    }

    public boolean canAdvance(float truePower){
        return truePower >= requiredTruePower;
    }

    public float getDefaultSpiritPowerMax() {
        return defaultSpiritPowerMax;
    }

    public float getRequiredTruePower() {
        return requiredTruePower;
    }

    public float getAbsorbSpiritPowerMax() {
        return absorbSpiritPowerMax;
    }

    public float getTransformedSpiritPowerMax() {
        return transformedSpiritPowerMax;
    }

    public float getDefaultTunNaEfficiency() {
        return defaultTunNaEfficiency;
    }

    public float getDefaultSeclusionEfficiency() {
        return defaultSeclusionEfficiency;
    }

    public int getBreakthroughTick() {
        return breakthroughTick;
    }
}
