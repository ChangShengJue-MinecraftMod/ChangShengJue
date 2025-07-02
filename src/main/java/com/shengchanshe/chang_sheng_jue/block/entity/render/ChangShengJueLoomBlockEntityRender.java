package com.shengchanshe.chang_sheng_jue.block.entity.render;

import com.shengchanshe.chang_sheng_jue.block.entity.ChangShengJueLoomBlockEntity;
import com.shengchanshe.chang_sheng_jue.block.entity.model.ChangShengJueLoomBlockEntityModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ChangShengJueLoomBlockEntityRender extends GeoBlockRenderer<ChangShengJueLoomBlockEntity> {
    public ChangShengJueLoomBlockEntityRender() {
        super(new ChangShengJueLoomBlockEntityModel());
    }
}
