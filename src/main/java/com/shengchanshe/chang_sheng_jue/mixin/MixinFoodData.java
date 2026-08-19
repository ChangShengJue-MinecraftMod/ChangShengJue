package com.shengchanshe.chang_sheng_jue.mixin;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.capability.kungfu.FoodDataOwnerTracker;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Hercules;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FoodData.class)
public abstract class MixinFoodData {
    @Shadow
    private float exhaustionLevel;

    @Inject(method = "addExhaustion", at = @At("HEAD"), cancellable = true)
    private void modifyExhaustion(float pExhaustion, CallbackInfo ci) {
        Player player = getAssociatedPlayer();
        if (player == null || player.level().isClientSide) {
            return;
        }
        player.getCapability(ChangShengJueCapabiliy.KUNGFU).resolve()
                .filter(cap -> cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) >= 1)
                .filter(cap -> player.isSprinting())
                .ifPresent(cap -> {
                    this.exhaustionLevel = Math.min(this.exhaustionLevel + pExhaustion * 0.6F, 40.0F);
                    ci.cancel();
                });
    }

    @Unique
    private Player getAssociatedPlayer() {
        return FoodDataOwnerTracker.findOwner((FoodData) (Object) this);
    }
}
