package com.shengchanshe.chang_sheng_jue.item.foods;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.List;


public class DurianBlockItem extends BlockItem {
    public DurianBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        ItemStack offhandStack = player.getOffhandItem();
        if (offhandStack.getItem() instanceof AxeItem) {
            itemstack.shrink(1);
            offhandStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(hand));
            player.addItem(ChangShengJueItems.DURIAN_MEAT.get().getDefaultInstance());
            return InteractionResultHolder.success(itemstack);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.chang_sheng_jue.durian.tooltip"));
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
