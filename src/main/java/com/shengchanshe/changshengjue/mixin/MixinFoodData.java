package com.shengchanshe.changshengjue.mixin;

import com.shengchanshe.changshengjue.capability.martial_arts.hercules.HerculesCapabilityProvider;
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
    private float exhaustionLevel; // 影子字段，用于操作原始 exhaustionLevel

    @Inject(method = "addExhaustion", at = @At("HEAD"), cancellable = true)
    private void modifyExhaustion(float pExhaustion, CallbackInfo ci) {
        // 获取持有此 FoodData 的玩家实体
        Player player = getAssociatedPlayer(); // 自定义方法获取玩家实体

        if (player != null) {
//            // 获取 HerculesCapability
            AtomicReference<Float> pExhaustionRef = new AtomicReference<>(pExhaustion);
            player.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
                if (hercules.getHerculesLevel() >= 1 &&player.isSprinting()) {
                    pExhaustionRef.set(pExhaustionRef.get() * 0.5F);
                }
            });
            // 将修改后的疲劳值添加到 exhaustionLevel 中
            this.exhaustionLevel = Math.min(this.exhaustionLevel + pExhaustionRef.get(), 40.0F);
        }
        // 将修改后的疲劳值添加到 exhaustionLevel 中
        this.exhaustionLevel = Math.min(this.exhaustionLevel + pExhaustion, 40.0F);
        // 阻止原始方法的执行
        ci.cancel();
    }

    /**
     * 自定义方法，用于获取 FoodData 所关联的玩家实体。
     */
    private Player getAssociatedPlayer() {
        MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
        if (server != null) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                if (player.getFoodData() == (Object) this) {
                    return player; // 找到绑定的玩家并返回
                }
            }
        }
        return null; // 如果找不到，返回 null
    }
}
