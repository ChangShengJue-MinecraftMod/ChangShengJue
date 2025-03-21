package com.shengchanshe.changshengjue.advancement.hasitem;

import com.google.gson.JsonObject;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class HasTea extends SimpleCriterionTrigger<HasTea.TriggerInstance> {
    // 定义触发器的唯一标识符
    static final ResourceLocation ID = new ResourceLocation(ChangShengJue.MOD_ID, "hastea");

    // 返回触发器的唯一标识符
    public ResourceLocation getId() {
        return ID;
    }

    // 创建触发器实例，用于反序列化
    public HasTea.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext context) {
        return new HasTea.TriggerInstance(predicate);
    }


    public void trigger(ServerPlayer player) {
        this.trigger(player, (p_160394_) -> {
            return true;
        });
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        public TriggerInstance(ContextAwarePredicate p_286351_) {
            super(HasTea.ID, p_286351_);
        }

        public static HasTea.TriggerInstance createInstance() {
            return new HasTea.TriggerInstance(ContextAwarePredicate.ANY);
        }

    }
}
