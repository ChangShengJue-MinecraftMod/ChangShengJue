package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.changshengjue.event.martial_arts.TreadTheSnowWithoutTraceEvent;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.gui.playerquest.OpenPlayerQuestScreenPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID ,value = Dist.CLIENT)
public class CSJEventClientEvents {
    private static Minecraft mc = Minecraft.getInstance();
    @SubscribeEvent
    public static void onKey(InputEvent.Key event) {
        TreadTheSnowWithoutTraceEvent.onKey(event);
        onKeys(event);
    }

    public static void onKeys(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
    }
    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        TreadTheSnowWithoutTraceEvent.onFall(event);
    }

    private static final ResourceLocation BUTTON_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/botton.png");

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof InventoryScreen screen) {
            // 检查合成书是否可见
            boolean isRecipeBookVisible = screen.getRecipeBookComponent().isVisible();
            TexturedButtonWithText customButton = new TexturedButtonWithText(
                    screen.leftPos - (!isRecipeBookVisible ? 15 : 92),
                    screen.height / 2 - 80,
                    15, 24,
                    65, 0, 24,
                    BUTTON_TEXTURE,
                    256, 256,
                    (button) -> {
                        ChangShengJueMessages.sendToServer(new OpenPlayerQuestScreenPacket(0, Component.translatable("quest."+ ChangShengJue.MOD_ID +".button")));
                    },
                    Component.translatable("quest."+ ChangShengJue.MOD_ID +".button"),0x000,0x000,1.0F
            );
            event.addListener(customButton);
        }
    }

}
