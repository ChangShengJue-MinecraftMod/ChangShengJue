package com.shengchanshe.changshengjue.entity.villagers.warrior;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WarriorRenderer extends HumanoidMobRenderer<Warrior, WarriorModel<Warrior>> {
    public WarriorRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new WarriorModel<>(pContext.bakeLayer(WarriorModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Warrior warrior) {
        return new ResourceLocation(ChangShengJue.MOD_ID, "textures/entity/warrior.png");
    }
}
