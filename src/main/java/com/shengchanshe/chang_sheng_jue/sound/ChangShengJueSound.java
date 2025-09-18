package com.shengchanshe.chang_sheng_jue.sound;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ChangShengJueSound {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ChangShengJue.MOD_ID);

    public static final RegistryObject<SoundEvent> CICADA_SOUND = registerSoundEvent("cicada_sound");
    public static final RegistryObject<SoundEvent> CICADA_HURT = registerSoundEvent("cicada_hurt");

    public static final RegistryObject<SoundEvent> CRANE_SOUND = registerSoundEvent("crane_sound");
    public static final RegistryObject<SoundEvent> CRANE_HURT = registerSoundEvent("crane_hurt");
    public static final RegistryObject<SoundEvent> CRANE_DEATH = registerSoundEvent("crane_death");

    public static final RegistryObject<SoundEvent> CROC_SOUND = registerSoundEvent("croc_sound");
    public static final RegistryObject<SoundEvent> CROC_HURT = registerSoundEvent("croc_hurt");
    public static final RegistryObject<SoundEvent> CROC_DEATH = registerSoundEvent("croc_death");

    public static final RegistryObject<SoundEvent> DRAGONFLY_HURT = registerSoundEvent("dragonfly_hurt");
    public static final RegistryObject<SoundEvent> DRAGONFLY_DEATH = registerSoundEvent("dragonfly_death");

    //猴子
    public static final RegistryObject<SoundEvent> MONKEY_SOUND = registerSoundEvent("monkey_sound");
    public static final RegistryObject<SoundEvent> MONKEY_BABY_SOUND = registerSoundEvent("monkey_baby_sound");
    public static final RegistryObject<SoundEvent> MONKEY_ANGRY_SOUND = registerSoundEvent("monkey_angry_sound");
    public static final RegistryObject<SoundEvent> MONKEY_HURT = registerSoundEvent("monkey_hurt");
    public static final RegistryObject<SoundEvent> MONKEY_DEATH = registerSoundEvent("monkey_death");

    public static final RegistryObject<SoundEvent> MONKEY_PLAY_1 = registerSoundEvent("monkey_play_1");
    public static final RegistryObject<SoundEvent> MONKEY_PLAY_2 = registerSoundEvent("monkey_play_2");
    public static final RegistryObject<SoundEvent> MONKEY_PLAY_3 = registerSoundEvent("monkey_play_3");
    public static final RegistryObject<SoundEvent> MONKEY_PLAY_4 = registerSoundEvent("monkey_play_4");


    public static final RegistryObject<SoundEvent> TIGER_SOUND = registerSoundEvent("tiger_sound");
    public static final RegistryObject<SoundEvent> TIGER_SOUND_1 = registerSoundEvent("tiger_sound_1");
    public static final RegistryObject<SoundEvent> TIGER_BABY_SOUND = registerSoundEvent("tiger_baby_sound");
    public static final RegistryObject<SoundEvent> TIGER_HURT = registerSoundEvent("tiger_hurt");
    public static final RegistryObject<SoundEvent> TIGER_DEATH = registerSoundEvent("tiger_death");

    public static final RegistryObject<SoundEvent> DEER_SOUND = registerSoundEvent("deer_sound");
    public static final RegistryObject<SoundEvent> DEER_SOUND_1 = registerSoundEvent("deer_sound_1");
    public static final RegistryObject<SoundEvent> DEER_SOUND_2 = registerSoundEvent("deer_sound_2");
    public static final RegistryObject<SoundEvent> DEER_SOUND_3 = registerSoundEvent("deer_sound_3");
    public static final RegistryObject<SoundEvent> DEER_SOUND_4 = registerSoundEvent("deer_sound_4");
    public static final RegistryObject<SoundEvent> DEER_SOUND_5 = registerSoundEvent("deer_sound_5");
    public static final RegistryObject<SoundEvent> DEER_HURT = registerSoundEvent("deer_hurt");
    public static final RegistryObject<SoundEvent> DEER_DEATH = registerSoundEvent("deer_death");

    public static final RegistryObject<SoundEvent> PEACOCK_SOUND = registerSoundEvent("peacock_sound");
    public static final RegistryObject<SoundEvent> PEACOCK_HURT = registerSoundEvent("peacock_hurt");
    public static final RegistryObject<SoundEvent> PEACOCK_DEATH = registerSoundEvent("peacock_death");

    //隔山打牛
    public static final RegistryObject<SoundEvent> GE_SHAN_DA_NIU_SOUND = registerSoundEvent("ge_shan_da_niu_sound");
    //独孤九剑
    public static final RegistryObject<SoundEvent> DUGU_NINE_SWORDS_SOUND = registerSoundEvent("dugu_nine_swords_sound");
    //不死神功
    public static final RegistryObject<SoundEvent> IMMORTAL_MIRACLE_SOUND = registerSoundEvent("immortal_miracle_sound");
    //高家枪法
    public static final RegistryObject<SoundEvent> GAO_MARKSMANSHIP_SOUND = registerSoundEvent("gao_marksmanship_sound");
    //龟息功
    public static final RegistryObject<SoundEvent> TURTLE_BREATH_WORK_SOUND = registerSoundEvent("turtle_breath_work_sound");
    //金乌刀法
    public static final RegistryObject<SoundEvent> GOLDEN_BLACK_KNIFE_METHOD_SOUND = registerSoundEvent("golden_black_knife_method_sound");
    //葵花点穴手
    public static final RegistryObject<SoundEvent> SUNFLOWER_POINT_CAVEMAN_SOUND = registerSoundEvent("sunflower_point_caveman_sound");
    //少林棍法
    public static final RegistryObject<SoundEvent> SHAOLIN_STICK_METHOD_SOUND = registerSoundEvent("shaolin_stick_method_sound");
    //踏雪无痕
    public static final RegistryObject<SoundEvent> TREAD_THE_SNOW_WITHOUT_TRACE_SOUND = registerSoundEvent("tread_the_snow_without_trace_sound");
    //无情飞刀
    public static final RegistryObject<SoundEvent> THROWING_KNIVES_SOUND = registerSoundEvent("throwing_knives_sound");
    public static final RegistryObject<SoundEvent> THREE_THROWING_KNIVES_SOUND = registerSoundEvent("three_throwing_knives_sound");
    public static final RegistryObject<SoundEvent> SEVEN_THROWING_KNIVES_SOUND = registerSoundEvent("seven_throwing_knives_sound");
    public static final RegistryObject<SoundEvent> THROWING_KNIVES_HIT = registerSoundEvent("throwing_knives_hit");
    public static final RegistryObject<SoundEvent> THROWING_KNIVES_HIT_GROUND = registerSoundEvent("throwing_knives_hit_ground");
    //吴刚伐桂
    public static final RegistryObject<SoundEvent> WU_GANG_CUT_GUI_SOUND = registerSoundEvent("wu_gang_cut_gui_sound");
    //玄女剑法
    public static final RegistryObject<SoundEvent> XUANNU_SWORDSMANSHIP_SOUND = registerSoundEvent("xuannu_swordsmanship_sound");
    //金钟罩
    public static final RegistryObject<SoundEvent> GOLDEN_BELLJAR_SOUND = registerSoundEvent("golden_belljar_sound");
    //乾坤大挪移
    public static final RegistryObject<SoundEvent> QIAN_KUN_DA_NUO_YI_SOUND = registerSoundEvent("qian_kun_da_nuo_yi_sound");
    //领悟
    public static final RegistryObject<SoundEvent> COMPREHEND_SOUND = registerSoundEvent("comprehend_sound");
    //大成
    public static final RegistryObject<SoundEvent> DACHENG_SOUND = registerSoundEvent("dacheng_sound");
    //风铃
    public static final RegistryObject<SoundEvent> WIND_CHIME_SOUND = registerSoundEvent("wind_chime_sound");
    //木桩
    public static final RegistryObject<SoundEvent> STAKES_HIT_SOUND = registerSoundEvent("stakes_hit_sound");

    //锣
    public static final RegistryObject<SoundEvent> GONG_SOUND = registerSoundEvent("gong_sound");

    //裁衣案
    public static final RegistryObject<SoundEvent> TAILORING_CASE_SOUND = registerSoundEvent("tailoring_case_sound");

    //锻造炉
    public static final RegistryObject<SoundEvent> FORGE_BLOCK_SOUND = registerSoundEvent("forge_block_sound");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ChangShengJue.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
