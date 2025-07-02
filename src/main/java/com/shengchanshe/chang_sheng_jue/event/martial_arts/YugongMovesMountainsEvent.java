package com.shengchanshe.chang_sheng_jue.event.martial_arts;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.cilent.hud.martial_arts.yugong_moves_mountains.YugongMovesMountainsClientData;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.martial_arts.YugongMovesMountainsPacket;
import com.shengchanshe.chang_sheng_jue.util.particle.ComprehendParticle;
import com.shengchanshe.chang_sheng_jue.util.particle.DachengParticle;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;

public class YugongMovesMountainsEvent {
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            if (!player.level().isClientSide) {
                player.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
                    if (yugongMovesMountains.isYugongMovesMountainsParticle()){
                        if (yugongMovesMountains.getYugongMovesMountainsLevel() == 1){
                            yugongMovesMountains.setYugongMovesMountainsToppedTick();
                            ChangShengJueMessages.sendToPlayer(new YugongMovesMountainsPacket(
                                    yugongMovesMountains.getYugongMovesMountainsLevel(),
                                    yugongMovesMountains.isYugongMovesMountainsComprehend(),
                                    yugongMovesMountains.getYugongMovesMountainsToppedTick(),
                                    yugongMovesMountains.getYugongMovesMountainsDachengTick(),
                                    yugongMovesMountains.isYugongMovesMountainsParticle()), (ServerPlayer) player);
                        }else if (yugongMovesMountains.getYugongMovesMountainsLevel() == 2){
                            yugongMovesMountains.setYugongMovesMountainsDachengTick();
                            ChangShengJueMessages.sendToPlayer(new YugongMovesMountainsPacket(
                                    yugongMovesMountains.getYugongMovesMountainsLevel(),
                                    yugongMovesMountains.isYugongMovesMountainsComprehend(),
                                    yugongMovesMountains.getYugongMovesMountainsToppedTick(),
                                    yugongMovesMountains.getYugongMovesMountainsDachengTick(),
                                    yugongMovesMountains.isYugongMovesMountainsParticle()), (ServerPlayer) player);
                        }
                    }
                });
            }
            if (player.level().isClientSide) {
                if (YugongMovesMountainsClientData.isYugongMovesMountainsParticle()) {
                    ComprehendParticle.ComprehendParticle(player, player.level(), YugongMovesMountainsClientData.getYugongMovesMountainsToppedTick());
                }
                if (YugongMovesMountainsClientData.isYugongMovesMountainsParticle()) {
                    DachengParticle.DachengParticle(player, player.level(), YugongMovesMountainsClientData.getYugongMovesMountainsDachengTick());
                }
            }
        }
    }
//    //生物受伤事件
//    public static void onEntityHurt(LivingDamageEvent event){
//        Level level = event.getEntity().level();
//        if (!level.isClientSide){
//            if (event.getSource().getDirectEntity() instanceof Player directEntity){
//                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
//                    if (!directEntity.isShiftKeyDown()){
//                        event.setAmount(0);
//                    }
//                    directEntity.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
//                        if (yugongMovesMountains.isYugongMovesMountainsComprehend() && yugongMovesMountains.getYugongMovesMountainsLevel() == 0) {
//                            float probability = directEntity.getRandom().nextFloat();
//                            float defaultProbability = !directEntity.getAbilities().instabuild ? 0.01F : 1.0F;
//                            if (probability < defaultProbability) {
//                                yugongMovesMountains.addYugongMovesMountainsLevel();
//                            }
//                        }
//                    });
//                }
//            }
//        }
//    }

//    public static void handleBlockBreakEvent(BlockEvent.BreakEvent event) {
//        Player player = event.getPlayer();
//        Level world = player.getCommandSenderWorld();
//        if (!world.isClientSide) {
//            if (!player.getAbilities().instabuild){
//                player.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
//                    if (yugongMovesMountains.isYugongMovesMountainsComprehend() && yugongMovesMountains.getYugongMovesMountainsLevel() != 0) {
//                        BlockPos pos = event.getPos();
//                        BlockState state = event.getState();
//                        ItemStack handItem = player.getMainHandItem();
//                        Set<BlockPos> blocksToMine;
//                        if (yugongMovesMountains.getYugongMovesMountainsLevel() <= 1){
//                            blocksToMine = findBlocksToMine(world, pos, state, Math.min(handItem.getDamageValue(), 2));
//                            for (BlockPos p : blocksToMine) {
//                                world.destroyBlock(p, true, player);
//                            }
//                        }else {
//                            blocksToMine = findBlocksToMine(world, pos, state, Math.min(handItem.getDamageValue(), 3));
//                            for (BlockPos p : blocksToMine) {
//                                world.destroyBlock(p, true, player);
//                            }
//                        }
//                        if (handItem.getDamageValue() != 0) {
//                            handItem.setDamageValue(Math.min(handItem.getDamageValue() + blocksToMine.size(), handItem.getMaxDamage()));
//                        }
//                        if (yugongMovesMountains.getYugongMovesMountainsUseCount() <= 1) {
//                            yugongMovesMountains.addYugongMovesMountainsUseCount();
//                        }
//                    }
//                });
//            }
//        }
//    }
//
//    private static Set<BlockPos> findBlocksToMine(Level world, BlockPos pos, BlockState originalState, int damageValue) {
//        Set<BlockPos> blocksToMine = new HashSet<>();
//        Queue<BlockPos> queue = new ArrayDeque<>();
//        queue.add(pos);
//        while (!queue.isEmpty()) {
//            BlockPos currentPos = queue.poll();
//            if (blocksToMine.contains(currentPos)) {
//                continue;
//            }
//            BlockState currentState = world.getBlockState(currentPos);
//            if (currentState.getBlock() == originalState.getBlock()) {
//                blocksToMine.add(currentPos);
//                for (BlockPos adjacentPos : getAdjacentPositions(currentPos)) {
//                    if (!queue.contains(adjacentPos)) {
//                        queue.add(adjacentPos);
//                    }
//                }
//            }
//            if (blocksToMine.size() >= damageValue) {
//                return blocksToMine;
//            }
//        }
//        return blocksToMine;
//    }
//
//    private static Set<BlockPos> getAdjacentPositions(BlockPos pos) {
//        Set<BlockPos> adjacentPositions = new HashSet<>();
//        adjacentPositions.add(pos.north());
//        adjacentPositions.add(pos.south());
//        adjacentPositions.add(pos.east());
//        adjacentPositions.add(pos.west());
//        adjacentPositions.add(pos.north().east());
//        adjacentPositions.add(pos.east().south());
//        adjacentPositions.add(pos.south().west());
//        adjacentPositions.add(pos.west().north());
//        adjacentPositions.add(pos.north().east());
//        adjacentPositions.add(pos.east().south());
//        adjacentPositions.add(pos.south().west());
//        adjacentPositions.add(pos.west().north());
//        return adjacentPositions;
//    }

}
