package com.shengchanshe.changshengjue.item.combat.feidao;

import com.shengchanshe.changshengjue.entity.combat.feidao.FeiDaoEntity;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class FeiDao extends SwordItem {
    public FeiDao() {
        super(Tiers.IRON, 1, -2.4F, new Item.Properties().durability(250));
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
//        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            FeiDaoEntity feiDaoEntity = new FeiDaoEntity(pLevel, player, itemstack);
            feiDaoEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(feiDaoEntity);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemstack.hurtAndBreak(1, player, (player1) -> {
            player1.broadcastBreakEvent(player.getUsedItemHand());
        });
        if (!player.getAbilities().instabuild) {
            player.getInventory().removeItem(itemstack);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
