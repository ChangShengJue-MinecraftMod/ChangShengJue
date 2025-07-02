package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.wu_gang_cut_gui.WuGangCutGuiClientData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.wu_gang_cut_gui.WuGangCutGuiPacket1;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class WuGangCutGuiEvent {

    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (!player.level().isClientSide) {
                player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
                    if (wuGangCutGui.isWuGangCutGuiParticle()){
                        if (wuGangCutGui.getWuGangCutGuiLevel() == 1){
                            wuGangCutGui.setWuGangCutGuiToppedTick();
                            ChangShengJueMessages.sendToPlayer(new WuGangCutGuiPacket1(
                                    wuGangCutGui.getWuGangCutGuiToppedTick(),
                                    wuGangCutGui.getWuGangCutGuiDachengTick(),
                                    wuGangCutGui.isWuGangCutGuiParticle()), (ServerPlayer) player);
                        }else if (wuGangCutGui.getWuGangCutGuiLevel() == 2){
                            wuGangCutGui.setWuGangCutGuiDachengTick();
                            ChangShengJueMessages.sendToPlayer(new WuGangCutGuiPacket1(
                                    wuGangCutGui.getWuGangCutGuiToppedTick(),
                                    wuGangCutGui.getWuGangCutGuiDachengTick(),
                                    wuGangCutGui.isWuGangCutGuiParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide) {
                BlockPos dropPos = WuGangCutGuiClientData.getDropPos();
                if (WuGangCutGuiClientData.getDropPos() != null && WuGangCutGuiClientData.getParticleTick() <= 20 && WuGangCutGuiClientData.getParticleTick() > 0){
                    if (WuGangCutGuiClientData.getParticleTick() > 18) {
                        // 粒子生成在玩家脚下
                        double particleX = dropPos.getX() + 0.5;
                        double particleY = dropPos.getY();  // 粒子生成在玩家脚下
                        double particleZ = dropPos.getZ() + 0.5;

                        // 生成粒子并设置速度为0
                        player.level().addParticle(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE_1.get(), particleX, particleY, particleZ, 0, 0, 0);
                    }
                    double radius = 0.5;
                    int numberOfPoints = 2; // 生成数量
                    for (int i = 0; i < numberOfPoints; i++) {
                        // 随机生成一个点
                        double phi = Math.random() * Math.PI * 2; // 随机生成方位角
                        double costheta = Math.random() * 2 - 1; // 随机生成余弦值
                        double theta = Math.acos(costheta); // 计算天顶角
                        double dx = radius * Math.sin(theta) * Math.cos(phi); // 计算X坐标
                        double dy = radius * Math.sin(theta) * Math.sin(phi); // 计算Y坐标
                        double dz = radius * Math.cos(theta); // 计算Z坐标

                        double speedFactor = 0.1;
                        // 计算粒子的速度向量，向外飞出
                        double speedX = dx * speedFactor;
                        double speedY = dy * speedFactor;
                        double speedZ = dz * speedFactor;

                        // 生成粒子并设置速度
                        player.level().addParticle(ChangShengJueParticles.WU_GANG_CUT_GUI_PARTICLE.get(), dropPos.getX() + dx + 0.5, dropPos.getY() + 0.1 + dy, dropPos.getZ() + dz + 0.5, speedX, speedY, speedZ);
                    }
                    WuGangCutGuiClientData.setParticleTick(WuGangCutGuiClientData.getParticleTick());
                }
                if (WuGangCutGuiClientData.isWuGangCutGuiParticle()) {
                    ComprehendParticle.ComprehendParticle(player, player.level(), WuGangCutGuiClientData.getWuGangCutGuiToppedTick());
                }
                if (WuGangCutGuiClientData.isWuGangCutGuiParticle()) {
                    DachengParticle.DachengParticle(player, player.level(), WuGangCutGuiClientData.getWuGangCutGuiDachengTick());
                }
            }
        }
    }

//    public static void onEntityHurt(LivingDamageEvent event){
//        Level level = event.getEntity().level();
//        if (!level.isClientSide){
//            if (event.getSource().getDirectEntity() instanceof Player directEntity){
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
//                    if (!directEntity.isShiftKeyDown()){
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
//                        if (wuGangCutGui.isWuGangCutGuiComprehend() && wuGangCutGui.getWuGangCutGuiLevel() == 0) {
//                            float probability = directEntity.getRandom().nextFloat();
//                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                            if (probability < defaultProbability) {
//                                wuGangCutGui.addWuGangCutGuiLevel();
//                                wuGangCutGui.setWuGangCutGuiParticle(true);
//                                level.playSound(null, directEntity.getX(), directEntity.getY(), directEntity.getZ(),
//                                        ChangShengJueSound.COMPREHEND_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

    public static void onInteract(PlayerInteractEvent event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide) {
            player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGuiCapability -> {
                if (wuGangCutGuiCapability.isWuGangCutGuiComprehend() && wuGangCutGuiCapability.getWuGangCutGuiLevel() > 1) {
                    // 判断是否正在挖掘木头
                    if (player.level().getBlockState(event.getPos()).is(BlockTags.LOGS)) {
                        // 添加临时挖掘加速效果
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 1));
                    }
                }
            });
        }
    }

//    public static void handleBlockBreakEvent(BlockEvent.BreakEvent event){
//        Player player = event.getPlayer();
//        Level level = player.getCommandSenderWorld();
//        if (!level.isClientSide) {
//            player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
//                if (wuGangCutGui.isWuGangCutGuiComprehend() && wuGangCutGui.getWuGangCutGuiLevel() >= 1) {
//                    BlockPos startPos = event.getPos();
//                    BlockState blockState = level.getBlockState(startPos);
//                    ItemStack mainHandItem = player.getMainHandItem();
//                    if (mainHandItem.getItem() instanceof XuanhuaAxe xuanhuaAxe) {
//                        // 判断是否是木头
//                        if (isLog(blockState)) {
//                            // 存储已处理的方块
//                            Set<BlockPos> visited = new HashSet<>();
//                            // 记录第一个破坏的位置
//                            BlockPos dropPos = startPos;
//                            // 执行连锁砍树
//                            chopTree((ServerLevel) level, startPos, visited, dropPos, mainHandItem, player);
//                            level.playSound(null, player.getX(), player.getY(), player.getZ(),
//                                    ChangShengJueSound.WU_GANG_CUT_GUI_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                            wuGangCutGui.setWuGangCutGuiMaxDamage(player.getRandom().nextFloat() > 0.2 ? 0 : 1);
//                            if (wuGangCutGui.getWuGangCutGuiUseCount() < 1000) {
//                                wuGangCutGui.addWuGangCutGuiUseCount(!player.getAbilities().instabuild ? 1 : 1000);
//                                if (wuGangCutGui.getWuGangCutGuiUseCount() >= 1000){
//                                    level.playSound(null, player.getX(), player.getY(), player.getZ(),
//                                            ChangShengJueSound.DACHENG_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
//                                    wuGangCutGui.setWuGangCutGuiParticle(true);
//                                }
//                            }
//                            ChangShengJueMessages.sendToServer(new WuGangCutGuiPacket(dropPos,20));
//                        }
//                    }
//                }
//            });
//        }
//    }

//    private static boolean isLog(BlockState state) {
//        return state.is(BlockTags.LOGS);// 可添加其他木头类型
//    }
//    private static void chopTree(ServerLevel world, BlockPos pos, Set<BlockPos> visited, BlockPos dropPos,ItemStack stack,Player player) {
//        if (visited.contains(pos)) return;
//        visited.add(pos);
//        BlockState state = world.getBlockState(pos);
//        // 检测是否为木头
//        if (isLog(state)) {
//            // 获取掉落物品
//            for (ItemStack drop : Block.getDrops(state, world, pos, null)) {
//                // 将掉落物生成在第一个方块的位置
//                world.addFreshEntity(new ItemEntity(world, dropPos.getX() + 0.5, dropPos.getY() + 0.5, dropPos.getZ() + 0.5, drop));
//            }
//            // 破坏方块但不掉落物品
//            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
//            // 检测相邻方块
//            for (BlockPos adjacent : getAdjacentPositions(pos)) {
//                chopTree(world, adjacent, visited, dropPos,stack,player);
//            }
//            stack.hurtAndBreak(1, player, player1 -> {
//                player1.broadcastBreakEvent(player.getUsedItemHand());
//            });
//        }
//    }
//
//    private static Iterable<BlockPos> getAdjacentPositions(BlockPos pos) {
//        return Set.of(
//                pos.above(), pos.north(), pos.south(),
//                pos.east(), pos.west()
//        );
//    }
}
