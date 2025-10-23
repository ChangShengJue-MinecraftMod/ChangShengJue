package com.shengchanshe.chang_sheng_jue.block.custom.workbench;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class WoodworkingBenchEntityRender extends GeoBlockRenderer<WoodworkingBenchEntity> {
    public WoodworkingBenchEntityRender() {
        super(new DefaultedBlockGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID, "wood_working_bench")));
    }
}
