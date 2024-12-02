package com.shengchanshe.changshengjue.item.combat.knife;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_black_knife_method.GoldenBlackKnifeMethodClientData;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.golden_black_knife_method.GoldenBlackKnifeMethodEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.GoldenBlackKnifeMethodPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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
                if (goldenBlackKnifeMethod.goldenBlackKnifeMethodComprehend() && goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel() == 0) {
                    float probability = pPlayer.getRandom().nextFloat();
                    float defaultProbability = 0.02F;
                    if (probability < defaultProbability) {
                        goldenBlackKnifeMethod.addGoldenBlackKnifeMethodLevel();
                        ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel(),goldenBlackKnifeMethod.isGoldenBlackKnifeMethodComprehend()), (ServerPlayer) pPlayer);
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
                directEntity.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                    int goldenBlackKnifeMethodLevel = goldenBlackKnifeMethod.getGoldenBlackKnifeMethodLevel();
                    if (goldenBlackKnifeMethodLevel != 0){
                        if (directEntity.getMainHandItem().getItem() == this){
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.15F;
                            if(goldenBlackKnifeMethodLevel < 2){
                                if (probability < defaultProbability){
                                    float amount = event.getAmount();
                                    event.setAmount((float) (amount * 1.15));
                                }
                            }else {
                                if (probability < defaultProbability * 1.2){
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
        if (!pLevel.isClientSide) {
            ItemStack itemstack = pPlayer.getMainHandItem();//获取玩家手中物品
            if (itemstack.getItem() instanceof Knife && itemstack.getItem() != ChangShengJueItems.SOFT_SWORD.get()) {
                if (pPlayer.getFoodData().getFoodLevel() > 8) {//检查玩家饱食度是否大于8
                    pPlayer.getCapability(GoldenBlackKnifeMethodCapabilityProvider.GOLDEN_BLACK_KNIFE_METHOD_CAPABILITY).ifPresent(goldenBlackKnifeMethod -> {
                        if (goldenBlackKnifeMethod.goldenBlackKnifeMethodComprehend()) {
                            this.onDuguNineSwords(pLevel, pPlayer,goldenBlackKnifeMethod);
                        }
                    });
                    if (GoldenBlackKnifeMethodClientData.getGoldenBlackKnifeMethodLevel() >= 1){
                        return InteractionResultHolder.success(pPlayer.getMainHandItem());
                    }
                }
            }
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private void onDuguNineSwords(Level pLevel, LivingEntity pEntity, GoldenBlackKnifeMethodCapability goldenBlackKnifeMethodCapability) {
        float radius = 4.0f;//攻击半径
        float distance = 4.0F;//攻击距离
        Vec3 forward = pEntity.getForward();//获取实体的前方方向
        Vec3 hitLocation = pEntity.position().add(0, pEntity.getBbHeight() * 0.3f, 0).add(forward.scale(distance));//获取实体高度的面向,计算攻击和实体生成的位置
        var entities = pLevel.getEntities(pEntity, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));//创建包围盒
        if (pEntity instanceof Player player) {
            if (goldenBlackKnifeMethodCapability.getGoldenBlackKnifeMethodLevel() != 0) {
                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                GoldenBlackKnifeMethodEntity goldenBlackKnifeMethodEntity = new GoldenBlackKnifeMethodEntity(ChangShengJueEntity.GOLDEN_BLACK_KNIFE_METHOD_ENTITY.get(), pLevel);
                goldenBlackKnifeMethodEntity.moveTo(hitLocation);
                goldenBlackKnifeMethodEntity.setYRot(player.getYRot());
                pLevel.addFreshEntity(goldenBlackKnifeMethodEntity);
                for (Entity entity : entities) {//遍历包围盒中的实体
                    //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                    if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                        float damage1 = this.getDamage();
                        float damage = goldenBlackKnifeMethodCapability.getGoldenBlackKnifeMethodLevel() < 2 ? (damage1 + 2) * 1.3F : (damage1 + 2) * 1.6F ;
                        if (entity.hurt(player.damageSources().playerAttack(player), damage)) {//造成伤害
                            if (goldenBlackKnifeMethodCapability.getGoldenBlackKnifeMethodUseCount() <= 100) {
                                goldenBlackKnifeMethodCapability.addGoldenBlackKnifeMethodUseCount();
                                ChangShengJueMessages.sendToPlayer(new GoldenBlackKnifeMethodPacket(goldenBlackKnifeMethodCapability.getGoldenBlackKnifeMethodLevel(),
                                        goldenBlackKnifeMethodCapability.isGoldenBlackKnifeMethodComprehend()), (ServerPlayer) player);
                            }
                            EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                        }
                    }
                }
                if (!player.getAbilities().instabuild) {
                    player.getFoodData().eat(-3, -2);//消耗饱食度
                    player.getCooldowns().addCooldown(itemstack.getItem(), 140);//添加使用冷却
                }
                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }
}
