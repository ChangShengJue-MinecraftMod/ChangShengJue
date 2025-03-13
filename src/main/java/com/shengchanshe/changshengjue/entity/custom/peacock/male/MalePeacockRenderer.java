package com.shengchanshe.changshengjue.entity.custom.peacock.male;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.custom.monkey.Monkey;
import com.shengchanshe.changshengjue.entity.custom.peacock.PeacockVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class MalePeacockRenderer extends GeoEntityRenderer<MalePeacock> {
    public static final Map<PeacockVariant,ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PeacockVariant.class),(map)->{
                map.put(PeacockVariant.MALE,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/peacock/male_peacock.png"));
                map.put(PeacockVariant.WHITE,
                        new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/peacock/white_peacock.png"));
            });
    public MalePeacockRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MalePeacockModel());
        this.shadowRadius = 0.3f;//阴影半径
    }

    //获取纹理位置
    @Override
    public ResourceLocation getTextureLocation(MalePeacock malePeacock) {
        if (malePeacock.isBaby()){
            return new ResourceLocation(ChangShengJue.MOD_ID,"textures/entity/peacock/peacock_baby.png");
        }else {
            return LOCATION_BY_VARIANT.get(malePeacock.getVariant());
        }
    }

    //获取渲染类型
    @Override
    public void render(MalePeacock entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
