package com.shengchanshe.chang_sheng_jue.entity.custom.goal;

import com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.AbstractWuXia;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class WuXiaAttackGoal extends MeleeAttackGoal {
    public AbstractWuXia wuxia;
    private int attackDelay = 10;//攻击延迟
    private int ticksUntilNextAttack = 10;//直到下一次攻击计时
    private boolean shouldCountTillNextAttack = false;
    public WuXiaAttackGoal(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        wuxia = (AbstractWuXia)pMob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 10;
        ticksUntilNextAttack = 10;
    }
    @Override
    public double getAttackReachSqr(LivingEntity pAttackTarget) {
        return (double)(this.mob.getBbWidth() * 3.0F * this.mob.getBbWidth() * 3.0F + pAttackTarget.getBbWidth());
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) {
        if (isEnemyWithinAttackDistance(pEnemy, pDistToEnemySqr)) {
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()) {
                wuxia.setAttacking(true);
            }

            if(isTimeToAttack()) {
                this.mob.getLookControl().setLookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            wuxia.setAttacking(false);
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
        return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation() {
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected int getTicksUntilNextAttack() {
        return this.ticksUntilNextAttack;
    }


    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swing(InteractionHand.MAIN_HAND);
        this.mob.doHurtTarget(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        wuxia.setAttacking(false);
        super.stop();
    }
}
