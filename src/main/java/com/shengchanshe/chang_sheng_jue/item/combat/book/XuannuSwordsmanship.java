package com.shengchanshe.chang_sheng_jue.item.combat.book;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.XuannuSwordsmanshipPacket;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
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

import java.util.Arrays;
import java.util.List;

public class XuannuSwordsmanship extends Item {
    public XuannuSwordsmanship() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            ItemStack itemInHand = pPlayer.getItemInHand(pUsedHand);
            pPlayer.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
                if (!xuannuSwordsmanship.xuannuSwordsmanshipComprehend()){
                    xuannuSwordsmanship.setXuannuSwordsmanshipComprehend(true);
                    if (!pPlayer.getAbilities().instabuild) {
                        itemInHand.shrink(1);
                    }
                    ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),xuannuSwordsmanship.isXuannuSwordsmanshipComprehend(),
                            xuannuSwordsmanship.getXuannuSwordsmanshipToppedTick(),
                            xuannuSwordsmanship.getXuannuSwordsmanshipDachengTick(),
                            xuannuSwordsmanship.isXuannuSwordsmanshipParticle()), (ServerPlayer) pPlayer);
                    if (pPlayer instanceof ServerPlayer serverPlayer) {
                        CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                    }
                }
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

}
