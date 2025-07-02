package com.shengchanshe.chang_sheng_jue.advancement.first;

import com.google.gson.JsonObject;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class MiChangSheng extends SimpleCriterionTrigger<MiChangSheng.TriggerInstance> {
    // 定义触发器的唯一标识符
    static final ResourceLocation ID = new ResourceLocation(ChangShengJue.MOD_ID, "michangsheng");

    // 返回触发器的唯一标识符
    public ResourceLocation getId() {
        return ID;
    }

    // 创建触发器实例，用于反序列化
    public MiChangSheng.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext context) {
        return new MiChangSheng.TriggerInstance(predicate);
    }

    // 触发触发器，当玩家满足条件时调用
    public void trigger(ServerPlayer player) {
        this.trigger(player, (p_160394_) -> {
            return true;
        });
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        public TriggerInstance(ContextAwarePredicate p_286351_) {
            super(MiChangSheng.ID, p_286351_);
        }

        public static MiChangSheng.TriggerInstance createInstance() {
            return new MiChangSheng.TriggerInstance(ContextAwarePredicate.ANY);
        }

    }
}
