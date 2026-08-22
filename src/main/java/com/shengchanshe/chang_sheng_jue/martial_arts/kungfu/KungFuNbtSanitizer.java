package com.shengchanshe.chang_sheng_jue.martial_arts.kungfu;

import net.minecraft.util.Mth;

public final class KungFuNbtSanitizer {
    private KungFuNbtSanitizer() {
    }

    public static int bounded(int value, int maximum) {
        return Mth.clamp(value, 0, Math.max(0, maximum));
    }

    public static float nonNegativeFinite(float value, float fallback) {
        float safeFallback = Float.isFinite(fallback) ? Math.max(0.0F, fallback) : 0.0F;
        return Float.isFinite(value) ? Math.max(0.0F, value) : safeFallback;
    }

    public static float probability(float value, float fallback) {
        float safeFallback = Float.isFinite(fallback) ? Mth.clamp(fallback, 0.0F, 1.0F) : 0.0F;
        return Float.isFinite(value) ? Mth.clamp(value, 0.0F, 1.0F) : safeFallback;
    }
}
