package com.shengchanshe.changshengjue.block.entity.render;

import com.shengchanshe.changshengjue.block.entity.ChangShengJueLoomBlockEntity;
import com.shengchanshe.changshengjue.block.entity.model.ChangShengJueLoomBlockEntityModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ChangShengJueLoomBlockEntityRender extends GeoBlockRenderer<ChangShengJueLoomBlockEntity> {
    public ChangShengJueLoomBlockEntityRender() {
        super(new ChangShengJueLoomBlockEntityModel());
    }
}
