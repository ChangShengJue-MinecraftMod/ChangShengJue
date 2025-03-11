package com.shengchanshe.changshengjue.entity.combat.stakes;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;

public class StakesRender extends LivingEntityRenderer {
    public static final ResourceLocation TRIDENT_LOCATION = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/stakes/stakes.png");

    public StakesRender(EntityRendererProvider.Context pContext) {
        super(pContext, new StakesModel(pContext.bakeLayer(StakesModel.LAYER_LOCATION)), 0.25F);
    }


    @Override
    protected boolean shouldShowName(LivingEntity pEntity) {
        double $$1 = this.entityRenderDispatcher.distanceToSqr(pEntity);
        float $$2 = pEntity.isCrouching() ? 32.0F : 64.0F;
        return !($$1 >= (double) ($$2 * $$2)) && pEntity.isCustomNameVisible();
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return TRIDENT_LOCATION;
    }
}
