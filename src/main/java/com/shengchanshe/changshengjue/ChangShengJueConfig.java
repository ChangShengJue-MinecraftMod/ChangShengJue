package com.shengchanshe.changshengjue;

import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangShengJueConfig {
    public static final ForgeConfigSpec.BooleanValue ENABLE_QUESTS;
    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        ENABLE_QUESTS = builder
                .translation("是否启用自动接受类型任务") // 可选翻译键
                .define("enableQuests", true); // 默认开启

        SPEC = builder.build();
    }

    @SubscribeEvent
    public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getModId().equals(ChangShengJue.MOD_ID)) {
            ChangShengJue.LOGGER.info("任务配置已重新加载");
        }
    }

}
