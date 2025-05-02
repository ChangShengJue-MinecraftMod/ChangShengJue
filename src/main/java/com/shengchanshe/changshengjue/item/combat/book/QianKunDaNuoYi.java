package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class QianKunDaNuoYi extends Item {
    public QianKunDaNuoYi() {
        super(new Properties());
    }

    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
                    if (qianKunDaNuoYi.isQianKunDaNuoYiComprehend() && qianKunDaNuoYi.getQianKunDaNuoYiLevel() == 0) {
                        if (qianKunDaNuoYi.isSkillZActive() || qianKunDaNuoYi.isSkillXActive() || qianKunDaNuoYi.isSkillCActive()){
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                qianKunDaNuoYi.addQianKunDaNuoYiLevel();
                                qianKunDaNuoYi.setQianKunDaNuoYiParticle(true);
                            }
                            ChangShengJueMessages.sendToPlayer(new QianKunDaNuoYiPacket(
                                    qianKunDaNuoYi.getQianKunDaNuoYiLevel(),
                                    qianKunDaNuoYi.isQianKunDaNuoYiComprehend(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent(),
                                    qianKunDaNuoYi.isQianKunDaNuoYiOff(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiToppedTick(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiDachengTick(),
                                    qianKunDaNuoYi.isQianKunDaNuoYiParticle(),
                                    qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax(),
                                    qianKunDaNuoYi.isSkillZActive(),
                                    qianKunDaNuoYi.isSkillXActive(),
                                    qianKunDaNuoYi.isSkillCActive()), (ServerPlayer) player);
                            if (player instanceof ServerPlayer serverPlayer) {
                                CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.YELLOW);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.YELLOW));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
