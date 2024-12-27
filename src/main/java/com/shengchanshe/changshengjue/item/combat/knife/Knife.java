package com.shengchanshe.changshengjue.item.combat.knife;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodClientData;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.GoldenBlackKnifeMethodPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
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

public class Knife extends SwordItem {
    public Knife(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player pPlayer, Entity entity) {
        if (!pPlayer.level().isClientSide) {
            pPlayer.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                int goldenBlackKnifeMethodLevel = goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel();
                if (goldenBlackKnifeMethod.goldenBlackKnifeMethodComprehend() && goldenBlackKnifeMethodLevel == 0) {
                    float probability = pPlayer.getRandom().nextFloat();
                    float defaultProbability = !pPlayer.getAbilities().instabuild ? 0.02F : 1.0F;
                    if (probability < defaultProbability) {
                        goldenBlackKnifeMethod.addGoldenBlackKnifeMethodLevel();
                        goldenBlackKnifeMethod.setGoldenBlackKnifeMethodParticle(true);
                        pPlayer.level().playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                                ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
                                goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
                                goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
                                goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
                                goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), (ServerPlayer) pPlayer);
                    }
                }else {
                    if (goldenBlackKnifeMethodLevel > 0) {
                        if (entity instanceof LivingEntity livingEntity){
                            float probability = pPlayer.getRandom().nextFloat();
                            float defaultProbability = 0.5f;
                            if (pPlayer.getMainHandItem().canDisableShield(livingEntity.getUseItem(), livingEntity, pPlayer)) {
                                if (probability < defaultProbability) {
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
        }
        return super.onLeftClickEntity(stack, pPlayer, entity);
    }

    @SubscribeEvent
    public void onKnifeAttack(LivingDamageEvent event) {
        Level level = event.getEntity().level();
        if (!level.isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
                directEntity.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                    int goldenBlackKnifeMethodLevel = goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel();
                    if (goldenBlackKnifeMethodLevel > 0) {
                        if (directEntity.getMainHandItem().getItem() == this) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.15F;
                            if (goldenBlackKnifeMethodLevel < 2) {
                                if (probability < defaultProbability) {
                                    float amount = event.getAmount();
                                    event.setAmount((float) (amount * 1.15));
                                }
                            } else {
                                if (probability < defaultProbability * 1.2) {
                                    float amount = event.getAmount();
                                    event.setAmount((float) (amount * 1.15));
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
        ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
        if (itemstack.getItem() instanceof Knife) {
            if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                if (!pLevel.isClientSide) {
                    pPlayer.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                        if (goldenBlackKnifeMethod.goldenBlackKnifeMethodComprehend()) {
                            this.onGoldenBlackKnifeMethod(pLevel, pPlayer, goldenBlackKnifeMethod);
                        }
                    });
                }
                if (GoldenBlackKnifeMethodClientData.getGoldenBlackKnifeMethodLevel() >= 1) {
                    return InteractionResultHolder.success(pPlayer.getMainHandItem());
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void onGoldenBlackKnifeMethod(Level pLevel, LivingEntity pEntity, GoldenBlackKnifeMethodCapability goldenBlackKnifeMethod) {
        float radius = 4.0f;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        if (pEntity instanceof Player player) {
            if (goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel() > 0) {
                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                if (!player.getAbilities().instabuild) {
                    int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                    player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
                    player.getCooldowns().addCooldown(itemstack.getItem(), player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ? 125 : 140);//添加使用冷却
                }
                GoldenBlackKnifeMethodEntity goldenBlackKnifeMethodEntity = new GoldenBlackKnifeMethodEntity(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD_ENTITY.get(), pLevel);
                goldenBlackKnifeMethodEntity.moveTo(hitLocation);
                goldenBlackKnifeMethodEntity.setYRot(player.getYRot());
                pLevel.addFreshEntity(goldenBlackKnifeMethodEntity);
                for (Entity entity : entities) {//遍历包围盒中的实体
                    //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                    if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                        float damage1 = this.getDamage();
                        float damage = goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel() < 2 ? (damage1 + 2) * 1.3F : (damage1 + 2) * 1.6F;
                        if (entity.hurt(player.damageSources().playerAttack(player), damage)) {//造成伤害
                            if (goldenBlackKnifeMethod.getGoldenBlackKnifeMethodUseCount() < 100) {
                                goldenBlackKnifeMethod.addGoldenBlackKnifeMethodUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                if (goldenBlackKnifeMethod.getGoldenBlackKnifeMethodUseCount() >= 100){
                                    goldenBlackKnifeMethod.setGoldenBlackKnifeMethodParticle(true);
                                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                }
                                ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),
                                        goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend(),
                                        goldenBlackKnifeMethod.getGoldenBlackKnifeMethodToppedTick(),
                                        goldenBlackKnifeMethod.getGoldenBlackKnifeMethodDachengTick(),
                                        goldenBlackKnifeMethod.isGoldenBlackKnifeMethodParticle()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                        ChangShengJueSound.GOLDEN_BLACK_KNIFE_METHOD_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
                    player.setHealth(player.getHealth() + 1);
                }
                if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
                    player.getFoodData().eat(1,0);
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }
}
