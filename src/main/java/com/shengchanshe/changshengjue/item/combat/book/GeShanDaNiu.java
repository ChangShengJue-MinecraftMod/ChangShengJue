package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
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

public class GeShanDaNiu extends Item {
    public GeShanDaNiu() {
        super(new Properties());
    }

    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                    if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.getGeShanDaNiuLevel() == 0) {
                        if (geShanDaNiu.isSkillZActive() || geShanDaNiu.isSkillXActive() || geShanDaNiu.isSkillCActive()) {
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                geShanDaNiu.addGeShanDaNiuLevel();
                                geShanDaNiu.setGeShanDaNiuParticle(true);
                                ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                        geShanDaNiu.getGeShanDaNiuLevel(),
                                        geShanDaNiu.isGeShanDaNiuComprehend(),
                                        geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                        geShanDaNiu.getGeShanDaNiuToppedTick(),
                                        geShanDaNiu.getGeShanDaNiuDachengTick(),
                                        geShanDaNiu.isGeShanDaNiuParticle(),
                                        geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                                        geShanDaNiu.isSkillZActive(),
                                        geShanDaNiu.isSkillXActive(),
                                        geShanDaNiu.isSkillCActive()), (ServerPlayer) player);
                                if (player instanceof ServerPlayer serverPlayer) {
                                    CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                                }
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
