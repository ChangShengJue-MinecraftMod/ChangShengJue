package com.shengchanshe.chang_sheng_jue.entity.custom.butterfly;

import java.util.Arrays;
import java.util.Comparator;

public enum ButterflyVariant {
    TEXTURES_0(0),TEXTURES_1(1),TEXTURES_2(2),TEXTURES_3(3);

    private static final ButterflyVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparing(ButterflyVariant::getId)).toArray(ButterflyVariant[]::new);
    private final int id;
    ButterflyVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ButterflyVariant getById(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
