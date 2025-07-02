package com.shengchanshe.chang_sheng_jue.entity.custom.deer.hind;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HindRenderer extends GeoEntityRenderer<Hind> {
    public HindRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HindModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(Hind instance) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/deer/hind.png");
    }
}
