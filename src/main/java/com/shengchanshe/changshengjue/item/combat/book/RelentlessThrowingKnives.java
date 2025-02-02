package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesCapabilityProvider;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.RelentlessThrowingKnivesPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RelentlessThrowingKnives extends Item {
    public RelentlessThrowingKnives() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(RelentlessThrowingKnivesCapabilityProvider.RELENTLESS_THROWING_KNIVES_CAPABILITY).ifPresent(relentlessThrowingKnives -> {
                if (!relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend()){
                    relentlessThrowingKnives.setRelentlessThrowingKnivesComprehend(true);
                    ChangShengJueMessages.sendToPlayer(new RelentlessThrowingKnivesPacket(relentlessThrowingKnives.getRelentlessThrowingKnivesLevel(),
                            relentlessThrowingKnives.isRelentlessThrowingKnivesComprehend(),
                            relentlessThrowingKnives.getRelentlessThrowingKnivesUseCooldownPercent(),
                            relentlessThrowingKnives.getRelentlessThrowingKnivesToppedTick(),
                            relentlessThrowingKnives.getRelentlessThrowingKnivesDachengTick(),
                            relentlessThrowingKnives.isRelentlessThrowingKnivesParticle()), (ServerPlayer) pPlayer);
                }
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.relentless_throwing_knives.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
