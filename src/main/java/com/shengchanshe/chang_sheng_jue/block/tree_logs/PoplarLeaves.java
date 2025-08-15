package com.shengchanshe.chang_sheng_jue.block.tree_logs;

import com.shengchanshe.chang_sheng_jue.block.ChangShengJueBlocks;
import com.shengchanshe.chang_sheng_jue.block.decoration.LeavesDefoliation;
import com.shengchanshe.chang_sheng_jue.particle.ChangShengJueParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

public class PoplarLeaves extends LeavesBlock {
    public PoplarLeaves(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        if (pRandom.nextInt(30) == 0) {
            BlockPos blockpos = pPos.below();
            BlockState blockstate = pLevel.getBlockState(blockpos);
            if (!isFaceFull(blockstate.getCollisionShape(pLevel, blockpos), Direction.UP)) {
                ParticleUtils.spawnParticleBelow(pLevel, pPos, pRandom, ChangShengJueParticles.POPLAR_DEFOLIATION_PARTICLE.get());
            }
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);
        if (!pLevel.isClientSide()) {
            // 假设每次随机更新有10%的机会生成落叶
            if (pRandom.nextInt(10) == 0) {
                BlockPos groundPos = findGroundPosition(pLevel, pPos);
                if (groundPos != null) {
                    BlockPos leafPos = groundPos.above();
                    BlockState currentLeafState = pLevel.getBlockState(groundPos);
                    if (currentLeafState.is(ChangShengJueBlocks.POPLAR_DEFOLIATION.get())) {
                        int currentLevel = currentLeafState.getValue(LeavesDefoliation.LEVEL);
                        if (currentLevel < 2) { // 假设LEVEL的最大值是3
                            pLevel.setBlock(groundPos, currentLeafState.setValue(LeavesDefoliation.LEVEL, currentLevel + 1), 3);
                        }
                    }else if (currentLeafState.canBeReplaced() || currentLeafState.is(BlockTags.FLOWERS)){
                        pLevel.setBlock(groundPos, ChangShengJueBlocks.POPLAR_DEFOLIATION.get().defaultBlockState(), 3);
                    }else if (pLevel.isEmptyBlock(leafPos)) {
                        pLevel.setBlock(leafPos, ChangShengJueBlocks.POPLAR_DEFOLIATION.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }

    private BlockPos findGroundPosition(ServerLevel pLevel, BlockPos start) {
        BlockPos pos = start.below();
        while (pos.getY() > pLevel.getMinBuildHeight()) {
            BlockState state = pLevel.getBlockState(pos);

            if (!state.is(Blocks.AIR)) {
                return pos;
            }
            pos = pos.below();
        }
        return null;
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

}
