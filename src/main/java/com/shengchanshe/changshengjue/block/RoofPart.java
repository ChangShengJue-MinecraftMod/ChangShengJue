package com.shengchanshe.changshengjue.block;

import net.minecraft.util.StringRepresentable;

public enum RoofPart  implements StringRepresentable {
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom");

    private final String name;

    RoofPart(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
