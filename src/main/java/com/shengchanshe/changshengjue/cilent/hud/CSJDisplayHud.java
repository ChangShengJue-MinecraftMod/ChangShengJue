package com.shengchanshe.changshengjue.cilent.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class CSJDisplayHud {
    public static void displayHud(GuiGraphics guiGraphics, ResourceLocation pAtlasLocation, int x, int y){
        RenderSystem.setShaderTexture(0, pAtlasLocation);
        // 绘制图标
        // 贴图，x坐标，y坐标，z坐标（图层 越高越不容易被遮盖）
        guiGraphics.blit(pAtlasLocation, x, y, 90, 0, 0, 16, 16,
                16, 16);
    }

}
