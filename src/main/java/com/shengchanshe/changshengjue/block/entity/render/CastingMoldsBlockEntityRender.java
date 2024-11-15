package com.shengchanshe.changshengjue.block.entity.render;

import com.shengchanshe.changshengjue.block.entity.CastingMoldsBlockEntity;
import com.shengchanshe.changshengjue.block.entity.model.CastingMoldsBlockEntityModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CastingMoldsBlockEntityRender extends GeoBlockRenderer<CastingMoldsBlockEntity> {
    public CastingMoldsBlockEntityRender() {
        super(new CastingMoldsBlockEntityModel());
    }
}
