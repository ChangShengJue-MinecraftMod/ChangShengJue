package com.shengchanshe.chang_sheng_jue.entity.villagers.worker;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.network.chat.Component;

public enum KilnWorkerTradeType {
    GRE("gre"),
    RED("red"),
    BLACK("black"),
    BLUE("blue"),
    GOLDEN("golden"),
    WOOD("wood");

    private final Component displayName;

    KilnWorkerTradeType(String translationSuffix) {
        this.displayName = Component.translatable("gui." + ChangShengJue.MOD_ID + ".trade." + translationSuffix);
    }

    public Component getDisplayName() {
        return displayName;
    }
}
