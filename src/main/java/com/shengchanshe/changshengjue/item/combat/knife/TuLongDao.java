package com.shengchanshe.changshengjue.item.combat.knife;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;


public class TuLongDao extends Knife implements GeoItem {
    public TuLongDao() {
        super(Tiers.IRON, 5, -2.4F, new Properties().durability(4000).fireResistant());
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.MENDING, 1);
        stack.enchant(Enchantments.MOB_LOOTING, 3);
        return stack;
    }

    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private TuLongDaoRender renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new TuLongDaoRender();
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
