package com.shengchanshe.chang_sheng_jue.item.items;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.tree_logs.MulberryLeaves;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

public class Silkworm extends Item {

    public Silkworm(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState blockState = level.getBlockState(pos);
        Player player = pContext.getPlayer();
        ItemStack itemStack = pContext.getItemInHand();

        if (blockState.getBlock() == ChangShengJueBlocks.MULBERRY_LEAVES.get()) {
            if (!level.isClientSide) {
                MulberryLeaves.State value = blockState.getValue(MulberryLeaves.STATE);
                if (value == MulberryLeaves.State.LEAVES) {
                    if (ForgeHooks.onCropsGrowPre(level, pos, blockState, true)) {
                        level.setBlockAndUpdate(pos, blockState.setValue(MulberryLeaves.STATE, MulberryLeaves.State.FRUITS));
                        ForgeHooks.onCropsGrowPost(level, pos, blockState);
                    }
                }

                if (player != null && !player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }

                level.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useOn(pContext);
    }
}
