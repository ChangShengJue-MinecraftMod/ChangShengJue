package com.shengchanshe.changshengjue.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CHANG_SHENG_JUE_CATEGORY = "key.chang_sheng_jue.category";

    public static final String KEY_CHANG_SHENG_JUE_ABILITY_1 = "key.chang_sheng_jue.ability_1";
    public static final String KEY_CHANG_SHENG_JUE_ABILITY_2 = "key.chang_sheng_jue.ability_2";
    public static final String KEY_CHANG_SHENG_JUE_ABILITY_3 = "key.chang_sheng_jue.ability_3";

    public static final KeyMapping ABILITY_KEY_Z = new KeyMapping(KEY_CHANG_SHENG_JUE_ABILITY_1, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z,KEY_CHANG_SHENG_JUE_CATEGORY);
    public static final KeyMapping ABILITY_KEY_X = new KeyMapping(KEY_CHANG_SHENG_JUE_ABILITY_2, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X,KEY_CHANG_SHENG_JUE_CATEGORY);
    public static final KeyMapping ABILITY_KEY_C = new KeyMapping(KEY_CHANG_SHENG_JUE_ABILITY_3, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C,KEY_CHANG_SHENG_JUE_CATEGORY);

    public static void registerKey(RegisterKeyMappingsEvent event){
        event.register(KeyBinding.ABILITY_KEY_Z);
        event.register(KeyBinding.ABILITY_KEY_X);
        event.register(KeyBinding.ABILITY_KEY_C);
    }
}
