package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.villain;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class VillainModel extends DefaultedEntityGeoModel<Villain> {
	public VillainModel() {
		super(new ResourceLocation(ChangShengJue.MOD_ID, "villain"));
	}

	@Override
	public void setCustomAnimations(Villain animatable, long instanceId, AnimationState<Villain> animationState) {
		CoreGeoBone head =  getAnimationProcessor().getBone("Head");
		if (head != null){
			EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
		super.setCustomAnimations(animatable, instanceId, animationState);
    }
}