package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.gangleader.other;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GangLeaderModel extends GeoModel<GangLeader> {

	@Override
	public ResourceLocation getModelResource(GangLeader gangLeader) {
		return GangLeaderRenderer.CAPE_GEO.get(gangLeader.getVariant());
	}

	@Override
	public ResourceLocation getTextureResource(GangLeader gangLeader) {
		return GangLeaderRenderer.CAPE_TEXTURE.get(gangLeader.getVariant());
	}

	@Override
	public ResourceLocation getAnimationResource(GangLeader gangLeader) {
		return GangLeaderRenderer.CAPE_ANIMATION.get(gangLeader.getVariant());
	}

	@Override
	public void setCustomAnimations(GangLeader animatable, long instanceId, AnimationState<GangLeader> animationState) {
		CoreGeoBone head =  getAnimationProcessor().getBone("Head");
		if (head != null){
			EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
		super.setCustomAnimations(animatable, instanceId, animationState);
    }
}