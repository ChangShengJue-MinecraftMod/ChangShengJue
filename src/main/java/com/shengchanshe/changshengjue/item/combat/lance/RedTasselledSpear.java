package com.shengchanshe.changshengjue.item.combat.lance;

import com.shengchanshe.changshengjue.item.render.combat.lance.RedTasselledSpearRender;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class RedTasselledSpear extends Lance implements GeoItem {
//    private static final RawAnimation ACTIVATE_ANIM = RawAnimation.begin().thenPlay("attack");
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public RedTasselledSpear() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties());
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private RedTasselledSpearRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new RedTasselledSpearRender();
                }
                return renderer;
            }
        });
    }
//    @Override
//    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
//        if (level instanceof ServerLevel serverLevel)
//            triggerAnim(player, GeoItem.getOrAssignId(player.getItemInHand(hand), serverLevel), "Activation", "activate");
//
//        return super.use(level, player, hand);
//    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
//        controllerRegistrar.add(new AnimationController<>(this, "Activation", 0, state -> PlayState.STOP)
//                .triggerableAnim("activate", ACTIVATE_ANIM));
        controllerRegistrar.add(((new AnimationController(this, "idle",0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
