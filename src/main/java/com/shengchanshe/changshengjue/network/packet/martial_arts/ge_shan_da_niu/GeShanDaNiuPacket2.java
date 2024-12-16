package com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu;

import com.google.common.collect.Multimap;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.ge_shan_da_niu.GeShanDaNiuEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GeShanDaNiuPacket2 {

    public GeShanDaNiuPacket2(){
    }

    public GeShanDaNiuPacket2(FriendlyByteBuf buf){
    }

    public void toBytes(FriendlyByteBuf buf){
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.isGeShanDaNiuOff() && geShanDaNiu.getGeShanDaNiuLevel() > 0) {
                    if (geShanDaNiu.getGeShanDaNiuUseCooldownPercent() <= 0) {
                        if (player.getFoodData().getFoodLevel() > 8) {
                            if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
                                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                                if (player.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat((int) -(4 - (4 * 0.25)), (float) -(2 - (2 * 0.25)));//消耗饱食度
                                    }
                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ?
                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - (geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() * 0.15F) : 0);
                                }else if (player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat((int) -(4-(4 * 0.2)), (float) -(2 - (2 * 0.2)));//消耗饱食度
                                    }
                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ?
                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - (geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() * 0.2F) : 0);
                                }else if (player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat((int) -(4- (4 * 0.15)), (float) -(2 - (2 * 0.15)));//消耗饱食度
                                    }
                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ?
                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - (geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() * 0.25F) : 0);
                                }else {
                                    if (!player.getAbilities().instabuild) {
                                        player.getFoodData().eat(-(4), (float) -(2));//消耗饱食度
                                    }
                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ? geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() : 0);
                                }
                                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
                                    player1.broadcastBreakEvent(player.getUsedItemHand());
                                });
                                if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
                                    float radius = geShanDaNiu.getGeShanDaNiuLevel() <= 1 ? 4.0F : 4.0F * 1.5F;
                                    float distance = 2.0F;
                                    Vec3 forward = player.getForward();
                                    Vec3 hitLocation = player.position().add(0, player.getBbHeight() * 0.3f, 0).add(forward.scale(distance));
                                    //radius * 2 表示的是立方体的边长,radius表示的从立方体中心到边界的距离
                                    var entities = level.getEntities(player, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));
                                    for (Entity entity : entities) {//遍历包围盒中的实体
                                        //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                                        if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                                            // 获取物品的攻击伤害
                                            double attackDamage = 0.0;
                                            Multimap<Attribute, AttributeModifier> attributeModifiers = itemstack.getAttributeModifiers(EquipmentSlot.MAINHAND);
                                            for (AttributeModifier modifier : attributeModifiers.get(Attributes.ATTACK_DAMAGE)) {
                                                if (modifier.getOperation() == AttributeModifier.Operation.ADDITION) {
                                                    attackDamage += modifier.getAmount();
                                                } else if (modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
                                                    attackDamage *= 1 + modifier.getAmount();
                                                }
                                            }
                                            if (entity.hurt(player.damageSources().playerAttack(player), (float) attackDamage + 2)) {//造成伤害
                                                EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                                                if (geShanDaNiu.getGeShanDaNiuUseCount() < 100) {
                                                    geShanDaNiu.addGeShanDaNiuUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                                    if (geShanDaNiu.getGeShanDaNiuUseCount() >= 100){
                                                        geShanDaNiu.setGeShanDaNiuParticle(true);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    GeShanDaNiuEntity geShanDaNiuEntity = new GeShanDaNiuEntity(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), level);
                                    geShanDaNiuEntity.moveTo(hitLocation);
                                    geShanDaNiuEntity.setYRot(player.getYRot());
                                    geShanDaNiuEntity.setXRot(player.getXRot());
                                    level.addFreshEntity(geShanDaNiuEntity);
                                }
                                ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                        geShanDaNiu.getGeShanDaNiuLevel(),
                                        geShanDaNiu.isGeShanDaNiuComprehend(),
                                        geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                        geShanDaNiu.isGeShanDaNiuOff(),
                                        geShanDaNiu.getGeShanDaNiuToppedTick(),
                                        geShanDaNiu.getGeShanDaNiuDachengTick(),
                                        geShanDaNiu.isGeShanDaNiuParticle(),
                                        geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax()), (ServerPlayer) player);
                            }
                        }
                    }
                }
            });
        });
        return true;
    }
}
