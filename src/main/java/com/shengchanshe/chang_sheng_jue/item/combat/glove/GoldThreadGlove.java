package com.shengchanshe.chang_sheng_jue.item.combat.glove;

import com.shengchanshe.chang_sheng_jue.item.combat.book.*;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class GoldThreadGlove extends SwordItem implements GeoItem {
    private final AnimatableInstanceCache CACHE = GeckoLibUtil.createInstanceCache(this);
    public GoldThreadGlove() {
        super(Tiers.IRON, 2, -2.4F, new Properties());
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            GeShanDaNiu.comprehend(player,player.level(),entity);
//            GoldenBellJar.comprehend(player,player.level());
            Hercules.comprehend(player,player.level());

//            QianKunDaNuoYi.comprehend(player,player.level());
            SunflowerPointCaveman.comprehend(player,player.level(),entity);
            TurtleBreathWork.comprehend(player,player.level());
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (!pPlayer.level().isClientSide) {
            SunflowerPointCaveman.onSunflowerPointCaveman(pPlayer.level() ,pPlayer,pInteractionTarget);
        }
        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品

        if (!pLevel.isClientSide) {
            if (pPlayer.getFoodData().getFoodLevel() > 8) {
                if (itemstack.getItem() instanceof GoldThreadGlove) {
                    GeShanDaNiu.onGeShanDaNiu(pLevel, pPlayer);
//                    GoldenBellJar.onGoldenBellJar(pLevel, pPlayer);
                    Hercules.onHercules(pLevel, pPlayer);
//                    QianKunDaNuoYi.onQianKunDaNuoYi(pLevel, pPlayer);
                    TurtleBreathWork.onTurtleBreathWork(pLevel, pPlayer);
                    return InteractionResultHolder.success(pPlayer.getMainHandItem());
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        return super.useOn(pContext);
    }

    @Override
    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pRemainingUseDuration) {
        super.onUseTick(pLevel, pLivingEntity, pStack, pRemainingUseDuration);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GoldThreadGloveRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new GoldThreadGloveRender();
                }
                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return CACHE;
    }
}
