package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.xia.clubbed;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ClubbedMingXiaModel extends DefaultedEntityGeoModel<ClubbedMingXia> {
	public ClubbedMingXiaModel() {
		super(new ResourceLocation(ChangShengJue.MOD_ID, "clubbed_ming_xia"));
	}

	@Override
	public void setCustomAnimations(ClubbedMingXia animatable, long instanceId, AnimationState<ClubbedMingXia> animationState) {
		CoreGeoBone head =  getAnimationProcessor().getBone("Head");
		if (head != null){
			EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
		super.setCustomAnimations(animatable, instanceId, animationState);
    }
}