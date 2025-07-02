package com.shengchanshe.chang_sheng_jue.block.entity.render;

import com.shengchanshe.chang_sheng_jue.block.entity.CastingMoldsBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.entity.model.CastingMoldsBlockEntityModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CastingMoldsBlockEntityRender extends GeoBlockRenderer<CastingMoldsBlockEntity> {
    public CastingMoldsBlockEntityRender() {
        super(new CastingMoldsBlockEntityModel());
    }
}
