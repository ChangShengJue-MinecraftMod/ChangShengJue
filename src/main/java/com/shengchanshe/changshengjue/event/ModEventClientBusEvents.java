package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.client.render.PeacockEggRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class ModEventClientBusEvents {
//    @SubscribeEvent
//    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
////        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.ANIMATED_BLOCK_ENTITY.get(), AnimatedLotusBlockRenderer::new);
//    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //投掷物的渲染
        event.registerEntityRenderer(ChangShengJueEntity.PEACOCK_EGG.get(), PeacockEggRender::new);
    }
}
