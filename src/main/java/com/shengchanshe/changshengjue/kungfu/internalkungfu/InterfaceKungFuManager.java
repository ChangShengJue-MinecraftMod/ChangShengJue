package com.shengchanshe.changshengjue.kungfu.internalkungfu;

import com.shengchanshe.changshengjue.kungfu.internalkungfu.kungfu.*;

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
        kungFuCapabilities.put(InternalKungFu.TURTLE_BREATH_WORK, new TurtleBreathWork());
        kungFuCapabilities.put(InternalKungFu.THE_CLASSICS_OF_TENDON_CHANGING, new TheClassicsOfTendonChanging());
    }

    public static InternalKungFuCapability createInterfaceKungFuCapabilityFromTag(String kungFuType) {
        return switch (kungFuType) {
            case "GoldenBellJar" -> new GoldenBellJar();
            case "ImmortalMiracle" -> new ImmortalMiracle();
            case "QianKunDaNuoYi" -> new QianKunDaNuoYi();
            case "TurtleBreathWork" -> new TurtleBreathWork();
            case "TheClassicsOfTendonChanging" -> new TheClassicsOfTendonChanging();
            default -> null;
        };
    }

    public InternalKungFuCapability getRandomInterfaceKungFuCapability() {
        Random random = new Random();
        InternalKungFu randomKungFu = InternalKungFu.values()[random.nextInt(InternalKungFu.values().length)];
        return kungFuCapabilities.get(randomKungFu);
    }
}
