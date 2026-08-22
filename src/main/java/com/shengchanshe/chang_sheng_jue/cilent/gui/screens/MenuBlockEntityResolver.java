package com.shengchanshe.chang_sheng_jue.cilent.gui.screens;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;

public final class MenuBlockEntityResolver {
    private MenuBlockEntityResolver() {
    }

    public static <T extends BlockEntity> Resolution<T> resolve(
            Level level,
            BlockPos pos,
            Class<T> entityType,
            Block expectedBlock,
        BiFunction<BlockPos, BlockState, T> detachedFactory
    ) {
        if (level.hasChunkAt(pos)) {
            BlockEntity candidate = level.getBlockEntity(pos);
            if (entityType.isInstance(candidate)
                    && isWorldBackingValid(level, pos, candidate, expectedBlock)) {
                return new Resolution<>(entityType.cast(candidate), true);
            }
        }

        T detached = detachedFactory.apply(pos, expectedBlock.defaultBlockState());
        detached.setLevel(level);
        return new Resolution<>(detached, false);
    }

    public static <T extends BlockEntity> Resolution<T> resolve(
            Level level,
            BlockEntity candidate,
            Class<T> entityType,
            Block expectedBlock,
            BiFunction<BlockPos, BlockState, T> detachedFactory
    ) {
        BlockPos pos = candidate == null ? BlockPos.ZERO : candidate.getBlockPos();
        if (entityType.isInstance(candidate)
                && isWorldBackingValid(level, pos, candidate, expectedBlock)) {
            return new Resolution<>(entityType.cast(candidate), true);
        }

        T detached = detachedFactory.apply(pos, expectedBlock.defaultBlockState());
        detached.setLevel(level);
        return new Resolution<>(detached, false);
    }

    public static boolean isWorldBackingValid(Level level, BlockEntity entity, Block expectedBlock) {
        return entity != null && isWorldBackingValid(level, entity.getBlockPos(), entity, expectedBlock);
    }

    private static boolean isWorldBackingValid(Level level, BlockPos pos, BlockEntity entity, Block expectedBlock) {
        return !entity.isRemoved()
                && entity.getLevel() == level
                && entity.getBlockPos().equals(pos)
                && level.hasChunkAt(pos)
                && level.getBlockEntity(pos) == entity
                && level.getBlockState(pos).is(expectedBlock)
                && entity.getBlockState().is(expectedBlock);
    }

    public record Resolution<T extends BlockEntity>(T entity, boolean valid) {
    }
}
