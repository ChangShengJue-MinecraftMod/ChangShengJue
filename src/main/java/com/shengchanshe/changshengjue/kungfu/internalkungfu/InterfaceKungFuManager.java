package com.shengchanshe.changshengjue.kungfu.internalkungfu;

import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.GoldenBellJar;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.ImmortalMiracle;
import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.QianKunDaNuoYi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InterfaceKungFuManager {
    private final Map<InternalKungFu, InternalKungFuCapability> kungFuCapabilities = new HashMap<>();

    public InterfaceKungFuManager() {
        // 初始化每种武功的能力
        kungFuCapabilities.put(InternalKungFu.GOLDEN_BELL_JAR, new GoldenBellJar());
        kungFuCapabilities.put(InternalKungFu.IMMORTAL_MIRACLE, new ImmortalMiracle());
        kungFuCapabilities.put(InternalKungFu.QIAN_KUN_DA_NUO_YI, new QianKunDaNuoYi());
    }

    public static InternalKungFuCapability createInterfaceKungFuCapabilityFromTag(String kungFuType) {
        return switch (kungFuType) {
            case "GoldenBellJar" -> new GoldenBellJar();
            case "ImmortalMiracle" -> new ImmortalMiracle();
            case "QianKunDaNuoYi" -> new QianKunDaNuoYi();
            default -> null;
        };
    }

    public InternalKungFuCapability getRandomInterfaceKungFuCapability() {
        Random random = new Random();
        InternalKungFu randomKungFu = InternalKungFu.values()[random.nextInt(InternalKungFu.values().length)];
        return kungFuCapabilities.get(randomKungFu);
    }
}
