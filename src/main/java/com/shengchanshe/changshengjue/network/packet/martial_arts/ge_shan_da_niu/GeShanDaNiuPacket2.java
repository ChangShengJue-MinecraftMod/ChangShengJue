package com.shengchanshe.changshengjue.network.packet.martial_arts.ge_shan_da_niu;

import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.ge_shan_da_niu.GeShanDaNiuCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.immortal_miracle.ImmortalMiracleCapabilityProvider;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapability;
import com.shengchanshe.changshengjue.capability.martial_arts.sunflower_point_caveman.SunflowerPointCavemanCapabilityProvider;
import com.shengchanshe.changshengjue.effect.ChangShengJueEffects;
import com.shengchanshe.changshengjue.entity.ChangShengJueEntity;
import com.shengchanshe.changshengjue.entity.combat.ge_shan_da_niu.GeShanDaNiuEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.immortal_miracle.ImmortalMiraclePacket;
import com.shengchanshe.changshengjue.network.packet.martial_arts.sunflower_point_caveman.SunflowerPointCavemanPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class GeShanDaNiuPacket2 {

    private String key;

    public GeShanDaNiuPacket2(String key) {
        this.key = key;
    }

    public GeShanDaNiuPacket2(FriendlyByteBuf buf) {
        this.key = buf.readUtf(32767); // 读取按键
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(this.key); // 写入按键
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(GeShanDaNiuCapabilityProvider.GE_SHAN_DA_NIU_CAPABILITY).ifPresent(geShanDaNiu -> {
                if (this.key.equals("Z")){
                    geShanDaNiu.setSkillZActive(!geShanDaNiu.isSkillZActive());
                    player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle ->{
                        if (immortalMiracle.isSkillZActive()){
                            immortalMiracle.setSkillZActive(false);
                            immortalMiracleMessages(immortalMiracle,player);
                        }
                    });
                    player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman ->{
                        if (sunflowerPointCaveman.isSkillZActive()){
                            sunflowerPointCaveman.setSkillZActive(false);
                            sunflowerPointCavemanMessages(sunflowerPointCaveman,player);
                        }
                    });
                    player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar ->{
                        if (goldenBellJar.isSkillZActive()){
                            goldenBellJar.setSkillZActive(false);
                            goldenBellJarMessages(goldenBellJar,player);
                        }
                    });

                    if (!geShanDaNiu.isGeShanDaNiuComprehend()){
                        geShanDaNiu.setGeShanDaNiuComprehend(true);
                    }

                }else if (this.key.equals("X")){
                    geShanDaNiu.setSkillXActive(!geShanDaNiu.isSkillXActive());
                    player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle ->{
                        if (immortalMiracle.isSkillXActive()){
                            immortalMiracle.setSkillXActive(false);
                            immortalMiracleMessages(immortalMiracle,player);
                        }
                    });
                    player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman ->{
                        if (sunflowerPointCaveman.isSkillXActive()){
                            sunflowerPointCaveman.setSkillXActive(false);
                            sunflowerPointCavemanMessages(sunflowerPointCaveman,player);
                        }
                    });
                    player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar ->{
                        if (goldenBellJar.isSkillXActive()){
                            goldenBellJar.setSkillXActive(false);
                            goldenBellJarMessages(goldenBellJar,player);
                        }
                    });

                    if (!geShanDaNiu.isGeShanDaNiuComprehend()){
                        geShanDaNiu.setGeShanDaNiuComprehend(true);
                    }

                }else if (this.key.equals("C")){
                    geShanDaNiu.setSkillCActive(!geShanDaNiu.isSkillCActive());
                    player.getCapability(ImmortalMiracleCapabilityProvider.IMMORTAL_MIRACLE_CAPABILITY).ifPresent(immortalMiracle ->{
                        if (immortalMiracle.isSkillCActive()){
                            immortalMiracle.setSkillCActive(false);
                            immortalMiracleMessages(immortalMiracle,player);
                        }
                    });
                    player.getCapability(SunflowerPointCavemanCapabilityProvider.SUNFLOWER_POINT_CAVEMAN_CAPABILITY).ifPresent(sunflowerPointCaveman ->{
                        if (sunflowerPointCaveman.isSkillCActive()){
                            sunflowerPointCaveman.setSkillCActive(false);
                            sunflowerPointCavemanMessages(sunflowerPointCaveman,player);
                        }
                    });
                    if (!geShanDaNiu.isGeShanDaNiuComprehend()){
                        geShanDaNiu.setGeShanDaNiuComprehend(true);
                    }
                    player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar ->{
                        if (goldenBellJar.isSkillCActive()){
                            goldenBellJar.setSkillCActive(false);
                            goldenBellJarMessages(goldenBellJar,player);
                        }
                    });
                }else {
                    if (geShanDaNiu.isGeShanDaNiuComprehend() && geShanDaNiu.getGeShanDaNiuLevel() > 0) {
                        if (geShanDaNiu.getGeShanDaNiuUseCooldownPercent() <= 0) {
                            if (player.getFoodData().getFoodLevel() > 8) {
                                if (geShanDaNiu.getGeShanDaNiuLevel() >= 1) {
                                    ItemStack itemstack = player.getMainHandItem();//获取玩家手中物品
                                    if (!player.getAbilities().instabuild) {
                                        int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
                                        player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
                                        geShanDaNiu.setGeShanDaNiuUseCooldownPercent(player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get()) ?
                                                geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax() - 1.5F : geShanDaNiu.getGeShanDaNiuUseCooldownPercentMax());
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
                                                if (entity.hurt(player.damageSources().playerAttack(player), 14)) {//造成伤害
                                                    EnchantmentHelper.doPostDamageEffects(player, entity);//应用附魔
                                                    if (geShanDaNiu.getGeShanDaNiuUseCount() <= 100) {
                                                        geShanDaNiu.addGeShanDaNiuUseCount(!player.getAbilities().instabuild ? 1 : 100);
                                                        if (geShanDaNiu.getGeShanDaNiuUseCount() >= 100){
                                                            geShanDaNiu.setGeShanDaNiuParticle(true);
                                                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                                    ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
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
                                    if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
                                        player.setHealth(player.getHealth() + 1);
                                    }
                                    if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
                                        player.getFoodData().eat(1,0);
                                    }
                                }
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
                        geShanDaNiu.isSkillZActive(),
                        geShanDaNiu.isSkillXActive(),
                        geShanDaNiu.isSkillCActive()), player);
            });
        });
        return true;
    }

    public void immortalMiracleMessages(ImmortalMiracleCapability immortalMiracle, ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new ImmortalMiraclePacket(
                immortalMiracle.getImmortalMiracleLevel(),
                immortalMiracle.isImmortalMiracleComprehend(),
                immortalMiracle.getImmortalMiracleUseCooldownPercent(),
                immortalMiracle.isImmortalMiracleOff(),
                immortalMiracle.getImmortalMiracleToppedTick(),
                immortalMiracle.getImmortalMiracleDachengTick(),
                immortalMiracle.isImmortalMiracleParticle(),
                immortalMiracle.getImmortalMiracleUseCooldownPercentMax(),
                immortalMiracle.isSkillZActive(),
                immortalMiracle.isSkillXActive(),
                immortalMiracle.isSkillCActive()), player);
    }
    public void sunflowerPointCavemanMessages(SunflowerPointCavemanCapability sunflowerPointCaveman, ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new SunflowerPointCavemanPacket(
                sunflowerPointCaveman.getSunflowerPointCavemanLevel(),
                sunflowerPointCaveman.isSunflowerPointCavemanComprehend(),
                sunflowerPointCaveman.getSunflowerPointCavemanUseCooldownPercent(),
                sunflowerPointCaveman.isSunflowerPointCavemanOff(),
                sunflowerPointCaveman.getSunflowerPointCavemanToppedTick(),
                sunflowerPointCaveman.getSunflowerPointCavemanDachengTick(),
                sunflowerPointCaveman.isSunflowerPointCavemanParticle(),
                sunflowerPointCaveman.isSkillZActive(),
                sunflowerPointCaveman.isSkillXActive(),
                sunflowerPointCaveman.isSkillCActive()), player);
    }
    public void goldenBellJarMessages(GoldenBellJarCapability goldenBellJar, ServerPlayer player){
        ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                goldenBellJar.getGoldenBellJarLevel(),
                goldenBellJar.isGoldenBellJarComprehend(),
                goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                goldenBellJar.isGoldenBellJarOff(),
                goldenBellJar.getGoldenBellJarToppedTick(),
                goldenBellJar.getGoldenBellJarDachengTick(),
                goldenBellJar.isGoldenBellJarParticle(),
                goldenBellJar.isSkillZActive(),
                goldenBellJar.isSkillXActive(),
                goldenBellJar.isSkillCActive()), player);
    }
}
