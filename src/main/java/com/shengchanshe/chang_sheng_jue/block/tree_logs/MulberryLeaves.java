package com.shengchanshe.chang_sheng_jue.block.tree_logs;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.ForgeHooks;

import java.util.Locale;

public class MulberryLeaves extends LeavesBlock {
    public static final EnumProperty<State> STATE = EnumProperty.create("type", State.class);
    public MulberryLeaves(Properties pProperties,MulberryLeaves.State state) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, 7)
                .setValue(PERSISTENT, false).setValue(WATERLOGGED, false).setValue(STATE, state));

    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        if (state.getValue(PERSISTENT)) {return false;}
        if (state.getValue(STATE) != State.FRUITS) {return true;}
        if (state.getValue(DISTANCE) == 4){return true;}
        return state.getValue(DISTANCE) == 7;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.getValue(PERSISTENT) && !decaying(pState)) {
            if (pLevel.getRawBrightness(pPos, 0) >= 9) {
                State value = pState.getValue(STATE);
                if (value == State.LEAVES) {
                    // 检查周围是否有 FRUITS 状态的方块
                    boolean hasFruitsNearby = false;
                    for (Direction direction : Direction.values()) {
                        BlockPos neighborPos = pPos.relative(direction);
                        BlockState neighborState = pLevel.getBlockState(neighborPos);
                        if (neighborState.getBlock() == pState.getBlock() && neighborState.getValue(STATE) == State.FRUITS) {
                            hasFruitsNearby = true;
                            break;
                        }
                    }

                    // 如果有 FRUITS 状态的方块，则有 10% 的概率感染
                    if (hasFruitsNearby && pRandom.nextDouble() < 0.1) {
                        if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, true)) {
                            pLevel.setBlockAndUpdate(pPos, pState.setValue(STATE, State.FRUITS));
                            ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                            return;
                        }
                    }
                }
            }
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }


    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DISTANCE, PERSISTENT, WATERLOGGED,STATE);
    }

    public enum State implements StringRepresentable {
        LEAVES, FRUITS;
        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
