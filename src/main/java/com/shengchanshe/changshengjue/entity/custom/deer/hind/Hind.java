package com.shengchanshe.changshengjue.entity.custom.deer.hind;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.changshengjue.entity.custom.deer.stag.Stag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;

import javax.annotation.Nullable;

public class Hind extends AbstractDeer implements GeoEntity {
    public Hind(EntityType<? extends Hind> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }


    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D, Stag.class));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return ChangShengJueEntity.HIND.get().create(level);
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