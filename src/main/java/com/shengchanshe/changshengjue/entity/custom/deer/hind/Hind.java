package com.shengchanshe.changshengjue.entity.custom.deer.hind;

import com.shengchanshe.changshengjue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.changshengjue.entity.custom.deer.stag.Stag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;

public class Hind extends AbstractDeer implements GeoEntity {
    public Hind(EntityType<? extends Hind> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof Stag)) {
            return false;
        }else {
            return true;
        }
    }
}