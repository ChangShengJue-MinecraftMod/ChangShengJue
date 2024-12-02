package com.shengchanshe.changshengjue.item.combat.clubbed;

import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.item.combat.lance.Lance;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ShaolinStickMethodPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Clubbed extends SwordItem {
    public Clubbed(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player pPlayer, Entity entity) {
        if (!pPlayer.level().isClientSide) {
            pPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                if (shaolinStickMethod.getShaolinStickMethodComprehend() && shaolinStickMethod.getShaolinStickMethodLevel() == 0) {
                    float probability = pPlayer.getRandom().nextFloat();
                    float defaultProbability = 1;
                    if (probability < defaultProbability) {
                        shaolinStickMethod.addShaolinStickMethodLevel();
                        ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethod.getShaolinStickMethodLevel(),shaolinStickMethod.isShaolinStickMethodComprehend()), (ServerPlayer) pPlayer);
                    }
                }
            });
        }
        return super.onLeftClickEntity(stack, pPlayer, entity);
    }

    @SubscribeEvent
    public void onKnifeAttack(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                LivingEntity entity = event.getEntity();
                directEntity.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                    int shaolinStickMethodLevel = shaolinStickMethod.getShaolinStickMethodLevel();
                    if (shaolinStickMethodLevel != 0){
                        if (directEntity.getMainHandItem().getItem() == this){
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.15F;
                            if(shaolinStickMethodLevel < 2){
                                if (probability < defaultProbability){
                                    entity.addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 10, 1, false, false), directEntity);
                                }
                            }else {
                                if (probability < defaultProbability * 1.2){
                                    entity.addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 10, 1, false, false), directEntity);
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() == this) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                        if (shaolinStickMethod.getShaolinStickMethodComprehend()) {
                            this.onShaolinStickMethod(pLevel, pPlayer,shaolinStickMethod);
                        }
                    });
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void onShaolinStickMethod(Level pLevel, LivingEntity pEntity, ShaolinStickMethodCapability shaolinStickMethodCapability) {
        float radius = 5.0f;//攻击半径
        float distance = 5.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3F, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius, radius, radius));//创建包围盒
        if (pEntity instanceof Player player) {
            if (shaolinStickMethodCapability.getShaolinStickMethodLevel() != 0) {
                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                for (Entity entity : entities) {//遍历包围盒中的实体
                    //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                    if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                        float damage;
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = 0.15F;
                        if (shaolinStickMethodCapability.getShaolinStickMethodLevel() < 2 ) {
                            damage = (this.getDamage() + 2) * 1.5F;
                            if (probability < defaultProbability) {
                                ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 14, 1, false, false), player);
                            }
                        } else {
                            damage = (this.getDamage() + 2) * 1.8F;
                            if (probability < (defaultProbability * 1.2F)) {
                                ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 14, 1, false, false), player);
                            }
                        }
                        if (entity.hurt(player.damageSources().playerAttack(player), damage)) {//造成伤害
                            if (shaolinStickMethodCapability.getShaolinStickMethodUseCount() <= 100) {
                                shaolinStickMethodCapability.addShaolinStickMethodUseCount();
                                ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethodCapability.getShaolinStickMethodLevel(),
                                        shaolinStickMethodCapability.isShaolinStickMethodComprehend()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                if (!player.getAbilities().instabuild) {
                    player.getFoodData().eat(-3, -2);//消耗饱食度
                    player.getCooldowns().addCooldown(itemstack.getItem(), 160);//添加使用冷却
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }
}
