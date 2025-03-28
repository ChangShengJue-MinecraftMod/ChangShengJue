package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BeatDogStickRender extends GeoItemRenderer<BeatDogStick> {
    public BeatDogStickRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"beat_dog_stick")));
    }
}
