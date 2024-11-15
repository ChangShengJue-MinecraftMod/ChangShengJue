package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.entity.render.*;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.client.render.PeacockEggRender;
import com.shengchanshe.changshengjue.particle.ChangShengJueParticles;
import com.shengchanshe.changshengjue.particle.custom.PoplarDefoliationParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class CSJEventClientBusEvents {

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //投掷物的渲染
        event.registerEntityRenderer(ChangShengJueEntity.PEACOCK_EGG.get(), PeacockEggRender::new);
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
//        event.registerLayerDefinition(ChangShengJueModelLayers.CHANG_SHENG_JUE_VILLAGER_LAYER, LayerDefinition.create(VillagerModel.createBodyModel(),64, 128));
    }


    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
//        event.registerSpecial(ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get(),PoplarDefoliationParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get(),
                PoplarDefoliationParticle.Provider::new);
    }
}
