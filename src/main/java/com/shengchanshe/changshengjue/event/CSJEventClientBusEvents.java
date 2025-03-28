package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.custom.shing_mun.bigleft.entity.BigShingMunLeftEntityRender;
import com.shengchanshe.changshengjue.block.custom.shing_mun.bigright.entity.BigShingMunRightEntityRender;
import com.shengchanshe.changshengjue.block.custom.shing_mun.left.entity.ShingMunLeftEntityRender;
import com.shengchanshe.changshengjue.block.custom.shing_mun.right.entity.ShingMunRightEntityRender;
import com.shengchanshe.changshengjue.block.entity.desk.DeskRender;
import com.shengchanshe.changshengjue.block.entity.render.*;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.gao_marksmanship.GaoMarksmanshipHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.hercules.HerculesHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.turtle_breath_work.TurtleBreathWorkHudOverlay;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipHudOverlay;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntityModel;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesModel;
import com.shengchanshe.changshengjue.entity.custom.peacock.egg.PeacockEggRender;
import com.shengchanshe.changshengjue.entity.combat.throwingknives.ThrowingKnivesEntityRender;
import com.shengchanshe.changshengjue.entity.decoration.seat.SeatRender;
import com.shengchanshe.changshengjue.entity.villagers.warrior.WarriorModel;
import com.shengchanshe.changshengjue.entity.villagers.worker.KilnWorkerModel;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.particle.custom.PoplarDefoliationParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.ComprehendParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.ComprehendParticle2;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.DachengParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.ge_shan_da_niu.GeShanDaNiuParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.golden_bell_jar.GoldenBellJarParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.immortal_miracle.ImmortalMiracleParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.sunflower_point_caveman.SunflowerPointCavemanParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.sunflower_point_caveman.SunflowerPointCavemanParticle1;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.sunflower_point_caveman.SunflowerPointCavemanParticle2;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.throwingknives.ThrowingknivesParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.wu_gang_cut_gui.WuGangCutGuiParticle;
import com.shengchanshe.changshengjue.particle.custom.martial_arts.wu_gang_cut_gui.WuGangCutGuiParticle1;
import com.shengchanshe.changshengjue.util.KeyBinding;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class CSJEventClientBusEvents {

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //投掷物的渲染
        event.registerEntityRenderer(ChangShengJueEntity.PEACOCK_EGG.get(), PeacockEggRender::new);
        event.registerEntityRenderer(ChangShengJueEntity.THROWING_KNIVES_ENTITY.get(), ThrowingKnivesEntityRender::new);
        //方块实体的渲染
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.POTTERY_WHEEL_ENTITY.get(), PotteryWheelEntityRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.TOOL_TABLE_ENTITY.get(), ToolTableEntityRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.WEAPON_RACK_ENTITY.get(), WeaponRackRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.BLUE_AND_WHITE_PORCELAIN_FLOWER_POTS_ENTITY.get(), BlueAndWhitePorcelainFlowerPotsEntityRender::new);
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.CHANG_SHENG_JUE_LOOM_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context context) -> new ChangShengJueLoomBlockEntityRender());
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.CASTING_MOLDS_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context context) -> new CastingMoldsBlockEntityRender());
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.BULLIONS_CASTING_MOLDS_BLOCK_ENTITY.get(), (BlockEntityRendererProvider.Context context) -> new BullionsCastingMoldsBlockEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.DESK.get(), DeskRender::new);

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.SHING_MUN_LEFT_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new ShingMunLeftEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.SHING_MUN_RIGHT_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new ShingMunRightEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.BIG_SHING_MUN_LEFT_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new BigShingMunLeftEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.BIG_SHING_MUN_RIGHT_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new BigShingMunRightEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.PLAQUE_ENTITY.get(), PlaqueEntityRender::new);

        event.registerEntityRenderer(ChangShengJueEntity.SEAT.get(), SeatRender::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ThrowingKnivesEntityModel.LAYER_LOCATION, ThrowingKnivesEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
        event.registerAboveAll("dugu_nine_swords_hud", DuguNineSwordsHudOverlay.HUD_DUGU_NINE_SWORDS);
        event.registerAboveAll("golden_black_knife_method_hud", GoldenBlackKnifeMethodHudOverlay.HUD_GOLDEN_BLACK_KNIFE_METHOD);
        event.registerAboveAll("xuannu_swordsmanship_hud", XuannuSwordsmanshipHudOverlay.HUD_XUANNU_SWORDSMANSHIP);
        event.registerAboveAll("gao_marksmanship_hud", GaoMarksmanshipHudOverlay.HUD_GAO_MARKSMANSHIP);
        event.registerAboveAll("shaolin_stick_method_hud", ShaolinStickMethodHudOverlay.HUD_SHAOLIN_STICK_METHOD);
        event.registerAboveAll("tread_the_snow_without_trace_hud", TreadTheSnowWithoutTraceHudOverlay.HUD_TREAD_THE_SNOW_WITHOUT_TRACE);
        event.registerAboveAll("sunflower_point_caveman_hud", SunflowerPointCavemanHudOverlay.HUD_SUNFLOWER_POINT_CAVEMAN);
        event.registerAboveAll("golden_bell_jar_hud", GoldenBellJarHudOverlay.HUD_GOLDEN_BELL_JAR);
        event.registerAboveAll("immortal_miracle_hud", ImmortalMiracleHudOverlay.HUD_IMMORTAL_MIRACLE);
        event.registerAboveAll("ge_shan_da_niu_hud", GeShanDaNiuHudOverlay.HUD_GE_SHAN_DA_NIU);
        event.registerAboveAll("turtle_breath_work_hud", TurtleBreathWorkHudOverlay.HUD_TURTLE_BREATH_WORK);
        event.registerAboveAll("relentless_throwing_knives_hud", RelentlessThrowingKnivesHudOverlay.HUD_RELENTLESS_THROWING_KNIVES);
        event.registerAboveAll("qian_kun_da_nuo_yi_hud", QianKunDaNuoYiHudOverlay.HUD_QIAN_KUN_DA_NUO_YI);
        event.registerAboveAll("hercules_hud", HerculesHudOverlay.HUD_HERCULES);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {

//        event.registerSpecial(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN.get(), new SunflowerPointCavemanParticle.Provider());
        event.registerSpriteSet(ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get(), PoplarDefoliationParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), ComprehendParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.COMPREHEND_PARTICLE_2.get(), ComprehendParticle2.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.DACHENG_PARTICLE.get(), DachengParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.IMMORTAL_MIRACLE_PARTICLE.get(), ImmortalMiracleParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE.get(), SunflowerPointCavemanParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE_1.get(), SunflowerPointCavemanParticle1.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE_2.get(), SunflowerPointCavemanParticle2.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE.get(), WuGangCutGuiParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE_1.get(), WuGangCutGuiParticle1.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.GOLDEN_BELL_JAR_PARTICLE.get(), GoldenBellJarParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.TREAD_THE_SNOW_WITHOUT_TRACE_PARTICLE.get(), TreadTheSnowWithoutTraceParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.GE_SHAN_DA_NIU_PARTICLE.get(), GeShanDaNiuParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.THROWING_KNIVES_PARTICLE.get(), ThrowingknivesParticle.Provider::new);

//        event.registerSpriteSet(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), ComprehendParticle.Provider::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(StakesModel.LAYER_LOCATION, StakesModel::createBodyLayer);
        evt.registerLayerDefinition(WarriorModel.LAYER_LOCATION, WarriorModel::createBodyLayer);
        evt.registerLayerDefinition(KilnWorkerModel.LAYER_LOCATION, KilnWorkerModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerKey(RegisterKeyMappingsEvent event){
        KeyBinding.registerKey(event);
    }

}
