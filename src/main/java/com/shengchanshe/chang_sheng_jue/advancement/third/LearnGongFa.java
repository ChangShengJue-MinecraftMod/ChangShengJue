package com.shengchanshe.chang_sheng_jue.advancement.third;

import com.google.gson.JsonObject;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class LearnGongFa extends SimpleCriterionTrigger<LearnGongFa.TriggerInstance> {
    // 定义触发器的唯一标识符
    static final ResourceLocation ID = new ResourceLocation(ChangShengJue.MOD_ID, "learngongfa");

    // 返回触发器的唯一标识符
    public ResourceLocation getId() {
        return ID;
    }

    // 创建触发器实例，用于反序列化
    public LearnGongFa.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext context) {
        return new LearnGongFa.TriggerInstance(predicate);
    }


    public void trigger(ServerPlayer player) {
        this.trigger(player, (p_160394_) -> {
            return true;
        });
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        public TriggerInstance(ContextAwarePredicate p_286351_) {
            super(LearnGongFa.ID, p_286351_);
        }

        public static LearnGongFa.TriggerInstance createInstance() {
            return new LearnGongFa.TriggerInstance(ContextAwarePredicate.ANY);
        }

    }
}
