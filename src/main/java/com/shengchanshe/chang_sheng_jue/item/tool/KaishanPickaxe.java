package com.shengchanshe.chang_sheng_jue.item.tool;

import com.shengchanshe.chang_sheng_jue.capability.martial_arts.yugong_moves_mountains.YugongMovesMountainsCapabilityProvider;
import com.shengchanshe.chang_sheng_jue.item.tiers.ChangShengJueTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class KaishanPickaxe extends PickaxeItem {
    public KaishanPickaxe() {
        super(ChangShengJueTiers.IRON, 0, -2.8F, new Item.Properties());
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        int baseDurability = super.getMaxDamage(stack);

        CompoundTag nbt = stack.getOrCreateTag();
        int maxDamage = nbt.getInt("kaishanPickaxeMaxDamage");

        return baseDurability + maxDamage;
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (pEntityLiving instanceof Player player){
            Level world = player.level();
            BlockState clickedBlockState = world.getBlockState(pPos);
            if (!world.isClientSide) {
                player.getCapability(YugongMovesMountainsCapabilityProvider.YUGONG_MOVES_MOUNTAINS_CAPABILITY).ifPresent(yugongMovesMountains -> {
                    if (yugongMovesMountains.isYugongMovesMountainsComprehend() && yugongMovesMountains.getYugongMovesMountainsLevel() > 0) {
                        BlockPos startPos = pPos;
                        if (yugongMovesMountains.getYugongMovesMountainsLevel() <= 1){
                            // 遍历一个 2x2x2 的区域
                            for (int dx = 0; dx <= 1; dx++) {
                                for (int dy = -1; dy <= 0; dy++) {
                                    for (int dz = 0; dz <= 1; dz++) {
                                        // 计算要破坏的方块的位置
                                        BlockPos targetPos = pPos.offset(dx, dy, dz);

                                        // 破坏这个方块
                                        breakBlock(pStack, targetPos,startPos, player,clickedBlockState);
                                    }
                                }
                            }
                        }else {
                            // 遍历一个 2x2x2 的区域
                            for (int dx = -1; dx <= 1; dx++) {
                                for (int dy = -2; dy <= 0; dy++) {
                                    for (int dz = -1; dz <= 1; dz++) {
                                        // 计算要破坏的方块的位置
                                        BlockPos targetPos = pPos.offset(dx, dy, dz);

                                        // 破坏这个方块
                                        breakBlock(pStack, targetPos,startPos, player,clickedBlockState);
                                    }
                                }
                            }
                        }
                        CompoundTag nbt = pStack.getOrCreateTag();
                        int maxDamage = nbt.getInt("kaishanPickaxeMaxDamage");
                        nbt.putInt("kaishanPickaxeMaxDamage", maxDamage + player.getRandom().nextFloat() > 0.2 ? 0 : 1);
                        if (yugongMovesMountains.getYugongMovesMountainsUseCount() < 1000) {
                            yugongMovesMountains.addYugongMovesMountainsUseCount(!player.getAbilities().instabuild ? 1 : 1000);
                            if (yugongMovesMountains.getYugongMovesMountainsUseCount() >= 1000){
                                yugongMovesMountains.setYugongMovesMountainsParticle(true);
                            }
                        }
                    }
                });
            }
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    private void breakBlock(ItemStack itemstack, BlockPos pos,BlockPos dropPos, Player player,BlockState clickedBlockState) {
        Level world = player.level();
        BlockState state = world.getBlockState(pos);
        if (!world.isClientSide) {
            // 检查方块是否可以被这个工具破坏
            if (this.canAttackBlock(state, world, pos, player)&& state.getBlock() == clickedBlockState.getBlock() && state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
                // 破坏方块并掉落物品
                // 获取掉落物品
                for (ItemStack drop : Block.getDrops(state, (ServerLevel) world, pos, null)) {
                    // 将掉落物生成在第一个方块的位置
                    world.addFreshEntity(new ItemEntity(world, dropPos.getX(), dropPos.getY(), dropPos.getZ(), drop));
                }
                // 破坏方块但不掉落物品
                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                // 消耗工具的耐久
                itemstack.hurtAndBreak(1, player, player1 -> {
                    player1.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
//        if (pPlayer.level().isClientSide) return super.use(pLevel, pPlayer, pUsedHand);
//        pPlayer.getCapability(CultivationCapabilityProvider.XIU_XIAN_CAPABILITY).ifPresent(cap -> {
//            cap.setSeclusion(true);
//        });
        return super.use(pLevel, pPlayer, pUsedHand);
    }

}
