package com.shengchanshe.changshengjue.entity.custom.wuxia.pillager;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Pillager;

public class PillagerWuXiaRenderer extends IllagerRenderer<Pillager> {
    private static final ResourceLocation PILLAGER = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/illager/pillager_wu_xia.png");

    public PillagerWuXiaRenderer(EntityRendererProvider.Context context) {
        super(context, new IllagerModel<>(context.bakeLayer(ModelLayers.PILLAGER)), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    public ResourceLocation getTextureLocation(Pillager pEntity) {
        return PILLAGER;
    }
}
