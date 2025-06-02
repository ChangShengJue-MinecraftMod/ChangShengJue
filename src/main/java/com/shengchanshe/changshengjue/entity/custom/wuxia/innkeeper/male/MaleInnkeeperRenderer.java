package com.shengchanshe.changshengjue.entity.custom.wuxia.innkeeper.male;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.shengchanshe.changshengjue.ChangShengJue;
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

public class MaleInnkeeperRenderer extends DynamicGeoEntityRenderer<MaleInnkeeper> {
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
    protected final ResourceLocation CAPE_TEXTURE = new ResourceLocation(ChangShengJue.MOD_ID, "textures/entity/innkeeper/male_innkeeper.png");
    protected ItemStack mainHandItem;
    protected ItemStack offhandItem;

    public MaleInnkeeperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MaleInnkeeperModel());
//        this.addRenderLayer(new ItemArmorGeoLayer<MaleInnkeeper>(this) {
//            @Nullable
//            protected ItemStack getArmorItemForBone(GeoBone bone, MaleInnkeeper animatable) {
//                ItemStack var10000;
//                switch (bone.getName()) {
//                    case "armorBipedLeftFoot":
//                    case "armorBipedRightFoot":
//                        var10000 = this.bootsStack;
//                        break;
//                    case "armorBipedLeftLeg":
//                    case "armorBipedRightLeg":
//                        var10000 = this.leggingsStack;
//                        break;
//                    case "armorBipedBody":
//                    case "armorBipedRightArm":
//                    case "armorBipedLeftArm":
//                        var10000 = this.chestplateStack;
//                        break;
//                    case "armorBipedHead":
//                        var10000 = this.helmetStack;
//                        break;
//                    default:
//                        var10000 = null;
//                }
//
//                return var10000;
//            }

//            @Nonnull
//            protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, MaleInnkeeper animatable) {
//                EquipmentSlot var10000;
//                switch (bone.getName()) {
//                    case "armorBipedLeftFoot":
//                    case "armorBipedRightFoot":
//                        var10000 = EquipmentSlot.FEET;
//                        break;
//                    case "armorBipedLeftLeg":
//                    case "armorBipedRightLeg":
//                        var10000 = EquipmentSlot.LEGS;
//                        break;
//                    case "armorBipedRightArm":
//                        var10000 = !animatable.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
//                        break;
//                    case "armorBipedLeftArm":
//                        var10000 = animatable.isLeftHanded() ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
//                        break;
//                    case "armorBipedBody":
//                        var10000 = EquipmentSlot.CHEST;
//                        break;
//                    case "armorBipedHead":
//                        var10000 = EquipmentSlot.HEAD;
//                        break;
//                    default:
//                        var10000 = super.getEquipmentSlotForBone(bone, stack, animatable);
//                }
//
//                return var10000;
//            }

//            @Nonnull
//            protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, MaleInnkeeper animatable, HumanoidModel<?> baseModel) {
//                ModelPart var10000;
//                switch (bone.getName()) {
//                    case "armorBipedLeftFoot":
//                    case "armorBipedLeftLeg":
//                        var10000 = baseModel.leftLeg;
//                        break;
//                    case "armorBipedRightFoot":
//                    case "armorBipedRightLeg":
//                        var10000 = baseModel.rightLeg;
//                        break;
//                    case "armorBipedRightArm":
//                        var10000 = baseModel.rightArm;
//                        break;
//                    case "armorBipedLeftArm":
//                        var10000 = baseModel.leftArm;
//                        break;
//                    case "armorBipedBody":
//                        var10000 = baseModel.body;
//                        break;
//                    case "armorBipedHead":
//                        var10000 = baseModel.head;
//                        break;
//                    default:
//                        var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
//                }
//
//                return var10000;
//            }
//        });
        this.addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Nullable
            protected ItemStack getStackForBone(GeoBone bone, MaleInnkeeper animatable) {
                // 新增：没有仇恨目标时隐藏武器
                if (!animatable.isAggressive()) {
                    return null;
                }
                ItemStack var10000;
                switch (bone.getName()) {
                    case "bipedHandLeft" -> var10000 = animatable.isLeftHanded() ? MaleInnkeeperRenderer.this.mainHandItem : MaleInnkeeperRenderer.this.offhandItem;
                    case "bipedHandRight" -> var10000 = animatable.isLeftHanded() ? MaleInnkeeperRenderer.this.offhandItem : MaleInnkeeperRenderer.this.mainHandItem;
                    default -> var10000 = null;
                }

                return var10000;
            }

            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, MaleInnkeeper animatable) {
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

            protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, MaleInnkeeper animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == MaleInnkeeperRenderer.this.mainHandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
                    if (stack.getItem() instanceof ShieldItem) {
                        poseStack.translate(0.0, 0.125, -0.25);
                    }
                } else if (stack == MaleInnkeeperRenderer.this.offhandItem) {
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
    protected ResourceLocation getTextureOverrideForBone(GeoBone bone, MaleInnkeeper animatable, float partialTick) {
        return "bipedCape".equals(bone.getName()) ? this.CAPE_TEXTURE : null;
    }

    public void preRender(PoseStack poseStack, MaleInnkeeper animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        this.mainHandItem = animatable.getMainHandItem();
        this.offhandItem = animatable.getOffhandItem();
    }
}
