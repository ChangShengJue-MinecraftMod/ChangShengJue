package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class QianKunDaNuoYiEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
                    if (qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent() > 0) {
                        if (qianKunDaNuoYi.isSkillZActive() || qianKunDaNuoYi.isSkillXActive() || qianKunDaNuoYi.isSkillCActive()) {
                            qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownPercent();
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
                        }
                    }
                    if (qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMaxAdd() > 0){
                        qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownMaxAdd();
                    }
                    if (qianKunDaNuoYi.isQianKunDaNuoYiParticle()){
                        if (qianKunDaNuoYi.getQianKunDaNuoYiLevel() == 1){
                            qianKunDaNuoYi.setQianKunDaNuoYiToppedTick();
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
                        }else if (qianKunDaNuoYi.getQianKunDaNuoYiLevel() == 2){
                            qianKunDaNuoYi.setQianKunDaNuoYiDachengTick();
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
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (QianKunDaNuoYiClientData.isQianKunDaNuoYiParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, QianKunDaNuoYiClientData.getQianKunDaNuoYiToppedTick());
                }
                if (QianKunDaNuoYiClientData.isQianKunDaNuoYiParticle()) {
                    DachengParticle.DachengParticle(player, level, QianKunDaNuoYiClientData.getQianKunDaNuoYiDachengTick());
                }
            }
        }
    }

    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getEntity() != null && event.getSource().getEntity() != null){
                event.getEntity().getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
                    if(event.getEntity() instanceof Player player) {
                        if (qianKunDaNuoYi.isSkillZActive() || qianKunDaNuoYi.isSkillXActive() || qianKunDaNuoYi.isSkillCActive()) {
                            if (qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownPercent() > 0) {
                                    if (qianKunDaNuoYi.getQianKunDaNuoYiLevel() >= 1) {
                                        float health = player.getHealth();
                                        float v = qianKunDaNuoYi.getQianKunDaNuoYiLevel() <= 1 ? 0.35F : 0.35F + health * 0.02F;
                                        if (player.getRandom().nextFloat() < v) {
                                            if (event.getSource().getEntity() instanceof LivingEntity livingEntity) {
                                                livingEntity.hurt(event.getSource(), event.getAmount() * 1.35F);
                                            }
                                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                    ChangShengJueSound.QIAN_KUN_DA_NUO_YI_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                        }
                                        if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())) {
                                            player.setHealth(player.getHealth() + 1);
                                        }
                                        if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())) {
                                            player.getFoodData().eat(1, 0);
                                        }
                                    }
                            }
                        }
                    }
                });
            }
        }
    }
}
