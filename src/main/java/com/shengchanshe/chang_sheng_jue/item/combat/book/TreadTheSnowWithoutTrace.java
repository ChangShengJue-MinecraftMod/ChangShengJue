package com.shengchanshe.chang_sheng_jue.item.combat.book;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class TreadTheSnowWithoutTrace extends Item {
    public TreadTheSnowWithoutTrace() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                if (!treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend()){
                    treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceComprehend(true);
                    ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), (ServerPlayer) pPlayer);
                }
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                    if (treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend() && treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel() == 0) {
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                        if (probability < defaultProbability) {
                            treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceLevel();
                            treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceParticle(true);
                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                    ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                            ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                                    treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                                    treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), (ServerPlayer) player);
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
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.DARK_BLUE);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.DARK_BLUE));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
