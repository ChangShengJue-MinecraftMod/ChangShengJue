package com.shengchanshe.chang_sheng_jue.item.combat.throwingknives;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
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
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand hand) {
        ItemStack itemstack = pPlayer.getItemInHand(hand);
        pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ChangShengJueSound.THROWING_KNIVES_SOUND.get(), SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            pPlayer.awardStat(Stats.ITEM_USED.get(this));
            itemstack.hurtAndBreak(1, pPlayer, (pPlayer1) -> {
                pPlayer1.broadcastBreakEvent(pPlayer.getUsedItemHand());
            });
            ThrowingKnivesEntity feiDaoEntity = new ThrowingKnivesEntity(pLevel, pPlayer, itemstack);
            feiDaoEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2.5F, 1.0F);
            pLevel.addFreshEntity(feiDaoEntity);
            pPlayer.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                if (relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend() && relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() <= 0){
                    float probability = pPlayer.getRandom().nextFloat();
                    float defaultProbability = !pPlayer.getAbilities().instabuild ? 0.02F : 1.0F;
                    if (probability < defaultProbability) {
                        relentlessThrowingKnives.addRelentlessThrowingKnivesLevel();
                        relentlessThrowingKnives.setRelentlessThrowingKnivesParticle(true);
                        pPlayer.level().playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                                ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                    }
                    relentlessThrowingKnives.setRelentlessThrowingKnivesToppedTick();
                }
                ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                        relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                        relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                        relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                        relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                        relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) pPlayer);
            });
        }
        if (!pPlayer.getAbilities().instabuild) {
            pPlayer.getInventory().removeItem(itemstack);
        }
        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
