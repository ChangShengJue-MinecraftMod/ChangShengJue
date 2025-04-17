package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.paoding.PaodingCapabilityProvider;
import com.shengchanshe.changshengjue.init.CSJAdvanceInit;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.PaodingPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
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

import java.util.List;

public class Paoding extends Item {
    public Paoding() {
        super(new Properties());
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
                if (!paoding.isPaodingComprehend()){
                    paoding.setPaodingComprehend(true);
                }
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }
    public static void comprehend(Entity entity, Level level){
        if (!level.isClientSide) {
            if (entity instanceof Player player){
                player.getCapability(PaodingCapabilityProvider.PAODING_CAPABILITY).ifPresent(paoding -> {
                    if (paoding.isPaodingComprehend() && paoding.getPaodingLevel() == 0) {
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                        if (probability < defaultProbability) {
                            paoding.addPaodingLevel();
                            paoding.setPaodingParticle(true);
                            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                    ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                            ChangShengJueMessages.sendToPlayer(new PaodingPacket(
                                    paoding.getPaodingLevel(),
                                    paoding.isPaodingComprehend(),
                                    paoding.getPaodingToppedTick(),
                                    paoding.getPaodingDachengTick(),
                                    paoding.isPaodingParticle()), (ServerPlayer) player);
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
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.paoding.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
