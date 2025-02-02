package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.item.combat.lance.Lance;
import com.shengchanshe.changshengjue.item.render.combat.clubbed.BeatDogStickRender;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.ClientUtils;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BeatDogStick extends Clubbed implements GeoItem {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public BeatDogStick() {
        super(Tiers.IRON, 4, -2.4F, new Properties().fireResistant().durability(4500).setNoRepair());
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() == this) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                        if (shaolinStickMethod.getShaolinStickMethodLevel() >= 1) {
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
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(((new AnimationController<>(this, "idle",0, (state) ->
                state.setAndContinue(DefaultAnimations.IDLE)))));
        controllerRegistrar.add(new AnimationController<>(this, "Attack", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("attack", DefaultAnimations.ATTACK_SWING).setSoundKeyframeHandler((state) -> {
                    Player player = ClientUtils.getClientPlayer();
                    if (player != null) {
                        player.playSound(ChangShengJueSound.SHAOLIN_STICK_METHOD_SOUND.get(), 1.0F, 1.0F);
                    }
                }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
