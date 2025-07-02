package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader;

import java.util.Arrays;
import java.util.Comparator;

public enum GangleaderVariant {
    TEXTURES_0(0),TEXTURES_1(1),TEXTURES_2(2);

    private static final GangleaderVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparing(GangleaderVariant::getId)).toArray(GangleaderVariant[]::new);
    private final int id;
    GangleaderVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static GangleaderVariant getById(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
