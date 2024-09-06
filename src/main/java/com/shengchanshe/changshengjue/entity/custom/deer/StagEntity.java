package com.shengchanshe.changshengjue.entity.custom.deer;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;

public class StagEntity extends AbstractDeer implements GeoEntity {
    public StagEntity(EntityType<? extends StagEntity> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }
    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof HindEntity)) {
            return false;
        }else {
            return true;
        }
    }
}