package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.DuguNineSwordsPacket;
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

public class DuguNineSwordsBook extends Item {
    public DuguNineSwordsBook() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            ItemStack itemInHand = pPlayer.getItemInHand(pUsedHand);
            pPlayer.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
                if (!duguNineSword.duguNineSwordsComprehend()){
                    duguNineSword.setDuguNineSwordsComprehend(true);
                    if (!pPlayer.getAbilities().instabuild) {
                        itemInHand.shrink(1);
                    }
                    ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(duguNineSword.getDuguNineSwordsLevel(),
                            duguNineSword.isDuguNineSwordsComprehend(),
                            duguNineSword.getDuguNineSwordsToppedTick(),
                            duguNineSword.getDuguNineSwordsDachengTick(),
                            duguNineSword.isDuguNineSwordsParticle()), (ServerPlayer) pPlayer);
                    if (pPlayer instanceof ServerPlayer serverPlayer) {
                        CSJAdvanceInit.learnwaigong.trigger(serverPlayer);
                    }
                }
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
            pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.dugu_nine_swords.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
