package com.shengchanshe.changshengjue.item.combat.sword;

import com.shengchanshe.changshengjue.item.combat.knife.TuLongDaoRender;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class HanJian extends Sword implements GeoItem {
    public HanJian() {
        super(Tiers.IRON, 4, -2.4F, new Item.Properties().durability(1500));
    }
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
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
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
