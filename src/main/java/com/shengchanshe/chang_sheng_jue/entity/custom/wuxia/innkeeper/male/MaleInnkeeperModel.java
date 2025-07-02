package com.shengchanshe.chang_sheng_jue.entity.custom.wuxia.innkeeper.male;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MaleInnkeeperModel extends DefaultedEntityGeoModel<MaleInnkeeper> {
	public MaleInnkeeperModel() {
		super(new ResourceLocation(ChangShengJue.MOD_ID, "innkeeper/male_innkeeper"));
	}

	@Override
	public void setCustomAnimations(MaleInnkeeper animatable, long instanceId, AnimationState<MaleInnkeeper> animationState) {
		CoreGeoBone head =  getAnimationProcessor().getBone("Head");
		if (head != null){
			EntityModelData entityModelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityModelData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityModelData.netHeadYaw() * Mth.DEG_TO_RAD);
		}
		super.setCustomAnimations(animatable, instanceId, animationState);
    }
}