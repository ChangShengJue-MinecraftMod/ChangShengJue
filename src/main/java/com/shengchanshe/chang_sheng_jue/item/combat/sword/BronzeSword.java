package com.shengchanshe.chang_sheng_jue.item.combat.sword;

import com.shengchanshe.chang_sheng_jue.item.tiers.ChangShengJueTiers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class BronzeSword extends Sword {
    public BronzeSword() {
        super(ChangShengJueTiers.COPPER, 3, -2.4F, new Item.Properties());
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private BronzeSwordRender renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new  BronzeSwordRender();
                }
                return renderer;
            }
        });
    }
}
