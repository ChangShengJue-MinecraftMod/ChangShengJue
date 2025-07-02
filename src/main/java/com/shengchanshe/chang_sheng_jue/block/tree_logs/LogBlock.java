package com.shengchanshe.chang_sheng_jue.block.tree_logs;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class LogBlock extends RotatedPillarBlock {
    public LogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem){
            if (state.is(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get())){
                return ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.JI_CHI_MU_LOG.get())){
                return ChangShengJueBlocks.STRIPPED_JI_CHI_MU_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.ZI_TAN_LOG.get())){
                return ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.MULBERRY_LOG.get())){
                return ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
