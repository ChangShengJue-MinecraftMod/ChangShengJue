package com.shengchanshe.chang_sheng_jue.block;

import net.minecraft.util.StringRepresentable;

public enum BigBlockType implements StringRepresentable {
    TOP_LEFT("top_left"),
    MIDDLE_LEFT("middle_left"),
    BOTTOM_LEFT("bottom_left"),
    TOP_RIGHT("top_right"),
    MIDDLE_RIGHT("middle_right"),
    BOTTOM_RIGHT("bottom_right");

    private final String name;

    BigBlockType(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
