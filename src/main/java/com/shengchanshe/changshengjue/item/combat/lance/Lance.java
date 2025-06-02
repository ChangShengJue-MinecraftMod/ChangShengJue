package com.shengchanshe.changshengjue.item.combat.lance;

import com.shengchanshe.changshengjue.ChangShengJue;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.gao_marksmanship.GaoMarksmanshipCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.beat_dog_stick.BeatDogStickAttackEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.GaoMarksmanshipPacket;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Lance extends SwordItem {
    public Lance(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player pPlayer, Entity entity) {
        if (!pPlayer.level().isClientSide) {
            pPlayer.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
                int gaoMarksmanshipLevel = gaoMarksmanship.getGaoMarksmanshipLevel();
                if (gaoMarksmanship.gaoMarksmanshipComprehend() && gaoMarksmanshipLevel == 0) {
                    float probability = pPlayer.getRandom().nextFloat();
                    float defaultProbability = !pPlayer.getAbilities().instabuild ? 0.02F : 1.0F;
                    if (entity instanceof LivingEntity livingEntity) {
                        if (probability < 0.10F) {
                            livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(), 30, 1, false, true), entity);
                        }
                    }
                    if (probability < defaultProbability) {
                        gaoMarksmanship.addGaoMarksmanshipLevel();
                        gaoMarksmanship.setGaoMarksmanshipParticle(true);
                        pPlayer.level().playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                                ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(gaoMarksmanship.getGaoMarksmanshipLevel(),
                                gaoMarksmanship.isGaoMarksmanshipComprehend(),
                                gaoMarksmanship.getGaoMarksmanshipToppedTick(),
                                gaoMarksmanship.getGaoMarksmanshipDachengTick(),
                                gaoMarksmanship.isGaoMarksmanshipParticle()), (ServerPlayer) pPlayer);
                    }
                }else {
                    if (gaoMarksmanshipLevel > 0) {
                        if (entity instanceof LivingEntity livingEntity){
                            float probability = pPlayer.getRandom().nextFloat();
                            float defaultProbability = 0.10F;
                            if (gaoMarksmanshipLevel < 2) {
                                if (probability < defaultProbability) {
                                    livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(), 30, 1, false, true), entity);
                                }
                            } else {
                                if (probability < defaultProbability * 1.15) {
                                    livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(), 30, 1, false, true), entity);
                                }
                            }
                            EffectUtils.setTrauma(pPlayer, livingEntity, 2,140,0.25F);
                            if (pPlayer.getMainHandItem().canDisableShield(livingEntity.getUseItem(), livingEntity, pPlayer)) {
                                if (probability < 0.5) {
                                    // 强制打破目标玩家的防御状态（禁用盾牌防御）
                                    pPlayer.getCooldowns().addCooldown(pPlayer.getUseItem().getItem(), 100);
                                    pPlayer.stopUsingItem();
                                    livingEntity.stopUsingItem();
                                    pPlayer.level().broadcastEntityEvent(pPlayer, (byte) 30);
                                }
                            }
                        }
                    }
                }
            });
            if (pPlayer.getMainHandItem().is(ChangShengJueItems.BA_WANG_QIANG.get())){
                BeatDogStickAttackEntity beatDogStickAttack = new BeatDogStickAttackEntity(ChangShengJueEntity.BA_WANG_QIANG_ATTACK.get(), pPlayer.level());
                beatDogStickAttack.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                beatDogStickAttack.setYRot(pPlayer.getYRot());
                pPlayer.level().addFreshEntity(beatDogStickAttack);
            }
        }
        return super.onLeftClickEntity(stack, pPlayer, entity);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
        if (itemstack.getItem() == this) {
            if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                if (!pLevel.isClientSide) {
                    pPlayer.getCapability(GaoMarksmanshipCapabilityProvider.GAO_MARKSMANSHIP_CAPABILITY).ifPresent(gaoMarksmanship -> {
                        if (gaoMarksmanship.gaoMarksmanshipComprehend() && !pPlayer.isShiftKeyDown()) {
                            this.onGaoMarksmanship(pLevel, pPlayer, gaoMarksmanship);
                        }
                    });
                }
            }
        }
        ItemStack itemInHand = pPlayer.getItemInHand(pUsedHand);
        if (itemInHand.getDamageValue() >= itemInHand.getMaxDamage() - 1) {
            return InteractionResultHolder.fail(itemInHand);
        } else if (EnchantmentHelper.getRiptide(itemInHand) > 0 && !pPlayer.isInWaterOrRain()) {
            return InteractionResultHolder.fail(itemInHand);
        } else {
            if (pPlayer.isShiftKeyDown()){
                pPlayer.startUsingItem(pUsedHand);
            }
            return InteractionResultHolder.consume(itemInHand);
        }
    }

    private void onGaoMarksmanship(Level pLevel, LivingEntity pEntity, GaoMarksmanshipCapability gaoMarksmanship) {
        float radius = 5.0f;//攻击半径
        float distance = 5.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3F, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        if (pEntity instanceof Player player) {
            if (gaoMarksmanship.getGaoMarksmanshipLevel() != 0) {
                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                if (!player.getAbilities().instabuild) {
                    player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
                        int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                        if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() >= 1){
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
                        float defaultProbability = 0.10F;
                        if (gaoMarksmanship.getGaoMarksmanshipLevel() < 2) {
                            damage = (this.getDamage() + 2) * 1.8F;
                            if (probability < defaultProbability) {
                                ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(), 30, 1, false, false), player);
                            }
                        } else {
                            damage = (this.getDamage() + 2) * 2.1F;
                            if (probability < (defaultProbability * 1.15F)) {
                                ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.AIRBORNE_EFFECT.get(), 30, 1, false, false), player);
                            }
                        }
                        if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                                        .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), player),
                                player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? damage + 2 : damage)) {//造成伤害
                            if (entity instanceof LivingEntity livingEntity) {
                                EffectUtils.setTrauma(player, livingEntity, 5,140,0.25F);
                            }
                            if (gaoMarksmanship.getGaoMarksmanshipUseCount() < 100) {
                                gaoMarksmanship.addGaoMarksmanshipUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                if (gaoMarksmanship.getGaoMarksmanshipUseCount() >= 100){
                                    gaoMarksmanship.setGaoMarksmanshipParticle(true);
                                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                }
                                ChangShengJueMessages.sendToPlayer(new GaoMarksmanshipPacket(gaoMarksmanship.getGaoMarksmanshipLevel(),
                                        gaoMarksmanship.isGaoMarksmanshipComprehend(),
                                        gaoMarksmanship.getGaoMarksmanshipToppedTick(),
                                        gaoMarksmanship.getGaoMarksmanshipDachengTick(),
                                        gaoMarksmanship.isGaoMarksmanshipParticle()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
                    player.setHealth(player.getHealth() + 1);
                }
                if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
                    player.getFoodData().eat(1, 0);
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }
}
