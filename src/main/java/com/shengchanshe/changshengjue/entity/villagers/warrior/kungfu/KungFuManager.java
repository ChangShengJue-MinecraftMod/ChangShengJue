package com.shengchanshe.changshengjue.entity.villagers.warrior.kungfu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class KungFuManager {
    private final Map<KungFu, KungFuCapability> kungFuCapabilities = new HashMap<>();

    public KungFuManager() {
        // 初始化每种武功的能力
        kungFuCapabilities.put(KungFu.DuguNineSwords, new DuguNineSwords());
        kungFuCapabilities.put(KungFu.GaoMarksmanship, new GaoMarksmanship());
        kungFuCapabilities.put(KungFu.GoldenBlackKnifeMethod, new GoldenBlackKnifeMethod());
        kungFuCapabilities.put(KungFu.RelentlessThrowingKnives, new RelentlessThrowingKnives());
        kungFuCapabilities.put(KungFu.ShaolinStickMethod, new ShaolinStickMethod());
        kungFuCapabilities.put(KungFu.XuannuSwordsmanship, new XuannuSwordsmanship());
        kungFuCapabilities.put(KungFu.GeShanDaNiu, new GeShanDaNiu());
        kungFuCapabilities.put(KungFu.GoldenBellJar, new GoldenBellJar());
        kungFuCapabilities.put(KungFu.ImmortalMiracle, new ImmortalMiracle());
        kungFuCapabilities.put(KungFu.QianKunDaNuoYi, new QianKunDaNuoYi());
    }

    // 获取指定武功的能力实例
    public KungFuCapability getKungFuCapability(KungFu kungFu) {
        return kungFuCapabilities.get(kungFu);
    }

    // 从 NBT 数据中创建 KungFuCapability 实例
    public static KungFuCapability createKungFuCapabilityFromNBT(String kungFuType) {
        return switch (kungFuType) {
            case "DuguNineSwords" -> new DuguNineSwords();
            case "GaoMarksmanship" -> new GaoMarksmanship();
            case "GoldenBlackKnifeMethod" -> new GoldenBlackKnifeMethod();
            case "RelentlessThrowingKnives" -> new RelentlessThrowingKnives();
            case "ShaolinStickMethod" -> new ShaolinStickMethod();
            case "XuannuSwordsmanship" -> new XuannuSwordsmanship();
            case "GeShanDaNiu" -> new GeShanDaNiu();
            case "GoldenBellJar" -> new GoldenBellJar();
            case "ImmortalMiracle" -> new ImmortalMiracle();
            case "QianKunDaNuoYi" -> new QianKunDaNuoYi();
            default -> null;
        };
    }

    public KungFuCapability getRandomKungFuCapability() {
        Random random = new Random();
        if (random.nextFloat() < 0.75F) { // 75% 的概率
            KungFu randomKungFu = KungFu.values()[random.nextInt(KungFu.values().length)];
            return kungFuCapabilities.get(randomKungFu);
        } else {
            return null; // 25% 的概率返回 null
        }
    }
}
