package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.entity.render.*;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.gao_marksmanship.GaoMarksmanshipHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipHudOverlay;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.client.render.PeacockEggRender;
import com.shengchanshe.changshengjue.entity.client.render.combat.FeiDaoEntityRender;
import com.shengchanshe.changshengjue.entity.client.model.combat.FeiDaoModel;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.particle.custom.PoplarDefoliationParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.ComprehendParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class CSJEventClientBusEvents {

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //投掷物的渲染
        event.registerEntityRenderer(ChangShengJueEntity.PEACOCK_EGG.get(), PeacockEggRender::new);
        event.registerEntityRenderer(ChangShengJueEntity.FEI_DAO_ENTITY.get(), FeiDaoEntityRender::new);
        //方块实体的渲染
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.POTTERY_WHEEL_ENTITY.get(), PotteryWheelEntityRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.TOOL_TABLE_ENTITY.get(), ToolTableEntityRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS_ENTITY.get(), BlueAndWhitePorcelainFlowerPotsEntityRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.CHANG_SHENG_JUE_LOOM_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context context) -> new ChangShengJueLoomBlockEntityRender());
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.CASTING_MOLDS_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context context) -> new CastingMoldsBlockEntityRender());
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.BULLIONS_CASTING_MOLDS_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context context) -> new BullionsCastingMoldsBlockEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.PLAQUE_ENTITY.get(), PlaqueEntityRender::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FeiDaoModel.LAYER_LOCATION,FeiDaoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
        event.registerAboveAll("dugu_nine_swords_hud", DuguNineSwordsHudOverlay.HUD_DUGU_NINE_SWORDS);
        event.registerAboveAll("golden_black_knife_method_hud", GoldenBlackKnifeMethodHudOverlay.HUD_GOLDEN_BLACK_KNIFE_METHOD);
        event.registerAboveAll("xuannu_swordsmanship_hud", XuannuSwordsmanshipHudOverlay.HUD_XUANNU_SWORDSMANSHIP);
        event.registerAboveAll("gao_marksmanship_hud", GaoMarksmanshipHudOverlay.HUD_GAO_MARKSMANSHIP);
        event.registerAboveAll("shaolin_stick_method_hud", ShaolinStickMethodHudOverlay.HUD_SHAOLIN_STICK_METHOD);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
//        event.registerSprite(ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get(),PoplarDefoliationParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get(),
                PoplarDefoliationParticle.Provider::new);

        Minecraft.getInstance().particleEngine.register(ChangShengJueParticles.COMPREHEND_PARTICLE.get(),
                ComprehendParticle.Provider::new);

//        event.registerSpriteSet(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), ComprehendParticle.Provider::new);
    }
}
