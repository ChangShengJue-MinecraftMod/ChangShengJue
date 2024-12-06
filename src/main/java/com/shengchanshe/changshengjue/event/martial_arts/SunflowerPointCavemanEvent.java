package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
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
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent() > 0 && sunflowerPointCaveman.isSunflowerPointCavemanOff()) {
                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) player);
                    }
                    if (sunflowerPointCaveman.isSunflowerPointCavemanParticle()){
                        if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 1){
                            sunflowerPointCaveman.setSunflowerPointCavemanToppedTick();
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) player);
                        }else if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 2){
                            sunflowerPointCaveman.setSunflowerPointCavemanDachengTick();
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (SunflowerPointCavemanClientData.isSunflowerPointCavemanParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, SunflowerPointCavemanClientData.getSunflowerPointCavemanToppedTick());
                }
                if (SunflowerPointCavemanClientData.isSunflowerPointCavemanParticle()) {
                    DachengParticle.DachengParticle(player, level, SunflowerPointCavemanClientData.getSunflowerPointCavemanDachengTick());
                }
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
                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                sunflowerPointCaveman.addSunflowerPointCavemanLevel();
                                sunflowerPointCaveman.setSunflowerPointCavemanParticle(true);
                            }
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) directEntity);
                        }
                    });
                }
            }
        }
    }

    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        Player player = event.getEntity();
        if (!event.getLevel().isClientSide){
            player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.isSunflowerPointCavemanOff() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() > 0){
                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent()<=0){
                        if (player.getMainHandItem().isEmpty()){
                            if (player.getFoodData().getFoodLevel() > 8){
                                float health;
                                Entity entity = event.getTarget();
                                if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() < 2){
                                    health = 25;
                                    if (entity instanceof LivingEntity livingEntity){
                                        if (livingEntity.getHealth() < health){
                                            livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 25, 1, false, false), player);
                                            sunflowerPointCaveman.addSunflowerPointCavemanUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                        }
                                    }
                                }else {
                                    health = 200;
                                    if (entity instanceof LivingEntity livingEntity){
                                        if (livingEntity.getHealth() < health){
                                            livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 1, false, false), player);
                                            sunflowerPointCaveman.addSunflowerPointCavemanUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                        }
                                    }
                                }
                                sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(!player.getAbilities().instabuild ? 180 : 0);
                                if (sunflowerPointCaveman.getSunflowerPointCavemanUseCount() <= 100){
                                    sunflowerPointCaveman.addSunflowerPointCavemanUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                    sunflowerPointCaveman.setSunflowerPointCavemanParticle(true);
                                }
                                ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                        sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                        sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                        sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                        sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                        sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                        sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                        sunflowerPointCaveman.isSunflowerPointCavemanParticle()), (ServerPlayer) player);
                                if (!player.getAbilities().instabuild){
                                    player.getFoodData().eat(-3, -2);//消耗饱食度
                                }
                            }
                        }
                    }
                }
            });
        }else{
            boolean sunflowerPointCavemanComprehend = SunflowerPointCavemanClientData.isSunflowerPointCavemanComprehend();
            boolean sunflowerPointCavemanOff = SunflowerPointCavemanClientData.isSunflowerPointCavemanOff();
            if (sunflowerPointCavemanComprehend && sunflowerPointCavemanOff){
                if (SunflowerPointCavemanClientData.getSunflowerPointCavemanLevel() >= 1){
                    if (SunflowerPointCavemanClientData.getSunflowerPointCavemanUseCooldownPercent()<=0) {
                        if (player.getFoodData().getFoodLevel() > 8){
                            player.swing(player.getUsedItemHand());
                        }
                    }
                }
            }
        }
    }

}
