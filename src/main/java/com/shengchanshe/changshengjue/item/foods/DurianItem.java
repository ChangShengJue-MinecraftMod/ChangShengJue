package com.shengchanshe.changshengjue.item.foods;

import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DurianItem extends Item {
    public DurianItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        ItemStack offhandStack = player.getOffhandItem();
        if (offhandStack.getItem() instanceof AxeItem) {
            itemstack.shrink(1);
            offhandStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            player.addItem(ChangShengJueItems.OPEN_DURIAN.get().getDefaultInstance());
            return InteractionResultHolder.success(itemstack);
        }
        return super.use(level, player, hand);
    }
}
