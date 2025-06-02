package com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.lance;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.GangleaderVariant;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.knife.KnifeGangLeader;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

import javax.annotation.Nullable;
import java.util.Map;

public class LanceGangLeaderRenderer extends DynamicGeoEntityRenderer<LanceGangLeader> {
    private static final String LEFT_HAND = "bipedHandLeft";
    private static final String RIGHT_HAND = "bipedHandRight";
    private static final String LEFT_BOOT = "armorBipedLeftFoot";
    private static final String RIGHT_BOOT = "armorBipedRightFoot";
    private static final String LEFT_ARMOR_LEG = "armorBipedLeftLeg";
    private static final String RIGHT_ARMOR_LEG = "armorBipedRightLeg";
    private static final String CHESTPLATE = "armorBipedBody";
    private static final String RIGHT_SLEEVE = "armorBipedRightArm";
    private static final String LEFT_SLEEVE = "armorBipedLeftArm";
    private static final String HELMET = "armorBipedHead";
    public static final Map<GangleaderVariant,ResourceLocation> CAPE_TEXTURE =
            Util.make(Maps.newEnumMap(GangleaderVariant.class),(map)->{
                map.put(GangleaderVariant.TEXTURES_0,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/gang_leader/lance_gang_leader.png"));
                map.put(GangleaderVariant.TEXTURES_1,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/gang_leader/knife_gang_leader.png"));
                map.put(GangleaderVariant.TEXTURES_2,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/gang_leader/sword_gang_leader.png"));
            });
    public static final Map<GangleaderVariant,ResourceLocation> CAPE_GEO =
            Util.make(Maps.newEnumMap(GangleaderVariant.class),(map)->{
                map.put(GangleaderVariant.TEXTURES_0,
                        new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/gang_leader/lance_gang_leader.geo.json"));
                map.put(GangleaderVariant.TEXTURES_1,
                        new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/gang_leader/knife_gang_leader.geo.json"));
                map.put(GangleaderVariant.TEXTURES_2,
                        new ResourceLocation(ChangShengJue.MOD_ID,"geo/entity/gang_leader/sword_gang_leader.geo.json"));
            });
    protected ItemStack mainHandItem;
    protected ItemStack offhandItem;

    public LanceGangLeaderRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LanceGangLeaderModel());
        this.addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            protected ItemStack getStackForBone(GeoBone bone, LanceGangLeader animatable) {
                if (!animatable.isAggressive()) {
                    return null;
                }
                ItemStack var10000;
                switch (bone.getName()) {
                    case "bipedHandLeft" -> var10000 = animatable.isLeftHanded() ? LanceGangLeaderRenderer.this.mainHandItem : LanceGangLeaderRenderer.this.offhandItem;
                    case "bipedHandRight" -> var10000 = animatable.isLeftHanded() ? LanceGangLeaderRenderer.this.offhandItem : LanceGangLeaderRenderer.this.mainHandItem;
                    default -> var10000 = null;
                }
                return var10000;
            }

            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, LanceGangLeader animatable) {
                ItemDisplayContext var10000;
                switch (bone.getName()) {
                    case "bipedHandLeft":
                    case "bipedHandRight":
                        var10000 = ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
                        break;
                    default:
                        var10000 = ItemDisplayContext.NONE;
                }

                return var10000;
            }

            protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, LanceGangLeader animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == LanceGangLeaderRenderer.this.mainHandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                    if (stack.getItem() instanceof ShieldItem) {
                        poseStack.translate(0.0, 0.125, -0.25);
                    }
                } else if (stack == LanceGangLeaderRenderer.this.offhandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                    if (stack.getItem() instanceof ShieldItem) {
                        poseStack.translate(0.0, 0.125, 0.25);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
                    }
                }

                super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
            }
        });
    }

    @Nullable
    protected ResourceLocation getTextureOverrideForBone(GeoBone bone, LanceGangLeader animatable, float partialTick) {
        return "bipedCape".equals(bone.getName()) ? CAPE_TEXTURE.get(animatable.getVariant()) : null;
    }

    public void preRender(PoseStack poseStack, LanceGangLeader animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        this.mainHandItem = animatable.getMainHandItem();
        this.offhandItem = animatable.getOffhandItem();
    }
}
