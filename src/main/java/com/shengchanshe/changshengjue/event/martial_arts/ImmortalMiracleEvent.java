package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

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
                if (ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercent() < ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercentMax()
                        && ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercent() >= ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercentMax() - 40){
                    if (ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercent() >= ImmortalMiracleClientData.getImmortalMiracleUseCooldownPercentMax() - 1){
                        player.playSound(ChangShengJueSound.IMMORTAL_MIRACLE_SOUND.get(), 1.0F, 1.0F);
                    }
                    double radius = 0.4;  // 设置球体的半径
                    int particleCount = 3;  // 控制粒子的数量

                    for (int i = 0; i < particleCount; i++) {
                        // 在球体上随机生成一个点并引入随机角度偏差
                        double phi = Math.random() * Math.PI * 2;  // 产生随机的phi角
                        double costheta = Math.random() * 2 - 1;  // 产生随机的cos(theta)
                        double theta = Math.acos(costheta);  // 计算theta角

                        // 在角度上引入一定的随机波动
                        double randomAngleVariation = Math.random() * 0.5 - 0.25;  // 角度变化范围[-0.25, 0.25]
                        phi += randomAngleVariation;  // 在phi角上增加偏差

                        // 计算粒子位置
                        double dx = radius * Math.sin(theta) * Math.cos(phi);
                        double dy = radius * Math.sin(theta) * Math.sin(phi);
                        double dz = radius * Math.cos(theta);

                        double speedFactor = 0.2;  // 控制粒子的移动速度
                        // 计算粒子的速度向量
                        double speedX = dx * speedFactor;
                        double speedY = dy * speedFactor;
                        double speedZ = dz * speedFactor;

                        level.addParticle(ChangShengJueParticles.IMMORTAL_MIRACLE_PARTICLE.get(), player.getX() + dx, player.getY() + 1.3 + dy, player.getZ() + dz, speedX, speedY, speedZ);
                    }
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
                                level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
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
                                float cooldownMax1 = 1600 - (15 * 20);
                                float cooldownMax2 = 1600 - (30 * 20);
                                if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat((int) -(5 - (5 * 0.25)), (float) -(2 - (2 * 0.25)));//消耗饱食度
                                    }
                                    immortalMiracle.setImmortalMiracleUseCooldownPercentMax((float) (immortalMiracle.getImmortalMiracleLevel() == 1 ? cooldownMax1 - (cooldownMax1 * 0.15) : cooldownMax2 - (cooldownMax2 * 0.15)));
                                }else if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat((int) -(5 - (5 * 0.15)), (float) -(2 - (2 * 0.15)));//消耗饱食度
                                    }
                                    immortalMiracle.setImmortalMiracleUseCooldownPercentMax((float) (immortalMiracle.getImmortalMiracleLevel() == 1 ? cooldownMax1 - (cooldownMax1 * 0.25) : cooldownMax2 - (cooldownMax2 * 0.25)));
                                }else {
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat(-5, -3);//消耗饱食度
                                    }
                                    immortalMiracle.setImmortalMiracleUseCooldownPercentMax(immortalMiracle.getImmortalMiracleLevel() == 1 ? cooldownMax1 : cooldownMax2);
                                }
                                immortalMiracle.setImmortalMiracleUseCooldownPercent(!player.getAbilities().instabuild ? immortalMiracle.getImmortalMiracleUseCooldownPercentMax() : 0);
                                float health = event.getEntity().getHealth();
                                float amount = event.getAmount();
                                if (amount >= health){
                                    event.setAmount(0);
//                                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
//                                            ChangShengJueSound.IMMORTAL_MIRACLE_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                    if (immortalMiracle.getImmortalMiracleUseCount() < 100){
                                        immortalMiracle.addImmortalMiracleUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                        if (immortalMiracle.getImmortalMiracleUseCount() >= 100){
                                            immortalMiracle.setImmortalMiracleParticle(true);
                                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                    ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                        }
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
                            }
                        }
                    }
                });
            }
        }
    }
}
