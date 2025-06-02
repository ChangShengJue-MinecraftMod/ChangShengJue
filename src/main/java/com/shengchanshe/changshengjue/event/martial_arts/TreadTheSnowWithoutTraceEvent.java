package com.shengchanshe.changshengjue.event.martial_arts;

import com.mojang.blaze3d.platform.InputConstants;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceClientData;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket2;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;
import java.util.UUID;

public class TreadTheSnowWithoutTraceEvent {
    private static Minecraft mc = Minecraft.getInstance();

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (!player.level().isClientSide) {
                player.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
                    if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent() > 0) {
                        treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceUseCooldownPercent();
                        ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                                treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                                treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                                treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                                treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                                treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), (ServerPlayer) player);
                    }
                    if (treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()) {
                        if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel() == 1) {
                            treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceToppedTick();
                            ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                                    treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                                    treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), (ServerPlayer) player);
                        } else if (treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel() == 2) {
                            treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceDachengTick();
                            ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
                                    treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
                                    treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
                                    treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide) {
                if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceLevel() >= 1 && TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceUseCooldownPercent() > 0
                        && TreadTheSnowWithoutTraceClientData.getjumpCount() > 1) {
                    int numParticles = 1;  // 可以根据需要调整数量
                    Random random = new Random();

                    for (int i = 0; i < numParticles; ++i) {
                        // 使用球坐标系生成球形范围内的粒子位置
                        double radius = 0.3;
                        double theta = random.nextDouble() * 2 * Math.PI;  // 0 到 2π 之间的随机角度
                        double phi = random.nextDouble() * Math.PI;  // 0 到 π 之间的随机角度

                        // 球坐标转换为笛卡尔坐标
                        double offsetX = radius * Math.sin(phi) * Math.cos(theta);
                        double offsetY = radius * Math.sin(phi) * Math.sin(theta);
                        double offsetZ = radius * Math.cos(phi);

                        double particleX = player.getX() + offsetX;
                        double particleY = player.getY() + offsetY;  // 生成在玩家的高度
                        double particleZ = player.getZ() + offsetZ;

                        // 获取玩家当前朝向的角度（以弧度为单位）
                        double playerYawRadians = Math.toRadians(player.getYRot());
                        double playerPitchRadians = Math.toRadians(player.getXRot());

                        // 计算玩家朝向的方向
                        double directionX = Math.sin(playerYawRadians) * Math.cos(playerPitchRadians);
                        double directionZ = -Math.cos(playerYawRadians) * Math.cos(playerPitchRadians);

                        Vec3 direction = new Vec3(directionX, 0, directionZ);
                        Vec3 normalizedDirection = direction.normalize();

                        // 设置粒子的速度，使其与玩家视角方向相反，速度设为每秒2格
                        double speedFactor = 0.3;  // 控制粒子速度的因子
                        double speedX = normalizedDirection.x * speedFactor;  // 粒子速度与玩家朝向的反方向
                        double speedZ = normalizedDirection.z * speedFactor;

                        // 生成粒子并设置速度
                        player.level().addParticle(ChangShengJueParticles.TREAD_THE_SNOW_WITHOUT_TRACE_PARTICLE.get(), particleX, particleY, particleZ, speedX, 0, speedZ);
                    }
                }
                if (TreadTheSnowWithoutTraceClientData.isTreadTheSnowWithoutTraceParticle()) {
                    ComprehendParticle.ComprehendParticle(player, player.level(), TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceToppedTick());
                }
                if (TreadTheSnowWithoutTraceClientData.isTreadTheSnowWithoutTraceParticle()) {
                    DachengParticle.DachengParticle(player, player.level(), TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceDachengTick());
                }
            }
        }
    }


//    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event) {
//        Level level = event.getEntity().level();
//        if (!level.isClientSide) {
//            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()) {
//                    if (!directEntity.isShiftKeyDown()) {
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(TreadTheSnowWithoutTraceCapabilityProvider.TREAD_THE_SNOW_WITHOUT_TRACE_CAPABILITY).ifPresent(treadTheSnowWithoutTrace -> {
//                        if (treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend() && treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel() == 0) {
//                            float probability = directEntity.getRandom().nextFloat();
//                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                            if (probability < defaultProbability) {
//                                treadTheSnowWithoutTrace.addTreadTheSnowWithoutTraceLevel();
//                                treadTheSnowWithoutTrace.setTreadTheSnowWithoutTraceParticle(true);
//                                level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                ChangShengJueMessages.sendToPlayer(new TreadTheSnowWithoutTracePacket(treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceLevel(),
//                                        treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceComprehend(),
//                                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceUseCooldownPercent(),
//                                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceToppedTick(),
//                                        treadTheSnowWithoutTrace.getTreadTheSnowWithoutTraceDachengTick(),
//                                        treadTheSnowWithoutTrace.isTreadTheSnowWithoutTraceParticle()), (ServerPlayer) directEntity);
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

    public static void onKey(InputEvent.Key event) {
//      检查游戏窗口是否处于活动状态和是否有 GUI 打开
        if (mc.player == null || !mc.isWindowActive() || mc.screen != null) return;

        if (event.getAction() == InputConstants.PRESS || event.getAction() == InputConstants.REPEAT) {
            if (event.getKey() == mc.options.keyJump.getKey().getValue()) {
                if (!mc.player.getAbilities().instabuild) {
                    if (TreadTheSnowWithoutTraceClientData.isTreadTheSnowWithoutTraceComprehend()) {
                        if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceLevel() == 1) {
                            if (TreadTheSnowWithoutTraceClientData.getjumpCount() <= 1) {
                                if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceUseCooldownPercent() <= 0) {
                                    TreadTheSnowWithoutTraceClientData.setjumpCount();
                                    mc.player.jumpFromGround();
                                    if (TreadTheSnowWithoutTraceClientData.getjumpCount() == 2) {
                                        mc.player.playSound(ChangShengJueSound.TREAD_THE_SNOW_WITHOUT_TRACE_SOUND.get(), 1.0F, 1.0F);
                                        ChangShengJueMessages.sendToServer(new TreadTheSnowWithoutTracePacket2());
                                    }
                                }
                            }
                        } else if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceLevel() == 2) {
                            if (TreadTheSnowWithoutTraceClientData.getjumpCount() <= 2) {
                                if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceUseCooldownPercent() <= 0) {
                                    TreadTheSnowWithoutTraceClientData.setjumpCount();
                                    mc.player.jumpFromGround();
                                    if (TreadTheSnowWithoutTraceClientData.getjumpCount() == 3) {
                                        mc.player.playSound(ChangShengJueSound.TREAD_THE_SNOW_WITHOUT_TRACE_SOUND.get(), 1.0F, 1.0F);
                                        ChangShengJueMessages.sendToServer(new TreadTheSnowWithoutTracePacket2());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void onFall(LivingFallEvent event) {
        if (event.getEntity() instanceof LocalPlayer player) {
            if (player == mc.player) {
                TreadTheSnowWithoutTraceClientData.setjumpCount(0);
            }
        }
    }
}
