package com.shengchanshe.chang_sheng_jue.block.custom.storage;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class FretworkOpenworkPanelModel extends Model {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ChangShengJue.MOD_ID, "storage_compartment"), "main");

    private final ModelPart single;
    private final ModelPart right;
    private final ModelPart left;

    public FretworkOpenworkPanelModel(ModelPart root) {
        super(RenderType::entityCutout);
        this.single = root.getChild("single");
        this.right = root.getChild("right");
        this.left = root.getChild("left");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition single = partdefinition.addOrReplaceChild("single", CubeListBuilder.create().texOffs(5, 36).addBox(-8.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 36).addBox(7.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 36).addBox(-8.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 36).addBox(7.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-8.0F, 7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 2).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(73, 21).addBox(-7.0F, -7.0F, 7.0F, 14.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 79).addBox(-7.5F, -7.0F, -7.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(7, 79).addBox(7.5F, -7.0F, -7.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(35, 93).addBox(-7.0F, -7.0F, -7.5F, 14.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(5, 36).addBox(-8.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 36).addBox(-8.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(58, 51).addBox(-8.0F, 7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(58, 51).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(73, 72).addBox(-7.0F, -7.0F, 7.0F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 79).addBox(-7.5F, -7.0F, -7.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(63, 93).addBox(-7.0F, -7.0F, -7.5F, 14.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(5, 36).mirror().addBox(7.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(5, 36).mirror().addBox(7.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(58, 51).mirror().addBox(-8.0F, 7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(58, 51).mirror().addBox(-8.0F, -8.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(73, 72).mirror().addBox(-8.0F, -7.0F, 7.0F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(7, 79).addBox(7.5F, -7.0F, -7.0F, 0.0F, 14.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(63, 93).mirror().addBox(-7.0F, -7.0F, -7.5F, 14.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    public void renderSingle(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
        single.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    public void renderLeft(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
        left.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    public void renderRight(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
        right.render(poseStack, vertexConsumer, packedLight, packedOverlay);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        renderSingle(poseStack, vertexConsumer, packedLight, packedOverlay);
    }
}