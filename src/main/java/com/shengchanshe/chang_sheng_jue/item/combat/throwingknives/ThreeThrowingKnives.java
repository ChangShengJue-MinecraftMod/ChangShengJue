package com.shengchanshe.chang_sheng_jue.item.combat.throwingknives;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntity;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class ThreeThrowingKnives extends SwordItem {
    public ThreeThrowingKnives() {
        super(Tiers.IRON, 1, -2.4F, new Properties().durability(250));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
//        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            player.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                if (relentlessThrowingKnives.getRelentlessThrowingKnivesLevel() >= 1){
                    player.awardStat(Stats.ITEM_USED.get(this));
                    itemstack.hurtAndBreak(1, player, (player1) -> {
                        player1.broadcastBreakEvent(player.getUsedItemHand());
                    });
                    int numKnives = 3; // 投掷物的数量
                    float angleStep = 10.0F; // 每个投掷物之间的角度差

                    for (int i = 0; i < numKnives; i++) {
                        ThrowingKnivesEntity feiDaoEntity = new ThrowingKnivesEntity(pLevel, player, ChangShengJueItems.THROWING_KNIVES.get().getDefaultInstance());

                        // 计算这个投掷物的发射角度
                        float angle = player.getYRot() + (i - numKnives / 2) * angleStep;

                        feiDaoEntity.shootFromRotation(player, player.getXRot(), angle, 0.0F, 2.5F, 1.0F);
                        pLevel.addFreshEntity(feiDaoEntity);
                    }
                    if (!player.getAbilities().instabuild) {
                        player.getInventory().removeItem(itemstack);
                    }
                    pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), ChangShengJueSound.THREE_THROWING_KNIVES_SOUND.get(), SoundSource.PLAYERS, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
                }
                ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                    relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                    relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                    relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                    relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                    relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) player);
            });
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }
}
