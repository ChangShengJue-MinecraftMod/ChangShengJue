package com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.lance;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.knife.KnifeGangLeader;
import com.shengchanshe.changshengjue.entity.custom.wuxia.gangleader.knife.KnifeGangLeaderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class LanceGangLeaderModel extends DefaultedEntityGeoModel<LanceGangLeader> {
	public LanceGangLeaderModel() {
		super(new ResourceLocation(ChangShengJue.MOD_ID, "gang_leader/lance_gang_leader"));
	}

	@Override
	public ResourceLocation getModelResource(LanceGangLeader animatable) {
		return KnifeGangLeaderRenderer.CAPE_GEO.get(animatable.getVariant());
	}

	@Override
	public ResourceLocation getTextureResource(LanceGangLeader knifeGangLeader) {
		return KnifeGangLeaderRenderer.CAPE_TEXTURE.get(knifeGangLeader.getVariant());
	}

	@Override
	public void setCustomAnimations(LanceGangLeader animatable, long instanceId, AnimationState<LanceGangLeader> animationState) {
		CoreGeoBone head =  getAnimationProcessor().getBone("Head");
		if (head != null){
			EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
		super.setCustomAnimations(animatable, instanceId, animationState);
    }
}