package com.shengchanshe.changshengjue.block.decoration.windchime;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class WindChimeEntityRender extends GeoBlockRenderer<WindChimeEntity> {
    public WindChimeEntityRender() {
        super(new WindChimeEntityModel());
    }

    @Override
    public RenderType getRenderType(WindChimeEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }
}
