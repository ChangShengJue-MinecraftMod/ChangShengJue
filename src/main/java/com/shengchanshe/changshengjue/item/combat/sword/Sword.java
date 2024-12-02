package com.shengchanshe.changshengjue.item.combat.sword;

import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.dugu_nine_swords.DuguNineSwordsEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.DuguNineSwordsPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Sword extends SwordItem {
    public Sword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!player.level().isClientSide) {
            player.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
                if (duguNineSword.duguNineSwordsComprehend() && duguNineSword.getDuguNineSwordsLevel() == 0) {
                    float probability = player.getRandom().nextFloat();
                    float defaultProbability = 0.02F;
                    if (probability < defaultProbability) {
                        duguNineSword.addDuguNineSwordsLevel();
                        ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(duguNineSword.getDuguNineSwordsLevel(),duguNineSword.isDuguNineSwordsComprehend()), (ServerPlayer) player);
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
            if (itemstack.getItem() instanceof Sword && itemstack.getItem() != ChangShengJueItems.SOFT_SWORD.get()) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
                        if (duguNineSword.duguNineSwordsComprehend()) {
                            this.onDuguNineSwords(pLevel, duguNineSword.getDuguNineSwordsLevel(), pPlayer, duguNineSword);
                        }
                    });
                    if (DuguNineSwordsClientData.getDuguNineSwordsLevel()>=1){
                        return InteractionResultHolder.success(pPlayer.getMainHandItem());
                    }
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void onDuguNineSwords(Level pLevel, int martialArtsLevel, LivingEntity pEntity, DuguNineSwordsCapability duguNineSword) {
        float radius = 4.0f;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
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
                            damage = (this.getDamage() + 2) * 1.4F;
                            if (probability < defaultProbability) {
                                if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                    ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, false), player);
                                }
                            }
                        } else {
                            damage = (this.getDamage() + 2) * 1.6F;
                            if (probability < (defaultProbability * 1.2F)) {
                                if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                    ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, false), player);
                                }
                            }
                        }
                        if (entity.hurt(player.damageSources().playerAttack(player), damage)) {//造成伤害
                            if (duguNineSword.getDuguNineSwordsUseCount() <= 100){
                                duguNineSword.addDuguNineSwordsUseCount();
                                ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket(duguNineSword.getDuguNineSwordsLevel(),duguNineSword.isDuguNineSwordsComprehend()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                if (!player.getAbilities().instabuild){
                    player.getFoodData().eat(-3, -2);//消耗饱食度
                    player.getCooldowns().addCooldown(itemstack.getItem(), 100);//添加使用冷却
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
                DuguNineSwordsEntity duguNineSwordsEntity = new DuguNineSwordsEntity(ChangShengJueEntity.DUGU_NINE_SOWRDS_ENTITY.get(), pLevel);
                duguNineSwordsEntity.moveTo(hitLocation);
                duguNineSwordsEntity.setYRot(player.getYRot());
                pLevel.addFreshEntity(duguNineSwordsEntity);
            }
        }
    }

    public boolean isLivingSkeletonAndGolemAndSlime(LivingEntity pLivingEntity) {
        return pLivingEntity instanceof AbstractSkeleton || pLivingEntity instanceof AbstractGolem || pLivingEntity instanceof Slime || pLivingEntity instanceof SkeletonHorse;
    }
}
