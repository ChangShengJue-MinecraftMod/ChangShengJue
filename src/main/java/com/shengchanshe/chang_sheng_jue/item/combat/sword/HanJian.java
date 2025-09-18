package com.shengchanshe.chang_sheng_jue.item.combat.sword;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class HanJian extends Sword {
    public HanJian() {
        super(Tiers.IRON, 4, -2.4F, new Item.Properties().durability(1500));
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private HanJianRender renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new HanJianRender();
                }
                return renderer;
            }
        });
    }
}
