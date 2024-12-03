package com.shengchanshe.changshengjue.event;

import com.mojang.blaze3d.platform.InputConstants;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceClientData;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTracePacket2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID ,value = Dist.CLIENT)
public class CSJEventClientEvents {
    private static Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public static void onKey(InputEvent.Key event) {
        if (mc.player == null){return;}
        if (event.getAction() == InputConstants.PRESS){
            if (event.getKey() == mc.options.keyJump.getKey().getValue()) {
                if (!mc.player.getAbilities().instabuild){
                    if (TreadTheSnowWithoutTraceClientData.isTreadTheSnowWithoutTraceComprehend()) {
                        if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceLevel() == 1){
                            if (mc.player.getFoodData().getFoodLevel() > 8) {// 检查玩家饱食度是否大于8
                                if (TreadTheSnowWithoutTraceClientData.getjumpCount() <= 1) {
                                    if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceUseCooldownPercent() <= 0) {
                                        TreadTheSnowWithoutTraceClientData.setjumpCount();
                                        mc.player.jumpFromGround();
                                        if (TreadTheSnowWithoutTraceClientData.getjumpCount() == 2) {
                                            mc.player.getFoodData().eat(-2, -1);//消耗饱食度
                                            ChangShengJueMessages.sendToServer(new TreadTheSnowWithoutTracePacket2());
                                        }
                                    }
                                }
                            }
                        }else if(TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceLevel() == 2){
                            if (mc.player.getFoodData().getFoodLevel() > 8) {// 检查玩家饱食度是否大于8
                                if (TreadTheSnowWithoutTraceClientData.getjumpCount() <= 2) {
                                    if (TreadTheSnowWithoutTraceClientData.getTreadTheSnowWithoutTraceUseCooldownPercent() <= 0) {
                                        TreadTheSnowWithoutTraceClientData.setjumpCount();
                                        mc.player.jumpFromGround();
                                        if (TreadTheSnowWithoutTraceClientData.getjumpCount() == 3) {
                                            mc.player.getFoodData().eat(-2, -1);//消耗饱食度
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
    }

    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        if (event.getEntity() instanceof LocalPlayer player) {
            if (player == mc.player) {
                TreadTheSnowWithoutTraceClientData.setjumpCount(0);
            }
        }
    }
}
