package com.shengchanshe.chang_sheng_jue.capability.cultivation.entity;

public enum HeartRealm {
    // 格式: 最小点数 | 中文名 | 每100点增益 | 下一阶段阈值 | 当前阶段上限
    DISTRACTED(0, "心烦意乱", 0.01f, 100, 100) {
        @Override
        public boolean canReach(int points, CultivationStage playerStage) {
            return playerStage == CultivationStage.QI_CONDENSATION;
        }
    },
    CALM(100, "神静心安", 0.01f, 200, 200) {
        @Override
        public boolean canReach(int points, CultivationStage playerStage) {
            return playerStage == CultivationStage.FOUNDATION;
        }
    },
    UNMOVED(200, "古井不波", 0.02f, 500, 500) {
        @Override
        public boolean canReach(int points, CultivationStage playerStage) {
            return playerStage == CultivationStage.CORE_FORMATION;
        }
    },
    DETACHED(500, "六情沉寂", 0.05f, 1000, 1000) {
        @Override
        public boolean canReach(int points, CultivationStage playerStage) {
            return playerStage == CultivationStage.NASCENT_SOUL;
        }
    },
    TRANSCENDENT(1500, "高超物外", 0.10f, 2000, 2000) {
        @Override
        public boolean canReach(int points, CultivationStage playerStage) {
            return playerStage == CultivationStage.DEITY_TRANSFORMATION && points >= 1500;
        }
    },
    UNIFIED(2000, "物我合一", 0.20f, Integer.MAX_VALUE, 2000) {
        @Override
        public boolean canReach(int points, CultivationStage playerStage) {
            return playerStage == CultivationStage.DEITY_TRANSFORMATION && points >= 2000;
        }
    };

    private final int minPoints;
    private final String chineseName;
    private final float efficiencyGainPer100;
    private final int nextThreshold;
    private final int stageCap;

    HeartRealm(int minPoints, String chineseName, float efficiencyGainPer100, int nextThreshold, int stageCap) {
        this.minPoints = minPoints;
        this.chineseName = chineseName;
        this.efficiencyGainPer100 = efficiencyGainPer100;
        this.nextThreshold = nextThreshold;
        this.stageCap = stageCap;
    }

    // 抽象方法：检查玩家当前境界是否可达此心境等级
    public abstract boolean canReach(int points, CultivationStage playerStage);

    // 根据点数获取对应等级（静态方法）
    public static HeartRealm getLevel(int points, CultivationStage playerStage) {
        // 倒序检查，返回符合条件的最高等级
        for (int i = values().length - 1; i >= 0; i--) {
            HeartRealm level = values()[i];
            if (points >= level.minPoints && level.canReach(points, playerStage)) {
                return level;
            }
        }
        return DISTRACTED;
    }

    // Getter 方法
    public int getMinPoints() { return minPoints; }
    public String getChineseName() { return chineseName; }
    public float getEfficiencyGainPer100() { return efficiencyGainPer100; }
    public int getNextThreshold() { return nextThreshold; }
    public int getStageCap() { return stageCap; }
}