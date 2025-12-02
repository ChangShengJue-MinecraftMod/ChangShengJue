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

public class LianggeModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ChangShengJue.MOD_ID, "liangge"), "main");
	private final ModelPart single;
	private final ModelPart left;
	private final ModelPart right;

	public LianggeModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.single = root.getChild("single");
		this.left = root.getChild("left");
		this.right = root.getChild("right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition single = partdefinition.addOrReplaceChild("single", CubeListBuilder.create().texOffs(5, 36).addBox(-8.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(5, 36).addBox(7.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(5, 36).addBox(-8.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(5, 36).addBox(7.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(-8.0F, 7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(0, 2).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(5, 36).addBox(-8.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(5, 36).addBox(-8.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(58, 51).addBox(-8.0F, 7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(58, 51).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(5, 36).mirror().addBox(7.0F, -7.0F, -8.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(5, 36).mirror().addBox(7.0F, -7.0F, 7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(58, 51).mirror().addBox(-8.0F, 7.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(58, 51).mirror().addBox(-8.0F, -8.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 16.0F, 0.0F));

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