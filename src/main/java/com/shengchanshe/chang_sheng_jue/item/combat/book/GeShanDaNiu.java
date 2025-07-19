package com.shengchanshe.chang_sheng_jue.item.combat.book;

import com.shengchanshe.chang_sheng_jue.ChangShengJue;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.hercules.HerculesCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.the_classics_of_tendon_changing.TheClassicsOfTendonChangingCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.capability.martial_arts.turtle_breath_work.TurtleBreathWorkCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.effect.ChangShengJueEffects;
import com.shengchanshe.chang_sheng_jue.entity.ChangShengJueEntity;
import com.shengchanshe.chang_sheng_jue.entity.combat.ge_shan_da_niu.GeShanDaNiuEntity;
import com.shengchanshe.chang_sheng_jue.event.CSJAdvanceEvent;
import com.shengchanshe.chang_sheng_jue.init.CSJAdvanceInit;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.ge_shan_da_niu.GeShanDaNiuPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.hercules.HerculesPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.turtle_breath_work.TurtleBreathWorkPacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class GeShanDaNiu extends Item {
    public GeShanDaNiu() {
        super(new Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide){
            pPlayer.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                if (!geShanDaNiu.isGeShanDaNiuComprehend()) {
                    geShanDaNiu.setGeShanDaNiuComprehend(true);
                    geShanDaNiu.setSkillActive(true);
                    if (pPlayer instanceof ServerPlayer serverPlayer) {
                        CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                    }
                }else {
                    geShanDaNiu.setSkillActive(!geShanDaNiu.isSkillActive());
                }
                pPlayer.getCapability(HerculesCapabilityProvider.HERCULES_CAPABILITY).ifPresent(hercules -> {
                    if (hercules.isSkillActive()) {
                        hercules.setSkillActive(false);
                        ChangShengJueMessages.sendToPlayer(new HerculesPacket(
                                hercules.getHerculesLevel(),
                                hercules.isHerculesComprehend(),
                                hercules.getHerculesToppedTick(),
                                hercules.getHerculesDachengTick(),
                                hercules.isHerculesParticle(), hercules.isSkillActive()), (ServerPlayer) pPlayer);
                    }
                });
                pPlayer.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman -> {
                    if (sunflowerPointCaveman.isSkillActive()) {
                        sunflowerPointCaveman.setSkillActive(false);
                        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                                sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                                sunflowerPointCaveman.isSkillActive()), (ServerPlayer) pPlayer);
                    }
                });
                pPlayer.getCapability(TurtleBreathWorkCapabilityProvider.TURTLE_BREATH_WORK_CAPABILITY).ifPresent(turtleBreathWork -> {
                    if (turtleBreathWork.isSkillActive()){
                        turtleBreathWork.setSkillActive(false);
                        ChangShengJueMessages.sendToPlayer(new TurtleBreathWorkPacket(
                                turtleBreathWork.getTurtleBreathWorkLevel(),
                                turtleBreathWork.isTurtleBreathWorkComprehend(),
                                turtleBreathWork.getTurtleBreathWorkUseCooldownPercent(),
                                turtleBreathWork.isTurtleBreathWorkOff(),
                                turtleBreathWork.getTurtleBreathWorkToppedTick(),
                                turtleBreathWork.getTurtleBreathWorkDachengTick(),
                                turtleBreathWork.isTurtleBreathWorkParticle(),
                                turtleBreathWork.isSkillActive()), (ServerPlayer) pPlayer);
                    }
                });
                ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                        geShanDaNiu.getGeShanDaNiuLevel(),
                        geShanDaNiu.isGeShanDaNiuComprehend(),
                        geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                        geShanDaNiu.getGeShanDaNiuToppedTick(),
                        geShanDaNiu.getGeShanDaNiuDachengTick(),
                        geShanDaNiu.isGeShanDaNiuParticle(),
                        geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                        geShanDaNiu.isSkillActive()), (ServerPlayer) pPlayer);
            });
        }
        return InteractionResultHolder.consume(pPlayer.getItemInHand(pUsedHand));
    }

    public static void comprehend(Player player, Level level, Entity entity){
        if (!level.isClientSide) {
            player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                if (geShanDaNiu.isSkillActive()) {
                    if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.getGeShanDaNiuLevel() == 0) {
                        float probability = player.getRandom().nextFloat();
                        float defaultProbability = !player.getAbilities().instabuild ? 0.01F : 1.0F;
                        if (probability < defaultProbability) {
                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                    ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                            geShanDaNiu.addGeShanDaNiuLevel();
                            geShanDaNiu.setGeShanDaNiuParticle(true);
                            CSJAdvanceEvent.summonChallenger(level, player);

                            ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                                    geShanDaNiu.getGeShanDaNiuLevel(),
                                    geShanDaNiu.isGeShanDaNiuComprehend(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                                    geShanDaNiu.getGeShanDaNiuToppedTick(),
                                    geShanDaNiu.getGeShanDaNiuDachengTick(),
                                    geShanDaNiu.isGeShanDaNiuParticle(),
                                    geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                                    geShanDaNiu.isSkillActive()), (ServerPlayer) player);
                            if (player instanceof ServerPlayer serverPlayer) {
                                CSJAdvanceInit.LEARN_GONG_FA.trigger(serverPlayer);
                            }
                        }
                    }else {
                        if (geShanDaNiu.getGeShanDaNiuLevel() > 0) {
                            LivingEntity livingEntity = (LivingEntity) entity;
                            float probability = player.getRandom().nextFloat();
                            if (livingEntity != player) {
                                if (probability < 0.25F) {
                                    int duration = 300;
                                    int level1 = 0;

                                    if (livingEntity.hasEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get())) {
                                        MobEffectInstance oldEffect = livingEntity.getEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get());
                                        if (oldEffect != null) {
                                            int increment = livingEntity instanceof Zombie ? 2 : 1;
                                            level1 = Math.min(oldEffect.getAmplifier() + increment, 4);
                                        }
                                    }

                                    livingEntity.addEffect(new MobEffectInstance(
                                            ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), duration, level1,
                                            true,
                                            true,
                                            true
                                    ), player);
                                }
                            }
                        }
                    }
                }
            });
        }
    }


    public static void onGeShanDaNiu(Level pLevel, LivingEntity pEntity) {
        if (pEntity instanceof Player player) {
            player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                if (geShanDaNiu.isSkillActive()) {
                    if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.getGeShanDaNiuLevel() > 0) {
                        if (geShanDaNiu.getGeShanDaNiuUseCooldownPercent() <= 0) {
                            if (player.getFoodData().getFoodLevel() > 8) {
                                if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
                                    if (!player.getAbilities().instabuild) {
                                        player.getCapability(TheClassicsOfTendonChangingCapabilityProvider.THE_CLASSICS_OF_TENDON_CHANGING_CAPABILITY).ifPresent(theClassicsOfTendonChanging -> {
                                            int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                                            if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() >= 1) {
                                                player.getFoodData().eat(-foodLevel + 1, -1);//消耗饱食度
                                                if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 100) {
                                                    theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                                                }
                                            } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() > 1) {
                                                player.getFoodData().eat(-foodLevel + 2, -1);//消耗饱食度
                                                if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingUseCount() < 100) {
                                                    theClassicsOfTendonChanging.addTheClassicsOfTendonChangingUseCount(1);
                                                }
                                            } else if (theClassicsOfTendonChanging.getTheClassicsOfTendonChangingLevel() < 1) {
                                                player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
                                            }
                                        });
                                        geShanDaNiu.setGeShanDaNiuUseCooldownPercent(player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ?
                                                geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - 30 : geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax());
                                    }
                                    if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
                                        float radius = geShanDaNiu.getGeShanDaNiuLevel() <= 1 ? 4.0F : 4.0F + 2.0F;
                                        float distance = 2.0F;
                                        Vec3 forward = player.getForward();
                                        Vec3 hitLocation = player.position().add(0, player.getBbHeight() * 0.3f, 0).add(forward.scale(distance));
                                        //radius * 2 表示的是立方体的边长,radius表示的从立方体中心到边界的距离
                                        var entities = pLevel.getEntities(player, AABB.ofSize(hitLocation, radius * 2, radius, radius * 2));
                                        for (Entity entity : entities) {//遍历包围盒中的实体
                                            //检查生物是否可以交互,是否在给定的平方距离内,检查生物是否是LivingEntity,检查生物是否还活着
                                            if (player.isPickable() && player.distanceToSqr(entity) < radius * radius && entity instanceof LivingEntity && entity.isAlive()) {
                                                if (entity.hurt(new DamageSource(pLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE)
                                                                .getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE,
                                                                        new ResourceLocation(ChangShengJue.MOD_ID + ":martial_arts"))), player)
                                                        , player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 22 + 2 : 22)) {//造成伤害
                                                    float probability = player.getRandom().nextFloat();
                                                    if (probability < 0.25F && entity instanceof LivingEntity livingEntity) {
                                                        int duration = 300;
                                                        int level1 = 0;

                                                        if (livingEntity.hasEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get())) {
                                                            MobEffectInstance oldEffect = livingEntity.getEffect(ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get());
                                                            if (oldEffect != null) {
                                                                int increment = livingEntity instanceof Zombie ? 2 : 1;
                                                                level1 = Math.min(oldEffect.getAmplifier() + increment, 4);
                                                            }
                                                        }

                                                        livingEntity.addEffect(new MobEffectInstance(
                                                                ChangShengJueEffects.INTERNAL_INJURY_EFFECT.get(), duration, level1,
                                                                true,
                                                                true,
                                                                true
                                                        ), player);
                                                    }

                                                    EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                                                    if (geShanDaNiu.getGeShanDaNiuUseCount() <= 100) {
                                                        geShanDaNiu.addGeShanDaNiuUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                                        if (geShanDaNiu.getGeShanDaNiuUseCount() >= 100) {
                                                            geShanDaNiu.setGeShanDaNiuParticle(true);
                                                            pLevel.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                                    ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        GeShanDaNiuEntity geShanDaNiuEntity = new GeShanDaNiuEntity(ChangShengJueEntity.GE_SHAN_DA_NIU.get(), pLevel);
                                        geShanDaNiuEntity.moveTo(hitLocation);
                                        geShanDaNiuEntity.setYRot(player.getYRot());
                                        geShanDaNiuEntity.setXRot(player.getXRot());
                                        pLevel.addFreshEntity(geShanDaNiuEntity);
                                    }
                                    if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())) {
                                        player.setHealth(player.getHealth() + 1);
                                    }
                                    if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())) {
                                        player.getFoodData().eat(1, 0);
                                    }
                                    player.getMainHandItem().hurtAndBreak(1, player, (player1) -> {//消耗耐久
                                        player1.broadcastBreakEvent(player.getUsedItemHand());
                                    });
                                }
                            }
                        }
                    }
                    ChangShengJueMessages.sendToPlayer(new GeShanDaNiuPacket(
                            geShanDaNiu.getGeShanDaNiuLevel(),
                            geShanDaNiu.isGeShanDaNiuComprehend(),
                            geShanDaNiu.getGeShanDaNiuUseCooldownPercent(),
                            geShanDaNiu.getGeShanDaNiuToppedTick(),
                            geShanDaNiu.getGeShanDaNiuDachengTick(),
                            geShanDaNiu.isGeShanDaNiuParticle(),
                            geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax(),
                            geShanDaNiu.isSkillActive()), (ServerPlayer) player);
                }
            });
        }
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()) {
            Component fullDesc = Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "."
                    + this + ".hold_shift.tooltip").withStyle(ChatFormatting.YELLOW);
            String formattedText = fullDesc.getString();
            Arrays.stream(formattedText.split("\\u000A|\\\\n"))
                    .map(line -> Component.literal(line).withStyle(fullDesc.getStyle()))
                    .forEach(pTooltipComponents::add);
        } else {
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID + "." + this + ".tooltip").withStyle(ChatFormatting.YELLOW));
            // 提示按住Shift
            pTooltipComponents.add(Component.translatable("tooltip."+ ChangShengJue.MOD_ID +".hold_shift.tooltip"));
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
