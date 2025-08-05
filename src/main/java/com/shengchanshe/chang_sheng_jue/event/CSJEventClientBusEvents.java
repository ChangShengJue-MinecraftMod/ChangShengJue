package com.shengchanshe.chang_sheng_jue.event;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.BullionsCastingMoldsBlockEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.castingmolds.CastingMoldsBlockEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.forgeblock.ForgeBlockEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.furniture.desk.entity.DesksEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.gong.GongEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.loom.ChangShengJueLoomBlockEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.plaque.PlaqueEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.pottery.PotteryWheelEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigleft.entity.BigShingMunLeftEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.bigright.entity.BigShingMunRightEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.left.entity.ShingMunLeftEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.shing_mun.right.entity.ShingMunRightEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.tailoringcase.TailoringCaseEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.tool_table.ToolTableEntityRender;
import com.shengchanshe.chang_sheng_jue.block.custom.weaponrack.WeaponRackRender;
import com.shengchanshe.chang_sheng_jue.block.decoration.flowerpot.BlueAndWhitePorcelainFlowerPotsEntityRender;
import com.shengchanshe.chang_sheng_jue.block.decoration.windchime.WindChimeEntityRender;
import com.shengchanshe.chang_sheng_jue.cilent.hud.kungfu.KungFuHudOverlay;
import com.shengchanshe.chang_sheng_jue.cilent.layer.EntityExtraLayer;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.stakes.StakesModel;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntityModel;
import com.shengchanshe.chang_sheng_jue.entity.combat.throwingknives.ThrowingKnivesEntityRender;
import com.shengchanshe.chang_sheng_jue.entity.custom.peacock.egg.PeacockEggRender;
import com.shengchanshe.chang_sheng_jue.entity.decoration.seat.SeatRender;
import com.shengchanshe.chang_sheng_jue.entity.villagers.warrior.WarriorModel;
import com.shengchanshe.chang_sheng_jue.entity.villagers.worker.KilnWorkerModel;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.particle.custom.block.ForgeBlockPartcle;
import com.shengchanshe.chang_sheng_jue.particle.custom.block.LeavesDefoliationParticle;
import com.shengchanshe.chang_sheng_jue.particle.custom.block.StakesParticle;
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

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.GONG_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new GongEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.TAILORING_CASE_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new TailoringCaseEntityRender());

        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.FORGE_BLOCK_ENTITY.get(),
                (BlockEntityRendererProvider.Context context) -> new ForgeBlockEntityRender());
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ThrowingKnivesEntityModel.LAYER_LOCATION, ThrowingKnivesEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
        event.registerAboveAll("kung_fu_hud", KungFuHudOverlay.HUD);
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

        event.registerSpriteSet(ChangShengJueParticles.FORGE_BLOCK_PARTCLE.get(), ForgeBlockPartcle.Provider::new);

        event.registerSpriteSet(ChangShengJueParticles.STAKES_PARTICLE.get(), StakesParticle.Provider::new);

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

    @SubscribeEvent
    public static void addLayersToEntities(EntityRenderersEvent.AddLayers event) {
        for (String skinType : event.getSkins()){
            event.getSkin(skinType).addLayer(new EntityExtraLayer(event.getSkin(skinType)));
        }

//        GeckoPlayer.GeckoPlayerThirdPerson.initRenderer();
    }
}
