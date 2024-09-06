package com.shengchanshe.changshengjue.entity.custom.peacock;

import java.util.Arrays;
import java.util.Comparator;

public enum PeacockVariant {
    MALE(0),WHITE(1);

    private static final PeacockVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparing(PeacockVariant::getId)).toArray(PeacockVariant[]::new);
    private final int id;
    PeacockVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static PeacockVariant getById(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
