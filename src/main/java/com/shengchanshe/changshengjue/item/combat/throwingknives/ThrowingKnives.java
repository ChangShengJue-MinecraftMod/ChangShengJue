package com.shengchanshe.changshengjue.item.combat.throwingknives;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.GoldenBlackKnifeMethodPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class ThrowingKnives extends SwordItem {
    public ThrowingKnives() {
        super(Tiers.IRON, 1, -2.4F, new Item.Properties().durability(250));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
//        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            player.awardStat(Stats.ITEM_USED.get(this));
            itemstack.hurtAndBreak(1, player, (player1) -> {
                player1.broadcastBreakEvent(player.getUsedItemHand());
            });
            ThrowingKnivesEntity feiDaoEntity = new ThrowingKnivesEntity(pLevel, player, itemstack);
            feiDaoEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            pLevel.addFreshEntity(feiDaoEntity);
            player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                if (relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend() && relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() <= 0){
                    float probability = player.getRandom().nextFloat();
                    float defaultProbability = !player.getAbilities().instabuild ? 0.02F : 1.0F;
                    if (probability < defaultProbability) {
                        relentlessThrowingKnives.addRelentlessThrowingKnivesLevel();
                        relentlessThrowingKnives.setRelentlessThrowingKnivesParticle(true);
                    }
                    relentlessThrowingKnives.setRelentlessThrowingKnivesToppedTick();
                }
                ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                        relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                        relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                        relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                        relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                        relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) player);
            });
        }
        if (!player.getAbilities().instabuild) {
            player.getInventory().removeItem(itemstack);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
