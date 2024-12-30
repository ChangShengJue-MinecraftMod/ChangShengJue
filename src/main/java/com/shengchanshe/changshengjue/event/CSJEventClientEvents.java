package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;
import com.shengchanshe.changshengjue.event.martial_arts.GoldenBellJarEvent;
import com.shengchanshe.changshengjue.event.martial_arts.TreadTheSnowWithoutTraceEvent;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket2;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket2;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket2;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket2;
import com.shengchanshe.changshengjue.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
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
        TreadTheSnowWithoutTraceEvent.onKey(event);
//        GoldenBellJarEvent.onKey(event);
        onKeys(event);
    }
    public static void onKeys(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
        if (KeyBinding.ABILITY_KEY_Z.consumeClick()){
            if (player.getMainHandItem().is(ChangShengJueItems.GE_SHAN_DA_NIU.get())){
                ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2("Z"));
            }else if (GeShanDaNiuClientData.isSkillZActive() && !player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                    && !player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()) && !player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())){
                ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2(""));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())){
                ChangShengJueMessages.sendToServer(new ImmortalMiraclePacket2("Z"));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get())){
                ChangShengJueMessages.sendToServer(new SunflowerPointCavemanPacket2("Z"));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())){
                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2("Z"));
            }else if (GoldenBellJarClientData.isSkillZActive() && !player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                    && !player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()) && !player.getMainHandItem().is(ChangShengJueItems.GE_SHAN_DA_NIU.get())){
                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2(""));
            }
        }

        if (KeyBinding.ABILITY_KEY_X.consumeClick()){
            if (player.getMainHandItem().is(ChangShengJueItems.GE_SHAN_DA_NIU.get())){
                ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2("X"));
            }else if (GeShanDaNiuClientData.isSkillZActive() && !player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                    && !player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()) && !player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())){
                ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2(""));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())){
                ChangShengJueMessages.sendToServer(new ImmortalMiraclePacket2("X"));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get())){
                ChangShengJueMessages.sendToServer(new SunflowerPointCavemanPacket2("X"));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())){
                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2("X"));
            }else if (GoldenBellJarClientData.isSkillXActive() && !player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                    && !player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()) && !player.getMainHandItem().is(ChangShengJueItems.GE_SHAN_DA_NIU.get())){
                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2(""));
            }
        }

        if (KeyBinding.ABILITY_KEY_C.consumeClick()){
            if (player.getMainHandItem().is(ChangShengJueItems.GE_SHAN_DA_NIU.get())){
                ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2("C"));
            }else if (GeShanDaNiuClientData.isSkillZActive() && !player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                    && !player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()) && !player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())){
                ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2(""));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())){
                ChangShengJueMessages.sendToServer(new ImmortalMiraclePacket2("C"));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get())){
                ChangShengJueMessages.sendToServer(new SunflowerPointCavemanPacket2("C"));
            }

            if (player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())){
                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2("C"));
            }else if (GoldenBellJarClientData.isSkillCActive() && !player.getMainHandItem().is(ChangShengJueItems.IMMORTAL_MIRACLE.get())
                    && !player.getMainHandItem().is(ChangShengJueItems.SUNFLOWER_POINT_CAVEMAN.get()) && !player.getMainHandItem().is(ChangShengJueItems.GE_SHAN_DA_NIU.get())){
                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2(""));
            }
        }
    }
    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        TreadTheSnowWithoutTraceEvent.onFall(event);
    }
}
