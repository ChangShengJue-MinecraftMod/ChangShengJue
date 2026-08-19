package com.shengchanshe.chang_sheng_jue.cilent.setup;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.item.combat.lance.Lance;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public final class ClientItemPropertyRegistrar {
    private ClientItemPropertyRegistrar() {
    }

    public static void register(FMLClientSetupEvent event) {
        // 使用enqueueWork确保在主线程中执行物品属性注册，避免并发修改异常
        event.enqueueWork(() -> {
            ItemProperties.register(ChangShengJueItems.BA_WANG_QIANG.get(),new ResourceLocation("throwing"),(stack, clientLevel, livingEntity, i) ->
                    livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack
                            && stack.getItem() instanceof Lance lance && lance.isThrowing ? 1.0F : 0.0F);
            ItemProperties.register(ChangShengJueItems.RED_TASSELLED_SPEAR.get(),new ResourceLocation("throwing"),(stack, clientLevel, livingEntity, i) ->
                    livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack
                            && stack.getItem() instanceof Lance lance && lance.isThrowing ? 1.0F : 0.0F);
        });
    }
}

