package com.shengchanshe.changshengjue.entity.combat.stakes;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.combat.book.*;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;

public class StakesEntity extends Mob {
    public StakesEntity(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,1D)
                .add(Attributes.MOVEMENT_SPEED,0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE,1)
                .add(Attributes.FLYING_SPEED,0.6).build();
    }
    public void kill() {
        this.remove(RemovalReason.KILLED);
        this.gameEvent(GameEvent.ENTITY_DIE);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        Level level = this.level();
        if (!level.isClientSide && !this.isRemoved()) {
            Entity entity = pSource.getEntity();
            if (entity instanceof Player && entity.isShiftKeyDown()){
                this.brokenByPlayer(pSource);
                this.showBreakingParticles();
                this.kill();
                return true; // 实体对所有伤害免疫
            }else {
                GeShanDaNiu.comprehend(entity,level);
                GoldenBellJar.comprehend(entity,level);
                Hercules.comprehend(entity,level);
                ImmortalMiracle.comprehend(entity,level);
                QianKunDaNuoYi.comprehend(entity,level);
                SunflowerPointCaveman.comprehend(entity,level);
                TheClassicsOfTendonChanging.comprehend(entity,level);
                WuGangCutGui.comprehend(entity,level);
                YugongMovesMountains.comprehend(entity,level);
                Paoding.comprehend(entity,level);
                TurtleBreathWork.comprehend(entity,level);
                TreadTheSnowWithoutTrace.comprehend(entity,level);
                return false;
            }
        } else {
            return false;
        }
    }

    private void showBreakingParticles() {
        if (this.level() instanceof ServerLevel) {
            ((ServerLevel)this.level()).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.OAK_PLANKS.defaultBlockState()),
                    this.getX(), this.getY(0.6666666666666666), this.getZ(), 10, (double)(this.getBbWidth() / 4.0F), (double)(this.getBbHeight() / 4.0F), (double)(this.getBbWidth() / 4.0F), 0.05);
        }
    }
    private void brokenByPlayer(DamageSource pDamageSource) {
        this.brokenByAnything(pDamageSource);
    }

    private void brokenByAnything(DamageSource pDamageSource) {
        this.dropAllDeathLoot(pDamageSource);
    }
}
