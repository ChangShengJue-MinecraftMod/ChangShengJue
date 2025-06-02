package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.combat.book.QianKunDaNuoYi;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import java.util.Optional;
import java.util.UUID;

public class QianKunDaNuoYiEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(QianKunDaNuoYiCapabilityProvider.QIAN_KUN_DA_NUO_YI_CAPABILITY).ifPresent(qianKunDaNuoYi -> {
                    if (qianKunDaNuoYi.getRecordTime() > 0 && qianKunDaNuoYi.getRecordDamage() > 0 && qianKunDaNuoYi.getRecordDamageSource() != null) {
                        qianKunDaNuoYi.setRecordTime();
                    }
                    if (qianKunDaNuoYi.getRecordTime() <= 0){
                        Optional<Entity> entityOpt = Optional.ofNullable(((ServerLevel) level).getEntity(qianKunDaNuoYi.getRecordDamageSource()));
                        entityOpt.ifPresent(entity -> {
                            entity.hurt(player.damageSources().playerAttack(player), qianKunDaNuoYi.getRecordDamage());
                            qianKunDaNuoYi.setRecordTime(20);
                            qianKunDaNuoYi.setRecordDamage(0);
                            qianKunDaNuoYi.setRecordDamageSource(UUID.randomUUID());
                            qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownMaxAdd(3600);
                            qianKunDaNuoYi.setQianKunDaNuoYiUseCooldownMax(qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownMax() + 20);
                        });
                    }
                    if (qianKunDaNuoYi.getQianKunDaNuoYiUseCooldownPercent() > 0) {
                        if (qianKunDaNuoYi.isSkillActive()) {
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
                                    qianKunDaNuoYi.isSkillActive(),
                                    qianKunDaNuoYi.getRecordTime(),
                                    qianKunDaNuoYi.getRecordDamage(),
                                    qianKunDaNuoYi.getRecordDamageSource()), (ServerPlayer) player);
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
                                    qianKunDaNuoYi.isSkillActive(),
                                    qianKunDaNuoYi.getRecordTime(),
                                    qianKunDaNuoYi.getRecordDamage(),
                                    qianKunDaNuoYi.getRecordDamageSource()), (ServerPlayer) player);
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
                                    qianKunDaNuoYi.isSkillActive(),
                                    qianKunDaNuoYi.getRecordTime(),
                                    qianKunDaNuoYi.getRecordDamage(),
                                    qianKunDaNuoYi.getRecordDamageSource()), (ServerPlayer) player);
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
    public static void onEntityHurt(LivingAttackEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getEntity() != null && event.getSource().getEntity() != null){
                if(event.getEntity() instanceof Player player) {
                    float originalDamage = event.getAmount();
                    QianKunDaNuoYi.onQianKunDaNuoYi(level, player, event.getSource(), originalDamage);
                }
            }
        }
    }
}
