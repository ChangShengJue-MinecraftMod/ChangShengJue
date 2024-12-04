package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class YugongMovesMountainsEvent {
    //生物受伤事件
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
                    if (!directEntity.isShiftKeyDown()){
                        event.setAmount(0);
                    }
                    directEntity.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
                        if (yugongMovesMountains.isYugongMovesMountainsComprehend() && yugongMovesMountains.getYugongMovesMountainsLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 1F;
                            if (probability < defaultProbability) {
                                yugongMovesMountains.addYugongMovesMountainsLevel();
                            }
                        }
                    });
                }
            }
        }
    }
    public static void handleBlockBreakEvent(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Level world = player.getCommandSenderWorld();
        if (!world.isClientSide) {
            if (!player.getAbilities().instabuild){
                player.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
                    if (yugongMovesMountains.isYugongMovesMountainsComprehend() && yugongMovesMountains.getYugongMovesMountainsLevel() != 0) {
                        BlockPos pos = event.getPos();
                        BlockState state = event.getState();
                        ItemStack handItem = player.getMainHandItem();
                        Set<BlockPos> blocksToMine;
                        if (yugongMovesMountains.getYugongMovesMountainsLevel() <= 1){
                            blocksToMine = findBlocksToMine(world, pos, state, Math.min(handItem.getDamageValue(), 2));
                            for (BlockPos p : blocksToMine) {
                                world.destroyBlock(p, true, player);
                            }
                        }else {
                            blocksToMine = findBlocksToMine(world, pos, state, Math.min(handItem.getDamageValue(), 3));
                            for (BlockPos p : blocksToMine) {
                                world.destroyBlock(p, true, player);
                            }
                        }
                        if (handItem.getDamageValue() != 0) {
                            handItem.setDamageValue(Math.min(handItem.getDamageValue() + blocksToMine.size(), handItem.getMaxDamage()));
                        }
                        if (yugongMovesMountains.getYugongMovesMountainsUseCount() <= 1) {
                            yugongMovesMountains.addYugongMovesMountainsUseCount();
                        }
                    }
                });
            }
        }
    }

    private static Set<BlockPos> findBlocksToMine(Level world, BlockPos pos, BlockState originalState, int damageValue) {
        Set<BlockPos> blocksToMine = new HashSet<>();
        Queue<BlockPos> queue = new ArrayDeque<>();
        queue.add(pos);
        while (!queue.isEmpty()) {
            BlockPos currentPos = queue.poll();
            if (blocksToMine.contains(currentPos)) {
                continue;
            }
            BlockState currentState = world.getBlockState(currentPos);
            if (currentState.getBlock() == originalState.getBlock()) {
                blocksToMine.add(currentPos);
                for (BlockPos adjacentPos : getAdjacentPositions(currentPos)) {
                    if (!queue.contains(adjacentPos)) {
                        queue.add(adjacentPos);
                    }
                }
            }
            if (blocksToMine.size() >= damageValue) {
                return blocksToMine;
            }
        }
        return blocksToMine;
    }

    private static Set<BlockPos> getAdjacentPositions(BlockPos pos) {
        Set<BlockPos> adjacentPositions = new HashSet<>();
        adjacentPositions.add(pos.north());
        adjacentPositions.add(pos.south());
        adjacentPositions.add(pos.east());
        adjacentPositions.add(pos.west());
        adjacentPositions.add(pos.north().east());
        adjacentPositions.add(pos.east().south());
        adjacentPositions.add(pos.south().west());
        adjacentPositions.add(pos.west().north());
        adjacentPositions.add(pos.north().east());
        adjacentPositions.add(pos.east().south());
        adjacentPositions.add(pos.south().west());
        adjacentPositions.add(pos.west().north());
        return adjacentPositions;
    }

}
