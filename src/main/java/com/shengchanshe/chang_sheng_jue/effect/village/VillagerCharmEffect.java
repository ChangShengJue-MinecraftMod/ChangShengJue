package com.shengchanshe.chang_sheng_jue.effect.village;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.gossip.GossipType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;

public class VillagerCharmEffect extends MobEffect {
    public VillagerCharmEffect() {
        super(MobEffectCategory.BENEFICIAL, ChatFormatting.GREEN.getColor());
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            // 每10秒刷新一次好感度（防止其他系统修改）
            if (player.level().getGameTime() % 100 == 0) {
                updateVillagerReputation(player);
            }
        }
    }

    private void updateVillagerReputation(Player player) {
        player.level().getEntitiesOfClass(
                Villager.class,
                player.getBoundingBox().inflate(32), // 32格范围
                v -> true
        ).forEach(villager -> {
            villager.getGossips().add(player.getUUID(), GossipType.MAJOR_POSITIVE, 100);
            villager.getGossips().add(player.getUUID(), GossipType.MINOR_POSITIVE, 200);
        });
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true; // 每tick都生效
    }
}