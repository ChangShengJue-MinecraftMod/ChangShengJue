package com.shengchanshe.changshengjue.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ZhuTaiBlock extends TorchBlock {
    protected static final VoxelShape AABB = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 13.0D, 12.0D);
    public ZhuTaiBlock(Properties p_57491_, ParticleOptions p_57492_) {
        super(p_57491_, p_57492_);
    }
    @Override
    public VoxelShape getShape(BlockState p_57510_, BlockGetter p_57511_, BlockPos p_57512_, CollisionContext p_57513_) {
        return AABB;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        double d0 = (double)blockPos.getX() + 0.8D;
        double d1 = (double)blockPos.getY() + 0.85D;
        double d2 = (double)blockPos.getZ() + 0.5D;
        level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
        level.addParticle(this.flameParticle, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
