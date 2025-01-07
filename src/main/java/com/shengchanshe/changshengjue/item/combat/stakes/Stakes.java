package com.shengchanshe.changshengjue.item.combat.stakes;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Stakes extends Item {
    public Stakes() {
        super(new Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!level.isClientSide){
            var stakesEntityEntityType = ChangShengJueEntity.STAKES.get();
            Vec3 vec3 = Vec3.atBottomCenterOf(pContext.getClickedPos().above());
            StakesEntity stakesEntity =new StakesEntity(stakesEntityEntityType, level);
            stakesEntity.moveTo(vec3.x,vec3.y,vec3.z);
            level.addFreshEntity(stakesEntity);
            if (!pContext.getPlayer().getAbilities().instabuild) {
                pContext.getItemInHand().shrink(1);
            }
        }
        return super.useOn(pContext);
    }
}
