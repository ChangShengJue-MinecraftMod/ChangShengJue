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

import java.util.HashSet;
import java.util.Set;

public class XuanhuaAxe extends AxeItem {
    public XuanhuaAxe() {
        super(ChangShengJueTiers.IRON, 5.0F, -3.0F, new Item.Properties());
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        int baseDurability = super.getMaxDamage(stack);

        CompoundTag nbt = stack.getOrCreateTag();
        int maxDamage = nbt.getInt("xuanhuaAxeMaxDamage");

        return baseDurability + maxDamage;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
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
                                        Set<BlockPos> visited = new HashSet<>();
                                        BlockPos dropPos = pos;
                                        chopTree((ServerLevel) level, pos, visited, dropPos, mainHandItem, player);
                                        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                                                ChangShengJueSound.WU_GANG_CUT_GUI_SOUND.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

                                        CompoundTag nbt = stack.getOrCreateTag();
                                        int maxDamage = nbt.getInt("xuanhuaAxeMaxDamage");
                                        ((WuGangCutGui) active).setXuanhuaAxeMaxDamage(player.getRandom().nextFloat() > 0.2 ? 0 : 1);
                                        nbt.putInt("xuanhuaAxeMaxDamage", maxDamage + ((WuGangCutGui) active).getXuanhuaAxeMaxDamage());
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
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }

    private static boolean isLog(BlockState state) {
        return state.is(BlockTags.LOGS);// 可添加其他木头类型
    }
    private static void chopTree(ServerLevel world, BlockPos pos, Set<BlockPos> visited, BlockPos dropPos,ItemStack stack,Player player) {
        if (visited.contains(pos)) return;
        visited.add(pos);
        BlockState state = world.getBlockState(pos);
        if (isLog(state)) {
            for (ItemStack drop : Block.getDrops(state, world, pos, null)) {
                world.addFreshEntity(new ItemEntity(world, dropPos.getX() + 0.5, dropPos.getY() + 0.5, dropPos.getZ() + 0.5, drop));
            }
            world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
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
                pos.above(), pos.north(), pos.south(),
                pos.east(), pos.west()
        );
    }
}
