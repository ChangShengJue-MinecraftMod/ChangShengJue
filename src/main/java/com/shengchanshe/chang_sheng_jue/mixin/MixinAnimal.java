package com.shengchanshe.chang_sheng_jue.mixin;

import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Animal.class)
public class MixinAnimal {

    // 定义一个常量FOOD_ITEMS，类型为Ingredient
    private static final Ingredient FOOD_ITEMS;
    // 在isFood方法执行前，注入一个方法，如果pStack是FOOD_ITEMS中的物品，则返回true，并取消后续操作
    // 注入方法，在方法头部执行，可取消
    @Inject(method = "isFood", at = @At("HEAD"), cancellable = true)
    public void isFood(ItemStack pStack, CallbackInfoReturnable<Boolean> cir) {
        // 如果pStack是FOOD_ITEMS中的物品
        if (FOOD_ITEMS.test(pStack)) {
            // 返回true
            cir.setReturnValue(true);
            // 取消后续操作
            cir.cancel();
        }
    }
    // 静态代码块，初始化FOOD_ITEMS
    static {
        // FOOD_ITEMS包含WHEAT和THATCH
        FOOD_ITEMS = Ingredient.of(new ItemLike[]{Items.WHEAT,  ChangShengJueItems.THATCH.get()});
    }

}
