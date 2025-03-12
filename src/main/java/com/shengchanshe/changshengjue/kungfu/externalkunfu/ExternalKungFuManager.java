package com.shengchanshe.changshengjue.kungfu.externalkunfu;

import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cow;

import java.util.*;

public class ExternalKungFuManager {
    private final Map<ExternalKungFu, ExternalKungFuCapability> kungFuCapabilities = new HashMap<>();

    public ExternalKungFuManager() {
        // 初始化每种武功的能力
        kungFuCapabilities.put(ExternalKungFu.DUGU_NINE_SWORDS, new DuguNineSwords());
        kungFuCapabilities.put(ExternalKungFu.GAO_MARKSMANSHIP, new GaoMarksmanship());
        kungFuCapabilities.put(ExternalKungFu.GOLDEN_BLACK_KNIFE_METHOD, new GoldenBlackKnifeMethod());
        kungFuCapabilities.put(ExternalKungFu.RELENTLESS_THROWING_KNIVES, new RelentlessThrowingKnives());
        kungFuCapabilities.put(ExternalKungFu.SHAOLIN_STICK_METHOD, new ShaolinStickMethod());
        kungFuCapabilities.put(ExternalKungFu.XUANNU_SWORDSMANSHIP, new XuannuSwordsmanship());
        kungFuCapabilities.put(ExternalKungFu.GE_SHAN_DA_NIU, new GeShanDaNiu());
    }

    // 从 NBT 数据中创建 KungFuCapability 实例
    public static ExternalKungFuCapability createExternalKungFuCapabilityFromTag(String kungFuType) {
        return switch (kungFuType) {
            case "DuguNineSwords" -> new DuguNineSwords();
            case "GaoMarksmanship" -> new GaoMarksmanship();
            case "GoldenBlackKnifeMethod" -> new GoldenBlackKnifeMethod();
            case "RelentlessThrowingKnives" -> new RelentlessThrowingKnives();
            case "ShaolinStickMethod" -> new ShaolinStickMethod();
            case "XuannuSwordsmanship" -> new XuannuSwordsmanship();
            case "GeShanDaNiu" -> new GeShanDaNiu();
            default -> null;
        };
    }

    public ExternalKungFuCapability getRandomExternalKungFuCapability(LivingEntity entity) {
        Random random = new Random();
        List<ExternalKungFu> availableKungFus = new ArrayList<>(Arrays.asList(ExternalKungFu.values()));

        // 如果实体不是牛，则从可用武功中移除RelentlessThrowingKnives
        if (!(entity instanceof Cow)) {
            availableKungFus.remove(ExternalKungFu.RELENTLESS_THROWING_KNIVES);
        }

//        if (random.nextFloat() < 0.75F) { // 75% 的概率
        ExternalKungFu randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
        return kungFuCapabilities.get(randomKungFu);
//        } else {
//            return null; // 25% 的概率返回 null
//        }
    }
}
