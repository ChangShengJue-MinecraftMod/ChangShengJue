package com.shengchanshe.changshengjue.kungfu.qinggong;

import com.shengchanshe.changshengjue.entity.custom.wuxia.assassin.Assassin;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFu;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.ExternalKungFuCapability;
import com.shengchanshe.changshengjue.kungfu.externalkunfu.kungfu.*;
import com.shengchanshe.changshengjue.kungfu.qinggong.kungfu.TreadTheSnowWithoutTrace;
import net.minecraft.world.entity.LivingEntity;

import java.util.*;

public class QingGongManager {
    private final Map<QingGong, QingGongCapability> kungFuCapabilities = new HashMap<>();

    public QingGongManager() {
        // 初始化每种武功的能力
        kungFuCapabilities.put(QingGong.TREAD_THE_SNOW_WITHOUT_TRACE, new TreadTheSnowWithoutTrace());
    }

    // 从 NBT 数据中创建 KungFuCapability 实例
    public static QingGongCapability createExternalKungFuCapabilityFromTag(String kungFuType) {
        return switch (kungFuType) {
            case "TreadTheSnowWithoutTrace" -> new TreadTheSnowWithoutTrace();
            default -> null;
        };
    }

    public QingGongCapability getRandomExternalKungFuCapability(LivingEntity entity) {
        Random random = new Random();
        List<QingGong> availableKungFus = new ArrayList<>(Arrays.asList(QingGong.values()));
        QingGong randomKungFu = availableKungFus.get(random.nextInt(availableKungFus.size()));
        return kungFuCapabilities.get(randomKungFu);
    }
}
