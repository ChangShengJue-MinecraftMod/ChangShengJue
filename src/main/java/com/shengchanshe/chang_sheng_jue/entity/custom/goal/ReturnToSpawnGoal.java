package com.shengchanshe.chang_sheng_jue.entity.custom.goal;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class ReturnToSpawnGoal extends Goal {
    private final AbstractVillager mob;
    private final double speedModifier;
    private final int maxDistance;
    private final int cooldown;
    private BlockPos spawnPos;
    private int timeToRecalcPath;
    private int cooldownTimer;

    public ReturnToSpawnGoal(AbstractVillager mob, double speed, int maxDist, int cooldownTicks) {
        this.mob = mob;
        this.speedModifier = speed;
        this.maxDistance = maxDist;
        this.cooldown = cooldownTicks;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (this.mob.level().isClientSide) return false;

        // 初始化生成点（仅首次调用时）
        if (this.spawnPos == null) {
            this.spawnPos = this.mob.blockPosition();
        }

        // 检查是否超出范围或冷却结束
        boolean tooFar = this.mob.distanceToSqr(
                Vec3.atCenterOf(this.spawnPos)
        ) > (maxDistance * maxDistance);

        return tooFar || (cooldownTimer > 0 && --cooldownTimer <= 0);
    }

    @Override
    public void start() {
        this.timeToRecalcPath = 0;
        this.cooldownTimer = this.cooldown; // 重置冷却
    }

    @Override
    public void tick() {
        // 每3秒重新计算路径
        if (--this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 60;
            this.mob.getNavigation().moveTo(
                    this.spawnPos.getX() + 0.5,
                    this.spawnPos.getY(),
                    this.spawnPos.getZ() + 0.5,
                    this.speedModifier
            );
        }

        // 到达生成点后停留
        if (this.mob.distanceToSqr(Vec3.atCenterOf(this.spawnPos)) < 2.0) {
            this.mob.getNavigation().stop();
        }
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }
}
