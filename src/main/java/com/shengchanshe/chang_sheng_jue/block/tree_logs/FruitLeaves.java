package com.shengchanshe.chang_sheng_jue.block.tree_logs;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;

import java.util.Locale;

public class FruitLeaves extends LeavesBlock implements BonemealableBlock {
    public static final EnumProperty<State> STATE = EnumProperty.create("type", State.class);
    public FruitLeaves(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        if (state.getValue(PERSISTENT)) {return false;}
        if (state.getValue(STATE) != State.FRUITS) {return true;}
        if (state.getValue(DISTANCE) == 1){return true;}
        return state.getValue(DISTANCE) == 7;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pState.getValue(STATE) == State.FRUITS){
            if (this == ChangShengJueBlocks.MANGO_LEAVES.get()){
                dropResources(pState, pLevel, pPos);
            }else if (this == ChangShengJueBlocks.PEAR_LEAVES.get()){
                dropResources(pState, pLevel, pPos);
            }else if (this == ChangShengJueBlocks.LICHEE_LEAVES.get()){
                dropResources(pState, pLevel, pPos);
            }else if (this == ChangShengJueBlocks.DURIAN_LEAVES.get()){
                dropResources(pState, pLevel, pPos);
            }
            pLevel.setBlockAndUpdate(pPos, pState.setValue(STATE, State.LEAVES));
            return InteractionResult.SUCCESS;
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.getValue(PERSISTENT) && !decaying(pState)) {
            if (pLevel.getRawBrightness(pPos, 0) >= 9) {
                State value = pState.getValue(STATE);
                if (value == State.LEAVES) {
                    boolean grow = pRandom.nextDouble() < 0.1;
                    if (ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, grow)) {
                        pLevel.setBlockAndUpdate(pPos, pState.setValue(STATE, State.FRUITS));
                        ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                        return;
                    }
                }
            }
        }
        super.randomTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return pState.getValue(STATE) != State.FRUITS;
    }

    @Override
    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        pLevel.setBlockAndUpdate(pPos, pState.cycle(STATE));
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
        pBuilder.add(STATE);
        super.createBlockStateDefinition(pBuilder);
    }

    public enum State implements StringRepresentable {
        LEAVES, FRUITS;

        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

}
