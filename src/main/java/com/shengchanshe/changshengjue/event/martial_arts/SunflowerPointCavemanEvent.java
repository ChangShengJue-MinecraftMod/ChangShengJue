package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.effect.EffectEntityPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
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
                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent() > 0) {
                        if (sunflowerPointCaveman.isSkillZActive() || sunflowerPointCaveman.isSkillXActive() || sunflowerPointCaveman.isSkillCActive()) {
                            sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent();
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                    sunflowerPointCaveman.isSkillZActive(),
                                    sunflowerPointCaveman.isSkillXActive(),
                                    sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) player);
                        }
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
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                    sunflowerPointCaveman.isSkillZActive(),
                                    sunflowerPointCaveman.isSkillXActive(),
                                    sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) player);
                        }else if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 2){
                            sunflowerPointCaveman.setSunflowerPointCavemanDachengTick();
                            ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                    sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                    sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                    sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                    sunflowerPointCaveman.isSkillZActive(),
                                    sunflowerPointCaveman.isSkillXActive(),
                                    sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) player);
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
                        if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() == 0) {
                            if (sunflowerPointCaveman.isSkillZActive() || sunflowerPointCaveman.isSkillXActive() || sunflowerPointCaveman.isSkillCActive()){
                                float probability = directEntity.getRandom().nextFloat();
                                float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
                                if (probability < defaultProbability) {
                                    level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
                                            ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
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
                                        sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                        sunflowerPointCaveman.isSkillZActive(),
                                        sunflowerPointCaveman.isSkillXActive(),
                                        sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) directEntity);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event){
        Player player = event.getEntity();
        Entity entity = event.getTarget();
        Level level = event.getLevel();
        if (!event.getLevel().isClientSide){
            player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                if (sunflowerPointCaveman.isSunflowerPointCavemanComprehend() && sunflowerPointCaveman.getSunflowerPointCavemanLevel() > 0) {
                    if (sunflowerPointCaveman.isSkillZActive() || sunflowerPointCaveman.isSkillXActive() || sunflowerPointCaveman.isSkillCActive()) {
                        if (sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent() <= 0) {
                            if (player.getMainHandItem().isEmpty()) {
                                if (player.getFoodData().getFoodLevel() > 8) {
                                    float health;
                                    if (sunflowerPointCaveman.getSunflowerPointCavemanLevel() < 2) {
                                        health = 25;
                                        if (entity instanceof LivingEntity livingEntity) {
                                            if (livingEntity.getHealth() < health) {
                                                event.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(),
                                                        ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                                livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 25, 1, false, false), player);
                                                MobEffectInstance effectInstance = new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 25, 0, false, false);
                                                ChangShengJueMessages.sendMSGToAll(new EffectEntityPacket(livingEntity.getId(), player.getId(), 0, effectInstance.getDuration()));
                                            }
                                        }
                                    } else {
                                        health = 200;
                                        if (entity instanceof LivingEntity livingEntity) {
                                            if (livingEntity.getHealth() < health) {
                                                event.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(),
                                                        ChangShengJueSound.SUNFLOWER_POINT_CAVEMAN_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                                livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 1, false, false), player);
                                                MobEffectInstance effectInstance = new MobEffectInstance(ChangShengJueEffects.FIXATION_EFFECT.get(), 30, 0, false, false);
                                                ChangShengJueMessages.sendMSGToAll(new EffectEntityPacket(livingEntity.getId(), player.getId(), 0, effectInstance.getDuration()));
                                            }
                                        }
                                    }
                                    if (player.hasEffect(ChangShengJueEffects.FEN_JIU.get())) {
                                        if (!player.getAbilities().instabuild) {
                                            player.getFoodData().eat((int) -(3 - (3 * 0.25)), (float) -(2 - (2 * 0.25)));//消耗饱食度
                                        }
                                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(!player.getAbilities().instabuild ? (180 - (180 * 0.15f)) : 0);
                                    } else if (player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())) {
                                        if (!player.getAbilities().instabuild) {
                                            player.getFoodData().eat((int) -(3 - (3 * 0.2)), (float) -(2 - (2 * 0.2)));//消耗饱食度
                                        }
                                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(!player.getAbilities().instabuild ? (180 - (180 * 0.2f)) : 0);
                                    } else if (player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())) {
                                        if (!player.getAbilities().instabuild) {
                                            player.getFoodData().eat((int) -(3 - (3 * 0.15)), (float) -(2 - (2 * 0.15)));//消耗饱食度
                                        }
                                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(!player.getAbilities().instabuild ? (180 - (180 * 0.25f)) : 0);
                                    } else {
                                        if (!player.getAbilities().instabuild) {
                                            player.getFoodData().eat(-(3), (float) -(2));//消耗饱食度
                                        }
                                        sunflowerPointCaveman.setSunflowerPointCavemanUseCooldownPercent(!player.getAbilities().instabuild ? 180 : 0);
                                    }
                                    if (sunflowerPointCaveman.getSunflowerPointCavemanUseCount() < 100) {
                                        sunflowerPointCaveman.addSunflowerPointCavemanUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                        if (sunflowerPointCaveman.getSunflowerPointCavemanUseCount() >= 100) {
                                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                    ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                            sunflowerPointCaveman.setSunflowerPointCavemanParticle(true);
                                        }
                                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                                sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                                sunflowerPointCaveman.isSkillZActive(),
                                                sunflowerPointCaveman.isSkillXActive(),
                                                sunflowerPointCaveman.isSkillCActive()), (ServerPlayer) player);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }else if (player.level().isClientSide){
            boolean sunflowerPointCavemanComprehend = SunflowerPointCavemanClientData.isSunflowerPointCavemanComprehend();
            if (sunflowerPointCavemanComprehend){
                if (SunflowerPointCavemanClientData.isSkillZActive() || SunflowerPointCavemanClientData.isSkillXActive() || SunflowerPointCavemanClientData.isSkillCActive()){
                    if (SunflowerPointCavemanClientData.getSunflowerPointCavemanLevel() >= 1){
                        if (SunflowerPointCavemanClientData.getSunflowerPointCavemanUseCooldownPercent()<=0) {
                            if (player.getMainHandItem().isEmpty()) {
                                if (player.getFoodData().getFoodLevel() > 8) {
                                    player.swing(player.getUsedItemHand());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
