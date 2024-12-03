package com.shengchanshe.changshengjue.item.combat.book;

import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TreadTheSnowWithoutTrace extends Item {
    public TreadTheSnowWithoutTrace() {
        super(new Properties());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                if (!treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend()){
                    treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceComprehend(true);
                    ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                            treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                            treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent()), (ServerPlayer) pPlayer);
                }
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }
    //生物受伤事件
    @SubscribeEvent
    public void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (!directEntity.isShiftKeyDown()){
                    float amount = event.getAmount();
                    event.setAmount(-amount);
                }
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().getItem() instanceof AirItem){
                    directEntity.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                        if (treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend() && treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.01F;
                            if (probability < defaultProbability) {
                                treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceLevel();
                                ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                                        treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent()), (ServerPlayer) directEntity);
                            }
                        }
                    });
                }
            }
        }
    }
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.chang_sheng_jue.tread_the_snow_without_trace.tooltip").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
