package com.shengchanshe.chang_sheng_jue.block.custom.lockers;// Made with Blockbench 5.0.4

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

public class CabinetModel extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ChangShengJue.MOD_ID, "cabinet"), "main");
	private final ModelPart single;
	private final ModelPart bone40;
	private final ModelPart bone41;
	private final ModelPart right;
	private final ModelPart bone42;
	private final ModelPart left;
	private final ModelPart bone44;

	public CabinetModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.single = root.getChild("single");
		this.bone40 = this.single.getChild("bone40");
		this.bone41 = this.single.getChild("bone41");
		this.right = root.getChild("right");
		this.bone42 = this.right.getChild("bone42");
		this.left = root.getChild("left");
		this.bone44 = this.left.getChild("bone44");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition single = partdefinition.addOrReplaceChild("single", CubeListBuilder.create().texOffs(51, 1).mirror().addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(51, 1).mirror().addBox(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(68, 40).mirror().addBox(-8.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(68, 40).addBox(7.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 22).mirror().addBox(-8.0F, -15.0F, -6.0F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone40 = single.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(8, 104).addBox(-0.5F, -14.0F, -0.25F, 7.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -1.0F, -7.0F));

		PartDefinition bone41 = single.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(8, 104).mirror().addBox(-6.5F, -14.0F, -0.25F, 7.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.5F, -1.0F, -7.0F));

		PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(64, 47).mirror().addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 47).mirror().addBox(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(68, 40).mirror().addBox(-8.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(66, 91).mirror().addBox(-8.0F, -15.0F, -6.0F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone42 = right.addOrReplaceChild("bone42", CubeListBuilder.create().texOffs(27, 104).addBox(-0.5F, -14.0F, -0.25F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -1.0F, -7.0F));

		PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(64, 47).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(68, 40).addBox(7.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(66, 91).addBox(-8.0F, -15.0F, -6.0F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone44 = left.addOrReplaceChild("bone44", CubeListBuilder.create().texOffs(27, 104).mirror().addBox(-14.5F, -14.0F, -0.25F, 15.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.5F, -1.0F, -7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setDoorAngles(float openProgress) {
		float maxAngle = (float) Math.toRadians(-110);

		bone40.yRot = -maxAngle * openProgress;
		bone41.yRot = maxAngle * openProgress;

		bone42.yRot = -maxAngle * openProgress;

		bone44.yRot = maxAngle * openProgress;
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