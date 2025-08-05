package com.shengchanshe.chang_sheng_jue.item.tool;

import com.shengchanshe.chang_sheng_jue.capability.ChangShengJueCapabiliy;
import com.shengchanshe.chang_sheng_jue.item.tiers.ChangShengJueTiers;
import com.shengchanshe.chang_sheng_jue.martial_arts.IKungFu;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.KungFuConfig;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.WuGangCutGui;
import com.shengchanshe.chang_sheng_jue.martial_arts.kungfu.internal_kungfu.YugongMovesMountains;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashSet;
import java.util.Set;

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
            if (!world.isClientSide) {
                if (player.isShiftKeyDown()){
                    player.getCapability(ChangShengJueCapabiliy.KUNGFU).ifPresent(cap -> {
                        cap.getKungFu(YugongMovesMountains.KUNG_FU_ID.toString())
                                .filter(kungFu -> kungFu instanceof YugongMovesMountains)
                                .filter(IKungFu::isReady)
                                .ifPresent(kungFu -> {
                                    int range = ((YugongMovesMountains) kungFu).getLevel() >= 2 ? KungFuConfig.YUGONG_MOVES_MOUNTAINS_EXCAVATION_RANGE.get() + 1 : KungFuConfig.YUGONG_MOVES_MOUNTAINS_EXCAVATION_RANGE.get();
                                    mineArea((ServerLevel) world, pPos, player, pStack, range);
                                    CompoundTag nbt = pStack.getOrCreateTag();
                                    int currentBonus = nbt.getInt("kaishanPickaxeMaxDamage");
                                    ((YugongMovesMountains) kungFu).setKaishanPickaxeMaxDamage(player.getRandom().nextFloat() > 0.2 ? 0 : 1);
                                    nbt.putInt("kaishanPickaxeMaxDamage",
                                            currentBonus + ((YugongMovesMountains) kungFu).getKaishanPickaxeMaxDamage());
                                    ((YugongMovesMountains) kungFu).onInteranKungFu(world, player);
                                });
                    });
                }
            }
        }
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    private void mineArea(ServerLevel level, BlockPos originPos, Player player, ItemStack stack, int range) {
        Set<BlockPos> minedBlocks = new HashSet<>();
        int radius = (range - 1) / 2; // 2x2→radius=0, 3x3→radius=1
        // 挖掘范围内的所有方块
        for (int x = -radius; x <= (radius <= 0 ? radius + 1 : radius); x++) {
            for (int z = -radius; z <= (radius <= 0 ? radius + 1 : radius); z++) {
                BlockPos pos = originPos.offset(x, 0, z);
                if (minedBlocks.contains(pos)) continue;

                BlockState state = level.getBlockState(pos);
                if (canMineBlock(state, player)) {
                    Block.getDrops(state, level, pos, null, player, stack)
                            .forEach(itemStack -> Block.popResource(level, originPos, itemStack));

                    level.destroyBlock(pos, false);
                    minedBlocks.add(pos);

                    // 消耗耐久度
                    stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(p.getUsedItemHand()));
                }
            }
        }
    }

    private boolean canMineBlock(BlockState state, Player player) {
        // 检查方块是否可挖掘且玩家有权限
        return !state.isAir() &&
                state.getDestroySpeed(player.level(), BlockPos.ZERO) >= 0 &&
                player.hasCorrectToolForDrops(state);
    }
}
