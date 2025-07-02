package com.shengchanshe.chang_sheng_jue.capability.cultivation.entity;

public enum SpiritRootType {
    METAL("金灵根"),    // 金灵根
    WOOD("木灵根"),      // 木灵根
    WATER("水灵根"),     // 水灵根
    FIRE("火灵根"),     // 火灵根
    EARTH("土灵根");    // 土灵根

    private final String name;

    SpiritRootType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
