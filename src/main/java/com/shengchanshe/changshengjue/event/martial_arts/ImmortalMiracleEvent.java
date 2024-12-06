package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ImmortalMiracleEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                    if (immortalMiracle.getImmortalMiracleUseCooldownPercent() > 0 && immortalMiracle.isImmortalMiracleOff()) {
                        immortalMiracle.setImmortalMiracleUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                immortalMiracle.getImmortalMiracleLevel(),
                                immortalMiracle.isImmortalMiracleComprehend(),
                                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                immortalMiracle.isImmortalMiracleOff(),
                                immortalMiracle.getImmortalMiracleToppedTick(),
                                immortalMiracle.getImmortalMiracleDachengTick(),
                                immortalMiracle.isImmortalMiracleParticle(),
                                immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) player);
                    }
                    if (immortalMiracle.isImmortalMiracleParticle()){
                        if (immortalMiracle.getImmortalMiracleLevel() == 1){
                            immortalMiracle.setImmortalMiracleToppedTick();
                        }else if (immortalMiracle.getImmortalMiracleLevel() == 2){
                            immortalMiracle.setImmortalMiracleDachengTick();
                        }
                        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                immortalMiracle.getImmortalMiracleLevel(),
                                immortalMiracle.isImmortalMiracleComprehend(),
                                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                immortalMiracle.isImmortalMiracleOff(),
                                immortalMiracle.getImmortalMiracleToppedTick(),
                                immortalMiracle.getImmortalMiracleDachengTick(),
                                immortalMiracle.isImmortalMiracleParticle(),
                                immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) player);
                    }
                });
            }
            if (player.level().isClientSide){
                if (ImmortalMiracleClientData.isImmortalMiracleParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, ImmortalMiracleClientData.getImmortalMiracleToppedTick());
                }
                if (ImmortalMiracleClientData.isImmortalMiracleParticle()) {
                    DachengParticle.DachengParticle(player, level, ImmortalMiracleClientData.getImmortalMiracleDachengTick());
                }
            }
        }
    }

    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event) {
        Level level = event.getEntity().level();
        if (!level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()) {
                    if (!directEntity.isShiftKeyDown()) {
                        event.setAmount(0);
                    }
                    directEntity.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                        if (immortalMiracle.isImmortalMiracleComprehend() && immortalMiracle.isImmortalMiracleOff() && immortalMiracle.getImmortalMiracleLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
                            if (probability < defaultProbability) {
                                immortalMiracle.addImmortalMiracleLevel();
                                immortalMiracle.setImmortalMiracleParticle(true);
                                ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                        immortalMiracle.getImmortalMiracleLevel(),
                                        immortalMiracle.isImmortalMiracleComprehend(),
                                        immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                        immortalMiracle.isImmortalMiracleOff(),
                                        immortalMiracle.getImmortalMiracleToppedTick(),
                                        immortalMiracle.getImmortalMiracleDachengTick(),
                                        immortalMiracle.isImmortalMiracleParticle(),
                                        immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) directEntity);
                            }
                        }
                    });
                }
            }
            if (event.getEntity() instanceof Player player){
                player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle -> {
                    if (immortalMiracle.isImmortalMiracleComprehend() && immortalMiracle.isImmortalMiracleOff() && immortalMiracle.getImmortalMiracleLevel() > 0) {
                        if (immortalMiracle.getImmortalMiracleUseCooldownPercent() <= 0) {
                            if (player.getFoodData().getFoodLevel() > 8) {
                                if (!player.getAbilities().instabuild) {
                                    player.getFoodData().eat(-5, -3);//消耗饱食度
                                }
                                float health = event.getEntity().getHealth();
                                float amount = event.getAmount();
                                if (amount >= health){
                                    event.setAmount(0);
                                    if (immortalMiracle.getImmortalMiracleUseCount() <= 100){
                                        immortalMiracle.addImmortalMiracleUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                        immortalMiracle.setImmortalMiracleParticle(true);
                                    }
                                    immortalMiracle.setImmortalMiracleUseCooldownPercentMax(immortalMiracle.getImmortalMiracleLevel() == 1 ? 1600 - (15 * 20) : 1600 - (30 * 20));
                                    immortalMiracle.setImmortalMiracleUseCooldownPercent(immortalMiracle.getImmortalMiracleUseCooldownPercentMax());
                                    ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                                            immortalMiracle.getImmortalMiracleLevel(),
                                            immortalMiracle.isImmortalMiracleComprehend(),
                                            immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                                            immortalMiracle.isImmortalMiracleOff(),
                                            immortalMiracle.getImmortalMiracleToppedTick(),
                                            immortalMiracle.getImmortalMiracleDachengTick(),
                                            immortalMiracle.isImmortalMiracleParticle(),
                                            immortalMiracle.getImmortalMiracleUseCooldownPercentMax()), (ServerPlayer) player);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

}
