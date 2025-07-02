package com.shengchanshe.chang_sheng_jue.cilent.hud.cultivation.spirit;

import com.mojang.blaze3d.systems.RenderSystem;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

@OnlyIn(Dist.CLIENT)
public class CultivationHudOverlay {
    private static final Minecraft MINECRAFT_INSTANCE = Minecraft.getInstance();
    // 预定义纹理UV坐标
    private static final DensityUV[] DENSITY_UVS = {
            new DensityUV(1,2),   // 枯竭
            new DensityUV(2,16),  // 稀少
            new DensityUV(3,33),  // 普通
            new DensityUV(4,49),  // 充沛
            new DensityUV(5,64),  // 浓郁
            new DensityUV(6,80)   // 灵脉
    };

    // 绘制的领悟后技能贴图的位置
    private static final ResourceLocation CULTIVATION = new ResourceLocation(ChangShengJue.MOD_ID,
            "textures/gui/cultivation/cultivation.png");

    public static final IGuiOverlay HUD_CULTIVATION = (gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        if (MINECRAFT_INSTANCE.player == null) return;

        if (MINECRAFT_INSTANCE.player.isCreative() || MINECRAFT_INSTANCE.player.isSpectator() || CultivationClientData.getStageOrdinal() < 1) return;

        int x = (screenWidth / 2) + 91 - 8;
        boolean hasOxygen = MINECRAFT_INSTANCE.player.getAirSupply() < MINECRAFT_INSTANCE.player.getMaxAirSupply() && MINECRAFT_INSTANCE.player.getAirSupply() > 0;
        int spiritY = hasOxygen ? screenHeight - 59 : screenHeight - 49;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CULTIVATION);
        byte densityTier = CultivationClientData.getDensityTier();
        // 渲染天地灵气
        DensityUV uv = DENSITY_UVS[densityTier - 1];
        guiGraphics.blit(CULTIVATION, (screenWidth / 2) - 7, screenHeight - 49,100, uv.xOffset,
                18, 16, 16, 256, 256);

        // 渲染灵力条
        float spiritRatio = CultivationClientData.getSpiritPower() / CultivationClientData.getSpiritPowerMax();
        int totalUnits = 10;
        float exactUnits = totalUnits * spiritRatio;
        int fullUnits = (int) exactUnits;
        boolean hasHalfUnit = ((exactUnits - fullUnits) >= 0.5f || (exactUnits - fullUnits) < 0.5f && (exactUnits - fullUnits) > 0.0f); // 是否需要半格

        for (int i = 0; i < totalUnits; i++) {
            int xPos = (i == 0) ? x:
                    (x - (i * 8));
            guiGraphics.blit(
                    CULTIVATION,
                    xPos, spiritY,100,
                    0, 0, // 空状态UV
                    9, 9, // 纹理尺寸
                    256, 256
            );
        }

        for (int i = 0; i < fullUnits; i++) {
            int xPos = (i == 0) ? x - i + 1:
                    (x - (i * 8)) + 1;
            guiGraphics.blit(
                    CULTIVATION,
                    xPos, spiritY,101,
                    37, 0,
                    9, 9,
                    256, 256
            );
        }

        if (hasHalfUnit) {
            guiGraphics.blit(
                    CULTIVATION,
                    (x - fullUnits * 8) + 1, spiritY,101,
                    46, 0,
                    9, 9,
                    256, 256
            );
        }
    };
    // 辅助记录类
    private record DensityUV(int tier, int xOffset) {}

}
