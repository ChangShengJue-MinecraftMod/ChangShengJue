package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.golden_bell_jar.GoldenBellJarCapabilityProvider;
import com.shengchanshe.changshengjue.cilent.hud.martial_arts.golden_bell_jar.GoldenBellJarClientData;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import com.shengchanshe.changshengjue.network.ChangShengJueMessages;
import com.shengchanshe.changshengjue.network.packet.martial_arts.golden_bell_jar.GoldenBellJarPacket;
import com.shengchanshe.changshengjue.sound.ChangShengJueSound;
import com.shengchanshe.changshengjue.util.particle.ComprehendParticle;
import com.shengchanshe.changshengjue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class GoldenBellJarEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level();
            if (!player.level().isClientSide) {
                player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
                    if (goldenBellJar.getGoldenBellJarUseCooldownPercent() > 0) {
                        if (goldenBellJar.isSkillActive()) {
                            goldenBellJar.setGoldenBellJarUseCooldownPercent();
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff(),
                                    goldenBellJar.getGoldenBellJarToppedTick(),
                                    goldenBellJar.getGoldenBellJarDachengTick(),
                                    goldenBellJar.isGoldenBellJarParticle(),
                                    goldenBellJar.isSkillActive()), (ServerPlayer) player);
                        }
                    }
//                    if (goldenBellJar.isGoldenBellJarOff()){
//                        goldenBellJar.getGoldenBellJarKeyTick();
//                        if (goldenBellJar.getGoldenBellJarKeyTick() < 0){
//                            goldenBellJar.setGoldenBellJarKeyTick(100);
//                            goldenBellJar.setGoldenBellJarOff(false);
//                        }
//                        ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                                goldenBellJar.getGoldenBellJarLevel(),
//                                goldenBellJar.isGoldenBellJarComprehend(),
//                                goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                                goldenBellJar.isGoldenBellJarOff(),
//                                goldenBellJar.getGoldenBellJarToppedTick(),
//                                goldenBellJar.getGoldenBellJarDachengTick(),
//                                goldenBellJar.isGoldenBellJarParticle(),
//                                goldenBellJar.isSkillZActive(),
//                                goldenBellJar.isSkillXActive(),
//                                goldenBellJar.isSkillCActive()), (ServerPlayer) player);
//                    }
                    if (goldenBellJar.isGoldenBellJarParticle()){
                        if (goldenBellJar.getGoldenBellJarLevel() == 1){
                            goldenBellJar.setGoldenBellJarToppedTick();
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff(),
                                    goldenBellJar.getGoldenBellJarToppedTick(),
                                    goldenBellJar.getGoldenBellJarDachengTick(),
                                    goldenBellJar.isGoldenBellJarParticle(),
                                    goldenBellJar.isSkillActive()), (ServerPlayer) player);
                        }else if (goldenBellJar.getGoldenBellJarLevel() == 2){
                            goldenBellJar.setGoldenBellJarDachengTick();
                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
                                    goldenBellJar.getGoldenBellJarLevel(),
                                    goldenBellJar.isGoldenBellJarComprehend(),
                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
                                    goldenBellJar.isGoldenBellJarOff(),
                                    goldenBellJar.getGoldenBellJarToppedTick(),
                                    goldenBellJar.getGoldenBellJarDachengTick(),
                                    goldenBellJar.isGoldenBellJarParticle(),
                                    goldenBellJar.isSkillActive()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide){
                if (GoldenBellJarClientData.isGoldenBellJarParticle()) {
                    ComprehendParticle.ComprehendParticle(player, level, GoldenBellJarClientData.getGoldenBellJarToppedTick());
                }
                if (GoldenBellJarClientData.isGoldenBellJarParticle()) {
                    DachengParticle.DachengParticle(player, level, GoldenBellJarClientData.getGoldenBellJarDachengTick());
                }
            }
        }
    }

    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event) {
//        Level level = event.getEntity().level();
//        if (!level.isClientSide) {
//            if (event.getSource().getDirectEntity() instanceof Player directEntity) {
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()) {
//                    if (!directEntity.isShiftKeyDown()) {
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                        if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.getGoldenBellJarLevel() == 0) {
//                            if (goldenBellJar.isSkillZActive() || goldenBellJar.isSkillXActive() || goldenBellJar.isSkillCActive()) {
//                                float probability = directEntity.getRandom().nextFloat();
//                                float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                                if (probability < defaultProbability) {
//                                    level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                            ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                    goldenBellJar.addGoldenBellJarLevel();
//                                    goldenBellJar.setGoldenBellJarParticle(true);
//                                    ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                                            goldenBellJar.getGoldenBellJarLevel(),
//                                            goldenBellJar.isGoldenBellJarComprehend(),
//                                            goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                                            goldenBellJar.isGoldenBellJarOff(),
//                                            goldenBellJar.getGoldenBellJarToppedTick(),
//                                            goldenBellJar.getGoldenBellJarDachengTick(),
//                                            goldenBellJar.isGoldenBellJarParticle(),
//                                            goldenBellJar.isSkillZActive(),
//                                            goldenBellJar.isSkillXActive(),
//                                            goldenBellJar.isSkillCActive()), (ServerPlayer) directEntity);
//                                }
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

//    public static void onKey(InputEvent.Key event) {
//        Minecraft minecraft = Minecraft.getInstance();
//        Player player = minecraft.player;
//        // 检查游戏窗口是否处于活动状态和是否有 GUI 打开
//        if (player == null || !minecraft.isWindowActive() || minecraft.screen != null) return;
//
//        // 玩家按下了键
//        if (event.getAction() == GLFW.GLFW_PRESS) {
//            int keyCode = event.getKey(); // 获取按键代码
//            if (player.getMainHandItem().is(ChangShengJueItems.GOLDEN_BELL_JAR.get())) {
//                if (GoldenBellJarClientData.isGoldenBellJarOff()){
//                    ChangShengJueMessages.sendToServer(new GoldenBellJarPacketKey(keyCode));
//                }else if (keyCode == GoldenBellJarClientData.getGoldenBellJarKey()){
//                    ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2(keyCode));
//                }
//            }else if (keyCode == GoldenBellJarClientData.getGoldenBellJarKey()){
//                ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2(keyCode));
//            }
//        }
//
//    }

//    private static boolean isKeyReserved(String keyName) {
//        // 这里只是一个简单的例子，您可能需要检查所有的原版按键
//        return "key.keyboard.w".equals(keyName) || "key.keyboard.a".equals(keyName) || "key.keyboard.s".equals(keyName) || "key.keyboard.d".equals(keyName);
//    }

//    public static void onPlayerEntityInteract(PlayerInteractEvent.EntityInteract event) {
//        Player player = event.getEntity();
//        if (!event.getLevel().isClientSide) {
//            player.getCapability(GoldenBellJarCapabilityProvider.GOLDEN_BELL_JAR_CAPABILITY).ifPresent(goldenBellJar -> {
//                if (goldenBellJar.isGoldenBellJarComprehend() && goldenBellJar.isGoldenBellJarOff() && goldenBellJar.getGoldenBellJarLevel() > 0) {
//                    if (goldenBellJar.getGoldenBellJarUseCooldownPercent() <= 0) {
//                        if (player.getFoodData().getFoodLevel() > 8) {
//                            if (!player.getAbilities().instabuild) {
//                                int foodLevel = player.hasEffect(ChangShengJueEffects.SHI_LI_XIANG.get()) ? 1 : player.hasEffect(ChangShengJueEffects.FEN_JIU.get()) ? 3 : 2;
//                                player.getFoodData().eat(-foodLevel, -1);//消耗饱食度
//                            }
//                            if (player.hasEffect(ChangShengJueEffects.WHEAT_NUGGETS_TRIBUTE_WINE.get())){
//                                goldenBellJar.setGoldenBellJarUseCooldownPercent(!player.getAbilities().instabuild ? 145 : 0);
//                            }else {
//                                goldenBellJar.setGoldenBellJarUseCooldownPercent(!player.getAbilities().instabuild ? 160 : 0);
//                            }
//                            player.addEffect(new MobEffectInstance(ChangShengJueEffects.GOLDEN_BELL_JAR_EFFECT.get(), 120, goldenBellJar.getGoldenBellJarLevel() < 2 ? 0 : 1, false, false), player);
//                            if (player.hasEffect(ChangShengJueEffects.LONG_JING_TEAS.get())){
//                                player.getFoodData().eat(1,0);
//                            }
//                            if (player.hasEffect(ChangShengJueEffects.BILUOCHUN_TEAS.get())){
////                                if (!player.getAbilities().instabuild) {
////                                    player.getFoodData().eat((int) -(3 - (3 * 0.25)), (float) -(2 - (2 * 0.25)));//消耗饱食度
////                                }
//                                player.setHealth(player.getHealth() + 1);
//                            }
//                            if (goldenBellJar.getGoldenBellJarUseCount() <= 100){
//                                goldenBellJar.addGoldenBellJarUseCount(!player.getAbilities().instabuild ? 1 : 100);
//                                if (goldenBellJar.getGoldenBellJarUseCount() >= 100){
//                                    goldenBellJar.setGoldenBellJarParticle(true);
//                                    event.getLevel().playSound(null, player.getX(), player.getY(), player.getZ(),
//                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                }
//                            }
//                            ChangShengJueMessages.sendToPlayer(new GoldenBellJarPacket(
//                                    goldenBellJar.getGoldenBellJarLevel(),
//                                    goldenBellJar.isGoldenBellJarComprehend(),
//                                    goldenBellJar.getGoldenBellJarUseCooldownPercent(),
//                                    goldenBellJar.isGoldenBellJarOff(),
//                                    goldenBellJar.getGoldenBellJarToppedTick(),
//                                    goldenBellJar.getGoldenBellJarDachengTick(),
//                                    goldenBellJar.isGoldenBellJarParticle(),
//                                    goldenBellJar.getGoldenBellJarKey()), (ServerPlayer) player);
//                        }
//                    }
//                }
//            });
//        }else {
//            boolean goldenBellJarComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
//            boolean goldenBellJarOff = GoldenBellJarClientData.isGoldenBellJarOff();
//            if (goldenBellJarComprehend && goldenBellJarOff){
//                if (GoldenBellJarClientData.getGoldenBellJarLevel() >= 1){
//                    if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent()<=0) {
//                        if (player.getFoodData().getFoodLevel() > 8){
//                            player.swing(player.getUsedItemHand());
//                        }
//                    }
//                }
//            }
//        }
//    }

//    public static void onPlayerRightClickItem(PlayerInteractEvent.RightClickItem event) {
//        Player player = event.getEntity();
//        if (!player.isUsingItem()){
//            return;
//        }
//        ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2());
//        boolean geShanDaNiuComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
//        boolean geShanDaNiuOff = GoldenBellJarClientData.isGoldenBellJarOff();
//        if (geShanDaNiuComprehend && geShanDaNiuOff){
//            if (GoldenBellJarClientData.getGoldenBellJarLevel() >= 1){
//                if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent()<=0) {
//                    if (player.getFoodData().getFoodLevel() > 8){
//                        player.swing(player.getUsedItemHand());
//                    }
//                }
//            }
//        }
//    }
//
//    public static void onPlayerRightClick(PlayerInteractEvent.RightClickEmpty event) {
//        Player player = event.getEntity();
//        ChangShengJueMessages.sendToServer(new GoldenBellJarPacket2());
//        boolean goldenBellJarComprehend = GoldenBellJarClientData.isGoldenBellJarComprehend();
//        boolean goldenBellJarOff = GoldenBellJarClientData.isGoldenBellJarOff();
//        if (goldenBellJarComprehend && goldenBellJarOff){
//            if (GoldenBellJarClientData.getGoldenBellJarLevel() >= 1){
//                if (GoldenBellJarClientData.getGoldenBellJarUseCooldownPercent()<=0) {
//                    if (player.getFoodData().getFoodLevel() > 8){
//                        player.swing(player.getUsedItemHand());
//                    }
//                }
//            }
//        }
//    }
}
