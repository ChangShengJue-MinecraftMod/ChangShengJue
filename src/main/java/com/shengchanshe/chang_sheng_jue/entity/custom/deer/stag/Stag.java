package com.shengchanshe.chang_sheng_jue.entity.custom.deer.stag;

import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.AbstractDeer;
import com.shengchanshe.chang_sheng_jue.entity.custom.deer.hind.Hind;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;

import javax.annotation.Nullable;

public class Stag extends AbstractDeer implements GeoEntity {
    public Stag(EntityType<? extends Stag> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.6D, Hind.class));
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return ChangShengJueEntity.STAG.get().create(level);
    }

    @Override
    public boolean canMate(Animal animal) {
        if (animal == this) {
            return false;
        } else if (!(animal instanceof Hind)) {
            return false;
        }else {
            return true;
        }
    }
}