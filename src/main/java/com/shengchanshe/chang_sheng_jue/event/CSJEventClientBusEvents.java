package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigleft.entity.BigShingMunLeftEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigright.entity.BigShingMunRightEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.left.entity.ShingMunLeftEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.right.entity.ShingMunRightEntityRender;
import com.shengchanshe.chang_sheng_jue.block.decoration.windchime.WindChimeEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.desk.entity.DesksEntityRender;
import com.shengchanshe.chang_sheng_jue.block.entity.render.*;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.gao_marksmanship.GaoMarksmanshipHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.hercules.HerculesHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.immortal_miracle.ImmortalMiracleHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.qian_kun_da_nuo_yi.QianKunDaNuoYiHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.relentless_throwing_knives.RelentlessThrowingKnivesHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.shaolin_stick_method.ShaolinStickMethodHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.sunflower_point_caveman.SunflowerPointCavemanHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.turtle_breath_work.TurtleBreathWorkHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipHudOverlay;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.stakes.StakesModel;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntityModel;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.egg.PeacockEggRender;
import com.shengchanshe.chang_sheng_jue.entity.decoration.seat.SeatRender;
import com.shengchanshe.chang_sheng_jue.entity.villagers.warrior.WarriorModel;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorkerModel;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.particle.custom.block.LeavesDefoliationParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.ComprehendParticle2;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.DachengParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.ge_shan_da_niu.GeShanDaNiuParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.immortal_miracle.ImmortalMiracleParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.sunflower_point_caveman.SunflowerPointCavemanParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.sunflower_point_caveman.SunflowerPointCavemanParticle1;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.sunflower_point_caveman.SunflowerPointCavemanParticle2;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.throwingknives.ThrowingknivesParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.tread_the_snow_without_trace.TreadTheSnowWithoutTraceParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.wu_gang_cut_gui.WuGangCutGuiParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.martial_arts.wu_gang_cut_gui.WuGangCutGuiParticle1;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal.MortalBreakthrough3Particle;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal.MortalBreakthrough0Particle;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal.MortalBreakthrough1Particle;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.mortal.MortalBreakthrough2Particle;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.breakthrough.qi_condensation.*;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.tun_na.TunNa1Particle;
import com.shengchanshe.chang_sheng_jue.particle.custom.xiu_xian.tun_na.TunNaParticle;
import com.shengchanshe.chang_sheng_jue.util.KeyBinding;
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

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.DESK.get(), DesksEntityRender::new);

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

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.WIND_CHIME_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new WindChimeEntityRender());
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
//        event.registerAboveAll("hud_cultivation", CultivationHudOverlay.HUD_CULTIVATION);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {

        event.registerSpriteSet(ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get(), LeavesDefoliationParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.GUI_HUA_DEFOLIATION_PARTICLE.get(), LeavesDefoliationParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.MEI_HUA_DEFOLIATION_PARTICLE.get(), LeavesDefoliationParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.COMPREHEND_PARTICLE.get(), ComprehendParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.COMPREHEND_PARTICLE_2.get(), ComprehendParticle2.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.DACHENG_PARTICLE.get(), DachengParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.IMMORTAL_MIRACLE_PARTICLE.get(), ImmortalMiracleParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE.get(), SunflowerPointCavemanParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE_1.get(), SunflowerPointCavemanParticle1.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.SUNFLOWER_POINT_CAVEMAN_PARTICLE_2.get(), SunflowerPointCavemanParticle2.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE.get(), WuGangCutGuiParticle.Provider::new);
        event.registerSpriteSet(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE_1.get(), WuGangCutGuiParticle1.Provider::new);


        event.registerSpriteSet(ChangShengJueParticles.TREAD_THE_SNOW_WITHOUT_TRACE_PARTICLE.get(), TreadTheSnowWithoutTraceParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.GE_SHAN_DA_NIU_PARTICLE.get(), GeShanDaNiuParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.THROWING_KNIVES_PARTICLE.get(), ThrowingknivesParticle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.TUN_NA_PARTICLE.get(), TunNaParticle.TunNaParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.TUN_NA_1_PARTICLE.get(), TunNa1Particle.TunNa1ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.MORTAL_BREAKTHROUGH0_PARTICLE.get(), MortalBreakthrough0Particle.BreakthroughParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.MORTAL_BREAKTHROUGH1_PARTICLE.get(), MortalBreakthrough1Particle.Breakthrough1ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.MORTAL_BREAKTHROUGH2_PARTICLE.get(), MortalBreakthrough2Particle.Breakthrough2ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.MORTAL_BREAKTHROUGH3_PARTICLE.get(), MortalBreakthrough3Particle.Breakthrough3ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH0_PARTICLE.get(),
                QiCondensationBreakthrough0Particle.QiCondensationBreakthrough0ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH1_PARTICLE.get(),
                QiCondensationBreakthrough1Particle.QiCondensationBreakthrough1ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH2_PARTICLE.get(),
                QiCondensationBreakthrough2Particle.QiCondensationBreakthrough2ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH3_PARTICLE.get(),
                QiCondensationBreakthrough3Particle.QiCondensationBreakthrough3ParticleProvider::new);
        event.registerSpriteSet(ChangShengJueParticles.QI_CONDENSATION_BREAKTHROUGH4_PARTICLE.get(),
                QiCondensationBreakthrough4Particle.QiCondensationBreakthrough4ParticleProvider::new);
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
