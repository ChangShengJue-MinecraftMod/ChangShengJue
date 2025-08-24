package com.shengchanshe.chang_sheng_jue.mixin;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.Hercules;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.atomic.AtomicReference;

@Mixin(FoodData.class)
public abstract class MixinFoodData {
    @Shadow
    private float exhaustionLevel;

    @Inject(method = "addExhaustion", at = @At("HEAD"), cancellable = true)
    private void modifyExhaustion(float pExhaustion, CallbackInfo ci) {
        Player player = getAssociatedPlayer();

        if (player != null) {
            AtomicReference<Float> pExhaustionRef = new AtomicReference<>(pExhaustion);
            player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                if (cap.getKungFuLevel(Hercules.KUNG_FU_ID.toString()) >= 1 && player.isSprinting()) {
                    pExhaustionRef.set(pExhaustionRef.get() * 0.6F);
                    this.exhaustionLevel = Math.min(this.exhaustionLevel + pExhaustionRef.get(), 40.0F);
                }else {
                    this.exhaustionLevel = Math.min(this.exhaustionLevel + pExhaustion, 40.0F);
                }
            });
        }

        ci.cancel();
    }

    private Player getAssociatedPlayer() {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (player.getFoodData() == (Object) this) {
                    return player;
                }
            }
        }
        return null;
    }
}
