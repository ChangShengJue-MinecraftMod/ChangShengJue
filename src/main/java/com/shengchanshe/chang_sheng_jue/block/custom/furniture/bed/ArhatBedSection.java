package com.shengchanshe.chang_sheng_jue.block.custom.furniture.bed;

import net.minecraft.util.StringRepresentable;

public enum ArhatBedSection implements StringRepresentable {
    HEAD("head"),
    BODY("body"),
    FOOT("foot");

    private final String name;

    ArhatBedSection(String pName) {
        this.name = pName;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
