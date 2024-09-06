package com.shengchanshe.changshengjue.sound;

import com.shengchanshe.changshengjue.ChangShengJue;
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

    public static final RegistryObject<SoundEvent> MONKEY_SOUND = registerSoundEvent("monkey_sound");
    public static final RegistryObject<SoundEvent> MONKEY_BABY_SOUND = registerSoundEvent("monkey_baby_sound");
    public static final RegistryObject<SoundEvent> MONKEY_ANGRY_SOUND = registerSoundEvent("monkey_angry_sound");
    public static final RegistryObject<SoundEvent> MONKEY_HURT = registerSoundEvent("monkey_hurt");
    public static final RegistryObject<SoundEvent> MONKEY_DEATH = registerSoundEvent("monkey_death");

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


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ChangShengJue.MOD_ID, name)));
    }
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
