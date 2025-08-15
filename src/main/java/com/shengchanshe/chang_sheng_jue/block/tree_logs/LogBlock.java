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
            if (state.is(ChangShengJueBlocks.POPLAR_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_POPLAR_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.POPLAR_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_POPLAR_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.OSMANTHUS_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_OSMANTHUS_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.OSMANTHUS_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_OSMANTHUS_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.HUANG_HUA_LI_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.HUANG_HUA_LI_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_HUANG_HUA_LI_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.WENGE_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_WENGE_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.WENGE_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_WENGE_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.LICHEE_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_LICHEE_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.LICHEE_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_LICHEE_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.DURIAN_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_DURIAN_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.DURIAN_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_DURIAN_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.MANGO_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_MANGO_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.MANGO_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_MANGO_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.PLUM_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_PLUM_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.PLUM_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_PLUM_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.MULBERRY_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_MULBERRY_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.MULBERRY_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_MULBERRY_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }

            if (state.is(ChangShengJueBlocks.ZI_TAN_LOG.get())) {
                return ChangShengJueBlocks.STRIPPED_ZI_TAN_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if (state.is(ChangShengJueBlocks.ZI_TAN_WOOD.get())) {
                return ChangShengJueBlocks.STRIPPED_ZI_TAN_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
