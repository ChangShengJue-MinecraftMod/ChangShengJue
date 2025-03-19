package com.shengchanshe.changshengjue.entity.custom.wuxia.innkeeper.female;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FemaleInnkeeperModel extends DefaultedEntityGeoModel<FemaleInnkeeper> {
	public FemaleInnkeeperModel() {
		super(new ResourceLocation(ChangShengJue.MOD_ID, "innkeeper/female_innkeeper"));
	}

	@Override
	public void setCustomAnimations(FemaleInnkeeper animatable, long instanceId, AnimationState<FemaleInnkeeper> animationState) {
		CoreGeoBone head =  getAnimationProcessor().getBone("Head");
		if (head != null){
			EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
		super.setCustomAnimations(animatable, instanceId, animationState);
    }
}