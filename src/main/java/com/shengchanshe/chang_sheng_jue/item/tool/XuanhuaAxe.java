package com.shengchanshe.chang_sheng_jue.item.tool;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.tiers.ChangShengJueTiers;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.WuGangCutGui;
import com.shengchanshe.chang_sheng_jue.network.ChangShengJueMessages;
import com.shengchanshe.chang_sheng_jue.network.packet.particle.kungfu.WuGangCutGuiParticlePacket;
import com.shengchanshe.chang_sheng_jue.sound.ChangShengJueSound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class XuanhuaAxe extends AxeItem {
    private static final int MAX_LOGS_PER_USE = 64;
    private static final int MAX_BONUS_DURABILITY = 1_000_000;

    public XuanhuaAxe() {
        super(ChangShengJueTiers.IRON, 5.0F, -3.0F, new Item.Properties());
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        int baseDurability = super.getMaxDamage(stack);

        CompoundTag nbt = stack.getOrCreateTag();
        int bonusDurability = boundedBonusDurability(nbt.getInt("xuanhuaAxeMaxDamage"));
        return (int) Math.min(Integer.MAX_VALUE, (long) baseDurability + bonusDurability);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
        boolean[] activated = {false};
        if (entityLiving instanceof Player player && player.isShiftKeyDown()){
            Level level = player.getCommandSenderWorld();
            if (!level.isClientSide) {
                player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                    cap.getKungFu(WuGangCutGui.KUNG_FU_ID.toString())
                            .filter(kungFu -> kungFu instanceof WuGangCutGui)
                            .filter(IKungFu::isReady)
                            .map(active -> {
                                BlockState blockState = level.getBlockState(pos);
                                ItemStack mainHandItem = player.getMainHandItem();
                                if (mainHandItem.getItem() instanceof XuanhuaAxe) {
                                    if (isLog(blockState)) {
                                        BlockPos dropPos = pos;
                                        int choppedLogs = chopTree((ServerLevel) level, pos, dropPos, mainHandItem, player);
                                        if (choppedLogs == 0) {
                                            return false;
                                        }
                                        activated[0] = true;
                                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.WU_GANG_CUT_GUI_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

                                        ((WuGangCutGui) active).setXuanhuaAxeMaxDamage(player.getRandom().nextFloat() > 0.2 ? 0 : 1);
                                        increaseBonusDurability(stack, ((WuGangCutGui) active).getXuanhuaAxeMaxDamage());
                                        ((WuGangCutGui) active).onInteranKungFu(level, player);
                                        ChangShengJueMessages.sendToPlayer(new WuGangCutGuiParticlePacket(dropPos.getX() + 0.5f, dropPos.getY(), dropPos.getZ() + 0.5f),
                                                (ServerPlayer) player);
                                    }
                                }
                                if (entityLiving instanceof ServerPlayer) {
                                    cap.syncToClient((ServerPlayer) player);
                                }
                                return true;
                            });
                });
            }
        }
        if (activated[0]) {
            return true;
        }
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }

    private static boolean isLog(BlockState state) {
        return state.is(BlockTags.LOGS);// 可添加其他木头类型
    }

    private static int boundedBonusDurability(int value) {
        return Math.max(0, Math.min(value, MAX_BONUS_DURABILITY));
    }

    private static void increaseBonusDurability(ItemStack stack, int amount) {
        CompoundTag nbt = stack.getOrCreateTag();
        long increased = (long) boundedBonusDurability(nbt.getInt("xuanhuaAxeMaxDamage"))
                + Math.max(0, amount);
        nbt.putInt("xuanhuaAxeMaxDamage", (int) Math.min(increased, MAX_BONUS_DURABILITY));
    }
    private static int chopTree(ServerLevel world, BlockPos pos, BlockPos dropPos, ItemStack stack, Player player) {
        int durabilityBudget = player.isCreative()
                ? MAX_LOGS_PER_USE
                : Math.max(0, stack.getMaxDamage() - stack.getDamageValue());
        int blockBudget = Math.min(MAX_LOGS_PER_USE, durabilityBudget);
        if (blockBudget == 0) {
            return 0;
        }

        Set<BlockPos> visited = new HashSet<>();
        ArrayDeque<BlockPos> pending = new ArrayDeque<>();
        pending.add(pos);
        int choppedLogs = 0;
        while (!pending.isEmpty() && choppedLogs < blockBudget) {
            BlockPos current = pending.removeFirst();
            if (!visited.add(current)) continue;
            BlockState state = world.getBlockState(current);
            if (!isLog(state)) continue;
            for (ItemStack drop : Block.getDrops(state, world, current, null)) {
                world.addFreshEntity(new ItemEntity(world, dropPos.getX() + 0.5, dropPos.getY() + 0.5, dropPos.getZ() + 0.5, drop));
            }
            world.setBlock(current, Blocks.AIR.defaultBlockState(), 3);
            choppedLogs++;
            if (!player.isCreative()) {
                stack.hurtAndBreak(1, player, player1 ->
                        player1.broadcastBreakEvent(InteractionHand.MAIN_HAND));
                if (stack.isEmpty()) {
                    break;
                }
            }
            for (BlockPos adjacent : getAdjacentPositions(current)) {
                if (!visited.contains(adjacent)) pending.addLast(adjacent);
            }
        }
        return choppedLogs;
    }

    private static Iterable<BlockPos> getAdjacentPositions(BlockPos pos) {
        return Set.of(
                pos.above(), pos.north(), pos.south(),
                pos.east(), pos.west()
        );
    }
}
