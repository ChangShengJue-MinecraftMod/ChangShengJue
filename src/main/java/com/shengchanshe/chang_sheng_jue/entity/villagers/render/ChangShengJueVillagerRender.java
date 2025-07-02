package com.shengchanshe.chang_sheng_jue.entity.villagers.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.entity.villagers.ChangShengJueVillagerEntity;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChangShengJueVillagerRender extends MobRenderer<ChangShengJueVillagerEntity, VillagerModel<ChangShengJueVillagerEntity>> {
    private static final ResourceLocation VILLAGER_BASE_SKIN = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager.png");

    public ChangShengJueVillagerRender(EntityRendererProvider.Context pRoot) {
        super(pRoot, new VillagerModel<>(pRoot.bakeLayer(ModelLayers.VILLAGER)), 0.5F);
        this.addLayer(new CustomHeadLayer<>(this, pRoot.getModelSet(), pRoot.getItemInHandRenderer()));
        this.addLayer(new ChangShengJueVillagerLayer<>(this, pRoot.getResourceManager(), "villager"));
        this.addLayer(new CrossedArmsItemLayer<>(this, pRoot.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(ChangShengJueVillagerEntity entity) {
        return VILLAGER_BASE_SKIN;
    }

    protected void scale(ChangShengJueVillagerEntity pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float f = 0.9375F;
        if (pLivingEntity.isBaby()) {
            f *= 0.5F;
            this.shadowRadius = 0.25F;
        } else {
            this.shadowRadius = 0.5F;
        }

        pPoseStack.scale(f, f, f);
    }
}
