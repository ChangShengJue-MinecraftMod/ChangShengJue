package com.shengchanshe.changshengjue.item.combat.sword;

import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.xuannu_swordsmanship.XuannuSwordsmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.item.render.combat.sword.SoftSwordRender;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.XuannuSwordsmanshipPacket;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class SoftSword extends Sword implements GeoItem {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public SoftSword() {
        super(Tiers.IRON, 3, -2.4F, new Item.Properties().durability(1200));
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            player.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
                if (xuannuSwordsmanship.xuannuSwordsmanshipComprehend() && xuannuSwordsmanship.getXuannuSwordsmanshipLevel() == 0) {
                    float probability = player.getRandom().nextFloat();
                    float defaultProbability = 0.02F;
                    if (probability < defaultProbability) {
                        xuannuSwordsmanship.addXuannuSwordsmanshipLevel();
                        ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),xuannuSwordsmanship.isXuannuSwordsmanshipComprehend()), (ServerPlayer) player);
                    }
                }
            });
        }
        return super.onLeftClickEntity(stack, player, entity);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() == ChangShengJueItems.SOFT_SWORD.get()) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(XuannuSwordsmanshipCapabilityProvider.XUANNU_SWORDSMANSHIP_CAPABILITY).ifPresent(xuannuSwordsmanship -> {
                        if (xuannuSwordsmanship.xuannuSwordsmanshipComprehend()) {
                            this.onXuannuSwordsmanship(pLevel, xuannuSwordsmanship.getXuannuSwordsmanshipLevel(), pPlayer, xuannuSwordsmanship);
                            triggerAnim(pPlayer, GeoItem.getOrAssignId(pPlayer.getItemInHand(pUsedHand), (ServerLevel) pLevel), "Attack", "attack");
                        }
                    });
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }
    private void onXuannuSwordsmanship(Level pLevel, int martialArtsLevel, LivingEntity pEntity, XuannuSwordsmanshipCapability xuannuSwordsmanship) {
        float radius = 4.0f;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius, radius, radius));//创建包围盒
        if (pEntity instanceof Player player) {
            if (martialArtsLevel != 0) {
                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                for (Entity entity : entities) {//遍历包围盒中的实体
                    //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                    if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                        float damage;
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = 0.15F;
                        if (martialArtsLevel < 2) {
                            damage = (this.getDamage() + 2) * 1.8F;
                            if (probability < defaultProbability) {
                                if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                    ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, false), player);
                                }
                            }
                        } else {
                            damage = (this.getDamage() + 2) * 2.0F;
                            if (probability < (defaultProbability * 1.2F)) {
                                if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                    ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, false), player);
                                }
                            }
                        }
                        if (entity.hurt(player.damageSources().playerAttack(player), damage)) {//造成伤害
                            if (xuannuSwordsmanship.getXuannuSwordsmanshipUseCount() <= 100){
                                xuannuSwordsmanship.addXuannuSwordsmanshipUseCount();
                                ChangShengJueMessages.sendToPlayer(new XuannuSwordsmanshipPacket(xuannuSwordsmanship.getXuannuSwordsmanshipLevel(),xuannuSwordsmanship.isXuannuSwordsmanshipComprehend()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                if (!player.getAbilities().instabuild){
                    player.getFoodData().eat(-3, -2);//消耗饱食度
                    player.getCooldowns().addCooldown(itemstack.getItem(), 80);//添加使用冷却
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
//                XuannuSwordsmanshipEntity xuannuSwordsmanshipsEntity = new XuannuSwordsmanshipEntity(ChangShengJueEntity.DUGU_NINE_SOWRDS_ENTITY.get(), pLevel);
//                xuannuSwordsmanshipsEntity.moveTo(hitLocation);
//                xuannuSwordsmanshipsEntity.setYRot(player.getYRot());
//                pLevel.addFreshEntity(xuannuSwordsmanshipsEntity);
            }
        }
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private SoftSwordRender renderer = null;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.renderer == null) {
                    this.renderer = new SoftSwordRender();
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
