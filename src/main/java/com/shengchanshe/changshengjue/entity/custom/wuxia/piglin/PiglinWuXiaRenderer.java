package com.shengchanshe.changshengjue.entity.custom.wuxia.piglin;

import com.google.common.collect.ImmutableMap;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PiglinModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;

import java.util.Map;

public class PiglinWuXiaRenderer extends HumanoidMobRenderer<Mob, PiglinModel<Mob>> {
    private static final Map<EntityType<?>, ResourceLocation> TEXTURES;
    private static final float PIGLIN_CUSTOM_HEAD_SCALE = 1.0019531F;

    public PiglinWuXiaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, createModel(pContext.getModelSet(), ModelLayers.PIGLIN, false), 0.5F, 1.0019531F, 1.0F, 1.0019531F);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidArmorModel(pContext.bakeLayer(ModelLayers.PIGLIN)), new HumanoidArmorModel(pContext.bakeLayer(ModelLayers.PIGLIN)), pContext.getModelManager()));
    }

    private static PiglinModel<Mob> createModel(EntityModelSet pModelSet, ModelLayerLocation pLayer, boolean pNoRightEar) {
        PiglinModel<Mob> $$3 = new PiglinModel(pModelSet.bakeLayer(pLayer));
        if (pNoRightEar) {
            $$3.rightEar.visible = false;
        }

        return $$3;
    }

    public ResourceLocation getTextureLocation(Mob pEntity) {
        ResourceLocation $$1 = (ResourceLocation)TEXTURES.get(pEntity.getType());
        if ($$1 == null) {
            throw new IllegalArgumentException("I don't know what texture to use for " + pEntity.getType());
        } else {
            return $$1;
        }
    }

    protected boolean isShaking(Mob pEntity) {
        return super.isShaking(pEntity) || pEntity instanceof AbstractPiglin && ((AbstractPiglin)pEntity).isConverting();
    }

    static {
        TEXTURES = ImmutableMap.of(ChangShengJueEntity.PIGLIN_WU_XIA.get(), new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/piglin_wuxia.png"), EntityType.ZOMBIFIED_PIGLIN, new ResourceLocation("textures/entity/piglin/zombified_piglin.png"), EntityType.PIGLIN_BRUTE, new ResourceLocation("textures/entity/piglin/piglin_brute.png"));
    }
}
