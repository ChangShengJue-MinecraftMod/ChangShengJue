package com.shengchanshe.chang_sheng_jue.item.combat.knife;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class HengDao extends Knife {
    public HengDao() {
        super(Tiers.IRON, 4, -2.4F, new Properties().durability(1500));
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private HengDaoRender renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new HengDaoRender();
                }
                return renderer;
            }
        });
    }

}
