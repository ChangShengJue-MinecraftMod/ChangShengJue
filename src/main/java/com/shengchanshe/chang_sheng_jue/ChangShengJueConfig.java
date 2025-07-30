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
    public static final ForgeConfigSpec.IntValue SPIRIT_RECOVERY_AMOUNT;
    public static final ForgeConfigSpec.IntValue SPIRIT_RECOVERY_INTERVAL;
    public static final ForgeConfigSpec.IntValue SPIRIT_ROOT_JU_QI_EFFICIENCY;
    public static final ForgeConfigSpec.IntValue APTITUDE_TO_TUN_NA_RATE;
    public static final ForgeConfigSpec.BooleanValue TUN_NA_PARTICLE;
    public static final ForgeConfigSpec.BooleanValue BREAKTHROUGH_PARTICLE;
    public static final ForgeConfigSpec.IntValue FLYING_DAGGER_POUCH_MAX_SLOTS;
    public static final ForgeConfigSpec SPEC;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        ENABLE_QUESTS = builder
                .comment("是否启用自动接受类型任务")
                .translation("config."+ ChangShengJue.MOD_ID +".enable_quests")
                .define("enableQuests", true);

        // 新增灵气恢复配置
        SPIRIT_RECOVERY_AMOUNT = builder
                .comment("自然恢复的天地灵气值", "默认: 10")
                .translation("config."+ ChangShengJue.MOD_ID +".spirit_recovery_amount")
                .defineInRange("spiritRecoveryAmount", 10, Integer.MIN_VALUE, Integer.MAX_VALUE); // 最小值1，最大值Integer.MAX_VALUE

        SPIRIT_RECOVERY_INTERVAL = builder
                .comment("天地灵气自然恢复间隔（游戏刻）", "默认200刻(10秒)")
                .translation("config."+ ChangShengJue.MOD_ID +".spirit_recovery_interval")
                .defineInRange("spiritRecoveryInterval", 200, 20, 72000); // 最小1秒，最大1小时

        SPIRIT_ROOT_JU_QI_EFFICIENCY = builder
                .comment("化神期后灵根数量影响聚气效率", "默认每多一个灵根增加5%效率")
                .translation("config."+ ChangShengJue.MOD_ID +".spirit_root_ju_qi_efficiency")
                .defineInRange("spiritRootJuQiEfficiency", 5, Integer.MIN_VALUE, Integer.MAX_VALUE);

        APTITUDE_TO_TUN_NA_RATE = builder
                .comment("默认资质影响吐纳的效率", "默认为2%,该值会被资质高低影响,如果资质过低增加此值会减少你的吐纳效率")
                .translation("config."+ ChangShengJue.MOD_ID +".aptitude_to_tun_na_rate")
                .defineInRange("aptitudeToTunNaRate", 2, Integer.MIN_VALUE, Integer.MAX_VALUE);
        //吐纳粒子
        TUN_NA_PARTICLE = builder
                .comment("是否显示吐纳粒子","吐纳时的粒子特效,默认显示")
                .translation("config."+ ChangShengJue.MOD_ID +".tun_na_particle")
                .define("tunNaParticle", true);
        //突破粒子
        BREAKTHROUGH_PARTICLE = builder
                .comment("是否显示突破粒子","突破境界时的粒子特效,默认显示")
                .translation("config."+ ChangShengJue.MOD_ID +".breakthrough_particle")
                .define("breakthroughParticle", true);

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
    }

}
