package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.event.martial_arts.TreadTheSnowWithoutTraceEvent;
import net.minecraft.client.Minecraft;
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
    }

    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        TreadTheSnowWithoutTraceEvent.onFall(event);
    }
}
