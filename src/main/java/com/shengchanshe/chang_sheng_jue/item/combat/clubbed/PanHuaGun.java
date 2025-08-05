package com.shengchanshe.chang_sheng_jue.item.combat.clubbed;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class PanHuaGun extends Clubbed {
    public PanHuaGun() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties().durability(2000));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private PanHuaGunRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new PanHuaGunRender();
                }
                return renderer;
            }
        });
    }

}
