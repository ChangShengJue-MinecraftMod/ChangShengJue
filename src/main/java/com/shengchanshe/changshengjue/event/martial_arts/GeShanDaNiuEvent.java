package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.ge_shan_da_niu.GeShanDaNiuClientData;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.item.ChangShengJueItems;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket2;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.KeyBinding;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class GeShanDaNiuEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                    if (geShanDaNiu.getGeShanDaNiuUseCooldownPercent() > 0) {
                        if (geShanDaNiu.isSkillZActive() || geShanDaNiu.isSkillXActive() || geShanDaNiu.isSkillCActive()){
                            geShanDaNiu.setGeShanDaNiuUseCooldownPercent();
                            ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                    geShanDaNiu.getGeShanDaNiuLevel(),
                                    geShanDaNiu.isGeShanDaNiuComprehend(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                    geShanDaNiu.getGeShanDaNiuToppedTick(),
                                    geShanDaNiu.getGeShanDaNiuDachengTick(),
                                    geShanDaNiu.isGeShanDaNiuParticle(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                                    geShanDaNiu.isSkillZActive(),
                                    geShanDaNiu.isSkillXActive(),
                                    geShanDaNiu.isSkillCActive()), (ServerPlayer) player);
                        }
                    }
                    if (geShanDaNiu.isGeShanDaNiuParticle()){
                        if (geShanDaNiu.getGeShanDaNiuLevel() == 1){
                            geShanDaNiu.setGeShanDaNiuToppedTick();
                            ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                    geShanDaNiu.getGeShanDaNiuLevel(),
                                    geShanDaNiu.isGeShanDaNiuComprehend(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                    geShanDaNiu.getGeShanDaNiuToppedTick(),
                                    geShanDaNiu.getGeShanDaNiuDachengTick(),
                                    geShanDaNiu.isGeShanDaNiuParticle(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                                    geShanDaNiu.isSkillZActive(),
                                    geShanDaNiu.isSkillXActive(),
                                    geShanDaNiu.isSkillCActive()), (ServerPlayer) player);
                        }else if (geShanDaNiu.getGeShanDaNiuLevel() == 2){
                            geShanDaNiu.setGeShanDaNiuDachengTick();
                            ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                    geShanDaNiu.getGeShanDaNiuLevel(),
                                    geShanDaNiu.isGeShanDaNiuComprehend(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                    geShanDaNiu.getGeShanDaNiuToppedTick(),
                                    geShanDaNiu.getGeShanDaNiuDachengTick(),
                                    geShanDaNiu.isGeShanDaNiuParticle(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                                    geShanDaNiu.isSkillZActive(),
                                    geShanDaNiu.isSkillXActive(),
                                    geShanDaNiu.isSkillCActive()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide) {
                if (GeShanDaNiuClientData.isGeShanDaNiuParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, GeShanDaNiuClientData.getGeShanDaNiuToppedTick());
                }
                if (GeShanDaNiuClientData.isGeShanDaNiuParticle()) {
                    DachengParticle.DachengParticle(player, level, GeShanDaNiuClientData.getGeShanDaNiuDachengTick());
                }
            }
        }
    }

//    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event) {
//        Level level = event.getEntity().level();
//        if (!level.isClientSide) {
//            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()) {
//                    if (!directEntity.isShiftKeyDown()) {
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
//                        if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.getGeShanDaNiuLevel() == 0) {
//                            if (geShanDaNiu.isSkillZActive() || geShanDaNiu.isSkillXActive() || geShanDaNiu.isSkillCActive()){
//                                float probability = directEntity.getRandom().nextFloat();
//                                float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                                if (probability < defaultProbability) {
//                                    level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                            ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                    geShanDaNiu.addGeShanDaNiuLevel();
//                                    geShanDaNiu.setGeShanDaNiuParticle(true);
//                                    ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
//                                            geShanDaNiu.getGeShanDaNiuLevel(),
//                                            geShanDaNiu.isGeShanDaNiuComprehend(),
//                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
//                                            geShanDaNiu.getGeShanDaNiuToppedTick(),
//                                            geShanDaNiu.getGeShanDaNiuDachengTick(),
//                                            geShanDaNiu.isGeShanDaNiuParticle(),
//                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
//                                            geShanDaNiu.isSkillZActive(),
//                                            geShanDaNiu.isSkillXActive(),
//                                            geShanDaNiu.isSkillCActive()), (ServerPlayer) directEntity);
//                                }
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

//    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event) {
//        Player player = event.getEntity();
//        Level level = player.level();
//        if (!event.getLevel().isClientSide) {
//            player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
//                if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.isGeShanDaNiuOff() && geShanDaNiu.getGeShanDaNiuLevel() > 0) {
//                    if (geShanDaNiu.getGeShanDaNiuUseCooldownPercent() <= 0) {
//                        if (player.getFoodData().getFoodLevel() > 8) {
//                            if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
//                                ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
//                                if (player.hasEffect(ChangShengJueEffects.FEN_JIU.get())){
//                                    if (!player.getAbilities().instabuild) {
//                                        player.getFoodData().eat((int) -(4 - (4 * 0.25)), (float) -(2 - (2 * 0.25)));//消耗饱食度
//                                    }
//                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ?
//                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - (geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() * 0.15F) : 0);
//                                }else if (player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
//                                    if (!player.getAbilities().instabuild) {
//                                        player.getFoodData().eat((int) -(4-(4 * 0.2)), (float) -(2 - (2 * 0.2)));//消耗饱食度
//                                    }
//                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ?
//                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - (geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() * 0.2F) : 0);
//                                }else if (player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get())){
//                                    if (!player.getAbilities().instabuild) {
//                                        player.getFoodData().eat((int) -(4- (4 * 0.15)), (float) -(2 - (2 * 0.15)));//消耗饱食度
//                                    }
//                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ?
//                                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - (geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() * 0.25F) : 0);
//                                }else {
//                                    if (!player.getAbilities().instabuild) {
//                                        player.getFoodData().eat(-(4), (float) -(2));//消耗饱食度
//                                    }
//                                    geShanDaNiu.setGeShanDaNiuUseCooldownPercent(!player.getAbilities().instabuild ? geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() : 0);
//                                }
//                                itemstack.hurtAndBreak(1, player, (player1) -> {//消耗耐久
//                                    player1.broadcastBreakEvent(player.getUsedItemHand());
//                                });
//                                if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
//                                    float radius = geShanDaNiu.getGeShanDaNiuLevel() <= 1 ? 4.0F : 4.0F * 1.5F;
//                                    float distance = 2.0F;
//                                    Vec3 forward = player.getForward();
//                                    Vec3 hitLocation = player.position().add(0, player.getBbHeight() * 0.3f, 0).add(forward.scale(distance));
//                                    //radius * 2 表示的是立方体的边长,radius表示的从立方体中心到边界的距离
//                                    var entities = level.getEntities(player, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));
//                                    for (Entity entity : entities) {//遍历包围盒中的实体
//                                        //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
//                                        if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
////                                            // 获取物品的攻击伤害
////                                            double attackDamage = 0.0;
////                                            Multimap<Attribute, AttributeModifier> attributeModifiers = itemstack.getAttributeModifiers(EquipmentSlot.MAINHAND);
////                                            for (AttributeModifier modifier : attributeModifiers.get(Attributes.ATTACK_DAMAGE)) {
////                                                if (modifier.getOperation() == AttributeModifier.Operation.ADDITION) {
////                                                    attackDamage += modifier.getAmount();
////                                                } else if (modifier.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL) {
////                                                    attackDamage *= 1 + modifier.getAmount();
////                                                }
////                                            }
//                                            if (entity.hurt(player.damageSources().playerAttack(player), 14)) {//造成伤害
//                                                EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
//                                                if (geShanDaNiu.getGeShanDaNiuUseCount() <= 100) {
//                                                    geShanDaNiu.addGeShanDaNiuUseCount(!player.getAbilities().instabuild ? 1 : 100);
//                                                    if (geShanDaNiu.getGeShanDaNiuUseCount() >= 100){
//                                                        geShanDaNiu.setGeShanDaNiuParticle(true);
//                                                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
//                                                                ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                                    }
//                                                }
//                                            }
//                                        }
//                                    }
//                                    GeShanDaNiuEntity geShanDaNiuEntity = new GeShanDaNiuEntity(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), level);
//                                    geShanDaNiuEntity.moveTo(hitLocation);
//                                    geShanDaNiuEntity.setYRot(player.getYRot());
//                                    geShanDaNiuEntity.setXRot(player.getXRot());
//                                    level.addFreshEntity(geShanDaNiuEntity);
//                                }
//                                ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
//                                        geShanDaNiu.getGeShanDaNiuLevel(),
//                                        geShanDaNiu.isGeShanDaNiuComprehend(),
//                                        geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
//                                        geShanDaNiu.isGeShanDaNiuOff(),
//                                        geShanDaNiu.getGeShanDaNiuToppedTick(),
//                                        geShanDaNiu.getGeShanDaNiuDachengTick(),
//                                        geShanDaNiu.isGeShanDaNiuParticle(),
//                                        geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax()), (ServerPlayer) player);
//                            }
//                        }
//                    }
//                }
//            });
//        } else {
//            boolean geShanDaNiuComprehend = GeShanDaNiuClientData.isGeShanDaNiuComprehend();
//            boolean geShanDaNiuOff = GeShanDaNiuClientData.isGeShanDaNiuOff();
//            if (geShanDaNiuComprehend && geShanDaNiuOff) {
//                if (GeShanDaNiuClientData.getGeShanDaNiuLevel() >= 1) {
//                    if (GeShanDaNiuClientData.getGeShanDaNiuUseCooldownPercent() <= 0) {
//                        if (player.getFoodData().getFoodLevel() > 8) {
//                            player.swing(player.getUsedItemHand());
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
//        Player player = event.getEntity();
//        if (!player.isUsingItem()){
//            return;
//        }
//        ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2());
//        boolean geShanDaNiuComprehend = GeShanDaNiuClientData.isGeShanDaNiuComprehend();
//        boolean geShanDaNiuOff = GeShanDaNiuClientData.isGeShanDaNiuOff();
//        if (geShanDaNiuComprehend && geShanDaNiuOff){
//            if (GeShanDaNiuClientData.getGeShanDaNiuLevel() >= 1){
//                if (GeShanDaNiuClientData.getGeShanDaNiuUseCooldownPercent()<=0) {
//                    if (player.getFoodData().getFoodLevel() > 8){
//                        player.swing(player.getUsedItemHand());
//                    }
//                }
//            }
//        }
//    }
//
//    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event) {
//        ChangShengJueMessages.sendToServer(new GeShanDaNiuPacket2());
//        Player player = event.getEntity();
//        boolean geShanDaNiuComprehend = GeShanDaNiuClientData.isGeShanDaNiuComprehend();
//        boolean geShanDaNiuOff = GeShanDaNiuClientData.isGeShanDaNiuOff();
//        if (geShanDaNiuComprehend && geShanDaNiuOff){
//            if (GeShanDaNiuClientData.getGeShanDaNiuLevel() >= 1){
//                if (GeShanDaNiuClientData.getGeShanDaNiuUseCooldownPercent()<=0) {
//                    if (player.getFoodData().getFoodLevel() > 8){
//                        player.swing(player.getUsedItemHand());
//                    }
//                }
//            }
//        }
//    }

}
