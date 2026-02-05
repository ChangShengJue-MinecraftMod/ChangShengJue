package com.shengchanshe.chang_sheng_jue.entity.custom.checkin;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

/**
 * 签到NPC模型
 */
public class CheckInNPCModel extends DefaultedEntityGeoModel<CheckInNPC> {
	public CheckInNPCModel() {
        super(new ResourceLocation(ChangShengJue.MOD_ID, "checkin_npc"));
    }
}
