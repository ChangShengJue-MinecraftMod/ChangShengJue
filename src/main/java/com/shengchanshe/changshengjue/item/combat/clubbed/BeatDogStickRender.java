package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class BeatDogStickRender extends GeoItemRenderer<BeatDogStick> {
    public BeatDogStickRender() {
        super(new DefaultedItemGeoModel(new ResourceLocation(ChangShengJue.MOD_ID,"beat_dog_stick")));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext transformType, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (!getGeoModel().getAnimationProcessor().getRegisteredBones().isEmpty()) {
            if (transformType == ItemDisplayContext.GUI) {
                getGeoModel().getBone("all").get().setHidden(false);
            }
        }
        super.renderByItem(stack, transformType, poseStack, bufferSource, packedLight, packedOverlay);
    }
}
