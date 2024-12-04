package com.shengchanshe.changshengjue.event.martial_arts;

import com.shengchanshe.changshengjue.capability.martial_arts.wu_gang_cut_gui.WuGangCutGuiCapabilityProvider;
import com.shengchanshe.changshengjue.entity.combat.stakes.StakesEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AirItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

public class WuGangCutGuiEvent {
    public static void onEntityHurt(LivingDamageEvent event){
        Level level = event.getEntity().level();
        if (!level.isClientSide){
            if (event.getSource().getDirectEntity() instanceof Player directEntity){
                if (event.getEntity() instanceof StakesEntity && directEntity.getMainHandItem().isEmpty()){
                    if (!directEntity.isShiftKeyDown()){
                        event.setAmount(0);
                    }
                    directEntity.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGui -> {
                        if (wuGangCutGui.isWuGangCutGuiComprehend() && wuGangCutGui.getWuGangCutGuiLevel() == 0) {
                            float probability = directEntity.getRandom().nextFloat();
                            float defaultProbability = 0.01F;
                            if (probability < defaultProbability) {
                                wuGangCutGui.addWuGangCutGuiLevel();
                            }
                        }
                    });
                }
            }
        }
    }

    public static void handleBlockBreakEvent(BlockEvent.BreakEvent event){
        Player player = event.getPlayer();
        Level level = player.getCommandSenderWorld();
        if (!level.isClientSide) {
            if (!player.getAbilities().instabuild) {
                player.getCapability(WuGangCutGuiCapabilityProvider.WU_GANG_CUT_GUI_CAPABILITY).ifPresent(wuGangCutGuiCapability -> {
                    if (wuGangCutGuiCapability.isWuGangCutGuiComprehend() && wuGangCutGuiCapability.getWuGangCutGuiLevel() >= 1) {
                        BlockPos startPos = event.getPos();
                        BlockState blockState = level.getBlockState(startPos);
                        ItemStack mainHandItem = player.getMainHandItem();
                        if (mainHandItem.getItem() instanceof AxeItem) {
                            // 判断是否是木头
                            if (isLog(blockState)) {
                                // 存储已处理的方块
                                Set<BlockPos> visited = new HashSet<>();
                                // 记录第一个破坏的位置
                                BlockPos dropPos = startPos;
                                // 执行连锁砍树
                                chopTree((ServerLevel) level, startPos, visited, dropPos, mainHandItem, player);
                                if (wuGangCutGuiCapability.getWuGangCutGuiUseCount() <= 1000) {
                                    wuGangCutGuiCapability.addWuGangCutGuiUseCount();
                                }
                            }
                        }
                    }
                });
            }
        }
    }
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
    private static boolean isLog(BlockState state) {
        return state.is(BlockTags.LOGS);// 可添加其他木头类型
    }
    private static void chopTree(ServerLevel world, BlockPos pos, Set<BlockPos> visited, BlockPos dropPos,ItemStack stack,Player player) {
        if (visited.contains(pos)) return;
        visited.add(pos);
        BlockState state = world.getBlockState(pos);
        // 检测是否为木头
        if (isLog(state)) {
            // 获取掉落物品
            for (ItemStack drop : Block.getDrops(state, world, pos, null)) {
                // 将掉落物生成在第一个方块的位置
                world.addFreshEntity(new ItemEntity(world, dropPos.getX() + 0.5, dropPos.getY() + 0.5, dropPos.getZ() + 0.5, drop));
            }
            // 破坏方块但不掉落物品
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            // 检测相邻方块
            for (BlockPos adjacent : getAdjacentPositions(pos)) {
                chopTree(world, adjacent, visited, dropPos,stack,player);
            }
            stack.hurtAndBreak(1, player, player1 -> {
                player1.broadcastBreakEvent(player.getUsedItemHand());
            });
        }
    }

    private static Iterable<BlockPos> getAdjacentPositions(BlockPos pos) {
        return Set.of(
                pos.above(), pos.below(),
                pos.north(), pos.south(),
                pos.east(), pos.west()
        );
    }
}
