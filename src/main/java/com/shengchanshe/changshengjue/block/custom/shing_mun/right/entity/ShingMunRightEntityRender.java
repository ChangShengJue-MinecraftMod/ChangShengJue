package com.shengchanshe.changshengjue.block.custom.shing_mun.right.entity;

import com.shengchanshe.changshengjue.block.custom.shing_mun.left.entity.ShingMunLeftEntity;
import com.shengchanshe.changshengjue.block.custom.shing_mun.left.entity.ShingMunLeftEntityModel;
import com.shengchanshe.changshengjue.block.custom.shing_mun.right.ShingMunRight;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class ShingMunRightEntityRender extends GeoBlockRenderer<ShingMunRightEntity> {
    public ShingMunRightEntityRender() {
        super(new ShingMunRightEntityModel());
    }
}
