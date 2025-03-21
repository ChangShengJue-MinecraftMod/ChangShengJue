package com.shengchanshe.changshengjue.init;

import com.shengchanshe.changshengjue.advancement.hasitem.*;
import com.shengchanshe.changshengjue.advancement.MiChangSheng;
import com.shengchanshe.changshengjue.advancement.usesth.LearnWaiGong;
import com.shengchanshe.changshengjue.advancement.usesth.UseWaiGong;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;

public class CSJAdvanceInit {
    public static final MiChangSheng michangsheng = CriteriaTriggers.register(new MiChangSheng());
    public static final HasMiFan hasmifan = CriteriaTriggers.register(new HasMiFan());
    public static final HasLichee haslichee = CriteriaTriggers.register(new HasLichee());
    public static final HasTea hastea = CriteriaTriggers.register(new HasTea());
    public static final HasWine haswine = CriteriaTriggers.register(new HasWine());
    public static final HasTomatoEgg hastomatoegg = CriteriaTriggers.register(new HasTomatoEgg());
    public static final HasBronzeSword hasbrozesword = CriteriaTriggers.register(new HasBronzeSword());
    public static final HasSword hassword = CriteriaTriggers.register(new HasSword());

    public static final UseWaiGong usewaigong = CriteriaTriggers.register(new UseWaiGong());

    public static final LearnWaiGong learnwaigong = CriteriaTriggers.register(new LearnWaiGong());


}
