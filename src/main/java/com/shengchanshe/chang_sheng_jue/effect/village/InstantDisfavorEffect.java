package com.shengchanshe.chang_sheng_jue.effect.village;

import net.minecraft.ChatFormatting;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.gossip.GossipType;
import net.minecraft.world.entity.npc.Villager;

public class InstantDisfavorEffect extends InstantenousMobEffect {
    public InstantDisfavorEffect() {
        super(MobEffectCategory.HARMFUL, ChatFormatting.GREEN.getColor());
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayer player) {
            affectNearbyVillagers(player, amplifier + 1); // amplifier决定影响范围倍数
        }
    }

    private void affectNearbyVillagers(ServerPlayer player, int rangeMultiplier) {
        int baseRange = 32; // 基础范围16格
        player.level().getEntitiesOfClass(
                Villager.class,
                player.getBoundingBox().inflate(baseRange * rangeMultiplier),
                v -> true
        ).forEach(villager -> {
            villager.getGossips().add(player.getUUID(), GossipType.MAJOR_NEGATIVE, 25 * rangeMultiplier);
            villager.getGossips().add(player.getUUID(), GossipType.MINOR_NEGATIVE, 25 * rangeMultiplier);
        });
    }
}
