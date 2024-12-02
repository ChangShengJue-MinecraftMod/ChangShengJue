package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.item.combat.lance.Lance;
import com.shengchanshe.changshengjue.item.render.combat.clubbed.PanHuaGunRender;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class PanHuaGun extends Clubbed implements GeoItem {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public PanHuaGun() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties().durability(2000));
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() instanceof Lance) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                        if (shaolinStickMethod.getShaolinStickMethodComprehend()) {
                            pPlayer.startUsingItem(pUsedHand);
                            triggerAnim(pPlayer, GeoItem.getOrAssignId(pPlayer.getItemInHand(pUsedHand), (ServerLevel) pLevel), "Attack", "attack");
                        }
                    });
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
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

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController(this, "idle",0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
        controllerRegistrar.add(new AnimationController<>(this, "Attack", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("attack", DefaultAnimations.ATTACK_SWING));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
