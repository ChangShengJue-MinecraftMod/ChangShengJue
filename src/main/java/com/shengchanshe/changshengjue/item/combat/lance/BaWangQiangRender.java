package com.shengchanshe.changshengjue.item.combat.lance;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import javax.annotation.Nullable;

public class BaWangQiangRender extends GeoItemRenderer<BaWangQiang> {
    public BaWangQiangRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"ba_wang_qiang")));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (!getGeoModel().getAnimationProcessor().getRegisteredBones().isEmpty()) {
            if (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND ||
                    transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND ||
                    transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND ||
                    transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND) {
                if (stack.getItem() instanceof RedTasselledSpear redTasselledSpear) {
                    if (redTasselledSpear.getPlayer() != null && redTasselledSpear.getPlayer().isShiftKeyDown()) {
                        getGeoModel().getBone("all2").get().setHidden(true);
                        getGeoModel().getBone("all").get().setHidden(false);
                    }
                }
            } else {
                getGeoModel().getBone("all2").get().setHidden(false);
                getGeoModel().getBone("all").get().setHidden(true);
            }
        }
        super.renderByItem(stack, transformType, poseStack, bufferSource, packedLight, packedOverlay);
    }

    @Override
    public RenderType getRenderType(BaWangQiang animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
