package com.shengchanshe.changshengjue.entity.combat.stakes;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class StakesRender extends MobRenderer {
    public static final ResourceLocation TRIDENT_LOCATION = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/stakes/stakes.png");

    public StakesRender(EntityRendererProvider.Context pContext) {
        super(pContext, new StakesModel(pContext.bakeLayer(StakesModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return TRIDENT_LOCATION;
    }
}
