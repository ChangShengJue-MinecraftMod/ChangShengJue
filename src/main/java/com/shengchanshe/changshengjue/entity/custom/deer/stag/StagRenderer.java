package com.shengchanshe.changshengjue.entity.custom.deer.stag;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StagRenderer extends GeoEntityRenderer<Stag> {
    public StagRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StagModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Stag instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/deer/stag.png");
    }
}
