package com.shengchanshe.chang_sheng_jue.item.combat.sword;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;

import java.util.function.Consumer;

public class LongYuanSword extends Sword implements GeoItem {

    public LongYuanSword() {
        super(Tiers.DIAMOND, 5, -2.4F, new Item.Properties().durability(4000).fireResistant().rarity(Rarity.EPIC));
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.MENDING, 1);
        stack.enchant(Enchantments.SHARPNESS, 4);
        return stack;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private LongYuanSwordRender renderer = null;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new LongYuanSwordRender();
                }
                return renderer;
            }
        });
    }
}
