package com.shengchanshe.changshengjue.entity.custom.wuxia.vindicator;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VindicatorWuXiaRenderer extends IllagerRenderer<VindicatorWuXia> {
    private static final ResourceLocation VINDICATOR = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/illager/vindicator_wu_xia.png");

    public VindicatorWuXiaRenderer(EntityRendererProvider.Context context) {
        super(context, new IllagerModel<>(context.bakeLayer(ModelLayers.VINDICATOR)), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()) {
            public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, VindicatorWuXia pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
                if (pLivingEntity.isAggressive()) {
                    super.render(pPoseStack, pBuffer, pPackedLight, pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks, pAgeInTicks, pNetHeadYaw, pHeadPitch);
                }

            }
        });
    }

    public ResourceLocation getTextureLocation(VindicatorWuXia pEntity) {
        return VINDICATOR;
    }
}
