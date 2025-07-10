package com.shengchanshe.chang_sheng_jue.item.combat.sword;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SoftSwordRender extends GeoItemRenderer<SoftSword> {
    public SoftSwordRender() {
        super(new DefaultedItemGeoModel<>(new ResourceLocation(ChangShengJue.MOD_ID,"soft_sword")));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (!getGeoModel().getAnimationProcessor().getRegisteredBones().isEmpty()) {
            if (transformType == ItemDisplayContext.THIRD_PERSON_LEFT_HAND ||
                    transformType == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND) {
                getGeoModel().getBone("all3").get().setHidden(true);
                getGeoModel().getBone("all2").get().setHidden(true);
                getGeoModel().getBone("all").get().setHidden(false);
            } else if (transformType == ItemDisplayContext.FIRST_PERSON_LEFT_HAND ||
                    transformType == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND){
                getGeoModel().getBone("all3").get().setHidden(true);
                getGeoModel().getBone("all2").get().setHidden(false);
                getGeoModel().getBone("all").get().setHidden(true);
            }else {
                getGeoModel().getBone("all3").get().setHidden(false);
                getGeoModel().getBone("all2").get().setHidden(true);
                getGeoModel().getBone("all").get().setHidden(true);
            }
        }
        super.renderByItem(stack, transformType, poseStack, bufferSource, packedLight, packedOverlay);
    }
    @Override
    public RenderType getRenderType(SoftSword animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }
}
