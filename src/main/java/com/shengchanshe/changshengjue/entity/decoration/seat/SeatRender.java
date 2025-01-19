package com.shengchanshe.changshengjue.entity.decoration.seat;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SeatRender extends EntityRenderer<SeatEntity> {
    public SeatRender(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity seatEntity) {
        return null;
    }
}
