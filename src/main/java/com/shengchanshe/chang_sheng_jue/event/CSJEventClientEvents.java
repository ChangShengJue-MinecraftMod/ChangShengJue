package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.button.TexturedButtonWithText;
import com.shengchanshe.chang_sheng_jue.cilent.gui.screens.wuxia.playerquest.ClientQuestDataCache;
import com.shengchanshe.chang_sheng_jue.event.kungfu.TreadTheSnowWithoutTraceClientEvent;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.gui.playerquest.OpenPlayerQuestScreenPacket;
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
        TreadTheSnowWithoutTraceClientEvent.onKey(event);
        onKeys(event);
    }

    public static void onKeys(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;
    }
    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        TreadTheSnowWithoutTraceClientEvent.onFall(event);
    }

    private static final ResourceLocation BUTTON_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/botton.png");

    @SubscribeEvent
    public static void onScreenInit(ScreenEvent.Init.Post event) {
        if (event.getScreen() instanceof InventoryScreen screen) {
            // 检查合成书是否可见
            boolean isRecipeBookVisible = screen.getRecipeBookComponent().isVisible();
            if (mc.player != null && !ClientQuestDataCache.get().getPlayerQuests(mc.player.getUUID()).isEmpty()) {
                TexturedButtonWithText customButton = new TexturedButtonWithText(
                        screen.leftPos - (!isRecipeBookVisible ? 32 : 109),
                        screen.height / 2 - 80,
                        35, 25,
                        35, 0, 0,
                        BUTTON_TEXTURE,256,256,
                        (button) -> ChangShengJueMessages.sendToServer(new OpenPlayerQuestScreenPacket(0, Component.translatable("quest." + ChangShengJue.MOD_ID + ".button"))),
                        Component.translatable("quest." + ChangShengJue.MOD_ID + ".button"), 0x000, 0x000, 1.0F)
                        .setIcon(new ResourceLocation(ChangShengJue.MOD_ID, "textures/gui/container/quests.png"),0,0,16,16,16,16)
                        .setIconPosition(TexturedButtonWithText.IconPosition.CENTER)
                        .setIconScale(1.0f);
                event.addListener(customButton);
            }
        }
    }

}
