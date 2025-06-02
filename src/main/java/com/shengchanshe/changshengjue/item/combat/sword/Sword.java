package com.shengchanshe.changshengjue.item.combat.sword;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.dugu_nine_swords.DuguNineSwordsCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.dugu_nine_swords.DuguNineSwordsClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.dugu_nine_swords.DuguNineSwordsEntity;
import com.shengchanshe.changshengjue.entity.combat.yi_tian_jian.YiTianJianAttackEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.DuguNineSwordsPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.EffectUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
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
                    float defaultProbability = !player.getAbilities().instabuild ? 0.02F : 1.0F;
                    if (entity instanceof LivingEntity livingEntity) {
                        if (probability < 0.15F) {
                            if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, true), player);
                            }
                        }
                    }
                    if (probability < defaultProbability) {
                        duguNineSword.addDuguNineSwordsLevel();
                        duguNineSword.setDuguNineSwordsParticle(true);
                        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket( duguNineSword.getDuguNineSwordsLevel(),
                                duguNineSword.isDuguNineSwordsComprehend(),
                                duguNineSword.getDuguNineSwordsToppedTick(),
                                duguNineSword.getDuguNineSwordsDachengTick(),
                                duguNineSword.isDuguNineSwordsParticle()), (ServerPlayer) player);
                    }
                }else {
                    if (duguNineSword.getDuguNineSwordsLevel() > 0) {
                        if (entity instanceof LivingEntity livingEntity){
                            float probability = player.getRandom().nextFloat();
                            float defaultProbability = 0.15F;
                            if (duguNineSword.getDuguNineSwordsLevel() < 2) {
                                if (probability < defaultProbability) {
                                    if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                        livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, true), player);
                                    }
                                }
                            } else {
                                if (probability < (defaultProbability * 1.05F)) {
                                    if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                        livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, true), player);
                                    }
                                }
                            }
                            EffectUtils.setTrauma(player, livingEntity, 2,140,0.25F);
                            if (player.getMainHandItem().canDisableShield(livingEntity.getUseItem(), livingEntity, player)) {
                                if (probability < 0.5) {
                                    // 强制打破目标玩家的防御状态（禁用盾牌防御）
                                    player.getCooldowns().addCooldown(player.getUseItem().getItem(), 100);
                                    player.stopUsingItem();
                                    livingEntity.stopUsingItem();
                                    player.level().broadcastEntityEvent(player, (byte) 30);
                                }
                            }
                        }
                    }
                }
            });
            if (player.getMainHandItem().is(ChangShengJueItems.YI_TIAN_JIAN.get())){
                YiTianJianAttackEntity yiTianJianAttackEntity = new YiTianJianAttackEntity(ChangShengJueEntity.YI_TIAN_JIAN_ATTACK.get(), player.level());
                yiTianJianAttackEntity.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                yiTianJianAttackEntity.setYRot(player.getYRot());
                player.level().addFreshEntity(yiTianJianAttackEntity);
            }
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.getFoodData().getFoodLevel() > 8) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() instanceof Sword && itemstack.getItem() != ChangShengJueItems.SOFT_SWORD.get()) {
                if (!pLevel.isClientSide) {
                    pPlayer.getCapability(DuguNineSwordsCapabilityProvider.MARTIAL_ARTS_CAPABILITY).ifPresent(duguNineSword -> {
                        if (duguNineSword.duguNineSwordsComprehend()) {
                            this.onDuguNineSwords(pLevel, duguNineSword.getDuguNineSwordsLevel(), pPlayer, duguNineSword);
                        }
                    });
                    if (DuguNineSwordsClientData.getDuguNineSwordsLevel() >= 1) {
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
                if (!player.getAbilities().instabuild) {
                    player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
                        int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                        if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() == 1){
                            player.getFoodData().eat(-foodLevel + 1, -1);//消耗饱食度
                            if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 1000){
                                theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                            }
                        }else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() > 1){
                            player.getFoodData().eat(-foodLevel + 2, -1);//消耗饱食度
                            if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 1000){
                                theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                            }
                        }else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() < 1){
                            player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
                        }
                    });
                    player.getCooldowns().addCooldown(itemstack.getItem(), player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ? 125 : 140);//添加使用冷却
                }
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
                            damage = (this.getDamage() + 2) * 2.2F;
                            if (probability < (defaultProbability * 1.2F)) {
                                if (!isLivingSkeletonAndGolemAndSlime((LivingEntity) entity)) {
                                    ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.BLEED_EFFECT.get(), 30, 1, false, false), player);
                                }
                            }
                        }
                        if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                                        .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), player),
                                player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? damage + 2 : damage)) {//造成伤害
                            if (entity instanceof LivingEntity livingEntity) {
                                EffectUtils.setTrauma(player, livingEntity, 5,140,0.25F);
                            }
                            if (duguNineSword.getDuguNineSwordsUseCount() < 100) {
                                duguNineSword.addDuguNineSwordsUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                if (duguNineSword.getDuguNineSwordsUseCount() >= 100){
                                    duguNineSword.setDuguNineSwordsParticle(true);
                                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                }
                                ChangShengJueMessages.sendToPlayer(new DuguNineSwordsPacket( duguNineSword.getDuguNineSwordsLevel(),
                                        duguNineSword.isDuguNineSwordsComprehend(),
                                        duguNineSword.getDuguNineSwordsToppedTick(),
                                        duguNineSword.getDuguNineSwordsDachengTick(),
                                        duguNineSword.isDuguNineSwordsParticle()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                        ChangShengJueSound.DUGU_NINE_SWORDS_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
                    player.setHealth(player.getHealth() + 1);
                }
                if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
                    player.getFoodData().eat(1,0);
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
                DuguNineSwordsEntity duguNineSwordsEntity = new DuguNineSwordsEntity(ChangShengJueEntity.DUGU_NINE_SOWRDS.get(), pLevel);
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
