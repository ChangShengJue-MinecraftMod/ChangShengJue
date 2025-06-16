package com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader;

import java.util.Arrays;
import java.util.Comparator;

public enum GangleaderVariant2 {
    TEXTURES_0(0),TEXTURES_1(1),TEXTURES_2(2),TEXTURES_3(3);

    private static final GangleaderVariant2[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparing(GangleaderVariant2::getId)).toArray(GangleaderVariant2[]::new);
    private final int id;

    GangleaderVariant2(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static GangleaderVariant2 getById(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
