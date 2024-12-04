package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class SunflowerPointCavemanEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (!player.level().isClientSide) {
                player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent() > 0) {
                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                sunflowerPointCaveman.isSunflowerPointCavemanOff()), (ServerPlayer) player);
                    }
                });
            }
        }
    }

    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
                    if (!directEntity.isShiftKeyDown()){
                        event.setAmount(0);
                    }
                    directEntity.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                        if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.isSunflowerPointCavemanOff() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.01F;
                            if (probability < defaultProbability) {
                                sunflowerPointCaveman.addSunflowerPointCavemanLevel();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        if (!event.getLevel().isClientSide){
            Player player = event.getEntity();
            player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.isSunflowerPointCavemanOff() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() > 0){
                    if (player.getMainHandItem().isEmpty()){
                        if (player.getFoodData().getFoodLevel() > 8){
                            float health;
                            Entity entity = event.getTarget();
                            if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() < 2){
                                health = 25;
                                if (entity instanceof LivingEntity livingEntity){
                                    if (livingEntity.getHealth() < health){
                                        livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 25, 1, false, false), player);
                                        sunflowerPointCaveman.addSunflowerPointCavemanUseCount();
                                    }
                                }
                            }else {
                                health = 200;
                                if (entity instanceof LivingEntity livingEntity){
                                    if (livingEntity.getHealth() < health){
                                        livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 1, false, false), player);
                                        sunflowerPointCaveman.addSunflowerPointCavemanUseCount();
                                    }
                                }
                            }
                            sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(180);
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff()), (ServerPlayer) player);
                            if (!player.getAbilities().instabuild){
                                player.getFoodData().eat(-3, -2);//消耗饱食度
                            }
                        }
                    }
                }
            });
        }
    }

}
