package com.shengchanshe.chang_sheng_jue.util;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public final class TooltipInput {
    private static volatile BooleanSupplier shiftDown = () -> false;

    private TooltipInput() {
    }

    public static boolean isShiftDown() {
        return shiftDown.getAsBoolean();
    }

    static void installShiftStateSupplier(BooleanSupplier supplier) {
        shiftDown = Objects.requireNonNull(supplier);
    }
}
