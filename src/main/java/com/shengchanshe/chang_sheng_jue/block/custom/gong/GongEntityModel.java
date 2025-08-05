package com.shengchanshe.chang_sheng_jue.block.custom.gong;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class GongEntityModel extends DefaultedBlockGeoModel<GongEntity> {

    public GongEntityModel() {
        super(new ResourceLocation(ChangShengJue.MOD_ID, "gong"));
    }


    public RenderType getRenderType(GongEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(this.getTextureResource(animatable));
    }

}
