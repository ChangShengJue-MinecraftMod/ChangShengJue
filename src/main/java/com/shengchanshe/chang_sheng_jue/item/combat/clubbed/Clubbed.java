package com.shengchanshe.chang_sheng_jue.item.combat.clubbed;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapability;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.shaolin_stick_method.ShaolinStickMethodCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.beat_dog_stick.BeatDogStickAttackEntity;
import com.shengchanshe.chang_sheng_jue.event.CSJAdvanceEvent;
import com.shengchanshe.chang_sheng_jue.event.CSJEvent;
import com.shengchanshe.chang_sheng_jue.item.ChangShengJueItems;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.ShaolinStickMethodPacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import com.shengchanshe.chang_sheng_jue.util.EffectUtils;
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

public class Clubbed extends SwordItem {
    public Clubbed(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
//        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player pPlayer, Entity entity) {
        if (!pPlayer.level().isClientSide) {
            float probability = pPlayer.getRandom().nextFloat();
            float defaultProbability = 0.10F;
            if (entity instanceof LivingEntity livingEntity) {
                if (probability < defaultProbability) {
                    livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 20, 1, false, true), pPlayer);
                }
            }
            pPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                int shaolinStickMethodLevel = shaolinStickMethod.getShaolinStickMethodLevel();
                if (shaolinStickMethod.getShaolinStickMethodComprehend() && shaolinStickMethodLevel == 0) {
                    float defaultComprehendProbability = !pPlayer.getAbilities().instabuild ? 0.02F : 1.0F;
                    if (probability < defaultComprehendProbability) {
                        shaolinStickMethod.addShaolinStickMethodLevel();
                        shaolinStickMethod.setShaolinStickMethodParticle(true);
                        pPlayer.level().playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        Level pLevel = pPlayer.level();
                        CSJAdvanceEvent.summonChallenger(pLevel, pPlayer);
                        ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethod.getShaolinStickMethodLevel(),
                                shaolinStickMethod.isShaolinStickMethodComprehend(),
                                shaolinStickMethod.getShaolinStickMethodToppedTick(),
                                shaolinStickMethod.getShaolinStickMethodDachengTick(),
                                shaolinStickMethod.isShaolinStickMethodParticle()), (ServerPlayer) pPlayer);
                    }
                }else {
                    if (shaolinStickMethodLevel > 0) {
                        if (entity instanceof LivingEntity livingEntity){
                            if (shaolinStickMethodLevel >= 2) {
                                if (probability < (defaultProbability * 2.5)) {
                                    livingEntity.addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 20, 1, false, true), pPlayer);
                                }
                            }
                            EffectUtils.setTrauma(pPlayer, livingEntity, 2,140,0.25F);
                            if (pPlayer.getMainHandItem().canDisableShield(livingEntity.getUseItem(), livingEntity, pPlayer)) {
                                if (probability < 0.5) {
                                    // 强制打破目标玩家的防御状态（禁用盾牌防御）
                                    pPlayer.getCooldowns().addCooldown(pPlayer.getUseItem().getItem(), CSJEvent.hasWheatNuggetsTributeWine ? 70:100);
                                    pPlayer.stopUsingItem();
                                    livingEntity.stopUsingItem();
                                    pPlayer.level().broadcastEntityEvent(pPlayer, (byte) 30);
                                }
                            }
                        }
                    }
                }
            });
            if (pPlayer.getMainHandItem().is(ChangShengJueItems.BEAT_DOG_STICK.get())){
                BeatDogStickAttackEntity beatDogStickEntity = new BeatDogStickAttackEntity(ChangShengJueEntity.BEAT_DOG_STICK_ATTACK.get(), pPlayer.level());
                beatDogStickEntity.moveTo(entity.position().add(0, entity.getEyeHeight(), 0).add(entity.getForward().scale(0)));
                beatDogStickEntity.setYRot(pPlayer.getYRot());
                pPlayer.level().addFreshEntity(beatDogStickEntity);
            }
        }
        return super.onLeftClickEntity(stack, pPlayer, entity);
    }

//    @SubscribeEvent
//    public void onClubbedAttack(LivingDamageEvent event) {
//        Level level = event.getEntity().level();
//        if (!level.isClientSide) {
//            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
//                LivingEntity entity = event.getEntity();
//                directEntity.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
//
//                });
//            }
//        }
//    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
        if (itemstack.getItem() == this) {
            if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                if (!pLevel.isClientSide) {
                    pPlayer.getCapability(ShaolinStickMethodCapabilityProvider.SHAOLIN_STICK_METHOD_CAPABILITY).ifPresent(shaolinStickMethod -> {
                        if (shaolinStickMethod.getShaolinStickMethodComprehend()) {
                            this.onShaolinStickMethod(pLevel, pPlayer, shaolinStickMethod);
                        }
                    });
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void onShaolinStickMethod(Level pLevel, LivingEntity pEntity, ShaolinStickMethodCapability shaolinStickMethod) {
        float radius = 5.0f;//攻击半径
        float distance = 5.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3F, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        //radius * 2 表示的是立方体的边长,radius表示的从立方体中心到边界的距离
        if (pEntity instanceof Player player) {
            if (shaolinStickMethod.getShaolinStickMethodLevel() != 0) {
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
                    player.getCooldowns().addCooldown(itemstack.getItem(), player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ? 145 : 160);//添加使用冷却
                }
                for (Entity entity : entities) {//遍历包围盒中的实体
                    //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                    if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                        float damage;
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = 0.10F;
                        if (shaolinStickMethod.getShaolinStickMethodLevel() < 2) {
                            damage = (this.getDamage() + 2) * 1.7F;
                            if (probability < defaultProbability) {
                                ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 20, 1, false, false), player);
                            }
                        } else {
                            damage = (this.getDamage() + 2) * 2.0F;
                            if (probability < (defaultProbability * 1.2F)) {
                                ((LivingEntity) entity).addEffect(new MobEffectInstance(ChangShengJueEffects.DIZZY_EFFECT.get(), 20, 1, false, false), player);
                            }
                        }
//                        if (new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
//                                .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), player)
//                                .is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts")))) {
//                            entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).
//                                    getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), player), 1);
//                        }

                        if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                                .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), player)
                                , player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? damage + 2 : damage)) {//造成伤害
                            if (entity instanceof LivingEntity livingEntity) {
                                EffectUtils.setTrauma(player, livingEntity, 5,140,0.25F);
                            }
                            if (shaolinStickMethod.getShaolinStickMethodUseCount() < 100) {
                                shaolinStickMethod.addShaolinStickMethodUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                if (shaolinStickMethod.getShaolinStickMethodUseCount() >= 100) {
                                    shaolinStickMethod.setShaolinStickMethodParticle(true);
                                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                }
                                ChangShengJueMessages.sendToPlayer(new ShaolinStickMethodPacket(shaolinStickMethod.getShaolinStickMethodLevel(),
                                        shaolinStickMethod.isShaolinStickMethodComprehend(),
                                        shaolinStickMethod.getShaolinStickMethodToppedTick(),
                                        shaolinStickMethod.getShaolinStickMethodDachengTick(),
                                        shaolinStickMethod.isShaolinStickMethodParticle()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())) {
                    player.setHealth(player.getHealth() + 1);
                }
                if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())) {
                    player.getFoodData().eat(1, 0);
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }
}
