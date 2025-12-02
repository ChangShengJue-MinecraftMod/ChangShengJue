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

public class ChestOfDrawersModel extends Model {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ChangShengJue.MOD_ID, "chest_of_drawers"), "main");
	private final ModelPart single;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart left;
	private final ModelPart bone2;
	private final ModelPart bone3;
	private final ModelPart bone5;
	private final ModelPart right;
	private final ModelPart bone;
	private final ModelPart bone4;
	private final ModelPart bone6;

	public ChestOfDrawersModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.single = root.getChild("single");
		this.bone7 = this.single.getChild("bone7");
		this.bone8 = this.single.getChild("bone8");
		this.bone9 = this.single.getChild("bone9");
		this.left = root.getChild("left");
		this.bone2 = this.left.getChild("bone2");
		this.bone3 = this.left.getChild("bone3");
		this.bone5 = this.left.getChild("bone5");
		this.right = root.getChild("right");
		this.bone = this.right.getChild("bone");
		this.bone4 = this.right.getChild("bone4");
		this.bone6 = this.right.getChild("bone6");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition single = partdefinition.addOrReplaceChild("single", CubeListBuilder.create().texOffs(51, 1).mirror().addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(51, 1).mirror().addBox(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(76, 40).mirror().addBox(-7.0F, -6.0F, -7.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(76, 40).mirror().addBox(-7.0F, -11.0F, -7.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(68, 40).mirror().addBox(-8.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(68, 40).addBox(7.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 22).mirror().addBox(-8.0F, -15.0F, -6.0F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone7 = single.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(4, 52).mirror().addBox(-8.0F, -4.0F, -8.0F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -11.0F, 0.75F));

		PartDefinition bone8 = single.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(4, 52).mirror().addBox(-8.0F, -4.0F, -8.0F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -6.0F, 0.75F));

		PartDefinition bone9 = single.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(4, 52).mirror().addBox(-8.0F, -4.0F, -8.0F, 14.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -1.0F, 0.75F));

		PartDefinition left = partdefinition.addOrReplaceChild("left", CubeListBuilder.create().texOffs(64, 47).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(64, 47).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
				.texOffs(31, 98).addBox(-8.0F, -6.0F, -7.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(31, 98).addBox(-8.0F, -11.0F, -7.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(68, 40).addBox(7.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(66, 91).addBox(-8.0F, -15.0F, -6.0F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone2 = left.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(3, 72).addBox(-7.0F, -4.0F, -8.0F, 15.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -11.0F, 0.75F));

		PartDefinition bone3 = left.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(3, 72).addBox(-7.0F, -4.0F, -8.0F, 15.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -6.0F, 0.75F));

		PartDefinition bone5 = left.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(3, 72).addBox(-7.0F, -4.0F, -8.0F, 15.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.75F));

		PartDefinition right = partdefinition.addOrReplaceChild("right", CubeListBuilder.create().texOffs(64, 47).mirror().addBox(-8.0F, -16.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(64, 47).mirror().addBox(-8.0F, -1.0F, -8.0F, 16.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(31, 98).mirror().addBox(-7.0F, -6.0F, -7.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(31, 98).mirror().addBox(-7.0F, -11.0F, -7.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(68, 40).mirror().addBox(-8.0F, -15.0F, -7.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(66, 91).mirror().addBox(-8.0F, -15.0F, -6.0F, 16.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone = right.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(3, 72).mirror().addBox(-8.0F, -4.0F, -8.0F, 15.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -11.0F, 0.75F));

		PartDefinition bone4 = right.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(3, 72).mirror().addBox(-8.0F, -4.0F, -8.0F, 15.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -6.0F, 0.75F));

		PartDefinition bone6 = right.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(3, 72).mirror().addBox(-8.0F, -4.0F, -8.0F, 15.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, -1.0F, 0.75F));

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

	public void setDrawerAngles(float openProgress) {
		float bottomDrawerDistance = openProgress * 2.5f;
		float middleDrawerDistance = openProgress * 4f;
		float topDrawerDistance = openProgress * 6f;

		bone7.z = 0.75F - bottomDrawerDistance; // 下面的抽屉
		bone8.z = 0.75F - middleDrawerDistance; // 中间的抽屉
		bone9.z = 0.75F - topDrawerDistance;    // 上面的抽屉

		bone2.z = 0.75F - bottomDrawerDistance;
		bone3.z = 0.75F - middleDrawerDistance;
		bone5.z = 0.75F - topDrawerDistance;

		bone.z = 0.75F - bottomDrawerDistance;
		bone4.z = 0.75F - middleDrawerDistance;
		bone6.z = 0.75F - topDrawerDistance;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		single.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}