package com.shengchanshe.changshengjue.entity.villagers.worker;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KilnWorkerRenderer extends MobRenderer<KilnWorker, KilnWorkerModel<KilnWorker>> {
    public KilnWorkerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new KilnWorkerModel<>(pContext.bakeLayer(KilnWorkerModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(KilnWorker warrior) {
        return new ResourceLocation(ChangShengJue.MOD_ID, "textures/entity/kiln_worker.png");
    }
}
