package com.shengchanshe.changshengjue.entity.villagers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class DefendVillageTargetGoal  extends TargetGoal {
    private final ChangShengJueHunterEntity hunterEntity;
    @Nullable
    private LivingEntity potentialTarget;
    private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);

    public DefendVillageTargetGoal(ChangShengJueHunterEntity hunterEntity) {
        super(hunterEntity, false, true);
        this.hunterEntity = hunterEntity;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        AABB aabb = this.hunterEntity.getBoundingBox().inflate(10.0D, 8.0D, 10.0D);
        List<? extends LivingEntity> list = this.hunterEntity.level().getNearbyEntities(Villager.class, this.attackTargeting, this.hunterEntity, aabb);
        List<Player> list1 = this.hunterEntity.level().getNearbyPlayers(this.attackTargeting, this.hunterEntity, aabb);

        for(LivingEntity livingentity : list) {
            Villager villager = (Villager)livingentity;

            for(Player player : list1) {
                int i = villager.getPlayerReputation(player);
                if (i <= -100) {
                    this.potentialTarget = player;
                }
            }
        }

        if (this.potentialTarget == null) {
            return false;
        } else {
            return !(this.potentialTarget instanceof Player) || !this.potentialTarget.isSpectator() && !((Player)this.potentialTarget).isCreative();
        }
    }

    public void start() {
        this.hunterEntity.setTarget(this.potentialTarget);
        super.start();
    }
}