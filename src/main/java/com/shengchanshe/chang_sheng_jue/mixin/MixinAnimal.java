package com.shengchanshe.chang_sheng_jue.mixin;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Animal.class)
public class MixinAnimal {
    @Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
    public void isFood(ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        if (pStack.is(Items.WHEAT) || pStack.is(ChangShengJueItems.THATCH.get())) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }
}
