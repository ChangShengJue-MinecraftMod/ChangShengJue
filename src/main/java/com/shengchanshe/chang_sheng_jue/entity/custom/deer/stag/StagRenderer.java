package com.shengchanshe.chang_sheng_jue.entity.custom.deer.stag;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
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
