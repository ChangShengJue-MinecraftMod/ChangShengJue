package com.shengchanshe.chang_sheng_jue.block.food.ciwan;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CiWanFood extends WanTypeBlock{
    protected static final VoxelShape PLATE_SHAPE = Block.box(3.5D, 0.0D, 3.5D, 12.5D, 5.1D, 12.5D);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private final int fed;
    private final float fedpro;

    public CiWanFood(Properties properties, boolean hasLeftovers, int fed, float fedpro) {
        super(properties, hasLeftovers, fed, fedpro);
        this.fed = fed;
        this.fedpro = fedpro;
    }

    protected InteractionResult addFed(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand, int fed, float fedpro) {
        return super.addFed(level, pos, state, player, hand, this.fed, this.fedpro);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, TYPES);
    }
}
