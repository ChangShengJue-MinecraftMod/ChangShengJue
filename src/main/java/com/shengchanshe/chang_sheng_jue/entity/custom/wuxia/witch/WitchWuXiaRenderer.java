package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.witch;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.model.WitchModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.WitchItemLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WitchWuXiaRenderer extends MobRenderer<WitchWuXia, WitchModel<WitchWuXia>> {
    private static final ResourceLocation WITCH_LOCATION = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/witch_wuxia.png");

    public WitchWuXiaRenderer(EntityRendererProvider.Context context) {
        super(context, new WitchModel<>(context.bakeLayer(ModelLayers.WITCH)), 0.5F);
        this.addLayer(new WitchItemLayer<>(this, context.getItemInHandRenderer()));
    }

    public void render(WitchWuXia pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.model.setHoldingItem(!pEntity.getMainHandItem().isEmpty());
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    public ResourceLocation getTextureLocation(WitchWuXia pEntity) {
        return WITCH_LOCATION;
    }

    protected void scale(WitchWuXia pLivingEntity, PoseStack pPoseStack, float pPartialTickTime) {
        float $$3 = 0.9375F;
        pPoseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }
}
