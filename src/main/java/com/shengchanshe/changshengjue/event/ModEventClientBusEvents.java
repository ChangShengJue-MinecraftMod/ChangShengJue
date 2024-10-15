package com.shengchanshe.changshengjue.event;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.block.ChangShengJueBlocksEntities;
import com.shengchanshe.changshengjue.block.entity.render.PotteryWheelEntityRender;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.client.render.PeacockEggRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ChangShengJue.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //投掷物的渲染
        event.registerEntityRenderer(ChangShengJueEntity.PEACOCK_EGG.get(), PeacockEggRender::new);
        //方块实体的渲染
        event.registerBlockEntityRenderer(ChangShengJueBlocksEntities.POTTERY_WHEEL_ENTITY.get(), PotteryWheelEntityRender::new);
    }
}
