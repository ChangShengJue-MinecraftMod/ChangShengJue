package com.shengchanshe.chang_sheng_jue;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangShengJueConfig {
    public static final ForgeConfigSpec.BooleanValue ENABLE_QUESTS;
    public static final ForgeConfigSpec.IntValue FLYING_DAGGER_POUCH_MAX_SLOTS;
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.BooleanValue ENABLE_BANDIT_SPAWN;
    public static final ForgeConfigSpec.BooleanValue ENABLE_VILLAIN_SPAWN;


    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        ENABLE_QUESTS = builder
                .comment("是否启用自动接受类型任务")
                .translation("config."+ ChangShengJue.MOD_ID +".enable_quests")
                .define("enableQuests", true);

        ENABLE_BANDIT_SPAWN = builder
                .comment("是否启用劫匪生成")
                .translation("config."+ ChangShengJue.MOD_ID +".enable_bandit_spawn")
                .define("enableBanditSpawn", true);

        ENABLE_VILLAIN_SPAWN = builder
                .comment("是否启用反派生成")
                .translation("config."+ ChangShengJue.MOD_ID +".enable_villain_spawn")
                .define("enableVillainSpawn", true);

        FLYING_DAGGER_POUCH_MAX_SLOTS = builder
                .comment("飞刀囊中最大可放入的飞刀数量", "默认为9把")
                .translation("config."+ ChangShengJue.MOD_ID +".flying_dagger_pouch_max_slots")
                .defineInRange("flyingDaggerPouchMaxSlots", 9, 0, 64);

        SPEC = builder.build();
    }

    @SubscribeEvent
    public static void onConfigReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getModId().equals(ChangShengJue.MOD_ID)) {
            ChangShengJue.LOGGER.info("config."+ ChangShengJue.MOD_ID +".reload");
        }
    }

    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal(ChangShengJue.MOD_ID + "_quests")
                .requires(source -> source.hasPermission(2)) // 需要OP权限
                .then(Commands.literal("toggle")
                        .executes(ctx -> {
                            boolean newState = !ChangShengJueConfig.ENABLE_QUESTS.get();
                            ChangShengJueConfig.ENABLE_QUESTS.set(newState);

                            ctx.getSource().sendSuccess(() -> Component.literal(
                                    "自动接受类型任务已" + (newState ? "§a启用" : "§c禁用")), false);
                            return 1;
                        })));

        event.getDispatcher().register(Commands.literal(ChangShengJue.MOD_ID + "_bandit")
                .requires(source -> source.hasPermission(2))
                .then(Commands.literal("toggleSpawn")
                        .executes(ctx -> {
                            boolean newState = !ChangShengJueConfig.ENABLE_BANDIT_SPAWN.get();
                            ChangShengJueConfig.ENABLE_BANDIT_SPAWN.set(newState);
                            ctx.getSource().sendSuccess(() -> Component.literal(
                                    "强盗生成已" + (newState ? "§a启用" : "§c禁用")), false);
                            return 1;
                        })));
    }

}
