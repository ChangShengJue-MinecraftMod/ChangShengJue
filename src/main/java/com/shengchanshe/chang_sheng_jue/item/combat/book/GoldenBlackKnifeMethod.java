package com.shengchanshe.chang_sheng_jue.item.combat.book;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.event.CSJAdvanceEvent;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.GoldenBlackKnifeMethodPacket;
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

public class GoldenBlackKnifeMethod extends Item {
    public GoldenBlackKnifeMethod() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            ItemStack itemInHand = pPlayer.getItemInHand(pUsedHand);
            pPlayer.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                if (!goldenBlackKnifeMethod.goldenBlackKnifeMethodComprehend()){
                    goldenBlackKnifeMethod.setGoldenBlackKnifeMethodComprehend(true);
                    if (!pPlayer.getAbilities().instabuild) {
                        itemInHand.shrink(1);
                    }
                    ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
                            goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
                            goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
                            goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
                            goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), (ServerPlayer) pPlayer);
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
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.GOLD);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.GOLD));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
