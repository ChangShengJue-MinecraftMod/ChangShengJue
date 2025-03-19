package com.shengchanshe.changshengjue.entity.custom.wuxia.evoker;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.model.IllagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.SpellcasterIllager;

public class EvokerWuXiaRenderer <T extends SpellcasterIllager> extends IllagerRenderer<T> {
    private static final ResourceLocation EVOKER_ILLAGER = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/illager/evoker_wuxia.png");
    public EvokerWuXiaRenderer(EntityRendererProvider.Context context) {
        super(context, new IllagerModel<>(context.bakeLayer(ModelLayers.EVOKER)), 0.5F);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()) {
            public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int p_114571_, T pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
                if (pLivingEntity.isCastingSpell()) {
                    super.render(pPoseStack, pBuffer, p_114571_, pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks, pAgeInTicks, pNetHeadYaw, pHeadPitch);
                }

            }
        });
    }

    public ResourceLocation getTextureLocation(T pEntity) {
        return EVOKER_ILLAGER;
    }
}
