package com.shengchanshe.chang_sheng_jue.block.custom.lockers;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class LargeCabinetModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ChangShengJue.MOD_ID, "large_cabinet"), "main");
	private final ModelPart bottomLeft;
	private final ModelPart bone52;
	private final ModelPart middleLeft;
	private final ModelPart bone54;
	private final ModelPart topLeft;
	private final ModelPart bone56;
	private final ModelPart bottomRight;
	private final ModelPart bone4;
	private final ModelPart middleRight;
	private final ModelPart bone3;
	private final ModelPart topRight;
	private final ModelPart bone2;

	public LargeCabinetModel(ModelPart root) {
		this.bottomLeft = root.getChild("bottomLeft");
		this.bone52 = this.bottomLeft.getChild("bone52");
		this.middleLeft = root.getChild("middleLeft");
		this.bone54 = this.middleLeft.getChild("bone54");
		this.topLeft = root.getChild("topLeft");
		this.bone56 = this.topLeft.getChild("bone56");
		this.bottomRight = root.getChild("bottomRight");
		this.bone4 = this.bottomRight.getChild("bone4");
		this.middleRight = root.getChild("middleRight");
		this.bone3 = this.middleRight.getChild("bone3");
		this.topRight = root.getChild("topRight");
		this.bone2 = this.topRight.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bottomLeft = partdefinition.addOrReplaceChild("bottomLeft", CubeListBuilder.create().texOffs(60, 59).addBox(-3.3F, 2.3F, -6.2F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(60, 59).addBox(-3.3F, 2.3F, 6.8F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(56, 26).addBox(-3.3F, 1.3F, -6.2F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(56, 0).addBox(-3.3F, -10.7F, -5.2F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.7F, 18.7F, -0.8F));

		PartDefinition bone52 = bottomLeft.addOrReplaceChild("bone52", CubeListBuilder.create().texOffs(30, 59).mirror().addBox(-0.5F, -6.0F, -0.5F, 14.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.8F, -4.7F, -5.7F));

		PartDefinition middleLeft = partdefinition.addOrReplaceChild("middleLeft", CubeListBuilder.create().texOffs(0, 0).addBox(-15.75F, -12.0F, -23.25F, 14.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(9.75F, 20.0F, 17.25F));

		PartDefinition bone54 = middleLeft.addOrReplaceChild("bone54", CubeListBuilder.create().texOffs(56, 42).mirror().addBox(-0.5F, -8.0F, -0.5F, 14.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-15.25F, -4.0F, -23.75F));

		PartDefinition topLeft = partdefinition.addOrReplaceChild("topLeft", CubeListBuilder.create().texOffs(0, 30).addBox(-12.8333F, -7.3333F, -17.6667F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(56, 26).addBox(-12.8333F, -8.3333F, -18.6667F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(6.8333F, 16.3333F, 11.6667F));

		PartDefinition bone56 = topLeft.addOrReplaceChild("bone56", CubeListBuilder.create().texOffs(0, 59).mirror().addBox(-0.5F, -7.5F, -0.5F, 14.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-12.3333F, 0.1667F, -18.1667F));

		PartDefinition bottomRight = partdefinition.addOrReplaceChild("bottomRight", CubeListBuilder.create().texOffs(60, 59).mirror().addBox(6.1F, 1.1F, -14.2F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(60, 59).mirror().addBox(6.1F, 1.1F, -1.2F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 26).mirror().addBox(-5.9F, 0.1F, -14.2F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 0).mirror().addBox(-5.9F, -11.9F, -13.2F, 14.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.1F, 19.9F, 7.2F));

		PartDefinition bone4 = bottomRight.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(30, 59).addBox(-13.5F, -6.0F, -0.5F, 14.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.6F, -5.9F, -13.7F));

		PartDefinition middleRight = partdefinition.addOrReplaceChild("middleRight", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(1.75F, -12.0F, -23.25F, 14.0F, 16.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.75F, 20.0F, 17.25F));

		PartDefinition bone3 = middleRight.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(56, 42).addBox(-13.5F, -8.0F, -0.5F, 14.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(15.25F, -4.0F, -23.75F));

		PartDefinition topRight = partdefinition.addOrReplaceChild("topRight", CubeListBuilder.create().texOffs(0, 30).mirror().addBox(-1.1667F, -7.3333F, -17.6667F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(56, 26).mirror().addBox(-1.1667F, -8.3333F, -18.6667F, 14.0F, 1.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-6.8333F, 16.3333F, 11.6667F));

		PartDefinition bone2 = topRight.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 59).addBox(-13.5F, -7.5F, -0.5F, 14.0F, 15.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(12.3333F, 0.1667F, -18.1667F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	public void renderBottomLeft(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		bottomLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	public void renderMiddleLeft(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		middleLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	public void renderTopLeft(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		topLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	public void renderBottomRight(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		bottomRight.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	public void renderMiddleRight(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		middleRight.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	public void renderTopRight(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay) {
		topRight.render(poseStack, vertexConsumer, packedLight, packedOverlay);
	}

	public void setDoorAngles(float bottomLeft, float middleLeft, float topLeft, float bottomRight, float middleRight, float topRight) {
		float maxAngle = (float) Math.toRadians(-110);
		this.bone52.yRot = -maxAngle * bottomLeft;
		this.bone54.yRot = -maxAngle * middleLeft;
		this.bone56.yRot = -maxAngle * topLeft;
		this.bone4.yRot  =  maxAngle * bottomRight;
		this.bone3.yRot  =  maxAngle * middleRight;
		this.bone2.yRot  =  maxAngle * topRight;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bottomLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middleLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		topLeft.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bottomRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		middleRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		topRight.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}