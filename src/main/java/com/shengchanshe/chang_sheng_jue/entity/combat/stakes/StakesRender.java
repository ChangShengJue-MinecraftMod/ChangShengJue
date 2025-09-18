package com.shengchanshe.chang_sheng_jue.entity.combat.stakes;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StakesRender extends LivingEntityRenderer<StakesEntity, StakesModel<StakesEntity>> {
    public static final ResourceLocation TRIDENT_LOCATION = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/stakes/stakes.png");

    public StakesRender(EntityRendererProvider.Context pContext) {
        super(pContext, new StakesModel(pContext.bakeLayer(StakesModel.LAYER_LOCATION)), 0.25F);
    }

    @Override
    public ResourceLocation getTextureLocation(StakesEntity stakesEntity) {
        return TRIDENT_LOCATION;
    }

    @Override
    public void render(StakesEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
