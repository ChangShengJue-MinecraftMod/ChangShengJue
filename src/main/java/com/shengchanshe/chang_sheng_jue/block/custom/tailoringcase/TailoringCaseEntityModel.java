package com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class TailoringCaseEntityModel extends DefaultedBlockGeoModel<TailoringCaseEntity> {

    public TailoringCaseEntityModel() {
        super(new ResourceLocation(ChangShengJue.MOD_ID, "tailoring_case"));
    }


    public RenderType getRenderType(TailoringCaseEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(this.getTextureResource(animatable));
    }

}
