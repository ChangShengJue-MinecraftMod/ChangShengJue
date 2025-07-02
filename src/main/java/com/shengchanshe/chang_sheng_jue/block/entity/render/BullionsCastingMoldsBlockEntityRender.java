package com.shengchanshe.chang_sheng_jue.block.entity.render;

import com.shengchanshe.chang_sheng_jue.block.entity.BullionsCastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.entity.model.BullionsCastingMoldsBlockEntityModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class BullionsCastingMoldsBlockEntityRender extends GeoBlockRenderer<BullionsCastingMoldsBlockEntity> {
    public BullionsCastingMoldsBlockEntityRender() {
        super(new BullionsCastingMoldsBlockEntityModel());
    }
}
