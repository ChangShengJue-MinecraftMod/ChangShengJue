package com.shengchanshe.changshengjue.item.combat.stakes;

import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Stakes extends Item {
    public Stakes() {
        super(new Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        if (!level.isClientSide){
            StakesEntity stakesEntity =new StakesEntity(ChangShengJueEntity.STAKES.get(), level);
            stakesEntity.moveTo(pContext.getClickedPos().above(1).getCenter());
            level.addFreshEntity(stakesEntity);
            if (!pContext.getPlayer().getAbilities().instabuild) {
                pContext.getItemInHand().shrink(1);
            }
        }
        return super.useOn(pContext);
    }
}
