package com.shengchanshe.chang_sheng_jue.block.decoration.windchime;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class WindChimeEntityModel extends GeoModel<WindChimeEntity> {
    @Override
    public ResourceLocation getModelResource(WindChimeEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"geo/block/wind_chime.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WindChimeEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"textures/block/wind_chime.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WindChimeEntity entity) {
        return new ResourceLocation(ChangShengJue.MOD_ID,"animations/block/wind_chime.animation.json");
    }
}
