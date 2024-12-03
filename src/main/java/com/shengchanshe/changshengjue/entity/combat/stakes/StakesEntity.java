package com.shengchanshe.changshengjue.entity.combat.stakes;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public class StakesEntity extends Mob {
    public StakesEntity(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH,1)
                .add(Attributes.MOVEMENT_SPEED,0.3)
                .add(Attributes.KNOCKBACK_RESISTANCE,1)
                .add(Attributes.FLYING_SPEED,0.6).build();
    }
}
