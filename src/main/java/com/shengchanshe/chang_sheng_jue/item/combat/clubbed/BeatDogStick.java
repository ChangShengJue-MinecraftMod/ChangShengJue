package com.shengchanshe.chang_sheng_jue.item.combat.clubbed;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;

import java.util.function.Consumer;

public class BeatDogStick extends Clubbed {
    public BeatDogStick() {
        super(Tiers.IRON, 5, -2.4F, new Properties().fireResistant().durability(4500).setNoRepair().rarity(Rarity.UNCOMMON));
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private BeatDogStickRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new BeatDogStickRender();
                }
                return renderer;
            }
        });
    }
    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.enchant(Enchantments.MENDING, 1);
        stack.enchant(Enchantments.KNOCKBACK, 2);
        return stack;
    }
}
