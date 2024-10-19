package com.shengchanshe.changshengjue.entity.villagers.render;

import com.shengchanshe.changshengjue.ChangShengJue;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.VillagerProfessionLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.Villager;

public class ChangShengJueVillagerRender extends MobRenderer<Villager, VillagerModel<Villager>> {
    private static final ResourceLocation VILLAGER_BASE_SKIN = new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/villager/chang_sheng_jue_villager.png");

    public ChangShengJueVillagerRender(EntityRendererProvider.Context pRoot) {
        super(pRoot, new VillagerModel<>(pRoot.bakeLayer(ModelLayers.VILLAGER)), 0.5F);
        this.addLayer(new CustomHeadLayer<>(this, pRoot.getModelSet(), pRoot.getItemInHandRenderer()));
        this.addLayer(new ChangShengJueVillagerLayer<>(this, pRoot.getResourceManager(), "villager"));
        this.addLayer(new CrossedArmsItemLayer<>(this, pRoot.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Villager entity) {
        return VILLAGER_BASE_SKIN;
    }
}
