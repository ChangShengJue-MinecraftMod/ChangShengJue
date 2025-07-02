package com.shengchanshe.chang_sheng_jue.item.foods;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class PorcelainPlatesFoodItem extends BlockItem {

    public PorcelainPlatesFoodItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        ItemStack itemstack = super.finishUsingItem(pStack, pLevel, pEntityLiving);
        return pEntityLiving instanceof Player && ((Player)pEntityLiving).getAbilities().instabuild ? itemstack : new ItemStack(ChangShengJueItems.CI_PAN.get());
    }
}
