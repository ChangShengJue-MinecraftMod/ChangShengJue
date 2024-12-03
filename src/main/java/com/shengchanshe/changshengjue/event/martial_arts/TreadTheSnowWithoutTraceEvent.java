package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class TreadTheSnowWithoutTraceEvent {
    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().getItem() instanceof AirItem){
                    if (!directEntity.isShiftKeyDown()){
                        event.setAmount(0);
                    }
                    directEntity.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
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
}
