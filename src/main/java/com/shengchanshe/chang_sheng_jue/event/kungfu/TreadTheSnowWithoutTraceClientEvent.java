package com.shengchanshe.chang_sheng_jue.event.kungfu;

import com.mojang.blaze3d.platform.InputConstants;
import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuClientData;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.light_kungfu.TreadTheSnowWithoutTrace;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;

@OnlyIn(Dist.CLIENT)
public class TreadTheSnowWithoutTraceClientEvent {
    private static Minecraft mc = Minecraft.getInstance();
    private static int jumpCount;

    @OnlyIn(Dist.CLIENT)
    public static void onKey(InputEvent.Key event) {
//      检查游戏窗口是否处于活动状态和是否有 GUI 打开
        if (mc.player == null || !mc.isWindowActive() || mc.screen != null) return;

        if (event.getAction() == InputConstants.PRESS || event.getAction() == InputConstants.REPEAT) {
            if (event.getKey() == mc.options.keyJump.getKey().getValue()) {
                if (!mc.player.getAbilities().instabuild) {
                    if (KungFuClientData.get().isKnows(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString())) {
                        if (KungFuClientData.get().getKungFuLevel(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()) == 1) {
                            if (jumpCount <= 1) {
                                if (KungFuClientData.get().kungFuCoolDown(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()) <= 0) {
                                    jumpCount++;
                                    if (jumpCount == 2) {
                                        mc.player.jumpFromGround();
                                        ChangShengJueMessages.sendToServer(new TreadTheSnowWithoutTracePacket());
                                    }
                                }
                            } else if (KungFuClientData.get().getKungFuLevel(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()) == 2) {
                                if (jumpCount <= 2) {
                                    if (KungFuClientData.get().kungFuCoolDown(TreadTheSnowWithoutTrace.KUNG_FU_ID.toString()) <= 0) {
                                        jumpCount++;
                                        if (jumpCount == 3) {
                                            mc.player.jumpFromGround();
                                            ChangShengJueMessages.sendToServer(new TreadTheSnowWithoutTracePacket());
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        ChangShengJueMessages.sendToServer(new TreadTheSnowWithoutTracePacket());
                    }
                }
            }
        }
    }

    public static void onFall(LivingFallEvent event) {
        if (event.getEntity() instanceof LocalPlayer player) {
            if (player == mc.player) {
                jumpCount = 0;
            }
        }
    }
}
