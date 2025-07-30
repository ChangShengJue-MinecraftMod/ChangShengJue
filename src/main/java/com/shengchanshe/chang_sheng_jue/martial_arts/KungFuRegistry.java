package com.shengchanshe.chang_sheng_jue.martial_arts;

import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.external_kunfu.*;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.*;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.WheatNuggetEncyclopedia;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.mental_kungfu.ZhangMenXinXue;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class KungFuRegistry {
    // 使用 ConcurrentHashMap 保证线程安全
    private final Map<String, Supplier<IKungFu>> registry = new ConcurrentHashMap<>();

    // 私有化构造器
    private KungFuRegistry() {
        registerDefaults();
    }

    // 使用 Holder 模式替代静态 INSTANCE
    private static final class Holder {
        static final KungFuRegistry INSTANCE = new KungFuRegistry();
    }

    public static KungFuRegistry getInstance() {
        return Holder.INSTANCE;
    }

    // 注册武功（使用 Supplier 延迟创建）
    public void register(String id, Supplier<IKungFu> supplier) {
        registry.put(id, supplier);
    }

    // 获取武功（每次返回新实例）
    public Optional<IKungFu> getKungFu(String id) {
        return Optional.ofNullable(registry.get(id)).map(Supplier::get);
    }

    // 注册默认武功
    private void registerDefaults() {
        register(DuguNineSwords.KUNG_FU_ID.toString(), DuguNineSwords::new);
        register(GaoMarksmanship.KUNG_FU_ID.toString(), GaoMarksmanship::new);
        register(GeShanDaNiu.KUNG_FU_ID.toString(), GeShanDaNiu::new);
        register(GoldenBlackKnifeMethod.KUNG_FU_ID.toString(), GoldenBlackKnifeMethod::new);
        register(ShaolinStickMethod.KUNG_FU_ID.toString(), ShaolinStickMethod::new);
        register(SunflowerPointCaveman.KUNG_FU_ID.toString(), SunflowerPointCaveman::new);
        register(TurtleBreathWork.KUNG_FU_ID.toString(), TurtleBreathWork::new);
        register(XuannuSwordsmanship.KUNG_FU_ID.toString(), XuannuSwordsmanship::new);
        register(RelentlessThrowingKnives.KUNG_FU_ID.toString(), RelentlessThrowingKnives::new);
        register(GoldenBellJar.KUNG_FU_ID.toString(), GoldenBellJar::new);
        register(Hercules.KUNG_FU_ID.toString(), Hercules::new);
        register(ImmortalMiracle.KUNG_FU_ID.toString(), ImmortalMiracle::new);
        register(QianKunDaNuoYi.KUNG_FU_ID.toString(), QianKunDaNuoYi::new);
        register(TheClassicsOfTendonChanging.KUNG_FU_ID.toString(), TheClassicsOfTendonChanging::new);
        register(Paoding.KUNG_FU_ID.toString(), Paoding::new);
        register(WuGangCutGui.KUNG_FU_ID.toString(), WuGangCutGui::new);
        register(YugongMovesMountains.KUNG_FU_ID.toString(), YugongMovesMountains::new);
        register(WheatNuggetEncyclopedia.KUNG_FU_ID.toString(), WheatNuggetEncyclopedia::new);
        register(ZhangMenXinXue.KUNG_FU_ID.toString(), ZhangMenXinXue::new);
        register(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString(), TreadTheSnowWithoutTrace::new);
        // 其他武功...
    }

    // 安全获取所有武功ID（用于命令补全等）
    public Set<String> getAllKungFuIds() {
        return Collections.unmodifiableSet(registry.keySet());
    }

}
