package com.shengchanshe.changshengjue.event.martial_arts.tread_the_snow_without_trace;

import com.mojang.blaze3d.platform.InputConstants;
import com.shengchanshe.changshengjue.capability.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceClientData;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class TreadTheSnowWithoutTraceClientEvent {
    private static Minecraft mc = Minecraft.getInstance();

    @OnlyIn(Dist.CLIENT)
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
