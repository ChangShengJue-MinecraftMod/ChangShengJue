package com.shengchanshe.changshengjue.entity.custom.peacock.egg;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.custom.peacock.AbstractPeacock;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

import java.util.Random;

public class PeacockEgg extends ThrowableItemProjectile {

    public PeacockEgg(EntityType<? extends ThrowableItemProjectile> p_37442_, Level p_37443_) {
        super(p_37442_, p_37443_);
    }

    public PeacockEgg(Level p_37481_, LivingEntity p_37482_) {
        super(ChangShengJueEntity.PEACOCK_EGG.get(), p_37482_, p_37481_);
    }
    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }
    }

    @Override
    protected void onHit(HitResult p_37488_) {
        if (!this.level().isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    AbstractPeacock peacock = (new Random().nextInt(2)+1) > 1 ? ChangShengJueEntity.FEMALE_PEACOCK.get().create(this.level()) : ChangShengJueEntity.MALE_PEACOCK.get().create(this.level());
                    peacock.setAge(-24000);
                    peacock.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                    this.level().addFreshEntity(peacock);
                }
            }

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

    @Override
    protected Item getDefaultItem() {
        return ChangShengJueItems.PEACOCK_EGGS.get();
    }
}
