package com.shengchanshe.changshengjue.block.entity.render;

import com.shengchanshe.changshengjue.block.entity.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.changshengjue.block.entity.model.BullionsCastingMoldsBlockEntityModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BullionsCastingMoldsBlockEntityRender extends GeoBlockRenderer<BullionsCastingMoldsBlockEntity> {
    public BullionsCastingMoldsBlockEntityRender() {
        super(new BullionsCastingMoldsBlockEntityModel());
    }
}
