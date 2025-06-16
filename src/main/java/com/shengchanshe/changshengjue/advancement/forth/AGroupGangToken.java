package com.shengchanshe.changshengjue.advancement.forth;

import com.google.gson.JsonObject;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class AGroupGangToken extends SimpleCriterionTrigger<AGroupGangToken.TriggerInstance> {
    // 定义触发器的唯一标识符
    static final ResourceLocation ID = new ResourceLocation(ChangShengJue.MOD_ID, "agroupgangtoken");

    // 返回触发器的唯一标识符
    public ResourceLocation getId() {
        return ID;
    }

    // 创建触发器实例，用于反序列化
    public AGroupGangToken.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext context) {
        return new AGroupGangToken.TriggerInstance(predicate);
    }


    public void trigger(ServerPlayer player) {
        this.trigger(player, (p_160394_) -> {
            return true;
        });
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance {
        public TriggerInstance(ContextAwarePredicate p_286351_) {
            super(AGroupGangToken.ID, p_286351_);
        }

        public static AGroupGangToken.TriggerInstance createInstance() {
            return new AGroupGangToken.TriggerInstance(ContextAwarePredicate.ANY);
        }

    }
}