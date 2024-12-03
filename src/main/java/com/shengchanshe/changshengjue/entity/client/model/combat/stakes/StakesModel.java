package com.shengchanshe.changshengjue.entity.client.model.combat.stakes;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class StakesModel extends HierarchicalModel<StakesEntity> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ChangShengJue.MOD_ID, "stakes"), "main");
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;

	public StakesModel(ModelPart root) {
		this.bone = root.getChild("bone");
		this.bone2 = this.bone.getChild("bone2");
		this.bone3 = this.bone2.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(16, 51).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 1.0F));

		PartDefinition bone2 = bone.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -23.0F, -2.5F, 5.0F, 22.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(17, 14).addBox(-1.0F, -14.0F, -8.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = bone2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(17, 14).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -19.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(17, 14).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -17.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition bone3 = bone2.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(20, 17).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -7.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = bone3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(22, 19).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.03F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1345F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return null;
	}

	@Override
	public void setupAnim(StakesEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

	}
}
